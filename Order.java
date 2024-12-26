import java.util.ArrayList;
import java.util.Random;
public class Order implements OrderInterface, Comparable<Order> {
	private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;
    
    public Order(int orderTime, Day orderDay, Customer customer) {
    	this.orderNumber = generateOrder();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = customer;
        this.beverages = new ArrayList<>();
    }
    
    public int generateOrder() {
    	Random rand = new Random();
        return rand.nextInt(80001) + 10000; // random number between 10000 and 90000
    }
    
    public void addNewBeverage(Beverage beverage) {
        beverages.add(beverage);
    }
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
        
    }
    
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }
    
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }
    
    public double calcOrderTotal() {
    	double orderTotal = 0;
    	for (Beverage b : beverages) {
    	orderTotal += b.calcPrice();
    	}
    	return orderTotal;
    }
    
    public boolean isWeekend() {
    	if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
    	return true;
    	}
    	return false;
    	}
    
    
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            Beverage original = beverages.get(itemNo);
            if (original instanceof Coffee) {
                Coffee coffee = (Coffee) original;
                return new Coffee(coffee.getBevName(), coffee.getSize(), coffee.getExtraShot(), coffee.getExtraSyrup());
            } else if (original instanceof Alcohol) {
                Alcohol alcohol = (Alcohol) original;
                return new Alcohol(alcohol.getBevName(), alcohol.getSize(), alcohol.isWeekend());
            } else if (original instanceof Smoothie) {
                Smoothie smoothie = (Smoothie) original;
                return new Smoothie(smoothie.getBevName(), smoothie.getSize(), smoothie.getNumOfFruits(), smoothie.getAddProtein());
            }
        }
        return null; // Return null if itemNo is invalid
    }

    
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNumber, other.orderNumber);
    }
    
    public int getOrderNo() {
        return orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); 
    }
    
    public int getTotalItems() {
        return beverages.size();
    }
    
    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    @Override
    public String toString() {
    	String beveragesList = "";
    	for (Beverage beverage : beverages) {
         beveragesList += beverage.toString() + "\n";
    	}
         return "Order Number: " + orderNumber + "\n" +
         "Order Time: " + orderTime + "\n" +
         "Order Day: " + orderDay + "\n" +
         "Customer: " + customer.getName() + "\n" +
         "Customer Age: " + customer.getAge() + "Beverages: \n" + beveragesList;

    
    }
}


    


