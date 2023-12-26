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

public class CurveDataValidator {
		
	/**
	 * default constructor
	 */
	protected CurveDataValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public CurveDataValidator getInstance() {
		return new CurveDataValidator();
	}
		
	/**
	 * handles creation validation for a CurveData
	 */
	public void validate( CreateCurveDataCommand curveData )throws Exception {
		Assert.notNull( curveData, "CreateCurveDataCommand should not be null" );
//		Assert.isNull( curveData.getCurveDataId(), "CreateCurveDataCommand identifier should be null" );
	}

	/**
	 * handles update validation for a CurveData
	 */
	public void validate( UpdateCurveDataCommand curveData ) throws Exception {
		Assert.notNull( curveData, "UpdateCurveDataCommand should not be null" );
		Assert.notNull( curveData.getCurveDataId(), "UpdateCurveDataCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a CurveData
	 */
    public void validate( DeleteCurveDataCommand curveData ) throws Exception {
		Assert.notNull( curveData, "{commandAlias} should not be null" );
		Assert.notNull( curveData.getCurveDataId(), "DeleteCurveDataCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a CurveData
	 */
	public void validate( CurveDataFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "CurveDataFetchOneSummary should not be null" );
		Assert.notNull( summary.getCurveDataId(), "CurveDataFetchOneSummary identifier should not be null" );
	}



}
