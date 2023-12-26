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
 * Subscriber for GovGAST related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("govGAST-subscriber")
public class GovGASTSubscriber extends BaseSubscriber {

	public GovGASTSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<GovGAST>, GovGAST> govGASTSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllGovGASTQuery(), 
                		ResponseTypes.multipleInstancesOf(GovGAST.class),
                		ResponseTypes.instanceOf(GovGAST.class));
    }

    public SubscriptionQueryResult<GovGAST, GovGAST> govGASTSubscribe(@DestinationVariable UUID govGASTId) {
        return queryGateway
                .subscriptionQuery(new FindGovGASTQuery(new LoadGovGASTFilter(govGASTId)), 
                		ResponseTypes.instanceOf(GovGAST.class),
                		ResponseTypes.instanceOf(GovGAST.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

