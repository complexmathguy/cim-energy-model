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
 * Subscriber for ExcIEEEST3A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEST3A-subscriber")
public class ExcIEEEST3ASubscriber extends BaseSubscriber {

	public ExcIEEEST3ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcIEEEST3A>, ExcIEEEST3A> excIEEEST3ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcIEEEST3AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcIEEEST3A.class),
                		ResponseTypes.instanceOf(ExcIEEEST3A.class));
    }

    public SubscriptionQueryResult<ExcIEEEST3A, ExcIEEEST3A> excIEEEST3ASubscribe(@DestinationVariable UUID excIEEEST3AId) {
        return queryGateway
                .subscriptionQuery(new FindExcIEEEST3AQuery(new LoadExcIEEEST3AFilter(excIEEEST3AId)), 
                		ResponseTypes.instanceOf(ExcIEEEST3A.class),
                		ResponseTypes.instanceOf(ExcIEEEST3A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

