<%@ attribute name="properties" type="java.util.Map" required="true" rtexprvalue="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${properties}" var="property">
	<tr><td>${property.value.name}</td><td>${property.value.value}</td></tr>
</c:forEach>