public class DeluxeRoom implements IRoomType {
    @Override
    public double basePrice(BookingRequest req) {
        return 16000.0;
    }

    @Override
    public boolean matches(int roomType) {
        return roomType == LegacyRoomTypes.DELUXE;
    }
}
