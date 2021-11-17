package pages;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AddCarPage {

    private By yearInput = By.id("year");
    private By makeSelect = By.id("make");
    private By modelInput = By.id("model");
    private By colorInput = By.id("color");
    private By stockInput = By.id("stock");
    private By imageInput = By.id("image");

    public static void clickAddCarButton() {
    }


    public void goToPage() {
        Driver.getDriver().get("http://dealerlot.tk/add");
    }

    public void enterYear(int year) {
        Driver.getDriver().findElement(yearInput).sendKeys(year + "");
    }

    public void enterModel(String model) {
        Driver.getDriver().findElement(modelInput).sendKeys(model);
    }

    public void enterColor(String color) {
        Driver.getDriver().findElement(colorInput).sendKeys(color);
    }

    public void enterStock(int stock) {
        Driver.getDriver().findElement(imageInput).sendKeys(stock + "");
    }

    public void enterImage(String image) {
        Driver.getDriver().findElement(modelInput).sendKeys(image);
    }

    public void selectMake(String make) {

        WebElement selectEl = Driver.getDriver().findElement(makeSelect);
        Select makeSelect = new Select(selectEl);

        switch (make.toLowerCase()) {
            case "audi":
                //        makeSelect.selectByValue("Audi");
                makeSelect.selectByVisibleText("Audi");
                break;
            case "bmw":
                //       makeSelect.selectByValue("BMW");
                makeSelect.selectByVisibleText("BMW");
                break;
            case "toyota":
                //        makeSelect.selectByValue("Toyota");
                makeSelect.selectByVisibleText("BMW");
                break;
            default:
//			throw new IllegalArgumentException("Make you requested is not existing in dropdown.");
                break;
        }
    }
}