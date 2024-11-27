@import exercise.dto.users.UserPage
@param UserPage page2


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
        <>
            <table>
                <thead>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>id</th>
                <th>email</th>
                </thead>
                <tbody>
                    <tr>
                        <td>${page2.getUser().getFirstName()}</td>
                        <td>${page2.getUser().getLastName()}  </td>
                        <td>${page2.getUser().getEmail()}  </td>
                        <td> </td>
                    </tr>
                </tbody>
            </table>
    </main>>
</div>
</body>
</html>