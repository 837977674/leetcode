package imlp.factory;

public class BMW330Factory implements BMWFactory {
    @Override
    public BMW createBMW() {
        return new BMW330();
    }
}
