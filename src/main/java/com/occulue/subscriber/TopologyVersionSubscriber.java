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
 * Subscriber for TopologyVersion related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("topologyVersion-subscriber")
public class TopologyVersionSubscriber extends BaseSubscriber {

	public TopologyVersionSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TopologyVersion>, TopologyVersion> topologyVersionSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTopologyVersionQuery(), 
                		ResponseTypes.multipleInstancesOf(TopologyVersion.class),
                		ResponseTypes.instanceOf(TopologyVersion.class));
    }

    public SubscriptionQueryResult<TopologyVersion, TopologyVersion> topologyVersionSubscribe(@DestinationVariable UUID topologyVersionId) {
        return queryGateway
                .subscriptionQuery(new FindTopologyVersionQuery(new LoadTopologyVersionFilter(topologyVersionId)), 
                		ResponseTypes.instanceOf(TopologyVersion.class),
                		ResponseTypes.instanceOf(TopologyVersion.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

