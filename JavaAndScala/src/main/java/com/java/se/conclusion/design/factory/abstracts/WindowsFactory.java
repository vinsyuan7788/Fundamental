package com.java.se.conclusion.design.factory.abstracts;

import com.java.se.conclusion.design.factory.abstracts.common.Border;
import com.java.se.conclusion.design.factory.abstracts.common.Button;
import com.java.se.conclusion.design.factory.abstracts.common.WindowsBorder;
import com.java.se.conclusion.design.factory.abstracts.common.WindowsButton;

/**
 * 	This is a class to implement abstract factory pattern
 *  -- This class must implement a parent interface
 *  
 * @author VinceYuan
 *
 */
public class WindowsFactory implements BrandFactory {

	@Override
	public Button getButton() {
		return new WindowsButton();
	}

	@Override
	public Border getBorder() {
		return new WindowsBorder();
	}
}
