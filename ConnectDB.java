//package com.JDBC;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class ConnectDB {
//	public Connection getConnection() {
//		try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch55", "root", "Josh@1511");
//	}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		return con;
//	
//}
//}
package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public Connection getConnection() {
        Connection con = null;  // Declare outside the try block
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch55", "root", "Josh@1511");
        } catch (Exception e) {
            System.out.println("Connection error: " + e);
        }
        return con;
    }
}

