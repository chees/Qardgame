<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute required="true" type="java.lang.String" name="title" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Qardgame - <spring:message code="${title}" /></title>
	<link rel="stylesheet" href="/css/default.css" />
</head>
<body>

<jsp:doBody/>

</body>
</html>
