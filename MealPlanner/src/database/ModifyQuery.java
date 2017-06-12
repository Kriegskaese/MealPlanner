package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyQuery extends Query {

	public ModifyQuery(String tableName, String fieldName, String newValue, int id) {
		super();
		doModify(tableName, fieldName, newValue, id);
	}

	public void doModify(String tableName, String fieldName, String newValue, int id) {
		String query = "UPDATE " + tableName + " set ?=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fieldName);
			preparedStatement.setString(2, newValue);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
