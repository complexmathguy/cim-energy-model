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
 * Subscriber for TapChangerTablePoint related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("tapChangerTablePoint-subscriber")
public class TapChangerTablePointSubscriber extends BaseSubscriber {

	public TapChangerTablePointSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TapChangerTablePoint>, TapChangerTablePoint> tapChangerTablePointSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTapChangerTablePointQuery(), 
                		ResponseTypes.multipleInstancesOf(TapChangerTablePoint.class),
                		ResponseTypes.instanceOf(TapChangerTablePoint.class));
    }

    public SubscriptionQueryResult<TapChangerTablePoint, TapChangerTablePoint> tapChangerTablePointSubscribe(@DestinationVariable UUID tapChangerTablePointId) {
        return queryGateway
                .subscriptionQuery(new FindTapChangerTablePointQuery(new LoadTapChangerTablePointFilter(tapChangerTablePointId)), 
                		ResponseTypes.instanceOf(TapChangerTablePoint.class),
                		ResponseTypes.instanceOf(TapChangerTablePoint.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

