import 'bootstrap/dist/css/bootstrap.css';
import React from "react";

const Login = ({ username, password, onLogin, onChange }) => (
    <div class="jumbotron text-center">
        <h1>Welcome to Mini Stackoverflow!</h1>
        <p class="text-info">You have to Login first!</p> 
        <div>
            <label>Username: </label>
            <input value={username} onChange={ e => onChange("username", e.target.value)} />
            <br />
            <label>Password: </label>
            <input value={password} onChange={ e => onChange("password", e.target.value)} />
            <br />
            <button type="button" class="btn btn-info" onClick={onLogin}>Login</button>
        </div>
    </div>
);

export default Login;
