<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="layout" content="main" />
        <title>Listagem de livros</title>
    </head>
    <body>
        <div class="main-container">
            <g:render template="/book/templates/index/searchBar" model="[titleLike: titleLike]"/>
            <g:render template="/book/templates/index/list" model="[bookAdapterList: bookAdapterList]"/>
            <a class="btn btn-darkbrown mr-3 lowerRightFixedButton" href="/book/create">+</a>
        </div>
    </body>
</html>