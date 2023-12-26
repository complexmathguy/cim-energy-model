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
 * Subscriber for ExcIEEEAC1A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC1A-subscriber")
public class ExcIEEEAC1ASubscriber extends BaseSubscriber {

	public ExcIEEEAC1ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcIEEEAC1A>, ExcIEEEAC1A> excIEEEAC1ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcIEEEAC1AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcIEEEAC1A.class),
                		ResponseTypes.instanceOf(ExcIEEEAC1A.class));
    }

    public SubscriptionQueryResult<ExcIEEEAC1A, ExcIEEEAC1A> excIEEEAC1ASubscribe(@DestinationVariable UUID excIEEEAC1AId) {
        return queryGateway
                .subscriptionQuery(new FindExcIEEEAC1AQuery(new LoadExcIEEEAC1AFilter(excIEEEAC1AId)), 
                		ResponseTypes.instanceOf(ExcIEEEAC1A.class),
                		ResponseTypes.instanceOf(ExcIEEEAC1A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

