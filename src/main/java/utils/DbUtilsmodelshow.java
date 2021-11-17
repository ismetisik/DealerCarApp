package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbUtilsmodelshow {
    public static List<Models.Car> getAllCarsInDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://95.217.14.25:3306/dealerlot?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
                    , "testuser"
                    , "Password@1");

            Statement statement = conn.createStatement();

            String sampleQuery = "SELECT * FROM cars";
            ResultSet rs = statement.executeQuery(sampleQuery);
            List<Models.Car> carList = new ArrayList<>();
            while (rs.next()) {
                Models.Car car = new Models.Car(rs.getInt("Year")
                        , rs.getString("make")
                        , rs.getString("model")
                        , rs.getString("color")
                        , rs.getString("image"));
                carList.add(car);
            }
            return carList;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int getNumberOfCarsFromDb(){
        return getAllCarsInDb().size();
    }

    public static boolean doesStockExistInDb(int stockNumber) {
        List<Models.Car> carList = getAllCarsInDb();
        for(Models.Car car : carList){
            if (car.stock==stockNumber){
                return true;
            }
        }
        return false;
    }
    public static String getModelNameForCar(int stockNumber) {
        List<Models.Car> carList = getAllCarsInDb();
        String modelNameInDb = "";
        for (Models.Car car : carList) {
            if (car.stock == stockNumber) {
                modelNameInDb = car.model;
                break;
            }
        }
        return modelNameInDb;
    }
}

    /*
    public static void main(String[] args) {
        getNumberOfCarsFromDb();
    }

    public static int getNumberOfCarsFromDb() {
   try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://95.217.14.25:3306/dealerlot?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
                , "testuser"
                , "Password@1");
        Statement statement = conn.createStatement();
        String sampleQuery = "SELECT * FROM cars";
        ResultSet rs = statement.executeQuery(sampleQuery);

                while (rs.next()){
                    System.out.println(rs.getString("model"));
                }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
return 0;
    }
    public static String getModelNameByStockNumber(int stockNumber){
        return null;
    }
}


*/
