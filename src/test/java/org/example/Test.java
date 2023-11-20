package org.example;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Alex\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();

    }
    @Before
    public void getURL(){
        driver.get("https://parabank.parasoft.com/parabank");
    }


    @org.junit.Test
    public void simple_login() throws Exception{

        Thread.sleep(1000);
        WebElement username=driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
        WebElement password=driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
        Thread.sleep(1000);

        username.sendKeys("salam");
        Thread.sleep(1000);

        password.sendKeys("salam");
        Thread.sleep(1000);

        password.submit();
    }
    @org.junit.Test
    public void emptyUsername() throws Exception{

        Thread.sleep(1000);

        WebElement password=driver.findElement(By.name("password"));
        Thread.sleep(1000);

        password.sendKeys("salam");
        Thread.sleep(1000);

        password.submit();
        Thread.sleep(1000);

        WebElement error=driver.findElement(By.xpath("//html/body/div[1]/div[3]/div[2]/p"));
        System.out.println(error.getText());
        Assert.assertEquals("Please enter a username and password.", error.getText());

    }
    @org.junit.Test
    public void emptyPassword() throws Exception{
        Thread.sleep(1000);
        WebElement username=driver.findElement(By.name("username"));

        Thread.sleep(1000);

        username.sendKeys("salam");
        Thread.sleep(1000);



        username.submit();
        Thread.sleep(1000);

        WebElement error=driver.findElement(By.xpath("//html/body/div[1]/div[3]/div[2]/p"));
        System.out.println(error.getText());
        Assert.assertEquals("Please enter a username and password.", error.getText());
    }
    @org.junit.Test
    public void wrong_redentials() throws Exception{
        Thread.sleep(1000);
        WebElement username=driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
        WebElement password=driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
        Thread.sleep(1000);

        username.sendKeys("salam1");
        Thread.sleep(1000);

        password.sendKeys("salam1");
        Thread.sleep(1000);

        password.submit();
        WebElement error=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/p"));
        System.out.println(error.getText());
        Assert.assertEquals("READ MORE", error.getText());
    }
    @org.junit.Test
    public void aboutUs() throws Exception{
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[2]/a")).click();
        WebElement title=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/h1"));
        Assert.assertEquals("ParaSoft Demo Website", title.getText());
    }
    @org.junit.Test
    public void services()throws Exception{
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[3]/a")).click();
        WebElement title=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/span[1]"));
        Assert.assertEquals("Available Bookstore SOAP services:", title.getText());
    }
    @org.junit.Test
    public void admin()throws Exception{
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[6]/a")).click();
        WebElement title=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/h1"));
        Assert.assertFalse(("Administration".equals( title.getText())));
    }
    @org.junit.Test
    public void index() throws Exception{
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[2]/li[1]/a")).click();
        Assert.assertEquals("https://parabank.parasoft.com/parabank/index.htm", driver.getCurrentUrl());
    }
    @org.junit.Test
    public void products() throws Exception{
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[4]/a")).click();
        Assert.assertEquals("https://www.parasoft.com/products/", driver.getCurrentUrl());
    }
    @org.junit.Test
    public void locations() throws Exception{
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[5]/a")).click();
        Assert.assertEquals("https://www.parasoft.com/solutions/", driver.getCurrentUrl());
    }
    @org.junit.Test
    public void transfer_loan() throws Exception{
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/ul[1]/li[3]/a")).click();
        Assert.assertSame("https://parabank.parasoft.com/parabank/services/ParaBank?wsdl", driver.getCurrentUrl());

    }
    @AfterClass
    public static void quit(){
        driver.quit();
    }
}
