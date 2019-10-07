const jsonServer = require("json-server");
const server = jsonServer.create();
const path = require("path");
const router = jsonServer.router(
  path.join(__dirname, "..", "src", "api", "db.json")
);

const middlewares = jsonServer.defaults();

server.use(middlewares);

server.use(jsonServer.bodyParser);

server.use(function(req, res, next) {
  setTimeout(next, 2000);
});

server.use((req, res, next) => {
  if (req.method === "POST") {
    req.body.createdAt = Date.now();
  }

  next();
});

server.post("/todos/", function(req, res, next) {
  const error = validateTodo(req.body);

  if (error) {
    res.status(400).send(error);
  } else {
    req.body.id = createId(req.body.name);
    next();
  }
});

server.use(router);

const port = 3001;

server.listen(port, () => {
  console.log(`JSON server is running on port ${port}`);
});

function createId(value) {
  return value
    .replace(/[^a-z0-9_]+/gi, "-")
    .replace(/^-|-$/g, "")
    .toLowerCase();
}

function validateTodo(todo) {
  if (!todo.name) return "Name is required";
  return "";
}
