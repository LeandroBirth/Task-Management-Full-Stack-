import api from "./api";

// User Registration
export const registerUser = async (username: string, password: string) => {
  return api.post("/auth/register", { username, password, role: "user" });
};

// User Login
export const loginUser = async (username: string, password: string) => {
  return api.post("/auth/login", { username, password });
};
