import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        double base = 0.0;

        List<IRoomType> roomTypes = new ArrayList<>();
        roomTypes.add(new SingleRoom());
        roomTypes.add(new DoubleRoom());
        roomTypes.add(new TripleRoom());
        roomTypes.add(new DeluxeRoom());

        for (IRoomType roomType : roomTypes) {
            if (roomType.matches(req.roomType)) {
                base = roomType.basePrice(req);
                break;
            }
        }

        double add = 0.0;

        List<IAddOn> addOns = new ArrayList<>();
        addOns.add(new Mess());
        addOns.add(new Laundry());
        addOns.add(new Gym());

        for (AddOn reqAddOn : req.addOns) {
            for (IAddOn addOn : addOns) {
                if (addOn.matches(reqAddOn)) {
                    add += addOn.price(req);
                }
            }
        }

        return new Money(base + add);
    }
}
