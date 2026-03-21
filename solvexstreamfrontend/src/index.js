import React from 'react';
import ReactDOM from 'react-dom/client';
import App, { Footer, Hello, Hi } from './App';
import reportWebVitals from './reportWebVitals';
import { NewfileMethod } from './newfile';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
    <Hi />
    <Footer/>
    <Hello />
     <NewfileMethod />
  </React.StrictMode>
);


reportWebVitals();
