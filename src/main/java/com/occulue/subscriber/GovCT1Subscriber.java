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
 * Subscriber for GovCT1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govCT1-subscriber")
public class GovCT1Subscriber extends BaseSubscriber {

	public GovCT1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovCT1>, GovCT1> govCT1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovCT1Query(), 
                		ResponseTypes.multipleInstancesOf(GovCT1.class),
                		ResponseTypes.instanceOf(GovCT1.class));
    }

    public SubscriptionQueryResult<GovCT1, GovCT1> govCT1Subscribe(@DestinationVariable UUID govCT1Id) {
        return queryGateway
                .subscriptionQuery(new FindGovCT1Query(new LoadGovCT1Filter(govCT1Id)), 
                		ResponseTypes.instanceOf(GovCT1.class),
                		ResponseTypes.instanceOf(GovCT1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

