const path = require('path');
const WebpackWatchedGlobEntries = require('webpack-watched-glob-entries-plugin');

const entries = WebpackWatchedGlobEntries.getEntries([path.resolve(__dirname, './src/**/**/*.js')], {
    ignore: path.resolve(__dirname, './src/**/**/_*.js'),
})();

module.exports = (outputFile) => ({
    entry: entries,

    output: {
        path: path.resolve(__dirname, './build'),
        filename: `./${outputFile}.bundle.js`,
    },
    resolve: {
        //modules: [path.resolve(__dirname, "node_modules")],
        extensions: ['.js', '.jsx', '.ts', '.tsx'],
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                use: [
                    'style-loader',
                    {
                        loader: 'css-loader',
                        options: {
                            url: false
                        }
                    },
                ],
            },
            {
                test: /\.ts$/,
                use: "ts-loader",
            },
            {
                test: [/\.js$/, /\.jsx$/, /\.jsx$/],
                use: [
                    {
                        loader: "babel-loader",
                        options: {
                            presets: ["@babel/preset-env", "@babel/preset-react"],
                        },
                    },
                    {
                        loader: 'ts-loader',
                        options: { appendTsSuffixTo: [/\.ts$/] }
                    }
                ],
            },
        ],
    },

    plugins: [
        new WebpackWatchedGlobEntries(),

    ]
});