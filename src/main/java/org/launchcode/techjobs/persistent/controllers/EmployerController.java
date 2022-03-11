package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    // TODO Add a private field of EmployerRepository type called employerRepository to EmployerController
    // TODO Add an index method that responds at /employers with a list of all employers in the database.
//    @Autowired
//    private employerRepository


    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    // TODO  processAddEmployerForm does not yet contain the code to save a valid object. Use
    //  employerRepository and the appropriate method to do so.
    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }

        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        // TODO 3
        Optional optEmployer = null;
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }
}
