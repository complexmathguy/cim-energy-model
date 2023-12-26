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
 * Subscriber for EquivalentBranch related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("equivalentBranch-subscriber")
public class EquivalentBranchSubscriber extends BaseSubscriber {

	public EquivalentBranchSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<EquivalentBranch>, EquivalentBranch> equivalentBranchSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllEquivalentBranchQuery(), 
                		ResponseTypes.multipleInstancesOf(EquivalentBranch.class),
                		ResponseTypes.instanceOf(EquivalentBranch.class));
    }

    public SubscriptionQueryResult<EquivalentBranch, EquivalentBranch> equivalentBranchSubscribe(@DestinationVariable UUID equivalentBranchId) {
        return queryGateway
                .subscriptionQuery(new FindEquivalentBranchQuery(new LoadEquivalentBranchFilter(equivalentBranchId)), 
                		ResponseTypes.instanceOf(EquivalentBranch.class),
                		ResponseTypes.instanceOf(EquivalentBranch.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

