package model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Ingredient_AddPropertyName {

	@Test
	public void addTwoPropertyNames() {
		Ingredient ingredient = new Ingredient(1);
		ingredient.addPropertyName("Protein");
		ingredient.addPropertyName("Calcium");

		boolean result = false;

		if (ingredient.getpropertyNames().contains("Protein") && ingredient.getpropertyNames().contains("Calcium")) {
			result = true;
		}

		assertTrue(result);
	}

}
