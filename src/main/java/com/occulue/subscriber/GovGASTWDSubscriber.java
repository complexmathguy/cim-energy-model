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
 * Subscriber for GovGASTWD related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govGASTWD-subscriber")
public class GovGASTWDSubscriber extends BaseSubscriber {

	public GovGASTWDSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovGASTWD>, GovGASTWD> govGASTWDSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovGASTWDQuery(), 
                		ResponseTypes.multipleInstancesOf(GovGASTWD.class),
                		ResponseTypes.instanceOf(GovGASTWD.class));
    }

    public SubscriptionQueryResult<GovGASTWD, GovGASTWD> govGASTWDSubscribe(@DestinationVariable UUID govGASTWDId) {
        return queryGateway
                .subscriptionQuery(new FindGovGASTWDQuery(new LoadGovGASTWDFilter(govGASTWDId)), 
                		ResponseTypes.instanceOf(GovGASTWD.class),
                		ResponseTypes.instanceOf(GovGASTWD.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

