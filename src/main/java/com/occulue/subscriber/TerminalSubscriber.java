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
 * Subscriber for Terminal related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("terminal-subscriber")
public class TerminalSubscriber extends BaseSubscriber {

	public TerminalSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Terminal>, Terminal> terminalSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTerminalQuery(), 
                		ResponseTypes.multipleInstancesOf(Terminal.class),
                		ResponseTypes.instanceOf(Terminal.class));
    }

    public SubscriptionQueryResult<Terminal, Terminal> terminalSubscribe(@DestinationVariable UUID terminalId) {
        return queryGateway
                .subscriptionQuery(new FindTerminalQuery(new LoadTerminalFilter(terminalId)), 
                		ResponseTypes.instanceOf(Terminal.class),
                		ResponseTypes.instanceOf(Terminal.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

