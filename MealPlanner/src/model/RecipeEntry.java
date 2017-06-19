package model;

public class RecipeEntry {

	private int amount;
	private Ingredient ingredient;

	public RecipeEntry(int amount, Ingredient ingredient) {
		this.amount = amount;
		this.ingredient = ingredient;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

}
