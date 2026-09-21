package campuscanteenapp;


public class Order {

    private Menu menu;

    private int[] quantities;


    public Order(Menu menu) {

        this.menu = menu;

      
        quantities = new int[menu.getMenuSize()];
    }

    public void addItem(int choice, int quantity) {

        quantities[choice - 1] =
            quantities[choice - 1] + quantity;
    }

    public int getQuantity(int choice) {

        return quantities[choice - 1];
    }

    public double calculateSubtotal() {

        double subtotal = 0;


        for (int i = 0; i < quantities.length; i++) {

            subtotal =
                subtotal
                + (menu.getItemPrice(i + 1) * quantities[i]);
        }


        return subtotal;
    }


    public double calculateDiscount(Customer customer) {

        double subtotal = calculateSubtotal();

        return subtotal * customer.getDiscountRate();
    }


  
    
    public double calculateFinalAmount(Customer customer) {

        double subtotal = calculateSubtotal();

        double discount = calculateDiscount(customer);

        return subtotal - discount;
    }


    public void displayOrder() {

        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("                  YOUR ORDER");
        System.out.println("----------------------------------------------");


        boolean hasItems = false;


        for (int i = 0; i < quantities.length; i++) {

            if (quantities[i] > 0) {

                hasItems = true;


                double itemTotal =
                    menu.getItemPrice(i + 1)
                    * quantities[i];


                System.out.println(
                    menu.getItemName(i + 1)
                    + " x "
                    + quantities[i]
                    + " = UGX "
                    + itemTotal
                );
            }
        }


        if (!hasItems) {

            System.out.println(
                "No items have been ordered."
            );
        }


        System.out.println("----------------------------------------------");
    }
}