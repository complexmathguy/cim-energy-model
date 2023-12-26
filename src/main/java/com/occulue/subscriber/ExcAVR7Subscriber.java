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
 * Subscriber for ExcAVR7 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excAVR7-subscriber")
public class ExcAVR7Subscriber extends BaseSubscriber {

	public ExcAVR7Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcAVR7>, ExcAVR7> excAVR7Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcAVR7Query(), 
                		ResponseTypes.multipleInstancesOf(ExcAVR7.class),
                		ResponseTypes.instanceOf(ExcAVR7.class));
    }

    public SubscriptionQueryResult<ExcAVR7, ExcAVR7> excAVR7Subscribe(@DestinationVariable UUID excAVR7Id) {
        return queryGateway
                .subscriptionQuery(new FindExcAVR7Query(new LoadExcAVR7Filter(excAVR7Id)), 
                		ResponseTypes.instanceOf(ExcAVR7.class),
                		ResponseTypes.instanceOf(ExcAVR7.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

