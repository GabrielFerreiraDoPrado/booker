<!doctype html>
<html>
    <head>
        <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
        <meta name="layout" content="main">
        <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <div class="col-12">
                    <ul class="errors">
                        <li>Ocorreu um erro desconhecido</li>
                    </ul>
                </div>
            </section>
        </div>
    </div>
    </body>
</html>
