package com.generation.model.repositories;

import com.generation.model.entities.Gig;

import java.util.List;

public class GigRepository extends RepositoryGenerica<Gig>
{
	private static GigRepository instance;

	public static GigRepository getInstance()
	{
		if (instance == null)
		{
			instance = new GigRepository();
			System.out.println("Gig Repository created");
		}

		return instance;
	}

	private GigRepository()
	{
		super(Gig.class);
	}

	public Gig findGigByCharacterAndPayment(String character,String payment)
	{
		List<Gig> gigs = em.createQuery("SELECT f FROM Gig f WHERE charcter=:c AND payment=:p", Gig.class)
				.setParameter("c", character)
				.setParameter("p", payment)
				.getResultList();

		if(gigs.size() > 1)
			throw new RuntimeException("Problema con il database");
		if(gigs.size() == 1)
			return gigs.getFirst();

		return null;
	}
}
