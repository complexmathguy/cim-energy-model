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
 * Subscriber for GovGAST4 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govGAST4-subscriber")
public class GovGAST4Subscriber extends BaseSubscriber {

	public GovGAST4Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovGAST4>, GovGAST4> govGAST4Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovGAST4Query(), 
                		ResponseTypes.multipleInstancesOf(GovGAST4.class),
                		ResponseTypes.instanceOf(GovGAST4.class));
    }

    public SubscriptionQueryResult<GovGAST4, GovGAST4> govGAST4Subscribe(@DestinationVariable UUID govGAST4Id) {
        return queryGateway
                .subscriptionQuery(new FindGovGAST4Query(new LoadGovGAST4Filter(govGAST4Id)), 
                		ResponseTypes.instanceOf(GovGAST4.class),
                		ResponseTypes.instanceOf(GovGAST4.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

