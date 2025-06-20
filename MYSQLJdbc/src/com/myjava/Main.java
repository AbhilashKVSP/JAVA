package com.myjava;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
            CityDAO city = new CityDAO();

            // Fetching data from a Query
            city.connection();
            HashMap<Integer,String> dataRow = city.getLikeCity("Santa Cruz%");
            for(Map.Entry<Integer,String> row : dataRow.entrySet()){
                System.out.println(row.getKey() + " " + row.getValue());
            }

            // Updating Data from a Query
            city.connection();
            int count = city.changePopulation(98600123);
            System.out.println("Rows affected due to update is : " + count);
    }
}
