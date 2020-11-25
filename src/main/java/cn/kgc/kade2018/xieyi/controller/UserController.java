package cn.kgc.kade2018.xieyi.controller;

import cn.kgc.kade2018.xieyi.pojo.User;
import cn.kgc.kade2018.xieyi.service.user.UserService;
import cn.kgc.kade2018.xieyi.service.user.UserServiceImpl;
import cn.kgc.kade2018.xieyi.tools.Constants;
import com.mysql.jdbc.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("user.do")
    private String updatePwd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object o = request.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = request.getParameter("newpassword");
        boolean flag = false;
        if(o != null && !StringUtils.isNullOrEmpty(newpassword)){
            flag = userService.updatePwd(((User)o).getId(),newpassword);
            if(flag){
                request.setAttribute(Constants.SYS_MESSAGE, "修改密码成功,请退出并使用新密码重新登录！");
                request.getSession().removeAttribute(Constants.USER_SESSION);//session注销
            }else{
                request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
            }
        }else{
            request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
        }
        return "forward:pwdmodify";
    }
}
