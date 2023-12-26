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
 * Subscriber for PFVArControllerType1UserDefined related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pFVArControllerType1UserDefined-subscriber")
public class PFVArControllerType1UserDefinedSubscriber extends BaseSubscriber {

	public PFVArControllerType1UserDefinedSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PFVArControllerType1UserDefined>, PFVArControllerType1UserDefined> pFVArControllerType1UserDefinedSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPFVArControllerType1UserDefinedQuery(), 
                		ResponseTypes.multipleInstancesOf(PFVArControllerType1UserDefined.class),
                		ResponseTypes.instanceOf(PFVArControllerType1UserDefined.class));
    }

    public SubscriptionQueryResult<PFVArControllerType1UserDefined, PFVArControllerType1UserDefined> pFVArControllerType1UserDefinedSubscribe(@DestinationVariable UUID pFVArControllerType1UserDefinedId) {
        return queryGateway
                .subscriptionQuery(new FindPFVArControllerType1UserDefinedQuery(new LoadPFVArControllerType1UserDefinedFilter(pFVArControllerType1UserDefinedId)), 
                		ResponseTypes.instanceOf(PFVArControllerType1UserDefined.class),
                		ResponseTypes.instanceOf(PFVArControllerType1UserDefined.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

