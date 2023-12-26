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
 * Subscriber for SvTapStep related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("svTapStep-subscriber")
public class SvTapStepSubscriber extends BaseSubscriber {

	public SvTapStepSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SvTapStep>, SvTapStep> svTapStepSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSvTapStepQuery(), 
                		ResponseTypes.multipleInstancesOf(SvTapStep.class),
                		ResponseTypes.instanceOf(SvTapStep.class));
    }

    public SubscriptionQueryResult<SvTapStep, SvTapStep> svTapStepSubscribe(@DestinationVariable UUID svTapStepId) {
        return queryGateway
                .subscriptionQuery(new FindSvTapStepQuery(new LoadSvTapStepFilter(svTapStepId)), 
                		ResponseTypes.instanceOf(SvTapStep.class),
                		ResponseTypes.instanceOf(SvTapStep.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

