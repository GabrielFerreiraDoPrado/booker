<%@ page import="com.booker.book.Language"%>
<%@ page import="com.booker.book.Genre"%>

<g:form class="card-body border mt-5" name="customerForm" url="[controller: 'book', action: 'save']">
    <h1 class="display-4 mt-0">Adicionar livro</h1>

    <div class="form-group">
        <label>Título</label>
        <input class="form-control" type="text" name="title" placeholder="Ex: Dom Casmurro"/>
    </div>

    <div class="form-group">
        <label>Nome do autor</label> <br>
        <input class="form-control" type="text" name="authorName" placeholder="Ex: Machado de Assis"/>
    </div>

    <div class="form-group">
        <label class="mb-1">Idioma</label>
        <g:select class="form-control"
                  name="language"
                  data-constraint="select"
                  from="${Language.values()}"
                  noSelection="${['': 'Selecione um idioma']}"
                  optionValue="name"/>
    </div>

    <div class="form-group">
        <label>Editora</label>
        <input class="form-control" type="text" name="publisher" placeholder="Ex: Ática"/>
    </div>

    <div class="form-group">
        <label>Descrição</label>
        <textarea class="form-control" type="text" name="description" placeholder="Escreva uma sinopse do livro"></textarea>
    </div>

    <div class="form-group">
        <label class="mb-1">Gênero</label>
        <g:select class="form-control"
                  name="genreList"
                  data-constraint="select"
                  multiple="true"
                  from="${Genre.values()}"
                  noSelection="${['': 'Selecione um ou mais gêneros']}"
                  optionValue="name"/>
    </div>

    <div>
        <label>Ano de publicação</label>
        <input class="form-control" type="number" name="yearPublished" placeholder="Ex: 1899"/>
    </div>

    <div>
        <label>ISBN</label>
        <input class="form-control" type="number" name="isbn" placeholder="Ex: 9786586490084"/>
    </div>

    <div class="navbar d-flex justify-content-space-between">
        <a href="/book/index" class="btn btn-outline-secondary" type="button">Cancelar</a>
        <button class="btn btn-darkbrown mt-5 mb-4" type="submit">Salvar</button>
    </div>
</g:form>