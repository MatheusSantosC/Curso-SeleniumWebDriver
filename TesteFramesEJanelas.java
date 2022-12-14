import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteFramesEJanelas {

	@Test
	public void deveInteragirComFrame() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		driver.switchTo().alert();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
		
		driver.close();
		
		
	}
		@Test
		public void deveInteragirComJanela() {
		
			WebDriver driver = new FirefoxDriver();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("buttonPopUpEasy")).click();
			driver.switchTo().window("Popup");
			driver.findElement(By.tagName("textarea")).sendKeys("Deu Cert?");
			driver.close();
			driver.switchTo().window("");
			driver.findElement(By.tagName("textarea")).sendKeys("E Agora?");
			
		
		
	}
	
	
}
