@import exercise.dto.posts.BuildPostPage
@import exercise.dto.posts.EditPostPage
@import exercise.dto.posts.PostPage
@import exercise.repository.PostRepository
@import exercise.util.NamedRoutes
@param EditPostPage page


@template.layout.page(
content  = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/posts/${page.getPost().getId()}" method="post">
        <div>
            <label>
                Измени название поста
                <input type="text" name="name" value="${page.getPost().getName()}"/>
            </label>
        </div>
        <div>
            <label>
                Измени описание поста
                <textarea required name="body" rows="6" cols="30" value="${page.getPost().getBody()}"></textarea>
            </label>
        </div>
        <input type="submit" value="Изменить" />
    </form>
`
)