package com.wusa.sharepro.service

import com.wusa.sharepro.data.ShareProEntity
import com.wusa.sharepro.data.uploadForm
import com.wusa.sharepro.repository.MShareProRepository
import com.wusa.sharepro.repository.ShareProRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Service
@ComponentScan("repository", "data")
class ShareProService() {

    @Autowired
    lateinit var repository: ShareProRepository

    @Autowired
    lateinit var util: MShareProRepository

    fun findAllPicture(): List<ShareProEntity> {
        val pictures = mutableListOf<ShareProEntity>()
        repository.findAll()
            .forEach({
                val path = Paths.get(it.image)

                val fileByte = Files.readAllBytes(path)
                val base64Bytes = Base64.getEncoder()
                    .encodeToString(fileByte)

                val sb = StringBuffer()

                sb.append("data:")
                    .append(Files.probeContentType(path))
                    .append(";base64,")
                    .append(base64Bytes)
                it.image = sb.toString()

                pictures.add(it)
            })

        return pictures
    }


    fun uploadPicture(form: uploadForm, image: MultipartFile): Boolean {
        val base = util.findAll()[0].value1
        val userName = if (form.contributor.isNotEmpty()) form.contributor
        else "anonymous"

        val path = Paths.get(base + userName)

        if (!(Files.isDirectory(path))) {
            Files.createDirectory(path)
        }


        val file = Paths.get(base + userName + "/" + form.fileName)

        if (Files.isWritable(file)) {
            return false
        }

        Files.createFile(file)

        val imageBytes = image.bytes

        Files.write(file, imageBytes)

        var dto = ShareProEntity()
        dto.id = 0
        dto.image = file.toString()
        dto.comment = form.comment
        dto.contributor = userName
        dto.location = form.location
        dto.uploadDay = if (form.uploadDay.isNotEmpty()) {
            LocalDate.parse(form.uploadDay, DateTimeFormatter
                .ofPattern("yyyy/MM/dd"))
        } else {
            LocalDate.now()
        }

        dto.ins_date = Date()
        dto.upd_date = Date()

        repository.save(dto)

        return true
    }
}