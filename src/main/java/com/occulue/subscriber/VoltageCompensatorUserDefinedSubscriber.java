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
 * Subscriber for VoltageCompensatorUserDefined related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("voltageCompensatorUserDefined-subscriber")
public class VoltageCompensatorUserDefinedSubscriber extends BaseSubscriber {

	public VoltageCompensatorUserDefinedSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<VoltageCompensatorUserDefined>, VoltageCompensatorUserDefined> voltageCompensatorUserDefinedSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllVoltageCompensatorUserDefinedQuery(), 
                		ResponseTypes.multipleInstancesOf(VoltageCompensatorUserDefined.class),
                		ResponseTypes.instanceOf(VoltageCompensatorUserDefined.class));
    }

    public SubscriptionQueryResult<VoltageCompensatorUserDefined, VoltageCompensatorUserDefined> voltageCompensatorUserDefinedSubscribe(@DestinationVariable UUID voltageCompensatorUserDefinedId) {
        return queryGateway
                .subscriptionQuery(new FindVoltageCompensatorUserDefinedQuery(new LoadVoltageCompensatorUserDefinedFilter(voltageCompensatorUserDefinedId)), 
                		ResponseTypes.instanceOf(VoltageCompensatorUserDefined.class),
                		ResponseTypes.instanceOf(VoltageCompensatorUserDefined.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

