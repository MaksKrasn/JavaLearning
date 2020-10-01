<#import "parts/template.ftlh" as c>


<@c.page>
    <h2>Список задач</h2>
    <ul>
        <#list tasks as t>
        <li>#${t.id} | ${t.taskName} | ${t.beginData} | ${t.endData} | ${t.taskAuthor} | <a href="task?id=${t.id}">Детально</a> | <a href="edit?id=${t.id}">Редактировать</a> | <a href="remove?id=${t.id}">Удалить задачу</a></li>
        <#else>
            <h4>Список задач пуст</h4>
        </#list>
    </ul>
    <a href="/createtask">Создать новую задачу</a>
</@c.page>