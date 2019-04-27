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
/**
 *
 * @author CodyWickman
 */
public class HotelReservation extends Application {
    /*Creates a label object for the guest's first name */
    private Label firstName;
	
    /*Creates a label object for the guest's last name */
    private Label lastName;
    
    /*Creates a label object for the guest's preferred title */
    private Label prefTitle;
    
    /*Creates a label object for the guest's email address*/
    private Label email;
    
    /*Creates a label object for the country the guest lives in */
    private Label country;
    
    /*Creates a label object for the state the guest lives in */
    private Label state;
    
    /*Creates a label object for the guest's address */
    private Label address;
    
    /*Creates a label object for the city that the guest lives in */    
    private Label city;
    
    /*Creates a label object for the guest's zip code */
    private Label postalCode;
    
    /*Creates a label object for the guest's phone number */
    private Label phoneNum;
    
    /*Creates a label object for the type of credit card */
    private Label cardType;
    
    /*Creates a label object for the guest's credit card number */
    private Label cardNum;
    
    /*Creates a label object for the guest's credit card expiration date */
    private Label expirationDate;
    
    /*Creates a label object for the guest's name on their credit card */
    private Label nameOnCard;
    
    /*Creates a label object for the guest's CCV number */
    private Label ccvNumber;
    
    /*Creates a label object for the first room type */
    private Label roomType;
    
    /*Creates a label object for the 2nd room type */
    private Label room2Type;
    
    /*Creates a label object for the number of rooms */
    private Label numRooms;
    
    /*Creates a label object for the number of guests */
    private Label numGuests;
    
    /*Creates a label object for the guest's check in date */
    private Label inDate;
    
    /*Creates a label object for the guest's check out date */
    private Label outDate;
    
    /*Creates a label object for the terms and conditions */
    private Label termsCond;
   
    /*Creates a text field object type of room */
    private TextField roomsField;
    
    /*Creates a text field object type of room */
    private TextField guestsField;
    
    /*Creates a text field object type of room */
    private TextField fNameField;
    
    /*Creates a text field object type of room */
    private TextField lNameField;
    
    /*Creates a text field object type of room */
    private TextField prefTitleField;
    
    /*Creates a text field object type of room */
    private TextField emailField;
    
    /*Creates a text field object type of room */
    private TextField countryField;
    
    /*Creates a text field object type of room */
    private TextField stateField;
    
    /*Creates a text field object type of room */
    private TextField addressField;
    
    /*Creates a text field object type of room */
    private TextField cityField;
    
    /*Creates a text field object type of room */
    private TextField postalField;
    
    /*Creates a text field object type of room */
    private TextField phoneField;
  
    /*Creates a text field object type of room */
    private TextField cardField;
    
    /*Creates a text field object type of room */
    private TextField cardNumField;
    
    /*Creates a text field object type of room */
    private TextField expDateField;
    
    /*Creates a text field object type of room */
    private TextField nameOnCardField;
    
    /*Creates a text field object type of room */
    private TextField ccvNumberField;
    
    /*Creates a text field object type of room */
    private TextField inDateField;
    
    /*Creates a text field object type of room */
    private TextField outDateField;
    
    /*Creates a text field object type of room */
    LocalDate ld;
    
    /*Creates a text field object type of room */
    DatePicker dp;
    
    /*Creates a text field object type of room */
    DatePicker dp2;
    
    ComboBox choiceBox;
    ComboBox cardSelect;
    ComboBox cardExpMonth;
    ComboBox cardExpYear;
    ComboBox cb2;
    
    int roomCost;
    int nightsStayed;
    
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
      Button validate = new Button("Validate info");
      Button bookButton = new Button("Book A Room");
      
      String pic = "file:hotelPic.jpg";
      
      Image image = new Image(pic);
      
      VBox vBox = new VBox();
      
      Label outputLabel = new Label("Welcome");
      
      outputLabel.setText("Welcome to Hotel Java Fresno!");
      
      ImageView imageView = new ImageView(image);
      
      vBox.getChildren().addAll(imageView,outputLabel, bookButton);
      
      vBox.setAlignment(Pos.CENTER);
      
      scene = new Scene(vBox, 600,600);
      
      
      
     
      
        
      
        bookButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                 Scene scene = null;         // Scene contains all content
                GridPane gridPane = null;   // Positions components within scene
      
                 gridPane = new GridPane();   // Create an empty pane
                 scene = new Scene(gridPane);
                 
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
             gridPane.add(validate, 0, 19);
      
