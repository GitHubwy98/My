package vo;


import com.mysql.cj.jdbc.Driver;


import java.sql.*;
import java.util.Arrays;
import java.util.Collections;


public  class Wy_1 {
      

    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my?serverTimezone=UTC","root","123456");

            Statement statement = connection.createStatement();
            statement.executeUpdate("update  od set  NAME = '3333'");
            ResultSet resultSet = statement.executeQuery("select * from od;");



            while (resultSet.next()){
                String string = resultSet.getString(1);
                System.out.println(string);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    void ss(){
        System.out.println("基本数据类型");
        int a=5;
        int b=a;
        a=10;
        System.out.println("a----------"+a);
        System.out.println("a----------"+b);

        System.out.println("***************************");

        System.out.println("引用数据类型");
        int [] arr = {20,30,40};
        int [] arr1=arr;
        arr[0]=60;
        System.out.println("arr------------"+Arrays.toString(arr));
        System.out.println("arr1-------------"+Arrays.toString(arr1));

    }
}
