/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.subscriber;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.axonframework.messaging.responsetypes.ResponseTypes;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;


import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;

/**
 * Subscriber for RatioTapChangerTablePoint related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("ratioTapChangerTablePoint-subscriber")
public class RatioTapChangerTablePointSubscriber extends BaseSubscriber {

	public RatioTapChangerTablePointSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<RatioTapChangerTablePoint>, RatioTapChangerTablePoint> ratioTapChangerTablePointSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllRatioTapChangerTablePointQuery(), 
                		ResponseTypes.multipleInstancesOf(RatioTapChangerTablePoint.class),
                		ResponseTypes.instanceOf(RatioTapChangerTablePoint.class));
    }

    public SubscriptionQueryResult<RatioTapChangerTablePoint, RatioTapChangerTablePoint> ratioTapChangerTablePointSubscribe(@DestinationVariable UUID ratioTapChangerTablePointId) {
        return queryGateway
                .subscriptionQuery(new FindRatioTapChangerTablePointQuery(new LoadRatioTapChangerTablePointFilter(ratioTapChangerTablePointId)), 
                		ResponseTypes.instanceOf(RatioTapChangerTablePoint.class),
                		ResponseTypes.instanceOf(RatioTapChangerTablePoint.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

