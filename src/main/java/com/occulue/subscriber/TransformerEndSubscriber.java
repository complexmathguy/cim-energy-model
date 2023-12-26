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
 * Subscriber for TransformerEnd related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("transformerEnd-subscriber")
public class TransformerEndSubscriber extends BaseSubscriber {

	public TransformerEndSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TransformerEnd>, TransformerEnd> transformerEndSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTransformerEndQuery(), 
                		ResponseTypes.multipleInstancesOf(TransformerEnd.class),
                		ResponseTypes.instanceOf(TransformerEnd.class));
    }

    public SubscriptionQueryResult<TransformerEnd, TransformerEnd> transformerEndSubscribe(@DestinationVariable UUID transformerEndId) {
        return queryGateway
                .subscriptionQuery(new FindTransformerEndQuery(new LoadTransformerEndFilter(transformerEndId)), 
                		ResponseTypes.instanceOf(TransformerEnd.class),
                		ResponseTypes.instanceOf(TransformerEnd.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

