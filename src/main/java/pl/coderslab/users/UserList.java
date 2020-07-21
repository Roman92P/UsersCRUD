package pl.coderslab.users;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.User;
import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;


@WebServlet("/user/list")
public class UserList extends HttpServlet {
    public static final Logger log = LogManager.getLogger(UserList.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(Connection connection = DbUtil.getConnection()) {
            UserDao userDao = new UserDao();
            User[]currentUsers = userDao.findAll();
            log.debug(Arrays.toString(currentUsers));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);


    }

}

