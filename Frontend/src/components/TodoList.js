import React from 'react'
import TodoItem from './TodoItem'

function TodoList({todos,handleDeleteTodo}) {
  return (
    <div className='todo-list'>
      {todos.map((todo)=>(
        <TodoItem id={todo.id}
                  title={todo.title}
                  completed={todo.completed}
                  handleDeleteTodo={handleDeleteTodo}/>
      ))}
    </div>
  )
}

export default TodoList