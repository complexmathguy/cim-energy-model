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
 * Subscriber for Money related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("money-subscriber")
public class MoneySubscriber extends BaseSubscriber {

	public MoneySubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Money>, Money> moneySubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllMoneyQuery(), 
                		ResponseTypes.multipleInstancesOf(Money.class),
                		ResponseTypes.instanceOf(Money.class));
    }

    public SubscriptionQueryResult<Money, Money> moneySubscribe(@DestinationVariable UUID moneyId) {
        return queryGateway
                .subscriptionQuery(new FindMoneyQuery(new LoadMoneyFilter(moneyId)), 
                		ResponseTypes.instanceOf(Money.class),
                		ResponseTypes.instanceOf(Money.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

