package com.kirkzhang.wordbreak;


import com.kirkzhang.wordbreak.service.WordBreakService;
import com.kirkzhang.wordbreak.service.serviceimpl.WordBreakImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {
  private  Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);


    @Autowired
    private final WordBreakService wordBreakService = new WordBreakImpl();

    @Test()
    public void testWordBreakService() {
     String word = "ilikeicecreamandmango";
     String defaultDict = wordBreakService.getDefaultDict(word);
     String userDict = wordBreakService.getUserAndDefault(word);
     String userAndDefault = wordBreakService.getUserAndDefault(word);
     logger.info("\n [+]defaultDict:{} \n [+]userDict:{} \n [+]userAndDefaultDict:{} ",defaultDict,userDict,userAndDefault);

    }


//    @DataProvider(name = "default")
//    public Object[][] provideDefaultData(){
//      return  new Object[][]{
//              new Object[]{"ilikesamsungmobile"},
//              new Object[]{"ilikeicecreamandmango"}
//      };
//    }



}
