package databaseHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Query {
	
	protected Connection connection;

	public Query() {
		String url = "jdbc:mysql://localhost:3306/MealPlanner";
		String username = "root";
		String password = "";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, username, password);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
