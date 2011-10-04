<%@ attribute name="contests" type="java.util.Collection" required="true" rtexprvalue="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${contests}" var="contest">
	<a href="${baseURL}/contest/view?id=${contest.id}">${contest.name}</a><br />
</c:forEach>