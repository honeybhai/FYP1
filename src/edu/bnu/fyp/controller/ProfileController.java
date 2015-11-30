package edu.bnu.fyp.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bnu.fyp.entity.Buyer;
import edu.bnu.fyp.entity.Seller;
import edu.bnu.fyp.service.BuyerService;
import edu.bnu.fyp.service.SellerService;

@Controller
public class ProfileController {
	
@Autowired 
private SellerService sellerService;
@Autowired 
private BuyerService buyerService;
	

	@RequestMapping(value = "/viewSellerProfile")
	public String viewSellerProfile(HttpServletRequest request, Model model) {
		HttpSession session=request.getSession();
		Long sellerId=(Long) session.getAttribute("sellerId");
		
		try {
			
			Seller seller=sellerService.findSellerBySellerId(sellerId);
			
			model.addAttribute("sellerFirstName", seller.getSellerFirstName());
			model.addAttribute("sellerLastName", seller.getSellerLastName());
			model.addAttribute("sellerMobile",seller.getSellerMobile());
			model.addAttribute("sellerAddress", seller.getSellerLocation());
			model.addAttribute("sellerBusiness", seller.getSellerType());
			
			return "SellerProfile";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "SellerProfile";
	}
	
	@RequestMapping(value = "/viewBuyerProfile")
	public String viewBuyerProfile(HttpServletRequest request, Model model) {
		HttpSession session=request.getSession();
		Long buyerId=(Long) session.getAttribute("buyerId");
		
		try {
			
			Buyer buyer=buyerService.findBuyerByBuyerId(buyerId);
			model.addAttribute("buyerName", buyer.getBuyerName());
			
			model.addAttribute("buyerMobile",buyer.getBuyerMobile());
			model.addAttribute("buyerEmail",buyer.getBuyerEmail());
			
			
			return "BuyerProfile";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "BuyerProfile";
	}

}
