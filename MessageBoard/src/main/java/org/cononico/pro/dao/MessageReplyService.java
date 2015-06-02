package org.cononico.pro.dao;

import java.util.List;

import org.cononico.pro.bean.MessageReply;

public interface MessageReplyService {

	public List<MessageReply> searchMessageReply(int number);           //查询留言回复
	
	public void saveMessageReply(MessageReply messageReply);
	
	public void delReply(long id);
	
	public void deleteReply(long id);
	
}
