package com.mycompany.scdproject;

// This code is for establishing connection with MySQL
// database and retrieving data
// from db Java Database connectivity

/*
*1. import --->java.sql
*2. load and register the driver ---> com.jdbc.
*3. create connection
*4. create a statement
*5. execute the query
*6. process the results
*7. close
*/
import java.sql.*;

class SCDProject {
    static String url="jdbc:mysql://jsmartfix.com:3306/jsmartfix_SCD";
    static String dbusername = "jsmartfix_SCD"; // MySQL credentials
    static String dbpassword = "Scdfuckyou101";
    
	public static void main(String[] args) throws Exception
	{
		//String url
		//	= "jdbc:mysql://jsmartfix.com:3306/jsmartfix_SCD"; // table details
		//String username = "jsmartfix_SCD"; // MySQL credentials
		//String password = "Scdfuckyou101";
		 // query to be run
		//Class.forName(
		//	"com.mysql.cj.jdbc.Driver"); // Driver name
            try (Connection con = DriverManager.getConnection(url, dbusername, dbpassword); Statement st = con.createStatement();) 
            {
                String query= "select *from users";
                System.out.println("Connection Established successfully");
                //Statement st = con.createStatement();
                ResultSet rs= st.executeQuery(query); // Execute query
                rs.next();
                String name= rs.getString("username"); // Retrieve name from db

                System.out.println(name); // Print result on console
                con.close(); // close connection
                System.out.println("Connection Closed....");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
                
	}
}
