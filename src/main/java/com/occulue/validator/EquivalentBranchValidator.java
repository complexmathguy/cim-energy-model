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

public class EquivalentBranchValidator {
		
	/**
	 * default constructor
	 */
	protected EquivalentBranchValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public EquivalentBranchValidator getInstance() {
		return new EquivalentBranchValidator();
	}
		
	/**
	 * handles creation validation for a EquivalentBranch
	 */
	public void validate( CreateEquivalentBranchCommand equivalentBranch )throws Exception {
		Assert.notNull( equivalentBranch, "CreateEquivalentBranchCommand should not be null" );
//		Assert.isNull( equivalentBranch.getEquivalentBranchId(), "CreateEquivalentBranchCommand identifier should be null" );
	}

	/**
	 * handles update validation for a EquivalentBranch
	 */
	public void validate( UpdateEquivalentBranchCommand equivalentBranch ) throws Exception {
		Assert.notNull( equivalentBranch, "UpdateEquivalentBranchCommand should not be null" );
		Assert.notNull( equivalentBranch.getEquivalentBranchId(), "UpdateEquivalentBranchCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a EquivalentBranch
	 */
    public void validate( DeleteEquivalentBranchCommand equivalentBranch ) throws Exception {
		Assert.notNull( equivalentBranch, "{commandAlias} should not be null" );
		Assert.notNull( equivalentBranch.getEquivalentBranchId(), "DeleteEquivalentBranchCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a EquivalentBranch
	 */
	public void validate( EquivalentBranchFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "EquivalentBranchFetchOneSummary should not be null" );
		Assert.notNull( summary.getEquivalentBranchId(), "EquivalentBranchFetchOneSummary identifier should not be null" );
	}



}
