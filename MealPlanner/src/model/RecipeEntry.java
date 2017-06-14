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

	public int getPrice() {
		return amount * ingredient.getPriceInCentsPer100();
	}

	public int getEnergy() {
		return amount * ingredient.getEnergyPer100();
	}

	public int getProtein() {
		return amount * ingredient.getProteinPer100();
	}

	public int getFat() {
		return amount * ingredient.getFatPer100();
	}

	public int getCarbs() {
		return amount * ingredient.getCarbsPer100();
	}

}
