package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.CinemaEBooking.entities.Promotion;
import com.example.Database.DatabaseConnector;

@Controller
public class PromotionHomeController {

    DatabaseConnector db = new DatabaseConnector();

    @RequestMapping(value = "/promotionHome", method = RequestMethod.GET)
    public String showPromotionHomePage(ModelMap model) {
        model.addAttribute("editPromotionForm", new Promotion());

        String[] promotionCodes = db.getAllPromotionCodes();

        for (int i = 0; i < promotionCodes.length && i < 5; i++) {
            String promotionCode = promotionCodes[i];
            String promotion = "promo" + i;
            int promotionPercentOff = db.getPercentOff(promotionCode);
            String promotionStartDate = db.getDateStart(promotionCode);
            String promotionExpirationDate = db.getDateEnd(promotionCode);

            System.out.println(promotion);
            System.out.println(promotionCode);
            System.out.println(promotionPercentOff);
            System.out.println(promotionStartDate);
            System.out.println(promotionExpirationDate);            

            model.addAttribute(promotion, promotion);
            model.addAttribute(promotion + "_code", promotionCode);
            model.addAttribute(promotion + "_percentOff", promotionPercentOff);
            model.addAttribute(promotion + "_startDate", promotionStartDate);
            model.addAttribute(promotion + "_expirationDate", promotionExpirationDate);
            
          }

        return "promotionHome";
    }
    
}
