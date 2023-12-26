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
 * Subscriber for ExcSEXS related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("excSEXS-subscriber")
public class ExcSEXSSubscriber extends BaseSubscriber {

	public ExcSEXSSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ExcSEXS>, ExcSEXS> excSEXSSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllExcSEXSQuery(), 
                		ResponseTypes.multipleInstancesOf(ExcSEXS.class),
                		ResponseTypes.instanceOf(ExcSEXS.class));
    }

    public SubscriptionQueryResult<ExcSEXS, ExcSEXS> excSEXSSubscribe(@DestinationVariable UUID excSEXSId) {
        return queryGateway
                .subscriptionQuery(new FindExcSEXSQuery(new LoadExcSEXSFilter(excSEXSId)), 
                		ResponseTypes.instanceOf(ExcSEXS.class),
                		ResponseTypes.instanceOf(ExcSEXS.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

