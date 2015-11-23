'use strict';

/**
 * @ngdoc function
 * @name libraryGaeApp.controller:BookDetailCtrl
 * @description
 * # BookDetailCtrl
 * Controller of the libraryGaeApp
 */
angular.module('libraryGaeApp')
  .controller('BookDetailCtrl', function ($scope, $rootScope, bookService, $mdDialog, $routeParams) {

  	// To control from where this controller is accessed.
  	var isDetailsFromURL = false;

  	// Book init.
  	$scope.book = {};

  	// The book obtained from the id of the URL or from the MainCtrl.
  	if ($routeParams.bookId) {
  		isDetailsFromURL = true;

  		bookService.get($routeParams.bookId, function(bookData) {
  			$scope.book = bookData.data; 
		});
  	} else {
		$scope.book = $scope.locals.book;
		// To control the status of 'Delete Button' obtained from MainCtrl.
		$scope.deleteDisabled = $scope.locals.deleteDisabled;
	}

	// Call the service to add a new book.
	$scope.addBook = function() {
	    bookService.save($scope.book, function(){});
		bookEditEnd($scope);
	};

	// Call the service to delete an existing book.
	$scope.deleteBook = function() {
	    bookService.delete($scope.book.id, function(){});
	    $scope.book = {};
    	bookEditEnd($scope);
	};

	// Execute the operations after finish the book edition.
	function bookEditEnd($scope) {
		// If not working with popup from 'Books list' this may not execute.
		if (!isDetailsFromURL) {
    		// Request for update books list.
    		$rootScope.$broadcast('updateBooksList');

			// Close the popup.
			$scope.cancel();
		}
	}
});