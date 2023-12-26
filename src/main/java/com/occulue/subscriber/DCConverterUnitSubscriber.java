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
 * Subscriber for DCConverterUnit related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dCConverterUnit-subscriber")
public class DCConverterUnitSubscriber extends BaseSubscriber {

	public DCConverterUnitSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DCConverterUnit>, DCConverterUnit> dCConverterUnitSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDCConverterUnitQuery(), 
                		ResponseTypes.multipleInstancesOf(DCConverterUnit.class),
                		ResponseTypes.instanceOf(DCConverterUnit.class));
    }

    public SubscriptionQueryResult<DCConverterUnit, DCConverterUnit> dCConverterUnitSubscribe(@DestinationVariable UUID dCConverterUnitId) {
        return queryGateway
                .subscriptionQuery(new FindDCConverterUnitQuery(new LoadDCConverterUnitFilter(dCConverterUnitId)), 
                		ResponseTypes.instanceOf(DCConverterUnit.class),
                		ResponseTypes.instanceOf(DCConverterUnit.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

