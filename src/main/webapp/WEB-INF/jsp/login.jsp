<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" style="height: 100%"> <!--css doesn't work-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <%@ include file="sections/styles.jsp" %>
    <title>
        Login | Finmart
    </title>
</head>
<body style="height: 100%">

<div class="container-fluid" style="height: 100%">

    <div class="row align-items-center" style="height: 100%">
        <div class="col-md-4 offset-4">

            <c:if test="${error}">
                <p>${error}</p>
            </c:if>

            <legend class="text-center">Login</legend>
            <form action="/login" method="post" id="needs-validation" novalidate>
                <div class="form-group">
                    <label for="loginField">Login: </label>
                    <input class="form-control form-control-sm" type="text" id="loginField" name="login">
                </div>

                <div class="form-group">
                    <label for="passwordField">Password: </label>
                    <input class="form-control form-control-sm" type="password" id="passwordField" name="password">
                </div>

                <input class="btn btn-block btn-success" role="button" type="submit" value="Login"/>
                <p class="text-center" style="margin:2px 0 2px 0">OR</p>
                <a class="btn btn-block btn-sm btn-primary" href="/registration">Registrer</a>

            </form>

        </div>
    </div>
</div>

</body>
</html>
