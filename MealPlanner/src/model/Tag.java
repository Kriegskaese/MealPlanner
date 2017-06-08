package model;

public abstract class Tag {

	protected String name;
	protected boolean transferable;
	protected Tag correspondingTag;
	
	public Tag(String name, boolean transferable) {
		this.name = name;
		this.transferable = transferable;
	}
	
	public boolean isTransferable() {
		return transferable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Tag getCorrespondingTag() {
		return correspondingTag;
	}

	
}
