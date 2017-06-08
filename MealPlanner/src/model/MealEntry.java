package model;

public class MealEntry {
	
	private int amount;
	private Food food;
	
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
	
	public double getPrice() {
		return amount * food.getPrice();
	}
	
	public double getEnergy() {
		return amount * food.getEnergy();
	}
	
	public int getProtein() {
		return amount * food.getProtein();
	}
	
	public int getFat() {
		return amount * food.getFat();
	}
	
	public int getCarbs() {
		return amount * food.getCarbs();
	}

}
