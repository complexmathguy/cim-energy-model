/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.api

import org.axonframework.modelling.command.TargetAggregateIdentifier


import java.util.*
import javax.persistence.*

import com.occulue.entity.*;

//-----------------------------------------------------------
// Command definitions
//-----------------------------------------------------------

// ACDCConverter Commands
data class CreateACDCConverterCommand(
    @TargetAggregateIdentifier val aCDCConverterId: UUID? = null,
    val baseS: String,
    val idleLoss: String,
    val maxUdc: String,
    val minUdc: String,
    val numberOfValves: String,
    val ratedUdc: String,
    val resistiveLoss: String,
    val switchingLoss: String,
    val valveU0: String
)

data class UpdateACDCConverterCommand(
    @TargetAggregateIdentifier val aCDCConverterId: UUID? = null,
    val baseS: String,
    val idleLoss: String,
    val maxUdc: String,
    val minUdc: String,
    val numberOfValves: String,
    val ratedUdc: String,
    val resistiveLoss: String,
    val switchingLoss: String,
    val valveU0: String
)

data class DeleteACDCConverterCommand(@TargetAggregateIdentifier  var aCDCConverterId: UUID? = null)

// single association commands

// multiple association commands


// ACDCConverterDCTerminal Commands
data class CreateACDCConverterDCTerminalCommand(
    @TargetAggregateIdentifier val aCDCConverterDCTerminalId: UUID? = null,
    val polarity: String
)

data class UpdateACDCConverterDCTerminalCommand(
    @TargetAggregateIdentifier val aCDCConverterDCTerminalId: UUID? = null,
    val polarity: String
)

data class DeleteACDCConverterDCTerminalCommand(@TargetAggregateIdentifier  var aCDCConverterDCTerminalId: UUID? = null)

// single association commands

// multiple association commands


// ACDCTerminal Commands
data class CreateACDCTerminalCommand(
    @TargetAggregateIdentifier val aCDCTerminalId: UUID? = null,
    val sequenceNumber: String
)

data class UpdateACDCTerminalCommand(
    @TargetAggregateIdentifier val aCDCTerminalId: UUID? = null,
    val sequenceNumber: String
)

data class DeleteACDCTerminalCommand(@TargetAggregateIdentifier  var aCDCTerminalId: UUID? = null)

// single association commands

// multiple association commands


// ACLineSegment Commands
data class CreateACLineSegmentCommand(
    @TargetAggregateIdentifier val aCLineSegmentId: UUID? = null,
    val b0ch: String,
    val bch: String,
    val g0ch: String,
    val gch: String,
    val r: String,
    val r0: String,
    val shortCircuitEndTemperature: String,
    val x: String,
    val x0: String
)

data class UpdateACLineSegmentCommand(
    @TargetAggregateIdentifier val aCLineSegmentId: UUID? = null,
    val b0ch: String,
    val bch: String,
    val g0ch: String,
    val gch: String,
    val r: String,
    val r0: String,
    val shortCircuitEndTemperature: String,
    val x: String,
    val x0: String
)

data class DeleteACLineSegmentCommand(@TargetAggregateIdentifier  var aCLineSegmentId: UUID? = null)

// single association commands

// multiple association commands


// Accumulator Commands
data class CreateAccumulatorCommand(
    @TargetAggregateIdentifier  val accumulatorId: UUID? = null
)

data class UpdateAccumulatorCommand(
    @TargetAggregateIdentifier  val accumulatorId: UUID? = null
)

data class DeleteAccumulatorCommand(@TargetAggregateIdentifier  var accumulatorId: UUID? = null)

// single association commands

// multiple association commands


// AccumulatorLimit Commands
data class CreateAccumulatorLimitCommand(
    @TargetAggregateIdentifier val accumulatorLimitId: UUID? = null,
    val value: String
)

data class UpdateAccumulatorLimitCommand(
    @TargetAggregateIdentifier val accumulatorLimitId: UUID? = null,
    val value: String
)

data class DeleteAccumulatorLimitCommand(@TargetAggregateIdentifier  var accumulatorLimitId: UUID? = null)

// single association commands

// multiple association commands


// AccumulatorLimitSet Commands
data class CreateAccumulatorLimitSetCommand(
    @TargetAggregateIdentifier  val accumulatorLimitSetId: UUID? = null
)

data class UpdateAccumulatorLimitSetCommand(
    @TargetAggregateIdentifier  val accumulatorLimitSetId: UUID? = null
)

data class DeleteAccumulatorLimitSetCommand(@TargetAggregateIdentifier  var accumulatorLimitSetId: UUID? = null)

// single association commands

// multiple association commands


// AccumulatorReset Commands
data class CreateAccumulatorResetCommand(
    @TargetAggregateIdentifier  val accumulatorResetId: UUID? = null
)

data class UpdateAccumulatorResetCommand(
    @TargetAggregateIdentifier  val accumulatorResetId: UUID? = null
)

data class DeleteAccumulatorResetCommand(@TargetAggregateIdentifier  var accumulatorResetId: UUID? = null)

// single association commands

// multiple association commands


// AccumulatorValue Commands
data class CreateAccumulatorValueCommand(
    @TargetAggregateIdentifier val accumulatorValueId: UUID? = null,
    val value: String
)

data class UpdateAccumulatorValueCommand(
    @TargetAggregateIdentifier val accumulatorValueId: UUID? = null,
    val value: String
)

data class DeleteAccumulatorValueCommand(@TargetAggregateIdentifier  var accumulatorValueId: UUID? = null)

// single association commands

// multiple association commands


