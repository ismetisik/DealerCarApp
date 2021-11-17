package pages;


import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static common.Driver.getDriver;


public class HomePage {
    private By stocklocater = By.id("stockNumber");

    public int getNumberOfCarsOnPage()
    {
        List<WebElement> stockElementList = getDriver().findElements(stocklocater);
        int count = stockElementList.size();
        return count;
    }
    public void goToPage(){
        Driver.getDriver().get("http://dealerlot.tk/");
    }

    public void deleteCar(int stockNumber) {
        By deleteButton = By.xpath("//a[@href='/delete/" + stockNumber + "']");
        Driver.getDriver().findElement(deleteButton).click();
    }

}
