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
 * Subscriber for StringMeasurementValue related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("stringMeasurementValue-subscriber")
public class StringMeasurementValueSubscriber extends BaseSubscriber {

	public StringMeasurementValueSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<StringMeasurementValue>, StringMeasurementValue> stringMeasurementValueSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllStringMeasurementValueQuery(), 
                		ResponseTypes.multipleInstancesOf(StringMeasurementValue.class),
                		ResponseTypes.instanceOf(StringMeasurementValue.class));
    }

    public SubscriptionQueryResult<StringMeasurementValue, StringMeasurementValue> stringMeasurementValueSubscribe(@DestinationVariable UUID stringMeasurementValueId) {
        return queryGateway
                .subscriptionQuery(new FindStringMeasurementValueQuery(new LoadStringMeasurementValueFilter(stringMeasurementValueId)), 
                		ResponseTypes.instanceOf(StringMeasurementValue.class),
                		ResponseTypes.instanceOf(StringMeasurementValue.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

