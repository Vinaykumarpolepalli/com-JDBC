package com.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentData1 implements StudentDataInterface {
	private String status = "fail";
	ConnectDB c;

	public String insert() {

		try {

			ConnectDB c = new ConnectDB();
			Connection con = c.getConnection();

			
			PreparedStatement ps = con.prepareStatement("insert into students(studentname,marks) values (?,?)");
			// ps.setInt(1,8);
			ps.setString(1, "srikanth");
			ps.setInt(2, 94);
			int i = ps.executeUpdate();

			if (i > 0)
				status = "success";

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public void selectAllStudent() {
		try {
			ConnectDB c = new ConnectDB();
			Connection con = c.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from students");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getInt(3));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void selectstudentbyId(int id) {
		try {
			ConnectDB c = new ConnectDB();
			Connection con = c.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from students where id= ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getInt(3));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void updateAllStudent() {
		try {

			ConnectDB c = new ConnectDB();
			Connection con = c.getConnection();

			PreparedStatement ps = con.prepareStatement("update students set marks = ?");
			ps.setInt(1, 100);
			int i = ps.executeUpdate();

			if (i > 0)
				// status ="success";
				System.out.println(i + "row Affected");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void updateStudentById(int id,int marks) {
		try {

			ConnectDB c = new ConnectDB();
			Connection con = c.getConnection();

			PreparedStatement ps = con.prepareStatement("update students set marks = ? where id =?");
			ps.setInt(1, marks );
			ps.setInt(2, id);
			int i = ps.executeUpdate();

			if (i > 0)
				// status ="success";
				System.out.println(i + "row Affected");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	

}
