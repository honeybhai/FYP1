/**
 * 
 */
package edu.bnu.fyp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.xpath.internal.operations.Mod;

import edu.bnu.fyp.entity.Wishlist;
import edu.bnu.fyp.service.ItemAttributeService;
import edu.bnu.fyp.service.ItemService;
import edu.bnu.fyp.service.WishlistService;

/**
 * @author Honey
 *
 */
@Controller
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	@Autowired
	private ItemService itemService;
 	
	@RequestMapping(value= "/addToWishlist")
	public String addToWishlist(HttpServletRequest request){
		HttpSession session=request.getSession();
		Wishlist wishlist=new Wishlist();
		wishlist.setBuyerId((Long)session.getAttribute("buyerId"));
		wishlist.setItemId(Long.parseLong(request.getParameter("itemId")));
		try {
			wishlistService.addWishlist(wishlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Home";
	}
	@RequestMapping(value="/viewWishlist")
	public String viewWishlist(HttpServletRequest request, Model model){
		HttpSession session=request.getSession();
		try {
			List<Wishlist> wishList=wishlistService.getWishlist((Long)session.getAttribute("buyerId"));
			model.addAttribute("wishlist",wishList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ViewWishlist";
	}
	@RequestMapping(value="/deleteFromWishlist")
	public String deleteFromWishlist(HttpServletRequest request){
		try {
			wishlistService.deleteWishlist(Long.parseLong(request.getParameter("wishlistId")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ViewWishlist";
	}
}
