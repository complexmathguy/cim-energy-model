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
 * Subscriber for HydroGeneratingUnit related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("hydroGeneratingUnit-subscriber")
public class HydroGeneratingUnitSubscriber extends BaseSubscriber {

	public HydroGeneratingUnitSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<HydroGeneratingUnit>, HydroGeneratingUnit> hydroGeneratingUnitSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllHydroGeneratingUnitQuery(), 
                		ResponseTypes.multipleInstancesOf(HydroGeneratingUnit.class),
                		ResponseTypes.instanceOf(HydroGeneratingUnit.class));
    }

    public SubscriptionQueryResult<HydroGeneratingUnit, HydroGeneratingUnit> hydroGeneratingUnitSubscribe(@DestinationVariable UUID hydroGeneratingUnitId) {
        return queryGateway
                .subscriptionQuery(new FindHydroGeneratingUnitQuery(new LoadHydroGeneratingUnitFilter(hydroGeneratingUnitId)), 
                		ResponseTypes.instanceOf(HydroGeneratingUnit.class),
                		ResponseTypes.instanceOf(HydroGeneratingUnit.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

