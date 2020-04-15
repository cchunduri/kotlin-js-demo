config.resolve.modules.push("processedResources/Js/main");

config.devServer = config.devServer || {}
config.devServer.port = 4000

config.module.rules.push({
    test: /\.css$/,
    use: ["style-loader", "css-loader"]
});

config.module.rules.push({
    test: /\.(woff(2)?|ttf|eot|svg|gif|png|jpe?g)(\?v=\d+\.\d+\.\d+)?$/,
    use: [{
        loader: 'file-loader',
        options: {
            name: '[name].[ext]',
            outputPath: 'fonts/'
        }
    }]
});

console.info('Done Loading Webpack config..');