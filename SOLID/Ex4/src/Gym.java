public class Gym implements IAddOn {
    @Override
    public double price(BookingRequest req) {
        return 300.0;
    }

    @Override
    public boolean matches(AddOn addOn) {
        return addOn == AddOn.GYM;
    }
}
