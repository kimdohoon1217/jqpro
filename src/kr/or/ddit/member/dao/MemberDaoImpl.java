package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;

/*
 *  1.Mapper 에 접근하기 위해서 SqlMapClient객체가 필요하다 - 직접 생성하지 않고
 *  		생성되어 있는 클래스에서 getter를 이용해서 가져온다
 *  2.자신의 Dao객체를 다른 서비스에서 공유 하여 사용할 수 있도록 생성
 *   자신의 객체를 return시켜주는 메소드 정의
 * 
 */

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZIpVO;

public class MemberDaoImpl implements IMemberDao {
	
	private SqlMapClient client;
	private static IMemberDao dao;
	
	
	private MemberDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IMemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		
		return dao;
	}
	

	@Override
	public List<MemberVO> selectAll() throws SQLException {
		
		return client.queryForList("member.selectAll");
	}

	@Override
	public String getSelectedId(String id) throws SQLException {
		
		return (String) client.queryForObject("member.getSelectedId", id);
	}

	@Override
	public List<ZIpVO> getSelectedDong(String dong) throws SQLException {
		
		return client.queryForList("member.getSelectedDong", dong);
	}

	@Override
	public String insertMember(MemberVO vo) throws SQLException {
		
		return (String) client.insert("member.insertMember", vo);
	}

	@Override
	public List<Map> getSelectSido() throws SQLException {
		
		return client.queryForList("member.getSelectSido");
	}

	@Override
	public List<Map> getSelectGugun(String gugun) throws SQLException {

		return client.queryForList("member.getSelectGugun", gugun);
	}

	@Override
	public List<Map> getSelectDong(Map map) throws SQLException {

		return client.queryForList("member.getSelectDong", map);
	}

}
