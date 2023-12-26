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
 * Subscriber for PhaseTapChangerTablePoint related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("phaseTapChangerTablePoint-subscriber")
public class PhaseTapChangerTablePointSubscriber extends BaseSubscriber {

	public PhaseTapChangerTablePointSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PhaseTapChangerTablePoint>, PhaseTapChangerTablePoint> phaseTapChangerTablePointSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPhaseTapChangerTablePointQuery(), 
                		ResponseTypes.multipleInstancesOf(PhaseTapChangerTablePoint.class),
                		ResponseTypes.instanceOf(PhaseTapChangerTablePoint.class));
    }

    public SubscriptionQueryResult<PhaseTapChangerTablePoint, PhaseTapChangerTablePoint> phaseTapChangerTablePointSubscribe(@DestinationVariable UUID phaseTapChangerTablePointId) {
        return queryGateway
                .subscriptionQuery(new FindPhaseTapChangerTablePointQuery(new LoadPhaseTapChangerTablePointFilter(phaseTapChangerTablePointId)), 
                		ResponseTypes.instanceOf(PhaseTapChangerTablePoint.class),
                		ResponseTypes.instanceOf(PhaseTapChangerTablePoint.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

