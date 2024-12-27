import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ValidInputs {

    WebDriver driver;

    // Open Webpage using Before Method
    @BeforeMethod
    public void openWebPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the web page
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(3000);
    }

    @Test
    public void correctInputs() throws InterruptedException {

        // 1) First Name Field
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Pasan" );

        // 2) Last Name Field
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Pethangoda");

        // 3) User Email Field
        WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmail.sendKeys("pasanpethangoda@gmail.com");

        // 4) Gender Radio Button
        WebElement gender = driver.findElement(By.xpath("//*[@id='genterWrapper']/div[2]/div[1]/label"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gender);
        gender.click();

        // 5) Mobile Number Field
        WebElement userNumber = driver.findElement(By.xpath("//input[@id='userNumber']"));
        userNumber.sendKeys("0771775431");

        // 6) Date of Birth Field
        WebElement dateInput = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        dateInput.click();

        // 6.1 - Select the month dropdown
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText("March");

        // 6.2 - Select the year dropdown
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText("2000");

        // 6.3 - Click the Date
        WebElement day = driver.findElement(By.xpath("//div[@aria-label='Choose Monday, March 20th, 2000']"));
        day.click();
        Thread.sleep(1000);

        // 7) Subjects Filed
        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subjects);
        subjects.sendKeys("Computer Science");

        WebElement firstItem = driver.findElement(By.id("react-select-2-option-0"));
        firstItem.click();

        // 8) Hobbies Check Box
        List<WebElement> checkboxList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (WebElement element : checkboxList){
            if (!(element.getText().equals("Music"))){
                element.click();
            }
        }

        // 9) Upload Picture
        WebElement uploadPicture = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
        String filePath = "C://Users//ASUS//Downloads//user.jpg";  // This is my own file path. Please add your file path properly
        uploadPicture.sendKeys(filePath);

        // 10) Current Address
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("47/2 Fisrt Lane, Maukuluwa, Galle");


        // 11) Select State Dropdown
        WebElement state = driver.findElement(By.xpath("//div[@id='state']"));
        state.click();
        WebElement stateOption = driver.findElement(By.id("react-select-3-option-0"));
        stateOption.click(); // Click the State
        Thread.sleep(1000);

        // 12) Select City Dropdown
        WebElement city = driver.findElement(By.xpath("//div[@id='city']"));
        city.click();
        Thread.sleep(1000);
        WebElement cityOption = driver.findElement(By.id("react-select-4-option-0"));
        cityOption.click();

        // 13) Click the Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(1000);

        driver.quit();

    }
}
