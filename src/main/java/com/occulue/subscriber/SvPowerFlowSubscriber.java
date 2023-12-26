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
 * Subscriber for SvPowerFlow related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("svPowerFlow-subscriber")
public class SvPowerFlowSubscriber extends BaseSubscriber {

	public SvPowerFlowSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SvPowerFlow>, SvPowerFlow> svPowerFlowSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSvPowerFlowQuery(), 
                		ResponseTypes.multipleInstancesOf(SvPowerFlow.class),
                		ResponseTypes.instanceOf(SvPowerFlow.class));
    }

    public SubscriptionQueryResult<SvPowerFlow, SvPowerFlow> svPowerFlowSubscribe(@DestinationVariable UUID svPowerFlowId) {
        return queryGateway
                .subscriptionQuery(new FindSvPowerFlowQuery(new LoadSvPowerFlowFilter(svPowerFlowId)), 
                		ResponseTypes.instanceOf(SvPowerFlow.class),
                		ResponseTypes.instanceOf(SvPowerFlow.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

