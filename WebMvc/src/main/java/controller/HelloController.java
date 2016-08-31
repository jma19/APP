package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloController extends AbstractController{
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String hello=httpServletRequest.getParameter("hello");
        System.out.println("....:"+hello);
        ModelAndView modelAndView=new ModelAndView("index.jsp");
        modelAndView.addObject("helloworld","hello "+hello);

        return modelAndView;
    }

}
