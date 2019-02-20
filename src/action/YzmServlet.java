package action;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "YzmServlet",urlPatterns = "/yzm")
public class YzmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage bd = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bd.getGraphics();
        String str ="0123456789abcdefghijklnmopqrstuvwxyz";
        Random rd = new Random();
        graphics.setColor(new Color(rd.nextInt(255), rd.nextInt(255), rd.nextInt(255)));
        graphics.fillRect(0, 0, 80, 20);
        for (int i=0;i<4;i++) {
            graphics.setColor(new Color(rd.nextInt(255), rd.nextInt(255), rd.nextInt(255)));
            char c = str.charAt(rd.nextInt(str.length()));
            graphics.drawString(Character.toString(c),i*20+2,12);
        }
        ImageIO.write(bd,"png",response.getOutputStream());
    }
}
