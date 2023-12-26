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
 * Subscriber for WindPlantFreqPcontrolIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windPlantFreqPcontrolIEC-subscriber")
public class WindPlantFreqPcontrolIECSubscriber extends BaseSubscriber {

	public WindPlantFreqPcontrolIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindPlantFreqPcontrolIEC>, WindPlantFreqPcontrolIEC> windPlantFreqPcontrolIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindPlantFreqPcontrolIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindPlantFreqPcontrolIEC.class),
                		ResponseTypes.instanceOf(WindPlantFreqPcontrolIEC.class));
    }

    public SubscriptionQueryResult<WindPlantFreqPcontrolIEC, WindPlantFreqPcontrolIEC> windPlantFreqPcontrolIECSubscribe(@DestinationVariable UUID windPlantFreqPcontrolIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindPlantFreqPcontrolIECQuery(new LoadWindPlantFreqPcontrolIECFilter(windPlantFreqPcontrolIECId)), 
                		ResponseTypes.instanceOf(WindPlantFreqPcontrolIEC.class),
                		ResponseTypes.instanceOf(WindPlantFreqPcontrolIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

