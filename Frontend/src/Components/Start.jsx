import axios from "axios";
import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
useEffect

const Start = () => {
    const navigate = useNavigate()
  axios.defaults.withCredentials = true;
  useEffect(() => {
    axios.get('#')
    .then(result => {
      if(result.data.Status) {
        if(result.data.role === "admin") {
          navigate('/dashboard')
        } else {
          navigate('/employee_detail/'+result.data.id)
        }
      }
    }).catch(err =>console.log(err))
  }, [])

  return (
    <div className="d-flex justify-content-center align-items-center vh-100 login-page">
      <div className="p-4 rounded w-25 border login-form">
        <h2 className="text-center mb-4">Select Login Role</h2>
        <div className="login-buttons d-flex justify-content-around">
          <button
            type="button"
            className="btn btn-primary mx-4"
            onClick={() => navigate('/employee_login')}
          >
            <h2 className="text-center">Employee</h2>
          </button>
          <button
            type="button"
            className="btn btn-success"
            onClick={() => navigate('/adminlogin')}
          >
            <h2 className="text-center">Admin</h2>
          </button>
        </div>
      </div>
    </div>
  );
};

export default Start;
