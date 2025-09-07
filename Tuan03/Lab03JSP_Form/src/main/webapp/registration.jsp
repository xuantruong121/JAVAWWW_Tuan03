<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Form Đăng ký Khóa học</title>
    <style>
        body {
            background-color: #b3e5fc;
            font-family: Arial, sans-serif;
        }

        table {
            border-collapse: collapse;
            margin-top: 15px;
        }

        table, th, td {
            border: 1px solid #000;
            padding: 5px;
        }

        th {
            background-color: #90caf9;
        }

        label {
            display: inline-block;
            width: 120px;
        }

        input[type=text], input[type=email], textarea {
            width: 250px;
        }

        .section {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<h2>Form Đăng ký Khóa học</h2>

<!-- method GET -->
<form action="registration-form" name="formDangKy" method="GET">

    <div class="section">
        <label>First name</label>
        <input type="text" name="firstName" maxlength="30"/> (max 30 characters a-z and A-Z)
    </div>

    <div class="section">
        <label>Last name</label>
        <input type="text" name="lastName" maxlength="30"/> (max 30 characters a-z and A-Z)
    </div>

    <div class="section">
        <label>Date of birth</label>
        Day:
        <select name="day">
            <% for (int i = 1; i <= 31; i++) { %>
            <option value="<%=i%>"><%=i%>
            </option>
            <% } %>
        </select>
        Month:
        <select name="month">
            <%
                String[] months = {"January", "February", "March", "April", "May", "June",
                        "July", "August", "September", "October", "November", "December"};
                for (String m : months) {
            %>
            <option value="<%=m%>"><%=m%>
            </option>
            <% } %>
        </select>
        Year:
        <select name="year">
            <% for (int y = 1980; y <= 2025; y++) { %>
            <option value="<%=y%>"><%=y%>
            </option>
            <% } %>
        </select>
    </div>

    <div class="section">
        <label>Email</label>
        <input type="email" name="email"/>
    </div>

    <div class="section">
        <label>Mobile number</label>
        <input type="text" name="mobileNumber" maxlength="10"/> (10 digit number)
    </div>

    <div class="section">
        <label>Gender</label>
        <input type="radio" name="gender" value="Male"/> Male
        <input type="radio" name="gender" value="Female"/> Female
    </div>

    <div class="section">
        <label>Address</label>
        <textarea name="address" rows="3" cols="40"></textarea>
    </div>

    <div class="section">
        <label>City</label>
        <input type="text" name="city" maxlength="30"/> (max 30 characters a-z and A-Z)
    </div>

    <div class="section">
        <label>Pin code</label>
        <input type="text" name="pinCode" maxlength="6"/> (6 digit number)
    </div>

    <div class="section">
        <label>State</label>
        <input type="text" name="state" maxlength="30"/> (max 30 characters a-z and A-Z)
    </div>

    <div class="section">
        <label>Country</label>
        <input type="text" name="country"/>
    </div>

    <div class="section">
        <label>Hobbies</label>
        <input type="checkbox" name="hobbies" value="Drawing"/> Drawing
        <input type="checkbox" name="hobbies" value="Singing"/> Singing
        <input type="checkbox" name="hobbies" value="Dancing"/> Dancing
        <input type="checkbox" name="hobbies" value="Sketching"/> Sketching
        <input type="checkbox" name="hobbies" value="Others"/> Others
        <input type="text" name="hobbyOther"/>
    </div>

    <div class="section">
        <label>Qualification</label><br/>
        <table>
            <tr>
                <th>Sl.No</th>
                <th>Examination</th>
                <th>Board</th>
                <th>Percentage</th>
                <th>Year of Passing</th>
            </tr>
            <tr>
                <td>1</td>
                <td>Class X</td>
                <td><input type="text" name="board0" maxlength="10"/></td>
                <td><input type="text" name="percentage0"/></td>
                <td><input type="text" name="year0"/></td>
            </tr>
            <tr>
                <td>2</td>
                <td>Class XII</td>
                <td><input type="text" name="board1" maxlength="10"/></td>
                <td><input type="text" name="percentage1"/></td>
                <td><input type="text" name="year1"/></td>
            </tr>
            <tr>
                <td>3</td>
                <td>Graduation</td>
                <td><input type="text" name="board2" maxlength="10"/></td>
                <td><input type="text" name="percentage2"/></td>
                <td><input type="text" name="year2"/></td>
            </tr>
            <tr>
                <td>4</td>
                <td>Masters</td>
                <td><input type="text" name="board3" maxlength="10"/></td>
                <td><input type="text" name="percentage3"/></td>
                <td><input type="text" name="year3"/></td>
            </tr>
        </table>
    </div>

    <div class="section">
        <label>Course applies for</label>
        <input type="radio" name="courseAppliedFor" value="BCA"/> BCA
        <input type="radio" name="courseAppliedFor" value="B.Com"/> B.Com
        <input type="radio" name="courseAppliedFor" value="B.Sc"/> B.Sc
        <input type="radio" name="courseAppliedFor" value="B.A"/> B.A
    </div>

    <div class="section">
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </div>
</form>
</body>
</html>
