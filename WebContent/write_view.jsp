<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<div class="responsive">
	<div class="jumbotron">
		<form action="write.do" method="post">
		<div class="form-group">
			<label for="usr">작성자</label>
				<input type="text" class="form-control" name="bName">
		</div>
		<div class="form-group">
			<label for="usr">제목</label>
				<input type="text" class="form-control" name="bTitle">
		</div>
		<div class="form-group">
			<label for="usr">내용</label>
				<textarea class="form-control" id="comment" name="bContent" rows="10" ></textarea>
		</div>
		<div class="row">
			<div class="col-1"><input type="submit" class="btn btn-primary btn-sm" value="입력"></div>
			<div class="col-2"><button type="button" class="btn btn-primary btn-sm"><a class="text-white" href="list.do">목록</a></button></div>	
		</div>		
		</form>	
	</div>
	</div>
	</div>
</body>
</html>