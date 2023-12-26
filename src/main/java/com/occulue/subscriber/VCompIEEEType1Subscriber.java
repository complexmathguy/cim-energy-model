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
 * Subscriber for VCompIEEEType1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("vCompIEEEType1-subscriber")
public class VCompIEEEType1Subscriber extends BaseSubscriber {

	public VCompIEEEType1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<VCompIEEEType1>, VCompIEEEType1> vCompIEEEType1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllVCompIEEEType1Query(), 
                		ResponseTypes.multipleInstancesOf(VCompIEEEType1.class),
                		ResponseTypes.instanceOf(VCompIEEEType1.class));
    }

    public SubscriptionQueryResult<VCompIEEEType1, VCompIEEEType1> vCompIEEEType1Subscribe(@DestinationVariable UUID vCompIEEEType1Id) {
        return queryGateway
                .subscriptionQuery(new FindVCompIEEEType1Query(new LoadVCompIEEEType1Filter(vCompIEEEType1Id)), 
                		ResponseTypes.instanceOf(VCompIEEEType1.class),
                		ResponseTypes.instanceOf(VCompIEEEType1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

