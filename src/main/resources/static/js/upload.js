$(function () {
    $('#uploadDummyBtn').on('click', () => $('#fileBtn').click())
    $('#fileBtn').on('change', function (e) {
        indicateFileName(this)
        previewImage(e)
        indicateFormField()
    })
})

function indicateFileName(receiver) {
    $('#filename').val($(receiver).prop('files')[0].name)
}

function indicateFormField() {
    $('#fileInfoField').removeClass('d-none')
}

function previewImage(receiver) {
    const file = receiver.target.files[0]

    if (file.type.indexOf("image") < 0) {
        alert("画像ファイルを指定してください。")
        return false
    }

    const reader = new FileReader()

    reader.onload = ((file) => {
        return (e) => {
            $("#preview").attr("src", e.target.result)
            $("#preview").attr("title", file.name)
        }
    })(file)

    reader.readAsDataURL(file)
}