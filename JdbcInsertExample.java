package com.JDBC;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection; // you forgot to import this too

public class JdbcInsertExample {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch55", "root", "Josh@1511");
			Statement st1 = c.createStatement();
			int i = st1.executeUpdate("insert into students values(4,'Raju',87)");
			if (i > 0) {
				System.out.println(i + " rows affected");
			} else {
				System.out.println("Something went wrong!");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}