import React, { createContext, useState, ReactNode } from "react";
import { loginUser } from "../api/api";

interface AuthContextType {
    token: string | null;
    login: (username: string, password: string) => Promise<void>;
    logout: () => void;
}

export const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider = ({ children }: { children: ReactNode }) => {
    const [token, setToken] = useState<string | null>(null);

    const login = async (username: string, password: string) => {
        const response = await loginUser({ username, password });
        setToken(response.data.token);
        localStorage.setItem("token", response.data.token);
    };

    const logout = () => {
        setToken(null);
        localStorage.removeItem("token");
    };

    return <AuthContext.Provider value={{ token, login, logout }}>{children}</AuthContext.Provider>;
};
