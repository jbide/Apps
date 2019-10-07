import * as types from "../actions/actionTypes";
import initialState from "./initialState";

export default function todoReducer(state = initialState.todos, action) {
  switch (action.type) {
    case types.SAVE_TODO_SUCCESS:
      return [...state, { ...action.todo }];
    case types.UPDATE_TODO_SUCCESS:
      return state.map(todo =>
        todo.id === action.todo.id ? action.todo : todo
      );
    case types.LOAD_LIST_TODO_SUCESS:
      return action.todos;
    default:
      return state;
  }
}
