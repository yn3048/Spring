<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>user3::modify</title>
</head>
<body>
    <h3>user3 수정</h3>
    <a href="/ch04">메인</a>
    <a href="/ch04/user3/register" >목록</a>
    <form action="/ch04/user3/modify" method="post">
        <table border="1">
            <tr>
                <td>아이디</td>
                <td><input type="text" name="uid"  readonly value="${user3DTO.uid}"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name" value="${user3DTO.name}"></td>
            </tr>
            <tr>
                <td>생일</td>
                <td><input type="text" name="birth" value="${user3DTO.birth}"></td>
            </tr>
            <tr>
                <td>휴대폰</td>
                <td><input type="text" name="hp" value="${user3DTO.hp}"></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" name="addr" value="${user3DTO.addr}"></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input type="submit" value="수정"></td>
            </tr>
        </table>
    </form>
</body>
</html>
