package campuscanteenapp;

import java.util.Scanner;

public class CampusCanteenApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Menu menu = new Menu();

        System.out.println();
        System.out.println("==============================================");
        System.out.println("       WELCOME TO CAMPUS CANTEEN");
        System.out.println("==============================================");


        System.out.print("Enter your name: ");

        String name = input.nextLine();


        System.out.print(
            "Are you a registered student? (yes/no): "
        );

        String studentAnswer = input.nextLine();

        boolean isStudent =
            studentAnswer.equalsIgnoreCase("yes");
     
        Customer customer =
            new Customer(name, isStudent);

        Order order =
            new Order(menu);


      boolean continueOrdering = true;
     
        do {

         
            menu.displayMenu();


          System.out.print(
                "Enter the number of the item you want: "
            );

            int choice = input.nextInt();


         
            if (choice >= 1 &&
                choice <= menu.getMenuSize()) {


             
                System.out.println(
                    "You selected: "
                    + menu.getItemName(choice)
                );


                System.out.println(
                    "Price: UGX "
                    + menu.getItemPrice(choice)
                );


                System.out.print(
                    "Enter quantity: "
                );

                int quantity = input.nextInt();


             
                while (quantity <= 0) {

                    System.out.println(
                        "Quantity must be greater than zero."
                    );


                    System.out.print(
                        "Please enter the quantity again: "
                    );


                    quantity = input.nextInt();
                }


              order.addItem(choice, quantity);


                System.out.println(
                    quantity
                    + " x "
                    + menu.getItemName(choice)
                    + " added to your order."
                );


            } else {

              System.out.println(
                    "Invalid choice. Please choose "
                    + "an item from the menu."
                );
            }

            System.out.print(
                "\nDo you want to order another item? (yes/no): "
            );


            String answer = input.next();


        
            if (answer.equalsIgnoreCase("no")) {

                continueOrdering = false;

            } else {

                continueOrdering = true;
            }


        } while (continueOrdering);

        order.displayOrder();

        double subtotal =
            order.calculateSubtotal();


        double discount =
            order.calculateDiscount(customer);


        double finalAmount =
            order.calculateFinalAmount(customer);


        System.out.println();
        System.out.println("==============================================");
        System.out.println("                CUSTOMER BILL");
        System.out.println("==============================================");


        System.out.println(
            "Customer: "
            + customer.getName()
        );

        System.out.println(
            "Student: "
            + (customer.isStudent() ? "Yes" : "No")
        );

        System.out.println(
            "Subtotal: UGX "
            + subtotal
        );

        System.out.println(
            "Discount: UGX "
            + discount
        );

        System.out.println(
            "Final Amount: UGX "
            + finalAmount
        );

        System.out.print(
            "Enter amount paid: UGX "
        );

        double amountPaid = input.nextDouble();

        if (amountPaid >= finalAmount) {

            double change =
                amountPaid - finalAmount;


            System.out.println(
                "Payment successful."
            );


            System.out.println(
                "Change: UGX "
                + change
            );


        } else {

            double remaining =
                finalAmount - amountPaid;


            System.out.println(
                "Payment is not enough."
            );


            System.out.println(
                "Additional amount needed: UGX "
                + remaining
            );
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println(
            "Thank you, "
            + customer.getName()
            + "!"
        );

        System.out.println(
            "Thank you for using Campus Canteen."
        );

        System.out.println("==============================================");


     
        input.close();
    }
}