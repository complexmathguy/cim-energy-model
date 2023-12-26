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
 * Subscriber for RatioTapChangerTable related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("ratioTapChangerTable-subscriber")
public class RatioTapChangerTableSubscriber extends BaseSubscriber {

	public RatioTapChangerTableSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<RatioTapChangerTable>, RatioTapChangerTable> ratioTapChangerTableSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllRatioTapChangerTableQuery(), 
                		ResponseTypes.multipleInstancesOf(RatioTapChangerTable.class),
                		ResponseTypes.instanceOf(RatioTapChangerTable.class));
    }

    public SubscriptionQueryResult<RatioTapChangerTable, RatioTapChangerTable> ratioTapChangerTableSubscribe(@DestinationVariable UUID ratioTapChangerTableId) {
        return queryGateway
                .subscriptionQuery(new FindRatioTapChangerTableQuery(new LoadRatioTapChangerTableFilter(ratioTapChangerTableId)), 
                		ResponseTypes.instanceOf(RatioTapChangerTable.class),
                		ResponseTypes.instanceOf(RatioTapChangerTable.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

