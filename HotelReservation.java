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
    ComboBox cb2;
    
    //int i = 0;
    
    @Override
    public void start(Stage primaryStage) {
        
      Scene scene = null;         // Scene contains all content
      GridPane gridPane = null;   // Positions components within scene
      
      gridPane = new GridPane();   // Create an empty pane
      scene = new Scene(gridPane);
      
      dp = new DatePicker();
      dp2 = new DatePicker();
        
      Button nextPageBtn = new Button("Next Page");
      Button saveButton = new Button ("Save");
      Button paymentButton = new Button ("Payment");
      Button confirmationButton = new Button ("Review Reservation");
      Button showRoomButton = new Button("Show My Room");
      Button reviewButton = new Button("Review my Reservation");
      Button confirmButton = new Button ("Confirm my Reservation");
      
      
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
      
      gridPane.setPadding(new Insets(30, 30, 30, 30)); // Padding around  grid
      gridPane.setHgap(10);                            // Spacing between columns
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
                  
                  choiceBox = new ComboBox<>();
                  
                  choiceBox.getItems().addAll("Guest Room, 2 Queen", "Guest Room, 1 Queen",
                          "Guest Room, 1 King", "Executive Suite, 1 King, 1 Sofa");
                 
                  
                  
                  cb2 = new ComboBox<>();
                  
                  cb2.getItems().addAll("Guest Room, 2 Queen", "Guest Room, 1 Queen",
                          "Guest Room, 1 King", "Executive Suite, 1 King, 1 Sofa");
                           
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
                  gridPane.add(showRoomButton, 0, 13);
                  
                  
                 
                  
                 
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
            	nameOnCard = new Label("Enter the name on the credit card exactly how it appears");
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
            	
            	cardSelect.getItems().addAll("Visa","Master Card","American Express");

            	
            	gridPane.setPadding(new Insets(30, 30, 30, 30)); // Padding around  grid
                gridPane.setHgap(10);                            // Spacing between columns
                gridPane.setVgap(10);
            	
                gridPane.add(nameOnCard, 0, 0);
                gridPane.add(nameOnCardField, 0, 1);
            	gridPane.add(cardType,0,2);
            	gridPane.add(cardSelect, 0,3);
            	gridPane.add(cardNum, 0, 4);
            	gridPane.add(cardNumField, 0, 5);
            	gridPane.add(expirationDate, 0, 6);
            	gridPane.add(expDateField,0,7);
            	gridPane.add(ccvNumber,0,8);
            	gridPane.add(ccvNumberField, 0, 9);
                gridPane.add(saveButton,0,10);
            	gridPane.add(reviewButton, 0,11);
            	
            	 primaryStage.setTitle("Payment Information");
                 primaryStage.setScene(scene);
                 primaryStage.show();
                 
                 
                 
          saveButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             try {
                SaveFile();
             }
             catch (IOException e) {
                 System.out.println("Could not save file");
             }
             
       
            }
        });
          
           reviewButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
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
                    String guestNum = scnr.nextLine(); 
                    String rooms = scnr.nextLine();
                    String room1 = scnr.nextLine();
                    String room2 = scnr.nextLine();
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
                 roomAssignment.setType2(room2);
                 
                 Payment payment = new Payment();
                 payment.setNameOnCard(nameOnCCard);
                 payment.setCcNumber(CCNumber);
                 payment.setSecurityNum(ccvNum);
                 payment.setExpDate(cardExp);
                 
                 Label outputLabel = new Label ("Review your Reservation");
                 outputLabel.setText("Is this information correct?" + "\n" + "\n"
                 + person.getFirstName() + " " + person.getLastName() + "\n" +
                 person.getEmail() + "\n" + person.getAddress() + " " + person.getCity() 
                 + ", " + person.getState() + " " + person.getPostalCode() + "\n"
                 + person.getPhoneNumber() + "\n" + checkIn1.getCheckInTime()
                 + "\n" + checkOut1.getCheckOutTime() + "\n" 
                 + roomAssignment.getType1() + ", " + roomAssignment.getType2()
                 + "\n" + payment.getNameOnCard() + "\n" + payment.getCcNumber() + "\n" +
                 payment.getSecurityNum() + "\n" + payment.getExpDate());
                 
                 
                 
                    VBox vbox = new VBox(10, outputLabel, confirmButton);
                    vbox.setPadding(new Insets(10));
                    vbox.setAlignment(Pos.CENTER);
               
                     // Create a Scene and display it.
                      Scene scene = new Scene(vbox);
                        primaryStage.setScene(scene);
                        primaryStage.show();
             }
                }
              catch (IOException e) {
                  System.out.println("Could not read from file");
              }
           
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
        
        
        showRoomButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             
            	Image image = new Image("file:download.jpg");
        		
                        Button nextPage = new Button("Next Page");
                        
        		HBox hBox = new HBox();
                        
                        ImageView imageView = new ImageView(image);
                        
                        hBox.getChildren().addAll(nextPage,imageView );
        	
        		Scene scene = new Scene(hBox);
                        
        		primaryStage.setTitle("King Room");
        		primaryStage.setScene(scene);
                        primaryStage.show();
                        
                        
            }
        });
        
           confirmationButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event)  {
                  

            }
            
        });

        
        
        primaryStage.setTitle("Guest Information");
        primaryStage.setScene(scene);
        primaryStage.show();
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
            filewriter.write("Rooms: " + roomsField.getText());
            filewriter.write("\n");
            filewriter.write("Room 1 type: " + choiceBox.getValue());
            filewriter.write("\n");
            filewriter.write("Room 2 Type: " + cb2.getValue());
            filewriter.write("\n");
            filewriter.write("Name on Card: " + nameOnCardField.getText());
            filewriter.write("\n");
            filewriter.write("Card Type: " + cardSelect.getValue());
            filewriter.write("\n");
            filewriter.write("Card Number: " + cardNumField.getText());
            filewriter.write("\n");
            filewriter.write("Expiration: " + expDateField.getText());
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
      
      String subject = "Java Email Demo";
      
      String messageText = "Dear " + prefTitleField.getText() + " "
              + " " + lNameField.getText() + ", " + "\n" + "\n" + "We have recieved your"
              + " reservation." + "\n" + "\n" + "Please refer to the information below "
              + "regarding your reservation details." + "\n" + "\n" + "Arrival: "
              + dp.getValue() + "\n" + "Number of Guests: " + guestsField.getText()
              + "\n" + "Number of Rooms: " + roomsField.getText() + "\n" + "Room Types: "
              + choiceBox.getValue() + ", " + cb2.getValue() + "\n" + "Departure: "
              + dp2.getValue() + "\n" + "\n" + "If you have any questions regarding"
              + " this reservation, please feel free to contact us. Telephone: English"
              + " Support 1 800 123 4567, Spanish Support 1 800 321 7654, Email:"
              + " HotelJavaFresno@gmail.com" + "\n" + "\n" + "Yours sincerely, "
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
}
    

