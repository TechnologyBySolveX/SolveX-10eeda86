import { Routes, Route } from 'react-router-dom';
import Home from './features/auth/Home';
import Login from './features/auth/Login';
import Signup from './features/auth/Signup';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/signup" element={<Signup />} />
    </Routes>
  );
}

export default App;
