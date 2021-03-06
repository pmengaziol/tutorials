package com.stackify.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stackify.daos.UserDAO;
import com.stackify.models.User;

@Path("/users")
public class UserService {
    private UserDAO userDao = new UserDAO();
    
    public UserService (){
        userDao.createTable();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        userDao.add(user);
        return Response.ok()
            .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userDao.findAll();
    }
}
