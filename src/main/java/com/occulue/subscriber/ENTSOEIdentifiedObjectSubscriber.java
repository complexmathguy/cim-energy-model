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
 * Subscriber for ENTSOEIdentifiedObject related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("eNTSOEIdentifiedObject-subscriber")
public class ENTSOEIdentifiedObjectSubscriber extends BaseSubscriber {

	public ENTSOEIdentifiedObjectSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ENTSOEIdentifiedObject>, ENTSOEIdentifiedObject> eNTSOEIdentifiedObjectSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllENTSOEIdentifiedObjectQuery(), 
                		ResponseTypes.multipleInstancesOf(ENTSOEIdentifiedObject.class),
                		ResponseTypes.instanceOf(ENTSOEIdentifiedObject.class));
    }

    public SubscriptionQueryResult<ENTSOEIdentifiedObject, ENTSOEIdentifiedObject> eNTSOEIdentifiedObjectSubscribe(@DestinationVariable UUID eNTSOEIdentifiedObjectId) {
        return queryGateway
                .subscriptionQuery(new FindENTSOEIdentifiedObjectQuery(new LoadENTSOEIdentifiedObjectFilter(eNTSOEIdentifiedObjectId)), 
                		ResponseTypes.instanceOf(ENTSOEIdentifiedObject.class),
                		ResponseTypes.instanceOf(ENTSOEIdentifiedObject.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

