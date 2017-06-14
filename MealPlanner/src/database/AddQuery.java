package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddQuery extends Query {

	public AddQuery(String tableName, int newId) {
		super();
		issueAddQuery(tableName, newId);
	}

	public void issueAddQuery(String tableName, int newId) {
		String query = "INSERT INTO " + tableName + " (id) VALUES (?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, newId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
