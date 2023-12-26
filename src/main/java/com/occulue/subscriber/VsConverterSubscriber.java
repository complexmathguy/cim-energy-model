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
 * Subscriber for VsConverter related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("vsConverter-subscriber")
public class VsConverterSubscriber extends BaseSubscriber {

	public VsConverterSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<VsConverter>, VsConverter> vsConverterSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllVsConverterQuery(), 
                		ResponseTypes.multipleInstancesOf(VsConverter.class),
                		ResponseTypes.instanceOf(VsConverter.class));
    }

    public SubscriptionQueryResult<VsConverter, VsConverter> vsConverterSubscribe(@DestinationVariable UUID vsConverterId) {
        return queryGateway
                .subscriptionQuery(new FindVsConverterQuery(new LoadVsConverterFilter(vsConverterId)), 
                		ResponseTypes.instanceOf(VsConverter.class),
                		ResponseTypes.instanceOf(VsConverter.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

