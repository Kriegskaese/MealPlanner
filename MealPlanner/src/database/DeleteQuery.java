package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery extends Query {

	public DeleteQuery(String tableName, int id) {
		super();
		issueDeleteQuery(tableName, id);
	}

	public void issueDeleteQuery(String tableName, int id) {
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
