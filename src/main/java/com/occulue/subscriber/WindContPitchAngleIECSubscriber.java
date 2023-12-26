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
 * Subscriber for WindContPitchAngleIEC related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("windContPitchAngleIEC-subscriber")
public class WindContPitchAngleIECSubscriber extends BaseSubscriber {

	public WindContPitchAngleIECSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<WindContPitchAngleIEC>, WindContPitchAngleIEC> windContPitchAngleIECSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllWindContPitchAngleIECQuery(), 
                		ResponseTypes.multipleInstancesOf(WindContPitchAngleIEC.class),
                		ResponseTypes.instanceOf(WindContPitchAngleIEC.class));
    }

    public SubscriptionQueryResult<WindContPitchAngleIEC, WindContPitchAngleIEC> windContPitchAngleIECSubscribe(@DestinationVariable UUID windContPitchAngleIECId) {
        return queryGateway
                .subscriptionQuery(new FindWindContPitchAngleIECQuery(new LoadWindContPitchAngleIECFilter(windContPitchAngleIECId)), 
                		ResponseTypes.instanceOf(WindContPitchAngleIEC.class),
                		ResponseTypes.instanceOf(WindContPitchAngleIEC.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

