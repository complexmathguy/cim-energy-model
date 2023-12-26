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
 * Subscriber for PFVArType2Common1 related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("pFVArType2Common1-subscriber")
public class PFVArType2Common1Subscriber extends BaseSubscriber {

	public PFVArType2Common1Subscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PFVArType2Common1>, PFVArType2Common1> pFVArType2Common1Subscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPFVArType2Common1Query(), 
                		ResponseTypes.multipleInstancesOf(PFVArType2Common1.class),
                		ResponseTypes.instanceOf(PFVArType2Common1.class));
    }

    public SubscriptionQueryResult<PFVArType2Common1, PFVArType2Common1> pFVArType2Common1Subscribe(@DestinationVariable UUID pFVArType2Common1Id) {
        return queryGateway
                .subscriptionQuery(new FindPFVArType2Common1Query(new LoadPFVArType2Common1Filter(pFVArType2Common1Id)), 
                		ResponseTypes.instanceOf(PFVArType2Common1.class),
                		ResponseTypes.instanceOf(PFVArType2Common1.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

