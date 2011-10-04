<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elh" uri="http://www.neumont.edu/elhelper" %>

<cc:CCJudge title="Edit User Information">
<h2>Edit ${user.name}</h2>
<form method="post" action="${baseURL}/user/update">
<table>
	<tr><td>ID</td><td><input type="hidden" name="id" value="${user.id}"/>${user.id}
	<c:if test="${team.id gt 0}">
	<a href="${baseURL}/user/delete?id=${user.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this user?');"/></a>
	</c:if>
	</td></tr>
	<tr><td>Username</td><td><input type="text" name="username" value="${user.username}" size="40" /></td></tr>
	<tr><td>Name</td><td><input type="text" name="name" value="${user.name}" size="40" /></td></tr>
	<tr><td>Email</td><td><input type="text" name="email" value="${user.email}" size="40" /></td></tr>
	<tr><td>Admin</td>
		<td><input id="madmin" type="checkbox" name="admin" value="true" ${user.role eq 'admin'?'checked="checked"':''} /></td></tr>
</table>
<input type="submit" value="Save" /> <input type="button" value="Cancel" onclick="window.location='${baseURL}/user/view?id=${user.id}';" />
</form>
</cc:CCJudge>