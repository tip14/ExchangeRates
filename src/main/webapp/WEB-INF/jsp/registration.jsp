<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="sections/styles.jsp" %>
    <title>
        Registration
    </title>
</head>
<body>

<p>${successRegistration}</p>

<div class="col-md-4 offset-4">
    <form:form action="/registration" method="post" modelAttribute="user" id="needs-validation" novalidate="novalidate">
        <legend class="text-center">Registration</legend>

        <div class="form-group">
            <form:label path = "username">Login: </form:label>
            <form:input class="form-control form-control-sm" type="text" id="loginField" path = "username" required="required"/>
        </div>
        <div class="form-group">
            <form:label path = "email">Email: </form:label>
            <form:input class="form-control form-control-sm" type="email" id="emailField" path = "email" required="required"/>
        </div>
        <div class="form-group">
            <form:label path="birthday">Birthday: </form:label>
            <form:input class="form-control form-control-sm" type="date" id="dateField" path="birthday" required="required"/>
        </div>
        <div class="form-group">
            <form:label path="country">Country: </form:label>
            <select class="form-control form-control-sm" id="countryField" path="country">
                <c:forEach items="${countries}" var="country">
                    <option><c:out value="${country}"/></option>
                </c:forEach>
            </select>

            <%--<form:input class="form-control" type="text" id="countryField" path="country"/>--%>
        </div>
        <div class="form-group">
            <form:label path="password">Password: </form:label>
            <form:input class="form-control form-control-sm" type="password" id="passwordField" path="password" required="required"/>
        </div>

        <%--<label for="passwordConfirmField">Password confirm: </label>--%>
        <%--<input type="password" id="passwordConfirmField">--%>
        <%--<br/>--%>
        <input class="btn btn-lg btn-block btn-primary" role="button" type="submit" value="Register"/>

    </form:form>
</div>


<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function() {
        'use strict';

        window.addEventListener('load', function() {
            var form = document.getElementById('needs-validation');
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        }, false);
    })();
</script>

</body>
</html>
