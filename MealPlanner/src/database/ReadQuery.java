package databaseHelpers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadQuery extends Query {

	private ResultSet resultSet;

	public ReadQuery() {
		super();
		doRead();
	}

	public void doRead() {
		String query = "Select * from Ingredients";
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
