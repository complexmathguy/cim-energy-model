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
 * Subscriber for ExcBBC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excBBC-subscriber")
public class ExcBBCSubscriber extends BaseSubscriber {

	public ExcBBCSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcBBC>, ExcBBC> excBBCSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcBBCQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcBBC.class),
                		ResponseTypes.instanceOf(ExcBBC.class));
    }

    public SubscriptionQueryResult<ExcBBC, ExcBBC> excBBCSubscribe(@DestinationVariable UUID excBBCId) {
        return queryGateway
                .subscriptionQuery(new FindExcBBCQuery(new LoadExcBBCFilter(excBBCId)), 
                		ResponseTypes.instanceOf(ExcBBC.class),
                		ResponseTypes.instanceOf(ExcBBC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

