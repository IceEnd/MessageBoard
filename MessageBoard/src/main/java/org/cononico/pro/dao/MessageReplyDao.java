package org.cononico.pro.dao;

import java.util.List;

import org.cononico.pro.bean.MessageReply;

/**
 * 留言的回复
 * @author Cononico
 *
 */
public interface MessageReplyDao {
	
	public List<MessageReply> searchMessageReply(int number);           //查询留言回复
	
	public void saveMessageReply(MessageReply messagereply);            //发表回复
	
	public void delReply(long id);                                      //移除回复
	
	public void deleteReply(long id);                                     //删除   

}
