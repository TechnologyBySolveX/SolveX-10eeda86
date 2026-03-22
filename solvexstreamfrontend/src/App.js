import { Routes, Route } from 'react-router-dom';
import Home from './features/auth/Home';
import Login from './features/auth/Login';
import Signup from './features/auth/Signup';
import Profile from './features/auth/Profile';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/signup" element={<Signup />} />
      <Route path="/profile" element={<Profile />} />
    </Routes>
  );
}

export default App;
