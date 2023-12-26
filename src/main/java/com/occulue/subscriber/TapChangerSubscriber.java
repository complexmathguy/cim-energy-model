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
 * Subscriber for TapChanger related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("tapChanger-subscriber")
public class TapChangerSubscriber extends BaseSubscriber {

	public TapChangerSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TapChanger>, TapChanger> tapChangerSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTapChangerQuery(), 
                		ResponseTypes.multipleInstancesOf(TapChanger.class),
                		ResponseTypes.instanceOf(TapChanger.class));
    }

    public SubscriptionQueryResult<TapChanger, TapChanger> tapChangerSubscribe(@DestinationVariable UUID tapChangerId) {
        return queryGateway
                .subscriptionQuery(new FindTapChangerQuery(new LoadTapChangerFilter(tapChangerId)), 
                		ResponseTypes.instanceOf(TapChanger.class),
                		ResponseTypes.instanceOf(TapChanger.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

