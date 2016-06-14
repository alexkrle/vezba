'use strict';

/**
 * @ngdoc function
 * @name studentsClientApp.controller:ProfesorsCtrl
 * @description
 * # ProfesorsCtrl
 * Controller of the studentsClientApp
 */
angular.module('studentsClientApp')
  .controller('ProfesorsCtrl', ['$scope', 'Restangular', '$uibModal', '$log', '_', function($scope, Restangular, $uibModal, $log, _) {
    //Restangular koristimo za rest pozive
    Restangular.all("profesors").getList().then(function(entries) {
      // nakon sto resursi stgnu sa sa back enda, postavimo ih u $scope da bismo mogli da ih prikazemo na stranici
      $scope.profesors = entries;
    });

    $scope.deleteProfesor = function(id) {
      Restangular.one("profesors", id).remove().then(function() {
        // uklanjamo profesora sa zadatim id-om iz kolekcije
        _.remove($scope.profesors, {
          id: id
        });
      }, function() {
        $log.info("the profesor cannot be removed since they are enrolled to some courses");
      });
    };

    var ProfesorsModalCtrl = ['$scope', '$uibModalInstance', 'profesor', 'Restangular', '$log', '_',
      function($scope, $uibModalInstance, profesor, Restangular, $log, _) {
        $scope.profesor = profesor;
        if ($scope.profesor.id) {
          Restangular.one("profesors", $scope.profesor.id).getList("courses").then(function(entries) {
            $scope.enrollments = entries;
          });
        }

        $scope.ok = function() {
          if ($scope.profesor.id) {
            Restangular.all('profesors').customPUT($scope.profesor).then(function (data) {
              var index = _.indexOf($scope.profesors, _.find($scope.profesors, {id: $scope.profesor.id}));
              $scope.profesors.splice(index, 1, data);
            });
          } else {
            Restangular.all('profesors').post($scope.profesor).then(function (data) {
              $scope.profesor.push(data);
            },
              // callback za gresku sa servera
              function() {
                $log.info('the profesor with such a cardNumber already exists');
              });
          }
          $uibModalInstance.close('ok');
        };

        $scope.cancel = function() {
          $uibModalInstance.dismiss('cancel');
        };
      }
    ];

    $scope.openModal = function(profesor) {

      if (!profesor) {
    	profesor = {
          firstName: '',
          lastName: ''
          cast: '',
          mail: ''
        };
      }

      var modalInstance = $uibModal.open({
        templateUrl: 'views/modals/profesor.html',
        controller: ProfesorsModalCtrl,
        scope: $scope,
        resolve: {
          student: function() {
            return profesor;
          }
        }
      });

      modalInstance.result.then(function(value) {
        $log.info('Modal finished its job at: ' + new Date() + ' with value: ' + value);
      }, function(value) {
        $log.info('Modal dismissed at: ' + new Date() + ' with value: ' + value);
      });
    };

  }]);
