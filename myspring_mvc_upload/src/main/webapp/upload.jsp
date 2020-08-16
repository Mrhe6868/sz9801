<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>下载页面</title>
</head>
<body>

<form action="/test/upload" method="post" enctype="multipart/form-data">
    上传<input type="file" name="multipartFile" ><br>
    描述<input type="text" name="desc" ><br>
    <input type="submit" value="提交" style="color: coral">
</form>
<script>


</script>
</body>
</html>