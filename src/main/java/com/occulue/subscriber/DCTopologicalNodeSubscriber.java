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
 * Subscriber for DCTopologicalNode related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCTopologicalNode-subscriber")
public class DCTopologicalNodeSubscriber extends BaseSubscriber {

	public DCTopologicalNodeSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCTopologicalNode>, DCTopologicalNode> dCTopologicalNodeSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCTopologicalNodeQuery(), 
                		ResponseTypes.multipleInstancesOf(DCTopologicalNode.class),
                		ResponseTypes.instanceOf(DCTopologicalNode.class));
    }

    public SubscriptionQueryResult<DCTopologicalNode, DCTopologicalNode> dCTopologicalNodeSubscribe(@DestinationVariable UUID dCTopologicalNodeId) {
        return queryGateway
                .subscriptionQuery(new FindDCTopologicalNodeQuery(new LoadDCTopologicalNodeFilter(dCTopologicalNodeId)), 
                		ResponseTypes.instanceOf(DCTopologicalNode.class),
                		ResponseTypes.instanceOf(DCTopologicalNode.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

