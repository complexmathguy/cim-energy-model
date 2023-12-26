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
 * Subscriber for ConductingEquipment related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("conductingEquipment-subscriber")
public class ConductingEquipmentSubscriber extends BaseSubscriber {

	public ConductingEquipmentSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ConductingEquipment>, ConductingEquipment> conductingEquipmentSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllConductingEquipmentQuery(), 
                		ResponseTypes.multipleInstancesOf(ConductingEquipment.class),
                		ResponseTypes.instanceOf(ConductingEquipment.class));
    }

    public SubscriptionQueryResult<ConductingEquipment, ConductingEquipment> conductingEquipmentSubscribe(@DestinationVariable UUID conductingEquipmentId) {
        return queryGateway
                .subscriptionQuery(new FindConductingEquipmentQuery(new LoadConductingEquipmentFilter(conductingEquipmentId)), 
                		ResponseTypes.instanceOf(ConductingEquipment.class),
                		ResponseTypes.instanceOf(ConductingEquipment.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

