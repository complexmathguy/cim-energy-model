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
 * Subscriber for PssSH related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pssSH-subscriber")
public class PssSHSubscriber extends BaseSubscriber {

	public PssSHSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PssSH>, PssSH> pssSHSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPssSHQuery(), 
                		ResponseTypes.multipleInstancesOf(PssSH.class),
                		ResponseTypes.instanceOf(PssSH.class));
    }

    public SubscriptionQueryResult<PssSH, PssSH> pssSHSubscribe(@DestinationVariable UUID pssSHId) {
        return queryGateway
                .subscriptionQuery(new FindPssSHQuery(new LoadPssSHFilter(pssSHId)), 
                		ResponseTypes.instanceOf(PssSH.class),
                		ResponseTypes.instanceOf(PssSH.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

