package org.cononico.pro.vo;

import java.util.ArrayList;
import java.util.List;

import org.cononico.pro.bean.Message;
import org.cononico.pro.bean.MessageReply;

/**
 * 存储留言和留言回复的vo
 * @author Cononico
 *
 */
public class ListVo {
	
	private Message message;
	
	private List<MessageReply> messageReplyList = new ArrayList<MessageReply>();

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<MessageReply> getMessageReplyList() {
		return messageReplyList;
	}

	public void setMessageReplyList(List<MessageReply> messageReplyList) {
		this.messageReplyList = messageReplyList;
	}
	
	

}
