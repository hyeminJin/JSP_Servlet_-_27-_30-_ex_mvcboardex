<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
	
	<form action="reply.do" method="post">
		<input type="hidden" name="bId" value="${reply_view.bId}">
		<input type="hidden" name="bGroup" value="${reply_view.bGroup}">
		<input type="hidden" name="bStep" value="${reply_view.bStep}">
		<input type="hidden" name="bIndent" value="${reply_view.bIndent}">		
		<tr>
			<td> ��ȣ </td>
			<td> ${reply_view.bId}</td>
		</tr>
		<tr>
			<td> ��Ʈ </td>
			<td> ${reply_view.bHit}</td>
		</tr>
		<tr>
			<td> �̸� </td>
			<td> <input type="text" name="bName" size = "50" value="${reply_view.bName}"> </td>
		</tr>
		<tr>
			<td> ���� </td>
			<td> <input type="text" name="bTitle" size = "50" value="[re]"> </td>
		</tr>
		<tr>
			<td> ���� </td>
			<td> <textarea name="bContent" rows="10" >${reply_view.bContent}</textarea> </td>
		</tr>
		
		<tr>
			<td colspan="2"> <input type="submit" value="�亯"> &nbsp;&nbsp; <a href="list.do">��Ϻ���</a></td>
		</tr>
	
	</form>
	</table>
</body>
</html>