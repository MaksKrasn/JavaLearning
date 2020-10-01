<#import "parts/template.ftlh" as c>

<@c.page>
    <h3>Редактирование задачи</h3>
    <#if task??>
    <form method="post">
        <input type="hidden" name="id" value="${task.id}">
        <div>
            <label>Наименование задачи:
                <input type="text" name="taskName" value="${task.taskName}">
            </label>
        </div>
        <div>
            <label>Описание:
                <input type="text" name="description" value="${task.description}">
            </label>
        </div>
        <div>
            <label>Актуальность:
                <input type="text" name="isActual" value="${task.isActual}">
            </label>
        </div>
        <div>
            <label>Дата начала:
                <input type="text" name="beginData" value="${task.beginData}">
            </label>
        </div>
        <div>
            <label>Дата окончания:
                <input type="text" name="endData" value="${task.endData}">
            </label>
        </div>
        <div>
            <label>Выполнение задачи:
                <input type="text" name="isCompleted" value="${task.isCompleted}">
            </label>
        </div>
        <div>
            <label>Владелец задачи:
                <input type="text" name="taskAuthor" value="${task.taskAuthor}">
            </label>
        </div>
        <button>Save</button>
    </form>
    </#if>
</@c.page>