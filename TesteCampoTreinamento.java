import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class TesteCampoTreinamento {
	
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
	public void testeTextField() {
		
	driver.findElement(By.id("elementosForm:nome")).sendKeys("teste");
	//driver.findElement(By.id("elementosForm:name")).getAttribute("value");
	Assert.assertEquals("teste",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	
//driver.quit();
	
	
	
	}
	
	@Test
	public void deveIteragirComTextArea() {
		
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		Assert.assertEquals("teste",driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		//driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		
	driver.findElement(By.id("elementosForm:sexo:0")).click();
	Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		//driver.quit();
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		
		
	driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
	Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	//driver.quit();
	}

	
	@Test
	public void deveinteragirComCombo() {
		
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByIndex(2);
		//driver.quit();
		
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
	
			}
		
	
@Test
public void deveVerificarValoresComboMultiplo() {
	
	
	WebElement element = driver.findElement(By.id("elementosForm:esportes"));
	Select combo = new Select(element);
	combo.selectByVisibleText("Natacao");
	combo.selectByVisibleText("Corrida");
	combo.selectByVisibleText("O que eh esporte?");
	
	List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
	Assert.assertEquals(3, allSelectedOptions.size());
	
	
}
	@Test
	public void deveVerificarValoresComBotoes() {
		
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		
	}
	
	@Test
	
	public void deveVerificarValoresComLinks() {
		
		
		driver.findElement(By.linkText("Voltar")).click();
		//driver.findElement(By.id("Resultado")).getText();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("Resultado")).getText());
	}
	
	
	@Test
	public void deveEncontraNomeNaTela() {
		
		
		//driver.findElement(By.tagName("body"));
		//Assert.assertTrue(driver.findElement(By.tagName("body"))
			//	.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		
		
	
}
}


