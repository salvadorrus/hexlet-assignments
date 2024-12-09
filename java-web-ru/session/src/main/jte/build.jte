@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page = new exercise.dto.LoginPage(null, null)


@template.layout.page(
content = @`
    @if(page.getError() != null)
        <p>${page.getError()}</p>
    @endif
    <div>
        <form action="${NamedRoutes.loginPath()}" method="post">
            <label>Имя
                <input type="text" name="name" placeholder="Name" value="${page.getName()}">
            </label>
            <label>Пароль
                <input type="password" name="password" placeholder="Password">
            </label>
            <input type="submit" value="Войти">
        </form>
    </div>
`
)
