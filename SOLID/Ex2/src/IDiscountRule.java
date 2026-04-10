public interface IDiscountRule {
    double discountAmount(String customerType, double subtotal, int distinctLines);
}
