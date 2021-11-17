package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.Driver;

public class EditCarPage {
    private By yearInput = By.id("year");
    private By makeSelect = By.id("make");
    private By modelInput = By.id("model");
    private By colorInput = By.id("color");
    private By imageInput = By.id("image");
    private By updateCarButton = By.tagName("button");

    public void goToPage(int stockNumber) {
        Driver.getDriver().get("http://dealerlot.tk/edit/" + stockNumber);
    }

    public void enterYear(int year) {
        Driver.getDriver().findElement(yearInput).clear();
        Driver.getDriver().findElement(yearInput).sendKeys(year + "");
    }

    public void enterModel(String model) {
        Driver.getDriver().findElement(modelInput).clear();
        Driver.getDriver().findElement(modelInput).sendKeys(model);
    }

    public void enterColor(String color) {
        Driver.getDriver().findElement(colorInput).clear();
        Driver.getDriver().findElement(colorInput).sendKeys(color);
    }

    public void enterImage(String image) {
        Driver.getDriver().findElement(imageInput).clear();
        Driver.getDriver().findElement(imageInput).sendKeys(image);
    }

    public void selectMake(String make) {
        WebElement selectEl = Driver.getDriver().findElement(makeSelect);
        Select makeSelect = new Select(selectEl);
        switch (make.toLowerCase()) {
            case "audi":
                makeSelect.selectByVisibleText("Audi");
                break;
            case "bmw":
                makeSelect.selectByVisibleText("BMW");
                break;
            case "toyota":
                makeSelect.selectByVisibleText("Toyota");
                break;
            default:
//			throw new IllegalArgumentException("Make you requested is not existing in dropdown.");
                break;
        }
    }

    public void clickUpdateCarButton() {
        Driver.getDriver().findElement(updateCarButton).click();
    }
}
