import java.util.*;

public class MenuTotal {

    public static List<InvoiceLine> computeLines(Map<String, MenuItem> menu, List<OrderLine> order) {
        List<InvoiceLine> result = new ArrayList<>();
        for (OrderLine ol : order) {
            MenuItem item = menu.get(ol.itemId);
            result.add(new InvoiceLine(item.name, ol.qty, item.price * ol.qty));
        }
        return result;
    }

    public static double subtotal(List<InvoiceLine> lines) {
        double sum = 0;
        for (InvoiceLine l : lines) sum += l.lineTotal;
        return sum;
    }
}
