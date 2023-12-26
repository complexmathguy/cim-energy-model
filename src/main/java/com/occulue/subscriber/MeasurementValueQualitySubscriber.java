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
 * Subscriber for MeasurementValueQuality related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("measurementValueQuality-subscriber")
public class MeasurementValueQualitySubscriber extends BaseSubscriber {

	public MeasurementValueQualitySubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<MeasurementValueQuality>, MeasurementValueQuality> measurementValueQualitySubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllMeasurementValueQualityQuery(), 
                		ResponseTypes.multipleInstancesOf(MeasurementValueQuality.class),
                		ResponseTypes.instanceOf(MeasurementValueQuality.class));
    }

    public SubscriptionQueryResult<MeasurementValueQuality, MeasurementValueQuality> measurementValueQualitySubscribe(@DestinationVariable UUID measurementValueQualityId) {
        return queryGateway
                .subscriptionQuery(new FindMeasurementValueQualityQuery(new LoadMeasurementValueQualityFilter(measurementValueQualityId)), 
                		ResponseTypes.instanceOf(MeasurementValueQuality.class),
                		ResponseTypes.instanceOf(MeasurementValueQuality.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

