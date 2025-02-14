import api from "./api";

// Get all tasks
export const getTasks = async () => {
  return api.get("/tasks");
};

// Create a new task
export const createTask = async (title: string, description: string) => {
  return api.post("/tasks", { title, description });
};

// Delete a task
export const deleteTask = async (taskId: number) => {
  return api.delete(`/tasks/${taskId}`);
};
