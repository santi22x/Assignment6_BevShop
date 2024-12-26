public class Coffee extends Beverage{
	private boolean extraShot;
	private boolean extraSyrup;
	private final double SHOT_COST = .5;
	private final double SYRUP_COST = .5;
	
	//constructor
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
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
		if (extraShot) {
		price += SHOT_COST;
		}
		if (extraSyrup) {
		price += SYRUP_COST;
		}
		return price;
		}
	  @Override
	    public String toString() {
	        return super.toString() + ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup + ", $" + calcPrice();
	    }
	  
	  @Override
	  public boolean equals(Object anotherBev) {
	      if (this == anotherBev) return true;
	      if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
	      if (!super.equals(anotherBev)) return false;
	      Coffee coffee = (Coffee) anotherBev;
	      return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
	  }
	  
	  public boolean getExtraShot() {
		  return extraShot;
	  }
	  public boolean getExtraSyrup() {
		  return extraSyrup;
	  }
	  public double getShotCost() {
		  return SHOT_COST;
	  }
	  public double getSyrupCost() {
		  return SYRUP_COST;
		  }
	  
	  public void setExtraShot(boolean shot) {
		  this.extraShot = shot;
		  }
	  
	  public void setExtraSyrup(boolean syrup) {
		  this.extraSyrup = syrup;
		  }

}
