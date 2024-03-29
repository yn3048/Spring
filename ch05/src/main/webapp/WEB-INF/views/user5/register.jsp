<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user5::register</title>
</head>
<body>
    <h3>user5 등록</h3>
    <a href="/ch05">메인</a>
    <a href="/ch05/user5/list">목록</a>
    <form action="/ch05/user5/register" method="post">
        <table border="1">
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
                <td><input type="number"  min="0" name="age"></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" name="addr" ></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input type="submit" value="등록"></td>
            </tr>
        </table>
    </form>
</body>
</html>
