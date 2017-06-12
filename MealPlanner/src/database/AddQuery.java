package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddQuery extends Query {

	public AddQuery(String tableName, int newID) {
		super();
		doAdd(tableName, newID);
	}

	public void doAdd(String tableName, int newID) {
		String query = "INSERT INTO " + tableName + " (id) VALUES (?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, newID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
