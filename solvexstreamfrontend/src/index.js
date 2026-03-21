import React from 'react';
import ReactDOM from 'react-dom/client';
import reportWebVitals from './reportWebVitals';
import { LoginUserusing } from './pages/login';
import { LoginForm } from './features/auth/LoginForm';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <LoginUserusing />
    <LoginForm />
  </React.StrictMode>
);


reportWebVitals();
