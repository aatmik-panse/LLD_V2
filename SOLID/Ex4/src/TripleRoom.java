public class TripleRoom implements IRoomType {
    @Override
    public double basePrice(BookingRequest req) {
        return 12000.0;
    }

    @Override
    public boolean matches(int roomType) {
        return roomType == LegacyRoomTypes.TRIPLE;
    }
}
