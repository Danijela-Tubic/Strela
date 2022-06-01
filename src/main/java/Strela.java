import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Strela {
    /*Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru, izabrati opciju Lukovi - Bows iz leve
    navigacije, potom kliknuti na luk koji se zove Samick Sage, i onda proveriti da ime tog luka na njegovoj stranici
    zaista sadrži reč Samick.*/
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tubic\\Desktop\\IT BOOTCAMP\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Ulazak na sajt:
        driver.get("http://www.strela.co.rs/");

        //Prodavnica:
        WebElement prodavnica = driver.findElement(By.xpath("//*[contains(text(),'PRODAVNICA')]"));
        prodavnica.click();

        //Lukovi:
        WebElement lukovi = driver.findElement(By.xpath("//*[contains(text(),'Lukovi - Bows')]"));
        lukovi.click();

        //Explicit wait:
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img")));

        //Bow Samick Sage:
        WebElement bowSamickSage = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
        bowSamickSage.click();

        //Bow Samick Sage title:
        String bowSamickSageTitle = driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel")).getText();

        //Da li naslov sadrži u sebi reč "Samick":
        if (bowSamickSageTitle.contains("Samick")) {
            System.out.println("Test: Pass");
        } else {
            System.out.println("Test: Fail");
        }

        //Zatvaranje programa:
        driver.close();

    }
}
