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
 * Subscriber for DiagramObjectStyle related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("diagramObjectStyle-subscriber")
public class DiagramObjectStyleSubscriber extends BaseSubscriber {

	public DiagramObjectStyleSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DiagramObjectStyle>, DiagramObjectStyle> diagramObjectStyleSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDiagramObjectStyleQuery(), 
                		ResponseTypes.multipleInstancesOf(DiagramObjectStyle.class),
                		ResponseTypes.instanceOf(DiagramObjectStyle.class));
    }

    public SubscriptionQueryResult<DiagramObjectStyle, DiagramObjectStyle> diagramObjectStyleSubscribe(@DestinationVariable UUID diagramObjectStyleId) {
        return queryGateway
                .subscriptionQuery(new FindDiagramObjectStyleQuery(new LoadDiagramObjectStyleFilter(diagramObjectStyleId)), 
                		ResponseTypes.instanceOf(DiagramObjectStyle.class),
                		ResponseTypes.instanceOf(DiagramObjectStyle.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

