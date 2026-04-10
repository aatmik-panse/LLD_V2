public class Mess implements IAddOn {
    @Override
    public double price(BookingRequest req) {
        return 1000.0;
    }

    @Override
    public boolean matches(AddOn addOn) {
        return addOn == AddOn.MESS;
    }
}
