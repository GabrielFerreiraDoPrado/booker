<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="layout" content="main" />
        <title>Detalhes do livro</title>
    </head>
    <body>
        <g:render template="/book/templates/show/breadcrumb" model="[book: bookAdapter, currentUser: currentUserAdapter]"/>
        <div class="main-container d-flex justify-content-center">
            <g:render template="/book/templates/show/details" model="[book: bookAdapter, currentUser: currentUserAdapter]"/>
        </div>
    </body>
</html>