<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<header>
    <div class="jumbotron jumbotron-fluid" id="banner">
        <div class="parallax text-center" style="background-image: url(img/cover.jpg);">
            <div class="parallax-pattern-overlay">
                <div class="container text-center" id="size-banner">
                    <h2 class="display-2">Strona użytkownika:</h2>
                    <h3 class="learn">${message.username}</h3>
                </div>
            </div>
        </div>
    </div>

    <div align="center">
        <p>Imie uzytkownika: ${message.name}</p>
        <p>Nazwisko: ${message.surname}</p>
        <p>E-mail: ${message.email}</p>
        <p>Id: ${message.uid}</p>
        <a href="hello.ftl">Zaloguj się</a>
    </div>


</header>
</body>
</html>