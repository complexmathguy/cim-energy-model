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
 * Subscriber for Diagram related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("diagram-subscriber")
public class DiagramSubscriber extends BaseSubscriber {

	public DiagramSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Diagram>, Diagram> diagramSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDiagramQuery(), 
                		ResponseTypes.multipleInstancesOf(Diagram.class),
                		ResponseTypes.instanceOf(Diagram.class));
    }

    public SubscriptionQueryResult<Diagram, Diagram> diagramSubscribe(@DestinationVariable UUID diagramId) {
        return queryGateway
                .subscriptionQuery(new FindDiagramQuery(new LoadDiagramFilter(diagramId)), 
                		ResponseTypes.instanceOf(Diagram.class),
                		ResponseTypes.instanceOf(Diagram.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

