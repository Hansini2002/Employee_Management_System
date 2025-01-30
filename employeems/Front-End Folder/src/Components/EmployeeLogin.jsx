import React, { useState } from 'react'
import './style.css'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const EmployeeLogin = () => {
    const [values, setValues] = useState({
        email: '',
        password: ''
    })
    const [error, setError] = useState(null)
    const navigate = useNavigate()
    axios.defaults.withCredentials = true;
    const handleSubmit = (event) => {
        event.preventDefault()
        axios.post('http://localhost:3000/employee/employee_login', values)
        .then(result => {
            if(result.data.loginStatus) {
                localStorage.setItem("valid", true)
                navigate('/employee_detail/'+result.data.id)
            } else {
                setError(result.data.Error)
            }
        })
        .catch(err => console.log(err))
    }

    return (
        <div className="d-flex justify-content-center align-items-center vh-100 bg-light login-page">
          <div className="p-4 rounded shadow-lg bg-white adminlogin-form " style={{ width: "400px", height: "400px" }}>
            
            {error && <div className="alert alert-danger text-center mb-3">{error}</div>}
      
            
            <h2 className="text-center text-primary mb-4">Login</h2>
            <form onSubmit={handleSubmit}>
              
              <div className="mb-4">
                <label htmlFor="email" className="form-label fw-bold">Email:</label>
                <input
                  type="email"
                  name="email"
                  id="email"
                  autoComplete="off"
                  placeholder="Enter your email"
                  onChange={(e) => setValues({ ...values, email: e.target.value })}
                  className="form-control"
                />
              </div>
      
              
              <div className="mb-4">
                <label htmlFor="password" className="form-label fw-bold">Password:</label>
                <input
                  type="password"
                  name="password"
                  id="password"
                  placeholder="Enter your password"
                  onChange={(e) => setValues({ ...values, password: e.target.value })}
                  className="form-control"
                />
              </div>
      
              
              <div className="d-flex justify-content-between align-items-center mb-4">
                <a
                  href="#"
                  className="text-primary text-decoration-none small"
                  onClick={() => alert("Redirect to forgot password page")}
                >
                  Forgot Password?
                </a>
              </div>
      
              
              <div className="d-flex justify-content-center">
              <button type="submit" className="btn btn-primary w-50 py-2">
                Log In
              </button>
              </div>
            </form>
          </div>
        </div>
      );
}

export default EmployeeLogin