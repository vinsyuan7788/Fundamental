package com.java.se.conclusion.interoperation.utils;

import java.util.ArrayList;
import java.util.List;

import com.java.se.conclusion.interoperation.bean.AdPosition;

/**
 * 	This is a class to get a list of advertisement positions
 * 
 * @author VinceYuan
 *
 */
public class AdPosistionList {

	/*	Necessary instance variables	*/
	public static List<AdPosition> adPositionList = new ArrayList<>();
	
	/*	Static block for initialization	 */
	static {
		adPositionList.add(new AdPosition());
		adPositionList.add(new AdPosition());
		adPositionList.add(new AdPosition());
		adPositionList.add(new AdPosition());
		adPositionList.add(new AdPosition());
		adPositionList.add(new AdPosition());
	}
}
