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
 * Subscriber for VCompIEEEType2 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("vCompIEEEType2-subscriber")
public class VCompIEEEType2Subscriber extends BaseSubscriber {

	public VCompIEEEType2Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<VCompIEEEType2>, VCompIEEEType2> vCompIEEEType2Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllVCompIEEEType2Query(), 
                		ResponseTypes.multipleInstancesOf(VCompIEEEType2.class),
                		ResponseTypes.instanceOf(VCompIEEEType2.class));
    }

    public SubscriptionQueryResult<VCompIEEEType2, VCompIEEEType2> vCompIEEEType2Subscribe(@DestinationVariable UUID vCompIEEEType2Id) {
        return queryGateway
                .subscriptionQuery(new FindVCompIEEEType2Query(new LoadVCompIEEEType2Filter(vCompIEEEType2Id)), 
                		ResponseTypes.instanceOf(VCompIEEEType2.class),
                		ResponseTypes.instanceOf(VCompIEEEType2.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

