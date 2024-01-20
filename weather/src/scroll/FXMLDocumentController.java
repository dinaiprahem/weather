/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scroll;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.json.simple.JSONObject;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

/**
 *
 * @author Norhan
 */
public class FXMLDocumentController implements Initializable {
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView imgaswan;
    @FXML
    private ImageView imgasut;
    @FXML
    private ImageView imgalex;
    @FXML
    private ImageView imgismailia;
    @FXML
    private ImageView imgaqsr;
    @FXML
    private ImageView imdahmr;
    @FXML
    private ImageView imgbehera;
    @FXML
    private ImageView imggiza;
    @FXML
    private ImageView imgdaqahlya;
    @FXML
    private ImageView imgswas;
    @FXML
    private ImageView imgsharqua;
    @FXML
    private Button button;
    
    
     public void backevent(ActionEvent event) throws IOException
   {
       System.out.println("nnnnnnnnnnnnnn");
   }
    
     
     
    public void handleButtonAction(ActionEvent event) throws IOException
    {
         root = FXMLLoader.load(getClass().getResource("FXMLDocument22.fxml"));
         stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         
         
       
       
        
        
        //بجيب انهى بوتن اتكيت عليه بعدين اجيب التيكست الى عليه الى هو اسم المحافظه
        Button b=(Button)event.getSource();
        String city=b.getId();
        city = city.replaceAll("_", "+");
        
        //location
        Text textlocation= (Text) scene.lookup("#textlocation");
        textlocation.setText(toUpperCase(city));
        
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
        texthumidity.setText(Long.toString(humidity)+"%");
        ImageView imghumidity=(ImageView)scene.lookup("#imghumidity");
        imghumidity.setImage(new Image("image/humidity.png"));
        
        
        
        //windspeed
        double windspeed= (double) weatherData.get("windspeed");
        Text textwindspeed= (Text) scene.lookup("#textwindspeed");
        textwindspeed.setText(Double.toString(windspeed)+"Km/h");
        ImageView imgwindspeed=(ImageView)scene.lookup("#imgwindspeed");
         imgwindspeed.setImage(new Image("image/windspeed.png"));
        
         
         
    
         
        stage.setScene(scene);
        stage.show();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}