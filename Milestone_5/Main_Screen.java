import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main_Screen extends Application {
	public String[] header = {"Product Name","Price $","Stock","Location","Quantity"};
	public String[] headerAdmin = {"Product Name","Price $","Stock","Location","Type"};
	Stage window; // sets a stage
    Scene Home, sceneDrink, sceneCandy, sceneChips, sceneGum, sceneCart, sceneAdmin;// sets different scenes
    Dispenser dispDrink = new Dispenser("all");
    public Drink[] drinkItems = (Drink[]) getCount(dispDrink.prodObjects,"Drink");
    public Candy[] candyItems = (Candy[]) getCount(dispDrink.prodObjects,"Candy");
    public Chips[] chipItems = (Chips[]) getCount(dispDrink.prodObjects,"Chips");
    public Gum[] gumItems = (Gum[]) getCount(dispDrink.prodObjects,"Gum");
    public Drink[] drinkCart = new Drink[drinkItems.length];
    public Candy[] candyCart = new Candy[drinkItems.length];
    public Chips[] chipCart = new Chips[drinkItems.length];
    public Gum[] gumCart = new Gum[drinkItems.length];
    public ArrayList<Button> btnHold = new ArrayList<Button>();
    public int crtSize = 0;
    public ArrayList<Object> shoppingCart = new ArrayList<Object>();

    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage; // we call window the main stage
        
        BorderPane home = new BorderPane(); // sets "home" as a borderPane
        home.setLeft(navigationBar()); // adds the navigation bar on the left
        home.setTop(Title()); // adds the title bar on the top
        Image image = new Image(Main_Screen.class.getResource("/Design/Welcome.png").toExternalForm());
        ImageView IV = new ImageView(image); // set up image
        IV.setFitWidth(800);;
        home.setCenter(IV);
        
        
        BorderPane drinkPage = new BorderPane(); // sets "drinkPage" as a borderPane
        drinkPage.setLeft(navigationBar()); // adds the navigation bar on the left
        drinkPage.setTop(Title()); // adds the title bar on the top
        GridPane gridPaneDrink = gridPaneMeth(drinkItems); //Create GridPane
        drinkPage.setCenter(gridPaneDrink); //Add GridPane
        
        BorderPane candyPage = new BorderPane(); // sets "candyPage" as a borderPane
        candyPage.setLeft(navigationBar()); // adds the navigation bar on the left
        candyPage.setTop(Title()); // adds the title bar on the top
        GridPane gridPaneCandy = gridPaneMeth(candyItems); //Create GridPane
        candyPage.setCenter(gridPaneCandy); //Add GridPane
        
        BorderPane chipsPage = new BorderPane(); // sets "chipsPage" as a borderPane
        chipsPage.setLeft(navigationBar()); // adds the navigation bar on the left
        chipsPage.setTop(Title()); // adds the title bar on the top
        GridPane gridPaneChip = gridPaneMeth(chipItems); //Create GridPane
        chipsPage.setCenter(gridPaneChip); //Add GridPane
        
        BorderPane gumPage = new BorderPane(); // sets "gumPage" as a borderPane
        gumPage.setLeft(navigationBar()); // adds the navigation bar on the left
        gumPage.setTop(Title()); // adds the title bar on the top
        GridPane gridPaneGum = gridPaneMeth(gumItems); //Create GridPane
        gumPage.setCenter(gridPaneGum); //Add GridPane
        
        BorderPane cartPage = new BorderPane(); // sets "cartPage" as a borderPane
		cartPage.setLeft(navigationBar()); // adds the navigation bar on the left
        cartPage.setTop(Title()); // adds the title bar on the top
        GridPane gridPaneCart = gridPaneMeth(shoppingCart); //Create GridPane
        cartPage.setCenter(gridPaneCart); //Add GridPane
        
        BorderPane adminPage = new BorderPane(); // sets "AdminPage" as a borderPane
		adminPage.setLeft(navigationBar()); // adds the navigation bar on the left
        adminPage.setTop(Title()); // adds the title bar on the top
        GridPane gridPaneAdmin = gridPaneAdmin(dispDrink.prodObjects); //Create GridPane
        adminPage.setCenter(gridPaneAdmin); //Add GridPane
        
        Home = new Scene(home, 1050, 850); // sets the Home scene to the home borderpane
        sceneDrink = new Scene(drinkPage, 1050, 850); // sets the Drink scene to the drink borderpane
        sceneCandy = new Scene(candyPage, 1050, 850); // sets the Candy scene to the candy borderpane
        sceneChips = new Scene(chipsPage, 1050, 850); // sets the Chips scene to the chips borderpane
        sceneGum = new Scene(gumPage, 1050, 850); // sets the Gum scene to the gum borderpane
        sceneCart = new Scene(cartPage, 1050, 850); // sets the cart scene to the cart borderpane
        sceneAdmin = new Scene(adminPage, 1050, 850); // sets the cart scene to the cart borderpane
        
        window.setResizable(false); // the user cannot resize the frame
        window.setScene(Home); // sets the first scene to Home
        window.show(); // show the window
    }
    //    THE BAR ON THE LEFT - SET FOR NAVIGATION SELECTION    \\

    private VBox navigationBar() {
        VBox vbox = new VBox(25); // new Vbox with 25px gaps
        vbox.setPrefSize(90, 200);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(Icon1());
        vbox.getChildren().add(Icon2());
        vbox.getChildren().add(Icon3());
        vbox.getChildren().add(Icon4());
        vbox.getChildren().add(Icon5());
        vbox.getChildren().add(Icon6());
        vbox.setStyle("-fx-background-color:#797979");
        vbox.setVisible(true);
        return vbox;
    }

    private HBox Icon1() { // icon 1 which is the house for the home screen
        Image image = new Image(Main_Screen.class.getResource("/Design/home1.png").toExternalForm());
        ImageView IV = new ImageView(image); // set up image
        Button btn = new Button(); //set up button
        btn.setGraphic(IV); // set button as image
        btn.setPrefSize(45, 50); // set up size
        btn.setStyle("-fx-background-color:#797979"); // set background color
        Pane paneIndent = new Pane(); // the indent on the left of the button
        paneIndent.setPrefSize(5, 45); // set size
        paneIndent.setStyle("-fx-background-color:#797979");// set background color
        btn.setOnAction(e ->{ window.setScene(Home);
        btnHold.get(0).setText(String.valueOf(crtSize));
        });// set to go to the home scene
        buttonDecor(btn, paneIndent); // use buttonDecor method
        HBox hbox = new HBox(paneIndent, btn); // set hbox containing the indent and button
        return hbox;
    }

    private HBox Icon2() { // icon 2 which is the drinks for the drink screen
        Image image = new Image(Main_Screen.class.getResource("/Design/Drinks.jpeg").toExternalForm());
        ImageView IV = new ImageView(image);
        Button btn = new Button();
        btn.setGraphic(IV);
        btn.setPrefSize(45, 50);
        btn.setStyle("-fx-background-color:#797979");
        Pane paneIndent = new Pane();
        paneIndent.setPrefSize(5, 45);
        paneIndent.setStyle("-fx-background-color:#797979");
        btn.setOnAction(e ->{ window.setScene(sceneDrink);
        btnHold.get(1).setText(String.valueOf(crtSize));
        });//window.setScene(sceneDrink));
        buttonDecor(btn, paneIndent);
        HBox hbox = new HBox(paneIndent, btn);
        return hbox;
    }
    
    private HBox Icon3() { // icon 3 which is the candy button for the candy screen
        Image image = new Image(Main_Screen.class.getResource("/Design/Candy.jpeg").toExternalForm());
        ImageView IV = new ImageView(image);
        Button btn = new Button();
        btn.setGraphic(IV);
        btn.setPrefSize(45, 50);
        btn.setStyle("-fx-background-color:#797979");
        Pane paneIndent = new Pane();
        paneIndent.setPrefSize(5, 45);
        paneIndent.setStyle("-fx-background-color:#797979");
        btn.setOnAction(e ->{ window.setScene(sceneCandy);
        btnHold.get(2).setText(String.valueOf(crtSize));
        });
        buttonDecor(btn, paneIndent);
        HBox hbox = new HBox(paneIndent, btn);
        return hbox;
    }
    
    private HBox Icon4() { // icon 4 which is the chips button for the chips screen
        Image image = new Image(Main_Screen.class.getResource("/Design/Chips.jpeg").toExternalForm());
        ImageView IV = new ImageView(image);
        Button btn = new Button();
        btn.setGraphic(IV);
        btn.setPrefSize(45, 50);
        btn.setStyle("-fx-background-color:#797979");
        Pane paneIndent = new Pane();
        paneIndent.setPrefSize(5, 45);
        paneIndent.setStyle("-fx-background-color:#797979");
        btn.setOnAction(e ->{ window.setScene(sceneChips);
        btnHold.get(3).setText(String.valueOf(crtSize));
        });
        buttonDecor(btn, paneIndent);
        HBox hbox = new HBox(paneIndent, btn);
        return hbox;
    }
    
    private HBox Icon5() { // icon 5 which is the gum button for the gum screen
        Image image = new Image(Main_Screen.class.getResource("/Design/Gum.jpeg").toExternalForm());
        ImageView IV = new ImageView(image);
        Button btn = new Button();
        btn.setGraphic(IV);
        btn.setPrefSize(45, 50);
        btn.setStyle("-fx-background-color:#797979");
        Pane paneIndent = new Pane();
        paneIndent.setPrefSize(5, 45);
        paneIndent.setStyle("-fx-background-color:#797979");
        btn.setOnAction(e -> window.setScene(sceneGum));
        btn.setOnAction(e ->{ window.setScene(sceneGum);
        btnHold.get(4).setText(String.valueOf(crtSize));
        });
        buttonDecor(btn, paneIndent);
        HBox hbox = new HBox(paneIndent, btn);
        return hbox;
    }
    
    private HBox Icon6() { // icon 6 which is the gum button for the Admin screen
        Image image = new Image(Main_Screen.class.getResource("/Design/Admin.png").toExternalForm());
        ImageView IV = new ImageView(image);
        Button btn = new Button();
        btn.setGraphic(IV);
        btn.setPrefSize(45, 50);
        btn.setStyle("-fx-background-color:#797979");
        Pane paneIndent = new Pane();
        paneIndent.setPrefSize(5, 45);
        paneIndent.setStyle("-fx-background-color:#797979");
        btn.setOnAction(e ->{ window.setScene(sceneAdmin);
        btnHold.get(6).setText(String.valueOf(crtSize));
        });
        buttonDecor(btn, paneIndent);
        HBox hbox = new HBox(paneIndent, btn);
        return hbox;
    }
    
    //COLOR CHANGER WHEN BUTTONS ARE HOVERED OVER\\
    private void buttonDecor(Button btn, Pane paneIndent) {
        btn.setOnMouseEntered(value -> { // when the mouse enters / hovers
            btn.setStyle("-fx-background-color:#000000");
            paneIndent.setStyle("-fx-background-color:#FFF500");
        });
        btn.setOnMouseExited(value -> { // when the mouse exits
            btn.setStyle("-fx-background-color:#797979");
            paneIndent.setStyle("-fx-background-color:#797979");
        });
    }

    //    THE BAR ON THE TOP - SET FOR TITLE & CART   \\
    private HBox Title() {
        HBox title = new HBox(20); // new hbox with gaps of 20
        title.setPrefSize(400, 100); // set size
        title.setAlignment(Pos.CENTER); // set items positions
        title.setStyle("-fx-background-color:#797979"); // set background color
        Text text = new Text("\t Virtual Vending Machine \t"); // the title
        text.setFont(Font.font("Sans-serif", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 55)); // title design = font, weight, and posture
        text.setFill(Color.rgb(255, 0, 0)); // set text color
        title.getChildren().add(text); // add the text
        title.getChildren().add(ShopIcon()); // add the cart icon
        title.setVisible(true);// users can see the title bar
        return title;
    }
    
    private HBox ShopIcon() { // sets up the button image for the shoping cart
    	BackgroundImage backgroundImage = new BackgroundImage( new Image(Main_Screen.class.getResource("/Design/cart.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        Button btn = new Button(String.valueOf(crtSize)); 
        btnHold.add(btn);
        btn.setStyle("-fx-font-size: 2em; -fx-text-fill: #FFF; -fx-alignment: top-center; -fx-font-weight: bold");
        btn.setBackground(background);
        btn.setAlignment(Pos.CENTER);
        btn.setPrefSize(60, 60);
        btn.setOnAction(e -> {
        	BorderPane cartPage = new BorderPane(); // sets "cartPage" as a borderPane
   			cartPage.setLeft(navigationBar()); // adds the navigation bar on the left
   	        cartPage.setTop(Title()); // adds the title bar on the top
        	GridPane gridPaneCart = gridPaneMeth(shoppingCart);
        	cartPage.setCenter(gridPaneCart);
        	sceneCart = new Scene(cartPage, 1050, 850); // sets the cart scene to the cart borderpane
            btnHold.get(5).setText(String.valueOf(crtSize));
        });
        HBox hbox = new HBox(btn);
        return hbox;
    } 
    
    //Animation method
    private StackPane animationMeth() {
    	Rectangle rect = new Rectangle(0,0,20,20);
	    rect.setFill(Color.ORANGE);
	    StackPane stkPane = new StackPane();
	    stkPane.getChildren().add(rect);
	    FadeTransition ft = new FadeTransition(Duration.millis(4000), rect);
	    ft.setFromValue(1.0);
	    ft.setToValue(0.0);
	    rect.setArcWidth(5);
	    rect.setArcHeight(5);
	    ft.play();// Start animation
	    PathTransition pt = new PathTransition(Duration.millis(2000), new Line(807,-85,807,-70), rect);
	    pt.setCycleCount(1);
	    pt.play();
	    return stkPane;
    }
    
    //Shopping Cart Number Change
    private void cartNumChange(int btnNum) {
    	crtSize = shoppingCart.size();
		btnHold.get(btnNum).setText(String.valueOf(crtSize));
    }
    
    //Method used for Drink GridPane
    private  GridPane gridPaneMeth(Drink[] objArr) {
    	java.util.Arrays.sort(objArr);
    	GridPane gridPaneobj = new GridPane();
    	//Create the header for the GridPane
    	for (int index=0; index<header.length;index++) {
    		Text prodText = new Text(header[index]);
        	prodText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 26));
        	gridPaneobj.add(prodText, index, 0);
        	GridPane.setHalignment(prodText, HPos.CENTER);
    	}
    	
    	int goCrtBtnCnt = 1; //counter needed for go to cart button
    	for (int index=0; index<objArr.length;index++) {
    		goCrtBtnCnt++;
    		Drink obj = objArr[index];
    		Drink cartObj = new Drink(obj); //create a new object with same variables as original 
    		cartObj.setQuantity(0); //change new object quantity to 0
    		drinkCart[index] = cartObj;
    		
    		//Create Objects and format the text
			Text prodText = new Text(obj.getName());
    		prodText.setFont(Font.font("Times New Roman", 22));
       		Text quantText = new Text(String.valueOf(obj.getQuantity()));
       		quantText.setFont(Font.font("Times New Roman", 22));
       		Text priceText = new Text(doubleFormat(obj.getPrice()));
       		priceText.setFont(Font.font("Times New Roman", 22));
       		Text locText = new Text(obj.getLocation());
       		locText.setFont(Font.font("Times New Roman", 22));
        	Spinner<Integer> quantSpinner = new Spinner<>(0, obj.getQuantity(), 0, 1);
        	Button cartButton = new Button("Add to Cart");
        	
        	//Add nodes to GridPane (node, col, row)
       		gridPaneobj.add(prodText, 0, index+1);
       		GridPane.setHalignment(prodText, HPos.CENTER);
       		gridPaneobj.add(priceText, 1, index+1);
       		GridPane.setHalignment(priceText, HPos.CENTER);
        	gridPaneobj.add(quantText, 2, index+1);
        	GridPane.setHalignment(quantText, HPos.CENTER);
       		gridPaneobj.add(locText, 3, index+1);
       		GridPane.setHalignment(locText, HPos.CENTER);
       		gridPaneobj.add(quantSpinner, 4, index+1);
       		gridPaneobj.add(cartButton, 5, index+1);
       		GridPane.setHalignment(cartButton, HPos.CENTER);
        		
       		quantSpinner.setOnMouseClicked(e -> { //Mouse click event for spinner
        		Node source = (Node)e.getSource() ;
        		Integer rowIndex = GridPane.getRowIndex(source);
        		int newSpinVal = new Inventory_Management(obj.getQuantity(), quantSpinner.getValue()).getNewStock();
        		//int newSpinVal = obj.getQuantity() - quantSpinner.getValue();
        		quantText.setText(String.valueOf(newSpinVal));
        		drinkCart[rowIndex-1].setQuantity(quantSpinner.getValue());
        		if (quantSpinner.getValue() == 0 && shoppingCart.contains(drinkCart[rowIndex-1])) {
        			shoppingCart.remove(drinkCart[rowIndex-1]);
        			cartNumChange(1);
        		}
        	});
       		
        	cartButton.setOnMouseClicked(e -> { //Mouse click event for add to cart button
        		Node source = (Node)e.getSource(); //Find node
        		
        		Integer rowIndex = GridPane.getRowIndex(source); //get row location of event
        		if (quantSpinner.getValue() >  0 && !shoppingCart.contains(drinkCart[rowIndex-1])) {
					shoppingCart.add(drinkCart[rowIndex-1]); //add object to shopping cart
					cartNumChange(1);
        		}
        		if (quantSpinner.getValue() >  0) {
        			StackPane stkPane = animationMeth();
           	        gridPaneobj.add(stkPane, 0, 0);
        		}
        	});
    		
    	}
    	//Create the button that will activate the shopping cart scene
    	Button goCartButton = new Button("Go to Cart");
    	gridPaneobj.add(goCartButton, 5, goCrtBtnCnt);
   		GridPane.setHalignment(goCartButton, HPos.CENTER); 
   		goCartButton.setOnAction(e -> { //Button action when clicked
   	        BorderPane cartPage = new BorderPane(); // sets "cartPage" as a borderPane
   			cartPage.setLeft(navigationBar()); // adds the navigation bar on the left
   	        cartPage.setTop(Title()); // adds the title bar on the top
   	        GridPane gridPaneCart = gridPaneMeth(shoppingCart);
	        cartPage.setCenter(gridPaneCart);
	        sceneCart = new Scene(cartPage, 1050, 850); // sets the cart scene to the cart borderpane
   			window.setScene(sceneCart);

   			});
   		
    	gridPaneobj.setHgap(50);
    	gridPaneobj.setVgap(10);
    	
    	return gridPaneobj;
    }
     
  //Method used for Candy GridPane
    private  GridPane gridPaneMeth(Candy[] objArr) {
    	java.util.Arrays.sort(objArr);
    	GridPane gridPaneobj = new GridPane();
    	//Create the header for the GridPane
    	for (int index=0; index<header.length;index++) {
    		Text prodText = new Text(header[index]);
        	prodText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 26));
        	gridPaneobj.add(prodText, index, 0);
        	GridPane.setHalignment(prodText, HPos.CENTER);
    	}
    	
    	int goCrtBtnCnt = 1; //counter needed for go to cart button
    	for (int index=0; index<objArr.length;index++) {
    		goCrtBtnCnt++;
    		Candy obj = objArr[index];
    		Candy cartObj = new Candy(obj); //create a new object with same variables as original 
    		cartObj.setQuantity(0); //change new object quantity to 0
    		candyCart[index] = cartObj;
    		
    		//Create Objects and format the text
			Text prodText = new Text(obj.getName());
    		prodText.setFont(Font.font("Times New Roman", 22));
       		Text quantText = new Text(String.valueOf(obj.getQuantity()));
       		quantText.setFont(Font.font("Times New Roman", 22));
       		Text priceText = new Text(doubleFormat(obj.getPrice()));
       		priceText.setFont(Font.font("Times New Roman", 22));
       		Text locText = new Text(obj.getLocation());
       		locText.setFont(Font.font("Times New Roman", 22));
        	Spinner<Integer> quantSpinner = new Spinner<>(0, obj.getQuantity(), 0, 1);
        	Button cartButton = new Button("Add to Cart");
        	
        	//Add nodes to GridPane (node, col, row)
       		gridPaneobj.add(prodText, 0, index+1);
       		GridPane.setHalignment(prodText, HPos.CENTER);
       		gridPaneobj.add(priceText, 1, index+1);
       		GridPane.setHalignment(priceText, HPos.CENTER);
        	gridPaneobj.add(quantText, 2, index+1);
        	GridPane.setHalignment(quantText, HPos.CENTER);
       		gridPaneobj.add(locText, 3, index+1);
       		GridPane.setHalignment(locText, HPos.CENTER);
       		gridPaneobj.add(quantSpinner, 4, index+1);
       		gridPaneobj.add(cartButton, 5, index+1);
       		GridPane.setHalignment(cartButton, HPos.CENTER);
        		
       		quantSpinner.setOnMouseClicked(e -> { //Mouse click event for spinner
        		Node source = (Node)e.getSource() ;
        		Integer rowIndex = GridPane.getRowIndex(source);
        		int newSpinVal = new Inventory_Management(obj.getQuantity(), quantSpinner.getValue()).getNewStock();
        		//int newSpinVal = obj.getQuantity() - quantSpinner.getValue();
        		quantText.setText(String.valueOf(newSpinVal));
        		candyCart[rowIndex-1].setQuantity(quantSpinner.getValue());
        		if (quantSpinner.getValue() == 0 && shoppingCart.contains(candyCart[rowIndex-1])) {
        			shoppingCart.remove(candyCart[rowIndex-1]);
        			cartNumChange(2);
        		}
        	});
       		
        	cartButton.setOnMouseClicked(e -> { //Mouse click event for add to cart button
        		Node source = (Node)e.getSource(); //Find node
        		Integer rowIndex = GridPane.getRowIndex(source); //get row location of event
        		if (quantSpinner.getValue() >  0 && !shoppingCart.contains(candyCart[rowIndex-1])) {
        			shoppingCart.add(candyCart[rowIndex-1]); //add object to shopping cart
        			cartNumChange(2);
        		}
        		if (quantSpinner.getValue() >  0) {
        			StackPane stkPane = animationMeth();
           	        gridPaneobj.add(stkPane, 0, 0);
        		}
        	});
    		
    	}
    	//Create the button that will activate the shopping cart scene
    	Button goCartButton = new Button("Go to Cart");
    	gridPaneobj.add(goCartButton, 5, goCrtBtnCnt);
   		GridPane.setHalignment(goCartButton, HPos.CENTER); 
   		goCartButton.setOnAction(e -> { //Button action when clicked
   	        BorderPane cartPage = new BorderPane(); // sets "cartPage" as a borderPane
   			cartPage.setLeft(navigationBar()); // adds the navigation bar on the left
   	        cartPage.setTop(Title()); // adds the title bar on the top
   	        GridPane gridPaneCart = gridPaneMeth(shoppingCart);
	        cartPage.setCenter(gridPaneCart);
	        sceneCart = new Scene(cartPage, 1050, 850); // sets the cart scene to the cart borderpane
   			window.setScene(sceneCart);

   			});
   		
    	gridPaneobj.setHgap(50);
    	gridPaneobj.setVgap(10);
    	
    	return gridPaneobj;
    }    
    
    
    
  //Method used for Chip GridPane
    private  GridPane gridPaneMeth(Chips[] objArr) {
    	java.util.Arrays.sort(objArr);
    	GridPane gridPaneobj = new GridPane();
    	//Create the header for the GridPane
    	for (int index=0; index<header.length;index++) {
    		Text prodText = new Text(header[index]);
        	prodText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 26));
        	gridPaneobj.add(prodText, index, 0);
        	GridPane.setHalignment(prodText, HPos.CENTER);
    	}
    	
    	int goCrtBtnCnt = 1; //counter needed for go to cart button
    	for (int index=0; index<objArr.length;index++) {
    		goCrtBtnCnt++;
    		Chips obj = objArr[index];
    		Chips cartObj = new Chips(obj); //create a new object with same variables as original 
    		cartObj.setQuantity(0); //change new object quantity to 0
    		chipCart[index] = cartObj;
    		
    		//Create Objects and format the text
			Text prodText = new Text(obj.getName());
    		prodText.setFont(Font.font("Times New Roman", 22));
       		Text quantText = new Text(String.valueOf(obj.getQuantity()));
       		quantText.setFont(Font.font("Times New Roman", 22));
       		Text priceText = new Text(doubleFormat(obj.getPrice()));
       		priceText.setFont(Font.font("Times New Roman", 22));
       		Text locText = new Text(obj.getLocation());
       		locText.setFont(Font.font("Times New Roman", 22));
        	Spinner<Integer> quantSpinner = new Spinner<>(0, obj.getQuantity(), 0, 1);
        	Button cartButton = new Button("Add to Cart");
        	
        	//Add nodes to GridPane (node, col, row)
       		gridPaneobj.add(prodText, 0, index+1);
       		GridPane.setHalignment(prodText, HPos.CENTER);
       		gridPaneobj.add(priceText, 1, index+1);
       		GridPane.setHalignment(priceText, HPos.CENTER);
        	gridPaneobj.add(quantText, 2, index+1);
        	GridPane.setHalignment(quantText, HPos.CENTER);
       		gridPaneobj.add(locText, 3, index+1);
       		GridPane.setHalignment(locText, HPos.CENTER);
       		gridPaneobj.add(quantSpinner, 4, index+1);
       		gridPaneobj.add(cartButton, 5, index+1);
       		GridPane.setHalignment(cartButton, HPos.CENTER);
        		
       		quantSpinner.setOnMouseClicked(e -> { //Mouse click event for spinner
        		Node source = (Node)e.getSource() ;
        		Integer rowIndex = GridPane.getRowIndex(source);
        		int newSpinVal = new Inventory_Management(obj.getQuantity(), quantSpinner.getValue()).getNewStock();
        		//int newSpinVal = obj.getQuantity() - quantSpinner.getValue();
        		quantText.setText(String.valueOf(newSpinVal));
        		chipCart[rowIndex-1].setQuantity(quantSpinner.getValue());
        		if (quantSpinner.getValue() == 0 && shoppingCart.contains(chipCart[rowIndex-1])) {
        			shoppingCart.remove(chipCart[rowIndex-1]);
        			cartNumChange(3);
        		}
        	});
       		
        	cartButton.setOnMouseClicked(e -> { //Mouse click event for add to cart button
        		Node source = (Node)e.getSource(); //Find node
        		Integer rowIndex = GridPane.getRowIndex(source); //get row location of event
        		if (quantSpinner.getValue() > 0 && !shoppingCart.contains(chipCart[rowIndex-1])) {
        			shoppingCart.add(chipCart[rowIndex-1]); //add object to shopping cart
        			cartNumChange(3);
        		}
        		if (quantSpinner.getValue() >  0) {
        			StackPane stkPane = animationMeth();
           	        gridPaneobj.add(stkPane, 0, 0);
        		}
        	});
    		
    	}
    	//Create the button that will activate the shopping cart scene
    	Button goCartButton = new Button("Go to Cart");
    	gridPaneobj.add(goCartButton, 5, goCrtBtnCnt);
   		GridPane.setHalignment(goCartButton, HPos.CENTER); 
   		goCartButton.setOnAction(e -> { //Button action when clicked
   	        BorderPane cartPage = new BorderPane(); // sets "cartPage" as a borderPane
   			cartPage.setLeft(navigationBar()); // adds the navigation bar on the left
   	        cartPage.setTop(Title()); // adds the title bar on the top
   	        GridPane gridPaneCart = gridPaneMeth(shoppingCart);
	        cartPage.setCenter(gridPaneCart);
	        sceneCart = new Scene(cartPage, 1050, 850); // sets the cart scene to the cart borderpane
   			window.setScene(sceneCart);
   			});
   		
    	gridPaneobj.setHgap(50);
    	gridPaneobj.setVgap(10);
    	
    	return gridPaneobj;
    }    
    
  //Method used for Gum GridPane
    private  GridPane gridPaneMeth(Gum[] objArr) {
    	java.util.Arrays.sort(objArr);
    	GridPane gridPaneobj = new GridPane();
    	for (int index=0; index<header.length;index++) {
    		Text prodText = new Text(header[index]);
        	prodText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 26));
        	gridPaneobj.add(prodText, index, 0);
        	GridPane.setHalignment(prodText, HPos.CENTER);
    	}
    	
    	int goCrtBtnCnt = 1;
    	for (int index=0; index<objArr.length;index++) {
    		goCrtBtnCnt++;
    		Gum obj = objArr[index];
    		Gum cartObj = new Gum(obj);
    		cartObj.setQuantity(0);
    		gumCart[index] = cartObj;
			Text prodText = new Text(obj.getName());
    		prodText.setFont(Font.font("Times New Roman", 22));
       		Text quantText = new Text(String.valueOf(obj.getQuantity()));
       		quantText.setFont(Font.font("Times New Roman", 22));
       		Text priceText = new Text(doubleFormat(obj.getPrice()));
       		priceText.setFont(Font.font("Times New Roman", 22));
       		Text locText = new Text(obj.getLocation());
       		locText.setFont(Font.font("Times New Roman", 22));
        	Spinner<Integer> quantSpinner = new Spinner<>(0, obj.getQuantity(), 0, 1);
        	Button cartButton = new Button("Add to Cart");
       		gridPaneobj.add(prodText, 0, index+1);
       		GridPane.setHalignment(prodText, HPos.CENTER);
       		gridPaneobj.add(priceText, 1, index+1);
       		GridPane.setHalignment(priceText, HPos.CENTER);
        	gridPaneobj.add(quantText, 2, index+1);
        	GridPane.setHalignment(quantText, HPos.CENTER);
       		gridPaneobj.add(locText, 3, index+1);
       		GridPane.setHalignment(locText, HPos.CENTER);
       		gridPaneobj.add(quantSpinner, 4, index+1);
       		gridPaneobj.add(cartButton, 5, index+1);
       		GridPane.setHalignment(cartButton, HPos.CENTER);
        		
       		quantSpinner.setOnMouseClicked(e -> {
        		Node source = (Node)e.getSource() ;
        		//Integer colIndex = GridPane.getColumnIndex(source);
        		Integer rowIndex = GridPane.getRowIndex(source);
        		int newSpinVal = new Inventory_Management(obj.getQuantity(), quantSpinner.getValue()).getNewStock();
        		//int newSpinVal = obj.getQuantity() - quantSpinner.getValue();
        		quantText.setText(String.valueOf(newSpinVal));
        		//System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
        		gumCart[rowIndex-1].setQuantity(quantSpinner.getValue());
        		if (quantSpinner.getValue() == 0 && shoppingCart.contains(gumCart[rowIndex-1])) {
        			shoppingCart.remove(gumCart[rowIndex-1]);
        			cartNumChange(4);
        		}
        		
        	});
       		
        	cartButton.setOnMouseClicked(e -> {
        		Node source = (Node)e.getSource() ;
        		Integer rowIndex = GridPane.getRowIndex(source);
        		if (quantSpinner.getValue() > 0 && !shoppingCart.contains(gumCart[rowIndex-1])) {
        			shoppingCart.add(gumCart[rowIndex-1]);
        			cartNumChange(4);
        		}
        		if (quantSpinner.getValue() >  0) {
        			StackPane stkPane = animationMeth();
           	        gridPaneobj.add(stkPane, 0, 0);
        		}
        	});
    		
    	}
    	Button goCartButton = new Button("Go to Cart");
    	gridPaneobj.add(goCartButton, 5, goCrtBtnCnt);
   		GridPane.setHalignment(goCartButton, HPos.CENTER);
   		goCartButton.setOnAction(e -> {
   	        BorderPane cartPage = new BorderPane(); // sets "cartPage" as a borderPane
   			cartPage.setLeft(navigationBar()); // adds the navigation bar on the left
   	        cartPage.setTop(Title()); // adds the title bar on the top
   	        GridPane gridPaneCart = gridPaneMeth(shoppingCart);
	        cartPage.setCenter(gridPaneCart);
	        sceneCart = new Scene(cartPage, 1050, 850); // sets the cart scene to the cart borderpane
   			window.setScene(sceneCart);

   			});
   		
    	gridPaneobj.setHgap(50);
    	gridPaneobj.setVgap(10);
    	
    	return gridPaneobj;
    }
    
    
    //Used to create GridPane for the shopping cart
    private  GridPane gridPaneMeth(ArrayList<Object> cartItems) {
    	Object[] itemArr = cartItems.toArray();
    	String[] header = {"Product Name","Price $","Quantity","Total Cost $"};
    	GridPane gridPaneobj = new GridPane();
    	double priceTotal = 0.00;
    	for (int index=0; index<header.length;index++) {
    		Text prodText = new Text(header[index]);
        	prodText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 26));
        	gridPaneobj.add(prodText, index, 0);
        	GridPane.setHalignment(prodText, HPos.CENTER);
    	}
    	int goCrtBtnCnt = 1;
    	for (int index=0; index<itemArr.length;index++) {
    		goCrtBtnCnt++;
    		if (itemArr[index] instanceof Drink) {
    			Drink obj;
        		obj = ((Drink)itemArr[index]);
    			Text prodText = new Text(obj.getName());
        		prodText.setFont(Font.font("Times New Roman", 22));
           		Text quantText = new Text(String.valueOf(obj.getQuantity()));
           		quantText.setFont(Font.font("Times New Roman", 22));
           		Text priceText = new Text(doubleFormat(obj.getPrice()));
           		priceText.setFont(Font.font("Times New Roman", 22));
           		double subTotal = obj.getPrice()*obj.getQuantity();
           		priceTotal = priceTotal+subTotal;
           		Text subT = new Text(doubleFormat(subTotal));
           		subT.setFont(Font.font("Times New Roman", 22));
           		Button removeBtn = new Button("Remove");
           		gridPaneobj.add(prodText, 0, index+1);
           		GridPane.setHalignment(prodText, HPos.CENTER);
           		gridPaneobj.add(priceText, 1, index+1);
           		GridPane.setHalignment(priceText, HPos.CENTER);
           		gridPaneobj.add(quantText, 2, index+1);
            	GridPane.setHalignment(quantText, HPos.CENTER);
            	gridPaneobj.add(subT, 3, index+1);
           		GridPane.setHalignment(subT, HPos.CENTER);
           		gridPaneobj.add(removeBtn, 4, index+1);
           		GridPane.setHalignment(removeBtn, HPos.CENTER);
           		removeBtn.setOnAction(e -> {
           			Node source = (Node)e.getSource() ;
            		Integer rowIndex = GridPane.getRowIndex(source);
            		shoppingCart.remove(rowIndex-1);
           	        BorderPane cartPage = new BorderPane(); // sets "cartPage" as a borderPane
           			cartPage.setLeft(navigationBar()); // adds the navigation bar on the left
           	        cartPage.setTop(Title()); // adds the title bar on the top
           	        GridPane gridPaneCart = gridPaneMeth(shoppingCart);
        	        cartPage.setCenter(gridPaneCart);
        	        sceneCart = new Scene(cartPage, 1050, 850); // sets the cart scene to the cart borderpane
           			window.setScene(sceneCart);
           			crtSize = shoppingCart.size();
           	        btnHold.get(btnHold.size()-1).setText(String.valueOf(crtSize));
           			});
           		
    		}
    		
    		else if (itemArr[index] instanceof Candy) {
    			Candy obj;
        		obj = ((Candy)itemArr[index]);
        		Text prodText = new Text(obj.getName());
        		prodText.setFont(Font.font("Times New Roman", 22));
           		Text quantText = new Text(String.valueOf(obj.getQuantity()));
           		quantText.setFont(Font.font("Times New Roman", 22));
           		Text priceText = new Text(doubleFormat(obj.getPrice()));
           		priceText.setFont(Font.font("Times New Roman", 22));
           		double subTotal = obj.getPrice()*obj.getQuantity();
           		priceTotal = priceTotal+subTotal;
           		Text subT = new Text(doubleFormat(subTotal));
           		subT.setFont(Font.font("Times New Roman", 22));
           		Button removeBtn = new Button("Remove");
           		gridPaneobj.add(prodText, 0, index+1);
           		GridPane.setHalignment(prodText, HPos.CENTER);
           		gridPaneobj.add(priceText, 1, index+1);
           		GridPane.setHalignment(priceText, HPos.CENTER);
           		gridPaneobj.add(quantText, 2, index+1);
            	GridPane.setHalignment(quantText, HPos.CENTER);
            	gridPaneobj.add(subT, 3, index+1);
           		GridPane.setHalignment(subT, HPos.CENTER);
           		gridPaneobj.add(removeBtn, 4, index+1);
           		GridPane.setHalignment(removeBtn, HPos.CENTER);
           		removeBtn.setOnAction(e -> {
           			Node source = (Node)e.getSource() ;
            		Integer rowIndex = GridPane.getRowIndex(source);
            		shoppingCart.remove(rowIndex-1);
           	        BorderPane cartPage = new BorderPane(); // sets "cartPage" as a borderPane
           			cartPage.setLeft(navigationBar()); // adds the navigation bar on the left
           	        cartPage.setTop(Title()); // adds the title bar on the top
           	        GridPane gridPaneCart = gridPaneMeth(shoppingCart);
        	        cartPage.setCenter(gridPaneCart);
        	        sceneCart = new Scene(cartPage, 1050, 850); // sets the cart scene to the cart borderpane
           			window.setScene(sceneCart);
           			crtSize = shoppingCart.size();
           	        btnHold.get(btnHold.size()-1).setText(String.valueOf(crtSize));
           			});
    		}
    		
    		else if (itemArr[index] instanceof Chips) {
    			Chips obj;
        		obj = ((Chips)itemArr[index]);
        		Text prodText = new Text(obj.getName());
        		prodText.setFont(Font.font("Times New Roman", 22));
           		Text quantText = new Text(String.valueOf(obj.getQuantity()));
           		quantText.setFont(Font.font("Times New Roman", 22));
           		Text priceText = new Text(doubleFormat(obj.getPrice()));
           		priceText.setFont(Font.font("Times New Roman", 22));
           		double subTotal = obj.getPrice()*obj.getQuantity();
           		priceTotal = priceTotal+subTotal;
           		Text subT = new Text(doubleFormat(subTotal));
           		subT.setFont(Font.font("Times New Roman", 22));
           		Button removeBtn = new Button("Remove");
           		gridPaneobj.add(prodText, 0, index+1);
           		GridPane.setHalignment(prodText, HPos.CENTER);
           		gridPaneobj.add(priceText, 1, index+1);
           		GridPane.setHalignment(priceText, HPos.CENTER);
           		gridPaneobj.add(quantText, 2, index+1);
            	GridPane.setHalignment(quantText, HPos.CENTER);
            	gridPaneobj.add(subT, 3, index+1);
           		GridPane.setHalignment(subT, HPos.CENTER);
           		gridPaneobj.add(removeBtn, 4, index+1);
           		GridPane.setHalignment(removeBtn, HPos.CENTER);
           		removeBtn.setOnAction(e -> {
           			Node source = (Node)e.getSource() ;
            		Integer rowIndex = GridPane.getRowIndex(source);
            		shoppingCart.remove(rowIndex-1);
           	        BorderPane cartPage = new BorderPane(); // sets "cartPage" as a borderPane
           			cartPage.setLeft(navigationBar()); // adds the navigation bar on the left
           	        cartPage.setTop(Title()); // adds the title bar on the top
           	        GridPane gridPaneCart = gridPaneMeth(shoppingCart);
        	        cartPage.setCenter(gridPaneCart);
        	        sceneCart = new Scene(cartPage, 1050, 850); // sets the cart scene to the cart borderpane
           			window.setScene(sceneCart);
           			crtSize = shoppingCart.size();
           	        btnHold.get(btnHold.size()-1).setText(String.valueOf(crtSize));
           			});
    		}
    		
    		else if (itemArr[index] instanceof Gum) {
    			Gum obj;
        		obj = ((Gum)itemArr[index]);
        		Text prodText = new Text(obj.getName());
        		prodText.setFont(Font.font("Times New Roman", 22));
           		Text quantText = new Text(String.valueOf(obj.getQuantity()));
           		quantText.setFont(Font.font("Times New Roman", 22));
           		Text priceText = new Text(doubleFormat(obj.getPrice()));
           		priceText.setFont(Font.font("Times New Roman", 22));
           		double subTotal = obj.getPrice()*obj.getQuantity();
           		priceTotal = priceTotal+subTotal;
           		Text subT = new Text(doubleFormat(subTotal));
           		subT.setFont(Font.font("Times New Roman", 22));
           		Button removeBtn = new Button("Remove");
           		gridPaneobj.add(prodText, 0, index+1);
           		GridPane.setHalignment(prodText, HPos.CENTER);
           		gridPaneobj.add(priceText, 1, index+1);
           		GridPane.setHalignment(priceText, HPos.CENTER);
           		gridPaneobj.add(quantText, 2, index+1);
            	GridPane.setHalignment(quantText, HPos.CENTER);
            	gridPaneobj.add(subT, 3, index+1);
           		GridPane.setHalignment(subT, HPos.CENTER);
           		gridPaneobj.add(removeBtn, 4, index+1);
           		GridPane.setHalignment(removeBtn, HPos.CENTER);
           		removeBtn.setOnAction(e -> {
           			Node source = (Node)e.getSource() ;
            		Integer rowIndex = GridPane.getRowIndex(source);
            		shoppingCart.remove(rowIndex-1);
           	        BorderPane cartPage = new BorderPane(); // sets "cartPage" as a borderPane
           			cartPage.setLeft(navigationBar()); // adds the navigation bar on the left
           	        cartPage.setTop(Title()); // adds the title bar on the top
           	        GridPane gridPaneCart = gridPaneMeth(shoppingCart);
        	        cartPage.setCenter(gridPaneCart);
        	        sceneCart = new Scene(cartPage, 1050, 850); // sets the cart scene to the cart borderpane
           			window.setScene(sceneCart);
           			crtSize = shoppingCart.size();
           	        btnHold.get(btnHold.size()-1).setText(String.valueOf(crtSize));
           			});
    		}
    		
    	}
    	Text totalAmount = new Text("Total   $"+doubleFormat(priceTotal));
    	totalAmount.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
    	gridPaneobj.add(totalAmount, 3, goCrtBtnCnt);
   		GridPane.setHalignment(totalAmount, HPos.CENTER);

    	gridPaneobj.setHgap(50);
    	gridPaneobj.setVgap(10);
    	
    	return gridPaneobj;
    }
    
  //Used to create GridPane for the admin
    private  GridPane gridPaneAdmin(Object[] itemArr) {
    	GridPane gridPaneobj = new GridPane();
    	for (int index=0; index<headerAdmin.length;index++) {
    		Text prodText = new Text(headerAdmin[index]);
        	prodText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 26));
        	gridPaneobj.add(prodText, index, 0);
        	GridPane.setHalignment(prodText, HPos.CENTER);
    	}

    	for (int index=0; index<itemArr.length;index++) {
    		if (itemArr[index] instanceof Drink) {
    			Drink obj;
        		obj = ((Drink)itemArr[index]);
    			Text prodText = new Text(obj.getName());
        		prodText.setFont(Font.font("Times New Roman", 22));
           		Text quantText = new Text(String.valueOf(obj.getQuantity()));
           		quantText.setFont(Font.font("Times New Roman", 22));
           		Text priceText = new Text(doubleFormat(obj.getPrice()));
           		priceText.setFont(Font.font("Times New Roman", 22));
           		Text LocationText = new Text(obj.getLocation());
           		LocationText.setFont(Font.font("Times New Roman", 22));
           		Text typeText = new Text("Drink");
           		typeText.setFont(Font.font("Times New Roman", 22));
           		gridPaneobj.add(prodText, 0, index+1);
           		GridPane.setHalignment(prodText, HPos.CENTER);
           		gridPaneobj.add(priceText, 1, index+1);
           		GridPane.setHalignment(priceText, HPos.CENTER);
           		gridPaneobj.add(quantText, 2, index+1);
            	GridPane.setHalignment(quantText, HPos.CENTER);
            	gridPaneobj.add(LocationText, 3, index+1);
            	GridPane.setHalignment(LocationText, HPos.CENTER);
            	gridPaneobj.add(typeText, 4, index+1);
            	GridPane.setHalignment(typeText, HPos.CENTER);

    		}
    		
    		else if (itemArr[index] instanceof Candy) {
    			Candy obj;
        		obj = ((Candy)itemArr[index]);
        		Text prodText = new Text(obj.getName());
        		prodText.setFont(Font.font("Times New Roman", 22));
           		Text quantText = new Text(String.valueOf(obj.getQuantity()));
           		quantText.setFont(Font.font("Times New Roman", 22));
           		Text priceText = new Text(doubleFormat(obj.getPrice()));
           		priceText.setFont(Font.font("Times New Roman", 22));
           		Text LocationText = new Text(obj.getLocation());
           		LocationText.setFont(Font.font("Times New Roman", 22));
           		Text typeText = new Text("Candy");
           		typeText.setFont(Font.font("Times New Roman", 22));
           		gridPaneobj.add(prodText, 0, index+1);
           		GridPane.setHalignment(prodText, HPos.CENTER);
           		gridPaneobj.add(priceText, 1, index+1);
           		GridPane.setHalignment(priceText, HPos.CENTER);
           		gridPaneobj.add(quantText, 2, index+1);
            	GridPane.setHalignment(quantText, HPos.CENTER);
            	gridPaneobj.add(LocationText, 3, index+1);
            	GridPane.setHalignment(LocationText, HPos.CENTER);
            	gridPaneobj.add(typeText, 4, index+1);
            	GridPane.setHalignment(typeText, HPos.CENTER);
    		}
    		
    		else if (itemArr[index] instanceof Chips) {
    			Chips obj;
        		obj = ((Chips)itemArr[index]);
        		Text prodText = new Text(obj.getName());
        		prodText.setFont(Font.font("Times New Roman", 22));
           		Text quantText = new Text(String.valueOf(obj.getQuantity()));
           		quantText.setFont(Font.font("Times New Roman", 22));
           		Text priceText = new Text(doubleFormat(obj.getPrice()));
           		priceText.setFont(Font.font("Times New Roman", 22));
           		Text LocationText = new Text(obj.getLocation());
           		LocationText.setFont(Font.font("Times New Roman", 22));
           		Text typeText = new Text("Chips");
           		typeText.setFont(Font.font("Times New Roman", 22));
           		gridPaneobj.add(prodText, 0, index+1);
           		GridPane.setHalignment(prodText, HPos.CENTER);
           		gridPaneobj.add(priceText, 1, index+1);
           		GridPane.setHalignment(priceText, HPos.CENTER);
           		gridPaneobj.add(quantText, 2, index+1);
            	GridPane.setHalignment(quantText, HPos.CENTER);
            	gridPaneobj.add(LocationText, 3, index+1);
            	GridPane.setHalignment(LocationText, HPos.CENTER);
            	gridPaneobj.add(typeText, 4, index+1);
            	GridPane.setHalignment(typeText, HPos.CENTER);
    		}
    		
    		else if (itemArr[index] instanceof Gum) {
    			Gum obj;
        		obj = ((Gum)itemArr[index]);
        		Text prodText = new Text(obj.getName());
        		prodText.setFont(Font.font("Times New Roman", 22));
           		Text quantText = new Text(String.valueOf(obj.getQuantity()));
           		quantText.setFont(Font.font("Times New Roman", 22));
           		Text priceText = new Text(doubleFormat(obj.getPrice()));
           		priceText.setFont(Font.font("Times New Roman", 22));
           		Text LocationText = new Text(obj.getLocation());
           		LocationText.setFont(Font.font("Times New Roman", 22));
           		Text typeText = new Text("Gum");
           		typeText.setFont(Font.font("Times New Roman", 22));
           		gridPaneobj.add(prodText, 0, index+1);
           		GridPane.setHalignment(prodText, HPos.CENTER);
           		gridPaneobj.add(priceText, 1, index+1);
           		GridPane.setHalignment(priceText, HPos.CENTER);
           		gridPaneobj.add(quantText, 2, index+1);
            	GridPane.setHalignment(quantText, HPos.CENTER);
            	gridPaneobj.add(LocationText, 3, index+1);
            	GridPane.setHalignment(LocationText, HPos.CENTER);
            	gridPaneobj.add(typeText, 4, index+1);
            	GridPane.setHalignment(typeText, HPos.CENTER);
    		}
    		
    	}

    	gridPaneobj.setHgap(50);
    	gridPaneobj.setVgap(10);
    	
    	return gridPaneobj;
    }
    
    //Filter the array by type and return type array
    public Object[] getCount(Product[] objArr, String typeOfProd) {
    	ArrayList<Product> holdArray = new ArrayList<Product>();
    	ArrayList<Drink> holdArrayDrink = new ArrayList<Drink>();
    	ArrayList<Candy> holdArrayCandy = new ArrayList<Candy>();
    	ArrayList<Chips> holdArrayChips = new ArrayList<Chips>();
    	ArrayList<Gum> holdArrayGum = new ArrayList<Gum>();
    	for (int index =0; index<objArr.length;index++) {
    		if (objArr[index] instanceof Drink && typeOfProd =="Drink") {
        		holdArray.add(objArr[index]);
        		holdArrayDrink.add((Drink)objArr[index]);
        	}
    		else if (objArr[index] instanceof Candy && typeOfProd =="Candy") {
        		holdArray.add(objArr[index]);
        		holdArrayCandy.add((Candy)objArr[index]);
        	}
    		else if (objArr[index] instanceof Chips && typeOfProd =="Chips") {
        		holdArray.add(objArr[index]);
        		holdArrayChips.add((Chips)objArr[index]);
        	}
    		else if (objArr[index] instanceof Gum && typeOfProd =="Gum") {
        		holdArray.add(objArr[index]);
        		holdArrayGum.add((Gum)objArr[index]);
        	}
    	}

    	if (typeOfProd =="Drink") {
    		Drink[] tempArray = new Drink[holdArrayDrink.size()];
    		for (int index = 0;index<holdArrayDrink.size();index++) {
    			tempArray[index] = holdArrayDrink.get(index);
    		}
    		return tempArray;
    	}
    	if (typeOfProd =="Candy") {
    		Candy[] tempArray = new Candy[holdArrayCandy.size()];
    		for (int index = 0;index<holdArrayCandy.size();index++) {
    			tempArray[index] = holdArrayCandy.get(index);
    		}
    		return tempArray;
    	}
    	if (typeOfProd =="Chips") {
    		Chips[] tempArray = new Chips[holdArrayChips.size()];
    		for (int index = 0;index<holdArrayChips.size();index++) {
    			tempArray[index] = holdArrayChips.get(index);
    		}
    		return tempArray;
    	}
    	if (typeOfProd =="Gum") {
    		Gum[] tempArray = new Gum[holdArrayGum.size()];
    		for (int index = 0;index<holdArrayGum.size();index++) {
    			tempArray[index] = holdArrayGum.get(index);
    		}
    		return tempArray;
    	}
    	
    	return null;
    }
    
    private String doubleFormat(double dataVar) {
    	DecimalFormat dataFormat = new DecimalFormat("#0.00");
    	return dataFormat.format(dataVar);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}