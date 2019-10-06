import { handleResponse } from "./apiUtils";
const baseUrl = process.env.API_URL + "/todos/";

export function getTodos() {
  return fetch(baseUrl)
    .then(handleResponse)
    .catch(handleResponse);
}

export function saveTodo(todo) {
  return fetch(baseUrl + (todo.id || ""), {
    method: "POST",
    headers: { "content-type": "application/json" },
    body: JSON.stringify(todo)
  })
    .then(handleResponse)
    .catch(handleResponse);
}

export function deleteTodo(todo) {
  return fetch(baseUrl + todo.id, {
    method: "DELETE"
  })
    .then(handleResponse)
    .catch(handleResponse);
}
