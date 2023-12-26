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
 * Subscriber for VAdjIEEE related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("vAdjIEEE-subscriber")
public class VAdjIEEESubscriber extends BaseSubscriber {

	public VAdjIEEESubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<VAdjIEEE>, VAdjIEEE> vAdjIEEESubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllVAdjIEEEQuery(), 
                		ResponseTypes.multipleInstancesOf(VAdjIEEE.class),
                		ResponseTypes.instanceOf(VAdjIEEE.class));
    }

    public SubscriptionQueryResult<VAdjIEEE, VAdjIEEE> vAdjIEEESubscribe(@DestinationVariable UUID vAdjIEEEId) {
        return queryGateway
                .subscriptionQuery(new FindVAdjIEEEQuery(new LoadVAdjIEEEFilter(vAdjIEEEId)), 
                		ResponseTypes.instanceOf(VAdjIEEE.class),
                		ResponseTypes.instanceOf(VAdjIEEE.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

