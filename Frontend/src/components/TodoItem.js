import React from 'react'
import { Button } from 'react-bootstrap';


function TodoItem({ id, title,completed, handleDeleteTodo}) {

    return (
        <li className='list-group-item'>
            <div className='listitem d-flex justify-content-between border'>
            <span className='d-flex align-items-center'>
                <input type="checkbox"  className='checkbox me-3'></input>
                 <span>{title}</span>
                 </span>

                 <Button variant="danger"  onClick={() => { handleDeleteTodo(id) }}>DELETE</Button>
  
        </div>
        </li>
    )
}

export default TodoItem;