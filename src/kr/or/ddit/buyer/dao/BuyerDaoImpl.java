package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BuyerDaoImpl implements IBuyerDao {
	private SqlMapClient client;
	private static IBuyerDao dao;
	
	public BuyerDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IBuyerDao getInstance() {
		if(dao == null) {
			dao = new BuyerDaoImpl();
		}
		return dao;
	}
	
	
	

	@Override
	public List<Map> buyer() throws SQLException {
		List<Map> nameList = client.queryForList("buyer.buyerName");
		
		return nameList;
	}


}
