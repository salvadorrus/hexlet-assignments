@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@param EditPostPage page

@template.layout.page(
content = @`
    <main>
        <!-- BEGIN -->
        @if(page.getErrors() != null)
            <div class="mb-3">
                <ul>
                    @for(var validator : page.getErrors().values())
                        @for(var error : validator)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            </div>
        @endif
        <form class="row g-3" action="${NamedRoutes.postPath(page.getId().toString())}" method="post">
            <div class="container">
                <div class="mx-auto p-3 md-5 row align-items-start">
                    <div class="col col-lg-1">
                        <label for="id" class="col-form-label">ID</label>
                        <input placeholder="ID"
                               readonly
                               type="text"
                               class="form-control text-truncate"
                               name="id"
                               value="${page.getId()}"
                               id="id"/>
                    </div>
                    <div class="col">
                        <label for="name" class="col-form-label">Заголовок</label>
                        <input placeholder="Заголовок"
                               required
                               type="text"
                               class="form-control text-truncate"
                               name="name"
                               value="${page.getName()}"
                               id="name"/>
                    </div>
                </div>
                <div class="mx-auto p-4 md-5">
                    <label for="body" class="col-form-label">Контент</label>
                    <textarea placeholder="Контент"
                              required
                              class="form-control text-truncate"
                              name="body"
                              id="body">
                            ${page.getBody()}
                        </textarea>
                </div>
            </div>
            <div class="mx-auto p-4 md-2">
                <a class="btn btn-secondary py-md-2" href="${NamedRoutes.postsPath()}">Отменить</a>
                <input class="btn btn-primary py-md-2"  role="button" type="submit" value="Сохранить">
            </div>
        </form>
        <!-- END -->
    </main>
`
)

<!-- END -->