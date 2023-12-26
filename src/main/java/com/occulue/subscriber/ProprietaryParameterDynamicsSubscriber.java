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
 * Subscriber for ProprietaryParameterDynamics related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("proprietaryParameterDynamics-subscriber")
public class ProprietaryParameterDynamicsSubscriber extends BaseSubscriber {

	public ProprietaryParameterDynamicsSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ProprietaryParameterDynamics>, ProprietaryParameterDynamics> proprietaryParameterDynamicsSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllProprietaryParameterDynamicsQuery(), 
                		ResponseTypes.multipleInstancesOf(ProprietaryParameterDynamics.class),
                		ResponseTypes.instanceOf(ProprietaryParameterDynamics.class));
    }

    public SubscriptionQueryResult<ProprietaryParameterDynamics, ProprietaryParameterDynamics> proprietaryParameterDynamicsSubscribe(@DestinationVariable UUID proprietaryParameterDynamicsId) {
        return queryGateway
                .subscriptionQuery(new FindProprietaryParameterDynamicsQuery(new LoadProprietaryParameterDynamicsFilter(proprietaryParameterDynamicsId)), 
                		ResponseTypes.instanceOf(ProprietaryParameterDynamics.class),
                		ResponseTypes.instanceOf(ProprietaryParameterDynamics.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

