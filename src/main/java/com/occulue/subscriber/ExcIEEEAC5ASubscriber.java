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
 * Subscriber for ExcIEEEAC5A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC5A-subscriber")
public class ExcIEEEAC5ASubscriber extends BaseSubscriber {

	public ExcIEEEAC5ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcIEEEAC5A>, ExcIEEEAC5A> excIEEEAC5ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcIEEEAC5AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcIEEEAC5A.class),
                		ResponseTypes.instanceOf(ExcIEEEAC5A.class));
    }

    public SubscriptionQueryResult<ExcIEEEAC5A, ExcIEEEAC5A> excIEEEAC5ASubscribe(@DestinationVariable UUID excIEEEAC5AId) {
        return queryGateway
                .subscriptionQuery(new FindExcIEEEAC5AQuery(new LoadExcIEEEAC5AFilter(excIEEEAC5AId)), 
                		ResponseTypes.instanceOf(ExcIEEEAC5A.class),
                		ResponseTypes.instanceOf(ExcIEEEAC5A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

