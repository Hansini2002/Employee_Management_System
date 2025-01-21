import React, { useState } from 'react';
import './style.css';

const ManageLeaves = () => {
    const leaveData = [
      { id: 1, name: 'x', leaveType: 'Sick Leave', days: 2, status: 'Approved' },
      { id: 2, name: 'y', leaveType: 'Vacation Leave', days: 5, status: 'Pending' },
      { id: 3, name: 'z', leaveType: 'Casual Leave', days: 3, status: 'Rejected' },
    ];
  
    const handleUpdate = (id) => {
     
      navigate(`/dashboard/edit_leave/${id}`);
    };

    const handleDelete = (id) => {
        const confirmDelete = window.confirm('Are you sure you want to delete this leave?');
        if (confirmDelete) {
          setLeaveData(leaveData.filter((leave) => leave.id !== id));
        }
      };
  
    return (
      <div className="manage-leaves-container py-5">
        <h2 className="text-center mb-4">Employee Leave List</h2>
        <table className="table table-bordered table-striped">
          <thead className="thead-dark">
            <tr>
              <th>#</th>
              <th>Employee Name</th>
              <th>Leave Type</th>
              <th>Days</th>
              <th>Status</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {leaveData.map((leave) => (
              <tr key={leave.id}>
                <td>{leave.id}</td>
                <td>{leave.name}</td>
                <td>{leave.leaveType}</td>
                <td>{leave.days}</td>
                <td
                  className={
                    leave.status === 'Approved'
                      ? 'text-success'
                      : leave.status === 'Pending'
                      ? 'text-warning'
                      : 'text-danger'
                  }
                >
                  {leave.status}
                </td>
                <td>
                  <button
                    className="btn btn-primary btn-sm me-2"
                    onClick={() => handleUpdate(leave.id)}
                  >
                    Update
                  </button>
                  <button
                    className="btn btn-danger btn-sm"
                    onClick={() => handleDelete(leave.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  };
  
  export default ManageLeaves;
