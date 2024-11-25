package com.generation.model.repositories;

import com.generation.helpers.HibernateHelper;
import com.generation.model.entities.BaseEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

//							T non può essere qualsiasi TIPO, ma deve rispettare il vincolo
//							di essere un SOTTOTIPO di BaseEntity (va bene anche BaseEntity stessa)
//RepositoryGenerica<String> NOOOOOO, perchè String non è sottotipo di BaseEntity
//RepositoryGenerica<Contract> SIIII, perchè Contract è sottotipo di BaseEntity
public abstract class RepositoryGenerica<T extends BaseEntity>
{
	protected EntityManager em = HibernateHelper.getEntityManager();
	protected Class<T> entityClass;

	public RepositoryGenerica(Class<T> entityClass)
	{
		this.entityClass = entityClass;
	}

	public List<T> findAll()
	{
		return em.createQuery("select u from " + entityClass.getSimpleName() + "  u", entityClass).getResultList();
	}

	public T find(int id)
	{
		return em.find(entityClass, id);
	}

	public void insert(T t)
	{
		//se t ha già un id allora dai eccezione
		if (t.getId() != null)
			throw new RuntimeException("No, non voglio che id lo dia tu");
		em.getTransaction().begin();//qui iniziamo la transazione
		em.persist(t);//persist=save
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void modify(T t)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.merge(t);//merge=update
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void delete(int id)
	{

		T toDelete = find(id);//prima prendiamo lo contract con quell'id
		if (toDelete == null)//se non l'abbiamo trovato
			throw new RuntimeException(entityClass.getSimpleName() + " to delete not found");

		em.getTransaction().begin();
		em.remove(toDelete);
		em.getTransaction().commit();
	}
	//FINE METODI CRUD DI BASE
}
