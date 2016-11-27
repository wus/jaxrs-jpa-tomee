package de.shan.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.commons.collections4.CollectionUtils;

import de.shan.persistence.dao.api.CouponDao;
import de.shan.persistence.model.CouponRedemptionEntitiy;
import de.shan.service.CouponUsedException;
import de.shan.service.api.CouponService;

@ApplicationScoped
public class CouponServiceImpl implements CouponService {
    
    @Inject
    private CouponDao dao;

    @Override
    public void save(CouponRedemptionEntitiy redemption) {
    	List<CouponRedemptionEntitiy> entities = dao.findByCoupon(redemption.getCoupon());
    	if (CollectionUtils.isNotEmpty(entities)) {
    		throw new CouponUsedException("the code: " + redemption.getCoupon() + " has been used");
    	}
    	dao.save(redemption);
    }

}
