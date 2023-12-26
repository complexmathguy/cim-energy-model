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
 * Subscriber for GovSteamIEEE1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govSteamIEEE1-subscriber")
public class GovSteamIEEE1Subscriber extends BaseSubscriber {

	public GovSteamIEEE1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovSteamIEEE1>, GovSteamIEEE1> govSteamIEEE1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovSteamIEEE1Query(), 
                		ResponseTypes.multipleInstancesOf(GovSteamIEEE1.class),
                		ResponseTypes.instanceOf(GovSteamIEEE1.class));
    }

    public SubscriptionQueryResult<GovSteamIEEE1, GovSteamIEEE1> govSteamIEEE1Subscribe(@DestinationVariable UUID govSteamIEEE1Id) {
        return queryGateway
                .subscriptionQuery(new FindGovSteamIEEE1Query(new LoadGovSteamIEEE1Filter(govSteamIEEE1Id)), 
                		ResponseTypes.instanceOf(GovSteamIEEE1.class),
                		ResponseTypes.instanceOf(GovSteamIEEE1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

