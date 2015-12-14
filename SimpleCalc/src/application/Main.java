package application;
	
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
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
import javafx.scene.image.WritableImage;
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
	LineChart<String, Number> lineChart;
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
		areaChartTest();
		barChartTest();
		bubbleChartTest();
		scatterChartTest();
		stackedAreaChartTest();
		stackedBarChartTest();
	}
	
	private void pieChartTest(){
		ObservableList<PieChart.Data> pieChartData =
				FXCollections.observableArrayList(
						new PieChart.Data("Grapefruit", 13),
						new PieChart.Data("Oranges", 25),
						new PieChart.Data("Plums", 10),
						new PieChart.Data("Pears", 22),
						new PieChart.Data("Apples", 30));
		pieChart.getData().clear();
		pieChart.setData(pieChartData);
	}
	
	private void areaChartTest(){
		areaChart.setTitle("Stock Monitoring, 2010");
		//defining a series
		XYChart.Series<String, Number> series = new XYChart.Series<>();
		series.setName("My portfolio");
//		populating the series with data
		series.getData().add(new XYChart.Data("1", 23));
		series.getData().add(new XYChart.Data("2", 14));
		series.getData().add(new XYChart.Data("3", 15));
		series.getData().add(new XYChart.Data("4", 24));
		series.getData().add(new XYChart.Data("5", 34));
		series.getData().add(new XYChart.Data("6", 36));
		series.getData().add(new XYChart.Data("7", 22));
		series.getData().add(new XYChart.Data("8", 45));
		series.getData().add(new XYChart.Data("9", 43));
		series.getData().add(new XYChart.Data("10", 17));
		series.getData().add(new XYChart.Data("11", 29));
		series.getData().add(new XYChart.Data("12", 25));
		
		areaChart.getData().clear();
		areaChart.getData().add(series);
	}

	private void barChartTest(){
		barChart.setTitle("Stock Monitoring, 2010");
		//defining a series
		XYChart.Series<String, Number> series = new XYChart.Series<>();
		series.setName("My portfolio");
//		populating the series with data
		series.getData().add(new XYChart.Data("1", 23));
		series.getData().add(new XYChart.Data("2", 14));
		series.getData().add(new XYChart.Data("3", 15));
		series.getData().add(new XYChart.Data("4", 24));
		series.getData().add(new XYChart.Data("5", 34));
		series.getData().add(new XYChart.Data("6", 36));
		series.getData().add(new XYChart.Data("7", 22));
		series.getData().add(new XYChart.Data("8", 45));
		series.getData().add(new XYChart.Data("9", 43));
		series.getData().add(new XYChart.Data("10", 17));
		series.getData().add(new XYChart.Data("11", 29));
		series.getData().add(new XYChart.Data("12", 25));
		
		barChart.getData().clear();
		barChart.getData().add(series);
	}

	private void bubbleChartTest(){
		bubbleChart.setTitle("Stock Monitoring, 2010");
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
		
		bubbleChart.getData().clear();
		bubbleChart.getData().add(series);
	}

	private void scatterChartTest(){
		scatterChart.setTitle("Stock Monitoring, 2010");
		//defining a series
		XYChart.Series<String, Number> series = new XYChart.Series<>();
		series.setName("My portfolio");
//		populating the series with data
		series.getData().add(new XYChart.Data("1", 23));
		series.getData().add(new XYChart.Data("2", 14));
		series.getData().add(new XYChart.Data("3", 15));
		series.getData().add(new XYChart.Data("4", 24));
		series.getData().add(new XYChart.Data("5", 34));
		series.getData().add(new XYChart.Data("6", 36));
		series.getData().add(new XYChart.Data("7", 22));
		series.getData().add(new XYChart.Data("8", 45));
		series.getData().add(new XYChart.Data("9", 43));
		series.getData().add(new XYChart.Data("10", 17));
		series.getData().add(new XYChart.Data("11", 29));
		series.getData().add(new XYChart.Data("12", 25));
		
		scatterChart.getData().clear();
		scatterChart.getData().add(series);
	}

	private void lineChartTest(){
		lineChart.setTitle("Stock Monitoring, 2010");
		//defining a series
		XYChart.Series<String, Number> series = new XYChart.Series<>();
		series.setName("My portfolio");
//		populating the series with data
		series.getData().add(new XYChart.Data("1", 23));
		series.getData().add(new XYChart.Data("2", 14));
		series.getData().add(new XYChart.Data("3", 15));
		series.getData().add(new XYChart.Data("4", 24));
		series.getData().add(new XYChart.Data("5", 34));
		series.getData().add(new XYChart.Data("6", 36));
		series.getData().add(new XYChart.Data("7", 22));
		series.getData().add(new XYChart.Data("8", 45));
		series.getData().add(new XYChart.Data("9", 43));
		series.getData().add(new XYChart.Data("10", 17));
		series.getData().add(new XYChart.Data("11", 29));
		series.getData().add(new XYChart.Data("12", 25));
		
		lineChart.getData().clear();
		lineChart.getData().add(series);
	}
	
	private void stackedAreaChartTest(){
		stackedAreaChart.setTitle("Stock Monitoring, 2010");
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
		
		stackedAreaChart.getData().add(series);
	}

	private void stackedBarChartTest(){
		stackedBarChart.setTitle("Stock Monitoring, 2010");
		//defining a series
		XYChart.Series<String, Number> series = new XYChart.Series<>();
		series.setName("My portfolio");
//		populating the series with data
		series.getData().add(new XYChart.Data("1", 23));
		series.getData().add(new XYChart.Data("2", 14));
		series.getData().add(new XYChart.Data("3", 15));
		series.getData().add(new XYChart.Data("4", 24));
		series.getData().add(new XYChart.Data("5", 34));
		series.getData().add(new XYChart.Data("6", 36));
		series.getData().add(new XYChart.Data("7", 22));
		series.getData().add(new XYChart.Data("8", 45));
		series.getData().add(new XYChart.Data("9", 43));
		series.getData().add(new XYChart.Data("10", 17));
		series.getData().add(new XYChart.Data("11", 29));
		series.getData().add(new XYChart.Data("12", 25));
		
		stackedBarChart.getData().add(series);
	}
	
	@FXML
	protected void onSave(ActionEvent ev){
		Node[] nodes = new Node[]{
				areaChart, 
				barChart,
				bubbleChart,
				lineChart,
				pieChart,
				scatterChart,
				stackedAreaChart,
				stackedBarChart,
				canvas};
		for(Node n: nodes){
			String base = n.getClass().getName();
			WritableImage img = n.snapshot(new SnapshotParameters(), null);
			try{
				saveImage(img, base, "png");
				saveImage(img, base, "jpg");
				saveAsPDF(img, base);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	private boolean saveImage(WritableImage img, String base, String fmt) throws IOException{
		File f = new File(base + "." + fmt);
		return ImageIO.write(SwingFXUtils.fromFXImage(img, null), fmt, f);
	}	

	private void saveAsJpeg(WritableImage img, String base) throws IOException{
		File f = new File(base + ".jpg");
		boolean flag = ImageIO.write(SwingFXUtils.fromFXImage(img, null), "jpg", f);
	}
		
	private void saveAsPDF(WritableImage img, String base) throws IOException{
	    PDDocument doc = null;
	    PDPage page = null;
	    PDImageXObject ximage = null;

	    try {
	        doc = new PDDocument();
	        page = new PDPage();
	        doc.addPage(page);
	        PDPageContentStream content = new PDPageContentStream(doc, page);
	        ximage = LosslessFactory.createFromImage(doc, SwingFXUtils.fromFXImage(img, null));
	        content.drawImage(ximage, 20, 20);
	        content.close();
	    } catch(IOException ie) {
	    }
	    doc.save(new File("test.pdf"));
	    doc.close();		
	}

	
	private void canvasTest(){
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
