config.resolve.modules.push("processedResources/Js/main");

config.module.rules.push({
    test: /\.css$/,
    loader: 'style-loader!css-loader'
});

console.info('Done Loading Webpack config..');