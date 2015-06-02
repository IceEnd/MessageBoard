package org.cononico.pro.service;

import java.util.List;

import org.cononico.pro.bean.Message;
import org.cononico.pro.bean.MessageReply;
import org.cononico.pro.dao.MessageDao;
import org.cononico.pro.dao.MessageService;
import org.cononico.pro.vo.ListVo;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MessageServiceImpl implements MessageService {

	
	private MessageDao messageDao;
	
	@Override
	public List<ListVo> getMessage(int number) {
		// TODO Auto-generated method stub
		List<ListVo> list = messageDao.getMessage(number);
		return list;
	}

	@Override
	public void saveMessage(Message message) {           //留言
		// TODO Auto-generated method stub
		messageDao.saveMessage(message);
	}
	
	@Override
	public void updateMessage(long id,MessageReply messageReply) {          //更新留言（插入留言回复）
		// TODO Auto-generated method stub
		messageDao.updateMessage(id,messageReply);
		
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public Message searchMessage(long id) {
		// TODO Auto-generated method stub
		Message m = messageDao.searchMessage(id);
		return m;
	}

	@Override
	public void delMessage(long id) {                             //删除留言
		// TODO Auto-generated method stub
		messageDao.delMessage(id);
		
	}


}
