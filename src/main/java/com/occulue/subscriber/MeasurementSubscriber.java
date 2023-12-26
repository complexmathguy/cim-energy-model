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
 * Subscriber for Measurement related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("measurement-subscriber")
public class MeasurementSubscriber extends BaseSubscriber {

	public MeasurementSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Measurement>, Measurement> measurementSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllMeasurementQuery(), 
                		ResponseTypes.multipleInstancesOf(Measurement.class),
                		ResponseTypes.instanceOf(Measurement.class));
    }

    public SubscriptionQueryResult<Measurement, Measurement> measurementSubscribe(@DestinationVariable UUID measurementId) {
        return queryGateway
                .subscriptionQuery(new FindMeasurementQuery(new LoadMeasurementFilter(measurementId)), 
                		ResponseTypes.instanceOf(Measurement.class),
                		ResponseTypes.instanceOf(Measurement.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

