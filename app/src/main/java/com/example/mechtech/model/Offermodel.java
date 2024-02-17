package com.example.mechtech.model;

public class Offermodel {
    private int offerImage;
    private String offerPrice;
    private String offerconstraint;


    public Offermodel(int offerImage, String offerconstraint, String offerPrice) {
        this.offerImage = offerImage;
        this.offerPrice = offerPrice;
        this.offerconstraint=offerconstraint;


    }
    public int getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(int offerImage) {
        this.offerImage = offerImage;
    }

    public String getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getOfferconstraint() {
        return offerconstraint;
    }

    public void setOfferconstraint(String offerconstraint) {
        this.offerconstraint = offerconstraint;
    }
}