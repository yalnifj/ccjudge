<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elh" uri="http://www.neumont.edu/elhelper" %>

<cc:CCJudge title="Edit problem Information">
<script type="text/javascript" charset="utf-8" src="${baseURL}/js/tinymce/jscripts/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript" charset="utf-8" src="${baseURL}/js/ccjudge.js"></script>
<script type="text/javascript" charset="utf-8">
	tinyMCE.init(tiny_mce_config);
	tinyMCE.execCommand("mceAddControl", true, "description");

	function checkData(frm) {
		var ret = true;
		if (frm.input.value.length > 10000) ret = confirm('Your test data has more than 10,000 characers.\r\nLarge amounts of test data may slow down the judging system.\r\nAre you sure you want to include this much test data?');
		if (!ret) return ret;
		if (frm.output.value.length > 10000) ret = confirm('Your test data has more than 10,000 characers.\r\nLarge amounts of test data may slow down the judging system.\r\nAre you sure you want to include this much test data?'); 
		return ret;
	}
</script>
<h2>Edit ${problem.name}</h2>
<form method="post" action="${baseURL}/problem/update" onsubmit="return checkData(this);">
<table>
	<tr><td>ID</td><td><input type="hidden" name="id" value="${problem.id}"/>${problem.id}
	<c:if test="${problem.id gt 0}">
	<a href="${baseURL}/problem/delete?id=${problem.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this problem?');"/></a>
	</c:if>
	</td></tr>
	<tr><td>Short Name</td><td><input type="text" name="shortName" value="${problem.shortName}" size="20" /></td></tr>
	<tr><td>Name</td><td><input type="text" name="name" value="${problem.name}" size="40" /></td></tr>
	<tr><td>Contest</td><td>
		<select name="contest" size="5" multiple="multiple">
			<c:forEach items="${contests}" var="contest">
				<option value="${contest.id}" ${elh:listContains(problem.contests, contest) ? 'selected="selected"':'' }>${contest.name}</option>
			</c:forEach>
		</select>
	</td></tr>
	<tr><td>Description</td>
		<td><textarea id="description" name="description" rows="40" cols="100">${elh:htmlentities(problem.description)}</textarea>
		</td></tr>
	<tr><td>Test Input</td>
		<td><textarea name="input" rows="10" cols="50">${problem.input}</textarea>
		</td></tr>
	<tr><td>Test Output</td>
		<td><textarea name="output" rows="10" cols="50">${problem.output}</textarea>
		</td></tr>
</table>
<input type="submit" value="Save" /> <input type="button" value="Cancel" onclick="window.location='${baseURL}/problem/view?id=${problem.id}';" />
</form>
</cc:CCJudge>