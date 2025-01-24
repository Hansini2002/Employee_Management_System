import axios from 'axios'
import React, { useEffect, useState } from 'react'

const Home = () => {
  const [adminTotal, setAdminTotal] = useState(0)
  const [employeeTotal, setemployeeTotal] = useState(0)
  const [salaryTotal, setSalaryTotal] = useState(0)
  const [admins, setAdmins] = useState([])

  useEffect(() => {
    adminCount();
    employeeCount();
    salaryCount();
    AdminRecords();
  }, [])

  const AdminRecords = () => {
    axios.get('#')
    .then(result => {
      if(result.data.Status) {
        setAdmins(result.data.Result)
      } else {
         alert(result.data.Error)
      }
    })
  }
  const adminCount = () => {
    axios.get('#')
    .then(result => {
      if(result.data.Status) {
        setAdminTotal(result.data.Result[0].admin)
      }
    })
  }
  const employeeCount = () => {
    axios.get('#')
    .then(result => {
      if(result.data.Status) {
        setemployeeTotal(result.data.Result[0].employee)
      }
    })
  }
  const salaryCount = () => {
    axios.get('#')
    .then(result => {
      if(result.data.Status) {
        setSalaryTotal(result.data.Result[0].salaryOFEmp)
      } else {
        alert(result.data.Error)
      }
    })
  }
  return (
    <div>
      <div className="p-3">
  <div className="d-flex justify-content-around gap-4 mt-3">
    
    <div className="card border-0 shadow-lg text-white" style={{ backgroundColor: "#4d285b", width: "200px" }}>
      <div className="card-body text-center">
        <h4 className="card-title mb-3">Admin</h4>
        <hr className="bg-light" />
        <div className="d-flex justify-content-between mt-3">
          <h5>Total:</h5>
          <h5>{adminTotal}</h5>
        </div>
      </div>
    </div>

    
    <div className="card border-0 shadow-lg text-white" style={{ backgroundColor: "#9610c7", width: "200px" }}>
      <div className="card-body text-center">
        <h4 className="card-title mb-3">Employee</h4>
        <hr className="bg-light" />
        <div className="d-flex justify-content-between mt-3">
          <h5>Total:</h5>
          <h5>{employeeTotal}</h5>
        </div>
      </div>
    </div>

    
    <div className="card border-0 shadow-lg text-white" style={{ backgroundColor: "#6d359c", width: "200px" }}>
      <div className="card-body text-center">
        <h4 className="card-title mb-3">Salary</h4>
        <hr className="bg-light" />
        <div className="d-flex justify-content-between mt-3">
          <h5>Total:</h5>
          <h5>Rs.{salaryTotal}</h5>
        </div>
      </div>
    </div>
  </div>
</div>

      <div className='mt-4 px-5 pt-3'>
        <h3>List of Admins</h3>
        <table className='table'>
          <thead>
            <tr>
              <th>Email</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {
              admins.map(a => (
                <tr>
                  <td>{a.email}</td>
                  <td>
                  <button
                    className="btn btn-info btn-sm me-2">
                    Edit
                  </button>
                  <button
                    className="btn btn-warning btn-sm" >
                    Delete
                  </button>
                  </td>
                </tr>
              ))
            }
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default Home