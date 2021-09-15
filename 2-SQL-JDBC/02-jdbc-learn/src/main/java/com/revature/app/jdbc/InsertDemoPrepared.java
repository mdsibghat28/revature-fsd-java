package com.revature.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemoPrepared {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learndb", "root", "Kanewilliamson");
			
			String sql = "insert into department (name) values (?)";
			PreparedStatement statement  = connection.prepareStatement(sql);
			statement.setString(1, "Research");
			statement.executeUpdate();
			statement.setString(1, "Design");
			statement.executeUpdate();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
