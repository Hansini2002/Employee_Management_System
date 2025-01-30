import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'


const EmployeeDetail = () => {
    const [employee, setEmployee] = useState([])
    const {id} = useParams()
    const navigate = useNavigate()
    useEffect(() => {
        axios.get('http://localhost:3000/employee/detail/'+id)
        .then(result => {
            setEmployee(result.data[0])
        })
        .catch(err => console.log(err))
    }, [])
    const handleLogout = () => {
        axios.get('http://localhost:3000/employee/logout')
        .then(result => {
          if(result.data.Status) {
            localStorage.removeItem("valid")
            navigate('/')
          }
        }).catch(err => console.log(err))
      }
      return (
        <div className="container mt-4">
         
          <div className="p-3 text-center shadow-sm bg-light rounded">
            <h3 className="fw-bold text-primary">Employee Management System</h3>
          </div>
      
          
          <div className="card mt-4 p-4 text-center shadow-lg border-0" style={{ maxWidth: "500px", margin: "0 auto" }}>
            
            <div className="d-flex justify-content-center">
              <img 
                src={`http://localhost:3000/Images/` + employee.image} 
                className="rounded-circle shadow-sm" 
                alt="Employee"
                style={{ width: "150px", height: "150px", objectFit: "cover" }} 
              />
            </div>
      
            <div className="mt-4">
              <h4 className="fw-semibold">Name: <span className="text-secondary">{employee.name}</span></h4>
              <h5 className="fw-normal mt-2">Email: <span className="text-muted">{employee.email}</span></h5>
              <h5 className="fw-normal">Salary: <span className="text-success">Rs. {employee.salary}</span></h5>
            </div>
      
            
            <div className="mt-4">
              <button className="btn btn-outline-primary me-3 px-4">Edit</button>
              <button className="btn btn-danger px-4" onClick={handleLogout}>Logout</button>
            </div>
          </div>
        </div>
      );
      
      
}

export default EmployeeDetail