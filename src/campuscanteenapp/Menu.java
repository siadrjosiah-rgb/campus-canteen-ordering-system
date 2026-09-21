package campuscanteenapp;

public class Menu {

   
    private String[] items = {
        "Rolex",
        "Chapati and Beans",
        "Chicken and Chips",
        "Pilau",
        "Samosa",
        "Soda",
        "Water"
    };


    private double[] prices = {
        3000,
        5000,
        12000,
        8000,
        1500,
        2500,
        1500
    };


  
    public void displayMenu() {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("              CAMPUS CANTEEN MENU");
        System.out.println("==============================================");

        for (int i = 0; i < items.length; i++) {

            System.out.println(
                (i + 1) + ". "
                + items[i]
                + " - UGX "
                + prices[i]
            );
        }

        System.out.println("==============================================");
    }


   
    public String getItemName(int choice) {

        return items[choice - 1];
    }

   
    public double getItemPrice(int choice) {

        return prices[choice - 1];
    }


    public int getMenuSize() {

        return items.length;
    }
}