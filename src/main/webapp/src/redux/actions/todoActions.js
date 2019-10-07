import * as types from "./actionTypes";
import * as todoApis from "../../api/TodoApi";

let todos = [{ id: "1", name: "creer", description: "blabla", date: "juin" }];

export function loadListTodo() {
  return function(dispatch) {
    todoApis.getTodos().then(todos => dispatch(loadListTodoSuccess(todos)));
  };
}

export function loadListTodoSuccess(todos) {
  return { type: types.LOAD_LIST_TODO_SUCESS, todos: todos };
}

export function saveTodo(todo) {
  let savedTodo = { ...todo, id: "2" };
  todos = [...todos].push(savedTodo);

  return function(dispatch) {
    return todo.id === "0"
      ? dispatch(createTodoSuccess(savedTodo))
      : dispatch(updateTodoSuccess(savedTodo));
  };
}

export function createTodoSuccess(todo) {
  return { type: types.SAVE_TODO_SUCCESS, todo: todo };
}

export function updateTodoSuccess(todo) {
  return { type: types.UPDATE_TODO_SUCCESS, todo: todo };
}
