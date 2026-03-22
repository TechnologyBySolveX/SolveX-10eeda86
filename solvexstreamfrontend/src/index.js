import React from 'react';
import ReactDOM from 'react-dom/client';
import reportWebVitals from './reportWebVitals';
import { LoginUserusing } from './pages/login';
import Signup from './features/auth/Signup';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Signup />
  </React.StrictMode>
);


reportWebVitals();
