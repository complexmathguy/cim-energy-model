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

public class WindDynamicsLookupTableValidator {
		
	/**
	 * default constructor
	 */
	protected WindDynamicsLookupTableValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindDynamicsLookupTableValidator getInstance() {
		return new WindDynamicsLookupTableValidator();
	}
		
	/**
	 * handles creation validation for a WindDynamicsLookupTable
	 */
	public void validate( CreateWindDynamicsLookupTableCommand windDynamicsLookupTable )throws Exception {
		Assert.notNull( windDynamicsLookupTable, "CreateWindDynamicsLookupTableCommand should not be null" );
//		Assert.isNull( windDynamicsLookupTable.getWindDynamicsLookupTableId(), "CreateWindDynamicsLookupTableCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindDynamicsLookupTable
	 */
	public void validate( UpdateWindDynamicsLookupTableCommand windDynamicsLookupTable ) throws Exception {
		Assert.notNull( windDynamicsLookupTable, "UpdateWindDynamicsLookupTableCommand should not be null" );
		Assert.notNull( windDynamicsLookupTable.getWindDynamicsLookupTableId(), "UpdateWindDynamicsLookupTableCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindDynamicsLookupTable
	 */
    public void validate( DeleteWindDynamicsLookupTableCommand windDynamicsLookupTable ) throws Exception {
		Assert.notNull( windDynamicsLookupTable, "{commandAlias} should not be null" );
		Assert.notNull( windDynamicsLookupTable.getWindDynamicsLookupTableId(), "DeleteWindDynamicsLookupTableCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindDynamicsLookupTable
	 */
	public void validate( WindDynamicsLookupTableFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindDynamicsLookupTableFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindDynamicsLookupTableId(), "WindDynamicsLookupTableFetchOneSummary identifier should not be null" );
	}



}
