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
 * Subscriber for DiagramLayoutVersion related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("diagramLayoutVersion-subscriber")
public class DiagramLayoutVersionSubscriber extends BaseSubscriber {

	public DiagramLayoutVersionSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DiagramLayoutVersion>, DiagramLayoutVersion> diagramLayoutVersionSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDiagramLayoutVersionQuery(), 
                		ResponseTypes.multipleInstancesOf(DiagramLayoutVersion.class),
                		ResponseTypes.instanceOf(DiagramLayoutVersion.class));
    }

    public SubscriptionQueryResult<DiagramLayoutVersion, DiagramLayoutVersion> diagramLayoutVersionSubscribe(@DestinationVariable UUID diagramLayoutVersionId) {
        return queryGateway
                .subscriptionQuery(new FindDiagramLayoutVersionQuery(new LoadDiagramLayoutVersionFilter(diagramLayoutVersionId)), 
                		ResponseTypes.instanceOf(DiagramLayoutVersion.class),
                		ResponseTypes.instanceOf(DiagramLayoutVersion.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

