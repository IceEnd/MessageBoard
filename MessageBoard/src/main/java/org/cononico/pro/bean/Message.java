package org.cononico.pro.bean;

/**
 * 留言板主表
 * 包括用户信息，留言内容，留言时间，以及回复
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	
	@Id@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="username")
	private String username;
	
	private String content;       //留言内容
	
	private Date time;            //留言时间
	
	@OneToMany(cascade=CascadeType.ALL ,fetch = FetchType.EAGER,mappedBy = "message")
	private List<MessageReply> reply = new ArrayList<MessageReply>();    //回复

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<MessageReply> getReply() {
		return reply;
	}

	public void setReply(List<MessageReply> reply) {
		this.reply = reply;
	}
}
