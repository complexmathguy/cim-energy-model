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
 * Subscriber for Control related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("control-subscriber")
public class ControlSubscriber extends BaseSubscriber {

	public ControlSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Control>, Control> controlSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllControlQuery(), 
                		ResponseTypes.multipleInstancesOf(Control.class),
                		ResponseTypes.instanceOf(Control.class));
    }

    public SubscriptionQueryResult<Control, Control> controlSubscribe(@DestinationVariable UUID controlId) {
        return queryGateway
                .subscriptionQuery(new FindControlQuery(new LoadControlFilter(controlId)), 
                		ResponseTypes.instanceOf(Control.class),
                		ResponseTypes.instanceOf(Control.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

