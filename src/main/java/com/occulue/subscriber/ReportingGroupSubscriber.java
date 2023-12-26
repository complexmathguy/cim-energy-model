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
 * Subscriber for ReportingGroup related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("reportingGroup-subscriber")
public class ReportingGroupSubscriber extends BaseSubscriber {

	public ReportingGroupSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ReportingGroup>, ReportingGroup> reportingGroupSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllReportingGroupQuery(), 
                		ResponseTypes.multipleInstancesOf(ReportingGroup.class),
                		ResponseTypes.instanceOf(ReportingGroup.class));
    }

    public SubscriptionQueryResult<ReportingGroup, ReportingGroup> reportingGroupSubscribe(@DestinationVariable UUID reportingGroupId) {
        return queryGateway
                .subscriptionQuery(new FindReportingGroupQuery(new LoadReportingGroupFilter(reportingGroupId)), 
                		ResponseTypes.instanceOf(ReportingGroup.class),
                		ResponseTypes.instanceOf(ReportingGroup.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

