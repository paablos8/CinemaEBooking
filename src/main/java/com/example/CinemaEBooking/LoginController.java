package com.example.CinemaEBooking;

import com.example.Database.DatabaseConnector;
import com.example.CinemaEBooking.entities.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userId")
public class LoginController {
   
    DatabaseConnector db = new DatabaseConnector();
    int userId;


    

    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        model.addAttribute("login", new User());
        return "userLogin";
    }


    
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public Object submitLoginIn(@ModelAttribute("login") User userForm, ModelMap model) {
        String email = userForm.getEmail();
        String password = userForm.getPassword();
        System.out.println(email);
        //whatever is stored in the model will be directly accessible for the view

        int loginResult = db.verifyLogin(email, password);

        switch(loginResult)
        {
            case(0):System.out.println("Something went wrong");
            break;
            case(-1):System.out.println("Incorrect password");
            break;
            case(-2):System.out.println("Email not found");
            break;
            default:System.out.println("Successfully logged in");
            int userId = loginResult; //once youre logged in, you get your unique UserID returned!
            User currentUser = db.createUserObject(userId);
            String firstName = db.getUserFirstName(userId);
            //boolean isAdmin = db.getUserType(userId);
            
            /*
            if(isAdmin == true) {
                userType = "Admin";
            }
            else if (isAdmin == false) {
                userType = "Customer";
            }
            */
            model.put("firstName", firstName);//whatever is stored in the model will be directly accessible for the view
            model.put("userId", userId);

            return "/loginSuccess";
            
        }
        return "/userLogin";

   }
    

    //"Sign-in"-button gets pressed & the controller returns the "loginSuccess"-File
    @RequestMapping("/loginSuccess")
    public ModelAndView loginSuccess (ModelAndView model) {
        model.setViewName ("loginSuccess");

        return model;
    }
    
}