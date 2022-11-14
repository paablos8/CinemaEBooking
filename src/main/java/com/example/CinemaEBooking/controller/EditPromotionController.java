package com.example.CinemaEBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CinemaEBooking.entities.Promotion;
import com.example.Database.DatabaseConnector;

@Controller
public class EditPromotionController {

    DatabaseConnector db = new DatabaseConnector();

    @RequestMapping(value = "/viewPromotion", method = RequestMethod.GET)
    public String showAddPromotionPage(ModelMap model) {

        model.addAttribute("editPromotionForm", new Promotion());

        String[] promotionCodes = db.getAllPromotionCodes();

        for (int i = 0; i < promotionCodes.length && i < 5; i++) {
            String promotionCode = promotionCodes[i];
            String promotionName = "promo" + i;
            int promotionPercentOff = db.getPercentOff(promotionCode);
            String promotionStartDate = db.getDateStart(promotionCode);
            String promotionExpirationDate = db.getDateEnd(promotionCode);

            System.out.println(promotionName);
            System.out.println(promotionCode);
            System.out.println(promotionPercentOff);
            System.out.println(promotionStartDate);
            System.out.println(promotionExpirationDate);            


            model.addAttribute(promotionName, promotionCode);
            model.addAttribute(promotionName + "_percentOff", promotionPercentOff);
            model.addAttribute(promotionName + "_startDate", promotionStartDate);
            model.addAttribute(promotionName + "_expirationDate", promotionExpirationDate);
            
          }

        return "viewPromotion";
    }


    @RequestMapping(value = "/editPromotion", method = RequestMethod.GET)
    public String showEditPromotionPage(ModelMap model, @RequestParam String promotion) {
        model.addAttribute("editPromotionForm", new Promotion());
        model.addAttribute("code", promotion);

        int percentOff = db.getPercentOff(promotion);
        String startDate = db.getDateStart(promotion);
        String expriationDate = db.getDateEnd(promotion);

        System.out.println(percentOff);
        System.out.println(startDate);
        System.out.println(expriationDate);

        model.addAttribute("percentOff", percentOff);
        model.addAttribute("startDate", startDate);
        model.addAttribute("expirationDate", expriationDate);
        
        return "editPromotion";
    }
}
