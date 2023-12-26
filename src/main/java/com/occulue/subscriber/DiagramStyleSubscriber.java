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
 * Subscriber for DiagramStyle related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("diagramStyle-subscriber")
public class DiagramStyleSubscriber extends BaseSubscriber {

	public DiagramStyleSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DiagramStyle>, DiagramStyle> diagramStyleSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDiagramStyleQuery(), 
                		ResponseTypes.multipleInstancesOf(DiagramStyle.class),
                		ResponseTypes.instanceOf(DiagramStyle.class));
    }

    public SubscriptionQueryResult<DiagramStyle, DiagramStyle> diagramStyleSubscribe(@DestinationVariable UUID diagramStyleId) {
        return queryGateway
                .subscriptionQuery(new FindDiagramStyleQuery(new LoadDiagramStyleFilter(diagramStyleId)), 
                		ResponseTypes.instanceOf(DiagramStyle.class),
                		ResponseTypes.instanceOf(DiagramStyle.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

