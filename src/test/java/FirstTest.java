import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest {
    @Test
    public void checkZipCodeInput() {
        //1 открыть браузер
        //зайти на сайт

        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.cssSelector("[name='zip_code']")).sendKeys("1234");
        browser.findElement(By.cssSelector("[value='Continue']")).click();

        boolean isErrorAppear = browser.findElement(By.cssSelector(".error_message")).isDisplayed();
        assertTrue(isErrorAppear, "Error message does not appear");

        String errorMessageText = browser.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorMessageText, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }

    @Test
    public void checkZipCodeFiveDigitInput() {
        //1 открыть браузер
        //зайти на сайт

        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.cssSelector("[name='zip_code']")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value='Continue']")).click();

        boolean isRegisterBtnExist = browser.findElement(By.cssSelector("[value='Register']")).isDisplayed();
        assertTrue(isRegisterBtnExist, "Register btn is not visible");

        browser.quit();
    }
}