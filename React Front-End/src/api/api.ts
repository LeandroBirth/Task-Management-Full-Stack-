import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

export const api = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        "Content-Type": "application/json",
    },
});

export const registerUser = async (userData: { username: string; password: string; role: string }) => {
    return api.post("/auth/register", userData);
};

export const loginUser = async (credentials: { username: string; password: string }) => {
    return api.post("/auth/login", credentials);
};

