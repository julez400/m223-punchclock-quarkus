package ch.zli.m223.punchclock.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;

@Path("/users")
@Tag(name = "User", description = "Haha controlling User")
public class UserController {
    @Inject
    UserService userService;

    /**
     * Creates a list with Users
     * @return returns the list with Users
     */
    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Lists Useres", description = "")
    public List<User> list() {
        return userService.list();
    }

    /**
     * Adds a User
     * @param user the new User
     * @return the added User
     */
    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User add(User user) {
       return userService.add(user);
    }
}