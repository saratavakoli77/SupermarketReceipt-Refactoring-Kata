package dojo.supermarket.model;

public abstract class Offer {
    private SpecialOfferType offerType;
    protected Product product;

    public Offer(SpecialOfferType offerType, Product product) {
        this.offerType = offerType;
        this.product = product;
    }

    public abstract Discount consider(ShoppingCart shoppingCart, SupermarketCatalog catalog);
}
