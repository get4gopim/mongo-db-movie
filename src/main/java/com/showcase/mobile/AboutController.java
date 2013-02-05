/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.showcase.mobile;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the About page.
 * @author Roy Clarkson
 */
@Controller
public class AboutController {
	
	private static final Logger logger = LoggerFactory.getLogger(AboutController.class);

	/**
	 * Show the About page to the user.
	 * Declares a {@link SitePreference} parameter to show how you can resolve the user's site preference.
	 * This controller renders a different version of the home view if the user has a mobile site preference.
	 */
	@RequestMapping("/about")
	public ModelAndView about(HttpServletRequest servletRequest) {
		logger.info("about");
		ModelAndView mav = new ModelAndView();
		
		/*Device currentDevice = DeviceUtils.getCurrentDevice(servletRequest);
		mav.addObject("currentDevice", currentDevice.toString());*/
		
		mav.setViewName("home");
		return mav;
	}

}