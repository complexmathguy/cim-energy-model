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

public class LoadAggregateValidator {
		
	/**
	 * default constructor
	 */
	protected LoadAggregateValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public LoadAggregateValidator getInstance() {
		return new LoadAggregateValidator();
	}
		
	/**
	 * handles creation validation for a LoadAggregate
	 */
	public void validate( CreateLoadAggregateCommand loadAggregate )throws Exception {
		Assert.notNull( loadAggregate, "CreateLoadAggregateCommand should not be null" );
//		Assert.isNull( loadAggregate.getLoadAggregateId(), "CreateLoadAggregateCommand identifier should be null" );
	}

	/**
	 * handles update validation for a LoadAggregate
	 */
	public void validate( UpdateLoadAggregateCommand loadAggregate ) throws Exception {
		Assert.notNull( loadAggregate, "UpdateLoadAggregateCommand should not be null" );
		Assert.notNull( loadAggregate.getLoadAggregateId(), "UpdateLoadAggregateCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a LoadAggregate
	 */
    public void validate( DeleteLoadAggregateCommand loadAggregate ) throws Exception {
		Assert.notNull( loadAggregate, "{commandAlias} should not be null" );
		Assert.notNull( loadAggregate.getLoadAggregateId(), "DeleteLoadAggregateCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a LoadAggregate
	 */
	public void validate( LoadAggregateFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "LoadAggregateFetchOneSummary should not be null" );
		Assert.notNull( summary.getLoadAggregateId(), "LoadAggregateFetchOneSummary identifier should not be null" );
	}



}
