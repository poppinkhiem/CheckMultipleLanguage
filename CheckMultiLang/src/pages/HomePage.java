package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import model.LanguageUtils;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	private By serviceLabel = By.xpath("/html/body/header/div[4]/div/nav[1]/ul/li[1]/a");
	private By productLabel = By.xpath("/html/body/header/div[4]/div/nav[1]/ul/li[2]/a");
	private By customerLabel = By.xpath("/html/body/header/div[4]/div/nav[1]/ul/li[3]/a");
	private By projectLabel = By.xpath("/html/body/header/div[4]/div/nav[1]/ul/li[4]/a");
	private By abilityLabel = By.xpath("/html/body/header/div[4]/div/nav[1]/ul/li[5]/a");

	public String getServiceLabelText() {
		WebElement service = driver.findElement(serviceLabel);
		String serviceText = service.getText();
		System.out.println("Lấy từ trình duyệt ra");
		return serviceText;
	}

	public String getProductLabelText() {
		WebElement product = driver.findElement(productLabel);
		String productText = product.getText();
		return productText;
	}

	public String getCustomerLabelText() {
		WebElement customer = driver.findElement(customerLabel);
		String customerText = customer.getText();
		return customerText;
	}

	public String getProjectLabelText() {
		WebElement project = driver.findElement(projectLabel);
		String projectText = project.getText();
		return projectText;
	}

	public String getAbilityLabelText() {
		WebElement ability = driver.findElement(abilityLabel);
		String abilityText = ability.getText();
		return abilityText;
	}


}