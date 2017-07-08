package model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Ingredient_AddPropertyName {

	@Test
	public void addTwoPropertyNames() {
		Ingredient ingredient = new Ingredient(1);

		ingredient.addPropertyName("Protein");
		ingredient.addPropertyName("Calcium");

		assertTrue(propertyNamesContains(ingredient, "Protein") && propertyNamesContains(ingredient, "Calcium"));
	}

	private boolean propertyNamesContains(Ingredient ingredient, String string) {
		return ingredient.getpropertyNames().contains(string);
	}

}
