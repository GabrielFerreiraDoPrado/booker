<ol class="bookList">
    <g:each var="book" in="${bookAdapterList}">
        <g:render template="/book/templates/index/bookCard" model="[book: book]"/>
    </g:each>
</ol>