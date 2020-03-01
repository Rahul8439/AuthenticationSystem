package com.auth.authenticationSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.jsonwebtoken.Claims;


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
    	int exist=Connection.verifyData(student);
    	if(exist==0) {
    		Connection.insertRecord(student);
         return "Save successfull";
    	}
    	else 
    		return "user already exist";
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
    
    @Path("auth")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
	public String auth(@HeaderParam("AccessToken")String token ,Student student) {
			Claims map=Middleware.decodeJWT(token); 
			String username=(String) map.get("sub");
			String name=student.getName();
			boolean existency=username.equals(name);
			if(existency) {
				return "Valid user";}
			else {
				return "Invalid user";
			}
		}
		

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> deleteData(@QueryParam("Age") int age) {
        return  Connection.deleteRecord(age);
    }
}
