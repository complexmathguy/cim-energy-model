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
 * Subscriber for ApparentPowerLimit related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("apparentPowerLimit-subscriber")
public class ApparentPowerLimitSubscriber extends BaseSubscriber {

	public ApparentPowerLimitSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ApparentPowerLimit>, ApparentPowerLimit> apparentPowerLimitSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllApparentPowerLimitQuery(), 
                		ResponseTypes.multipleInstancesOf(ApparentPowerLimit.class),
                		ResponseTypes.instanceOf(ApparentPowerLimit.class));
    }

    public SubscriptionQueryResult<ApparentPowerLimit, ApparentPowerLimit> apparentPowerLimitSubscribe(@DestinationVariable UUID apparentPowerLimitId) {
        return queryGateway
                .subscriptionQuery(new FindApparentPowerLimitQuery(new LoadApparentPowerLimitFilter(apparentPowerLimitId)), 
                		ResponseTypes.instanceOf(ApparentPowerLimit.class),
                		ResponseTypes.instanceOf(ApparentPowerLimit.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

