package model;

public class RecipeTag extends Tag {

	public RecipeTag(String name, boolean transferable) {
		super(name,transferable);
		if (this.isTransferable()) {
			correspondingTag = new IngredientTag(name, transferable, this);
		}
	}
	
	public RecipeTag(String name, boolean transferable, IngredientTag correspondingTag) {
		super(name,transferable);
		this.correspondingTag = correspondingTag;
	}

}
