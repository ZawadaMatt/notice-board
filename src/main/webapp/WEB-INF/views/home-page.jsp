<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
            integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
            integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <a class="navbar-brand">Notice Board</a>
    <sec:authorize access="!isAuthenticated()">
        <form class="form-inline mr-2 mt-3" method="get" action="/login">
            <button class="btn btn-success" type="submit">Zaloguj</button>
            <sec:csrfInput/>
        </form>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <form class="form-inline mt-3" method="post" action="/logout">
            <button class="btn btn-success" type="submit">Wyloguj</button>
            <sec:csrfInput/>
        </form>
    </sec:authorize>
</nav>
<div class="container">
    <sec:authorize access="isAuthenticated()">
        <div class="row" style="margin-top: 40px; margin-bottom: 10px">
            <div class="col-1"></div>
            <div class="col-6"><h2>Dodaj ogłoszenie</h2></div>
            <div class="col-5"></div>
        </div>

        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">

                <form method="post" action="/add-advert">
                    <div class="form-group">
                        <label for="title">Tytuł ogłoszenia:</label>
                        <input type="text" required name="title" id="title" class="form-control"
                               placeholder="Podaj tytuł ogłoszenia"/>
                    </div>
                    <div class="form-group">
                        <label for="description">Opis ogłoszenia</label>
                        <textarea name="description" id="description"
                                  class="form-control"
                                  placeholder="Uzupełnij opis ogłoszenia"></textarea>
                    </div>
                    <button class="btn btn-primary" type="submit">Dodaj</button>
                    <button class="btn btn-secondary" type="reset">Wyczyść dane</button>
                    <sec:csrfInput/>
                </form>
            </div>
            <div class="col-2"></div>
        </div>
    </sec:authorize>

    <div class="row" style="margin-top: 40px; margin-bottom: 10px">
        <div class="col-1"></div>
        <div class="col-6"><h2>Lista ogłoszeń</h2></div>
        <div class="col-5"></div>
    </div>

    <div class="row">
        <div class="col-12" style="padding-bottom: 20px">
            <table class="table">
                <thead class="thead-Primary">
                <tr>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${advertList}" var="advert" varStatus="stat">
                    <tr>
                        <td>
                            <div class="media position-relative">
                                <img src="http://www.thebristolarms.com.au/wp-content/uploads/2018/03/img-not-found.png"
                                     class="mr-3" alt="..." style="height: 100px; width: 100px">
                                <div class="media-body">
                                    <h5 class="mt-0">${advert.title}</h5>
                                    <p>${advert.description}</p>
                                    <p>Dodano : ${advert.posted.format(dateFormat)}</p>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
</body>
</html>