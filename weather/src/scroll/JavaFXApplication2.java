
package scroll;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class JavaFXApplication2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument22.fxml"));
        Scene scene = new Scene(root);
        
        
        //String city="cairo";
        
        //Button b=(Button)event.getSource();
        String city="aswan";
        
        //location
        Text textlocation= (Text) scene.lookup("#textlocation");
        textlocation.setText(city);
        
        //temperature
        Text temp= (Text) scene.lookup("#temp");
        JSONObject weatherData;
        weatherData = WeatherApp.getWeatherData(city);
        double temperature = (double) weatherData.get("temperature");
        temp.setText(Double.toString(temperature) + " ْ C");
        
        
        
        //weathercode
        String weatherCondition = (String) weatherData.get("weather_condition");
        
        Text textweathercondition= (Text) scene.lookup("#textweathercondition");
        textweathercondition.setText(weatherCondition);
        ImageView imgweathercode=(ImageView)scene.lookup("#imgweathercode");
        Image image=new Image("image/clear.png");
         

                
                switch(weatherCondition)
                {
                    case "Clear":
                        image = new Image("image/clear.png");
                        break;
                    case "Cloudy":
                         image = new Image("image/cloudy.png");
                        break;
                    case "Rain":
                        image = new Image("image/rain.png");
                        break;
                    case "Snow":
                         image = new Image("image/snow.png");
                        break;
                }
        imgweathercode.setImage(image);
        
        
        
        //humidity
        long humidity = (long) weatherData.get("humidity");
        Text texthumidity= (Text) scene.lookup("#texthumidity");
        texthumidity.setText(Long.toString(humidity));
        ImageView imghumidity=(ImageView)scene.lookup("#imghumidity");
        imghumidity.setImage(new Image("image/humidity.png"));
        
        
        
        //windspeed
        double windspeed= (double) weatherData.get("windspeed");
        Text textwindspeed= (Text) scene.lookup("#textwindspeed");
        textwindspeed.setText(Double.toString(windspeed));
        ImageView imgwindspeed=(ImageView)scene.lookup("#imgwindspeed");
         imgwindspeed.setImage(new Image("image/windspeed.png"));
        
        /* 
         //binding
         AnchorPane p1=(AnchorPane)scene.lookup("p1");
         ImageView img=(ImageView)scene.lookup("img1");
         
       img.fitWidthProperty().bind(p1.widthProperty());
       img.fitHeightProperty().bind(p1.heightProperty());
        */ 
         
         
         
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
