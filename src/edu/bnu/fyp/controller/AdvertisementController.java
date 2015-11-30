package edu.bnu.fyp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bnu.fyp.entity.Advertisement;
import edu.bnu.fyp.service.AdvertisementService;

@Controller
public class AdvertisementController {
	@Autowired
	private AdvertisementService advertisementService;
	
	@RequestMapping(value="/advertiseProduct")
	public String advertiseProduct(HttpServletRequest request){
		Advertisement advertisement=new Advertisement();
		advertisement.setItemId(Long.parseLong(request.getParameter("itemId")));
		try {
			advertisementService.addNewAdvertisement(advertisement);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/viewProducts.bnu";
	}

}
