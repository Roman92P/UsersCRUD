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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    public static final Logger log = LogManager.getLogger(UserEdit.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String userId = req.getParameter("userId");
        int i = Integer.parseInt(userId);

        User user = new UserDao().read(i);
        String userN = user.getUserName();
        String userEmail = user.getEmail();
        req.getSession().setAttribute("userToEdit", user);
        log.debug(user);
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("identyfikator");
        String mail = req.getParameter("mail");
        String imie = req.getParameter("imie");
        String haslo = req.getParameter("haslo");
        User user = new User(Integer.parseInt(userId),mail, imie,haslo);
        UserDao a = new UserDao();
        a.update(user);

        resp.sendRedirect("/users/edit.jsp");
    }
}
