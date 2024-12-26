public class Alcohol extends Beverage{
	private boolean isWeekend;
    private final double weekendOfferPrice = 0.6;
    
    public Alcohol(String name, Size size, boolean isWeekend) {
        super(name, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
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
    	if (isWeekend) {
    	price += weekendOfferPrice;
    	}
    	return price;
    	}
    
    public boolean isWeekend() {
    	return isWeekend;
    	}
    	
    public double getWeekendFee() {
    	return weekendOfferPrice;
    	}
    @Override
    public String toString() {
            return super.toString() + ", Weekend Offer: " + isWeekend + ", $" + calcPrice();
    }
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        if (!super.equals(anotherBev)) return false;
        Alcohol alcohol = (Alcohol) anotherBev;
        return isWeekend == alcohol.isWeekend;
    }
}

