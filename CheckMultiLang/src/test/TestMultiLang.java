package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import model.LanguageUtils;
import pages.HomePage;

public class TestMultiLang {
private WebDriver driver;
public String driverPath = "C:\\Users\\Admin\\Desktop\\Automation Test\\Edge\\msedgedriver.exe";
HomePage homepage;
LanguageUtils languageutils;
@BeforeClass
public void setup() throws InterruptedException {
    System.setProperty("webdriver.edge.driver", driverPath);
    driver = new EdgeDriver();
    homepage = new HomePage(driver);
    languageutils = new LanguageUtils(driver);
    driver.get("https://co-well.vn");
    driver.manage().window().maximize(); 
    LanguageUtils.loadLanguage("vi"); // Chọn ngôn ngữ "en"
    Thread.sleep(2000);
   
}

@Test
public void getHeader() throws InterruptedException {

   

    String multiService = LanguageUtils.getText("serviceLabel").toString();
    System.out.println(multiService + " Lấy trong file ra");
    String multiProduct = LanguageUtils.getText("productLabel").toString();
    String multiCustomer = LanguageUtils.getText("customerLabel");
    System.out.println(" Chạy vào khách hàng " + multiCustomer.toString());
    String multiProject = LanguageUtils.getText("projectLabel").toString();
    String multiAbility = LanguageUtils.getText("abilityLabel").toString();
    System.out.println(homepage.toString() + "Đọc gần cuối file");
    
    
    Thread.sleep(2000);
    // Thay đổi tên biến và key tương ứng cho các giá trị khác
    Assert.assertEquals(homepage.getServiceLabelText(), multiService);
    System.out.println(homepage + "Đọc cuối file");
    Assert.assertEquals(homepage.getProductLabelText(), multiProduct);
    Assert.assertEquals(homepage.getCustomerLabelText(), multiCustomer);
    Assert.assertEquals(homepage.getProjectLabelText(), multiProject);
    Assert.assertEquals(homepage.getAbilityLabelText(), multiAbility);

    System.out.println(homepage + "Đã chạy vào hàm test header");
    
}
@AfterClass
public void tearDown() {
	
    languageutils.captureScreenshot("C:\\Users\\Admin\\Desktop\\screenshot200.png");
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	driver.quit();
}
}