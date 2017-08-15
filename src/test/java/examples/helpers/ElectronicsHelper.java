package examples.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectronicsHelper {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	public ElectronicsHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void mouseOverOnElectronics() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("li[data-key=electronics]"))).perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-tracking-id='0_Motorola']")));
	}
	
	static void wait(WebElement element) {
		wait = new WebDriverWait(driver, 10);
	}

}
