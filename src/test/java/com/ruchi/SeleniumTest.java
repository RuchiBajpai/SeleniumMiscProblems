
package com.ruchi;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumTest extends SeleniumOperations {


    @BeforeAll
    public void beforeAll(){
        SeleniumOperations.launchWebBrowser();
    }

    @BeforeEach
    public void beforeEach(){
        SeleniumOperations.navigatetoURL("http://the-internet.herokuapp.com/");
        SeleniumOperations.waitFor(2000);
    }

//    @Test
    public void testfileupload() {
        WebElement elem = SeleniumOperations.findElement(By.xpath("//ul/li/a[text()='File Upload']"));
        SeleniumOperations.clickfileupload(elem);
        elem = SeleniumOperations.findElement(By.id("file-upload"));
        SeleniumOperations.uploadafile(elem, "/Users/amitrawat/Desktop/Amit/Ruchi/Java-projects/Ruchi_Job_Studies/SeleniumMiscProbelms/test.js");
        SeleniumOperations.waitFor(5000);
        elem = SeleniumOperations.findElement(By.id("file-submit"));
        SeleniumOperations.clickonupload(elem);
        SeleniumOperations.waitFor(5000);
        elem = SeleniumOperations.findElement(By.id("uploaded-files"));
        String actualtext = elem.getText();
        Assertions.assertEquals("test.js", actualtext);
    }


   @Test
    public void testhoveroperation() throws InterruptedException {
        WebElement elem = SeleniumOperations.findElement(By.xpath("//a[text()='Hovers']"));
        elem.click();
        elem = SeleniumOperations.findElement(By.xpath("//div/img[@alt = 'User Avatar']"));
        SeleniumOperations.hoverover(elem);
        Thread.sleep(5000);
        elem = SeleniumOperations.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
        boolean flag = elem.isDisplayed();
        Assertions.assertEquals(true, flag);


    }

//    @Test
    public void testcheckbox() {
        WebElement elem = SeleniumOperations.findElement(By.xpath("//a[text()='Checkboxes']"));
        elem.click();
        elem = SeleniumOperations.findElement(By.cssSelector("input[type*='checkbox 2']"));
        boolean isSelected = elem.isSelected();
        Assertions.assertEquals("true", isSelected);


    }


//    @Test
//    public void testdropdown(){
//        WebElement elem = SeleniumOperations.findElement(By.xpath("//a[text() = 'Dropdown']"));
//        elem.click();
//        Select select = new Select(SeleniumOperations.findElement(By.id("dropdown")));
//        select.selectByVisibleText("Option 1");
//        WebElement selectedOptionElement = SeleniumOperations.findElement(By.cssSelector("select#dropdown>option[selected='selected']"));
//        Assertions.assertEquals(selectedOptionElement.getText(),"Option 1");
//    }

    @AfterEach
    public void tearDown(){
        SeleniumOperations.quitdriver();

    }

}

