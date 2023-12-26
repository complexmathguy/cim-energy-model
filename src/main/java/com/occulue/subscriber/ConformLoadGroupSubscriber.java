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
 * Subscriber for ConformLoadGroup related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("conformLoadGroup-subscriber")
public class ConformLoadGroupSubscriber extends BaseSubscriber {

	public ConformLoadGroupSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ConformLoadGroup>, ConformLoadGroup> conformLoadGroupSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllConformLoadGroupQuery(), 
                		ResponseTypes.multipleInstancesOf(ConformLoadGroup.class),
                		ResponseTypes.instanceOf(ConformLoadGroup.class));
    }

    public SubscriptionQueryResult<ConformLoadGroup, ConformLoadGroup> conformLoadGroupSubscribe(@DestinationVariable UUID conformLoadGroupId) {
        return queryGateway
                .subscriptionQuery(new FindConformLoadGroupQuery(new LoadConformLoadGroupFilter(conformLoadGroupId)), 
                		ResponseTypes.instanceOf(ConformLoadGroup.class),
                		ResponseTypes.instanceOf(ConformLoadGroup.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

