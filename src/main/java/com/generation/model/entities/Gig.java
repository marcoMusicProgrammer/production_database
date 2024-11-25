package com.generation.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "gig", schema = "production_database")
@AttributeOverrides({
		@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
})
public class Gig extends BaseEntity
{
	@Column(name = "charcter", length = 50)
	private String charcter;

	@Column(name = "payment")
	private Integer payment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id")
	private Film film;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "actor_id")
	private Actor actor;

	public Gig(){}
	public Gig(String charcter, Integer payment)
	{
		this.setCharcter(charcter);
		this.setPayment(payment);
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getCharcter()
	{
		return charcter;
	}

	public void setCharcter(String charcter)
	{
		this.charcter = charcter;
	}

	public Integer getPayment()
	{
		return payment;
	}

	public void setPayment(Integer payment)
	{
		this.payment = payment;
	}

	public Film getFilm()
	{
		return film;
	}

	public void setFilm(Film film)
	{
		this.film = film;
	}

	public Actor getActor()
	{
		return actor;
	}

	public void setActor(Actor actor)
	{
		this.actor = actor;
	}

}