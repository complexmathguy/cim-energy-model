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
 * Subscriber for Season related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("season-subscriber")
public class SeasonSubscriber extends BaseSubscriber {

	public SeasonSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Season>, Season> seasonSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSeasonQuery(), 
                		ResponseTypes.multipleInstancesOf(Season.class),
                		ResponseTypes.instanceOf(Season.class));
    }

    public SubscriptionQueryResult<Season, Season> seasonSubscribe(@DestinationVariable UUID seasonId) {
        return queryGateway
                .subscriptionQuery(new FindSeasonQuery(new LoadSeasonFilter(seasonId)), 
                		ResponseTypes.instanceOf(Season.class),
                		ResponseTypes.instanceOf(Season.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

