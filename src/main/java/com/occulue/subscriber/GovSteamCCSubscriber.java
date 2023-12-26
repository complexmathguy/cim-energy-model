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
 * Subscriber for GovSteamCC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govSteamCC-subscriber")
public class GovSteamCCSubscriber extends BaseSubscriber {

	public GovSteamCCSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovSteamCC>, GovSteamCC> govSteamCCSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovSteamCCQuery(), 
                		ResponseTypes.multipleInstancesOf(GovSteamCC.class),
                		ResponseTypes.instanceOf(GovSteamCC.class));
    }

    public SubscriptionQueryResult<GovSteamCC, GovSteamCC> govSteamCCSubscribe(@DestinationVariable UUID govSteamCCId) {
        return queryGateway
                .subscriptionQuery(new FindGovSteamCCQuery(new LoadGovSteamCCFilter(govSteamCCId)), 
                		ResponseTypes.instanceOf(GovSteamCC.class),
                		ResponseTypes.instanceOf(GovSteamCC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

