<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>
        Registration
    </title>
</head>
<body>

<p>${successRegistration}</p>

<form:form action="/registration" method="post" modelAttribute="user">

    <form:label path = "username">Login: </form:label>
    <form:input type="text" id="loginField" path = "username" /> <!--it is usernmae in entity -->
    <br/>
    <form:label path = "email">Email: </form:label>
    <form:input type="email" id="emailField" path = "email" />
    <br/>
    <form:label path="birthday">Birthday: </form:label>
    <form:input type="date" id="dateField" path="birthday" />
    <br/>
    <form:label path="country">Country: </form:label>
    <form:input type="text" id="countryField" path="country"/>
    <br/>
    <form:label path="password">Password: </form:label>
    <form:input type="password" id="passwordField" path="password" />
    <br/>
    <%--<label for="passwordConfirmField">Password confirm: </label>--%>
    <%--<input type="password" id="passwordConfirmField">--%>
    <%--<br/>--%>
    <input type="submit" value="Register"/>

</form:form>

</body>
</html>
