/**
 * @author Muhammad Haris
 * Nov 2, 2013
 */
package edu.bnu.fyp.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bnu.fyp.entity.Advertisement;
import edu.bnu.fyp.service.AdvertisementService;

/**
 *
 */
@Controller
public class HomeController {

	@Autowired
	private AdvertisementService advertisementService;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String saySalam(HttpServletRequest request, Model model) {
		try {
			List<Advertisement> advertisementList=advertisementService.getAllAdvertisedItem();
			Collections.reverse(advertisementList);
			model.addAttribute("advertisementList",advertisementList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Home";
	}
	@RequestMapping(value = "/empty", method = RequestMethod.GET)
	public String showEmpty() {
		return "Empty";
	}
	
	
}
