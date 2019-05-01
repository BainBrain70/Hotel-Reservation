/**
 * Hotel Reservation Program that allows a user to enter their information.
 *
 * 
 */
package hotelreservation;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Modality;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;
import java.time.LocalDate;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.internet.MimeMessage;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author CodyWickman, ChrisBain
 */
public class HotelReservation extends Application {
    private Label firstName;  // Label for the first name of the guest
    private Label lastName;   // Label for the last name of the guest
    private Label prefTitle;  // Label for the preferred title of the guest
    private Label email;      // Label for the guest email
    private Label country;    // Label for the guests country
    private Label state;      // Label for the guests state
    private Label address;    // Label for the guests address
    private Label city;       // Label for the guests city
    private Label postalCode; // Label for the guests postal code
    private Label phoneNum;   // Label for the guests phone number
    
    private Label cardType;   // Label for type of credit card
    private Label cardNum;    // Label for the card number
    private Label expirationDate;   // Label for the card expiration date
    private Label nameOnCard;   // Label for the name on the card
    private Label ccvNumber;    // Label for the ccv number on card
    
    private Label roomType;    // Label for the room type
    private Label numGuests;   // Label for the number of guests
    private Label inDate;      // Label for check in date
    private Label outDate;     // Label for the check out date
    private Label termsCond;
   
    private TextField roomsField;       // Text Field for number of rooms
    private TextField guestsField;      // Text field for number of guests
    private TextField fNameField;       // Text field for guest first name
    private TextField lNameField;       // Text field for guest last name
    private TextField prefTitleField;   // Text field for the guest preferred title
    private TextField emailField;       // Text field for the guest email
    private TextField countryField;     // Text field for the guests country
    private TextField stateField;       // Text field for the guests state
    private TextField addressField;     // Text field for the guests address
    private TextField cityField;        // Text field for the guests city
    private TextField postalField;      // Text field for the guests postal code
    private TextField phoneField;       // Text field for the guests phone number
  
    private TextField cardNumField;     // Text field for the guests card number
    private TextField expDateField;     // Text field for the card expiration date
    private TextField nameOnCardField;  // Text field for the name on the card
    private TextField ccvNumberField;   // Text field for the ccv number on card
    
    LocalDate ld;   // Local Date for the date picker for check in and check out
    DatePicker dp;  // Date picker for the check in date
    DatePicker dp2; // Date picker for the check out date
    ComboBox choiceBox; // Combo box for the guest to select the room they want
    ComboBox cardSelect; // Combo Box for the guest to select the card type
    ComboBox cardExpMonth; // Combo Box for the guest to select the card exp month
    ComboBox cardExpYear;  // Combo box for the guest to select the card exp year
  
    double roomCost;  // Variable for the cost of the room
    int nightsStayed; //Variable for the nights the guest is statying
    
    
    
