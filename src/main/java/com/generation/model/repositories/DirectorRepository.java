package com.generation.model.repositories;

import com.generation.model.entities.Director;

import java.util.List;

public class DirectorRepository extends RepositoryGenerica<Director>
{
	private static DirectorRepository instance;

	public static DirectorRepository getInstance()
	{
		if (instance == null)
		{
			instance = new DirectorRepository();
			System.out.println("Director Repository created");
		}

		return instance;
	}

	private DirectorRepository()
	{
		super(Director.class);
	}

	public Director findDirectorByNameAndSurname(String name, String surname)
	{
		List<Director> directors = em.createQuery("SELECT d FROM Director d WHERE name=: n AND surname=: sn",Director.class)
				.setParameter("n", name)
				.setParameter("sn", surname)
				.getResultList();
		
		if(directors.size() > 1)
			throw new RuntimeException("More than one director found");
		if(directors.size() == 1)
			directors.getFirst();
		
		return null;
	}


}
