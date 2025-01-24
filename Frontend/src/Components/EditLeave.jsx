import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const EditLeaveDetails = () => {
    const {id} = useParams()
    const [leave, setLeave] = useState({
        employeeName: "",
        leaveType: "",
        startDate: "",
        endDate: "",
        reason: "",
      });
      const [leaveTypes, setLeaveTypes] = useState([])
      const navigate = useNavigate()

      useEffect(()=> {
        axios.get('/api/leavetypes')
        .then(result => {
            if(result.data.Status) {
                setLeaveTypes(result.data.Result);
            } else {
                alert(result.data.Error)
            }
        }).catch(err => console.log(err))

        axios.get(`/api/leaves/${id}`)
        .then(result => {
            setLeave({
                ...leave,
                employeeName: result.data.Result[0].employeeName,
                leaveType: result.data.Result[0].leaveType,
                startDate: result.data.Result[0].startDate,
                endDate: result.data.Result[0].endDate,
                reason: result.data.Result[0].reason,
            })
        }).catch(err => console.log(err))
    }, [])

    const handleSubmit = (e) => {
        e.preventDefault()
        axios.put(`/api/leaves/${id}`, leave)
        .then(result => {
            if(result.data.Status) {
                navigate('/dashboard/leaves')
            } else {
                alert(result.data.Error)
            }
        }).catch(err => console.log(err))
    }
    
  return (
    <div className="d-flex justify-content-center align-items-center mt-3">
      <div className="p-3 rounded w-50 border">
        <h3 className="text-center">Edit Leave Details</h3>
        <form className="row g-1" onSubmit={handleSubmit}>
          <div className="col-12">
            <label for="employeeName" className="form-label">
              Employee Name
            </label>
            <input
              type="text"
              className="form-control rounded-0"
              id="employeeName"
              placeholder="Enter Employee Name"
              value={leave.employeeName}
              onChange={(e) =>
                setLeave({ ...leave, employeeName: e.target.value })
              }
            />
          </div>
          <div className="col-12">
            <label for="leaveType" className="form-label">
              Leave Type
            </label>
            <select name="leaveType" id="leaveType" className="form-select"
                onChange={(e) => setLeave({...leave, leaveType: e.target.value})}>
              {leaveTypes.map((lt) => {
                return <option key={lt.id} value={lt.id}>{lt.name}</option>;
              })}
            </select>
          </div>
          <div className='col-12'>
            <label for="startDate" className="form-label">
              Start Date
            </label>
            <input
              type="date"
              className="form-control rounded-0"
              id="startDate"
              value={leave.startDate}
              onChange={(e) =>
                setLeave({ ...leave, startDate: e.target.value })
              }
            />
          </div>
          <div className="col-12">
            <label for="endDate" className="form-label">
              End Date
            </label>
            <input
              type="date"
              className="form-control rounded-0"
              id="endDate"
              value={leave.endDate}
              onChange={(e) =>
                setLeave({ ...leave, endDate: e.target.value })
              }
            />
          </div>
          <div className="col-12">
            <label for="reason" className="form-label">
              Reason
            </label>
            <textarea
              className="form-control rounded-0"
              id="reason"
              placeholder="Enter Reason"
              value={leave.reason}
              onChange={(e) =>
                setLeave({ ...leave, reason: e.target.value })
              }
            />
          </div>
          <div className="col-12">
            <button type="submit" className="btn btn-primary w-100">
              Edit Leave Details
            </button>
          </div>
        </form>
      </div>
    </div>
  )
}

export default EditLeaveDetails
