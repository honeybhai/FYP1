package edu.bnu.fyp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;

import edu.bnu.fyp.entity.AttributeOption;
import edu.bnu.fyp.entity.Category;
import edu.bnu.fyp.entity.CategoryAttribute;
import edu.bnu.fyp.entity.Comment;
import edu.bnu.fyp.entity.Item;
import edu.bnu.fyp.entity.ItemAttribute;
import edu.bnu.fyp.entity.Seller;
import edu.bnu.fyp.service.AttributeOptionService;
import edu.bnu.fyp.service.CategoryAttributeService;
import edu.bnu.fyp.service.CategoryService;
import edu.bnu.fyp.service.CommentsService;
import edu.bnu.fyp.service.ItemAttributeService;
import edu.bnu.fyp.service.ItemService;
import edu.bnu.fyp.service.SellerService;

@Controller


public class ProductsController {
	@Autowired
	private SellerService sellerService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private CommentsService commentsService;
	@Autowired
	private ItemAttributeService itemAttributeService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryAttributeService categoryAttributeService;
	@Autowired
	private AttributeOptionService attributeOptionService;
	@RequestMapping(value="/viewProducts")
	public String viewProducts(HttpServletRequest request, Model model){
		HttpSession session=request.getSession();
		try {
			
			if(session.getAttribute("userRole").equals("seller")){
				Seller seller=sellerService.findSellerByUserId((Long)session.getAttribute("userId"));
				
				List<Item> itemList=new ArrayList<>();
				itemList=itemService.getItemsBySellerId(seller.getSellerId());
				model.addAttribute("itemList", itemList);
				
			}else{
				System.out.println(request.getParameter("sellerId"));
				Seller seller=sellerService.findSellerBySellerId(Long.parseLong(request.getParameter("sellerId")));
				List<Item> itemList=new ArrayList<>();
				itemList=itemService.getItemsBySellerId(seller.getSellerId());
				model.addAttribute("itemList", itemList);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ViewProducts";
	}
	@RequestMapping(value="/viewProduct")
	public String viewProduct(HttpServletRequest request, Model model){
		
		
		HttpSession session=request.getSession();
		
		try {
			
			

			
			Item item = itemService.getItemByItemId(Long.valueOf(request.getParameter("itemId")));
			
			
			Seller seller=sellerService.findSellerBySellerId(item.getSellerId());
			Category category=categoryService.getCategoryByCategoryId(item.getCategoryId());
			
			List<Comment> commentList=commentsService.getCommentsByItemId(Long.valueOf(request.getParameter("itemId")));
			List<ItemAttribute> itemAttributes=itemAttributeService.getItemAttributeOptionListForProduct(item.getItemId());
			model.addAttribute("commentList", commentList);
			model.addAttribute("productOptionList",itemAttributes);
			model.addAttribute("item",item);
			model.addAttribute("category",category);
			model.addAttribute("seller",seller);
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ViewProduct";
		
	}
	@RequestMapping (value="/addNewProduct")
	public String addNewProduct(HttpServletRequest request,Model model,  @RequestParam(required = false) Long itemId){
		
		HttpSession session=request.getSession();
		try {
			//hard coded here
			if(session.getAttribute("sellerType").equals("laptop")){
				List<AttributeOption> brandOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("3"));
				List<AttributeOption> processorOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("4"));
				List<AttributeOption> screenOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("5"));
				model.addAttribute("screen", screenOption);
				model.addAttribute("brand", brandOption);
				model.addAttribute("processor", processorOption);
			}else if(session.getAttribute("sellerType").equals("auto")){
				List<AttributeOption> brandOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("8"));
				List<AttributeOption> processorOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("9"));
				List<AttributeOption> screenOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("10"));
	
