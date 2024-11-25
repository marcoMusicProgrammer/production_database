package com.generation.model.Exceptions;

import com.generation.model.entities.Film;

public class FilmPropertyException extends RuntimeException
{
	String nomePropieta;
	String motivoErrore;

	public FilmPropertyException() {}

	public FilmPropertyException(String nomePropieta, String motivoErrore)
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
