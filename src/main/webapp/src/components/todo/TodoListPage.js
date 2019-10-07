import React from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import * as todoActions from "../../redux/actions/todoActions";

class TodoListPage extends React.Component {
  constructor(props) {
    super(props);
  }

  static willTransitionTo(transition) {
    debugger;
    return transition.redirect("/", {}, { nextPath: transition.path });
  }

  componentDidMount() {
    if (this.props.todos.length === 0) {
      this.props.actions.loadListTodo();
    }
  }

  render() {
    return (
      <div>
        <table>
          <thead>
            <tr>
              <th>Nom</th>
              <th>Description</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {this.props.todos.map(todo => (
              <tr key={todo.id}>
                <td>{todo.name}</td>
                <td>{todo.description}</td>
                <td>
                  <Link to={`${this.props.match.path}/${todo.id}`}>Edit</Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>

        <Link to={`${this.props.match.path}/0`}>
          <button className="btn btn-primary">Add todo</button>
        </Link>
      </div>
    );
  }
}

TodoListPage.propTypes = {
  match: PropTypes.object.isRequired,
  todos: PropTypes.array.isRequired,
  actions: PropTypes.object.isRequired
};

function mapStateToProps(state) {
  return {
    todos: state.todos
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
)(TodoListPage);
