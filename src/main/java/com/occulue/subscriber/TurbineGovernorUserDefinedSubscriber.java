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
 * Subscriber for TurbineGovernorUserDefined related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("turbineGovernorUserDefined-subscriber")
public class TurbineGovernorUserDefinedSubscriber extends BaseSubscriber {

	public TurbineGovernorUserDefinedSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TurbineGovernorUserDefined>, TurbineGovernorUserDefined> turbineGovernorUserDefinedSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTurbineGovernorUserDefinedQuery(), 
                		ResponseTypes.multipleInstancesOf(TurbineGovernorUserDefined.class),
                		ResponseTypes.instanceOf(TurbineGovernorUserDefined.class));
    }

    public SubscriptionQueryResult<TurbineGovernorUserDefined, TurbineGovernorUserDefined> turbineGovernorUserDefinedSubscribe(@DestinationVariable UUID turbineGovernorUserDefinedId) {
        return queryGateway
                .subscriptionQuery(new FindTurbineGovernorUserDefinedQuery(new LoadTurbineGovernorUserDefinedFilter(turbineGovernorUserDefinedId)), 
                		ResponseTypes.instanceOf(TurbineGovernorUserDefined.class),
                		ResponseTypes.instanceOf(TurbineGovernorUserDefined.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

