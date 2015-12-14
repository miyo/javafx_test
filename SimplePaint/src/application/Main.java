package application;
	
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	
	@FXML
	Canvas canvas;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			URL fxml = getClass().getResource("ui.fxml");
			FXMLLoader ldr = new FXMLLoader(fxml, null);
			ldr.setController(this);
			Scene scene = new Scene(ldr.load());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setOnCloseRequest(x->{
				Platform.exit();
			});
			primaryStage.setResizable(false);
			primaryStage.setTitle("SimpleCalc");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void onSave(ActionEvent ev){
		System.out.println(ev);
		WritableImage img = canvas.snapshot(new SnapshotParameters(), null);
		try{
			File f = new File("test.png");
			ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", f);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void onPut(ActionEvent ev){
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Color c = new Color(Math.random(), Math.random(), Math.random(), 1d);
		gc.setFill(c);
		int x = (int)(Math.random() * canvas.getWidth());
		int y = (int)(Math.random() * canvas.getHeight());
		
		gc.fillRect(x, y, 100, 100);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
