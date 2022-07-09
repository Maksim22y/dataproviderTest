package gstore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MainClass {

         public static WebDriver driver;
         public static Enter enter;
         String siteUrl="https://gstore.ua/?gclid=Cj0KCQiAnuGNBhCPARIsACbnLzpIm0BunNyor6hcWxx9U2nLgtBOfdnQK-V0vDatFLojDQgOK4Pne48aAncaEALw_wcB";
        @BeforeClass
        void chromeDriver(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\"C:\\chromedriver.exe\"");

    }
       @BeforeMethod
        public void setUp() {
        enter= new Enter(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.MILLISECONDS);
           driver.get(siteUrl);

    }

   @Test(dataProvider = "LoginPass")
    public void testLogin(String lg,String ps,String errorXpass) throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     enter.clickLogin();
     enter.login(lg);
     enter.password(ps);
     enter.checkError(errorXpass);
    }
    @DataProvider(name ="LoginPass" )
    public Object [][] getData() {
        Object [][] data={
                {"","","//*[@id=\"login_form_id\"]/dl/dd[2]/div/div"},
                {"    ","        ","//*[@id=\"login_form_id\"]/dl/dd[1]/div/div"},
                {"killativspidey@gmail.com","","//*[@id=\"login_form_id\"]/dl/dd[2]/div/div"},
                {"","gimno2000","//*[@id=\"login_form_id\"]/dl/dd[1]/div/div"},
                {"killativspidey@gmail.com","gimno2000","//span[@class=\"userbar__button-text\"]"}};
        return data;
    }
}
