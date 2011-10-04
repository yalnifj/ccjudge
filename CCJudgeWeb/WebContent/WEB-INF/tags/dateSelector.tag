<%@ attribute name="date" type="java.util.Date" required="false" rtexprvalue="true" %>
<%@ attribute name="name" required="true" rtexprvalue="true" %>
<%@ taglib prefix="dt" uri="http://jakarta.apache.org/taglibs/datetime-1.0" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="${name}.day">
	<c:forEach begin="1" end="31" step="1" var="i">
		<c:choose>
		<c:when test="${date.date eq i}">
			<option value="${i}" selected="selected">${i}</option>
		</c:when>
		<c:otherwise>
			<option value="${i}">${i}</option>
		</c:otherwise>
		</c:choose>
	</c:forEach>
</select>
<select name="${name}.month">
	<dt:months id="mon">
		<c:choose>
		<c:when test="${date.month+1 eq mon.monthOfYear}">
			<option value="${mon.monthOfYear}" selected="selected">${mon.month}</option>
		</c:when>
		<c:otherwise>
			<option value="${mon.monthOfYear}">${mon.month}</option>
		</c:otherwise>
		</c:choose>
 	</dt:months>
</select>
<select name="${name}.year">
	<c:forEach begin="${date.year+1900-5}" end="${date.year+1900+5}" step="1" var="y">
	<c:choose>
		<c:when test="${date.year+1900 eq y}">
			<option value="${y}" selected="selected">${y}</option>
		</c:when>
		<c:otherwise>
			<option value="${y}">${y}</option>
		</c:otherwise>
		</c:choose>		
	</c:forEach>
</select>