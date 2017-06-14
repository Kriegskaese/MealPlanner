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
		return amount * food.getPriceInCentsPer100();
	}
	
	public double getEnergy() {
		return amount * food.getEnergyPer100();
	}
	
	public int getProtein() {
		return amount * food.getProteinPer100();
	}
	
	public int getFat() {
		return amount * food.getFatPer100();
	}
	
	public int getCarbs() {
		return amount * food.getCarbsPer100();
	}

}
