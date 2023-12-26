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
 * Subscriber for PssELIN2 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pssELIN2-subscriber")
public class PssELIN2Subscriber extends BaseSubscriber {

	public PssELIN2Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PssELIN2>, PssELIN2> pssELIN2Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPssELIN2Query(), 
                		ResponseTypes.multipleInstancesOf(PssELIN2.class),
                		ResponseTypes.instanceOf(PssELIN2.class));
    }

    public SubscriptionQueryResult<PssELIN2, PssELIN2> pssELIN2Subscribe(@DestinationVariable UUID pssELIN2Id) {
        return queryGateway
                .subscriptionQuery(new FindPssELIN2Query(new LoadPssELIN2Filter(pssELIN2Id)), 
                		ResponseTypes.instanceOf(PssELIN2.class),
                		ResponseTypes.instanceOf(PssELIN2.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

