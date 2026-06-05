package com.jagat.SpringBootWebApp1;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    //@GetMapping("/")
    public String home()
    {
        System.out.println("in home page...");
        return "index";
    }

    @RequestMapping("add")
//    public String add(@RequestParam("num1") int a,@RequestParam("num2") int b, HttpSession session){      // Servlet way of handling requests
    public ModelAndView add(@RequestParam("num1") int a, @RequestParam("num2") int b, ModelAndView mv){

//        int a = Integer.parseInt(req.getParameter("num1"));
//        int b = Integer.parseInt(req.getParameter("num2"));
        int result = a+b;

        //session.setAttribute("result",result);
        //model.addAttribute("result",result);
        mv.addObject("result",result);
        mv.setViewName("result");

        //System.out.println(result);
        return mv;
    }

}
