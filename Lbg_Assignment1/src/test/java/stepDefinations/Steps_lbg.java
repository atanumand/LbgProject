package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps_lbg {
	WebDriver driver;
	
	@Given("Bank page should open {string}")
	public void bank_page_should_open(String string) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(string);
	}

	@When("i mouse hover on products and service and click on current accounts")
	public void i_mouse_hover_on_products_and_service_and_click_on_current_accounts() {
		WebElement element = driver.findElement(By.linkText("Products and services"));

		//Creating object of an Actions class
		Actions act = new Actions(driver);

		//Performing the mouse hover action on the target element.
		act.moveToElement(element);
		
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Current accounts"));

		//To mousehover on sub menu
		act.moveToElement(subMenu);

		//build()- used to compile all the actions into a single step 
		act.click().build().perform();
	}

	@When("checking the validatios")
	public void checking_the_validatios() {
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div[2]/div/div/div/div/div[2]/p[1]"));
		String s = element.getText();
		assertEquals(s,"£21 monthly fee to maintain the account.");
		
		List<WebElement> ele = driver.findElements(By.xpath("/html/body/div[1]/div/div[5]/div/div/div/div"));
		List<WebElement> ele2 = driver.findElements(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div"));
		int CurrentAcProducts = ele.size()+ele2.size();
		assertEquals(CurrentAcProducts,4);
	}


	@Then("it should be loaded with {string}")
	public void it_should_be_loaded_with(String string) {
		assertEquals(string,driver.getCurrentUrl());
		driver.close();
	}


}
