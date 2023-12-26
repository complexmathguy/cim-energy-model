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
 * Subscriber for EquipmentContainer related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("equipmentContainer-subscriber")
public class EquipmentContainerSubscriber extends BaseSubscriber {

	public EquipmentContainerSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<EquipmentContainer>, EquipmentContainer> equipmentContainerSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllEquipmentContainerQuery(), 
                		ResponseTypes.multipleInstancesOf(EquipmentContainer.class),
                		ResponseTypes.instanceOf(EquipmentContainer.class));
    }

    public SubscriptionQueryResult<EquipmentContainer, EquipmentContainer> equipmentContainerSubscribe(@DestinationVariable UUID equipmentContainerId) {
        return queryGateway
                .subscriptionQuery(new FindEquipmentContainerQuery(new LoadEquipmentContainerFilter(equipmentContainerId)), 
                		ResponseTypes.instanceOf(EquipmentContainer.class),
                		ResponseTypes.instanceOf(EquipmentContainer.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