    @Override
    public void start(Stage primaryStage) {
      
      Stage window = primaryStage; // Setting the primaryStage to variable window
      Scene scene1 = null;         // Scene contains all content
      GridPane gridPane = null;    // Positions components within scene
      
      gridPane = new GridPane();   // Create an empty pane
      scene1 = new Scene(gridPane); //Create a scene that includes the grid pane
      
      dp = new DatePicker(); // Create new date picker for check in
      dp2 = new DatePicker(); //Create a second date picker for check out
      
      // Button for going to the next page from the second scene
      Button nextPageBtn = new Button("Next Page");
      
      // Button that takes you to payment page
      Button paymentButton = new Button ("Payment");
      
      // Button that takes you to review page
      Button confirmationButton = new Button ("Review Reservation");
      
      // Button that will show you your room
      Button showRoomButton = new Button("Show My Room");
      
      // Button that takes you to the review page and saves your reservation
      Button reviewButton = new Button("Review and Save my Reservation");
      
      // Button that confirms your reservation
      Button confirmButton = new Button ("Confirm my Reservation");
      
      // Button that takes you to the first scene after you decide to book a room
      Button bookButton = new Button("Book A Room");
      
      // Button that takes you from the third scene to the second scene
      Button previousPage1 = new Button("Previous Page");
      
      // Button that takes you from fourth scene to third scene
      Button previousPage2 = new Button("Previous Page");
      
      // Button that takes you directly to guest info page
      Button guestInfo = new Button("Guest Information");
      
      // Button that takes you directly to room info page
      Button roomInfo = new Button("Room Information");
      
      // Button that takes you directly to the payment page
      Button paymentInfo = new Button("Payment Information");
      
      // Assign the picture file to variable pic
      String pic = "file:hotelPic.jpg";
      
      // Create a new image object that takes the pic file
      Image image = new Image(pic);
      
      //Create a new VBox
      VBox vBox = new VBox();
      
      // Create output label object
      Label outputLabel = new Label("Welcome");
      
      // Set the output label to a certain string
      outputLabel.setText("\n \n Welcome to Hotel Java Fresno!\n \n");
      
      // Create an imageView object that allows you to view the picture
      ImageView imageView = new ImageView(image);
      
      // Add the image, the outputLabel and the bookButton to the VBox
      vBox.getChildren().addAll(imageView,outputLabel, bookButton);
      
      // Allign the VBox to the center 
      vBox.setAlignment(Pos.CENTER);
      
      // Scene that contains the Vbox and 600 insets of spacing
      scene1 = new Scene(vBox, 600,600);

        //Event handler for when the book button is pressed
        bookButton.setOnAction(new EventHandler<ActionEvent>() {
            
          /** Method is automatically called when the book button is pressed. */
            @Override
            public void handle(ActionEvent event) {
                
                GridPane gridPane = null;   // Positions components within scene
      
                 gridPane = new GridPane();   // Create an empty pane
                 Scene scene2 = new Scene(gridPane); //Create scene2 with gridpane
                 
                 // Create the first name label and name it
                 firstName = new Label("First Name*");
                 
                 // Last name label 
                 lastName = new Label("Last Name*");
                 
                 // Guest Preferred title label
                 prefTitle = new Label("Preferred Title");
                 
                 // Guests email label
                 email = new Label ("Email Address*");
                 
                 // Guests address label
                 address = new Label ("Address*");
                 
                 // Guests country label
                 country = new Label ("Country / Reigon*");
                 
                 // Guests city label
                 city = new Label("City*");
                 
                 // Guests state label
                 state = new Label("State*");
                 
                 // Postal code label
                 postalCode = new Label ("Postal Code*");
                 
                 // Phone num label
                 phoneNum = new Label("Phone Number*");
      
                // First name text field for the guest
                fNameField = new TextField(); 
                fNameField.setPrefColumnCount(15);
                fNameField.setEditable(true);  // Allow them to enter their fName
                fNameField.setText("");
      
                // Last name text field for the guest
                lNameField = new TextField(); 
                lNameField.setPrefColumnCount(15);
                lNameField.setEditable(true);  // Allow them to enter their lName
                lNameField.setText("");
      
                // Preferred title text field for the guest
                prefTitleField = new TextField(); 
                prefTitleField.setPrefColumnCount(15);
                prefTitleField.setEditable(true); // Let user enter their pref title
                prefTitleField.setText("");
      
                // Email text field for the guest
                emailField = new TextField(); 
                emailField.setPrefColumnCount(15);
                emailField.setEditable(true); // Let them enter their email
                emailField.setText("");
      
                // Address text field for the guest
                addressField = new TextField(); 
                addressField.setPrefColumnCount(15);
                addressField.setEditable(true); // Let them enter their address
                addressField.setText("");
      
                // Country text field for the guest
                countryField = new TextField(); 
                countryField.setPrefColumnCount(15);
                countryField.setEditable(true); // Let them enter their country
                countryField.setText("");
      
                // State text field for the guest
                stateField = new TextField(); 
                stateField.setPrefColumnCount(15);
                stateField.setEditable(true); // Let them enter their state
                stateField.setText("");
      
                // City text field for the guest
                cityField = new TextField(); 
                cityField.setPrefColumnCount(15);
                cityField.setEditable(true); // Let them enter their city
                cityField.setText("");
      
                // Posta code text field for the guest
                postalField = new TextField(); 
                postalField.setPrefColumnCount(15);
                postalField.setEditable(true); // Let them enter their postal code
                postalField.setText("");
      
                // Phone number field for the guest
                phoneField = new TextField(); 
                phoneField.setPrefColumnCount(15);
                phoneField.setEditable(true); // Let them enter their phone num
                phoneField.setText("");
      
                // Set the padding to 30 around the grid pane
               gridPane.setPadding(new Insets(30, 30, 30, 30));
               gridPane.setHgap(10);   // Horizontal gap of 10                         
               gridPane.setVgap(10);   // Vertical gap of 1-
      
               /**
                Add the created labels and text fields to specific columns and
                rows of the grid pane.
               */
               gridPane.add(firstName, 0,0);
               gridPane.add(fNameField, 0,1);
               gridPane.add(lastName, 1, 0);
               gridPane.add(lNameField,1,1);
               gridPane.add(prefTitle,0,2);
               gridPane.add(prefTitleField,0,3);
               gridPane.add(email, 0,4);
               gridPane.add(emailField, 0,5);
               gridPane.add(address,0,6);
               gridPane.add(addressField,0,7);
               gridPane.add(country,0,8);
               gridPane.add(countryField,0,9);  
               gridPane.add(city,0,10);
               gridPane.add(cityField,0,11);
               gridPane.add(state,0,12);
               gridPane.add(stateField,0,13);
               gridPane.add(postalCode,0,14);
               gridPane.add(postalField,0,15);
               gridPane.add(phoneNum,0,16);
               gridPane.add(phoneField,0,17);
               gridPane.add(nextPageBtn,0,18);
      
                 // Set the title and the scene of the stage and then show it
                 primaryStage.setTitle("Guest Information");
                 primaryStage.setScene(scene2);
                 primaryStage.show();

           // Event handler for the next page button
           nextPageBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            /**
            Method is automatically called when the next page button is pressed.
            */
            @Override
            public void handle(ActionEvent event) {
                
              /**
                 If the first name or the last name contain an integer display
                 an error alert box.
              */
              if (ContainsInteger(fNameField.getText()) || 
                      ContainsInteger(lNameField.getText()))
              {
                Alert alert = new Alert(AlertType.ERROR,"First or last name "
                        + "cannot contain an integer");
                         alert.showAndWait();
              }
              
              /**
               If the postal code is not exactly 5 digits or contains a 
                character display an error alert box.
              */
              else if(postalField.getText().length() != 5 || !ContainsInteger
                      (postalField.getText())) {
                   Alert alert = new Alert(AlertType.ERROR,"Postal Code must "
                           + "only be 5 digits and contain no Characters");
                  alert.showAndWait();
              }
              
              /**
                If the phone number is not exactly 10 digits long or contains
                a character display an error alert box.
              */
              else if (phoneField.getText().length() != 10 || !ContainsInteger
                      (phoneField.getText())) {
                  Alert alert = new Alert(AlertType.ERROR,"Phone number must be"
                          + " 10 digits and have no Characters");
                  alert.showAndWait();
              }
              
              /**
                 If the preferred title contains an integer display an error 
                 alert box.
              */
              else if (ContainsInteger(prefTitleField.getText()))
              {
               Alert alert = new Alert(AlertType.ERROR,"Prefrred title cannot "
                       + "contain an integer");
                         alert.showAndWait();     
            	 }
              
              /**
                 If the country field contains an integer display an error alert
                 box.
              */
               else if (ContainsInteger(countryField.getText()))
              {
               Alert alert = new Alert(AlertType.ERROR,"Country cannot contain "
                       + "an integer");
                         alert.showAndWait();     
            	 }
               
              /**
               If the city contains an integer display an error alert box.
              */
              else if (ContainsInteger(cityField.getText()))
              {
               Alert alert = new Alert(AlertType.ERROR,"City cannot contain an"
                       + " integer");
                         alert.showAndWait();  
            	 }
             
             /**
               If the state contains an integer display an error alert box.
              */
             else if (ContainsInteger(stateField.getText()))
              {
               Alert alert = new Alert(AlertType.ERROR,"State cannot contain an "
                       + "integer");
                         alert.showAndWait();     
            	 }

    
                  GridPane gridPane = null;  // Positios components within scene
      
                  gridPane = new GridPane();  // Create an empty pane
                  Scene scene3 = new Scene(gridPane); // Set the scene with grid pane
                  
                  // Label for the check in date
                  inDate = new Label ("Check-In Date");
                  
                  // Label for the check out date
                  outDate = new Label ("Check-Out Date");
                  
                  // Label for the room type
                  roomType = new Label ("Room Type");
                  
                  // Label for the number of guests
                  numGuests = new Label ("Number of Guests");
                  
                  // Text field for the number of guests
                  guestsField = new TextField(); 
                  guestsField.setPrefColumnCount(15);
                  guestsField.setEditable(true); // Let user enter number of guests
                  guestsField.setText("");

                  // Create a new combo box for selecting a room
                  choiceBox = new ComboBox<>();
                  
                  // Add the types of rooms to the combo box
                  choiceBox.getItems().addAll("Guest Room, 2 Queen ($250)", 
                          "Guest Room, 1 Queen ($200)",
                          "Guest Room, 1 King ($300)", "Executive Suite ($480)");
                 
                  
                  // Set padding around the grid pane
                  gridPane.setPadding(new Insets(30, 30, 30, 30)); 
                  gridPane.setHgap(10);   // Horizontal gap of 10                         
                  gridPane.setVgap(10);   // Vertical gap of 10
                  
                  /**
                   Add the labels and text fields to the columns and rows of 
                   the grid pane.
                  */
                  gridPane.add(inDate,0,0);
                  gridPane.add(dp,0,1);
                  gridPane.add(outDate,0,2);
                  gridPane.add(dp2,0,3);
                  gridPane.add(numGuests,0,4);
                  gridPane.add(guestsField,0,5);
                  gridPane.add(roomType,0,7);
                  gridPane.add(choiceBox,0,8);
                  gridPane.add(showRoomButton, 0, 9);
                  gridPane.add(paymentButton,0,10);
                  gridPane.add(previousPage1,0,11);
         
                 /**
                    Set title of the stage, set the scene of the stage and 
                    display it.
                  */
                 primaryStage.setTitle("Room Information");
                 primaryStage.setScene(scene3);
                 primaryStage.show();
                 
         /**
            Event handler that occurs when the previousPage button is pressed,
            taking you back to the second scene.
         */
         previousPage1.setOnAction( e -> window.setScene(scene2));
        
         // Event handler for when the show room button is pressed
         showRoomButton.setOnAction(new EventHandler<ActionEvent>() {
            
            /**
             Method is automatically called when the show room button is 
             pressed.
             */
            @Override
            public void handle(ActionEvent event) {
            	  
                // Call the show room method when the button is pressed
                ShowRoom();
                  
                  System.out.println(NumOfDays(dp.getValue(),dp2.getValue()));

            }
            
        });
            
          paymentButton.setOnAction(new EventHandler<ActionEvent>()  {
            
            @Override
            public void handle(ActionEvent event) {
                
               if (dp.getValue() == null || dp2.getValue() == null)
               {
                 Alert alert = new Alert(AlertType.ERROR,"Please enter a check"
                          + "in / check out date");
                         alert.showAndWait();
              }
              
              else if ( nightsStayed == NumOfDays(dp.getValue(),dp2.getValue())) 
              {

              }
              
              else if (!ContainsInteger(guestsField.getText())) 
              {
                  Alert alert = new Alert(AlertType.ERROR,"Please enter a valid"
                          + " number of guests");
                  alert.showAndWait();
              }
              
              else if (choiceBox.getValue() == null) 
              {
                  Alert alert = new Alert(AlertType.ERROR,"You must choose a room"
                          + " type");
                          
                  alert.showAndWait();
              }
               
               try {
                      /**
                       NumOfDays method is called, the date picker for the 
                       check in date takes the first parameter and the date 
                       picker for the check out date takes the second parameter.
                      */
                      nightsStayed = NumOfDays(dp.getValue(),dp2.getValue());
                      
                    /**
                       CostOfRoom Method is called, nights stayed takes first
                        parameter while the room they select in the choice box 
                        takes the second parameter.
                      */
                      roomCost = CostOfRoom(nightsStayed, choiceBox.getValue());
               }
               catch (FileNotFoundException e) {
                   e.printStackTrace();
               }
                  
            	
            	GridPane gridPane = null;
            	
            	gridPane = new GridPane();
            	Scene scene4 = new Scene(gridPane);
            	
            	cardType = new Label("Card Type");
            	cardNum = new Label("Card Number");
            	expirationDate = new Label("Expiration Date");
            	nameOnCard = new Label("Enter the name on the credit card "
                        + "exactly how it appears");
            	ccvNumber = new Label("CCV #");
            	
            	cardNumField = new TextField();
            	cardNumField.setEditable(true);
            	cardNumField.setText("");
            	
            	expDateField = new TextField();
            	expDateField.setEditable(true);
            	expDateField.setText("");
            	
            	nameOnCardField = new TextField();
            	nameOnCardField.setEditable(true);
            	nameOnCardField.setText("");
            	
            	ccvNumberField = new TextField();
            	ccvNumberField.setEditable(true);
            	ccvNumberField.setText("");
            	
            	cardSelect = new ComboBox<>();
            	
            	cardSelect.getItems().addAll("Visa","Master Card","American "
                        + "Express");
                
                cardExpMonth = new ComboBox<>();
                
                cardExpMonth.getItems().addAll("01 - Janruary", "02 - February"
                , "03 - March", "04 - April", "05 - May", "06 - June", "07 - July"
                , "08 - August", "09 - September", "10 - October", "11 - November"
                , "12 - December");
                
                cardExpYear = new ComboBox<>();
                
                cardExpYear.getItems().addAll("2019", "2020", "2021", "2022",
                        "2023", "2024");
            	
               
                Label outputLabel2 = new Label("HI");
                outputLabel2.setText("Total Cost: " );
                
                Label outputLabel1 = new Label("Hello");
                outputLabel1.setText(String.format("$%.2f" , roomCost));
            	
            	gridPane.setPadding(new Insets(30, 30, 30, 30)); 
                gridPane.setHgap(10);                            
                gridPane.setVgap(10);
            	
                gridPane.add(outputLabel2,0,0);
                gridPane.add(outputLabel1,0,1);
                gridPane.add(nameOnCard, 0, 2);
                gridPane.add(nameOnCardField, 0, 3);
            	gridPane.add(cardType,0,4);
            	gridPane.add(cardSelect, 0,5);
            	gridPane.add(cardNum, 0, 6);
            	gridPane.add(cardNumField, 0, 7);
            	gridPane.add(expirationDate, 0, 8);
            	gridPane.add(cardExpMonth,0,9);
                gridPane.add(cardExpYear,0,10);
            	gridPane.add(ccvNumber,0,11);
            	gridPane.add(ccvNumberField, 0, 12);
            	gridPane.add(reviewButton, 0,13);
                gridPane.add(previousPage2,0,14);
            	
            	 primaryStage.setTitle("Payment Information");
                 primaryStage.setScene(scene4);
                 primaryStage.show();
                 
            /**
             Event handler that occurs when the previousPage button is pressed,
            taking you back to the third scene .
            */
           previousPage2.setOnAction( e -> window.setScene(scene3));
                 
           // Event handler for the review Button
           reviewButton.setOnAction(new EventHandler<ActionEvent>() {
            
          /** 
           Method is automatically called when the review button is pressed.
           */    
            @Override
            public void handle(ActionEvent event) {
               
             // If the name on the card contains an integer display an error alert
              if (ContainsInteger(nameOnCardField.getText()))
              {
                 Alert alert = new Alert(AlertType.ERROR,"Please enter a valid"
                          + " name. No integers allowed");
                         alert.showAndWait();
              }
              
             // If the user does not select the card type display an error alert
              else if (cardSelect.getValue() == null) 
              {
                   Alert alert = new Alert(AlertType.ERROR,"Please select a card"
                      + " type");
                         alert.showAndWait(); 
              }
              
              /**
                 If the card number length is not exactly 16 or the card number
                 contains a character display an error alert.
              */
              else if (cardNumField.getText().length() != 16 || !ContainsInteger
                      (cardNumField.getText())) 
              {
                  
                  Alert alert = new Alert(AlertType.ERROR,"Please enter a valid"
                          + " card number with 16 digits and no Characters");
                  alert.showAndWait();
              }
              
              /**
               If the user does not select the card expiration month or year
               display an error alert.
              */
              else if (cardExpMonth.getValue() == null || cardExpYear.getValue()
                      == null) 
              {
                  Alert alert = new Alert(AlertType.ERROR,"You must enter your "
                          + " card expiration date inside of the choice box");
                          
                  alert.showAndWait();
              }
              
              /** If the ccv number contains a character display an error alert.
               */
              else if (!ContainsInteger(ccvNumberField.getText())) {
                  Alert alert = new Alert(AlertType.ERROR,"Please enter a valid "
                          + " CCV Number without letters");
              }
                 
             try {
                 //Call the save file method to save the users reservation info
                SaveFile();
             }
             
             // If the compiler cannot save the file catch the exception 
             catch (IOException e) {
                 System.out.println("Could not save file");
             }
            
             try {
                 // Scanner to scan in the guestInfo file
                Scanner scnr = new Scanner(new File("guestInfo.txt"));
                
                // Loop through the file one time
                for (int i = 0; i < 1; i++) {
                    
                    // First line of the file is first name
                    String fName = scnr.nextLine(); 
                    
                    // Second line is the last name
                    String lName = scnr.nextLine();
                    
                    // Third line is the guest email
                    String guestEmail = scnr.nextLine(); 
                    
                    // Fourth line is the address 
                    String guestAddress = scnr.nextLine(); 
                    
                    // Fifth line is the city
                    String guestCity = scnr.nextLine();
                    
                    // Sixth line is the state
                    String guestState = scnr.nextLine();
                    
                    // Seventh line is the postal code
                    String postalCode = scnr.nextLine();
                    
                    // Eighth line is the phone number
                    String guestPhoneNum = scnr.nextLine(); 
                    
                    // Ninth line is the check in date
                    String checkIn = scnr.nextLine();
                    
                    // Tenth line is the check out date
                    String checkOut = scnr.nextLine();
                    
                    // Eleventh line is the number of guests
                    String guests = scnr.nextLine();
                    
                    // Twelfth line is the room type
                    String room = scnr.nextLine();
                    
                    // Thirteenth line is the cost of the room
                    String roomCost = scnr.nextLine();
                    
                    // Fourteenth line is the name on the card
                    String nameOnCCard = scnr.nextLine();
                    
                    // Fifteenth line is the card type
                    String CardType = scnr.nextLine();
                    
                    // Sixteenth line is the card number
                    String CCNumber = scnr.nextLine();
                    
                    // Seventeenth line is the card exp date
                    String cardExp = scnr.nextLine();
                    
                    // Last line is the ccv Num
                    String ccvNum = scnr.nextLine();
                    
                 /**
                    Create a person object that calls the person class and 
                    sets the values just read from the file (fName, lName, 
                    guestEmail, guestAddress, guestCity, guestState, postalCode,
                    and guestPhoneNum) to the variables defined in the person 
                    class.
                 */
                 Person person = new Person();
                 person.setFirstName(fName);
                 person.setLastName(lName);
                 person.setEmail(guestEmail);
                 person.setAddress(guestAddress);
                 person.setCity(guestCity);
                 person.setState(guestState);
                 person.setPostalCode(postalCode);
                 person.setPhoneNumber(guestPhoneNum);
                 
                 /**
                    Create a checkIn1 object that calls the CheckIn class and 
                    sets the values that were just read from the file (checkIn)
                    to the variables defined in the CheckIn class.
                 */
                 CheckIn checkIn1 = new CheckIn();
                 checkIn1.setCheckInDate(checkIn);
        
                 /**
                    Create a checkOut1 object that calls the CheckOut class and
                    sets the values read from the file (checkOut) to the 
                    variable defined in CheckOut class.
                 */
                 CheckOut checkOut1 = new CheckOut();
                 checkOut1.setCheckOutDate(checkOut);
        
                 /**
                    Create a roomAssignment object that calls the RoomAssignment
                    class and sets the values read from the file (room1, guests)
                    to the variables defined in the RoomAssignment class.
                 */
                 RoomAssignment roomAssignment = new RoomAssignment();
                 roomAssignment.setRoomType(room);
                 roomAssignment.setNumGuests(guests);
                
                 /**
                    Create a payment object that calls the Payment class and
                    sets the values read from the file (nameOnCCard, CCNumber,
                    ccvNum, cardExp, and roomCost) to the variables defined in
                    the Payment class.
                 */
                 Payment payment = new Payment();
                 payment.setNameOnCard(nameOnCCard);
                 payment.setCcNumber(CCNumber);
                 payment.setSecurityNum(ccvNum);
                 payment.setExpDate(cardExp);
                 payment.setCostOfRoom(roomCost);
         
                 // Create an outputLabel object
                 Label outputLabel = new Label ("Review your Reservation");
                 
                 /**
                    Set the outputLabel text that displays the information the
                    user entered and asks them if it is correct, If so, they 
                    will hit the confirm button or go back and fix the problems
                    they see by clicking the button of the page they wish to go
                    back to.
                 */ 
                 outputLabel.setText("Is this information correct?" + "\n" + "\n"
                 + "Guest Information:" + "\n" + "\n" + person.getFirstName() + 
                  " " + person.getLastName() + "\n" +  person.getEmail() + "\n"
                  + person.getAddress() + " " + person.getCity() + ", " + 
                  person.getState() + " " + person.getPostalCode() + "\n"
                 + person.getPhoneNumber() +"\n" + "\n" + "Room Information:" +
                  "\n" + "\n" + checkIn1.getCheckInDate() + "\n" +
                 checkOut1.getCheckOutDate() + "\n" + roomAssignment.getNumGuests()
                 + "\n" + roomAssignment.getRoomType() +  ", " + "\n" + "\n" + 
                 "Payment Information:" + "\n" + "\n" + payment.getCostOfRoom()
                 + "\n" + payment.getNameOnCard() + "\n" + 
                 payment.getCcNumber() + "\n" + payment.getSecurityNum() + "\n" 
                 + payment.getExpDate() + "\n" + "\n" + "If this information is "
                 + "not correct, please click the button of the page you would "
                 + "like to go back to" + "\n" + "\n");
                 
                 
                    /**
                     Create a VBox with spacing of 10 that includes the 
                        outputLabel, guestInfo button, roomInfo button, 
                        paymentInfo button, and the confirmButton.
                    */
                    VBox vbox = new VBox(10, outputLabel, guestInfo, roomInfo, 
                            paymentInfo, confirmButton);
                    
                    // Set the padding around the scene and VBox
                    vbox.setPadding(new Insets(10));
                    
                    // Set the allignment of the VBox to the center of the scene
                    vbox.setAlignment(Pos.CENTER);
               
                     // Create the scene
                      Scene scene5 = new Scene(vbox);
                        
                        // Set the scene of the stage to scene5
                        primaryStage.setScene(scene5);
                        
                        // Show the stage
                        primaryStage.show();
             }
                }
             
             /**
               If the compiler cannot read the file catch the exception and 
                display a message.
             */
              catch (IOException e) {
                  System.out.println("Could not read from file");
              }
           
           /**
             Event handler that takes user back to scene 2 (Guest Info) when 
             the guestInfo button is pressed.
             */
           guestInfo.setOnAction( e -> window.setScene(scene2));
           
           /**
             Event handler that takes user back to scene 3 (Room Info) when 
             the roomInfo button is pressed.
             */
           roomInfo.setOnAction( e -> window.setScene(scene3));
           
          /**
             Event handler that takes user back to scene 4 (Payment Info) when 
             the paymentInfo button is pressed.
             */
           paymentInfo.setOnAction( e -> window.setScene(scene4));
                        
           // Event handler for the confirmButton
          confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            
             /**
              Method is automatically called when the user presses the 
              confirmButton.
              */
             @Override
             public void handle(ActionEvent event) {
               try {
                   
                   //Call the SendConfirmation method 
                   SendConfirmation();
                   
                   // Create new label
                   Label outputLabel = new Label("Confirm your reservation");
                   
                   /**
                   Set the text of the label saying an email has been sent to
                   their email.
                   */  
                   outputLabel.setText("An email has been sent to you regarding "
                           + "your reservation.");
                   
                   // Create a new VBox with the outputLabel
                    VBox vbox = new VBox(10, outputLabel);
                    
                    // Set the padding of the VBox
                    vbox.setPadding(new Insets(10));
                    
                    // Position the VBox to the center
                    vbox.setAlignment(Pos.CENTER);
               
                     // Create a Scene and display it.
                      Scene scene = new Scene(vbox);
                      primaryStage.setScene(scene);
                      primaryStage.show();
                      
               }
               
               // If the email cannot send, catch the messaging exception
               catch (MessagingException e) {
                   
               }
               
            }
             
          }); 
       
            }
            
        });
           
            }
            
        });
                 
            }
    
        });
   
            }
        });
        

        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    
    

    /**
     Method that creates a new text file and save the users reservation info
      to that file which throws an IOException.
    */ 
    private void SaveFile () throws IOException {
        try {
            FileWriter filewriter; // FileWriter object
            filewriter = new FileWriter("guestInfo.txt");
            filewriter.write(fNameField.getText());
            filewriter.write("\n");
            filewriter.write(lNameField.getText());
            filewriter.write("\n");
            filewriter.write(emailField.getText());
            filewriter.write("\n");
            filewriter.write(addressField.getText() + "\n" + cityField.getText()
            + "\n" + stateField.getText() + "\n" + postalField.getText());
            filewriter.write("\n");
            filewriter.write(phoneField.getText());
            filewriter.write("\n");
            filewriter.write("Check-In Date: " + dp.getValue());
            filewriter.write("\n"); 
            filewriter.write("Check-Out Date: " + dp2.getValue());
            filewriter.write("\n");
            filewriter.write("Guests: " + guestsField.getText());
            filewriter.write("\n");
            filewriter.write("Room type: " + choiceBox.getValue());
            filewriter.write("\n");
            filewriter.write("Total Cost: $" + roomCost);
            filewriter.write("\n");
            filewriter.write("Name on Card: " + nameOnCardField.getText());
            filewriter.write("\n");
            filewriter.write("Card Type: " + cardSelect.getValue());
            filewriter.write("\n");
            filewriter.write("Card Number: " + cardNumField.getText());
            filewriter.write("\n");
            filewriter.write("Expiration: " + cardExpMonth.getValue() + "/" +
                    cardExpYear.getValue());
            filewriter.write("\n");
            filewriter.write("CCV Number: " + ccvNumberField.getText());
            
            //Close file once all information has been written to the file
            filewriter.close();
            
        }
        
        // If the compiler cannot save the file catch the IOException 
        catch (IOException e) {
            
        }
    }
    
    
   /**
    Method that sends a confirmation email to the user regarding their 
    reservation. 
    * Got help with this code from https://www.youtube.com/watch?v=UMfjndwGwnM
    */ 
   private void SendConfirmation () throws MessagingException {
      try {
          
      // Set the recipient's email to the users entered email
      String to = emailField.getText();

      // Set the senders email
      String from = "HotelJavaFresno@gmail.com";

      // Host number from which you are sending the email
      String host = "smtp.gmail.com";
      
      // Password for the email address you are sending the email from
      String pass = "hotelreservation11";
      
      // Create the subject of the email
      String subject = "Your " + dp.getValue() + " Confirmation" ;
      
      /**
       Call the ConfirmationNumber method to get a random number 
       between 300000 and 5000000 and assign it to confirmNum.
       */
      int confirmNum = ConfirmationNumber(300000,5000000);
      
      //Set the message text 
      String messageText = fNameField.getText() + " " + lNameField.getText() +
              "\n" + "See you on " + dp.getValue() + "!" + "\n" + "\n" + "Your "
              + "Upcoming Stay" + "\n" + "\n" + "Hotel Java Fresno" + "\n" +
              "1500 Programming Ave Fresno CA 93727, US" + "\n" + "T: +1 800 123"
              + " 4567" + "\n" + "\n" + "Confirmation #" + confirmNum + "\n" + 
              "\n" +  "Check-In Date: " + dp.getValue() + "\n" + nightsStayed + 
              " nights" + "\n" + "Check-Out Date: " + dp2.getValue() + "\n"
              + "\n" + "Your Room Information" + "\n" + "\n" + 
              choiceBox.getValue() + "\n" + "Guests: " + guestsField.getText() 
              + "\n" + "\n" + "Payment Information" + "\n" + "\n" + "Total for"
              + " Stay: " + roomCost + "\n" + "\n" + "Rate Rules and "
              + "Cancellation Policy" + "\n" + "* Please contact us should you"
              + " need to cancel your reservation" + "\n" + "\n" +
              "If you have any questions regarding this reservation, please"
              + " feel free to contact us. Telephone: English Support 1 800 123"
              + " 4567, Spanish Support 1 800 321 7654, Email: "
              + "HotelJavaFresno@gmail.com" + "\n" + "\n" + "Yours sincerely, "
              + "Hotel Java Fresno";
      
      boolean sessionDebug = false;

      // Get system properties
      Properties props = System.getProperties();

      // Setup mail server
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.required", "true");
      
      java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

      // Get the default Session object.
      Session session = Session.getDefaultInstance(props, null);

            session.setDebug(sessionDebug);
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=session.getTransport("smtp");
           transport.connect(host, from, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message sent successfully");
        } 
        catch(MessagingException ex)
        {
            System.out.println(ex);
        }
    }
    
     public static boolean ContainsInteger(String s) {
        
       boolean containsInteger = false;   
       char[] temp = s.toCharArray();
	       	
        for(int i = 0; i < s.length(); i++)
	 {
	     if(Character.isDigit(temp[i]))
	     {
	       	return true;
	     }
	  }
	      return false;
	   }
	
      public void ShowRoom()
      {
	  
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Button closeButton = new Button("Close Window");
        closeButton.setOnAction(e -> window.close());
        String pic = null;
        String roomType = null;
	   
          if(choiceBox.getValue() == "Guest Room, 1 King ($300)")
	   {
		   pic = "file:download.jpg";
		   roomType = "Guest Room, 1 King ($300)";
	   }
          
	   else if(choiceBox.getValue() == "Guest Room, 1 Queen ($200)")
	   {
		   pic = "file:download2.jpg";
		   roomType = "Guest Room, 1 Queen ($200)";
	   }
           
	   else if(choiceBox.getValue() == "Guest Room, 2 Queen ($250)")
	   {
		   pic = "file:download3.jpg";
		   roomType = "Guest Room, 2 Queen ($250)";
	   }
           
	   else if(choiceBox.getValue() == "Executive Suite ($480)")
	   {
		   pic = "file:download4.jpg";
		   roomType = "Executive Suite ($480)";
	   }

	   Image image = new Image(pic);
	   
           VBox vBox = new VBox();
     
           ImageView imageView = new ImageView(image);
     
           vBox.getChildren().addAll(imageView, closeButton);
           vBox.setAlignment(Pos.CENTER);
           Scene scene = new Scene(vBox,265,220 );
           window.setScene(scene);
           window.showAndWait();
    
      }
      
   
     public int NumOfDays(LocalDate d1, LocalDate d2)
      {
	   int day1;
	   int day2;
	   int numOfNights = 0;
	   day1 = d1.getDayOfYear();
	   day2 = d2.getDayOfYear();
	   numOfNights = day2 - day1;
           if (d1.getDayOfYear() < d2.getDayOfYear()) {
           
               return numOfNights;
           }
           
           else {
               Alert alert = new Alert(AlertType.ERROR,"Check-In Date cannot be"
                       + " after Check-Out Date");
               alert.showAndWait();
           }
           return 0;
       }
   
     /**
       Method that reads cost of each room from a file and calculates the cost
       depending on the toom they select. 
       Takes two parameters, num is for the number of days stayed and object 
       room is for the room they select.
     * @param num for the number of days the guest will be staying
     * @param room for the type of room the guest picks
     * @return the value in the cost field
     * @throws java.io.FileNotFoundException
     */
     public double CostOfRoom(int num, Object room) throws FileNotFoundException
     {
           
	   double cost = 0.0;
	   double queen1 = 0.0;
	   double  queen2 = 0.0;
	   double king1 = 0.0;
	   double executive = 0.0;
           
           
          
           
	   try {
	     Scanner scnr = new Scanner(new File("cost.txt"));
            
             while (scnr.hasNext())
	     {
                  queen1 = scnr.nextDouble();
		  queen2 = scnr.nextDouble();
		  king1 = scnr.nextDouble();
		  executive = scnr.nextDouble();
                  
             }  
      
              if(room == "Guest Room, 1 Queen ($200)" )
	      {
		 cost = num * queen1;
                 
                 
	      }
              
	       else if(room == "Guest Room, 2 Queen ($250)" )
	       {
		  cost = num * queen2;
                 
	       }
               
	       else if(room == "Guest Room, 1 King ($300)" )
	       {
		  cost = num * king1;
                 
	       } 
               
	       else if(room == "Executive Suite ($480)")
	       {
		  cost = num * executive;
               
	       }
	
               else
	       {
	          System.out.println("Could not calculate room cost");
	        }
      
	   }
           catch(IOException e){
		   
	   }
	   
           return cost;
           
   }
     
    /**
      Method that takes two parameters and generates a random number between 2 
      integers that will be used for the guests confirmation #.
     * @param min the lowest number 
     * @param max the highest number
     * @return the value in the confirmNumber field
     */
    public int ConfirmationNumber(int min, int max)  {
        
        // Assign the random number generated to the variable confirmNumber
        int confirmNumber = (int) (Math.random() * ((max - min) + 1)) + min;
        
        // Return the randomly generated number
        return confirmNumber; 
     }
   
   

        public static void main(String[] args) {
            launch(args);
  }
}      
