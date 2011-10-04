<%@ page contentType="text/xml; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<members>
<c:forEach items="${list}" var="member">
<member id="${member.id}">
	<id>${member.id}</id>
	<username>${member.username}</username>
	<name>${member.name}</name>
	<email>${member.email}</email>
</member>
</c:forEach>
</members>