<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<cc:CCJudgeSimple title="Resources">
<h2>Resources</h2>
<table border="1" cellpadding="2">
	<tr><th>File</th><th>View</th><th>Delete</th></tr>
	<c:forEach items="${resources}" var="resource" varStatus="count">
		<tr>
		<td>${resource}</td>
		<td><a href="${baseURL}/resource/view/${resource}"><img src="${baseURL}/images/edit.png" border="0" alt="view" title="view"/></a></td>
		<td>
		<a href="${baseURL}/resource/delete/${resource}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this resource?');"/></a>
		</td>
		</tr>
	</c:forEach>
</table>
<form method="POST" action="${baseURL}/resource/upload" enctype="multipart/form-data">
<h2>Upload a Resource</h2>
<span class="error">${message}</span>
<table>
<tr><td>Choose File:</td>
<td><input type="file" name="resource" /></td>
</tr>
<tr><td colspan="2"><input type="submit" value="Upload" /></td></tr>
</table>
</form>
</cc:CCJudgeSimple>