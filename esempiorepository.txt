package com.generation.model.repositories;

import com.generation.helpers.HibernateHelper;
import com.generation.model.entities.Contract;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContractRepository extends RepositoryGenerica<Contract>
{
	//SINGLETON
	private static ContractRepository instance;

	public static ContractRepository getInstance()
	{
		if (instance == null)
			instance = new ContractRepository();
		return instance;
	}

	private ContractRepository()
	{
		//ogni COSTRUTTORE di un SOTTOTIPO
		//è OBBLIGATO a richiamare un COSTRUTTORE del SUPERTIPO
		super(Contract.class);
	}
	//FINE SINGLETON

	public List<Contract> findAllByEmployerName(String employerName)
	{
		return 	em.createQuery("select u from Contract u WHERE u.employer.name=:employerName", Contract.class)
				.setParameter("employerName", employerName)
				.getResultList();

	}
}
