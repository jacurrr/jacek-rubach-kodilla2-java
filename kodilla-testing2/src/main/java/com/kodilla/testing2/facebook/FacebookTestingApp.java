package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookTestingApp {
    public static final String SELECT_REGISTRATION = "u_0_2";
    public static final String XPATH_FIRSTNAME ="//div[contains(@class,\"clearfix _58mh\")]/div[1]/div/input";
    public static final String XPATH_LASTNAME ="//div[contains(@class,\"clearfix _58mh\")]/div[2]/div/div/input";
    public static final String XPATH_MAIL_OR_PHONE ="//div[contains(@class,\"mbm _a4y\")]/div/div/input";
    public static final String XPATH_PASSWORD ="//div[contains(@class,\"mbm _br- _a4y\")]/div/div/input";
    public static final String XPATH_BIRTH_DATE_DAY ="//span[contains(@class,\"_5k_4\")]/span/select[1]";
    public static final String XPATH_BIRTH_DATE_MONTH ="//span[contains(@class,\"_5k_4\")]/span/select[2]";
    public static final String XPATH_BIRTH_DATE_YEAR ="//span[contains(@class,\"_5k_4\")]/span/select[3]";
    public static final String XPATH_SEX_MALE ="//span[contains(@class,\"_5k_3\")]/span[2]/input";


    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com/");

        WebElement registration = driver.findElement(By.id(SELECT_REGISTRATION));
        registration.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement firstName = driver.findElement(By.xpath(XPATH_FIRSTNAME));
        firstName.sendKeys("Jan");

        WebElement lastName = driver.findElement(By.xpath(XPATH_LASTNAME));
        lastName.sendKeys("Kowalski");

        WebElement mail = driver.findElement(By.xpath(XPATH_MAIL_OR_PHONE));
        mail.sendKeys("999888777");

        WebElement password = driver.findElement(By.xpath(XPATH_PASSWORD));
        password.sendKeys("abc123@");

        WebElement birthDateDay = driver.findElement(By.xpath(XPATH_BIRTH_DATE_DAY));
        Select selectDay = new Select(birthDateDay);
        selectDay.selectByIndex(30);

        WebElement birthDateMonth = driver.findElement(By.xpath(XPATH_BIRTH_DATE_MONTH));
        Select selectMonth = new Select(birthDateMonth);
        selectMonth.selectByIndex(12);

        WebElement birthDateYear = driver.findElement(By.xpath(XPATH_BIRTH_DATE_YEAR));
        Select selectYear = new Select(birthDateYear);
        selectYear.selectByValue("1945");

        WebElement sexSelect = driver.findElement(By.xpath(XPATH_SEX_MALE));
        sexSelect.click();
    }
}
