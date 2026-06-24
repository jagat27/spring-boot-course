package com.jagat.JobApp;

import com.jagat.JobApp.model.JobPost;
import com.jagat.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class homeController {

    @Autowired
    private JobService service;

    @GetMapping({"/","home"})
    public String home(){
        //System.out.println("in home page...");
        return "home";
    }

    @GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleFrom(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model m){
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts",jobs);
        return "viewalljobs";
    }

    @GetMapping("load")
    public String load(){
        service.load();
        return "success";
    }
}
