package com.generation.model.entities;

import com.generation.model.Exceptions.FilmPropertyException;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "film", schema = "production_database")
@AttributeOverrides({
		@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
})
public class Film extends BaseEntity
{
	@Column(name = "title", length = 50)
	private String title;

	@Column(name = "releaseDate", length = 50)
	private LocalDate releaseDate;

	@Column(name = "genre", length = 50)
	private String genre;

	@Column(name = "revenue")
	private Integer revenue;

	@ManyToOne
	@JoinColumn(name = "director_id")
	private Director director;

	@OneToMany(mappedBy = "film")
	private List<Gig> gigs = new ArrayList<>();

	public Film(){}

	public Film(String title, LocalDate releaseDate, String genre, Integer revenue)
	{
		this.setTitle(title);
		this.setReleaseDate(releaseDate);
		this.setGenre(genre);
		this.setRevenue(revenue);
	}

	public Film(String title, String releaseDate, String genre, String revenue)
	{
		this.setTitle(title);
		this.setReleaseDate(releaseDate);
		this.setGenre(genre);
		this.setRevenue(revenue);
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		if(id < 1)
			throw new FilmPropertyException("id","minore 1");
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		if(title.equals(" "))
			throw new FilmPropertyException("title","vuoto");
		if(title.equals(""))
			throw new FilmPropertyException("title","vuoto");
		if(title.contains("'"))
		{
			title = title.replace("'","''");
		}

		this.title = title;
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate)
	{
		if(releaseDate == null)
			throw new FilmPropertyException("releaseDate","vuoto");
		this.releaseDate = releaseDate;
	}

	public void setReleaseDate(String releaseDate)
	{
		LocalDate parse = LocalDate.parse(releaseDate);
		if(parse == null)
			throw new FilmPropertyException("releaseDate","vuoto");
		this.releaseDate = parse;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		if(genre.equals(" "))
			throw new FilmPropertyException("genre","vuoto");
		if(genre.equals(""))
			throw new FilmPropertyException("genre","vuoto");

		this.genre = genre;
	}

	public Integer getRevenue()
	{
		return revenue;
	}

	public void setRevenue(Integer revenue)
	{
		if(revenue < 0)
			throw new FilmPropertyException("revenue","minore 0");
		this.revenue = revenue;
	}

	public void setRevenue(String revenue)
	{
		Integer parse = Integer.parseInt(revenue);
		if(parse < 0)
			throw new FilmPropertyException("revenue","minore 0");
		this.revenue = parse;
	}

	public Director getDirector()
	{
		return director;
	}

	public void setDirector(Director director)
	{
		if(director == null)
			throw new FilmPropertyException("director","vuoto");
		this.director = director;
	}


	/**
	 * Cerca tutti gli attori che sono collegati con relazione n-n ai film
	 * @return
	 */
	public Set<Actor> getAllActors()
	{
		Set<Actor> res = new HashSet<>();

		for(Gig gig : gigs)
		{
			res.add(gig.getActor());
		}

		return res;
	}

	public List<Gig> getGigs()
	{
		List<Gig> res = new ArrayList<>(gigs);

		return res;
	}

	public void setGigs(Gig gig)
	{
		this.gigs.add(gig);
	}

	public int cost()
	{
		Director dir 		= this.getDirector();
		List<Gig> newGigs 	= this.getGigs();

		int res = dir.getWorkCosto();

		for(Gig gig : newGigs)
		{
			res += gig.getPayment();
		}

		return res;
	}
}