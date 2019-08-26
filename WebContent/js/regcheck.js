/**
 * 
 */

var idtest = function(){
	idval = $('#id').val();
	
	//공백검증
	if(idval.trim().length == 0){
		alert("아이디를 입력하세요");
		$('#id').focus();
		return false;
	}
	
	//길이검증
	if(idval.trim().length < 4 || idval.trim().length > 12){
		alert("아이디는 4~12 사이 입니다");
		return false;
	}
	
	//정규화 검증
	//영문 소문자로 시작하고 한개 이상의 숫자와 그외 영문자로 조합한다
	regid = /^[a-z]+[0-9a-zA-Z]{3,11}$/;
	if(!(regid.test(idval))){
		alert("id형식오류 입니다.");
		return false;
	}
	
	return true;
	
}


var dongtest = function(){
	//dongvalue = $("#dong").val();
	if(dongvalue.trim().length == 0){
		alert("동이름을 입력하세요.");
		$('#dong').focus();
		return false;
	}
	
	return true;
}

var regtest = function(){
	//이름, 비밀번호, 휴대폰번호, 이메일
	
	nameval = $("#name").val();
	if(nameval.trim().length == 0){
		alert("이름좀넣어라");
		$("#name").focus();
		return false;
	}
	
	
	
	regname = /^[가-힝]+|^[a-zA-Z]+/;
	if(regname.test(nameval)){
		rkor = /^[가-힝]+$/;
		reng = /^[a-zA-Z]+$/;
		
		//한글일 경우
		if(rkor.test(nameval)){
			//길이검증 2 ~ 5 
			if(nameval.trim().length < 2 || nameval.trim().length > 5){
				alert("이름은 2~5사이 입니다.");
				$("#name").focus();
				return false;
			}
		//영문일 경우
		}else if(reng.test(nameval)){
			//길이검증 5 ~ 10
			if(nameval.trim().length < 5 || nameval.trim().length > 10){
				alert("영문이름은 5~10사이 입니다.");
				$("#name").focus();
				return false;
			}
		}else{
			//한글로 시작, 숫자나 영문이 조합
			//영문으로 시작, 숫자나 한글이 조합
			alert("이름형식 오류입니다.");
			$("#name").focus();
			return false;
		}
		
	}else{
		//숫자로만 입력햇을때
		alert("이름형식 오류입니다.");
		$("#name").focus();
		return false;
	}
	////////////////////////////////////
	//비밀번호
	//공백검증
	pwdval = $("#pwd").val();
	
	if(pwdval.trim().length == 0){
		alert("비밀번호를 입력하세요.");
		$("#pwd").focus();
		return false;
	}
	
	
	//길이검증 8 ~ 12
	if(pwdval.trim().length < 8 || pwdval.trim().length > 12){
		alert("비밀번호는 8 ~ 12 자리입니다.");
		$("#pwd").focus();
		return false;
	}
	
	//정규식 - 전방탐색을 이용 - 숫자, 영문대소문자, 특수문자 반드시 한개이상씩 포함된다.
	//0번이상 나오는 문자뒤에 a-z를 기준으로 전방에 아무것도 없다 , 그래서  a-z로 시작한다
	//0번이상 나오는 문자뒤에 A-Z를 기준으로 전방에 아무것도 없다 , 그래서  A-Z로 시작한다
	//0번이상 나오는 문자뒤에 0-9를 기준으로 전방에 아무것도 없다 , 그래서  0-9로 시작한다
	//0번이상 나오는 문자뒤에 !@#$%^&*()_+|를 기준으로 전방에 아무것도 없다 , 그래서  !@#$%^&*()_+|로 시작한다
	
	regpass = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+|]).{8,12}$/;
	if(!(regpass.test(pwdval))){
		alert("비밀번호 형식오류 입니다.");
		$("#pwd").focus();
		return false;
	}
	
/*	
	aa = "http://www.naver.com";
	//aa = "https://www.naver.com";
	reg = /\w+(?=:)$/;	//?= 전방탐색 ?=찾는문자
	
	//해당되는 문자를 출력해준다
	bb = aa.match(reg);
	
	if(bb == "http"){
		alert("http처리입니다");
	}else if(bb == "https"){
		alert("https처리입니다");
	}*/
	
	telval = $("#phone").val();
	if(telval.trim().length == 0){
		alert("휴대전화입력해라");
		$("#phone").focus();
		return false;
	}
	
	regtel = /\d{3}-\d{4}-\d{4}/;
	if(!(regtel.test(telval))){
		alert("재대로입력해라전화하게");
		$("#phone").focus();
		return false;
	}
	
	
	mailval = $("#email").val();
	if(mailval.trim().length == 0){
		alert("이메일을 입력해주세요.");
		$("#email").focus();
		return false;
	}
	
	regmail = /^[가-힝a-zA-Z0-9]+@[가-힝a-zA-Z0-9]+(\.[가-힝a-zA-Z0-9]+){1,2}$/;
	if(!(regmail.test(mailval))){
		alert("이메일형식오류입니다.");
		$("#email").focus();
		return false;
	}
	
	
	return true;
	
}

