package com.auth.authenticationSystem;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getData() {
        return 	Connection.fetchRecord();	
    }
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String setData(Student student) {
         Connection.insertRecord(student);
         return "Save successfull";
    }

	/*
	 * @PUT
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public List<Student> updateData(Student
	 * student) { return }
	 */
    @Path("/login")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
	public String verifyData(Student student) {
		int successMsg = Connection.verifyData(student);
		if (successMsg == 1) {
        	long nowMillis=86400000;
			String token=Middleware.createJWT(student.getName(), nowMillis);
			return token;
		}
		else
			return "user not exist";
	}

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> deleteData(@QueryParam("Age") int age) {
        return  Connection.deleteRecord(age);
    }
}
