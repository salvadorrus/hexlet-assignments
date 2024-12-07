@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(content = @`
    <h1>Список постов</h1>
    <ul>
    @for(Post post : page.getPosts())
        <li><a href="${NamedRoutes.postsPath(post.getId())}">${post.getName()}</a></li>
    @endfor
    </ul>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="?page=${page.getPageNumber() - 1}">Previous</a></li>
            <li class="page-item"><a class="page-link" href="?page=${page.getPageNumber() + 1}">Next</a></li>
        </ul>
    </nav>
`
)