				model.addAttribute("screen", screenOption);
				model.addAttribute("brand", brandOption);
				model.addAttribute("processor", processorOption);

			}
			else if(session.getAttribute("sellerType").equals("desktop")){
				List<AttributeOption> brandOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("18"));
				List<AttributeOption> processorOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("19"));
				List<AttributeOption> screenOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("20"));
	
				model.addAttribute("screen", screenOption);
				model.addAttribute("brand", brandOption);
				model.addAttribute("processor", processorOption);

			}
			else if(session.getAttribute("sellerType").equals("mobile")){
				List<AttributeOption> brandOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("13"));
				List<AttributeOption> processorOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("14"));
				List<AttributeOption> screenOption=attributeOptionService.getAttributeOptionListByCategoryAttributeId(Long.parseLong("15"));
	
				model.addAttribute("screen", screenOption);
				model.addAttribute("brand", brandOption);
				model.addAttribute("processor", processorOption);

			}
			if(itemId!=null){
				Item item=itemService.getItemByItemId(itemId);
				List<ItemAttribute> itemAttributeList=itemAttributeService.getItemAttributeOptionListForProduct(itemId);
				
				
				model.addAttribute("wifi",itemAttributeList.get(0).getAttributeOption());
				model.addAttribute("bluetooth",itemAttributeList.get(1).getAttributeOption());
				model.addAttribute("Brand",itemAttributeList.get(2).getAttributeOption());
				model.addAttribute("Processor",itemAttributeList.get(3).getAttributeOption());
				model.addAttribute("Screen",itemAttributeList.get(4).getAttributeOption());
				model.addAttribute("item",item);
			}else{
				
				Item item=new Item();
				model.addAttribute("item",item);
			}
			
			List<CategoryAttribute> categoryAttributes=categoryService.getCategoryAttributeListByCategoryId((Long)session.getAttribute("categoryId"));
			model.addAttribute("name1", categoryAttributes.get(0).getCategoryAttributeName());
			model.addAttribute("name2", categoryAttributes.get(1).getCategoryAttributeName());
			model.addAttribute("name3", categoryAttributes.get(2).getCategoryAttributeName());
			model.addAttribute("name4", categoryAttributes.get(3).getCategoryAttributeName());
			model.addAttribute("name5", categoryAttributes.get(4).getCategoryAttributeName());		
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(itemId!=null){
			return "EditProduct";
		}else{
			return "AddNewProduct";
		}
	}
	
	@RequestMapping(value="/saveNewProduct", method=RequestMethod.POST)
	public String saveNewProduct(@ModelAttribute Item item, HttpServletRequest request){
		//caution hard code here :P :D
		HttpSession session=request.getSession();
		item.setCategoryId((Long)session.getAttribute("categoryId"));
		item.setSellerId((Long)session.getAttribute("sellerId"));
		try {
			if(item.getItemId()!=null){
				itemService.updateItem(item);
				List<CategoryAttribute> categoryAttributeList=categoryService.getCategoryAttributeListByCategoryId(item.getCategoryId());
				List<ItemAttribute> itemAttributeList=itemAttributeService.getItemAttributessByItemId(item.getItemId());
				
		
				
				
				itemAttributeList.get(0).setAttributeOption(request.getParameter("wifi"));
				itemAttributeList.get(1).setAttributeOption(request.getParameter("bluetooth"));
				itemAttributeList.get(2).setAttributeOption(request.getParameter("brand"));
				itemAttributeList.get(3).setAttributeOption(request.getParameter("processor"));
				itemAttributeList.get(4).setAttributeOption(request.getParameter("screen"));
				itemAttributeService.updateItemAttributes(itemAttributeList);
			}else if(itemService.addNewItem(item)){
				Long itemId=itemService.getMaxItemId();
				List<CategoryAttribute> categoryAttributeList=categoryService.getCategoryAttributeListByCategoryId(item.getCategoryId());
				List<ItemAttribute> itemAttributeList=new ArrayList<>();
				
				Long num;
				String a="0"; 
				
				for(CategoryAttribute i:categoryAttributeList){
					num=i.getCategoryAttributeId();
					ItemAttribute itemAttribute=new ItemAttribute();
					itemAttribute.setCategoryAttributeId(num);
					itemAttribute.setItemId(itemId);
					itemAttributeList.add(itemAttribute);
					
				}
				
				itemAttributeList.get(0).setAttributeOption(request.getParameter("wifi"));
				itemAttributeList.get(1).setAttributeOption(request.getParameter("bluetooth"));
				itemAttributeList.get(2).setAttributeOption(request.getParameter("brand"));
				itemAttributeList.get(3).setAttributeOption(request.getParameter("processor"));
				itemAttributeList.get(4).setAttributeOption(request.getParameter("screen"));
				itemAttributeService.addItemAttributes(itemAttributeList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return "ViewProducts";
	}
	@RequestMapping(value="/deleteProduct")
	public String deleteProduct(HttpServletRequest request){
		try {
			Item item = itemService.getItemByItemId(Long.valueOf(request.getParameter("itemId")));
			itemAttributeService.deleteItemAttributes(item.getItemId());
			itemService.deleteItem(item.getItemId());
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ViewProducts";
	}
	@RequestMapping(value="/addComment")
	public String addComment(HttpServletRequest request){
		HttpSession session=request.getSession();
		Comment comment=new Comment();
		comment.setComment(request.getParameter("comment"));
		comment.setBuyerId((Long)session.getAttribute("buyerId"));
		comment.setItemId(Long.parseLong(request.getParameter("itemId")));
		try {
			itemService.addComment(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/viewProduct.bnu?itemId="+request.getParameter("itemId");
	}
}

