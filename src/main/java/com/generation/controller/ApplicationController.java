package com.generation.controller;

import com.generation.helpers.ControllerHelper;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ApplicationController
{
	private ControllerHelper helper = ControllerHelper.getInstance();

	@FXML
	private TextField filmTitle;
	@FXML
	private TextField releaseDateFilm;
	@FXML
	private TextField filmGenre;
	@FXML
	private TextField filmRevenue;
	@FXML
	private TextField assignIdDirector;
	@FXML
	private TextField assignFilmTitle;
	@FXML
	private TextField insertNameDirector;
	@FXML
	private TextField insertSurnameDirector;
	@FXML
	private TextField insertGenderDirector;
	@FXML
	private TextField insertBirthDirector;
	@FXML
	private TextField insertNameActor;
	@FXML
	private TextField insertSurnameActor;
	@FXML
	private TextField insertGenderActor;
	@FXML
	private TextField insertBirthActor;
	@FXML
	private TextField characterNameFilm;
	@FXML
	private TextField characterPayment;
	@FXML
	private TextField gigNameActor;
	@FXML
	private TextField gigSurnameActor;
	@FXML
	private TextField gigFilmName;

	@FXML
	private Text insertFilmText;
	@FXML
	private Text getAllEntityText;
	@FXML
	private Text textAssigned;
	@FXML
	private Text insertActorToText;
	@FXML
	private Text insertDirectorToText;
	@FXML
	private Text insertGigToText;

	public void insertFilm()
	{
		String title = filmTitle.getText();
		String releaseDate = releaseDateFilm.getText();
		String genre = filmGenre.getText();
		String revenue = filmRevenue.getText();

		String context = helper.insertFilmToText(title,releaseDate,genre,revenue);
		insertFilmText.setText(context);
	}

	public void getAllFilms()
	{
		String context = helper.getAllFilms();
		System.out.println(context);
		getAllEntityText.setText(context);
	}

	public void gelAllActors()
	{
		String context = helper.getAllActors();
		System.out.println(context);
		getAllEntityText.setText(context);
	}

	public void getAllDirectors()
	{
		String context = helper.getAllDirectors();
		System.out.println(context);
		getAllEntityText.setText(context);
	}

	public void assignDirector()
	{
		String id_director = assignIdDirector.getText();
		String film_title = assignFilmTitle.getText();

		String context = helper.assignDirectorToString(id_director,film_title);
		textAssigned.setText(context);
	}

	public void insertDirector()
	{
		String name 	= insertNameDirector.getText();
		String surname 	= insertSurnameDirector.getText();
		String gender 	= insertGenderDirector.getText();
		String birth 	= insertBirthDirector.getText();

		String context 	= helper.insertDirectorToString(name,surname,gender,birth);
		insertDirectorToText.setText(context);
	}

	public void insertActor()
	{
		String name 	= insertNameActor.getText();
		String surname 	= insertSurnameActor.getText();
		String gender 	= insertGenderActor.getText();
		String birth 	= insertBirthActor.getText();

		String context 	= helper.insertActorToString(name,surname,gender,birth);
		insertActorToText.setText(context);
	}

	public void insertGig()
	{
		String characterName 	= characterNameFilm.getText();
		String payment 			= characterPayment.getText();
		String nameActor 		= gigNameActor.getText();
		String surnameActor 	= gigSurnameActor.getText();
		String nameFilm 		= gigFilmName.getText();

		String context = helper.insertGigToText(characterName,payment,nameActor,surnameActor,nameFilm);
		insertGigToText.setText(context);
	}
}


