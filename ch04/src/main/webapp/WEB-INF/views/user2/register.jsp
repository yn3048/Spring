<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>user2::register</title>
</head>
<body>
    <h3>user2 등록</h3>
    <a href="/ch04">메인</a>
    <a href="/ch04/user2/list">목록</a>
    <form action="/ch04/user2/register" method="post">
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
