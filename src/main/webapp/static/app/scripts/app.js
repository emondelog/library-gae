'use strict';

/**
 * @ngdoc overview
 * @name libraryGaeApp
 * @description
 * # libraryGaeApp
 *
 * Main module of the application.
 */
angular
  .module('libraryGaeApp', [
    'environment',
    'ngResource',
    'ngRoute',
    'ngMaterial',
    'ngMessages',
    'md.data.table'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/:bookId', {
        templateUrl: 'views/bookDetail.html',
        controller: 'BookDetailCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
