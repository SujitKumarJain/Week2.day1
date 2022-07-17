package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
			 WebDriverManager.chromedriver().setup();
			 ChromeDriver driver=new ChromeDriver();
			 driver.get("http://leaftaps.com/opentaps/control/main");
		 
	}*/

	public static void main(String[] args) {
		//Driver set up
		WebDriverManager.chromedriver().setup();
		//Location
	//	String property = System.getProperty(WebDriver.TargetLocator);
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		//EnterURl
		driver.get("http://leaftaps.com/opentaps/control/main");
		//Maximize window
		driver.manage().window().maximize();
		//close browser
		//driver.close();
		//enter username and password and click on login
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		//confirm page loaded
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		//find attribute
		String attribute = logout.getAttribute("value");
		System.out.println(attribute);
		if(attribute.equals("Logout"))
		{
			System.out.println("Page loaded Successful");
		}
		//Click on CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click on Leads Tab
		driver.findElement(By.linkText("Leads")).click();
		//Click on Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		//Enter User details and click on Create
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("BOA");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sujit");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Jain");
		
		//First name local 
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Sujit");
		
		//Department field
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		//Description field
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test Automation script");
		//Email address
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sujitkumarjain@gmail.com");
		//State/Province
		WebElement dropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Armed Forces Americas");
		
		//Create Button
		driver.findElement(By.className("smallSubmit")).click();
		//Get Title
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Created Successfully");
		
		}
		else
		{
			System.out.println("Not created");
		}
	
		
	}
}
