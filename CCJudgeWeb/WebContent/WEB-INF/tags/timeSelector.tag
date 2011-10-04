<%@ attribute name="date" type="java.util.Date" required="false" rtexprvalue="true" %>
<%@ attribute name="name" required="true" rtexprvalue="true" %>
<%@ taglib prefix="dt" uri="http://jakarta.apache.org/taglibs/datetime-1.0" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="${name}.hour">
	<c:forEach begin="0" end="23" step="1" var="h">
		<c:choose>
		<c:when test="${date.hours eq h}">
			<option value="${h}" selected="selected">${h}</option>
		</c:when>
		<c:otherwise>
			<option value="${h}">${h}</option>
		</c:otherwise>
		</c:choose>
	</c:forEach>
</select>:
<select name="${name}.minute">
	<c:forEach begin="0" end="55" step="5" var="m">
		<c:choose>
		<c:when test="${date.minutes >= m && date.minutes < m+5}">
			<option value="${m}" selected="selected">${m}</option>
		</c:when>
		<c:otherwise>
			<option value="${m}">${m}</option>
		</c:otherwise>
		</c:choose>
	</c:forEach>
</select>