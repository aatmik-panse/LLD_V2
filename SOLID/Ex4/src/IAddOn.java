public interface IAddOn {
    double price(BookingRequest req);
    boolean matches(AddOn addOn);
}