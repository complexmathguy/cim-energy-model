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
 * Subscriber for DomainVersion related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("domainVersion-subscriber")
public class DomainVersionSubscriber extends BaseSubscriber {

	public DomainVersionSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DomainVersion>, DomainVersion> domainVersionSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDomainVersionQuery(), 
                		ResponseTypes.multipleInstancesOf(DomainVersion.class),
                		ResponseTypes.instanceOf(DomainVersion.class));
    }

    public SubscriptionQueryResult<DomainVersion, DomainVersion> domainVersionSubscribe(@DestinationVariable UUID domainVersionId) {
        return queryGateway
                .subscriptionQuery(new FindDomainVersionQuery(new LoadDomainVersionFilter(domainVersionId)), 
                		ResponseTypes.instanceOf(DomainVersion.class),
                		ResponseTypes.instanceOf(DomainVersion.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

