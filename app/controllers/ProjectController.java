package controllers;


import models.Project;
import models.User;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import javax.inject.Inject;
import java.util.List;

public class ProjectController extends Controller{


    private FormFactory FormFactory;

    @Inject
    public ProjectController(FormFactory formFactory) {
        this.FormFactory = formFactory;
    }

    @Security.Authenticated(Secured.class)
    public Result projects() {
        List<Project> projectList = Project.getAll();
        User user = User.getWithId(session().get("email"));
        if(user.getRole().equals("employee")) {

        }
    }



}
