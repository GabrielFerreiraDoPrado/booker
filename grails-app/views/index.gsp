<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>

    <sec:ifLoggedIn>
        <meta http-equiv="refresh" content="0; URL='/book'"/>
    </sec:ifLoggedIn>

        <title>Booker</title>
</head>
<body>
    <div class="bg-image"></div>
    <div class="col-7 d-flex justify-content-center mt-5 ml-3 index-text-div">
        <div class="col-8">
            <h2 class="display-4 index-title"><span class="gogreen font-weight-bold">Compartilhe</span> seus livros e promova conhecimento</h2>
            <p class="index-subtitle">Participe de uma comunidade de leitores que promove a sustentabilidade cultural através da circulação consciente de livros</p>
            <div class="d-flex justify-content-center col-10">
                <a class="btn btn-darkbrown btn-lg mt-5" href="/user/signUp">Criar conta agora</a>
            </div>
        </div>
    </div>
</body>
</html>
