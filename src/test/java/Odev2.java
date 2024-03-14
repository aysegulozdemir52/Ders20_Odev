package org.Ders20_Odev.Tests;

import org.Ders20_Odev.drivers.Driver;
import org.Ders20_Odev.drivers.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
public class Odev2 {
    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager = new PropertyManager();
    @BeforeSuite
    public void CssOdev2() throws MalformedURLException {
        driver = webDriver.initializeDriver();
    }

    @Test(priority = 1)
    public void sayfayaGit() {
        driver.get(propertyManager.getProperty("APP_URL2"));
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "DEMOQA");
    }

    @Test(priority = 2)
    public void WebTablesClick() {
        WebElement Buttons = driver.findElement(By.cssSelector("#item-3"));
        Buttons.click();
        WebElement textWebtables = driver.findElement(By.cssSelector(".text-center"));
        String control = textWebtables.getText();
        Assert.assertEquals(control, "Web Tables");
    }

    @Test(priority = 3)
    public void Add() {
        WebElement Add = driver.findElement(By.cssSelector("#addNewRecordButton"));
        Add.click();
        WebElement textWebtables = driver.findElement(By.cssSelector("#registration-form-modal"));
        String control = textWebtables.getText();
        Assert.assertEquals(control, "Registration Form");
    }

    @Test(priority = 4)
    public void firstName() {
        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.click();
        firstName.sendKeys("Aysegul");
//        String control = firstName.getText();
//        Assert.assertEquals(control, "Aysegul");
    }

    @Test(priority = 5)
    public void lastName() {
        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.click();
        lastName.sendKeys("Ozdemir");
//        String control = lastName.getText();
//        Assert.assertEquals(control, "Ozdemir");
    }

    @Test(priority = 6)
    public void eMail() {
        WebElement eMail = driver.findElement(By.cssSelector("#userEmail"));
        eMail.click();
        eMail.sendKeys("cs.aysegulozdemir@gmail.com");
//        String control = eMail.getText();
//        Assert.assertEquals(control, "cs.aysegulozdemir@gmail.com");
    }

    @Test(priority = 7)
    public void age() {
        WebElement age = driver.findElement(By.cssSelector("#age"));
        age.click();
        age.sendKeys("42");
//        String control = age.getText();
//        Assert.assertEquals(control, "42");
    }

    @Test(priority = 8)
    public void salary() {
        WebElement salary = driver.findElement(By.cssSelector("#salary"));
        salary.click();
        salary.sendKeys("0");
//        String control = salary.getText();
//        Assert.assertEquals(control, "0");
    }

    @Test(priority = 9)
    public void department() {
        WebElement department = driver.findElement(By.cssSelector("#department"));
        department.click();
        department.sendKeys("Kalite");
//        String control = department.getText();
//        Assert.assertEquals(control, "Kalite");
    }

    @Test(priority = 10)
    public void submit() {
        WebElement submit = driver.findElement(By.cssSelector("#submit"));
        submit.click();
    }

    @Test(priority = 11)
    public void edit() {
        WebElement duzenle = driver.findElement(By.cssSelector("span#edit-record-4"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", duzenle);
    }

    @Test(priority = 12)
    public void newAge() {
        WebElement ageEdit = driver.findElement(By.cssSelector("#age"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", ageEdit);
        ageEdit.click();
        ageEdit.clear();
        ageEdit.sendKeys("40");

    }
    @Test(priority = 13)
    public void submitClick(){
        WebElement editSubmit = driver.findElement(By.cssSelector("#submit"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", editSubmit);
    }
    @Test(priority = 14)
    public void agecontrol() {
        WebElement newage = driver.findElement(By.cssSelector("div.rt-table > div.rt-tbody > div:nth-child(4) > div > div:nth-child(3)"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", newage);
        String text = newage.getText();
        Assert.assertEquals(text, "40");
    }
    @AfterSuite
    public void close() {
        webDriver.quitDriver();
    }
}