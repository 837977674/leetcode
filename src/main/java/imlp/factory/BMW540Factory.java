package imlp.factory;

public class BMW540Factory implements BMWFactory {
    @Override
    public BMW createBMW() {
        return new BMW540();
    }
}
