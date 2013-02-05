/*
 * Copyright 2012 the original author or authors.
 *
 */
package com.showcase.mobile;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.mobile.device.site.SitePreferenceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the showcase application.
 * @author get4gopi
 */
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	/**
	 * Show the home page to the user. 
	 * Declares a {@link SitePreference} parameter to show how you can resolve the user's site preference.
	 * This controller renders a different version of the home view if the user has a mobile site preference.
	 */
	@RequestMapping("/index")
	public ModelAndView index(Model model, HttpServletRequest servletRequest) {
		SitePreference sitePreference = SitePreferenceUtils.getCurrentSitePreference(servletRequest);
		logger.info("index SitePreference = " + sitePreference);
		String currentDevice = "";
		
		ModelAndView  mav = new ModelAndView();

		Device device = DeviceUtils.getCurrentDevice(servletRequest);
		if (device != null) {
			if (device.isMobile()) currentDevice = "MOBILE";
			else if (device.isTablet()) currentDevice = "TABLET";
			else if (device.isNormal()) currentDevice = "NORMAL";
			
		} else {
			currentDevice = "NORMAL";
		}
		
		mav.addObject("currentDevice", currentDevice);
		mav.setViewName("index");
		return mav;
	}

}