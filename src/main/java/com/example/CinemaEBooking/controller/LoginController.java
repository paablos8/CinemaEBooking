package com.example.CinemaEBooking.controller;

import com.example.Database.DatabaseConnector;
import com.example.CinemaEBooking.entities.Status;
import com.example.CinemaEBooking.entities.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("currentUser")
public class LoginController {
   
    DatabaseConnector db = new DatabaseConnector();
    int userId;
    String userType;


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

        Status status = Status.ACTIVE;
        db.changeStatus(userId, status);
        System.out.println(status);

        int loginResult = db.verifyLogin(email, password);

        switch(loginResult)
        {
            case(0):System.out.println("Something went wrong");
            break;
            case(-1):System.out.println("Incorrect password");
            break;
            case(-2):System.out.println("Email not found");
            break;
            case(-3):System.out.println("Your account was set to INACTIVE");
            System.out.println(status);
            break;


            //we have to implement another case, where the logged-in user is an admin         
            default:System.out.println("Successfully logged in");
            int userId = loginResult; //once youre logged in, you get your unique UserID returned!
            System.out.println(loginResult);
            
            //pull values for the current user session from the database, after he is successfully logged-in
            User currentUser = db.createUserObject(userId);
            currentUser.setFirstName(db.getUserFirstName(userId));
            currentUser.setLastName(db.getUserLastName(userId));
            currentUser.setStatus(db.getUserStatus(userId));
            currentUser.setStreet(db.getStreetAddress(userId));
            currentUser.setPhone(db.getUserPhoneNumber(userId));
            currentUser.setState(db.getStateRegion(userId));
            currentUser.setCity(db.getCityCounty(userId));
            currentUser.setCountry(db.getCountry(userId));
            currentUser.setZipCode(db.getZipCode(userId));

            //currentUser.setPhone(db.getUserPhoneNumber(userId));

            System.out.println(db.getUserStatus(userId));
            System.out.println(db.getUserLastName(userId));
            


           
            
            /*
            boolean isAdmin = db.getUserType(userId);
            
            if(isAdmin == true) {
                userType = "Admin";
            }
            else if (isAdmin == false) {
                userType = "Customer";
            }
            */

            model.put("firstName", currentUser.getFirstName());//whatever is stored in the model will be directly accessible for the view
            model.put("userId", userId);
            model.put("currentUser", currentUser);

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