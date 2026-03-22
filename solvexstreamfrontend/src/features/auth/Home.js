// Home.js
import React from 'react';
import { Link } from 'react-router-dom';
import '../../assets/Home.css';

function Home() {
  return (
    <div>
      {/* Navigation Bar */}
      <nav className="navbar">
        <h1 className="logo">SolveXStreamApp</h1>
        <ul className="nav-links">
            <li><Link to="/login">Login</Link></li>
            <li><Link to="/signup">Sign Up</Link></li>
        </ul>

      </nav>

      {/* Hero Section */}
      <header className="hero">
        <h2>Welcome to SolveXStreamApp</h2>
        <p>Your gateway to solving problems and streaming solutions seamlessly.</p>
      </header>

      {/* SolveX Section */}
      <section className="section">
        <h3>About SolveX</h3>
        <p>
          SolveX is designed to help you tackle complex challenges with smart tools,
          analytics, and collaboration features. It empowers individuals and teams
          to break down problems and find actionable solutions.
        </p>
      </section>

      {/* SolveXStream Section */}
      <section className="section">
        <h3>About SolveXStream</h3>
        <p>
          SolveXStream brings real-time streaming of solutions, discussions, and
          collaborative workflows. It ensures that knowledge flows continuously
          and efficiently across your projects.
        </p>
      </section>
    </div>
  );
}

export default Home;
