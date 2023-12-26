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
 * Subscriber for ExcIEEEST1A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEST1A-subscriber")
public class ExcIEEEST1ASubscriber extends BaseSubscriber {

	public ExcIEEEST1ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcIEEEST1A>, ExcIEEEST1A> excIEEEST1ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcIEEEST1AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcIEEEST1A.class),
                		ResponseTypes.instanceOf(ExcIEEEST1A.class));
    }

    public SubscriptionQueryResult<ExcIEEEST1A, ExcIEEEST1A> excIEEEST1ASubscribe(@DestinationVariable UUID excIEEEST1AId) {
        return queryGateway
                .subscriptionQuery(new FindExcIEEEST1AQuery(new LoadExcIEEEST1AFilter(excIEEEST1AId)), 
                		ResponseTypes.instanceOf(ExcIEEEST1A.class),
                		ResponseTypes.instanceOf(ExcIEEEST1A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

