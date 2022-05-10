package cmpe318_hw2_18244710060;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CMPE318_HW2_18244710060 extends Application {
    
   
    
    Pane pane,paneTwo;
    Pane panePlay;
    ComboBox playerOneBox;
    ComboBox playerTwoBox;
    
    Label typeOne,typeTwo,powerOne,powerTwo,p1,p2;
    int playerOnePower,playerTwoPower;
    Button fight;
    int score=0;
    //image view
    
    String path= "C:\\Users\\merti\\Documents\\NetBeansProjects\\CMPE318_HW2_18244710060\\src\\pokemons\\";
  
    ImageView playerOneImage;
    ImageView playerTwoImage;
    Image imOne;
    Image imTwo;
    Image win;
   
    FileInputStream input;
    FileInputStream input2;
  
    
    
    @Override
    public void start(Stage primaryStage) {
        
       
        typeOne = new Label();
        typeTwo = new Label();
        powerOne = new Label();
        powerTwo = new Label();
        p1 = new Label("Player 1");
        playerOneBox = new ComboBox();
        playerOneBox.getItems().add("Alakazam");
        playerOneBox.getItems().add("Arbok");
        playerOneBox.getItems().add("Eevee");
        playerOneBox.getItems().add("Gengar");
        playerOneBox.getItems().add("Starmie");
        
        p2 = new Label("Player 2");
        playerTwoBox = new ComboBox();
        playerTwoBox.getItems().add("Clefairy");
        playerTwoBox.getItems().add("Lapras");
        playerTwoBox.getItems().add("Squirtle");
        playerTwoBox.getItems().add("Butterfree");
        playerTwoBox.getItems().add("Jigglypuff");
        
        playerOneBox.setOnAction((event)->
        {
            String character = playerOneBox.getValue().toString().toLowerCase();
            try {
                input = new FileInputStream(path + character + ".png");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            if(character.equals("alakazam"))
            {
                typeOne.setText("Type:Psychic");
                powerOne.setText("Power:40");
                playerOnePower=40;
            }
            
             if(character.equals("arbok"))
            {
                typeOne.setText("Type:Poison");
                powerOne.setText("Power:19");
                playerOnePower=19;
            }
             
             if(character.equals("eevee"))
            {
                typeOne.setText("Type:Normal");
                powerOne.setText("Power:21");
                playerOnePower=21;
            }
             
             if(character.equals("gengar"))
            {
                typeOne.setText("Type:Ghost, Poison");
                powerOne.setText("Power:45");
                playerOnePower=45;
            }
             
             if(character.equals("starmie"))
            {
                typeOne.setText("Type:Water, Psychic");
                powerOne.setText("Power:25");
                playerOnePower=25;
            } 
            
            imOne = new Image(input);
            playerOneImage.setImage(imOne);
        });
        
        
      
        playerTwoBox.setOnAction((event)->
        {
            String characterTwo = playerTwoBox.getValue().toString().toLowerCase();
            try {
                input2 = new FileInputStream(path + characterTwo + ".png");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            
             if(characterTwo.equals("clefairy"))
            {
                typeTwo.setText("Type:Fairy");
                powerTwo.setText("Power:12");
                playerTwoPower=12;
            } 
             
             if(characterTwo.equals("lapras"))
            {
                typeTwo.setText("Type:Water, Ice ");
                powerTwo.setText("Power:34");
                playerTwoPower=34;
            } 
            
            
              if(characterTwo.equals("squirtle"))
            {
                typeTwo.setText("Type:Water");
                powerTwo.setText("Power:27");
                playerTwoPower=27;
            } 
              
             if(characterTwo.equals("butterfree"))
            {
                typeTwo.setText("Type:Bug, Flying");
                powerTwo.setText("Power:17");
                playerTwoPower=25;
            }   
             
              if(characterTwo.equals("jigglypuff"))
            {
                typeTwo.setText("Type:Normal, Fairy");
                powerTwo.setText("Power:9");
                playerTwoPower=9;
            }  

            imTwo = new Image(input2);
            playerTwoImage.setImage(imTwo);
        });
        
        
        fight = new Button("PLAY");
        fight.setPrefSize(250, 100);
        fight.prefHeight(50);
        fight.prefWidth(300);
        fight.setAlignment(Pos.CENTER);
       
        fight.setOnAction((ActionEvent event) ->
        {
            
            if(playerOnePower>playerTwoPower)
            {
                try {
                input2 = new FileInputStream(path + "winner.png");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
                
            imTwo = new Image(input2);
            playerTwoImage.setImage(imTwo);
            }
            
            if(playerOnePower<playerTwoPower)
            {
                try {
                input = new FileInputStream(path + "winner.png");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
                
            imOne = new Image(input);
            playerOneImage.setImage(imOne);
            }
           
        });
        
        
        
        try 
        {
            input = new FileInputStream(path + "pokeball.png");
            input2 = new FileInputStream(path + "pokeball.png");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        imOne = new Image(input);
        imTwo = new Image(input2);
        
        playerOneImage = new ImageView(imOne);
        playerOneImage.setFitHeight(200);
        playerOneImage.setFitWidth(200);
        
        
        playerTwoImage = new ImageView(imTwo);
        playerTwoImage.setFitHeight(200);
        playerTwoImage.setFitWidth(200);
        
        
        
        VBox vBoxOne = new VBox();
        vBoxOne.getChildren().addAll(p1,playerOneBox,typeOne,powerOne);
        VBox vBoxTwo= new VBox();
        vBoxTwo.getChildren().addAll(p2,playerTwoBox,typeTwo,powerTwo);
        HBox hBoxFight = new HBox();
        hBoxFight.getChildren().add(fight);
        hBoxFight.setAlignment(Pos.CENTER);
        
        
        pane = new Pane();
        pane.setPrefSize(200, 200);
        pane.getChildren().add(playerOneImage);
        paneTwo =new Pane();
        paneTwo.setPrefSize(200, 200);
        paneTwo.getChildren().add(playerTwoImage);
        
        
        BorderPane borderCenter= new BorderPane();
        borderCenter.setRight(paneTwo);
        borderCenter.setLeft(pane);
        BorderPane border = new BorderPane();       
        border.setLeft(vBoxOne);
        border.setRight(vBoxTwo);
        border.setCenter(borderCenter);
        border.setBottom(hBoxFight);
        
     
  
        
        
        Scene scene = new Scene(border, 800, 325);
        
        primaryStage.setTitle("Pokemon Tournament");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
