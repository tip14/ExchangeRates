<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <%@ include file="sections/styles.jsp" %>
    <title>Currency Rates on ${currentDate}</title>
</head>
<body>

<h1>Currency Rates for ${baseCurrency} on ${currentDate}</h1>

<form method="post" action="/rates">

    <label for="chooseCurrency">Choose currency: </label>
    <select id="chooseCurrency" name="chooseCurrency">
        <c:forEach items="${currencySymbols}" var="symbol">
            <option><c:out value="${symbol}"/></option>
        </c:forEach>
    </select>
    <input class="btn btn-primary btn-sm" type="submit" value="Change currency">

</form>

<br/>

<table class="table table-bordered table-hover table-sm text-center">
    <caption>Currency rates for the last 10 days</caption>
    <thead class="thead-dark">
    <tr>
        <th>
            Request date
        </th>
        <th>
            Last modified date
        </th>
        <c:forEach items="${jsonResponse[0].rates}" var="title">
            <th>
                <c:out value="${title.key}"/>
            </th>

        </c:forEach>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${jsonResponse}" var="response" varStatus="status">

        <tr>
            <td>
                <c:out value="${lastTenDays[status.index]}"/>
            </td>

            <td>${response.date}</td>
            <c:forEach items="${response.rates}" var="rate">
                <td>
                    <fmt:formatNumber type = "number" maxFractionDigits = "3" minFractionDigits="3"  value = "${rate.value}" />
                </td>
            </c:forEach>
        </tr>

    </c:forEach>
    </tbody>
</table>


</body>

</html>