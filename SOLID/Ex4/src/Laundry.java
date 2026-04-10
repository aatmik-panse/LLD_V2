public class Laundry implements IAddOn {
    @Override
    public double price(BookingRequest req) {
        return 500.0;
    }

    @Override
    public boolean matches(AddOn addOn) {
        return addOn == AddOn.LAUNDRY;
    }
}
