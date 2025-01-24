import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

const Position = () => {

    const [position, setPosition] = useState([])

    useEffect(()=> {
        axios.get('#')
        .then(result => {
            if(result.data.Status) {
                setPosition(result.data.Result);
            } else {
                alert(result.data.Error)
            }
        }).catch(err => console.log(err))
    }, [])
  return (
    <div className='px-5 mt-3'>
        <div className='d-flex justify-content-center'>
            <h3>Positions</h3>
        </div>
        <Link to="/dashboard/add_position" className='btn btn-success'>Add New Position</Link>
        <div className='mt-3'>
            <table className='table'>
                <thead>
                    <tr>
                        <th>Name</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        position.map(p => (
                            <tr>
                                <td>{p.name}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>

    </div>
  )
}

export default Position