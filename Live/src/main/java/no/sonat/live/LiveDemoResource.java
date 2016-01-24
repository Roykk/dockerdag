package no.sonat.live;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created 24.01.2016.
 */

@Path("/livedemo")
@Produces(MediaType.APPLICATION_JSON)
public class LiveDemoResource {

    private final String greeting;

    public LiveDemoResource(String greeting) {
        this.greeting = greeting;
    }

    @GET
    @Path("/hello")
    public Response sayHelloSonat() {
        return Response.ok(greeting).build();
    }


    @GET
    @Path("/killComputer")
    public void killComputer() {
        for(int i =0;i<100000;i++){
            new Thread(){
                public void run() {
                    long number = 1;
                    while(true){
                        number = number*2;
                    }
                }
            }.start();
        }
    }
}
