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
 * Subscriber for VolumeFlowRate related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("volumeFlowRate-subscriber")
public class VolumeFlowRateSubscriber extends BaseSubscriber {

	public VolumeFlowRateSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<VolumeFlowRate>, VolumeFlowRate> volumeFlowRateSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllVolumeFlowRateQuery(), 
                		ResponseTypes.multipleInstancesOf(VolumeFlowRate.class),
                		ResponseTypes.instanceOf(VolumeFlowRate.class));
    }

    public SubscriptionQueryResult<VolumeFlowRate, VolumeFlowRate> volumeFlowRateSubscribe(@DestinationVariable UUID volumeFlowRateId) {
        return queryGateway
                .subscriptionQuery(new FindVolumeFlowRateQuery(new LoadVolumeFlowRateFilter(volumeFlowRateId)), 
                		ResponseTypes.instanceOf(VolumeFlowRate.class),
                		ResponseTypes.instanceOf(VolumeFlowRate.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

