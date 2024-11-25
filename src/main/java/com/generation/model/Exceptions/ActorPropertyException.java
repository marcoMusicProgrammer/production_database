package com.generation.model.Exceptions;

import com.generation.model.entities.Actor;

public class ActorPropertyException extends RuntimeException
{
	String nomePropieta;
	String motivoErrore;

	public ActorPropertyException() {}

	public ActorPropertyException(String nomePropieta, String motivoErrore)
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
