package databaseHelpers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddQuery extends Query {
	
	public AddQuery(String tableName, int newID) {
		super();
		doAdd(tableName, newID);
	}

	public void doAdd(String tableName, int newID) {
		String query = "INSERT INTO ? (id) VALUES (?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, tableName);
			preparedStatement.setInt(2, newID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
