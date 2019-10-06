//import { green, red } from "chalk";
//import * as fs from "fs";
//import * as jsf from "json-schema-faker";
//import mockDataSchema from "./mockDataSchema";

const jsf = require("json-schema-faker");
const fs = require("fs");
const colors = require("chalk");
const mockDataSchema = require("./mockDataSchema");

const compiledmockDataSchema = jsf(mockDataSchema.schema);
console.log(compiledmockDataSchema);
const todos = compiledmockDataSchema.todos;
const json = JSON.stringify({
  todos
});

fs.writeFile("src/api/db.json", json, err => {
  if (err) {
    console.log(colors.red(err.message));
  } else {
    console.log(colors.green("Mock API data generated."));
  }
});
