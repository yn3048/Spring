<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>user2::modify</title>
</head>
<body>
<h3>user2 수정</h3>
<a href="/ch05">메인</a>
<a href="/ch05/user2/list">목록</a>
<form action="/ch05/user2/modify" method="post">
    <table border="1">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="uid" readonly value="${user2DTO.uid}"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" value="${user2DTO.name}"></td>
        </tr>
        <tr>
            <td>생일</td>
            <td><input type="date" name="birth" value="${user2DTO.birth}"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="addr" value="${user2DTO.addr}"></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="수정"></td>
        </tr>
    </table>

</form>
</body>
</html>
