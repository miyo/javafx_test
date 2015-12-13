package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	
	@FXML
	AreaChart areaChart;
	@FXML
	BarChart barChart;
	@FXML
	BubbleChart bubbleChart;
	@FXML
	LineChart<Number, Number> lineChart;
	@FXML
	PieChart pieChart;
	@FXML
	ScatterChart scatterChart;
	@FXML
	StackedAreaChart stackedAreaChart;
	@FXML
	StackedBarChart stackedBarChart;
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
	protected void onButton(ActionEvent ev){
		System.out.println(ev);
		canvasTest();
		pieChartTest();
		lineChartTest();
	}
	
	private void pieChartTest(){
		ObservableList<PieChart.Data> pieChartData =
				FXCollections.observableArrayList(
						new PieChart.Data("Grapefruit", 13),
						new PieChart.Data("Oranges", 25),
						new PieChart.Data("Plums", 10),
						new PieChart.Data("Pears", 22),
						new PieChart.Data("Apples", 30));
		pieChart.setData(pieChartData);
	}
	
	private void lineChartTest(){
		lineChart.setTitle("Stock Monitoring, 2010");
		//defining a series
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		series.setName("My portfolio");
//		populating the series with data
		series.getData().add(new XYChart.Data(1, 23));
		series.getData().add(new XYChart.Data(2, 14));
		series.getData().add(new XYChart.Data(3, 15));
		series.getData().add(new XYChart.Data(4, 24));
		series.getData().add(new XYChart.Data(5, 34));
		series.getData().add(new XYChart.Data(6, 36));
		series.getData().add(new XYChart.Data(7, 22));
		series.getData().add(new XYChart.Data(8, 45));
		series.getData().add(new XYChart.Data(9, 43));
		series.getData().add(new XYChart.Data(10, 17));
		series.getData().add(new XYChart.Data(11, 29));
		series.getData().add(new XYChart.Data(12, 25));
		
		lineChart.getData().add(series);
	}
	
	private void canvasTest(){
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLUE);
		gc.fillRect(75, 75, 100, 100);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
