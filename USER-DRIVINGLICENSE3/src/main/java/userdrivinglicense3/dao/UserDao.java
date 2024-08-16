package userdrivinglicense3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import userdrivinglicense3.dto.User;

public class UserDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sree");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	
	public void register(User saveuser) {
		et.begin();
		em.persist(saveuser);
		et.commit();
	}
	
	public User userLogin(String email, String pwd) {
		Query q =em.createQuery("select a from User a where email=?1 and pwd=?2");
		q.setParameter(1, email);
		q.setParameter(2, pwd);
		User u=(User) q.getSingleResult();
		return u;
		
	}
	public void updateUser(User u, String email) {
		Query q = em.createQuery("select a from user a where email=?1 ");
		q.setParameter(1, email);
		User db=(User) q.getSingleResult();
		try {
			if(u.getName()!=null) {
				db.setName(u.getName());
			}
			if(u.getPhoneNumber()!=0) {
				db.setPhoneNumber(0);
			}
			if(u.getEmail()!=null) {
				db.setEmail(u.getEmail());
			}
			if(u.getGender()!=null) {
				db.setGender(u.getGender());
			}
			if(u.getDl() != null) {
				db.setDl(u.getDl());
			}
			if(u.getPwd()!=null) {
				db.setPwd(u.getPwd());
			}
		}catch(Exception e) {
			System.out.println("the not found with the email"+email);
		}
		et.begin();
		em.merge(db);
		et.commit();
	}
	public User profileFetch(String email) {
		Query q = em.createQuery("select a from user a where email=?1 ");
		q.setParameter(1, email);
		User db=(User) q.getSingleResult();
		return db;
	}
	public void deleteUser(String email) {
		Query q = em.createQuery("select a from user a where email=?1 ");
		q.setParameter(1, email);
		User db=(User) q.getSingleResult();
		et.begin();
		em.remove(db);
		et.commit();
	}
}
	
	
	


