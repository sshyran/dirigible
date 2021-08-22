/*
 * Copyright (c) 2010-2020 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   SAP - initial API and implementation
 */
function showAlert(title, message, $scope) {
	$scope.$parent.alertTitle = title;
	$scope.$parent.alertStatus = 'warning';
	$scope.$parent.alertMessage = message;
	$scope.$apply();
	$('#alertOpen').click();
}

function openReferEntity(title, message, $scope, graph) {
	$scope.$parent.dialogTitle = title;
	$scope.$parent.okReferEntity = function() {

		if (!$scope.$parent.referencedModel || !$scope.$parent.referencedEntity) {
			$('#Delete').click();
			return;
		}

		var model = graph.getModel();
		model.beginUpdate();
		try {
			$scope.$cell.value.name = $scope.$parent.referencedModel + ":" + $scope.$parent.referencedEntity;
			$scope.$cell.value.entityType = "PROJECTION";
			$scope.$cell.value.projectionReferencedModel = $scope.$parent.referencedModel;
			$scope.$cell.value.projectionReferencedEntity = $scope.$parent.referencedEntity;


			var propertyObject = new Property('propertyName');
			var property = new mxCell(propertyObject, new mxGeometry(0, 0, 0, 26));
			property.setVertex(true);
			property.setConnectable(false);

			$scope.$parent.availableEntities.forEach(entity => {
				if (entity.name === $scope.$parent.referencedEntity) {
					entity.properties.forEach(projectionProperty => {
						var newProperty = property.clone();

						for(var attributeName in projectionProperty) {
							newProperty.value[attributeName] = projectionProperty[attributeName];
						}

						newProperty.style = 'projectionproperty';
						
						$scope.$cell.insert(newProperty);
					});
				}
			});


			

			model.setCollapsed($scope.$cell, true);


		} finally {
			model.endUpdate();
		}
		graph.refresh();
	};
	$scope.$parent.cancelReferEntity = function() {
		$('#Delete').click();
	}
	$scope.$apply();
	$('#referEntityOpen').click();
}
