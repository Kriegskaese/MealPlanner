package model;

public class RecipeEntry {

	private int amount;
	private Ingredient ingredient;

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
		return amount * ingredient.getPrice();
	}
	
	public int getEnergy() {
		return amount * ingredient.getEnergy();
	}
	
	public int getProtein() {
		return amount * ingredient.getProtein();
	}
	
	public int getFat() {
		return amount * ingredient.getFat();
	}
	
	public int getCarbs() {
		return amount * ingredient.getCarbs();
	}

}
