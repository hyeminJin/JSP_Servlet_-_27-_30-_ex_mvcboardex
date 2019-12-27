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
	
	<form action="modify.do" method="post">
		<input type="hidden" name="bId" value="${content_view.bId}"> <!-- 히든하면 보이지않게함 -->
		<tr>
			<td>번호</td>
			<td>${content_view.bId}</td>
		</tr>
		
		<tr>
			<td>히트</td>
			<td>${content_view.bHit}</td>
		</tr>
		
		<tr>
			<td> 이름 </td>
			<td> <input type="text" name="bName" value="${content_view.bName}"></td>
		</tr>
		
		<tr>
			<td> 제목 </td>
			<td> <input type="text" name="bTitle" value="${content_view.bTitle}"> </td>
		</tr>
		
		<tr>
			<td> 내용 </td>
			<td> <textarea name="bContent" rows="10" >${content_view.bContent}</textarea> </td>
		</tr>
		
		<tr>
			<td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="list.do">목록보기</a>
			<a href="delete.do?bId=${content_view.bId}">삭제하기</a>
			<a href="reply_view.do?bId=${content_view.bId}">답변하기</a></td>
		</tr>
	
	</form>
	</table>
</body>
</html>