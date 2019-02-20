package action;

import org.apache.commons.beanutils.BeanUtils;
import services.UserService;
import vo.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
            UserService us = new UserService();
            User dbuser = us.loginUser(user);
            if(dbuser!=null){
                Cookie cookie = new Cookie("markuser",user.getUser());
                cookie.setPath("/");
                cookie.setMaxAge(60*60*12);
                response.addCookie(cookie);
                request.getSession().setAttribute("loginUser",dbuser);
                response.sendRedirect(request.getContextPath()+"/info.jsp");
            }else {
                request.setAttribute("errorMsg", "登录失败，用户名或密码错误");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
