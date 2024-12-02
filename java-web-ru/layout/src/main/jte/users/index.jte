@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        <a href="/users">Пользователи</a>
        <table>
            <thead>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>id</th>
            <th>email</th>
            </thead>
            <tbody>
            @for(var user : page.getUsers())
            <tr>
                <td><a href="/users/${user.getId()}">${user.getFirstName()}</a></td>
                <td>${user.getLastName()}  </td>
                <td>${user.getId()}  </td>
                <td>${user.getEmail()}  </td>
            </tr>
            @endfor
            </tbody>
        </table>
    </main>
</div>
</body>
</html>
)