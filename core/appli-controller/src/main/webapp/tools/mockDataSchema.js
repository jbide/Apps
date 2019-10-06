const schema = {
  type: "object",
  properties: {
    todos: {
      type: "array",
      minItems: 3,
      maxItems: 6,
      items: {
        type: "object",
        properties: {
          id: {
            type: "number",
            unique: true,
            minimum: 1
          },
          name: {
            type: "string",
            faker: "name.lastname"
          },
          description: {
            type: "string",
            faker: "random.description"
          }
        },
        required: ["id", "name", "description"]
      }
    }
  },
  required: ["todos"]
};

module.exports = {
  schema: schema
};
