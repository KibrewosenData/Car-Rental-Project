package srs;

import java.util.List;

import srs.db.DBFacade;
import srs.model.Student;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;

public class SRSAppMain extends Application {
	
	private ObservableList<String> studentsList;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Maharishi University of Management - Computer Science - Students Registration System");
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SRSAppMain2.fxml"));
			Scene scene = new Scene(root,960,640);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Populate listView
			List<Student> students = new DBFacade().getStudents();
			String[] arrStudentNames = new String[students.size()];
			int i = 0;
			for(Student s : students) {
				arrStudentNames[i] = s.getStudentNumber() + " - " + s.getFirstName();
				i++;
			}
			
			BorderPane borderPaneListViewStudents = (BorderPane)root.lookup("#borderPaneListView");
			
			studentsList = FXCollections.<String>observableArrayList(arrStudentNames);
			ListView<String> listViewStudents = new ListView<String>();
			listViewStudents.setOrientation(Orientation.VERTICAL);
			listViewStudents.setPrefWidth(940.0);
			listViewStudents.setPrefHeight(220.0);
			listViewStudents.getItems().addAll(studentsList);
			
			borderPaneListViewStudents.setCenter(listViewStudents);
			BorderPane.setMargin(listViewStudents, new Insets(10.0, 10.0, 10.0, 10.0));
					
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public ObservableList<String> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(ObservableList<String> studentsList) {
		this.studentsList = studentsList;
	}
	
}
