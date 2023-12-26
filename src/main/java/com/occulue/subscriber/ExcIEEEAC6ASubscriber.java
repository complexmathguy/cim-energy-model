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
 * Subscriber for ExcIEEEAC6A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC6A-subscriber")
public class ExcIEEEAC6ASubscriber extends BaseSubscriber {

	public ExcIEEEAC6ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcIEEEAC6A>, ExcIEEEAC6A> excIEEEAC6ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcIEEEAC6AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcIEEEAC6A.class),
                		ResponseTypes.instanceOf(ExcIEEEAC6A.class));
    }

    public SubscriptionQueryResult<ExcIEEEAC6A, ExcIEEEAC6A> excIEEEAC6ASubscribe(@DestinationVariable UUID excIEEEAC6AId) {
        return queryGateway
                .subscriptionQuery(new FindExcIEEEAC6AQuery(new LoadExcIEEEAC6AFilter(excIEEEAC6AId)), 
                		ResponseTypes.instanceOf(ExcIEEEAC6A.class),
                		ResponseTypes.instanceOf(ExcIEEEAC6A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

