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
 * Subscriber for StringMeasurement related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("stringMeasurement-subscriber")
public class StringMeasurementSubscriber extends BaseSubscriber {

	public StringMeasurementSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<StringMeasurement>, StringMeasurement> stringMeasurementSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllStringMeasurementQuery(), 
                		ResponseTypes.multipleInstancesOf(StringMeasurement.class),
                		ResponseTypes.instanceOf(StringMeasurement.class));
    }

    public SubscriptionQueryResult<StringMeasurement, StringMeasurement> stringMeasurementSubscribe(@DestinationVariable UUID stringMeasurementId) {
        return queryGateway
                .subscriptionQuery(new FindStringMeasurementQuery(new LoadStringMeasurementFilter(stringMeasurementId)), 
                		ResponseTypes.instanceOf(StringMeasurement.class),
                		ResponseTypes.instanceOf(StringMeasurement.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

