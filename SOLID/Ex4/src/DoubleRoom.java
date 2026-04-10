public class DoubleRoom implements IRoomType {
    @Override
    public double basePrice(BookingRequest req) {
        return 15000.0;
    }

    @Override
    public boolean matches(int roomType) {
        return roomType == LegacyRoomTypes.DOUBLE;
    }
}
