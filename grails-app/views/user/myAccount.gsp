<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="layout" content="main" />
        <title>Minha conta</title>
    </head>
    <body>
        <div class="container d-flex justify-content-start col-10 mb-3 main-container">
            <div class="col-12">
                <h1 class="display-4 mb-4">Minha conta</h1>
                <div class="border rounded col">
                    <div class="row d-flex justify-content-center rounded border">
                        <span class="h2">Alterar senha</span>
                    </div>
                    <div class="d-flex justify-content-center">
                        <div class="col-6">
                            <div>
                                <div class="d-flex justify-content-center">
                                    <h3>Para alterar a senha de acesso, informe sua senha atual e a nova senha.</h3>
                                </div>
                                <g:render template="/user/templates/changePassword"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>