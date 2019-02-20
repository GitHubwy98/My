package action;

import com.google.gson.Gson;
import services.JugeUser;
import services.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JugeUserServlet",urlPatterns = "/ju")
public class JugeUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String s = request.getParameter("name");
        UserService us = new UserService();
        JugeUser ju = new JugeUser();
        boolean b = us.jugeUser(s);
        if (b){
            ju.setMsg("用户已注册");
        }else {
            ju.setMsg("可以注册");
        }
        Gson gson = new Gson();
        String s1 = gson.toJson(ju);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(s1);
    }
}
