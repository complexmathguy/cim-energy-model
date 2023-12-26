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
 * Subscriber for ENTSOEOperationalLimitType related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("eNTSOEOperationalLimitType-subscriber")
public class ENTSOEOperationalLimitTypeSubscriber extends BaseSubscriber {

	public ENTSOEOperationalLimitTypeSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ENTSOEOperationalLimitType>, ENTSOEOperationalLimitType> eNTSOEOperationalLimitTypeSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllENTSOEOperationalLimitTypeQuery(), 
                		ResponseTypes.multipleInstancesOf(ENTSOEOperationalLimitType.class),
                		ResponseTypes.instanceOf(ENTSOEOperationalLimitType.class));
    }

    public SubscriptionQueryResult<ENTSOEOperationalLimitType, ENTSOEOperationalLimitType> eNTSOEOperationalLimitTypeSubscribe(@DestinationVariable UUID eNTSOEOperationalLimitTypeId) {
        return queryGateway
                .subscriptionQuery(new FindENTSOEOperationalLimitTypeQuery(new LoadENTSOEOperationalLimitTypeFilter(eNTSOEOperationalLimitTypeId)), 
                		ResponseTypes.instanceOf(ENTSOEOperationalLimitType.class),
                		ResponseTypes.instanceOf(ENTSOEOperationalLimitType.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