                 primaryStage.setTitle("Guest Information");
                 primaryStage.setScene(scene);
                 primaryStage.show();
                 
                 
           validate.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            	              	 if (ContainsInteger(fNameField.getText()) || ContainsInteger(lNameField.getText()) ||
            		ContainsInteger(prefTitleField.getText()) || ContainsInteger(countryField.getText()) ||
            		ContainsInteger(cityField.getText()) || ContainsInteger(stateField.getText()))
            	 {
            		 Alert alert = new Alert(AlertType.ERROR,"First name cannot contain an integer");
                         alert.showAndWait();
            	 }
             }
           
            
        });
           
           nextPageBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                  

            	 
            	  Scene scene = null;         // Scene contains all content
                  GridPane gridPane = null;   // Positios components within scene
      
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
                          "Guest Room, 1 King", "Executive Suite");
                 
                  
                  
                  cb2 = new ComboBox<>();
                  
                  cb2.getItems().addAll("Guest Room, 2 Queen", "Guest Room, 1 Queen",
                          "Guest Room, 1 King", "Executive Suite");
                           
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
                
                cardExpMonth = new ComboBox<>();
                
                cardExpMonth.getItems().addAll("01 - Janruary", "02 - February"
                , "03 - March", "04 - April", "05 - May", "06 - June", "07 - July"
                , "08 - August", "09 - September", "10 - October", "11 - November"
                , "12 - December");
                
                cardExpYear = new ComboBox<>();
                
                cardExpYear.getItems().addAll("2019", "2020", "2021", "2022",
                        "2023", "2024");
            	
            	
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
            	gridPane.add(cardExpMonth,0,7);
                gridPane.add(cardExpYear,0,8);
            	gridPane.add(ccvNumber,0,9);
            	gridPane.add(ccvNumberField, 0, 10);
                gridPane.add(saveButton,0,11);
            	gridPane.add(reviewButton, 0,12);
            	
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
            	  ShowRoom();
                  nightsStayed = NumOfDays(dp.getValue(),dp2.getValue());
                  System.out.println(NumOfDays(dp.getValue(),dp2.getValue()));
                  
                  try {
                      roomCost = CostOfRoom(nightsStayed, choiceBox.getValue());
                  }
                  
                  catch (FileNotFoundException e1) {
                      e1.printStackTrace();
                  }
                  
                  System.out.println(roomCost);
             }
           
            
        });
        
           confirmationButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event)  {
                  

            }
            
        });

        
        
        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(scene);
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
	   
          if(choiceBox.getValue() == "Guest Room, 1 King")
	   {
		   pic = "file:download.jpg";
		   roomType = "Guest Room, 1 King";
	   }
	   else if(choiceBox.getValue() == "Guest Room, 1 Queen")
	   {
		   pic = "file:download2.jpg";
		   roomType = "Guest Room, 1 Queen";
	   }
	   else if(choiceBox.getValue() == "Guest Room, 2 Queen")
	   {
		   pic = "file:download3.jpg";
		   roomType = "Guest Room, 2 Queen";
	   }
	   else if(choiceBox.getValue() == "Executive Suite")
	   {
		   pic = "file:download4.jpg";
		   roomType = "Executive Suite";
	   }
	   else
	   {
		   
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
	   return numOfNights;
   }
   
   public int CostOfRoom(int num, Object room) throws FileNotFoundException
   {
	   int cost = 0;
	   int queen1 = 0;
	   int  queen2 = 0;
	   int king1 = 0;
	   int executive = 0;
	   try {
		   Scanner scnr = new Scanner(new File("cost.txt"));
		   while(scnr.hasNextInt())
		   {
			   queen1 = scnr.nextInt();
			   queen2 = scnr.nextInt();
			   king1 = scnr.nextInt(); 
			   executive = scnr.nextInt();
		   }
		   if(room == "Guest Room, 1 Queen" )
		   {
			   cost = num * queen1;
		   }
		   else if(room == "Guest Room, 2 Queen" )
		   {
			   cost = num * queen2;
		   }
		   else if(room == "Guest Room, 1 King" )
		   {
			   cost = num * king1;
		   }
		   else if(room == "Executive Suite")
		   {
			   cost = num * executive;
		   }
		   else
		   {
			   System.out.println("Could not calculate room cost");
		   }
		   
	   }catch(IOException e){
		   
	   }
	   return cost;
   }
   
   

        public static void main(String[] args) {
            launch(args);
  }
}      
