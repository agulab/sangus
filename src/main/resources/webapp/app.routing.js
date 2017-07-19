'use strict';
var app = angular.module('sangus');

app.config(function($locationProvider, $routeProvider) {
    // Routing
    $routeProvider.
    when('/web/', {
        controller: 'HomeCtrl',
        templateUrl: 'pages/home/template.html'
    });
    // DEFAULT
    otherwise('/web/');

    // configure html5 to get links working on jsfiddle
    $locationProvider.html5Mode(true);
});

