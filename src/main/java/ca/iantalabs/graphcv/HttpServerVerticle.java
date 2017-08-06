package ca.iantalabs.graphcv;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

// Provides a REST interface for the other services of the server
public class HttpServerVerticle extends AbstractVerticle {
	
	public void start(Future<Void> future) {
		
		// Create vertex server  
		HttpServer server = vertx.createHttpServer();
		
		// Create vertex router 
		Router router = Router.router(vertx);
		
		// Define the video transformation route for  
		Route transform = router.route(HttpMethod.POST, "/graph-stream/");
		
		transform.handler(routingContext -> {
			
			HttpServerRequest request = routingContext.request();
			
			request.response().end(Json.encode(new JsonObject().put("msg", "Hello World!")));
			
		});
		
		server.requestHandler(router::accept).listen(8080);
		
		future.complete();
		
	}

}
