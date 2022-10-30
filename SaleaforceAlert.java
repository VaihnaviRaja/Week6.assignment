package week6.assg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaleaforceAlert {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("disable-notification");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		
//		2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
//		3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
//		4. Click on Opportunity tab 
		WebElement oppor = driver.findElement(By.xpath("//a[@class='slds-context-bar__label-action dndItem']//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", oppor);
		
//		5. Click on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
//		6. Choose Close date as Tomorrow Date
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("10/31/2022",Keys.ENTER);
		
//		7. Click on save 
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();

//		8. Verify the Alert message (Complete this field) displayed for Name and Stage"
		String alert = driver.findElement(By.xpath("//h2[@title='We hit a snag.']")).getText();
		System.out.println(alert);
		driver.findElement(By.xpath("//button[@title='Close error dialog']//lightning-primitive-icon[1]")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce_Automation_by_Vaishnavi",Keys.ENTER);
		Thread.sleep(20);
		driver.findElement(By.xpath("//button[@data-value='--None--']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
	}

}
