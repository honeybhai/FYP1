/**
 * 
 */
package edu.bnu.fyp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bnu.fyp.entity.Category;
import edu.bnu.fyp.entity.Item;
import edu.bnu.fyp.entity.Seller;
import edu.bnu.fyp.service.CategoryService;
import edu.bnu.fyp.service.ItemService;
import edu.bnu.fyp.service.SellerService;

/**
 * @author Honey
 *
 */
@Controller
public class SearchController {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private CategoryService categoryService;
	@RequestMapping(value="/searchInput",method=RequestMethod.POST)
	public String searchInput(HttpServletRequest request, Model model){
		
		try {
			String search=request.getParameter("searchInput");
			List<Item> itemList= itemService.getItemsByItemName("%"+search+"%");
			List<Category> categoryList=categoryService.getAllCategoriesByCategoryName("%"+search+"%");
			List<Seller> sellerList=sellerService.getSellersBySellersName("%"+search+"%");

			model.addAttribute("sellerList",sellerList);
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("itemList", itemList);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ViewSearchResult";
	}
	
	
	

}
