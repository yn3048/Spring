<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user4::register</title>
</head>
<body>
<h3>user4 등록</h3>
<a href="/ch04">메인</a>
<a href="/ch04/user4/list">목록</a>
<form action="/ch04/user4/register" method="post">
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
            <td>성별</td>
            <td>
                <label><input type="radio" name="gender" value="F">여자</label>
                <label><input type="radio" name="gender" value="M">남자</label>
            </td>
        </tr>
        <tr>
            <td>나이</td>
            <td><input type="number" name="age" min="0"></td>
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
