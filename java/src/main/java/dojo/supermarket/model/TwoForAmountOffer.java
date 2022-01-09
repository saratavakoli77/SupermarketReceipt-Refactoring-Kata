package dojo.supermarket.model;

public class TwoForAmountOffer extends BoughtForAmountOffer{

    public TwoForAmountOffer(SpecialOfferType offerType, Product product, double amount) {
        super(offerType, product, amount);
        this.requiredQuantity = 2;
    }
}
