const path = require('path');
const { merge } = require('webpack-merge');
const common = require('./webpack.common.js');
const outputFile = '[name]';
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

const WebpackWatchedGlobEntries = require('webpack-watched-glob-entries-plugin');

const entries = WebpackWatchedGlobEntries.getEntries([path.resolve(__dirname, './src/js/**/*.js')], {
    ignore: path.resolve(__dirname, './src/js/**/_*.js'),
})();

const HtmlWebpackPlugin = require("html-webpack-plugin");
const htmlGlobPlugins = (entries, srcPath) => {
    return Object.keys(entries).map((key) =>
        new HtmlWebpackPlugin({
            inject: 'body',
            filename: `${key}.html`,
            //template: `${srcPath}/${key}.html`,
            template: `html/${key}.html`,
            chunks: [key],
        })
    );
};

module.exports = merge(common(outputFile), {
    mode: 'development',
    devtool: 'source-map',

    plugins: [
        new HtmlWebpackPlugin({
            title: 'RouteMe',
            hash: false,
            template: `html/index.html`,
            //template: `${path.public}/index.html`,
            //template: path.resolve(__dirname, "src/index.html"),
            filename: 'index.html',
            inject: true,
            collapseWhitespace: true,
            removeComments: true,
            removeRedundantAttributes: true,
            removeScriptTypeAttributes: true,
            removeStyleLinkTypeAttributes: true,
            useShortDoctype: true
        }),
        new MiniCssExtractPlugin({
            filename: './css/[name].css',
        }),
        ...htmlGlobPlugins(entries, './src')
    ],
    devServer: {
        static: {
            directory: path.resolve(__dirname, "./build"),
        }
    }

});