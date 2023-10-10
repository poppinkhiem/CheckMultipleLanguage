package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class LanguageUtils {
    private static Properties properties = new Properties();

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
            System.out.println("Đang đọc file lần 2: " + language);
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
}