package com.bridgelabz;
import java.sql.*;
import java.util.Scanner;

public class AddressBook_JDBC {
    public static void Read(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbookDB", "root", "Ardent@1");

            Statement smt = connection.createStatement();
            ResultSet result = smt.executeQuery("select * from addressbook;");

            while (result.next()) {
                System.out.println("id :" + result.getInt(1));
                System.out.println("First Name :" + result.getString(2));
                System.out.println("Last name :" + result.getString(3));
                System.out.println("Address :" + result.getString(4));
                System.out.println("City :" + result.getString(5));
                System.out.println("State :" + result.getString(6));
                System.out.println("ZIP :" + result.getString(7));
                System.out.println("Phone Number :" + result.getString(8));
                System.out.println("Email ID :" + result.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Update(){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbookDB", "root", "Ardent@1");

            Scanner sc = new Scanner(System.in);

            System.out.println("Please enter First Name you want to edit");
            String str10 = sc.nextLine();

            System.out.println("Please enter First Name");
            String str1 = sc.nextLine();

            System.out.println("Please enter last Name");
            String str2 = sc.nextLine();

            System.out.println("Please enter address");
            String str3 = sc.nextLine();

            System.out.println("Please enter city");
            String str4 = sc.nextLine();

            System.out.println("Please enter state");
            String str5 = sc.nextLine();

            System.out.println("Please enter email id");
            String str8 = sc.nextLine();

            System.out.println("Please enter Phone number");
            long str7 = sc.nextLong();

            System.out.println("Please enter zip");
            int str6 = sc.nextInt();

            String sql = "UPDATE addressbook SET first_name=?,last_name=?,address=?, city=?, state=?, zip=?,phone_number=?, email=? Where first_name=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, str1);
            pstmt.setString(2, str2);
            pstmt.setString(3,str3);
            pstmt.setString(4, str4);
            pstmt.setString(5, str5);
            pstmt.setInt(6,str6);
            pstmt.setLong(7, str7);
            pstmt.setString(8,str8);
            pstmt.setString(10,str10);

            int affectedRows = pstmt.executeUpdate();
            System.out.println("Data Changed");


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        boolean Stopper = true;

        while (Stopper == true){

            System.out.println("Enter the following details");
            System.out.println("1. Read data");
            System.out.println("2. Update data");
            System.out.println("3. Exit");

            Scanner sc = new Scanner(System.in);
            int inp = sc.nextInt();

            if (inp == 1){
                Read();
            } else if (inp == 2) {

                Update();

            } else if (inp == 3) {
                Stopper = false;
            }

        }

    }
}