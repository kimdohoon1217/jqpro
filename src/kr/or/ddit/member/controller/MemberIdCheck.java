package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.MappingChange.Map;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;


@WebServlet("/MemberIdCheck")
public class MemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		IMemberService service = MemberServiceImpl.getInstanse();
		String inputId = request.getParameter("id");
		
		String resId = service.getSelectedId(inputId);
		
		request.setAttribute("inputId", inputId);
		request.setAttribute("resId", resId);
		
		//map으로도 가능
		
		RequestDispatcher disp = request.getRequestDispatcher("member/checkId.jsp");
		disp.forward(request, response);
		
		
				
		
		
		
		
	}

}
