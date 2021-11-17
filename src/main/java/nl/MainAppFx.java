package nl;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import nl.view.StageReadyEvent;

public class MainAppFx extends Application {
	
private ConfigurableApplicationContext applicationContext;
	
	@Override
	public void init() {
		String[] args = getParameters().getRaw().toArray(new String[0]);
		this.applicationContext = new SpringApplicationBuilder()
				.sources(MainApp.class)
				.run(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		applicationContext.publishEvent(new StageReadyEvent(primaryStage));
		
	}
	
	@Override 
	public void stop() {
		this.applicationContext.close();
		Platform.exit();
	}
}
