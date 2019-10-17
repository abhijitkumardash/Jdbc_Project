package org.oar.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String qry = "delete from oar.student  where id=5";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded And Registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
			System.out.println("Connection Established With DB Server");
			stmt = con.createStatement();
			System.out.println("Platform Created");
			stmt.executeUpdate(qry);
			System.out.println("Data Deleted!!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Costly Resource Closed ");
		}

	}
}
