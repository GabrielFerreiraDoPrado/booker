<!doctype html>
<html lang="en" class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <title>
            <g:layoutTitle default="Grails"/>
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

        <asset:javascript src="jquery-3.5.1.js"/>
        <asset:stylesheet src="application.css"/>
        <asset:stylesheet src="notificationDropdownCss.css"/>
        <asset:stylesheet src="booker.css"/>

        <asset:javascript src="FlashMessageController.js"/>

        <g:layoutHead/>
    </head>

    <body class="js-main-container">
        <nav class="navbar navbar-expand-lg navbar-dark bg-wheat navbar-static-top" role="navigation">
            <div class="container-fluid justify-content-between">
                <div class="col">
                </div>

                <a href="/" class="container-fluid justify-content-center col">
                    <p class="display-4 text-navbar-title">Booker</p>
                </a>

                <sec:ifNotLoggedIn>
                    <div class="container-fluid justify-content-end col">
                        <a class="btn btn-lg btn-darkbrown mr-3" href="/user/login">Login</a>
                        <a class="btn btn-lg btn-darkbrown mr-3" href="/user/signUp">Cadastrar</a>
                    </div>
                </sec:ifNotLoggedIn>
                <sec:ifLoggedIn>
                    <div class="container-fluid justify-content-end col">
                        <div class="js-notification-container">
                            <btn class="btn btn-lg btn-darkbrown mr-3 js-btn-notification">
                                <asset:image class="js-notification" src="bell.svg"/>
                            </btn>

                            <div class="js-dropdown-menu dropdown-menu navbar-dark bg-secondary" aria-labelledby="dropdownMenuButton">
                            </div>
                        </div>
                        <a class="btn btn-darkbrown mr-3" href="/user/myAccount">Minha Conta</a>
                        <a class="btn btn-darkbrown mr-3" href='${request.contextPath}/logoff' method='POST'>Sair</a>
                    </div>
                </sec:ifLoggedIn>
            </div>
        </nav>

        <g:if test="${flash?.message}">
            <g:render template="/flashMessage/templates/flashMessage"/>
        </g:if>

        <g:layoutBody/>

        <div id="spinner" class="spinner" style="display:none;">
            <g:message code="spinner.alt" default="Loading&hellip;"/>
        </div>

        <asset:javascript src="application.js"/>
        <asset:javascript src="NotificationDropdownController.js"/>
    </body>
</html>
