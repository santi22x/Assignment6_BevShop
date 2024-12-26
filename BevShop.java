import java.util.ArrayList;

public class BevShop  implements BevShopInterface {
	public ArrayList<Order> orders;
	private int alcoholCount;
	private int currentOrderIndex; 
	private int numOfAlcoholOrders;
	
	public BevShop() {
        this.orders = new ArrayList<>();
        this.alcoholCount = 0;
    }
	
	@Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }
	
	@Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }
	
	public boolean validTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) {
		return true;
		}
		else{
			return false;
		}
	}
	@Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }
	
	public boolean isMaxFruit(int num) {
		if (num > MAX_FRUIT) {
		return true;
		}
		return false;
		}
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholOrders;
		}
	
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		currentOrderIndex = orders.indexOf(order);
		numOfAlcoholOrders = 0;
		}
	
	@Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        if (currentOrderIndex >= 0) {
            orders.get(currentOrderIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
        }
    }
	
	@Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (currentOrderIndex >= 0 && isEligibleForMore()) {
            orders.get(currentOrderIndex).addNewBeverage(bevName, size);
        }
    }
	
	@Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (currentOrderIndex >= 0 && !isMaxFruit(numOfFruits)) {
            orders.get(currentOrderIndex).addNewBeverage(bevName, size, numOfFruits, addProtein);
        }
    }
	
	@Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNo) {
                return i;
            }
        }
        return -1;
    }
	
	 @Override
	    public double totalOrderPrice(int orderNo) {
	        int index = findOrder(orderNo);
	        if (index != -1) {
	            return orders.get(index).calcOrderTotal();
	        }
	        return 0.0;
	    }
	 
	 @Override
	    public double totalMonthlySale() {
	        double total = 0.0;
	        for (Order order : orders) {
	            total += order.calcOrderTotal();
	        }
	        return total;
	    }
	 @Override
	    public int totalNumOfMonthlyOrders() {
	        return orders.size();
	    }	 
	 @Override
	    public Order getCurrentOrder() {
	        if (currentOrderIndex >= 0) {
	            return orders.get(currentOrderIndex);
	        }
	        return null;
	    }
	 
	 public Order getOrderAtIndex(int index) {
		 return orders.get(index);
	 }
	 
	 public void sortOrders() {
		 for (int i = 0; i < orders.size()-1; i++) {
		 int minOrderNumIdx = i;
		 for (int j = i+1; j < orders.size(); j++) {
		 if (orders.get(j).getOrderNo() < orders.get(minOrderNumIdx).getOrderNo()) {
		 minOrderNumIdx = j;
		 		}
		 	}
		 Order temp = orders.get(i);
         orders.set(i, orders.get(minOrderNumIdx));
         orders.set(minOrderNumIdx, temp);
		 }
	 }
	 @Override
	 public String toString() {
		 String s = "Monthly Orders\n";
		 for (Order o : orders) {
		 s += o.toString();
		 }
		 s += "Total Sale: " + totalMonthlySale();
		 return s;
		 }

	@Override
	public boolean isValidTime(int time) {
		return time >= MIN_TIME && time <= MAX_TIME;
	}

	@Override
	public boolean isEligibleForMore() {
		if (numOfAlcoholOrders < 3) {
			return true;
		} 
		return false;
	}

	@Override
	public boolean isValidAge(int age) {
		if (age >= MIN_AGE_FOR_ALCOHOL) {
			return true;
			}
			return false;
	}
	

}


