<%-- 
    Document   : users
    Created on : 13.05.2019, 18:43:45
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/styles.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="form-style-2">
            <div class="form-style-2-heading">
                Already registered!
            </div>
            <table >
                <tr>
                    <th>First name</th>
                </tr>
                <c:forEach items="${usersFromServer}" var="user">
                    <tr>
                        <td>${user.firstName}</td>
                    </tr>
                </c:forEach>   
            </table>
        </div>
    </body>
</html>
