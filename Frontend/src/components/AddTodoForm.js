import React, { useState } from 'react'
import Button from 'react-bootstrap/Button';

function AddTodoForm({handleAddTodo}) {
    const [value,setValue]=useState('')

    //to save
    const handleAddClick = () => {
        if(value.trim().length>0){
            handleAddTodo(value)  
            setValue('');
        }
     }
     const handleChange = (event) => {
            setValue(event.target.value); 
    }

    return (
        <form  className='form mt-3 mb-3'>
            <div className='flex-container'>
            <Button variant="primary" className='button' onClick={handleAddClick}>ADD</Button>
                <input type='text'
                 placeholder='type to add...' 
                 className='form-control'
                 value={value}
                 onChange={handleChange}>
                 </input>
             </div >
        </form>

    )
}

export default AddTodoForm