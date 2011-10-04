<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
<c:forEach items="${team.members}" var="member">
	<tr><td>${member.role}</td><td>${member.member.name}</td>
	<c:if test="${edit}">
	<td>
		<a href="${baseURL}/member/edit?id=${member.member.id}"><img src="${baseURL}/images/edit.png" border="0" alt="edit member" title="edit member"/></a>
		<a href="${baseURL}/team/removeMember?id=${team.id}&amp;member=${member.id}"><img src="${baseURL}/images/delete.png" border="0" alt="remove team member" title="remove team member" onclick="return confirm('Are you sure you want to remove this member from the team?');"/></a>
	</td>
	</c:if>
	</tr>
</c:forEach>
</table>
