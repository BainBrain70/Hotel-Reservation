/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;
import java.time.LocalDate;
import java.io.*;
/**
 *
 * @author CodyWickman
 */
public class HotelReservation extends Application {
    private Label firstName;
    private Label lastName;
    private Label email;
    private Label country;
    private Label state;
    private Label address;
    private Label city;
    private Label postalCode;
    private Label phoneNum;
    private Label cardType;
    private Label cardNum;
    private Label expirationDate;
    private Label expirationYear;
    private Label roomType;
    private Label room2Type;
    private Label numRooms;
    private Label numGuests;
    private Label inDate;
    private Label outDate;
    private Label termsCond;
    private TextField roomsField;
    private TextField guestsField;
    private TextField fNameField;
    private TextField lNameField;
    private TextField emailField;
    private TextField countryField;
    private TextField stateField;
    private TextField addressField;
    private TextField cityField;
    private TextField postalField;
    private TextField phoneField;
    private TextField cardField;
    private TextField cardNumField;
    private TextField expDateField;
    private TextField expYearField;
    private TextField roomField;
    private TextField inDateField;
    private TextField outDateField;
    LocalDate ld;
    
    int i = 0;
    
    @Override
    public void start(Stage primaryStage) {
        
      Scene scene = null;         // Scene contains all content
      GridPane gridPane = null;   // Positions components within scene
      
      gridPane = new GridPane();   // Create an empty pane
      scene = new Scene(gridPane);
      
      DatePicker dp = new DatePicker();
      DatePicker dp2 = new DatePicker();
        
      Button nextPageBtn = new Button("Next Page");
      Button saveButton = new Button ("Save");
      Button paymentButton = new Button ("Continue");
      Button confirmationButton = new Button ("Confirm");
      
      firstName = new Label("First Name*");
      lastName = new Label("Last Name*");
      email = new Label ("Email Address*");
      address = new Label ("Address*");
      country = new Label ("Country / Reigon*");
      city = new Label("City*");
      state = new Label("State*");
      postalCode = new Label ("Postal Code*");
      phoneNum = new Label("Phone Number*");
      
      fNameField = new TextField(); 
      fNameField.setPrefColumnCount(15);
      fNameField.setEditable(true);
      fNameField.setText("");
      
      lNameField = new TextField(); 
      lNameField.setPrefColumnCount(15);
      lNameField.setEditable(true);
      lNameField.setText("");
      
      emailField = new TextField(); 
      emailField.setPrefColumnCount(15);
      emailField.setEditable(true);
      emailField.setText("");
      
      addressField = new TextField(); 
      addressField.setPrefColumnCount(15);
      addressField.setEditable(true);
      addressField.setText("");
      
      countryField = new TextField(); 
      countryField.setPrefColumnCount(15);
      countryField.setEditable(true);
      countryField.setText("");
      
      stateField = new TextField(); 
      stateField.setPrefColumnCount(15);
      stateField.setEditable(true);
      stateField.setText("");
      
      cityField = new TextField(); 
      cityField.setPrefColumnCount(15);
      cityField.setEditable(true);
      cityField.setText("");
      
      postalField = new TextField(); 
      postalField.setPrefColumnCount(15);
      postalField.setEditable(true);
      postalField.setText("");
      
      phoneField = new TextField(); 
      phoneField.setPrefColumnCount(15);
      phoneField.setEditable(true);
      phoneField.setText("");
      
      gridPane.setPadding(new Insets(30, 30, 30, 30)); // Padding around  grid
      gridPane.setHgap(10);                            // Spacing between columns
      gridPane.setVgap(10); 
      
      gridPane.add(firstName, 0,0);
      gridPane.add(fNameField, 0,1);
      gridPane.add(lastName, 1, 0);
      gridPane.add(lNameField,1,1);
      gridPane.add(email, 0,2);
      gridPane.add(emailField, 0,3);
      gridPane.add(address,0,4);
      gridPane.add(addressField,0,5);
      gridPane.add(country,0,6);
      gridPane.add(countryField,0,7);
      gridPane.add(city,0,8);
      gridPane.add(cityField,0,9);
      gridPane.add(state,0,10);
      gridPane.add(stateField,0,11);
      gridPane.add(postalCode,0,12);
      gridPane.add(postalField,0,13);
      gridPane.add(phoneNum,0,14);
      gridPane.add(phoneField,0,15);
      gridPane.add(saveButton,0,16);
      gridPane.add(nextPageBtn,0,17);
      
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             try {
                SaveFile();
             }
             catch (IOException e) {
                 
             }
             
       
            }
        });
        
        nextPageBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                  Scene scene = null;         // Scene contains all content
                  GridPane gridPane = null;   // Positions components within scene
      
                  gridPane = new GridPane();   // Create an empty pane
                  scene = new Scene(gridPane);
                  
                  inDate = new Label ("Check-In Date");
                  outDate = new Label ("Check-Out Date");
                  roomType = new Label ("Room Type");
                  numRooms = new Label ("Number of Rooms");
                  numGuests = new Label ("Number of Guests");
                  room2Type = new Label ("Room 2 Type (If Applicable)");
                  
                  guestsField = new TextField(); 
                  guestsField.setPrefColumnCount(15);
                  guestsField.setEditable(true);
                  guestsField.setText("");
                  
                  roomsField = new TextField(); 
                  roomsField.setPrefColumnCount(15);
                  roomsField.setEditable(true);
                  roomsField.setText("");
                  
                  ChoiceBox<String> choiceBox = new ChoiceBox<>();
                  
                  choiceBox.getItems().add("Guest Room, 2 Queen");
                  choiceBox.getItems().add("Guest Room, 1 Queen");
                  choiceBox.getItems().add("Guest Room, 1 King");
                  choiceBox.getItems().add("Executive Suite, 1 King, 1 Sofa");
                  
                  ChoiceBox<String> cb2 = new ChoiceBox<>();
                  
                  cb2.getItems().add("Guest Room, 2 Queen");
                  cb2.getItems().add("Guest Room, 1 Queen");
                  cb2.getItems().add("Guest Room, 1 King");
                  cb2.getItems().add("Executive Suite, 1 King, 1 Sofa");
             
             
               
                  
                  
                  gridPane.setPadding(new Insets(30, 30, 30, 30)); // Padding around  grid
                  gridPane.setHgap(10);                            // Spacing between columns
                  gridPane.setVgap(10);
                  
                  gridPane.add(inDate,0,0);
                  gridPane.add(dp,0,1);
                  gridPane.add(outDate,0,2);
                  gridPane.add(dp2,0,3);
                  gridPane.add(numGuests,0,4);
                  gridPane.add(guestsField,0,5);
                  gridPane.add(numRooms,0,6);
                  gridPane.add(roomsField,0,7);
                  gridPane.add(roomType,0,8);
                  gridPane.add(choiceBox,0,9);
                  gridPane.add(room2Type,0,10);
                  gridPane.add(cb2,0,11);
                  gridPane.add(paymentButton,0,12);
                  
                 primaryStage.setTitle("Room Information");
                 primaryStage.setScene(scene);
                 primaryStage.show();
       
            }
        });
        
        paymentButton.setOnAction(new EventHandler<ActionEvent>()  {
            
            @Override
            public void handle(ActionEvent event) {
            	Scene scene = null;
            	GridPane gridPane = null;
            	
            	gridPane = new GridPane();
            	scene = new Scene(gridPane);
            	
            	cardType = new Label("Card Type");
            	cardNum = new Label("Card Number");
            	expirationDate = new Label("Expiration Date");
            	expirationYear = new Label("Expiration Year");
            	
            	cardNumField = new TextField();
            	cardNumField.setEditable(true);
            	cardNumField.setText("");
            	
            	expDateField = new TextField();
            	expDateField.setEditable(true);
            	expDateField.setText("");
            	
            	expYearField = new TextField();
            	expYearField.setEditable(true);
            	expYearField.setText("");
            	
            	
            	ChoiceBox<String> choiceBox = new ChoiceBox<>();
            	
            	choiceBox.getItems().add("Visa");
            	choiceBox.getItems().add("MasterCard");
            	choiceBox.getItems().add("AmericanExpress");
            	
            	gridPane.setPadding(new Insets(30, 30, 30, 30)); // Padding around  grid
                gridPane.setHgap(10);                            // Spacing between columns
                gridPane.setVgap(10);
            	
            	gridPane.add(cardType,0,0);
            	gridPane.add(choiceBox, 0,1);
            	gridPane.add(cardNum, 0, 2);
            	gridPane.add(cardNumField, 0, 3);
            	gridPane.add(expirationDate, 0, 4);
            	gridPane.add(expDateField,0,5);
            	gridPane.add(expirationYear, 0, 6);
            	gridPane.add(expYearField, 0, 7);
            	gridPane.add(confirmationButton, 0,8 );
            	
            	 primaryStage.setTitle("Payment Information");
                 primaryStage.setScene(scene);
                 primaryStage.show();
       
            }
        });
        
        confirmationButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             
       
            }
        });
        
        
        primaryStage.setTitle("Guest Information");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void RoomCost () {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void SaveFile () throws IOException {
        try {
            FileWriter filewriter;
            filewriter = new FileWriter("guestInfo.txt");
            filewriter.write(fNameField.getText());
            filewriter.write(" ");
            filewriter.write(lNameField.getText());
            filewriter.write("\n");
            filewriter.write(emailField.getText());
            filewriter.write("\n");
            filewriter.write(countryField.getText());
            filewriter.write("\n");
            filewriter.write(addressField.getText() + " " + cityField.getText()
            + ", " + stateField.getText() + postalField.getText());
            filewriter.write("\n");
            filewriter.write(phoneField.getText());
            filewriter.write("\n");
            filewriter.close();
            
        }
        catch (IOException e) {
            
        }
    }
 
    	public static int stringToInt(String s) {
    	    try {
    	        return Integer.valueOf(s);
    	    } catch (NumberFormatException e) {
    	        return 0;
    	    }
    	}
}
    
