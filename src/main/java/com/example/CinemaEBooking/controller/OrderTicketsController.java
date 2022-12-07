package com.example.CinemaEBooking.controller;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.CinemaEBooking.entities.Booking;
import com.example.CinemaEBooking.entities.User;

import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Database.DatabaseConnector;

@Controller
public class OrderTicketsController {

    //Accessing the Database Connector instance
    DatabaseConnector db = DatabaseConnector.getInstance();

    @RequestMapping(value = "/orderTickets",method = RequestMethod.GET )
    public String orderTicks( ModelMap model, @RequestParam int show, HttpServletRequest request){
        model.addAttribute("seatSelect", new Booking());
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        /*if (currentUser == null){
            return "redirect:/userLogin";
        }*/
        String movie = db.getShowTitle(show);
        model.addAttribute("title", movie);
        model.addAttribute("img", db.getPosterURL(movie));
        return "orderTickets";
    }

    @RequestMapping(value = "/orderTickets", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("seatSelect")Booking booking, ModelMap model) {
        int child = booking.getChild();
        System.out.println(child);
        return "viewcart";
    }



    @ModelAttribute("row1")
   public List<String> getRow1() {
      List<String> row1 = new ArrayList<String>();
      row1.add("1A");
      row1.add("1B");
      row1.add("1C");
      row1.add("1D");
      row1.add("1E");
      return row1;
   }

   @ModelAttribute("row2")
   public List<String> getRow2() {
      List<String> row2 = new ArrayList<String>();
      row2.add("2A");
      row2.add("2B");
      row2.add("2C");
      row2.add("2D");
      row2.add("2E");
      return row2;
   }

   @ModelAttribute("row3")
   public List<String> getRow3() {
      List<String> row3 = new ArrayList<String>();
      row3.add("3A");
      row3.add("3B");
      row3.add("3C");
      row3.add("3D");
      row3.add("3E");
      return row3;
   }

   @ModelAttribute("row4")
   public List<String> getRow4() {
      List<String> row4 = new ArrayList<String>();
      row4.add("4A");
      row4.add("4B");
      row4.add("4C");
      row4.add("4D");
      row4.add("4E");
      return row4;
   }
}