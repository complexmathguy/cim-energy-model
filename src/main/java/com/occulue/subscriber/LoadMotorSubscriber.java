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
 * Subscriber for LoadMotor related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("loadMotor-subscriber")
public class LoadMotorSubscriber extends BaseSubscriber {

	public LoadMotorSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<LoadMotor>, LoadMotor> loadMotorSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllLoadMotorQuery(), 
                		ResponseTypes.multipleInstancesOf(LoadMotor.class),
                		ResponseTypes.instanceOf(LoadMotor.class));
    }

    public SubscriptionQueryResult<LoadMotor, LoadMotor> loadMotorSubscribe(@DestinationVariable UUID loadMotorId) {
        return queryGateway
                .subscriptionQuery(new FindLoadMotorQuery(new LoadLoadMotorFilter(loadMotorId)), 
                		ResponseTypes.instanceOf(LoadMotor.class),
                		ResponseTypes.instanceOf(LoadMotor.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

