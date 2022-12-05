package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.CinemaEBooking.entities.Status;
import com.example.CinemaEBooking.entities.User;
import com.example.Database.DatabaseConnector;

@Controller
public class AdminLoginController {

    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();
    int userId;
    String userType;


    @RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
    public String showAdminLoginPage(ModelMap model) {
        model.addAttribute("login", new User());
        return "adminLogin";
    }

    

    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public Object submitAdminLoginIn(@ModelAttribute("login") User userForm, ModelMap model) {
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
            model.addAttribute("message", "Something went wrong. Try Again!");
            break;
            case(-1):System.out.println("Incorrect password");
            model.addAttribute("message", "Incorrect password. Try Again!");
            break;
            case(-2):System.out.println("Email not found");
            model.addAttribute("message", "Email not found. Try Again!");
            break;
            case(-3):System.out.println("Your account was set to INACTIVE");
            model.addAttribute("message", "Your account was set to INACTIVE");
            System.out.println(status);
            break;            
            
            default:

            int userId = loginResult; //once youre logged in, you get your unique UserID returned!
            System.out.println(loginResult);

            boolean isAdmin = db.getUserType(userId);
            
            if(isAdmin == true) {
                userType = "Admin";
                System.out.println("Successfully logged in as an Admin");

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

                    System.out.println(db.getUserStatus(userId));
                    System.out.println(db.getUserLastName(userId));

                    model.put("firstName", currentUser.getFirstName());//whatever is stored in the model will be directly accessible for the view
                    model.put("userId", userId);
                    model.put("currentUser", currentUser);

            return "/adminHome";
            }
            else if (isAdmin == false) {
                userType = "Customer";
                System.out.println("You are not an admin! Please the User Login Feature!");
                model.addAttribute("message", "You are not an Admin. Please use the User Login!");
            return "/adminLogin";
            }
        }
        return "/adminLogin";

   }
    
}
