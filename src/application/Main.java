package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Main extends Application {
	
    @FXML
    private Label labelTitulo;
    
    @FXML
    private Label labelAutor;
    
    @FXML
    private Label labelSemilla;
    
    @FXML
    private TextField textSemilla;
    
    @FXML
    private Label labelPrecision;
    
    @FXML
    private TextField textPrecision;
    
    @FXML
    private Label labelCoefA0;
    
    @FXML
    private TextField textCoefA0;
    
    @FXML
    private Label labelCoefA1;
    
    @FXML
    private TextField textCoefA1;
    
    @FXML
    private Label labelCoefA2;
    
    @FXML
    private TextField textCoefA2;

    @FXML
    private Label labelCoefA3;
    
    @FXML
    private TextField textCoefA3;
    
    @FXML
    private Label labelCoefA4;

    @FXML
    private TextField textCoefA4;
    
    @FXML
    private Button botonCalcular;
    
    @FXML
    private Label labelRaiz;
    
    @FXML
    private TextField textRaiz;
    
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/Interfaz.fxml"));
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Newton");
            primaryStage.setScene(scene);
            scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
            primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void newton(ActionEvent event) {
	    try {
	    	double semilla = Double.valueOf(textSemilla.getText());
		    double precision = Double.valueOf(textPrecision.getText());
		    double coefA0 = Double.valueOf(textCoefA0.getText());
		    double coefA1 = Double.valueOf(textCoefA1.getText());
		    double coefA2 = Double.valueOf(textCoefA2.getText());
		    double coefA3 = Double.valueOf(textCoefA3.getText());
		    double coefA4 = Double.valueOf(textCoefA4.getText());
		    
			double a;
			double numFuncion;
			double numFuncionDerivada;
			double precisionObtenida;
			
			do {
				numFuncion = (coefA4 * semilla * semilla * semilla * semilla
						+ coefA3 * semilla * semilla * semilla
						+ coefA2 * semilla * semilla
						+ coefA1 * semilla
						+ coefA0);
				
				numFuncionDerivada = (4 * coefA4 * semilla * semilla * semilla
						+ 3 * coefA3 * semilla * semilla
						+ 2 * coefA2 * semilla 
						+ 1 * coefA1);
				
				a = semilla - (numFuncion)/(numFuncionDerivada);
				
				precisionObtenida = Math.abs(semilla - a);
				
				semilla = a;
			} while (precisionObtenida > precision);
		    textRaiz.setText(a + "");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	textRaiz.setText("Error! Revise los datos.");
	    }
	    
	}
	
	
}
