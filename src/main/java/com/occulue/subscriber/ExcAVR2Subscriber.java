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
 * Subscriber for ExcAVR2 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excAVR2-subscriber")
public class ExcAVR2Subscriber extends BaseSubscriber {

	public ExcAVR2Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcAVR2>, ExcAVR2> excAVR2Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcAVR2Query(), 
                		ResponseTypes.multipleInstancesOf(ExcAVR2.class),
                		ResponseTypes.instanceOf(ExcAVR2.class));
    }

    public SubscriptionQueryResult<ExcAVR2, ExcAVR2> excAVR2Subscribe(@DestinationVariable UUID excAVR2Id) {
        return queryGateway
                .subscriptionQuery(new FindExcAVR2Query(new LoadExcAVR2Filter(excAVR2Id)), 
                		ResponseTypes.instanceOf(ExcAVR2.class),
                		ResponseTypes.instanceOf(ExcAVR2.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

