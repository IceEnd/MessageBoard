package org.cononico.pro.dao;

import java.util.List;

import org.cononico.pro.bean.Message;
import org.cononico.pro.bean.MessageReply;
import org.cononico.pro.vo.ListVo;

public interface MessageService {
	
	public List<ListVo> getMessage(int number);         //查询留言
	
	public void saveMessage(Message message);            //留言
	
	public void updateMessage(long id,MessageReply messageReply);
	
	public Message searchMessage(long id);
	
	public void delMessage(long id);                       //删除留言
	
}
