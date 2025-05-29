package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Preparedstatement {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch55", "root", "Josh@1511");
			//Statement
			//Statement st1 = con.createStatement();
			// int i = st1.executeUpdate("insert into students values(5,'ramesh',43)");
			PreparedStatement ps = con.prepareStatement("insert into students values (?,?,?)");
			ps.setInt(1,6);
			ps.setString(2,"ranjith");
			ps.setInt(3, 100);
			int i =ps.executeUpdate();
			if (i > 0) {
				System.out.println(i + ": rows affected");
			} else {
				System.out.println("Something went wrong!");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
