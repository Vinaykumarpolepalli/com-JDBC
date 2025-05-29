package com.JDBC;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public class JdbcInsertExample {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch55", "root", "Josh@1511");
			Statement st1 = con.createStatement();
			int i = st1.executeUpdate("insert into students values(5,'ramesh',43)");
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
