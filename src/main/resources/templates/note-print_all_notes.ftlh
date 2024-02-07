<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<body>

<h1>note-print_all_notes</h1>
<h4>Вывожу все записи в блокноте</h4>



<form action="/" method="get">
    <#list noteList as item>
        <div>
            <p><b>Создано: </b> ${item.createDate}| <b>Изменено: </b>${item.changeDate}| <b>Заметка: </b> ${item.description}| <b>Широта: </b>${item.latitude}| <b>Долгота: </b>${item.longitude}</p>

        </div>
    </#list>

    <input type="submit" value="На главную">
</form>



</body>
</html>