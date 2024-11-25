package com.generation.model.Exceptions;

import com.generation.model.entities.Person;

public class PersonPropertyException extends RuntimeException
{
	String nomePropieta;
	String motivoErrore;

	public PersonPropertyException() {}

	public PersonPropertyException(String nomePropieta, String motivoErrore)
	{
		this.nomePropieta = nomePropieta;
		this.motivoErrore = motivoErrore;
	}

	@Override
	public String getMessage()
	{
		return "Nome: " + nomePropieta + "\nMotivo: " + motivoErrore;
	}
}
