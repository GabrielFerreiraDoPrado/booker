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

        <asset:stylesheet src="application.css"/>
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

        <div class="footer" role="contentinfo">
            <div class="container-fluid">
                <div class="row">
                    <div class="col">
                        <a href="http://guides.grails.org" target="_blank">
                            <asset:image src="advancedgrails.svg" alt="Grails Guides" class="float-left"/>
                        </a>
                        <strong class="centered"><a href="http://guides.grails.org" target="_blank">Grails Guides</a></strong>
                        <p>Building your first Grails app? Looking to add security, or create a Single-Page-App? Check out the <a href="http://guides.grails.org" target="_blank">Grails Guides</a> for step-by-step tutorials.</p>

                    </div>
                    <div class="col">
                        <a href="http://docs.grails.org" target="_blank">
                            <asset:image src="documentation.svg" alt="Grails Documentation" class="float-left"/>
                        </a>
                        <strong class="centered"><a href="http://docs.grails.org" target="_blank">Documentation</a></strong>
                        <p>Ready to dig in? You can find in-depth documentation for all the features of Grails in the <a href="http://docs.grails.org" target="_blank">User Guide</a>.</p>

                    </div>
                    <div class="col">
                        <a href="https://slack.grails.org" target="_blank">
                            <asset:image src="slack.svg" alt="Grails Slack" class="float-left"/>
                        </a>
                        <strong class="centered"><a href="https://slack.grails.org" target="_blank">Join the Community</a></strong>
                        <p>Get feedback and share your experience with other Grails developers in the community <a href="https://slack.grails.org" target="_blank">Slack channel</a>.</p>
                    </div>
                </div>
            </div>
        </div>

        <div id="spinner" class="spinner" style="display:none;">
            <g:message code="spinner.alt" default="Loading&hellip;"/>
        </div>

        <asset:javascript src="application.js"/>

    </body>
</html>
