package com.java.se.conclusion.design.factory.abstracts;

import com.java.se.conclusion.design.factory.abstracts.common.Border;
import com.java.se.conclusion.design.factory.abstracts.common.Button;

/**
 * 	This is an interface to implement abstract factory pattern
 *  -- This interface must be implemented by its child classes
 *  
 * @author VinceYuan
 *
 */
public interface BrandFactory {

	public Button getButton();
	public Border getBorder();
}
