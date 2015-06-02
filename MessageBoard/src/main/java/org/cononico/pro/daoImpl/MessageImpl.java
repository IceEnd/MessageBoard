package org.cononico.pro.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.cononico.pro.bean.Message;
import org.cononico.pro.bean.MessageReply;
import org.cononico.pro.dao.MessageDao;
import org.cononico.pro.vo.ListVo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MessageImpl implements MessageDao {
	
	private SessionFactory sessionFactory;  
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ListVo> getMessage(int number) {              //查找留言  以ListVo形式返回
		// TODO Auto-generated method stub
		List<ListVo> list = new ArrayList<>();
		String hql = "from Message m";
		Session session = sessionFactory.openSession();
	    Query query = session.createQuery(hql);
	    List<Message> messageList = query.list();
	    
	    for(Message m : messageList){
	    	ListVo lv = new ListVo();
	    	lv.setMessage(m);
	    	String rhql = "from MessageReply mr where mr.message = ?";
	    	Query rq =  session.createQuery(rhql);
			rq.setLong(0, m.getId());
			lv.setMessageReplyList(m.getReply());
			list.add(lv);
	    	
	    }
	    
	    session.flush();
	    session.close();
		return list;
	}

	@Override
	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(message);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void updateMessage(long id,MessageReply messageReply) {             //更新留言（插入留言的回复）
		// TODO Auto-generated method stub
		 String hql = "from Message where id = ?";
	     Session session = sessionFactory.openSession();
	     
	     Query query = session.createQuery(hql);
	     query.setLong(0, id);
	     query.setMaxResults(1);                             // 必须在查询之前指定，使其返回单个对象  
	     Message target = (Message) query.uniqueResult();
	     
	     List<MessageReply> mr = target.getReply();
	     for(MessageReply mRe : mr){
	    	 System.out.println(mRe.getUsername() +"  " +mRe.getContent());
	     }
	     System.out.println(target.getId());
	     
	     List<MessageReply> reply = target.getReply();
	     reply.add(messageReply);
	     
	     System.out.println(messageReply.getContent());
	     
	     session.saveOrUpdate(target);
	     session.flush();
	     session.close();
	}

	@Override
	public Message searchMessage(long id) {
		// TODO Auto-generated method stub
		String hql = "from Message where id = ?";
		Session session = sessionFactory.openSession(); 
	    Query query = session.createQuery(hql);
	    query.setLong(0, id);
	    query.setMaxResults(1); 
	    Message message = (Message) query.uniqueResult();
	    session.flush();
	    session.close();
		return message;
	}

	@Override
	public void delMessage(long id) {                        //删除留言
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Message m = (Message)session.get(Message.class, id);
		session.delete(m);
		session.getTransaction().commit();
		session.flush();
		session.close();
		
	}

}
