@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <h2>${page.getPost().getName()}</h2>
    <p>
        ${page.getPost().getBody()}
    </p>
    <a href="${NamedRoutes.postsPath()}">Все посты</a>
`
)