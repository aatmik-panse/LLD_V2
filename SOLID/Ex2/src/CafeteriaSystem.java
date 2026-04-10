import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final ITaxRule taxRule;
    private final IDiscountRule discountRule;
    private final IInvoiceStore store;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(ITaxRule taxRule, IDiscountRule discountRule, IInvoiceStore store) {
        this.taxRule = taxRule;
        this.discountRule = discountRule;
        this.store = store;
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        // Calculate the invoice lines
        List<InvoiceLine> invoiceLines = MenuTotal.computeLines(menu, lines);
        double subtotal = MenuTotal.subtotal(invoiceLines);
        // Calculate the tax of the order

        double taxPct = taxRule.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        // Calculate the discount of the order
        double discount = discountRule.discountAmount(customerType, subtotal, lines.size());

        // Calculate the total of the order
        double total = subtotal + tax - discount;

        // Format the invoice

        String printable = InvoiceFormatter.format(invId, invoiceLines,
                subtotal, taxPct, tax, discount, total);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
