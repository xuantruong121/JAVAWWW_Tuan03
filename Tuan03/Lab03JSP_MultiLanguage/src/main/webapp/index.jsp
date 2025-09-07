<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${param.languageCode != null ? param.languageCode : 'vi'}" scope="session"/>
<fmt:setBundle basename="resource" scope="session"/>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>MultiLanguage JSP</title>
</head>
<body>
<!-- Chọn ngôn ngữ -->
<form method="get" action="index.jsp">
    <label><fmt:message key="chooseLang"/></label>
    <select name="languageCode" onchange="this.form.submit()">
        <option value="vi"
                <c:if test="${param.languageCode == 'vi' || empty param.languageCode}">selected</c:if>>
            Tiếng Việt
        </option>
        <option value="en"
                <c:if test="${param.languageCode == 'en'}">selected</c:if>>
            English
        </option>
    </select>
</form>

<h2><fmt:message key="title"/></h2>

<!-- Form Login -->
<form action="login" method="get">
    <label><fmt:message key="username"/></label>
    <input type="text" name="username"/><br/>

    <label><fmt:message key="password"/></label>
    <input type="password" name="password"/><br/>

    <button type="submit"><fmt:message key="login"/></button>
</form>
</body>
</html>
