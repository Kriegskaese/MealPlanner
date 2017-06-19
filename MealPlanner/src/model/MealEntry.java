package model;

public class MealEntry {

	private int amount;
	private Food food;

	public MealEntry() {}

	public MealEntry(int amount, Food food) {
		this.amount = amount;
		this.food = food;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

}
