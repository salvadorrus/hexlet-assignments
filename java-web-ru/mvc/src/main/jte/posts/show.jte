@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <main>
        <header>
            <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                    <form class="d-flex">
                        <a class="btn btn-primary py-md-2" type="cancel" href="${NamedRoutes.postsPath()}">
                            < Назад
                        </a>
                    </form>
                </div>
            </nav>
        </header>

        <div class="mx-auto p-4 py-md-5">
            <h1>${page.getPost().getName()}</h1>
        </div>

        <div class="mx-auto p-4 py-md-5">
            ${page.getPost().getBody()}
        </div>
        <!-- BEGIN -->
        <div class="container-fluid">
            <form class="d-flex">
                <a class="btn btn-primary py-md-2"
                   href="${NamedRoutes.editPostPath(page.getPost().getId().toString())}">
                    Редактировать
                </a>
            </form>
        </div>
        <!-- END -->
    </main>
`
)