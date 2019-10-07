import React from "react";
import PropTypes from "prop-types";
import TextInput from "../common/TextInput";

const TodoForm = props => {
  const { todo, onSave, onChange, saving = false, errors = {} } = props;
  return (
    <form onSubmit={onSave}>
      <h2>{todo.id ? "Edit" : "Add"} Course</h2>
      <TextInput
        label="Name"
        name="name"
        onChange={onChange}
        placeHolder=""
        value={todo.name}
      />

      <TextInput
        label="Description"
        name="description"
        onChange={onChange}
        placeHolder=""
        value={todo.description}
      />

      <button type="submit" disabled={saving} className="btn btn-primary">
        {saving ? "Saving..." : "Save"}
      </button>
    </form>
  );
};

TodoForm.propTypes = {
  todo: PropTypes.object.isRequired,
  onSave: PropTypes.func.isRequired,
  onChange: PropTypes.func.isRequired,
  saving: PropTypes.bool,
  errors: PropTypes.object
};
export default TodoForm;
