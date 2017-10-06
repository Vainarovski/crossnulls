<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.06.2017
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game</title>
</head>
<body>
<p align="center">Введите имя игрока</p>
<form action="/in/crossnull" method="post" name="blabla">
    <p align="center"><input type="text" name="nick">
        <input type="submit"></p>
    <p align="center"> <label>Играть крестиками &nbsp; <input type="radio" checked name="gameType" value="1"></label>&nbsp;&nbsp;
        <label>Играть ноликами&nbsp;<input type="radio" name="gameType" value="2"/></p></form></label>
</body>
</html>
