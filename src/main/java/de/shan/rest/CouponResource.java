package de.shan.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.Logger;

import de.shan.persistence.model.CouponRedemptionEntitiy;
import de.shan.rest.model.CouponRedemptionRequest;
import de.shan.rest.model.CouponRedemptionResponse;
import de.shan.service.api.CouponService;

@Path("/coupon")
@Transactional(rollbackOn = Throwable.class)
@RequestScoped
public class CouponResource {
    
    @Inject
    CouponService couponDao;
    
    @Inject
    Logger logger;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/redemption")
    public CouponRedemptionResponse redemption(@Valid CouponRedemptionRequest request) {
        CouponRedemptionEntitiy redemptionEntity = new CouponRedemptionEntitiy();
        redemptionEntity.setCardNr(request.getCardNr());
        redemptionEntity.setCoupon(request.getCoupon());
        couponDao.save(redemptionEntity);
        CouponRedemptionResponse response = new CouponRedemptionResponse();
        response.setMessage("okay");
        return response;
    }

    @GET
    @Produces("text/plain")
    public String doGet(@QueryParam("name") String name) {
        final String message = "Hello " + name + " !";
        logger.info(message);
        return message;
    }
}