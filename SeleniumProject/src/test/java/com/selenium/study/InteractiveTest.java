package com.selenium.study;

import io.appium.java_client.TouchAction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;


import java.security.Key;
import java.util.concurrent.TimeUnit;

public class InteractiveTest {

    public static WebDriver driver;

    public static Actions actions;

    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        actions =new Actions(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    //鼠标操作
    @Test
    public void clickTest(){

        try {
            driver.get("https://sahitest.com/demo/clicks.htm");
            actions.click(driver.findElement(By.xpath("//input[@value='click me']")));
            actions.doubleClick(driver.findElement(By.xpath("//input[@value='dbl click me']")));
            actions.contextClick(driver.findElement(By.xpath("//input[@value='right click me']")));
            actions.perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }
    //鼠标移动
    @Test
    public void moveTest(){
        try {
            driver.get("https://www.baidu.com");
            actions.moveToElement(driver.findElement(By.id("s-usersetting-top")));
            actions.perform();
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //鼠标拖拽
    @Test
    public void dragTest(){

        try {
            driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
            actions.dragAndDrop(driver.findElement(By.id("dragger")),driver.findElement(By.xpath("//*[@class='item'][last()]"))).perform();
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //键盘操作
    @Test
    public void keyBoardTest(){
        try {
            //谷歌浏览是不支持键盘事件的，需要用火狐
            driver.get("http://sahitest.com/demo/label.htm");
            driver.findElements(By.xpath("//input[@type='textbox']")).get(0).sendKeys("seleniumcoding");
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
            actions.keyDown(driver.findElements(By.xpath("//input[@type='textbox']")).get(1),Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //滑动效果
    @Test
    public void scrollTest(){
        try {
            //
            driver.get("https://www.baidu.com");
            driver.manage().window().maximize();
            driver.findElement(By.id("kw")).sendKeys("霍格沃兹测试学院");

            TouchActions actions=new TouchActions(driver);
            actions.click(driver.findElement(By.id("su")));

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Thread.sleep(4000);

            driver.findElement(By.xpath("//a[@class='n']")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
