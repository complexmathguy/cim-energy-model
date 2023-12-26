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
 * Subscriber for DCSeriesDevice related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCSeriesDevice-subscriber")
public class DCSeriesDeviceSubscriber extends BaseSubscriber {

	public DCSeriesDeviceSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCSeriesDevice>, DCSeriesDevice> dCSeriesDeviceSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCSeriesDeviceQuery(), 
                		ResponseTypes.multipleInstancesOf(DCSeriesDevice.class),
                		ResponseTypes.instanceOf(DCSeriesDevice.class));
    }

    public SubscriptionQueryResult<DCSeriesDevice, DCSeriesDevice> dCSeriesDeviceSubscribe(@DestinationVariable UUID dCSeriesDeviceId) {
        return queryGateway
                .subscriptionQuery(new FindDCSeriesDeviceQuery(new LoadDCSeriesDeviceFilter(dCSeriesDeviceId)), 
                		ResponseTypes.instanceOf(DCSeriesDevice.class),
                		ResponseTypes.instanceOf(DCSeriesDevice.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

