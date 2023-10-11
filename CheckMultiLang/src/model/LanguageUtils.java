package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import pages.HomePage;
import test.TestMultiLang;

public class LanguageUtils {
private static Properties properties = new Properties();
private WebDriver driver;
public LanguageUtils(WebDriver driver) {
	this.driver = driver;
}



public static void loadLanguage(String language) {
    System.out.println("Đang đọc file " + language);
    try {
        FileInputStream fileInput;
        if (language.equals("en")) {
            fileInput = new FileInputStream("C:\\Users\\Admin\\Desktop\\Multilang\\en.properties");
        } else {
            fileInput = new FileInputStream("C:\\Users\\Admin\\Desktop\\Multilang\\" + language + ".properties");
        }
        Thread.sleep(5000);
     // System.out.println("Đang đọc file lần 2: " + language); Log ra xem có chạy vào hàm này không?
        properties.load(new InputStreamReader(fileInput, StandardCharsets.UTF_8));
        Thread.sleep(1000);
        fileInput.close();
        } catch (IOException e) {
        System.err.println("Không thể đọc file " + language);
        e.printStackTrace();
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        }
public static String getText(String key) {
    if (properties != null) {
        return properties.getProperty(key);
    } else {
        System.err.println("Thuộc tính 'properties' chưa được khởi tạo.");
        return null;
  }
}



    public void captureScreenshot( String filePath) {
   
        // Kiểm tra xem driver có hỗ trợ việc chụp màn hình không
        if (driver instanceof TakesScreenshot) {
            // Chuyển đổi driver thành TakesScreenshot
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

            // Chụp màn hình và lưu ảnh vào file
            File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotFile, new File(filePath));
                System.out.println("Chụp màn hình thành công!");
            } catch (IOException e) {
                System.err.println("Lỗi khi lưu ảnh chụp màn hình: " + e.getMessage());
            }
        } else {
            System.err.println("Driver không hỗ trợ chụp màn hình!");
        
    }
    }
}