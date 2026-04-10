public class TaxRules implements ITaxRule {
    @Override
    public double taxPercent(String customerType) {
        // Also violating OCP because we are adding a new customer type we need to edit the code
        if ("student".equalsIgnoreCase(customerType)) return 5.0;
        if ("staff".equalsIgnoreCase(customerType)) return 2.0;
        return 8.0;
    }
}
