<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game</title>
</head>
<body>
<p align="center">${gameVS}</p>
<p align="center">${typeGame}</p>

<table align="center">

    <tr>
        <td>
            <form action="/in/crossnull" method="post">
                <button type="submit" name="button1" value="1">${pole1}</button>
            </form>
        </td>
        <td>
            <form action="/in/crossnull" method="post">
                <button type="submit" name="button2" value="2">${pole2}</button>
            </form>
        </td>
        <td>
            <form action="/in/crossnull" method="post">
                <button type="submit" name="button3" value="3">${pole3}</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="/in/crossnull" method="post">
                <button type="submit" name="button4" value="4">${pole4}</button>
            </form>
        </td>
        <td>
            <form action="/in/crossnull" method="post">
                <button type="submit" name="button5" value="5">${pole5}</button>
            </form>
        </td>
        <td>
            <form action="/in/crossnull" method="post">
                <button type="submit" name="button6" value="6">${pole6}</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="/in/crossnull" method="post">
                <button type="submit" name="button7" value="7">${pole7}</button>
            </form>
        </td>
        <td>
            <form action="/in/crossnull" method="post">
                <button type="submit" name="button8" value="8">${pole8}</button>
            </form>
        </td>
        <td>
            <form action="/in/crossnull" method="post">
                <button type="submit" name="button9" value="9">${pole9}</button>
            </form>
        </td>
    </tr>

</table>
<table align="center">
    <tr>
        <td>
            <form action="/in/crossnull" method="post">
                <button type="submit" name="button10" value="10">Повторить игру</button>
            </form>
        </td>
        <td>
            <form action="/" method="post">
                <button type="submit" name="button11" value="11">Новая игра</button>
            </form>
        </td>
    </tr>
</table>

<p align="center">${win1}&nbsp;</p>
<p align="center">${win2}&nbsp;</p>

</body>
</html>
