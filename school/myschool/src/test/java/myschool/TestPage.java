/**
 * 
 */
package myschool;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author c116
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/conf/applicationContext-dao.xml",
"/conf/applicationContext-service.xml",
"springmvc.xml"							})
public class TestPage {

}
