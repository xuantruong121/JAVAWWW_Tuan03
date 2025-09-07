<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${param.languageCode != null ? param.languageCode : 'vi'}" scope="session"/>
<fmt:setBundle basename="resource" scope="session"/>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>Result</title>
</head>
<body>
<h2><fmt:message key="title"/></h2>

<c:choose>
    <c:when test="${param.username == 'admin' and param.password == '123'}">
        ✅ <fmt:message key="login"/> <fmt:message key="success"/>
    </c:when>
    <c:otherwise>
        ❌ <fmt:message key="login"/> <fmt:message key="fail"/>
    </c:otherwise>
</c:choose>

<br/><br/>
<a href="index.jsp"><fmt:message key="back"/></a>
</body>
</html>
