/**
 * 
 */
package edu.bnu.fyp.controller;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bnu.fyp.entity.Message;
import edu.bnu.fyp.entity.User;
import edu.bnu.fyp.service.MessageService;
import edu.bnu.fyp.service.UserService;

/**
 * @author Honey
 *
 */
@Controller
public class MessagesController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/viewMessages")
	public String viewMessages(HttpServletRequest request, Model model){
		HttpSession session=request.getSession();
		try {
			List<Message> messagesList=messageService.getDistinctUserFromMessages((Long)session.getAttribute("userId"));
			model.addAttribute("userList",messagesList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ViewMessages";
	}
	@RequestMapping(value="/viewThread")
	public String viewtheread(HttpServletRequest request,Model model){
		//System.out.println("role = "+request.getParameter("role")+" userId = "+request.getParameter("userId"));
		HttpSession session=request.getSession();
		try {
			List<Message> messagesList=messageService.getMessagesBySenderId(Long.parseLong(request.getParameter("userId")),(Long)session.getAttribute("userId"));
			Message message=new Message();
			model.addAttribute("sender",userService.findUserById(Long.parseLong(request.getParameter("userId"))));
			model.addAttribute("messageList",messagesList);
			model.addAttribute("message",message);
			//System.out.println("recvr = "+userService.findUserById(Long.parseLong(request.getParameter("userId"))).getUserName()+" sender = "+userService.findUserById((Long)session.getAttribute("userId")).getUserName());
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ViewThread";
	}
	@RequestMapping(value="/replyMessage")
	public String replyMessage(@ModelAttribute Message message, HttpServletRequest request){
		HttpSession session=request.getSession();

		message.setSenderRole((Long)session.getAttribute("userRoleNum"));
		message.setSenderUserId((Long)session.getAttribute("userId"));
		try {
			messageService.addMessage(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/viewMessages.bnu";
	}
	@RequestMapping(value="/deleteThread")
	public String deleteMessage(HttpServletRequest request){
		HttpSession session=request.getSession();
		try {
			messageService.deleteThread(Long.parseLong(request.getParameter("userId")),(Long)session.getAttribute("userId"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/viewMessages.bnu";
	}

}
