package demo.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.beans.Account;
import demo.beans.Contact;
import demo.beans.Statement;
import demo.beans.Transaction;
import demo.utils.Logger;

@Repository
public class AccountDAOImpl {

	//private DataSource dataSource;
	private NamedParameterJdbcTemplate npjc = null;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		try {			
			Logger.INSTANCE.log("Connected to DB: " + dataSource.getConnection().getMetaData().getDriverName());
			this.npjc = new NamedParameterJdbcTemplate(dataSource);
			//this.dataSource = dataSource;
			//initialiseTemplate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Account getAccountDetails(int accNo){
		//initialiseTemplate();
		String sql = "select *" + 
					 " from accounts " +
					 " where id = :accNo";

	    SqlParameterSource namedParameters = new MapSqlParameterSource("accNo", accNo);
	    //Logger.INSTANCE.log("About to initialise query: " + npjc + ", " + ", " + sql + ", " + namedParameters);
	    
	    return npjc.queryForObject(sql, namedParameters, new AccountMapper());
	}
	
	public Contact getContactForAccount(int accNo){
		//initialiseTemplate();
		String sql = "select con.*" + 
					 " from accounts acc, contacts con " +
					 " where acc.id = :accNo " +
					 " and con.id = acc.contact_id";

	    SqlParameterSource namedParameters = new MapSqlParameterSource("accNo", accNo);
	    //Logger.INSTANCE.log("About to initialise query: " + npjc + ", " + ", " + sql + ", " + namedParameters);
	    
	    return npjc.queryForObject(sql, namedParameters, new ContactMapper());
	}
	
	public List<Statement> getStatementsForAccount(int accNo){
		String sql = "select st.*" + 
					 " from statements st, accounts acc " +
					 " where acc.id = :accNo " +
					 " and st.acc_id = acc.id";

	    SqlParameterSource namedParameters = new MapSqlParameterSource("accNo", accNo);
	    
	    return npjc.query(sql, namedParameters, new StatementMapper());
	}
	
	public List<Transaction> getTransactionsForStatement(int accNo, int statementId){
		String sql = "select *" + 
					 " from transactions " +
					 " where acc_id = :accNo " +
					 " and statement_id = :statementId";

		Map<String, Integer> values = new HashMap<String, Integer>();
		values.put("accNo", new Integer(accNo));
		values.put("statementId", new Integer(statementId));
	    SqlParameterSource namedParameters = new MapSqlParameterSource(values);
	    
	    return npjc.query(sql, namedParameters, new TransactionMapper());
	}
	
	public AccountDAOImpl() {
		super();
	}
	
	private static final class AccountMapper implements RowMapper<Account> {

	    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	Account account = new Account();
	    	account.setId(rs.getInt("id"));
	    	account.setCustomer_id(rs.getInt("customer_id"));
	    	account.setContact_id(rs.getInt("contact_id"));
	    	account.setStart_date(rs.getDate("start_date"));
	    	account.setAcctype(rs.getString("acctype"));
	    	account.setSegmentation(rs.getString("segmentation"));
	    	account.setAcc_limit(rs.getBigDecimal("acc_limit"));
	    	account.setCurrent_balance(rs.getBigDecimal("current_balance"));
	    	account.setIncome_received(rs.getBigDecimal("income_received"));
	    	account.setStatement_count(rs.getInt("statement_count"));
	    	account.setBal_segment(rs.getString("bal_segment"));
	    	account.setTxn_count(rs.getInt("txn_count"));

	        return account;
	    }
	}
	
	private static final class ContactMapper implements RowMapper<Contact> {

	    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	//Logger.INSTANCE.log("Mapping Contact");
	    	Contact con = new Contact();
	    	con.setId(rs.getInt("id"));
	    	con.setAgent_id(rs.getShort("agent_id"));
	    	con.setAddress1(rs.getString("address1"));
	    	con.setAddress2(rs.getString("address2"));
	    	con.setAddress3(rs.getString("address3"));
	    	con.setAddress4(rs.getString("address4"));
	    	con.setAddress5(rs.getString("address5"));
	    	con.setAge(rs.getShort("age"));
	    	con.setAgent_id(rs.getShort("agent_id"));
	    	con.setEmail(rs.getString("email"));
	    	con.setExtaccno(rs.getString("extaccno"));
	    	con.setIncome(rs.getInt("income"));
	    	con.setMarital_status(rs.getString("marital_status"));
	    	con.setPhone(rs.getString("phone"));
	    	con.setProfession(rs.getString("profession"));
	    	con.setFirst_name(rs.getString("first_name"));
	    	con.setLast_name(rs.getString("last_name"));
	    	//Logger.INSTANCE.log("Mapped Contact: " + con.toString());

	        return con;
	    }
	}
	
	private static final class StatementMapper implements RowMapper<Statement> {

	    public Statement mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	Statement stmnt = new Statement();
	    	stmnt.setAcc_id(rs.getInt("acc_id"));
	    	stmnt.setStatementId(rs.getInt("statement_id"));
	    	stmnt.setYear(rs.getShort("year"));
	    	stmnt.setMonth(rs.getShort("month"));
	    	stmnt.setOpening_balance(rs.getBigDecimal("opening_balance"));
	    	stmnt.setClosing_balance(rs.getBigDecimal("closing_balance"));
	    	stmnt.setMin_payment(rs.getBigDecimal("min_payment"));
	    	stmnt.setTxn_count(rs.getInt("txn_count"));

	        return stmnt;
	    }
	}
	
	private static final class TransactionMapper implements RowMapper<Transaction> {

	    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	Transaction trans = new Transaction();
	    	trans.setAcc_id(rs.getInt("acc_id"));
	    	trans.setStatement_id(rs.getInt("statement_id"));
	    	trans.setTx_id(rs.getInt("tx_id"));
	    	trans.setTx_date(rs.getDate("tx_date"));
	    	trans.setAmount(rs.getBigDecimal("amount"));
	    	trans.setDescription(rs.getString("description"));
	    	trans.setCategory(rs.getString("category"));

	        return trans;
	    }
	}

	public NamedParameterJdbcTemplate getNpjc() {
		return npjc;
	}

	public void setNpjc(NamedParameterJdbcTemplate npjc) {
		this.npjc = npjc;
	}

//	public DataSource getDataSource() {
//		return dataSource;
//	}
}
