package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCarPage;
import pages.EditCarPage;
import pages.HomePage;
import utils.DbUtil;

//compare the number of cars
public class driverTest {

    @Test
    public void verifyNumberOfCarsONPageNUmberOfCarsInDatabase(){
        HomePage homePage=new HomePage();
        homePage = new HomePage();
        homePage.goToPage();
        int numberOfCarsOnPage = homePage.getNumberOfCarsOnPage();
        numberOfCarsOnPage = 20;
        System.out.println("There are" + numberOfCarsOnPage + "cars on Webpage");
        int numberOfCarsInDb = DbUtil.getNumberOfCarsFromDb();
        System.out.println("There are" + numberOfCarsOnPage + "on HomePage");
        Assert.assertEquals(numberOfCarsInDb,numberOfCarsOnPage);
    }
    @Test
    public void verifyAddingNewCarCreatedNewRowofNewCarInDatabase(){
        AddCarPage addCarPage = new AddCarPage();
        addCarPage.goToPage();
        addCarPage.enterYear(2019);
        addCarPage.enterModel("Porche");
        addCarPage.selectMake("911");
        addCarPage.enterStock(889);
        addCarPage.enterImage("https://www.google.com/imgres?imgurl=https%3A%2F%2Fd6bcb2297ed864a11336-6ec5b0b1e395d0d1f7279be93d5a3bd6.ssl.cf1.rackcdn.com%2FWP0AB2A93KS115576%2Fbe4f49355af088b0cf2e33a988b598d4.jpg&imgrefurl=https%3A%2F%2Fwww.rusnakpasadenaporsche.com%2Finventory%2Fnew-2019-porsche-911-carrera-4-gts-awd-2d-coupe-wp0ab2a93ks115576&tbnid=97q7dZNEx3kZ8M&vet=12ahUKEwisg-O6gN7lAhVGiqwKHSObAd8QMygEegUIARCRAg..i&docid=nVewKb-0JKe3bM&w=1536&h=1021&q=porsche%20911&hl=en&authuser=0&safe=active&ved=2ahUKEwisg-O6gN7lAhVGiqwKHSObAd8QMygEegUIARCRAg");
        addCarPage.enterColor("White");
        AddCarPage.clickAddCarButton();
        boolean result =DbUtil.doesStockExistInDb(889);
        Assert.assertTrue(result);
    }

    @Test
    public void verifyDeletingACarRemovesCarFromDatabase(){
        HomePage homePage = new HomePage();
        homePage.goToPage();
        homePage.deleteCar(888);
        boolean result = DbUtil.doesStockExistInDb(888);
        Assert.assertFalse(result);
    }
    @Test
    public void verifyEditingCarModel() {
        EditCarPage editCarPage = new EditCarPage();
        editCarPage.goToPage(16);
        String newModelName = "Sportage";
        editCarPage.enterModel(newModelName);
        editCarPage.clickUpdateCarButton();
        String modelNameInDb = DbUtil.getModelNameForCar(16);
        Assert.assertEquals(modelNameInDb, newModelName);
    }
}


