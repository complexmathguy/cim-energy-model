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
 * Subscriber for DCConductingEquipment related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCConductingEquipment-subscriber")
public class DCConductingEquipmentSubscriber extends BaseSubscriber {

	public DCConductingEquipmentSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCConductingEquipment>, DCConductingEquipment> dCConductingEquipmentSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCConductingEquipmentQuery(), 
                		ResponseTypes.multipleInstancesOf(DCConductingEquipment.class),
                		ResponseTypes.instanceOf(DCConductingEquipment.class));
    }

    public SubscriptionQueryResult<DCConductingEquipment, DCConductingEquipment> dCConductingEquipmentSubscribe(@DestinationVariable UUID dCConductingEquipmentId) {
        return queryGateway
                .subscriptionQuery(new FindDCConductingEquipmentQuery(new LoadDCConductingEquipmentFilter(dCConductingEquipmentId)), 
                		ResponseTypes.instanceOf(DCConductingEquipment.class),
                		ResponseTypes.instanceOf(DCConductingEquipment.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

