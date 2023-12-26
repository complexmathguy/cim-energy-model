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
 * Subscriber for ExcAVR3 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excAVR3-subscriber")
public class ExcAVR3Subscriber extends BaseSubscriber {

	public ExcAVR3Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcAVR3>, ExcAVR3> excAVR3Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcAVR3Query(), 
                		ResponseTypes.multipleInstancesOf(ExcAVR3.class),
                		ResponseTypes.instanceOf(ExcAVR3.class));
    }

    public SubscriptionQueryResult<ExcAVR3, ExcAVR3> excAVR3Subscribe(@DestinationVariable UUID excAVR3Id) {
        return queryGateway
                .subscriptionQuery(new FindExcAVR3Query(new LoadExcAVR3Filter(excAVR3Id)), 
                		ResponseTypes.instanceOf(ExcAVR3.class),
                		ResponseTypes.instanceOf(ExcAVR3.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

