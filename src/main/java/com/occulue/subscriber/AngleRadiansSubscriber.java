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
 * Subscriber for AngleRadians related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("angleRadians-subscriber")
public class AngleRadiansSubscriber extends BaseSubscriber {

	public AngleRadiansSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<AngleRadians>, AngleRadians> angleRadiansSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllAngleRadiansQuery(), 
                		ResponseTypes.multipleInstancesOf(AngleRadians.class),
                		ResponseTypes.instanceOf(AngleRadians.class));
    }

    public SubscriptionQueryResult<AngleRadians, AngleRadians> angleRadiansSubscribe(@DestinationVariable UUID angleRadiansId) {
        return queryGateway
                .subscriptionQuery(new FindAngleRadiansQuery(new LoadAngleRadiansFilter(angleRadiansId)), 
                		ResponseTypes.instanceOf(AngleRadians.class),
                		ResponseTypes.instanceOf(AngleRadians.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

