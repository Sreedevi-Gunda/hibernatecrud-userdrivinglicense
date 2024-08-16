package userdrivinglicense3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import userdrivinglicense3.dto.DrivingLicense;
import userdrivinglicense3.dto.User;

public class DrivingLicenseDao {
	

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sree");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void register(DrivingLicense d, int id) {
		Query q = em.createQuery("select a from user a where id=?1");
		q.setParameter(1,id);
		User u=(User)q.getSingleResult();
		try {
			u.setDl(d);
			et.begin();
			  em.persist(d);
			  em.merge(u);
			  et.commit();
		}catch(Exception e){
			System.out.println("data not found with the id"+id);
		}		
	}
	
	 public DrivingLicense login(int dlNum,String name) {
			Query q =em.createQuery("select a from DrivingLicense a where dlNum=?1 and name=?2");
			q.setParameter(1, dlNum);
			q.setParameter(2, name);
			DrivingLicense dl =(DrivingLicense)q.getSingleResult();
			return dl;
		}
	 
	public void updateDrivingLicense(DrivingLicense d1,int id) {
		Query q = em.createQuery("select a from user a where id=?1");
		q.setParameter(1,id);
		User u1=(User)q.getSingleResult();
		DrivingLicense db= u1.getDl();
		if(db==null){
			System.out.println("data not found");	
		}else {
			DrivingLicense db1=em.find(DrivingLicense.class, db.getdLid());
			if(d1.getName()!=null) {
				db1.setName(d1.getName());
			}
			if(d1.getDlNum()!=0) {
				db1.setDlNum(d1.getDlNum());
			}
		
			et.begin();
			em.merge(db1);
			et.commit();
	}
		}
	
	public void fetchDrivinglicense(String email) {
		Query q = em.createQuery("select a from user a where email=?1");
		q.setParameter(1,email);
		User u=(User)q.getSingleResult();
		DrivingLicense dl= u.getDl();
			DrivingLicense dl1=em.find(DrivingLicense.class, dl.getdLid());
			System.out.println(dl1);	
		}	
	

	
	public void deleteDrivinglicense(int id) {
		Query q = em.createQuery("select a from user a where id=?1");
		q.setParameter(1,id);
		User u=(User)q.getSingleResult();
		DrivingLicense dl= u.getDl();
		if(dl==null){
			System.out.println("data not found");	
		}else {
			DrivingLicense dl1=em.find(DrivingLicense.class, dl.getdLid());
			et.begin();
			  em.remove(dl1);
			  et.commit();	
	}
	}
}
	
	
	
	


