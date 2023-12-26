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
 * Subscriber for ValueAliasSet related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("valueAliasSet-subscriber")
public class ValueAliasSetSubscriber extends BaseSubscriber {

	public ValueAliasSetSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ValueAliasSet>, ValueAliasSet> valueAliasSetSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllValueAliasSetQuery(), 
                		ResponseTypes.multipleInstancesOf(ValueAliasSet.class),
                		ResponseTypes.instanceOf(ValueAliasSet.class));
    }

    public SubscriptionQueryResult<ValueAliasSet, ValueAliasSet> valueAliasSetSubscribe(@DestinationVariable UUID valueAliasSetId) {
        return queryGateway
                .subscriptionQuery(new FindValueAliasSetQuery(new LoadValueAliasSetFilter(valueAliasSetId)), 
                		ResponseTypes.instanceOf(ValueAliasSet.class),
                		ResponseTypes.instanceOf(ValueAliasSet.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

