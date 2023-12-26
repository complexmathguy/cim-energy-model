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
 * Subscriber for ExcIEEEDC4B related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEDC4B-subscriber")
public class ExcIEEEDC4BSubscriber extends BaseSubscriber {

	public ExcIEEEDC4BSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcIEEEDC4B>, ExcIEEEDC4B> excIEEEDC4BSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcIEEEDC4BQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcIEEEDC4B.class),
                		ResponseTypes.instanceOf(ExcIEEEDC4B.class));
    }

    public SubscriptionQueryResult<ExcIEEEDC4B, ExcIEEEDC4B> excIEEEDC4BSubscribe(@DestinationVariable UUID excIEEEDC4BId) {
        return queryGateway
                .subscriptionQuery(new FindExcIEEEDC4BQuery(new LoadExcIEEEDC4BFilter(excIEEEDC4BId)), 
                		ResponseTypes.instanceOf(ExcIEEEDC4B.class),
                		ResponseTypes.instanceOf(ExcIEEEDC4B.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

