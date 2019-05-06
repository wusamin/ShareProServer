package com.wusa.sharepro.service

import com.wusa.sharepro.data.ListData
import com.wusa.sharepro.data.ShareProEntity
import com.wusa.sharepro.data.uploadForm
import com.wusa.sharepro.repository.`interface`.ShareProRepositoryInterface
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate
import java.util.*

@Service
@ComponentScan("repository/interface")
class ShareProService(private val repository:
                      ShareProRepositoryInterface) {
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

    fun getAllPicture(): Collection<ListData> {

        val dataList = mutableListOf<ListData>()
        val path = Paths.get("D:/tmp/sample/dl8.png")

        val fileByte = Files.readAllBytes(path)
        val base64Bytes = Base64.getEncoder()
            .encodeToString(fileByte)

        val sb = StringBuffer()

        sb.append("data:")
            .append(Files.probeContentType(path))
            .append(";base64,")
            .append(base64Bytes)

        val data = ListData(sb.toString(), "Iris", "秩父湖", LocalDate.now())
        val data2 = ListData(sb.toString(), "Jack", "秩父湖", LocalDate.now().plusDays(1))
        val data3 = ListData(sb.toString(), "Kevin", "秩父湖", LocalDate.now().plusDays(2))

        dataList.apply {
            add(data)
            add(data2)
            add(data3)
            add(data3)
            add(data3)
        }


        return dataList
    }

    fun uploadPicture(form: uploadForm, image: MultipartFile) {
        val base = "D:/tmp/sample/"
        val path = Paths.get(base + form.contributor)

        if (!(Files.isDirectory(path))) {
            Files.createDirectory(path)
        }

        val file = Paths.get(base + form.contributor + "/" + form.fileName)
        Files.createFile(file)

        val imageBytes = image.bytes

        Files.write(file, imageBytes)

    }
}