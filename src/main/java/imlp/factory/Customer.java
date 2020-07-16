package imlp.factory;

public class Customer {
    public static void main(String[] args) {
        BMW330Factory bmw330Factory = new BMW330Factory();
        BMW bmw320 = bmw330Factory.createBMW();

        BMW540Factory bmw540Factory = new BMW540Factory();
        BMW bmw523 = bmw540Factory.createBMW();
    }
}
