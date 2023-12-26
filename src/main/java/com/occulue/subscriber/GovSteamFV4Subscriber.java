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
 * Subscriber for GovSteamFV4 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govSteamFV4-subscriber")
public class GovSteamFV4Subscriber extends BaseSubscriber {

	public GovSteamFV4Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovSteamFV4>, GovSteamFV4> govSteamFV4Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovSteamFV4Query(), 
                		ResponseTypes.multipleInstancesOf(GovSteamFV4.class),
                		ResponseTypes.instanceOf(GovSteamFV4.class));
    }

    public SubscriptionQueryResult<GovSteamFV4, GovSteamFV4> govSteamFV4Subscribe(@DestinationVariable UUID govSteamFV4Id) {
        return queryGateway
                .subscriptionQuery(new FindGovSteamFV4Query(new LoadGovSteamFV4Filter(govSteamFV4Id)), 
                		ResponseTypes.instanceOf(GovSteamFV4.class),
                		ResponseTypes.instanceOf(GovSteamFV4.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

