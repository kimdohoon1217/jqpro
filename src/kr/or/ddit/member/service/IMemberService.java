package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZIpVO;

public interface IMemberService {
	
	public List<MemberVO> selectAll();
	
	//id중복검사
	public String getSelectedId(String id);
	
	//우편번호 검색
	public List<ZIpVO> getSelectedDong(String dong);
	
	//저장하기(가입하기)
	public String insertMember(MemberVO vo);
	
	public List<Map> getSelectSido();
	
	//중복값 없앤 구군 구하기
	public List<Map> getSelectGugun(String gugun);
	
	public List<Map> getSelectDong(Map map);
	
	
}
