
package tn.esprit.spring.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

		@Autowired
		IUserService us; 
private static final Logger log = LogManager.getLogger(UserServiceImplTest.class);


	@Test
		public void testAddUser() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User("Maroua", "Maroua", d, Role.INGENIEUR); 
			User userAdded = us.addUser(u); 
			Assert.assertEquals(u.getLastName(), userAdded.getLastName());
			log.info(" user ajoutée avec succès");
		}
	 

		@Test
		public void testRetrieveAllUsers() {
			List<User> listUsers = us.retrieveAllUsers(); 
			// if there are 7 users in DB : 
			Assert.assertEquals(10L, listUsers.size());
			
		}
		
		
		
		@Test
		public void testModifyUser() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User(14L, "Maroua", "Maroua11", d, Role.INGENIEUR); 
			User userUpdated  = us.updateUser(u); 
			Assert.assertEquals(u.getLastName(), userUpdated.getLastName());
			log.info("user modifié avec succès");
		}
	
		@Test
		public void testRetrieveUser() {
			User userRetrieved = us.retrieveUser("12"); 
			Assert.assertEquals(12L, userRetrieved.getId().longValue());
			log.info(" retrieve user: " + us);
		}
		
		@Test
		public void testDeleteUser() {
			us.deleteUser("17");
			//Assert.assertNull(us.retrieveUser("16"));
			log.info(" user supprimé avec succès");
		}
		
		// 5 tests unitaires  
 
}
