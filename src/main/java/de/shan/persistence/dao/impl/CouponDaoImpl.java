package de.shan.persistence.dao.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.shan.persistence.dao.api.CouponDao;
import de.shan.persistence.model.CouponRedemptionEntitiy;

@ApplicationScoped
public class CouponDaoImpl implements CouponDao {

	@PersistenceContext(unitName = "coupon")
	private EntityManager em;

	@Override
	public List<CouponRedemptionEntitiy> findByCoupon(String coupon) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<CouponRedemptionEntitiy> criteriaQuery = criteriaBuilder
				.createQuery(CouponRedemptionEntitiy.class);
		
		Root<CouponRedemptionEntitiy> couponRedemption = criteriaQuery.from(CouponRedemptionEntitiy.class);
		criteriaQuery.select(couponRedemption)
				.where(criteriaBuilder.equal(couponRedemption.get("coupon"), coupon)).distinct(true);
		List<CouponRedemptionEntitiy> resultList = em.createQuery(criteriaQuery).getResultList();
		return resultList;
	}

	@Override
	public void save(CouponRedemptionEntitiy entity) {
		em.persist(entity);
	}

}
