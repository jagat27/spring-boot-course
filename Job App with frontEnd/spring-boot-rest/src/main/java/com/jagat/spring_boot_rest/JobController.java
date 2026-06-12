package com.jagat.spring_boot_rest;


import com.jagat.spring_boot_rest.model.JobPost;
import com.jagat.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId)
    {
        return service.getJobById(postId);
    }

//    @GetMapping("JobPost/{id}")
//    public JobPost getJob(@PathVariable Integer id) if i dont want to use declared variables then have to use wrapper class Integer
//    {
//        return service.getJobById(postId);
//    }
    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){       //@RequestBody is an important annotation to send data to repo
        service.addJob(jobPost);
        return jobPost;
    }

    @PutMapping("jobPost")
    public void updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
    }


    @DeleteMapping("jobPost/{id}")
    public String deleteJob(@PathVariable int id) {
        service.deleteJob(id);
        return "Job deleted successfully";
    }

    @GetMapping("load")
    public String load(){
        service.load();
        return "success";
    }

//    @GetMapping("jobPosts/keyword/{keyword}")
//    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){       //@PathVariable is used to extract values from the URL path and bind them to method parameters. It can also be used to map a URL variable to a parameter with a different name."
//        return service.search(keyword);
//    }
    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }
}
