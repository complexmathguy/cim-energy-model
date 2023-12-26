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
 * Subscriber for PFVArType1IEEEVArController related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pFVArType1IEEEVArController-subscriber")
public class PFVArType1IEEEVArControllerSubscriber extends BaseSubscriber {

	public PFVArType1IEEEVArControllerSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PFVArType1IEEEVArController>, PFVArType1IEEEVArController> pFVArType1IEEEVArControllerSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPFVArType1IEEEVArControllerQuery(), 
                		ResponseTypes.multipleInstancesOf(PFVArType1IEEEVArController.class),
                		ResponseTypes.instanceOf(PFVArType1IEEEVArController.class));
    }

    public SubscriptionQueryResult<PFVArType1IEEEVArController, PFVArType1IEEEVArController> pFVArType1IEEEVArControllerSubscribe(@DestinationVariable UUID pFVArType1IEEEVArControllerId) {
        return queryGateway
                .subscriptionQuery(new FindPFVArType1IEEEVArControllerQuery(new LoadPFVArType1IEEEVArControllerFilter(pFVArType1IEEEVArControllerId)), 
                		ResponseTypes.instanceOf(PFVArType1IEEEVArController.class),
                		ResponseTypes.instanceOf(PFVArType1IEEEVArController.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

