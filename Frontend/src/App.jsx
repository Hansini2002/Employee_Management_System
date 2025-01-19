import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import Login from './Components/Login'
import {BrowserRouter, Routes, Route, useNavigate} from 'react-router-dom'
import Dashboard from './Components/Dashboard'
import Home from './Components/Home'
import Employee from './Components/Employee'
import Position from './Components/Position'
import Profile from './Components/Profile'
import AddPosition from './Components/AddPosition'
import AddEmployee from './Components/AddEmployee'
import EditEmployee from './Components/EditEmployee'
import Start from './Components/Start'
import EmployeeLogin from './Components/EmployeeLogin'
import EmployeeDetail from './Components/EmployeeDetail'
import Leaves from './Components/LeaveDetails'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Start />} />
        <Route path="/adminlogin" element={<Login />} />
        <Route path="/employee_login" element={<EmployeeLogin />} />
        <Route path="/employee_detail/:id" element={<EmployeeDetail />} />
        <Route path="/dashboard" element={<Dashboard />}>
          <Route path="" element={<Home />} />
          <Route path="/dashboard/employee" element={<Employee />} />
          <Route path="/dashboard/position" element={<Position />} />
          <Route path="/dashboard/profile" element={<Profile />} />
          <Route path="/dashboard/add_position" element={<AddPosition />} />
          <Route path="/dashboard/add_employee" element={<AddEmployee />} />
          <Route path="/dashboard/edit_employee/:id" element={<EditEmployee />} />
          <Route path="/dashboard/leaves" element={<Leaves />} />
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
