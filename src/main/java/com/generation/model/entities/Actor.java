package com.generation.model.entities;

import com.generation.model.Exceptions.ActorPropertyException;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actor", schema = "production_database")
@AttributeOverrides({
		@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
		@AttributeOverride(name = "name", column = @Column(name = "name", length = 50)),
		@AttributeOverride(name = "surname", column = @Column(name = "surname", length = 50)),
		@AttributeOverride(name = "gender", column = @Column(name = "gender", length = 50)),
		@AttributeOverride(name = "dob", column = @Column(name = "dob", length = 50))
})
public class Actor extends Person
{

	public Actor()
	{
	}

	public Actor(String firstName, String lastName, String gender, String dob)
	{
		this.setName(firstName);
		this.setSurname(lastName);
		this.setGender(gender);
		this.setDob(dob);
	}

	@OneToMany(mappedBy = "actor")
	List<Gig> gigs = new ArrayList<>();

	@Column(name = "main_language", length = 50)
	private String mainLanguage;

	public String getMainLanguage()
	{
		return mainLanguage;
	}

	public void setMainLanguage(String mainLanguage)
	{
		if (mainLanguage != null && !mainLanguage.isEmpty())
			throw new ActorPropertyException("Language", "null");
		this.mainLanguage = mainLanguage;
	}

	public Set<Film> getAllFilms()
	{
		Set<Film> res = new HashSet<>();

		for (Gig gig : gigs)
			res.add(gig.getFilm());

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
}