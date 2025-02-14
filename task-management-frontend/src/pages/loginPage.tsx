import React, { useState } from "react";
import { loginUser } from "../services/authService";
import "../styles/LoginPage.css"

const LoginPage = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const response = await loginUser(username, password);
      console.log("Login Success:", response.data);
      alert("Logged in successfully!");
    } catch (error) {
      console.error("Login Error:", error);
      alert("Login failed. Please check your credentials.");
    }
  };
  return (
    <div className="login-container">
      <h1 className="title">Task Management</h1>
      <div className="login-box">
        <h2>Login</h2>
        <form onSubmit={handleLogin}>
          <input type="text" placeholder="Username" value={username} onChange={(e) => setUsername(e.target.value)} />
          <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} />
          <button type="submit">Login</button>
        </form>
        <p className="footer">Created by: Leandro Birth <a href="https://www.leandrobirth.com" target="_blank" rel="noopener noreferrer">www.leandrobirth.com</a></p>
      </div>
    </div>
  );
};

export default LoginPage;
