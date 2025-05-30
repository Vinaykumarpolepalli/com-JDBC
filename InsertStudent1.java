package com.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertStudent1 {
	private String status ="fail";
	public String  insert () {

		try {
			
			ConnectDB c = new ConnectDB();
			Connection con = c.getConnection();
			
			//Statement
			//Statement st1 = con.createStatement();
			// int i = st1.executeUpdate("insert into students values(5,'ramesh',43)");
			PreparedStatement ps = con.prepareStatement("insert into students(studentname,marks) values (?,?)");
			//ps.setInt(1,8);
			ps.setString(1,"srikanth");
			ps.setInt(2, 94);
			int i =ps.executeUpdate();
			
			
			if (i > 0)
				status ="success";
				//System.out.println(i + "  : rows affected");
//			} else {
//				System.out.println("Something went wrong!");
//			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
		public void selectAllStudent() {
			try {
			ConnectDB  c = new ConnectDB();
			Connection con = c.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from students");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getInt(3));
			}
			
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		public void selectByid(int i) {
			try {
				ConnectDB  c = new ConnectDB();
				Connection con = c.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from students where id= ?");
				ps.setInt(1,i);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getInt(3));
				}
				
				}catch (Exception e) {
					System.out.println(e);
				}
			}
		
	

}
