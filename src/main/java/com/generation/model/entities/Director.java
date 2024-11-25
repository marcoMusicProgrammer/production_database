package com.generation.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "director", schema = "production_database")
@AttributeOverrides({
		@AttributeOverride(name = "id", 		column = @Column(name = "id", nullable = false)),
		@AttributeOverride(name = "name", 		column = @Column(name = "name", length = 50)),
		@AttributeOverride(name = "surname", 	column = @Column(name = "surname", length = 50)),
		@AttributeOverride(name = "gender", 	column = @Column(name = "gender", length = 50)),
		@AttributeOverride(name = "dob", 		column = @Column(name = "dob", length = 50))
})

public class Director extends Person
{
	Integer workCosto;

	@OneToMany (mappedBy = "director")
	List<Film> films = new ArrayList<>();

	public Director(){}

	public Director(String name, String surname, String gender, String dob,Integer workCosto)
	{
		this.setName(name);
		this.setSurname(surname);
		this.setGender(gender);
		this.setDob(dob);
		this.setWorkCosto(workCosto);
	}

	public List<Film> getFilms()
	{
		List<Film> newFilms = new ArrayList<>(this.films);
		return newFilms;
	}

	public void setFilms(List<Film> films)
	{
		this.films = films;
	}

	public Integer getWorkCosto()
	{
		return workCosto;
	}

	public void setWorkCosto(Integer workCosto)
	{
		this.workCosto = workCosto;
	}
}