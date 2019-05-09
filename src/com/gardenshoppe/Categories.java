package com.gardenshoppe;

public enum Categories {

	
	PLANTS, SEEDS, CONTAINERS, DECOR, TOOLS, LANDSCAPPING;
	
	public String toString() {
		switch (this) {
		case PLANTS:
			return "Plants";
		case SEEDS:
			return "Seeds";
		case CONTAINERS:
			return "Containers";
		case DECOR:
			return "Decor";
		case TOOLS:
			return "Tools";
		default:
			return "Landscapping";
		}		
	}
	
	
	
}
