package com.generation.model.repositories;

import com.generation.model.entities.Film;

import java.util.List;

public class FilmRepository extends RepositoryGenerica<Film>
{
	private static FilmRepository instance;

	public static FilmRepository getInstance()
	{
		if (instance == null)
		{
			instance = new FilmRepository();
			System.out.println("Film Repository created");
		}

		return instance;
	}

	private FilmRepository()
	{
		super(Film.class);
	}

	public Film findFilmByName(String name)
	{
		List<Film> films = em.createQuery("SELECT f FROM Film f WHERE title=:nm", Film.class)
				.setParameter("nm", name)
				.getResultList();

		if(films.size() > 1)
			throw new RuntimeException("Problema con il database");
		if(films.size() == 1)
			return films.getFirst();

		return null;
	}
}
