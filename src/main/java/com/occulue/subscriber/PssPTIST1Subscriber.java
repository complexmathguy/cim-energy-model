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
 * Subscriber for PssPTIST1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pssPTIST1-subscriber")
public class PssPTIST1Subscriber extends BaseSubscriber {

	public PssPTIST1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PssPTIST1>, PssPTIST1> pssPTIST1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPssPTIST1Query(), 
                		ResponseTypes.multipleInstancesOf(PssPTIST1.class),
                		ResponseTypes.instanceOf(PssPTIST1.class));
    }

    public SubscriptionQueryResult<PssPTIST1, PssPTIST1> pssPTIST1Subscribe(@DestinationVariable UUID pssPTIST1Id) {
        return queryGateway
                .subscriptionQuery(new FindPssPTIST1Query(new LoadPssPTIST1Filter(pssPTIST1Id)), 
                		ResponseTypes.instanceOf(PssPTIST1.class),
                		ResponseTypes.instanceOf(PssPTIST1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

