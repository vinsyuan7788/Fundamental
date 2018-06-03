package com.java.se.conclusion.design.factory.abstracts;

import com.java.se.conclusion.design.factory.abstracts.common.Border;
import com.java.se.conclusion.design.factory.abstracts.common.Button;
import com.java.se.conclusion.design.factory.abstracts.common.MacBorder;
import com.java.se.conclusion.design.factory.abstracts.common.MacButton;

/**
 * 	This is a class to implement abstract factory pattern
 *  -- This class must implement a parent interface
 *  
 * @author VinceYuan
 *
 */
public class MacFactory implements BrandFactory {

	@Override
	public Button getButton() {
		return new MacButton();
	}

	@Override
	public Border getBorder() {
		return new MacBorder();
	}
}
