/**
 * 
 */
package myschool;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.school.po.User;
import com.school.service.impl.UserService;

/**
 * @author c116
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/conf/applicationContext-dao.xml","/conf/applicationContext-service.xml"})
public class test {
	
	@Resource
	private UserService userService;
	
	@Test
	public void login() throws Exception{
		User user = new User();
		user.setuId("88888");	
		user.setuPw("88888");
		User result = userService.selectByUidAndUpw(user);
		System.out.println(result);
	}
	
}
