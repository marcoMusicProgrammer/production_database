package com.generation.helpers;

import com.generation.model.entities.Actor;
import com.generation.model.entities.Director;
import com.generation.model.entities.Film;
import com.generation.model.entities.Gig;
import com.generation.model.repositories.ActorRepository;
import com.generation.model.repositories.DirectorRepository;
import com.generation.model.repositories.FilmRepository;
import com.generation.model.repositories.GigRepository;

import java.util.List;

public class ControllerHelper
{

	private static ControllerHelper instance;
	public static ControllerHelper getInstance()
	{
		if(instance == null)
			instance = new ControllerHelper();
		return instance;
	}
	private ControllerHelper(){}


	private FilmRepository 		filmRepository 		= FilmRepository.getInstance();
	private DirectorRepository 	directorRepository 	= DirectorRepository.getInstance();
	private ActorRepository 	actorRepository 	= ActorRepository.getInstance();
	private GigRepository 		gigRepository 		= GigRepository.getInstance();

	public String insertFilmToText(String t, String rd, String g, String r)
	{
		Film sameFilm = filmRepository.findFilmByName(t);
		if(sameFilm != null)
			return "Film already exists";

		Film film = new Film(t,rd,g,r);
		filmRepository.insert(film);

		return "Film inserted successfully";
	}

	public String getAllFilms()
	{
		List<Film> filmList = filmRepository.findAll();
		StringBuilder b = new StringBuilder();

		if (filmList != null)
		{
			for (Film film : filmList)
			{
				b.append(film.getId())
						.append(film.getId() < 10 ? "  " :
								film.getId() > 100 ? " " :
								"  ")
						.append(film.getTitle() + " - ")
						.append(film.getGenre() + " ")
						.append(film.cost())
						.append("\n");
			}
			return b.toString();
		}
		return "No films stored";
	}
		
	public String getAllDirectors()
	{
		List<Director> directorList = directorRepository.findAll();
		StringBuilder b = new StringBuilder();

		if (directorList != null)
		{
			for (Director director : directorList)
			{
				b.append(director.getId())
						.append(director.getId() < 10 ? "  " :
								director.getId() > 100 ? " " :
								"  ")
						.append(director.getName() + " ")
						.append(director.getSurname() + " ")
						.append("\n");
			}
			return b.toString();
		}
		return "No directors stored";
	}
		
	public String getAllActors()
	{
		List<Actor> actorList = actorRepository.findAll();
		StringBuilder b = new StringBuilder();
		System.out.println(actorList.size());

		if(!actorList.isEmpty())
		{
			for (Actor actor : actorList)
			{
				b.append(actor.getId())
						.append(actor.getId() < 10 ? "  " :
								actor.getId() > 100 ? " " :
								"  ")
						.append(actor.getName() + " ")
						.append(actor.getSurname() + " ")
						.append("\n");
			}
			return b.toString();
		}

		return "No actors stored";
	}

	public String assignDirectorToString(String id, String filmTitle)
	{
		Film film;
		Director director;
		try
		{
			film = filmRepository.findFilmByName(filmTitle);
			director = directorRepository.find(Integer.parseInt(id));
		} catch (Exception e)
		{
			e.getMessage();
			return "No film assigned";

		}

		if(film != null && director != null)
		{
			film.setDirector(director);
			directorRepository.modify(director);

			return "Film assigned successfully";
		}

		return "No film assigned";
	}

	public String insertDirectorToString(String n,String sn,String g,String b)
	{
		Director sameDirector = directorRepository.findDirectorByNameAndSurname(n,sn);
		if(sameDirector != null)
			return "Director already exists";
		
		Director director = new Director(n,sn,g,b,100000);
		directorRepository.insert(director);
		
		return "Director inserted successfully";
	}
	
	public String insertActorToString(String n,String sn,String g,String b)
	{
		Actor sameActor = actorRepository.findActorByNameAndSurname(n,sn);
		System.out.println(sameActor);
		if(sameActor != null)
			return "Actor already exists";
		
		Actor actor = new Actor(n,sn,g,b);
		actorRepository.insert(actor);
		
		return "Actor inserted successfully";
	}

	public String insertGigToText(String cn,String p,String na,String sa,String nf)
	{
		Gig sameGig = gigRepository.findGigByCharacterAndPayment(cn,p);
		if(sameGig != null)
			return "Gig already exists";

		Gig gig = new Gig(cn,Integer.parseInt(p));

		Actor actor = actorRepository.findActorByNameAndSurname(na,sa);
		System.out.println(actor);
		System.out.println(na);
		System.out.println(sa);
		if(actor == null)
			return "No actor stored with name: "+ na + " and surname: " + sa;

		Film film = filmRepository.findFilmByName(nf);
		if(film == null)
			return "No film stored with name: "+ nf;

		gig.setFilm(film);
		gig.setActor(actor);

		gigRepository.insert(gig);
		gigRepository.modify(gig);

		return "Actor inserted successfully";
	}
}
