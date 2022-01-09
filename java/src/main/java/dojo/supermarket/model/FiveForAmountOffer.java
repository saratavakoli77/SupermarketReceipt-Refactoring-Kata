package dojo.supermarket.model;

public class FiveForAmountOffer extends Offer{
    private final double amount;
    private final int requiredQuantity = 5;

    public FiveForAmountOffer(SpecialOfferType offerType, Product product, double amount) {
        super(offerType, product);
        this.amount = amount;
    }

    private Discount getDiscount(SupermarketCatalog catalog, double productQuantity, int quantityAsInt) {
        double unitPrice = catalog.getUnitPrice(this.product);
        double totalPrice = unitPrice * productQuantity;
        double discountTotal =
                totalPrice - (calculateDiscountedPrice(quantityAsInt) + calculateRemainingQuantityPrice(quantityAsInt, unitPrice));
        String description = this.requiredQuantity + " for " + this.amount;
        return new Discount(this.product, description, -discountTotal);
    }

    private double calculateDiscountedPrice(int quantityAsInt) {
        return this.amount * Math.floor(quantityAsInt / this.requiredQuantity);
    }

    private double calculateRemainingQuantityPrice(int quantityAsInt, double unitPrice) {
        return quantityAsInt % this.requiredQuantity * unitPrice;
    }

    @Override
    public Discount consider(ShoppingCart shoppingCart, SupermarketCatalog catalog) {
        double productQuantity = shoppingCart.getItemQuantity(this.product);
        int quantityAsInt = (int) productQuantity;
        if (quantityAsInt >= requiredQuantity)
            return getDiscount(catalog, productQuantity, quantityAsInt);
        return null;
    }
}
