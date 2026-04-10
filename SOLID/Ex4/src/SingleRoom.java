public class SingleRoom implements IRoomType {
    @Override
    public double basePrice(BookingRequest req) {
        return 14000.0;
    }

    @Override
    public boolean matches(int roomType) {
        return roomType == LegacyRoomTypes.SINGLE;
    }
}