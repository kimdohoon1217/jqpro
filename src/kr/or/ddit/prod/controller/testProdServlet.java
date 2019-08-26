package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;


@WebServlet("/testProdServlet")
public class testProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lgu = request.getParameter("lprod_lgu");
		IProdService service = ProdServiceImpl.getInstance();
		List<ProdVO> list = service.selectProdNames(lgu);
		
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("/0812/testProdNames.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("prod_id");
		IProdService service = ProdServiceImpl.getInstance();
		ProdVO prodVo = service.prodDetail(pId);
		
		request.setAttribute("prodVo", prodVo);
		RequestDispatcher disp = request.getRequestDispatcher("/0812/testProdDatail.jsp");
		disp.forward(request, response);
		
	}

}
