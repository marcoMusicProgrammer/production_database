package com.generation.model.entities;

import com.generation.model.Exceptions.PersonPropertyException;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Person extends BaseEntity
{
	private String name;
	private String surname;
	private LocalDate dob;
	private String gender;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		if(name == null)
			throw new PersonPropertyException("Name","null");
			this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		if(surname == null)
			throw new PersonPropertyException("Surname","null");
		this.surname = surname;
	}

	public LocalDate getDob()
	{
		return dob;
	}

	public void setDob(LocalDate dob)
	{
		if(dob == null)
			throw new PersonPropertyException("Dob","null");
		if(dob.isAfter(LocalDate.now()))
			throw new PersonPropertyException("Dob","not before now");

		this.dob = dob;
	}

	public void setDob(String dob)
	{
		LocalDate parse = LocalDate.parse(dob);

		if(parse == null)
			throw new PersonPropertyException("Dob","null");
		if(parse.isAfter(LocalDate.now()))
			throw new PersonPropertyException("Dob","not before now");

		this.dob = parse;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		if(gender == null)
			throw new PersonPropertyException("Gender","null");
		this.gender = gender;
	}
}
