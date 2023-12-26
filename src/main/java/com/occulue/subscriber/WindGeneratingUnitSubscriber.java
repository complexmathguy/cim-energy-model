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
 * Subscriber for WindGeneratingUnit related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windGeneratingUnit-subscriber")
public class WindGeneratingUnitSubscriber extends BaseSubscriber {

	public WindGeneratingUnitSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindGeneratingUnit>, WindGeneratingUnit> windGeneratingUnitSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindGeneratingUnitQuery(), 
                		ResponseTypes.multipleInstancesOf(WindGeneratingUnit.class),
                		ResponseTypes.instanceOf(WindGeneratingUnit.class));
    }

    public SubscriptionQueryResult<WindGeneratingUnit, WindGeneratingUnit> windGeneratingUnitSubscribe(@DestinationVariable UUID windGeneratingUnitId) {
        return queryGateway
                .subscriptionQuery(new FindWindGeneratingUnitQuery(new LoadWindGeneratingUnitFilter(windGeneratingUnitId)), 
                		ResponseTypes.instanceOf(WindGeneratingUnit.class),
                		ResponseTypes.instanceOf(WindGeneratingUnit.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

