package campuscanteenapp;

public class Customer {

  
    private String name;

   
    private boolean student;


    public Customer(String name, boolean student) {

        this.name = name;

        this.student = student;
    }


    public String getName() {

        return name;
    }

    public boolean isStudent() {

        return student;
    }

    public double getDiscountRate() {

        return student ? 0.10 : 0.00;
    }
}