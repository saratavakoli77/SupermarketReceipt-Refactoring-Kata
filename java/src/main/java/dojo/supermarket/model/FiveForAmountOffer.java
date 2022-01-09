package dojo.supermarket.model;

public class FiveForAmountOffer extends BoughtForAmountOffer{

    public FiveForAmountOffer(SpecialOfferType offerType, Product product, double amount) {
        super(offerType, product, amount);
        this.requiredQuantity = 5;
    }
}
