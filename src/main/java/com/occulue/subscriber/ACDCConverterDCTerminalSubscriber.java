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
 * Subscriber for ACDCConverterDCTerminal related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("aCDCConverterDCTerminal-subscriber")
public class ACDCConverterDCTerminalSubscriber extends BaseSubscriber {

	public ACDCConverterDCTerminalSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ACDCConverterDCTerminal>, ACDCConverterDCTerminal> aCDCConverterDCTerminalSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllACDCConverterDCTerminalQuery(), 
                		ResponseTypes.multipleInstancesOf(ACDCConverterDCTerminal.class),
                		ResponseTypes.instanceOf(ACDCConverterDCTerminal.class));
    }

    public SubscriptionQueryResult<ACDCConverterDCTerminal, ACDCConverterDCTerminal> aCDCConverterDCTerminalSubscribe(@DestinationVariable UUID aCDCConverterDCTerminalId) {
        return queryGateway
                .subscriptionQuery(new FindACDCConverterDCTerminalQuery(new LoadACDCConverterDCTerminalFilter(aCDCConverterDCTerminalId)), 
                		ResponseTypes.instanceOf(ACDCConverterDCTerminal.class),
                		ResponseTypes.instanceOf(ACDCConverterDCTerminal.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

