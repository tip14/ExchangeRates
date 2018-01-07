<!DOCTYPE html>
<html>
<head>
    <title>
        Registration
    </title>
</head>
<body>

<form action="/registration" method="post" >
    <label for="loginField">Login: </label>
    <input type="text" id="loginField">
    <br/>
    <label for="countryField">Country: </label>
    <input type="text" id="countryField">
    <br/>
    <label for="dateField">Birthday: </label>
    <input type="date" id="dateField">
    <br/>
    <label for="passwordField">Password: </label>
    <input type="password" id="passwordField">
    <br/>
    <label for="passwordConfirmField">Password confirm: </label>
    <input type="password" id="passwordConfirmField">
    <br/>
    <input type="submit" value="Register"/>
</form>

</body>
</html>
