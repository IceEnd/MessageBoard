package org.cononico.pro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cononico.pro.bean.Message;
import org.cononico.pro.bean.MessageReply;
import org.cononico.pro.dao.MessageService;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	@Test
	public void test() {
		Message message = new Message();
		List<MessageReply> reply = new ArrayList<MessageReply>();
		MessageReply messageReply1 = new MessageReply();
		MessageReply messageReply2 = new MessageReply();
		
		message.setUsername("haha2");
		message.setContent("今天星期天");
		Date date = new Date();
		message.setTime(date);
		
		messageReply1.setContent("明天六一");
		messageReply1.setTime(date);
		messageReply1.setUsername("hehe");
		reply.add(messageReply1);
		
		messageReply2.setContent("蓝胖子");
		messageReply2.setTime(date);
		messageReply2.setUsername("hehe");
		reply.add(messageReply2);
		message.setReply(reply);

		ApplicationContext context = new ClassPathXmlApplicationContext("/org/cononico/pro/config/applicationContext.xml");
		MessageService messageService = (MessageService) context.getBean("messageService");
		messageService.saveMessage(message);
	}
	
	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/org/cononico/pro/config/applicationContext.xml");
		MessageService messageService = (MessageService) context.getBean("messageService");
		
		Date date = new Date();
		MessageReply messageReply3 = new MessageReply();
		messageReply3.setContent("明天六一1111");
		messageReply3.setTime(date);
		messageReply3.setUsername("hehe22");
		long a = 1;
		messageService.updateMessage(a, messageReply3);
		
	}
	
	@Test 
	public void test2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/org/cononico/pro/config/applicationContext.xml");
		MessageService messageService = (MessageService) context.getBean("messageService");
		
		Message m = messageService.searchMessage(1);
		List<MessageReply> re = m.getReply();
		
		for(MessageReply mr : re){
			System.out.println(mr.getContent());
		}
	}

}
