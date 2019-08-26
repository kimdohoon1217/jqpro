package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZIpVO;

public class MemberServiceImpl implements IMemberService {
	
/*
 * 1. Dao객체가 필요 - 직접 생성하지 않고 getter를 이용해서 가져온다
 * 2. 다른 controller에서 공유하여 사용될 수 있도록 자신의 객체를 생성하고
 * 	   리턴하는 메소드
 * 
 */
	
	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstanse() {
		if (service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}

	@Override
	public List<MemberVO> selectAll(){

		List<MemberVO> list = null;
		
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String getSelectedId(String id) {
		String res = null;
		try {
			res = dao.getSelectedId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<ZIpVO> getSelectedDong(String dong) {
		List<ZIpVO> list = null;
		
		try {
			list = dao.getSelectedDong(dong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String insertMember(MemberVO vo) {
		String res = null;
		try {
			res = dao.insertMember(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Map> getSelectSido() {
		List<Map> sidoList = null;
		try {
			sidoList = dao.getSelectSido();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sidoList;
	}

	@Override
	public List<Map> getSelectGugun(String gugun) {
		List<Map> gugunList = null;
		try {
			gugunList = dao.getSelectGugun(gugun);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gugunList;
	}

	@Override
	public List<Map> getSelectDong(Map map) {
		List<Map> dongList = null;
		
		try {
			dongList = dao.getSelectDong(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dongList;
	}

}
