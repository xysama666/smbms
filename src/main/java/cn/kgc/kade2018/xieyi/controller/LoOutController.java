package cn.kgc.kade2018.xieyi.controller;

import cn.kgc.kade2018.xieyi.service.user.UserService;
import cn.kgc.kade2018.xieyi.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoOutController {


    @RequestMapping("logout.do")
    public String logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //清除session
        request.getSession().removeAttribute(Constants.USER_SESSION);
        return "redirect:"+request.getContextPath()+"/login.jsp";

    }
}
