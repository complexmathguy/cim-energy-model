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
 * Subscriber for PssWECC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pssWECC-subscriber")
public class PssWECCSubscriber extends BaseSubscriber {

	public PssWECCSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PssWECC>, PssWECC> pssWECCSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPssWECCQuery(), 
                		ResponseTypes.multipleInstancesOf(PssWECC.class),
                		ResponseTypes.instanceOf(PssWECC.class));
    }

    public SubscriptionQueryResult<PssWECC, PssWECC> pssWECCSubscribe(@DestinationVariable UUID pssWECCId) {
        return queryGateway
                .subscriptionQuery(new FindPssWECCQuery(new LoadPssWECCFilter(pssWECCId)), 
                		ResponseTypes.instanceOf(PssWECC.class),
                		ResponseTypes.instanceOf(PssWECC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

