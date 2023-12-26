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
 * Subscriber for PssSB4 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pssSB4-subscriber")
public class PssSB4Subscriber extends BaseSubscriber {

	public PssSB4Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PssSB4>, PssSB4> pssSB4Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPssSB4Query(), 
                		ResponseTypes.multipleInstancesOf(PssSB4.class),
                		ResponseTypes.instanceOf(PssSB4.class));
    }

    public SubscriptionQueryResult<PssSB4, PssSB4> pssSB4Subscribe(@DestinationVariable UUID pssSB4Id) {
        return queryGateway
                .subscriptionQuery(new FindPssSB4Query(new LoadPssSB4Filter(pssSB4Id)), 
                		ResponseTypes.instanceOf(PssSB4.class),
                		ResponseTypes.instanceOf(PssSB4.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

