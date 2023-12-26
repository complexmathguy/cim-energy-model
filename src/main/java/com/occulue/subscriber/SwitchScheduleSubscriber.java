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
 * Subscriber for SwitchSchedule related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("switchSchedule-subscriber")
public class SwitchScheduleSubscriber extends BaseSubscriber {

	public SwitchScheduleSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SwitchSchedule>, SwitchSchedule> switchScheduleSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSwitchScheduleQuery(), 
                		ResponseTypes.multipleInstancesOf(SwitchSchedule.class),
                		ResponseTypes.instanceOf(SwitchSchedule.class));
    }

    public SubscriptionQueryResult<SwitchSchedule, SwitchSchedule> switchScheduleSubscribe(@DestinationVariable UUID switchScheduleId) {
        return queryGateway
                .subscriptionQuery(new FindSwitchScheduleQuery(new LoadSwitchScheduleFilter(switchScheduleId)), 
                		ResponseTypes.instanceOf(SwitchSchedule.class),
                		ResponseTypes.instanceOf(SwitchSchedule.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

