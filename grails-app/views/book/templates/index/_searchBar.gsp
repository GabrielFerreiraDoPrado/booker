<div class="mt-3 mb-3 d-flex flex-row justify-content-center">
    <g:form class="form-inline col-6 d-flex flex-row justify-content-center" url="[controller: 'book', action: 'index']">
        <div class="form-group col-8">
            <label class="sr-only">Nome do livro</label>
            <input type="text" class="form-control border col" name="title[like]" value="${titleLike}">
        </div>
        <button type="submit" class="btn btn-darkbrown">
            <asset:image src="search.svg" style="filter: invert(91%) sepia(14%) saturate(901%) hue-rotate(325deg) brightness(104%) contrast(95%);"/>
        </button>
    </g:form>
</div>