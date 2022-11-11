package com.example.CinemaEBooking.controller;


import java.io.UnsupportedEncodingException;

import javax.management.MBeanException;
import javax.servlet.http.HttpServletRequest;

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

    

    @RequestMapping(value = "/addPromotion", method = RequestMethod.GET)
    public String showAddPromotionPage(Model model) {
    model.addAttribute("addPromotionForm", new Promotion());
        return "addPromotion";
    }    

    //Add new Promotion
@RequestMapping(value = "/addPromotion", method = RequestMethod.POST)
public Object addPromotion (@ModelAttribute("addPromotionForm") Promotion addPromotionForm, BindingResult bindingResult,
Model model, HttpServletRequest request) throws UnsupportedEncodingException, MBeanException {

                                    String promotionName = addPromotionForm.getPromotionName();
                                    String description = addPromotionForm.getDescription();
                                    String startDate = addPromotionForm.getStartDate();
                                    String expirationDate = addPromotionForm.getExpirationDate();
                                    String code = addPromotionForm.getCode(); 

        
        System.out.println("Movie created with title:" + promotionName);



    return "redirect:/editPromotion";
}
}
