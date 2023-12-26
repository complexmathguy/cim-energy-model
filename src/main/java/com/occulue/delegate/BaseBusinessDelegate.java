/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.delegate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import org.springframework.beans.BeansException;

/**
 * Base class for application business delegates.
 * <p>
 * @author your_name_here
 */
@Component
public class BaseBusinessDelegate implements ApplicationContextAware {
 
	public BaseBusinessDelegate() {	
	}
	
	@Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        applicationContext = ctx;
    }    

//************************************************************************
// Protected / Private Methods
//************************************************************************
    protected static ApplicationContext applicationContext;

}



