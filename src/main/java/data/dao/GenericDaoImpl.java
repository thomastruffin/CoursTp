package data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

public class GenericDaoImpl<BO , ID> implements CRUDInterface<BO, ID>{
	private Class<BO> clazz;
	private EntityManagerFactory emf;
	
	public GenericDaoImpl(Class<BO> clazz){
		this.clazz = clazz;
		emf = Persistence.createEntityManagerFactory("coursDB");
	}
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl(String str) throws ClassNotFoundException{
		this((Class<BO>) Class.forName(str));
	}
	
	
	public Class<BO> getClazz() {
		return clazz;
	}

	public void setClazz(Class<BO> clazz) {
		this.clazz = clazz;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<BO> selectAll() {
		EntityManager em = this.getSession();
		List<BO> list = em.createQuery("from"+clazz.getName(),clazz).getResultList();
		em.close();
		return list;
	}

	@Override
	public BO selectById(ID id) {
		EntityManager em = this.getSession();
		BO bo = em.find(clazz, id);
		em.close();
		return bo; 
	}

	@Override
	public BO update(BO bo) {
		EntityManager em = getSession();
		em.getTransaction().begin();
		BO save = bo;
		try {
			em.merge(bo);
		}catch(Exception e) {
			e.printStackTrace();
			save=null;
			em.getTransaction().rollback();
		}
		em.close();
		return save;
	}

	@Override
	public BO delete(ID id) {
		EntityManager em = getSession();
		em.getTransaction().begin();
		BO save = selectById(id);
		try {
			em.createQuery("DELETE FROM"+clazz+"");
		}catch(Exception e) {
			e.printStackTrace();
			save=null;
			em.getTransaction().rollback();
		}
		em.close();
		return save;
	}

	@Override
	public void insert(BO bo) {
		EntityManager em = getSession();
		em.getTransaction().begin();
		try {
			em.persist(em);
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		
	}
	public EntityManager getSession() {
		return emf.createEntityManager();
	}
}
