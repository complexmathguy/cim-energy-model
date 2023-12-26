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
 * Subscriber for TapChangerControl related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("tapChangerControl-subscriber")
public class TapChangerControlSubscriber extends BaseSubscriber {

	public TapChangerControlSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TapChangerControl>, TapChangerControl> tapChangerControlSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTapChangerControlQuery(), 
                		ResponseTypes.multipleInstancesOf(TapChangerControl.class),
                		ResponseTypes.instanceOf(TapChangerControl.class));
    }

    public SubscriptionQueryResult<TapChangerControl, TapChangerControl> tapChangerControlSubscribe(@DestinationVariable UUID tapChangerControlId) {
        return queryGateway
                .subscriptionQuery(new FindTapChangerControlQuery(new LoadTapChangerControlFilter(tapChangerControlId)), 
                		ResponseTypes.instanceOf(TapChangerControl.class),
                		ResponseTypes.instanceOf(TapChangerControl.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

