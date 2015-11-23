'use strict';

/**
 * @ngdoc function
 * @name libraryGaeApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the libraryGaeApp
 */
angular.module('libraryGaeApp')
  .controller('MainCtrl', function ($scope, bookService, $mdDialog) {

	$scope.status = '  ';
	$scope.selected = [];

	// To control the status of 'Delete Button'.
	$scope.deleteDisabled = true;

	// The default order is ascending by author.
	$scope.params = {
		sortField : 'author',
		descendingSort : 'false'
	};

	// Retrieve all books from the server.
	function loadBooksList($scope) {
		bookService.list($scope.params, function(books) {
   			$scope.books = books;
		});
	}

	loadBooksList($scope);

	// Watch for the 'updateBooksList' request.
	$scope.$on('updateBooksList', function() {
		loadBooksList($scope);
	});
	
	// Show the dialog with the book details of the selected book or blank fields if new book.
	$scope.showDialog = function(bookSelected) {
		if (bookSelected !== undefined && bookSelected !== null) {
			$scope.book = bookSelected;	
			$scope.deleteDisabled = false;
		} else {
			$scope.book = {};
			$scope.deleteDisabled = true;
		}
		
	    $mdDialog.show({
	      controller: DialogController,
	      templateUrl: 'views/bookDialog.html',
	      parent: angular.element(document.body),
	      targetEvent: bookSelected,
	      clickOutsideToClose:true,
	      locals: {
	      	book: $scope.book,
	      	deleteDisabled: $scope.deleteDisabled,
	      	books: $scope.books,
	      	params: $scope.params
	      }
	    });
	};

	// Dialog controller with some needed operations.
	function DialogController($scope, $mdDialog, locals) {
		$scope.locals = locals;

  		$scope.cancel = function() {
    		$mdDialog.cancel();
  		};
	}

});