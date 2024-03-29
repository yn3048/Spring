<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>user3::list</title>
</head>
<body>
<h3>user3 목록</h3>

<a href="/ch05">메인</a>
<a href="/ch05/user3/register">등록</a>

<table border="1">
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>생일</th>
        <th>휴대폰</th>
        <th>주소</th>
        <th>관리</th>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.uid}</td>
            <td>${user.name}</td>
            <td>${user.birth}</td>
            <td>${user.hp}</td>
            <td>${user.addr}</td>
            <td>
                <a href="/ch05/user3/modify?uid=${user.uid}">수정</a>
                <a href="/ch05/user3/delete?uid=${user.uid}">삭제</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


