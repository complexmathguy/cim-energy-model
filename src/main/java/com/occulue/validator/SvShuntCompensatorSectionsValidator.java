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

public class SvShuntCompensatorSectionsValidator {
		
	/**
	 * default constructor
	 */
	protected SvShuntCompensatorSectionsValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public SvShuntCompensatorSectionsValidator getInstance() {
		return new SvShuntCompensatorSectionsValidator();
	}
		
	/**
	 * handles creation validation for a SvShuntCompensatorSections
	 */
	public void validate( CreateSvShuntCompensatorSectionsCommand svShuntCompensatorSections )throws Exception {
		Assert.notNull( svShuntCompensatorSections, "CreateSvShuntCompensatorSectionsCommand should not be null" );
//		Assert.isNull( svShuntCompensatorSections.getSvShuntCompensatorSectionsId(), "CreateSvShuntCompensatorSectionsCommand identifier should be null" );
	}

	/**
	 * handles update validation for a SvShuntCompensatorSections
	 */
	public void validate( UpdateSvShuntCompensatorSectionsCommand svShuntCompensatorSections ) throws Exception {
		Assert.notNull( svShuntCompensatorSections, "UpdateSvShuntCompensatorSectionsCommand should not be null" );
		Assert.notNull( svShuntCompensatorSections.getSvShuntCompensatorSectionsId(), "UpdateSvShuntCompensatorSectionsCommand identifier should not be null" );
    }

	/**
	 * handles delete validation for a SvShuntCompensatorSections
	 */
    public void validate( DeleteSvShuntCompensatorSectionsCommand svShuntCompensatorSections ) throws Exception {
		Assert.notNull( svShuntCompensatorSections, "{commandAlias} should not be null" );
		Assert.notNull( svShuntCompensatorSections.getSvShuntCompensatorSectionsId(), "DeleteSvShuntCompensatorSectionsCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a SvShuntCompensatorSections
	 */
	public void validate( SvShuntCompensatorSectionsFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "SvShuntCompensatorSectionsFetchOneSummary should not be null" );
		Assert.notNull( summary.getSvShuntCompensatorSectionsId(), "SvShuntCompensatorSectionsFetchOneSummary identifier should not be null" );
	}



}
