package dojo.supermarket.model;

public class ThreeForTwoOffer extends Offer{
    private final int finalQuantity = 3;
    private final int requiredQuantity = 2;

    public ThreeForTwoOffer(SpecialOfferType offerType, Product product) {
        super(offerType, product);
    }

    private Discount getDiscount(SupermarketCatalog catalog, double productQuantity, int quantityAsInt) {
        double unitPrice = catalog.getUnitPrice(this.product);
        int CompleteChunks = quantityAsInt / finalQuantity;
        double originalPrice = productQuantity * unitPrice;
        double mustBuyPrice = CompleteChunks * requiredQuantity * unitPrice;
        double extraPrice = quantityAsInt % finalQuantity * unitPrice;
        double discountAmount = originalPrice - (mustBuyPrice + extraPrice);
        String description = finalQuantity + " for " + requiredQuantity;
        return new Discount(this.product, description, -discountAmount);
    }

    @Override
    public Discount consider(ShoppingCart shoppingCart, SupermarketCatalog catalog) {
        double productQuantity = shoppingCart.getItemQuantity(this.product);
        int quantityAsInt = (int) productQuantity;

        if(quantityAsInt > requiredQuantity)
            return getDiscount(catalog, productQuantity, quantityAsInt);
        return null;
    }
}
