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
 * Subscriber for ExcIEEEDC2A related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEDC2A-subscriber")
public class ExcIEEEDC2ASubscriber extends BaseSubscriber {

	public ExcIEEEDC2ASubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcIEEEDC2A>, ExcIEEEDC2A> excIEEEDC2ASubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcIEEEDC2AQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcIEEEDC2A.class),
                		ResponseTypes.instanceOf(ExcIEEEDC2A.class));
    }

    public SubscriptionQueryResult<ExcIEEEDC2A, ExcIEEEDC2A> excIEEEDC2ASubscribe(@DestinationVariable UUID excIEEEDC2AId) {
        return queryGateway
                .subscriptionQuery(new FindExcIEEEDC2AQuery(new LoadExcIEEEDC2AFilter(excIEEEDC2AId)), 
                		ResponseTypes.instanceOf(ExcIEEEDC2A.class),
                		ResponseTypes.instanceOf(ExcIEEEDC2A.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

