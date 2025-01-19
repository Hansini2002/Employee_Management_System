import React from 'react';
import './style.css';

const Profile = () => {
  const user = {
    name: 'John Doe',
    email: 'johndoe@example.com',
    position: 'HR Manager',
    contact: '071',
    address: '242/1',
  };

  return (
    <div className="profile-container d-flex flex-column align-items-center py-5">
      

      
      <div className="profile-details text-center w-50 p-4 rounded shadow-lg bg-light">
        <h2 className="mb-3">{user.name}</h2>
        <p className="text-muted mb-1">
          <strong>Email:</strong> {user.email}
        </p>
        <p className="text-muted mb-1">
          <strong>Position:</strong> {user.position}
        </p>
        <p className="text-muted mb-1">
          <strong>Contact:</strong> {user.contact}
        </p>
        <p className="text-muted">
          <strong>Address:</strong> {user.address}
        </p>
      </div>
    </div>
  );
};

export default Profile;
