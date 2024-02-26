<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="layout" content="main" />
        <title>Detalhes do livro</title>
    </head>
    <body>
        <div class="container my-8 d-flex justify-content-center-center col-6">
            <g:render template="/book/templates/edit/form" model="[book: bookAdapter, currentUser: currentUserAdapter]"/>
        </div>
    </body>
</html>