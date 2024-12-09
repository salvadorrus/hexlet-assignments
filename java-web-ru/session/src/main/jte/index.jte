@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page


@template.layout.page(content = @`
    @if(page.getName() == null)
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @else
        <p>${String.valueOf(page.getName())}</p>
        <form action="${NamedRoutes.logoutPath()}" method="get">
            <input type="submit" value="Выйти">
        </form>
    @endif
`
)