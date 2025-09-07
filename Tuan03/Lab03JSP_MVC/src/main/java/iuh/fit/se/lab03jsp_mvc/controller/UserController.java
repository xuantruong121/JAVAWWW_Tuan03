package iuh.fit.se.lab03jsp_mvc.controller;

import iuh.fit.se.lab03jsp_mvc.dao.UserDAO;
import iuh.fit.se.lab03jsp_mvc.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // Lấy dữ liệu từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String reEmail = request.getParameter("reEmail");
        String password = request.getParameter("password");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

// đảm bảo định dạng 2 chữ số cho tháng và ngày
        if (month.length() == 1) month = "0" + month;
        if (day.length() == 1) day = "0" + day;

// birthday chuẩn yyyy-MM-dd
        String birthday = year + "-" + month + "-" + day;

        String gender = request.getParameter("gender");

        // Kiểm tra email nhập lại có khớp không (basic)
        if (!email.equals(reEmail)) {
            request.setAttribute("error", "Email nhập lại không khớp!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Tạo User object
        User user = new User(firstName, lastName, email, password, birthday, gender);

        // Lưu vào DB
        userDAO.insertUser(user);

        // Lấy danh sách user từ DB
        List<User> users = userDAO.getAllUsers();

        // Forward sang trang listUsers.jsp
        request.setAttribute("users", users);
        RequestDispatcher rd = request.getRequestDispatcher("listUsers.jsp");
        rd.forward(request, response);
    }
}
