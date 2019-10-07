const webpack = require("webpack");
const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const CleanWwebpackPlugin = require("clean-webpack-plugin");
const WebpackMd5Hash = require("webpack-md5-hash");
const WebpackBundleAnalyzer = require("webpack-bundle-analyzer");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const UglifyJsPlugin = require("uglifyjs-webpack-plugin");

process.env.NODE_ENV = "production";

module.exports = {
  mode: "production",
  devtool: "source-map",
  target: "web",

  entry: {
    app: "./src/index"
  },
  output: {
    path: path.resolve(__dirname, "build"),
    filename: "[name].[chunkhash].bundle.js",
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
        test: /\.(scss|css)$/,
        use: [
          MiniCssExtractPlugin.loader,
          { loader: "css-loader", options: { sourceMap: true } },
          {
            loader: "postcss-loader",
            options: {
              plugins: () => [require("cssnano")],
              sourceMap: true
            }
          },
          "sass-loader"
        ]
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
    //display bundle stats when build completed
    new WebpackBundleAnalyzer.BundleAnalyzerPlugin({
      analyzerMode: "disabled",
      generateStatsFile: true
    }),
    new MiniCssExtractPlugin({ filename: "[name].[contenthash].css" }),
    new webpack.DefinePlugin({
      "process.env.NODE_ENV": JSON.stringify(process.env.NODE_ENV),
      "process.env.API_URL": JSON.stringify("http://192.168.2.43:8180/api")
    }),
    new HtmlWebpackPlugin({
      template: "src/index.html",
      filename: "index.html",
      favicon: "",
      //hash: true,
      minify: {
        removeComments: true,
        collapseWhitespace: true,
        removeRedundantAttributes: true,
        useShortDoctype: true,
        removeEmptyAttributes: true,
        removeStyleLinkTypeAttributes: true,
        keepClosingSlash: true,
        minifyJS: true,
        minifyCSS: true,
        minifyURLs: true
      }
    }),
    new webpack.NamedModulesPlugin(),

    new CleanWwebpackPlugin(),
    new WebpackMd5Hash()
    /*new webpack.optimize.CommonsChunkPlugin({
      name: "vendor"()
    })*/
  ],
  optimization: {
    minimizer: [
      new UglifyJsPlugin({
        sourceMap: true
      })
    ]
  },
  devServer: {
    contentBase: path.resolve(__dirname, "build"),
    //watchContentBase: true, //for static content not managed by webpack
    publicPath: "/",
    stats: "minimal",
    overlay: true,
    historyApiFallback: true,
    inline: true
    //https: false
    //hotOnly: true or hotOnly: true to avoid reload fallback
  }
};
