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

public class SubLoadAreaValidator {
		
	/**
	 * default constructor
	 */
	protected SubLoadAreaValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SubLoadAreaValidator getInstance() {
		return new SubLoadAreaValidator();
	}
		
	/**
	 * handles creation validation for a SubLoadArea
	 */
	public void validate( CreateSubLoadAreaCommand subLoadArea )throws Exception {
		Assert.notNull( subLoadArea, "CreateSubLoadAreaCommand should not be null" );
//		Assert.isNull( subLoadArea.getSubLoadAreaId(), "CreateSubLoadAreaCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SubLoadArea
	 */
	public void validate( UpdateSubLoadAreaCommand subLoadArea ) throws Exception {
		Assert.notNull( subLoadArea, "UpdateSubLoadAreaCommand should not be null" );
		Assert.notNull( subLoadArea.getSubLoadAreaId(), "UpdateSubLoadAreaCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SubLoadArea
	 */
    public void validate( DeleteSubLoadAreaCommand subLoadArea ) throws Exception {
		Assert.notNull( subLoadArea, "{commandAlias} should not be null" );
		Assert.notNull( subLoadArea.getSubLoadAreaId(), "DeleteSubLoadAreaCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SubLoadArea
	 */
	public void validate( SubLoadAreaFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SubLoadAreaFetchOneSummary should not be null" );
		Assert.notNull( summary.getSubLoadAreaId(), "SubLoadAreaFetchOneSummary identifier should not be null" );
	}



}
