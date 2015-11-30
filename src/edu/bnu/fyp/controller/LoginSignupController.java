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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bnu.fyp.entity.Admin;
import edu.bnu.fyp.entity.Buyer;
import edu.bnu.fyp.entity.Seller;
import edu.bnu.fyp.entity.User;
import edu.bnu.fyp.service.AdministratorService;
import edu.bnu.fyp.service.BuyerService;
import edu.bnu.fyp.service.CategoryService;
import edu.bnu.fyp.service.SellerService;
import edu.bnu.fyp.service.UserService;

/**
 * @author Honey
 * 
 */
@Controller
public class LoginSignupController {
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private AdministratorService adminService;
	@RequestMapping(value = "/login")
	public String loginPage(Model model) {
		User user = new User();

		model.addAttribute(user);
		return "Login";
	}

	@RequestMapping(value = "/tryLogin", method = RequestMethod.POST)
	public String login(HttpServletRequest request, @ModelAttribute User user) {

		User checkUser = new User();
		
		try {
			checkUser = userService.findUserByEmail(user.getUserEmail());

			if (user.getUserEmail().contains(checkUser.getUserEmail()) && user.getPassword().contains(checkUser.getPassword())) {
				HttpSession session=request.getSession();
				session.setAttribute("userName", checkUser.getUserName());
				session.setAttribute("userRoleNum", checkUser.getRole());
				session.setAttribute("userId", checkUser.getUserId());
				if(checkUser.getRole()==1){
					session.setAttribute("userRole","administrator" );
					Admin admin=adminService.findAdminByUserId(checkUser.getUserId());
					session.setAttribute("adminId", admin.getAdminId());
				}else if(checkUser.getRole()==2){
					
					session.setAttribute("userRole","buyer");
					Buyer buyer=buyerService.findBuyerByUserId(checkUser.getUserId());
					session.setAttribute("buyerId", buyer.getBuyerId());
				}else if(checkUser.getRole()==3){
					session.setAttribute("userRole","seller" );
					
					Seller seller=sellerService.findSellerByUserId(checkUser.getUserId());
					session.setAttribute("sellerId", seller.getSellerId());
					session.setAttribute("sellerType",seller.getSellerType());
					session.setAttribute("categoryId", categoryService.getCategoryByCategoryName(seller.getSellerType()).getCategoryId());
				}
				return "redirect:/welcome.bnu";
			} else {
				return "Login";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "login";

	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("userName");
		session.removeAttribute("userRole");
		session.removeAttribute("userId");
		session.removeAttribute("sellerType");
		session.removeAttribute("categoryId");
		session.removeAttribute("sellerId");
		session.removeAttribute("buyerId");
		session.removeAttribute("adminId");
		
		System.out.println("logout");
		return "redirect:/welcome.bnu";
	}
	
	@RequestMapping(value = "/signUp")
	public String signUp(Model model){
		User user=new User();
		model.addAttribute("user",user);
		return "SignUp";
	}
	
	@RequestMapping(value="/trySignUp")
	public String trySignUp(HttpServletRequest request, @ModelAttribute User user){
		try {
			
			List<User> userList=userService.getAllUsers();
			for(User i:userList){
				if(i.getUserEmail().equals(user.getUserEmail())){
					return "redirect:/signUp.bnu";
				}
			}
			if(user.getPassword().equals(request.getParameter("password"))){
				if(request.getParameter("category").equals("buyer")){
					user.setRole(Long.parseLong("2"));
					userService.addUser(user);
					Buyer buyer=new Buyer();
					buyer.setBuyerName(user.getUserName());
					buyer.setBuyerEmail(user.getUserEmail());
					buyer.setBuyerMobile(request.getParameter("mobile"));
					buyer.setUserId(userService.getMaxUserId());
					buyerService.addBuyer(buyer);
					return "Login";
				}else{
					user.setRole(Long.parseLong("3"));
					userService.addUser(user);
					Seller seller=new Seller();
					seller.setSellerFirstName(user.getUserName());
					seller.setSellerLastName(request.getParameter("lastName"));
					seller.setSellerLocation(request.getParameter("address"));
					seller.setSellerMobile(request.getParameter("mobile"));
					seller.setUserId(userService.getMaxUserId());
					seller.setSellerType(request.getParameter("category"));
					sellerService.addSeller(seller);
					return "Login";

					
				}
				
			}else{
				return "redirect:/signUp.bnu";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/welcome.bnu";
		
	}

}
