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
 * Subscriber for Area related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("area-subscriber")
public class AreaSubscriber extends BaseSubscriber {

	public AreaSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Area>, Area> areaSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAreaQuery(), 
                		ResponseTypes.multipleInstancesOf(Area.class),
                		ResponseTypes.instanceOf(Area.class));
    }

    public SubscriptionQueryResult<Area, Area> areaSubscribe(@DestinationVariable UUID areaId) {
        return queryGateway
                .subscriptionQuery(new FindAreaQuery(new LoadAreaFilter(areaId)), 
                		ResponseTypes.instanceOf(Area.class),
                		ResponseTypes.instanceOf(Area.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

