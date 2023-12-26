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
 * Subscriber for ExcDC3A1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excDC3A1-subscriber")
public class ExcDC3A1Subscriber extends BaseSubscriber {

	public ExcDC3A1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcDC3A1>, ExcDC3A1> excDC3A1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcDC3A1Query(), 
                		ResponseTypes.multipleInstancesOf(ExcDC3A1.class),
                		ResponseTypes.instanceOf(ExcDC3A1.class));
    }

    public SubscriptionQueryResult<ExcDC3A1, ExcDC3A1> excDC3A1Subscribe(@DestinationVariable UUID excDC3A1Id) {
        return queryGateway
                .subscriptionQuery(new FindExcDC3A1Query(new LoadExcDC3A1Filter(excDC3A1Id)), 
                		ResponseTypes.instanceOf(ExcDC3A1.class),
                		ResponseTypes.instanceOf(ExcDC3A1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

