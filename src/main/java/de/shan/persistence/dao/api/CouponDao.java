package de.shan.persistence.dao.api;

import java.util.List;

import de.shan.persistence.model.CouponRedemptionEntitiy;

public interface CouponDao {
	
	public List<CouponRedemptionEntitiy> findByCoupon(String coupon);
	
	public void save(CouponRedemptionEntitiy entity);

}
