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
 * Subscriber for PFVArControllerType2Dynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pFVArControllerType2Dynamics-subscriber")
public class PFVArControllerType2DynamicsSubscriber extends BaseSubscriber {

	public PFVArControllerType2DynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PFVArControllerType2Dynamics>, PFVArControllerType2Dynamics> pFVArControllerType2DynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPFVArControllerType2DynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(PFVArControllerType2Dynamics.class),
                		ResponseTypes.instanceOf(PFVArControllerType2Dynamics.class));
    }

    public SubscriptionQueryResult<PFVArControllerType2Dynamics, PFVArControllerType2Dynamics> pFVArControllerType2DynamicsSubscribe(@DestinationVariable UUID pFVArControllerType2DynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindPFVArControllerType2DynamicsQuery(new LoadPFVArControllerType2DynamicsFilter(pFVArControllerType2DynamicsId)), 
                		ResponseTypes.instanceOf(PFVArControllerType2Dynamics.class),
                		ResponseTypes.instanceOf(PFVArControllerType2Dynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

