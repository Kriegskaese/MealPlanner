package databaseHelpers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyQuery extends Query {

	public ModifyQuery(String tableName, String fieldName, String newValue, int id) {
		super();
		doModify(tableName, fieldName, newValue, id);
	}

	public void doModify(String tableName, String fieldName, String newValue, int id) {
		String query = "UPDATE ? set ?=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, tableName);
			preparedStatement.setString(2, fieldName);
			preparedStatement.setString(3, newValue);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
