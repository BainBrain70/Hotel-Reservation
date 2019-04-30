/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author CodyWickman
 */
public class HotelReservation extends Application {
     private Label firstName;
    private Label lastName;
    private Label prefTitle;
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
    private Label nameOnCard;
    private Label ccvNumber;
    
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
    private TextField prefTitleField;
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
    private TextField nameOnCardField;
    private TextField ccvNumberField;
    
    
    private TextField inDateField;
    private TextField outDateField;
    LocalDate ld;
    DatePicker dp;
    DatePicker dp2;
    ComboBox choiceBox;
    ComboBox cardSelect;
    ComboBox cardExpMonth;
    ComboBox cardExpYear;
    ComboBox cb2;
    
    double roomCost;
    int nightsStayed;
    
    
    
    @Override
    public void start(Stage primaryStage) {
         Stage window = primaryStage;
      Scene scene1 = null;         // Scene contains all content
      GridPane gridPane = null;   // Positions components within scene
      
      gridPane = new GridPane();   // Create an empty pane
      scene1 = new Scene(gridPane);
      
      dp = new DatePicker();
      dp2 = new DatePicker();
        
      Button nextPageBtn = new Button("Next Page");
      Button paymentButton = new Button ("Payment");
      Button confirmationButton = new Button ("Review Reservation");
      Button showRoomButton = new Button("Show My Room");
      Button reviewButton = new Button("Review and Save my Reservation");
      Button confirmButton = new Button ("Confirm my Reservation");
      Button bookButton = new Button("Book A Room");
      Button previousPage1 = new Button("Previous Page");
      Button previousPage2 = new Button("Previous Page");
      Button previousPage3 = new Button("Previous Page");
      Button guestInfo = new Button("Guest Information");
      Button roomInfo = new Button("Room Information");
      Button paymentInfo = new Button("Payment Information");
      
      String pic = "file:hotelPic.jpg";
      
      Image image = new Image(pic);
      
      VBox vBox = new VBox();
      
      Label outputLabel = new Label("Welcome");
      
      outputLabel.setText("\n \n Welcome to Hotel Java Fresno!\n \n");
      
      ImageView imageView = new ImageView(image);
      
      vBox.getChildren().addAll(imageView,outputLabel, bookButton);
      
      vBox.setAlignment(Pos.CENTER);
      
      scene1 = new Scene(vBox, 600,600);

      
        bookButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                GridPane gridPane = null;   // Positions components within scene
      
                 gridPane = new GridPane();   // Create an empty pane
                 Scene scene2 = new Scene(gridPane);
                 
                 firstName = new Label("First Name*");
                 lastName = new Label("Last Name*");
                 prefTitle = new Label("Preferred Title");
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
      
                prefTitleField = new TextField(); 
                prefTitleField.setPrefColumnCount(15);
                prefTitleField.setEditable(true);
                prefTitleField.setText("");
      
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
      
               gridPane.setPadding(new Insets(30, 30, 30, 30));
               gridPane.setHgap(10);                           
               gridPane.setVgap(10); 
      
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
      
                 primaryStage.setTitle("Guest Information");
                 primaryStage.setScene(scene2);
                 primaryStage.show();

           
           nextPageBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
              if (ContainsInteger(fNameField.getText()) || 
                      ContainsInteger(lNameField.getText()))
              {
                Alert alert = new Alert(AlertType.ERROR,"First or last name "
                        + "cannot contain an integer");
                         alert.showAndWait();
              }
              
              else if(postalField.getText().length() != 5 || !ContainsInteger
                      (postalField.getText())) {
                   Alert alert = new Alert(AlertType.ERROR,"Postal Code must "
                           + "only be 5 digits and contain no Characters");
                  alert.showAndWait();
              }
              
              else if (phoneField.getText().length() != 10 || !ContainsInteger
                      (phoneField.getText())) {
                  Alert alert = new Alert(AlertType.ERROR,"Phone number must be"
                          + " 10 digits and have no Characters");
                  alert.showAndWait();
              }
              
              else if (ContainsInteger(prefTitleField.getText()))
              {
               Alert alert = new Alert(AlertType.ERROR,"Prefrred title cannot "
                       + "contain an integer");
                         alert.showAndWait();     
            	 }
               else if (ContainsInteger(countryField.getText()))
              {
               Alert alert = new Alert(AlertType.ERROR,"Country cannot contain "
                       + "an integer");
                         alert.showAndWait();     
            	 }
                else if (ContainsInteger(cityField.getText()))
              {
               Alert alert = new Alert(AlertType.ERROR,"City cannot contain an"
                       + " integer");
                         alert.showAndWait();  
            	 }
                 else if (ContainsInteger(stateField.getText()))
              {
               Alert alert = new Alert(AlertType.ERROR,"State cannot contain an "
                       + "integer");
                         alert.showAndWait();     
            	 }

               
       
                  GridPane gridPane = null;   // Positios components within scene
      
                  gridPane = new GridPane();   // Create an empty pane
                  Scene scene3 = new Scene(gridPane);
                  
                  inDate = new Label ("Check-In Date");
                  outDate = new Label ("Check-Out Date");
                  roomType = new Label ("Room Type");
                  numGuests = new Label ("Number of Guests");
                  
                 
    
                  guestsField = new TextField(); 
                  guestsField.setPrefColumnCount(15);
                  guestsField.setEditable(true);
                  guestsField.setText("");
                  
                  
                  roomsField = new TextField(); 
                  roomsField.setPrefColumnCount(15);
                  roomsField.setEditable(true);
                  roomsField.setText("");
                  
                  choiceBox = new ComboBox<>();
                  
                  choiceBox.getItems().addAll("Guest Room, 2 Queen ($250)", 
                          "Guest Room, 1 Queen ($200)",
                          "Guest Room, 1 King ($300)", "Executive Suite ($480)");
                 
                  
                  gridPane.setPadding(new Insets(30, 30, 30, 30)); 
                  gridPane.setHgap(10);                            
                  gridPane.setVgap(10);
                  
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
         
                 primaryStage.setTitle("Room Information");
                 primaryStage.setScene(scene3);
                 primaryStage.show();
                 
         previousPage1.setOnAction( e -> window.setScene(scene2));
        
         /////
         showRoomButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            	  ShowRoom();
                  
                  System.out.println(NumOfDays(dp.getValue(),dp2.getValue()));
                  
                  try {
                      /*CostOfRoom Method is called, nights stayed takes first
                        parameter while the room they select in the choice box 
                        takes the second parameter.
                      */
                      nightsStayed = NumOfDays(dp.getValue(),dp2.getValue());
                      roomCost = CostOfRoom(nightsStayed, choiceBox.getValue());
                  }
                  
                  catch (FileNotFoundException e1) {
                      e1.printStackTrace();
                  }
                  
                  System.out.println(roomCost);
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
                 
          previousPage2.setOnAction( e -> window.setScene(scene3));
                 

      
           reviewButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                             
              if (ContainsInteger(nameOnCardField.getText()))
              {
                 Alert alert = new Alert(AlertType.ERROR,"Please enter a valid"
                          + " name. No integers allowed");
                         alert.showAndWait();
              }
              
              else if (cardSelect.getValue() == null) 
              {
                   Alert alert = new Alert(AlertType.ERROR,"Please select a card"
                      + " type");
                         alert.showAndWait(); 
              }
              
              else if (cardNumField.getText().length() != 16 || !ContainsInteger
                      (cardNumField.getText())) 
              {
                  
                  Alert alert = new Alert(AlertType.ERROR,"Please enter a valid"
                          + " card number with 16 digits and no Characters");
                  alert.showAndWait();
              }
              
           
              else if (cardExpMonth.getValue() == null || cardExpYear.getValue()
                      == null) 
              {
                  Alert alert = new Alert(AlertType.ERROR,"You must enter your "
                          + " card expiration date inside of the choice box");
                          
                  alert.showAndWait();
              }
              
              else if (!ContainsInteger(ccvNumberField.getText())) {
                  Alert alert = new Alert(AlertType.ERROR,"Please enter a valid "
                          + " CCV Number without letters");
              }
                
                
             try {
                SaveFile();
             }
             
             catch (IOException e) {
                 System.out.println("Could not save file");
             }
            
             try {
                Scanner scnr = new Scanner(new File("guestInfo.txt"));
                
                for (int i = 0; i < 1; i++) {
                
                    String fName = scnr.nextLine(); 
                    String lName = scnr.nextLine();
                    String guestEmail = scnr.nextLine(); 
                    String guestAddress = scnr.nextLine(); 
                    String guestCity = scnr.nextLine();
                    String guestState = scnr.nextLine();
                    String postalCode = scnr.nextLine();
                    String guestPhoneNum = scnr.nextLine(); 
                    String checkIn = scnr.nextLine();
                    String checkOut = scnr.nextLine();
                    String guests = scnr.nextLine();
                    String room1 = scnr.nextLine();
                    String roomCost = scnr.nextLine();
                    String nameOnCCard = scnr.nextLine();
                    String CardType = scnr.nextLine();
                    String CCNumber = scnr.nextLine();
                    String cardExp = scnr.nextLine();
                    String ccvNum = scnr.nextLine();
                    
                 
                 Person person = new Person();
                 person.setFirstName(fName);
                 person.setLastName(lName);
                 person.setEmail(guestEmail);
                 person.setAddress(guestAddress);
                 person.setCity(guestCity);
                 person.setState(guestState);
                 person.setPostalCode(postalCode);
                 person.setPhoneNumber(guestPhoneNum);
                 
                 CheckIn checkIn1 = new CheckIn();
                 checkIn1.setCheckInTime(checkIn);
        
                 CheckOut checkOut1 = new CheckOut();
                 checkOut1.setCheckOutTime(checkOut);
        
                 RoomAssignment roomAssignment = new RoomAssignment();
                 roomAssignment.setType1(room1);
                 roomAssignment.setNumGuests(guests);
                
                 
                 Payment payment = new Payment();
                 payment.setNameOnCard(nameOnCCard);
                 payment.setCcNumber(CCNumber);
                 payment.setSecurityNum(ccvNum);
                 payment.setExpDate(cardExp);
                 payment.setCostOfRoom(roomCost);
         
                 
                 Label outputLabel = new Label ("Review your Reservation");
                 outputLabel.setText("Is this information correct?" + "\n" + "\n"
                 + "Guest Information:" + "\n" + "\n" + person.getFirstName() + 
                  " " + person.getLastName() + "\n" +  person.getEmail() + "\n"
                  + person.getAddress() + " " + person.getCity() + ", " + 
                  person.getState() + " " + person.getPostalCode() + "\n"
                 + person.getPhoneNumber() +"\n" + "\n" + "Room Information:" +
                  "\n" + "\n" + checkIn1.getCheckInTime() + "\n" +
                 checkOut1.getCheckOutTime() + "\n" + roomAssignment.getNumGuests()
                 + "\n" + roomAssignment.getType1() +  ", " + "\n" + "\n" + 
                 "Payment Information:" + "\n" + "\n" + payment.getCostOfRoom()
                 + "\n" + payment.getNameOnCard() + "\n" + 
                 payment.getCcNumber() + "\n" + payment.getSecurityNum() + "\n" 
                 + payment.getExpDate() + "\n" + "\n" + "If this information is "
                 + "not correct, please click the button of the page you would "
                 + "like to go back to" + "\n" + "\n");
                 
                 
                 
                    VBox vbox = new VBox(10, outputLabel, guestInfo, roomInfo, 
                            paymentInfo, confirmButton);
                    vbox.setPadding(new Insets(10));
                    vbox.setAlignment(Pos.CENTER);
               
                     // Create a Scene and display it.
                      Scene scene5 = new Scene(vbox);
                        primaryStage.setScene(scene5);
                        primaryStage.show();
             }
                }
              catch (IOException e) {
                  System.out.println("Could not read from file");
              }
            
           guestInfo.setOnAction( e -> window.setScene(scene2));
           roomInfo.setOnAction( e -> window.setScene(scene3));
           paymentInfo.setOnAction( e -> window.setScene(scene4));
                        
 
          confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            
             @Override
             public void handle(ActionEvent event) {
               try {
                   SendConfirmation();
                   Label outputLabel = new Label("Confirm your reservation");
                   outputLabel.setText("An email has been sent to you regarding "
                           + "your reservation.");
                   
                    VBox vbox = new VBox(10, outputLabel);
                    vbox.setPadding(new Insets(10));
                    vbox.setAlignment(Pos.CENTER);
               
                     // Create a Scene and display it.
                      Scene scene = new Scene(vbox);
                      primaryStage.setScene(scene);
                      primaryStage.show();
                      
               }
               
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
     * @param args the command line arguments
     */
  
    private void SaveFile () throws IOException {
        try {
            FileWriter filewriter;
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
            
            filewriter.close();
            
        }
        catch (IOException e) {
            
        }
    }
    
    
    
   private void SendConfirmation () throws MessagingException {
      try {
          
      // Recipient's email ID needs to be mentioned.
      String to = emailField.getText();

      // Sender's email ID needs to be mentioned
      String from = "HotelJavaFresno@gmail.com";

      // Assuming you are sending email from localhost
      String host = "smtp.gmail.com";
      
      String pass = "hotelreservation11";
      
      String subject = "Your " + dp.getValue() + " Confirmation" ;
      
      int confirmNum = ConfirmationNumber(300000,5000000);
      
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
   
     /*Method that reads cost of each room from a file and calculates the cost
     * depending on the toom they select. Takes two parameters, num is for the
     * number of days stayed and object room is for the room they select.
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
     
    public int ConfirmationNumber(int min, int max)  {
        int confirmNumber = (int) (Math.random() * ((max - min) + 1)) + min;
        return confirmNumber;
}
   
   

        public static void main(String[] args) {
            launch(args);
  }
}      
