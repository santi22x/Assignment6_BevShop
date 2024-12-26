import java.util.Scanner;

public class BevShopDriverApp {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();
        System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());
        while (true) {
            System.out.println("Start please a new order:");
            System.out.println("Your Total Order for now is 0.0");
            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Would you please enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            if (age >= bevShop.getMinAgeForAlcohol()) {
                System.out.println("Your age is above 20 and you are eligible to order alcohol");
            } else {
                System.out.println("Your Age is not appropriate for alcohol drink!!");
            }
            System.out.print("Enter the time of the order (e.g., 14 for 2 PM): ");
            int time = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the day of the week (e.g., MONDAY): ");
            Day day = Day.valueOf(scanner.nextLine().toUpperCase());

            if (!bevShop.isValidTime(time)) {
                System.out.println("Invalid time. Orders can only be placed between " + BevShop.MIN_TIME + " and " + BevShop.MAX_TIME + ".");
                continue;
            }

            bevShop.startNewOrder(time, day, name, age);

            while (true) {
                System.out.println("Would you please add a drink (1: Alcohol, 2: Coffee, 3: Smoothie, 4: Finish Order): ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 4) break;

                System.out.print("Enter the name of the drink: ");
                String drinkName = scanner.nextLine();

                System.out.print("Enter the size (SMALL, MEDIUM, LARGE): ");
                Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                switch (choice) {
                    case 1:
                        if (bevShop.isValidAge(age) && bevShop.isEligibleForMore()) {
                            bevShop.processAlcoholOrder(drinkName, size);
                            System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
                            System.out.println("The Total price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

                            if (bevShop.getNumOfAlcoholDrink() < 3) {
                                System.out.println("Your current alcohol drink order is less than 4");
                            } else {
                                System.out.println("You have a maximum alcohol drinks for this order");
                            }
                        } else {
                            System.out.println("Cannot add alcoholic beverage. Age restriction or limit exceeded.");
                        }
                        break;

                    case 2:
                        System.out.print("Extra shot? (true/false): ");
                        boolean extraShot = scanner.nextBoolean();
                        System.out.print("Extra syrup? (true/false): ");
                        boolean extraSyrup = scanner.nextBoolean();
                        scanner.nextLine();

                        bevShop.processCoffeeOrder(drinkName, size, extraShot, extraSyrup);
                        System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getTotalItems());
                        System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());
                        break;

                    case 3:
                        System.out.print("Number of fruits: ");
                        int numFruits = scanner.nextInt();
                        System.out.print("Add protein? (true/false): ");
                        boolean addProtein = scanner.nextBoolean();
                        scanner.nextLine();

                        if (!bevShop.isMaxFruit(numFruits)) {
                            bevShop.processSmoothieOrder(drinkName, size, numFruits, addProtein);
                            System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());
                        } else {
                            System.out.println("You reached a Maximum number of fruits");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
            System.out.println("#------------------------------------#");
            System.out.println("Would you please start a new order");
            System.out.print("Would you please enter your name: ");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) break;
        }
        System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());
        scanner.close();
    }
}
