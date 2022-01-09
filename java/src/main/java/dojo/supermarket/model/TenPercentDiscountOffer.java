package dojo.supermarket.model;

public class TenPercentDiscountOffer extends Offer{
    private final double offerDiscount = 10.0;

    public TenPercentDiscountOffer(SpecialOfferType offerType, Product product) {
        super(offerType, product);
    }

    @Override
    public Discount consider(ShoppingCart shoppingCart, SupermarketCatalog catalog) {
        double productQuantity = shoppingCart.getItemQuantity(this.product);
        double unitPrice = catalog.getUnitPrice(this.product);
        double discountAmount = productQuantity * unitPrice * this.offerDiscount / 100.0;
        String description = this.offerDiscount + "% off";
        return new Discount(this.product, description, -discountAmount);
    }
}
