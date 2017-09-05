package model;

public class RecipeEntry {

	private float amount;
	private Ingredient ingredient;

	//***************************** Constructor(s) *****************************

	public RecipeEntry(float amount, Ingredient ingredient) {
		this.amount = amount;
		this.ingredient = ingredient;
	}

	//************************ Getter(s) and Setter(s) *************************

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

}
