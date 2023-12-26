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

public class WindPlantFreqPcontrolIECValidator {
		
	/**
	 * default constructor
	 */
	protected WindPlantFreqPcontrolIECValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public WindPlantFreqPcontrolIECValidator getInstance() {
		return new WindPlantFreqPcontrolIECValidator();
	}
		
	/**
	 * handles creation validation for a WindPlantFreqPcontrolIEC
	 */
	public void validate( CreateWindPlantFreqPcontrolIECCommand windPlantFreqPcontrolIEC )throws Exception {
		Assert.notNull( windPlantFreqPcontrolIEC, "CreateWindPlantFreqPcontrolIECCommand should not be null" );
//		Assert.isNull( windPlantFreqPcontrolIEC.getWindPlantFreqPcontrolIECId(), "CreateWindPlantFreqPcontrolIECCommand identifier should be null" );
	}

	/**
	 * handles update validation for a WindPlantFreqPcontrolIEC
	 */
	public void validate( UpdateWindPlantFreqPcontrolIECCommand windPlantFreqPcontrolIEC ) throws Exception {
		Assert.notNull( windPlantFreqPcontrolIEC, "UpdateWindPlantFreqPcontrolIECCommand should not be null" );
		Assert.notNull( windPlantFreqPcontrolIEC.getWindPlantFreqPcontrolIECId(), "UpdateWindPlantFreqPcontrolIECCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a WindPlantFreqPcontrolIEC
	 */
    public void validate( DeleteWindPlantFreqPcontrolIECCommand windPlantFreqPcontrolIEC ) throws Exception {
		Assert.notNull( windPlantFreqPcontrolIEC, "{commandAlias} should not be null" );
		Assert.notNull( windPlantFreqPcontrolIEC.getWindPlantFreqPcontrolIECId(), "DeleteWindPlantFreqPcontrolIECCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a WindPlantFreqPcontrolIEC
	 */
	public void validate( WindPlantFreqPcontrolIECFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "WindPlantFreqPcontrolIECFetchOneSummary should not be null" );
		Assert.notNull( summary.getWindPlantFreqPcontrolIECId(), "WindPlantFreqPcontrolIECFetchOneSummary identifier should not be null" );
	}



}
