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
import java.util.Arrays;


@WebServlet("/user/list")
public class UserList extends HttpServlet {
    public static final Logger log = LogManager.getLogger(UserList.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            UserDao userDao = new UserDao();
            User[]currentUsers = userDao.findAll();
            log.debug(Arrays.toString(currentUsers));

            request.setAttribute("listaUser", currentUsers);
        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);


    }

}

