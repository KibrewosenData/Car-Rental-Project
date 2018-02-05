package srs;

import srs.db.DBFacade;
import srs.model.Car;
//import edu.mum.cs.srs.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SRSAppMainController {
	
	@FXML
	private TextField passwordField1;
	
	@FXML
	private TextField passwordField2; 
	
	@FXML
	private TextField passwordField3;
	
	@FXML
	private TextField passwordField4;
	
	@FXML
	private TextField passwordField5;
	
	@FXML
	private TextField txfldCity;
	
	@FXML
	private ComboBox<String> cmboxState;
	
	@FXML
	private TextField txfldZipLabel;
	
	@FXML
	private DatePicker dtePickerAdmissionDate;
	
    @FXML 
    private Text messageText;
    
    @FXML
    private ListView<String> listViewStudents;
    
    @FXML 
    protected void handleCustmorRegisterButtonAction(ActionEvent event) {
    	String brand = this.passwordField1.getText();
    	String vin = this.passwordField2.getText();
    	String type = this.passwordField3.getText();
    	String Catagory = this.passwordField4.getText();
    	double Rentprice = Double.parseDouble(this.passwordField5.getText());
    	
    	Car car = new Car(brand, vin,type,Catagory,Rentprice);
    	new DBFacade().registerNewCar(car);
    	
    	this.passwordField1.setText("");
    	this.passwordField2.setText("");
    	this.passwordField3.setText("");
    	this.passwordField4.setText("");
    	this.passwordField5.setText("");
    	
        messageText.setText("Student registered successfully.");
    }
}
