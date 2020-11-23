<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">Personal Training</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/trainer/trainerSearch">Search</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/notice/noticeList">Notice</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/qna/qnaList">Q&A</a>
          </li>
          <c:choose>
          <c:when test="${ not empty member}">
         	<!-- 로그인 정보가 트레이너인 경우 -->
         	<c:if test="${ member.trainer eq 'T' }">
	          <li class="nav-item">
	            <a class="nav-link" href="${pageContext.request.contextPath}/payment/paymentInfo">status of members</a>
	          </li>
	          
	         </c:if>
	         <!-- 로그인 정보가 회원인 경우 -->
	         <c:if test="${ member.trainer eq 'M' }">
	          <li class="nav-item">
	            <a class="nav-link" href="${pageContext.request.contextPath}/payment/paymentMyInfo?id=${member.id}">My Reserve</a>
	          </li>
	         </c:if>  
	         
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/member/memberPage">member</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogout">Logout</a>
          </li>
          </c:when>
          <c:otherwise>
          <li class="nav-item">
            <a class="nav-link trigger-btn" href="#myModal" data-toggle="modal">Login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/member/memberAgrement">Sign up</a>
          </li>
          </c:otherwise>
          </c:choose>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
<header class="slider_section">
        <div id="myCarousel" class="carousel slide banner-main" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="slide" src="${pageContext.request.contextPath}/resources/img/main/fc_16.jpg" alt="First slide">
                    
                </div>
                <div class="carousel-item">
                    <img class="slide" src="${pageContext.request.contextPath}/resources/img/main/fc_main.png" alt="Second slide">
                    <div class="container">
                        
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="slide" src="${pageContext.request.contextPath}/resources/img/main/fc_slide.jpg" alt="Third slide">
                    
                </div>
            </div>
            <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
            <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
        </div>

    </header>
    <!-- 로그인 페이지	  -->
 

    <div id="myModal" class="modal fade">
	<div class="modal-dialog modal-login">
		<div class="modal-content">
			<div class="modal-header">
				<div class="avatar">
					<img src="/examples/images/avatar.png" alt="Avatar">
				</div>				
				<h4 class="modal-title">Member Login</h4>	
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<form action="${pageContext.request.contextPath}/member/memberLogin" method="post" id="loginfrm">
					<div class="form-group" id="divId">
						<input type="text" class="form-control" id="id" name="id" placeholder="Username" required="required" value="${cookie.remember.value}"  onkeydown="JavaScript:Enter_Check();">		
					</div>
					<div class="form-group" id="divPw">
						<input type="password" class="form-control" id="pw" name="pw" placeholder="Password" required="required"  onkeydown="JavaScript:Enter_Check();">
						<div id ="loginResult"></div>
					</div>
					<div>
					<label class="font-weight-bold text-black"> 
						<input type="checkbox" id="remember" name="remember" ${checked}> 아이디 기억하기
					</label>
					</div>
					<div class="form-group" id="divLogin">
						<input type="button" class="btn btn-primary btn-lg btn-block login-btn" id="login" value="Login" >
					</div>
					
				</form>
			</div>
			<div>
				<a href="#">Forgot Password?</a>
				
			</div>
		</div>
	</div>
</div>     

   <style type="text/css">
	 @import url("${pageContext.request.contextPath}/resources/css/login.css");
    </style>
	<script type="text/javascript">
	var id='';
	


	$("input:checkbox").on('click', function() {
	 if ( $(this).prop('checked') ) 
		{ 
			if(id!=''){
				$(this).val("true");
				}
		 }
		 });
	var data1 = 0;
	$("#divId").on("blur", "#id", function(){
		$("#loginResult").html("");
		id = $("#id").val();
	});
	$("#divPW").on("blur", "#pw", function(){
		$("#loginResult").html("");
	});
//**********************************로그인버튼*******************************************8
	  function Enter_Check(){
	        // 엔터키의 코드는 13입니다.
		    if(event.keyCode == 13){
		    	loginChk();
		    }
		}

	$("#divLogin").on("click","#login",function(){
		loginChk();
	
		});
	function loginChk(event){
		var pw = $("#pw").val();
		id = $("#id").val();
		if(id!=''&&pw!=''){
		$.get("${pageContext.request.contextPath}/member/memberpwCheck?pw="+pw+"&"+"id="+id,function(data){
			data=data.trim();
			data1=data;
			if(data1==1){
					$("#loginfrm").submit();
				}
			else{
				$("#loginResult").html("아이디 또는 비밀번호가 틀렸습니다.");
			}
			});
		}
		else
			{$("#loginResult").html("아이디 또는 비밀번호를 입력하세요");}}
	</script>





