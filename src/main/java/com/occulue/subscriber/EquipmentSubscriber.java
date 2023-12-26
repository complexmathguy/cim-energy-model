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
 * Subscriber for Equipment related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("equipment-subscriber")
public class EquipmentSubscriber extends BaseSubscriber {

	public EquipmentSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Equipment>, Equipment> equipmentSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllEquipmentQuery(), 
                		ResponseTypes.multipleInstancesOf(Equipment.class),
                		ResponseTypes.instanceOf(Equipment.class));
    }

    public SubscriptionQueryResult<Equipment, Equipment> equipmentSubscribe(@DestinationVariable UUID equipmentId) {
        return queryGateway
                .subscriptionQuery(new FindEquipmentQuery(new LoadEquipmentFilter(equipmentId)), 
                		ResponseTypes.instanceOf(Equipment.class),
                		ResponseTypes.instanceOf(Equipment.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

