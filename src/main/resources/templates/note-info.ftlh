<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<body>

<h1>Notes</h1>
<h4>Подробная информация о записи:</h4>
<b>Дата создания заметки: </b>${note.createDate}<br>
<b>Дата последней модификации заметки: </b>${note.changeDate}<br>
<b>Название заметки (title): </b>${note.title}<br>
<b>Содержимое заметки (description): </b>${note.description}<br>
<b>Блокнот (notepad): </b>${note.notepad}<br>
<b>Широта: </b>${note.latitude}<br>
<b>Долгота: </b>${note.longitude}<br>
<hr>



<h3>Создать новую заметку</h3>
<form action="/note/delete/${note.id}" method="post">
    <input type="submit" value="Удалить запись."/><br><br>
</form>

</body>
</html>