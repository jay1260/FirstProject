<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../resources/css/default.css">
<c:import url="../template/bootStrap.jsp"></c:import>
<c:import url="../template/slide.jsp"></c:import>

<style type="text/css">
	#search-h2{
		text-align: center;
		margin-top: 40px;
		margin-bottom: 40px;
	}
</style>		
</head>
<c:import url="../template/header.jsp"></c:import>

<body>
	<!-- 검색창 -->
<div class="container" id="div2">
	<!--  트레이너의 이름이나 지역으로 검색  -->
	<h2 id="search-h2">Trainer Search</h2>
	<form class="example" style="margin: 25px;" action="./trainerWindowSearch">
		<div class="col-xs-3">
			<select style="font-size: 15px; margin-bottom: 5px;" class="form-control" name="select">
				<option value="nm">이름</option>
				<option value="loc">지역</option>
			</select>
		</div>
		<div class="col-xs-10">
			<input type="text" placeholder="Search..." name="search" id="search-text">
			<button id="search-blank"><i class="fa fa-search"></i></button>
			
		</div>
	</form>
	
</div>

<!-- 상세조건 검색 -->
<div style="margin-top: 25px;" class="list-group" id="div1" >
	<form id="frm_trainer" action="./trainerDetailSearch" style="margin-top: 15px;">
		<hr>
		<h4> 성별 </h4>
		<label class="radio-inline">
			<input type="radio" name="gender" value="M">남
		</label>
		<label class="radio-inline">
			<input type="radio" name="gender" value="W">여
		</label>
		<label class="radio-inline">
			<input type="radio" name="gender" value="all" checked="checked">모두
		</label>	
		<hr>
		<h4 style="font-size: 18px;"> ★종목★ </h4>
		<label class="radio-inline">
			<input type="radio" name="kind" value="health"> 헬스
		</label>
		<label class="radio-inline">
			<input type="radio" name="kind" value="pilates"> 필라테스
		</label>
		<label class="radio-inline">
			<input type="radio" name="kind" value="yoga"> 요가
		</label>
		<label class="radio-inline">
			<input type="radio" name="kind" value="spinning"> 스피닝
		</label>
		<label class="radio-inline">
			<input type="radio" name="kind" value="crossfit"> 크로스핏 
		</label>
		<hr>
		<h4 style="font-size: 18px;"> ★장소★ </h4>
		<label class="radio-inline">
			<input type="radio" name="business" value="N"> 헬스장
		</label>
		<label class="radio-inline">
			<input type="radio" name="business" value="Y"> 홈트레이닝
		</label>
			
		<div class="col-xs-12" id="div3">
			<div>
				<input type="button" id="btn" value="검색하기" class="btn btn-primary" >
				<a href = "./trainer/map"><input type = "button" class = "map btn btn-success" value = "헬스장  위치안내" style="float: right;"></a>
			</div>
		</div>
	</form>

<c:import url="../template/footer.jsp"></c:import>
</div>

<script type="text/javascript">
	$("#btn").click(function() {
		
		// 종목과 장소선택의 필수 사항
		
		//var ge = ($('input:radio[name=gender]').is(':checked'));
		var ki = ($('input:radio[name=kind]').is(':checked'));
		var bu = ($('input:radio[name=business]').is(':checked'));
		if(bu == false || ki == false){
			alert("종목과 장소를 선택하여주세요.");
		}else{
			$("#frm_trainer").submit();
		}
	});

	// 검색어 창 입력 유도
	$("#search-blank").click(function() {
		var b = $("#search-text").val();
		if(b==''){
			alert("검색어를 입력해주세요.");
			return false;
		}
	});
	
</script>
</body>
</html>