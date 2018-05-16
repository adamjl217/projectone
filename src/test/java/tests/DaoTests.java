package tests;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.revature.daoservice.EmployeeDaoService;
import com.revature.daoservice.ReimbursementDaoService;
import com.revature.factory.Reimbursement;
import com.revature.model.Employee;
@SuppressWarnings("unused")
public class DaoTests {

	
	
	@Test
	public void ConnectionException() {

		com.revature.util.ConnectionUtil.main(null);
		
		assertTrue(true);
		
	}
	
	@Test
	public void ReimbursementDataExists(){
		
		List<Reimbursement> reimbursementlist = ReimbursementDaoService.getAllReimbursements();
		List<Reimbursement> reimbursementlist2 = ReimbursementDaoService.getPendingReimbursements();
		List<Reimbursement> reimbursementlist3 = ReimbursementDaoService.getApprovedReimbursements();
		List<Reimbursement> reimbursementlist4 = ReimbursementDaoService.getRejectedReimbursements();


		System.out.println(reimbursementlist);
		System.out.println(reimbursementlist2);
		System.out.println(reimbursementlist3);
		System.out.println(reimbursementlist4);


		assert(reimbursementlist != null);
		assert(reimbursementlist2 != null);
		assert(reimbursementlist3 != null);
		assert(reimbursementlist4 != null);
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        salt.append("a");
        while (salt.length() < 15) { 
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
	
	@Test
	public void InsertAndUpdate() {
		Random rand = new Random();
		
		String randomname = getSaltString();
		String randompass = getSaltString();
		boolean manager = false;
		String randomfirst = getSaltString();
		String randomlast = getSaltString();
		String randomemail = getSaltString();
		Long randomphone = 1234567890L;
		
//		System.out.println(randomname);
//		System.out.println(randompass);
		
		Employee randuser = new Employee(randomname, randompass, manager,
				randomfirst, randomlast, randomemail, randomphone);	
		assertTrue(EmployeeDaoService.insertEmployee(randuser));
		assertFalse(EmployeeDaoService.insertEmployee(randuser));

		
	}
	


}
