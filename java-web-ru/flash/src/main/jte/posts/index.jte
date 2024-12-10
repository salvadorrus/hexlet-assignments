@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
page = page,
content  = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>${"Это лист со всеми доступными постами!"}</h1>


            <div class="mb-3">
                <a href="${NamedRoutes.buildPostPath()}">Создать новый пост</a>
            </div>


            <table class="table table-striped">
                @for(var post : page.getPostList())
                    <tr>
                        <td>
                            ${post.getId()}
                        </td>
                        <td>
                            <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                        </td>
                        <td>
                            <a>${post.getBody()}</a>
                        </td>
                    </tr>
                @endfor
            </table>
        </main>
    </div>
`
)
