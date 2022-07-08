package gstore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
        public void setup() {
        enter= new Enter(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.MILLISECONDS);
        driver.get(siteUrl);
    }
    @DataProvider(name ="LoginPass" )
    public Object [][] getData() {
        Object [][] data={
                {"","","//*[@id=\"login_form_id\"]/dl/dd[1]/div/div"},
                {"killatua@gmail.com","kkkk","//*[@id=\"login_form_id\"]/div/div"},
                {"killativspidey@gmail.com","gimno2000","//span[@class=\"userbar__button-text\"]"}};
        return data;
    }
   @Test(dataProvider = "LoginPass")
    public void testLogin(String lg,String ps,String errorXpass) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     enter.clickLogin();
     enter.login(lg);
     enter.password(ps);
     enter.checkError(errorXpass);
    }
}
