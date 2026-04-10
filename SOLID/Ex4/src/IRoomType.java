public interface IRoomType {
    double basePrice(BookingRequest req);
    boolean matches(int roomType);
}