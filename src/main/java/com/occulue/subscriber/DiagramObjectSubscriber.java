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
 * Subscriber for DiagramObject related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("diagramObject-subscriber")
public class DiagramObjectSubscriber extends BaseSubscriber {

	public DiagramObjectSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DiagramObject>, DiagramObject> diagramObjectSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDiagramObjectQuery(), 
                		ResponseTypes.multipleInstancesOf(DiagramObject.class),
                		ResponseTypes.instanceOf(DiagramObject.class));
    }

    public SubscriptionQueryResult<DiagramObject, DiagramObject> diagramObjectSubscribe(@DestinationVariable UUID diagramObjectId) {
        return queryGateway
                .subscriptionQuery(new FindDiagramObjectQuery(new LoadDiagramObjectFilter(diagramObjectId)), 
                		ResponseTypes.instanceOf(DiagramObject.class),
                		ResponseTypes.instanceOf(DiagramObject.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

