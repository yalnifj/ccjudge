<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<cc:CCJudgeMe title="Register Your Team">
<h1 id="pagetitle">Register Your Team</h1>
<form method="post" action="${baseURL}/register/register">
<span class="error">${error}</span>
To being registration, enter your Neumont username and password.  <br />
(This is the same username and password you use to login to your computer
or login to the LMS.)<br /><br /> 
<table>
	<tr>
		<td>Neumont Username:</td>
		<td><input type="text" name="username" value="${member.username}" /></td>
	</tr>
	<tr>
		<td>Neumont Password:</td>
		<td><input type="password" name="password" value="${member.password}" /></td>
	</tr>
</table>
<br />
<input type="submit" value="Continue" />
</form>
</cc:CCJudgeMe>