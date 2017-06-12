package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WriteQuery extends Query {

	public WriteQuery(String tableName, int id) {
		super();
		doDelete(tableName, id);
	}

	public void doDelete(String tableName, int id) {
		String query = "DELETE from " + tableName + " WHERE name = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
