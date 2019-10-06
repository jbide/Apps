const webpack = require("webpack");
const path = require("path");
const CleanWwebpackPlugin = require("clean-webpack-plugin");
const HtmlWebpackPlugin = require("html-webpack-plugin");

process.env.NODE_ENV = "development";

module.exports = {
  //debug: true,
  mode: "development",
  devtool: "cheap-module-source-map",
  target: "web",
  //watch: true,

  entry: {
    app: "./src/index"
  },
  output: {
    path: path.resolve(__dirname, "build"),
    filename: "[name].bundle.js",
    publicPath: "/"
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: ["babel-loader", "eslint-loader"]
      },
      {
        test: /\.(css|scss)$/,
        use: ["style-loader", "css-loader", "sass-loader"]
      },
      {
        test: /\.(jpg|gif|png|svg)$/,
        use: ["file-loader"]
      },
      {
        test: /\.(ttf|woff|woff2|eot)$/,
        use: ["file-loader"]
      }
    ]
  },
  plugins: [
    new CleanWwebpackPlugin(),
    new HtmlWebpackPlugin({
      template: "src/index.html",
      filename: "index.html",
      favicon: ""
      //hash: true
    }),
    new webpack.NamedModulesPlugin(),
    //new StatsGraphPlugin(),
    new webpack.DefinePlugin({
      "process.env.NODE_ENV": JSON.stringify(process.env.NODE_ENV),
      "process.env.API_URL": JSON.stringify("http://localhost:3001")
    })

    //new webpack.HotModuleReplacementPlugin(),
    /*new webpack.optimize.CommonsChunkPlugin({
      name: "vendor"()
    })*/
    //new webpack.ProgressPlugin()
  ],
  devServer: {
    contentBase: path.resolve(__dirname, "build"),
    //watchContentBase: true, //for static content not managed by webpack
    publicPath: "/",
    stats: "minimal",
    overlay: true,
    historyApiFallback: true,
    inline: true
    //disableHostCheck: true,
    //headers: { "Access-Control-Allow-Origin": "*" },
    //https: false,
    //hotOnly: true or hotOnly: true to avoid reload fallback
  }
};
