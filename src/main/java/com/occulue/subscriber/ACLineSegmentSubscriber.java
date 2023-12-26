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
 * Subscriber for ACLineSegment related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("aCLineSegment-subscriber")
public class ACLineSegmentSubscriber extends BaseSubscriber {

	public ACLineSegmentSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ACLineSegment>, ACLineSegment> aCLineSegmentSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllACLineSegmentQuery(), 
                		ResponseTypes.multipleInstancesOf(ACLineSegment.class),
                		ResponseTypes.instanceOf(ACLineSegment.class));
    }

    public SubscriptionQueryResult<ACLineSegment, ACLineSegment> aCLineSegmentSubscribe(@DestinationVariable UUID aCLineSegmentId) {
        return queryGateway
                .subscriptionQuery(new FindACLineSegmentQuery(new LoadACLineSegmentFilter(aCLineSegmentId)), 
                		ResponseTypes.instanceOf(ACLineSegment.class),
                		ResponseTypes.instanceOf(ACLineSegment.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

