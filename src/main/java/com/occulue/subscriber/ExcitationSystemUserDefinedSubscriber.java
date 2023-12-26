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
 * Subscriber for ExcitationSystemUserDefined related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excitationSystemUserDefined-subscriber")
public class ExcitationSystemUserDefinedSubscriber extends BaseSubscriber {

	public ExcitationSystemUserDefinedSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcitationSystemUserDefined>, ExcitationSystemUserDefined> excitationSystemUserDefinedSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcitationSystemUserDefinedQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcitationSystemUserDefined.class),
                		ResponseTypes.instanceOf(ExcitationSystemUserDefined.class));
    }

    public SubscriptionQueryResult<ExcitationSystemUserDefined, ExcitationSystemUserDefined> excitationSystemUserDefinedSubscribe(@DestinationVariable UUID excitationSystemUserDefinedId) {
        return queryGateway
                .subscriptionQuery(new FindExcitationSystemUserDefinedQuery(new LoadExcitationSystemUserDefinedFilter(excitationSystemUserDefinedId)), 
                		ResponseTypes.instanceOf(ExcitationSystemUserDefined.class),
                		ResponseTypes.instanceOf(ExcitationSystemUserDefined.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

