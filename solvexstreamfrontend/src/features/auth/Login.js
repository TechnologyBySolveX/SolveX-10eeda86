// Login.js
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

function Login() {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const navigate = useNavigate();

  const handleLogin = async () => {
    const response = await fetch("http://localhost:8080/api/auth/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ userName, password })
    });
    const data = await response.text();
    setMessage(data);
    if(data==="Login successful!"){
        navigate("/profile")
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <input placeholder="Username" value={userName} onChange={e => setUserName(e.target.value)} />
      <input type="password" placeholder="Password" value={password} onChange={e => setPassword(e.target.value)} />
      <button onClick={handleLogin}>Login</button>
      <p>{message}</p>

      <p>Please Login here <Link to="/signUp">Sign Up here</Link></p>
    </div>
  );
}

export default Login;
