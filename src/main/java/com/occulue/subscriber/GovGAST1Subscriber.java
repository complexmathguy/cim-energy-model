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
 * Subscriber for GovGAST1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govGAST1-subscriber")
public class GovGAST1Subscriber extends BaseSubscriber {

	public GovGAST1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovGAST1>, GovGAST1> govGAST1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovGAST1Query(), 
                		ResponseTypes.multipleInstancesOf(GovGAST1.class),
                		ResponseTypes.instanceOf(GovGAST1.class));
    }

    public SubscriptionQueryResult<GovGAST1, GovGAST1> govGAST1Subscribe(@DestinationVariable UUID govGAST1Id) {
        return queryGateway
                .subscriptionQuery(new FindGovGAST1Query(new LoadGovGAST1Filter(govGAST1Id)), 
                		ResponseTypes.instanceOf(GovGAST1.class),
                		ResponseTypes.instanceOf(GovGAST1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

