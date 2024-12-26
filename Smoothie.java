
public class Smoothie extends Beverage {
	private int numOfFruits;
	private boolean proteinPowder;
	private final double FRUIT_COST = .5;
	private final double PROTEIN_COST = 1.5;
	
	public Smoothie(String name, Size size, int numFruits, boolean proteinPowder) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numFruits;
        this.proteinPowder = proteinPowder;
    }

	@Override
	public double calcPrice() {
		double price = super.getBasePrice();
		if (super.getSize() == Size.MEDIUM) {
		price += super.getSizePrice();
		}
		else if (super.getSize() == Size.LARGE) {
		price += 2 * super.getSizePrice();
		}

		price += numOfFruits * FRUIT_COST;
		if (proteinPowder) {
		price += PROTEIN_COST;
		}
		return price;
		}
	@Override
	public String toString() {
        return super.toString() + ", Number of fruits: " + numOfFruits + ", Protein Powder: " + proteinPowder + ", $" + calcPrice();
    }
	
	@Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false; 
        if (!super.equals(anotherBev)) return false;
        Smoothie smoothie = (Smoothie) anotherBev;
        return numOfFruits == smoothie.numOfFruits && proteinPowder == smoothie.proteinPowder;
    }
	
	public int getNumOfFruits() {
        return numOfFruits;
    }
	
    public boolean getAddProtein() {
        return proteinPowder;
    }
    
    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }
    
    public void setAddProtein(boolean addProtein) {
        this.proteinPowder = addProtein;
    }
}
