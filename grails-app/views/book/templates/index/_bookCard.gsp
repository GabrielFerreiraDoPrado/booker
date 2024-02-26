<a href="${createLink(controller: 'book', action: 'show', id: book.id)}">
    <li class="bookCard border">
        <div class="detail d-flex justify-content-center">
            <img class="bookCover-sm" src="data:image/png;base64, ${ book.bookCoverBase64 }"/>
        </div>
    </li>
</a>