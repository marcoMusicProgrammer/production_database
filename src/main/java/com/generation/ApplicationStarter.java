package com.generation;

import com.generation.helpers.HibernateHelper;
import jakarta.persistence.EntityManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationStarter extends Application
{
	@Override
	public void start(Stage stage) throws IOException
	{

		FXMLLoader fxmlLoader = new FXMLLoader(ApplicationStarter.class.getResource("applicationView.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("Production Database");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args)
	{
		launch();
	}
}