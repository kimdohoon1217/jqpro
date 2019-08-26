package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/BoardWrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		BoardVO vo = new BoardVO();
		
		//입력한 모든 값을 가져온다
		//BeanUtils.populate를 하면 vo컬럼에 맞게 vo.set컬럼명  값 이렇게 셋팅해준다
		//vo.setSeq(21) ..
		
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//client의 ip를 얻어오기
		vo.setWip(request.getRemoteAddr());
		
		IBoardService service = BoardServiceImpl.getInstance();
		int seq = service.insertBoard(vo);
		
		request.setAttribute("seq", seq);
		
		request.getRequestDispatcher("accordion/write.jsp").forward(request, response);
		
		
	}

}
