package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZIpVO;


@WebServlet("/DongSelect")
public class DongSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//입력한 dong을 전달 받는다
		String dong = (String)request.getParameter("dong");
		
		//service객체 얻기
		IMemberService service = MemberServiceImpl.getInstanse();
		
		//메소드 호출 - 결과값 받기 - List
		List<ZIpVO> list = service.getSelectedDong(dong);
		
		request.setAttribute("list", list);
		
		//zipSearch.jsp로 이동 - json데이터 생성
		RequestDispatcher disp = request.getRequestDispatcher("member/zipSearch.jsp");
		disp.forward(request, response);
		
	}

}
