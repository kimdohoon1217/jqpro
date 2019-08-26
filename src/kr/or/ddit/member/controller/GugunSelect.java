package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class GugunSelect
 */
@WebServlet("/GugunSelect")
public class GugunSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sido = request.getParameter("sido");
		
		IMemberService service = MemberServiceImpl.getInstanse();
		
		List<Map> gugun  = service.getSelectGugun(sido);
		request.setAttribute("gugun", gugun);
		
		request.getRequestDispatcher("/member/gugunSearch.jsp").forward(request, response);
	
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String sido = request.getParameter("sido");
		System.out.println(sido);
		String gugun = request.getParameter("gugun");
		System.out.println(gugun);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("sido", sido);
		map.put("gugun", gugun);
		
		IMemberService service = MemberServiceImpl.getInstanse();
		List<Map> list = service.getSelectDong(map);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/member/dongSearch.jsp").forward(request, response);
		
		

	}
	
	


}
