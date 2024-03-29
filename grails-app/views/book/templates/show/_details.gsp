<%
    Boolean isBookBorrowed = book.currentReader != null
%>

<div class="card border border-secondary rounded col-6 mt-3 p-4 mb-5">
    <div class="d-flex flex-row">
        <div class="col-4 mr-2">
            <img class="bookCover-md" src="data:image/png;base64, ${ book.bookCoverBase64 }"/>
        </div>
        <div class="d-flex flex-column justify-content-between col">
            <div>
                <h1 class="font-weight-bold title">${ book.title }</h1>
                <h1 class="authorName">${ book.authorName }</h1>
            </div>

            <div>
                <h3 class="font-weight-bold">Dono do livro:</h3>
                <p>${ book.owner.username }</p>
            </div>

            <g:if test="${book.owner.id == currentUser.id}">
                <div>
                    <a href="${createLink(controller: 'book', action: 'edit', id: book.id)}" class="col btn btn-darkbrown mb-3" type="submit">Editar</a>
                </div>
            </g:if>
            <g:elseif test="${book.currentReader?.id == currentUser.id}">
                <div>
                    <a href="${createLink(controller: 'book', action: 'returnBook', id: book.id)}"
                       class="col btn btn-darkbrown mb-3"
                       type="submit">Devolver</a>
                </div>
            </g:elseif>
            <g:else>
                <div>
                    <a href="${createLink(controller: 'book', action: 'request', id: book.id)}"
                       class="col btn btn-darkbrown ${isBookBorrowed ? 'disabled' : ''} mb-3"
                       type="submit">Solicitar</a>
                </div>
            </g:else>
        </div>
    </div>
    <hr class="mt-3">
    <div class="card-body">
        <h3 class="font-weight-bold">Idioma</h3>
        <p>${ book.language.name }</p>

        <h3 class="font-weight-bold mt-4">Editora</h3>
        <p>${ book.publisher }</p>

        <h3 class="font-weight-bold mt-4">Descrição</h3>
        <p>${ book.description }</p>

        <h3 class="font-weight-bold mt-4">Categorias</h3>
        <g:each var="genre" in="${ book.genreList }">
            <p>${ genre.name }</p>
        </g:each>

        <h3 class="font-weight-bold mt-4">Ano de Publicação</h3>
        <p>${ book.yearPublished }</p>

        <h3 class="font-weight-bold mt-4">ISBN</h3>
        <p>${ book.isbn }</p>
    </div>
</div>