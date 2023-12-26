/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.config;

import org.axonframework.eventsourcing.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class SnapshotConfig {

	// --------------------------------------------------------
	// define a snapshot trigger for each aggregate,
	// as implicitly defined per class and explicitly defined in the model
	// --------------------------------------------------------
	@Bean
    public SnapshotTriggerDefinition aCDCConverterAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.aCDCConverter.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition aCDCConverterDCTerminalAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.aCDCConverterDCTerminal.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition aCDCTerminalAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.aCDCTerminal.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition aCLineSegmentAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.aCLineSegment.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition accumulatorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.accumulator.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition accumulatorLimitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.accumulatorLimit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition accumulatorLimitSetAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.accumulatorLimitSet.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition accumulatorResetAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.accumulatorReset.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition accumulatorValueAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.accumulatorValue.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition activePowerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.activePower.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition activePowerLimitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.activePowerLimit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition activePowerPerCurrentFlowAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.activePowerPerCurrentFlow.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition activePowerPerFrequencyAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.activePowerPerFrequency.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition analogAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.analog.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition analogControlAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.analogControl.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition analogLimitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.analogLimit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition analogLimitSetAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.analogLimitSet.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition analogValueAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.analogValue.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition angleDegreesAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.angleDegrees.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition angleRadiansAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.angleRadians.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition apparentPowerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.apparentPower.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition apparentPowerLimitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.apparentPowerLimit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition areaAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.area.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition asynchronousMachineAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.asynchronousMachine.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition asynchronousMachineDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.asynchronousMachineDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition asynchronousMachineEquivalentCircuitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.asynchronousMachineEquivalentCircuit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition asynchronousMachineTimeConstantReactanceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.asynchronousMachineTimeConstantReactance.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition asynchronousMachineUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.asynchronousMachineUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition baseVoltageAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.baseVoltage.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition basicIntervalScheduleAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.basicIntervalSchedule.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition bayAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.bay.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition booleanProxyAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.booleanProxy.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition boundaryExtensionsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.boundaryExtensions.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition breakerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.breaker.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition busNameMarkerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.busNameMarker.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition busbarSectionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.busbarSection.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition capacitanceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.capacitance.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition capacitancePerLengthAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.capacitancePerLength.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition commandAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.command.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition conductanceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.conductance.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition conductingEquipmentAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.conductingEquipment.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition conductorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.conductor.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition conformLoadAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.conformLoad.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition conformLoadGroupAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.conformLoadGroup.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition conformLoadScheduleAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.conformLoadSchedule.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition connectivityNodeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.connectivityNode.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition connectivityNodeContainerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.connectivityNodeContainer.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition connectorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.connector.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition controlAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.control.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition controlAreaAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.controlArea.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition controlAreaGeneratingUnitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.controlAreaGeneratingUnit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition coordinateSystemAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.coordinateSystem.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition csConverterAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.csConverter.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition currentFlowAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.currentFlow.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition currentLimitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.currentLimit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition curveAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.curve.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition curveDataAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.curveData.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCBaseTerminalAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCBaseTerminal.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCBreakerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCBreaker.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCBusbarAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCBusbar.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCChopperAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCChopper.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCConductingEquipmentAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCConductingEquipment.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCConverterUnitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCConverterUnit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCDisconnectorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCDisconnector.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCEquipmentContainerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCEquipmentContainer.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCGroundAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCGround.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCLineAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCLine.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCLineSegmentAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCLineSegment.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCNodeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCNode.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCSeriesDeviceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCSeriesDevice.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCShuntAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCShunt.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCSwitchAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCSwitch.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCTerminalAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCTerminal.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCTopologicalIslandAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCTopologicalIsland.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dCTopologicalNodeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dCTopologicalNode.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dateProxyAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dateProxy.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dateTimeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dateTime.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dayTypeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dayType.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition decimalProxyAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.decimalProxy.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition diagramAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.diagram.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition diagramLayoutVersionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.diagramLayoutVersion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition diagramObjectAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.diagramObject.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition diagramObjectGluePointAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.diagramObjectGluePoint.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition diagramObjectPointAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.diagramObjectPoint.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition diagramObjectStyleAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.diagramObjectStyle.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition diagramStyleAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.diagramStyle.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition discExcContIEEEDEC1AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.discExcContIEEEDEC1A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition discExcContIEEEDEC2AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.discExcContIEEEDEC2A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition discExcContIEEEDEC3AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.discExcContIEEEDEC3A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition disconnectorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.disconnector.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition discontinuousExcitationControlDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.discontinuousExcitationControlDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition discontinuousExcitationControlUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.discontinuousExcitationControlUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition discreteAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.discrete.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition discreteValueAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.discreteValue.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition domainVersionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.domainVersion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dynamicsFunctionBlockAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dynamicsFunctionBlock.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dynamicsVersionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dynamicsVersion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition dynamicsmodelAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.dynamicsmodel.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition eNTSOEConnectivityNodeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.eNTSOEConnectivityNode.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition eNTSOEIdentifiedObjectAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.eNTSOEIdentifiedObject.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition eNTSOEJunctionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.eNTSOEJunction.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition eNTSOEOperationalLimitTypeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.eNTSOEOperationalLimitType.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition eNTSOETopologicalNodeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.eNTSOETopologicalNode.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition earthFaultCompensatorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.earthFaultCompensator.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition energyAreaAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.energyArea.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition energyConsumerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.energyConsumer.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition energySchedulingTypeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.energySchedulingType.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition energySourceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.energySource.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition equipmentAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.equipment.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition equipmentBoundaryVersionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.equipmentBoundaryVersion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition equipmentContainerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.equipmentContainer.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition equipmentVersionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.equipmentVersion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition equivalentBranchAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.equivalentBranch.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition equivalentEquipmentAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.equivalentEquipment.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition equivalentInjectionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.equivalentInjection.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition equivalentNetworkAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.equivalentNetwork.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition equivalentShuntAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.equivalentShunt.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAC1AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAC1A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAC2AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAC2A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAC3AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAC3A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAC4AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAC4A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAC5AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAC5A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAC6AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAC6A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAC8BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAC8B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excANSAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excANS.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAVR1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAVR1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAVR2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAVR2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAVR3AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAVR3.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAVR4AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAVR4.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAVR5AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAVR5.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excAVR7AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excAVR7.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excBBCAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excBBC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excCZAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excCZ.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excDC1AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excDC1A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excDC2AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excDC2A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excDC3AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excDC3A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excDC3A1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excDC3A1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excELIN1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excELIN1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excELIN2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excELIN2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excHUAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excHU.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEAC1AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEAC1A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEAC2AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEAC2A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEAC3AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEAC3A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEAC4AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEAC4A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEAC5AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEAC5A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEAC6AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEAC6A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEAC7BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEAC7B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEAC8BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEAC8B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEDC1AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEDC1A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEDC2AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEDC2A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEDC3AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEDC3A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEDC4BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEDC4B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEST1AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEST1A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEST2AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEST2A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEST3AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEST3A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEST4BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEST4B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEST5BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEST5B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEST6BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEST6B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excIEEEST7BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excIEEEST7B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excOEX3TAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excOEX3T.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excPICAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excPIC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excREXSAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excREXS.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excSCRXAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excSCRX.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excSEXSAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excSEXS.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excSKAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excSK.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excST1AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excST1A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excST2AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excST2A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excST3AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excST3A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excST4BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excST4B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excST6BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excST6B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excST7BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excST7B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excitationSystemDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excitationSystemDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition excitationSystemUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.excitationSystemUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition extensionVersionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.extensionVersion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition externalNetworkInjectionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.externalNetworkInjection.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition floatProxyAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.floatProxy.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition fossilFuelAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.fossilFuel.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition frequencyAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.frequency.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition genICompensationForGenJAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.genICompensationForGenJ.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition generatingUnitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.generatingUnit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition geographicalLocationVersionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.geographicalLocationVersion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition geographicalRegionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.geographicalRegion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govCT1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govCT1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govCT2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govCT2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govGASTAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govGAST.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govGAST1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govGAST1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govGAST2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govGAST2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govGAST3AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govGAST3.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govGAST4AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govGAST4.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govGASTWDAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govGASTWD.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydro1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydro1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydro2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydro2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydro3AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydro3.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydro4AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydro4.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydroDDAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydroDD.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydroFrancisAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydroFrancis.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydroIEEE0AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydroIEEE0.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydroIEEE2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydroIEEE2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydroPIDAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydroPID.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydroPID2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydroPID2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydroPeltonAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydroPelton.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydroRAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydroR.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydroWEHAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydroWEH.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govHydroWPIDAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govHydroWPID.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govSteam0AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govSteam0.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govSteam1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govSteam1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govSteam2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govSteam2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govSteamCCAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govSteamCC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govSteamEUAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govSteamEU.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govSteamFV2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govSteamFV2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govSteamFV3AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govSteamFV3.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govSteamFV4AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govSteamFV4.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govSteamIEEE1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govSteamIEEE1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition govSteamSGOAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.govSteamSGO.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition grossToNetActivePowerCurveAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.grossToNetActivePowerCurve.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition groundAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.ground.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition groundDisconnectorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.groundDisconnector.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition groundingImpedanceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.groundingImpedance.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition hydroGeneratingUnitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.hydroGeneratingUnit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition hydroPowerPlantAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.hydroPowerPlant.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition hydroPumpAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.hydroPump.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition identifiedObjectAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.identifiedObject.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition inductanceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.inductance.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition inductancePerLengthAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.inductancePerLength.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition integerProxyAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.integerProxy.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition junctionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.junction.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition lengthAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.length.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition limitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.limit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition limitSetAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.limitSet.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition lineAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.line.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition linearShuntCompensatorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.linearShuntCompensator.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition loadAggregateAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.loadAggregate.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition loadAreaAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.loadArea.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition loadBreakSwitchAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.loadBreakSwitch.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition loadCompositeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.loadComposite.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition loadDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.loadDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition loadGenericNonLinearAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.loadGenericNonLinear.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition loadGroupAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.loadGroup.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition loadMotorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.loadMotor.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition loadResponseCharacteristicAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.loadResponseCharacteristic.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition loadStaticAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.loadStatic.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition loadUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.loadUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition locationAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.location.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition measurementAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.measurement.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition measurementValueAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.measurementValue.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition measurementValueQualityAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.measurementValueQuality.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition measurementValueSourceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.measurementValueSource.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition mechLoad1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.mechLoad1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition mechanicalLoadDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.mechanicalLoadDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition mechanicalLoadUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.mechanicalLoadUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition moneyAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.money.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition monthDayAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.monthDay.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition monthDayIntervalAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.monthDayInterval.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition mutualCouplingAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.mutualCoupling.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition nonConformLoadAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.nonConformLoad.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition nonConformLoadGroupAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.nonConformLoadGroup.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition nonConformLoadScheduleAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.nonConformLoadSchedule.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition nonlinearShuntCompensatorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.nonlinearShuntCompensator.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition nonlinearShuntCompensatorPointAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.nonlinearShuntCompensatorPoint.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition nuclearGeneratingUnitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.nuclearGeneratingUnit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition operationalLimitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.operationalLimit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition operationalLimitSetAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.operationalLimitSet.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition operationalLimitTypeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.operationalLimitType.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition overexcLim2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.overexcLim2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition overexcLimIEEEAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.overexcLimIEEE.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition overexcLimX1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.overexcLimX1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition overexcLimX2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.overexcLimX2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition overexcitationLimiterDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.overexcitationLimiterDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition overexcitationLimiterUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.overexcitationLimiterUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pFVArControllerType1DynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pFVArControllerType1Dynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pFVArControllerType1UserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pFVArControllerType1UserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pFVArControllerType2DynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pFVArControllerType2Dynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pFVArControllerType2UserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pFVArControllerType2UserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pFVArType1IEEEPFControllerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pFVArType1IEEEPFController.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pFVArType1IEEEVArControllerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pFVArType1IEEEVArController.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pFVArType2Common1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pFVArType2Common1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pFVArType2IEEEPFControllerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pFVArType2IEEEPFController.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pFVArType2IEEEVArControllerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pFVArType2IEEEVArController.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pUAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pU.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition perCentAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.perCent.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition perLengthDCLineParameterAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.perLengthDCLineParameter.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition petersenCoilAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.petersenCoil.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition phaseTapChangerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.phaseTapChanger.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition phaseTapChangerAsymmetricalAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.phaseTapChangerAsymmetrical.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition phaseTapChangerLinearAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.phaseTapChangerLinear.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition phaseTapChangerNonLinearAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.phaseTapChangerNonLinear.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition phaseTapChangerSymmetricalAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.phaseTapChangerSymmetrical.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition phaseTapChangerTableAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.phaseTapChangerTable.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition phaseTapChangerTablePointAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.phaseTapChangerTablePoint.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition phaseTapChangerTabularAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.phaseTapChangerTabular.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition positionPointAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.positionPoint.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition powerSystemResourceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.powerSystemResource.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition powerSystemStabilizerDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.powerSystemStabilizerDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition powerSystemStabilizerUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.powerSystemStabilizerUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition powerTransformerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.powerTransformer.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition powerTransformerEndAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.powerTransformerEnd.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition proprietaryParameterDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.proprietaryParameterDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition protectedSwitchAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.protectedSwitch.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pss1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pss1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pss1AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pss1A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pss2BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pss2B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pss2STAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pss2ST.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pss5AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pss5.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pssELIN2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pssELIN2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pssIEEE1AAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pssIEEE1A.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pssIEEE2BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pssIEEE2B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pssIEEE3BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pssIEEE3B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pssIEEE4BAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pssIEEE4B.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pssPTIST1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pssPTIST1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pssPTIST3AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pssPTIST3.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pssSB4AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pssSB4.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pssSHAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pssSH.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pssSKAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pssSK.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition pssWECCAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.pssWECC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition quality61850AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.quality61850.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition raiseLowerCommandAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.raiseLowerCommand.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition ratioTapChangerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.ratioTapChanger.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition ratioTapChangerTableAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.ratioTapChangerTable.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition ratioTapChangerTablePointAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.ratioTapChangerTablePoint.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition reactanceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.reactance.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition reactiveCapabilityCurveAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.reactiveCapabilityCurve.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition reactivePowerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.reactivePower.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition regularIntervalScheduleAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.regularIntervalSchedule.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition regularTimePointAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.regularTimePoint.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition regulatingCondEqAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.regulatingCondEq.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition regulatingControlAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.regulatingControl.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition regulationScheduleAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.regulationSchedule.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition remoteInputSignalAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.remoteInputSignal.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition reportingGroupAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.reportingGroup.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition resistanceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.resistance.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition resistancePerLengthAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.resistancePerLength.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition rotatingMachineAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.rotatingMachine.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition rotatingMachineDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.rotatingMachineDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition rotationSpeedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.rotationSpeed.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition seasonAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.season.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition seasonDayTypeScheduleAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.seasonDayTypeSchedule.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition secondsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.seconds.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition seriesCompensatorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.seriesCompensator.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition setPointAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.setPoint.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition shuntCompensatorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.shuntCompensator.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition simple_FloatAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.simple_Float.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition solarGeneratingUnitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.solarGeneratingUnit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition stateVariablesVersionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.stateVariablesVersion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition staticVarCompensatorAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.staticVarCompensator.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition staticpowersystemmodelAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.staticpowersystemmodel.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition stationSupplyAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.stationSupply.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition steadyStateHypothesisVersionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.steadyStateHypothesisVersion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition stringMeasurementAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.stringMeasurement.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition stringMeasurementValueAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.stringMeasurementValue.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition stringProxyAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.stringProxy.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition subGeographicalRegionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.subGeographicalRegion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition subLoadAreaAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.subLoadArea.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition substationAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.substation.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition susceptanceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.susceptance.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition svInjectionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.svInjection.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition svPowerFlowAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.svPowerFlow.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition svShuntCompensatorSectionsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.svShuntCompensatorSections.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition svStatusAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.svStatus.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition svTapStepAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.svTapStep.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition svVoltageAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.svVoltage.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition switchItAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.switchIt.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition switchProxyAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.switchProxy.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition switchScheduleAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.switchSchedule.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition synchronousMachineAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.synchronousMachine.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition synchronousMachineDetailedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.synchronousMachineDetailed.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition synchronousMachineDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.synchronousMachineDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition synchronousMachineEquivalentCircuitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.synchronousMachineEquivalentCircuit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition synchronousMachineSimplifiedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.synchronousMachineSimplified.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition synchronousMachineTimeConstantReactanceAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.synchronousMachineTimeConstantReactance.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition synchronousMachineUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.synchronousMachineUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition tapChangerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.tapChanger.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition tapChangerControlAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.tapChangerControl.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition tapChangerTablePointAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.tapChangerTablePoint.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition tapScheduleAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.tapSchedule.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition temperatureAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.temperature.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition terminalAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.terminal.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition textDiagramObjectAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.textDiagramObject.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition thermalGeneratingUnitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.thermalGeneratingUnit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition tieFlowAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.tieFlow.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition topologicalIslandAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.topologicalIsland.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition topologicalNodeAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.topologicalNode.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition topologyBoundaryVersionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.topologyBoundaryVersion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition topologyVersionAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.topologyVersion.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition transformerEndAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.transformerEnd.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition turbLCFB1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.turbLCFB1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition turbineGovernorDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.turbineGovernorDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition turbineGovernorUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.turbineGovernorUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition turbineLoadControllerDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.turbineLoadControllerDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition turbineLoadControllerUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.turbineLoadControllerUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition underexcLim2SimplifiedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.underexcLim2Simplified.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition underexcLimIEEE1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.underexcLimIEEE1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition underexcLimIEEE2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.underexcLimIEEE2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition underexcLimX1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.underexcLimX1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition underexcLimX2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.underexcLimX2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition underexcitationLimiterDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.underexcitationLimiterDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition underexcitationLimiterUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.underexcitationLimiterUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition unresolvednameAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.unresolvedname.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition vAdjIEEEAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.vAdjIEEE.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition vCompIEEEType1AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.vCompIEEEType1.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition vCompIEEEType2AggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.vCompIEEEType2.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition valueAliasSetAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.valueAliasSet.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition valueToAliasAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.valueToAlias.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition visibilityLayerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.visibilityLayer.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition voltageAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.voltage.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition voltageAdjusterDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.voltageAdjusterDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition voltageAdjusterUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.voltageAdjusterUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition voltageCompensatorDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.voltageCompensatorDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition voltageCompensatorUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.voltageCompensatorUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition voltageLevelAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.voltageLevel.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition voltageLimitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.voltageLimit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition voltagePerReactivePowerAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.voltagePerReactivePower.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition volumeFlowRateAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.volumeFlowRate.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition vsCapabilityCurveAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.vsCapabilityCurve.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition vsConverterAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.vsConverter.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windAeroConstIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windAeroConstIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windAeroLinearIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windAeroLinearIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windContCurrLimIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windContCurrLimIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windContPType3IECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windContPType3IEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windContPType4aIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windContPType4aIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windContPType4bIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windContPType4bIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windContPitchAngleIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windContPitchAngleIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windContQIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windContQIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windContRotorRIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windContRotorRIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windDynamicsLookupTableAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windDynamicsLookupTable.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windGenTurbineType1IECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windGenTurbineType1IEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windGenTurbineType2IECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windGenTurbineType2IEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windGenTurbineType3IECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windGenTurbineType3IEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windGenTurbineType3aIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windGenTurbineType3aIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windGenTurbineType3bIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windGenTurbineType3bIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windGenType4IECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windGenType4IEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windGeneratingUnitAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windGeneratingUnit.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windMechIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windMechIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windPitchContEmulIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windPitchContEmulIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windPlantDynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windPlantDynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windPlantFreqPcontrolIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windPlantFreqPcontrolIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windPlantIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windPlantIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windPlantReactiveControlIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windPlantReactiveControlIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windPlantUserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windPlantUserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windProtectionIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windProtectionIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windTurbineType1or2DynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windTurbineType1or2Dynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windTurbineType1or2IECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windTurbineType1or2IEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windTurbineType3or4DynamicsAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windTurbineType3or4Dynamics.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windTurbineType3or4IECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windTurbineType3or4IEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windTurbineType4aIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windTurbineType4aIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windTurbineType4bIECAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windTurbineType4bIEC.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windType1or2UserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windType1or2UserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	@Bean
    public SnapshotTriggerDefinition windType3or4UserDefinedAggregateSnapshotTriggerDefinition(
        Snapshotter snapshotter,
        @Value("${axon.aggregate.windType3or4UserDefined.snapshot-threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }

	
}