package controllers;

import play.mvc.*;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;

import models.*;

public class AdminAuth extends Action.Simple {
    public CompletionStage<Result> call(Http.Context ctx) {
        String id = ctx.session().get("email");
        if (id != null) {
            User user = Admin.get(id);
            if (user.getRole().equals("admin") && user.getClass().equals(Admin.class)) {
                return delegate.call(ctx);
            }
        }

        ctx.flash().put("error", "Admin Login Required");
        return CompletableFuture.completedFuture(redirect(routes.Login.login()));
    }
}