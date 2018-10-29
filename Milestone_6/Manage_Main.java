import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Manage_Main extends Application {
	Global_Inventory_Management vendObjects = new Global_Inventory_Management();
    Stage window;
    Scene login, Vdashboard, // login screen & dashboard screen (holds multiple vending machine
            mainV1, invV1, shopV1, // vend. machine 1 invintory screen & its own shop
            mainV2, invV2, shopV2, // vend. machine 2 invintory screen & its own shop
            mainV3, invV3, shopV3; // vend. machine 3 invintory screen & its own shop

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        BorderPane logStart = new BorderPane();
        logStart.setCenter(stack());

        BorderPane main = new BorderPane();
        main.setTop(welcome());
        main.setCenter(selection());
        main.setBottom(placeholder());

//========================PlaceHolders *CAN DELETE LATER*==========================================
        Image warning = new Image(Manage_Main.class.getResource("/Design/warn.png").toExternalForm());
        Image shopping = new Image(Manage_Main.class.getResource("/Design/Shop.png").toExternalForm());

        ImageView W1 = new ImageView(warning);
        ImageView S1 = new ImageView(shopping);
        ImageView W2 = new ImageView(warning);
        ImageView S2 = new ImageView(shopping);
        ImageView W3 = new ImageView(warning);
        ImageView S3 = new ImageView(shopping);

        Image vm1 = new Image(Manage_Main.class.getResource("/Design/VM1.png").toExternalForm());
        ImageView IV1 = new ImageView(vm1);

        Image vm2 = new Image(Manage_Main.class.getResource("/Design/VM2.png").toExternalForm());
        ImageView IV2 = new ImageView(vm2);

        Image vm3 = new Image(Manage_Main.class.getResource("/Design/VM3.png").toExternalForm());
        ImageView IV3 = new ImageView(vm3);
//==============================================================================

        BorderPane VM1 = new BorderPane();
        VM1.setTop(info1());
        VM1.setCenter(IV1);//center placeholder
        //VM1.setCenter(itemGP("VendingMachine_1"));
        VM1.setBottom(menu1());

        BorderPane LowVM1 = new BorderPane();
        LowVM1.setTop(info1());
        LowVM1.setCenter(W1);//center placeholder
        LowVM1.setBottom(menu1());

        BorderPane StoreVM1 = new BorderPane();
        StoreVM1.setTop(info1());
        StoreVM1.setCenter(S1);//center placeholder
        StoreVM1.setBottom(menu1());

//==============================================================================
        BorderPane VM2 = new BorderPane();
        VM2.setTop(info2());
        VM2.setCenter(IV2);//center placeholder
        //VM2.setCenter(itemGP("VendingMachine_2"));
        VM2.setBottom(menu2());

        BorderPane LowVM2 = new BorderPane();
        LowVM2.setTop(info2());
        LowVM2.setCenter(W2);//center placeholder
        LowVM2.setBottom(menu2());

        BorderPane StoreVM2 = new BorderPane();
        StoreVM2.setTop(info2());
        StoreVM2.setCenter(S2);//center placeholder
        StoreVM2.setBottom(menu2());

//==============================================================================
        BorderPane VM3 = new BorderPane();
        VM3.setTop(info3());
        VM3.setCenter(IV3);//center placeholder
        //VM3.setCenter(itemGP("VendingMachine_3"));
        VM3.setBottom(menu3());

        BorderPane LowVM3 = new BorderPane();
        LowVM3.setTop(info3());
        LowVM3.setCenter(W3);//center placeholder
        LowVM3.setBottom(menu3());

        BorderPane StoreVM3 = new BorderPane();
        StoreVM3.setTop(info3());
        StoreVM3.setCenter(S3);//center placeholder
        StoreVM3.setBottom(menu3());

        Vdashboard = new Scene(main, 500, 800);
        login = new Scene(logStart, 500, 800);

        mainV1 = new Scene(VM1, 500, 800);
        invV1 = new Scene(LowVM1, 500, 800);
        shopV1 = new Scene(StoreVM1, 500, 800);

        mainV2 = new Scene(VM2, 500, 800);
        invV2 = new Scene(LowVM2, 500, 800);
        shopV2 = new Scene(StoreVM2, 500, 800);

        mainV3 = new Scene(VM3, 500, 800);
        invV3 = new Scene(LowVM3, 500, 800);
        shopV3 = new Scene(StoreVM3, 500, 800);

        //this set of code allows to set the window to be in a certain space (by pixles),
        //perfect to not let a window pop over another.
        //X == across the top of the screen
        //Y == up and down of the screen
        //sets the window to be at the left side of the screen, about in the 
        //middle from the top and bottom
        window.setX(10);
        window.setY(45);

        primaryStage.setTitle("Virtual VM Mangement");
        primaryStage.setResizable(false);
        primaryStage.setScene(login);
        primaryStage.show();
    }

    private StackPane stack() {
        StackPane stack = new StackPane();

        Image image = new Image(Manage_Main.class.getResource("/Design/back.png").toExternalForm());
        ImageView IV = new ImageView(image);

        Image person = new Image(Manage_Main.class.getResource("/Design/Person.png").toExternalForm());
        ImageView PIV = new ImageView(person);

        GridPane Log = new GridPane();
        Log.setAlignment(Pos.CENTER);
        Log.setHgap(10);
        Log.setVgap(10);
        Log.setPadding(new Insets(10));

        Log.add(PIV, 0, 1);

        TextField user = new TextField();
        user.setPromptText("username");
        user.setFocusTraversable(false);
        Log.add(user, 0, 2);

        PasswordField passw = new PasswordField();
        passw.setPromptText("password");
        passw.setFocusTraversable(false);
        Log.add(passw, 0, 3);

        Button Enter = new Button("\tLogin \t");
        Enter.setOnAction(e -> {
            window.setScene(Vdashboard);
            user.clear();
            passw.clear();
        });
        Log.add(Enter, 0, 4);

        stack.getChildren().addAll(IV, Log);
        return stack;
    }

    private HBox welcome() {
        HBox area = new HBox();
        area.setStyle("-fx-background-color:#B30072");
        area.setAlignment(Pos.CENTER);

        GridPane tile = new GridPane();
        tile.setAlignment(Pos.CENTER);
        tile.setPadding(new Insets(15));

        Text Welcome = new Text("\t   Welcome!");
        Welcome.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 32));
        Welcome.setFill(Color.WHITE);

        Text info = new Text("Manage Your Vending Machines Below");
        info.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, FontPosture.ITALIC, 20));
        info.setFill(Color.WHITE);

        tile.add(Welcome, 2, 0);
        tile.add(info, 2, 2);

        area.getChildren().add(tile);

        return area;
    }

    private HBox placeholder() {
        HBox area = new HBox();
        area.setStyle("-fx-background-color:#B30072");
        area.setMaxSize(500, 100);

        GridPane copyright = new GridPane();
        copyright.setAlignment(Pos.BOTTOM_LEFT);
        copyright.setPadding(new Insets(5));

        Text copyrights = new Text("\t\t\t\t\t\t\t\t  Copyright VendMyProducts 2018");
        copyrights.setFont(Font.font("Times New Roman", FontWeight.LIGHT, FontPosture.REGULAR, 16));
        copyrights.setFill(Color.WHITE);

        copyright.add(copyrights, 0, 0);

        area.getChildren().add(copyright);
        return area;
    }

    private GridPane selection() {
        //set images so that java can get them

        GridPane mainSelcetions = new GridPane();
        mainSelcetions.setAlignment(Pos.CENTER);
        mainSelcetions.setStyle("-fx-background-color:#FFFFFF");
        mainSelcetions.setVgap(50);
        mainSelcetions.setPadding(new Insets(10));

        Image vm1 = new Image(Manage_Main.class.getResource("/Design/VM1.png").toExternalForm());
        ImageView IV1 = new ImageView(vm1);

        Image vm2 = new Image(Manage_Main.class.getResource("/Design/VM2.png").toExternalForm());
        ImageView IV2 = new ImageView(vm2);

        Image vm3 = new Image(Manage_Main.class.getResource("/Design/VM3.png").toExternalForm());
        ImageView IV3 = new ImageView(vm3);

        Text VM1T = new Text("Vending Machine 1 - At BoxMyItems Inc. ");
        VM1T.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 18));

        Text VM2T = new Text("Vending Machine 2 - At MyHealth Hospital ");
        VM2T.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 18));

        Text VM3T = new Text("Vending Machine 3 - At SleepIn Hotel ");
        VM3T.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 18));

        Button VM1 = new Button();
        VM1.setGraphic(IV1);
        VM1.setStyle("-fx-background-color:#FFFFFF");
        VM1.setOnAction(e -> {
            window.setScene(mainV1);
        });

        Button VM2 = new Button();
        VM2.setGraphic(IV2);
        VM2.setStyle("-fx-background-color:#FFFFFF");
        VM2.setOnAction(e -> {
            window.setScene(mainV2);
        });

        Button VM3 = new Button();
        VM3.setGraphic(IV3);
        VM3.setStyle("-fx-background-color:#FFFFFF");
        VM3.setOnAction(e -> {
            window.setScene(mainV3);
        });

        Button logout = new Button("Logout");
        logout.setStyle("-fx-background-color:#F70000");
        logout.setOnAction(e -> {
            window.setScene(login);
        });
        logout.setMaxWidth(200);

        mainSelcetions.add(VM1, 0, 0);
        mainSelcetions.add(VM1T, 1, 0);
        mainSelcetions.add(VM2, 0, 1);
        mainSelcetions.add(VM2T, 1, 1);
        mainSelcetions.add(VM3, 0, 2);
        mainSelcetions.add(VM3T, 1, 2);
        mainSelcetions.add(logout, 1, 3);

        return mainSelcetions;
    }

    //a simple window that has built in buttons, that will have the ability to close the program or not.
    private HBox menu1() { //***
        HBox Menu = new HBox();
        Menu.setStyle("-fx-background-color:#D5D5D5");
        Menu.setAlignment(Pos.CENTER);

        GridPane menu_V = new GridPane();
        menu_V.setAlignment(Pos.CENTER);
        menu_V.setHgap(60);
        menu_V.setVgap(10);
        menu_V.setPadding(new Insets(20));

        //set images so that java can get them
        Image dashboard = new Image(Manage_Main.class.getResource("/Design/dash.png").toExternalForm());
        ImageView D = new ImageView(dashboard);

        Image warning = new Image(Manage_Main.class.getResource("/Design/warn.png").toExternalForm());
        ImageView W = new ImageView(warning);

        Image shopping = new Image(Manage_Main.class.getResource("/Design/Shop.png").toExternalForm());
        ImageView S = new ImageView(shopping);

        //create buttons for the menu
        Button dash = new Button();
        dash.setGraphic(D);
        dash.setStyle("-fx-background-color:#D5D5D5");
        dash.setOnAction(e -> {
            window.setScene(Vdashboard);
        });
        dash.setOnMouseEntered(e -> {
            dash.setText("Vending Machines");
        });
        dash.setOnMouseExited(e -> {
            dash.setText("");
        });

        Button notice = new Button();
        notice.setGraphic(W);
        notice.setStyle("-fx-background-color:#D5D5D5");
        notice.setOnAction(e -> {
        	BorderPane LowVM1 = new BorderPane();
            LowVM1.setTop(info1());
            LowVM1.setCenter(lowInven("VendingMachine_1"));//center placeholder
            LowVM1.setBottom(menu1());
            invV1 = new Scene(LowVM1, 500, 800);
            window.setScene(invV1);
        }); //***
        notice.setOnMouseEntered(e -> {
            notice.setText("Low Items");
        });
        notice.setOnMouseExited(e -> {
            notice.setText("");
        });

        Button shop = new Button();
        shop.setGraphic(S);
        shop.setStyle("-fx-background-color:#D5D5D5");
        shop.setOnAction(e -> {
        	BorderPane StoreVM1 = new BorderPane();
            StoreVM1.setTop(info1());
            StoreVM1.setCenter(invenPO("VendingMachine_1"));//center placeholder
            StoreVM1.setBottom(menu1());
            shopV1 = new Scene(StoreVM1, 500, 800);
            window.setScene(shopV1);
        }); //***
        shop.setOnMouseEntered(e -> {
            shop.setText("VM1 Shop");
        });
        shop.setOnMouseExited(e -> {
            shop.setText("");
        });

        menu_V.add(dash, 0, 0);
        menu_V.add(notice, 1, 0);
        menu_V.add(shop, 2, 0);

        Menu.getChildren().add(menu_V);

        return Menu;
    }

    private HBox menu2() { //***
        HBox Menu = new HBox();
        Menu.setStyle("-fx-background-color:#D5D5D5");
        Menu.setAlignment(Pos.CENTER);

        GridPane menu_V = new GridPane();
        menu_V.setAlignment(Pos.CENTER);
        menu_V.setHgap(60);
        menu_V.setVgap(10);
        menu_V.setPadding(new Insets(20));

        //set images so that java can get them
        Image dashboard = new Image(Manage_Main.class.getResource("/Design/dash.png").toExternalForm());
        ImageView D = new ImageView(dashboard);

        Image warning = new Image(Manage_Main.class.getResource("/Design/warn.png").toExternalForm());
        ImageView W = new ImageView(warning);

        Image shopping = new Image(Manage_Main.class.getResource("/Design/Shop.png").toExternalForm());
        ImageView S = new ImageView(shopping);

        //create buttons for the menu
        Button dash = new Button();
        dash.setGraphic(D);
        dash.setStyle("-fx-background-color:#D5D5D5");
        dash.setOnAction(e -> {
            window.setScene(Vdashboard);
        });
        dash.setOnMouseEntered(e -> {
            dash.setText("Vending Machines");
        });
        dash.setOnMouseExited(e -> {
            dash.setText("");
        });

        Button notice = new Button();
        notice.setGraphic(W);
        notice.setStyle("-fx-background-color:#D5D5D5");
        notice.setOnAction(e -> {
        	BorderPane LowVM2 = new BorderPane();
            LowVM2.setTop(info2());
            LowVM2.setCenter(lowInven("VendingMachine_2"));//center placeholder
            LowVM2.setBottom(menu2());
            invV2 = new Scene(LowVM2, 500, 800);
            window.setScene(invV2);
        }); //***
        notice.setOnMouseEntered(e -> {
            notice.setText("Low Items");
        });
        notice.setOnMouseExited(e -> {
            notice.setText("");
        });

        Button shop = new Button();
        shop.setGraphic(S);
        shop.setStyle("-fx-background-color:#D5D5D5");
        shop.setOnAction(e -> {
        	BorderPane StoreVM2 = new BorderPane();
            StoreVM2.setTop(info2());
            StoreVM2.setCenter(invenPO("VendingMachine_2"));//center placeholder
            StoreVM2.setBottom(menu2());
            shopV2 = new Scene(StoreVM2, 500, 800);
            window.setScene(shopV2);
        }); //***
        shop.setOnMouseEntered(e -> {
            shop.setText("VM2 Shop");
        });
        shop.setOnMouseExited(e -> {
            shop.setText("");
        });

        menu_V.add(dash, 0, 0);
        menu_V.add(notice, 1, 0);
        menu_V.add(shop, 2, 0);

        Menu.getChildren().add(menu_V);

        return Menu;
    }

    private HBox menu3() { //***
        HBox Menu = new HBox();
        Menu.setStyle("-fx-background-color:#D5D5D5");
        Menu.setAlignment(Pos.CENTER);

        GridPane menu_V = new GridPane();
        menu_V.setAlignment(Pos.CENTER);
        menu_V.setHgap(60);
        menu_V.setVgap(10);
        menu_V.setPadding(new Insets(20));

        //set images so that java can get them
        Image dashboard = new Image(Manage_Main.class.getResource("/Design/dash.png").toExternalForm());
        ImageView D = new ImageView(dashboard);

        Image warning = new Image(Manage_Main.class.getResource("/Design/warn.png").toExternalForm());
        ImageView W = new ImageView(warning);

        Image shopping = new Image(Manage_Main.class.getResource("/Design/Shop.png").toExternalForm());
        ImageView S = new ImageView(shopping);

        //create buttons for the menu
        Button dash = new Button();
        dash.setGraphic(D);
        dash.setStyle("-fx-background-color:#D5D5D5");
        dash.setOnAction(e -> {
            window.setScene(Vdashboard);
        });
        dash.setOnMouseEntered(e -> {
            dash.setText("Vending Machines");
        });
        dash.setOnMouseExited(e -> {
            dash.setText("");
        });

        Button notice = new Button();
        notice.setGraphic(W);
        notice.setStyle("-fx-background-color:#D5D5D5");
        notice.setOnAction(e -> {
        	BorderPane LowVM3 = new BorderPane();
            LowVM3.setTop(info3());
            LowVM3.setCenter(lowInven("VendingMachine_3"));//center placeholder
            LowVM3.setBottom(menu3());
            invV3 = new Scene(LowVM3, 500, 800);
            window.setScene(invV3);
        }); //***
        notice.setOnMouseEntered(e -> {
            notice.setText("Low Items");
        });
        notice.setOnMouseExited(e -> {
            notice.setText("");
        });

        Button shop = new Button();
        shop.setGraphic(S);
        shop.setStyle("-fx-background-color:#D5D5D5");
        shop.setOnAction(e -> {
        	BorderPane StoreVM3 = new BorderPane();
            StoreVM3.setTop(info3());
            StoreVM3.setCenter(invenPO("VendingMachine_3"));//center placeholder
            StoreVM3.setBottom(menu3());
            shopV3 = new Scene(StoreVM3, 500, 800);
            window.setScene(shopV3);
        }); //***
        shop.setOnMouseEntered(e -> {
            shop.setText("VM3 Shop");
        });
        shop.setOnMouseExited(e -> {
            shop.setText("");
        });

        menu_V.add(dash, 0, 0);
        menu_V.add(notice, 1, 0);
        menu_V.add(shop, 2, 0);

        Menu.getChildren().add(menu_V);

        return Menu;
    }

    private HBox info1() {
        HBox Top = new HBox();
        Top.setStyle("-fx-background-color:#6373A6");
        Top.setAlignment(Pos.CENTER);

        GridPane menu = new GridPane();
        menu.setAlignment(Pos.CENTER);
        menu.setHgap(10);
        menu.setVgap(10);
        menu.setPadding(new Insets(10));

        GridPane menu1 = new GridPane();
        menu1.setAlignment(Pos.CENTER);
        menu1.setHgap(10);

        Text VM1T = new Text("\tVending Machine 1 - At BoxMyItems Inc. ");
        VM1T.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 22));
        VM1T.setFill(Color.WHITE);

        Text space = new Text("\t\t\t");

        TextField searchBox = new TextField();
        searchBox.setMaxWidth(180);
        searchBox.setPromptText("Search");

        Image searchB = new Image(Manage_Main.class.getResource("/Design/search.png").toExternalForm());
        ImageView Search = new ImageView(searchB);

        Image sortB = new Image(Manage_Main.class.getResource("/Design/sort.png").toExternalForm());
        ImageView SortABC = new ImageView(sortB);

        Image listing = new Image(Manage_Main.class.getResource("/Design/list.png").toExternalForm());
        ImageView list = new ImageView(listing);

        Button btnSearch = new Button();
        btnSearch.setGraphic(Search);
        btnSearch.setOnAction(e -> {
        	BorderPane VM1 = new BorderPane();
            VM1.setTop(info1());
            VM1.setCenter(itemGPSearch(searchBox.getText()));
            VM1.setBottom(menu1());
        	mainV1 = new Scene(VM1, 500, 800);
        	window.setScene(mainV1);
        });
        
        Button sorts = new Button(); // this should start the sort method for the original list
        sorts.setGraphic(SortABC);
        sorts.setStyle("-fx-background-color:#FFFFFF");
        sorts.setOnMouseEntered(e -> {
            sorts.setText("Sort");
        });
        sorts.setOnMouseExited(e -> {
            sorts.setText("");
        });
        sorts.setOnAction(e -> {
        	BorderPane VM1 = new BorderPane();
            VM1.setTop(info1());
            VM1.setCenter(itemGPSort("VendingMachine_1"));
            VM1.setBottom(menu1());
        	mainV1 = new Scene(VM1, 500, 800);
        	window.setScene(mainV1);
        });

        Button searchs = new Button(); // this should start a search method
        searchs.setGraphic(Search);
        searchs.setStyle("-fx-background-color:#FFFFFF");
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // goes to the main area with the original list
        Button back2List = new Button();
        back2List.setGraphic(list);
        back2List.setStyle("-fx-background-color:#FFFFFF");
        back2List.setOnAction(e -> {
        	BorderPane VM1 = new BorderPane();
            VM1.setTop(info1());
            VM1.setCenter(itemGP("VendingMachine_1"));
            VM1.setBottom(menu1());
        	mainV1 = new Scene(VM1, 500, 800);
            window.setScene(mainV1);
        }); //***
        
        back2List.setOnMouseEntered(e -> {
            back2List.setText("Items List");
        });
        back2List.setOnMouseExited(e -> {
            back2List.setText("");
        });

        menu1.add(back2List, 0, 0);
        menu1.add(sorts, 1, 0);
        menu1.add(space, 2, 0);
        menu1.add(searchBox, 4, 0);
        menu1.add(btnSearch, 5, 0);

        menu.add(VM1T, 0, 0);
        menu.add(menu1, 0, 1);

        Top.getChildren().add(menu);
        return Top;
    }

    private HBox info2() {
        HBox Top = new HBox();
        Top.setStyle("-fx-background-color:#A3A13E");
        Top.setAlignment(Pos.CENTER);

        GridPane menu = new GridPane();
        menu.setAlignment(Pos.CENTER);
        menu.setHgap(10);
        menu.setVgap(10);
        menu.setPadding(new Insets(10));

        GridPane menu1 = new GridPane();
        menu1.setAlignment(Pos.CENTER);
        menu1.setHgap(10);

        Text VM2T = new Text("\tVending Machine 2 - At MyHealth Hospital ");
        VM2T.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 22));
        VM2T.setFill(Color.WHITE);

        Text space = new Text("\t\t\t");

        TextField searchBox = new TextField();
        searchBox.setMaxWidth(180);
        searchBox.setPromptText("Search");

        Image searchB = new Image(Manage_Main.class.getResource("/Design/search.png").toExternalForm());
        ImageView Search = new ImageView(searchB);

        Image sortB = new Image(Manage_Main.class.getResource("/Design/sort.png").toExternalForm());
        ImageView SortABC = new ImageView(sortB);

        Image listing = new Image(Manage_Main.class.getResource("/Design/list.png").toExternalForm());
        ImageView list = new ImageView(listing);

        Button btnSearch = new Button();
        btnSearch.setGraphic(Search);
        btnSearch.setOnAction(e -> {
        	BorderPane VM2 = new BorderPane();
            VM2.setTop(info2());
            VM2.setCenter(itemGPSearch(searchBox.getText()));
            VM2.setBottom(menu2());
        	mainV2 = new Scene(VM2, 500, 800);
        	window.setScene(mainV2);
        });
        
        Button sorts = new Button();// this should start the sort method for the original list
        sorts.setGraphic(SortABC);
        sorts.setStyle("-fx-background-color:#FFFFFF");
        sorts.setOnMouseEntered(e -> {
            sorts.setText("Sort");
        });
        sorts.setOnMouseExited(e -> {
            sorts.setText("");
        });
        
        sorts.setOnAction(e -> {
        	BorderPane VM2 = new BorderPane();
            VM2.setTop(info2());
            VM2.setCenter(itemGPSort("VendingMachine_2"));
            VM2.setBottom(menu2());
        	mainV2 = new Scene(VM2, 500, 800);
        	window.setScene(mainV2);
        });

        Button searchs = new Button(); // this should start a search method
        searchs.setGraphic(Search);
        searchs.setStyle("-fx-background-color:#FFFFFF");

        // goes to the main area with the original list
        Button back2List = new Button();
        back2List.setGraphic(list);
        back2List.setStyle("-fx-background-color:#FFFFFF");
        back2List.setOnAction(e -> {
        	BorderPane VM2 = new BorderPane();
            VM2.setTop(info2());
            VM2.setCenter(itemGP("VendingMachine_2"));
            VM2.setBottom(menu2());
        	mainV2 = new Scene(VM2, 500, 800);
            window.setScene(mainV2);
        }); //***
        back2List.setOnMouseEntered(e -> {
            back2List.setText("Items List");
        });
        back2List.setOnMouseExited(e -> {
            back2List.setText("");
        });

        menu1.add(back2List, 0, 0);
        menu1.add(sorts, 1, 0);
        menu1.add(space, 2, 0);
        menu1.add(searchBox, 4, 0);
        menu1.add(btnSearch, 5, 0);

        menu.add(VM2T, 0, 0);
        menu.add(menu1, 0, 1);

        Top.getChildren().add(menu);
        return Top;
    }

    private HBox info3() {
        HBox Top = new HBox();
        Top.setStyle("-fx-background-color:#6FAB6A");
        Top.setAlignment(Pos.CENTER);

        GridPane menu = new GridPane();
        menu.setAlignment(Pos.CENTER);
        menu.setHgap(10);
        menu.setVgap(10);
        menu.setPadding(new Insets(10));

        GridPane menu1 = new GridPane();
        menu1.setAlignment(Pos.CENTER);
        menu1.setHgap(10);

        Text VM3T = new Text("\tVending Machine 3 - At SleepIn Hotel ");
        VM3T.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 22));
        VM3T.setFill(Color.WHITE);

        Text space = new Text("\t\t\t");

        TextField searchBox = new TextField();
        searchBox.setMaxWidth(180);
        searchBox.setPromptText("Search");

        Image searchB = new Image(Manage_Main.class.getResource("/Design/search.png").toExternalForm());
        ImageView Search = new ImageView(searchB);

        Image sortB = new Image(Manage_Main.class.getResource("/Design/sort.png").toExternalForm());
        ImageView SortABC = new ImageView(sortB);

        Image listing = new Image(Manage_Main.class.getResource("/Design/list.png").toExternalForm());
        ImageView list = new ImageView(listing);

        Button btnSearch = new Button();
        btnSearch.setGraphic(Search);
        btnSearch.setOnAction(e -> {
        	BorderPane VM3 = new BorderPane();
            VM3.setTop(info3());
            VM3.setCenter(itemGPSearch(searchBox.getText()));
            VM3.setBottom(menu3());
        	mainV3 = new Scene(VM3, 500, 800);
        	window.setScene(mainV3);
        });
        
        Button sorts = new Button(); // this should start the sort method for the original list
        sorts.setGraphic(SortABC);
        sorts.setStyle("-fx-background-color:#FFFFFF");
        sorts.setOnMouseEntered(e -> {
            sorts.setText("Sort");
        });
        sorts.setOnMouseExited(e -> {
            sorts.setText("");
        });
        sorts.setOnAction(e -> {
        	BorderPane VM3 = new BorderPane();
            VM3.setTop(info3());
            VM3.setCenter(itemGPSort("VendingMachine_3"));
            VM3.setBottom(menu3());
        	mainV3 = new Scene(VM3, 500, 800);
        	window.setScene(mainV3);
        });

        Button searchs = new Button(); // this should start a search method
        searchs.setGraphic(Search);
        searchs.setStyle("-fx-background-color:#FFFFFF");

        // goes to the main area with the original list
        Button back2List = new Button();
        back2List.setGraphic(list);
        back2List.setStyle("-fx-background-color:#FFFFFF");
        back2List.setOnAction(e -> {
        	BorderPane VM3 = new BorderPane();
            VM3.setTop(info3());
            VM3.setCenter(itemGP("VendingMachine_3"));
            VM3.setBottom(menu3());
        	mainV3 = new Scene(VM3, 500, 800);
            window.setScene(mainV3);
        }); //***
        back2List.setOnMouseEntered(e -> {
            back2List.setText("Items List");
        });
        back2List.setOnMouseExited(e -> {
            back2List.setText("");
        });

        menu1.add(back2List, 0, 0);
        menu1.add(sorts, 1, 0);
        menu1.add(space, 2, 0);
        menu1.add(searchBox, 4, 0);
        menu1.add(btnSearch, 5, 0);

        menu.add(VM3T, 0, 0);
        menu.add(menu1, 0, 1);

        Top.getChildren().add(menu);
        return Top;
    }
    
    private GridPane itemGP(String VendMachine) {
    	String[] header = {"Product Name","Stock","Location"};
    	GridPane itemGridDisplay = new GridPane();
    	List<Product> vendObs = new ArrayList<Product>();
    	for (int index=0; index < vendObjects.prodManObjects.length; index++) {
    		if (VendMachine.equals(vendObjects.prodManObjects[index].getMachine())){
    			vendObs.add(vendObjects.prodManObjects[index]);
    		}
    	}
    	for (int x=0; x<header.length;x++) {
    		Text prodText = new Text(header[x]);
        	prodText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 24));
        	itemGridDisplay.add(prodText, x, 0);
        	GridPane.setHalignment(prodText, HPos.CENTER);
    	}
    	if (!vendObs.isEmpty()) {
    		for (int index=0;index<vendObs.size(); index++ ){
    			//Create Objects and format the text
				Text prodText = new Text(vendObs.get(index).getName());
	    		prodText.setFont(Font.font("Times New Roman", 20));
	       		Text quantText = new Text(String.valueOf(vendObs.get(index).getQuantity()));
	       		quantText.setFont(Font.font("Times New Roman", 22));
	       		Text locText = new Text(vendObs.get(index).getLocation());
	       		locText.setFont(Font.font("Times New Roman", 22));
	        	
	        	//Add nodes to GridPane (node, col, row)
	       		itemGridDisplay.add(prodText, 0, index+1);
	       		GridPane.setHalignment(prodText, HPos.CENTER);
	       		itemGridDisplay.add(quantText, 1, index+1);
	        	GridPane.setHalignment(quantText, HPos.CENTER);
	        	itemGridDisplay.add(locText, 2, index+1);
	       		GridPane.setHalignment(locText, HPos.CENTER);
    		}
    	}
    		itemGridDisplay.setHgap(50);
        	itemGridDisplay.setVgap(10);
    	return itemGridDisplay;
    }

    private GridPane itemGPSort(String VendMachine) {
    	Global_Inventory_Management.quickSort(vendObjects.prodManObjects);
    	String[] header = {"Product Name","Stock","Location"};
    	GridPane itemGridDisplay = new GridPane();
    	List<Product> vendObs = new ArrayList<Product>();
    	for (int index=0; index < vendObjects.prodManObjects.length; index++) {
    		if (VendMachine.equals(vendObjects.prodManObjects[index].getMachine())){
    			vendObs.add(vendObjects.prodManObjects[index]);
    		}
    	}
    	for (int x=0; x<header.length;x++) {
    		Text prodText = new Text(header[x]);
        	prodText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 24));
        	itemGridDisplay.add(prodText, x, 0);
        	GridPane.setHalignment(prodText, HPos.CENTER);
    	}
    	if (!vendObs.isEmpty()) {
    		for (int index=0;index<vendObs.size(); index++ ){
    			//Create Objects and format the text
				Text prodText = new Text(vendObs.get(index).getName());
	    		prodText.setFont(Font.font("Times New Roman", 20));
	       		Text quantText = new Text(String.valueOf(vendObs.get(index).getQuantity()));
	       		quantText.setFont(Font.font("Times New Roman", 22));
	       		Text locText = new Text(vendObs.get(index).getLocation());
	       		locText.setFont(Font.font("Times New Roman", 22));
	        	
	        	//Add nodes to GridPane (node, col, row)
	       		itemGridDisplay.add(prodText, 0, index+1);
	       		GridPane.setHalignment(prodText, HPos.CENTER);
	       		itemGridDisplay.add(quantText, 1, index+1);
	        	GridPane.setHalignment(quantText, HPos.CENTER);
	        	itemGridDisplay.add(locText, 2, index+1);
	       		GridPane.setHalignment(locText, HPos.CENTER);
    		}
    	}
    		itemGridDisplay.setHgap(50);
        	itemGridDisplay.setVgap(10);
    	return itemGridDisplay;
    }    
    
    //Recursive Method for product in vending machine
    private GridPane itemGPSearch(String userWord) {
    	String[] header = {"Product Name","Stock","Vending Machine"};
    	GridPane itemGridDisplay = new GridPane();
    	
    	for (int x=0; x<header.length;x++) {
    		Text prodText = new Text(header[x]);
        	prodText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 24));
        	itemGridDisplay.add(prodText, x, 0);
        	GridPane.setHalignment(prodText, HPos.CENTER);
    	}
    	
    	if (!userWord.isEmpty() && Global_Inventory_Management.prodSearch(vendObjects.prodManObjects, userWord) != null) {
        	Product vendObs = Global_Inventory_Management.prodSearch(vendObjects.prodManObjects, userWord);
        	Text prodText = new Text(vendObs.getName());
    		prodText.setFont(Font.font("Times New Roman", 20));
       		Text quantText = new Text(String.valueOf(vendObs.getQuantity()));
       		quantText.setFont(Font.font("Times New Roman", 22));
       		Text machText = new Text(vendObs.getMachine());
       		machText.setFont(Font.font("Times New Roman", 22));
        	//Add nodes to GridPane (node, col, row)
       		itemGridDisplay.add(prodText, 0, 1);
       		GridPane.setHalignment(prodText, HPos.CENTER);
       		itemGridDisplay.add(quantText, 1, 1);
        	GridPane.setHalignment(quantText, HPos.CENTER);
       		itemGridDisplay.add(machText, 2, 1);
       		GridPane.setHalignment(machText, HPos.CENTER);
        }
    	
    	else {
    		Text prodText = new Text("Item Not Found");
    		prodText.setFont(Font.font("Times New Roman", 20));
    		itemGridDisplay.add(prodText, 0, 1);
       		GridPane.setHalignment(prodText, HPos.CENTER);
    	}
    		itemGridDisplay.setHgap(50);
        	itemGridDisplay.setVgap(10);
    	return itemGridDisplay;
    }  
    
    //Method for low inventory
    private GridPane lowInven(String VendMachine) {
    	String[] header = {"Product Name","Stock","Location"};
    	GridPane itemGridDisplay = new GridPane();
    	List<Product> vendObs = new ArrayList<Product>();
    	List<Product> neededObs = new ArrayList<Product>();
    	for (int index=0; index < vendObjects.prodManObjects.length; index++) {
    		if (VendMachine.equals(vendObjects.prodManObjects[index].getMachine())){
    			vendObs.add(vendObjects.prodManObjects[index]);
    		}
    	}
    	for (int x=0; x<header.length;x++) {
    		Text prodText = new Text(header[x]);
        	prodText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 24));
        	itemGridDisplay.add(prodText, x, 0);
        	GridPane.setHalignment(prodText, HPos.CENTER);
    	}
    	if (!vendObs.isEmpty()) {
    		for (int index=0;index<vendObs.size(); index++ ){
    			Restock neededStock = new Restock(vendObs.get(index));
    			if (neededStock.itemLow() == true) {
    				neededObs.add(vendObs.get(index));
    			}
    		}	
    	}
    	if (!vendObs.isEmpty()) {
    		for (int index=0;index<neededObs.size(); index++ ){
    			//Create Objects and format the text
				Text prodText = new Text(neededObs.get(index).getName());
	    		prodText.setFont(Font.font("Times New Roman", 20));
	       		Text quantText = new Text(String.valueOf(neededObs.get(index).getQuantity()));
	       		quantText.setFont(Font.font("Times New Roman", 22));
	       		quantText.setFill(Color.RED);
	       		Text locText = new Text(neededObs.get(index).getLocation());
	       		locText.setFont(Font.font("Times New Roman", 22));
	       		
	        	
	        	//Add nodes to GridPane (node, col, row)
	       		itemGridDisplay.add(prodText, 0, index+1);
	       		GridPane.setHalignment(prodText, HPos.CENTER);
	       		itemGridDisplay.add(quantText, 1, index+1);
	        	GridPane.setHalignment(quantText, HPos.CENTER);
	        	itemGridDisplay.add(locText, 2, index+1);
	       		GridPane.setHalignment(locText, HPos.CENTER);
    		}
    	}
    		itemGridDisplay.setHgap(50);
        	itemGridDisplay.setVgap(10);
    	return itemGridDisplay;
    } 
    
    
    
    
    //Method for PO
    private GridPane invenPO(String VendMachine) {
    	double poTotal = 0;
    	int objCnt = 1;
    	String[] header = {"Machine", "Product Type","Quantity","Cost"};
    	GridPane itemGridDisplay = new GridPane();
    	List<Product> vendObs = new ArrayList<Product>();
    	List<Product> neededObs = new ArrayList<Product>();
    	for (int index=0; index < vendObjects.prodManObjects.length; index++) {
    		if (VendMachine.equals(vendObjects.prodManObjects[index].getMachine())){
    			vendObs.add(vendObjects.prodManObjects[index]);
    		}
    	}
    	for (int x=0; x<header.length;x++) {
    		Text prodText = new Text(header[x]);
        	prodText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 18));
        	itemGridDisplay.add(prodText, x, 0);
        	GridPane.setHalignment(prodText, HPos.CENTER);
    	}
    	if (!vendObs.isEmpty()) {
    		for (int index=0;index<vendObs.size(); index++ ){
    			Restock neededStock = new Restock(vendObs.get(index));
    			if (neededStock.getItemDiff() > 0) {
    				neededObs.add(vendObs.get(index));
    			}
    		}	
    	}
    	if (!vendObs.isEmpty()) {
    		
    		for (int index=0;index<neededObs.size(); index++ ){
    			objCnt = objCnt + 1;
    			Restock neededStock = new Restock(neededObs.get(index));
    			//Create Objects and format the text
    			Text machText = new Text(neededObs.get(index).getMachine());
	    		machText.setFont(Font.font("Times New Roman", 16));
				Text prodText = new Text(neededObs.get(index).getName());
	    		prodText.setFont(Font.font("Times New Roman", 16));
	    		int needStock = neededStock.getItemDiff();
	    		double lineCost = (needStock *neededObs.get(index).getPrice());
	       		poTotal = poTotal + lineCost;
	       		Text quantText = new Text(String.valueOf(needStock));
	       		quantText.setFont(Font.font("Times New Roman", 16));
	       		Text costText = new Text("$"+doubleFormat(lineCost));
	       		costText.setFont(Font.font("Times New Roman", 16));
	       		
	        	
	        	//Add nodes to GridPane (node, col, row)
	       		itemGridDisplay.add(machText, 0, index+1);
	       		GridPane.setHalignment(machText, HPos.CENTER);
	       		itemGridDisplay.add(prodText, 1, index+1);
	       		GridPane.setHalignment(prodText, HPos.CENTER);
	       		itemGridDisplay.add(quantText, 2, index+1);
	        	GridPane.setHalignment(quantText, HPos.CENTER);
	        	itemGridDisplay.add(costText, 3, index+1);
	       		GridPane.setHalignment(costText, HPos.CENTER);
    		}
    	}
    		Text totalTxt = new Text("Total");
    		totalTxt.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
    		Text totalAmount = new Text("$"+doubleFormat(poTotal));
    		totalAmount.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
    		itemGridDisplay.add(totalAmount, 3, objCnt);
    		GridPane.setHalignment(totalAmount, HPos.CENTER);
    		itemGridDisplay.add(totalTxt, 2, objCnt);
    		GridPane.setHalignment(totalTxt, HPos.CENTER);
    		itemGridDisplay.setHgap(50);
        	itemGridDisplay.setVgap(10);
    	return itemGridDisplay;
    } 
    
    //Format double
    private String doubleFormat(double dataVar) {
    	DecimalFormat dataFormat = new DecimalFormat("#0.00");
    	return dataFormat.format(dataVar);
    }
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
