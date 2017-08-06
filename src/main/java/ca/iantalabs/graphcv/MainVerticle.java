package ca.iantalabs.graphcv;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Verticle;

public class MainVerticle extends AbstractVerticle{ 
	
	public void start (Future<Void> future) {
		
		// Defining the server
		Verticle server = new HttpServerVerticle ();
		
		// deploying the server verticle that will engage the services of the server
		vertx.deployVerticle(server);
		
		future.complete();
		
	}

}
