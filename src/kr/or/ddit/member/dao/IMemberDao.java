package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZIpVO;

public interface IMemberDao {

	public List<MemberVO> selectAll() throws SQLException;
	
	//id중복검사
	public String getSelectedId(String id) throws SQLException;
	
	//우편번호 검색
	public List<ZIpVO> getSelectedDong(String dong) throws SQLException;
	
	//저장하기(가입하기)
	public String insertMember(MemberVO vo) throws SQLException;
	
	//중복값 없앤 시 구하기
	public List<Map> getSelectSido() throws SQLException;
	
	//중복값 없앤 구군 구하기
	public List<Map> getSelectGugun(String gugun) throws SQLException;
	

	public List<Map> getSelectDong(Map map) throws SQLException;
	
	
}
