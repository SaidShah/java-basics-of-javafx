package p1;

import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);// tells the IDE to launch the start and not the main

	}

/*	pubilc void init(){// this loads all of the arrays that should load when the problem starts
		theBag1.load();
		theBag2.load();
		loadIdCounter();
	}*/

	@Override
	public void start(Stage primaryStage) throws Exception {// only the first
															// window is the
															// primary stage
		// System.out.println("Hello JafaFX");

		/*BackgroundImage myBI= new BackgroundImage(new Image("images/image1.png",32,32,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);*/
		Image image = new Image("file:image4.png");
		BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
		          BackgroundSize.DEFAULT);
		
		/*BackgroundImage bgi= new BackgroundImage(new Image("images/image1.png",32,32,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);*/
		/*ImageView imageView = new ImageView(image);
		imageView.minWidth(50);
		imageView.minHeight(50);
*/
		/*Image image = new Image("file:image1.png");
		Background imageView = new Background(image);*/
		
		/*Image image = new Image("file:image1.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(500);
		imageView.setFitHeight(500);*/
		
		/*Image image = new Image("image1.png");
		BackgroundImage imageView = new BackgroundImage(image, null, null, null, null);*/
		// first set of controls always import the javaFX imports
		Label nameLabel = new Label("Name");// , this is the name label next to
											// the textbox to ask for
											// information
		TextField nameField = new TextField();// this is a place for person to
												// enter information
		nameField.setPromptText("Name");// this text is in the textbox before
										// user input it inserted

		// Second set of controls
		Label phoneLabel = new Label("Phone Number");
		TextField phoneField = new TextField();
		phoneField.setPromptText("Phone Number");

		// Buttons
		Button exitButton = new Button("Exit");
		Button okButton = new Button("OK");// this is a button for people to
		// click


		okButton.setOnAction(e -> {// the e can be called anything and this is
									// where something gets activated
			// when the button gets clicked
			String name = nameField.getText();// this will capture whatever type
												// in the textfield
			// textfield must always be a string
			String phone = phoneField.getText();// this accepts the phone number
			Person person = new Person(name, phone);
			System.out.println(person);
			nameField.clear();
			phoneField.clear();// this clears the text field after its entered
		});

		exitButton.setOnAction(e -> {
			/*// this exits the program
			//theBag1.save();
			//theBag2.save();// everything should be saved before as soon as you exit
			File file = new File("data/perons.dat");
			if(file.exists()){
				personBag.load();
			}*/
			Platform.exit();
		});

		// first Container
		HBox pane1 = new HBox(30);// horizontal container, sets everything
									// horizontally
									// the 30 is the padding in between the
									// controls
		
		pane1.setAlignment(Pos.CENTER);// this positions the controls on the
										// center of the screen
		
		// add Controls to the Container
		pane1.getChildren().add(nameLabel);// this adds the name label to the
											// container
		pane1.getChildren().add(nameField);// this adds the textfield into the
											// container
		pane1.getChildren().add(okButton);// this adds the button to the
											// container
		
		HBox pane2 = new HBox(30);// this is the secone container for the phone number
								// each HBox is one lane and you need multiple lanes for multiple panes
		pane2.setAlignment(Pos.CENTER);// this centers all of the controls
		pane2.getChildren().addAll(phoneLabel, phoneField);// this adds all of the controls so you dont have to
															// add them seperately

		HBox pane3 = new HBox(30);// each HBox is one lane and you need multiple lanes for multiple panes
		pane3.setAlignment(Pos.CENTER);
		pane3.getChildren().addAll(okButton, exitButton);
		//pane3.setBackground(new Background(myBI));
		/*HBox pane4 = new HBox(30);
		pane3.getChildren().add(imageView);*/
		VBox root = new VBox(30);// vertical box, this places all of the panes vertically
		root.getChildren().addAll(pane1, pane2, pane3);// this places all of the conatiners in the scene
	/*	root.setBackground(imageView);*/
	//	root.getChildren().add(new Background(myBI));
		root.setAlignment(Pos.CENTER);
		root.setBackground(new Background(bgi));
		//root.setBackground(new Background(myBI));
		//root.setBackground(imageView);
		// first Scene
		/*String image2 = Demo.class.getResource("image1.png").toExternalForm();
		root.setStyle("-fx-background-image: url('" + image + "'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;");*/
		
		Scene scene = new Scene(root, 500, 500);// this creates the scene and
												// places the container in the
												// scene
												// it takes arguments of the
												// scene name and the size of
												// the screen

		// add Scene to the Stage
		primaryStage.setScene(scene);// this adds the scene to the stage
		primaryStage.setTitle("My Stage");// gives a title to the top of the
											// stage if you want
		primaryStage.show();// allows the user to display the stage, lets you
							// see the stage

	}

}
