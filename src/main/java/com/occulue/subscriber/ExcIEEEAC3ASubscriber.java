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
 * Subscriber for ExcIEEEAC3A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC3A-subscriber")
public class ExcIEEEAC3ASubscriber extends BaseSubscriber {

	public ExcIEEEAC3ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcIEEEAC3A>, ExcIEEEAC3A> excIEEEAC3ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcIEEEAC3AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcIEEEAC3A.class),
                		ResponseTypes.instanceOf(ExcIEEEAC3A.class));
    }

    public SubscriptionQueryResult<ExcIEEEAC3A, ExcIEEEAC3A> excIEEEAC3ASubscribe(@DestinationVariable UUID excIEEEAC3AId) {
        return queryGateway
                .subscriptionQuery(new FindExcIEEEAC3AQuery(new LoadExcIEEEAC3AFilter(excIEEEAC3AId)), 
                		ResponseTypes.instanceOf(ExcIEEEAC3A.class),
                		ResponseTypes.instanceOf(ExcIEEEAC3A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

