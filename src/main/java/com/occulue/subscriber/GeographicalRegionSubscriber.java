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
 * Subscriber for GeographicalRegion related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("geographicalRegion-subscriber")
public class GeographicalRegionSubscriber extends BaseSubscriber {

	public GeographicalRegionSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GeographicalRegion>, GeographicalRegion> geographicalRegionSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGeographicalRegionQuery(), 
                		ResponseTypes.multipleInstancesOf(GeographicalRegion.class),
                		ResponseTypes.instanceOf(GeographicalRegion.class));
    }

    public SubscriptionQueryResult<GeographicalRegion, GeographicalRegion> geographicalRegionSubscribe(@DestinationVariable UUID geographicalRegionId) {
        return queryGateway
                .subscriptionQuery(new FindGeographicalRegionQuery(new LoadGeographicalRegionFilter(geographicalRegionId)), 
                		ResponseTypes.instanceOf(GeographicalRegion.class),
                		ResponseTypes.instanceOf(GeographicalRegion.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

