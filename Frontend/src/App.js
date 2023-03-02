import React, { useState,useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { nanoid } from 'nanoid'
import AddTodoForm from './components/AddTodoForm';
import TodoList from './components/TodoList';
import axios from 'axios';

function App() {
  // const [todos, setTodos] = useState([
  //   { id: nanoid(), title: 'todo1', completed: false },
  //   { id: nanoid(), title: 'todo2', completed: false },
  //   { id: nanoid(), title: 'todo3', completed: false },
  // ])

  /*_____________________________________________________ */
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/tasks')
      .then(response => {
        setTodos(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);
   /*_____________________________________________________ */

  //add todo
  const addTodo = (title) => {
    const newTodo = {
      id: nanoid(),
      title: title,
      completed: false
    }
    //console.log(newTodo);
    const newTodos = [...todos, newTodo]
    setTodos(newTodos);
  }



  //delete todo
  const deleteTodo = (id) => {
    const newTodos = todos.filter((todos) => todos.id !== id);{
      setTodos(newTodos);
  }
}


return (
  <div className='container'>
    <h2>TASK MANAGEMENT</h2>
    <h3>TODO:</h3>
    <AddTodoForm handleAddTodo={addTodo} />
    <TodoList todos={todos} handleDeleteTodo={deleteTodo}/>
  </div>

);
}

export default App;
