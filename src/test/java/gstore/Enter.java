package gstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class Enter {
    public WebDriver driver;
    public Enter(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
public void clickLogin(){
    WebElement loginBtn = driver.findElement(By.xpath("//a[@class='userbar__button __active']"));
    loginBtn.click();
}
public void login(String lg){
    WebElement enterLogin = driver.findElement(By.xpath("//*[@id=\"login_form_id\"]/dl/dd[1]/input"));
    enterLogin.sendKeys(lg);
}
public void password(String ps){
    WebElement enterPassword = driver.findElement(By.xpath("//*[@id=\"login_form_id\"]/dl/dd[2]/input"));
    enterPassword.sendKeys(ps);
}
public void checkError(String errorXpass){
    WebElement enterKeys =driver.findElement(By.xpath("//*[@id=\"login_form_id\"]/dl/dd[3]/span[1]/input"));
   enterKeys.click();
    driver.findElement(By.xpath(errorXpass)).isDisplayed();
}
}

