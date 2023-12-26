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
 * Subscriber for DCBaseTerminal related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCBaseTerminal-subscriber")
public class DCBaseTerminalSubscriber extends BaseSubscriber {

	public DCBaseTerminalSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCBaseTerminal>, DCBaseTerminal> dCBaseTerminalSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCBaseTerminalQuery(), 
                		ResponseTypes.multipleInstancesOf(DCBaseTerminal.class),
                		ResponseTypes.instanceOf(DCBaseTerminal.class));
    }

    public SubscriptionQueryResult<DCBaseTerminal, DCBaseTerminal> dCBaseTerminalSubscribe(@DestinationVariable UUID dCBaseTerminalId) {
        return queryGateway
                .subscriptionQuery(new FindDCBaseTerminalQuery(new LoadDCBaseTerminalFilter(dCBaseTerminalId)), 
                		ResponseTypes.instanceOf(DCBaseTerminal.class),
                		ResponseTypes.instanceOf(DCBaseTerminal.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

