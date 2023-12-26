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
 * Subscriber for Length related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("length-subscriber")
public class LengthSubscriber extends BaseSubscriber {

	public LengthSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Length>, Length> lengthSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllLengthQuery(), 
                		ResponseTypes.multipleInstancesOf(Length.class),
                		ResponseTypes.instanceOf(Length.class));
    }

    public SubscriptionQueryResult<Length, Length> lengthSubscribe(@DestinationVariable UUID lengthId) {
        return queryGateway
                .subscriptionQuery(new FindLengthQuery(new LoadLengthFilter(lengthId)), 
                		ResponseTypes.instanceOf(Length.class),
                		ResponseTypes.instanceOf(Length.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

