package com.cperceful.controllers;

import com.cperceful.models.Danism;
import com.cperceful.models.data.DanismDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Controller for handling root requests
 */

@Controller
public class IndexController {

    @Autowired
    private DanismDao danismDao;

    @RequestMapping("")
    public String index(Model model){

        model.addAttribute("title", "Things Dan Says");
        model.addAttribute("danisms", danismDao.findAll());
        return "index/index";
    }

    @RequestMapping(value = "submit", method = RequestMethod.GET)
    public String submit(Model model){

        model.addAttribute("title", "Submit A Danism");
        model.addAttribute(new Danism());

        return "index/submit";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute @Valid Danism newDanism, Errors errors){

        if (errors.hasErrors()){
            return "index/submit";
        }

        danismDao.save(newDanism);

        return "redirect:";
    }
}
