package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import database.AddQuery;
import database.ReadQuery;

public class Ingredient extends Food {

	private static int currentId;
	private List<IngredientTag> tags;

	public Ingredient() {
		properties.add(new FoodProperty("id", new Integer(currentId)));
		new AddQuery("ingredients", currentId);
		currentId++;
	}

	public Ingredient(int id) {
		properties.add(new FoodProperty("id", new Integer(id)));
	}

	public List<IngredientTag> getTags() {
		return tags;
	}

	public void addTag(IngredientTag tag) {
		tags.add(tag);
		setChanged();
		notifyObservers();
	}

	public void removeTag(IngredientTag tag) {
		tags.remove(tag);
		setChanged();
		notifyObservers();
	}

	public static void initializeId() {
		// get all the ingredients from the database
		ResultSet resultSet = new ReadQuery("ingredients").getResultSet();

		// find the highest id
		int highestId = 0;
		try {
			while (resultSet.next()) {
				if (resultSet.getInt(1) > highestId) {
					highestId = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// increment highest id by one
		currentId = highestId + 1;
	}

}
