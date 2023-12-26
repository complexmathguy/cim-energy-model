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
 * Subscriber for SetPoint related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("setPoint-subscriber")
public class SetPointSubscriber extends BaseSubscriber {

	public SetPointSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SetPoint>, SetPoint> setPointSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSetPointQuery(), 
                		ResponseTypes.multipleInstancesOf(SetPoint.class),
                		ResponseTypes.instanceOf(SetPoint.class));
    }

    public SubscriptionQueryResult<SetPoint, SetPoint> setPointSubscribe(@DestinationVariable UUID setPointId) {
        return queryGateway
                .subscriptionQuery(new FindSetPointQuery(new LoadSetPointFilter(setPointId)), 
                		ResponseTypes.instanceOf(SetPoint.class),
                		ResponseTypes.instanceOf(SetPoint.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

