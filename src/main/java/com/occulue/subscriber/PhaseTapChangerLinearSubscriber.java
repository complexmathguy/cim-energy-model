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
 * Subscriber for PhaseTapChangerLinear related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("phaseTapChangerLinear-subscriber")
public class PhaseTapChangerLinearSubscriber extends BaseSubscriber {

	public PhaseTapChangerLinearSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PhaseTapChangerLinear>, PhaseTapChangerLinear> phaseTapChangerLinearSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPhaseTapChangerLinearQuery(), 
                		ResponseTypes.multipleInstancesOf(PhaseTapChangerLinear.class),
                		ResponseTypes.instanceOf(PhaseTapChangerLinear.class));
    }

    public SubscriptionQueryResult<PhaseTapChangerLinear, PhaseTapChangerLinear> phaseTapChangerLinearSubscribe(@DestinationVariable UUID phaseTapChangerLinearId) {
        return queryGateway
                .subscriptionQuery(new FindPhaseTapChangerLinearQuery(new LoadPhaseTapChangerLinearFilter(phaseTapChangerLinearId)), 
                		ResponseTypes.instanceOf(PhaseTapChangerLinear.class),
                		ResponseTypes.instanceOf(PhaseTapChangerLinear.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

