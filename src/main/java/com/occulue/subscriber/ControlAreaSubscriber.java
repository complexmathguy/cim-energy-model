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
 * Subscriber for ControlArea related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("controlArea-subscriber")
public class ControlAreaSubscriber extends BaseSubscriber {

	public ControlAreaSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ControlArea>, ControlArea> controlAreaSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllControlAreaQuery(), 
                		ResponseTypes.multipleInstancesOf(ControlArea.class),
                		ResponseTypes.instanceOf(ControlArea.class));
    }

    public SubscriptionQueryResult<ControlArea, ControlArea> controlAreaSubscribe(@DestinationVariable UUID controlAreaId) {
        return queryGateway
                .subscriptionQuery(new FindControlAreaQuery(new LoadControlAreaFilter(controlAreaId)), 
                		ResponseTypes.instanceOf(ControlArea.class),
                		ResponseTypes.instanceOf(ControlArea.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

