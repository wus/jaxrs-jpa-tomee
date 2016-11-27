package de.shan.rest.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class CouponRedemptionRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String coupon;
    
    @NotEmpty
    private String cardNr;

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getCardNr() {
        return cardNr;
    }

    public void setCardNr(String cardNr) {
        this.cardNr = cardNr;
    }

}
