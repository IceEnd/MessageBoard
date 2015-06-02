package org.cononico.pro.service;

import java.util.List;

import org.cononico.pro.bean.MessageReply;
import org.cononico.pro.dao.MessageReplyDao;
import org.cononico.pro.dao.MessageReplyService;

public class MessageReplyServiceImpl implements MessageReplyService{

	private MessageReplyDao messageReplyDao;
	
	@Override
	public List<MessageReply> searchMessageReply(int number) {         //查询留言回复
		// TODO Auto-generated method stub
		List<MessageReply> messageReplyList = messageReplyDao.searchMessageReply(number);
		return messageReplyList;
	}

	@Override
	public void saveMessageReply(MessageReply messageReply) {            //回复留言
		// TODO Auto-generated method stub
		messageReplyDao.saveMessageReply(messageReply);
		
	}

	public MessageReplyDao getMessageReplyDao() {                
		return messageReplyDao;
	}

	public void setMessageReplyDao(MessageReplyDao messageReplyDao) {
		this.messageReplyDao = messageReplyDao;
	}

	@Override
	public void delReply(long id) {
		// TODO Auto-generated method stub
		messageReplyDao.delReply(id);
	}

	@Override
	public void deleteReply(long id) {
		// TODO Auto-generated method stub
		messageReplyDao.deleteReply(id);
	}
	
	

}
