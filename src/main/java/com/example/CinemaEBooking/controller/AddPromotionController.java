package com.example.CinemaEBooking.controller;


import java.io.UnsupportedEncodingException;

import javax.management.MBeanException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.CinemaEBooking.entities.Promotion;
import com.example.Database.DatabaseConnector;

@Controller
public class AddPromotionController {

    private DatabaseConnector db = new DatabaseConnector();
    //private SendEMailController emailController = new SendEMailController();
   
    @Autowired
    private JavaMailSender javaMailSender;
    String[] promotionMailAddresses;
    

    @RequestMapping(value = "/addPromotion", method = RequestMethod.GET)
    public String showAddPromotionPage(Model model) {
    model.addAttribute("addPromotionForm", new Promotion());
        return "addPromotion";
    }    

    //Add new Promotion
@RequestMapping(value = "/addPromotion", method = RequestMethod.POST)
public Object addPromotion (@ModelAttribute("addPromotionForm") Promotion addPromotionForm, BindingResult bindingResult,
Model model, HttpServletRequest request) throws UnsupportedEncodingException, MBeanException {

                                    int percentOff = addPromotionForm.getPercentOff();
                                    String startDate = addPromotionForm.getStartDate();
                                    String expirationDate = addPromotionForm.getExpirationDate();
                                    String code = addPromotionForm.getCode(); 
                                         
        
        db.createDraftPromotion(startDate, expirationDate, percentOff, code);
          System.out.println("Promotion created with starting date: " + startDate + " and Expiration Date: " + expirationDate);
          System.out.println("Use code " + code + " to get -" + percentOff + " off!");

        //emailController.sendPromotionEmail(startDate, expirationDate, percentOff, code);
        //sendPromotionEmail(startDate, expirationDate, percentOff, code);

        return "redirect:/viewPromotion";
    }


    void sendPromotionEmail(String startDate, String expirationDate, int percentOff, String code) {

        SimpleMailMessage msg = new SimpleMailMessage();
        promotionMailAddresses = db.getAllPromotionEmails();
    
        
        for (int i=0; i < promotionMailAddresses.length; i++) {
            System.out.println(promotionMailAddresses[i]);
            msg.setTo(promotionMailAddresses[i]);

            msg.setSubject("New Promotion available");
            msg.setText("A new promotion has just been released!      It is active from " + startDate + " until " + expirationDate + "!  Make sure to use code " + code +" to get your -" + percentOff + "% when buying your tickets!");
        
            javaMailSender.send(msg);
        }
    }
    
    
}

