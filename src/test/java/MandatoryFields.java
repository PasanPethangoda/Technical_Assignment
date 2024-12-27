import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MandatoryFields {

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
    public void checkMandatoryFields() throws InterruptedException {
        // 1) Check the Empty First Name Field
        WebElement firstname = driver.findElement(By.id("firstName"));
        firstname.sendKeys("");
        if (firstname.getAttribute("value").isEmpty()) {
            System.out.println("First Name field is empty!");
        } else {
            System.out.println("First Name field has value:");
        }

        // 2) Check the Empty Last Name Field
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("");
        if (lastName.getAttribute("value").isEmpty()) {
            System.out.println("Last Name field is empty!");
        } else {
            System.out.println("Last Name field has value");
        }

        // 3) User Email Field
        WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmail.sendKeys("pasanpethangoda@gmail.com");

        // 4) Verify if the Gender Radio Button is selected
        WebElement genderRadioButton = driver.findElement(By.xpath("//*[@id='gender-radio-1']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderRadioButton);
        if (!genderRadioButton.isSelected()) {
            System.out.println("Gender has not been selected!");
        } else {
            System.out.println("Gender is selected.");
        }

        // 5) Check the Empty Mobile Number Field
        WebElement userNumber = driver.findElement(By.xpath("//input[@id='userNumber']"));
        userNumber.sendKeys("");
        if (userNumber.getAttribute("value").isEmpty()) {
            System.out.println("Mobile Number field is empty!");
        } else {
            System.out.println("Mobile Number field has value:");
        }


        // 6) Date of Birth Field
        WebElement dateInput = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        dateInput.click();

        WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText("March");

        WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText("2000");

        WebElement day = driver.findElement(By.xpath("//div[@aria-label='Choose Monday, March 20th, 2000']"));
        day.click();

        // 7) Subjects Field
        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subjects);
        subjects.sendKeys("Computer Science");

        WebElement firstItem = driver.findElement(By.id("react-select-2-option-0"));
        firstItem.click();

        // 8) Hobbies Check Box
        List<WebElement> checkboxList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (WebElement element : checkboxList) {
            if (!(element.getText().equals("Music"))) {
                element.click();
            }
        }

        // 9) Upload Picture
        WebElement uploadPicture = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
        String filePath = "C://Users//ASUS//Downloads//user.jpg";  // This is my own file path
        uploadPicture.sendKeys(filePath);

        // 10) Current Address
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("47/2 First Lane, Maukuluwa, Galle");

        // 11) Select State Dropdown
        WebElement state = driver.findElement(By.xpath("//div[@id='state']"));
        state.click();
        WebElement stateOption = driver.findElement(By.id("react-select-3-option-0"));
        stateOption.click();

        // 12) Select City Dropdown
        WebElement city = driver.findElement(By.xpath("//div[@id='city']"));
        city.click();
        WebElement cityOption = driver.findElement(By.id("react-select-4-option-0"));
        cityOption.click();

        // 13) Click the Submit Button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(1000);
        driver.quit();
    }
}
