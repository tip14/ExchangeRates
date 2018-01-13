<!DOCTYPE html>
<html>
<head>
    <title>
        Login
    </title>
</head>
<body>

<form action="/login" method="post" >

    <label for="loginField">Login: </label>
    <input type="text" id="loginField" name="login">
    <br/>
    <label for="passwordField">Password: </label>
    <input type="password" id="passwordField" name="password">
    <br/>
    <input type="submit" value="Login"/>

</form>
<a href="/registration">Registration</a>
</body>
</html>
