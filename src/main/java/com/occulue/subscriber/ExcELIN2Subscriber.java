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
 * Subscriber for ExcELIN2 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excELIN2-subscriber")
public class ExcELIN2Subscriber extends BaseSubscriber {

	public ExcELIN2Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcELIN2>, ExcELIN2> excELIN2Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcELIN2Query(), 
                		ResponseTypes.multipleInstancesOf(ExcELIN2.class),
                		ResponseTypes.instanceOf(ExcELIN2.class));
    }

    public SubscriptionQueryResult<ExcELIN2, ExcELIN2> excELIN2Subscribe(@DestinationVariable UUID excELIN2Id) {
        return queryGateway
                .subscriptionQuery(new FindExcELIN2Query(new LoadExcELIN2Filter(excELIN2Id)), 
                		ResponseTypes.instanceOf(ExcELIN2.class),
                		ResponseTypes.instanceOf(ExcELIN2.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

