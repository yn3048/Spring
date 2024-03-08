<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    h2 {
        max-width: 800px;
        height: 80px;
        width: 100%;
        margin: 50px auto;
        text-align: center;
        line-height: 80px;
        background-color: lightpink;
        color: #333;
    }

    div {
        margin: 10px auto;
        max-width: 800px;
        width:100%;
        height:600px;
        border: 1px solid pink;
        text-align: center;
    }

    div h4 {
        font-weight: bold;
    }

    div a {
        text-decoration: none;
        color: #333;
        font-weight: bold;
        display: inline-block;
        padding: 5px;
        margin-right: 10px;
        background-color: pink;
    }

    div a:hover {
        text-decoration: underline;
    }
</style>
<body>
<h2>Ch05.myBatis</h2>
<div>


    <h4>user1 실습</h4>
    <a href="/ch05/user1/list">user1 목록</a>
    <a href="/ch05/user1/register">user1 등록</a>

    <h4>user2 실습</h4>
    <a href="/ch05/user2/list">user2 목록</a>
    <a href="/ch05/user2/register">user2 등록</a>

    <h4>user3 실습</h4>
    <a href="/ch05/user3/list">user3 목록</a>
    <a href="/ch05/user3/register">user3 등록</a>

    <h4>user4 실습</h4>
    <a href="/ch05/user4/list">user4 목록</a>
    <a href="/ch05/user4/register">user4 등록</a>

    <h4>user5 실습</h4>
    <a href="/ch05/user5/list">user5 목록</a>
    <a href="/ch05/user5/register">user5 등록</a>

    <h4>member 실습</h4>
    <a href="/ch05/member/list">member 목록</a>
    <a href="/ch05/member/register">member 등록</a>
</div>

</body>
</html>
