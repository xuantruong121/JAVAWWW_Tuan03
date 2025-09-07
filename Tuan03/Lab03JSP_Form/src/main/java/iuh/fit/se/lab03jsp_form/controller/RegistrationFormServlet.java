package iuh.fit.se.lab03jsp_form.controller;

import iuh.fit.se.lab03jsp_form.model.Qualification;
import iuh.fit.se.lab03jsp_form.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/registration-form")
public class RegistrationFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // 1. Lấy dữ liệu từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirth = request.getParameter("day") + "/" +
                request.getParameter("month") + "/" +
                request.getParameter("year");

        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobileNumber");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pinCode = request.getParameter("pinCode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");

        // Hobbies (checkbox)
        String[] hobbiesArr = request.getParameterValues("hobbies");
        List<String> hobbies = hobbiesArr != null ? Arrays.asList(hobbiesArr) : new ArrayList<>();

        // 2. Xử lý Qualification (có nhiều dòng)
        List<Qualification> qualifications = new ArrayList<>();

        String[] exams = {"Class X", "Class XII", "Graduation", "Masters"};
        for (int i = 0; i < exams.length; i++) {
            String board = request.getParameter("board" + i);
            String percentageStr = request.getParameter("percentage" + i);
            String yearStr = request.getParameter("year" + i);

            if (board != null && !board.isEmpty()) {
                double percentage = percentageStr != null && !percentageStr.isEmpty()
                        ? Double.parseDouble(percentageStr) : 0.0;
                int year = yearStr != null && !yearStr.isEmpty()
                        ? Integer.parseInt(yearStr) : 0;

                qualifications.add(new Qualification(exams[i], board, percentage, year));
            }
        }

        // 3. Khóa học đăng ký
        String courseAppliedFor = request.getParameter("courseAppliedFor");

        // 4. Tạo Student object
        Student student = new Student(firstName, lastName, dateOfBirth, email,
                mobileNumber, gender, address, city, pinCode, state,
                country, hobbies, qualifications, courseAppliedFor);

        // 5. Lưu vào request scope và forward sang JSP kết quả
        request.setAttribute("student", student);
        RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
        rd.forward(request, response);
    }
}
