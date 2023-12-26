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

public class BusbarSectionValidator {
		
	/**
	 * default constructor
	 */
	protected BusbarSectionValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public BusbarSectionValidator getInstance() {
		return new BusbarSectionValidator();
	}
		
	/**
	 * handles creation validation for a BusbarSection
	 */
	public void validate( CreateBusbarSectionCommand busbarSection )throws Exception {
		Assert.notNull( busbarSection, "CreateBusbarSectionCommand should not be null" );
//		Assert.isNull( busbarSection.getBusbarSectionId(), "CreateBusbarSectionCommand identifier should be null" );
	}

	/**
	 * handles update validation for a BusbarSection
	 */
	public void validate( UpdateBusbarSectionCommand busbarSection ) throws Exception {
		Assert.notNull( busbarSection, "UpdateBusbarSectionCommand should not be null" );
		Assert.notNull( busbarSection.getBusbarSectionId(), "UpdateBusbarSectionCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a BusbarSection
	 */
    public void validate( DeleteBusbarSectionCommand busbarSection ) throws Exception {
		Assert.notNull( busbarSection, "{commandAlias} should not be null" );
		Assert.notNull( busbarSection.getBusbarSectionId(), "DeleteBusbarSectionCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a BusbarSection
	 */
	public void validate( BusbarSectionFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "BusbarSectionFetchOneSummary should not be null" );
		Assert.notNull( summary.getBusbarSectionId(), "BusbarSectionFetchOneSummary identifier should not be null" );
	}



}
