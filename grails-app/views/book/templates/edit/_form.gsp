<%@ page import="com.booker.book.Language"%>
<%@ page import="com.booker.book.Genre"%>

<g:form class="card-body border mt-5 mb-5" url="[controller: 'book', action: 'update']" enctype="multipart/form-data">
    <h1 class="display-4 mt-0">Editar livro</h1>

    <input type="hidden" name="id" value="${ book.id }"/>

    <div class="form-group">
        <label>Título</label>
        <input class="form-control" type="text" name="title" placeholder="Ex: Dom Casmurro" value="${ book.title }"/>
    </div>

    <div class="form-group">
        <label>Nome do autor</label> <br>
        <input class="form-control" type="text" name="authorName" placeholder="Ex: Machado de Assis" value="${ book.authorName }"/>
    </div>

    <div class="form-group">
        <label class="mb-1">Idioma</label>
        <g:select class="form-control"
                  name="language"
                  data-constraint="select"
                  from="${Language.values()}"
                  noSelection="${['': 'Selecione um idioma']}"
                  optionValue="name"
                  value="${ book.language }"/>
    </div>

    <div class="form-group">
        <label>Editora</label>
        <input class="form-control" type="text" name="publisher" placeholder="Ex: Ática" value="${ book.publisher }"/>
    </div>

    <div class="form-group">
        <label>Descrição</label>
        <textarea class="form-control" type="text" name="description" placeholder="Escreva uma sinopse do livro">${ book.description }</textarea>
    </div>

    <div class="form-group">
        <label class="mb-1">Gênero</label>
        <g:select class="form-control"
                  name="genreList"
                  data-constraint="select"
                  multiple="true"
                  from="${Genre.values()}"
                  noSelection="${['': 'Selecione um ou mais gêneros']}"
                  optionValue="name"
                  value="${ book.genreList }"/>
    </div>

    <div class="form-group">
        <label>Ano de publicação</label>
        <input class="form-control" type="number" name="yearPublished" placeholder="Ex: 1899" value="${ book.yearPublished }"/>
    </div>

    <div class="form-group">
        <label>ISBN</label>
        <input class="form-control" type="number" name="isbn" placeholder="Ex: 9786586490084" value="${ book.isbn }"/>
    </div>

    <div class="form-group">
        <label>Capa do livro</label>
        <div class="custom-file">
            <input type="file" class="custom-file-input" name="bookCover">
            <p class="info">* O arquivo deve ter até 5 MB. Formatos aceitos: .jpg e .png</p>
            <label class="custom-file-label">Escolha o arquivo</label>
        </div>
    </div>

    <div class="navbar d-flex justify-content-space-between">
        <a href="/book/show/${ book.id }" class="btn btn-outline-secondary" type="button">Cancelar</a>
        <button class="btn btn-darkbrown mt-5 mb-4" type="submit">Salvar</button>
    </div>
</g:form>
<asset:javascript src="bs-custom-file-input.js"/>
<asset:javascript src="fileInput.js"/>