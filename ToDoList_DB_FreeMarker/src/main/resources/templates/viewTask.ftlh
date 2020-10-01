<#import "parts/template.ftlh" as c>

<@c.page>
    <#if task??>
        <h3>Просмотр задачи #${task.id}</h3>
        <p>Наименование задачи: ${task.taskName}</p>
        <p>Описание: ${task.description}</p>
        <p>Владелец задачи: ${task.taskAuthor}</p>
        <P>Актуально? ${task.isActual}</P>
        <p>Дата начала: ${task.beginData}</p>
        <p>Дата окончания: ${task.endData}</p>
        <p>Завершено? ${task.isCompleted}</p>
    </#if>
    <a href="/">Назад к списку задач</a>
</@c.page>