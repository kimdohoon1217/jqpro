<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
  <script>
  	$(function(){
  		$(".dropdown").on("click", function(){
  			menu = $('.dropdown-toggle', this).text();
  			submenu = $('.dropdown-menu li a', this).text();
  			//alert(menu + "," + submenu);
  			
  			//subm = submenu.split(" ");
  			subm = $('.dropdown-menu li a', this).map(function() {
  				 return $(this).text();
  			})
		  	code = '<div class="list-group">';
			code +='<a href="#" class="list-group-item active disabled">' + menu + '</a>';
			$.each(subm, function(i) {
				code +='<a href="#" class="list-group-item">' + subm[i] +'</a>';
			})
		  	code +='</div>';
		  	$(".sidenav").html(code);
		  	
  		}); 
  		
  		//왼쪽메뉴 클릭시 - delegate
  		$(".sidenav").on("click", ".list-group-item", function(){
  			
  			//match 포함된 단어를 반환해주는 메서드
  			if($(this).attr('class').match('disabled')) return ;
  			proc(this);
  			
  		})
  		//드롭다운 메뉴 클릭시
  		$(".dropdown-menu li a").on("click", function(){
  			proc(this);
  		});
  		
  		$(".navlogo .nav li a").on("click", function(){
  			proc(this);
  		});
  		
  		
  		function proc(item){
  			//리스트 그룹 아이템 의 문자 - 서브메뉴 가져오기
  			subtxt = $(item).text().trim();
  			$(".text-left h1").text(subtxt);
  			
  			if(subtxt == "회원가입"){
  				$(".text-left #result1").load("/jqpro/member/member.html");
  			}else if(subtxt == "Login"){
  				$(".text-left #result1").load("/jqpro/0812/lprod_prod.html");
  			}else if(subtxt == "자유게시판"){
  				$(".text-left #result1").load("/jqpro/0810/buyer.html");
  			}
  			
  		}
  		
  	});
  </script>
</head>
	<body>
	 	<jsp:include page="header.jsp"></jsp:include>
	 	<jsp:include page="content.jsp"></jsp:include>
	 	<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>

