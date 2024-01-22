<g:form class="card-body mb-3" name="userForm" url="[controller: 'user', action: 'changePassword']">
    <div class="form-group mb-3">
        <label class="mb-2">Senha atual</label>
        <input class="form-control" type="password" name="currentPassword" value="" /><br/>
    </div>

    <div class="form-group mb-3">
        <label class="mb-2">Nova senha</label>
        <input class="form-control" type="password" name="password" value="" /><br >
    </div>

    <div class="form-group mb-3">
        <label class="mb-2">Confirmar nova senha</label>
        <input class="form-control" type="password" name="confirmPassword" value="" /><br/>
    </div>

    <div class="card-body row justify-content-between">
        <a href="/">
            <input href="/" class="btn btn-outline-secondary" type="button" name="buttonCancelar" value="Cancelar" />
        </a>
        <input class="btn btn-darkbrown" type="submit" value="Salvar"/>
    </div>
</g:form>