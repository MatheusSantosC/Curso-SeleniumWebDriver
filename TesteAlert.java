import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;

public class TesteAlert {

	
	@Test
	public void deveInteragirComAlertSimples() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("alert")).click();
	Alert alert = driver.switchTo().alert();
	String texto = alert.getText();
	Assert.assertEquals("Alert Simples", texto);
	alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}
	@Test
	public void deveInteragirComAlertComfirm() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept();
		Assert.assertEquals("Confirmado", alerta.getText());
		alerta.accept();
		
		
		
		driver.findElement(By.id("confirm")).click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
		alerta.dismiss();
	}
		@Test
		public void deveInteragirComPrompt() {
			WebDriver driver = new FirefoxDriver();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			driver.findElement(By.id("prompt")).click();
			Alert alerta = driver.switchTo().alert();
			Assert.assertEquals("Digite um numero", alerta.getText());
			alerta.sendKeys("12");
			alerta.accept();
			Assert.assertEquals("Era 12?", alerta.getText());
			alerta.accept();
			Assert.assertEquals(":D", alerta.getText());
			alerta.accept();
			





	}
}


