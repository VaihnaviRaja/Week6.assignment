package week6.assg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {
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
		
//		6. Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it 
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Vaishnavi",Keys.ENTER);
		Thread.sleep(20);
		
//		7. Choose close date as Today
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("10/30/2022",Keys.ENTER);		
//		8. Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//button[@data-value='--None--']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
		
//		9. click Save and VerifyOppurtunity Name"
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		WebElement verify = driver.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation by Vaishnavi']"));
		String text = verify.getText();
		System.out.println("The created Opprtunity name is"+text);
	}

}
