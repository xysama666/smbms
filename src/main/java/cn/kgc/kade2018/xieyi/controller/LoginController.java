package cn.kgc.kade2018.xieyi.controller;

import cn.kgc.kade2018.xieyi.pojo.User;
import cn.kgc.kade2018.xieyi.service.user.UserService;
import cn.kgc.kade2018.xieyi.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {
    @Resource
    UserService userService;

    @RequestMapping("login.do")
    public String login(HttpServletRequest request, Model model, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("login ============ " );
        //获取用户名和密码
        String userCode = request.getParameter("userCode");
        String userPassword = request.getParameter("userPassword");
        //调用service方法，进行用户匹配
        User user = userService.login(userCode,userPassword);
        if(null != user){//登录成功
            //放入session
            request.getSession().setAttribute(Constants.USER_SESSION, user);
            //页面跳转（frame.jsp）
            return "redirect:jsp/frame.jsp";
        }else{
            //页面跳转（login.jsp）带出提示信息--转发
            model.addAttribute("error", "用户名或密码不正确");
            return "forward:login.jsp";

        }

    }
}
