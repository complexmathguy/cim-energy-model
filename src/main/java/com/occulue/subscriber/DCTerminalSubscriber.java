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
 * Subscriber for DCTerminal related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCTerminal-subscriber")
public class DCTerminalSubscriber extends BaseSubscriber {

	public DCTerminalSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCTerminal>, DCTerminal> dCTerminalSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCTerminalQuery(), 
                		ResponseTypes.multipleInstancesOf(DCTerminal.class),
                		ResponseTypes.instanceOf(DCTerminal.class));
    }

    public SubscriptionQueryResult<DCTerminal, DCTerminal> dCTerminalSubscribe(@DestinationVariable UUID dCTerminalId) {
        return queryGateway
                .subscriptionQuery(new FindDCTerminalQuery(new LoadDCTerminalFilter(dCTerminalId)), 
                		ResponseTypes.instanceOf(DCTerminal.class),
                		ResponseTypes.instanceOf(DCTerminal.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

