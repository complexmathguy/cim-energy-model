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
 * Subscriber for TextDiagramObject related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("textDiagramObject-subscriber")
public class TextDiagramObjectSubscriber extends BaseSubscriber {

	public TextDiagramObjectSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TextDiagramObject>, TextDiagramObject> textDiagramObjectSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTextDiagramObjectQuery(), 
                		ResponseTypes.multipleInstancesOf(TextDiagramObject.class),
                		ResponseTypes.instanceOf(TextDiagramObject.class));
    }

    public SubscriptionQueryResult<TextDiagramObject, TextDiagramObject> textDiagramObjectSubscribe(@DestinationVariable UUID textDiagramObjectId) {
        return queryGateway
                .subscriptionQuery(new FindTextDiagramObjectQuery(new LoadTextDiagramObjectFilter(textDiagramObjectId)), 
                		ResponseTypes.instanceOf(TextDiagramObject.class),
                		ResponseTypes.instanceOf(TextDiagramObject.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

