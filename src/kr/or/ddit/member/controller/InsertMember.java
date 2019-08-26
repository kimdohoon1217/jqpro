package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/InsertMember")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberVO vo = new MemberVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//입력한 모든값을 가져온다. (json)의 이름을 getParameter로 가져온다
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String bir = request.getParameter("bir");
//		String pwd = request.getParameter("pwd");
//		String phone = request.getParameter("phone");
//		String email = request.getParameter("email");
//		String postal = request.getParameter("postal");
//		String add1 = request.getParameter("addr");
//		String add2 = request.getParameter("datailaddr");
//		
//		//MemberVo에 저장
//		vo.setMem_id(id);
//		vo.setMem_name(name);
//		vo.setMem_bir(bir);
//		vo.setMem_pass(pwd);
//		vo.setMem_hp(phone);
//		vo.setMem_mail(email);
//		vo.setMem_zip(postal);
//		vo.setMem_add1(add1);
//		vo.setMem_add2(add2);
		
		//service객체 얻기
		IMemberService service = MemberServiceImpl.getInstanse();
		
		//매소드 호출 - 파라미터 : vo , 결과 : String - mem_id
		String mem = service.insertMember(vo);
		
		//결과를 request에 저장
		request.setAttribute("mem", mem);
		
		
		//jsp(insert.jsp)로 이동
		RequestDispatcher disp = request.getRequestDispatcher("member/insert.jsp");
		disp.forward(request, response);
		
		
		
		
	}

}
