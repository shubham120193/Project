package Exam.Exam;


import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import io.cucumber.core.cli.Main;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class StepDefinitions {
	WebDriver driver =null;
	String projectpath=System.getProperty("user.dir");

	@Given("^user open browser and enter url$")
	public void user_open_browser_and_enter_url() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", projectpath+"/src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http://automationpractice.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.className("login")).click();
		Thread.sleep(5000);
		
	}

	@When("user enters username> and password")
	public void user_enters_username_and_password() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.id("email")).sendKeys("Selenium.testing@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Selenium123");
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(5000);
		
		
	    // Write code here that turns the phrase above into concrete actions

}

	@And("^Clicks login$")
	public void clicks_login() {
		String login = driver.findElement(By.className("logout")).getText();
		if(login=="Sign out") {
			System.out.println("Succesfully loggedin");			
		}
		else {
			System.out.println("notSuccesfully loggedin");
		
		}
	    // Write code here that turns the phrase above in
	}

	@And("^Orders a t-shirt proceed to Checkout$")
	public void orders_a_t_shirt_proceed_to_checkout() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"))).perform();
		driver.findElement(By.xpath("//*[@title='Add to cart']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@title='Proceed to checkout']")).click();
		driver.findElement(By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']")).click();
		driver.findElement(By.name("processAddress")).click();
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.name("processCarrier")).click();
	
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@And("^Selects payment method$")
	public void selects_payment_method() {
		driver.findElement(By.className("bankwire")).click();
		driver.findElement(By.xpath("//*[@type='submit']/span[contains(text(),'I confirm my order')]")).click();
		String message = driver.findElement(By.className("cheque-indent")).getText();
		if(message=="Your order on My Store is complete.") {
			System.out.println("Order places Successfully");
		}
		driver.findElement(By.xpath("//*[@title='Back to orders']")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@And("^Selects Order History$")
	public void selects_order_history() {
		   
		String order=driver.findElement(By.xpath("//*[@class='page-heading bottom-indent']")).getText();
		if(order=="ORDER HISTORY") {
			System.out.println("Order history page is open");	
		}
		
		
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("^Verifies the order placed$")
	public void verifies_the_order_placed() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mm/yyyy");  
		   LocalDateTime now = LocalDateTime.now(); 
		String date=driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr[1]/td[2]")).getText();
		if(date==dtf.format(now).toString()) {
			System.out.println("Order is verified");
		}
		
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.close();
	}
	
	@Given("^user open MyAccount page$")
	public void user_open_MyAccount_page() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", projectpath+"/src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http://automationpractice.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.className("login")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.id("email")).sendKeys("Selenium.testing@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Selenium123");
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@title='Information']")).click();
		Thread.sleep(5000);

		
	}
	
	@When("^user changes the first Name$")
	public void user_changes_the_first_Name() {
		
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Testing");
		driver.findElement(By.name("old_passwd")).sendKeys("Selenium123");
		driver.findElement(By.name("passwd")).sendKeys("Selenium123");
		driver.findElement(By.name("confirmation")).sendKeys("Selenium123");
	}
	@And ("^user saves the data$")
	public void user_saves_the_data() {
	driver.findElement(By.name("submitIdentity")).click();
		
		String Alert=driver.findElement(By.xpath("//*[@class='alert alert-success']")).getText();
		if(Alert=="Your personal information has been successfully updated.") {
			System.out.println("update is successfully");
		}
		
	}

	@Then("^Verifies the change is made properly$")
	public void Verifies_the_change_is_made_properly() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='columns']/div[1]/a[2]")).click();
		Thread.sleep(50000);
		driver.findElement(By.xpath("//*[@title='Information']")).click();
		String Verify=driver.findElement(By.id("firstname")).getText();
		if(Verify=="Testing") {
			System.out.println("First Name changes successfully");
		}
		
	}

}
