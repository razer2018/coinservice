/**
 * Webpack Config Production
 */

'use strict';

var webpack = require('webpack');
var path = require('path');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
var CopyWebpackPlugin = require('copy-webpack-plugin');
var _ = require('lodash');

var prodPlugins = [
  new webpack.IgnorePlugin(/^\.\/locale$/, /moment$/),//禁止moment打包locale文件减小体积
  new webpack.optimize.OccurrenceOrderPlugin(),
  new webpack.optimize.DedupePlugin(),
  new webpack.optimize.CommonsChunkPlugin({
      minChunks: 2,
      name: "vendor"
    }),
  new ExtractTextPlugin("[name].css"),
  new webpack.optimize.UglifyJsPlugin({
    compressor: {
      warnings: false,
      screw_ie8: true
    }
  }),
  new CopyWebpackPlugin([{ from: 'images', to: 'images' }]),
  new webpack.DefinePlugin({
    'process.env': {
      NODE_ENV: JSON.stringify('production')
    }
  })
];

var webpackDevConfig = require('./webpack.dev.config.js');

var webpackProdConfig = _.extend(webpackDevConfig, {
  devtool: false,
  entry: {
    app: ["babel-polyfill",  __dirname + '/src/app.js'],
    vendor: ['jquery','vue', 'bootstrap','moment','numeral' ]
  },
  output: {
    path: path.resolve(__dirname, '../') + '/src/main/resources/static/static/',
    publicPath: '/cloud/static/',
    filename: '[name].js'
  },
  plugins: webpackDevConfig.plugins.concat(prodPlugins)
});

module.exports = webpackProdConfig;
