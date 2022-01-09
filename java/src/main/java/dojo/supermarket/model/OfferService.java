package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.List;

public class OfferService {
    private final List<Offer> offerList = new ArrayList<>();

    public void addOfferType(SpecialOfferType offerType, Product product, double offerAmount) {
        switch (offerType) {
            case FiveForAmount:
                offerList.add(new FiveForAmountOffer(offerType, product, offerAmount));
                break;
            case TwoForAmount:
                offerList.add(new TwoForAmountOffer(offerType, product, offerAmount));
                break;
            case TenPercentDiscount:
                offerList.add(new TenPercentDiscountOffer(offerType, product));
                break;
            case ThreeForTwo:
                offerList.add(new ThreeForTwoOffer(offerType, product));
                break;
            default:
                break;
        }
    }

    public List<Discount> considerOffers(ShoppingCart shoppingCart, SupermarketCatalog catalog) {
        List<Discount> discounts = new ArrayList<>();
        for (Offer offer : offerList) {
            Discount offerDiscounts = offer.consider(shoppingCart, catalog);
            if (offerDiscounts != null) {
                discounts.add(offerDiscounts);
            }
        }
        return discounts;
    }

}
