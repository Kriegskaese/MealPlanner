package model;

import java.util.Observable;

public abstract class Food extends Observable {

	protected String name;
	protected Rating rating;
	protected int portionSize;
	protected int priceInCentsPer100;
	protected int energyPer100;
	protected int proteinPer100;
	protected int fatPer100;
	protected int carbsPer100;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers();
	}
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public void setPortionSize(int portionSize) {
		this.portionSize = portionSize;
	}

	public Rating getRating() {
		return rating;
	}

	public int getPrice() {
		return priceInCentsPer100;
	}

	public int getEnergy() {
		return energyPer100;
	}

	public int getProtein() {
		return proteinPer100;
	}

	public int getFat() {
		return fatPer100;
	}

	public int getCarbs() {
		return carbsPer100;
	}
	
	public int getProtionSize() {
		return portionSize;
	}

}
