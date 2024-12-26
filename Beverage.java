/*
 * Class: CMSC203 
 * Instructor: Kjit
 * Description: (Assignment 6 Beverage SHop)
 * Platform/compiler:
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Santiago Ardila
*/



public abstract class Beverage {
	private String bevName;
    private Type type;
    private Size size;
    public final double basePrice = 2.0;
    private final double sizePrice = 0.5;
    
    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }
    
    public double getBasePrice() {
        return basePrice;
    }
    
    public String getBevName() {
        return bevName;
    }
    public Type getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }
    public double getSizePrice() {
    	return sizePrice;
    }
    
    public void setBevName(String bevName) {
        this.bevName = bevName;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    
        
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        Beverage beverage = (Beverage) anotherBev;
        return bevName.equals(beverage.bevName) && type == beverage.type && size == beverage.size;
    }
    
    @Override
    public String toString() {
        return "Name: " + bevName + ", "+ "Size: " + size;
    }
    
    public double addSizePrice() {
        switch (size) {
            case MEDIUM:
                return basePrice + sizePrice;
            case LARGE:
                return basePrice + 2 * sizePrice;
            default: // if beverage is small
                return basePrice;
        }
    }
    
    public abstract double calcPrice();

}


