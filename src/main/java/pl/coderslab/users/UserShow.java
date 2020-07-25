package pl.coderslab.users;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    public static final Logger log = LogManager.getLogger(UserShow.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String userId = req.getParameter("userId");
        int i = Integer.parseInt(userId);

        User user = new UserDao().read(i);
        String userN = user.getUserName();
        String userEmail = user.getEmail();
        req.getSession().setAttribute("userToShow", user);
        log.debug(user);
        getServletContext().getRequestDispatcher("/users/show.jsp").forward(req,resp);
    }
}
