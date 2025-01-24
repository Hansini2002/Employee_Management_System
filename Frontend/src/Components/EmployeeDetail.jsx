import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const EmployeeDetail = () => {
    const [employee, setEmployee] = useState(null);
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('#' + id)
            .then(result => {
                if (result.data.length > 0) {
                    setEmployee(result.data[0]);
                } else {
                    alert("Employee not found");
                    navigate('/dashboard');
                }
            })
            .catch(err => console.log(err));
    }, [id, navigate]);

    const handleLogout = () => {
        axios.get('#')
            .then(result => {
                if (result.data.Status) {
                    localStorage.removeItem("valid");
                    navigate('/');
                }
            }).catch(err => console.log(err));
    };

    const handleEdit = () => {
        navigate(`/dashboard/edit_employee/${id}`);
    };

    const handleAddLeave = () => {
        navigate(`/dashboard/add_leave/${id}`);
    };

    if (!employee) {
        return <div className="text-center mt-5">Loading...</div>;
    }

    return (
        <div>
            <div className="p-2 d-flex justify-content-center shadow">
                <h4>Employee Management System</h4>
            </div>
            <div className='d-flex justify-content-center flex-column align-items-center mt-3'>
                <img src={`#` + employee.image} className='emp_det_image' alt="Employee" />
                <div className='d-flex align-items-center flex-column mt-5'>
                    <h3>Name: {employee.name}</h3>
                    <h3>Email: {employee.email}</h3>
                    <h3>Salary: ${employee.salary}</h3>
                </div>
                <div className='mt-3'>
                    <button className='btn btn-primary me-2' onClick={handleEdit}>Edit</button>
                    <button className='btn btn-success me-2' onClick={handleAddLeave}>Add Leave</button>
                    <button className='btn btn-danger' onClick={handleLogout}>Logout</button>
                </div>
            </div>
        </div>
    );
};

export default EmployeeDetail;
