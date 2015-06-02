package org.cononico.pro.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.cononico.pro.bean.Message;
import org.cononico.pro.bean.MessageReply;
import org.cononico.pro.dao.MessageReplyService;
import org.cononico.pro.dao.MessageService;
import org.cononico.pro.vo.ListVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ApplicationContext context = new ClassPathXmlApplicationContext("/org/cononico/pro/config/applicationContext.xml");
		MessageService messageService = (MessageService) context.getBean("messageService");
		
		List<ListVo> list = messageService.getMessage(1);
		//System.out.println(list.get(0).getMessage().getUsername()+"-===-=========");
		return new ModelAndView("index","list",list);
	}
	
	@RequestMapping(value = "/message",method = RequestMethod.GET)
	public ModelAndView Message(@ModelAttribute("message")Message message,BindingResult result,RedirectAttributes redirectAttributes){
		ApplicationContext context = new ClassPathXmlApplicationContext("/org/cononico/pro/config/applicationContext.xml");
		MessageService messageService = (MessageService) context.getBean("messageService");
		
		Date date = new Date();
		message.setTime(date);
		messageService.saveMessage(message);
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping(value = "/reply",method = RequestMethod.GET)
	public ModelAndView reply(@ModelAttribute("messageReply")MessageReply messageReply,BindingResult result,RedirectAttributes redirectAttributes,HttpServletRequest request){
		ApplicationContext context = new ClassPathXmlApplicationContext("/org/cononico/pro/config/applicationContext.xml");
		MessageService messageService = (MessageService) context.getBean("messageService");
		MessageReplyService replyService = (MessageReplyService) context.getBean("messageReplyService");
		
		Message m = messageService.searchMessage(messageReply.getId());
		
		MessageReply mr = new MessageReply();
		Date date = new Date();
		mr.setUsername(messageReply.getUsername());
		mr.setContent(messageReply.getContent());
		mr.setTime(date);
		mr.setMessage(m);
		
		replyService.saveMessageReply(mr);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/rdelete")                                  //删除回复
	public ModelAndView rDelete(HttpServletRequest request){
		System.out.println("-----------------------"+request.getParameter("id"));
		long id = Long.parseLong(request.getParameter("id"));
		long mid = Long.parseLong(request.getParameter("mid"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/org/cononico/pro/config/applicationContext.xml");
		MessageReplyService messageReplyService = (MessageReplyService) context.getBean("messageReplyService");
		messageReplyService.delReply(id);
		messageReplyService.deleteReply(id);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/mdelete")                                 //删除留言
	public ModelAndView mdelete(HttpServletRequest request){
		System.out.println("-----------------------"+request.getParameter("id"));
		long id = Long.parseLong(request.getParameter("id"));
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/org/cononico/pro/config/applicationContext.xml");
		MessageService messageService = (MessageService) context.getBean("messageService");
		
		messageService.delMessage(id);
		return new ModelAndView("redirect:/");
	}
	
	
}
