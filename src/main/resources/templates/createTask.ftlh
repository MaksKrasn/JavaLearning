<#import "parts/template.ftlh" as c>

<@c.page>
<h3>Create new task</h3>
<form method="post">
    <div>
        <label>Наименование задачи:
            <input type="text" name="taskName">
        </label>
    </div>
    <div>
        <label>Описание:
            <input type="text" name="description">
        </label>
    </div>
    <div>
        <label>Дата начала:
            <input type="text" name="beginData" >
        </label>
    </div>
    <div>
        <label>Дата окончания:
            <input type="text" name="endData" >
        </label>
    </div>
    <div>
        <label>Владелец задачи:
            <input type="text" name="taskAuthor" >
        </label>
    </div>
    <button>Add</button>
</form>
</@c.page>