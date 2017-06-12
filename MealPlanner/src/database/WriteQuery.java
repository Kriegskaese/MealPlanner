package databaseHelpers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WriteQuery extends Query {

	public WriteQuery(String tableName, String foodName) {
		super();
		doDelete(tableName, foodName);
	}

	public void doDelete(String tableName, String foodName) {
		String query = "DELETE from ? WHERE name = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, tableName);
			preparedStatement.setString(2, foodName);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
