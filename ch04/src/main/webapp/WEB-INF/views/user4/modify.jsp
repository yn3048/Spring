<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>user4::modify</title>
</head>
<body>
<h3>user4 수정</h3>
<a href="/ch04">메인</a>
<a href="/ch04/user4/list">목록</a>
<form action="/ch04/user4/modify" method="post">
    <table border="1">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="uid" readonly value="${user4DTO.uid}"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" value="${user4DTO.name}"></td>
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
            <td><input type="number" name="age" value="${user4DTO.age}" min="0"></td>
        </tr>
        <tr>
            <td>휴대폰</td>
            <td><input type="text" name="hp" value="${user4DTO.hp}"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="addr" value="${user4DTO.addr}"></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="등록"></td>
        </tr>
    </table>
</form>
</body>
</html>
