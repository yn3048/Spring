<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user3::register</title>
</head>
<body>
    <h3>user3 등록</h3>
    <a href="/ch04">메인</a>
    <a href="/ch04/user3/register">목록</a>
    <form action="/ch04/user3/register" method="post">
        <table border="1">
            <tr>
                <td>아이디</td>
                <td><input type="text" name="uid"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>생일</td>
                <td><input type="date" name="birth"></td>
            </tr>
            <tr>
                <td>휴대폰</td>
                <td><input type="text" name="hp"></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" name="addr"></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input type="submit" value="등록"></td>
            </tr>
        </table>
    </form>
</body>
</html>
