package com.myjava;

import java.sql.*;
import java.util.HashMap;

public class CityDAO {
    Connection con = null;
    PreparedStatement st = null;

    public void connection(){
        String URL = "jdbc:mysql://localhost:3306/world";
        String userName = "sys";
        String password = "admin";

        try {
            // forName helps to load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the Connection
            con = DriverManager.getConnection(URL,userName,password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer,String> getLikeCity(String city) {
        String Query = "select * from world.city where city.Name like ?";
        try{
            st = con.prepareStatement(Query);
            st.setString(1,city);
            ResultSet rs = st.executeQuery();

            // To get results or store initially rs is -1 we need once next to get into line 1
            // We need 2 col ID, Name
            HashMap<Integer,String> dataRow = new HashMap<Integer, String>();
            while(rs.next()){
                dataRow.put(rs.getInt("ID"),rs.getString("Name"));
            };

            // Closing the connection
            st.close();
            con.close();

            return dataRow;

        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }

        return null;
    }

    public int changePopulation(int pop){
        String Query = "UPDATE world.city SET population = ? WHERE ID = 939;";

        try {
            st = con.prepareStatement(Query);
            st.setInt(1,986100);
            int count = st.executeUpdate(); // for update or insert

            // Closing the connection
            st.close();
            con.close();

            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

}
