import React, { Component } from "react";
import PropTypes from "prop-types";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import * as todoActions from "../../redux/actions/todoActions";
import TodoForm from "./TodoForm";
import Todo from "./Todo";

class TodoManagePage extends Component {
  constructor(props) {
    super(props);

    this.state = {
      todo: Todo(),
      errors: {}
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSave = this.handleSave.bind(this);
    console.log(props);
  }

  componentDidMount() {
    if (this.props.todos.length === 0) {
      console.log("coucouuu");
      this.props.actions.loadListTodo();
    }
    console.log("====>  " + this.props.match.params.id);

    this.setState({
      todo: this.props.todo,
      errors: {}
    });
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    if (prevProps.todo != this.props.todo) {
      console.log("====>  Did update");
      this.setState({
        todo: this.props.todo,
        errors: {}
      });
    }
  }

  handleChange(event) {
    const { name, value } = event.target;
    this.setState((prevState, props) => {
      return { todo: { ...prevState.todo, [name]: value } };
    });
  }

  handleSave(event) {
    event.preventDefault();
    this.props.actions.saveTodo(this.state.todo);
    this.props.history.push("/todos");
  }

  render() {
    return (
      <TodoForm
        todo={this.state.todo}
        onChange={this.handleChange}
        onSave={this.handleSave}
        errors={this.state.errors}
      />
    );
  }
}

TodoManagePage.propTypes = {
  params: PropTypes.object,
  match: PropTypes.object,
  todos: PropTypes.array.isRequired,
  todo: PropTypes.object,
  history: PropTypes.object,
  actions: PropTypes.object.isRequired
};

function mapStateToProps(state, ownProps) {
  let id = ownProps.match.params.id;
  let todolist = state.todos;
  return {
    todos: todolist,
    todo:
      id === "0" || todolist.length === 0
        ? Todo()
        : todolist.find(todo => todo.id === id)
  };
}

function mapDispatchToProps(dispatch) {
  return {
    actions: bindActionCreators(todoActions, dispatch)
  };
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TodoManagePage);