// ActivePower Commands
data class CreateActivePowerCommand(
    @TargetAggregateIdentifier val activePowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateActivePowerCommand(
    @TargetAggregateIdentifier val activePowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteActivePowerCommand(@TargetAggregateIdentifier  var activePowerId: UUID? = null)

// single association commands

// multiple association commands


// ActivePowerLimit Commands
data class CreateActivePowerLimitCommand(
    @TargetAggregateIdentifier val activePowerLimitId: UUID? = null,
    val value: String
)

data class UpdateActivePowerLimitCommand(
    @TargetAggregateIdentifier val activePowerLimitId: UUID? = null,
    val value: String
)

data class DeleteActivePowerLimitCommand(@TargetAggregateIdentifier  var activePowerLimitId: UUID? = null)

// single association commands

// multiple association commands


// ActivePowerPerCurrentFlow Commands
data class CreateActivePowerPerCurrentFlowCommand(
    @TargetAggregateIdentifier val activePowerPerCurrentFlowId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateActivePowerPerCurrentFlowCommand(
    @TargetAggregateIdentifier val activePowerPerCurrentFlowId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteActivePowerPerCurrentFlowCommand(@TargetAggregateIdentifier  var activePowerPerCurrentFlowId: UUID? = null)

// single association commands

// multiple association commands


// ActivePowerPerFrequency Commands
data class CreateActivePowerPerFrequencyCommand(
    @TargetAggregateIdentifier val activePowerPerFrequencyId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateActivePowerPerFrequencyCommand(
    @TargetAggregateIdentifier val activePowerPerFrequencyId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteActivePowerPerFrequencyCommand(@TargetAggregateIdentifier  var activePowerPerFrequencyId: UUID? = null)

// single association commands

// multiple association commands


// Analog Commands
data class CreateAnalogCommand(
    @TargetAggregateIdentifier val analogId: UUID? = null,
    val positiveFlowIn: String
)

data class UpdateAnalogCommand(
    @TargetAggregateIdentifier val analogId: UUID? = null,
    val positiveFlowIn: String
)

data class DeleteAnalogCommand(@TargetAggregateIdentifier  var analogId: UUID? = null)

// single association commands

// multiple association commands


// AnalogControl Commands
data class CreateAnalogControlCommand(
    @TargetAggregateIdentifier val analogControlId: UUID? = null,
    val maxValue: String,
    val minValue: String
)

data class UpdateAnalogControlCommand(
    @TargetAggregateIdentifier val analogControlId: UUID? = null,
    val maxValue: String,
    val minValue: String
)

data class DeleteAnalogControlCommand(@TargetAggregateIdentifier  var analogControlId: UUID? = null)

// single association commands

// multiple association commands


// AnalogLimit Commands
data class CreateAnalogLimitCommand(
    @TargetAggregateIdentifier val analogLimitId: UUID? = null,
    val value: String
)

data class UpdateAnalogLimitCommand(
    @TargetAggregateIdentifier val analogLimitId: UUID? = null,
    val value: String
)

data class DeleteAnalogLimitCommand(@TargetAggregateIdentifier  var analogLimitId: UUID? = null)

// single association commands

// multiple association commands


// AnalogLimitSet Commands
data class CreateAnalogLimitSetCommand(
    @TargetAggregateIdentifier  val analogLimitSetId: UUID? = null
)

data class UpdateAnalogLimitSetCommand(
    @TargetAggregateIdentifier  val analogLimitSetId: UUID? = null
)

data class DeleteAnalogLimitSetCommand(@TargetAggregateIdentifier  var analogLimitSetId: UUID? = null)

// single association commands

// multiple association commands


// AnalogValue Commands
data class CreateAnalogValueCommand(
    @TargetAggregateIdentifier val analogValueId: UUID? = null,
    val value: String
)

data class UpdateAnalogValueCommand(
    @TargetAggregateIdentifier val analogValueId: UUID? = null,
    val value: String
)

data class DeleteAnalogValueCommand(@TargetAggregateIdentifier  var analogValueId: UUID? = null)

// single association commands

// multiple association commands


// AngleDegrees Commands
data class CreateAngleDegreesCommand(
    @TargetAggregateIdentifier val angleDegreesId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateAngleDegreesCommand(
    @TargetAggregateIdentifier val angleDegreesId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteAngleDegreesCommand(@TargetAggregateIdentifier  var angleDegreesId: UUID? = null)

// single association commands

// multiple association commands


// AngleRadians Commands
data class CreateAngleRadiansCommand(
    @TargetAggregateIdentifier val angleRadiansId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateAngleRadiansCommand(
    @TargetAggregateIdentifier val angleRadiansId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteAngleRadiansCommand(@TargetAggregateIdentifier  var angleRadiansId: UUID? = null)

// single association commands

// multiple association commands


// ApparentPower Commands
data class CreateApparentPowerCommand(
    @TargetAggregateIdentifier val apparentPowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateApparentPowerCommand(
    @TargetAggregateIdentifier val apparentPowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteApparentPowerCommand(@TargetAggregateIdentifier  var apparentPowerId: UUID? = null)

// single association commands

// multiple association commands


// ApparentPowerLimit Commands
data class CreateApparentPowerLimitCommand(
    @TargetAggregateIdentifier val apparentPowerLimitId: UUID? = null,
    val value: String
)

data class UpdateApparentPowerLimitCommand(
    @TargetAggregateIdentifier val apparentPowerLimitId: UUID? = null,
    val value: String
)

data class DeleteApparentPowerLimitCommand(@TargetAggregateIdentifier  var apparentPowerLimitId: UUID? = null)

// single association commands

// multiple association commands


// Area Commands
data class CreateAreaCommand(
    @TargetAggregateIdentifier val areaId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateAreaCommand(
    @TargetAggregateIdentifier val areaId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteAreaCommand(@TargetAggregateIdentifier  var areaId: UUID? = null)

// single association commands

// multiple association commands


// AsynchronousMachine Commands
data class CreateAsynchronousMachineCommand(
    @TargetAggregateIdentifier val asynchronousMachineId: UUID? = null,
    val converterFedDrive: String,
    val efficiency: String,
    val iaIrRatio: String,
    val nominalFrequency: String,
    val nominalSpeed: String,
    val polePairNumber: String,
    val ratedMechanicalPower: String,
    val reversible: String,
    val rxLockedRotorRatio: String
)

data class UpdateAsynchronousMachineCommand(
    @TargetAggregateIdentifier val asynchronousMachineId: UUID? = null,
    val converterFedDrive: String,
    val efficiency: String,
    val iaIrRatio: String,
    val nominalFrequency: String,
    val nominalSpeed: String,
    val polePairNumber: String,
    val ratedMechanicalPower: String,
    val reversible: String,
    val rxLockedRotorRatio: String
)

data class DeleteAsynchronousMachineCommand(@TargetAggregateIdentifier  var asynchronousMachineId: UUID? = null)

// single association commands

// multiple association commands


// AsynchronousMachineDynamics Commands
data class CreateAsynchronousMachineDynamicsCommand(
    @TargetAggregateIdentifier  val asynchronousMachineDynamicsId: UUID? = null
)

data class UpdateAsynchronousMachineDynamicsCommand(
    @TargetAggregateIdentifier  val asynchronousMachineDynamicsId: UUID? = null
)

data class DeleteAsynchronousMachineDynamicsCommand(@TargetAggregateIdentifier  var asynchronousMachineDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// AsynchronousMachineEquivalentCircuit Commands
data class CreateAsynchronousMachineEquivalentCircuitCommand(
    @TargetAggregateIdentifier val asynchronousMachineEquivalentCircuitId: UUID? = null,
    val rr1: String,
    val rr2: String,
    val xlr1: String,
    val xlr2: String,
    val xm: String
)

data class UpdateAsynchronousMachineEquivalentCircuitCommand(
    @TargetAggregateIdentifier val asynchronousMachineEquivalentCircuitId: UUID? = null,
    val rr1: String,
    val rr2: String,
    val xlr1: String,
    val xlr2: String,
    val xm: String
)

data class DeleteAsynchronousMachineEquivalentCircuitCommand(@TargetAggregateIdentifier  var asynchronousMachineEquivalentCircuitId: UUID? = null)

// single association commands

// multiple association commands


// AsynchronousMachineTimeConstantReactance Commands
data class CreateAsynchronousMachineTimeConstantReactanceCommand(
    @TargetAggregateIdentifier val asynchronousMachineTimeConstantReactanceId: UUID? = null,
    val tpo: String,
    val tppo: String,
    val xp: String,
    val xpp: String,
    val xs: String
)

data class UpdateAsynchronousMachineTimeConstantReactanceCommand(
    @TargetAggregateIdentifier val asynchronousMachineTimeConstantReactanceId: UUID? = null,
    val tpo: String,
    val tppo: String,
    val xp: String,
    val xpp: String,
    val xs: String
)

data class DeleteAsynchronousMachineTimeConstantReactanceCommand(@TargetAggregateIdentifier  var asynchronousMachineTimeConstantReactanceId: UUID? = null)

// single association commands

// multiple association commands


// AsynchronousMachineUserDefined Commands
data class CreateAsynchronousMachineUserDefinedCommand(
    @TargetAggregateIdentifier val asynchronousMachineUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateAsynchronousMachineUserDefinedCommand(
    @TargetAggregateIdentifier val asynchronousMachineUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteAsynchronousMachineUserDefinedCommand(@TargetAggregateIdentifier  var asynchronousMachineUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// BaseVoltage Commands
data class CreateBaseVoltageCommand(
    @TargetAggregateIdentifier val baseVoltageId: UUID? = null,
    val nominalVoltage: String
)

data class UpdateBaseVoltageCommand(
    @TargetAggregateIdentifier val baseVoltageId: UUID? = null,
    val nominalVoltage: String
)

data class DeleteBaseVoltageCommand(@TargetAggregateIdentifier  var baseVoltageId: UUID? = null)

// single association commands

// multiple association commands


// BasicIntervalSchedule Commands
data class CreateBasicIntervalScheduleCommand(
    @TargetAggregateIdentifier val basicIntervalScheduleId: UUID? = null,
    val startTime: String,
    val value1Unit: String,
    val value2Unit: String
)

data class UpdateBasicIntervalScheduleCommand(
    @TargetAggregateIdentifier val basicIntervalScheduleId: UUID? = null,
    val startTime: String,
    val value1Unit: String,
    val value2Unit: String
)

data class DeleteBasicIntervalScheduleCommand(@TargetAggregateIdentifier  var basicIntervalScheduleId: UUID? = null)

// single association commands

// multiple association commands


// Bay Commands
data class CreateBayCommand(
    @TargetAggregateIdentifier  val bayId: UUID? = null
)

data class UpdateBayCommand(
    @TargetAggregateIdentifier  val bayId: UUID? = null
)

data class DeleteBayCommand(@TargetAggregateIdentifier  var bayId: UUID? = null)

// single association commands

// multiple association commands


// BooleanProxy Commands
data class CreateBooleanProxyCommand(
    @TargetAggregateIdentifier  val booleanProxyId: UUID? = null
)

data class UpdateBooleanProxyCommand(
    @TargetAggregateIdentifier  val booleanProxyId: UUID? = null
)

data class DeleteBooleanProxyCommand(@TargetAggregateIdentifier  var booleanProxyId: UUID? = null)

// single association commands

// multiple association commands


// BoundaryExtensions Commands
data class CreateBoundaryExtensionsCommand(
    @TargetAggregateIdentifier val boundaryExtensionsId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class UpdateBoundaryExtensionsCommand(
    @TargetAggregateIdentifier val boundaryExtensionsId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class DeleteBoundaryExtensionsCommand(@TargetAggregateIdentifier  var boundaryExtensionsId: UUID? = null)

// single association commands

// multiple association commands


// Breaker Commands
data class CreateBreakerCommand(
    @TargetAggregateIdentifier  val breakerId: UUID? = null
)

data class UpdateBreakerCommand(
    @TargetAggregateIdentifier  val breakerId: UUID? = null
)

data class DeleteBreakerCommand(@TargetAggregateIdentifier  var breakerId: UUID? = null)

// single association commands

// multiple association commands


// BusNameMarker Commands
data class CreateBusNameMarkerCommand(
    @TargetAggregateIdentifier val busNameMarkerId: UUID? = null,
    val priority: String
)

data class UpdateBusNameMarkerCommand(
    @TargetAggregateIdentifier val busNameMarkerId: UUID? = null,
    val priority: String
)

data class DeleteBusNameMarkerCommand(@TargetAggregateIdentifier  var busNameMarkerId: UUID? = null)

// single association commands

// multiple association commands


// BusbarSection Commands
data class CreateBusbarSectionCommand(
    @TargetAggregateIdentifier val busbarSectionId: UUID? = null,
    val ipMax: String
)

data class UpdateBusbarSectionCommand(
    @TargetAggregateIdentifier val busbarSectionId: UUID? = null,
    val ipMax: String
)

data class DeleteBusbarSectionCommand(@TargetAggregateIdentifier  var busbarSectionId: UUID? = null)

// single association commands

// multiple association commands


// Capacitance Commands
data class CreateCapacitanceCommand(
    @TargetAggregateIdentifier val capacitanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateCapacitanceCommand(
    @TargetAggregateIdentifier val capacitanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteCapacitanceCommand(@TargetAggregateIdentifier  var capacitanceId: UUID? = null)

// single association commands

// multiple association commands


// CapacitancePerLength Commands
data class CreateCapacitancePerLengthCommand(
    @TargetAggregateIdentifier val capacitancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateCapacitancePerLengthCommand(
    @TargetAggregateIdentifier val capacitancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteCapacitancePerLengthCommand(@TargetAggregateIdentifier  var capacitancePerLengthId: UUID? = null)

// single association commands

// multiple association commands


// Command Commands
data class CreateCommandCommand(
    @TargetAggregateIdentifier val commandId: UUID? = null,
    val normalValue: String,
    val value: String
)

data class UpdateCommandCommand(
    @TargetAggregateIdentifier val commandId: UUID? = null,
    val normalValue: String,
    val value: String
)

data class DeleteCommandCommand(@TargetAggregateIdentifier  var commandId: UUID? = null)

// single association commands

// multiple association commands


// Conductance Commands
data class CreateConductanceCommand(
    @TargetAggregateIdentifier val conductanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateConductanceCommand(
    @TargetAggregateIdentifier val conductanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteConductanceCommand(@TargetAggregateIdentifier  var conductanceId: UUID? = null)

// single association commands

// multiple association commands


// ConductingEquipment Commands
data class CreateConductingEquipmentCommand(
    @TargetAggregateIdentifier  val conductingEquipmentId: UUID? = null
)

data class UpdateConductingEquipmentCommand(
    @TargetAggregateIdentifier  val conductingEquipmentId: UUID? = null
)

data class DeleteConductingEquipmentCommand(@TargetAggregateIdentifier  var conductingEquipmentId: UUID? = null)

// single association commands

// multiple association commands


// Conductor Commands
data class CreateConductorCommand(
    @TargetAggregateIdentifier val conductorId: UUID? = null,
    val length: String
)

data class UpdateConductorCommand(
    @TargetAggregateIdentifier val conductorId: UUID? = null,
    val length: String
)

data class DeleteConductorCommand(@TargetAggregateIdentifier  var conductorId: UUID? = null)

// single association commands

// multiple association commands


// ConformLoad Commands
data class CreateConformLoadCommand(
    @TargetAggregateIdentifier  val conformLoadId: UUID? = null
)

data class UpdateConformLoadCommand(
    @TargetAggregateIdentifier  val conformLoadId: UUID? = null
)

data class DeleteConformLoadCommand(@TargetAggregateIdentifier  var conformLoadId: UUID? = null)

// single association commands

// multiple association commands


// ConformLoadGroup Commands
data class CreateConformLoadGroupCommand(
    @TargetAggregateIdentifier  val conformLoadGroupId: UUID? = null
)

data class UpdateConformLoadGroupCommand(
    @TargetAggregateIdentifier  val conformLoadGroupId: UUID? = null
)

data class DeleteConformLoadGroupCommand(@TargetAggregateIdentifier  var conformLoadGroupId: UUID? = null)

// single association commands

// multiple association commands


// ConformLoadSchedule Commands
data class CreateConformLoadScheduleCommand(
    @TargetAggregateIdentifier  val conformLoadScheduleId: UUID? = null
)

data class UpdateConformLoadScheduleCommand(
    @TargetAggregateIdentifier  val conformLoadScheduleId: UUID? = null
)

data class DeleteConformLoadScheduleCommand(@TargetAggregateIdentifier  var conformLoadScheduleId: UUID? = null)

// single association commands

// multiple association commands


// ConnectivityNode Commands
data class CreateConnectivityNodeCommand(
    @TargetAggregateIdentifier val connectivityNodeId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class UpdateConnectivityNodeCommand(
    @TargetAggregateIdentifier val connectivityNodeId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class DeleteConnectivityNodeCommand(@TargetAggregateIdentifier  var connectivityNodeId: UUID? = null)

// single association commands

// multiple association commands


// ConnectivityNodeContainer Commands
data class CreateConnectivityNodeContainerCommand(
    @TargetAggregateIdentifier  val connectivityNodeContainerId: UUID? = null
)

data class UpdateConnectivityNodeContainerCommand(
    @TargetAggregateIdentifier  val connectivityNodeContainerId: UUID? = null
)

data class DeleteConnectivityNodeContainerCommand(@TargetAggregateIdentifier  var connectivityNodeContainerId: UUID? = null)

// single association commands

// multiple association commands


// Connector Commands
data class CreateConnectorCommand(
    @TargetAggregateIdentifier  val connectorId: UUID? = null
)

data class UpdateConnectorCommand(
    @TargetAggregateIdentifier  val connectorId: UUID? = null
)

data class DeleteConnectorCommand(@TargetAggregateIdentifier  var connectorId: UUID? = null)

// single association commands

// multiple association commands


// Control Commands
data class CreateControlCommand(
    @TargetAggregateIdentifier val controlId: UUID? = null,
    val controlType: String,
    val operationInProgress: String,
    val timeStamp: String,
    val unitMultiplier: String,
    val unitSymbol: String
)

data class UpdateControlCommand(
    @TargetAggregateIdentifier val controlId: UUID? = null,
    val controlType: String,
    val operationInProgress: String,
    val timeStamp: String,
    val unitMultiplier: String,
    val unitSymbol: String
)

data class DeleteControlCommand(@TargetAggregateIdentifier  var controlId: UUID? = null)

// single association commands

// multiple association commands


// ControlArea Commands
data class CreateControlAreaCommand(
    @TargetAggregateIdentifier val controlAreaId: UUID? = null,
    val type: String
)

data class UpdateControlAreaCommand(
    @TargetAggregateIdentifier val controlAreaId: UUID? = null,
    val type: String
)

data class DeleteControlAreaCommand(@TargetAggregateIdentifier  var controlAreaId: UUID? = null)

// single association commands

// multiple association commands


// ControlAreaGeneratingUnit Commands
data class CreateControlAreaGeneratingUnitCommand(
    @TargetAggregateIdentifier  val controlAreaGeneratingUnitId: UUID? = null
)

data class UpdateControlAreaGeneratingUnitCommand(
    @TargetAggregateIdentifier  val controlAreaGeneratingUnitId: UUID? = null
)

data class DeleteControlAreaGeneratingUnitCommand(@TargetAggregateIdentifier  var controlAreaGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// CoordinateSystem Commands
data class CreateCoordinateSystemCommand(
    @TargetAggregateIdentifier val coordinateSystemId: UUID? = null,
    val crsUrn: String
)

data class UpdateCoordinateSystemCommand(
    @TargetAggregateIdentifier val coordinateSystemId: UUID? = null,
    val crsUrn: String
)

data class DeleteCoordinateSystemCommand(@TargetAggregateIdentifier  var coordinateSystemId: UUID? = null)

// single association commands

// multiple association commands


// CsConverter Commands
data class CreateCsConverterCommand(
    @TargetAggregateIdentifier val csConverterId: UUID? = null,
    val maxAlpha: String,
    val maxGamma: String,
    val maxIdc: String,
    val minAlpha: String,
    val minGamma: String,
    val minIdc: String,
    val ratedIdc: String
)

data class UpdateCsConverterCommand(
    @TargetAggregateIdentifier val csConverterId: UUID? = null,
    val maxAlpha: String,
    val maxGamma: String,
    val maxIdc: String,
    val minAlpha: String,
    val minGamma: String,
    val minIdc: String,
    val ratedIdc: String
)

data class DeleteCsConverterCommand(@TargetAggregateIdentifier  var csConverterId: UUID? = null)

// single association commands

// multiple association commands


// CurrentFlow Commands
data class CreateCurrentFlowCommand(
    @TargetAggregateIdentifier val currentFlowId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateCurrentFlowCommand(
    @TargetAggregateIdentifier val currentFlowId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteCurrentFlowCommand(@TargetAggregateIdentifier  var currentFlowId: UUID? = null)

// single association commands

// multiple association commands


// CurrentLimit Commands
data class CreateCurrentLimitCommand(
    @TargetAggregateIdentifier val currentLimitId: UUID? = null,
    val value: String
)

data class UpdateCurrentLimitCommand(
    @TargetAggregateIdentifier val currentLimitId: UUID? = null,
    val value: String
)

data class DeleteCurrentLimitCommand(@TargetAggregateIdentifier  var currentLimitId: UUID? = null)

// single association commands

// multiple association commands


// Curve Commands
data class CreateCurveCommand(
    @TargetAggregateIdentifier val curveId: UUID? = null,
    val curveStyle: String,
    val xUnit: String,
    val y1Unit: String,
    val y2Unit: String
)

data class UpdateCurveCommand(
    @TargetAggregateIdentifier val curveId: UUID? = null,
    val curveStyle: String,
    val xUnit: String,
    val y1Unit: String,
    val y2Unit: String
)

data class DeleteCurveCommand(@TargetAggregateIdentifier  var curveId: UUID? = null)

// single association commands

// multiple association commands


// CurveData Commands
data class CreateCurveDataCommand(
    @TargetAggregateIdentifier val curveDataId: UUID? = null,
    val xvalue: String,
    val y1value: String,
    val y2value: String
)

data class UpdateCurveDataCommand(
    @TargetAggregateIdentifier val curveDataId: UUID? = null,
    val xvalue: String,
    val y1value: String,
    val y2value: String
)

data class DeleteCurveDataCommand(@TargetAggregateIdentifier  var curveDataId: UUID? = null)

// single association commands

// multiple association commands


// DCBaseTerminal Commands
data class CreateDCBaseTerminalCommand(
    @TargetAggregateIdentifier  val dCBaseTerminalId: UUID? = null
)

data class UpdateDCBaseTerminalCommand(
    @TargetAggregateIdentifier  val dCBaseTerminalId: UUID? = null
)

data class DeleteDCBaseTerminalCommand(@TargetAggregateIdentifier  var dCBaseTerminalId: UUID? = null)

// single association commands

// multiple association commands


// DCBreaker Commands
data class CreateDCBreakerCommand(
    @TargetAggregateIdentifier  val dCBreakerId: UUID? = null
)

data class UpdateDCBreakerCommand(
    @TargetAggregateIdentifier  val dCBreakerId: UUID? = null
)

data class DeleteDCBreakerCommand(@TargetAggregateIdentifier  var dCBreakerId: UUID? = null)

// single association commands

// multiple association commands


// DCBusbar Commands
data class CreateDCBusbarCommand(
    @TargetAggregateIdentifier  val dCBusbarId: UUID? = null
)

data class UpdateDCBusbarCommand(
    @TargetAggregateIdentifier  val dCBusbarId: UUID? = null
)

data class DeleteDCBusbarCommand(@TargetAggregateIdentifier  var dCBusbarId: UUID? = null)

// single association commands

// multiple association commands


// DCChopper Commands
data class CreateDCChopperCommand(
    @TargetAggregateIdentifier  val dCChopperId: UUID? = null
)

data class UpdateDCChopperCommand(
    @TargetAggregateIdentifier  val dCChopperId: UUID? = null
)

data class DeleteDCChopperCommand(@TargetAggregateIdentifier  var dCChopperId: UUID? = null)

// single association commands

// multiple association commands


// DCConductingEquipment Commands
data class CreateDCConductingEquipmentCommand(
    @TargetAggregateIdentifier  val dCConductingEquipmentId: UUID? = null
)

data class UpdateDCConductingEquipmentCommand(
    @TargetAggregateIdentifier  val dCConductingEquipmentId: UUID? = null
)

data class DeleteDCConductingEquipmentCommand(@TargetAggregateIdentifier  var dCConductingEquipmentId: UUID? = null)

// single association commands

// multiple association commands


// DCConverterUnit Commands
data class CreateDCConverterUnitCommand(
    @TargetAggregateIdentifier val dCConverterUnitId: UUID? = null,
    val operationMode: String
)

data class UpdateDCConverterUnitCommand(
    @TargetAggregateIdentifier val dCConverterUnitId: UUID? = null,
    val operationMode: String
)

data class DeleteDCConverterUnitCommand(@TargetAggregateIdentifier  var dCConverterUnitId: UUID? = null)

// single association commands

// multiple association commands


// DCDisconnector Commands
data class CreateDCDisconnectorCommand(
    @TargetAggregateIdentifier  val dCDisconnectorId: UUID? = null
)

data class UpdateDCDisconnectorCommand(
    @TargetAggregateIdentifier  val dCDisconnectorId: UUID? = null
)

data class DeleteDCDisconnectorCommand(@TargetAggregateIdentifier  var dCDisconnectorId: UUID? = null)

// single association commands

// multiple association commands


// DCEquipmentContainer Commands
data class CreateDCEquipmentContainerCommand(
    @TargetAggregateIdentifier  val dCEquipmentContainerId: UUID? = null
)

data class UpdateDCEquipmentContainerCommand(
    @TargetAggregateIdentifier  val dCEquipmentContainerId: UUID? = null
)

data class DeleteDCEquipmentContainerCommand(@TargetAggregateIdentifier  var dCEquipmentContainerId: UUID? = null)

// single association commands

// multiple association commands


// DCGround Commands
data class CreateDCGroundCommand(
    @TargetAggregateIdentifier val dCGroundId: UUID? = null,
    val inductance: String,
    val r: String
)

data class UpdateDCGroundCommand(
    @TargetAggregateIdentifier val dCGroundId: UUID? = null,
    val inductance: String,
    val r: String
)

data class DeleteDCGroundCommand(@TargetAggregateIdentifier  var dCGroundId: UUID? = null)

// single association commands

// multiple association commands


// DCLine Commands
data class CreateDCLineCommand(
    @TargetAggregateIdentifier  val dCLineId: UUID? = null
)

data class UpdateDCLineCommand(
    @TargetAggregateIdentifier  val dCLineId: UUID? = null
)

data class DeleteDCLineCommand(@TargetAggregateIdentifier  var dCLineId: UUID? = null)

// single association commands

// multiple association commands


// DCLineSegment Commands
data class CreateDCLineSegmentCommand(
    @TargetAggregateIdentifier val dCLineSegmentId: UUID? = null,
    val capacitance: String,
    val inductance: String,
    val length: String,
    val resistance: String
)

data class UpdateDCLineSegmentCommand(
    @TargetAggregateIdentifier val dCLineSegmentId: UUID? = null,
    val capacitance: String,
    val inductance: String,
    val length: String,
    val resistance: String
)

data class DeleteDCLineSegmentCommand(@TargetAggregateIdentifier  var dCLineSegmentId: UUID? = null)

// single association commands

// multiple association commands


// DCNode Commands
data class CreateDCNodeCommand(
    @TargetAggregateIdentifier  val dCNodeId: UUID? = null
)

data class UpdateDCNodeCommand(
    @TargetAggregateIdentifier  val dCNodeId: UUID? = null
)

data class DeleteDCNodeCommand(@TargetAggregateIdentifier  var dCNodeId: UUID? = null)

// single association commands

// multiple association commands


// DCSeriesDevice Commands
data class CreateDCSeriesDeviceCommand(
    @TargetAggregateIdentifier val dCSeriesDeviceId: UUID? = null,
    val inductance: String,
    val ratedUdc: String,
    val resistance: String
)

data class UpdateDCSeriesDeviceCommand(
    @TargetAggregateIdentifier val dCSeriesDeviceId: UUID? = null,
    val inductance: String,
    val ratedUdc: String,
    val resistance: String
)

data class DeleteDCSeriesDeviceCommand(@TargetAggregateIdentifier  var dCSeriesDeviceId: UUID? = null)

// single association commands

// multiple association commands


// DCShunt Commands
data class CreateDCShuntCommand(
    @TargetAggregateIdentifier val dCShuntId: UUID? = null,
    val capacitance: String,
    val ratedUdc: String,
    val resistance: String
)

data class UpdateDCShuntCommand(
    @TargetAggregateIdentifier val dCShuntId: UUID? = null,
    val capacitance: String,
    val ratedUdc: String,
    val resistance: String
)

data class DeleteDCShuntCommand(@TargetAggregateIdentifier  var dCShuntId: UUID? = null)

// single association commands

// multiple association commands


// DCSwitch Commands
data class CreateDCSwitchCommand(
    @TargetAggregateIdentifier  val dCSwitchId: UUID? = null
)

data class UpdateDCSwitchCommand(
    @TargetAggregateIdentifier  val dCSwitchId: UUID? = null
)

data class DeleteDCSwitchCommand(@TargetAggregateIdentifier  var dCSwitchId: UUID? = null)

// single association commands

// multiple association commands


// DCTerminal Commands
data class CreateDCTerminalCommand(
    @TargetAggregateIdentifier  val dCTerminalId: UUID? = null
)

data class UpdateDCTerminalCommand(
    @TargetAggregateIdentifier  val dCTerminalId: UUID? = null
)

data class DeleteDCTerminalCommand(@TargetAggregateIdentifier  var dCTerminalId: UUID? = null)

// single association commands

// multiple association commands


// DCTopologicalIsland Commands
data class CreateDCTopologicalIslandCommand(
    @TargetAggregateIdentifier  val dCTopologicalIslandId: UUID? = null
)

data class UpdateDCTopologicalIslandCommand(
    @TargetAggregateIdentifier  val dCTopologicalIslandId: UUID? = null
)

data class DeleteDCTopologicalIslandCommand(@TargetAggregateIdentifier  var dCTopologicalIslandId: UUID? = null)

// single association commands

// multiple association commands


// DCTopologicalNode Commands
data class CreateDCTopologicalNodeCommand(
    @TargetAggregateIdentifier  val dCTopologicalNodeId: UUID? = null
)

data class UpdateDCTopologicalNodeCommand(
    @TargetAggregateIdentifier  val dCTopologicalNodeId: UUID? = null
)

data class DeleteDCTopologicalNodeCommand(@TargetAggregateIdentifier  var dCTopologicalNodeId: UUID? = null)

// single association commands

// multiple association commands


// DateProxy Commands
data class CreateDateProxyCommand(
    @TargetAggregateIdentifier  val dateProxyId: UUID? = null
)

data class UpdateDateProxyCommand(
    @TargetAggregateIdentifier  val dateProxyId: UUID? = null
)

data class DeleteDateProxyCommand(@TargetAggregateIdentifier  var dateProxyId: UUID? = null)

// single association commands

// multiple association commands


// DateTime Commands
data class CreateDateTimeCommand(
    @TargetAggregateIdentifier  val dateTimeId: UUID? = null
)

data class UpdateDateTimeCommand(
    @TargetAggregateIdentifier  val dateTimeId: UUID? = null
)

data class DeleteDateTimeCommand(@TargetAggregateIdentifier  var dateTimeId: UUID? = null)

// single association commands

// multiple association commands


// DayType Commands
data class CreateDayTypeCommand(
    @TargetAggregateIdentifier  val dayTypeId: UUID? = null
)

data class UpdateDayTypeCommand(
    @TargetAggregateIdentifier  val dayTypeId: UUID? = null
)

data class DeleteDayTypeCommand(@TargetAggregateIdentifier  var dayTypeId: UUID? = null)

// single association commands

// multiple association commands


// DecimalProxy Commands
data class CreateDecimalProxyCommand(
    @TargetAggregateIdentifier  val decimalProxyId: UUID? = null
)

data class UpdateDecimalProxyCommand(
    @TargetAggregateIdentifier  val decimalProxyId: UUID? = null
)

data class DeleteDecimalProxyCommand(@TargetAggregateIdentifier  var decimalProxyId: UUID? = null)

// single association commands

// multiple association commands


// Diagram Commands
data class CreateDiagramCommand(
    @TargetAggregateIdentifier val diagramId: UUID? = null,
    val orientation: String,
    val x1InitialView: String,
    val x2InitialView: String,
    val y1InitialView: String,
    val y2InitialView: String
)

data class UpdateDiagramCommand(
    @TargetAggregateIdentifier val diagramId: UUID? = null,
    val orientation: String,
    val x1InitialView: String,
    val x2InitialView: String,
    val y1InitialView: String,
    val y2InitialView: String
)

data class DeleteDiagramCommand(@TargetAggregateIdentifier  var diagramId: UUID? = null)

// single association commands

// multiple association commands


// DiagramLayoutVersion Commands
data class CreateDiagramLayoutVersionCommand(
    @TargetAggregateIdentifier val diagramLayoutVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class UpdateDiagramLayoutVersionCommand(
    @TargetAggregateIdentifier val diagramLayoutVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class DeleteDiagramLayoutVersionCommand(@TargetAggregateIdentifier  var diagramLayoutVersionId: UUID? = null)

// single association commands

// multiple association commands


// DiagramObject Commands
data class CreateDiagramObjectCommand(
    @TargetAggregateIdentifier val diagramObjectId: UUID? = null,
    val drawingOrder: String,
    val isPolygon: String,
    val offsetX: String,
    val offsetY: String,
    val rotation: String
)

data class UpdateDiagramObjectCommand(
    @TargetAggregateIdentifier val diagramObjectId: UUID? = null,
    val drawingOrder: String,
    val isPolygon: String,
    val offsetX: String,
    val offsetY: String,
    val rotation: String
)

data class DeleteDiagramObjectCommand(@TargetAggregateIdentifier  var diagramObjectId: UUID? = null)

// single association commands

// multiple association commands


// DiagramObjectGluePoint Commands
data class CreateDiagramObjectGluePointCommand(
    @TargetAggregateIdentifier  val diagramObjectGluePointId: UUID? = null
)

data class UpdateDiagramObjectGluePointCommand(
    @TargetAggregateIdentifier  val diagramObjectGluePointId: UUID? = null
)

data class DeleteDiagramObjectGluePointCommand(@TargetAggregateIdentifier  var diagramObjectGluePointId: UUID? = null)

// single association commands

// multiple association commands


// DiagramObjectPoint Commands
data class CreateDiagramObjectPointCommand(
    @TargetAggregateIdentifier val diagramObjectPointId: UUID? = null,
    val sequenceNumber: String,
    val xPosition: String,
    val yPosition: String,
    val zPosition: String
)

data class UpdateDiagramObjectPointCommand(
    @TargetAggregateIdentifier val diagramObjectPointId: UUID? = null,
    val sequenceNumber: String,
    val xPosition: String,
    val yPosition: String,
    val zPosition: String
)

data class DeleteDiagramObjectPointCommand(@TargetAggregateIdentifier  var diagramObjectPointId: UUID? = null)

// single association commands

// multiple association commands


// DiagramObjectStyle Commands
data class CreateDiagramObjectStyleCommand(
    @TargetAggregateIdentifier  val diagramObjectStyleId: UUID? = null
)

data class UpdateDiagramObjectStyleCommand(
    @TargetAggregateIdentifier  val diagramObjectStyleId: UUID? = null
)

data class DeleteDiagramObjectStyleCommand(@TargetAggregateIdentifier  var diagramObjectStyleId: UUID? = null)

// single association commands

// multiple association commands


// DiagramStyle Commands
data class CreateDiagramStyleCommand(
    @TargetAggregateIdentifier  val diagramStyleId: UUID? = null
)

data class UpdateDiagramStyleCommand(
    @TargetAggregateIdentifier  val diagramStyleId: UUID? = null
)

data class DeleteDiagramStyleCommand(@TargetAggregateIdentifier  var diagramStyleId: UUID? = null)

// single association commands

// multiple association commands


// DiscExcContIEEEDEC1A Commands
data class CreateDiscExcContIEEEDEC1ACommand(
    @TargetAggregateIdentifier val discExcContIEEEDEC1AId: UUID? = null,
    val esc: String,
    val kan: String,
    val ketl: String,
    val tan: String,
    val td: String,
    val tl1: String,
    val tl2: String,
    val tw5: String,
    val value: String,
    val vanmax: String,
    val vomax: String,
    val vomin: String,
    val vsmax: String,
    val vsmin: String,
    val vtc: String,
    val vtlmt: String,
    val vtm: String,
    val vtn: String
)

data class UpdateDiscExcContIEEEDEC1ACommand(
    @TargetAggregateIdentifier val discExcContIEEEDEC1AId: UUID? = null,
    val esc: String,
    val kan: String,
    val ketl: String,
    val tan: String,
    val td: String,
    val tl1: String,
    val tl2: String,
    val tw5: String,
    val value: String,
    val vanmax: String,
    val vomax: String,
    val vomin: String,
    val vsmax: String,
    val vsmin: String,
    val vtc: String,
    val vtlmt: String,
    val vtm: String,
    val vtn: String
)

data class DeleteDiscExcContIEEEDEC1ACommand(@TargetAggregateIdentifier  var discExcContIEEEDEC1AId: UUID? = null)

// single association commands

// multiple association commands


// DiscExcContIEEEDEC2A Commands
data class CreateDiscExcContIEEEDEC2ACommand(
    @TargetAggregateIdentifier val discExcContIEEEDEC2AId: UUID? = null,
    val td1: String,
    val td2: String,
    val vdmax: String,
    val vdmin: String,
    val vk: String
)

data class UpdateDiscExcContIEEEDEC2ACommand(
    @TargetAggregateIdentifier val discExcContIEEEDEC2AId: UUID? = null,
    val td1: String,
    val td2: String,
    val vdmax: String,
    val vdmin: String,
    val vk: String
)

data class DeleteDiscExcContIEEEDEC2ACommand(@TargetAggregateIdentifier  var discExcContIEEEDEC2AId: UUID? = null)

// single association commands

// multiple association commands


// DiscExcContIEEEDEC3A Commands
data class CreateDiscExcContIEEEDEC3ACommand(
    @TargetAggregateIdentifier val discExcContIEEEDEC3AId: UUID? = null,
    val tdr: String,
    val vtmin: String
)

data class UpdateDiscExcContIEEEDEC3ACommand(
    @TargetAggregateIdentifier val discExcContIEEEDEC3AId: UUID? = null,
    val tdr: String,
    val vtmin: String
)

data class DeleteDiscExcContIEEEDEC3ACommand(@TargetAggregateIdentifier  var discExcContIEEEDEC3AId: UUID? = null)

// single association commands

// multiple association commands


// Disconnector Commands
data class CreateDisconnectorCommand(
    @TargetAggregateIdentifier  val disconnectorId: UUID? = null
)

data class UpdateDisconnectorCommand(
    @TargetAggregateIdentifier  val disconnectorId: UUID? = null
)

data class DeleteDisconnectorCommand(@TargetAggregateIdentifier  var disconnectorId: UUID? = null)

// single association commands

// multiple association commands


// DiscontinuousExcitationControlDynamics Commands
data class CreateDiscontinuousExcitationControlDynamicsCommand(
    @TargetAggregateIdentifier  val discontinuousExcitationControlDynamicsId: UUID? = null
)

data class UpdateDiscontinuousExcitationControlDynamicsCommand(
    @TargetAggregateIdentifier  val discontinuousExcitationControlDynamicsId: UUID? = null
)

data class DeleteDiscontinuousExcitationControlDynamicsCommand(@TargetAggregateIdentifier  var discontinuousExcitationControlDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// DiscontinuousExcitationControlUserDefined Commands
data class CreateDiscontinuousExcitationControlUserDefinedCommand(
    @TargetAggregateIdentifier val discontinuousExcitationControlUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateDiscontinuousExcitationControlUserDefinedCommand(
    @TargetAggregateIdentifier val discontinuousExcitationControlUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteDiscontinuousExcitationControlUserDefinedCommand(@TargetAggregateIdentifier  var discontinuousExcitationControlUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// Discrete Commands
data class CreateDiscreteCommand(
    @TargetAggregateIdentifier  val discreteId: UUID? = null
)

data class UpdateDiscreteCommand(
    @TargetAggregateIdentifier  val discreteId: UUID? = null
)

data class DeleteDiscreteCommand(@TargetAggregateIdentifier  var discreteId: UUID? = null)

// single association commands

// multiple association commands


// DiscreteValue Commands
data class CreateDiscreteValueCommand(
    @TargetAggregateIdentifier val discreteValueId: UUID? = null,
    val value: String
)

data class UpdateDiscreteValueCommand(
    @TargetAggregateIdentifier val discreteValueId: UUID? = null,
    val value: String
)

data class DeleteDiscreteValueCommand(@TargetAggregateIdentifier  var discreteValueId: UUID? = null)

// single association commands

// multiple association commands


// DomainVersion Commands
data class CreateDomainVersionCommand(
    @TargetAggregateIdentifier val domainVersionId: UUID? = null,
    val baseUML: String,
    val date: String,
    val entsoeUML: String,
    val version: String
)

data class UpdateDomainVersionCommand(
    @TargetAggregateIdentifier val domainVersionId: UUID? = null,
    val baseUML: String,
    val date: String,
    val entsoeUML: String,
    val version: String
)

data class DeleteDomainVersionCommand(@TargetAggregateIdentifier  var domainVersionId: UUID? = null)

// single association commands

// multiple association commands


// DynamicsFunctionBlock Commands
data class CreateDynamicsFunctionBlockCommand(
    @TargetAggregateIdentifier val dynamicsFunctionBlockId: UUID? = null,
    val enabled: String
)

data class UpdateDynamicsFunctionBlockCommand(
    @TargetAggregateIdentifier val dynamicsFunctionBlockId: UUID? = null,
    val enabled: String
)

data class DeleteDynamicsFunctionBlockCommand(@TargetAggregateIdentifier  var dynamicsFunctionBlockId: UUID? = null)

// single association commands

// multiple association commands


// DynamicsVersion Commands
data class CreateDynamicsVersionCommand(
    @TargetAggregateIdentifier val dynamicsVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class UpdateDynamicsVersionCommand(
    @TargetAggregateIdentifier val dynamicsVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class DeleteDynamicsVersionCommand(@TargetAggregateIdentifier  var dynamicsVersionId: UUID? = null)

// single association commands

// multiple association commands


// Dynamicsmodel Commands
data class CreateDynamicsmodelCommand(
    @TargetAggregateIdentifier  val dynamicsmodelId: UUID? = null
)

data class UpdateDynamicsmodelCommand(
    @TargetAggregateIdentifier  val dynamicsmodelId: UUID? = null
)

data class DeleteDynamicsmodelCommand(@TargetAggregateIdentifier  var dynamicsmodelId: UUID? = null)

// single association commands

// multiple association commands


// ENTSOEConnectivityNode Commands
data class CreateENTSOEConnectivityNodeCommand(
    @TargetAggregateIdentifier  val eNTSOEConnectivityNodeId: UUID? = null
)

data class UpdateENTSOEConnectivityNodeCommand(
    @TargetAggregateIdentifier  val eNTSOEConnectivityNodeId: UUID? = null
)

data class DeleteENTSOEConnectivityNodeCommand(@TargetAggregateIdentifier  var eNTSOEConnectivityNodeId: UUID? = null)

// single association commands

// multiple association commands


// ENTSOEIdentifiedObject Commands
data class CreateENTSOEIdentifiedObjectCommand(
    @TargetAggregateIdentifier val eNTSOEIdentifiedObjectId: UUID? = null,
    val energyIdentCodeEic: String,
    val shortName: String
)

data class UpdateENTSOEIdentifiedObjectCommand(
    @TargetAggregateIdentifier val eNTSOEIdentifiedObjectId: UUID? = null,
    val energyIdentCodeEic: String,
    val shortName: String
)

data class DeleteENTSOEIdentifiedObjectCommand(@TargetAggregateIdentifier  var eNTSOEIdentifiedObjectId: UUID? = null)

// single association commands

// multiple association commands


// ENTSOEJunction Commands
data class CreateENTSOEJunctionCommand(
    @TargetAggregateIdentifier  val eNTSOEJunctionId: UUID? = null
)

data class UpdateENTSOEJunctionCommand(
    @TargetAggregateIdentifier  val eNTSOEJunctionId: UUID? = null
)

data class DeleteENTSOEJunctionCommand(@TargetAggregateIdentifier  var eNTSOEJunctionId: UUID? = null)

// single association commands

// multiple association commands


// ENTSOEOperationalLimitType Commands
data class CreateENTSOEOperationalLimitTypeCommand(
    @TargetAggregateIdentifier val eNTSOEOperationalLimitTypeId: UUID? = null,
    val limitType: String
)

data class UpdateENTSOEOperationalLimitTypeCommand(
    @TargetAggregateIdentifier val eNTSOEOperationalLimitTypeId: UUID? = null,
    val limitType: String
)

data class DeleteENTSOEOperationalLimitTypeCommand(@TargetAggregateIdentifier  var eNTSOEOperationalLimitTypeId: UUID? = null)

// single association commands

// multiple association commands


// ENTSOETopologicalNode Commands
data class CreateENTSOETopologicalNodeCommand(
    @TargetAggregateIdentifier  val eNTSOETopologicalNodeId: UUID? = null
)

data class UpdateENTSOETopologicalNodeCommand(
    @TargetAggregateIdentifier  val eNTSOETopologicalNodeId: UUID? = null
)

data class DeleteENTSOETopologicalNodeCommand(@TargetAggregateIdentifier  var eNTSOETopologicalNodeId: UUID? = null)

// single association commands

// multiple association commands


// EarthFaultCompensator Commands
data class CreateEarthFaultCompensatorCommand(
    @TargetAggregateIdentifier val earthFaultCompensatorId: UUID? = null,
    val r: String
)

data class UpdateEarthFaultCompensatorCommand(
    @TargetAggregateIdentifier val earthFaultCompensatorId: UUID? = null,
    val r: String
)

data class DeleteEarthFaultCompensatorCommand(@TargetAggregateIdentifier  var earthFaultCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// EnergyArea Commands
data class CreateEnergyAreaCommand(
    @TargetAggregateIdentifier  val energyAreaId: UUID? = null
)

data class UpdateEnergyAreaCommand(
    @TargetAggregateIdentifier  val energyAreaId: UUID? = null
)

data class DeleteEnergyAreaCommand(@TargetAggregateIdentifier  var energyAreaId: UUID? = null)

// single association commands

// multiple association commands


// EnergyConsumer Commands
data class CreateEnergyConsumerCommand(
    @TargetAggregateIdentifier val energyConsumerId: UUID? = null,
    val pfixed: String,
    val pfixedPct: String,
    val qfixed: String,
    val qfixedPct: String
)

data class UpdateEnergyConsumerCommand(
    @TargetAggregateIdentifier val energyConsumerId: UUID? = null,
    val pfixed: String,
    val pfixedPct: String,
    val qfixed: String,
    val qfixedPct: String
)

data class DeleteEnergyConsumerCommand(@TargetAggregateIdentifier  var energyConsumerId: UUID? = null)

// single association commands

// multiple association commands


// EnergySchedulingType Commands
data class CreateEnergySchedulingTypeCommand(
    @TargetAggregateIdentifier  val energySchedulingTypeId: UUID? = null
)

data class UpdateEnergySchedulingTypeCommand(
    @TargetAggregateIdentifier  val energySchedulingTypeId: UUID? = null
)

data class DeleteEnergySchedulingTypeCommand(@TargetAggregateIdentifier  var energySchedulingTypeId: UUID? = null)

// single association commands

// multiple association commands


// EnergySource Commands
data class CreateEnergySourceCommand(
    @TargetAggregateIdentifier  val energySourceId: UUID? = null
)

data class UpdateEnergySourceCommand(
    @TargetAggregateIdentifier  val energySourceId: UUID? = null
)

data class DeleteEnergySourceCommand(@TargetAggregateIdentifier  var energySourceId: UUID? = null)

// single association commands

// multiple association commands


// Equipment Commands
data class CreateEquipmentCommand(
    @TargetAggregateIdentifier  val equipmentId: UUID? = null
)

data class UpdateEquipmentCommand(
    @TargetAggregateIdentifier  val equipmentId: UUID? = null
)

data class DeleteEquipmentCommand(@TargetAggregateIdentifier  var equipmentId: UUID? = null)

// single association commands

// multiple association commands


// EquipmentBoundaryVersion Commands
data class CreateEquipmentBoundaryVersionCommand(
    @TargetAggregateIdentifier val equipmentBoundaryVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURIcore: String,
    val entsoeURIoperation: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class UpdateEquipmentBoundaryVersionCommand(
    @TargetAggregateIdentifier val equipmentBoundaryVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURIcore: String,
    val entsoeURIoperation: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class DeleteEquipmentBoundaryVersionCommand(@TargetAggregateIdentifier  var equipmentBoundaryVersionId: UUID? = null)

// single association commands

// multiple association commands


// EquipmentContainer Commands
data class CreateEquipmentContainerCommand(
    @TargetAggregateIdentifier  val equipmentContainerId: UUID? = null
)

data class UpdateEquipmentContainerCommand(
    @TargetAggregateIdentifier  val equipmentContainerId: UUID? = null
)

data class DeleteEquipmentContainerCommand(@TargetAggregateIdentifier  var equipmentContainerId: UUID? = null)

// single association commands

// multiple association commands


// EquipmentVersion Commands
data class CreateEquipmentVersionCommand(
    @TargetAggregateIdentifier val equipmentVersionId: UUID? = null,
    val baseUML: String,
    val baseURIcore: String,
    val baseURIoperation: String,
    val baseURIshortCircuit: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURIcore: String,
    val entsoeURIoperation: String,
    val entsoeURIshortCircuit: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class UpdateEquipmentVersionCommand(
    @TargetAggregateIdentifier val equipmentVersionId: UUID? = null,
    val baseUML: String,
    val baseURIcore: String,
    val baseURIoperation: String,
    val baseURIshortCircuit: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURIcore: String,
    val entsoeURIoperation: String,
    val entsoeURIshortCircuit: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class DeleteEquipmentVersionCommand(@TargetAggregateIdentifier  var equipmentVersionId: UUID? = null)

// single association commands

// multiple association commands


// EquivalentBranch Commands
data class CreateEquivalentBranchCommand(
    @TargetAggregateIdentifier val equivalentBranchId: UUID? = null,
    val negativeR12: String,
    val negativeR21: String,
    val negativeX12: String,
    val negativeX21: String,
    val positiveR12: String,
    val positiveR21: String,
    val positiveX12: String,
    val positiveX21: String,
    val r: String,
    val r21: String,
    val x: String,
    val x21: String,
    val zeroR12: String,
    val zeroR21: String,
    val zeroX12: String,
    val zeroX21: String
)

data class UpdateEquivalentBranchCommand(
    @TargetAggregateIdentifier val equivalentBranchId: UUID? = null,
    val negativeR12: String,
    val negativeR21: String,
    val negativeX12: String,
    val negativeX21: String,
    val positiveR12: String,
    val positiveR21: String,
    val positiveX12: String,
    val positiveX21: String,
    val r: String,
    val r21: String,
    val x: String,
    val x21: String,
    val zeroR12: String,
    val zeroR21: String,
    val zeroX12: String,
    val zeroX21: String
)

data class DeleteEquivalentBranchCommand(@TargetAggregateIdentifier  var equivalentBranchId: UUID? = null)

// single association commands

// multiple association commands


// EquivalentEquipment Commands
data class CreateEquivalentEquipmentCommand(
    @TargetAggregateIdentifier  val equivalentEquipmentId: UUID? = null
)

data class UpdateEquivalentEquipmentCommand(
    @TargetAggregateIdentifier  val equivalentEquipmentId: UUID? = null
)

data class DeleteEquivalentEquipmentCommand(@TargetAggregateIdentifier  var equivalentEquipmentId: UUID? = null)

// single association commands

// multiple association commands


// EquivalentInjection Commands
data class CreateEquivalentInjectionCommand(
    @TargetAggregateIdentifier val equivalentInjectionId: UUID? = null,
    val maxP: String,
    val maxQ: String,
    val minP: String,
    val minQ: String,
    val r: String,
    val r0: String,
    val r2: String,
    val regulationCapability: String,
    val x: String,
    val x0: String,
    val x2: String
)

data class UpdateEquivalentInjectionCommand(
    @TargetAggregateIdentifier val equivalentInjectionId: UUID? = null,
    val maxP: String,
    val maxQ: String,
    val minP: String,
    val minQ: String,
    val r: String,
    val r0: String,
    val r2: String,
    val regulationCapability: String,
    val x: String,
    val x0: String,
    val x2: String
)

data class DeleteEquivalentInjectionCommand(@TargetAggregateIdentifier  var equivalentInjectionId: UUID? = null)

// single association commands

// multiple association commands


// EquivalentNetwork Commands
data class CreateEquivalentNetworkCommand(
    @TargetAggregateIdentifier  val equivalentNetworkId: UUID? = null
)

data class UpdateEquivalentNetworkCommand(
    @TargetAggregateIdentifier  val equivalentNetworkId: UUID? = null
)

data class DeleteEquivalentNetworkCommand(@TargetAggregateIdentifier  var equivalentNetworkId: UUID? = null)

// single association commands

// multiple association commands


// EquivalentShunt Commands
data class CreateEquivalentShuntCommand(
    @TargetAggregateIdentifier val equivalentShuntId: UUID? = null,
    val b: String,
    val g: String
)

data class UpdateEquivalentShuntCommand(
    @TargetAggregateIdentifier val equivalentShuntId: UUID? = null,
    val b: String,
    val g: String
)

data class DeleteEquivalentShuntCommand(@TargetAggregateIdentifier  var equivalentShuntId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC1A Commands
data class CreateExcAC1ACommand(
    @TargetAggregateIdentifier val excAC1AId: UUID? = null,
    val hvlvgates: String,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val kf1: String,
    val kf2: String,
    val ks: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcAC1ACommand(
    @TargetAggregateIdentifier val excAC1AId: UUID? = null,
    val hvlvgates: String,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val kf1: String,
    val kf2: String,
    val ks: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcAC1ACommand(@TargetAggregateIdentifier  var excAC1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC2A Commands
data class CreateExcAC2ACommand(
    @TargetAggregateIdentifier val excAC2AId: UUID? = null,
    val hvgate: String,
    val ka: String,
    val kb: String,
    val kb1: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val kh: String,
    val kl: String,
    val kl1: String,
    val ks: String,
    val lvgate: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vfemax: String,
    val vlr: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcAC2ACommand(
    @TargetAggregateIdentifier val excAC2AId: UUID? = null,
    val hvgate: String,
    val ka: String,
    val kb: String,
    val kb1: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val kh: String,
    val kl: String,
    val kl1: String,
    val ks: String,
    val lvgate: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vfemax: String,
    val vlr: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcAC2ACommand(@TargetAggregateIdentifier  var excAC2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC3A Commands
data class CreateExcAC3ACommand(
    @TargetAggregateIdentifier val excAC3AId: UUID? = null,
    val efdn: String,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val kf1: String,
    val kf2: String,
    val klv: String,
    val kn: String,
    val kr: String,
    val ks: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vemin: String,
    val vfemax: String,
    val vlv: String
)

data class UpdateExcAC3ACommand(
    @TargetAggregateIdentifier val excAC3AId: UUID? = null,
    val efdn: String,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val kf1: String,
    val kf2: String,
    val klv: String,
    val kn: String,
    val kr: String,
    val ks: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vemin: String,
    val vfemax: String,
    val vlv: String
)

data class DeleteExcAC3ACommand(@TargetAggregateIdentifier  var excAC3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC4A Commands
data class CreateExcAC4ACommand(
    @TargetAggregateIdentifier val excAC4AId: UUID? = null,
    val ka: String,
    val kc: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val vimax: String,
    val vimin: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcAC4ACommand(
    @TargetAggregateIdentifier val excAC4AId: UUID? = null,
    val ka: String,
    val kc: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val vimax: String,
    val vimin: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcAC4ACommand(@TargetAggregateIdentifier  var excAC4AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC5A Commands
data class CreateExcAC5ACommand(
    @TargetAggregateIdentifier val excAC5AId: UUID? = null,
    val a: String,
    val efd1: String,
    val efd2: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val ks: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf1: String,
    val tf2: String,
    val tf3: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcAC5ACommand(
    @TargetAggregateIdentifier val excAC5AId: UUID? = null,
    val a: String,
    val efd1: String,
    val efd2: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val ks: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf1: String,
    val tf2: String,
    val tf3: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcAC5ACommand(@TargetAggregateIdentifier  var excAC5AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC6A Commands
data class CreateExcAC6ACommand(
    @TargetAggregateIdentifier val excAC6AId: UUID? = null,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kh: String,
    val ks: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val th: String,
    val tj: String,
    val tk: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vfelim: String,
    val vhmax: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcAC6ACommand(
    @TargetAggregateIdentifier val excAC6AId: UUID? = null,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kh: String,
    val ks: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val th: String,
    val tj: String,
    val tk: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vfelim: String,
    val vhmax: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcAC6ACommand(@TargetAggregateIdentifier  var excAC6AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC8B Commands
data class CreateExcAC8BCommand(
    @TargetAggregateIdentifier val excAC8BId: UUID? = null,
    val inlim: String,
    val ka: String,
    val kc: String,
    val kd: String,
    val kdr: String,
    val ke: String,
    val kir: String,
    val kpr: String,
    val ks: String,
    val pidlim: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tdr: String,
    val te: String,
    val telim: String,
    val ve1: String,
    val ve2: String,
    val vemin: String,
    val vfemax: String,
    val vimax: String,
    val vimin: String,
    val vpidmax: String,
    val vpidmin: String,
    val vrmax: String,
    val vrmin: String,
    val vtmult: String
)

data class UpdateExcAC8BCommand(
    @TargetAggregateIdentifier val excAC8BId: UUID? = null,
    val inlim: String,
    val ka: String,
    val kc: String,
    val kd: String,
    val kdr: String,
    val ke: String,
    val kir: String,
    val kpr: String,
    val ks: String,
    val pidlim: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tdr: String,
    val te: String,
    val telim: String,
    val ve1: String,
    val ve2: String,
    val vemin: String,
    val vfemax: String,
    val vimax: String,
    val vimin: String,
    val vpidmax: String,
    val vpidmin: String,
    val vrmax: String,
    val vrmin: String,
    val vtmult: String
)

data class DeleteExcAC8BCommand(@TargetAggregateIdentifier  var excAC8BId: UUID? = null)

// single association commands

// multiple association commands


// ExcANS Commands
data class CreateExcANSCommand(
    @TargetAggregateIdentifier val excANSId: UUID? = null,
    val blint: String,
    val ifmn: String,
    val ifmx: String,
    val k2: String,
    val k3: String,
    val kce: String,
    val krvecc: String,
    val kvfif: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val tb: String,
    val vrmn: String,
    val vrmx: String
)

data class UpdateExcANSCommand(
    @TargetAggregateIdentifier val excANSId: UUID? = null,
    val blint: String,
    val ifmn: String,
    val ifmx: String,
    val k2: String,
    val k3: String,
    val kce: String,
    val krvecc: String,
    val kvfif: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val tb: String,
    val vrmn: String,
    val vrmx: String
)

data class DeleteExcANSCommand(@TargetAggregateIdentifier  var excANSId: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR1 Commands
data class CreateExcAVR1Command(
    @TargetAggregateIdentifier val excAVR1Id: UUID? = null,
    val e1: String,
    val e2: String,
    val ka: String,
    val kf: String,
    val se1: String,
    val se2: String,
    val ta: String,
    val tb: String,
    val te: String,
    val tf: String,
    val vrmn: String,
    val vrmx: String
)

data class UpdateExcAVR1Command(
    @TargetAggregateIdentifier val excAVR1Id: UUID? = null,
    val e1: String,
    val e2: String,
    val ka: String,
    val kf: String,
    val se1: String,
    val se2: String,
    val ta: String,
    val tb: String,
    val te: String,
    val tf: String,
    val vrmn: String,
    val vrmx: String
)

data class DeleteExcAVR1Command(@TargetAggregateIdentifier  var excAVR1Id: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR2 Commands
data class CreateExcAVR2Command(
    @TargetAggregateIdentifier val excAVR2Id: UUID? = null,
    val e1: String,
    val e2: String,
    val ka: String,
    val kf: String,
    val se1: String,
    val se2: String,
    val ta: String,
    val tb: String,
    val te: String,
    val tf1: String,
    val tf2: String,
    val vrmn: String,
    val vrmx: String
)

data class UpdateExcAVR2Command(
    @TargetAggregateIdentifier val excAVR2Id: UUID? = null,
    val e1: String,
    val e2: String,
    val ka: String,
    val kf: String,
    val se1: String,
    val se2: String,
    val ta: String,
    val tb: String,
    val te: String,
    val tf1: String,
    val tf2: String,
    val vrmn: String,
    val vrmx: String
)

data class DeleteExcAVR2Command(@TargetAggregateIdentifier  var excAVR2Id: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR3 Commands
data class CreateExcAVR3Command(
    @TargetAggregateIdentifier val excAVR3Id: UUID? = null,
    val e1: String,
    val e2: String,
    val ka: String,
    val se1: String,
    val se2: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val te: String,
    val vrmn: String,
    val vrmx: String
)

data class UpdateExcAVR3Command(
    @TargetAggregateIdentifier val excAVR3Id: UUID? = null,
    val e1: String,
    val e2: String,
    val ka: String,
    val se1: String,
    val se2: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val te: String,
    val vrmn: String,
    val vrmx: String
)

data class DeleteExcAVR3Command(@TargetAggregateIdentifier  var excAVR3Id: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR4 Commands
data class CreateExcAVR4Command(
    @TargetAggregateIdentifier val excAVR4Id: UUID? = null,
    val imul: String,
    val ka: String,
    val ke: String,
    val kif: String,
    val t1: String,
    val t1if: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val tif: String,
    val vfmn: String,
    val vfmx: String,
    val vrmn: String,
    val vrmx: String
)

data class UpdateExcAVR4Command(
    @TargetAggregateIdentifier val excAVR4Id: UUID? = null,
    val imul: String,
    val ka: String,
    val ke: String,
    val kif: String,
    val t1: String,
    val t1if: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val tif: String,
    val vfmn: String,
    val vfmx: String,
    val vrmn: String,
    val vrmx: String
)

data class DeleteExcAVR4Command(@TargetAggregateIdentifier  var excAVR4Id: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR5 Commands
data class CreateExcAVR5Command(
    @TargetAggregateIdentifier val excAVR5Id: UUID? = null,
    val ka: String,
    val rex: String,
    val ta: String
)

data class UpdateExcAVR5Command(
    @TargetAggregateIdentifier val excAVR5Id: UUID? = null,
    val ka: String,
    val rex: String,
    val ta: String
)

data class DeleteExcAVR5Command(@TargetAggregateIdentifier  var excAVR5Id: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR7 Commands
data class CreateExcAVR7Command(
    @TargetAggregateIdentifier val excAVR7Id: UUID? = null,
    val a1: String,
    val a2: String,
    val a3: String,
    val a4: String,
    val a5: String,
    val a6: String,
    val k1: String,
    val k3: String,
    val k5: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val vmax1: String,
    val vmax3: String,
    val vmax5: String,
    val vmin1: String,
    val vmin3: String,
    val vmin5: String
)

data class UpdateExcAVR7Command(
    @TargetAggregateIdentifier val excAVR7Id: UUID? = null,
    val a1: String,
    val a2: String,
    val a3: String,
    val a4: String,
    val a5: String,
    val a6: String,
    val k1: String,
    val k3: String,
    val k5: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val vmax1: String,
    val vmax3: String,
    val vmax5: String,
    val vmin1: String,
    val vmin3: String,
    val vmin5: String
)

data class DeleteExcAVR7Command(@TargetAggregateIdentifier  var excAVR7Id: UUID? = null)

// single association commands

// multiple association commands


// ExcBBC Commands
data class CreateExcBBCCommand(
    @TargetAggregateIdentifier val excBBCId: UUID? = null,
    val efdmax: String,
    val efdmin: String,
    val k: String,
    val switchIt: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val vrmax: String,
    val vrmin: String,
    val xe: String
)

data class UpdateExcBBCCommand(
    @TargetAggregateIdentifier val excBBCId: UUID? = null,
    val efdmax: String,
    val efdmin: String,
    val k: String,
    val switchIt: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val vrmax: String,
    val vrmin: String,
    val xe: String
)

data class DeleteExcBBCCommand(@TargetAggregateIdentifier  var excBBCId: UUID? = null)

// single association commands

// multiple association commands


// ExcCZ Commands
data class CreateExcCZCommand(
    @TargetAggregateIdentifier val excCZId: UUID? = null,
    val efdmax: String,
    val efdmin: String,
    val ka: String,
    val ke: String,
    val kp: String,
    val ta: String,
    val tc: String,
    val te: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcCZCommand(
    @TargetAggregateIdentifier val excCZId: UUID? = null,
    val efdmax: String,
    val efdmin: String,
    val ka: String,
    val ke: String,
    val kp: String,
    val ta: String,
    val tc: String,
    val te: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcCZCommand(@TargetAggregateIdentifier  var excCZId: UUID? = null)

// single association commands

// multiple association commands


// ExcDC1A Commands
data class CreateExcDC1ACommand(
    @TargetAggregateIdentifier val excDC1AId: UUID? = null,
    val edfmax: String,
    val efd1: String,
    val efd2: String,
    val efdmin: String,
    val exclim: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val ks: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcDC1ACommand(
    @TargetAggregateIdentifier val excDC1AId: UUID? = null,
    val edfmax: String,
    val efd1: String,
    val efd2: String,
    val efdmin: String,
    val exclim: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val ks: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcDC1ACommand(@TargetAggregateIdentifier  var excDC1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcDC2A Commands
data class CreateExcDC2ACommand(
    @TargetAggregateIdentifier val excDC2AId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val exclim: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val ks: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val tf1: String,
    val vrmax: String,
    val vrmin: String,
    val vtlim: String
)

data class UpdateExcDC2ACommand(
    @TargetAggregateIdentifier val excDC2AId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val exclim: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val ks: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val tf1: String,
    val vrmax: String,
    val vrmin: String,
    val vtlim: String
)

data class DeleteExcDC2ACommand(@TargetAggregateIdentifier  var excDC2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcDC3A Commands
data class CreateExcDC3ACommand(
    @TargetAggregateIdentifier val excDC3AId: UUID? = null,
    val edfmax: String,
    val efd1: String,
    val efd2: String,
    val efdlim: String,
    val efdmin: String,
    val exclim: String,
    val ke: String,
    val kr: String,
    val ks: String,
    val kv: String,
    val seefd1: String,
    val seefd2: String,
    val te: String,
    val trh: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcDC3ACommand(
    @TargetAggregateIdentifier val excDC3AId: UUID? = null,
    val edfmax: String,
    val efd1: String,
    val efd2: String,
    val efdlim: String,
    val efdmin: String,
    val exclim: String,
    val ke: String,
    val kr: String,
    val ks: String,
    val kv: String,
    val seefd1: String,
    val seefd2: String,
    val te: String,
    val trh: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcDC3ACommand(@TargetAggregateIdentifier  var excDC3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcDC3A1 Commands
data class CreateExcDC3A1Command(
    @TargetAggregateIdentifier val excDC3A1Id: UUID? = null,
    val exclim: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val ta: String,
    val te: String,
    val tf: String,
    val vb1max: String,
    val vblim: String,
    val vbmax: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcDC3A1Command(
    @TargetAggregateIdentifier val excDC3A1Id: UUID? = null,
    val exclim: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val ta: String,
    val te: String,
    val tf: String,
    val vb1max: String,
    val vblim: String,
    val vbmax: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcDC3A1Command(@TargetAggregateIdentifier  var excDC3A1Id: UUID? = null)

// single association commands

// multiple association commands


// ExcELIN1 Commands
data class CreateExcELIN1Command(
    @TargetAggregateIdentifier val excELIN1Id: UUID? = null,
    val dpnf: String,
    val efmax: String,
    val efmin: String,
    val ks1: String,
    val ks2: String,
    val smax: String,
    val tfi: String,
    val tnu: String,
    val ts1: String,
    val ts2: String,
    val tsw: String,
    val vpi: String,
    val vpnf: String,
    val vpu: String,
    val xe: String
)

data class UpdateExcELIN1Command(
    @TargetAggregateIdentifier val excELIN1Id: UUID? = null,
    val dpnf: String,
    val efmax: String,
    val efmin: String,
    val ks1: String,
    val ks2: String,
    val smax: String,
    val tfi: String,
    val tnu: String,
    val ts1: String,
    val ts2: String,
    val tsw: String,
    val vpi: String,
    val vpnf: String,
    val vpu: String,
    val xe: String
)

data class DeleteExcELIN1Command(@TargetAggregateIdentifier  var excELIN1Id: UUID? = null)

// single association commands

// multiple association commands


// ExcELIN2 Commands
data class CreateExcELIN2Command(
    @TargetAggregateIdentifier val excELIN2Id: UUID? = null,
    val efdbas: String,
    val iefmax: String,
    val iefmax2: String,
    val iefmin: String,
    val k1: String,
    val k1ec: String,
    val k2: String,
    val k3: String,
    val k4: String,
    val kd1: String,
    val ke2: String,
    val ketb: String,
    val pid1max: String,
    val seve1: String,
    val seve2: String,
    val tb1: String,
    val te: String,
    val te2: String,
    val ti1: String,
    val ti3: String,
    val ti4: String,
    val tr4: String,
    val upmax: String,
    val upmin: String,
    val ve1: String,
    val ve2: String,
    val xp: String
)

data class UpdateExcELIN2Command(
    @TargetAggregateIdentifier val excELIN2Id: UUID? = null,
    val efdbas: String,
    val iefmax: String,
    val iefmax2: String,
    val iefmin: String,
    val k1: String,
    val k1ec: String,
    val k2: String,
    val k3: String,
    val k4: String,
    val kd1: String,
    val ke2: String,
    val ketb: String,
    val pid1max: String,
    val seve1: String,
    val seve2: String,
    val tb1: String,
    val te: String,
    val te2: String,
    val ti1: String,
    val ti3: String,
    val ti4: String,
    val tr4: String,
    val upmax: String,
    val upmin: String,
    val ve1: String,
    val ve2: String,
    val xp: String
)

data class DeleteExcELIN2Command(@TargetAggregateIdentifier  var excELIN2Id: UUID? = null)

// single association commands

// multiple association commands


// ExcHU Commands
data class CreateExcHUCommand(
    @TargetAggregateIdentifier val excHUId: UUID? = null,
    val ae: String,
    val ai: String,
    val atr: String,
    val emax: String,
    val emin: String,
    val imax: String,
    val imin: String,
    val ke: String,
    val ki: String,
    val te: String,
    val ti: String,
    val tr: String
)

data class UpdateExcHUCommand(
    @TargetAggregateIdentifier val excHUId: UUID? = null,
    val ae: String,
    val ai: String,
    val atr: String,
    val emax: String,
    val emin: String,
    val imax: String,
    val imin: String,
    val ke: String,
    val ki: String,
    val te: String,
    val ti: String,
    val tr: String
)

data class DeleteExcHUCommand(@TargetAggregateIdentifier  var excHUId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC1A Commands
data class CreateExcIEEEAC1ACommand(
    @TargetAggregateIdentifier val excIEEEAC1AId: UUID? = null,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEAC1ACommand(
    @TargetAggregateIdentifier val excIEEEAC1AId: UUID? = null,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEAC1ACommand(@TargetAggregateIdentifier  var excIEEEAC1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC2A Commands
data class CreateExcIEEEAC2ACommand(
    @TargetAggregateIdentifier val excIEEEAC2AId: UUID? = null,
    val ka: String,
    val kb: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val kh: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vfemax: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEAC2ACommand(
    @TargetAggregateIdentifier val excIEEEAC2AId: UUID? = null,
    val ka: String,
    val kb: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val kh: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vfemax: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEAC2ACommand(@TargetAggregateIdentifier  var excIEEEAC2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC3A Commands
data class CreateExcIEEEAC3ACommand(
    @TargetAggregateIdentifier val excIEEEAC3AId: UUID? = null,
    val efdn: String,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val kn: String,
    val kr: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vemin: String,
    val vfemax: String
)

data class UpdateExcIEEEAC3ACommand(
    @TargetAggregateIdentifier val excIEEEAC3AId: UUID? = null,
    val efdn: String,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val kn: String,
    val kr: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vemin: String,
    val vfemax: String
)

data class DeleteExcIEEEAC3ACommand(@TargetAggregateIdentifier  var excIEEEAC3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC4A Commands
data class CreateExcIEEEAC4ACommand(
    @TargetAggregateIdentifier val excIEEEAC4AId: UUID? = null,
    val ka: String,
    val kc: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val vimax: String,
    val vimin: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEAC4ACommand(
    @TargetAggregateIdentifier val excIEEEAC4AId: UUID? = null,
    val ka: String,
    val kc: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val vimax: String,
    val vimin: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEAC4ACommand(@TargetAggregateIdentifier  var excIEEEAC4AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC5A Commands
data class CreateExcIEEEAC5ACommand(
    @TargetAggregateIdentifier val excIEEEAC5AId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val te: String,
    val tf1: String,
    val tf2: String,
    val tf3: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEAC5ACommand(
    @TargetAggregateIdentifier val excIEEEAC5AId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val te: String,
    val tf1: String,
    val tf2: String,
    val tf3: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEAC5ACommand(@TargetAggregateIdentifier  var excIEEEAC5AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC6A Commands
data class CreateExcIEEEAC6ACommand(
    @TargetAggregateIdentifier val excIEEEAC6AId: UUID? = null,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kh: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val th: String,
    val tj: String,
    val tk: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vfelim: String,
    val vhmax: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEAC6ACommand(
    @TargetAggregateIdentifier val excIEEEAC6AId: UUID? = null,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kh: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val th: String,
    val tj: String,
    val tk: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vfelim: String,
    val vhmax: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEAC6ACommand(@TargetAggregateIdentifier  var excIEEEAC6AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC7B Commands
data class CreateExcIEEEAC7BCommand(
    @TargetAggregateIdentifier val excIEEEAC7BId: UUID? = null,
    val kc: String,
    val kd: String,
    val kdr: String,
    val ke: String,
    val kf1: String,
    val kf2: String,
    val kf3: String,
    val kia: String,
    val kir: String,
    val kl: String,
    val kp: String,
    val kpa: String,
    val kpr: String,
    val seve1: String,
    val seve2: String,
    val tdr: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vemin: String,
    val vfemax: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEAC7BCommand(
    @TargetAggregateIdentifier val excIEEEAC7BId: UUID? = null,
    val kc: String,
    val kd: String,
    val kdr: String,
    val ke: String,
    val kf1: String,
    val kf2: String,
    val kf3: String,
    val kia: String,
    val kir: String,
    val kl: String,
    val kp: String,
    val kpa: String,
    val kpr: String,
    val seve1: String,
    val seve2: String,
    val tdr: String,
    val te: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val ve1: String,
    val ve2: String,
    val vemin: String,
    val vfemax: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEAC7BCommand(@TargetAggregateIdentifier  var excIEEEAC7BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC8B Commands
data class CreateExcIEEEAC8BCommand(
    @TargetAggregateIdentifier val excIEEEAC8BId: UUID? = null,
    val ka: String,
    val kc: String,
    val kd: String,
    val kdr: String,
    val ke: String,
    val kir: String,
    val kpr: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tdr: String,
    val te: String,
    val ve1: String,
    val ve2: String,
    val vemin: String,
    val vfemax: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEAC8BCommand(
    @TargetAggregateIdentifier val excIEEEAC8BId: UUID? = null,
    val ka: String,
    val kc: String,
    val kd: String,
    val kdr: String,
    val ke: String,
    val kir: String,
    val kpr: String,
    val seve1: String,
    val seve2: String,
    val ta: String,
    val tdr: String,
    val te: String,
    val ve1: String,
    val ve2: String,
    val vemin: String,
    val vfemax: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEAC8BCommand(@TargetAggregateIdentifier  var excIEEEAC8BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEDC1A Commands
data class CreateExcIEEEDC1ACommand(
    @TargetAggregateIdentifier val excIEEEDC1AId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val exclim: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val uelin: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEDC1ACommand(
    @TargetAggregateIdentifier val excIEEEDC1AId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val exclim: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val uelin: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEDC1ACommand(@TargetAggregateIdentifier  var excIEEEDC1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEDC2A Commands
data class CreateExcIEEEDC2ACommand(
    @TargetAggregateIdentifier val excIEEEDC2AId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val exclim: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val uelin: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEDC2ACommand(
    @TargetAggregateIdentifier val excIEEEDC2AId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val exclim: String,
    val ka: String,
    val ke: String,
    val kf: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val uelin: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEDC2ACommand(@TargetAggregateIdentifier  var excIEEEDC2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEDC3A Commands
data class CreateExcIEEEDC3ACommand(
    @TargetAggregateIdentifier val excIEEEDC3AId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val exclim: String,
    val ke: String,
    val kv: String,
    val seefd1: String,
    val seefd2: String,
    val te: String,
    val trh: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEDC3ACommand(
    @TargetAggregateIdentifier val excIEEEDC3AId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val exclim: String,
    val ke: String,
    val kv: String,
    val seefd1: String,
    val seefd2: String,
    val te: String,
    val trh: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEDC3ACommand(@TargetAggregateIdentifier  var excIEEEDC3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEDC4B Commands
data class CreateExcIEEEDC4BCommand(
    @TargetAggregateIdentifier val excIEEEDC4BId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val ka: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val oelin: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val td: String,
    val te: String,
    val tf: String,
    val uelin: String,
    val vemin: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEDC4BCommand(
    @TargetAggregateIdentifier val excIEEEDC4BId: UUID? = null,
    val efd1: String,
    val efd2: String,
    val ka: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val oelin: String,
    val seefd1: String,
    val seefd2: String,
    val ta: String,
    val td: String,
    val te: String,
    val tf: String,
    val uelin: String,
    val vemin: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEDC4BCommand(@TargetAggregateIdentifier  var excIEEEDC4BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST1A Commands
data class CreateExcIEEEST1ACommand(
    @TargetAggregateIdentifier val excIEEEST1AId: UUID? = null,
    val ilr: String,
    val ka: String,
    val kc: String,
    val kf: String,
    val klr: String,
    val pssin: String,
    val ta: String,
    val tb: String,
    val tb1: String,
    val tc: String,
    val tc1: String,
    val tf: String,
    val uelin: String,
    val vamax: String,
    val vamin: String,
    val vimax: String,
    val vimin: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEST1ACommand(
    @TargetAggregateIdentifier val excIEEEST1AId: UUID? = null,
    val ilr: String,
    val ka: String,
    val kc: String,
    val kf: String,
    val klr: String,
    val pssin: String,
    val ta: String,
    val tb: String,
    val tb1: String,
    val tc: String,
    val tc1: String,
    val tf: String,
    val uelin: String,
    val vamax: String,
    val vamin: String,
    val vimax: String,
    val vimin: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEST1ACommand(@TargetAggregateIdentifier  var excIEEEST1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST2A Commands
data class CreateExcIEEEST2ACommand(
    @TargetAggregateIdentifier val excIEEEST2AId: UUID? = null,
    val efdmax: String,
    val ka: String,
    val kc: String,
    val ke: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val ta: String,
    val te: String,
    val tf: String,
    val uelin: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEST2ACommand(
    @TargetAggregateIdentifier val excIEEEST2AId: UUID? = null,
    val efdmax: String,
    val ka: String,
    val kc: String,
    val ke: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val ta: String,
    val te: String,
    val tf: String,
    val uelin: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEST2ACommand(@TargetAggregateIdentifier  var excIEEEST2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST3A Commands
data class CreateExcIEEEST3ACommand(
    @TargetAggregateIdentifier val excIEEEST3AId: UUID? = null,
    val ka: String,
    val kc: String,
    val kg: String,
    val ki: String,
    val km: String,
    val kp: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val thetap: String,
    val tm: String,
    val vbmax: String,
    val vgmax: String,
    val vimax: String,
    val vimin: String,
    val vmmax: String,
    val vmmin: String,
    val vrmax: String,
    val vrmin: String,
    val xl: String
)

data class UpdateExcIEEEST3ACommand(
    @TargetAggregateIdentifier val excIEEEST3AId: UUID? = null,
    val ka: String,
    val kc: String,
    val kg: String,
    val ki: String,
    val km: String,
    val kp: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val thetap: String,
    val tm: String,
    val vbmax: String,
    val vgmax: String,
    val vimax: String,
    val vimin: String,
    val vmmax: String,
    val vmmin: String,
    val vrmax: String,
    val vrmin: String,
    val xl: String
)

data class DeleteExcIEEEST3ACommand(@TargetAggregateIdentifier  var excIEEEST3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST4B Commands
data class CreateExcIEEEST4BCommand(
    @TargetAggregateIdentifier val excIEEEST4BId: UUID? = null,
    val kc: String,
    val kg: String,
    val ki: String,
    val kim: String,
    val kir: String,
    val kp: String,
    val kpm: String,
    val kpr: String,
    val ta: String,
    val thetap: String,
    val vbmax: String,
    val vmmax: String,
    val vmmin: String,
    val vrmax: String,
    val vrmin: String,
    val xl: String
)

data class UpdateExcIEEEST4BCommand(
    @TargetAggregateIdentifier val excIEEEST4BId: UUID? = null,
    val kc: String,
    val kg: String,
    val ki: String,
    val kim: String,
    val kir: String,
    val kp: String,
    val kpm: String,
    val kpr: String,
    val ta: String,
    val thetap: String,
    val vbmax: String,
    val vmmax: String,
    val vmmin: String,
    val vrmax: String,
    val vrmin: String,
    val xl: String
)

data class DeleteExcIEEEST4BCommand(@TargetAggregateIdentifier  var excIEEEST4BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST5B Commands
data class CreateExcIEEEST5BCommand(
    @TargetAggregateIdentifier val excIEEEST5BId: UUID? = null,
    val kc: String,
    val kr: String,
    val t1: String,
    val tb1: String,
    val tb2: String,
    val tc1: String,
    val tc2: String,
    val tob1: String,
    val tob2: String,
    val toc1: String,
    val toc2: String,
    val tub1: String,
    val tub2: String,
    val tuc1: String,
    val tuc2: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEST5BCommand(
    @TargetAggregateIdentifier val excIEEEST5BId: UUID? = null,
    val kc: String,
    val kr: String,
    val t1: String,
    val tb1: String,
    val tb2: String,
    val tc1: String,
    val tc2: String,
    val tob1: String,
    val tob2: String,
    val toc1: String,
    val toc2: String,
    val tub1: String,
    val tub2: String,
    val tuc1: String,
    val tuc2: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEST5BCommand(@TargetAggregateIdentifier  var excIEEEST5BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST6B Commands
data class CreateExcIEEEST6BCommand(
    @TargetAggregateIdentifier val excIEEEST6BId: UUID? = null,
    val ilr: String,
    val kci: String,
    val kff: String,
    val kg: String,
    val kia: String,
    val klr: String,
    val km: String,
    val kpa: String,
    val oelin: String,
    val tg: String,
    val vamax: String,
    val vamin: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEST6BCommand(
    @TargetAggregateIdentifier val excIEEEST6BId: UUID? = null,
    val ilr: String,
    val kci: String,
    val kff: String,
    val kg: String,
    val kia: String,
    val klr: String,
    val km: String,
    val kpa: String,
    val oelin: String,
    val tg: String,
    val vamax: String,
    val vamin: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEST6BCommand(@TargetAggregateIdentifier  var excIEEEST6BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST7B Commands
data class CreateExcIEEEST7BCommand(
    @TargetAggregateIdentifier val excIEEEST7BId: UUID? = null,
    val kh: String,
    val kia: String,
    val kl: String,
    val kpa: String,
    val oelin: String,
    val tb: String,
    val tc: String,
    val tf: String,
    val tg: String,
    val tia: String,
    val uelin: String,
    val vmax: String,
    val vmin: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcIEEEST7BCommand(
    @TargetAggregateIdentifier val excIEEEST7BId: UUID? = null,
    val kh: String,
    val kia: String,
    val kl: String,
    val kpa: String,
    val oelin: String,
    val tb: String,
    val tc: String,
    val tf: String,
    val tg: String,
    val tia: String,
    val uelin: String,
    val vmax: String,
    val vmin: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcIEEEST7BCommand(@TargetAggregateIdentifier  var excIEEEST7BId: UUID? = null)

// single association commands

// multiple association commands


// ExcOEX3T Commands
data class CreateExcOEX3TCommand(
    @TargetAggregateIdentifier val excOEX3TId: UUID? = null,
    val e1: String,
    val e2: String,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val see1: String,
    val see2: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val te: String,
    val tf: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcOEX3TCommand(
    @TargetAggregateIdentifier val excOEX3TId: UUID? = null,
    val e1: String,
    val e2: String,
    val ka: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kf: String,
    val see1: String,
    val see2: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val te: String,
    val tf: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcOEX3TCommand(@TargetAggregateIdentifier  var excOEX3TId: UUID? = null)

// single association commands

// multiple association commands


// ExcPIC Commands
data class CreateExcPICCommand(
    @TargetAggregateIdentifier val excPICId: UUID? = null,
    val e1: String,
    val e2: String,
    val efdmax: String,
    val efdmin: String,
    val ka: String,
    val kc: String,
    val ke: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val se1: String,
    val se2: String,
    val ta1: String,
    val ta2: String,
    val ta3: String,
    val ta4: String,
    val te: String,
    val tf1: String,
    val tf2: String,
    val vr1: String,
    val vr2: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcPICCommand(
    @TargetAggregateIdentifier val excPICId: UUID? = null,
    val e1: String,
    val e2: String,
    val efdmax: String,
    val efdmin: String,
    val ka: String,
    val kc: String,
    val ke: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val se1: String,
    val se2: String,
    val ta1: String,
    val ta2: String,
    val ta3: String,
    val ta4: String,
    val te: String,
    val tf1: String,
    val tf2: String,
    val vr1: String,
    val vr2: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcPICCommand(@TargetAggregateIdentifier  var excPICId: UUID? = null)

// single association commands

// multiple association commands


// ExcREXS Commands
data class CreateExcREXSCommand(
    @TargetAggregateIdentifier val excREXSId: UUID? = null,
    val e1: String,
    val e2: String,
    val fbf: String,
    val flimf: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kefd: String,
    val kf: String,
    val kh: String,
    val kii: String,
    val kip: String,
    val ks: String,
    val kvi: String,
    val kvp: String,
    val kvphz: String,
    val nvphz: String,
    val se1: String,
    val se2: String,
    val ta: String,
    val tb1: String,
    val tb2: String,
    val tc1: String,
    val tc2: String,
    val te: String,
    val tf: String,
    val tf1: String,
    val tf2: String,
    val tp: String,
    val vcmax: String,
    val vfmax: String,
    val vfmin: String,
    val vimax: String,
    val vrmax: String,
    val vrmin: String,
    val xc: String
)

data class UpdateExcREXSCommand(
    @TargetAggregateIdentifier val excREXSId: UUID? = null,
    val e1: String,
    val e2: String,
    val fbf: String,
    val flimf: String,
    val kc: String,
    val kd: String,
    val ke: String,
    val kefd: String,
    val kf: String,
    val kh: String,
    val kii: String,
    val kip: String,
    val ks: String,
    val kvi: String,
    val kvp: String,
    val kvphz: String,
    val nvphz: String,
    val se1: String,
    val se2: String,
    val ta: String,
    val tb1: String,
    val tb2: String,
    val tc1: String,
    val tc2: String,
    val te: String,
    val tf: String,
    val tf1: String,
    val tf2: String,
    val tp: String,
    val vcmax: String,
    val vfmax: String,
    val vfmin: String,
    val vimax: String,
    val vrmax: String,
    val vrmin: String,
    val xc: String
)

data class DeleteExcREXSCommand(@TargetAggregateIdentifier  var excREXSId: UUID? = null)

// single association commands

// multiple association commands


// ExcSCRX Commands
data class CreateExcSCRXCommand(
    @TargetAggregateIdentifier val excSCRXId: UUID? = null,
    val cswitch: String,
    val emax: String,
    val emin: String,
    val k: String,
    val rcrfd: String,
    val tatb: String,
    val tb: String,
    val te: String
)

data class UpdateExcSCRXCommand(
    @TargetAggregateIdentifier val excSCRXId: UUID? = null,
    val cswitch: String,
    val emax: String,
    val emin: String,
    val k: String,
    val rcrfd: String,
    val tatb: String,
    val tb: String,
    val te: String
)

data class DeleteExcSCRXCommand(@TargetAggregateIdentifier  var excSCRXId: UUID? = null)

// single association commands

// multiple association commands


// ExcSEXS Commands
data class CreateExcSEXSCommand(
    @TargetAggregateIdentifier val excSEXSId: UUID? = null,
    val efdmax: String,
    val efdmin: String,
    val emax: String,
    val emin: String,
    val k: String,
    val kc: String,
    val tatb: String,
    val tb: String,
    val tc: String,
    val te: String
)

data class UpdateExcSEXSCommand(
    @TargetAggregateIdentifier val excSEXSId: UUID? = null,
    val efdmax: String,
    val efdmin: String,
    val emax: String,
    val emin: String,
    val k: String,
    val kc: String,
    val tatb: String,
    val tb: String,
    val tc: String,
    val te: String
)

data class DeleteExcSEXSCommand(@TargetAggregateIdentifier  var excSEXSId: UUID? = null)

// single association commands

// multiple association commands


// ExcSK Commands
data class CreateExcSKCommand(
    @TargetAggregateIdentifier val excSKId: UUID? = null,
    val efdmax: String,
    val efdmin: String,
    val emax: String,
    val emin: String,
    val k: String,
    val k1: String,
    val k2: String,
    val kc: String,
    val kce: String,
    val kd: String,
    val kgob: String,
    val kp: String,
    val kqi: String,
    val kqob: String,
    val kqp: String,
    val nq: String,
    val qconoff: String,
    val qz: String,
    val remote: String,
    val sbase: String,
    val tc: String,
    val te: String,
    val ti: String,
    val tp: String,
    val tr: String,
    val uimax: String,
    val uimin: String,
    val urmax: String,
    val urmin: String,
    val vtmax: String,
    val vtmin: String,
    val yp: String
)

data class UpdateExcSKCommand(
    @TargetAggregateIdentifier val excSKId: UUID? = null,
    val efdmax: String,
    val efdmin: String,
    val emax: String,
    val emin: String,
    val k: String,
    val k1: String,
    val k2: String,
    val kc: String,
    val kce: String,
    val kd: String,
    val kgob: String,
    val kp: String,
    val kqi: String,
    val kqob: String,
    val kqp: String,
    val nq: String,
    val qconoff: String,
    val qz: String,
    val remote: String,
    val sbase: String,
    val tc: String,
    val te: String,
    val ti: String,
    val tp: String,
    val tr: String,
    val uimax: String,
    val uimin: String,
    val urmax: String,
    val urmin: String,
    val vtmax: String,
    val vtmin: String,
    val yp: String
)

data class DeleteExcSKCommand(@TargetAggregateIdentifier  var excSKId: UUID? = null)

// single association commands

// multiple association commands


// ExcST1A Commands
data class CreateExcST1ACommand(
    @TargetAggregateIdentifier val excST1AId: UUID? = null,
    val ilr: String,
    val ka: String,
    val kc: String,
    val kf: String,
    val klr: String,
    val ta: String,
    val tb: String,
    val tb1: String,
    val tc: String,
    val tc1: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val vimax: String,
    val vimin: String,
    val vrmax: String,
    val vrmin: String,
    val xe: String
)

data class UpdateExcST1ACommand(
    @TargetAggregateIdentifier val excST1AId: UUID? = null,
    val ilr: String,
    val ka: String,
    val kc: String,
    val kf: String,
    val klr: String,
    val ta: String,
    val tb: String,
    val tb1: String,
    val tc: String,
    val tc1: String,
    val tf: String,
    val vamax: String,
    val vamin: String,
    val vimax: String,
    val vimin: String,
    val vrmax: String,
    val vrmin: String,
    val xe: String
)

data class DeleteExcST1ACommand(@TargetAggregateIdentifier  var excST1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcST2A Commands
data class CreateExcST2ACommand(
    @TargetAggregateIdentifier val excST2AId: UUID? = null,
    val efdmax: String,
    val ka: String,
    val kc: String,
    val ke: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val uelin: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcST2ACommand(
    @TargetAggregateIdentifier val excST2AId: UUID? = null,
    val efdmax: String,
    val ka: String,
    val kc: String,
    val ke: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val te: String,
    val tf: String,
    val uelin: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcST2ACommand(@TargetAggregateIdentifier  var excST2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcST3A Commands
data class CreateExcST3ACommand(
    @TargetAggregateIdentifier val excST3AId: UUID? = null,
    val efdmax: String,
    val kc: String,
    val kg: String,
    val ki: String,
    val kj: String,
    val km: String,
    val kp: String,
    val ks: String,
    val ks1: String,
    val tb: String,
    val tc: String,
    val thetap: String,
    val tm: String,
    val vbmax: String,
    val vgmax: String,
    val vimax: String,
    val vimin: String,
    val vrmax: String,
    val vrmin: String,
    val xl: String
)

data class UpdateExcST3ACommand(
    @TargetAggregateIdentifier val excST3AId: UUID? = null,
    val efdmax: String,
    val kc: String,
    val kg: String,
    val ki: String,
    val kj: String,
    val km: String,
    val kp: String,
    val ks: String,
    val ks1: String,
    val tb: String,
    val tc: String,
    val thetap: String,
    val tm: String,
    val vbmax: String,
    val vgmax: String,
    val vimax: String,
    val vimin: String,
    val vrmax: String,
    val vrmin: String,
    val xl: String
)

data class DeleteExcST3ACommand(@TargetAggregateIdentifier  var excST3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcST4B Commands
data class CreateExcST4BCommand(
    @TargetAggregateIdentifier val excST4BId: UUID? = null,
    val kc: String,
    val kg: String,
    val ki: String,
    val kim: String,
    val kir: String,
    val kp: String,
    val kpm: String,
    val kpr: String,
    val lvgate: String,
    val ta: String,
    val thetap: String,
    val uel: String,
    val vbmax: String,
    val vgmax: String,
    val vmmax: String,
    val vmmin: String,
    val vrmax: String,
    val vrmin: String,
    val xl: String
)

data class UpdateExcST4BCommand(
    @TargetAggregateIdentifier val excST4BId: UUID? = null,
    val kc: String,
    val kg: String,
    val ki: String,
    val kim: String,
    val kir: String,
    val kp: String,
    val kpm: String,
    val kpr: String,
    val lvgate: String,
    val ta: String,
    val thetap: String,
    val uel: String,
    val vbmax: String,
    val vgmax: String,
    val vmmax: String,
    val vmmin: String,
    val vrmax: String,
    val vrmin: String,
    val xl: String
)

data class DeleteExcST4BCommand(@TargetAggregateIdentifier  var excST4BId: UUID? = null)

// single association commands

// multiple association commands


// ExcST6B Commands
data class CreateExcST6BCommand(
    @TargetAggregateIdentifier val excST6BId: UUID? = null,
    val ilr: String,
    val k1: String,
    val kcl: String,
    val kff: String,
    val kg: String,
    val kia: String,
    val klr: String,
    val km: String,
    val kpa: String,
    val kvd: String,
    val oelin: String,
    val tg: String,
    val ts: String,
    val tvd: String,
    val vamax: String,
    val vamin: String,
    val vilim: String,
    val vimax: String,
    val vimin: String,
    val vmult: String,
    val vrmax: String,
    val vrmin: String,
    val xc: String
)

data class UpdateExcST6BCommand(
    @TargetAggregateIdentifier val excST6BId: UUID? = null,
    val ilr: String,
    val k1: String,
    val kcl: String,
    val kff: String,
    val kg: String,
    val kia: String,
    val klr: String,
    val km: String,
    val kpa: String,
    val kvd: String,
    val oelin: String,
    val tg: String,
    val ts: String,
    val tvd: String,
    val vamax: String,
    val vamin: String,
    val vilim: String,
    val vimax: String,
    val vimin: String,
    val vmult: String,
    val vrmax: String,
    val vrmin: String,
    val xc: String
)

data class DeleteExcST6BCommand(@TargetAggregateIdentifier  var excST6BId: UUID? = null)

// single association commands

// multiple association commands


// ExcST7B Commands
data class CreateExcST7BCommand(
    @TargetAggregateIdentifier val excST7BId: UUID? = null,
    val kh: String,
    val kia: String,
    val kl: String,
    val kpa: String,
    val oelin: String,
    val tb: String,
    val tc: String,
    val tf: String,
    val tg: String,
    val tia: String,
    val ts: String,
    val uelin: String,
    val vmax: String,
    val vmin: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdateExcST7BCommand(
    @TargetAggregateIdentifier val excST7BId: UUID? = null,
    val kh: String,
    val kia: String,
    val kl: String,
    val kpa: String,
    val oelin: String,
    val tb: String,
    val tc: String,
    val tf: String,
    val tg: String,
    val tia: String,
    val ts: String,
    val uelin: String,
    val vmax: String,
    val vmin: String,
    val vrmax: String,
    val vrmin: String
)

data class DeleteExcST7BCommand(@TargetAggregateIdentifier  var excST7BId: UUID? = null)

// single association commands

// multiple association commands


// ExcitationSystemDynamics Commands
data class CreateExcitationSystemDynamicsCommand(
    @TargetAggregateIdentifier  val excitationSystemDynamicsId: UUID? = null
)

data class UpdateExcitationSystemDynamicsCommand(
    @TargetAggregateIdentifier  val excitationSystemDynamicsId: UUID? = null
)

data class DeleteExcitationSystemDynamicsCommand(@TargetAggregateIdentifier  var excitationSystemDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// ExcitationSystemUserDefined Commands
data class CreateExcitationSystemUserDefinedCommand(
    @TargetAggregateIdentifier val excitationSystemUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateExcitationSystemUserDefinedCommand(
    @TargetAggregateIdentifier val excitationSystemUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteExcitationSystemUserDefinedCommand(@TargetAggregateIdentifier  var excitationSystemUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// ExtensionVersion Commands
data class CreateExtensionVersionCommand(
    @TargetAggregateIdentifier val extensionVersionId: UUID? = null,
    val date: String,
    val namespaceURI: String
)

data class UpdateExtensionVersionCommand(
    @TargetAggregateIdentifier val extensionVersionId: UUID? = null,
    val date: String,
    val namespaceURI: String
)

data class DeleteExtensionVersionCommand(@TargetAggregateIdentifier  var extensionVersionId: UUID? = null)

// single association commands

// multiple association commands


// ExternalNetworkInjection Commands
data class CreateExternalNetworkInjectionCommand(
    @TargetAggregateIdentifier val externalNetworkInjectionId: UUID? = null,
    val governorSCD: String,
    val ikSecond: String,
    val maxInitialSymShCCurrent: String,
    val maxP: String,
    val maxQ: String,
    val maxR0ToX0Ratio: String,
    val maxR1ToX1Ratio: String,
    val maxZ0ToZ1Ratio: String,
    val minInitialSymShCCurrent: String,
    val minP: String,
    val minQ: String,
    val minR0ToX0Ratio: String,
    val minR1ToX1Ratio: String,
    val minZ0ToZ1Ratio: String,
    val voltageFactor: String
)

data class UpdateExternalNetworkInjectionCommand(
    @TargetAggregateIdentifier val externalNetworkInjectionId: UUID? = null,
    val governorSCD: String,
    val ikSecond: String,
    val maxInitialSymShCCurrent: String,
    val maxP: String,
    val maxQ: String,
    val maxR0ToX0Ratio: String,
    val maxR1ToX1Ratio: String,
    val maxZ0ToZ1Ratio: String,
    val minInitialSymShCCurrent: String,
    val minP: String,
    val minQ: String,
    val minR0ToX0Ratio: String,
    val minR1ToX1Ratio: String,
    val minZ0ToZ1Ratio: String,
    val voltageFactor: String
)

data class DeleteExternalNetworkInjectionCommand(@TargetAggregateIdentifier  var externalNetworkInjectionId: UUID? = null)

// single association commands

// multiple association commands


// FloatProxy Commands
data class CreateFloatProxyCommand(
    @TargetAggregateIdentifier  val floatProxyId: UUID? = null
)

data class UpdateFloatProxyCommand(
    @TargetAggregateIdentifier  val floatProxyId: UUID? = null
)

data class DeleteFloatProxyCommand(@TargetAggregateIdentifier  var floatProxyId: UUID? = null)

// single association commands

// multiple association commands


// FossilFuel Commands
data class CreateFossilFuelCommand(
    @TargetAggregateIdentifier val fossilFuelId: UUID? = null,
    val fossilFuelType: String
)

data class UpdateFossilFuelCommand(
    @TargetAggregateIdentifier val fossilFuelId: UUID? = null,
    val fossilFuelType: String
)

data class DeleteFossilFuelCommand(@TargetAggregateIdentifier  var fossilFuelId: UUID? = null)

// single association commands

// multiple association commands


// Frequency Commands
data class CreateFrequencyCommand(
    @TargetAggregateIdentifier val frequencyId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateFrequencyCommand(
    @TargetAggregateIdentifier val frequencyId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteFrequencyCommand(@TargetAggregateIdentifier  var frequencyId: UUID? = null)

// single association commands

// multiple association commands


// GenICompensationForGenJ Commands
data class CreateGenICompensationForGenJCommand(
    @TargetAggregateIdentifier val genICompensationForGenJId: UUID? = null,
    val rcij: String,
    val xcij: String
)

data class UpdateGenICompensationForGenJCommand(
    @TargetAggregateIdentifier val genICompensationForGenJId: UUID? = null,
    val rcij: String,
    val xcij: String
)

data class DeleteGenICompensationForGenJCommand(@TargetAggregateIdentifier  var genICompensationForGenJId: UUID? = null)

// single association commands

// multiple association commands


// GeneratingUnit Commands
data class CreateGeneratingUnitCommand(
    @TargetAggregateIdentifier val generatingUnitId: UUID? = null,
    val genControlSource: String,
    val governorSCD: String,
    val initialP: String,
    val longPF: String,
    val maximumAllowableSpinningReserve: String,
    val maxOperatingP: String,
    val minOperatingP: String,
    val nominalP: String,
    val ratedGrossMaxP: String,
    val ratedGrossMinP: String,
    val ratedNetMaxP: String,
    val shortPF: String,
    val startupCost: String,
    val totalEfficiency: String,
    val variableCost: String
)

data class UpdateGeneratingUnitCommand(
    @TargetAggregateIdentifier val generatingUnitId: UUID? = null,
    val genControlSource: String,
    val governorSCD: String,
    val initialP: String,
    val longPF: String,
    val maximumAllowableSpinningReserve: String,
    val maxOperatingP: String,
    val minOperatingP: String,
    val nominalP: String,
    val ratedGrossMaxP: String,
    val ratedGrossMinP: String,
    val ratedNetMaxP: String,
    val shortPF: String,
    val startupCost: String,
    val totalEfficiency: String,
    val variableCost: String
)

data class DeleteGeneratingUnitCommand(@TargetAggregateIdentifier  var generatingUnitId: UUID? = null)

// single association commands

// multiple association commands


// GeographicalLocationVersion Commands
data class CreateGeographicalLocationVersionCommand(
    @TargetAggregateIdentifier val geographicalLocationVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class UpdateGeographicalLocationVersionCommand(
    @TargetAggregateIdentifier val geographicalLocationVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class DeleteGeographicalLocationVersionCommand(@TargetAggregateIdentifier  var geographicalLocationVersionId: UUID? = null)

// single association commands

// multiple association commands


// GeographicalRegion Commands
data class CreateGeographicalRegionCommand(
    @TargetAggregateIdentifier  val geographicalRegionId: UUID? = null
)

data class UpdateGeographicalRegionCommand(
    @TargetAggregateIdentifier  val geographicalRegionId: UUID? = null
)

data class DeleteGeographicalRegionCommand(@TargetAggregateIdentifier  var geographicalRegionId: UUID? = null)

// single association commands

// multiple association commands


// GovCT1 Commands
data class CreateGovCT1Command(
    @TargetAggregateIdentifier val govCT1Id: UUID? = null,
    val aset: String,
    val db: String,
    val dm: String,
    val ka: String,
    val kdgov: String,
    val kigov: String,
    val kiload: String,
    val kimw: String,
    val kpgov: String,
    val kpload: String,
    val kturb: String,
    val ldref: String,
    val maxerr: String,
    val minerr: String,
    val mwbase: String,
    val r: String,
    val rclose: String,
    val rdown: String,
    val ropen: String,
    val rselect: String,
    val rup: String,
    val ta: String,
    val tact: String,
    val tb: String,
    val tc: String,
    val tdgov: String,
    val teng: String,
    val tfload: String,
    val tpelec: String,
    val tsa: String,
    val tsb: String,
    val vmax: String,
    val vmin: String,
    val wfnl: String,
    val wfspd: String
)

data class UpdateGovCT1Command(
    @TargetAggregateIdentifier val govCT1Id: UUID? = null,
    val aset: String,
    val db: String,
    val dm: String,
    val ka: String,
    val kdgov: String,
    val kigov: String,
    val kiload: String,
    val kimw: String,
    val kpgov: String,
    val kpload: String,
    val kturb: String,
    val ldref: String,
    val maxerr: String,
    val minerr: String,
    val mwbase: String,
    val r: String,
    val rclose: String,
    val rdown: String,
    val ropen: String,
    val rselect: String,
    val rup: String,
    val ta: String,
    val tact: String,
    val tb: String,
    val tc: String,
    val tdgov: String,
    val teng: String,
    val tfload: String,
    val tpelec: String,
    val tsa: String,
    val tsb: String,
    val vmax: String,
    val vmin: String,
    val wfnl: String,
    val wfspd: String
)

data class DeleteGovCT1Command(@TargetAggregateIdentifier  var govCT1Id: UUID? = null)

// single association commands

// multiple association commands


// GovCT2 Commands
data class CreateGovCT2Command(
    @TargetAggregateIdentifier val govCT2Id: UUID? = null,
    val aset: String,
    val db: String,
    val dm: String,
    val flim1: String,
    val flim10: String,
    val flim2: String,
    val flim3: String,
    val flim4: String,
    val flim5: String,
    val flim6: String,
    val flim7: String,
    val flim8: String,
    val flim9: String,
    val ka: String,
    val kdgov: String,
    val kigov: String,
    val kiload: String,
    val kimw: String,
    val kpgov: String,
    val kpload: String,
    val kturb: String,
    val ldref: String,
    val maxerr: String,
    val minerr: String,
    val mwbase: String,
    val plim1: String,
    val plim10: String,
    val plim2: String,
    val plim3: String,
    val plim4: String,
    val plim5: String,
    val plim6: String,
    val plim7: String,
    val plim8: String,
    val plim9: String,
    val prate: String,
    val r: String,
    val rclose: String,
    val rdown: String,
    val ropen: String,
    val rselect: String,
    val rup: String,
    val ta: String,
    val tact: String,
    val tb: String,
    val tc: String,
    val tdgov: String,
    val teng: String,
    val tfload: String,
    val tpelec: String,
    val tsa: String,
    val tsb: String,
    val vmax: String,
    val vmin: String,
    val wfnl: String,
    val wfspd: String
)

data class UpdateGovCT2Command(
    @TargetAggregateIdentifier val govCT2Id: UUID? = null,
    val aset: String,
    val db: String,
    val dm: String,
    val flim1: String,
    val flim10: String,
    val flim2: String,
    val flim3: String,
    val flim4: String,
    val flim5: String,
    val flim6: String,
    val flim7: String,
    val flim8: String,
    val flim9: String,
    val ka: String,
    val kdgov: String,
    val kigov: String,
    val kiload: String,
    val kimw: String,
    val kpgov: String,
    val kpload: String,
    val kturb: String,
    val ldref: String,
    val maxerr: String,
    val minerr: String,
    val mwbase: String,
    val plim1: String,
    val plim10: String,
    val plim2: String,
    val plim3: String,
    val plim4: String,
    val plim5: String,
    val plim6: String,
    val plim7: String,
    val plim8: String,
    val plim9: String,
    val prate: String,
    val r: String,
    val rclose: String,
    val rdown: String,
    val ropen: String,
    val rselect: String,
    val rup: String,
    val ta: String,
    val tact: String,
    val tb: String,
    val tc: String,
    val tdgov: String,
    val teng: String,
    val tfload: String,
    val tpelec: String,
    val tsa: String,
    val tsb: String,
    val vmax: String,
    val vmin: String,
    val wfnl: String,
    val wfspd: String
)

data class DeleteGovCT2Command(@TargetAggregateIdentifier  var govCT2Id: UUID? = null)

// single association commands

// multiple association commands


// GovGAST Commands
data class CreateGovGASTCommand(
    @TargetAggregateIdentifier val govGASTId: UUID? = null,
    val at: String,
    val dturb: String,
    val kt: String,
    val mwbase: String,
    val r: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val vmax: String,
    val vmin: String
)

data class UpdateGovGASTCommand(
    @TargetAggregateIdentifier val govGASTId: UUID? = null,
    val at: String,
    val dturb: String,
    val kt: String,
    val mwbase: String,
    val r: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val vmax: String,
    val vmin: String
)

data class DeleteGovGASTCommand(@TargetAggregateIdentifier  var govGASTId: UUID? = null)

// single association commands

// multiple association commands


// GovGAST1 Commands
data class CreateGovGAST1Command(
    @TargetAggregateIdentifier val govGAST1Id: UUID? = null,
    val a: String,
    val b: String,
    val db1: String,
    val db2: String,
    val eps: String,
    val fidle: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val ka: String,
    val kt: String,
    val lmax: String,
    val loadinc: String,
    val ltrate: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val r: String,
    val rmax: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val tltr: String,
    val vmax: String,
    val vmin: String
)

data class UpdateGovGAST1Command(
    @TargetAggregateIdentifier val govGAST1Id: UUID? = null,
    val a: String,
    val b: String,
    val db1: String,
    val db2: String,
    val eps: String,
    val fidle: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val ka: String,
    val kt: String,
    val lmax: String,
    val loadinc: String,
    val ltrate: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val r: String,
    val rmax: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val tltr: String,
    val vmax: String,
    val vmin: String
)

data class DeleteGovGAST1Command(@TargetAggregateIdentifier  var govGAST1Id: UUID? = null)

// single association commands

// multiple association commands


// GovGAST2 Commands
data class CreateGovGAST2Command(
    @TargetAggregateIdentifier val govGAST2Id: UUID? = null,
    val a: String,
    val af1: String,
    val af2: String,
    val b: String,
    val bf1: String,
    val bf2: String,
    val c: String,
    val cf2: String,
    val ecr: String,
    val etd: String,
    val k3: String,
    val k4: String,
    val k5: String,
    val k6: String,
    val kf: String,
    val mwbase: String,
    val t: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val tc: String,
    val tcd: String,
    val tf: String,
    val tmax: String,
    val tmin: String,
    val tr: String,
    val trate: String,
    val tt: String,
    val w: String,
    val x: String,
    val y: String,
    val z: String
)

data class UpdateGovGAST2Command(
    @TargetAggregateIdentifier val govGAST2Id: UUID? = null,
    val a: String,
    val af1: String,
    val af2: String,
    val b: String,
    val bf1: String,
    val bf2: String,
    val c: String,
    val cf2: String,
    val ecr: String,
    val etd: String,
    val k3: String,
    val k4: String,
    val k5: String,
    val k6: String,
    val kf: String,
    val mwbase: String,
    val t: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val tc: String,
    val tcd: String,
    val tf: String,
    val tmax: String,
    val tmin: String,
    val tr: String,
    val trate: String,
    val tt: String,
    val w: String,
    val x: String,
    val y: String,
    val z: String
)

data class DeleteGovGAST2Command(@TargetAggregateIdentifier  var govGAST2Id: UUID? = null)

// single association commands

// multiple association commands


// GovGAST3 Commands
data class CreateGovGAST3Command(
    @TargetAggregateIdentifier val govGAST3Id: UUID? = null,
    val bca: String,
    val bp: String,
    val dtc: String,
    val ka: String,
    val kac: String,
    val kca: String,
    val ksi: String,
    val ky: String,
    val mnef: String,
    val mxef: String,
    val rcmn: String,
    val rcmx: String,
    val tac: String,
    val tc: String,
    val td: String,
    val tfen: String,
    val tg: String,
    val tsi: String,
    val tt: String,
    val ttc: String,
    val ty: String
)

data class UpdateGovGAST3Command(
    @TargetAggregateIdentifier val govGAST3Id: UUID? = null,
    val bca: String,
    val bp: String,
    val dtc: String,
    val ka: String,
    val kac: String,
    val kca: String,
    val ksi: String,
    val ky: String,
    val mnef: String,
    val mxef: String,
    val rcmn: String,
    val rcmx: String,
    val tac: String,
    val tc: String,
    val td: String,
    val tfen: String,
    val tg: String,
    val tsi: String,
    val tt: String,
    val ttc: String,
    val ty: String
)

data class DeleteGovGAST3Command(@TargetAggregateIdentifier  var govGAST3Id: UUID? = null)

// single association commands

// multiple association commands


// GovGAST4 Commands
data class CreateGovGAST4Command(
    @TargetAggregateIdentifier val govGAST4Id: UUID? = null,
    val bp: String,
    val ktm: String,
    val mnef: String,
    val mxef: String,
    val rymn: String,
    val rymx: String,
    val ta: String,
    val tc: String,
    val tcm: String,
    val tm: String,
    val tv: String
)

data class UpdateGovGAST4Command(
    @TargetAggregateIdentifier val govGAST4Id: UUID? = null,
    val bp: String,
    val ktm: String,
    val mnef: String,
    val mxef: String,
    val rymn: String,
    val rymx: String,
    val ta: String,
    val tc: String,
    val tcm: String,
    val tm: String,
    val tv: String
)

data class DeleteGovGAST4Command(@TargetAggregateIdentifier  var govGAST4Id: UUID? = null)

// single association commands

// multiple association commands


// GovGASTWD Commands
data class CreateGovGASTWDCommand(
    @TargetAggregateIdentifier val govGASTWDId: UUID? = null,
    val a: String,
    val af1: String,
    val af2: String,
    val b: String,
    val bf1: String,
    val bf2: String,
    val c: String,
    val cf2: String,
    val ecr: String,
    val etd: String,
    val k3: String,
    val k4: String,
    val k5: String,
    val k6: String,
    val kd: String,
    val kdroop: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val t: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val tc: String,
    val tcd: String,
    val td: String,
    val tf: String,
    val tmax: String,
    val tmin: String,
    val tr: String,
    val trate: String,
    val tt: String
)

data class UpdateGovGASTWDCommand(
    @TargetAggregateIdentifier val govGASTWDId: UUID? = null,
    val a: String,
    val af1: String,
    val af2: String,
    val b: String,
    val bf1: String,
    val bf2: String,
    val c: String,
    val cf2: String,
    val ecr: String,
    val etd: String,
    val k3: String,
    val k4: String,
    val k5: String,
    val k6: String,
    val kd: String,
    val kdroop: String,
    val kf: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val t: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val tc: String,
    val tcd: String,
    val td: String,
    val tf: String,
    val tmax: String,
    val tmin: String,
    val tr: String,
    val trate: String,
    val tt: String
)

data class DeleteGovGASTWDCommand(@TargetAggregateIdentifier  var govGASTWDId: UUID? = null)

// single association commands

// multiple association commands


// GovHydro1 Commands
data class CreateGovHydro1Command(
    @TargetAggregateIdentifier val govHydro1Id: UUID? = null,
    val at: String,
    val dturb: String,
    val gmax: String,
    val gmin: String,
    val hdam: String,
    val mwbase: String,
    val qnl: String,
    val rperm: String,
    val rtemp: String,
    val tf: String,
    val tg: String,
    val tr: String,
    val tw: String,
    val velm: String
)

data class UpdateGovHydro1Command(
    @TargetAggregateIdentifier val govHydro1Id: UUID? = null,
    val at: String,
    val dturb: String,
    val gmax: String,
    val gmin: String,
    val hdam: String,
    val mwbase: String,
    val qnl: String,
    val rperm: String,
    val rtemp: String,
    val tf: String,
    val tg: String,
    val tr: String,
    val tw: String,
    val velm: String
)

data class DeleteGovHydro1Command(@TargetAggregateIdentifier  var govHydro1Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydro2 Commands
data class CreateGovHydro2Command(
    @TargetAggregateIdentifier val govHydro2Id: UUID? = null,
    val aturb: String,
    val bturb: String,
    val db1: String,
    val db2: String,
    val eps: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val kturb: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val rperm: String,
    val rtemp: String,
    val tg: String,
    val tp: String,
    val tr: String,
    val tw: String,
    val uc: String,
    val uo: String
)

data class UpdateGovHydro2Command(
    @TargetAggregateIdentifier val govHydro2Id: UUID? = null,
    val aturb: String,
    val bturb: String,
    val db1: String,
    val db2: String,
    val eps: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val kturb: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val rperm: String,
    val rtemp: String,
    val tg: String,
    val tp: String,
    val tr: String,
    val tw: String,
    val uc: String,
    val uo: String
)

data class DeleteGovHydro2Command(@TargetAggregateIdentifier  var govHydro2Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydro3 Commands
data class CreateGovHydro3Command(
    @TargetAggregateIdentifier val govHydro3Id: UUID? = null,
    val at: String,
    val db1: String,
    val db2: String,
    val dturb: String,
    val eps: String,
    val governorControl: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val h0: String,
    val k1: String,
    val k2: String,
    val kg: String,
    val ki: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val qnl: String,
    val relec: String,
    val rgate: String,
    val td: String,
    val tf: String,
    val tp: String,
    val tt: String,
    val tw: String,
    val velcl: String,
    val velop: String
)

data class UpdateGovHydro3Command(
    @TargetAggregateIdentifier val govHydro3Id: UUID? = null,
    val at: String,
    val db1: String,
    val db2: String,
    val dturb: String,
    val eps: String,
    val governorControl: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val h0: String,
    val k1: String,
    val k2: String,
    val kg: String,
    val ki: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val qnl: String,
    val relec: String,
    val rgate: String,
    val td: String,
    val tf: String,
    val tp: String,
    val tt: String,
    val tw: String,
    val velcl: String,
    val velop: String
)

data class DeleteGovHydro3Command(@TargetAggregateIdentifier  var govHydro3Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydro4 Commands
data class CreateGovHydro4Command(
    @TargetAggregateIdentifier val govHydro4Id: UUID? = null,
    val at: String,
    val bgv0: String,
    val bgv1: String,
    val bgv2: String,
    val bgv3: String,
    val bgv4: String,
    val bgv5: String,
    val bmax: String,
    val db1: String,
    val db2: String,
    val dturb: String,
    val eps: String,
    val gmax: String,
    val gmin: String,
    val gv0: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val hdam: String,
    val mwbase: String,
    val pgv0: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val qn1: String,
    val rperm: String,
    val rtemp: String,
    val tblade: String,
    val tg: String,
    val tp: String,
    val tr: String,
    val tw: String,
    val uc: String,
    val uo: String
)

data class UpdateGovHydro4Command(
    @TargetAggregateIdentifier val govHydro4Id: UUID? = null,
    val at: String,
    val bgv0: String,
    val bgv1: String,
    val bgv2: String,
    val bgv3: String,
    val bgv4: String,
    val bgv5: String,
    val bmax: String,
    val db1: String,
    val db2: String,
    val dturb: String,
    val eps: String,
    val gmax: String,
    val gmin: String,
    val gv0: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val hdam: String,
    val mwbase: String,
    val pgv0: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val qn1: String,
    val rperm: String,
    val rtemp: String,
    val tblade: String,
    val tg: String,
    val tp: String,
    val tr: String,
    val tw: String,
    val uc: String,
    val uo: String
)

data class DeleteGovHydro4Command(@TargetAggregateIdentifier  var govHydro4Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydroDD Commands
data class CreateGovHydroDDCommand(
    @TargetAggregateIdentifier val govHydroDDId: UUID? = null,
    val aturb: String,
    val bturb: String,
    val db1: String,
    val db2: String,
    val eps: String,
    val gmax: String,
    val gmin: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val inputSignal: String,
    val k1: String,
    val k2: String,
    val kg: String,
    val ki: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val r: String,
    val td: String,
    val tf: String,
    val tp: String,
    val tt: String,
    val tturb: String,
    val velcl: String,
    val velop: String
)

data class UpdateGovHydroDDCommand(
    @TargetAggregateIdentifier val govHydroDDId: UUID? = null,
    val aturb: String,
    val bturb: String,
    val db1: String,
    val db2: String,
    val eps: String,
    val gmax: String,
    val gmin: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val inputSignal: String,
    val k1: String,
    val k2: String,
    val kg: String,
    val ki: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val r: String,
    val td: String,
    val tf: String,
    val tp: String,
    val tt: String,
    val tturb: String,
    val velcl: String,
    val velop: String
)

data class DeleteGovHydroDDCommand(@TargetAggregateIdentifier  var govHydroDDId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroFrancis Commands
data class CreateGovHydroFrancisCommand(
    @TargetAggregateIdentifier val govHydroFrancisId: UUID? = null,
    val am: String,
    val av0: String,
    val av1: String,
    val bp: String,
    val db1: String,
    val etamax: String,
    val governorControl: String,
    val h1: String,
    val h2: String,
    val hn: String,
    val kc: String,
    val kg: String,
    val kt: String,
    val qc0: String,
    val qn: String,
    val ta: String,
    val td: String,
    val ts: String,
    val twnc: String,
    val twng: String,
    val tx: String,
    val va: String,
    val valvmax: String,
    val valvmin: String,
    val vc: String,
    val waterTunnelSurgeChamberSimulation: String,
    val zsfc: String
)

data class UpdateGovHydroFrancisCommand(
    @TargetAggregateIdentifier val govHydroFrancisId: UUID? = null,
    val am: String,
    val av0: String,
    val av1: String,
    val bp: String,
    val db1: String,
    val etamax: String,
    val governorControl: String,
    val h1: String,
    val h2: String,
    val hn: String,
    val kc: String,
    val kg: String,
    val kt: String,
    val qc0: String,
    val qn: String,
    val ta: String,
    val td: String,
    val ts: String,
    val twnc: String,
    val twng: String,
    val tx: String,
    val va: String,
    val valvmax: String,
    val valvmin: String,
    val vc: String,
    val waterTunnelSurgeChamberSimulation: String,
    val zsfc: String
)

data class DeleteGovHydroFrancisCommand(@TargetAggregateIdentifier  var govHydroFrancisId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroIEEE0 Commands
data class CreateGovHydroIEEE0Command(
    @TargetAggregateIdentifier val govHydroIEEE0Id: UUID? = null,
    val k: String,
    val mwbase: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String
)

data class UpdateGovHydroIEEE0Command(
    @TargetAggregateIdentifier val govHydroIEEE0Id: UUID? = null,
    val k: String,
    val mwbase: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String
)

data class DeleteGovHydroIEEE0Command(@TargetAggregateIdentifier  var govHydroIEEE0Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydroIEEE2 Commands
data class CreateGovHydroIEEE2Command(
    @TargetAggregateIdentifier val govHydroIEEE2Id: UUID? = null,
    val aturb: String,
    val bturb: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val kturb: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val rperm: String,
    val rtemp: String,
    val tg: String,
    val tp: String,
    val tr: String,
    val tw: String,
    val uc: String,
    val uo: String
)

data class UpdateGovHydroIEEE2Command(
    @TargetAggregateIdentifier val govHydroIEEE2Id: UUID? = null,
    val aturb: String,
    val bturb: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val kturb: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val rperm: String,
    val rtemp: String,
    val tg: String,
    val tp: String,
    val tr: String,
    val tw: String,
    val uc: String,
    val uo: String
)

data class DeleteGovHydroIEEE2Command(@TargetAggregateIdentifier  var govHydroIEEE2Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydroPID Commands
data class CreateGovHydroPIDCommand(
    @TargetAggregateIdentifier val govHydroPIDId: UUID? = null,
    val aturb: String,
    val bturb: String,
    val db1: String,
    val db2: String,
    val eps: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val inputSignal: String,
    val kd: String,
    val kg: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val r: String,
    val td: String,
    val tf: String,
    val tp: String,
    val tt: String,
    val tturb: String,
    val velcl: String,
    val velop: String
)

data class UpdateGovHydroPIDCommand(
    @TargetAggregateIdentifier val govHydroPIDId: UUID? = null,
    val aturb: String,
    val bturb: String,
    val db1: String,
    val db2: String,
    val eps: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val inputSignal: String,
    val kd: String,
    val kg: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val r: String,
    val td: String,
    val tf: String,
    val tp: String,
    val tt: String,
    val tturb: String,
    val velcl: String,
    val velop: String
)

data class DeleteGovHydroPIDCommand(@TargetAggregateIdentifier  var govHydroPIDId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroPID2 Commands
data class CreateGovHydroPID2Command(
    @TargetAggregateIdentifier val govHydroPID2Id: UUID? = null,
    val atw: String,
    val d: String,
    val feedbackSignal: String,
    val g0: String,
    val g1: String,
    val g2: String,
    val gmax: String,
    val gmin: String,
    val kd: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val p1: String,
    val p2: String,
    val p3: String,
    val rperm: String,
    val ta: String,
    val tb: String,
    val treg: String,
    val tw: String,
    val velmax: String,
    val velmin: String
)

data class UpdateGovHydroPID2Command(
    @TargetAggregateIdentifier val govHydroPID2Id: UUID? = null,
    val atw: String,
    val d: String,
    val feedbackSignal: String,
    val g0: String,
    val g1: String,
    val g2: String,
    val gmax: String,
    val gmin: String,
    val kd: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val p1: String,
    val p2: String,
    val p3: String,
    val rperm: String,
    val ta: String,
    val tb: String,
    val treg: String,
    val tw: String,
    val velmax: String,
    val velmin: String
)

data class DeleteGovHydroPID2Command(@TargetAggregateIdentifier  var govHydroPID2Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydroPelton Commands
data class CreateGovHydroPeltonCommand(
    @TargetAggregateIdentifier val govHydroPeltonId: UUID? = null,
    val av0: String,
    val av1: String,
    val bp: String,
    val db1: String,
    val db2: String,
    val h1: String,
    val h2: String,
    val hn: String,
    val kc: String,
    val kg: String,
    val qc0: String,
    val qn: String,
    val simplifiedPelton: String,
    val staticCompensating: String,
    val ta: String,
    val ts: String,
    val tv: String,
    val twnc: String,
    val twng: String,
    val tx: String,
    val va: String,
    val valvmax: String,
    val valvmin: String,
    val vav: String,
    val vc: String,
    val vcv: String,
    val waterTunnelSurgeChamberSimulation: String,
    val zsfc: String
)

data class UpdateGovHydroPeltonCommand(
    @TargetAggregateIdentifier val govHydroPeltonId: UUID? = null,
    val av0: String,
    val av1: String,
    val bp: String,
    val db1: String,
    val db2: String,
    val h1: String,
    val h2: String,
    val hn: String,
    val kc: String,
    val kg: String,
    val qc0: String,
    val qn: String,
    val simplifiedPelton: String,
    val staticCompensating: String,
    val ta: String,
    val ts: String,
    val tv: String,
    val twnc: String,
    val twng: String,
    val tx: String,
    val va: String,
    val valvmax: String,
    val valvmin: String,
    val vav: String,
    val vc: String,
    val vcv: String,
    val waterTunnelSurgeChamberSimulation: String,
    val zsfc: String
)

data class DeleteGovHydroPeltonCommand(@TargetAggregateIdentifier  var govHydroPeltonId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroR Commands
data class CreateGovHydroRCommand(
    @TargetAggregateIdentifier val govHydroRId: UUID? = null,
    val at: String,
    val db1: String,
    val db2: String,
    val dturb: String,
    val eps: String,
    val gmax: String,
    val gmin: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val h0: String,
    val inputSignal: String,
    val kg: String,
    val ki: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val qnl: String,
    val r: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val td: String,
    val tp: String,
    val tt: String,
    val tw: String,
    val velcl: String,
    val velop: String
)

data class UpdateGovHydroRCommand(
    @TargetAggregateIdentifier val govHydroRId: UUID? = null,
    val at: String,
    val db1: String,
    val db2: String,
    val dturb: String,
    val eps: String,
    val gmax: String,
    val gmin: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val h0: String,
    val inputSignal: String,
    val kg: String,
    val ki: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val qnl: String,
    val r: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val td: String,
    val tp: String,
    val tt: String,
    val tw: String,
    val velcl: String,
    val velop: String
)

data class DeleteGovHydroRCommand(@TargetAggregateIdentifier  var govHydroRId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroWEH Commands
data class CreateGovHydroWEHCommand(
    @TargetAggregateIdentifier val govHydroWEHId: UUID? = null,
    val db: String,
    val dicn: String,
    val dpv: String,
    val dturb: String,
    val feedbackSignal: String,
    val fl1: String,
    val fl2: String,
    val fl3: String,
    val fl4: String,
    val fl5: String,
    val fp1: String,
    val fp10: String,
    val fp2: String,
    val fp3: String,
    val fp4: String,
    val fp5: String,
    val fp6: String,
    val fp7: String,
    val fp8: String,
    val fp9: String,
    val gmax: String,
    val gmin: String,
    val gtmxcl: String,
    val gtmxop: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val kd: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val pmss1: String,
    val pmss10: String,
    val pmss2: String,
    val pmss3: String,
    val pmss4: String,
    val pmss5: String,
    val pmss6: String,
    val pmss7: String,
    val pmss8: String,
    val pmss9: String,
    val rpg: String,
    val rpp: String,
    val td: String,
    val tdv: String,
    val tg: String,
    val tp: String,
    val tpe: String,
    val tw: String
)

data class UpdateGovHydroWEHCommand(
    @TargetAggregateIdentifier val govHydroWEHId: UUID? = null,
    val db: String,
    val dicn: String,
    val dpv: String,
    val dturb: String,
    val feedbackSignal: String,
    val fl1: String,
    val fl2: String,
    val fl3: String,
    val fl4: String,
    val fl5: String,
    val fp1: String,
    val fp10: String,
    val fp2: String,
    val fp3: String,
    val fp4: String,
    val fp5: String,
    val fp6: String,
    val fp7: String,
    val fp8: String,
    val fp9: String,
    val gmax: String,
    val gmin: String,
    val gtmxcl: String,
    val gtmxop: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val kd: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val pmss1: String,
    val pmss10: String,
    val pmss2: String,
    val pmss3: String,
    val pmss4: String,
    val pmss5: String,
    val pmss6: String,
    val pmss7: String,
    val pmss8: String,
    val pmss9: String,
    val rpg: String,
    val rpp: String,
    val td: String,
    val tdv: String,
    val tg: String,
    val tp: String,
    val tpe: String,
    val tw: String
)

data class DeleteGovHydroWEHCommand(@TargetAggregateIdentifier  var govHydroWEHId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroWPID Commands
data class CreateGovHydroWPIDCommand(
    @TargetAggregateIdentifier val govHydroWPIDId: UUID? = null,
    val d: String,
    val gatmax: String,
    val gatmin: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val kd: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pmax: String,
    val pmin: String,
    val reg: String,
    val ta: String,
    val tb: String,
    val treg: String,
    val tw: String,
    val velmax: String,
    val velmin: String
)

data class UpdateGovHydroWPIDCommand(
    @TargetAggregateIdentifier val govHydroWPIDId: UUID? = null,
    val d: String,
    val gatmax: String,
    val gatmin: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val kd: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pmax: String,
    val pmin: String,
    val reg: String,
    val ta: String,
    val tb: String,
    val treg: String,
    val tw: String,
    val velmax: String,
    val velmin: String
)

data class DeleteGovHydroWPIDCommand(@TargetAggregateIdentifier  var govHydroWPIDId: UUID? = null)

// single association commands

// multiple association commands


// GovSteam0 Commands
data class CreateGovSteam0Command(
    @TargetAggregateIdentifier val govSteam0Id: UUID? = null,
    val dt: String,
    val mwbase: String,
    val r: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val vmax: String,
    val vmin: String
)

data class UpdateGovSteam0Command(
    @TargetAggregateIdentifier val govSteam0Id: UUID? = null,
    val dt: String,
    val mwbase: String,
    val r: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val vmax: String,
    val vmin: String
)

data class DeleteGovSteam0Command(@TargetAggregateIdentifier  var govSteam0Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteam1 Commands
data class CreateGovSteam1Command(
    @TargetAggregateIdentifier val govSteam1Id: UUID? = null,
    val db1: String,
    val db2: String,
    val eps: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val k: String,
    val k1: String,
    val k2: String,
    val k3: String,
    val k4: String,
    val k5: String,
    val k6: String,
    val k7: String,
    val k8: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val sdb1: String,
    val sdb2: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val uc: String,
    val uo: String,
    val valve: String
)

data class UpdateGovSteam1Command(
    @TargetAggregateIdentifier val govSteam1Id: UUID? = null,
    val db1: String,
    val db2: String,
    val eps: String,
    val gv1: String,
    val gv2: String,
    val gv3: String,
    val gv4: String,
    val gv5: String,
    val gv6: String,
    val k: String,
    val k1: String,
    val k2: String,
    val k3: String,
    val k4: String,
    val k5: String,
    val k6: String,
    val k7: String,
    val k8: String,
    val mwbase: String,
    val pgv1: String,
    val pgv2: String,
    val pgv3: String,
    val pgv4: String,
    val pgv5: String,
    val pgv6: String,
    val pmax: String,
    val pmin: String,
    val sdb1: String,
    val sdb2: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val uc: String,
    val uo: String,
    val valve: String
)

data class DeleteGovSteam1Command(@TargetAggregateIdentifier  var govSteam1Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteam2 Commands
data class CreateGovSteam2Command(
    @TargetAggregateIdentifier val govSteam2Id: UUID? = null,
    val dbf: String,
    val k: String,
    val mnef: String,
    val mxef: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String
)

data class UpdateGovSteam2Command(
    @TargetAggregateIdentifier val govSteam2Id: UUID? = null,
    val dbf: String,
    val k: String,
    val mnef: String,
    val mxef: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String
)

data class DeleteGovSteam2Command(@TargetAggregateIdentifier  var govSteam2Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteamCC Commands
data class CreateGovSteamCCCommand(
    @TargetAggregateIdentifier val govSteamCCId: UUID? = null,
    val dhp: String,
    val dlp: String,
    val fhp: String,
    val flp: String,
    val mwbase: String,
    val pmaxhp: String,
    val pmaxlp: String,
    val rhp: String,
    val rlp: String,
    val t1hp: String,
    val t1lp: String,
    val t3hp: String,
    val t3lp: String,
    val t4hp: String,
    val t4lp: String,
    val t5hp: String,
    val t5lp: String
)

data class UpdateGovSteamCCCommand(
    @TargetAggregateIdentifier val govSteamCCId: UUID? = null,
    val dhp: String,
    val dlp: String,
    val fhp: String,
    val flp: String,
    val mwbase: String,
    val pmaxhp: String,
    val pmaxlp: String,
    val rhp: String,
    val rlp: String,
    val t1hp: String,
    val t1lp: String,
    val t3hp: String,
    val t3lp: String,
    val t4hp: String,
    val t4lp: String,
    val t5hp: String,
    val t5lp: String
)

data class DeleteGovSteamCCCommand(@TargetAggregateIdentifier  var govSteamCCId: UUID? = null)

// single association commands

// multiple association commands


// GovSteamEU Commands
data class CreateGovSteamEUCommand(
    @TargetAggregateIdentifier val govSteamEUId: UUID? = null,
    val chc: String,
    val cho: String,
    val cic: String,
    val cio: String,
    val db1: String,
    val db2: String,
    val hhpmax: String,
    val ke: String,
    val kfcor: String,
    val khp: String,
    val klp: String,
    val kwcor: String,
    val mwbase: String,
    val pmax: String,
    val prhmax: String,
    val simx: String,
    val tb: String,
    val tdp: String,
    val ten: String,
    val tf: String,
    val tfp: String,
    val thp: String,
    val tip: String,
    val tlp: String,
    val tp: String,
    val trh: String,
    val tvhp: String,
    val tvip: String,
    val tw: String,
    val wfmax: String,
    val wfmin: String,
    val wmax1: String,
    val wmax2: String,
    val wwmax: String,
    val wwmin: String
)

data class UpdateGovSteamEUCommand(
    @TargetAggregateIdentifier val govSteamEUId: UUID? = null,
    val chc: String,
    val cho: String,
    val cic: String,
    val cio: String,
    val db1: String,
    val db2: String,
    val hhpmax: String,
    val ke: String,
    val kfcor: String,
    val khp: String,
    val klp: String,
    val kwcor: String,
    val mwbase: String,
    val pmax: String,
    val prhmax: String,
    val simx: String,
    val tb: String,
    val tdp: String,
    val ten: String,
    val tf: String,
    val tfp: String,
    val thp: String,
    val tip: String,
    val tlp: String,
    val tp: String,
    val trh: String,
    val tvhp: String,
    val tvip: String,
    val tw: String,
    val wfmax: String,
    val wfmin: String,
    val wmax1: String,
    val wmax2: String,
    val wwmax: String,
    val wwmin: String
)

data class DeleteGovSteamEUCommand(@TargetAggregateIdentifier  var govSteamEUId: UUID? = null)

// single association commands

// multiple association commands


// GovSteamFV2 Commands
data class CreateGovSteamFV2Command(
    @TargetAggregateIdentifier val govSteamFV2Id: UUID? = null,
    val dt: String,
    val k: String,
    val mwbase: String,
    val r: String,
    val t1: String,
    val t3: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val ti: String,
    val tt: String,
    val vmax: String,
    val vmin: String
)

data class UpdateGovSteamFV2Command(
    @TargetAggregateIdentifier val govSteamFV2Id: UUID? = null,
    val dt: String,
    val k: String,
    val mwbase: String,
    val r: String,
    val t1: String,
    val t3: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val ti: String,
    val tt: String,
    val vmax: String,
    val vmin: String
)

data class DeleteGovSteamFV2Command(@TargetAggregateIdentifier  var govSteamFV2Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteamFV3 Commands
data class CreateGovSteamFV3Command(
    @TargetAggregateIdentifier val govSteamFV3Id: UUID? = null,
    val k: String,
    val k1: String,
    val k2: String,
    val k3: String,
    val mwbase: String,
    val pmax: String,
    val pmin: String,
    val prmax: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val uc: String,
    val uo: String
)

data class UpdateGovSteamFV3Command(
    @TargetAggregateIdentifier val govSteamFV3Id: UUID? = null,
    val k: String,
    val k1: String,
    val k2: String,
    val k3: String,
    val mwbase: String,
    val pmax: String,
    val pmin: String,
    val prmax: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val uc: String,
    val uo: String
)

data class DeleteGovSteamFV3Command(@TargetAggregateIdentifier  var govSteamFV3Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteamFV4 Commands
data class CreateGovSteamFV4Command(
    @TargetAggregateIdentifier val govSteamFV4Id: UUID? = null,
    val cpsmn: String,
    val cpsmx: String,
    val crmn: String,
    val crmx: String,
    val kdc: String,
    val kf1: String,
    val kf3: String,
    val khp: String,
    val kic: String,
    val kip: String,
    val kit: String,
    val kmp1: String,
    val kmp2: String,
    val kpc: String,
    val kpp: String,
    val kpt: String,
    val krc: String,
    val ksh: String,
    val lpi: String,
    val lps: String,
    val mnef: String,
    val mxef: String,
    val pr1: String,
    val pr2: String,
    val psmn: String,
    val rsmimn: String,
    val rsmimx: String,
    val rvgmn: String,
    val rvgmx: String,
    val srmn: String,
    val srmx: String,
    val srsmp: String,
    val svmn: String,
    val svmx: String,
    val ta: String,
    val tam: String,
    val tc: String,
    val tcm: String,
    val tdc: String,
    val tf1: String,
    val tf2: String,
    val thp: String,
    val tmp: String,
    val trh: String,
    val tv: String,
    val ty: String,
    val y: String,
    val yhpmn: String,
    val yhpmx: String,
    val ympmn: String,
    val ympmx: String
)

data class UpdateGovSteamFV4Command(
    @TargetAggregateIdentifier val govSteamFV4Id: UUID? = null,
    val cpsmn: String,
    val cpsmx: String,
    val crmn: String,
    val crmx: String,
    val kdc: String,
    val kf1: String,
    val kf3: String,
    val khp: String,
    val kic: String,
    val kip: String,
    val kit: String,
    val kmp1: String,
    val kmp2: String,
    val kpc: String,
    val kpp: String,
    val kpt: String,
    val krc: String,
    val ksh: String,
    val lpi: String,
    val lps: String,
    val mnef: String,
    val mxef: String,
    val pr1: String,
    val pr2: String,
    val psmn: String,
    val rsmimn: String,
    val rsmimx: String,
    val rvgmn: String,
    val rvgmx: String,
    val srmn: String,
    val srmx: String,
    val srsmp: String,
    val svmn: String,
    val svmx: String,
    val ta: String,
    val tam: String,
    val tc: String,
    val tcm: String,
    val tdc: String,
    val tf1: String,
    val tf2: String,
    val thp: String,
    val tmp: String,
    val trh: String,
    val tv: String,
    val ty: String,
    val y: String,
    val yhpmn: String,
    val yhpmx: String,
    val ympmn: String,
    val ympmx: String
)

data class DeleteGovSteamFV4Command(@TargetAggregateIdentifier  var govSteamFV4Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteamIEEE1 Commands
data class CreateGovSteamIEEE1Command(
    @TargetAggregateIdentifier val govSteamIEEE1Id: UUID? = null,
    val k: String,
    val k1: String,
    val k2: String,
    val k3: String,
    val k4: String,
    val k5: String,
    val k6: String,
    val k7: String,
    val k8: String,
    val mwbase: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val uc: String,
    val uo: String
)

data class UpdateGovSteamIEEE1Command(
    @TargetAggregateIdentifier val govSteamIEEE1Id: UUID? = null,
    val k: String,
    val k1: String,
    val k2: String,
    val k3: String,
    val k4: String,
    val k5: String,
    val k6: String,
    val k7: String,
    val k8: String,
    val mwbase: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val uc: String,
    val uo: String
)

data class DeleteGovSteamIEEE1Command(@TargetAggregateIdentifier  var govSteamIEEE1Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteamSGO Commands
data class CreateGovSteamSGOCommand(
    @TargetAggregateIdentifier val govSteamSGOId: UUID? = null,
    val k1: String,
    val k2: String,
    val k3: String,
    val mwbase: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String
)

data class UpdateGovSteamSGOCommand(
    @TargetAggregateIdentifier val govSteamSGOId: UUID? = null,
    val k1: String,
    val k2: String,
    val k3: String,
    val mwbase: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String
)

data class DeleteGovSteamSGOCommand(@TargetAggregateIdentifier  var govSteamSGOId: UUID? = null)

// single association commands

// multiple association commands


// GrossToNetActivePowerCurve Commands
data class CreateGrossToNetActivePowerCurveCommand(
    @TargetAggregateIdentifier  val grossToNetActivePowerCurveId: UUID? = null
)

data class UpdateGrossToNetActivePowerCurveCommand(
    @TargetAggregateIdentifier  val grossToNetActivePowerCurveId: UUID? = null
)

data class DeleteGrossToNetActivePowerCurveCommand(@TargetAggregateIdentifier  var grossToNetActivePowerCurveId: UUID? = null)

// single association commands

// multiple association commands


// Ground Commands
data class CreateGroundCommand(
    @TargetAggregateIdentifier  val groundId: UUID? = null
)

data class UpdateGroundCommand(
    @TargetAggregateIdentifier  val groundId: UUID? = null
)

data class DeleteGroundCommand(@TargetAggregateIdentifier  var groundId: UUID? = null)

// single association commands

// multiple association commands


// GroundDisconnector Commands
data class CreateGroundDisconnectorCommand(
    @TargetAggregateIdentifier  val groundDisconnectorId: UUID? = null
)

data class UpdateGroundDisconnectorCommand(
    @TargetAggregateIdentifier  val groundDisconnectorId: UUID? = null
)

data class DeleteGroundDisconnectorCommand(@TargetAggregateIdentifier  var groundDisconnectorId: UUID? = null)

// single association commands

// multiple association commands


// GroundingImpedance Commands
data class CreateGroundingImpedanceCommand(
    @TargetAggregateIdentifier val groundingImpedanceId: UUID? = null,
    val x: String
)

data class UpdateGroundingImpedanceCommand(
    @TargetAggregateIdentifier val groundingImpedanceId: UUID? = null,
    val x: String
)

data class DeleteGroundingImpedanceCommand(@TargetAggregateIdentifier  var groundingImpedanceId: UUID? = null)

// single association commands

// multiple association commands


// HydroGeneratingUnit Commands
data class CreateHydroGeneratingUnitCommand(
    @TargetAggregateIdentifier val hydroGeneratingUnitId: UUID? = null,
    val energyConversionCapability: String
)

data class UpdateHydroGeneratingUnitCommand(
    @TargetAggregateIdentifier val hydroGeneratingUnitId: UUID? = null,
    val energyConversionCapability: String
)

data class DeleteHydroGeneratingUnitCommand(@TargetAggregateIdentifier  var hydroGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// HydroPowerPlant Commands
data class CreateHydroPowerPlantCommand(
    @TargetAggregateIdentifier val hydroPowerPlantId: UUID? = null,
    val hydroPlantStorageType: String
)

data class UpdateHydroPowerPlantCommand(
    @TargetAggregateIdentifier val hydroPowerPlantId: UUID? = null,
    val hydroPlantStorageType: String
)

data class DeleteHydroPowerPlantCommand(@TargetAggregateIdentifier  var hydroPowerPlantId: UUID? = null)

// single association commands

// multiple association commands


// HydroPump Commands
data class CreateHydroPumpCommand(
    @TargetAggregateIdentifier  val hydroPumpId: UUID? = null
)

data class UpdateHydroPumpCommand(
    @TargetAggregateIdentifier  val hydroPumpId: UUID? = null
)

data class DeleteHydroPumpCommand(@TargetAggregateIdentifier  var hydroPumpId: UUID? = null)

// single association commands

// multiple association commands


// IdentifiedObject Commands
data class CreateIdentifiedObjectCommand(
    @TargetAggregateIdentifier val identifiedObjectId: UUID? = null,
    val description: String,
    val energyIdentCodeEic: String,
    val mRID: String,
    val name: String,
    val shortName: String
)

data class UpdateIdentifiedObjectCommand(
    @TargetAggregateIdentifier val identifiedObjectId: UUID? = null,
    val description: String,
    val energyIdentCodeEic: String,
    val mRID: String,
    val name: String,
    val shortName: String
)

data class DeleteIdentifiedObjectCommand(@TargetAggregateIdentifier  var identifiedObjectId: UUID? = null)

// single association commands

// multiple association commands


// Inductance Commands
data class CreateInductanceCommand(
    @TargetAggregateIdentifier val inductanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateInductanceCommand(
    @TargetAggregateIdentifier val inductanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteInductanceCommand(@TargetAggregateIdentifier  var inductanceId: UUID? = null)

// single association commands

// multiple association commands


// InductancePerLength Commands
data class CreateInductancePerLengthCommand(
    @TargetAggregateIdentifier val inductancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateInductancePerLengthCommand(
    @TargetAggregateIdentifier val inductancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteInductancePerLengthCommand(@TargetAggregateIdentifier  var inductancePerLengthId: UUID? = null)

// single association commands

// multiple association commands


// IntegerProxy Commands
data class CreateIntegerProxyCommand(
    @TargetAggregateIdentifier  val integerProxyId: UUID? = null
)

data class UpdateIntegerProxyCommand(
    @TargetAggregateIdentifier  val integerProxyId: UUID? = null
)

data class DeleteIntegerProxyCommand(@TargetAggregateIdentifier  var integerProxyId: UUID? = null)

// single association commands

// multiple association commands


// Junction Commands
data class CreateJunctionCommand(
    @TargetAggregateIdentifier  val junctionId: UUID? = null
)

data class UpdateJunctionCommand(
    @TargetAggregateIdentifier  val junctionId: UUID? = null
)

data class DeleteJunctionCommand(@TargetAggregateIdentifier  var junctionId: UUID? = null)

// single association commands

// multiple association commands


// Length Commands
data class CreateLengthCommand(
    @TargetAggregateIdentifier val lengthId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateLengthCommand(
    @TargetAggregateIdentifier val lengthId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteLengthCommand(@TargetAggregateIdentifier  var lengthId: UUID? = null)

// single association commands

// multiple association commands


// Limit Commands
data class CreateLimitCommand(
    @TargetAggregateIdentifier  val limitId: UUID? = null
)

data class UpdateLimitCommand(
    @TargetAggregateIdentifier  val limitId: UUID? = null
)

data class DeleteLimitCommand(@TargetAggregateIdentifier  var limitId: UUID? = null)

// single association commands

// multiple association commands


// LimitSet Commands
data class CreateLimitSetCommand(
    @TargetAggregateIdentifier val limitSetId: UUID? = null,
    val isPercentageLimits: String
)

data class UpdateLimitSetCommand(
    @TargetAggregateIdentifier val limitSetId: UUID? = null,
    val isPercentageLimits: String
)

data class DeleteLimitSetCommand(@TargetAggregateIdentifier  var limitSetId: UUID? = null)

// single association commands

// multiple association commands


// Line Commands
data class CreateLineCommand(
    @TargetAggregateIdentifier  val lineId: UUID? = null
)

data class UpdateLineCommand(
    @TargetAggregateIdentifier  val lineId: UUID? = null
)

data class DeleteLineCommand(@TargetAggregateIdentifier  var lineId: UUID? = null)

// single association commands

// multiple association commands


// LinearShuntCompensator Commands
data class CreateLinearShuntCompensatorCommand(
    @TargetAggregateIdentifier val linearShuntCompensatorId: UUID? = null,
    val b0PerSection: String,
    val bPerSection: String,
    val g0PerSection: String,
    val gPerSection: String
)

data class UpdateLinearShuntCompensatorCommand(
    @TargetAggregateIdentifier val linearShuntCompensatorId: UUID? = null,
    val b0PerSection: String,
    val bPerSection: String,
    val g0PerSection: String,
    val gPerSection: String
)

data class DeleteLinearShuntCompensatorCommand(@TargetAggregateIdentifier  var linearShuntCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// LoadAggregate Commands
data class CreateLoadAggregateCommand(
    @TargetAggregateIdentifier  val loadAggregateId: UUID? = null
)

data class UpdateLoadAggregateCommand(
    @TargetAggregateIdentifier  val loadAggregateId: UUID? = null
)

data class DeleteLoadAggregateCommand(@TargetAggregateIdentifier  var loadAggregateId: UUID? = null)

// single association commands

// multiple association commands


// LoadArea Commands
data class CreateLoadAreaCommand(
    @TargetAggregateIdentifier  val loadAreaId: UUID? = null
)

data class UpdateLoadAreaCommand(
    @TargetAggregateIdentifier  val loadAreaId: UUID? = null
)

data class DeleteLoadAreaCommand(@TargetAggregateIdentifier  var loadAreaId: UUID? = null)

// single association commands

// multiple association commands


// LoadBreakSwitch Commands
data class CreateLoadBreakSwitchCommand(
    @TargetAggregateIdentifier  val loadBreakSwitchId: UUID? = null
)

data class UpdateLoadBreakSwitchCommand(
    @TargetAggregateIdentifier  val loadBreakSwitchId: UUID? = null
)

data class DeleteLoadBreakSwitchCommand(@TargetAggregateIdentifier  var loadBreakSwitchId: UUID? = null)

// single association commands

// multiple association commands


// LoadComposite Commands
data class CreateLoadCompositeCommand(
    @TargetAggregateIdentifier val loadCompositeId: UUID? = null,
    val epfd: String,
    val epfs: String,
    val epvd: String,
    val epvs: String,
    val eqfd: String,
    val eqfs: String,
    val eqvd: String,
    val eqvs: String,
    val h: String,
    val lfrac: String,
    val pfrac: String
)

data class UpdateLoadCompositeCommand(
    @TargetAggregateIdentifier val loadCompositeId: UUID? = null,
    val epfd: String,
    val epfs: String,
    val epvd: String,
    val epvs: String,
    val eqfd: String,
    val eqfs: String,
    val eqvd: String,
    val eqvs: String,
    val h: String,
    val lfrac: String,
    val pfrac: String
)

data class DeleteLoadCompositeCommand(@TargetAggregateIdentifier  var loadCompositeId: UUID? = null)

// single association commands

// multiple association commands


// LoadDynamics Commands
data class CreateLoadDynamicsCommand(
    @TargetAggregateIdentifier  val loadDynamicsId: UUID? = null
)

data class UpdateLoadDynamicsCommand(
    @TargetAggregateIdentifier  val loadDynamicsId: UUID? = null
)

data class DeleteLoadDynamicsCommand(@TargetAggregateIdentifier  var loadDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// LoadGenericNonLinear Commands
data class CreateLoadGenericNonLinearCommand(
    @TargetAggregateIdentifier val loadGenericNonLinearId: UUID? = null,
    val bs: String,
    val bt: String,
    val genericNonLinearLoadModelType: String,
    val ls: String,
    val lt: String,
    val pt: String,
    val qt: String,
    val tp: String,
    val tq: String
)

data class UpdateLoadGenericNonLinearCommand(
    @TargetAggregateIdentifier val loadGenericNonLinearId: UUID? = null,
    val bs: String,
    val bt: String,
    val genericNonLinearLoadModelType: String,
    val ls: String,
    val lt: String,
    val pt: String,
    val qt: String,
    val tp: String,
    val tq: String
)

data class DeleteLoadGenericNonLinearCommand(@TargetAggregateIdentifier  var loadGenericNonLinearId: UUID? = null)

// single association commands

// multiple association commands


// LoadGroup Commands
data class CreateLoadGroupCommand(
    @TargetAggregateIdentifier  val loadGroupId: UUID? = null
)

data class UpdateLoadGroupCommand(
    @TargetAggregateIdentifier  val loadGroupId: UUID? = null
)

data class DeleteLoadGroupCommand(@TargetAggregateIdentifier  var loadGroupId: UUID? = null)

// single association commands

// multiple association commands


// LoadMotor Commands
data class CreateLoadMotorCommand(
    @TargetAggregateIdentifier val loadMotorId: UUID? = null,
    val d: String,
    val h: String,
    val lfac: String,
    val lp: String,
    val lpp: String,
    val ls: String,
    val pfrac: String,
    val ra: String,
    val tbkr: String,
    val tpo: String,
    val tppo: String,
    val tv: String,
    val vt: String
)

data class UpdateLoadMotorCommand(
    @TargetAggregateIdentifier val loadMotorId: UUID? = null,
    val d: String,
    val h: String,
    val lfac: String,
    val lp: String,
    val lpp: String,
    val ls: String,
    val pfrac: String,
    val ra: String,
    val tbkr: String,
    val tpo: String,
    val tppo: String,
    val tv: String,
    val vt: String
)

data class DeleteLoadMotorCommand(@TargetAggregateIdentifier  var loadMotorId: UUID? = null)

// single association commands

// multiple association commands


// LoadResponseCharacteristic Commands
data class CreateLoadResponseCharacteristicCommand(
    @TargetAggregateIdentifier val loadResponseCharacteristicId: UUID? = null,
    val exponentModel: String,
    val pConstantCurrent: String,
    val pConstantImpedance: String,
    val pConstantPower: String,
    val pFrequencyExponent: String,
    val pVoltageExponent: String,
    val qConstantCurrent: String,
    val qConstantImpedance: String,
    val qConstantPower: String,
    val qFrequencyExponent: String,
    val qVoltageExponent: String
)

data class UpdateLoadResponseCharacteristicCommand(
    @TargetAggregateIdentifier val loadResponseCharacteristicId: UUID? = null,
    val exponentModel: String,
    val pConstantCurrent: String,
    val pConstantImpedance: String,
    val pConstantPower: String,
    val pFrequencyExponent: String,
    val pVoltageExponent: String,
    val qConstantCurrent: String,
    val qConstantImpedance: String,
    val qConstantPower: String,
    val qFrequencyExponent: String,
    val qVoltageExponent: String
)

data class DeleteLoadResponseCharacteristicCommand(@TargetAggregateIdentifier  var loadResponseCharacteristicId: UUID? = null)

// single association commands

// multiple association commands


// LoadStatic Commands
data class CreateLoadStaticCommand(
    @TargetAggregateIdentifier val loadStaticId: UUID? = null,
    val ep1: String,
    val ep2: String,
    val ep3: String,
    val eq1: String,
    val eq2: String,
    val eq3: String,
    val kp1: String,
    val kp2: String,
    val kp3: String,
    val kp4: String,
    val kpf: String,
    val kq1: String,
    val kq2: String,
    val kq3: String,
    val kq4: String,
    val kqf: String,
    val staticLoadModelType: String
)

data class UpdateLoadStaticCommand(
    @TargetAggregateIdentifier val loadStaticId: UUID? = null,
    val ep1: String,
    val ep2: String,
    val ep3: String,
    val eq1: String,
    val eq2: String,
    val eq3: String,
    val kp1: String,
    val kp2: String,
    val kp3: String,
    val kp4: String,
    val kpf: String,
    val kq1: String,
    val kq2: String,
    val kq3: String,
    val kq4: String,
    val kqf: String,
    val staticLoadModelType: String
)

data class DeleteLoadStaticCommand(@TargetAggregateIdentifier  var loadStaticId: UUID? = null)

// single association commands

// multiple association commands


// LoadUserDefined Commands
data class CreateLoadUserDefinedCommand(
    @TargetAggregateIdentifier val loadUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateLoadUserDefinedCommand(
    @TargetAggregateIdentifier val loadUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteLoadUserDefinedCommand(@TargetAggregateIdentifier  var loadUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// Location Commands
data class CreateLocationCommand(
    @TargetAggregateIdentifier  val locationId: UUID? = null
)

data class UpdateLocationCommand(
    @TargetAggregateIdentifier  val locationId: UUID? = null
)

data class DeleteLocationCommand(@TargetAggregateIdentifier  var locationId: UUID? = null)

// single association commands

// multiple association commands


// Measurement Commands
data class CreateMeasurementCommand(
    @TargetAggregateIdentifier val measurementId: UUID? = null,
    val measurementType: String,
    val phases: String,
    val unitMultiplier: String,
    val unitSymbol: String
)

data class UpdateMeasurementCommand(
    @TargetAggregateIdentifier val measurementId: UUID? = null,
    val measurementType: String,
    val phases: String,
    val unitMultiplier: String,
    val unitSymbol: String
)

data class DeleteMeasurementCommand(@TargetAggregateIdentifier  var measurementId: UUID? = null)

// single association commands

// multiple association commands


// MeasurementValue Commands
data class CreateMeasurementValueCommand(
    @TargetAggregateIdentifier val measurementValueId: UUID? = null,
    val sensorAccuracy: String,
    val timeStamp: String
)

data class UpdateMeasurementValueCommand(
    @TargetAggregateIdentifier val measurementValueId: UUID? = null,
    val sensorAccuracy: String,
    val timeStamp: String
)

data class DeleteMeasurementValueCommand(@TargetAggregateIdentifier  var measurementValueId: UUID? = null)

// single association commands

// multiple association commands


// MeasurementValueQuality Commands
data class CreateMeasurementValueQualityCommand(
    @TargetAggregateIdentifier  val measurementValueQualityId: UUID? = null
)

data class UpdateMeasurementValueQualityCommand(
    @TargetAggregateIdentifier  val measurementValueQualityId: UUID? = null
)

data class DeleteMeasurementValueQualityCommand(@TargetAggregateIdentifier  var measurementValueQualityId: UUID? = null)

// single association commands

// multiple association commands


// MeasurementValueSource Commands
data class CreateMeasurementValueSourceCommand(
    @TargetAggregateIdentifier  val measurementValueSourceId: UUID? = null
)

data class UpdateMeasurementValueSourceCommand(
    @TargetAggregateIdentifier  val measurementValueSourceId: UUID? = null
)

data class DeleteMeasurementValueSourceCommand(@TargetAggregateIdentifier  var measurementValueSourceId: UUID? = null)

// single association commands

// multiple association commands


// MechLoad1 Commands
data class CreateMechLoad1Command(
    @TargetAggregateIdentifier val mechLoad1Id: UUID? = null,
    val a: String,
    val b: String,
    val d: String,
    val e: String
)

data class UpdateMechLoad1Command(
    @TargetAggregateIdentifier val mechLoad1Id: UUID? = null,
    val a: String,
    val b: String,
    val d: String,
    val e: String
)

data class DeleteMechLoad1Command(@TargetAggregateIdentifier  var mechLoad1Id: UUID? = null)

// single association commands

// multiple association commands


// MechanicalLoadDynamics Commands
data class CreateMechanicalLoadDynamicsCommand(
    @TargetAggregateIdentifier  val mechanicalLoadDynamicsId: UUID? = null
)

data class UpdateMechanicalLoadDynamicsCommand(
    @TargetAggregateIdentifier  val mechanicalLoadDynamicsId: UUID? = null
)

data class DeleteMechanicalLoadDynamicsCommand(@TargetAggregateIdentifier  var mechanicalLoadDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// MechanicalLoadUserDefined Commands
data class CreateMechanicalLoadUserDefinedCommand(
    @TargetAggregateIdentifier val mechanicalLoadUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateMechanicalLoadUserDefinedCommand(
    @TargetAggregateIdentifier val mechanicalLoadUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteMechanicalLoadUserDefinedCommand(@TargetAggregateIdentifier  var mechanicalLoadUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// Money Commands
data class CreateMoneyCommand(
    @TargetAggregateIdentifier val moneyId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateMoneyCommand(
    @TargetAggregateIdentifier val moneyId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteMoneyCommand(@TargetAggregateIdentifier  var moneyId: UUID? = null)

// single association commands

// multiple association commands


// MonthDay Commands
data class CreateMonthDayCommand(
    @TargetAggregateIdentifier  val monthDayId: UUID? = null
)

data class UpdateMonthDayCommand(
    @TargetAggregateIdentifier  val monthDayId: UUID? = null
)

data class DeleteMonthDayCommand(@TargetAggregateIdentifier  var monthDayId: UUID? = null)

// single association commands

// multiple association commands


// MonthDayInterval Commands
data class CreateMonthDayIntervalCommand(
    @TargetAggregateIdentifier val monthDayIntervalId: UUID? = null,
    val end: String,
    val start: String
)

data class UpdateMonthDayIntervalCommand(
    @TargetAggregateIdentifier val monthDayIntervalId: UUID? = null,
    val end: String,
    val start: String
)

data class DeleteMonthDayIntervalCommand(@TargetAggregateIdentifier  var monthDayIntervalId: UUID? = null)

// single association commands

// multiple association commands


// MutualCoupling Commands
data class CreateMutualCouplingCommand(
    @TargetAggregateIdentifier val mutualCouplingId: UUID? = null,
    val b0ch: String,
    val distance11: String,
    val distance12: String,
    val distance21: String,
    val distance22: String,
    val g0ch: String,
    val r0: String,
    val x0: String
)

data class UpdateMutualCouplingCommand(
    @TargetAggregateIdentifier val mutualCouplingId: UUID? = null,
    val b0ch: String,
    val distance11: String,
    val distance12: String,
    val distance21: String,
    val distance22: String,
    val g0ch: String,
    val r0: String,
    val x0: String
)

data class DeleteMutualCouplingCommand(@TargetAggregateIdentifier  var mutualCouplingId: UUID? = null)

// single association commands

// multiple association commands


// NonConformLoad Commands
data class CreateNonConformLoadCommand(
    @TargetAggregateIdentifier  val nonConformLoadId: UUID? = null
)

data class UpdateNonConformLoadCommand(
    @TargetAggregateIdentifier  val nonConformLoadId: UUID? = null
)

data class DeleteNonConformLoadCommand(@TargetAggregateIdentifier  var nonConformLoadId: UUID? = null)

// single association commands

// multiple association commands


// NonConformLoadGroup Commands
data class CreateNonConformLoadGroupCommand(
    @TargetAggregateIdentifier  val nonConformLoadGroupId: UUID? = null
)

data class UpdateNonConformLoadGroupCommand(
    @TargetAggregateIdentifier  val nonConformLoadGroupId: UUID? = null
)

data class DeleteNonConformLoadGroupCommand(@TargetAggregateIdentifier  var nonConformLoadGroupId: UUID? = null)

// single association commands

// multiple association commands


// NonConformLoadSchedule Commands
data class CreateNonConformLoadScheduleCommand(
    @TargetAggregateIdentifier  val nonConformLoadScheduleId: UUID? = null
)

data class UpdateNonConformLoadScheduleCommand(
    @TargetAggregateIdentifier  val nonConformLoadScheduleId: UUID? = null
)

data class DeleteNonConformLoadScheduleCommand(@TargetAggregateIdentifier  var nonConformLoadScheduleId: UUID? = null)

// single association commands

// multiple association commands


// NonlinearShuntCompensator Commands
data class CreateNonlinearShuntCompensatorCommand(
    @TargetAggregateIdentifier  val nonlinearShuntCompensatorId: UUID? = null
)

data class UpdateNonlinearShuntCompensatorCommand(
    @TargetAggregateIdentifier  val nonlinearShuntCompensatorId: UUID? = null
)

data class DeleteNonlinearShuntCompensatorCommand(@TargetAggregateIdentifier  var nonlinearShuntCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// NonlinearShuntCompensatorPoint Commands
data class CreateNonlinearShuntCompensatorPointCommand(
    @TargetAggregateIdentifier val nonlinearShuntCompensatorPointId: UUID? = null,
    val b: String,
    val b0: String,
    val g: String,
    val g0: String,
    val sectionNumber: String
)

data class UpdateNonlinearShuntCompensatorPointCommand(
    @TargetAggregateIdentifier val nonlinearShuntCompensatorPointId: UUID? = null,
    val b: String,
    val b0: String,
    val g: String,
    val g0: String,
    val sectionNumber: String
)

data class DeleteNonlinearShuntCompensatorPointCommand(@TargetAggregateIdentifier  var nonlinearShuntCompensatorPointId: UUID? = null)

// single association commands

// multiple association commands


// NuclearGeneratingUnit Commands
data class CreateNuclearGeneratingUnitCommand(
    @TargetAggregateIdentifier  val nuclearGeneratingUnitId: UUID? = null
)

data class UpdateNuclearGeneratingUnitCommand(
    @TargetAggregateIdentifier  val nuclearGeneratingUnitId: UUID? = null
)

data class DeleteNuclearGeneratingUnitCommand(@TargetAggregateIdentifier  var nuclearGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// OperationalLimit Commands
data class CreateOperationalLimitCommand(
    @TargetAggregateIdentifier  val operationalLimitId: UUID? = null
)

data class UpdateOperationalLimitCommand(
    @TargetAggregateIdentifier  val operationalLimitId: UUID? = null
)

data class DeleteOperationalLimitCommand(@TargetAggregateIdentifier  var operationalLimitId: UUID? = null)

// single association commands

// multiple association commands


// OperationalLimitSet Commands
data class CreateOperationalLimitSetCommand(
    @TargetAggregateIdentifier  val operationalLimitSetId: UUID? = null
)

data class UpdateOperationalLimitSetCommand(
    @TargetAggregateIdentifier  val operationalLimitSetId: UUID? = null
)

data class DeleteOperationalLimitSetCommand(@TargetAggregateIdentifier  var operationalLimitSetId: UUID? = null)

// single association commands

// multiple association commands


// OperationalLimitType Commands
data class CreateOperationalLimitTypeCommand(
    @TargetAggregateIdentifier val operationalLimitTypeId: UUID? = null,
    val acceptableDuration: String,
    val direction: String,
    val limitType: String
)

data class UpdateOperationalLimitTypeCommand(
    @TargetAggregateIdentifier val operationalLimitTypeId: UUID? = null,
    val acceptableDuration: String,
    val direction: String,
    val limitType: String
)

data class DeleteOperationalLimitTypeCommand(@TargetAggregateIdentifier  var operationalLimitTypeId: UUID? = null)

// single association commands

// multiple association commands


// OverexcLim2 Commands
data class CreateOverexcLim2Command(
    @TargetAggregateIdentifier val overexcLim2Id: UUID? = null,
    val ifdlim: String,
    val koi: String,
    val voimax: String,
    val voimin: String
)

data class UpdateOverexcLim2Command(
    @TargetAggregateIdentifier val overexcLim2Id: UUID? = null,
    val ifdlim: String,
    val koi: String,
    val voimax: String,
    val voimin: String
)

data class DeleteOverexcLim2Command(@TargetAggregateIdentifier  var overexcLim2Id: UUID? = null)

// single association commands

// multiple association commands


// OverexcLimIEEE Commands
data class CreateOverexcLimIEEECommand(
    @TargetAggregateIdentifier val overexcLimIEEEId: UUID? = null,
    val hyst: String,
    val ifdlim: String,
    val ifdmax: String,
    val itfpu: String,
    val kcd: String,
    val kramp: String
)

data class UpdateOverexcLimIEEECommand(
    @TargetAggregateIdentifier val overexcLimIEEEId: UUID? = null,
    val hyst: String,
    val ifdlim: String,
    val ifdmax: String,
    val itfpu: String,
    val kcd: String,
    val kramp: String
)

data class DeleteOverexcLimIEEECommand(@TargetAggregateIdentifier  var overexcLimIEEEId: UUID? = null)

// single association commands

// multiple association commands


// OverexcLimX1 Commands
data class CreateOverexcLimX1Command(
    @TargetAggregateIdentifier val overexcLimX1Id: UUID? = null,
    val efd1: String,
    val efd2: String,
    val efd3: String,
    val efddes: String,
    val efdrated: String,
    val kmx: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val vlow: String
)

data class UpdateOverexcLimX1Command(
    @TargetAggregateIdentifier val overexcLimX1Id: UUID? = null,
    val efd1: String,
    val efd2: String,
    val efd3: String,
    val efddes: String,
    val efdrated: String,
    val kmx: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val vlow: String
)

data class DeleteOverexcLimX1Command(@TargetAggregateIdentifier  var overexcLimX1Id: UUID? = null)

// single association commands

// multiple association commands


// OverexcLimX2 Commands
data class CreateOverexcLimX2Command(
    @TargetAggregateIdentifier val overexcLimX2Id: UUID? = null,
    val efd1: String,
    val efd2: String,
    val efd3: String,
    val efddes: String,
    val efdrated: String,
    val kmx: String,
    val m: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val vlow: String
)

data class UpdateOverexcLimX2Command(
    @TargetAggregateIdentifier val overexcLimX2Id: UUID? = null,
    val efd1: String,
    val efd2: String,
    val efd3: String,
    val efddes: String,
    val efdrated: String,
    val kmx: String,
    val m: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val vlow: String
)

data class DeleteOverexcLimX2Command(@TargetAggregateIdentifier  var overexcLimX2Id: UUID? = null)

// single association commands

// multiple association commands


// OverexcitationLimiterDynamics Commands
data class CreateOverexcitationLimiterDynamicsCommand(
    @TargetAggregateIdentifier  val overexcitationLimiterDynamicsId: UUID? = null
)

data class UpdateOverexcitationLimiterDynamicsCommand(
    @TargetAggregateIdentifier  val overexcitationLimiterDynamicsId: UUID? = null
)

data class DeleteOverexcitationLimiterDynamicsCommand(@TargetAggregateIdentifier  var overexcitationLimiterDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// OverexcitationLimiterUserDefined Commands
data class CreateOverexcitationLimiterUserDefinedCommand(
    @TargetAggregateIdentifier val overexcitationLimiterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateOverexcitationLimiterUserDefinedCommand(
    @TargetAggregateIdentifier val overexcitationLimiterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteOverexcitationLimiterUserDefinedCommand(@TargetAggregateIdentifier  var overexcitationLimiterUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// PFVArControllerType1Dynamics Commands
data class CreatePFVArControllerType1DynamicsCommand(
    @TargetAggregateIdentifier  val pFVArControllerType1DynamicsId: UUID? = null
)

data class UpdatePFVArControllerType1DynamicsCommand(
    @TargetAggregateIdentifier  val pFVArControllerType1DynamicsId: UUID? = null
)

data class DeletePFVArControllerType1DynamicsCommand(@TargetAggregateIdentifier  var pFVArControllerType1DynamicsId: UUID? = null)

// single association commands

// multiple association commands


// PFVArControllerType1UserDefined Commands
data class CreatePFVArControllerType1UserDefinedCommand(
    @TargetAggregateIdentifier val pFVArControllerType1UserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdatePFVArControllerType1UserDefinedCommand(
    @TargetAggregateIdentifier val pFVArControllerType1UserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeletePFVArControllerType1UserDefinedCommand(@TargetAggregateIdentifier  var pFVArControllerType1UserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// PFVArControllerType2Dynamics Commands
data class CreatePFVArControllerType2DynamicsCommand(
    @TargetAggregateIdentifier  val pFVArControllerType2DynamicsId: UUID? = null
)

data class UpdatePFVArControllerType2DynamicsCommand(
    @TargetAggregateIdentifier  val pFVArControllerType2DynamicsId: UUID? = null
)

data class DeletePFVArControllerType2DynamicsCommand(@TargetAggregateIdentifier  var pFVArControllerType2DynamicsId: UUID? = null)

// single association commands

// multiple association commands


// PFVArControllerType2UserDefined Commands
data class CreatePFVArControllerType2UserDefinedCommand(
    @TargetAggregateIdentifier val pFVArControllerType2UserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdatePFVArControllerType2UserDefinedCommand(
    @TargetAggregateIdentifier val pFVArControllerType2UserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeletePFVArControllerType2UserDefinedCommand(@TargetAggregateIdentifier  var pFVArControllerType2UserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// PFVArType1IEEEPFController Commands
data class CreatePFVArType1IEEEPFControllerCommand(
    @TargetAggregateIdentifier val pFVArType1IEEEPFControllerId: UUID? = null,
    val ovex: String,
    val tpfc: String,
    val vitmin: String,
    val vpf: String,
    val vpfcbw: String,
    val vpfref: String,
    val vvtmax: String,
    val vvtmin: String
)

data class UpdatePFVArType1IEEEPFControllerCommand(
    @TargetAggregateIdentifier val pFVArType1IEEEPFControllerId: UUID? = null,
    val ovex: String,
    val tpfc: String,
    val vitmin: String,
    val vpf: String,
    val vpfcbw: String,
    val vpfref: String,
    val vvtmax: String,
    val vvtmin: String
)

data class DeletePFVArType1IEEEPFControllerCommand(@TargetAggregateIdentifier  var pFVArType1IEEEPFControllerId: UUID? = null)

// single association commands

// multiple association commands


// PFVArType1IEEEVArController Commands
data class CreatePFVArType1IEEEVArControllerCommand(
    @TargetAggregateIdentifier val pFVArType1IEEEVArControllerId: UUID? = null,
    val tvarc: String,
    val vvar: String,
    val vvarcbw: String,
    val vvarref: String,
    val vvtmax: String,
    val vvtmin: String
)

data class UpdatePFVArType1IEEEVArControllerCommand(
    @TargetAggregateIdentifier val pFVArType1IEEEVArControllerId: UUID? = null,
    val tvarc: String,
    val vvar: String,
    val vvarcbw: String,
    val vvarref: String,
    val vvtmax: String,
    val vvtmin: String
)

data class DeletePFVArType1IEEEVArControllerCommand(@TargetAggregateIdentifier  var pFVArType1IEEEVArControllerId: UUID? = null)

// single association commands

// multiple association commands


// PFVArType2Common1 Commands
data class CreatePFVArType2Common1Command(
    @TargetAggregateIdentifier val pFVArType2Common1Id: UUID? = null,
    val j: String,
    val ki: String,
    val kp: String,
    val max: String,
    val ref: String
)

data class UpdatePFVArType2Common1Command(
    @TargetAggregateIdentifier val pFVArType2Common1Id: UUID? = null,
    val j: String,
    val ki: String,
    val kp: String,
    val max: String,
    val ref: String
)

data class DeletePFVArType2Common1Command(@TargetAggregateIdentifier  var pFVArType2Common1Id: UUID? = null)

// single association commands

// multiple association commands


// PFVArType2IEEEPFController Commands
data class CreatePFVArType2IEEEPFControllerCommand(
    @TargetAggregateIdentifier val pFVArType2IEEEPFControllerId: UUID? = null,
    val exlon: String,
    val ki: String,
    val kp: String,
    val pfref: String,
    val vclmt: String,
    val vref: String,
    val vs: String
)

data class UpdatePFVArType2IEEEPFControllerCommand(
    @TargetAggregateIdentifier val pFVArType2IEEEPFControllerId: UUID? = null,
    val exlon: String,
    val ki: String,
    val kp: String,
    val pfref: String,
    val vclmt: String,
    val vref: String,
    val vs: String
)

data class DeletePFVArType2IEEEPFControllerCommand(@TargetAggregateIdentifier  var pFVArType2IEEEPFControllerId: UUID? = null)

// single association commands

// multiple association commands


// PFVArType2IEEEVArController Commands
data class CreatePFVArType2IEEEVArControllerCommand(
    @TargetAggregateIdentifier val pFVArType2IEEEVArControllerId: UUID? = null,
    val exlon: String,
    val ki: String,
    val kp: String,
    val qref: String,
    val vclmt: String,
    val vref: String,
    val vs: String
)

data class UpdatePFVArType2IEEEVArControllerCommand(
    @TargetAggregateIdentifier val pFVArType2IEEEVArControllerId: UUID? = null,
    val exlon: String,
    val ki: String,
    val kp: String,
    val qref: String,
    val vclmt: String,
    val vref: String,
    val vs: String
)

data class DeletePFVArType2IEEEVArControllerCommand(@TargetAggregateIdentifier  var pFVArType2IEEEVArControllerId: UUID? = null)

// single association commands

// multiple association commands


// PU Commands
data class CreatePUCommand(
    @TargetAggregateIdentifier val pUId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdatePUCommand(
    @TargetAggregateIdentifier val pUId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeletePUCommand(@TargetAggregateIdentifier  var pUId: UUID? = null)

// single association commands

// multiple association commands


// PerCent Commands
data class CreatePerCentCommand(
    @TargetAggregateIdentifier val perCentId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdatePerCentCommand(
    @TargetAggregateIdentifier val perCentId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeletePerCentCommand(@TargetAggregateIdentifier  var perCentId: UUID? = null)

// single association commands

// multiple association commands


// PerLengthDCLineParameter Commands
data class CreatePerLengthDCLineParameterCommand(
    @TargetAggregateIdentifier val perLengthDCLineParameterId: UUID? = null,
    val capacitance: String,
    val inductance: String,
    val resistance: String
)

data class UpdatePerLengthDCLineParameterCommand(
    @TargetAggregateIdentifier val perLengthDCLineParameterId: UUID? = null,
    val capacitance: String,
    val inductance: String,
    val resistance: String
)

data class DeletePerLengthDCLineParameterCommand(@TargetAggregateIdentifier  var perLengthDCLineParameterId: UUID? = null)

// single association commands

// multiple association commands


// PetersenCoil Commands
data class CreatePetersenCoilCommand(
    @TargetAggregateIdentifier val petersenCoilId: UUID? = null,
    val mode: String,
    val nominalU: String,
    val offsetCurrent: String,
    val positionCurrent: String,
    val xGroundMax: String,
    val xGroundMin: String,
    val xGroundNominal: String
)

data class UpdatePetersenCoilCommand(
    @TargetAggregateIdentifier val petersenCoilId: UUID? = null,
    val mode: String,
    val nominalU: String,
    val offsetCurrent: String,
    val positionCurrent: String,
    val xGroundMax: String,
    val xGroundMin: String,
    val xGroundNominal: String
)

data class DeletePetersenCoilCommand(@TargetAggregateIdentifier  var petersenCoilId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChanger Commands
data class CreatePhaseTapChangerCommand(
    @TargetAggregateIdentifier  val phaseTapChangerId: UUID? = null
)

data class UpdatePhaseTapChangerCommand(
    @TargetAggregateIdentifier  val phaseTapChangerId: UUID? = null
)

data class DeletePhaseTapChangerCommand(@TargetAggregateIdentifier  var phaseTapChangerId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerAsymmetrical Commands
data class CreatePhaseTapChangerAsymmetricalCommand(
    @TargetAggregateIdentifier val phaseTapChangerAsymmetricalId: UUID? = null,
    val windingConnectionAngle: String
)

data class UpdatePhaseTapChangerAsymmetricalCommand(
    @TargetAggregateIdentifier val phaseTapChangerAsymmetricalId: UUID? = null,
    val windingConnectionAngle: String
)

data class DeletePhaseTapChangerAsymmetricalCommand(@TargetAggregateIdentifier  var phaseTapChangerAsymmetricalId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerLinear Commands
data class CreatePhaseTapChangerLinearCommand(
    @TargetAggregateIdentifier val phaseTapChangerLinearId: UUID? = null,
    val stepPhaseShiftIncrement: String,
    val xMax: String,
    val xMin: String
)

data class UpdatePhaseTapChangerLinearCommand(
    @TargetAggregateIdentifier val phaseTapChangerLinearId: UUID? = null,
    val stepPhaseShiftIncrement: String,
    val xMax: String,
    val xMin: String
)

data class DeletePhaseTapChangerLinearCommand(@TargetAggregateIdentifier  var phaseTapChangerLinearId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerNonLinear Commands
data class CreatePhaseTapChangerNonLinearCommand(
    @TargetAggregateIdentifier val phaseTapChangerNonLinearId: UUID? = null,
    val voltageStepIncrement: String,
    val xMax: String,
    val xMin: String
)

data class UpdatePhaseTapChangerNonLinearCommand(
    @TargetAggregateIdentifier val phaseTapChangerNonLinearId: UUID? = null,
    val voltageStepIncrement: String,
    val xMax: String,
    val xMin: String
)

data class DeletePhaseTapChangerNonLinearCommand(@TargetAggregateIdentifier  var phaseTapChangerNonLinearId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerSymmetrical Commands
data class CreatePhaseTapChangerSymmetricalCommand(
    @TargetAggregateIdentifier  val phaseTapChangerSymmetricalId: UUID? = null
)

data class UpdatePhaseTapChangerSymmetricalCommand(
    @TargetAggregateIdentifier  val phaseTapChangerSymmetricalId: UUID? = null
)

data class DeletePhaseTapChangerSymmetricalCommand(@TargetAggregateIdentifier  var phaseTapChangerSymmetricalId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerTable Commands
data class CreatePhaseTapChangerTableCommand(
    @TargetAggregateIdentifier  val phaseTapChangerTableId: UUID? = null
)

data class UpdatePhaseTapChangerTableCommand(
    @TargetAggregateIdentifier  val phaseTapChangerTableId: UUID? = null
)

data class DeletePhaseTapChangerTableCommand(@TargetAggregateIdentifier  var phaseTapChangerTableId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerTablePoint Commands
data class CreatePhaseTapChangerTablePointCommand(
    @TargetAggregateIdentifier val phaseTapChangerTablePointId: UUID? = null,
    val angle: String
)

data class UpdatePhaseTapChangerTablePointCommand(
    @TargetAggregateIdentifier val phaseTapChangerTablePointId: UUID? = null,
    val angle: String
)

data class DeletePhaseTapChangerTablePointCommand(@TargetAggregateIdentifier  var phaseTapChangerTablePointId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerTabular Commands
data class CreatePhaseTapChangerTabularCommand(
    @TargetAggregateIdentifier  val phaseTapChangerTabularId: UUID? = null
)

data class UpdatePhaseTapChangerTabularCommand(
    @TargetAggregateIdentifier  val phaseTapChangerTabularId: UUID? = null
)

data class DeletePhaseTapChangerTabularCommand(@TargetAggregateIdentifier  var phaseTapChangerTabularId: UUID? = null)

// single association commands

// multiple association commands


// PositionPoint Commands
data class CreatePositionPointCommand(
    @TargetAggregateIdentifier val positionPointId: UUID? = null,
    val sequenceNumber: String,
    val xPosition: String,
    val yPosition: String,
    val zPosition: String
)

data class UpdatePositionPointCommand(
    @TargetAggregateIdentifier val positionPointId: UUID? = null,
    val sequenceNumber: String,
    val xPosition: String,
    val yPosition: String,
    val zPosition: String
)

data class DeletePositionPointCommand(@TargetAggregateIdentifier  var positionPointId: UUID? = null)

// single association commands

// multiple association commands


// PowerSystemResource Commands
data class CreatePowerSystemResourceCommand(
    @TargetAggregateIdentifier  val powerSystemResourceId: UUID? = null
)

data class UpdatePowerSystemResourceCommand(
    @TargetAggregateIdentifier  val powerSystemResourceId: UUID? = null
)

data class DeletePowerSystemResourceCommand(@TargetAggregateIdentifier  var powerSystemResourceId: UUID? = null)

// single association commands

// multiple association commands


// PowerSystemStabilizerDynamics Commands
data class CreatePowerSystemStabilizerDynamicsCommand(
    @TargetAggregateIdentifier  val powerSystemStabilizerDynamicsId: UUID? = null
)

data class UpdatePowerSystemStabilizerDynamicsCommand(
    @TargetAggregateIdentifier  val powerSystemStabilizerDynamicsId: UUID? = null
)

data class DeletePowerSystemStabilizerDynamicsCommand(@TargetAggregateIdentifier  var powerSystemStabilizerDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// PowerSystemStabilizerUserDefined Commands
data class CreatePowerSystemStabilizerUserDefinedCommand(
    @TargetAggregateIdentifier val powerSystemStabilizerUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdatePowerSystemStabilizerUserDefinedCommand(
    @TargetAggregateIdentifier val powerSystemStabilizerUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeletePowerSystemStabilizerUserDefinedCommand(@TargetAggregateIdentifier  var powerSystemStabilizerUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// PowerTransformer Commands
data class CreatePowerTransformerCommand(
    @TargetAggregateIdentifier val powerTransformerId: UUID? = null,
    val beforeShCircuitHighestOperatingCurrent: String,
    val beforeShCircuitHighestOperatingVoltage: String,
    val beforeShortCircuitAnglePf: String,
    val highSideMinOperatingU: String,
    val isPartOfGeneratorUnit: String,
    val operationalValuesConsidered: String
)

data class UpdatePowerTransformerCommand(
    @TargetAggregateIdentifier val powerTransformerId: UUID? = null,
    val beforeShCircuitHighestOperatingCurrent: String,
    val beforeShCircuitHighestOperatingVoltage: String,
    val beforeShortCircuitAnglePf: String,
    val highSideMinOperatingU: String,
    val isPartOfGeneratorUnit: String,
    val operationalValuesConsidered: String
)

data class DeletePowerTransformerCommand(@TargetAggregateIdentifier  var powerTransformerId: UUID? = null)

// single association commands

// multiple association commands


// PowerTransformerEnd Commands
data class CreatePowerTransformerEndCommand(
    @TargetAggregateIdentifier val powerTransformerEndId: UUID? = null,
    val b: String,
    val b0: String,
    val connectionKind: String,
    val g: String,
    val g0: String,
    val phaseAngleClock: String,
    val r: String,
    val r0: String,
    val ratedS: String,
    val ratedU: String,
    val x: String,
    val x0: String
)

data class UpdatePowerTransformerEndCommand(
    @TargetAggregateIdentifier val powerTransformerEndId: UUID? = null,
    val b: String,
    val b0: String,
    val connectionKind: String,
    val g: String,
    val g0: String,
    val phaseAngleClock: String,
    val r: String,
    val r0: String,
    val ratedS: String,
    val ratedU: String,
    val x: String,
    val x0: String
)

data class DeletePowerTransformerEndCommand(@TargetAggregateIdentifier  var powerTransformerEndId: UUID? = null)

// single association commands

// multiple association commands


// ProprietaryParameterDynamics Commands
data class CreateProprietaryParameterDynamicsCommand(
    @TargetAggregateIdentifier val proprietaryParameterDynamicsId: UUID? = null,
    val booleanParameterValue: String,
    val floatParameterValue: String,
    val integerParameterValue: String,
    val parameterNumber: String
)

data class UpdateProprietaryParameterDynamicsCommand(
    @TargetAggregateIdentifier val proprietaryParameterDynamicsId: UUID? = null,
    val booleanParameterValue: String,
    val floatParameterValue: String,
    val integerParameterValue: String,
    val parameterNumber: String
)

data class DeleteProprietaryParameterDynamicsCommand(@TargetAggregateIdentifier  var proprietaryParameterDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// ProtectedSwitch Commands
data class CreateProtectedSwitchCommand(
    @TargetAggregateIdentifier  val protectedSwitchId: UUID? = null
)

data class UpdateProtectedSwitchCommand(
    @TargetAggregateIdentifier  val protectedSwitchId: UUID? = null
)

data class DeleteProtectedSwitchCommand(@TargetAggregateIdentifier  var protectedSwitchId: UUID? = null)

// single association commands

// multiple association commands


// Pss1 Commands
data class CreatePss1Command(
    @TargetAggregateIdentifier val pss1Id: UUID? = null,
    val kf: String,
    val kpe: String,
    val ks: String,
    val kw: String,
    val pmin: String,
    val t10: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val t9: String,
    val tpe: String,
    val vadat: String,
    val vsmn: String,
    val vsmx: String
)

data class UpdatePss1Command(
    @TargetAggregateIdentifier val pss1Id: UUID? = null,
    val kf: String,
    val kpe: String,
    val ks: String,
    val kw: String,
    val pmin: String,
    val t10: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val t9: String,
    val tpe: String,
    val vadat: String,
    val vsmn: String,
    val vsmx: String
)

data class DeletePss1Command(@TargetAggregateIdentifier  var pss1Id: UUID? = null)

// single association commands

// multiple association commands


// Pss1A Commands
data class CreatePss1ACommand(
    @TargetAggregateIdentifier val pss1AId: UUID? = null,
    val a1: String,
    val a2: String,
    val a3: String,
    val a4: String,
    val a5: String,
    val a6: String,
    val a7: String,
    val a8: String,
    val inputSignalType: String,
    val kd: String,
    val ks: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val tdelay: String,
    val vcl: String,
    val vcu: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdatePss1ACommand(
    @TargetAggregateIdentifier val pss1AId: UUID? = null,
    val a1: String,
    val a2: String,
    val a3: String,
    val a4: String,
    val a5: String,
    val a6: String,
    val a7: String,
    val a8: String,
    val inputSignalType: String,
    val kd: String,
    val ks: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val tdelay: String,
    val vcl: String,
    val vcu: String,
    val vrmax: String,
    val vrmin: String
)

data class DeletePss1ACommand(@TargetAggregateIdentifier  var pss1AId: UUID? = null)

// single association commands

// multiple association commands


// Pss2B Commands
data class CreatePss2BCommand(
    @TargetAggregateIdentifier val pss2BId: UUID? = null,
    val a: String,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val ks1: String,
    val ks2: String,
    val ks3: String,
    val ks4: String,
    val m: String,
    val n: String,
    val t1: String,
    val t10: String,
    val t11: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val t9: String,
    val ta: String,
    val tb: String,
    val tw1: String,
    val tw2: String,
    val tw3: String,
    val tw4: String,
    val vsi1max: String,
    val vsi1min: String,
    val vsi2max: String,
    val vsi2min: String,
    val vstmax: String,
    val vstmin: String
)

data class UpdatePss2BCommand(
    @TargetAggregateIdentifier val pss2BId: UUID? = null,
    val a: String,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val ks1: String,
    val ks2: String,
    val ks3: String,
    val ks4: String,
    val m: String,
    val n: String,
    val t1: String,
    val t10: String,
    val t11: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val t9: String,
    val ta: String,
    val tb: String,
    val tw1: String,
    val tw2: String,
    val tw3: String,
    val tw4: String,
    val vsi1max: String,
    val vsi1min: String,
    val vsi2max: String,
    val vsi2min: String,
    val vstmax: String,
    val vstmin: String
)

data class DeletePss2BCommand(@TargetAggregateIdentifier  var pss2BId: UUID? = null)

// single association commands

// multiple association commands


// Pss2ST Commands
data class CreatePss2STCommand(
    @TargetAggregateIdentifier val pss2STId: UUID? = null,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val k1: String,
    val k2: String,
    val lsmax: String,
    val lsmin: String,
    val t1: String,
    val t10: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val t9: String,
    val vcl: String,
    val vcu: String
)

data class UpdatePss2STCommand(
    @TargetAggregateIdentifier val pss2STId: UUID? = null,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val k1: String,
    val k2: String,
    val lsmax: String,
    val lsmin: String,
    val t1: String,
    val t10: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val t9: String,
    val vcl: String,
    val vcu: String
)

data class DeletePss2STCommand(@TargetAggregateIdentifier  var pss2STId: UUID? = null)

// single association commands

// multiple association commands


// Pss5 Commands
data class CreatePss5Command(
    @TargetAggregateIdentifier val pss5Id: UUID? = null,
    val ctw2: String,
    val deadband: String,
    val isfreq: String,
    val kf: String,
    val kpe: String,
    val kpss: String,
    val pmm: String,
    val tl1: String,
    val tl2: String,
    val tl3: String,
    val tl4: String,
    val tpe: String,
    val tw1: String,
    val tw2: String,
    val vadat: String,
    val vsmn: String,
    val vsmx: String
)

data class UpdatePss5Command(
    @TargetAggregateIdentifier val pss5Id: UUID? = null,
    val ctw2: String,
    val deadband: String,
    val isfreq: String,
    val kf: String,
    val kpe: String,
    val kpss: String,
    val pmm: String,
    val tl1: String,
    val tl2: String,
    val tl3: String,
    val tl4: String,
    val tpe: String,
    val tw1: String,
    val tw2: String,
    val vadat: String,
    val vsmn: String,
    val vsmx: String
)

data class DeletePss5Command(@TargetAggregateIdentifier  var pss5Id: UUID? = null)

// single association commands

// multiple association commands


// PssELIN2 Commands
data class CreatePssELIN2Command(
    @TargetAggregateIdentifier val pssELIN2Id: UUID? = null,
    val apss: String,
    val ks1: String,
    val ks2: String,
    val ppss: String,
    val psslim: String,
    val ts1: String,
    val ts2: String,
    val ts3: String,
    val ts4: String,
    val ts5: String,
    val ts6: String
)

data class UpdatePssELIN2Command(
    @TargetAggregateIdentifier val pssELIN2Id: UUID? = null,
    val apss: String,
    val ks1: String,
    val ks2: String,
    val ppss: String,
    val psslim: String,
    val ts1: String,
    val ts2: String,
    val ts3: String,
    val ts4: String,
    val ts5: String,
    val ts6: String
)

data class DeletePssELIN2Command(@TargetAggregateIdentifier  var pssELIN2Id: UUID? = null)

// single association commands

// multiple association commands


// PssIEEE1A Commands
data class CreatePssIEEE1ACommand(
    @TargetAggregateIdentifier val pssIEEE1AId: UUID? = null,
    val a1: String,
    val a2: String,
    val inputSignalType: String,
    val ks: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val vrmax: String,
    val vrmin: String
)

data class UpdatePssIEEE1ACommand(
    @TargetAggregateIdentifier val pssIEEE1AId: UUID? = null,
    val a1: String,
    val a2: String,
    val inputSignalType: String,
    val ks: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val vrmax: String,
    val vrmin: String
)

data class DeletePssIEEE1ACommand(@TargetAggregateIdentifier  var pssIEEE1AId: UUID? = null)

// single association commands

// multiple association commands


// PssIEEE2B Commands
data class CreatePssIEEE2BCommand(
    @TargetAggregateIdentifier val pssIEEE2BId: UUID? = null,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val ks1: String,
    val ks2: String,
    val ks3: String,
    val m: String,
    val n: String,
    val t1: String,
    val t10: String,
    val t11: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val t9: String,
    val tw1: String,
    val tw2: String,
    val tw3: String,
    val tw4: String,
    val vsi1max: String,
    val vsi1min: String,
    val vsi2max: String,
    val vsi2min: String,
    val vstmax: String,
    val vstmin: String
)

data class UpdatePssIEEE2BCommand(
    @TargetAggregateIdentifier val pssIEEE2BId: UUID? = null,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val ks1: String,
    val ks2: String,
    val ks3: String,
    val m: String,
    val n: String,
    val t1: String,
    val t10: String,
    val t11: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val t9: String,
    val tw1: String,
    val tw2: String,
    val tw3: String,
    val tw4: String,
    val vsi1max: String,
    val vsi1min: String,
    val vsi2max: String,
    val vsi2min: String,
    val vstmax: String,
    val vstmin: String
)

data class DeletePssIEEE2BCommand(@TargetAggregateIdentifier  var pssIEEE2BId: UUID? = null)

// single association commands

// multiple association commands


// PssIEEE3B Commands
data class CreatePssIEEE3BCommand(
    @TargetAggregateIdentifier val pssIEEE3BId: UUID? = null,
    val a1: String,
    val a2: String,
    val a3: String,
    val a4: String,
    val a5: String,
    val a6: String,
    val a7: String,
    val a8: String,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val ks1: String,
    val ks2: String,
    val t1: String,
    val t2: String,
    val tw1: String,
    val tw2: String,
    val tw3: String,
    val vstmax: String,
    val vstmin: String
)

data class UpdatePssIEEE3BCommand(
    @TargetAggregateIdentifier val pssIEEE3BId: UUID? = null,
    val a1: String,
    val a2: String,
    val a3: String,
    val a4: String,
    val a5: String,
    val a6: String,
    val a7: String,
    val a8: String,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val ks1: String,
    val ks2: String,
    val t1: String,
    val t2: String,
    val tw1: String,
    val tw2: String,
    val tw3: String,
    val vstmax: String,
    val vstmin: String
)

data class DeletePssIEEE3BCommand(@TargetAggregateIdentifier  var pssIEEE3BId: UUID? = null)

// single association commands

// multiple association commands


// PssIEEE4B Commands
data class CreatePssIEEE4BCommand(
    @TargetAggregateIdentifier val pssIEEE4BId: UUID? = null,
    val bwh1: String,
    val bwh2: String,
    val bwl1: String,
    val bwl2: String,
    val kh: String,
    val kh1: String,
    val kh11: String,
    val kh17: String,
    val kh2: String,
    val ki: String,
    val ki1: String,
    val ki11: String,
    val ki17: String,
    val ki2: String,
    val kl: String,
    val kl1: String,
    val kl11: String,
    val kl17: String,
    val kl2: String,
    val omeganh1: String,
    val omeganh2: String,
    val omeganl1: String,
    val omeganl2: String,
    val th1: String,
    val th10: String,
    val th11: String,
    val th12: String,
    val th2: String,
    val th3: String,
    val th4: String,
    val th5: String,
    val th6: String,
    val th7: String,
    val th8: String,
    val th9: String,
    val ti1: String,
    val ti10: String,
    val ti11: String,
    val ti12: String,
    val ti2: String,
    val ti3: String,
    val ti4: String,
    val ti5: String,
    val ti6: String,
    val ti7: String,
    val ti8: String,
    val ti9: String,
    val tl1: String,
    val tl10: String,
    val tl11: String,
    val tl12: String,
    val tl2: String,
    val tl3: String,
    val tl4: String,
    val tl5: String,
    val tl6: String,
    val tl7: String,
    val tl8: String,
    val tl9: String,
    val vhmax: String,
    val vhmin: String,
    val vimax: String,
    val vimin: String,
    val vlmax: String,
    val vlmin: String,
    val vstmax: String,
    val vstmin: String
)

data class UpdatePssIEEE4BCommand(
    @TargetAggregateIdentifier val pssIEEE4BId: UUID? = null,
    val bwh1: String,
    val bwh2: String,
    val bwl1: String,
    val bwl2: String,
    val kh: String,
    val kh1: String,
    val kh11: String,
    val kh17: String,
    val kh2: String,
    val ki: String,
    val ki1: String,
    val ki11: String,
    val ki17: String,
    val ki2: String,
    val kl: String,
    val kl1: String,
    val kl11: String,
    val kl17: String,
    val kl2: String,
    val omeganh1: String,
    val omeganh2: String,
    val omeganl1: String,
    val omeganl2: String,
    val th1: String,
    val th10: String,
    val th11: String,
    val th12: String,
    val th2: String,
    val th3: String,
    val th4: String,
    val th5: String,
    val th6: String,
    val th7: String,
    val th8: String,
    val th9: String,
    val ti1: String,
    val ti10: String,
    val ti11: String,
    val ti12: String,
    val ti2: String,
    val ti3: String,
    val ti4: String,
    val ti5: String,
    val ti6: String,
    val ti7: String,
    val ti8: String,
    val ti9: String,
    val tl1: String,
    val tl10: String,
    val tl11: String,
    val tl12: String,
    val tl2: String,
    val tl3: String,
    val tl4: String,
    val tl5: String,
    val tl6: String,
    val tl7: String,
    val tl8: String,
    val tl9: String,
    val vhmax: String,
    val vhmin: String,
    val vimax: String,
    val vimin: String,
    val vlmax: String,
    val vlmin: String,
    val vstmax: String,
    val vstmin: String
)

data class DeletePssIEEE4BCommand(@TargetAggregateIdentifier  var pssIEEE4BId: UUID? = null)

// single association commands

// multiple association commands


// PssPTIST1 Commands
data class CreatePssPTIST1Command(
    @TargetAggregateIdentifier val pssPTIST1Id: UUID? = null,
    val dtc: String,
    val dtf: String,
    val dtp: String,
    val k: String,
    val m: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val tf: String,
    val tp: String
)

data class UpdatePssPTIST1Command(
    @TargetAggregateIdentifier val pssPTIST1Id: UUID? = null,
    val dtc: String,
    val dtf: String,
    val dtp: String,
    val k: String,
    val m: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val tf: String,
    val tp: String
)

data class DeletePssPTIST1Command(@TargetAggregateIdentifier  var pssPTIST1Id: UUID? = null)

// single association commands

// multiple association commands


// PssPTIST3 Commands
data class CreatePssPTIST3Command(
    @TargetAggregateIdentifier val pssPTIST3Id: UUID? = null,
    val a0: String,
    val a1: String,
    val a2: String,
    val a3: String,
    val a4: String,
    val a5: String,
    val al: String,
    val athres: String,
    val b0: String,
    val b1: String,
    val b2: String,
    val b3: String,
    val b4: String,
    val b5: String,
    val dl: String,
    val dtc: String,
    val dtf: String,
    val dtp: String,
    val isw: String,
    val k: String,
    val lthres: String,
    val m: String,
    val nav: String,
    val ncl: String,
    val ncr: String,
    val pmin: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val tf: String,
    val tp: String
)

data class UpdatePssPTIST3Command(
    @TargetAggregateIdentifier val pssPTIST3Id: UUID? = null,
    val a0: String,
    val a1: String,
    val a2: String,
    val a3: String,
    val a4: String,
    val a5: String,
    val al: String,
    val athres: String,
    val b0: String,
    val b1: String,
    val b2: String,
    val b3: String,
    val b4: String,
    val b5: String,
    val dl: String,
    val dtc: String,
    val dtf: String,
    val dtp: String,
    val isw: String,
    val k: String,
    val lthres: String,
    val m: String,
    val nav: String,
    val ncl: String,
    val ncr: String,
    val pmin: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val tf: String,
    val tp: String
)

data class DeletePssPTIST3Command(@TargetAggregateIdentifier  var pssPTIST3Id: UUID? = null)

// single association commands

// multiple association commands


// PssSB4 Commands
data class CreatePssSB4Command(
    @TargetAggregateIdentifier val pssSB4Id: UUID? = null,
    val kx: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val td: String,
    val te: String,
    val tt: String,
    val tx1: String,
    val tx2: String,
    val vsmax: String,
    val vsmin: String
)

data class UpdatePssSB4Command(
    @TargetAggregateIdentifier val pssSB4Id: UUID? = null,
    val kx: String,
    val ta: String,
    val tb: String,
    val tc: String,
    val td: String,
    val te: String,
    val tt: String,
    val tx1: String,
    val tx2: String,
    val vsmax: String,
    val vsmin: String
)

data class DeletePssSB4Command(@TargetAggregateIdentifier  var pssSB4Id: UUID? = null)

// single association commands

// multiple association commands


// PssSH Commands
data class CreatePssSHCommand(
    @TargetAggregateIdentifier val pssSHId: UUID? = null,
    val k: String,
    val k0: String,
    val k1: String,
    val k2: String,
    val k3: String,
    val k4: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val td: String,
    val vsmax: String,
    val vsmin: String
)

data class UpdatePssSHCommand(
    @TargetAggregateIdentifier val pssSHId: UUID? = null,
    val k: String,
    val k0: String,
    val k1: String,
    val k2: String,
    val k3: String,
    val k4: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val td: String,
    val vsmax: String,
    val vsmin: String
)

data class DeletePssSHCommand(@TargetAggregateIdentifier  var pssSHId: UUID? = null)

// single association commands

// multiple association commands


// PssSK Commands
data class CreatePssSKCommand(
    @TargetAggregateIdentifier val pssSKId: UUID? = null,
    val k1: String,
    val k2: String,
    val k3: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val vsmax: String,
    val vsmin: String
)

data class UpdatePssSKCommand(
    @TargetAggregateIdentifier val pssSKId: UUID? = null,
    val k1: String,
    val k2: String,
    val k3: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val vsmax: String,
    val vsmin: String
)

data class DeletePssSKCommand(@TargetAggregateIdentifier  var pssSKId: UUID? = null)

// single association commands

// multiple association commands


// PssWECC Commands
data class CreatePssWECCCommand(
    @TargetAggregateIdentifier val pssWECCId: UUID? = null,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val k1: String,
    val k2: String,
    val t1: String,
    val t10: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val t9: String,
    val vcl: String,
    val vcu: String,
    val vsmax: String,
    val vsmin: String
)

data class UpdatePssWECCCommand(
    @TargetAggregateIdentifier val pssWECCId: UUID? = null,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val k1: String,
    val k2: String,
    val t1: String,
    val t10: String,
    val t2: String,
    val t3: String,
    val t4: String,
    val t5: String,
    val t6: String,
    val t7: String,
    val t8: String,
    val t9: String,
    val vcl: String,
    val vcu: String,
    val vsmax: String,
    val vsmin: String
)

data class DeletePssWECCCommand(@TargetAggregateIdentifier  var pssWECCId: UUID? = null)

// single association commands

// multiple association commands


// Quality61850 Commands
data class CreateQuality61850Command(
    @TargetAggregateIdentifier val quality61850Id: UUID? = null,
    val badReference: String,
    val estimatorReplaced: String,
    val failure: String,
    val oldData: String,
    val operatorBlocked: String,
    val oscillatory: String,
    val outOfRange: String,
    val overFlow: String,
    val source: String,
    val suspect: String,
    val test: String,
    val validity: String
)

data class UpdateQuality61850Command(
    @TargetAggregateIdentifier val quality61850Id: UUID? = null,
    val badReference: String,
    val estimatorReplaced: String,
    val failure: String,
    val oldData: String,
    val operatorBlocked: String,
    val oscillatory: String,
    val outOfRange: String,
    val overFlow: String,
    val source: String,
    val suspect: String,
    val test: String,
    val validity: String
)

data class DeleteQuality61850Command(@TargetAggregateIdentifier  var quality61850Id: UUID? = null)

// single association commands

// multiple association commands


// RaiseLowerCommand Commands
data class CreateRaiseLowerCommandCommand(
    @TargetAggregateIdentifier  val raiseLowerCommandId: UUID? = null
)

data class UpdateRaiseLowerCommandCommand(
    @TargetAggregateIdentifier  val raiseLowerCommandId: UUID? = null
)

data class DeleteRaiseLowerCommandCommand(@TargetAggregateIdentifier  var raiseLowerCommandId: UUID? = null)

// single association commands

// multiple association commands


// RatioTapChanger Commands
data class CreateRatioTapChangerCommand(
    @TargetAggregateIdentifier val ratioTapChangerId: UUID? = null,
    val stepVoltageIncrement: String,
    val tculControlMode: String
)

data class UpdateRatioTapChangerCommand(
    @TargetAggregateIdentifier val ratioTapChangerId: UUID? = null,
    val stepVoltageIncrement: String,
    val tculControlMode: String
)

data class DeleteRatioTapChangerCommand(@TargetAggregateIdentifier  var ratioTapChangerId: UUID? = null)

// single association commands

// multiple association commands


// RatioTapChangerTable Commands
data class CreateRatioTapChangerTableCommand(
    @TargetAggregateIdentifier  val ratioTapChangerTableId: UUID? = null
)

data class UpdateRatioTapChangerTableCommand(
    @TargetAggregateIdentifier  val ratioTapChangerTableId: UUID? = null
)

data class DeleteRatioTapChangerTableCommand(@TargetAggregateIdentifier  var ratioTapChangerTableId: UUID? = null)

// single association commands

// multiple association commands


// RatioTapChangerTablePoint Commands
data class CreateRatioTapChangerTablePointCommand(
    @TargetAggregateIdentifier  val ratioTapChangerTablePointId: UUID? = null
)

data class UpdateRatioTapChangerTablePointCommand(
    @TargetAggregateIdentifier  val ratioTapChangerTablePointId: UUID? = null
)

data class DeleteRatioTapChangerTablePointCommand(@TargetAggregateIdentifier  var ratioTapChangerTablePointId: UUID? = null)

// single association commands

// multiple association commands


// Reactance Commands
data class CreateReactanceCommand(
    @TargetAggregateIdentifier val reactanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateReactanceCommand(
    @TargetAggregateIdentifier val reactanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteReactanceCommand(@TargetAggregateIdentifier  var reactanceId: UUID? = null)

// single association commands

// multiple association commands


// ReactiveCapabilityCurve Commands
data class CreateReactiveCapabilityCurveCommand(
    @TargetAggregateIdentifier  val reactiveCapabilityCurveId: UUID? = null
)

data class UpdateReactiveCapabilityCurveCommand(
    @TargetAggregateIdentifier  val reactiveCapabilityCurveId: UUID? = null
)

data class DeleteReactiveCapabilityCurveCommand(@TargetAggregateIdentifier  var reactiveCapabilityCurveId: UUID? = null)

// single association commands

// multiple association commands


// ReactivePower Commands
data class CreateReactivePowerCommand(
    @TargetAggregateIdentifier val reactivePowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateReactivePowerCommand(
    @TargetAggregateIdentifier val reactivePowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteReactivePowerCommand(@TargetAggregateIdentifier  var reactivePowerId: UUID? = null)

// single association commands

// multiple association commands


// RegularIntervalSchedule Commands
data class CreateRegularIntervalScheduleCommand(
    @TargetAggregateIdentifier val regularIntervalScheduleId: UUID? = null,
    val endTime: String,
    val timeStep: String
)

data class UpdateRegularIntervalScheduleCommand(
    @TargetAggregateIdentifier val regularIntervalScheduleId: UUID? = null,
    val endTime: String,
    val timeStep: String
)

data class DeleteRegularIntervalScheduleCommand(@TargetAggregateIdentifier  var regularIntervalScheduleId: UUID? = null)

// single association commands

// multiple association commands


// RegularTimePoint Commands
data class CreateRegularTimePointCommand(
    @TargetAggregateIdentifier val regularTimePointId: UUID? = null,
    val sequenceNumber: String,
    val value1: String,
    val value2: String
)

data class UpdateRegularTimePointCommand(
    @TargetAggregateIdentifier val regularTimePointId: UUID? = null,
    val sequenceNumber: String,
    val value1: String,
    val value2: String
)

data class DeleteRegularTimePointCommand(@TargetAggregateIdentifier  var regularTimePointId: UUID? = null)

// single association commands

// multiple association commands


// RegulatingCondEq Commands
data class CreateRegulatingCondEqCommand(
    @TargetAggregateIdentifier  val regulatingCondEqId: UUID? = null
)

data class UpdateRegulatingCondEqCommand(
    @TargetAggregateIdentifier  val regulatingCondEqId: UUID? = null
)

data class DeleteRegulatingCondEqCommand(@TargetAggregateIdentifier  var regulatingCondEqId: UUID? = null)

// single association commands

// multiple association commands


// RegulatingControl Commands
data class CreateRegulatingControlCommand(
    @TargetAggregateIdentifier val regulatingControlId: UUID? = null,
    val mode: String
)

data class UpdateRegulatingControlCommand(
    @TargetAggregateIdentifier val regulatingControlId: UUID? = null,
    val mode: String
)

data class DeleteRegulatingControlCommand(@TargetAggregateIdentifier  var regulatingControlId: UUID? = null)

// single association commands

// multiple association commands


// RegulationSchedule Commands
data class CreateRegulationScheduleCommand(
    @TargetAggregateIdentifier  val regulationScheduleId: UUID? = null
)

data class UpdateRegulationScheduleCommand(
    @TargetAggregateIdentifier  val regulationScheduleId: UUID? = null
)

data class DeleteRegulationScheduleCommand(@TargetAggregateIdentifier  var regulationScheduleId: UUID? = null)

// single association commands

// multiple association commands


// RemoteInputSignal Commands
data class CreateRemoteInputSignalCommand(
    @TargetAggregateIdentifier val remoteInputSignalId: UUID? = null,
    val remoteSignalType: String
)

data class UpdateRemoteInputSignalCommand(
    @TargetAggregateIdentifier val remoteInputSignalId: UUID? = null,
    val remoteSignalType: String
)

data class DeleteRemoteInputSignalCommand(@TargetAggregateIdentifier  var remoteInputSignalId: UUID? = null)

// single association commands

// multiple association commands


// ReportingGroup Commands
data class CreateReportingGroupCommand(
    @TargetAggregateIdentifier  val reportingGroupId: UUID? = null
)

data class UpdateReportingGroupCommand(
    @TargetAggregateIdentifier  val reportingGroupId: UUID? = null
)

data class DeleteReportingGroupCommand(@TargetAggregateIdentifier  var reportingGroupId: UUID? = null)

// single association commands

// multiple association commands


// Resistance Commands
data class CreateResistanceCommand(
    @TargetAggregateIdentifier val resistanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateResistanceCommand(
    @TargetAggregateIdentifier val resistanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteResistanceCommand(@TargetAggregateIdentifier  var resistanceId: UUID? = null)

// single association commands

// multiple association commands


// ResistancePerLength Commands
data class CreateResistancePerLengthCommand(
    @TargetAggregateIdentifier val resistancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateResistancePerLengthCommand(
    @TargetAggregateIdentifier val resistancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteResistancePerLengthCommand(@TargetAggregateIdentifier  var resistancePerLengthId: UUID? = null)

// single association commands

// multiple association commands


// RotatingMachine Commands
data class CreateRotatingMachineCommand(
    @TargetAggregateIdentifier val rotatingMachineId: UUID? = null,
    val ratedPowerFactor: String,
    val ratedS: String,
    val ratedU: String
)

data class UpdateRotatingMachineCommand(
    @TargetAggregateIdentifier val rotatingMachineId: UUID? = null,
    val ratedPowerFactor: String,
    val ratedS: String,
    val ratedU: String
)

data class DeleteRotatingMachineCommand(@TargetAggregateIdentifier  var rotatingMachineId: UUID? = null)

// single association commands

// multiple association commands


// RotatingMachineDynamics Commands
data class CreateRotatingMachineDynamicsCommand(
    @TargetAggregateIdentifier val rotatingMachineDynamicsId: UUID? = null,
    val damping: String,
    val inertia: String,
    val saturationFactor: String,
    val saturationFactor120: String,
    val statorLeakageReactance: String,
    val statorResistance: String
)

data class UpdateRotatingMachineDynamicsCommand(
    @TargetAggregateIdentifier val rotatingMachineDynamicsId: UUID? = null,
    val damping: String,
    val inertia: String,
    val saturationFactor: String,
    val saturationFactor120: String,
    val statorLeakageReactance: String,
    val statorResistance: String
)

data class DeleteRotatingMachineDynamicsCommand(@TargetAggregateIdentifier  var rotatingMachineDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// RotationSpeed Commands
data class CreateRotationSpeedCommand(
    @TargetAggregateIdentifier val rotationSpeedId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateRotationSpeedCommand(
    @TargetAggregateIdentifier val rotationSpeedId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteRotationSpeedCommand(@TargetAggregateIdentifier  var rotationSpeedId: UUID? = null)

// single association commands

// multiple association commands


// Season Commands
data class CreateSeasonCommand(
    @TargetAggregateIdentifier val seasonId: UUID? = null,
    val endDate: String,
    val startDate: String
)

data class UpdateSeasonCommand(
    @TargetAggregateIdentifier val seasonId: UUID? = null,
    val endDate: String,
    val startDate: String
)

data class DeleteSeasonCommand(@TargetAggregateIdentifier  var seasonId: UUID? = null)

// single association commands

// multiple association commands


// SeasonDayTypeSchedule Commands
data class CreateSeasonDayTypeScheduleCommand(
    @TargetAggregateIdentifier  val seasonDayTypeScheduleId: UUID? = null
)

data class UpdateSeasonDayTypeScheduleCommand(
    @TargetAggregateIdentifier  val seasonDayTypeScheduleId: UUID? = null
)

data class DeleteSeasonDayTypeScheduleCommand(@TargetAggregateIdentifier  var seasonDayTypeScheduleId: UUID? = null)

// single association commands

// multiple association commands


// Seconds Commands
data class CreateSecondsCommand(
    @TargetAggregateIdentifier val secondsId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateSecondsCommand(
    @TargetAggregateIdentifier val secondsId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteSecondsCommand(@TargetAggregateIdentifier  var secondsId: UUID? = null)

// single association commands

// multiple association commands


// SeriesCompensator Commands
data class CreateSeriesCompensatorCommand(
    @TargetAggregateIdentifier val seriesCompensatorId: UUID? = null,
    val r: String,
    val r0: String,
    val varistorPresent: String,
    val varistorRatedCurrent: String,
    val varistorVoltageThreshold: String,
    val x: String,
    val x0: String
)

data class UpdateSeriesCompensatorCommand(
    @TargetAggregateIdentifier val seriesCompensatorId: UUID? = null,
    val r: String,
    val r0: String,
    val varistorPresent: String,
    val varistorRatedCurrent: String,
    val varistorVoltageThreshold: String,
    val x: String,
    val x0: String
)

data class DeleteSeriesCompensatorCommand(@TargetAggregateIdentifier  var seriesCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// SetPoint Commands
data class CreateSetPointCommand(
    @TargetAggregateIdentifier val setPointId: UUID? = null,
    val normalValue: String,
    val value: String
)

data class UpdateSetPointCommand(
    @TargetAggregateIdentifier val setPointId: UUID? = null,
    val normalValue: String,
    val value: String
)

data class DeleteSetPointCommand(@TargetAggregateIdentifier  var setPointId: UUID? = null)

// single association commands

// multiple association commands


// ShuntCompensator Commands
data class CreateShuntCompensatorCommand(
    @TargetAggregateIdentifier val shuntCompensatorId: UUID? = null,
    val aVRDelay: String,
    val grounded: String,
    val maximumSections: String,
    val nomU: String,
    val normalSections: String,
    val switchOnCount: String,
    val switchOnDate: String,
    val voltageSensitivity: String
)

data class UpdateShuntCompensatorCommand(
    @TargetAggregateIdentifier val shuntCompensatorId: UUID? = null,
    val aVRDelay: String,
    val grounded: String,
    val maximumSections: String,
    val nomU: String,
    val normalSections: String,
    val switchOnCount: String,
    val switchOnDate: String,
    val voltageSensitivity: String
)

data class DeleteShuntCompensatorCommand(@TargetAggregateIdentifier  var shuntCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// Simple_Float Commands
data class CreateSimple_FloatCommand(
    @TargetAggregateIdentifier val simple_FloatId: UUID? = null,
    val value: String
)

data class UpdateSimple_FloatCommand(
    @TargetAggregateIdentifier val simple_FloatId: UUID? = null,
    val value: String
)

data class DeleteSimple_FloatCommand(@TargetAggregateIdentifier  var simple_FloatId: UUID? = null)

// single association commands

// multiple association commands


// SolarGeneratingUnit Commands
data class CreateSolarGeneratingUnitCommand(
    @TargetAggregateIdentifier  val solarGeneratingUnitId: UUID? = null
)

data class UpdateSolarGeneratingUnitCommand(
    @TargetAggregateIdentifier  val solarGeneratingUnitId: UUID? = null
)

data class DeleteSolarGeneratingUnitCommand(@TargetAggregateIdentifier  var solarGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// StateVariablesVersion Commands
data class CreateStateVariablesVersionCommand(
    @TargetAggregateIdentifier val stateVariablesVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class UpdateStateVariablesVersionCommand(
    @TargetAggregateIdentifier val stateVariablesVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class DeleteStateVariablesVersionCommand(@TargetAggregateIdentifier  var stateVariablesVersionId: UUID? = null)

// single association commands

// multiple association commands


// StaticVarCompensator Commands
data class CreateStaticVarCompensatorCommand(
    @TargetAggregateIdentifier val staticVarCompensatorId: UUID? = null,
    val capacitiveRating: String,
    val inductiveRating: String,
    val slope: String,
    val sVCControlMode: String,
    val voltageSetPoint: String
)

data class UpdateStaticVarCompensatorCommand(
    @TargetAggregateIdentifier val staticVarCompensatorId: UUID? = null,
    val capacitiveRating: String,
    val inductiveRating: String,
    val slope: String,
    val sVCControlMode: String,
    val voltageSetPoint: String
)

data class DeleteStaticVarCompensatorCommand(@TargetAggregateIdentifier  var staticVarCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// Staticpowersystemmodel Commands
data class CreateStaticpowersystemmodelCommand(
    @TargetAggregateIdentifier  val staticpowersystemmodelId: UUID? = null
)

data class UpdateStaticpowersystemmodelCommand(
    @TargetAggregateIdentifier  val staticpowersystemmodelId: UUID? = null
)

data class DeleteStaticpowersystemmodelCommand(@TargetAggregateIdentifier  var staticpowersystemmodelId: UUID? = null)

// single association commands

// multiple association commands


// StationSupply Commands
data class CreateStationSupplyCommand(
    @TargetAggregateIdentifier  val stationSupplyId: UUID? = null
)

data class UpdateStationSupplyCommand(
    @TargetAggregateIdentifier  val stationSupplyId: UUID? = null
)

data class DeleteStationSupplyCommand(@TargetAggregateIdentifier  var stationSupplyId: UUID? = null)

// single association commands

// multiple association commands


// SteadyStateHypothesisVersion Commands
data class CreateSteadyStateHypothesisVersionCommand(
    @TargetAggregateIdentifier val steadyStateHypothesisVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class UpdateSteadyStateHypothesisVersionCommand(
    @TargetAggregateIdentifier val steadyStateHypothesisVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class DeleteSteadyStateHypothesisVersionCommand(@TargetAggregateIdentifier  var steadyStateHypothesisVersionId: UUID? = null)

// single association commands

// multiple association commands


// StringMeasurement Commands
data class CreateStringMeasurementCommand(
    @TargetAggregateIdentifier  val stringMeasurementId: UUID? = null
)

data class UpdateStringMeasurementCommand(
    @TargetAggregateIdentifier  val stringMeasurementId: UUID? = null
)

data class DeleteStringMeasurementCommand(@TargetAggregateIdentifier  var stringMeasurementId: UUID? = null)

// single association commands

// multiple association commands


// StringMeasurementValue Commands
data class CreateStringMeasurementValueCommand(
    @TargetAggregateIdentifier val stringMeasurementValueId: UUID? = null,
    val value: String
)

data class UpdateStringMeasurementValueCommand(
    @TargetAggregateIdentifier val stringMeasurementValueId: UUID? = null,
    val value: String
)

data class DeleteStringMeasurementValueCommand(@TargetAggregateIdentifier  var stringMeasurementValueId: UUID? = null)

// single association commands

// multiple association commands


// StringProxy Commands
data class CreateStringProxyCommand(
    @TargetAggregateIdentifier  val stringProxyId: UUID? = null
)

data class UpdateStringProxyCommand(
    @TargetAggregateIdentifier  val stringProxyId: UUID? = null
)

data class DeleteStringProxyCommand(@TargetAggregateIdentifier  var stringProxyId: UUID? = null)

// single association commands

// multiple association commands


// SubGeographicalRegion Commands
data class CreateSubGeographicalRegionCommand(
    @TargetAggregateIdentifier  val subGeographicalRegionId: UUID? = null
)

data class UpdateSubGeographicalRegionCommand(
    @TargetAggregateIdentifier  val subGeographicalRegionId: UUID? = null
)

data class DeleteSubGeographicalRegionCommand(@TargetAggregateIdentifier  var subGeographicalRegionId: UUID? = null)

// single association commands

// multiple association commands


// SubLoadArea Commands
data class CreateSubLoadAreaCommand(
    @TargetAggregateIdentifier  val subLoadAreaId: UUID? = null
)

data class UpdateSubLoadAreaCommand(
    @TargetAggregateIdentifier  val subLoadAreaId: UUID? = null
)

data class DeleteSubLoadAreaCommand(@TargetAggregateIdentifier  var subLoadAreaId: UUID? = null)

// single association commands

// multiple association commands


// Substation Commands
data class CreateSubstationCommand(
    @TargetAggregateIdentifier  val substationId: UUID? = null
)

data class UpdateSubstationCommand(
    @TargetAggregateIdentifier  val substationId: UUID? = null
)

data class DeleteSubstationCommand(@TargetAggregateIdentifier  var substationId: UUID? = null)

// single association commands

// multiple association commands


// Susceptance Commands
data class CreateSusceptanceCommand(
    @TargetAggregateIdentifier val susceptanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateSusceptanceCommand(
    @TargetAggregateIdentifier val susceptanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteSusceptanceCommand(@TargetAggregateIdentifier  var susceptanceId: UUID? = null)

// single association commands

// multiple association commands


// SvInjection Commands
data class CreateSvInjectionCommand(
    @TargetAggregateIdentifier val svInjectionId: UUID? = null,
    val pInjection: String,
    val qInjection: String
)

data class UpdateSvInjectionCommand(
    @TargetAggregateIdentifier val svInjectionId: UUID? = null,
    val pInjection: String,
    val qInjection: String
)

data class DeleteSvInjectionCommand(@TargetAggregateIdentifier  var svInjectionId: UUID? = null)

// single association commands

// multiple association commands


// SvPowerFlow Commands
data class CreateSvPowerFlowCommand(
    @TargetAggregateIdentifier val svPowerFlowId: UUID? = null,
    val p: String,
    val q: String
)

data class UpdateSvPowerFlowCommand(
    @TargetAggregateIdentifier val svPowerFlowId: UUID? = null,
    val p: String,
    val q: String
)

data class DeleteSvPowerFlowCommand(@TargetAggregateIdentifier  var svPowerFlowId: UUID? = null)

// single association commands

// multiple association commands


// SvShuntCompensatorSections Commands
data class CreateSvShuntCompensatorSectionsCommand(
    @TargetAggregateIdentifier val svShuntCompensatorSectionsId: UUID? = null,
    val sections: String
)

data class UpdateSvShuntCompensatorSectionsCommand(
    @TargetAggregateIdentifier val svShuntCompensatorSectionsId: UUID? = null,
    val sections: String
)

data class DeleteSvShuntCompensatorSectionsCommand(@TargetAggregateIdentifier  var svShuntCompensatorSectionsId: UUID? = null)

// single association commands

// multiple association commands


// SvStatus Commands
data class CreateSvStatusCommand(
    @TargetAggregateIdentifier val svStatusId: UUID? = null,
    val inService: String
)

data class UpdateSvStatusCommand(
    @TargetAggregateIdentifier val svStatusId: UUID? = null,
    val inService: String
)

data class DeleteSvStatusCommand(@TargetAggregateIdentifier  var svStatusId: UUID? = null)

// single association commands

// multiple association commands


// SvTapStep Commands
data class CreateSvTapStepCommand(
    @TargetAggregateIdentifier val svTapStepId: UUID? = null,
    val position: String
)

data class UpdateSvTapStepCommand(
    @TargetAggregateIdentifier val svTapStepId: UUID? = null,
    val position: String
)

data class DeleteSvTapStepCommand(@TargetAggregateIdentifier  var svTapStepId: UUID? = null)

// single association commands

// multiple association commands


// SvVoltage Commands
data class CreateSvVoltageCommand(
    @TargetAggregateIdentifier val svVoltageId: UUID? = null,
    val angle: String,
    val v: String
)

data class UpdateSvVoltageCommand(
    @TargetAggregateIdentifier val svVoltageId: UUID? = null,
    val angle: String,
    val v: String
)

data class DeleteSvVoltageCommand(@TargetAggregateIdentifier  var svVoltageId: UUID? = null)

// single association commands

// multiple association commands


// SwitchIt Commands
data class CreateSwitchItCommand(
    @TargetAggregateIdentifier val switchItId: UUID? = null,
    val open: String
)

data class UpdateSwitchItCommand(
    @TargetAggregateIdentifier val switchItId: UUID? = null,
    val open: String
)

data class DeleteSwitchItCommand(@TargetAggregateIdentifier  var switchItId: UUID? = null)

// single association commands

// multiple association commands


// SwitchProxy Commands
data class CreateSwitchProxyCommand(
    @TargetAggregateIdentifier val switchProxyId: UUID? = null,
    val normalOpen: String,
    val ratedCurrent: String,
    val retained: String
)

data class UpdateSwitchProxyCommand(
    @TargetAggregateIdentifier val switchProxyId: UUID? = null,
    val normalOpen: String,
    val ratedCurrent: String,
    val retained: String
)

data class DeleteSwitchProxyCommand(@TargetAggregateIdentifier  var switchProxyId: UUID? = null)

// single association commands

// multiple association commands


// SwitchSchedule Commands
data class CreateSwitchScheduleCommand(
    @TargetAggregateIdentifier  val switchScheduleId: UUID? = null
)

data class UpdateSwitchScheduleCommand(
    @TargetAggregateIdentifier  val switchScheduleId: UUID? = null
)

data class DeleteSwitchScheduleCommand(@TargetAggregateIdentifier  var switchScheduleId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachine Commands
data class CreateSynchronousMachineCommand(
    @TargetAggregateIdentifier val synchronousMachineId: UUID? = null,
    val earthing: String,
    val earthingStarPointR: String,
    val earthingStarPointX: String,
    val ikk: String,
    val maxQ: String,
    val minQ: String,
    val mu: String,
    val qPercent: String,
    val r: String,
    val r0: String,
    val r2: String,
    val satDirectSubtransX: String,
    val satDirectSyncX: String,
    val satDirectTransX: String,
    val shortCircuitRotorType: String,
    val type: String,
    val voltageRegulationRange: String,
    val x0: String,
    val x2: String
)

data class UpdateSynchronousMachineCommand(
    @TargetAggregateIdentifier val synchronousMachineId: UUID? = null,
    val earthing: String,
    val earthingStarPointR: String,
    val earthingStarPointX: String,
    val ikk: String,
    val maxQ: String,
    val minQ: String,
    val mu: String,
    val qPercent: String,
    val r: String,
    val r0: String,
    val r2: String,
    val satDirectSubtransX: String,
    val satDirectSyncX: String,
    val satDirectTransX: String,
    val shortCircuitRotorType: String,
    val type: String,
    val voltageRegulationRange: String,
    val x0: String,
    val x2: String
)

data class DeleteSynchronousMachineCommand(@TargetAggregateIdentifier  var synchronousMachineId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineDetailed Commands
data class CreateSynchronousMachineDetailedCommand(
    @TargetAggregateIdentifier val synchronousMachineDetailedId: UUID? = null,
    val efdBaseRatio: String,
    val ifdBaseType: String,
    val ifdBaseValue: String,
    val saturationFactor120QAxis: String,
    val saturationFactorQAxis: String
)

data class UpdateSynchronousMachineDetailedCommand(
    @TargetAggregateIdentifier val synchronousMachineDetailedId: UUID? = null,
    val efdBaseRatio: String,
    val ifdBaseType: String,
    val ifdBaseValue: String,
    val saturationFactor120QAxis: String,
    val saturationFactorQAxis: String
)

data class DeleteSynchronousMachineDetailedCommand(@TargetAggregateIdentifier  var synchronousMachineDetailedId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineDynamics Commands
data class CreateSynchronousMachineDynamicsCommand(
    @TargetAggregateIdentifier  val synchronousMachineDynamicsId: UUID? = null
)

data class UpdateSynchronousMachineDynamicsCommand(
    @TargetAggregateIdentifier  val synchronousMachineDynamicsId: UUID? = null
)

data class DeleteSynchronousMachineDynamicsCommand(@TargetAggregateIdentifier  var synchronousMachineDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineEquivalentCircuit Commands
data class CreateSynchronousMachineEquivalentCircuitCommand(
    @TargetAggregateIdentifier val synchronousMachineEquivalentCircuitId: UUID? = null,
    val r1d: String,
    val r1q: String,
    val r2q: String,
    val rfd: String,
    val x1d: String,
    val x1q: String,
    val x2q: String,
    val xad: String,
    val xaq: String,
    val xf1d: String,
    val xfd: String
)

data class UpdateSynchronousMachineEquivalentCircuitCommand(
    @TargetAggregateIdentifier val synchronousMachineEquivalentCircuitId: UUID? = null,
    val r1d: String,
    val r1q: String,
    val r2q: String,
    val rfd: String,
    val x1d: String,
    val x1q: String,
    val x2q: String,
    val xad: String,
    val xaq: String,
    val xf1d: String,
    val xfd: String
)

data class DeleteSynchronousMachineEquivalentCircuitCommand(@TargetAggregateIdentifier  var synchronousMachineEquivalentCircuitId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineSimplified Commands
data class CreateSynchronousMachineSimplifiedCommand(
    @TargetAggregateIdentifier  val synchronousMachineSimplifiedId: UUID? = null
)

data class UpdateSynchronousMachineSimplifiedCommand(
    @TargetAggregateIdentifier  val synchronousMachineSimplifiedId: UUID? = null
)

data class DeleteSynchronousMachineSimplifiedCommand(@TargetAggregateIdentifier  var synchronousMachineSimplifiedId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineTimeConstantReactance Commands
data class CreateSynchronousMachineTimeConstantReactanceCommand(
    @TargetAggregateIdentifier val synchronousMachineTimeConstantReactanceId: UUID? = null,
    val ks: String,
    val modelType: String,
    val rotorType: String,
    val tc: String,
    val tpdo: String,
    val tppdo: String,
    val tppqo: String,
    val tpqo: String,
    val xDirectSubtrans: String,
    val xDirectSync: String,
    val xDirectTrans: String,
    val xQuadSubtrans: String,
    val xQuadSync: String,
    val xQuadTrans: String
)

data class UpdateSynchronousMachineTimeConstantReactanceCommand(
    @TargetAggregateIdentifier val synchronousMachineTimeConstantReactanceId: UUID? = null,
    val ks: String,
    val modelType: String,
    val rotorType: String,
    val tc: String,
    val tpdo: String,
    val tppdo: String,
    val tppqo: String,
    val tpqo: String,
    val xDirectSubtrans: String,
    val xDirectSync: String,
    val xDirectTrans: String,
    val xQuadSubtrans: String,
    val xQuadSync: String,
    val xQuadTrans: String
)

data class DeleteSynchronousMachineTimeConstantReactanceCommand(@TargetAggregateIdentifier  var synchronousMachineTimeConstantReactanceId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineUserDefined Commands
data class CreateSynchronousMachineUserDefinedCommand(
    @TargetAggregateIdentifier val synchronousMachineUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateSynchronousMachineUserDefinedCommand(
    @TargetAggregateIdentifier val synchronousMachineUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteSynchronousMachineUserDefinedCommand(@TargetAggregateIdentifier  var synchronousMachineUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// TapChanger Commands
data class CreateTapChangerCommand(
    @TargetAggregateIdentifier val tapChangerId: UUID? = null,
    val highStep: String,
    val lowStep: String,
    val ltcFlag: String,
    val neutralStep: String,
    val neutralU: String,
    val normalStep: String
)

data class UpdateTapChangerCommand(
    @TargetAggregateIdentifier val tapChangerId: UUID? = null,
    val highStep: String,
    val lowStep: String,
    val ltcFlag: String,
    val neutralStep: String,
    val neutralU: String,
    val normalStep: String
)

data class DeleteTapChangerCommand(@TargetAggregateIdentifier  var tapChangerId: UUID? = null)

// single association commands

// multiple association commands


// TapChangerControl Commands
data class CreateTapChangerControlCommand(
    @TargetAggregateIdentifier  val tapChangerControlId: UUID? = null
)

data class UpdateTapChangerControlCommand(
    @TargetAggregateIdentifier  val tapChangerControlId: UUID? = null
)

data class DeleteTapChangerControlCommand(@TargetAggregateIdentifier  var tapChangerControlId: UUID? = null)

// single association commands

// multiple association commands


// TapChangerTablePoint Commands
data class CreateTapChangerTablePointCommand(
    @TargetAggregateIdentifier val tapChangerTablePointId: UUID? = null,
    val b: String,
    val g: String,
    val r: String,
    val ratio: String,
    val step: String,
    val x: String
)

data class UpdateTapChangerTablePointCommand(
    @TargetAggregateIdentifier val tapChangerTablePointId: UUID? = null,
    val b: String,
    val g: String,
    val r: String,
    val ratio: String,
    val step: String,
    val x: String
)

data class DeleteTapChangerTablePointCommand(@TargetAggregateIdentifier  var tapChangerTablePointId: UUID? = null)

// single association commands

// multiple association commands


// TapSchedule Commands
data class CreateTapScheduleCommand(
    @TargetAggregateIdentifier  val tapScheduleId: UUID? = null
)

data class UpdateTapScheduleCommand(
    @TargetAggregateIdentifier  val tapScheduleId: UUID? = null
)

data class DeleteTapScheduleCommand(@TargetAggregateIdentifier  var tapScheduleId: UUID? = null)

// single association commands

// multiple association commands


// Temperature Commands
data class CreateTemperatureCommand(
    @TargetAggregateIdentifier val temperatureId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateTemperatureCommand(
    @TargetAggregateIdentifier val temperatureId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteTemperatureCommand(@TargetAggregateIdentifier  var temperatureId: UUID? = null)

// single association commands

// multiple association commands


// Terminal Commands
data class CreateTerminalCommand(
    @TargetAggregateIdentifier  val terminalId: UUID? = null
)

data class UpdateTerminalCommand(
    @TargetAggregateIdentifier  val terminalId: UUID? = null
)

data class DeleteTerminalCommand(@TargetAggregateIdentifier  var terminalId: UUID? = null)

// single association commands

// multiple association commands


// TextDiagramObject Commands
data class CreateTextDiagramObjectCommand(
    @TargetAggregateIdentifier val textDiagramObjectId: UUID? = null,
    val text: String
)

data class UpdateTextDiagramObjectCommand(
    @TargetAggregateIdentifier val textDiagramObjectId: UUID? = null,
    val text: String
)

data class DeleteTextDiagramObjectCommand(@TargetAggregateIdentifier  var textDiagramObjectId: UUID? = null)

// single association commands

// multiple association commands


// ThermalGeneratingUnit Commands
data class CreateThermalGeneratingUnitCommand(
    @TargetAggregateIdentifier  val thermalGeneratingUnitId: UUID? = null
)

data class UpdateThermalGeneratingUnitCommand(
    @TargetAggregateIdentifier  val thermalGeneratingUnitId: UUID? = null
)

data class DeleteThermalGeneratingUnitCommand(@TargetAggregateIdentifier  var thermalGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// TieFlow Commands
data class CreateTieFlowCommand(
    @TargetAggregateIdentifier val tieFlowId: UUID? = null,
    val positiveFlowIn: String
)

data class UpdateTieFlowCommand(
    @TargetAggregateIdentifier val tieFlowId: UUID? = null,
    val positiveFlowIn: String
)

data class DeleteTieFlowCommand(@TargetAggregateIdentifier  var tieFlowId: UUID? = null)

// single association commands

// multiple association commands


// TopologicalIsland Commands
data class CreateTopologicalIslandCommand(
    @TargetAggregateIdentifier  val topologicalIslandId: UUID? = null
)

data class UpdateTopologicalIslandCommand(
    @TargetAggregateIdentifier  val topologicalIslandId: UUID? = null
)

data class DeleteTopologicalIslandCommand(@TargetAggregateIdentifier  var topologicalIslandId: UUID? = null)

// single association commands

// multiple association commands


// TopologicalNode Commands
data class CreateTopologicalNodeCommand(
    @TargetAggregateIdentifier val topologicalNodeId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class UpdateTopologicalNodeCommand(
    @TargetAggregateIdentifier val topologicalNodeId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class DeleteTopologicalNodeCommand(@TargetAggregateIdentifier  var topologicalNodeId: UUID? = null)

// single association commands

// multiple association commands


// TopologyBoundaryVersion Commands
data class CreateTopologyBoundaryVersionCommand(
    @TargetAggregateIdentifier val topologyBoundaryVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class UpdateTopologyBoundaryVersionCommand(
    @TargetAggregateIdentifier val topologyBoundaryVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class DeleteTopologyBoundaryVersionCommand(@TargetAggregateIdentifier  var topologyBoundaryVersionId: UUID? = null)

// single association commands

// multiple association commands


// TopologyVersion Commands
data class CreateTopologyVersionCommand(
    @TargetAggregateIdentifier val topologyVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class UpdateTopologyVersionCommand(
    @TargetAggregateIdentifier val topologyVersionId: UUID? = null,
    val baseUML: String,
    val baseURI: String,
    val date: String,
    val differenceModelURI: String,
    val entsoeUML: String,
    val entsoeURI: String,
    val modelDescriptionURI: String,
    val namespaceRDF: String,
    val namespaceUML: String,
    val shortName: String
)

data class DeleteTopologyVersionCommand(@TargetAggregateIdentifier  var topologyVersionId: UUID? = null)

// single association commands

// multiple association commands


// TransformerEnd Commands
data class CreateTransformerEndCommand(
    @TargetAggregateIdentifier val transformerEndId: UUID? = null,
    val endNumber: String,
    val grounded: String,
    val rground: String,
    val xground: String
)

data class UpdateTransformerEndCommand(
    @TargetAggregateIdentifier val transformerEndId: UUID? = null,
    val endNumber: String,
    val grounded: String,
    val rground: String,
    val xground: String
)

data class DeleteTransformerEndCommand(@TargetAggregateIdentifier  var transformerEndId: UUID? = null)

// single association commands

// multiple association commands


// TurbLCFB1 Commands
data class CreateTurbLCFB1Command(
    @TargetAggregateIdentifier val turbLCFB1Id: UUID? = null,
    val db: String,
    val emax: String,
    val fb: String,
    val fbf: String,
    val irmax: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val pbf: String,
    val pmwset: String,
    val speedReferenceGovernor: String,
    val tpelec: String
)

data class UpdateTurbLCFB1Command(
    @TargetAggregateIdentifier val turbLCFB1Id: UUID? = null,
    val db: String,
    val emax: String,
    val fb: String,
    val fbf: String,
    val irmax: String,
    val ki: String,
    val kp: String,
    val mwbase: String,
    val pbf: String,
    val pmwset: String,
    val speedReferenceGovernor: String,
    val tpelec: String
)

data class DeleteTurbLCFB1Command(@TargetAggregateIdentifier  var turbLCFB1Id: UUID? = null)

// single association commands

// multiple association commands


// TurbineGovernorDynamics Commands
data class CreateTurbineGovernorDynamicsCommand(
    @TargetAggregateIdentifier  val turbineGovernorDynamicsId: UUID? = null
)

data class UpdateTurbineGovernorDynamicsCommand(
    @TargetAggregateIdentifier  val turbineGovernorDynamicsId: UUID? = null
)

data class DeleteTurbineGovernorDynamicsCommand(@TargetAggregateIdentifier  var turbineGovernorDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// TurbineGovernorUserDefined Commands
data class CreateTurbineGovernorUserDefinedCommand(
    @TargetAggregateIdentifier val turbineGovernorUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateTurbineGovernorUserDefinedCommand(
    @TargetAggregateIdentifier val turbineGovernorUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteTurbineGovernorUserDefinedCommand(@TargetAggregateIdentifier  var turbineGovernorUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// TurbineLoadControllerDynamics Commands
data class CreateTurbineLoadControllerDynamicsCommand(
    @TargetAggregateIdentifier  val turbineLoadControllerDynamicsId: UUID? = null
)

data class UpdateTurbineLoadControllerDynamicsCommand(
    @TargetAggregateIdentifier  val turbineLoadControllerDynamicsId: UUID? = null
)

data class DeleteTurbineLoadControllerDynamicsCommand(@TargetAggregateIdentifier  var turbineLoadControllerDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// TurbineLoadControllerUserDefined Commands
data class CreateTurbineLoadControllerUserDefinedCommand(
    @TargetAggregateIdentifier val turbineLoadControllerUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateTurbineLoadControllerUserDefinedCommand(
    @TargetAggregateIdentifier val turbineLoadControllerUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteTurbineLoadControllerUserDefinedCommand(@TargetAggregateIdentifier  var turbineLoadControllerUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// UnderexcLim2Simplified Commands
data class CreateUnderexcLim2SimplifiedCommand(
    @TargetAggregateIdentifier val underexcLim2SimplifiedId: UUID? = null,
    val kui: String,
    val p0: String,
    val p1: String,
    val q0: String,
    val q1: String,
    val vuimax: String,
    val vuimin: String
)

data class UpdateUnderexcLim2SimplifiedCommand(
    @TargetAggregateIdentifier val underexcLim2SimplifiedId: UUID? = null,
    val kui: String,
    val p0: String,
    val p1: String,
    val q0: String,
    val q1: String,
    val vuimax: String,
    val vuimin: String
)

data class DeleteUnderexcLim2SimplifiedCommand(@TargetAggregateIdentifier  var underexcLim2SimplifiedId: UUID? = null)

// single association commands

// multiple association commands


// UnderexcLimIEEE1 Commands
data class CreateUnderexcLimIEEE1Command(
    @TargetAggregateIdentifier val underexcLimIEEE1Id: UUID? = null,
    val kuc: String,
    val kuf: String,
    val kui: String,
    val kul: String,
    val kur: String,
    val tu1: String,
    val tu2: String,
    val tu3: String,
    val tu4: String,
    val vucmax: String,
    val vuimax: String,
    val vuimin: String,
    val vulmax: String,
    val vulmin: String,
    val vurmax: String
)

data class UpdateUnderexcLimIEEE1Command(
    @TargetAggregateIdentifier val underexcLimIEEE1Id: UUID? = null,
    val kuc: String,
    val kuf: String,
    val kui: String,
    val kul: String,
    val kur: String,
    val tu1: String,
    val tu2: String,
    val tu3: String,
    val tu4: String,
    val vucmax: String,
    val vuimax: String,
    val vuimin: String,
    val vulmax: String,
    val vulmin: String,
    val vurmax: String
)

data class DeleteUnderexcLimIEEE1Command(@TargetAggregateIdentifier  var underexcLimIEEE1Id: UUID? = null)

// single association commands

// multiple association commands


// UnderexcLimIEEE2 Commands
data class CreateUnderexcLimIEEE2Command(
    @TargetAggregateIdentifier val underexcLimIEEE2Id: UUID? = null,
    val k1: String,
    val k2: String,
    val kfb: String,
    val kuf: String,
    val kui: String,
    val kul: String,
    val p0: String,
    val p1: String,
    val p10: String,
    val p2: String,
    val p3: String,
    val p4: String,
    val p5: String,
    val p6: String,
    val p7: String,
    val p8: String,
    val p9: String,
    val q0: String,
    val q1: String,
    val q10: String,
    val q2: String,
    val q3: String,
    val q4: String,
    val q5: String,
    val q6: String,
    val q7: String,
    val q8: String,
    val q9: String,
    val tu1: String,
    val tu2: String,
    val tu3: String,
    val tu4: String,
    val tul: String,
    val tup: String,
    val tuq: String,
    val tuv: String,
    val vuimax: String,
    val vuimin: String,
    val vulmax: String,
    val vulmin: String
)

data class UpdateUnderexcLimIEEE2Command(
    @TargetAggregateIdentifier val underexcLimIEEE2Id: UUID? = null,
    val k1: String,
    val k2: String,
    val kfb: String,
    val kuf: String,
    val kui: String,
    val kul: String,
    val p0: String,
    val p1: String,
    val p10: String,
    val p2: String,
    val p3: String,
    val p4: String,
    val p5: String,
    val p6: String,
    val p7: String,
    val p8: String,
    val p9: String,
    val q0: String,
    val q1: String,
    val q10: String,
    val q2: String,
    val q3: String,
    val q4: String,
    val q5: String,
    val q6: String,
    val q7: String,
    val q8: String,
    val q9: String,
    val tu1: String,
    val tu2: String,
    val tu3: String,
    val tu4: String,
    val tul: String,
    val tup: String,
    val tuq: String,
    val tuv: String,
    val vuimax: String,
    val vuimin: String,
    val vulmax: String,
    val vulmin: String
)

data class DeleteUnderexcLimIEEE2Command(@TargetAggregateIdentifier  var underexcLimIEEE2Id: UUID? = null)

// single association commands

// multiple association commands


// UnderexcLimX1 Commands
data class CreateUnderexcLimX1Command(
    @TargetAggregateIdentifier val underexcLimX1Id: UUID? = null,
    val k: String,
    val kf2: String,
    val km: String,
    val melmax: String,
    val tf2: String,
    val tm: String
)

data class UpdateUnderexcLimX1Command(
    @TargetAggregateIdentifier val underexcLimX1Id: UUID? = null,
    val k: String,
    val kf2: String,
    val km: String,
    val melmax: String,
    val tf2: String,
    val tm: String
)

data class DeleteUnderexcLimX1Command(@TargetAggregateIdentifier  var underexcLimX1Id: UUID? = null)

// single association commands

// multiple association commands


// UnderexcLimX2 Commands
data class CreateUnderexcLimX2Command(
    @TargetAggregateIdentifier val underexcLimX2Id: UUID? = null,
    val kf2: String,
    val km: String,
    val melmax: String,
    val qo: String,
    val r: String,
    val tf2: String,
    val tm: String
)

data class UpdateUnderexcLimX2Command(
    @TargetAggregateIdentifier val underexcLimX2Id: UUID? = null,
    val kf2: String,
    val km: String,
    val melmax: String,
    val qo: String,
    val r: String,
    val tf2: String,
    val tm: String
)

data class DeleteUnderexcLimX2Command(@TargetAggregateIdentifier  var underexcLimX2Id: UUID? = null)

// single association commands

// multiple association commands


// UnderexcitationLimiterDynamics Commands
data class CreateUnderexcitationLimiterDynamicsCommand(
    @TargetAggregateIdentifier  val underexcitationLimiterDynamicsId: UUID? = null
)

data class UpdateUnderexcitationLimiterDynamicsCommand(
    @TargetAggregateIdentifier  val underexcitationLimiterDynamicsId: UUID? = null
)

data class DeleteUnderexcitationLimiterDynamicsCommand(@TargetAggregateIdentifier  var underexcitationLimiterDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// UnderexcitationLimiterUserDefined Commands
data class CreateUnderexcitationLimiterUserDefinedCommand(
    @TargetAggregateIdentifier val underexcitationLimiterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateUnderexcitationLimiterUserDefinedCommand(
    @TargetAggregateIdentifier val underexcitationLimiterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteUnderexcitationLimiterUserDefinedCommand(@TargetAggregateIdentifier  var underexcitationLimiterUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// Unresolvedname Commands
data class CreateUnresolvednameCommand(
    @TargetAggregateIdentifier  val unresolvednameId: UUID? = null
)

data class UpdateUnresolvednameCommand(
    @TargetAggregateIdentifier  val unresolvednameId: UUID? = null
)

data class DeleteUnresolvednameCommand(@TargetAggregateIdentifier  var unresolvednameId: UUID? = null)

// single association commands

// multiple association commands


// VAdjIEEE Commands
data class CreateVAdjIEEECommand(
    @TargetAggregateIdentifier val vAdjIEEEId: UUID? = null,
    val adjslew: String,
    val taoff: String,
    val taon: String,
    val vadjf: String,
    val vadjmax: String,
    val vadjmin: String
)

data class UpdateVAdjIEEECommand(
    @TargetAggregateIdentifier val vAdjIEEEId: UUID? = null,
    val adjslew: String,
    val taoff: String,
    val taon: String,
    val vadjf: String,
    val vadjmax: String,
    val vadjmin: String
)

data class DeleteVAdjIEEECommand(@TargetAggregateIdentifier  var vAdjIEEEId: UUID? = null)

// single association commands

// multiple association commands


// VCompIEEEType1 Commands
data class CreateVCompIEEEType1Command(
    @TargetAggregateIdentifier val vCompIEEEType1Id: UUID? = null,
    val rc: String,
    val tr: String,
    val xc: String
)

data class UpdateVCompIEEEType1Command(
    @TargetAggregateIdentifier val vCompIEEEType1Id: UUID? = null,
    val rc: String,
    val tr: String,
    val xc: String
)

data class DeleteVCompIEEEType1Command(@TargetAggregateIdentifier  var vCompIEEEType1Id: UUID? = null)

// single association commands

// multiple association commands


// VCompIEEEType2 Commands
data class CreateVCompIEEEType2Command(
    @TargetAggregateIdentifier val vCompIEEEType2Id: UUID? = null,
    val tr: String
)

data class UpdateVCompIEEEType2Command(
    @TargetAggregateIdentifier val vCompIEEEType2Id: UUID? = null,
    val tr: String
)

data class DeleteVCompIEEEType2Command(@TargetAggregateIdentifier  var vCompIEEEType2Id: UUID? = null)

// single association commands

// multiple association commands


// ValueAliasSet Commands
data class CreateValueAliasSetCommand(
    @TargetAggregateIdentifier  val valueAliasSetId: UUID? = null
)

data class UpdateValueAliasSetCommand(
    @TargetAggregateIdentifier  val valueAliasSetId: UUID? = null
)

data class DeleteValueAliasSetCommand(@TargetAggregateIdentifier  var valueAliasSetId: UUID? = null)

// single association commands

// multiple association commands


// ValueToAlias Commands
data class CreateValueToAliasCommand(
    @TargetAggregateIdentifier val valueToAliasId: UUID? = null,
    val value: String
)

data class UpdateValueToAliasCommand(
    @TargetAggregateIdentifier val valueToAliasId: UUID? = null,
    val value: String
)

data class DeleteValueToAliasCommand(@TargetAggregateIdentifier  var valueToAliasId: UUID? = null)

// single association commands

// multiple association commands


// VisibilityLayer Commands
data class CreateVisibilityLayerCommand(
    @TargetAggregateIdentifier val visibilityLayerId: UUID? = null,
    val drawingOrder: String
)

data class UpdateVisibilityLayerCommand(
    @TargetAggregateIdentifier val visibilityLayerId: UUID? = null,
    val drawingOrder: String
)

data class DeleteVisibilityLayerCommand(@TargetAggregateIdentifier  var visibilityLayerId: UUID? = null)

// single association commands

// multiple association commands


// Voltage Commands
data class CreateVoltageCommand(
    @TargetAggregateIdentifier val voltageId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateVoltageCommand(
    @TargetAggregateIdentifier val voltageId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteVoltageCommand(@TargetAggregateIdentifier  var voltageId: UUID? = null)

// single association commands

// multiple association commands


// VoltageAdjusterDynamics Commands
data class CreateVoltageAdjusterDynamicsCommand(
    @TargetAggregateIdentifier  val voltageAdjusterDynamicsId: UUID? = null
)

data class UpdateVoltageAdjusterDynamicsCommand(
    @TargetAggregateIdentifier  val voltageAdjusterDynamicsId: UUID? = null
)

data class DeleteVoltageAdjusterDynamicsCommand(@TargetAggregateIdentifier  var voltageAdjusterDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// VoltageAdjusterUserDefined Commands
data class CreateVoltageAdjusterUserDefinedCommand(
    @TargetAggregateIdentifier val voltageAdjusterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateVoltageAdjusterUserDefinedCommand(
    @TargetAggregateIdentifier val voltageAdjusterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteVoltageAdjusterUserDefinedCommand(@TargetAggregateIdentifier  var voltageAdjusterUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// VoltageCompensatorDynamics Commands
data class CreateVoltageCompensatorDynamicsCommand(
    @TargetAggregateIdentifier  val voltageCompensatorDynamicsId: UUID? = null
)

data class UpdateVoltageCompensatorDynamicsCommand(
    @TargetAggregateIdentifier  val voltageCompensatorDynamicsId: UUID? = null
)

data class DeleteVoltageCompensatorDynamicsCommand(@TargetAggregateIdentifier  var voltageCompensatorDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// VoltageCompensatorUserDefined Commands
data class CreateVoltageCompensatorUserDefinedCommand(
    @TargetAggregateIdentifier val voltageCompensatorUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateVoltageCompensatorUserDefinedCommand(
    @TargetAggregateIdentifier val voltageCompensatorUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteVoltageCompensatorUserDefinedCommand(@TargetAggregateIdentifier  var voltageCompensatorUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// VoltageLevel Commands
data class CreateVoltageLevelCommand(
    @TargetAggregateIdentifier val voltageLevelId: UUID? = null,
    val highVoltageLimit: String,
    val lowVoltageLimit: String
)

data class UpdateVoltageLevelCommand(
    @TargetAggregateIdentifier val voltageLevelId: UUID? = null,
    val highVoltageLimit: String,
    val lowVoltageLimit: String
)

data class DeleteVoltageLevelCommand(@TargetAggregateIdentifier  var voltageLevelId: UUID? = null)

// single association commands

// multiple association commands


// VoltageLimit Commands
data class CreateVoltageLimitCommand(
    @TargetAggregateIdentifier val voltageLimitId: UUID? = null,
    val value: String
)

data class UpdateVoltageLimitCommand(
    @TargetAggregateIdentifier val voltageLimitId: UUID? = null,
    val value: String
)

data class DeleteVoltageLimitCommand(@TargetAggregateIdentifier  var voltageLimitId: UUID? = null)

// single association commands

// multiple association commands


// VoltagePerReactivePower Commands
data class CreateVoltagePerReactivePowerCommand(
    @TargetAggregateIdentifier val voltagePerReactivePowerId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateVoltagePerReactivePowerCommand(
    @TargetAggregateIdentifier val voltagePerReactivePowerId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteVoltagePerReactivePowerCommand(@TargetAggregateIdentifier  var voltagePerReactivePowerId: UUID? = null)

// single association commands

// multiple association commands


// VolumeFlowRate Commands
data class CreateVolumeFlowRateCommand(
    @TargetAggregateIdentifier val volumeFlowRateId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateVolumeFlowRateCommand(
    @TargetAggregateIdentifier val volumeFlowRateId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteVolumeFlowRateCommand(@TargetAggregateIdentifier  var volumeFlowRateId: UUID? = null)

// single association commands

// multiple association commands


// VsCapabilityCurve Commands
data class CreateVsCapabilityCurveCommand(
    @TargetAggregateIdentifier  val vsCapabilityCurveId: UUID? = null
)

data class UpdateVsCapabilityCurveCommand(
    @TargetAggregateIdentifier  val vsCapabilityCurveId: UUID? = null
)

data class DeleteVsCapabilityCurveCommand(@TargetAggregateIdentifier  var vsCapabilityCurveId: UUID? = null)

// single association commands

// multiple association commands


// VsConverter Commands
data class CreateVsConverterCommand(
    @TargetAggregateIdentifier val vsConverterId: UUID? = null,
    val maxModulationIndex: String,
    val maxValveCurrent: String
)

data class UpdateVsConverterCommand(
    @TargetAggregateIdentifier val vsConverterId: UUID? = null,
    val maxModulationIndex: String,
    val maxValveCurrent: String
)

data class DeleteVsConverterCommand(@TargetAggregateIdentifier  var vsConverterId: UUID? = null)

// single association commands

// multiple association commands


// WindAeroConstIEC Commands
data class CreateWindAeroConstIECCommand(
    @TargetAggregateIdentifier  val windAeroConstIECId: UUID? = null
)

data class UpdateWindAeroConstIECCommand(
    @TargetAggregateIdentifier  val windAeroConstIECId: UUID? = null
)

data class DeleteWindAeroConstIECCommand(@TargetAggregateIdentifier  var windAeroConstIECId: UUID? = null)

// single association commands

// multiple association commands


// WindAeroLinearIEC Commands
data class CreateWindAeroLinearIECCommand(
    @TargetAggregateIdentifier val windAeroLinearIECId: UUID? = null,
    val dpomega: String,
    val dptheta: String,
    val omegazero: String,
    val pavail: String,
    val thetazero: String
)

data class UpdateWindAeroLinearIECCommand(
    @TargetAggregateIdentifier val windAeroLinearIECId: UUID? = null,
    val dpomega: String,
    val dptheta: String,
    val omegazero: String,
    val pavail: String,
    val thetazero: String
)

data class DeleteWindAeroLinearIECCommand(@TargetAggregateIdentifier  var windAeroLinearIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContCurrLimIEC Commands
data class CreateWindContCurrLimIECCommand(
    @TargetAggregateIdentifier val windContCurrLimIECId: UUID? = null,
    val imax: String,
    val imaxdip: String,
    val mdfslim: String,
    val mqpri: String,
    val tufilt: String
)

data class UpdateWindContCurrLimIECCommand(
    @TargetAggregateIdentifier val windContCurrLimIECId: UUID? = null,
    val imax: String,
    val imaxdip: String,
    val mdfslim: String,
    val mqpri: String,
    val tufilt: String
)

data class DeleteWindContCurrLimIECCommand(@TargetAggregateIdentifier  var windContCurrLimIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContPType3IEC Commands
data class CreateWindContPType3IECCommand(
    @TargetAggregateIdentifier val windContPType3IECId: UUID? = null,
    val dpmax: String,
    val dtrisemaxlvrt: String,
    val kdtd: String,
    val kip: String,
    val kpp: String,
    val mplvrt: String,
    val omegaoffset: String,
    val pdtdmax: String,
    val rramp: String,
    val tdvs: String,
    val temin: String,
    val tomegafilt: String,
    val tpfilt: String,
    val tpord: String,
    val tufilt: String,
    val tuscale: String,
    val twref: String,
    val udvs: String,
    val updip: String,
    val wdtd: String,
    val zeta: String
)

data class UpdateWindContPType3IECCommand(
    @TargetAggregateIdentifier val windContPType3IECId: UUID? = null,
    val dpmax: String,
    val dtrisemaxlvrt: String,
    val kdtd: String,
    val kip: String,
    val kpp: String,
    val mplvrt: String,
    val omegaoffset: String,
    val pdtdmax: String,
    val rramp: String,
    val tdvs: String,
    val temin: String,
    val tomegafilt: String,
    val tpfilt: String,
    val tpord: String,
    val tufilt: String,
    val tuscale: String,
    val twref: String,
    val udvs: String,
    val updip: String,
    val wdtd: String,
    val zeta: String
)

data class DeleteWindContPType3IECCommand(@TargetAggregateIdentifier  var windContPType3IECId: UUID? = null)

// single association commands

// multiple association commands


// WindContPType4aIEC Commands
data class CreateWindContPType4aIECCommand(
    @TargetAggregateIdentifier val windContPType4aIECId: UUID? = null,
    val dpmax: String,
    val tpord: String,
    val tufilt: String
)

data class UpdateWindContPType4aIECCommand(
    @TargetAggregateIdentifier val windContPType4aIECId: UUID? = null,
    val dpmax: String,
    val tpord: String,
    val tufilt: String
)

data class DeleteWindContPType4aIECCommand(@TargetAggregateIdentifier  var windContPType4aIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContPType4bIEC Commands
data class CreateWindContPType4bIECCommand(
    @TargetAggregateIdentifier val windContPType4bIECId: UUID? = null,
    val dpmax: String,
    val tpaero: String,
    val tpord: String,
    val tufilt: String
)

data class UpdateWindContPType4bIECCommand(
    @TargetAggregateIdentifier val windContPType4bIECId: UUID? = null,
    val dpmax: String,
    val tpaero: String,
    val tpord: String,
    val tufilt: String
)

data class DeleteWindContPType4bIECCommand(@TargetAggregateIdentifier  var windContPType4bIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContPitchAngleIEC Commands
data class CreateWindContPitchAngleIECCommand(
    @TargetAggregateIdentifier val windContPitchAngleIECId: UUID? = null,
    val dthetamax: String,
    val dthetamin: String,
    val kic: String,
    val kiomega: String,
    val kpc: String,
    val kpomega: String,
    val kpx: String,
    val thetamax: String,
    val thetamin: String,
    val ttheta: String
)

data class UpdateWindContPitchAngleIECCommand(
    @TargetAggregateIdentifier val windContPitchAngleIECId: UUID? = null,
    val dthetamax: String,
    val dthetamin: String,
    val kic: String,
    val kiomega: String,
    val kpc: String,
    val kpomega: String,
    val kpx: String,
    val thetamax: String,
    val thetamin: String,
    val ttheta: String
)

data class DeleteWindContPitchAngleIECCommand(@TargetAggregateIdentifier  var windContPitchAngleIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContQIEC Commands
data class CreateWindContQIECCommand(
    @TargetAggregateIdentifier val windContQIECId: UUID? = null,
    val iqh1: String,
    val iqmax: String,
    val iqmin: String,
    val iqpost: String,
    val kiq: String,
    val kiu: String,
    val kpq: String,
    val kpu: String,
    val kqv: String,
    val qmax: String,
    val qmin: String,
    val rdroop: String,
    val tiq: String,
    val tpfilt: String,
    val tpost: String,
    val tqord: String,
    val tufilt: String,
    val udb1: String,
    val udb2: String,
    val umax: String,
    val umin: String,
    val uqdip: String,
    val uref0: String,
    val windLVRTQcontrolModesType: String,
    val windQcontrolModesType: String,
    val xdroop: String
)

data class UpdateWindContQIECCommand(
    @TargetAggregateIdentifier val windContQIECId: UUID? = null,
    val iqh1: String,
    val iqmax: String,
    val iqmin: String,
    val iqpost: String,
    val kiq: String,
    val kiu: String,
    val kpq: String,
    val kpu: String,
    val kqv: String,
    val qmax: String,
    val qmin: String,
    val rdroop: String,
    val tiq: String,
    val tpfilt: String,
    val tpost: String,
    val tqord: String,
    val tufilt: String,
    val udb1: String,
    val udb2: String,
    val umax: String,
    val umin: String,
    val uqdip: String,
    val uref0: String,
    val windLVRTQcontrolModesType: String,
    val windQcontrolModesType: String,
    val xdroop: String
)

data class DeleteWindContQIECCommand(@TargetAggregateIdentifier  var windContQIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContRotorRIEC Commands
data class CreateWindContRotorRIECCommand(
    @TargetAggregateIdentifier val windContRotorRIECId: UUID? = null,
    val kirr: String,
    val komegafilt: String,
    val kpfilt: String,
    val kprr: String,
    val rmax: String,
    val rmin: String,
    val tomegafilt: String,
    val tpfilt: String
)

data class UpdateWindContRotorRIECCommand(
    @TargetAggregateIdentifier val windContRotorRIECId: UUID? = null,
    val kirr: String,
    val komegafilt: String,
    val kpfilt: String,
    val kprr: String,
    val rmax: String,
    val rmin: String,
    val tomegafilt: String,
    val tpfilt: String
)

data class DeleteWindContRotorRIECCommand(@TargetAggregateIdentifier  var windContRotorRIECId: UUID? = null)

// single association commands

// multiple association commands


// WindDynamicsLookupTable Commands
data class CreateWindDynamicsLookupTableCommand(
    @TargetAggregateIdentifier val windDynamicsLookupTableId: UUID? = null,
    val input: String,
    val lookupTableFunctionType: String,
    val output: String,
    val sequence: String
)

data class UpdateWindDynamicsLookupTableCommand(
    @TargetAggregateIdentifier val windDynamicsLookupTableId: UUID? = null,
    val input: String,
    val lookupTableFunctionType: String,
    val output: String,
    val sequence: String
)

data class DeleteWindDynamicsLookupTableCommand(@TargetAggregateIdentifier  var windDynamicsLookupTableId: UUID? = null)

// single association commands

// multiple association commands


// WindGenTurbineType1IEC Commands
data class CreateWindGenTurbineType1IECCommand(
    @TargetAggregateIdentifier  val windGenTurbineType1IECId: UUID? = null
)

data class UpdateWindGenTurbineType1IECCommand(
    @TargetAggregateIdentifier  val windGenTurbineType1IECId: UUID? = null
)

data class DeleteWindGenTurbineType1IECCommand(@TargetAggregateIdentifier  var windGenTurbineType1IECId: UUID? = null)

// single association commands

// multiple association commands


// WindGenTurbineType2IEC Commands
data class CreateWindGenTurbineType2IECCommand(
    @TargetAggregateIdentifier  val windGenTurbineType2IECId: UUID? = null
)

data class UpdateWindGenTurbineType2IECCommand(
    @TargetAggregateIdentifier  val windGenTurbineType2IECId: UUID? = null
)

data class DeleteWindGenTurbineType2IECCommand(@TargetAggregateIdentifier  var windGenTurbineType2IECId: UUID? = null)

// single association commands

// multiple association commands


// WindGenTurbineType3IEC Commands
data class CreateWindGenTurbineType3IECCommand(
    @TargetAggregateIdentifier val windGenTurbineType3IECId: UUID? = null,
    val dipmax: String,
    val diqmax: String
)

data class UpdateWindGenTurbineType3IECCommand(
    @TargetAggregateIdentifier val windGenTurbineType3IECId: UUID? = null,
    val dipmax: String,
    val diqmax: String
)

data class DeleteWindGenTurbineType3IECCommand(@TargetAggregateIdentifier  var windGenTurbineType3IECId: UUID? = null)

// single association commands

// multiple association commands


// WindGenTurbineType3aIEC Commands
data class CreateWindGenTurbineType3aIECCommand(
    @TargetAggregateIdentifier val windGenTurbineType3aIECId: UUID? = null,
    val kpc: String,
    val tic: String,
    val xs: String
)

data class UpdateWindGenTurbineType3aIECCommand(
    @TargetAggregateIdentifier val windGenTurbineType3aIECId: UUID? = null,
    val kpc: String,
    val tic: String,
    val xs: String
)

data class DeleteWindGenTurbineType3aIECCommand(@TargetAggregateIdentifier  var windGenTurbineType3aIECId: UUID? = null)

// single association commands

// multiple association commands


// WindGenTurbineType3bIEC Commands
data class CreateWindGenTurbineType3bIECCommand(
    @TargetAggregateIdentifier val windGenTurbineType3bIECId: UUID? = null,
    val fducw: String,
    val mwtcwp: String,
    val tg: String,
    val two: String,
    val xs: String
)

data class UpdateWindGenTurbineType3bIECCommand(
    @TargetAggregateIdentifier val windGenTurbineType3bIECId: UUID? = null,
    val fducw: String,
    val mwtcwp: String,
    val tg: String,
    val two: String,
    val xs: String
)

data class DeleteWindGenTurbineType3bIECCommand(@TargetAggregateIdentifier  var windGenTurbineType3bIECId: UUID? = null)

// single association commands

// multiple association commands


// WindGenType4IEC Commands
data class CreateWindGenType4IECCommand(
    @TargetAggregateIdentifier val windGenType4IECId: UUID? = null,
    val dipmax: String,
    val diqmax: String,
    val diqmin: String,
    val tg: String
)

data class UpdateWindGenType4IECCommand(
    @TargetAggregateIdentifier val windGenType4IECId: UUID? = null,
    val dipmax: String,
    val diqmax: String,
    val diqmin: String,
    val tg: String
)

data class DeleteWindGenType4IECCommand(@TargetAggregateIdentifier  var windGenType4IECId: UUID? = null)

// single association commands

// multiple association commands


// WindGeneratingUnit Commands
data class CreateWindGeneratingUnitCommand(
    @TargetAggregateIdentifier val windGeneratingUnitId: UUID? = null,
    val windGenUnitType: String
)

data class UpdateWindGeneratingUnitCommand(
    @TargetAggregateIdentifier val windGeneratingUnitId: UUID? = null,
    val windGenUnitType: String
)

data class DeleteWindGeneratingUnitCommand(@TargetAggregateIdentifier  var windGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// WindMechIEC Commands
data class CreateWindMechIECCommand(
    @TargetAggregateIdentifier val windMechIECId: UUID? = null,
    val cdrt: String,
    val hgen: String,
    val hwtr: String,
    val kdrt: String
)

data class UpdateWindMechIECCommand(
    @TargetAggregateIdentifier val windMechIECId: UUID? = null,
    val cdrt: String,
    val hgen: String,
    val hwtr: String,
    val kdrt: String
)

data class DeleteWindMechIECCommand(@TargetAggregateIdentifier  var windMechIECId: UUID? = null)

// single association commands

// multiple association commands


// WindPitchContEmulIEC Commands
data class CreateWindPitchContEmulIECCommand(
    @TargetAggregateIdentifier val windPitchContEmulIECId: UUID? = null,
    val kdroop: String,
    val kipce: String,
    val komegaaero: String,
    val kppce: String,
    val omegaref: String,
    val pimax: String,
    val pimin: String,
    val t1: String,
    val t2: String,
    val tpe: String
)

data class UpdateWindPitchContEmulIECCommand(
    @TargetAggregateIdentifier val windPitchContEmulIECId: UUID? = null,
    val kdroop: String,
    val kipce: String,
    val komegaaero: String,
    val kppce: String,
    val omegaref: String,
    val pimax: String,
    val pimin: String,
    val t1: String,
    val t2: String,
    val tpe: String
)

data class DeleteWindPitchContEmulIECCommand(@TargetAggregateIdentifier  var windPitchContEmulIECId: UUID? = null)

// single association commands

// multiple association commands


// WindPlantDynamics Commands
data class CreateWindPlantDynamicsCommand(
    @TargetAggregateIdentifier  val windPlantDynamicsId: UUID? = null
)

data class UpdateWindPlantDynamicsCommand(
    @TargetAggregateIdentifier  val windPlantDynamicsId: UUID? = null
)

data class DeleteWindPlantDynamicsCommand(@TargetAggregateIdentifier  var windPlantDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// WindPlantFreqPcontrolIEC Commands
data class CreateWindPlantFreqPcontrolIECCommand(
    @TargetAggregateIdentifier val windPlantFreqPcontrolIECId: UUID? = null,
    val dprefmax: String,
    val dprefmin: String,
    val kiwpp: String,
    val kpwpp: String,
    val prefmax: String,
    val prefmin: String,
    val tpft: String,
    val tpfv: String,
    val twpffilt: String,
    val twppfilt: String
)

data class UpdateWindPlantFreqPcontrolIECCommand(
    @TargetAggregateIdentifier val windPlantFreqPcontrolIECId: UUID? = null,
    val dprefmax: String,
    val dprefmin: String,
    val kiwpp: String,
    val kpwpp: String,
    val prefmax: String,
    val prefmin: String,
    val tpft: String,
    val tpfv: String,
    val twpffilt: String,
    val twppfilt: String
)

data class DeleteWindPlantFreqPcontrolIECCommand(@TargetAggregateIdentifier  var windPlantFreqPcontrolIECId: UUID? = null)

// single association commands

// multiple association commands


// WindPlantIEC Commands
data class CreateWindPlantIECCommand(
    @TargetAggregateIdentifier  val windPlantIECId: UUID? = null
)

data class UpdateWindPlantIECCommand(
    @TargetAggregateIdentifier  val windPlantIECId: UUID? = null
)

data class DeleteWindPlantIECCommand(@TargetAggregateIdentifier  var windPlantIECId: UUID? = null)

// single association commands

// multiple association commands


// WindPlantReactiveControlIEC Commands
data class CreateWindPlantReactiveControlIECCommand(
    @TargetAggregateIdentifier val windPlantReactiveControlIECId: UUID? = null,
    val kiwpx: String,
    val kpwpx: String,
    val kwpqu: String,
    val mwppf: String,
    val mwpu: String,
    val twppfilt: String,
    val twpqfilt: String,
    val twpufilt: String,
    val txft: String,
    val txfv: String,
    val uwpqdip: String,
    val xrefmax: String,
    val xrefmin: String
)

data class UpdateWindPlantReactiveControlIECCommand(
    @TargetAggregateIdentifier val windPlantReactiveControlIECId: UUID? = null,
    val kiwpx: String,
    val kpwpx: String,
    val kwpqu: String,
    val mwppf: String,
    val mwpu: String,
    val twppfilt: String,
    val twpqfilt: String,
    val twpufilt: String,
    val txft: String,
    val txfv: String,
    val uwpqdip: String,
    val xrefmax: String,
    val xrefmin: String
)

data class DeleteWindPlantReactiveControlIECCommand(@TargetAggregateIdentifier  var windPlantReactiveControlIECId: UUID? = null)

// single association commands

// multiple association commands


// WindPlantUserDefined Commands
data class CreateWindPlantUserDefinedCommand(
    @TargetAggregateIdentifier val windPlantUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateWindPlantUserDefinedCommand(
    @TargetAggregateIdentifier val windPlantUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteWindPlantUserDefinedCommand(@TargetAggregateIdentifier  var windPlantUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// WindProtectionIEC Commands
data class CreateWindProtectionIECCommand(
    @TargetAggregateIdentifier val windProtectionIECId: UUID? = null,
    val fover: String,
    val funder: String,
    val tfover: String,
    val tfunder: String,
    val tuover: String,
    val tuunder: String,
    val uover: String,
    val uunder: String
)

data class UpdateWindProtectionIECCommand(
    @TargetAggregateIdentifier val windProtectionIECId: UUID? = null,
    val fover: String,
    val funder: String,
    val tfover: String,
    val tfunder: String,
    val tuover: String,
    val tuunder: String,
    val uover: String,
    val uunder: String
)

data class DeleteWindProtectionIECCommand(@TargetAggregateIdentifier  var windProtectionIECId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType1or2Dynamics Commands
data class CreateWindTurbineType1or2DynamicsCommand(
    @TargetAggregateIdentifier  val windTurbineType1or2DynamicsId: UUID? = null
)

data class UpdateWindTurbineType1or2DynamicsCommand(
    @TargetAggregateIdentifier  val windTurbineType1or2DynamicsId: UUID? = null
)

data class DeleteWindTurbineType1or2DynamicsCommand(@TargetAggregateIdentifier  var windTurbineType1or2DynamicsId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType1or2IEC Commands
data class CreateWindTurbineType1or2IECCommand(
    @TargetAggregateIdentifier  val windTurbineType1or2IECId: UUID? = null
)

data class UpdateWindTurbineType1or2IECCommand(
    @TargetAggregateIdentifier  val windTurbineType1or2IECId: UUID? = null
)

data class DeleteWindTurbineType1or2IECCommand(@TargetAggregateIdentifier  var windTurbineType1or2IECId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType3or4Dynamics Commands
data class CreateWindTurbineType3or4DynamicsCommand(
    @TargetAggregateIdentifier  val windTurbineType3or4DynamicsId: UUID? = null
)

data class UpdateWindTurbineType3or4DynamicsCommand(
    @TargetAggregateIdentifier  val windTurbineType3or4DynamicsId: UUID? = null
)

data class DeleteWindTurbineType3or4DynamicsCommand(@TargetAggregateIdentifier  var windTurbineType3or4DynamicsId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType3or4IEC Commands
data class CreateWindTurbineType3or4IECCommand(
    @TargetAggregateIdentifier  val windTurbineType3or4IECId: UUID? = null
)

data class UpdateWindTurbineType3or4IECCommand(
    @TargetAggregateIdentifier  val windTurbineType3or4IECId: UUID? = null
)

data class DeleteWindTurbineType3or4IECCommand(@TargetAggregateIdentifier  var windTurbineType3or4IECId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType4aIEC Commands
data class CreateWindTurbineType4aIECCommand(
    @TargetAggregateIdentifier  val windTurbineType4aIECId: UUID? = null
)

data class UpdateWindTurbineType4aIECCommand(
    @TargetAggregateIdentifier  val windTurbineType4aIECId: UUID? = null
)

data class DeleteWindTurbineType4aIECCommand(@TargetAggregateIdentifier  var windTurbineType4aIECId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType4bIEC Commands
data class CreateWindTurbineType4bIECCommand(
    @TargetAggregateIdentifier  val windTurbineType4bIECId: UUID? = null
)

data class UpdateWindTurbineType4bIECCommand(
    @TargetAggregateIdentifier  val windTurbineType4bIECId: UUID? = null
)

data class DeleteWindTurbineType4bIECCommand(@TargetAggregateIdentifier  var windTurbineType4bIECId: UUID? = null)

// single association commands

// multiple association commands


// WindType1or2UserDefined Commands
data class CreateWindType1or2UserDefinedCommand(
    @TargetAggregateIdentifier val windType1or2UserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateWindType1or2UserDefinedCommand(
    @TargetAggregateIdentifier val windType1or2UserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteWindType1or2UserDefinedCommand(@TargetAggregateIdentifier  var windType1or2UserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// WindType3or4UserDefined Commands
data class CreateWindType3or4UserDefinedCommand(
    @TargetAggregateIdentifier val windType3or4UserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateWindType3or4UserDefinedCommand(
    @TargetAggregateIdentifier val windType3or4UserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteWindType3or4UserDefinedCommand(@TargetAggregateIdentifier  var windType3or4UserDefinedId: UUID? = null)

// single association commands

// multiple association commands



