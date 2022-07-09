package gstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Enter {
    public WebDriver driver;
    public Enter(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
public void clickLogin() throws InterruptedException {
    WebElement loginBtn = driver.findElement(By.xpath("//a[@class='userbar__button __active']"));
    loginBtn.click();
}
public void login(String lg) throws InterruptedException {
    WebElement enterLogin = driver.findElement(By.xpath("//*[@id=\"login_form_id\"]/dl/dd[1]/input"));
    enterLogin.sendKeys(lg);
}
public void password(String ps) throws InterruptedException {
    WebElement enterPassword = driver.findElement(By.xpath("//*[@id=\"login_form_id\"]/dl/dd[2]/input"));
    enterPassword.sendKeys(ps);
}
public void checkError(String errorXpass) throws InterruptedException {
    WebElement enterKeys =driver.findElement(By.xpath("//*[@id=\"login_form_id\"]/dl/dd[3]/span[1]/input"));
   enterKeys.click();
    driver.findElement(By.xpath(errorXpass)).isDisplayed();


}

}

