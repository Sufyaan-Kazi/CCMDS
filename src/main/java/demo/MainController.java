package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.beans.Account;
import demo.beans.Contact;
import demo.beans.Statement;
import demo.beans.Transaction;
import demo.data.AccountDAOImpl;
import demo.utils.Logger;

@RestController
public class MainController {
	@Autowired
	private AccountDAOImpl accDao = null;
	
	@Autowired
	private Environment env;
	
    @RequestMapping("/getAccount")
    public Account getAccount(@RequestParam(value="accId", required=false, defaultValue="150094") int accId) {
    	Logger.INSTANCE.log("Stuff: " + env.getProperty("vcap.services.ccmds-service.credentials.uri"));
    	Logger.INSTANCE.log("In retrieve account from DB for: " + accId);
    	
    	return accDao.getAccountDetails(accId);
    }
    
    @RequestMapping("/getContactForAccount")
    public Contact getContactForAccount(@RequestParam(value="accId", required=false, defaultValue="150094") int accId) {
    	Logger.INSTANCE.log("In retrieve contact from DB for: " + accId);
    	
    	return accDao.getContactForAccount(accId);
    }
    
    @RequestMapping("/getStatementsForAccount")
    public List<Statement> getStatementsForAccount(@RequestParam(value="accId", required=false, defaultValue="150094") int accId) {
    	Logger.INSTANCE.log("In retrieve statement list from DB for: " + accId);
    	
    	return accDao.getStatementsForAccount(accId);
    }
    
    @RequestMapping("/getTransactionsForStatement")
    public List<Transaction> getTransactionsForStatement(@RequestParam(value="accId", required=false, defaultValue="150094") int accId, @RequestParam(value="statementId", required=false, defaultValue="44") int statementId) {
    	Logger.INSTANCE.log("In retrieve statement transaction list from DB for: " + accId + "," + statementId);
    	
    	return accDao.getTransactionsForStatement(accId, statementId);
    }

}