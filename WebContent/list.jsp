<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>게시판</title>
<style>

</style>
</head>
<body>
	<div class="container">
	<div class="responsive">
		<table class="table table-hover">
			<thead class="table-dark">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>제목</th>
					<th>날짜</th>
					<th>히트</th>
				</tr>
			</thead>
			
			<c:forEach items="${list}" var="dto"> <!-- setAttribute 한 것 list -->
			
			<tbody>
				
				<tr>
					<td>${dto.bId}</td>
					<td>${dto.bName}</td>
					<td>
						<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach> <!-- 댓글  -->
						<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td> <!-- get방식 (?) -->
					<td>${dto.bDate}</td>
					<td>${dto.bHit}</td>
				</tr>
				
				</c:forEach>
				</tbody>		
		</table>
		<div class="row" >
			<div class="col-4"><button type="button" class="btn btn-primary"><a class="text-white" href="write_view.do">글작성</a></button></div>
			<div class="col-8">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#">Previous</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</div>
		</div>	
							
					
			
	</div>
	</div>
</body>
</html>