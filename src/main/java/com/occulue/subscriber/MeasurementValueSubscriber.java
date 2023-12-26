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
 * Subscriber for MeasurementValue related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("measurementValue-subscriber")
public class MeasurementValueSubscriber extends BaseSubscriber {

	public MeasurementValueSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<MeasurementValue>, MeasurementValue> measurementValueSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllMeasurementValueQuery(), 
                		ResponseTypes.multipleInstancesOf(MeasurementValue.class),
                		ResponseTypes.instanceOf(MeasurementValue.class));
    }

    public SubscriptionQueryResult<MeasurementValue, MeasurementValue> measurementValueSubscribe(@DestinationVariable UUID measurementValueId) {
        return queryGateway
                .subscriptionQuery(new FindMeasurementValueQuery(new LoadMeasurementValueFilter(measurementValueId)), 
                		ResponseTypes.instanceOf(MeasurementValue.class),
                		ResponseTypes.instanceOf(MeasurementValue.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

