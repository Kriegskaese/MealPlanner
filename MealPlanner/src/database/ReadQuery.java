package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadQuery extends Query {

	private ResultSet resultSet;

	public ReadQuery(String tableName) {
		super();
		issueReadQuery(tableName);
	}

	public void issueReadQuery(String tableName) {
		String query = "Select * from " + tableName;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

}
