package org.cononico.pro.daoImpl;

import java.util.List;

import org.cononico.pro.bean.MessageReply;
import org.cononico.pro.dao.MessageReplyDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository
public class MessageReplyImpl implements MessageReplyDao{

	private SessionFactory sessionFactory;  
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageReply> searchMessageReply(int number) {            //查询留言的回复
		// TODO Auto-generated method stub
		String hql = "form MessageReply mr where mr.message_id = ?";
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		query.setLong(0, number);
		List<MessageReply> messageReplyList = query.list();
		session.flush();
		session.close();
		return messageReplyList;
	}

	@Override
	public void saveMessageReply(MessageReply messageReply) {
		// TODO Auto-generated method stub
		Session session = (Session) sessionFactory.openSession();
		session.save(messageReply);
		session.flush();
		session.close();
	}

	@Override
	public void delReply(long id) {                      //删除回复
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		MessageReply mr = (MessageReply)session.get(MessageReply.class, id);
		System.out.println("+++++++++++++++++++++++++"+mr.getContent());
		mr.setMessage(null);
		session.saveOrUpdate(mr);
//		session.delete(mr);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}

	@Override
	public void deleteReply(long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		MessageReply mr = (MessageReply)session.get(MessageReply.class, id);
		session.delete(mr);
		session.getTransaction().commit();
		session.flush();
		session.close();
		
	}
	

	
	

}
