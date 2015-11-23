'use strict';

angular.module('libraryGaeApp')
  .service('bookService', function ($http, environment) {
  
    // The URL of books API.
    var booksApi = environment.API_URL+'/books/';

    return {
        list: function (paramsRequest, success) {
            if (paramsRequest !== undefined && paramsRequest !== null) {
                return $http.get(booksApi, {params: paramsRequest}).then(success); 
            } else {
                return $http.get(booksApi).then(success);
            }
        },
        save: function (book, success) {
            return $http.post(booksApi, book).then(success);
        },
        get: function (id, success) {
            return $http.get(booksApi + id).then(success);
        },
        delete: function (id, success) {
            return $http.delete(booksApi + id).then(success);
        }
    };
});