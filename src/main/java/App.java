import dzikiZAfryki.model.AppUser;
import dzikiZAfryki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;

@Transactional
@RestController
public class App {

    //    private static final Logger log = LoggerFactory.getLogger(App.class);
    private static final String CONTEXT_LOCATION = "file:src/main/webapp/WEB-INF/applicationContext.xml";

//    @Autowired
//    private static UserService userService;

    public static void main(String[] args) throws Exception {

//        BasicConfigurator.configure();

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(CONTEXT_LOCATION);
        ctx.refresh();

        UserService userService = ctx.getBean(UserService.class);

        port(80);
        System.out.println(userService.getUserById(2).getName());
        AppUser user = userService.getUserById(3);
        String stringDB = user.getUsername();

        get("/login", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            System.out.println(stringDB);
            try {
                attributes.put("message", user);
                System.out.println("LOGIN");
            } catch (Exception e) {
                Spark.halt(500);
            }
            return new ModelAndView(attributes, "login.ftl");
        }, new FreeMarkerEngine());

        get("/logout", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Logout page");
            System.out.println("LOGOUT");
            return new ModelAndView(attributes, "logout.ftl");
        }, new FreeMarkerEngine());

        get("/register", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Register page");
            return new ModelAndView(attributes, "register.ftl");
        }, new FreeMarkerEngine());

        get("/user", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "AppUser page");
            return new ModelAndView(attributes, "user.ftl");
        }, new FreeMarkerEngine());

        get("/*", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Witaj uzytkowniku");
            return new ModelAndView(attributes, "hello.ftl");
        }, new FreeMarkerEngine());

        ctx.close();

//        ((ClassPathXmlApplicationContext) context).close();
    }
}
