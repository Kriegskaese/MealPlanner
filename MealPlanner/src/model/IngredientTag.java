package model;

public class IngredientTag extends Tag {

	public IngredientTag(String name, boolean transferable) {
		super(name,transferable);
		if (this.isTransferable()) {
			correspondingTag = new RecipeTag(name, transferable, this);
		}
	}
	
	public IngredientTag(String name, boolean transferable, RecipeTag correspondingTag) {
		super(name,transferable);
		this.correspondingTag = correspondingTag;
	}

}
