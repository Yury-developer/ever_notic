<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<body>

<h1>Notes</h1>
<h4>Все записи в блокноте</h4>


<form action="/" method="get">
    поиск по названию записки: <input type="text" name="title"><br>
    <input type="submit" value="поиск"/>
</form>


<#list notes as note>
    <div>
        <p><b>Создано: </b> ${note.createDate}| <b>Изменено: </b>${note.changeDate}| ${note.description} | <a href="/note/${note.id}">Просмотр заметки...</a></p>
<#--        <p>${note.Latitude}</p>-->
<#--        <p>${note.Longitude}</p>-->

    </div>
    <#else>
    <h3>Записей нет!</h3>
</#list>



<hr>
<h3>Вывести все записи</h3>
<form action="/note/getAll" method="post">
    <input type="submit" value="Вывести все записи">
</form>



<hr>
<h3>Создать новую заметку</h3>
<form action="/note/create" method="post">
    Дата создания заметки: <input type="date" name="createDate"/><br><br>
    Дата последних изменений заметки: <input type="date" name="changeDate"/><br><br>
    Название заметки (title): <input type="text" name="title"/><br><br>
    Содержимое заметки (description): <input type="text" name="description"/><br><br>
    Блокнот (notepad): <input type="text" name="notepad"/><br><br>
    Широта: <input type="text" name="latitude" value=${defaultLatitude}><br><br>
    Долгота: <input type="text" name="longitude" value=${defaultLongitude}><br><br>
    <input type="submit" value="Добавить запись!">
</form>

</body>
</html>