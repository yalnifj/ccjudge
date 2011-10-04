<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<cc:CCJudgeMe title="Login">
<h1 id="pagetitle">Login</h1>

<form method="post" action="${baseURL}/home/login">
<input type="hidden" name="redir" value="${redir}" />
	<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="j_username" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="j_password" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Login" /></td>
		</tr>
	</table>
</form>
<a href="${baseURL}/register">Register your team</a>
</cc:CCJudgeMe>