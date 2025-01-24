import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const AddLeave = () => {
  const [leave, setLeave] = useState({
    employeeName: "",
    leaveType: "",
    startDate: "",
    endDate: "",
    reason: "",
  });
  const [leaveTypes, setLeaveTypes] = useState([]);
  const navigate = useNavigate()

  useEffect(() => {
    axios
      .get("#")
      .then((result) => {
        if (result.data.Status) {
          setLeaveTypes(result.data.Result);
        } else {
          alert(result.data.Error);
        }
      })
      .catch((err) => console.log(err));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault()
    const formData = new FormData();
    formData.append('employeeName', leave.employeeName);
    formData.append('leaveType', leave.leaveType);
    formData.append('startDate', leave.startDate);
    formData.append('endDate', leave.endDate);
    formData.append('reason', leave.reason);

    axios.post('#', formData)
    .then(result => {
        if(result.data.Status) {
            navigate('/dashboard/leave')
        } else {
            alert(result.data.Error)
        }
    })
    .catch(err => console.log(err))
  }

  return (
    <div className="d-flex justify-content-center align-items-center mt-3">
      <div className="p-3 rounded w-50 border">
        <h3 className="text-center">Add Leave</h3>
        <form className="row g-1" onSubmit={handleSubmit}>
          <div className="col-12">
            <label for="inputEmployeeName" className="form-label">
              Employee Name
            </label>
            <input
              type="text"
              className="form-control rounded-0"
              id="inputEmployeeName"
              placeholder="Enter Employee Name"
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
              {leaveTypes.map((l) => {
                return <option value={l.id}>{l.name}</option>;
              })}
            </select>
          </div>
          <div className="col-12">
            <label for="inputStartDate" className="form-label">
              Start Date
            </label>
            <input
              type="date"
              className="form-control rounded-0"
              id="inputStartDate"
              onChange={(e) =>
                setLeave({ ...leave, startDate: e.target.value })
              }
            />
          </div>
          <div className="col-12">
            <label for="inputEndDate" className="form-label">
              End Date
            </label>
            <input
              type="date"
              className="form-control rounded-0"
              id="inputEndDate"
              onChange={(e) =>
                setLeave({ ...leave, endDate: e.target.value })
              }
            />
          </div>
          <div className="col-12">
            <label for="inputReason" className="form-label">
              Reason
            </label>
            <textarea
              className="form-control rounded-0"
              id="inputReason"
              placeholder="Enter Reason"
              onChange={(e) =>
                setLeave({ ...leave, reason: e.target.value })
              }
            ></textarea>
          </div>
          <div className="col-12">
            <button type="submit" className="btn btn-primary w-100">
              Add Leave
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default AddLeave;
