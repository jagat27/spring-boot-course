package com.jagat.spring_boot_rest;


import com.jagat.spring_boot_rest.model.JobPost;
import com.jagat.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("JobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("JobPost/{postId}")
    public JobPost getJob(@PathVariable int postId)
    {
        return service.getJobById(postId);
    }

//    @GetMapping("JobPost/{id}")
//    public JobPost getJob(@PathVariable Integer id) if i dont want to use declared variables then have to use wrapper class Integer
//    {
//        return service.getJobById(postId);
//    }
    @PostMapping("JobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){       //@RequestBody is an important annotation to send data to repo
        service.addJob(jobPost);
        return jobPost;
    }

    @PutMapping("JobPost")
    public void updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
    }


    @DeleteMapping("JobPost/{postId}")
    public void deleteJob(@PathVariable int postId){
        service.deleteJob(postId);

    }
}
