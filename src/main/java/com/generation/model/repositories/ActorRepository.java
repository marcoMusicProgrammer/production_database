package com.generation.model.repositories;

import com.generation.model.entities.Actor;

import java.util.List;

public class ActorRepository extends RepositoryGenerica<Actor>
{
	private static ActorRepository instance;

	public static ActorRepository getInstance()
	{
		if (instance == null)
		{
			instance = new ActorRepository();
			System.out.println("Actor Repository created");
		}
		return instance;
	}

	private ActorRepository()
	{
		super(Actor.class);
	}

	public Actor findActorByNameAndSurname(String nameAc, String surnameAc)
	{
		List<Actor> actors = em.createQuery("SELECT a FROM Actor a WHERE a.name=:n AND a.surname=:sn", Actor.class)
				.setParameter("n", nameAc)
				.setParameter("sn", surnameAc)
				.getResultList();

		if(actors.size() > 1)
			throw new RuntimeException("More than one actor found");
		if(actors.size() == 1)
			return actors.getFirst();

		return null;
	}

}
