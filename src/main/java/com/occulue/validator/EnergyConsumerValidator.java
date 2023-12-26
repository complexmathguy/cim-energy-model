/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.validator;

import org.springframework.util.Assert;

import com.occulue.api.*;

public class EnergyConsumerValidator {
		
	/**
	 * default constructor
	 */
	protected EnergyConsumerValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public EnergyConsumerValidator getInstance() {
		return new EnergyConsumerValidator();
	}
		
	/**
	 * handles creation validation for a EnergyConsumer
	 */
	public void validate( CreateEnergyConsumerCommand energyConsumer )throws Exception {
		Assert.notNull( energyConsumer, "CreateEnergyConsumerCommand should not be null" );
//		Assert.isNull( energyConsumer.getEnergyConsumerId(), "CreateEnergyConsumerCommand identifier should be null" );
	}

	/**
	 * handles update validation for a EnergyConsumer
	 */
	public void validate( UpdateEnergyConsumerCommand energyConsumer ) throws Exception {
		Assert.notNull( energyConsumer, "UpdateEnergyConsumerCommand should not be null" );
		Assert.notNull( energyConsumer.getEnergyConsumerId(), "UpdateEnergyConsumerCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a EnergyConsumer
	 */
    public void validate( DeleteEnergyConsumerCommand energyConsumer ) throws Exception {
		Assert.notNull( energyConsumer, "{commandAlias} should not be null" );
		Assert.notNull( energyConsumer.getEnergyConsumerId(), "DeleteEnergyConsumerCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a EnergyConsumer
	 */
	public void validate( EnergyConsumerFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "EnergyConsumerFetchOneSummary should not be null" );
		Assert.notNull( summary.getEnergyConsumerId(), "EnergyConsumerFetchOneSummary identifier should not be null" );
	}



}
