

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class desafio2 {

	
	
	
private WebDriver driver;
	
	@Before
	public void inicializa() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	
	@After
	public void finalizar() {
	driver.close();
	}
	@Test
	
	
	public void deveValidarNomeObrigatorioo() {
		
	
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
		
		
	}
	

		@Test
		
		public void deveValidarsobrenomeObrigatorio() {
			
		
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheus");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
			alert.accept();
			
		
		}
			@Test
			
			public void deveValidarSexoObrigatorio() {
				
				
				
				driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheus");
				driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
				driver.findElement(By.id("elementosForm:cadastrar")).click();
				Alert alert = driver.switchTo().alert();
				Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
				alert.accept();
							}
				
				@Test
				
				public void deveValidarComidaObrigatorio() {
					
				
					
					driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheus");
					driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
					driver.findElement(By.id("elementosForm:sexo:0")).click();
					driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
					driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
					driver.findElement(By.id("elementosForm:cadastrar")).click();
					Alert alert = driver.switchTo().alert();
					Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
					alert.accept();
					
		
				}
					
					@Test
					public void deveValidaresportesObrigatorio() {
						
						
						
						driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheus");
						driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
						driver.findElement(By.id("elementosForm:sexo:0")).click();
						driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
						WebElement element = driver.findElement(By.id("elementosForm:esportes"));
						Select combo = new Select(element);
						combo.selectByVisibleText("Corrida");
						combo.selectByVisibleText("O que eh esporte?");
						driver.findElement(By.id("elementosForm:cadastrar")).click();
						Alert alert = driver.switchTo().alert();
						Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
						alert.accept();
						
			
						
			}		
		}		
		
	
	
	
	
	
	
	
	

