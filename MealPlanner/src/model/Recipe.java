package model;

import java.util.List;

public class Recipe extends Food {

	private List<RecipeTag> tags;
	private List<RecipeEntry> entries;
	private boolean useManualPriceValue = false;
	private boolean useManualEnergyValue = false;
	private boolean useManualProteinValue = false;
	private boolean useManualFatValue = false;
	private boolean useManualCarbsValue = false;

	public void addTag(RecipeTag tag) {
		tags.add(tag);
	}

	public void removeTag(RecipeTag tag) {
		tags.remove(tag);
	}

	public void addEntry(RecipeEntry entry) {
		entries.add(entry);
	}

	public void removeEntry(RecipeEntry entry) {
		entries.remove(entry);
	}

	@Override
	public int getPrice() {
		if (useManualPriceValue) {
			return getPrice();
		} else {
			return calculatePriceFromEntries();
		}
	}

	@Override
	public int getEnergy() {
		if (useManualEnergyValue) {
			return getEnergy();
		} else {
			return calculateEnergyFromEntries();
		}
	}

	@Override
	public int getProtein() {
		if (useManualProteinValue) {
			return getProtein();
		} else {
			return calculateProteinFromEntries();
		}
	}

	@Override
	public int getFat() {
		if (useManualFatValue) {
			return getFat();
		} else {
			return calculateFatFromEntries();
		}
	}

	@Override
	public int getCarbs() {
		if (useManualCarbsValue) {
			return getCarbs();
		} else {
			return calculateCarbsFromEntries();
		}
	}

	private int calculatePriceFromEntries() {
		int sum = 0;
		for (RecipeEntry entry : entries) {
			sum += entry.getPrice();
		}
		return sum;
	}

	private int calculateEnergyFromEntries() {
		int sum = 0;
		for (RecipeEntry entry : entries) {
			sum += entry.getEnergy();
		}
		return sum;
	}

	private int calculateProteinFromEntries() {
		int sum = 0;
		for (RecipeEntry entry : entries) {
			sum += entry.getProtein();
		}
		return sum;
	}

	private int calculateFatFromEntries() {
		int sum = 0;
		for (RecipeEntry entry : entries) {
			sum += entry.getFat();
		}
		return sum;
	}

	private int calculateCarbsFromEntries() {
		int sum = 0;
		for (RecipeEntry entry : entries) {
			sum += entry.getCarbs();
		}
		return sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
