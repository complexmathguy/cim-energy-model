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
 * Subscriber for ExcSCRX related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excSCRX-subscriber")
public class ExcSCRXSubscriber extends BaseSubscriber {

	public ExcSCRXSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcSCRX>, ExcSCRX> excSCRXSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcSCRXQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcSCRX.class),
                		ResponseTypes.instanceOf(ExcSCRX.class));
    }

    public SubscriptionQueryResult<ExcSCRX, ExcSCRX> excSCRXSubscribe(@DestinationVariable UUID excSCRXId) {
        return queryGateway
                .subscriptionQuery(new FindExcSCRXQuery(new LoadExcSCRXFilter(excSCRXId)), 
                		ResponseTypes.instanceOf(ExcSCRX.class),
                		ResponseTypes.instanceOf(ExcSCRX.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

