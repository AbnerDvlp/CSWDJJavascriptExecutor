package framework.SeleniumAulaExecuteScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteExecuteScript {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// submarino();
		testeJavascript();
	}

	public static void submarino() throws InterruptedException {
		String driverPath = "C:\\Users\\55519\\eclipse-workspace\\SeleniumAulaExecuteScript\\drivers\\chrome\\084\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();

		driver.get("https://www.submarino.com.br/");
		// maximiza a tela
		driver.manage().window().maximize();

		// isntancia o java script
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// digita livros no input text
		js.executeScript("document.getElementById('h_search-input').value='livros';");
		Thread.sleep(1000);
		// clica no botao search
		js.executeScript("document.getElementById('h_search-btn').click();");
		js.executeScript("window.scrollBy(0,1600)");
		
		// pega o elemento
		WebElement livro = driver.findElement(By.cssSelector("img[alt='Livro - Como manter a calma']"));
		
		// clica nele
		js.executeScript("arguments[0].click();", livro);

	}

	public static void testeJavascript() throws InterruptedException {
		String driverPath = "C:\\Users\\55519\\eclipse-workspace\\SeleniumAulaExecuteScript\\drivers\\chrome\\084\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();
		// instanciando o java script Executor

		driver.get("https://the-internet.herokuapp.com");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement linkcheck = driver.findElement(By.linkText("Checkboxes"));
		js.executeScript("arguments[0].click();", linkcheck);
		
		// pega o titulo da pagina
		String titulo = js.executeScript("return document.title;").toString();
		System.out.println(titulo);

		WebElement checkbox = driver.findElement(By.cssSelector("input[type = 'checkbox']"));

		Thread.sleep(1000);
		// marca a checkbox
		js.executeScript("arguments[0].checked=true", checkbox);
		Thread.sleep(1000);
		
		// dispara um aleta javascript
		js.executeScript("alert('O elemento foi checkado!')");

		Thread.sleep(1000);
		// poe o foco no alerta
		Alert alerta = driver.switchTo().alert();
		
		// aceita o alerta
		alerta.accept();

		js.executeScript("arguments[0].checked=false", checkbox);

		Thread.sleep(1000);
		// da um refresh
		js.executeScript("history.go(0);");


	}

}
