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

@WebServlet("/user/add")
public class UserAdd  extends HttpServlet {
    public static final Logger log = LogManager.getLogger(UserAdd.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/users/add.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String imie = req.getParameter("imie");
        String mail = req.getParameter("mail");
        String haslo = req.getParameter("haslo");

        log.debug(imie+" "+haslo+" "+mail);
        User newUser = new User(mail, imie, haslo);
        UserDao newUserDao = new UserDao();
        newUserDao.create(newUser);

    }
}
