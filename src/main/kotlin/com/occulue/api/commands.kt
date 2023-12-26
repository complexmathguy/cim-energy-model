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
    @TargetAggregateIdentifier var aCDCConverterId: UUID? = null,
    var baseS: String,
    var idleLoss: String,
    var maxUdc: String,
    var minUdc: String,
    var numberOfValves: String,
    var ratedUdc: String,
    var resistiveLoss: String,
    var switchingLoss: String,
    var valveU0: String
)

data class UpdateACDCConverterCommand(
    @TargetAggregateIdentifier var aCDCConverterId: UUID? = null,
    var baseS: String,
    var idleLoss: String,
    var maxUdc: String,
    var minUdc: String,
    var numberOfValves: String,
    var ratedUdc: String,
    var resistiveLoss: String,
    var switchingLoss: String,
    var valveU0: String
)

data class DeleteACDCConverterCommand(@TargetAggregateIdentifier  var aCDCConverterId: UUID? = null)

// single association commands

// multiple association commands


// ACDCConverterDCTerminal Commands
data class CreateACDCConverterDCTerminalCommand(
    @TargetAggregateIdentifier var aCDCConverterDCTerminalId: UUID? = null,
    var polarity: String
)

data class UpdateACDCConverterDCTerminalCommand(
    @TargetAggregateIdentifier var aCDCConverterDCTerminalId: UUID? = null,
    var polarity: String
)

data class DeleteACDCConverterDCTerminalCommand(@TargetAggregateIdentifier  var aCDCConverterDCTerminalId: UUID? = null)

// single association commands

// multiple association commands


// ACDCTerminal Commands
data class CreateACDCTerminalCommand(
    @TargetAggregateIdentifier var aCDCTerminalId: UUID? = null,
    var sequenceNumber: String
)

data class UpdateACDCTerminalCommand(
    @TargetAggregateIdentifier var aCDCTerminalId: UUID? = null,
    var sequenceNumber: String
)

data class DeleteACDCTerminalCommand(@TargetAggregateIdentifier  var aCDCTerminalId: UUID? = null)

// single association commands

// multiple association commands


// ACLineSegment Commands
data class CreateACLineSegmentCommand(
    @TargetAggregateIdentifier var aCLineSegmentId: UUID? = null,
    var b0ch: String,
    var bch: String,
    var g0ch: String,
    var gch: String,
    var r: String,
    var r0: String,
    var shortCircuitEndTemperature: String,
    var x: String,
    var x0: String
)

data class UpdateACLineSegmentCommand(
    @TargetAggregateIdentifier var aCLineSegmentId: UUID? = null,
    var b0ch: String,
    var bch: String,
    var g0ch: String,
    var gch: String,
    var r: String,
    var r0: String,
    var shortCircuitEndTemperature: String,
    var x: String,
    var x0: String
)

data class DeleteACLineSegmentCommand(@TargetAggregateIdentifier  var aCLineSegmentId: UUID? = null)

// single association commands

// multiple association commands


// Accumulator Commands
data class CreateAccumulatorCommand(
    @TargetAggregateIdentifier  var accumulatorId: UUID? = null
)

data class UpdateAccumulatorCommand(
    @TargetAggregateIdentifier  var accumulatorId: UUID? = null
)

data class DeleteAccumulatorCommand(@TargetAggregateIdentifier  var accumulatorId: UUID? = null)

// single association commands

// multiple association commands


// AccumulatorLimit Commands
data class CreateAccumulatorLimitCommand(
    @TargetAggregateIdentifier var accumulatorLimitId: UUID? = null,
    var value: String
)

data class UpdateAccumulatorLimitCommand(
    @TargetAggregateIdentifier var accumulatorLimitId: UUID? = null,
    var value: String
)

data class DeleteAccumulatorLimitCommand(@TargetAggregateIdentifier  var accumulatorLimitId: UUID? = null)

// single association commands

// multiple association commands


// AccumulatorLimitSet Commands
data class CreateAccumulatorLimitSetCommand(
    @TargetAggregateIdentifier  var accumulatorLimitSetId: UUID? = null
)

data class UpdateAccumulatorLimitSetCommand(
    @TargetAggregateIdentifier  var accumulatorLimitSetId: UUID? = null
)

data class DeleteAccumulatorLimitSetCommand(@TargetAggregateIdentifier  var accumulatorLimitSetId: UUID? = null)

// single association commands

// multiple association commands


// AccumulatorReset Commands
data class CreateAccumulatorResetCommand(
    @TargetAggregateIdentifier  var accumulatorResetId: UUID? = null
)

data class UpdateAccumulatorResetCommand(
    @TargetAggregateIdentifier  var accumulatorResetId: UUID? = null
)

data class DeleteAccumulatorResetCommand(@TargetAggregateIdentifier  var accumulatorResetId: UUID? = null)

// single association commands

// multiple association commands


// AccumulatorValue Commands
data class CreateAccumulatorValueCommand(
    @TargetAggregateIdentifier var accumulatorValueId: UUID? = null,
    var value: String
)

data class UpdateAccumulatorValueCommand(
    @TargetAggregateIdentifier var accumulatorValueId: UUID? = null,
    var value: String
)

data class DeleteAccumulatorValueCommand(@TargetAggregateIdentifier  var accumulatorValueId: UUID? = null)

// single association commands

// multiple association commands


// ActivePower Commands
data class CreateActivePowerCommand(
    @TargetAggregateIdentifier var activePowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateActivePowerCommand(
    @TargetAggregateIdentifier var activePowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteActivePowerCommand(@TargetAggregateIdentifier  var activePowerId: UUID? = null)

// single association commands

// multiple association commands


// ActivePowerLimit Commands
data class CreateActivePowerLimitCommand(
    @TargetAggregateIdentifier var activePowerLimitId: UUID? = null,
    var value: String
)

data class UpdateActivePowerLimitCommand(
    @TargetAggregateIdentifier var activePowerLimitId: UUID? = null,
    var value: String
)

data class DeleteActivePowerLimitCommand(@TargetAggregateIdentifier  var activePowerLimitId: UUID? = null)

// single association commands

// multiple association commands


// ActivePowerPerCurrentFlow Commands
data class CreateActivePowerPerCurrentFlowCommand(
    @TargetAggregateIdentifier var activePowerPerCurrentFlowId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateActivePowerPerCurrentFlowCommand(
    @TargetAggregateIdentifier var activePowerPerCurrentFlowId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteActivePowerPerCurrentFlowCommand(@TargetAggregateIdentifier  var activePowerPerCurrentFlowId: UUID? = null)

// single association commands

// multiple association commands


// ActivePowerPerFrequency Commands
data class CreateActivePowerPerFrequencyCommand(
    @TargetAggregateIdentifier var activePowerPerFrequencyId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateActivePowerPerFrequencyCommand(
    @TargetAggregateIdentifier var activePowerPerFrequencyId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteActivePowerPerFrequencyCommand(@TargetAggregateIdentifier  var activePowerPerFrequencyId: UUID? = null)

// single association commands

// multiple association commands


// Analog Commands
data class CreateAnalogCommand(
    @TargetAggregateIdentifier var analogId: UUID? = null,
    var positiveFlowIn: String
)

data class UpdateAnalogCommand(
    @TargetAggregateIdentifier var analogId: UUID? = null,
    var positiveFlowIn: String
)

data class DeleteAnalogCommand(@TargetAggregateIdentifier  var analogId: UUID? = null)

// single association commands

// multiple association commands


// AnalogControl Commands
data class CreateAnalogControlCommand(
    @TargetAggregateIdentifier var analogControlId: UUID? = null,
    var maxValue: String,
    var minValue: String
)

data class UpdateAnalogControlCommand(
    @TargetAggregateIdentifier var analogControlId: UUID? = null,
    var maxValue: String,
    var minValue: String
)

data class DeleteAnalogControlCommand(@TargetAggregateIdentifier  var analogControlId: UUID? = null)

// single association commands

// multiple association commands


// AnalogLimit Commands
data class CreateAnalogLimitCommand(
    @TargetAggregateIdentifier var analogLimitId: UUID? = null,
    var value: String
)

data class UpdateAnalogLimitCommand(
    @TargetAggregateIdentifier var analogLimitId: UUID? = null,
    var value: String
)

data class DeleteAnalogLimitCommand(@TargetAggregateIdentifier  var analogLimitId: UUID? = null)

// single association commands

// multiple association commands


// AnalogLimitSet Commands
data class CreateAnalogLimitSetCommand(
    @TargetAggregateIdentifier  var analogLimitSetId: UUID? = null
)

data class UpdateAnalogLimitSetCommand(
    @TargetAggregateIdentifier  var analogLimitSetId: UUID? = null
)

data class DeleteAnalogLimitSetCommand(@TargetAggregateIdentifier  var analogLimitSetId: UUID? = null)

// single association commands

// multiple association commands


// AnalogValue Commands
data class CreateAnalogValueCommand(
    @TargetAggregateIdentifier var analogValueId: UUID? = null,
    var value: String
)

data class UpdateAnalogValueCommand(
    @TargetAggregateIdentifier var analogValueId: UUID? = null,
    var value: String
)

data class DeleteAnalogValueCommand(@TargetAggregateIdentifier  var analogValueId: UUID? = null)

// single association commands

// multiple association commands


// AngleDegrees Commands
data class CreateAngleDegreesCommand(
    @TargetAggregateIdentifier var angleDegreesId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateAngleDegreesCommand(
    @TargetAggregateIdentifier var angleDegreesId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteAngleDegreesCommand(@TargetAggregateIdentifier  var angleDegreesId: UUID? = null)

// single association commands

// multiple association commands


// AngleRadians Commands
data class CreateAngleRadiansCommand(
    @TargetAggregateIdentifier var angleRadiansId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateAngleRadiansCommand(
    @TargetAggregateIdentifier var angleRadiansId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteAngleRadiansCommand(@TargetAggregateIdentifier  var angleRadiansId: UUID? = null)

// single association commands

// multiple association commands


// ApparentPower Commands
data class CreateApparentPowerCommand(
    @TargetAggregateIdentifier var apparentPowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateApparentPowerCommand(
    @TargetAggregateIdentifier var apparentPowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteApparentPowerCommand(@TargetAggregateIdentifier  var apparentPowerId: UUID? = null)

// single association commands

// multiple association commands


// ApparentPowerLimit Commands
data class CreateApparentPowerLimitCommand(
    @TargetAggregateIdentifier var apparentPowerLimitId: UUID? = null,
    var value: String
)

data class UpdateApparentPowerLimitCommand(
    @TargetAggregateIdentifier var apparentPowerLimitId: UUID? = null,
    var value: String
)

data class DeleteApparentPowerLimitCommand(@TargetAggregateIdentifier  var apparentPowerLimitId: UUID? = null)

// single association commands

// multiple association commands


// Area Commands
data class CreateAreaCommand(
    @TargetAggregateIdentifier var areaId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateAreaCommand(
    @TargetAggregateIdentifier var areaId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteAreaCommand(@TargetAggregateIdentifier  var areaId: UUID? = null)

// single association commands

// multiple association commands


// AsynchronousMachine Commands
data class CreateAsynchronousMachineCommand(
    @TargetAggregateIdentifier var asynchronousMachineId: UUID? = null,
    var converterFedDrive: String,
    var efficiency: String,
    var iaIrRatio: String,
    var nominalFrequency: String,
    var nominalSpeed: String,
    var polePairNumber: String,
    var ratedMechanicalPower: String,
    var reversible: String,
    var rxLockedRotorRatio: String
)

data class UpdateAsynchronousMachineCommand(
    @TargetAggregateIdentifier var asynchronousMachineId: UUID? = null,
    var converterFedDrive: String,
    var efficiency: String,
    var iaIrRatio: String,
    var nominalFrequency: String,
    var nominalSpeed: String,
    var polePairNumber: String,
    var ratedMechanicalPower: String,
    var reversible: String,
    var rxLockedRotorRatio: String
)

data class DeleteAsynchronousMachineCommand(@TargetAggregateIdentifier  var asynchronousMachineId: UUID? = null)

// single association commands

// multiple association commands


// AsynchronousMachineDynamics Commands
data class CreateAsynchronousMachineDynamicsCommand(
    @TargetAggregateIdentifier  var asynchronousMachineDynamicsId: UUID? = null
)

data class UpdateAsynchronousMachineDynamicsCommand(
    @TargetAggregateIdentifier  var asynchronousMachineDynamicsId: UUID? = null
)

data class DeleteAsynchronousMachineDynamicsCommand(@TargetAggregateIdentifier  var asynchronousMachineDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// AsynchronousMachineEquivalentCircuit Commands
data class CreateAsynchronousMachineEquivalentCircuitCommand(
    @TargetAggregateIdentifier var asynchronousMachineEquivalentCircuitId: UUID? = null,
    var rr1: String,
    var rr2: String,
    var xlr1: String,
    var xlr2: String,
    var xm: String
)

data class UpdateAsynchronousMachineEquivalentCircuitCommand(
    @TargetAggregateIdentifier var asynchronousMachineEquivalentCircuitId: UUID? = null,
    var rr1: String,
    var rr2: String,
    var xlr1: String,
    var xlr2: String,
    var xm: String
)

data class DeleteAsynchronousMachineEquivalentCircuitCommand(@TargetAggregateIdentifier  var asynchronousMachineEquivalentCircuitId: UUID? = null)

// single association commands

// multiple association commands


// AsynchronousMachineTimeConstantReactance Commands
data class CreateAsynchronousMachineTimeConstantReactanceCommand(
    @TargetAggregateIdentifier var asynchronousMachineTimeConstantReactanceId: UUID? = null,
    var tpo: String,
    var tppo: String,
    var xp: String,
    var xpp: String,
    var xs: String
)

data class UpdateAsynchronousMachineTimeConstantReactanceCommand(
    @TargetAggregateIdentifier var asynchronousMachineTimeConstantReactanceId: UUID? = null,
    var tpo: String,
    var tppo: String,
    var xp: String,
    var xpp: String,
    var xs: String
)

data class DeleteAsynchronousMachineTimeConstantReactanceCommand(@TargetAggregateIdentifier  var asynchronousMachineTimeConstantReactanceId: UUID? = null)

// single association commands

// multiple association commands


// AsynchronousMachineUserDefined Commands
data class CreateAsynchronousMachineUserDefinedCommand(
    @TargetAggregateIdentifier var asynchronousMachineUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateAsynchronousMachineUserDefinedCommand(
    @TargetAggregateIdentifier var asynchronousMachineUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteAsynchronousMachineUserDefinedCommand(@TargetAggregateIdentifier  var asynchronousMachineUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// BaseVoltage Commands
data class CreateBaseVoltageCommand(
    @TargetAggregateIdentifier var baseVoltageId: UUID? = null,
    var nominalVoltage: String
)

data class UpdateBaseVoltageCommand(
    @TargetAggregateIdentifier var baseVoltageId: UUID? = null,
    var nominalVoltage: String
)

data class DeleteBaseVoltageCommand(@TargetAggregateIdentifier  var baseVoltageId: UUID? = null)

// single association commands

// multiple association commands


// BasicIntervalSchedule Commands
data class CreateBasicIntervalScheduleCommand(
    @TargetAggregateIdentifier var basicIntervalScheduleId: UUID? = null,
    var startTime: String,
    var value1Unit: String,
    var value2Unit: String
)

data class UpdateBasicIntervalScheduleCommand(
    @TargetAggregateIdentifier var basicIntervalScheduleId: UUID? = null,
    var startTime: String,
    var value1Unit: String,
    var value2Unit: String
)

data class DeleteBasicIntervalScheduleCommand(@TargetAggregateIdentifier  var basicIntervalScheduleId: UUID? = null)

// single association commands

// multiple association commands


// Bay Commands
data class CreateBayCommand(
    @TargetAggregateIdentifier  var bayId: UUID? = null
)

data class UpdateBayCommand(
    @TargetAggregateIdentifier  var bayId: UUID? = null
)

data class DeleteBayCommand(@TargetAggregateIdentifier  var bayId: UUID? = null)

// single association commands

// multiple association commands


// BooleanProxy Commands
data class CreateBooleanProxyCommand(
    @TargetAggregateIdentifier  var booleanProxyId: UUID? = null
)

data class UpdateBooleanProxyCommand(
    @TargetAggregateIdentifier  var booleanProxyId: UUID? = null
)

data class DeleteBooleanProxyCommand(@TargetAggregateIdentifier  var booleanProxyId: UUID? = null)

// single association commands

// multiple association commands


// BoundaryExtensions Commands
data class CreateBoundaryExtensionsCommand(
    @TargetAggregateIdentifier var boundaryExtensionsId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class UpdateBoundaryExtensionsCommand(
    @TargetAggregateIdentifier var boundaryExtensionsId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class DeleteBoundaryExtensionsCommand(@TargetAggregateIdentifier  var boundaryExtensionsId: UUID? = null)

// single association commands

// multiple association commands


// Breaker Commands
data class CreateBreakerCommand(
    @TargetAggregateIdentifier  var breakerId: UUID? = null
)

data class UpdateBreakerCommand(
    @TargetAggregateIdentifier  var breakerId: UUID? = null
)

data class DeleteBreakerCommand(@TargetAggregateIdentifier  var breakerId: UUID? = null)

// single association commands

// multiple association commands


// BusNameMarker Commands
data class CreateBusNameMarkerCommand(
    @TargetAggregateIdentifier var busNameMarkerId: UUID? = null,
    var priority: String
)

data class UpdateBusNameMarkerCommand(
    @TargetAggregateIdentifier var busNameMarkerId: UUID? = null,
    var priority: String
)

data class DeleteBusNameMarkerCommand(@TargetAggregateIdentifier  var busNameMarkerId: UUID? = null)

// single association commands

// multiple association commands


// BusbarSection Commands
data class CreateBusbarSectionCommand(
    @TargetAggregateIdentifier var busbarSectionId: UUID? = null,
    var ipMax: String
)

data class UpdateBusbarSectionCommand(
    @TargetAggregateIdentifier var busbarSectionId: UUID? = null,
    var ipMax: String
)

data class DeleteBusbarSectionCommand(@TargetAggregateIdentifier  var busbarSectionId: UUID? = null)

// single association commands

// multiple association commands


// Capacitance Commands
data class CreateCapacitanceCommand(
    @TargetAggregateIdentifier var capacitanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateCapacitanceCommand(
    @TargetAggregateIdentifier var capacitanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteCapacitanceCommand(@TargetAggregateIdentifier  var capacitanceId: UUID? = null)

// single association commands

// multiple association commands


// CapacitancePerLength Commands
data class CreateCapacitancePerLengthCommand(
    @TargetAggregateIdentifier var capacitancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateCapacitancePerLengthCommand(
    @TargetAggregateIdentifier var capacitancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteCapacitancePerLengthCommand(@TargetAggregateIdentifier  var capacitancePerLengthId: UUID? = null)

// single association commands

// multiple association commands


// Command Commands
data class CreateCommandCommand(
    @TargetAggregateIdentifier var commandId: UUID? = null,
    var normalValue: String,
    var value: String
)

data class UpdateCommandCommand(
    @TargetAggregateIdentifier var commandId: UUID? = null,
    var normalValue: String,
    var value: String
)

data class DeleteCommandCommand(@TargetAggregateIdentifier  var commandId: UUID? = null)

// single association commands

// multiple association commands


// Conductance Commands
data class CreateConductanceCommand(
    @TargetAggregateIdentifier var conductanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateConductanceCommand(
    @TargetAggregateIdentifier var conductanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteConductanceCommand(@TargetAggregateIdentifier  var conductanceId: UUID? = null)

// single association commands

// multiple association commands


// ConductingEquipment Commands
data class CreateConductingEquipmentCommand(
    @TargetAggregateIdentifier  var conductingEquipmentId: UUID? = null
)

data class UpdateConductingEquipmentCommand(
    @TargetAggregateIdentifier  var conductingEquipmentId: UUID? = null
)

data class DeleteConductingEquipmentCommand(@TargetAggregateIdentifier  var conductingEquipmentId: UUID? = null)

// single association commands

// multiple association commands


// Conductor Commands
data class CreateConductorCommand(
    @TargetAggregateIdentifier var conductorId: UUID? = null,
    var length: String
)

data class UpdateConductorCommand(
    @TargetAggregateIdentifier var conductorId: UUID? = null,
    var length: String
)

data class DeleteConductorCommand(@TargetAggregateIdentifier  var conductorId: UUID? = null)

// single association commands

// multiple association commands


// ConformLoad Commands
data class CreateConformLoadCommand(
    @TargetAggregateIdentifier  var conformLoadId: UUID? = null
)

data class UpdateConformLoadCommand(
    @TargetAggregateIdentifier  var conformLoadId: UUID? = null
)

data class DeleteConformLoadCommand(@TargetAggregateIdentifier  var conformLoadId: UUID? = null)

// single association commands

// multiple association commands


// ConformLoadGroup Commands
data class CreateConformLoadGroupCommand(
    @TargetAggregateIdentifier  var conformLoadGroupId: UUID? = null
)

data class UpdateConformLoadGroupCommand(
    @TargetAggregateIdentifier  var conformLoadGroupId: UUID? = null
)

data class DeleteConformLoadGroupCommand(@TargetAggregateIdentifier  var conformLoadGroupId: UUID? = null)

// single association commands

// multiple association commands


// ConformLoadSchedule Commands
data class CreateConformLoadScheduleCommand(
    @TargetAggregateIdentifier  var conformLoadScheduleId: UUID? = null
)

data class UpdateConformLoadScheduleCommand(
    @TargetAggregateIdentifier  var conformLoadScheduleId: UUID? = null
)

data class DeleteConformLoadScheduleCommand(@TargetAggregateIdentifier  var conformLoadScheduleId: UUID? = null)

// single association commands

// multiple association commands


// ConnectivityNode Commands
data class CreateConnectivityNodeCommand(
    @TargetAggregateIdentifier var connectivityNodeId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class UpdateConnectivityNodeCommand(
    @TargetAggregateIdentifier var connectivityNodeId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class DeleteConnectivityNodeCommand(@TargetAggregateIdentifier  var connectivityNodeId: UUID? = null)

// single association commands

// multiple association commands


// ConnectivityNodeContainer Commands
data class CreateConnectivityNodeContainerCommand(
    @TargetAggregateIdentifier  var connectivityNodeContainerId: UUID? = null
)

data class UpdateConnectivityNodeContainerCommand(
    @TargetAggregateIdentifier  var connectivityNodeContainerId: UUID? = null
)

data class DeleteConnectivityNodeContainerCommand(@TargetAggregateIdentifier  var connectivityNodeContainerId: UUID? = null)

// single association commands

// multiple association commands


// Connector Commands
data class CreateConnectorCommand(
    @TargetAggregateIdentifier  var connectorId: UUID? = null
)

data class UpdateConnectorCommand(
    @TargetAggregateIdentifier  var connectorId: UUID? = null
)

data class DeleteConnectorCommand(@TargetAggregateIdentifier  var connectorId: UUID? = null)

// single association commands

// multiple association commands


// Control Commands
data class CreateControlCommand(
    @TargetAggregateIdentifier var controlId: UUID? = null,
    var controlType: String,
    var operationInProgress: String,
    var timeStamp: String,
    var unitMultiplier: String,
    var unitSymbol: String
)

data class UpdateControlCommand(
    @TargetAggregateIdentifier var controlId: UUID? = null,
    var controlType: String,
    var operationInProgress: String,
    var timeStamp: String,
    var unitMultiplier: String,
    var unitSymbol: String
)

data class DeleteControlCommand(@TargetAggregateIdentifier  var controlId: UUID? = null)

// single association commands

// multiple association commands


// ControlArea Commands
data class CreateControlAreaCommand(
    @TargetAggregateIdentifier var controlAreaId: UUID? = null,
    var type: String
)

data class UpdateControlAreaCommand(
    @TargetAggregateIdentifier var controlAreaId: UUID? = null,
    var type: String
)

data class DeleteControlAreaCommand(@TargetAggregateIdentifier  var controlAreaId: UUID? = null)

// single association commands

// multiple association commands


// ControlAreaGeneratingUnit Commands
data class CreateControlAreaGeneratingUnitCommand(
    @TargetAggregateIdentifier  var controlAreaGeneratingUnitId: UUID? = null
)

data class UpdateControlAreaGeneratingUnitCommand(
    @TargetAggregateIdentifier  var controlAreaGeneratingUnitId: UUID? = null
)

data class DeleteControlAreaGeneratingUnitCommand(@TargetAggregateIdentifier  var controlAreaGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// CoordinateSystem Commands
data class CreateCoordinateSystemCommand(
    @TargetAggregateIdentifier var coordinateSystemId: UUID? = null,
    var crsUrn: String
)

data class UpdateCoordinateSystemCommand(
    @TargetAggregateIdentifier var coordinateSystemId: UUID? = null,
    var crsUrn: String
)

data class DeleteCoordinateSystemCommand(@TargetAggregateIdentifier  var coordinateSystemId: UUID? = null)

// single association commands

// multiple association commands


// CsConverter Commands
data class CreateCsConverterCommand(
    @TargetAggregateIdentifier var csConverterId: UUID? = null,
    var maxAlpha: String,
    var maxGamma: String,
    var maxIdc: String,
    var minAlpha: String,
    var minGamma: String,
    var minIdc: String,
    var ratedIdc: String
)

data class UpdateCsConverterCommand(
    @TargetAggregateIdentifier var csConverterId: UUID? = null,
    var maxAlpha: String,
    var maxGamma: String,
    var maxIdc: String,
    var minAlpha: String,
    var minGamma: String,
    var minIdc: String,
    var ratedIdc: String
)

data class DeleteCsConverterCommand(@TargetAggregateIdentifier  var csConverterId: UUID? = null)

// single association commands

// multiple association commands


// CurrentFlow Commands
data class CreateCurrentFlowCommand(
    @TargetAggregateIdentifier var currentFlowId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateCurrentFlowCommand(
    @TargetAggregateIdentifier var currentFlowId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteCurrentFlowCommand(@TargetAggregateIdentifier  var currentFlowId: UUID? = null)

// single association commands

// multiple association commands


// CurrentLimit Commands
data class CreateCurrentLimitCommand(
    @TargetAggregateIdentifier var currentLimitId: UUID? = null,
    var value: String
)

data class UpdateCurrentLimitCommand(
    @TargetAggregateIdentifier var currentLimitId: UUID? = null,
    var value: String
)

data class DeleteCurrentLimitCommand(@TargetAggregateIdentifier  var currentLimitId: UUID? = null)

// single association commands

// multiple association commands


// Curve Commands
data class CreateCurveCommand(
    @TargetAggregateIdentifier var curveId: UUID? = null,
    var curveStyle: String,
    var xUnit: String,
    var y1Unit: String,
    var y2Unit: String
)

data class UpdateCurveCommand(
    @TargetAggregateIdentifier var curveId: UUID? = null,
    var curveStyle: String,
    var xUnit: String,
    var y1Unit: String,
    var y2Unit: String
)

data class DeleteCurveCommand(@TargetAggregateIdentifier  var curveId: UUID? = null)

// single association commands

// multiple association commands


// CurveData Commands
data class CreateCurveDataCommand(
    @TargetAggregateIdentifier var curveDataId: UUID? = null,
    var xvalue: String,
    var y1value: String,
    var y2value: String
)

data class UpdateCurveDataCommand(
    @TargetAggregateIdentifier var curveDataId: UUID? = null,
    var xvalue: String,
    var y1value: String,
    var y2value: String
)

data class DeleteCurveDataCommand(@TargetAggregateIdentifier  var curveDataId: UUID? = null)

// single association commands

// multiple association commands


// DCBaseTerminal Commands
data class CreateDCBaseTerminalCommand(
    @TargetAggregateIdentifier  var dCBaseTerminalId: UUID? = null
)

data class UpdateDCBaseTerminalCommand(
    @TargetAggregateIdentifier  var dCBaseTerminalId: UUID? = null
)

data class DeleteDCBaseTerminalCommand(@TargetAggregateIdentifier  var dCBaseTerminalId: UUID? = null)

// single association commands

// multiple association commands


// DCBreaker Commands
data class CreateDCBreakerCommand(
    @TargetAggregateIdentifier  var dCBreakerId: UUID? = null
)

data class UpdateDCBreakerCommand(
    @TargetAggregateIdentifier  var dCBreakerId: UUID? = null
)

data class DeleteDCBreakerCommand(@TargetAggregateIdentifier  var dCBreakerId: UUID? = null)

// single association commands

// multiple association commands


// DCBusbar Commands
data class CreateDCBusbarCommand(
    @TargetAggregateIdentifier  var dCBusbarId: UUID? = null
)

data class UpdateDCBusbarCommand(
    @TargetAggregateIdentifier  var dCBusbarId: UUID? = null
)

data class DeleteDCBusbarCommand(@TargetAggregateIdentifier  var dCBusbarId: UUID? = null)

// single association commands

// multiple association commands


// DCChopper Commands
data class CreateDCChopperCommand(
    @TargetAggregateIdentifier  var dCChopperId: UUID? = null
)

data class UpdateDCChopperCommand(
    @TargetAggregateIdentifier  var dCChopperId: UUID? = null
)

data class DeleteDCChopperCommand(@TargetAggregateIdentifier  var dCChopperId: UUID? = null)

// single association commands

// multiple association commands


// DCConductingEquipment Commands
data class CreateDCConductingEquipmentCommand(
    @TargetAggregateIdentifier  var dCConductingEquipmentId: UUID? = null
)

data class UpdateDCConductingEquipmentCommand(
    @TargetAggregateIdentifier  var dCConductingEquipmentId: UUID? = null
)

data class DeleteDCConductingEquipmentCommand(@TargetAggregateIdentifier  var dCConductingEquipmentId: UUID? = null)

// single association commands

// multiple association commands


// DCConverterUnit Commands
data class CreateDCConverterUnitCommand(
    @TargetAggregateIdentifier var dCConverterUnitId: UUID? = null,
    var operationMode: String
)

data class UpdateDCConverterUnitCommand(
    @TargetAggregateIdentifier var dCConverterUnitId: UUID? = null,
    var operationMode: String
)

data class DeleteDCConverterUnitCommand(@TargetAggregateIdentifier  var dCConverterUnitId: UUID? = null)

// single association commands

// multiple association commands


// DCDisconnector Commands
data class CreateDCDisconnectorCommand(
    @TargetAggregateIdentifier  var dCDisconnectorId: UUID? = null
)

data class UpdateDCDisconnectorCommand(
    @TargetAggregateIdentifier  var dCDisconnectorId: UUID? = null
)

data class DeleteDCDisconnectorCommand(@TargetAggregateIdentifier  var dCDisconnectorId: UUID? = null)

// single association commands

// multiple association commands


// DCEquipmentContainer Commands
data class CreateDCEquipmentContainerCommand(
    @TargetAggregateIdentifier  var dCEquipmentContainerId: UUID? = null
)

data class UpdateDCEquipmentContainerCommand(
    @TargetAggregateIdentifier  var dCEquipmentContainerId: UUID? = null
)

data class DeleteDCEquipmentContainerCommand(@TargetAggregateIdentifier  var dCEquipmentContainerId: UUID? = null)

// single association commands

// multiple association commands


// DCGround Commands
data class CreateDCGroundCommand(
    @TargetAggregateIdentifier var dCGroundId: UUID? = null,
    var inductance: String,
    var r: String
)

data class UpdateDCGroundCommand(
    @TargetAggregateIdentifier var dCGroundId: UUID? = null,
    var inductance: String,
    var r: String
)

data class DeleteDCGroundCommand(@TargetAggregateIdentifier  var dCGroundId: UUID? = null)

// single association commands

// multiple association commands


// DCLine Commands
data class CreateDCLineCommand(
    @TargetAggregateIdentifier  var dCLineId: UUID? = null
)

data class UpdateDCLineCommand(
    @TargetAggregateIdentifier  var dCLineId: UUID? = null
)

data class DeleteDCLineCommand(@TargetAggregateIdentifier  var dCLineId: UUID? = null)

// single association commands

// multiple association commands


// DCLineSegment Commands
data class CreateDCLineSegmentCommand(
    @TargetAggregateIdentifier var dCLineSegmentId: UUID? = null,
    var capacitance: String,
    var inductance: String,
    var length: String,
    var resistance: String
)

data class UpdateDCLineSegmentCommand(
    @TargetAggregateIdentifier var dCLineSegmentId: UUID? = null,
    var capacitance: String,
    var inductance: String,
    var length: String,
    var resistance: String
)

data class DeleteDCLineSegmentCommand(@TargetAggregateIdentifier  var dCLineSegmentId: UUID? = null)

// single association commands

// multiple association commands


// DCNode Commands
data class CreateDCNodeCommand(
    @TargetAggregateIdentifier  var dCNodeId: UUID? = null
)

data class UpdateDCNodeCommand(
    @TargetAggregateIdentifier  var dCNodeId: UUID? = null
)

data class DeleteDCNodeCommand(@TargetAggregateIdentifier  var dCNodeId: UUID? = null)

// single association commands

// multiple association commands


// DCSeriesDevice Commands
data class CreateDCSeriesDeviceCommand(
    @TargetAggregateIdentifier var dCSeriesDeviceId: UUID? = null,
    var inductance: String,
    var ratedUdc: String,
    var resistance: String
)

data class UpdateDCSeriesDeviceCommand(
    @TargetAggregateIdentifier var dCSeriesDeviceId: UUID? = null,
    var inductance: String,
    var ratedUdc: String,
    var resistance: String
)

data class DeleteDCSeriesDeviceCommand(@TargetAggregateIdentifier  var dCSeriesDeviceId: UUID? = null)

// single association commands

// multiple association commands


// DCShunt Commands
data class CreateDCShuntCommand(
    @TargetAggregateIdentifier var dCShuntId: UUID? = null,
    var capacitance: String,
    var ratedUdc: String,
    var resistance: String
)

data class UpdateDCShuntCommand(
    @TargetAggregateIdentifier var dCShuntId: UUID? = null,
    var capacitance: String,
    var ratedUdc: String,
    var resistance: String
)

data class DeleteDCShuntCommand(@TargetAggregateIdentifier  var dCShuntId: UUID? = null)

// single association commands

// multiple association commands


// DCSwitch Commands
data class CreateDCSwitchCommand(
    @TargetAggregateIdentifier  var dCSwitchId: UUID? = null
)

data class UpdateDCSwitchCommand(
    @TargetAggregateIdentifier  var dCSwitchId: UUID? = null
)

data class DeleteDCSwitchCommand(@TargetAggregateIdentifier  var dCSwitchId: UUID? = null)

// single association commands

// multiple association commands


// DCTerminal Commands
data class CreateDCTerminalCommand(
    @TargetAggregateIdentifier  var dCTerminalId: UUID? = null
)

data class UpdateDCTerminalCommand(
    @TargetAggregateIdentifier  var dCTerminalId: UUID? = null
)

data class DeleteDCTerminalCommand(@TargetAggregateIdentifier  var dCTerminalId: UUID? = null)

// single association commands

// multiple association commands


// DCTopologicalIsland Commands
data class CreateDCTopologicalIslandCommand(
    @TargetAggregateIdentifier  var dCTopologicalIslandId: UUID? = null
)

data class UpdateDCTopologicalIslandCommand(
    @TargetAggregateIdentifier  var dCTopologicalIslandId: UUID? = null
)

data class DeleteDCTopologicalIslandCommand(@TargetAggregateIdentifier  var dCTopologicalIslandId: UUID? = null)

// single association commands

// multiple association commands


// DCTopologicalNode Commands
data class CreateDCTopologicalNodeCommand(
    @TargetAggregateIdentifier  var dCTopologicalNodeId: UUID? = null
)

data class UpdateDCTopologicalNodeCommand(
    @TargetAggregateIdentifier  var dCTopologicalNodeId: UUID? = null
)

data class DeleteDCTopologicalNodeCommand(@TargetAggregateIdentifier  var dCTopologicalNodeId: UUID? = null)

// single association commands

// multiple association commands


// DateProxy Commands
data class CreateDateProxyCommand(
    @TargetAggregateIdentifier  var dateProxyId: UUID? = null
)

data class UpdateDateProxyCommand(
    @TargetAggregateIdentifier  var dateProxyId: UUID? = null
)

data class DeleteDateProxyCommand(@TargetAggregateIdentifier  var dateProxyId: UUID? = null)

// single association commands

// multiple association commands


// DateTime Commands
data class CreateDateTimeCommand(
    @TargetAggregateIdentifier  var dateTimeId: UUID? = null
)

data class UpdateDateTimeCommand(
    @TargetAggregateIdentifier  var dateTimeId: UUID? = null
)

data class DeleteDateTimeCommand(@TargetAggregateIdentifier  var dateTimeId: UUID? = null)

// single association commands

// multiple association commands


// DayType Commands
data class CreateDayTypeCommand(
    @TargetAggregateIdentifier  var dayTypeId: UUID? = null
)

data class UpdateDayTypeCommand(
    @TargetAggregateIdentifier  var dayTypeId: UUID? = null
)

data class DeleteDayTypeCommand(@TargetAggregateIdentifier  var dayTypeId: UUID? = null)

// single association commands

// multiple association commands


// DecimalProxy Commands
data class CreateDecimalProxyCommand(
    @TargetAggregateIdentifier  var decimalProxyId: UUID? = null
)

data class UpdateDecimalProxyCommand(
    @TargetAggregateIdentifier  var decimalProxyId: UUID? = null
)

data class DeleteDecimalProxyCommand(@TargetAggregateIdentifier  var decimalProxyId: UUID? = null)

// single association commands

// multiple association commands


// Diagram Commands
data class CreateDiagramCommand(
    @TargetAggregateIdentifier var diagramId: UUID? = null,
    var orientation: String,
    var x1InitialView: String,
    var x2InitialView: String,
    var y1InitialView: String,
    var y2InitialView: String
)

data class UpdateDiagramCommand(
    @TargetAggregateIdentifier var diagramId: UUID? = null,
    var orientation: String,
    var x1InitialView: String,
    var x2InitialView: String,
    var y1InitialView: String,
    var y2InitialView: String
)

data class DeleteDiagramCommand(@TargetAggregateIdentifier  var diagramId: UUID? = null)

// single association commands

// multiple association commands


// DiagramLayoutVersion Commands
data class CreateDiagramLayoutVersionCommand(
    @TargetAggregateIdentifier var diagramLayoutVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class UpdateDiagramLayoutVersionCommand(
    @TargetAggregateIdentifier var diagramLayoutVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class DeleteDiagramLayoutVersionCommand(@TargetAggregateIdentifier  var diagramLayoutVersionId: UUID? = null)

// single association commands

// multiple association commands


// DiagramObject Commands
data class CreateDiagramObjectCommand(
    @TargetAggregateIdentifier var diagramObjectId: UUID? = null,
    var drawingOrder: String,
    var isPolygon: String,
    var offsetX: String,
    var offsetY: String,
    var rotation: String
)

data class UpdateDiagramObjectCommand(
    @TargetAggregateIdentifier var diagramObjectId: UUID? = null,
    var drawingOrder: String,
    var isPolygon: String,
    var offsetX: String,
    var offsetY: String,
    var rotation: String
)

data class DeleteDiagramObjectCommand(@TargetAggregateIdentifier  var diagramObjectId: UUID? = null)

// single association commands

// multiple association commands


// DiagramObjectGluePoint Commands
data class CreateDiagramObjectGluePointCommand(
    @TargetAggregateIdentifier  var diagramObjectGluePointId: UUID? = null
)

data class UpdateDiagramObjectGluePointCommand(
    @TargetAggregateIdentifier  var diagramObjectGluePointId: UUID? = null
)

data class DeleteDiagramObjectGluePointCommand(@TargetAggregateIdentifier  var diagramObjectGluePointId: UUID? = null)

// single association commands

// multiple association commands


// DiagramObjectPoint Commands
data class CreateDiagramObjectPointCommand(
    @TargetAggregateIdentifier var diagramObjectPointId: UUID? = null,
    var sequenceNumber: String,
    var xPosition: String,
    var yPosition: String,
    var zPosition: String
)

data class UpdateDiagramObjectPointCommand(
    @TargetAggregateIdentifier var diagramObjectPointId: UUID? = null,
    var sequenceNumber: String,
    var xPosition: String,
    var yPosition: String,
    var zPosition: String
)

data class DeleteDiagramObjectPointCommand(@TargetAggregateIdentifier  var diagramObjectPointId: UUID? = null)

// single association commands

// multiple association commands


// DiagramObjectStyle Commands
data class CreateDiagramObjectStyleCommand(
    @TargetAggregateIdentifier  var diagramObjectStyleId: UUID? = null
)

data class UpdateDiagramObjectStyleCommand(
    @TargetAggregateIdentifier  var diagramObjectStyleId: UUID? = null
)

data class DeleteDiagramObjectStyleCommand(@TargetAggregateIdentifier  var diagramObjectStyleId: UUID? = null)

// single association commands

// multiple association commands


// DiagramStyle Commands
data class CreateDiagramStyleCommand(
    @TargetAggregateIdentifier  var diagramStyleId: UUID? = null
)

data class UpdateDiagramStyleCommand(
    @TargetAggregateIdentifier  var diagramStyleId: UUID? = null
)

data class DeleteDiagramStyleCommand(@TargetAggregateIdentifier  var diagramStyleId: UUID? = null)

// single association commands

// multiple association commands


// DiscExcContIEEEDEC1A Commands
data class CreateDiscExcContIEEEDEC1ACommand(
    @TargetAggregateIdentifier var discExcContIEEEDEC1AId: UUID? = null,
    var esc: String,
    var kan: String,
    var ketl: String,
    var tan: String,
    var td: String,
    var tl1: String,
    var tl2: String,
    var tw5: String,
    var value: String,
    var vanmax: String,
    var vomax: String,
    var vomin: String,
    var vsmax: String,
    var vsmin: String,
    var vtc: String,
    var vtlmt: String,
    var vtm: String,
    var vtn: String
)

data class UpdateDiscExcContIEEEDEC1ACommand(
    @TargetAggregateIdentifier var discExcContIEEEDEC1AId: UUID? = null,
    var esc: String,
    var kan: String,
    var ketl: String,
    var tan: String,
    var td: String,
    var tl1: String,
    var tl2: String,
    var tw5: String,
    var value: String,
    var vanmax: String,
    var vomax: String,
    var vomin: String,
    var vsmax: String,
    var vsmin: String,
    var vtc: String,
    var vtlmt: String,
    var vtm: String,
    var vtn: String
)

data class DeleteDiscExcContIEEEDEC1ACommand(@TargetAggregateIdentifier  var discExcContIEEEDEC1AId: UUID? = null)

// single association commands

// multiple association commands


// DiscExcContIEEEDEC2A Commands
data class CreateDiscExcContIEEEDEC2ACommand(
    @TargetAggregateIdentifier var discExcContIEEEDEC2AId: UUID? = null,
    var td1: String,
    var td2: String,
    var vdmax: String,
    var vdmin: String,
    var vk: String
)

data class UpdateDiscExcContIEEEDEC2ACommand(
    @TargetAggregateIdentifier var discExcContIEEEDEC2AId: UUID? = null,
    var td1: String,
    var td2: String,
    var vdmax: String,
    var vdmin: String,
    var vk: String
)

data class DeleteDiscExcContIEEEDEC2ACommand(@TargetAggregateIdentifier  var discExcContIEEEDEC2AId: UUID? = null)

// single association commands

// multiple association commands


// DiscExcContIEEEDEC3A Commands
data class CreateDiscExcContIEEEDEC3ACommand(
    @TargetAggregateIdentifier var discExcContIEEEDEC3AId: UUID? = null,
    var tdr: String,
    var vtmin: String
)

data class UpdateDiscExcContIEEEDEC3ACommand(
    @TargetAggregateIdentifier var discExcContIEEEDEC3AId: UUID? = null,
    var tdr: String,
    var vtmin: String
)

data class DeleteDiscExcContIEEEDEC3ACommand(@TargetAggregateIdentifier  var discExcContIEEEDEC3AId: UUID? = null)

// single association commands

// multiple association commands


// Disconnector Commands
data class CreateDisconnectorCommand(
    @TargetAggregateIdentifier  var disconnectorId: UUID? = null
)

data class UpdateDisconnectorCommand(
    @TargetAggregateIdentifier  var disconnectorId: UUID? = null
)

data class DeleteDisconnectorCommand(@TargetAggregateIdentifier  var disconnectorId: UUID? = null)

// single association commands

// multiple association commands


// DiscontinuousExcitationControlDynamics Commands
data class CreateDiscontinuousExcitationControlDynamicsCommand(
    @TargetAggregateIdentifier  var discontinuousExcitationControlDynamicsId: UUID? = null
)

data class UpdateDiscontinuousExcitationControlDynamicsCommand(
    @TargetAggregateIdentifier  var discontinuousExcitationControlDynamicsId: UUID? = null
)

data class DeleteDiscontinuousExcitationControlDynamicsCommand(@TargetAggregateIdentifier  var discontinuousExcitationControlDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// DiscontinuousExcitationControlUserDefined Commands
data class CreateDiscontinuousExcitationControlUserDefinedCommand(
    @TargetAggregateIdentifier var discontinuousExcitationControlUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateDiscontinuousExcitationControlUserDefinedCommand(
    @TargetAggregateIdentifier var discontinuousExcitationControlUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteDiscontinuousExcitationControlUserDefinedCommand(@TargetAggregateIdentifier  var discontinuousExcitationControlUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// Discrete Commands
data class CreateDiscreteCommand(
    @TargetAggregateIdentifier  var discreteId: UUID? = null
)

data class UpdateDiscreteCommand(
    @TargetAggregateIdentifier  var discreteId: UUID? = null
)

data class DeleteDiscreteCommand(@TargetAggregateIdentifier  var discreteId: UUID? = null)

// single association commands

// multiple association commands


// DiscreteValue Commands
data class CreateDiscreteValueCommand(
    @TargetAggregateIdentifier var discreteValueId: UUID? = null,
    var value: String
)

data class UpdateDiscreteValueCommand(
    @TargetAggregateIdentifier var discreteValueId: UUID? = null,
    var value: String
)

data class DeleteDiscreteValueCommand(@TargetAggregateIdentifier  var discreteValueId: UUID? = null)

// single association commands

// multiple association commands


// DomainVersion Commands
data class CreateDomainVersionCommand(
    @TargetAggregateIdentifier var domainVersionId: UUID? = null,
    var baseUML: String,
    var date: String,
    var entsoeUML: String,
    var version: String
)

data class UpdateDomainVersionCommand(
    @TargetAggregateIdentifier var domainVersionId: UUID? = null,
    var baseUML: String,
    var date: String,
    var entsoeUML: String,
    var version: String
)

data class DeleteDomainVersionCommand(@TargetAggregateIdentifier  var domainVersionId: UUID? = null)

// single association commands

// multiple association commands


// DynamicsFunctionBlock Commands
data class CreateDynamicsFunctionBlockCommand(
    @TargetAggregateIdentifier var dynamicsFunctionBlockId: UUID? = null,
    var enabled: String
)

data class UpdateDynamicsFunctionBlockCommand(
    @TargetAggregateIdentifier var dynamicsFunctionBlockId: UUID? = null,
    var enabled: String
)

data class DeleteDynamicsFunctionBlockCommand(@TargetAggregateIdentifier  var dynamicsFunctionBlockId: UUID? = null)

// single association commands

// multiple association commands


// DynamicsVersion Commands
data class CreateDynamicsVersionCommand(
    @TargetAggregateIdentifier var dynamicsVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class UpdateDynamicsVersionCommand(
    @TargetAggregateIdentifier var dynamicsVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class DeleteDynamicsVersionCommand(@TargetAggregateIdentifier  var dynamicsVersionId: UUID? = null)

// single association commands

// multiple association commands


// Dynamicsmodel Commands
data class CreateDynamicsmodelCommand(
    @TargetAggregateIdentifier  var dynamicsmodelId: UUID? = null
)

data class UpdateDynamicsmodelCommand(
    @TargetAggregateIdentifier  var dynamicsmodelId: UUID? = null
)

data class DeleteDynamicsmodelCommand(@TargetAggregateIdentifier  var dynamicsmodelId: UUID? = null)

// single association commands

// multiple association commands


// ENTSOEConnectivityNode Commands
data class CreateENTSOEConnectivityNodeCommand(
    @TargetAggregateIdentifier  var eNTSOEConnectivityNodeId: UUID? = null
)

data class UpdateENTSOEConnectivityNodeCommand(
    @TargetAggregateIdentifier  var eNTSOEConnectivityNodeId: UUID? = null
)

data class DeleteENTSOEConnectivityNodeCommand(@TargetAggregateIdentifier  var eNTSOEConnectivityNodeId: UUID? = null)

// single association commands

// multiple association commands


// ENTSOEIdentifiedObject Commands
data class CreateENTSOEIdentifiedObjectCommand(
    @TargetAggregateIdentifier var eNTSOEIdentifiedObjectId: UUID? = null,
    var energyIdentCodeEic: String,
    var shortName: String
)

data class UpdateENTSOEIdentifiedObjectCommand(
    @TargetAggregateIdentifier var eNTSOEIdentifiedObjectId: UUID? = null,
    var energyIdentCodeEic: String,
    var shortName: String
)

data class DeleteENTSOEIdentifiedObjectCommand(@TargetAggregateIdentifier  var eNTSOEIdentifiedObjectId: UUID? = null)

// single association commands

// multiple association commands


// ENTSOEJunction Commands
data class CreateENTSOEJunctionCommand(
    @TargetAggregateIdentifier  var eNTSOEJunctionId: UUID? = null
)

data class UpdateENTSOEJunctionCommand(
    @TargetAggregateIdentifier  var eNTSOEJunctionId: UUID? = null
)

data class DeleteENTSOEJunctionCommand(@TargetAggregateIdentifier  var eNTSOEJunctionId: UUID? = null)

// single association commands

// multiple association commands


// ENTSOEOperationalLimitType Commands
data class CreateENTSOEOperationalLimitTypeCommand(
    @TargetAggregateIdentifier var eNTSOEOperationalLimitTypeId: UUID? = null,
    var limitType: String
)

data class UpdateENTSOEOperationalLimitTypeCommand(
    @TargetAggregateIdentifier var eNTSOEOperationalLimitTypeId: UUID? = null,
    var limitType: String
)

data class DeleteENTSOEOperationalLimitTypeCommand(@TargetAggregateIdentifier  var eNTSOEOperationalLimitTypeId: UUID? = null)

// single association commands

// multiple association commands


// ENTSOETopologicalNode Commands
data class CreateENTSOETopologicalNodeCommand(
    @TargetAggregateIdentifier  var eNTSOETopologicalNodeId: UUID? = null
)

data class UpdateENTSOETopologicalNodeCommand(
    @TargetAggregateIdentifier  var eNTSOETopologicalNodeId: UUID? = null
)

data class DeleteENTSOETopologicalNodeCommand(@TargetAggregateIdentifier  var eNTSOETopologicalNodeId: UUID? = null)

// single association commands

// multiple association commands


// EarthFaultCompensator Commands
data class CreateEarthFaultCompensatorCommand(
    @TargetAggregateIdentifier var earthFaultCompensatorId: UUID? = null,
    var r: String
)

data class UpdateEarthFaultCompensatorCommand(
    @TargetAggregateIdentifier var earthFaultCompensatorId: UUID? = null,
    var r: String
)

data class DeleteEarthFaultCompensatorCommand(@TargetAggregateIdentifier  var earthFaultCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// EnergyArea Commands
data class CreateEnergyAreaCommand(
    @TargetAggregateIdentifier  var energyAreaId: UUID? = null
)

data class UpdateEnergyAreaCommand(
    @TargetAggregateIdentifier  var energyAreaId: UUID? = null
)

data class DeleteEnergyAreaCommand(@TargetAggregateIdentifier  var energyAreaId: UUID? = null)

// single association commands

// multiple association commands


// EnergyConsumer Commands
data class CreateEnergyConsumerCommand(
    @TargetAggregateIdentifier var energyConsumerId: UUID? = null,
    var pfixed: String,
    var pfixedPct: String,
    var qfixed: String,
    var qfixedPct: String
)

data class UpdateEnergyConsumerCommand(
    @TargetAggregateIdentifier var energyConsumerId: UUID? = null,
    var pfixed: String,
    var pfixedPct: String,
    var qfixed: String,
    var qfixedPct: String
)

data class DeleteEnergyConsumerCommand(@TargetAggregateIdentifier  var energyConsumerId: UUID? = null)

// single association commands

// multiple association commands


// EnergySchedulingType Commands
data class CreateEnergySchedulingTypeCommand(
    @TargetAggregateIdentifier  var energySchedulingTypeId: UUID? = null
)

data class UpdateEnergySchedulingTypeCommand(
    @TargetAggregateIdentifier  var energySchedulingTypeId: UUID? = null
)

data class DeleteEnergySchedulingTypeCommand(@TargetAggregateIdentifier  var energySchedulingTypeId: UUID? = null)

// single association commands

// multiple association commands


// EnergySource Commands
data class CreateEnergySourceCommand(
    @TargetAggregateIdentifier  var energySourceId: UUID? = null
)

data class UpdateEnergySourceCommand(
    @TargetAggregateIdentifier  var energySourceId: UUID? = null
)

data class DeleteEnergySourceCommand(@TargetAggregateIdentifier  var energySourceId: UUID? = null)

// single association commands

// multiple association commands


// Equipment Commands
data class CreateEquipmentCommand(
    @TargetAggregateIdentifier  var equipmentId: UUID? = null
)

data class UpdateEquipmentCommand(
    @TargetAggregateIdentifier  var equipmentId: UUID? = null
)

data class DeleteEquipmentCommand(@TargetAggregateIdentifier  var equipmentId: UUID? = null)

// single association commands

// multiple association commands


// EquipmentBoundaryVersion Commands
data class CreateEquipmentBoundaryVersionCommand(
    @TargetAggregateIdentifier var equipmentBoundaryVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURIcore: String,
    var entsoeURIoperation: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class UpdateEquipmentBoundaryVersionCommand(
    @TargetAggregateIdentifier var equipmentBoundaryVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURIcore: String,
    var entsoeURIoperation: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class DeleteEquipmentBoundaryVersionCommand(@TargetAggregateIdentifier  var equipmentBoundaryVersionId: UUID? = null)

// single association commands

// multiple association commands


// EquipmentContainer Commands
data class CreateEquipmentContainerCommand(
    @TargetAggregateIdentifier  var equipmentContainerId: UUID? = null
)

data class UpdateEquipmentContainerCommand(
    @TargetAggregateIdentifier  var equipmentContainerId: UUID? = null
)

data class DeleteEquipmentContainerCommand(@TargetAggregateIdentifier  var equipmentContainerId: UUID? = null)

// single association commands

// multiple association commands


// EquipmentVersion Commands
data class CreateEquipmentVersionCommand(
    @TargetAggregateIdentifier var equipmentVersionId: UUID? = null,
    var baseUML: String,
    var baseURIcore: String,
    var baseURIoperation: String,
    var baseURIshortCircuit: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURIcore: String,
    var entsoeURIoperation: String,
    var entsoeURIshortCircuit: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class UpdateEquipmentVersionCommand(
    @TargetAggregateIdentifier var equipmentVersionId: UUID? = null,
    var baseUML: String,
    var baseURIcore: String,
    var baseURIoperation: String,
    var baseURIshortCircuit: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURIcore: String,
    var entsoeURIoperation: String,
    var entsoeURIshortCircuit: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class DeleteEquipmentVersionCommand(@TargetAggregateIdentifier  var equipmentVersionId: UUID? = null)

// single association commands

// multiple association commands


// EquivalentBranch Commands
data class CreateEquivalentBranchCommand(
    @TargetAggregateIdentifier var equivalentBranchId: UUID? = null,
    var negativeR12: String,
    var negativeR21: String,
    var negativeX12: String,
    var negativeX21: String,
    var positiveR12: String,
    var positiveR21: String,
    var positiveX12: String,
    var positiveX21: String,
    var r: String,
    var r21: String,
    var x: String,
    var x21: String,
    var zeroR12: String,
    var zeroR21: String,
    var zeroX12: String,
    var zeroX21: String
)

data class UpdateEquivalentBranchCommand(
    @TargetAggregateIdentifier var equivalentBranchId: UUID? = null,
    var negativeR12: String,
    var negativeR21: String,
    var negativeX12: String,
    var negativeX21: String,
    var positiveR12: String,
    var positiveR21: String,
    var positiveX12: String,
    var positiveX21: String,
    var r: String,
    var r21: String,
    var x: String,
    var x21: String,
    var zeroR12: String,
    var zeroR21: String,
    var zeroX12: String,
    var zeroX21: String
)

data class DeleteEquivalentBranchCommand(@TargetAggregateIdentifier  var equivalentBranchId: UUID? = null)

// single association commands

// multiple association commands


// EquivalentEquipment Commands
data class CreateEquivalentEquipmentCommand(
    @TargetAggregateIdentifier  var equivalentEquipmentId: UUID? = null
)

data class UpdateEquivalentEquipmentCommand(
    @TargetAggregateIdentifier  var equivalentEquipmentId: UUID? = null
)

data class DeleteEquivalentEquipmentCommand(@TargetAggregateIdentifier  var equivalentEquipmentId: UUID? = null)

// single association commands

// multiple association commands


// EquivalentInjection Commands
data class CreateEquivalentInjectionCommand(
    @TargetAggregateIdentifier var equivalentInjectionId: UUID? = null,
    var maxP: String,
    var maxQ: String,
    var minP: String,
    var minQ: String,
    var r: String,
    var r0: String,
    var r2: String,
    var regulationCapability: String,
    var x: String,
    var x0: String,
    var x2: String
)

data class UpdateEquivalentInjectionCommand(
    @TargetAggregateIdentifier var equivalentInjectionId: UUID? = null,
    var maxP: String,
    var maxQ: String,
    var minP: String,
    var minQ: String,
    var r: String,
    var r0: String,
    var r2: String,
    var regulationCapability: String,
    var x: String,
    var x0: String,
    var x2: String
)

data class DeleteEquivalentInjectionCommand(@TargetAggregateIdentifier  var equivalentInjectionId: UUID? = null)

// single association commands

// multiple association commands


// EquivalentNetwork Commands
data class CreateEquivalentNetworkCommand(
    @TargetAggregateIdentifier  var equivalentNetworkId: UUID? = null
)

data class UpdateEquivalentNetworkCommand(
    @TargetAggregateIdentifier  var equivalentNetworkId: UUID? = null
)

data class DeleteEquivalentNetworkCommand(@TargetAggregateIdentifier  var equivalentNetworkId: UUID? = null)

// single association commands

// multiple association commands


// EquivalentShunt Commands
data class CreateEquivalentShuntCommand(
    @TargetAggregateIdentifier var equivalentShuntId: UUID? = null,
    var b: String,
    var g: String
)

data class UpdateEquivalentShuntCommand(
    @TargetAggregateIdentifier var equivalentShuntId: UUID? = null,
    var b: String,
    var g: String
)

data class DeleteEquivalentShuntCommand(@TargetAggregateIdentifier  var equivalentShuntId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC1A Commands
data class CreateExcAC1ACommand(
    @TargetAggregateIdentifier var excAC1AId: UUID? = null,
    var hvlvgates: String,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var kf1: String,
    var kf2: String,
    var ks: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcAC1ACommand(
    @TargetAggregateIdentifier var excAC1AId: UUID? = null,
    var hvlvgates: String,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var kf1: String,
    var kf2: String,
    var ks: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcAC1ACommand(@TargetAggregateIdentifier  var excAC1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC2A Commands
data class CreateExcAC2ACommand(
    @TargetAggregateIdentifier var excAC2AId: UUID? = null,
    var hvgate: String,
    var ka: String,
    var kb: String,
    var kb1: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var kh: String,
    var kl: String,
    var kl1: String,
    var ks: String,
    var lvgate: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vfemax: String,
    var vlr: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcAC2ACommand(
    @TargetAggregateIdentifier var excAC2AId: UUID? = null,
    var hvgate: String,
    var ka: String,
    var kb: String,
    var kb1: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var kh: String,
    var kl: String,
    var kl1: String,
    var ks: String,
    var lvgate: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vfemax: String,
    var vlr: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcAC2ACommand(@TargetAggregateIdentifier  var excAC2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC3A Commands
data class CreateExcAC3ACommand(
    @TargetAggregateIdentifier var excAC3AId: UUID? = null,
    var efdn: String,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var kf1: String,
    var kf2: String,
    var klv: String,
    var kn: String,
    var kr: String,
    var ks: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vemin: String,
    var vfemax: String,
    var vlv: String
)

data class UpdateExcAC3ACommand(
    @TargetAggregateIdentifier var excAC3AId: UUID? = null,
    var efdn: String,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var kf1: String,
    var kf2: String,
    var klv: String,
    var kn: String,
    var kr: String,
    var ks: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vemin: String,
    var vfemax: String,
    var vlv: String
)

data class DeleteExcAC3ACommand(@TargetAggregateIdentifier  var excAC3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC4A Commands
data class CreateExcAC4ACommand(
    @TargetAggregateIdentifier var excAC4AId: UUID? = null,
    var ka: String,
    var kc: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var vimax: String,
    var vimin: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcAC4ACommand(
    @TargetAggregateIdentifier var excAC4AId: UUID? = null,
    var ka: String,
    var kc: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var vimax: String,
    var vimin: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcAC4ACommand(@TargetAggregateIdentifier  var excAC4AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC5A Commands
data class CreateExcAC5ACommand(
    @TargetAggregateIdentifier var excAC5AId: UUID? = null,
    var a: String,
    var efd1: String,
    var efd2: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var ks: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf1: String,
    var tf2: String,
    var tf3: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcAC5ACommand(
    @TargetAggregateIdentifier var excAC5AId: UUID? = null,
    var a: String,
    var efd1: String,
    var efd2: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var ks: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf1: String,
    var tf2: String,
    var tf3: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcAC5ACommand(@TargetAggregateIdentifier  var excAC5AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC6A Commands
data class CreateExcAC6ACommand(
    @TargetAggregateIdentifier var excAC6AId: UUID? = null,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kh: String,
    var ks: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var th: String,
    var tj: String,
    var tk: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vfelim: String,
    var vhmax: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcAC6ACommand(
    @TargetAggregateIdentifier var excAC6AId: UUID? = null,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kh: String,
    var ks: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var th: String,
    var tj: String,
    var tk: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vfelim: String,
    var vhmax: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcAC6ACommand(@TargetAggregateIdentifier  var excAC6AId: UUID? = null)

// single association commands

// multiple association commands


// ExcAC8B Commands
data class CreateExcAC8BCommand(
    @TargetAggregateIdentifier var excAC8BId: UUID? = null,
    var inlim: String,
    var ka: String,
    var kc: String,
    var kd: String,
    var kdr: String,
    var ke: String,
    var kir: String,
    var kpr: String,
    var ks: String,
    var pidlim: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tdr: String,
    var te: String,
    var telim: String,
    var ve1: String,
    var ve2: String,
    var vemin: String,
    var vfemax: String,
    var vimax: String,
    var vimin: String,
    var vpidmax: String,
    var vpidmin: String,
    var vrmax: String,
    var vrmin: String,
    var vtmult: String
)

data class UpdateExcAC8BCommand(
    @TargetAggregateIdentifier var excAC8BId: UUID? = null,
    var inlim: String,
    var ka: String,
    var kc: String,
    var kd: String,
    var kdr: String,
    var ke: String,
    var kir: String,
    var kpr: String,
    var ks: String,
    var pidlim: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tdr: String,
    var te: String,
    var telim: String,
    var ve1: String,
    var ve2: String,
    var vemin: String,
    var vfemax: String,
    var vimax: String,
    var vimin: String,
    var vpidmax: String,
    var vpidmin: String,
    var vrmax: String,
    var vrmin: String,
    var vtmult: String
)

data class DeleteExcAC8BCommand(@TargetAggregateIdentifier  var excAC8BId: UUID? = null)

// single association commands

// multiple association commands


// ExcANS Commands
data class CreateExcANSCommand(
    @TargetAggregateIdentifier var excANSId: UUID? = null,
    var blint: String,
    var ifmn: String,
    var ifmx: String,
    var k2: String,
    var k3: String,
    var kce: String,
    var krvecc: String,
    var kvfif: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var tb: String,
    var vrmn: String,
    var vrmx: String
)

data class UpdateExcANSCommand(
    @TargetAggregateIdentifier var excANSId: UUID? = null,
    var blint: String,
    var ifmn: String,
    var ifmx: String,
    var k2: String,
    var k3: String,
    var kce: String,
    var krvecc: String,
    var kvfif: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var tb: String,
    var vrmn: String,
    var vrmx: String
)

data class DeleteExcANSCommand(@TargetAggregateIdentifier  var excANSId: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR1 Commands
data class CreateExcAVR1Command(
    @TargetAggregateIdentifier var excAVR1Id: UUID? = null,
    var e1: String,
    var e2: String,
    var ka: String,
    var kf: String,
    var se1: String,
    var se2: String,
    var ta: String,
    var tb: String,
    var te: String,
    var tf: String,
    var vrmn: String,
    var vrmx: String
)

data class UpdateExcAVR1Command(
    @TargetAggregateIdentifier var excAVR1Id: UUID? = null,
    var e1: String,
    var e2: String,
    var ka: String,
    var kf: String,
    var se1: String,
    var se2: String,
    var ta: String,
    var tb: String,
    var te: String,
    var tf: String,
    var vrmn: String,
    var vrmx: String
)

data class DeleteExcAVR1Command(@TargetAggregateIdentifier  var excAVR1Id: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR2 Commands
data class CreateExcAVR2Command(
    @TargetAggregateIdentifier var excAVR2Id: UUID? = null,
    var e1: String,
    var e2: String,
    var ka: String,
    var kf: String,
    var se1: String,
    var se2: String,
    var ta: String,
    var tb: String,
    var te: String,
    var tf1: String,
    var tf2: String,
    var vrmn: String,
    var vrmx: String
)

data class UpdateExcAVR2Command(
    @TargetAggregateIdentifier var excAVR2Id: UUID? = null,
    var e1: String,
    var e2: String,
    var ka: String,
    var kf: String,
    var se1: String,
    var se2: String,
    var ta: String,
    var tb: String,
    var te: String,
    var tf1: String,
    var tf2: String,
    var vrmn: String,
    var vrmx: String
)

data class DeleteExcAVR2Command(@TargetAggregateIdentifier  var excAVR2Id: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR3 Commands
data class CreateExcAVR3Command(
    @TargetAggregateIdentifier var excAVR3Id: UUID? = null,
    var e1: String,
    var e2: String,
    var ka: String,
    var se1: String,
    var se2: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var te: String,
    var vrmn: String,
    var vrmx: String
)

data class UpdateExcAVR3Command(
    @TargetAggregateIdentifier var excAVR3Id: UUID? = null,
    var e1: String,
    var e2: String,
    var ka: String,
    var se1: String,
    var se2: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var te: String,
    var vrmn: String,
    var vrmx: String
)

data class DeleteExcAVR3Command(@TargetAggregateIdentifier  var excAVR3Id: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR4 Commands
data class CreateExcAVR4Command(
    @TargetAggregateIdentifier var excAVR4Id: UUID? = null,
    var imul: String,
    var ka: String,
    var ke: String,
    var kif: String,
    var t1: String,
    var t1if: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var tif: String,
    var vfmn: String,
    var vfmx: String,
    var vrmn: String,
    var vrmx: String
)

data class UpdateExcAVR4Command(
    @TargetAggregateIdentifier var excAVR4Id: UUID? = null,
    var imul: String,
    var ka: String,
    var ke: String,
    var kif: String,
    var t1: String,
    var t1if: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var tif: String,
    var vfmn: String,
    var vfmx: String,
    var vrmn: String,
    var vrmx: String
)

data class DeleteExcAVR4Command(@TargetAggregateIdentifier  var excAVR4Id: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR5 Commands
data class CreateExcAVR5Command(
    @TargetAggregateIdentifier var excAVR5Id: UUID? = null,
    var ka: String,
    var rex: String,
    var ta: String
)

data class UpdateExcAVR5Command(
    @TargetAggregateIdentifier var excAVR5Id: UUID? = null,
    var ka: String,
    var rex: String,
    var ta: String
)

data class DeleteExcAVR5Command(@TargetAggregateIdentifier  var excAVR5Id: UUID? = null)

// single association commands

// multiple association commands


// ExcAVR7 Commands
data class CreateExcAVR7Command(
    @TargetAggregateIdentifier var excAVR7Id: UUID? = null,
    var a1: String,
    var a2: String,
    var a3: String,
    var a4: String,
    var a5: String,
    var a6: String,
    var k1: String,
    var k3: String,
    var k5: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var vmax1: String,
    var vmax3: String,
    var vmax5: String,
    var vmin1: String,
    var vmin3: String,
    var vmin5: String
)

data class UpdateExcAVR7Command(
    @TargetAggregateIdentifier var excAVR7Id: UUID? = null,
    var a1: String,
    var a2: String,
    var a3: String,
    var a4: String,
    var a5: String,
    var a6: String,
    var k1: String,
    var k3: String,
    var k5: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var vmax1: String,
    var vmax3: String,
    var vmax5: String,
    var vmin1: String,
    var vmin3: String,
    var vmin5: String
)

data class DeleteExcAVR7Command(@TargetAggregateIdentifier  var excAVR7Id: UUID? = null)

// single association commands

// multiple association commands


// ExcBBC Commands
data class CreateExcBBCCommand(
    @TargetAggregateIdentifier var excBBCId: UUID? = null,
    var efdmax: String,
    var efdmin: String,
    var k: String,
    var switchIt: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var vrmax: String,
    var vrmin: String,
    var xe: String
)

data class UpdateExcBBCCommand(
    @TargetAggregateIdentifier var excBBCId: UUID? = null,
    var efdmax: String,
    var efdmin: String,
    var k: String,
    var switchIt: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var vrmax: String,
    var vrmin: String,
    var xe: String
)

data class DeleteExcBBCCommand(@TargetAggregateIdentifier  var excBBCId: UUID? = null)

// single association commands

// multiple association commands


// ExcCZ Commands
data class CreateExcCZCommand(
    @TargetAggregateIdentifier var excCZId: UUID? = null,
    var efdmax: String,
    var efdmin: String,
    var ka: String,
    var ke: String,
    var kp: String,
    var ta: String,
    var tc: String,
    var te: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcCZCommand(
    @TargetAggregateIdentifier var excCZId: UUID? = null,
    var efdmax: String,
    var efdmin: String,
    var ka: String,
    var ke: String,
    var kp: String,
    var ta: String,
    var tc: String,
    var te: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcCZCommand(@TargetAggregateIdentifier  var excCZId: UUID? = null)

// single association commands

// multiple association commands


// ExcDC1A Commands
data class CreateExcDC1ACommand(
    @TargetAggregateIdentifier var excDC1AId: UUID? = null,
    var edfmax: String,
    var efd1: String,
    var efd2: String,
    var efdmin: String,
    var exclim: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var ks: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcDC1ACommand(
    @TargetAggregateIdentifier var excDC1AId: UUID? = null,
    var edfmax: String,
    var efd1: String,
    var efd2: String,
    var efdmin: String,
    var exclim: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var ks: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcDC1ACommand(@TargetAggregateIdentifier  var excDC1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcDC2A Commands
data class CreateExcDC2ACommand(
    @TargetAggregateIdentifier var excDC2AId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var exclim: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var ks: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var tf1: String,
    var vrmax: String,
    var vrmin: String,
    var vtlim: String
)

data class UpdateExcDC2ACommand(
    @TargetAggregateIdentifier var excDC2AId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var exclim: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var ks: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var tf1: String,
    var vrmax: String,
    var vrmin: String,
    var vtlim: String
)

data class DeleteExcDC2ACommand(@TargetAggregateIdentifier  var excDC2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcDC3A Commands
data class CreateExcDC3ACommand(
    @TargetAggregateIdentifier var excDC3AId: UUID? = null,
    var edfmax: String,
    var efd1: String,
    var efd2: String,
    var efdlim: String,
    var efdmin: String,
    var exclim: String,
    var ke: String,
    var kr: String,
    var ks: String,
    var kv: String,
    var seefd1: String,
    var seefd2: String,
    var te: String,
    var trh: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcDC3ACommand(
    @TargetAggregateIdentifier var excDC3AId: UUID? = null,
    var edfmax: String,
    var efd1: String,
    var efd2: String,
    var efdlim: String,
    var efdmin: String,
    var exclim: String,
    var ke: String,
    var kr: String,
    var ks: String,
    var kv: String,
    var seefd1: String,
    var seefd2: String,
    var te: String,
    var trh: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcDC3ACommand(@TargetAggregateIdentifier  var excDC3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcDC3A1 Commands
data class CreateExcDC3A1Command(
    @TargetAggregateIdentifier var excDC3A1Id: UUID? = null,
    var exclim: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var ta: String,
    var te: String,
    var tf: String,
    var vb1max: String,
    var vblim: String,
    var vbmax: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcDC3A1Command(
    @TargetAggregateIdentifier var excDC3A1Id: UUID? = null,
    var exclim: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var ta: String,
    var te: String,
    var tf: String,
    var vb1max: String,
    var vblim: String,
    var vbmax: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcDC3A1Command(@TargetAggregateIdentifier  var excDC3A1Id: UUID? = null)

// single association commands

// multiple association commands


// ExcELIN1 Commands
data class CreateExcELIN1Command(
    @TargetAggregateIdentifier var excELIN1Id: UUID? = null,
    var dpnf: String,
    var efmax: String,
    var efmin: String,
    var ks1: String,
    var ks2: String,
    var smax: String,
    var tfi: String,
    var tnu: String,
    var ts1: String,
    var ts2: String,
    var tsw: String,
    var vpi: String,
    var vpnf: String,
    var vpu: String,
    var xe: String
)

data class UpdateExcELIN1Command(
    @TargetAggregateIdentifier var excELIN1Id: UUID? = null,
    var dpnf: String,
    var efmax: String,
    var efmin: String,
    var ks1: String,
    var ks2: String,
    var smax: String,
    var tfi: String,
    var tnu: String,
    var ts1: String,
    var ts2: String,
    var tsw: String,
    var vpi: String,
    var vpnf: String,
    var vpu: String,
    var xe: String
)

data class DeleteExcELIN1Command(@TargetAggregateIdentifier  var excELIN1Id: UUID? = null)

// single association commands

// multiple association commands


// ExcELIN2 Commands
data class CreateExcELIN2Command(
    @TargetAggregateIdentifier var excELIN2Id: UUID? = null,
    var efdbas: String,
    var iefmax: String,
    var iefmax2: String,
    var iefmin: String,
    var k1: String,
    var k1ec: String,
    var k2: String,
    var k3: String,
    var k4: String,
    var kd1: String,
    var ke2: String,
    var ketb: String,
    var pid1max: String,
    var seve1: String,
    var seve2: String,
    var tb1: String,
    var te: String,
    var te2: String,
    var ti1: String,
    var ti3: String,
    var ti4: String,
    var tr4: String,
    var upmax: String,
    var upmin: String,
    var ve1: String,
    var ve2: String,
    var xp: String
)

data class UpdateExcELIN2Command(
    @TargetAggregateIdentifier var excELIN2Id: UUID? = null,
    var efdbas: String,
    var iefmax: String,
    var iefmax2: String,
    var iefmin: String,
    var k1: String,
    var k1ec: String,
    var k2: String,
    var k3: String,
    var k4: String,
    var kd1: String,
    var ke2: String,
    var ketb: String,
    var pid1max: String,
    var seve1: String,
    var seve2: String,
    var tb1: String,
    var te: String,
    var te2: String,
    var ti1: String,
    var ti3: String,
    var ti4: String,
    var tr4: String,
    var upmax: String,
    var upmin: String,
    var ve1: String,
    var ve2: String,
    var xp: String
)

data class DeleteExcELIN2Command(@TargetAggregateIdentifier  var excELIN2Id: UUID? = null)

// single association commands

// multiple association commands


// ExcHU Commands
data class CreateExcHUCommand(
    @TargetAggregateIdentifier var excHUId: UUID? = null,
    var ae: String,
    var ai: String,
    var atr: String,
    var emax: String,
    var emin: String,
    var imax: String,
    var imin: String,
    var ke: String,
    var ki: String,
    var te: String,
    var ti: String,
    var tr: String
)

data class UpdateExcHUCommand(
    @TargetAggregateIdentifier var excHUId: UUID? = null,
    var ae: String,
    var ai: String,
    var atr: String,
    var emax: String,
    var emin: String,
    var imax: String,
    var imin: String,
    var ke: String,
    var ki: String,
    var te: String,
    var ti: String,
    var tr: String
)

data class DeleteExcHUCommand(@TargetAggregateIdentifier  var excHUId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC1A Commands
data class CreateExcIEEEAC1ACommand(
    @TargetAggregateIdentifier var excIEEEAC1AId: UUID? = null,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEAC1ACommand(
    @TargetAggregateIdentifier var excIEEEAC1AId: UUID? = null,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEAC1ACommand(@TargetAggregateIdentifier  var excIEEEAC1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC2A Commands
data class CreateExcIEEEAC2ACommand(
    @TargetAggregateIdentifier var excIEEEAC2AId: UUID? = null,
    var ka: String,
    var kb: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var kh: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vfemax: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEAC2ACommand(
    @TargetAggregateIdentifier var excIEEEAC2AId: UUID? = null,
    var ka: String,
    var kb: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var kh: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vfemax: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEAC2ACommand(@TargetAggregateIdentifier  var excIEEEAC2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC3A Commands
data class CreateExcIEEEAC3ACommand(
    @TargetAggregateIdentifier var excIEEEAC3AId: UUID? = null,
    var efdn: String,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var kn: String,
    var kr: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vemin: String,
    var vfemax: String
)

data class UpdateExcIEEEAC3ACommand(
    @TargetAggregateIdentifier var excIEEEAC3AId: UUID? = null,
    var efdn: String,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var kn: String,
    var kr: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vemin: String,
    var vfemax: String
)

data class DeleteExcIEEEAC3ACommand(@TargetAggregateIdentifier  var excIEEEAC3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC4A Commands
data class CreateExcIEEEAC4ACommand(
    @TargetAggregateIdentifier var excIEEEAC4AId: UUID? = null,
    var ka: String,
    var kc: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var vimax: String,
    var vimin: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEAC4ACommand(
    @TargetAggregateIdentifier var excIEEEAC4AId: UUID? = null,
    var ka: String,
    var kc: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var vimax: String,
    var vimin: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEAC4ACommand(@TargetAggregateIdentifier  var excIEEEAC4AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC5A Commands
data class CreateExcIEEEAC5ACommand(
    @TargetAggregateIdentifier var excIEEEAC5AId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var te: String,
    var tf1: String,
    var tf2: String,
    var tf3: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEAC5ACommand(
    @TargetAggregateIdentifier var excIEEEAC5AId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var te: String,
    var tf1: String,
    var tf2: String,
    var tf3: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEAC5ACommand(@TargetAggregateIdentifier  var excIEEEAC5AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC6A Commands
data class CreateExcIEEEAC6ACommand(
    @TargetAggregateIdentifier var excIEEEAC6AId: UUID? = null,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kh: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var th: String,
    var tj: String,
    var tk: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vfelim: String,
    var vhmax: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEAC6ACommand(
    @TargetAggregateIdentifier var excIEEEAC6AId: UUID? = null,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kh: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var th: String,
    var tj: String,
    var tk: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vfelim: String,
    var vhmax: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEAC6ACommand(@TargetAggregateIdentifier  var excIEEEAC6AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC7B Commands
data class CreateExcIEEEAC7BCommand(
    @TargetAggregateIdentifier var excIEEEAC7BId: UUID? = null,
    var kc: String,
    var kd: String,
    var kdr: String,
    var ke: String,
    var kf1: String,
    var kf2: String,
    var kf3: String,
    var kia: String,
    var kir: String,
    var kl: String,
    var kp: String,
    var kpa: String,
    var kpr: String,
    var seve1: String,
    var seve2: String,
    var tdr: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vemin: String,
    var vfemax: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEAC7BCommand(
    @TargetAggregateIdentifier var excIEEEAC7BId: UUID? = null,
    var kc: String,
    var kd: String,
    var kdr: String,
    var ke: String,
    var kf1: String,
    var kf2: String,
    var kf3: String,
    var kia: String,
    var kir: String,
    var kl: String,
    var kp: String,
    var kpa: String,
    var kpr: String,
    var seve1: String,
    var seve2: String,
    var tdr: String,
    var te: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var ve1: String,
    var ve2: String,
    var vemin: String,
    var vfemax: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEAC7BCommand(@TargetAggregateIdentifier  var excIEEEAC7BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEAC8B Commands
data class CreateExcIEEEAC8BCommand(
    @TargetAggregateIdentifier var excIEEEAC8BId: UUID? = null,
    var ka: String,
    var kc: String,
    var kd: String,
    var kdr: String,
    var ke: String,
    var kir: String,
    var kpr: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tdr: String,
    var te: String,
    var ve1: String,
    var ve2: String,
    var vemin: String,
    var vfemax: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEAC8BCommand(
    @TargetAggregateIdentifier var excIEEEAC8BId: UUID? = null,
    var ka: String,
    var kc: String,
    var kd: String,
    var kdr: String,
    var ke: String,
    var kir: String,
    var kpr: String,
    var seve1: String,
    var seve2: String,
    var ta: String,
    var tdr: String,
    var te: String,
    var ve1: String,
    var ve2: String,
    var vemin: String,
    var vfemax: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEAC8BCommand(@TargetAggregateIdentifier  var excIEEEAC8BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEDC1A Commands
data class CreateExcIEEEDC1ACommand(
    @TargetAggregateIdentifier var excIEEEDC1AId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var exclim: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var uelin: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEDC1ACommand(
    @TargetAggregateIdentifier var excIEEEDC1AId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var exclim: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var uelin: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEDC1ACommand(@TargetAggregateIdentifier  var excIEEEDC1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEDC2A Commands
data class CreateExcIEEEDC2ACommand(
    @TargetAggregateIdentifier var excIEEEDC2AId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var exclim: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var uelin: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEDC2ACommand(
    @TargetAggregateIdentifier var excIEEEDC2AId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var exclim: String,
    var ka: String,
    var ke: String,
    var kf: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var uelin: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEDC2ACommand(@TargetAggregateIdentifier  var excIEEEDC2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEDC3A Commands
data class CreateExcIEEEDC3ACommand(
    @TargetAggregateIdentifier var excIEEEDC3AId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var exclim: String,
    var ke: String,
    var kv: String,
    var seefd1: String,
    var seefd2: String,
    var te: String,
    var trh: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEDC3ACommand(
    @TargetAggregateIdentifier var excIEEEDC3AId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var exclim: String,
    var ke: String,
    var kv: String,
    var seefd1: String,
    var seefd2: String,
    var te: String,
    var trh: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEDC3ACommand(@TargetAggregateIdentifier  var excIEEEDC3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEDC4B Commands
data class CreateExcIEEEDC4BCommand(
    @TargetAggregateIdentifier var excIEEEDC4BId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var ka: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var oelin: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var td: String,
    var te: String,
    var tf: String,
    var uelin: String,
    var vemin: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEDC4BCommand(
    @TargetAggregateIdentifier var excIEEEDC4BId: UUID? = null,
    var efd1: String,
    var efd2: String,
    var ka: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var oelin: String,
    var seefd1: String,
    var seefd2: String,
    var ta: String,
    var td: String,
    var te: String,
    var tf: String,
    var uelin: String,
    var vemin: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEDC4BCommand(@TargetAggregateIdentifier  var excIEEEDC4BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST1A Commands
data class CreateExcIEEEST1ACommand(
    @TargetAggregateIdentifier var excIEEEST1AId: UUID? = null,
    var ilr: String,
    var ka: String,
    var kc: String,
    var kf: String,
    var klr: String,
    var pssin: String,
    var ta: String,
    var tb: String,
    var tb1: String,
    var tc: String,
    var tc1: String,
    var tf: String,
    var uelin: String,
    var vamax: String,
    var vamin: String,
    var vimax: String,
    var vimin: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEST1ACommand(
    @TargetAggregateIdentifier var excIEEEST1AId: UUID? = null,
    var ilr: String,
    var ka: String,
    var kc: String,
    var kf: String,
    var klr: String,
    var pssin: String,
    var ta: String,
    var tb: String,
    var tb1: String,
    var tc: String,
    var tc1: String,
    var tf: String,
    var uelin: String,
    var vamax: String,
    var vamin: String,
    var vimax: String,
    var vimin: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEST1ACommand(@TargetAggregateIdentifier  var excIEEEST1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST2A Commands
data class CreateExcIEEEST2ACommand(
    @TargetAggregateIdentifier var excIEEEST2AId: UUID? = null,
    var efdmax: String,
    var ka: String,
    var kc: String,
    var ke: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var ta: String,
    var te: String,
    var tf: String,
    var uelin: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEST2ACommand(
    @TargetAggregateIdentifier var excIEEEST2AId: UUID? = null,
    var efdmax: String,
    var ka: String,
    var kc: String,
    var ke: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var ta: String,
    var te: String,
    var tf: String,
    var uelin: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEST2ACommand(@TargetAggregateIdentifier  var excIEEEST2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST3A Commands
data class CreateExcIEEEST3ACommand(
    @TargetAggregateIdentifier var excIEEEST3AId: UUID? = null,
    var ka: String,
    var kc: String,
    var kg: String,
    var ki: String,
    var km: String,
    var kp: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var thetap: String,
    var tm: String,
    var vbmax: String,
    var vgmax: String,
    var vimax: String,
    var vimin: String,
    var vmmax: String,
    var vmmin: String,
    var vrmax: String,
    var vrmin: String,
    var xl: String
)

data class UpdateExcIEEEST3ACommand(
    @TargetAggregateIdentifier var excIEEEST3AId: UUID? = null,
    var ka: String,
    var kc: String,
    var kg: String,
    var ki: String,
    var km: String,
    var kp: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var thetap: String,
    var tm: String,
    var vbmax: String,
    var vgmax: String,
    var vimax: String,
    var vimin: String,
    var vmmax: String,
    var vmmin: String,
    var vrmax: String,
    var vrmin: String,
    var xl: String
)

data class DeleteExcIEEEST3ACommand(@TargetAggregateIdentifier  var excIEEEST3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST4B Commands
data class CreateExcIEEEST4BCommand(
    @TargetAggregateIdentifier var excIEEEST4BId: UUID? = null,
    var kc: String,
    var kg: String,
    var ki: String,
    var kim: String,
    var kir: String,
    var kp: String,
    var kpm: String,
    var kpr: String,
    var ta: String,
    var thetap: String,
    var vbmax: String,
    var vmmax: String,
    var vmmin: String,
    var vrmax: String,
    var vrmin: String,
    var xl: String
)

data class UpdateExcIEEEST4BCommand(
    @TargetAggregateIdentifier var excIEEEST4BId: UUID? = null,
    var kc: String,
    var kg: String,
    var ki: String,
    var kim: String,
    var kir: String,
    var kp: String,
    var kpm: String,
    var kpr: String,
    var ta: String,
    var thetap: String,
    var vbmax: String,
    var vmmax: String,
    var vmmin: String,
    var vrmax: String,
    var vrmin: String,
    var xl: String
)

data class DeleteExcIEEEST4BCommand(@TargetAggregateIdentifier  var excIEEEST4BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST5B Commands
data class CreateExcIEEEST5BCommand(
    @TargetAggregateIdentifier var excIEEEST5BId: UUID? = null,
    var kc: String,
    var kr: String,
    var t1: String,
    var tb1: String,
    var tb2: String,
    var tc1: String,
    var tc2: String,
    var tob1: String,
    var tob2: String,
    var toc1: String,
    var toc2: String,
    var tub1: String,
    var tub2: String,
    var tuc1: String,
    var tuc2: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEST5BCommand(
    @TargetAggregateIdentifier var excIEEEST5BId: UUID? = null,
    var kc: String,
    var kr: String,
    var t1: String,
    var tb1: String,
    var tb2: String,
    var tc1: String,
    var tc2: String,
    var tob1: String,
    var tob2: String,
    var toc1: String,
    var toc2: String,
    var tub1: String,
    var tub2: String,
    var tuc1: String,
    var tuc2: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEST5BCommand(@TargetAggregateIdentifier  var excIEEEST5BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST6B Commands
data class CreateExcIEEEST6BCommand(
    @TargetAggregateIdentifier var excIEEEST6BId: UUID? = null,
    var ilr: String,
    var kci: String,
    var kff: String,
    var kg: String,
    var kia: String,
    var klr: String,
    var km: String,
    var kpa: String,
    var oelin: String,
    var tg: String,
    var vamax: String,
    var vamin: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEST6BCommand(
    @TargetAggregateIdentifier var excIEEEST6BId: UUID? = null,
    var ilr: String,
    var kci: String,
    var kff: String,
    var kg: String,
    var kia: String,
    var klr: String,
    var km: String,
    var kpa: String,
    var oelin: String,
    var tg: String,
    var vamax: String,
    var vamin: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEST6BCommand(@TargetAggregateIdentifier  var excIEEEST6BId: UUID? = null)

// single association commands

// multiple association commands


// ExcIEEEST7B Commands
data class CreateExcIEEEST7BCommand(
    @TargetAggregateIdentifier var excIEEEST7BId: UUID? = null,
    var kh: String,
    var kia: String,
    var kl: String,
    var kpa: String,
    var oelin: String,
    var tb: String,
    var tc: String,
    var tf: String,
    var tg: String,
    var tia: String,
    var uelin: String,
    var vmax: String,
    var vmin: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcIEEEST7BCommand(
    @TargetAggregateIdentifier var excIEEEST7BId: UUID? = null,
    var kh: String,
    var kia: String,
    var kl: String,
    var kpa: String,
    var oelin: String,
    var tb: String,
    var tc: String,
    var tf: String,
    var tg: String,
    var tia: String,
    var uelin: String,
    var vmax: String,
    var vmin: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcIEEEST7BCommand(@TargetAggregateIdentifier  var excIEEEST7BId: UUID? = null)

// single association commands

// multiple association commands


// ExcOEX3T Commands
data class CreateExcOEX3TCommand(
    @TargetAggregateIdentifier var excOEX3TId: UUID? = null,
    var e1: String,
    var e2: String,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var see1: String,
    var see2: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var te: String,
    var tf: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcOEX3TCommand(
    @TargetAggregateIdentifier var excOEX3TId: UUID? = null,
    var e1: String,
    var e2: String,
    var ka: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kf: String,
    var see1: String,
    var see2: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var te: String,
    var tf: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcOEX3TCommand(@TargetAggregateIdentifier  var excOEX3TId: UUID? = null)

// single association commands

// multiple association commands


// ExcPIC Commands
data class CreateExcPICCommand(
    @TargetAggregateIdentifier var excPICId: UUID? = null,
    var e1: String,
    var e2: String,
    var efdmax: String,
    var efdmin: String,
    var ka: String,
    var kc: String,
    var ke: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var se1: String,
    var se2: String,
    var ta1: String,
    var ta2: String,
    var ta3: String,
    var ta4: String,
    var te: String,
    var tf1: String,
    var tf2: String,
    var vr1: String,
    var vr2: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcPICCommand(
    @TargetAggregateIdentifier var excPICId: UUID? = null,
    var e1: String,
    var e2: String,
    var efdmax: String,
    var efdmin: String,
    var ka: String,
    var kc: String,
    var ke: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var se1: String,
    var se2: String,
    var ta1: String,
    var ta2: String,
    var ta3: String,
    var ta4: String,
    var te: String,
    var tf1: String,
    var tf2: String,
    var vr1: String,
    var vr2: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcPICCommand(@TargetAggregateIdentifier  var excPICId: UUID? = null)

// single association commands

// multiple association commands


// ExcREXS Commands
data class CreateExcREXSCommand(
    @TargetAggregateIdentifier var excREXSId: UUID? = null,
    var e1: String,
    var e2: String,
    var fbf: String,
    var flimf: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kefd: String,
    var kf: String,
    var kh: String,
    var kii: String,
    var kip: String,
    var ks: String,
    var kvi: String,
    var kvp: String,
    var kvphz: String,
    var nvphz: String,
    var se1: String,
    var se2: String,
    var ta: String,
    var tb1: String,
    var tb2: String,
    var tc1: String,
    var tc2: String,
    var te: String,
    var tf: String,
    var tf1: String,
    var tf2: String,
    var tp: String,
    var vcmax: String,
    var vfmax: String,
    var vfmin: String,
    var vimax: String,
    var vrmax: String,
    var vrmin: String,
    var xc: String
)

data class UpdateExcREXSCommand(
    @TargetAggregateIdentifier var excREXSId: UUID? = null,
    var e1: String,
    var e2: String,
    var fbf: String,
    var flimf: String,
    var kc: String,
    var kd: String,
    var ke: String,
    var kefd: String,
    var kf: String,
    var kh: String,
    var kii: String,
    var kip: String,
    var ks: String,
    var kvi: String,
    var kvp: String,
    var kvphz: String,
    var nvphz: String,
    var se1: String,
    var se2: String,
    var ta: String,
    var tb1: String,
    var tb2: String,
    var tc1: String,
    var tc2: String,
    var te: String,
    var tf: String,
    var tf1: String,
    var tf2: String,
    var tp: String,
    var vcmax: String,
    var vfmax: String,
    var vfmin: String,
    var vimax: String,
    var vrmax: String,
    var vrmin: String,
    var xc: String
)

data class DeleteExcREXSCommand(@TargetAggregateIdentifier  var excREXSId: UUID? = null)

// single association commands

// multiple association commands


// ExcSCRX Commands
data class CreateExcSCRXCommand(
    @TargetAggregateIdentifier var excSCRXId: UUID? = null,
    var cswitch: String,
    var emax: String,
    var emin: String,
    var k: String,
    var rcrfd: String,
    var tatb: String,
    var tb: String,
    var te: String
)

data class UpdateExcSCRXCommand(
    @TargetAggregateIdentifier var excSCRXId: UUID? = null,
    var cswitch: String,
    var emax: String,
    var emin: String,
    var k: String,
    var rcrfd: String,
    var tatb: String,
    var tb: String,
    var te: String
)

data class DeleteExcSCRXCommand(@TargetAggregateIdentifier  var excSCRXId: UUID? = null)

// single association commands

// multiple association commands


// ExcSEXS Commands
data class CreateExcSEXSCommand(
    @TargetAggregateIdentifier var excSEXSId: UUID? = null,
    var efdmax: String,
    var efdmin: String,
    var emax: String,
    var emin: String,
    var k: String,
    var kc: String,
    var tatb: String,
    var tb: String,
    var tc: String,
    var te: String
)

data class UpdateExcSEXSCommand(
    @TargetAggregateIdentifier var excSEXSId: UUID? = null,
    var efdmax: String,
    var efdmin: String,
    var emax: String,
    var emin: String,
    var k: String,
    var kc: String,
    var tatb: String,
    var tb: String,
    var tc: String,
    var te: String
)

data class DeleteExcSEXSCommand(@TargetAggregateIdentifier  var excSEXSId: UUID? = null)

// single association commands

// multiple association commands


// ExcSK Commands
data class CreateExcSKCommand(
    @TargetAggregateIdentifier var excSKId: UUID? = null,
    var efdmax: String,
    var efdmin: String,
    var emax: String,
    var emin: String,
    var k: String,
    var k1: String,
    var k2: String,
    var kc: String,
    var kce: String,
    var kd: String,
    var kgob: String,
    var kp: String,
    var kqi: String,
    var kqob: String,
    var kqp: String,
    var nq: String,
    var qconoff: String,
    var qz: String,
    var remote: String,
    var sbase: String,
    var tc: String,
    var te: String,
    var ti: String,
    var tp: String,
    var tr: String,
    var uimax: String,
    var uimin: String,
    var urmax: String,
    var urmin: String,
    var vtmax: String,
    var vtmin: String,
    var yp: String
)

data class UpdateExcSKCommand(
    @TargetAggregateIdentifier var excSKId: UUID? = null,
    var efdmax: String,
    var efdmin: String,
    var emax: String,
    var emin: String,
    var k: String,
    var k1: String,
    var k2: String,
    var kc: String,
    var kce: String,
    var kd: String,
    var kgob: String,
    var kp: String,
    var kqi: String,
    var kqob: String,
    var kqp: String,
    var nq: String,
    var qconoff: String,
    var qz: String,
    var remote: String,
    var sbase: String,
    var tc: String,
    var te: String,
    var ti: String,
    var tp: String,
    var tr: String,
    var uimax: String,
    var uimin: String,
    var urmax: String,
    var urmin: String,
    var vtmax: String,
    var vtmin: String,
    var yp: String
)

data class DeleteExcSKCommand(@TargetAggregateIdentifier  var excSKId: UUID? = null)

// single association commands

// multiple association commands


// ExcST1A Commands
data class CreateExcST1ACommand(
    @TargetAggregateIdentifier var excST1AId: UUID? = null,
    var ilr: String,
    var ka: String,
    var kc: String,
    var kf: String,
    var klr: String,
    var ta: String,
    var tb: String,
    var tb1: String,
    var tc: String,
    var tc1: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var vimax: String,
    var vimin: String,
    var vrmax: String,
    var vrmin: String,
    var xe: String
)

data class UpdateExcST1ACommand(
    @TargetAggregateIdentifier var excST1AId: UUID? = null,
    var ilr: String,
    var ka: String,
    var kc: String,
    var kf: String,
    var klr: String,
    var ta: String,
    var tb: String,
    var tb1: String,
    var tc: String,
    var tc1: String,
    var tf: String,
    var vamax: String,
    var vamin: String,
    var vimax: String,
    var vimin: String,
    var vrmax: String,
    var vrmin: String,
    var xe: String
)

data class DeleteExcST1ACommand(@TargetAggregateIdentifier  var excST1AId: UUID? = null)

// single association commands

// multiple association commands


// ExcST2A Commands
data class CreateExcST2ACommand(
    @TargetAggregateIdentifier var excST2AId: UUID? = null,
    var efdmax: String,
    var ka: String,
    var kc: String,
    var ke: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var uelin: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcST2ACommand(
    @TargetAggregateIdentifier var excST2AId: UUID? = null,
    var efdmax: String,
    var ka: String,
    var kc: String,
    var ke: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var te: String,
    var tf: String,
    var uelin: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcST2ACommand(@TargetAggregateIdentifier  var excST2AId: UUID? = null)

// single association commands

// multiple association commands


// ExcST3A Commands
data class CreateExcST3ACommand(
    @TargetAggregateIdentifier var excST3AId: UUID? = null,
    var efdmax: String,
    var kc: String,
    var kg: String,
    var ki: String,
    var kj: String,
    var km: String,
    var kp: String,
    var ks: String,
    var ks1: String,
    var tb: String,
    var tc: String,
    var thetap: String,
    var tm: String,
    var vbmax: String,
    var vgmax: String,
    var vimax: String,
    var vimin: String,
    var vrmax: String,
    var vrmin: String,
    var xl: String
)

data class UpdateExcST3ACommand(
    @TargetAggregateIdentifier var excST3AId: UUID? = null,
    var efdmax: String,
    var kc: String,
    var kg: String,
    var ki: String,
    var kj: String,
    var km: String,
    var kp: String,
    var ks: String,
    var ks1: String,
    var tb: String,
    var tc: String,
    var thetap: String,
    var tm: String,
    var vbmax: String,
    var vgmax: String,
    var vimax: String,
    var vimin: String,
    var vrmax: String,
    var vrmin: String,
    var xl: String
)

data class DeleteExcST3ACommand(@TargetAggregateIdentifier  var excST3AId: UUID? = null)

// single association commands

// multiple association commands


// ExcST4B Commands
data class CreateExcST4BCommand(
    @TargetAggregateIdentifier var excST4BId: UUID? = null,
    var kc: String,
    var kg: String,
    var ki: String,
    var kim: String,
    var kir: String,
    var kp: String,
    var kpm: String,
    var kpr: String,
    var lvgate: String,
    var ta: String,
    var thetap: String,
    var uel: String,
    var vbmax: String,
    var vgmax: String,
    var vmmax: String,
    var vmmin: String,
    var vrmax: String,
    var vrmin: String,
    var xl: String
)

data class UpdateExcST4BCommand(
    @TargetAggregateIdentifier var excST4BId: UUID? = null,
    var kc: String,
    var kg: String,
    var ki: String,
    var kim: String,
    var kir: String,
    var kp: String,
    var kpm: String,
    var kpr: String,
    var lvgate: String,
    var ta: String,
    var thetap: String,
    var uel: String,
    var vbmax: String,
    var vgmax: String,
    var vmmax: String,
    var vmmin: String,
    var vrmax: String,
    var vrmin: String,
    var xl: String
)

data class DeleteExcST4BCommand(@TargetAggregateIdentifier  var excST4BId: UUID? = null)

// single association commands

// multiple association commands


// ExcST6B Commands
data class CreateExcST6BCommand(
    @TargetAggregateIdentifier var excST6BId: UUID? = null,
    var ilr: String,
    var k1: String,
    var kcl: String,
    var kff: String,
    var kg: String,
    var kia: String,
    var klr: String,
    var km: String,
    var kpa: String,
    var kvd: String,
    var oelin: String,
    var tg: String,
    var ts: String,
    var tvd: String,
    var vamax: String,
    var vamin: String,
    var vilim: String,
    var vimax: String,
    var vimin: String,
    var vmult: String,
    var vrmax: String,
    var vrmin: String,
    var xc: String
)

data class UpdateExcST6BCommand(
    @TargetAggregateIdentifier var excST6BId: UUID? = null,
    var ilr: String,
    var k1: String,
    var kcl: String,
    var kff: String,
    var kg: String,
    var kia: String,
    var klr: String,
    var km: String,
    var kpa: String,
    var kvd: String,
    var oelin: String,
    var tg: String,
    var ts: String,
    var tvd: String,
    var vamax: String,
    var vamin: String,
    var vilim: String,
    var vimax: String,
    var vimin: String,
    var vmult: String,
    var vrmax: String,
    var vrmin: String,
    var xc: String
)

data class DeleteExcST6BCommand(@TargetAggregateIdentifier  var excST6BId: UUID? = null)

// single association commands

// multiple association commands


// ExcST7B Commands
data class CreateExcST7BCommand(
    @TargetAggregateIdentifier var excST7BId: UUID? = null,
    var kh: String,
    var kia: String,
    var kl: String,
    var kpa: String,
    var oelin: String,
    var tb: String,
    var tc: String,
    var tf: String,
    var tg: String,
    var tia: String,
    var ts: String,
    var uelin: String,
    var vmax: String,
    var vmin: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdateExcST7BCommand(
    @TargetAggregateIdentifier var excST7BId: UUID? = null,
    var kh: String,
    var kia: String,
    var kl: String,
    var kpa: String,
    var oelin: String,
    var tb: String,
    var tc: String,
    var tf: String,
    var tg: String,
    var tia: String,
    var ts: String,
    var uelin: String,
    var vmax: String,
    var vmin: String,
    var vrmax: String,
    var vrmin: String
)

data class DeleteExcST7BCommand(@TargetAggregateIdentifier  var excST7BId: UUID? = null)

// single association commands

// multiple association commands


// ExcitationSystemDynamics Commands
data class CreateExcitationSystemDynamicsCommand(
    @TargetAggregateIdentifier  var excitationSystemDynamicsId: UUID? = null
)

data class UpdateExcitationSystemDynamicsCommand(
    @TargetAggregateIdentifier  var excitationSystemDynamicsId: UUID? = null
)

data class DeleteExcitationSystemDynamicsCommand(@TargetAggregateIdentifier  var excitationSystemDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// ExcitationSystemUserDefined Commands
data class CreateExcitationSystemUserDefinedCommand(
    @TargetAggregateIdentifier var excitationSystemUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateExcitationSystemUserDefinedCommand(
    @TargetAggregateIdentifier var excitationSystemUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteExcitationSystemUserDefinedCommand(@TargetAggregateIdentifier  var excitationSystemUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// ExtensionVersion Commands
data class CreateExtensionVersionCommand(
    @TargetAggregateIdentifier var extensionVersionId: UUID? = null,
    var date: String,
    var namespaceURI: String
)

data class UpdateExtensionVersionCommand(
    @TargetAggregateIdentifier var extensionVersionId: UUID? = null,
    var date: String,
    var namespaceURI: String
)

data class DeleteExtensionVersionCommand(@TargetAggregateIdentifier  var extensionVersionId: UUID? = null)

// single association commands

// multiple association commands


// ExternalNetworkInjection Commands
data class CreateExternalNetworkInjectionCommand(
    @TargetAggregateIdentifier var externalNetworkInjectionId: UUID? = null,
    var governorSCD: String,
    var ikSecond: String,
    var maxInitialSymShCCurrent: String,
    var maxP: String,
    var maxQ: String,
    var maxR0ToX0Ratio: String,
    var maxR1ToX1Ratio: String,
    var maxZ0ToZ1Ratio: String,
    var minInitialSymShCCurrent: String,
    var minP: String,
    var minQ: String,
    var minR0ToX0Ratio: String,
    var minR1ToX1Ratio: String,
    var minZ0ToZ1Ratio: String,
    var voltageFactor: String
)

data class UpdateExternalNetworkInjectionCommand(
    @TargetAggregateIdentifier var externalNetworkInjectionId: UUID? = null,
    var governorSCD: String,
    var ikSecond: String,
    var maxInitialSymShCCurrent: String,
    var maxP: String,
    var maxQ: String,
    var maxR0ToX0Ratio: String,
    var maxR1ToX1Ratio: String,
    var maxZ0ToZ1Ratio: String,
    var minInitialSymShCCurrent: String,
    var minP: String,
    var minQ: String,
    var minR0ToX0Ratio: String,
    var minR1ToX1Ratio: String,
    var minZ0ToZ1Ratio: String,
    var voltageFactor: String
)

data class DeleteExternalNetworkInjectionCommand(@TargetAggregateIdentifier  var externalNetworkInjectionId: UUID? = null)

// single association commands

// multiple association commands


// FloatProxy Commands
data class CreateFloatProxyCommand(
    @TargetAggregateIdentifier  var floatProxyId: UUID? = null
)

data class UpdateFloatProxyCommand(
    @TargetAggregateIdentifier  var floatProxyId: UUID? = null
)

data class DeleteFloatProxyCommand(@TargetAggregateIdentifier  var floatProxyId: UUID? = null)

// single association commands

// multiple association commands


// FossilFuel Commands
data class CreateFossilFuelCommand(
    @TargetAggregateIdentifier var fossilFuelId: UUID? = null,
    var fossilFuelType: String
)

data class UpdateFossilFuelCommand(
    @TargetAggregateIdentifier var fossilFuelId: UUID? = null,
    var fossilFuelType: String
)

data class DeleteFossilFuelCommand(@TargetAggregateIdentifier  var fossilFuelId: UUID? = null)

// single association commands

// multiple association commands


// Frequency Commands
data class CreateFrequencyCommand(
    @TargetAggregateIdentifier var frequencyId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateFrequencyCommand(
    @TargetAggregateIdentifier var frequencyId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteFrequencyCommand(@TargetAggregateIdentifier  var frequencyId: UUID? = null)

// single association commands

// multiple association commands


// GenICompensationForGenJ Commands
data class CreateGenICompensationForGenJCommand(
    @TargetAggregateIdentifier var genICompensationForGenJId: UUID? = null,
    var rcij: String,
    var xcij: String
)

data class UpdateGenICompensationForGenJCommand(
    @TargetAggregateIdentifier var genICompensationForGenJId: UUID? = null,
    var rcij: String,
    var xcij: String
)

data class DeleteGenICompensationForGenJCommand(@TargetAggregateIdentifier  var genICompensationForGenJId: UUID? = null)

// single association commands

// multiple association commands


// GeneratingUnit Commands
data class CreateGeneratingUnitCommand(
    @TargetAggregateIdentifier var generatingUnitId: UUID? = null,
    var genControlSource: String,
    var governorSCD: String,
    var initialP: String,
    var longPF: String,
    var maximumAllowableSpinningReserve: String,
    var maxOperatingP: String,
    var minOperatingP: String,
    var nominalP: String,
    var ratedGrossMaxP: String,
    var ratedGrossMinP: String,
    var ratedNetMaxP: String,
    var shortPF: String,
    var startupCost: String,
    var totalEfficiency: String,
    var variableCost: String
)

data class UpdateGeneratingUnitCommand(
    @TargetAggregateIdentifier var generatingUnitId: UUID? = null,
    var genControlSource: String,
    var governorSCD: String,
    var initialP: String,
    var longPF: String,
    var maximumAllowableSpinningReserve: String,
    var maxOperatingP: String,
    var minOperatingP: String,
    var nominalP: String,
    var ratedGrossMaxP: String,
    var ratedGrossMinP: String,
    var ratedNetMaxP: String,
    var shortPF: String,
    var startupCost: String,
    var totalEfficiency: String,
    var variableCost: String
)

data class DeleteGeneratingUnitCommand(@TargetAggregateIdentifier  var generatingUnitId: UUID? = null)

// single association commands

// multiple association commands


// GeographicalLocationVersion Commands
data class CreateGeographicalLocationVersionCommand(
    @TargetAggregateIdentifier var geographicalLocationVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class UpdateGeographicalLocationVersionCommand(
    @TargetAggregateIdentifier var geographicalLocationVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class DeleteGeographicalLocationVersionCommand(@TargetAggregateIdentifier  var geographicalLocationVersionId: UUID? = null)

// single association commands

// multiple association commands


// GeographicalRegion Commands
data class CreateGeographicalRegionCommand(
    @TargetAggregateIdentifier  var geographicalRegionId: UUID? = null
)

data class UpdateGeographicalRegionCommand(
    @TargetAggregateIdentifier  var geographicalRegionId: UUID? = null
)

data class DeleteGeographicalRegionCommand(@TargetAggregateIdentifier  var geographicalRegionId: UUID? = null)

// single association commands

// multiple association commands


// GovCT1 Commands
data class CreateGovCT1Command(
    @TargetAggregateIdentifier var govCT1Id: UUID? = null,
    var aset: String,
    var db: String,
    var dm: String,
    var ka: String,
    var kdgov: String,
    var kigov: String,
    var kiload: String,
    var kimw: String,
    var kpgov: String,
    var kpload: String,
    var kturb: String,
    var ldref: String,
    var maxerr: String,
    var minerr: String,
    var mwbase: String,
    var r: String,
    var rclose: String,
    var rdown: String,
    var ropen: String,
    var rselect: String,
    var rup: String,
    var ta: String,
    var tact: String,
    var tb: String,
    var tc: String,
    var tdgov: String,
    var teng: String,
    var tfload: String,
    var tpelec: String,
    var tsa: String,
    var tsb: String,
    var vmax: String,
    var vmin: String,
    var wfnl: String,
    var wfspd: String
)

data class UpdateGovCT1Command(
    @TargetAggregateIdentifier var govCT1Id: UUID? = null,
    var aset: String,
    var db: String,
    var dm: String,
    var ka: String,
    var kdgov: String,
    var kigov: String,
    var kiload: String,
    var kimw: String,
    var kpgov: String,
    var kpload: String,
    var kturb: String,
    var ldref: String,
    var maxerr: String,
    var minerr: String,
    var mwbase: String,
    var r: String,
    var rclose: String,
    var rdown: String,
    var ropen: String,
    var rselect: String,
    var rup: String,
    var ta: String,
    var tact: String,
    var tb: String,
    var tc: String,
    var tdgov: String,
    var teng: String,
    var tfload: String,
    var tpelec: String,
    var tsa: String,
    var tsb: String,
    var vmax: String,
    var vmin: String,
    var wfnl: String,
    var wfspd: String
)

data class DeleteGovCT1Command(@TargetAggregateIdentifier  var govCT1Id: UUID? = null)

// single association commands

// multiple association commands


// GovCT2 Commands
data class CreateGovCT2Command(
    @TargetAggregateIdentifier var govCT2Id: UUID? = null,
    var aset: String,
    var db: String,
    var dm: String,
    var flim1: String,
    var flim10: String,
    var flim2: String,
    var flim3: String,
    var flim4: String,
    var flim5: String,
    var flim6: String,
    var flim7: String,
    var flim8: String,
    var flim9: String,
    var ka: String,
    var kdgov: String,
    var kigov: String,
    var kiload: String,
    var kimw: String,
    var kpgov: String,
    var kpload: String,
    var kturb: String,
    var ldref: String,
    var maxerr: String,
    var minerr: String,
    var mwbase: String,
    var plim1: String,
    var plim10: String,
    var plim2: String,
    var plim3: String,
    var plim4: String,
    var plim5: String,
    var plim6: String,
    var plim7: String,
    var plim8: String,
    var plim9: String,
    var prate: String,
    var r: String,
    var rclose: String,
    var rdown: String,
    var ropen: String,
    var rselect: String,
    var rup: String,
    var ta: String,
    var tact: String,
    var tb: String,
    var tc: String,
    var tdgov: String,
    var teng: String,
    var tfload: String,
    var tpelec: String,
    var tsa: String,
    var tsb: String,
    var vmax: String,
    var vmin: String,
    var wfnl: String,
    var wfspd: String
)

data class UpdateGovCT2Command(
    @TargetAggregateIdentifier var govCT2Id: UUID? = null,
    var aset: String,
    var db: String,
    var dm: String,
    var flim1: String,
    var flim10: String,
    var flim2: String,
    var flim3: String,
    var flim4: String,
    var flim5: String,
    var flim6: String,
    var flim7: String,
    var flim8: String,
    var flim9: String,
    var ka: String,
    var kdgov: String,
    var kigov: String,
    var kiload: String,
    var kimw: String,
    var kpgov: String,
    var kpload: String,
    var kturb: String,
    var ldref: String,
    var maxerr: String,
    var minerr: String,
    var mwbase: String,
    var plim1: String,
    var plim10: String,
    var plim2: String,
    var plim3: String,
    var plim4: String,
    var plim5: String,
    var plim6: String,
    var plim7: String,
    var plim8: String,
    var plim9: String,
    var prate: String,
    var r: String,
    var rclose: String,
    var rdown: String,
    var ropen: String,
    var rselect: String,
    var rup: String,
    var ta: String,
    var tact: String,
    var tb: String,
    var tc: String,
    var tdgov: String,
    var teng: String,
    var tfload: String,
    var tpelec: String,
    var tsa: String,
    var tsb: String,
    var vmax: String,
    var vmin: String,
    var wfnl: String,
    var wfspd: String
)

data class DeleteGovCT2Command(@TargetAggregateIdentifier  var govCT2Id: UUID? = null)

// single association commands

// multiple association commands


// GovGAST Commands
data class CreateGovGASTCommand(
    @TargetAggregateIdentifier var govGASTId: UUID? = null,
    var at: String,
    var dturb: String,
    var kt: String,
    var mwbase: String,
    var r: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var vmax: String,
    var vmin: String
)

data class UpdateGovGASTCommand(
    @TargetAggregateIdentifier var govGASTId: UUID? = null,
    var at: String,
    var dturb: String,
    var kt: String,
    var mwbase: String,
    var r: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var vmax: String,
    var vmin: String
)

data class DeleteGovGASTCommand(@TargetAggregateIdentifier  var govGASTId: UUID? = null)

// single association commands

// multiple association commands


// GovGAST1 Commands
data class CreateGovGAST1Command(
    @TargetAggregateIdentifier var govGAST1Id: UUID? = null,
    var a: String,
    var b: String,
    var db1: String,
    var db2: String,
    var eps: String,
    var fidle: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var ka: String,
    var kt: String,
    var lmax: String,
    var loadinc: String,
    var ltrate: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var r: String,
    var rmax: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var tltr: String,
    var vmax: String,
    var vmin: String
)

data class UpdateGovGAST1Command(
    @TargetAggregateIdentifier var govGAST1Id: UUID? = null,
    var a: String,
    var b: String,
    var db1: String,
    var db2: String,
    var eps: String,
    var fidle: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var ka: String,
    var kt: String,
    var lmax: String,
    var loadinc: String,
    var ltrate: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var r: String,
    var rmax: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var tltr: String,
    var vmax: String,
    var vmin: String
)

data class DeleteGovGAST1Command(@TargetAggregateIdentifier  var govGAST1Id: UUID? = null)

// single association commands

// multiple association commands


// GovGAST2 Commands
data class CreateGovGAST2Command(
    @TargetAggregateIdentifier var govGAST2Id: UUID? = null,
    var a: String,
    var af1: String,
    var af2: String,
    var b: String,
    var bf1: String,
    var bf2: String,
    var c: String,
    var cf2: String,
    var ecr: String,
    var etd: String,
    var k3: String,
    var k4: String,
    var k5: String,
    var k6: String,
    var kf: String,
    var mwbase: String,
    var t: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var tc: String,
    var tcd: String,
    var tf: String,
    var tmax: String,
    var tmin: String,
    var tr: String,
    var trate: String,
    var tt: String,
    var w: String,
    var x: String,
    var y: String,
    var z: String
)

data class UpdateGovGAST2Command(
    @TargetAggregateIdentifier var govGAST2Id: UUID? = null,
    var a: String,
    var af1: String,
    var af2: String,
    var b: String,
    var bf1: String,
    var bf2: String,
    var c: String,
    var cf2: String,
    var ecr: String,
    var etd: String,
    var k3: String,
    var k4: String,
    var k5: String,
    var k6: String,
    var kf: String,
    var mwbase: String,
    var t: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var tc: String,
    var tcd: String,
    var tf: String,
    var tmax: String,
    var tmin: String,
    var tr: String,
    var trate: String,
    var tt: String,
    var w: String,
    var x: String,
    var y: String,
    var z: String
)

data class DeleteGovGAST2Command(@TargetAggregateIdentifier  var govGAST2Id: UUID? = null)

// single association commands

// multiple association commands


// GovGAST3 Commands
data class CreateGovGAST3Command(
    @TargetAggregateIdentifier var govGAST3Id: UUID? = null,
    var bca: String,
    var bp: String,
    var dtc: String,
    var ka: String,
    var kac: String,
    var kca: String,
    var ksi: String,
    var ky: String,
    var mnef: String,
    var mxef: String,
    var rcmn: String,
    var rcmx: String,
    var tac: String,
    var tc: String,
    var td: String,
    var tfen: String,
    var tg: String,
    var tsi: String,
    var tt: String,
    var ttc: String,
    var ty: String
)

data class UpdateGovGAST3Command(
    @TargetAggregateIdentifier var govGAST3Id: UUID? = null,
    var bca: String,
    var bp: String,
    var dtc: String,
    var ka: String,
    var kac: String,
    var kca: String,
    var ksi: String,
    var ky: String,
    var mnef: String,
    var mxef: String,
    var rcmn: String,
    var rcmx: String,
    var tac: String,
    var tc: String,
    var td: String,
    var tfen: String,
    var tg: String,
    var tsi: String,
    var tt: String,
    var ttc: String,
    var ty: String
)

data class DeleteGovGAST3Command(@TargetAggregateIdentifier  var govGAST3Id: UUID? = null)

// single association commands

// multiple association commands


// GovGAST4 Commands
data class CreateGovGAST4Command(
    @TargetAggregateIdentifier var govGAST4Id: UUID? = null,
    var bp: String,
    var ktm: String,
    var mnef: String,
    var mxef: String,
    var rymn: String,
    var rymx: String,
    var ta: String,
    var tc: String,
    var tcm: String,
    var tm: String,
    var tv: String
)

data class UpdateGovGAST4Command(
    @TargetAggregateIdentifier var govGAST4Id: UUID? = null,
    var bp: String,
    var ktm: String,
    var mnef: String,
    var mxef: String,
    var rymn: String,
    var rymx: String,
    var ta: String,
    var tc: String,
    var tcm: String,
    var tm: String,
    var tv: String
)

data class DeleteGovGAST4Command(@TargetAggregateIdentifier  var govGAST4Id: UUID? = null)

// single association commands

// multiple association commands


// GovGASTWD Commands
data class CreateGovGASTWDCommand(
    @TargetAggregateIdentifier var govGASTWDId: UUID? = null,
    var a: String,
    var af1: String,
    var af2: String,
    var b: String,
    var bf1: String,
    var bf2: String,
    var c: String,
    var cf2: String,
    var ecr: String,
    var etd: String,
    var k3: String,
    var k4: String,
    var k5: String,
    var k6: String,
    var kd: String,
    var kdroop: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var t: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var tc: String,
    var tcd: String,
    var td: String,
    var tf: String,
    var tmax: String,
    var tmin: String,
    var tr: String,
    var trate: String,
    var tt: String
)

data class UpdateGovGASTWDCommand(
    @TargetAggregateIdentifier var govGASTWDId: UUID? = null,
    var a: String,
    var af1: String,
    var af2: String,
    var b: String,
    var bf1: String,
    var bf2: String,
    var c: String,
    var cf2: String,
    var ecr: String,
    var etd: String,
    var k3: String,
    var k4: String,
    var k5: String,
    var k6: String,
    var kd: String,
    var kdroop: String,
    var kf: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var t: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var tc: String,
    var tcd: String,
    var td: String,
    var tf: String,
    var tmax: String,
    var tmin: String,
    var tr: String,
    var trate: String,
    var tt: String
)

data class DeleteGovGASTWDCommand(@TargetAggregateIdentifier  var govGASTWDId: UUID? = null)

// single association commands

// multiple association commands


// GovHydro1 Commands
data class CreateGovHydro1Command(
    @TargetAggregateIdentifier var govHydro1Id: UUID? = null,
    var at: String,
    var dturb: String,
    var gmax: String,
    var gmin: String,
    var hdam: String,
    var mwbase: String,
    var qnl: String,
    var rperm: String,
    var rtemp: String,
    var tf: String,
    var tg: String,
    var tr: String,
    var tw: String,
    var velm: String
)

data class UpdateGovHydro1Command(
    @TargetAggregateIdentifier var govHydro1Id: UUID? = null,
    var at: String,
    var dturb: String,
    var gmax: String,
    var gmin: String,
    var hdam: String,
    var mwbase: String,
    var qnl: String,
    var rperm: String,
    var rtemp: String,
    var tf: String,
    var tg: String,
    var tr: String,
    var tw: String,
    var velm: String
)

data class DeleteGovHydro1Command(@TargetAggregateIdentifier  var govHydro1Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydro2 Commands
data class CreateGovHydro2Command(
    @TargetAggregateIdentifier var govHydro2Id: UUID? = null,
    var aturb: String,
    var bturb: String,
    var db1: String,
    var db2: String,
    var eps: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var kturb: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var rperm: String,
    var rtemp: String,
    var tg: String,
    var tp: String,
    var tr: String,
    var tw: String,
    var uc: String,
    var uo: String
)

data class UpdateGovHydro2Command(
    @TargetAggregateIdentifier var govHydro2Id: UUID? = null,
    var aturb: String,
    var bturb: String,
    var db1: String,
    var db2: String,
    var eps: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var kturb: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var rperm: String,
    var rtemp: String,
    var tg: String,
    var tp: String,
    var tr: String,
    var tw: String,
    var uc: String,
    var uo: String
)

data class DeleteGovHydro2Command(@TargetAggregateIdentifier  var govHydro2Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydro3 Commands
data class CreateGovHydro3Command(
    @TargetAggregateIdentifier var govHydro3Id: UUID? = null,
    var at: String,
    var db1: String,
    var db2: String,
    var dturb: String,
    var eps: String,
    var governorControl: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var h0: String,
    var k1: String,
    var k2: String,
    var kg: String,
    var ki: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var qnl: String,
    var relec: String,
    var rgate: String,
    var td: String,
    var tf: String,
    var tp: String,
    var tt: String,
    var tw: String,
    var velcl: String,
    var velop: String
)

data class UpdateGovHydro3Command(
    @TargetAggregateIdentifier var govHydro3Id: UUID? = null,
    var at: String,
    var db1: String,
    var db2: String,
    var dturb: String,
    var eps: String,
    var governorControl: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var h0: String,
    var k1: String,
    var k2: String,
    var kg: String,
    var ki: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var qnl: String,
    var relec: String,
    var rgate: String,
    var td: String,
    var tf: String,
    var tp: String,
    var tt: String,
    var tw: String,
    var velcl: String,
    var velop: String
)

data class DeleteGovHydro3Command(@TargetAggregateIdentifier  var govHydro3Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydro4 Commands
data class CreateGovHydro4Command(
    @TargetAggregateIdentifier var govHydro4Id: UUID? = null,
    var at: String,
    var bgv0: String,
    var bgv1: String,
    var bgv2: String,
    var bgv3: String,
    var bgv4: String,
    var bgv5: String,
    var bmax: String,
    var db1: String,
    var db2: String,
    var dturb: String,
    var eps: String,
    var gmax: String,
    var gmin: String,
    var gv0: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var hdam: String,
    var mwbase: String,
    var pgv0: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var qn1: String,
    var rperm: String,
    var rtemp: String,
    var tblade: String,
    var tg: String,
    var tp: String,
    var tr: String,
    var tw: String,
    var uc: String,
    var uo: String
)

data class UpdateGovHydro4Command(
    @TargetAggregateIdentifier var govHydro4Id: UUID? = null,
    var at: String,
    var bgv0: String,
    var bgv1: String,
    var bgv2: String,
    var bgv3: String,
    var bgv4: String,
    var bgv5: String,
    var bmax: String,
    var db1: String,
    var db2: String,
    var dturb: String,
    var eps: String,
    var gmax: String,
    var gmin: String,
    var gv0: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var hdam: String,
    var mwbase: String,
    var pgv0: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var qn1: String,
    var rperm: String,
    var rtemp: String,
    var tblade: String,
    var tg: String,
    var tp: String,
    var tr: String,
    var tw: String,
    var uc: String,
    var uo: String
)

data class DeleteGovHydro4Command(@TargetAggregateIdentifier  var govHydro4Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydroDD Commands
data class CreateGovHydroDDCommand(
    @TargetAggregateIdentifier var govHydroDDId: UUID? = null,
    var aturb: String,
    var bturb: String,
    var db1: String,
    var db2: String,
    var eps: String,
    var gmax: String,
    var gmin: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var inputSignal: String,
    var k1: String,
    var k2: String,
    var kg: String,
    var ki: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var r: String,
    var td: String,
    var tf: String,
    var tp: String,
    var tt: String,
    var tturb: String,
    var velcl: String,
    var velop: String
)

data class UpdateGovHydroDDCommand(
    @TargetAggregateIdentifier var govHydroDDId: UUID? = null,
    var aturb: String,
    var bturb: String,
    var db1: String,
    var db2: String,
    var eps: String,
    var gmax: String,
    var gmin: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var inputSignal: String,
    var k1: String,
    var k2: String,
    var kg: String,
    var ki: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var r: String,
    var td: String,
    var tf: String,
    var tp: String,
    var tt: String,
    var tturb: String,
    var velcl: String,
    var velop: String
)

data class DeleteGovHydroDDCommand(@TargetAggregateIdentifier  var govHydroDDId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroFrancis Commands
data class CreateGovHydroFrancisCommand(
    @TargetAggregateIdentifier var govHydroFrancisId: UUID? = null,
    var am: String,
    var av0: String,
    var av1: String,
    var bp: String,
    var db1: String,
    var etamax: String,
    var governorControl: String,
    var h1: String,
    var h2: String,
    var hn: String,
    var kc: String,
    var kg: String,
    var kt: String,
    var qc0: String,
    var qn: String,
    var ta: String,
    var td: String,
    var ts: String,
    var twnc: String,
    var twng: String,
    var tx: String,
    var va: String,
    var valvmax: String,
    var valvmin: String,
    var vc: String,
    var waterTunnelSurgeChamberSimulation: String,
    var zsfc: String
)

data class UpdateGovHydroFrancisCommand(
    @TargetAggregateIdentifier var govHydroFrancisId: UUID? = null,
    var am: String,
    var av0: String,
    var av1: String,
    var bp: String,
    var db1: String,
    var etamax: String,
    var governorControl: String,
    var h1: String,
    var h2: String,
    var hn: String,
    var kc: String,
    var kg: String,
    var kt: String,
    var qc0: String,
    var qn: String,
    var ta: String,
    var td: String,
    var ts: String,
    var twnc: String,
    var twng: String,
    var tx: String,
    var va: String,
    var valvmax: String,
    var valvmin: String,
    var vc: String,
    var waterTunnelSurgeChamberSimulation: String,
    var zsfc: String
)

data class DeleteGovHydroFrancisCommand(@TargetAggregateIdentifier  var govHydroFrancisId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroIEEE0 Commands
data class CreateGovHydroIEEE0Command(
    @TargetAggregateIdentifier var govHydroIEEE0Id: UUID? = null,
    var k: String,
    var mwbase: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String
)

data class UpdateGovHydroIEEE0Command(
    @TargetAggregateIdentifier var govHydroIEEE0Id: UUID? = null,
    var k: String,
    var mwbase: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String
)

data class DeleteGovHydroIEEE0Command(@TargetAggregateIdentifier  var govHydroIEEE0Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydroIEEE2 Commands
data class CreateGovHydroIEEE2Command(
    @TargetAggregateIdentifier var govHydroIEEE2Id: UUID? = null,
    var aturb: String,
    var bturb: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var kturb: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var rperm: String,
    var rtemp: String,
    var tg: String,
    var tp: String,
    var tr: String,
    var tw: String,
    var uc: String,
    var uo: String
)

data class UpdateGovHydroIEEE2Command(
    @TargetAggregateIdentifier var govHydroIEEE2Id: UUID? = null,
    var aturb: String,
    var bturb: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var kturb: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var rperm: String,
    var rtemp: String,
    var tg: String,
    var tp: String,
    var tr: String,
    var tw: String,
    var uc: String,
    var uo: String
)

data class DeleteGovHydroIEEE2Command(@TargetAggregateIdentifier  var govHydroIEEE2Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydroPID Commands
data class CreateGovHydroPIDCommand(
    @TargetAggregateIdentifier var govHydroPIDId: UUID? = null,
    var aturb: String,
    var bturb: String,
    var db1: String,
    var db2: String,
    var eps: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var inputSignal: String,
    var kd: String,
    var kg: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var r: String,
    var td: String,
    var tf: String,
    var tp: String,
    var tt: String,
    var tturb: String,
    var velcl: String,
    var velop: String
)

data class UpdateGovHydroPIDCommand(
    @TargetAggregateIdentifier var govHydroPIDId: UUID? = null,
    var aturb: String,
    var bturb: String,
    var db1: String,
    var db2: String,
    var eps: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var inputSignal: String,
    var kd: String,
    var kg: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var r: String,
    var td: String,
    var tf: String,
    var tp: String,
    var tt: String,
    var tturb: String,
    var velcl: String,
    var velop: String
)

data class DeleteGovHydroPIDCommand(@TargetAggregateIdentifier  var govHydroPIDId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroPID2 Commands
data class CreateGovHydroPID2Command(
    @TargetAggregateIdentifier var govHydroPID2Id: UUID? = null,
    var atw: String,
    var d: String,
    var feedbackSignal: String,
    var g0: String,
    var g1: String,
    var g2: String,
    var gmax: String,
    var gmin: String,
    var kd: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var p1: String,
    var p2: String,
    var p3: String,
    var rperm: String,
    var ta: String,
    var tb: String,
    var treg: String,
    var tw: String,
    var velmax: String,
    var velmin: String
)

data class UpdateGovHydroPID2Command(
    @TargetAggregateIdentifier var govHydroPID2Id: UUID? = null,
    var atw: String,
    var d: String,
    var feedbackSignal: String,
    var g0: String,
    var g1: String,
    var g2: String,
    var gmax: String,
    var gmin: String,
    var kd: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var p1: String,
    var p2: String,
    var p3: String,
    var rperm: String,
    var ta: String,
    var tb: String,
    var treg: String,
    var tw: String,
    var velmax: String,
    var velmin: String
)

data class DeleteGovHydroPID2Command(@TargetAggregateIdentifier  var govHydroPID2Id: UUID? = null)

// single association commands

// multiple association commands


// GovHydroPelton Commands
data class CreateGovHydroPeltonCommand(
    @TargetAggregateIdentifier var govHydroPeltonId: UUID? = null,
    var av0: String,
    var av1: String,
    var bp: String,
    var db1: String,
    var db2: String,
    var h1: String,
    var h2: String,
    var hn: String,
    var kc: String,
    var kg: String,
    var qc0: String,
    var qn: String,
    var simplifiedPelton: String,
    var staticCompensating: String,
    var ta: String,
    var ts: String,
    var tv: String,
    var twnc: String,
    var twng: String,
    var tx: String,
    var va: String,
    var valvmax: String,
    var valvmin: String,
    var vav: String,
    var vc: String,
    var vcv: String,
    var waterTunnelSurgeChamberSimulation: String,
    var zsfc: String
)

data class UpdateGovHydroPeltonCommand(
    @TargetAggregateIdentifier var govHydroPeltonId: UUID? = null,
    var av0: String,
    var av1: String,
    var bp: String,
    var db1: String,
    var db2: String,
    var h1: String,
    var h2: String,
    var hn: String,
    var kc: String,
    var kg: String,
    var qc0: String,
    var qn: String,
    var simplifiedPelton: String,
    var staticCompensating: String,
    var ta: String,
    var ts: String,
    var tv: String,
    var twnc: String,
    var twng: String,
    var tx: String,
    var va: String,
    var valvmax: String,
    var valvmin: String,
    var vav: String,
    var vc: String,
    var vcv: String,
    var waterTunnelSurgeChamberSimulation: String,
    var zsfc: String
)

data class DeleteGovHydroPeltonCommand(@TargetAggregateIdentifier  var govHydroPeltonId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroR Commands
data class CreateGovHydroRCommand(
    @TargetAggregateIdentifier var govHydroRId: UUID? = null,
    var at: String,
    var db1: String,
    var db2: String,
    var dturb: String,
    var eps: String,
    var gmax: String,
    var gmin: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var h0: String,
    var inputSignal: String,
    var kg: String,
    var ki: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var qnl: String,
    var r: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var td: String,
    var tp: String,
    var tt: String,
    var tw: String,
    var velcl: String,
    var velop: String
)

data class UpdateGovHydroRCommand(
    @TargetAggregateIdentifier var govHydroRId: UUID? = null,
    var at: String,
    var db1: String,
    var db2: String,
    var dturb: String,
    var eps: String,
    var gmax: String,
    var gmin: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var h0: String,
    var inputSignal: String,
    var kg: String,
    var ki: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var qnl: String,
    var r: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var td: String,
    var tp: String,
    var tt: String,
    var tw: String,
    var velcl: String,
    var velop: String
)

data class DeleteGovHydroRCommand(@TargetAggregateIdentifier  var govHydroRId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroWEH Commands
data class CreateGovHydroWEHCommand(
    @TargetAggregateIdentifier var govHydroWEHId: UUID? = null,
    var db: String,
    var dicn: String,
    var dpv: String,
    var dturb: String,
    var feedbackSignal: String,
    var fl1: String,
    var fl2: String,
    var fl3: String,
    var fl4: String,
    var fl5: String,
    var fp1: String,
    var fp10: String,
    var fp2: String,
    var fp3: String,
    var fp4: String,
    var fp5: String,
    var fp6: String,
    var fp7: String,
    var fp8: String,
    var fp9: String,
    var gmax: String,
    var gmin: String,
    var gtmxcl: String,
    var gtmxop: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var kd: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var pmss1: String,
    var pmss10: String,
    var pmss2: String,
    var pmss3: String,
    var pmss4: String,
    var pmss5: String,
    var pmss6: String,
    var pmss7: String,
    var pmss8: String,
    var pmss9: String,
    var rpg: String,
    var rpp: String,
    var td: String,
    var tdv: String,
    var tg: String,
    var tp: String,
    var tpe: String,
    var tw: String
)

data class UpdateGovHydroWEHCommand(
    @TargetAggregateIdentifier var govHydroWEHId: UUID? = null,
    var db: String,
    var dicn: String,
    var dpv: String,
    var dturb: String,
    var feedbackSignal: String,
    var fl1: String,
    var fl2: String,
    var fl3: String,
    var fl4: String,
    var fl5: String,
    var fp1: String,
    var fp10: String,
    var fp2: String,
    var fp3: String,
    var fp4: String,
    var fp5: String,
    var fp6: String,
    var fp7: String,
    var fp8: String,
    var fp9: String,
    var gmax: String,
    var gmin: String,
    var gtmxcl: String,
    var gtmxop: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var kd: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var pmss1: String,
    var pmss10: String,
    var pmss2: String,
    var pmss3: String,
    var pmss4: String,
    var pmss5: String,
    var pmss6: String,
    var pmss7: String,
    var pmss8: String,
    var pmss9: String,
    var rpg: String,
    var rpp: String,
    var td: String,
    var tdv: String,
    var tg: String,
    var tp: String,
    var tpe: String,
    var tw: String
)

data class DeleteGovHydroWEHCommand(@TargetAggregateIdentifier  var govHydroWEHId: UUID? = null)

// single association commands

// multiple association commands


// GovHydroWPID Commands
data class CreateGovHydroWPIDCommand(
    @TargetAggregateIdentifier var govHydroWPIDId: UUID? = null,
    var d: String,
    var gatmax: String,
    var gatmin: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var kd: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pmax: String,
    var pmin: String,
    var reg: String,
    var ta: String,
    var tb: String,
    var treg: String,
    var tw: String,
    var velmax: String,
    var velmin: String
)

data class UpdateGovHydroWPIDCommand(
    @TargetAggregateIdentifier var govHydroWPIDId: UUID? = null,
    var d: String,
    var gatmax: String,
    var gatmin: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var kd: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pmax: String,
    var pmin: String,
    var reg: String,
    var ta: String,
    var tb: String,
    var treg: String,
    var tw: String,
    var velmax: String,
    var velmin: String
)

data class DeleteGovHydroWPIDCommand(@TargetAggregateIdentifier  var govHydroWPIDId: UUID? = null)

// single association commands

// multiple association commands


// GovSteam0 Commands
data class CreateGovSteam0Command(
    @TargetAggregateIdentifier var govSteam0Id: UUID? = null,
    var dt: String,
    var mwbase: String,
    var r: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var vmax: String,
    var vmin: String
)

data class UpdateGovSteam0Command(
    @TargetAggregateIdentifier var govSteam0Id: UUID? = null,
    var dt: String,
    var mwbase: String,
    var r: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var vmax: String,
    var vmin: String
)

data class DeleteGovSteam0Command(@TargetAggregateIdentifier  var govSteam0Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteam1 Commands
data class CreateGovSteam1Command(
    @TargetAggregateIdentifier var govSteam1Id: UUID? = null,
    var db1: String,
    var db2: String,
    var eps: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var k: String,
    var k1: String,
    var k2: String,
    var k3: String,
    var k4: String,
    var k5: String,
    var k6: String,
    var k7: String,
    var k8: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var sdb1: String,
    var sdb2: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var uc: String,
    var uo: String,
    var valve: String
)

data class UpdateGovSteam1Command(
    @TargetAggregateIdentifier var govSteam1Id: UUID? = null,
    var db1: String,
    var db2: String,
    var eps: String,
    var gv1: String,
    var gv2: String,
    var gv3: String,
    var gv4: String,
    var gv5: String,
    var gv6: String,
    var k: String,
    var k1: String,
    var k2: String,
    var k3: String,
    var k4: String,
    var k5: String,
    var k6: String,
    var k7: String,
    var k8: String,
    var mwbase: String,
    var pgv1: String,
    var pgv2: String,
    var pgv3: String,
    var pgv4: String,
    var pgv5: String,
    var pgv6: String,
    var pmax: String,
    var pmin: String,
    var sdb1: String,
    var sdb2: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var uc: String,
    var uo: String,
    var valve: String
)

data class DeleteGovSteam1Command(@TargetAggregateIdentifier  var govSteam1Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteam2 Commands
data class CreateGovSteam2Command(
    @TargetAggregateIdentifier var govSteam2Id: UUID? = null,
    var dbf: String,
    var k: String,
    var mnef: String,
    var mxef: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String
)

data class UpdateGovSteam2Command(
    @TargetAggregateIdentifier var govSteam2Id: UUID? = null,
    var dbf: String,
    var k: String,
    var mnef: String,
    var mxef: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String
)

data class DeleteGovSteam2Command(@TargetAggregateIdentifier  var govSteam2Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteamCC Commands
data class CreateGovSteamCCCommand(
    @TargetAggregateIdentifier var govSteamCCId: UUID? = null,
    var dhp: String,
    var dlp: String,
    var fhp: String,
    var flp: String,
    var mwbase: String,
    var pmaxhp: String,
    var pmaxlp: String,
    var rhp: String,
    var rlp: String,
    var t1hp: String,
    var t1lp: String,
    var t3hp: String,
    var t3lp: String,
    var t4hp: String,
    var t4lp: String,
    var t5hp: String,
    var t5lp: String
)

data class UpdateGovSteamCCCommand(
    @TargetAggregateIdentifier var govSteamCCId: UUID? = null,
    var dhp: String,
    var dlp: String,
    var fhp: String,
    var flp: String,
    var mwbase: String,
    var pmaxhp: String,
    var pmaxlp: String,
    var rhp: String,
    var rlp: String,
    var t1hp: String,
    var t1lp: String,
    var t3hp: String,
    var t3lp: String,
    var t4hp: String,
    var t4lp: String,
    var t5hp: String,
    var t5lp: String
)

data class DeleteGovSteamCCCommand(@TargetAggregateIdentifier  var govSteamCCId: UUID? = null)

// single association commands

// multiple association commands


// GovSteamEU Commands
data class CreateGovSteamEUCommand(
    @TargetAggregateIdentifier var govSteamEUId: UUID? = null,
    var chc: String,
    var cho: String,
    var cic: String,
    var cio: String,
    var db1: String,
    var db2: String,
    var hhpmax: String,
    var ke: String,
    var kfcor: String,
    var khp: String,
    var klp: String,
    var kwcor: String,
    var mwbase: String,
    var pmax: String,
    var prhmax: String,
    var simx: String,
    var tb: String,
    var tdp: String,
    var ten: String,
    var tf: String,
    var tfp: String,
    var thp: String,
    var tip: String,
    var tlp: String,
    var tp: String,
    var trh: String,
    var tvhp: String,
    var tvip: String,
    var tw: String,
    var wfmax: String,
    var wfmin: String,
    var wmax1: String,
    var wmax2: String,
    var wwmax: String,
    var wwmin: String
)

data class UpdateGovSteamEUCommand(
    @TargetAggregateIdentifier var govSteamEUId: UUID? = null,
    var chc: String,
    var cho: String,
    var cic: String,
    var cio: String,
    var db1: String,
    var db2: String,
    var hhpmax: String,
    var ke: String,
    var kfcor: String,
    var khp: String,
    var klp: String,
    var kwcor: String,
    var mwbase: String,
    var pmax: String,
    var prhmax: String,
    var simx: String,
    var tb: String,
    var tdp: String,
    var ten: String,
    var tf: String,
    var tfp: String,
    var thp: String,
    var tip: String,
    var tlp: String,
    var tp: String,
    var trh: String,
    var tvhp: String,
    var tvip: String,
    var tw: String,
    var wfmax: String,
    var wfmin: String,
    var wmax1: String,
    var wmax2: String,
    var wwmax: String,
    var wwmin: String
)

data class DeleteGovSteamEUCommand(@TargetAggregateIdentifier  var govSteamEUId: UUID? = null)

// single association commands

// multiple association commands


// GovSteamFV2 Commands
data class CreateGovSteamFV2Command(
    @TargetAggregateIdentifier var govSteamFV2Id: UUID? = null,
    var dt: String,
    var k: String,
    var mwbase: String,
    var r: String,
    var t1: String,
    var t3: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var ti: String,
    var tt: String,
    var vmax: String,
    var vmin: String
)

data class UpdateGovSteamFV2Command(
    @TargetAggregateIdentifier var govSteamFV2Id: UUID? = null,
    var dt: String,
    var k: String,
    var mwbase: String,
    var r: String,
    var t1: String,
    var t3: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var ti: String,
    var tt: String,
    var vmax: String,
    var vmin: String
)

data class DeleteGovSteamFV2Command(@TargetAggregateIdentifier  var govSteamFV2Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteamFV3 Commands
data class CreateGovSteamFV3Command(
    @TargetAggregateIdentifier var govSteamFV3Id: UUID? = null,
    var k: String,
    var k1: String,
    var k2: String,
    var k3: String,
    var mwbase: String,
    var pmax: String,
    var pmin: String,
    var prmax: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var uc: String,
    var uo: String
)

data class UpdateGovSteamFV3Command(
    @TargetAggregateIdentifier var govSteamFV3Id: UUID? = null,
    var k: String,
    var k1: String,
    var k2: String,
    var k3: String,
    var mwbase: String,
    var pmax: String,
    var pmin: String,
    var prmax: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var uc: String,
    var uo: String
)

data class DeleteGovSteamFV3Command(@TargetAggregateIdentifier  var govSteamFV3Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteamFV4 Commands
data class CreateGovSteamFV4Command(
    @TargetAggregateIdentifier var govSteamFV4Id: UUID? = null,
    var cpsmn: String,
    var cpsmx: String,
    var crmn: String,
    var crmx: String,
    var kdc: String,
    var kf1: String,
    var kf3: String,
    var khp: String,
    var kic: String,
    var kip: String,
    var kit: String,
    var kmp1: String,
    var kmp2: String,
    var kpc: String,
    var kpp: String,
    var kpt: String,
    var krc: String,
    var ksh: String,
    var lpi: String,
    var lps: String,
    var mnef: String,
    var mxef: String,
    var pr1: String,
    var pr2: String,
    var psmn: String,
    var rsmimn: String,
    var rsmimx: String,
    var rvgmn: String,
    var rvgmx: String,
    var srmn: String,
    var srmx: String,
    var srsmp: String,
    var svmn: String,
    var svmx: String,
    var ta: String,
    var tam: String,
    var tc: String,
    var tcm: String,
    var tdc: String,
    var tf1: String,
    var tf2: String,
    var thp: String,
    var tmp: String,
    var trh: String,
    var tv: String,
    var ty: String,
    var y: String,
    var yhpmn: String,
    var yhpmx: String,
    var ympmn: String,
    var ympmx: String
)

data class UpdateGovSteamFV4Command(
    @TargetAggregateIdentifier var govSteamFV4Id: UUID? = null,
    var cpsmn: String,
    var cpsmx: String,
    var crmn: String,
    var crmx: String,
    var kdc: String,
    var kf1: String,
    var kf3: String,
    var khp: String,
    var kic: String,
    var kip: String,
    var kit: String,
    var kmp1: String,
    var kmp2: String,
    var kpc: String,
    var kpp: String,
    var kpt: String,
    var krc: String,
    var ksh: String,
    var lpi: String,
    var lps: String,
    var mnef: String,
    var mxef: String,
    var pr1: String,
    var pr2: String,
    var psmn: String,
    var rsmimn: String,
    var rsmimx: String,
    var rvgmn: String,
    var rvgmx: String,
    var srmn: String,
    var srmx: String,
    var srsmp: String,
    var svmn: String,
    var svmx: String,
    var ta: String,
    var tam: String,
    var tc: String,
    var tcm: String,
    var tdc: String,
    var tf1: String,
    var tf2: String,
    var thp: String,
    var tmp: String,
    var trh: String,
    var tv: String,
    var ty: String,
    var y: String,
    var yhpmn: String,
    var yhpmx: String,
    var ympmn: String,
    var ympmx: String
)

data class DeleteGovSteamFV4Command(@TargetAggregateIdentifier  var govSteamFV4Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteamIEEE1 Commands
data class CreateGovSteamIEEE1Command(
    @TargetAggregateIdentifier var govSteamIEEE1Id: UUID? = null,
    var k: String,
    var k1: String,
    var k2: String,
    var k3: String,
    var k4: String,
    var k5: String,
    var k6: String,
    var k7: String,
    var k8: String,
    var mwbase: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var uc: String,
    var uo: String
)

data class UpdateGovSteamIEEE1Command(
    @TargetAggregateIdentifier var govSteamIEEE1Id: UUID? = null,
    var k: String,
    var k1: String,
    var k2: String,
    var k3: String,
    var k4: String,
    var k5: String,
    var k6: String,
    var k7: String,
    var k8: String,
    var mwbase: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var uc: String,
    var uo: String
)

data class DeleteGovSteamIEEE1Command(@TargetAggregateIdentifier  var govSteamIEEE1Id: UUID? = null)

// single association commands

// multiple association commands


// GovSteamSGO Commands
data class CreateGovSteamSGOCommand(
    @TargetAggregateIdentifier var govSteamSGOId: UUID? = null,
    var k1: String,
    var k2: String,
    var k3: String,
    var mwbase: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String
)

data class UpdateGovSteamSGOCommand(
    @TargetAggregateIdentifier var govSteamSGOId: UUID? = null,
    var k1: String,
    var k2: String,
    var k3: String,
    var mwbase: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String
)

data class DeleteGovSteamSGOCommand(@TargetAggregateIdentifier  var govSteamSGOId: UUID? = null)

// single association commands

// multiple association commands


// GrossToNetActivePowerCurve Commands
data class CreateGrossToNetActivePowerCurveCommand(
    @TargetAggregateIdentifier  var grossToNetActivePowerCurveId: UUID? = null
)

data class UpdateGrossToNetActivePowerCurveCommand(
    @TargetAggregateIdentifier  var grossToNetActivePowerCurveId: UUID? = null
)

data class DeleteGrossToNetActivePowerCurveCommand(@TargetAggregateIdentifier  var grossToNetActivePowerCurveId: UUID? = null)

// single association commands

// multiple association commands


// Ground Commands
data class CreateGroundCommand(
    @TargetAggregateIdentifier  var groundId: UUID? = null
)

data class UpdateGroundCommand(
    @TargetAggregateIdentifier  var groundId: UUID? = null
)

data class DeleteGroundCommand(@TargetAggregateIdentifier  var groundId: UUID? = null)

// single association commands

// multiple association commands


// GroundDisconnector Commands
data class CreateGroundDisconnectorCommand(
    @TargetAggregateIdentifier  var groundDisconnectorId: UUID? = null
)

data class UpdateGroundDisconnectorCommand(
    @TargetAggregateIdentifier  var groundDisconnectorId: UUID? = null
)

data class DeleteGroundDisconnectorCommand(@TargetAggregateIdentifier  var groundDisconnectorId: UUID? = null)

// single association commands

// multiple association commands


// GroundingImpedance Commands
data class CreateGroundingImpedanceCommand(
    @TargetAggregateIdentifier var groundingImpedanceId: UUID? = null,
    var x: String
)

data class UpdateGroundingImpedanceCommand(
    @TargetAggregateIdentifier var groundingImpedanceId: UUID? = null,
    var x: String
)

data class DeleteGroundingImpedanceCommand(@TargetAggregateIdentifier  var groundingImpedanceId: UUID? = null)

// single association commands

// multiple association commands


// HydroGeneratingUnit Commands
data class CreateHydroGeneratingUnitCommand(
    @TargetAggregateIdentifier var hydroGeneratingUnitId: UUID? = null,
    var energyConversionCapability: String
)

data class UpdateHydroGeneratingUnitCommand(
    @TargetAggregateIdentifier var hydroGeneratingUnitId: UUID? = null,
    var energyConversionCapability: String
)

data class DeleteHydroGeneratingUnitCommand(@TargetAggregateIdentifier  var hydroGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// HydroPowerPlant Commands
data class CreateHydroPowerPlantCommand(
    @TargetAggregateIdentifier var hydroPowerPlantId: UUID? = null,
    var hydroPlantStorageType: String
)

data class UpdateHydroPowerPlantCommand(
    @TargetAggregateIdentifier var hydroPowerPlantId: UUID? = null,
    var hydroPlantStorageType: String
)

data class DeleteHydroPowerPlantCommand(@TargetAggregateIdentifier  var hydroPowerPlantId: UUID? = null)

// single association commands

// multiple association commands


// HydroPump Commands
data class CreateHydroPumpCommand(
    @TargetAggregateIdentifier  var hydroPumpId: UUID? = null
)

data class UpdateHydroPumpCommand(
    @TargetAggregateIdentifier  var hydroPumpId: UUID? = null
)

data class DeleteHydroPumpCommand(@TargetAggregateIdentifier  var hydroPumpId: UUID? = null)

// single association commands

// multiple association commands


// IdentifiedObject Commands
data class CreateIdentifiedObjectCommand(
    @TargetAggregateIdentifier var identifiedObjectId: UUID? = null,
    var description: String,
    var energyIdentCodeEic: String,
    var mRID: String,
    var name: String,
    var shortName: String
)

data class UpdateIdentifiedObjectCommand(
    @TargetAggregateIdentifier var identifiedObjectId: UUID? = null,
    var description: String,
    var energyIdentCodeEic: String,
    var mRID: String,
    var name: String,
    var shortName: String
)

data class DeleteIdentifiedObjectCommand(@TargetAggregateIdentifier  var identifiedObjectId: UUID? = null)

// single association commands

// multiple association commands


// Inductance Commands
data class CreateInductanceCommand(
    @TargetAggregateIdentifier var inductanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateInductanceCommand(
    @TargetAggregateIdentifier var inductanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteInductanceCommand(@TargetAggregateIdentifier  var inductanceId: UUID? = null)

// single association commands

// multiple association commands


// InductancePerLength Commands
data class CreateInductancePerLengthCommand(
    @TargetAggregateIdentifier var inductancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateInductancePerLengthCommand(
    @TargetAggregateIdentifier var inductancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteInductancePerLengthCommand(@TargetAggregateIdentifier  var inductancePerLengthId: UUID? = null)

// single association commands

// multiple association commands


// IntegerProxy Commands
data class CreateIntegerProxyCommand(
    @TargetAggregateIdentifier  var integerProxyId: UUID? = null
)

data class UpdateIntegerProxyCommand(
    @TargetAggregateIdentifier  var integerProxyId: UUID? = null
)

data class DeleteIntegerProxyCommand(@TargetAggregateIdentifier  var integerProxyId: UUID? = null)

// single association commands

// multiple association commands


// Junction Commands
data class CreateJunctionCommand(
    @TargetAggregateIdentifier  var junctionId: UUID? = null
)

data class UpdateJunctionCommand(
    @TargetAggregateIdentifier  var junctionId: UUID? = null
)

data class DeleteJunctionCommand(@TargetAggregateIdentifier  var junctionId: UUID? = null)

// single association commands

// multiple association commands


// Length Commands
data class CreateLengthCommand(
    @TargetAggregateIdentifier var lengthId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateLengthCommand(
    @TargetAggregateIdentifier var lengthId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteLengthCommand(@TargetAggregateIdentifier  var lengthId: UUID? = null)

// single association commands

// multiple association commands


// Limit Commands
data class CreateLimitCommand(
    @TargetAggregateIdentifier  var limitId: UUID? = null
)

data class UpdateLimitCommand(
    @TargetAggregateIdentifier  var limitId: UUID? = null
)

data class DeleteLimitCommand(@TargetAggregateIdentifier  var limitId: UUID? = null)

// single association commands

// multiple association commands


// LimitSet Commands
data class CreateLimitSetCommand(
    @TargetAggregateIdentifier var limitSetId: UUID? = null,
    var isPercentageLimits: String
)

data class UpdateLimitSetCommand(
    @TargetAggregateIdentifier var limitSetId: UUID? = null,
    var isPercentageLimits: String
)

data class DeleteLimitSetCommand(@TargetAggregateIdentifier  var limitSetId: UUID? = null)

// single association commands

// multiple association commands


// Line Commands
data class CreateLineCommand(
    @TargetAggregateIdentifier  var lineId: UUID? = null
)

data class UpdateLineCommand(
    @TargetAggregateIdentifier  var lineId: UUID? = null
)

data class DeleteLineCommand(@TargetAggregateIdentifier  var lineId: UUID? = null)

// single association commands

// multiple association commands


// LinearShuntCompensator Commands
data class CreateLinearShuntCompensatorCommand(
    @TargetAggregateIdentifier var linearShuntCompensatorId: UUID? = null,
    var b0PerSection: String,
    var bPerSection: String,
    var g0PerSection: String,
    var gPerSection: String
)

data class UpdateLinearShuntCompensatorCommand(
    @TargetAggregateIdentifier var linearShuntCompensatorId: UUID? = null,
    var b0PerSection: String,
    var bPerSection: String,
    var g0PerSection: String,
    var gPerSection: String
)

data class DeleteLinearShuntCompensatorCommand(@TargetAggregateIdentifier  var linearShuntCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// LoadAggregate Commands
data class CreateLoadAggregateCommand(
    @TargetAggregateIdentifier  var loadAggregateId: UUID? = null
)

data class UpdateLoadAggregateCommand(
    @TargetAggregateIdentifier  var loadAggregateId: UUID? = null
)

data class DeleteLoadAggregateCommand(@TargetAggregateIdentifier  var loadAggregateId: UUID? = null)

// single association commands

// multiple association commands


// LoadArea Commands
data class CreateLoadAreaCommand(
    @TargetAggregateIdentifier  var loadAreaId: UUID? = null
)

data class UpdateLoadAreaCommand(
    @TargetAggregateIdentifier  var loadAreaId: UUID? = null
)

data class DeleteLoadAreaCommand(@TargetAggregateIdentifier  var loadAreaId: UUID? = null)

// single association commands

// multiple association commands


// LoadBreakSwitch Commands
data class CreateLoadBreakSwitchCommand(
    @TargetAggregateIdentifier  var loadBreakSwitchId: UUID? = null
)

data class UpdateLoadBreakSwitchCommand(
    @TargetAggregateIdentifier  var loadBreakSwitchId: UUID? = null
)

data class DeleteLoadBreakSwitchCommand(@TargetAggregateIdentifier  var loadBreakSwitchId: UUID? = null)

// single association commands

// multiple association commands


// LoadComposite Commands
data class CreateLoadCompositeCommand(
    @TargetAggregateIdentifier var loadCompositeId: UUID? = null,
    var epfd: String,
    var epfs: String,
    var epvd: String,
    var epvs: String,
    var eqfd: String,
    var eqfs: String,
    var eqvd: String,
    var eqvs: String,
    var h: String,
    var lfrac: String,
    var pfrac: String
)

data class UpdateLoadCompositeCommand(
    @TargetAggregateIdentifier var loadCompositeId: UUID? = null,
    var epfd: String,
    var epfs: String,
    var epvd: String,
    var epvs: String,
    var eqfd: String,
    var eqfs: String,
    var eqvd: String,
    var eqvs: String,
    var h: String,
    var lfrac: String,
    var pfrac: String
)

data class DeleteLoadCompositeCommand(@TargetAggregateIdentifier  var loadCompositeId: UUID? = null)

// single association commands

// multiple association commands


// LoadDynamics Commands
data class CreateLoadDynamicsCommand(
    @TargetAggregateIdentifier  var loadDynamicsId: UUID? = null
)

data class UpdateLoadDynamicsCommand(
    @TargetAggregateIdentifier  var loadDynamicsId: UUID? = null
)

data class DeleteLoadDynamicsCommand(@TargetAggregateIdentifier  var loadDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// LoadGenericNonLinear Commands
data class CreateLoadGenericNonLinearCommand(
    @TargetAggregateIdentifier var loadGenericNonLinearId: UUID? = null,
    var bs: String,
    var bt: String,
    var genericNonLinearLoadModelType: String,
    var ls: String,
    var lt: String,
    var pt: String,
    var qt: String,
    var tp: String,
    var tq: String
)

data class UpdateLoadGenericNonLinearCommand(
    @TargetAggregateIdentifier var loadGenericNonLinearId: UUID? = null,
    var bs: String,
    var bt: String,
    var genericNonLinearLoadModelType: String,
    var ls: String,
    var lt: String,
    var pt: String,
    var qt: String,
    var tp: String,
    var tq: String
)

data class DeleteLoadGenericNonLinearCommand(@TargetAggregateIdentifier  var loadGenericNonLinearId: UUID? = null)

// single association commands

// multiple association commands


// LoadGroup Commands
data class CreateLoadGroupCommand(
    @TargetAggregateIdentifier  var loadGroupId: UUID? = null
)

data class UpdateLoadGroupCommand(
    @TargetAggregateIdentifier  var loadGroupId: UUID? = null
)

data class DeleteLoadGroupCommand(@TargetAggregateIdentifier  var loadGroupId: UUID? = null)

// single association commands

// multiple association commands


// LoadMotor Commands
data class CreateLoadMotorCommand(
    @TargetAggregateIdentifier var loadMotorId: UUID? = null,
    var d: String,
    var h: String,
    var lfac: String,
    var lp: String,
    var lpp: String,
    var ls: String,
    var pfrac: String,
    var ra: String,
    var tbkr: String,
    var tpo: String,
    var tppo: String,
    var tv: String,
    var vt: String
)

data class UpdateLoadMotorCommand(
    @TargetAggregateIdentifier var loadMotorId: UUID? = null,
    var d: String,
    var h: String,
    var lfac: String,
    var lp: String,
    var lpp: String,
    var ls: String,
    var pfrac: String,
    var ra: String,
    var tbkr: String,
    var tpo: String,
    var tppo: String,
    var tv: String,
    var vt: String
)

data class DeleteLoadMotorCommand(@TargetAggregateIdentifier  var loadMotorId: UUID? = null)

// single association commands

// multiple association commands


// LoadResponseCharacteristic Commands
data class CreateLoadResponseCharacteristicCommand(
    @TargetAggregateIdentifier var loadResponseCharacteristicId: UUID? = null,
    var exponentModel: String,
    var pConstantCurrent: String,
    var pConstantImpedance: String,
    var pConstantPower: String,
    var pFrequencyExponent: String,
    var pVoltageExponent: String,
    var qConstantCurrent: String,
    var qConstantImpedance: String,
    var qConstantPower: String,
    var qFrequencyExponent: String,
    var qVoltageExponent: String
)

data class UpdateLoadResponseCharacteristicCommand(
    @TargetAggregateIdentifier var loadResponseCharacteristicId: UUID? = null,
    var exponentModel: String,
    var pConstantCurrent: String,
    var pConstantImpedance: String,
    var pConstantPower: String,
    var pFrequencyExponent: String,
    var pVoltageExponent: String,
    var qConstantCurrent: String,
    var qConstantImpedance: String,
    var qConstantPower: String,
    var qFrequencyExponent: String,
    var qVoltageExponent: String
)

data class DeleteLoadResponseCharacteristicCommand(@TargetAggregateIdentifier  var loadResponseCharacteristicId: UUID? = null)

// single association commands

// multiple association commands


// LoadStatic Commands
data class CreateLoadStaticCommand(
    @TargetAggregateIdentifier var loadStaticId: UUID? = null,
    var ep1: String,
    var ep2: String,
    var ep3: String,
    var eq1: String,
    var eq2: String,
    var eq3: String,
    var kp1: String,
    var kp2: String,
    var kp3: String,
    var kp4: String,
    var kpf: String,
    var kq1: String,
    var kq2: String,
    var kq3: String,
    var kq4: String,
    var kqf: String,
    var staticLoadModelType: String
)

data class UpdateLoadStaticCommand(
    @TargetAggregateIdentifier var loadStaticId: UUID? = null,
    var ep1: String,
    var ep2: String,
    var ep3: String,
    var eq1: String,
    var eq2: String,
    var eq3: String,
    var kp1: String,
    var kp2: String,
    var kp3: String,
    var kp4: String,
    var kpf: String,
    var kq1: String,
    var kq2: String,
    var kq3: String,
    var kq4: String,
    var kqf: String,
    var staticLoadModelType: String
)

data class DeleteLoadStaticCommand(@TargetAggregateIdentifier  var loadStaticId: UUID? = null)

// single association commands

// multiple association commands


// LoadUserDefined Commands
data class CreateLoadUserDefinedCommand(
    @TargetAggregateIdentifier var loadUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateLoadUserDefinedCommand(
    @TargetAggregateIdentifier var loadUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteLoadUserDefinedCommand(@TargetAggregateIdentifier  var loadUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// Location Commands
data class CreateLocationCommand(
    @TargetAggregateIdentifier  var locationId: UUID? = null
)

data class UpdateLocationCommand(
    @TargetAggregateIdentifier  var locationId: UUID? = null
)

data class DeleteLocationCommand(@TargetAggregateIdentifier  var locationId: UUID? = null)

// single association commands

// multiple association commands


// Measurement Commands
data class CreateMeasurementCommand(
    @TargetAggregateIdentifier var measurementId: UUID? = null,
    var measurementType: String,
    var phases: String,
    var unitMultiplier: String,
    var unitSymbol: String
)

data class UpdateMeasurementCommand(
    @TargetAggregateIdentifier var measurementId: UUID? = null,
    var measurementType: String,
    var phases: String,
    var unitMultiplier: String,
    var unitSymbol: String
)

data class DeleteMeasurementCommand(@TargetAggregateIdentifier  var measurementId: UUID? = null)

// single association commands

// multiple association commands


// MeasurementValue Commands
data class CreateMeasurementValueCommand(
    @TargetAggregateIdentifier var measurementValueId: UUID? = null,
    var sensorAccuracy: String,
    var timeStamp: String
)

data class UpdateMeasurementValueCommand(
    @TargetAggregateIdentifier var measurementValueId: UUID? = null,
    var sensorAccuracy: String,
    var timeStamp: String
)

data class DeleteMeasurementValueCommand(@TargetAggregateIdentifier  var measurementValueId: UUID? = null)

// single association commands

// multiple association commands


// MeasurementValueQuality Commands
data class CreateMeasurementValueQualityCommand(
    @TargetAggregateIdentifier  var measurementValueQualityId: UUID? = null
)

data class UpdateMeasurementValueQualityCommand(
    @TargetAggregateIdentifier  var measurementValueQualityId: UUID? = null
)

data class DeleteMeasurementValueQualityCommand(@TargetAggregateIdentifier  var measurementValueQualityId: UUID? = null)

// single association commands

// multiple association commands


// MeasurementValueSource Commands
data class CreateMeasurementValueSourceCommand(
    @TargetAggregateIdentifier  var measurementValueSourceId: UUID? = null
)

data class UpdateMeasurementValueSourceCommand(
    @TargetAggregateIdentifier  var measurementValueSourceId: UUID? = null
)

data class DeleteMeasurementValueSourceCommand(@TargetAggregateIdentifier  var measurementValueSourceId: UUID? = null)

// single association commands

// multiple association commands


// MechLoad1 Commands
data class CreateMechLoad1Command(
    @TargetAggregateIdentifier var mechLoad1Id: UUID? = null,
    var a: String,
    var b: String,
    var d: String,
    var e: String
)

data class UpdateMechLoad1Command(
    @TargetAggregateIdentifier var mechLoad1Id: UUID? = null,
    var a: String,
    var b: String,
    var d: String,
    var e: String
)

data class DeleteMechLoad1Command(@TargetAggregateIdentifier  var mechLoad1Id: UUID? = null)

// single association commands

// multiple association commands


// MechanicalLoadDynamics Commands
data class CreateMechanicalLoadDynamicsCommand(
    @TargetAggregateIdentifier  var mechanicalLoadDynamicsId: UUID? = null
)

data class UpdateMechanicalLoadDynamicsCommand(
    @TargetAggregateIdentifier  var mechanicalLoadDynamicsId: UUID? = null
)

data class DeleteMechanicalLoadDynamicsCommand(@TargetAggregateIdentifier  var mechanicalLoadDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// MechanicalLoadUserDefined Commands
data class CreateMechanicalLoadUserDefinedCommand(
    @TargetAggregateIdentifier var mechanicalLoadUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateMechanicalLoadUserDefinedCommand(
    @TargetAggregateIdentifier var mechanicalLoadUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteMechanicalLoadUserDefinedCommand(@TargetAggregateIdentifier  var mechanicalLoadUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// Money Commands
data class CreateMoneyCommand(
    @TargetAggregateIdentifier var moneyId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateMoneyCommand(
    @TargetAggregateIdentifier var moneyId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteMoneyCommand(@TargetAggregateIdentifier  var moneyId: UUID? = null)

// single association commands

// multiple association commands


// MonthDay Commands
data class CreateMonthDayCommand(
    @TargetAggregateIdentifier  var monthDayId: UUID? = null
)

data class UpdateMonthDayCommand(
    @TargetAggregateIdentifier  var monthDayId: UUID? = null
)

data class DeleteMonthDayCommand(@TargetAggregateIdentifier  var monthDayId: UUID? = null)

// single association commands

// multiple association commands


// MonthDayIntervar Commands
data class CreateMonthDayIntervalCommand(
    @TargetAggregateIdentifier var monthDayIntervalId: UUID? = null,
    var end: String,
    var start: String
)

data class UpdateMonthDayIntervalCommand(
    @TargetAggregateIdentifier var monthDayIntervalId: UUID? = null,
    var end: String,
    var start: String
)

data class DeleteMonthDayIntervalCommand(@TargetAggregateIdentifier  var monthDayIntervalId: UUID? = null)

// single association commands

// multiple association commands


// MutualCoupling Commands
data class CreateMutualCouplingCommand(
    @TargetAggregateIdentifier var mutualCouplingId: UUID? = null,
    var b0ch: String,
    var distance11: String,
    var distance12: String,
    var distance21: String,
    var distance22: String,
    var g0ch: String,
    var r0: String,
    var x0: String
)

data class UpdateMutualCouplingCommand(
    @TargetAggregateIdentifier var mutualCouplingId: UUID? = null,
    var b0ch: String,
    var distance11: String,
    var distance12: String,
    var distance21: String,
    var distance22: String,
    var g0ch: String,
    var r0: String,
    var x0: String
)

data class DeleteMutualCouplingCommand(@TargetAggregateIdentifier  var mutualCouplingId: UUID? = null)

// single association commands

// multiple association commands


// NonConformLoad Commands
data class CreateNonConformLoadCommand(
    @TargetAggregateIdentifier  var nonConformLoadId: UUID? = null
)

data class UpdateNonConformLoadCommand(
    @TargetAggregateIdentifier  var nonConformLoadId: UUID? = null
)

data class DeleteNonConformLoadCommand(@TargetAggregateIdentifier  var nonConformLoadId: UUID? = null)

// single association commands

// multiple association commands


// NonConformLoadGroup Commands
data class CreateNonConformLoadGroupCommand(
    @TargetAggregateIdentifier  var nonConformLoadGroupId: UUID? = null
)

data class UpdateNonConformLoadGroupCommand(
    @TargetAggregateIdentifier  var nonConformLoadGroupId: UUID? = null
)

data class DeleteNonConformLoadGroupCommand(@TargetAggregateIdentifier  var nonConformLoadGroupId: UUID? = null)

// single association commands

// multiple association commands


// NonConformLoadSchedule Commands
data class CreateNonConformLoadScheduleCommand(
    @TargetAggregateIdentifier  var nonConformLoadScheduleId: UUID? = null
)

data class UpdateNonConformLoadScheduleCommand(
    @TargetAggregateIdentifier  var nonConformLoadScheduleId: UUID? = null
)

data class DeleteNonConformLoadScheduleCommand(@TargetAggregateIdentifier  var nonConformLoadScheduleId: UUID? = null)

// single association commands

// multiple association commands


// NonlinearShuntCompensator Commands
data class CreateNonlinearShuntCompensatorCommand(
    @TargetAggregateIdentifier  var nonlinearShuntCompensatorId: UUID? = null
)

data class UpdateNonlinearShuntCompensatorCommand(
    @TargetAggregateIdentifier  var nonlinearShuntCompensatorId: UUID? = null
)

data class DeleteNonlinearShuntCompensatorCommand(@TargetAggregateIdentifier  var nonlinearShuntCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// NonlinearShuntCompensatorPoint Commands
data class CreateNonlinearShuntCompensatorPointCommand(
    @TargetAggregateIdentifier var nonlinearShuntCompensatorPointId: UUID? = null,
    var b: String,
    var b0: String,
    var g: String,
    var g0: String,
    var sectionNumber: String
)

data class UpdateNonlinearShuntCompensatorPointCommand(
    @TargetAggregateIdentifier var nonlinearShuntCompensatorPointId: UUID? = null,
    var b: String,
    var b0: String,
    var g: String,
    var g0: String,
    var sectionNumber: String
)

data class DeleteNonlinearShuntCompensatorPointCommand(@TargetAggregateIdentifier  var nonlinearShuntCompensatorPointId: UUID? = null)

// single association commands

// multiple association commands


// NuclearGeneratingUnit Commands
data class CreateNuclearGeneratingUnitCommand(
    @TargetAggregateIdentifier  var nuclearGeneratingUnitId: UUID? = null
)

data class UpdateNuclearGeneratingUnitCommand(
    @TargetAggregateIdentifier  var nuclearGeneratingUnitId: UUID? = null
)

data class DeleteNuclearGeneratingUnitCommand(@TargetAggregateIdentifier  var nuclearGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// OperationalLimit Commands
data class CreateOperationalLimitCommand(
    @TargetAggregateIdentifier  var operationalLimitId: UUID? = null
)

data class UpdateOperationalLimitCommand(
    @TargetAggregateIdentifier  var operationalLimitId: UUID? = null
)

data class DeleteOperationalLimitCommand(@TargetAggregateIdentifier  var operationalLimitId: UUID? = null)

// single association commands

// multiple association commands


// OperationalLimitSet Commands
data class CreateOperationalLimitSetCommand(
    @TargetAggregateIdentifier  var operationalLimitSetId: UUID? = null
)

data class UpdateOperationalLimitSetCommand(
    @TargetAggregateIdentifier  var operationalLimitSetId: UUID? = null
)

data class DeleteOperationalLimitSetCommand(@TargetAggregateIdentifier  var operationalLimitSetId: UUID? = null)

// single association commands

// multiple association commands


// OperationalLimitType Commands
data class CreateOperationalLimitTypeCommand(
    @TargetAggregateIdentifier var operationalLimitTypeId: UUID? = null,
    var acceptableDuration: String,
    var direction: String,
    var limitType: String
)

data class UpdateOperationalLimitTypeCommand(
    @TargetAggregateIdentifier var operationalLimitTypeId: UUID? = null,
    var acceptableDuration: String,
    var direction: String,
    var limitType: String
)

data class DeleteOperationalLimitTypeCommand(@TargetAggregateIdentifier  var operationalLimitTypeId: UUID? = null)

// single association commands

// multiple association commands


// OverexcLim2 Commands
data class CreateOverexcLim2Command(
    @TargetAggregateIdentifier var overexcLim2Id: UUID? = null,
    var ifdlim: String,
    var koi: String,
    var voimax: String,
    var voimin: String
)

data class UpdateOverexcLim2Command(
    @TargetAggregateIdentifier var overexcLim2Id: UUID? = null,
    var ifdlim: String,
    var koi: String,
    var voimax: String,
    var voimin: String
)

data class DeleteOverexcLim2Command(@TargetAggregateIdentifier  var overexcLim2Id: UUID? = null)

// single association commands

// multiple association commands


// OverexcLimIEEE Commands
data class CreateOverexcLimIEEECommand(
    @TargetAggregateIdentifier var overexcLimIEEEId: UUID? = null,
    var hyst: String,
    var ifdlim: String,
    var ifdmax: String,
    var itfpu: String,
    var kcd: String,
    var kramp: String
)

data class UpdateOverexcLimIEEECommand(
    @TargetAggregateIdentifier var overexcLimIEEEId: UUID? = null,
    var hyst: String,
    var ifdlim: String,
    var ifdmax: String,
    var itfpu: String,
    var kcd: String,
    var kramp: String
)

data class DeleteOverexcLimIEEECommand(@TargetAggregateIdentifier  var overexcLimIEEEId: UUID? = null)

// single association commands

// multiple association commands


// OverexcLimX1 Commands
data class CreateOverexcLimX1Command(
    @TargetAggregateIdentifier var overexcLimX1Id: UUID? = null,
    var efd1: String,
    var efd2: String,
    var efd3: String,
    var efddes: String,
    var efdrated: String,
    var kmx: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var vlow: String
)

data class UpdateOverexcLimX1Command(
    @TargetAggregateIdentifier var overexcLimX1Id: UUID? = null,
    var efd1: String,
    var efd2: String,
    var efd3: String,
    var efddes: String,
    var efdrated: String,
    var kmx: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var vlow: String
)

data class DeleteOverexcLimX1Command(@TargetAggregateIdentifier  var overexcLimX1Id: UUID? = null)

// single association commands

// multiple association commands


// OverexcLimX2 Commands
data class CreateOverexcLimX2Command(
    @TargetAggregateIdentifier var overexcLimX2Id: UUID? = null,
    var efd1: String,
    var efd2: String,
    var efd3: String,
    var efddes: String,
    var efdrated: String,
    var kmx: String,
    var m: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var vlow: String
)

data class UpdateOverexcLimX2Command(
    @TargetAggregateIdentifier var overexcLimX2Id: UUID? = null,
    var efd1: String,
    var efd2: String,
    var efd3: String,
    var efddes: String,
    var efdrated: String,
    var kmx: String,
    var m: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var vlow: String
)

data class DeleteOverexcLimX2Command(@TargetAggregateIdentifier  var overexcLimX2Id: UUID? = null)

// single association commands

// multiple association commands


// OverexcitationLimiterDynamics Commands
data class CreateOverexcitationLimiterDynamicsCommand(
    @TargetAggregateIdentifier  var overexcitationLimiterDynamicsId: UUID? = null
)

data class UpdateOverexcitationLimiterDynamicsCommand(
    @TargetAggregateIdentifier  var overexcitationLimiterDynamicsId: UUID? = null
)

data class DeleteOverexcitationLimiterDynamicsCommand(@TargetAggregateIdentifier  var overexcitationLimiterDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// OverexcitationLimiterUserDefined Commands
data class CreateOverexcitationLimiterUserDefinedCommand(
    @TargetAggregateIdentifier var overexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateOverexcitationLimiterUserDefinedCommand(
    @TargetAggregateIdentifier var overexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteOverexcitationLimiterUserDefinedCommand(@TargetAggregateIdentifier  var overexcitationLimiterUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// PFVArControllerType1Dynamics Commands
data class CreatePFVArControllerType1DynamicsCommand(
    @TargetAggregateIdentifier  var pFVArControllerType1DynamicsId: UUID? = null
)

data class UpdatePFVArControllerType1DynamicsCommand(
    @TargetAggregateIdentifier  var pFVArControllerType1DynamicsId: UUID? = null
)

data class DeletePFVArControllerType1DynamicsCommand(@TargetAggregateIdentifier  var pFVArControllerType1DynamicsId: UUID? = null)

// single association commands

// multiple association commands


// PFVArControllerType1UserDefined Commands
data class CreatePFVArControllerType1UserDefinedCommand(
    @TargetAggregateIdentifier var pFVArControllerType1UserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdatePFVArControllerType1UserDefinedCommand(
    @TargetAggregateIdentifier var pFVArControllerType1UserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeletePFVArControllerType1UserDefinedCommand(@TargetAggregateIdentifier  var pFVArControllerType1UserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// PFVArControllerType2Dynamics Commands
data class CreatePFVArControllerType2DynamicsCommand(
    @TargetAggregateIdentifier  var pFVArControllerType2DynamicsId: UUID? = null
)

data class UpdatePFVArControllerType2DynamicsCommand(
    @TargetAggregateIdentifier  var pFVArControllerType2DynamicsId: UUID? = null
)

data class DeletePFVArControllerType2DynamicsCommand(@TargetAggregateIdentifier  var pFVArControllerType2DynamicsId: UUID? = null)

// single association commands

// multiple association commands


// PFVArControllerType2UserDefined Commands
data class CreatePFVArControllerType2UserDefinedCommand(
    @TargetAggregateIdentifier var pFVArControllerType2UserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdatePFVArControllerType2UserDefinedCommand(
    @TargetAggregateIdentifier var pFVArControllerType2UserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeletePFVArControllerType2UserDefinedCommand(@TargetAggregateIdentifier  var pFVArControllerType2UserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// PFVArType1IEEEPFController Commands
data class CreatePFVArType1IEEEPFControllerCommand(
    @TargetAggregateIdentifier var pFVArType1IEEEPFControllerId: UUID? = null,
    var ovex: String,
    var tpfc: String,
    var vitmin: String,
    var vpf: String,
    var vpfcbw: String,
    var vpfref: String,
    var vvtmax: String,
    var vvtmin: String
)

data class UpdatePFVArType1IEEEPFControllerCommand(
    @TargetAggregateIdentifier var pFVArType1IEEEPFControllerId: UUID? = null,
    var ovex: String,
    var tpfc: String,
    var vitmin: String,
    var vpf: String,
    var vpfcbw: String,
    var vpfref: String,
    var vvtmax: String,
    var vvtmin: String
)

data class DeletePFVArType1IEEEPFControllerCommand(@TargetAggregateIdentifier  var pFVArType1IEEEPFControllerId: UUID? = null)

// single association commands

// multiple association commands


// PFVArType1IEEEVArController Commands
data class CreatePFVArType1IEEEVArControllerCommand(
    @TargetAggregateIdentifier var pFVArType1IEEEVArControllerId: UUID? = null,
    var tvarc: String,
    var vvar: String,
    var vvarcbw: String,
    var vvarref: String,
    var vvtmax: String,
    var vvtmin: String
)

data class UpdatePFVArType1IEEEVArControllerCommand(
    @TargetAggregateIdentifier var pFVArType1IEEEVArControllerId: UUID? = null,
    var tvarc: String,
    var vvar: String,
    var vvarcbw: String,
    var vvarref: String,
    var vvtmax: String,
    var vvtmin: String
)

data class DeletePFVArType1IEEEVArControllerCommand(@TargetAggregateIdentifier  var pFVArType1IEEEVArControllerId: UUID? = null)

// single association commands

// multiple association commands


// PFVArType2Common1 Commands
data class CreatePFVArType2Common1Command(
    @TargetAggregateIdentifier var pFVArType2Common1Id: UUID? = null,
    var j: String,
    var ki: String,
    var kp: String,
    var max: String,
    var ref: String
)

data class UpdatePFVArType2Common1Command(
    @TargetAggregateIdentifier var pFVArType2Common1Id: UUID? = null,
    var j: String,
    var ki: String,
    var kp: String,
    var max: String,
    var ref: String
)

data class DeletePFVArType2Common1Command(@TargetAggregateIdentifier  var pFVArType2Common1Id: UUID? = null)

// single association commands

// multiple association commands


// PFVArType2IEEEPFController Commands
data class CreatePFVArType2IEEEPFControllerCommand(
    @TargetAggregateIdentifier var pFVArType2IEEEPFControllerId: UUID? = null,
    var exlon: String,
    var ki: String,
    var kp: String,
    var pfref: String,
    var vclmt: String,
    var vref: String,
    var vs: String
)

data class UpdatePFVArType2IEEEPFControllerCommand(
    @TargetAggregateIdentifier var pFVArType2IEEEPFControllerId: UUID? = null,
    var exlon: String,
    var ki: String,
    var kp: String,
    var pfref: String,
    var vclmt: String,
    var vref: String,
    var vs: String
)

data class DeletePFVArType2IEEEPFControllerCommand(@TargetAggregateIdentifier  var pFVArType2IEEEPFControllerId: UUID? = null)

// single association commands

// multiple association commands


// PFVArType2IEEEVArController Commands
data class CreatePFVArType2IEEEVArControllerCommand(
    @TargetAggregateIdentifier var pFVArType2IEEEVArControllerId: UUID? = null,
    var exlon: String,
    var ki: String,
    var kp: String,
    var qref: String,
    var vclmt: String,
    var vref: String,
    var vs: String
)

data class UpdatePFVArType2IEEEVArControllerCommand(
    @TargetAggregateIdentifier var pFVArType2IEEEVArControllerId: UUID? = null,
    var exlon: String,
    var ki: String,
    var kp: String,
    var qref: String,
    var vclmt: String,
    var vref: String,
    var vs: String
)

data class DeletePFVArType2IEEEVArControllerCommand(@TargetAggregateIdentifier  var pFVArType2IEEEVArControllerId: UUID? = null)

// single association commands

// multiple association commands


// PU Commands
data class CreatePUCommand(
    @TargetAggregateIdentifier var pUId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdatePUCommand(
    @TargetAggregateIdentifier var pUId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeletePUCommand(@TargetAggregateIdentifier  var pUId: UUID? = null)

// single association commands

// multiple association commands


// PerCent Commands
data class CreatePerCentCommand(
    @TargetAggregateIdentifier var perCentId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdatePerCentCommand(
    @TargetAggregateIdentifier var perCentId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeletePerCentCommand(@TargetAggregateIdentifier  var perCentId: UUID? = null)

// single association commands

// multiple association commands


// PerLengthDCLineParameter Commands
data class CreatePerLengthDCLineParameterCommand(
    @TargetAggregateIdentifier var perLengthDCLineParameterId: UUID? = null,
    var capacitance: String,
    var inductance: String,
    var resistance: String
)

data class UpdatePerLengthDCLineParameterCommand(
    @TargetAggregateIdentifier var perLengthDCLineParameterId: UUID? = null,
    var capacitance: String,
    var inductance: String,
    var resistance: String
)

data class DeletePerLengthDCLineParameterCommand(@TargetAggregateIdentifier  var perLengthDCLineParameterId: UUID? = null)

// single association commands

// multiple association commands


// PetersenCoil Commands
data class CreatePetersenCoilCommand(
    @TargetAggregateIdentifier var petersenCoilId: UUID? = null,
    var mode: String,
    var nominalU: String,
    var offsetCurrent: String,
    var positionCurrent: String,
    var xGroundMax: String,
    var xGroundMin: String,
    var xGroundNominal: String
)

data class UpdatePetersenCoilCommand(
    @TargetAggregateIdentifier var petersenCoilId: UUID? = null,
    var mode: String,
    var nominalU: String,
    var offsetCurrent: String,
    var positionCurrent: String,
    var xGroundMax: String,
    var xGroundMin: String,
    var xGroundNominal: String
)

data class DeletePetersenCoilCommand(@TargetAggregateIdentifier  var petersenCoilId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChanger Commands
data class CreatePhaseTapChangerCommand(
    @TargetAggregateIdentifier  var phaseTapChangerId: UUID? = null
)

data class UpdatePhaseTapChangerCommand(
    @TargetAggregateIdentifier  var phaseTapChangerId: UUID? = null
)

data class DeletePhaseTapChangerCommand(@TargetAggregateIdentifier  var phaseTapChangerId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerAsymmetrical Commands
data class CreatePhaseTapChangerAsymmetricalCommand(
    @TargetAggregateIdentifier var phaseTapChangerAsymmetricalId: UUID? = null,
    var windingConnectionAngle: String
)

data class UpdatePhaseTapChangerAsymmetricalCommand(
    @TargetAggregateIdentifier var phaseTapChangerAsymmetricalId: UUID? = null,
    var windingConnectionAngle: String
)

data class DeletePhaseTapChangerAsymmetricalCommand(@TargetAggregateIdentifier  var phaseTapChangerAsymmetricalId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerLinear Commands
data class CreatePhaseTapChangerLinearCommand(
    @TargetAggregateIdentifier var phaseTapChangerLinearId: UUID? = null,
    var stepPhaseShiftIncrement: String,
    var xMax: String,
    var xMin: String
)

data class UpdatePhaseTapChangerLinearCommand(
    @TargetAggregateIdentifier var phaseTapChangerLinearId: UUID? = null,
    var stepPhaseShiftIncrement: String,
    var xMax: String,
    var xMin: String
)

data class DeletePhaseTapChangerLinearCommand(@TargetAggregateIdentifier  var phaseTapChangerLinearId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerNonLinear Commands
data class CreatePhaseTapChangerNonLinearCommand(
    @TargetAggregateIdentifier var phaseTapChangerNonLinearId: UUID? = null,
    var voltageStepIncrement: String,
    var xMax: String,
    var xMin: String
)

data class UpdatePhaseTapChangerNonLinearCommand(
    @TargetAggregateIdentifier var phaseTapChangerNonLinearId: UUID? = null,
    var voltageStepIncrement: String,
    var xMax: String,
    var xMin: String
)

data class DeletePhaseTapChangerNonLinearCommand(@TargetAggregateIdentifier  var phaseTapChangerNonLinearId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerSymmetrical Commands
data class CreatePhaseTapChangerSymmetricalCommand(
    @TargetAggregateIdentifier  var phaseTapChangerSymmetricalId: UUID? = null
)

data class UpdatePhaseTapChangerSymmetricalCommand(
    @TargetAggregateIdentifier  var phaseTapChangerSymmetricalId: UUID? = null
)

data class DeletePhaseTapChangerSymmetricalCommand(@TargetAggregateIdentifier  var phaseTapChangerSymmetricalId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerTable Commands
data class CreatePhaseTapChangerTableCommand(
    @TargetAggregateIdentifier  var phaseTapChangerTableId: UUID? = null
)

data class UpdatePhaseTapChangerTableCommand(
    @TargetAggregateIdentifier  var phaseTapChangerTableId: UUID? = null
)

data class DeletePhaseTapChangerTableCommand(@TargetAggregateIdentifier  var phaseTapChangerTableId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerTablePoint Commands
data class CreatePhaseTapChangerTablePointCommand(
    @TargetAggregateIdentifier var phaseTapChangerTablePointId: UUID? = null,
    var angle: String
)

data class UpdatePhaseTapChangerTablePointCommand(
    @TargetAggregateIdentifier var phaseTapChangerTablePointId: UUID? = null,
    var angle: String
)

data class DeletePhaseTapChangerTablePointCommand(@TargetAggregateIdentifier  var phaseTapChangerTablePointId: UUID? = null)

// single association commands

// multiple association commands


// PhaseTapChangerTabular Commands
data class CreatePhaseTapChangerTabularCommand(
    @TargetAggregateIdentifier  var phaseTapChangerTabularId: UUID? = null
)

data class UpdatePhaseTapChangerTabularCommand(
    @TargetAggregateIdentifier  var phaseTapChangerTabularId: UUID? = null
)

data class DeletePhaseTapChangerTabularCommand(@TargetAggregateIdentifier  var phaseTapChangerTabularId: UUID? = null)

// single association commands

// multiple association commands


// PositionPoint Commands
data class CreatePositionPointCommand(
    @TargetAggregateIdentifier var positionPointId: UUID? = null,
    var sequenceNumber: String,
    var xPosition: String,
    var yPosition: String,
    var zPosition: String
)

data class UpdatePositionPointCommand(
    @TargetAggregateIdentifier var positionPointId: UUID? = null,
    var sequenceNumber: String,
    var xPosition: String,
    var yPosition: String,
    var zPosition: String
)

data class DeletePositionPointCommand(@TargetAggregateIdentifier  var positionPointId: UUID? = null)

// single association commands

// multiple association commands


// PowerSystemResource Commands
data class CreatePowerSystemResourceCommand(
    @TargetAggregateIdentifier  var powerSystemResourceId: UUID? = null
)

data class UpdatePowerSystemResourceCommand(
    @TargetAggregateIdentifier  var powerSystemResourceId: UUID? = null
)

data class DeletePowerSystemResourceCommand(@TargetAggregateIdentifier  var powerSystemResourceId: UUID? = null)

// single association commands

// multiple association commands


// PowerSystemStabilizerDynamics Commands
data class CreatePowerSystemStabilizerDynamicsCommand(
    @TargetAggregateIdentifier  var powerSystemStabilizerDynamicsId: UUID? = null
)

data class UpdatePowerSystemStabilizerDynamicsCommand(
    @TargetAggregateIdentifier  var powerSystemStabilizerDynamicsId: UUID? = null
)

data class DeletePowerSystemStabilizerDynamicsCommand(@TargetAggregateIdentifier  var powerSystemStabilizerDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// PowerSystemStabilizerUserDefined Commands
data class CreatePowerSystemStabilizerUserDefinedCommand(
    @TargetAggregateIdentifier var powerSystemStabilizerUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdatePowerSystemStabilizerUserDefinedCommand(
    @TargetAggregateIdentifier var powerSystemStabilizerUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeletePowerSystemStabilizerUserDefinedCommand(@TargetAggregateIdentifier  var powerSystemStabilizerUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// PowerTransformer Commands
data class CreatePowerTransformerCommand(
    @TargetAggregateIdentifier var powerTransformerId: UUID? = null,
    var beforeShCircuitHighestOperatingCurrent: String,
    var beforeShCircuitHighestOperatingVoltage: String,
    var beforeShortCircuitAnglePf: String,
    var highSideMinOperatingU: String,
    var isPartOfGeneratorUnit: String,
    var operationalValuesConsidered: String
)

data class UpdatePowerTransformerCommand(
    @TargetAggregateIdentifier var powerTransformerId: UUID? = null,
    var beforeShCircuitHighestOperatingCurrent: String,
    var beforeShCircuitHighestOperatingVoltage: String,
    var beforeShortCircuitAnglePf: String,
    var highSideMinOperatingU: String,
    var isPartOfGeneratorUnit: String,
    var operationalValuesConsidered: String
)

data class DeletePowerTransformerCommand(@TargetAggregateIdentifier  var powerTransformerId: UUID? = null)

// single association commands

// multiple association commands


// PowerTransformerEnd Commands
data class CreatePowerTransformerEndCommand(
    @TargetAggregateIdentifier var powerTransformerEndId: UUID? = null,
    var b: String,
    var b0: String,
    var connectionKind: String,
    var g: String,
    var g0: String,
    var phaseAngleClock: String,
    var r: String,
    var r0: String,
    var ratedS: String,
    var ratedU: String,
    var x: String,
    var x0: String
)

data class UpdatePowerTransformerEndCommand(
    @TargetAggregateIdentifier var powerTransformerEndId: UUID? = null,
    var b: String,
    var b0: String,
    var connectionKind: String,
    var g: String,
    var g0: String,
    var phaseAngleClock: String,
    var r: String,
    var r0: String,
    var ratedS: String,
    var ratedU: String,
    var x: String,
    var x0: String
)

data class DeletePowerTransformerEndCommand(@TargetAggregateIdentifier  var powerTransformerEndId: UUID? = null)

// single association commands

// multiple association commands


// ProprietaryParameterDynamics Commands
data class CreateProprietaryParameterDynamicsCommand(
    @TargetAggregateIdentifier var proprietaryParameterDynamicsId: UUID? = null,
    var booleanParameterValue: String,
    var floatParameterValue: String,
    var integerParameterValue: String,
    var parameterNumber: String
)

data class UpdateProprietaryParameterDynamicsCommand(
    @TargetAggregateIdentifier var proprietaryParameterDynamicsId: UUID? = null,
    var booleanParameterValue: String,
    var floatParameterValue: String,
    var integerParameterValue: String,
    var parameterNumber: String
)

data class DeleteProprietaryParameterDynamicsCommand(@TargetAggregateIdentifier  var proprietaryParameterDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// ProtectedSwitch Commands
data class CreateProtectedSwitchCommand(
    @TargetAggregateIdentifier  var protectedSwitchId: UUID? = null
)

data class UpdateProtectedSwitchCommand(
    @TargetAggregateIdentifier  var protectedSwitchId: UUID? = null
)

data class DeleteProtectedSwitchCommand(@TargetAggregateIdentifier  var protectedSwitchId: UUID? = null)

// single association commands

// multiple association commands


// Pss1 Commands
data class CreatePss1Command(
    @TargetAggregateIdentifier var pss1Id: UUID? = null,
    var kf: String,
    var kpe: String,
    var ks: String,
    var kw: String,
    var pmin: String,
    var t10: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var t9: String,
    var tpe: String,
    var vadat: String,
    var vsmn: String,
    var vsmx: String
)

data class UpdatePss1Command(
    @TargetAggregateIdentifier var pss1Id: UUID? = null,
    var kf: String,
    var kpe: String,
    var ks: String,
    var kw: String,
    var pmin: String,
    var t10: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var t9: String,
    var tpe: String,
    var vadat: String,
    var vsmn: String,
    var vsmx: String
)

data class DeletePss1Command(@TargetAggregateIdentifier  var pss1Id: UUID? = null)

// single association commands

// multiple association commands


// Pss1A Commands
data class CreatePss1ACommand(
    @TargetAggregateIdentifier var pss1AId: UUID? = null,
    var a1: String,
    var a2: String,
    var a3: String,
    var a4: String,
    var a5: String,
    var a6: String,
    var a7: String,
    var a8: String,
    var inputSignalType: String,
    var kd: String,
    var ks: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var tdelay: String,
    var vcl: String,
    var vcu: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdatePss1ACommand(
    @TargetAggregateIdentifier var pss1AId: UUID? = null,
    var a1: String,
    var a2: String,
    var a3: String,
    var a4: String,
    var a5: String,
    var a6: String,
    var a7: String,
    var a8: String,
    var inputSignalType: String,
    var kd: String,
    var ks: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var tdelay: String,
    var vcl: String,
    var vcu: String,
    var vrmax: String,
    var vrmin: String
)

data class DeletePss1ACommand(@TargetAggregateIdentifier  var pss1AId: UUID? = null)

// single association commands

// multiple association commands


// Pss2B Commands
data class CreatePss2BCommand(
    @TargetAggregateIdentifier var pss2BId: UUID? = null,
    var a: String,
    var inputSignal1Type: String,
    var inputSignal2Type: String,
    var ks1: String,
    var ks2: String,
    var ks3: String,
    var ks4: String,
    var m: String,
    var n: String,
    var t1: String,
    var t10: String,
    var t11: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var t9: String,
    var ta: String,
    var tb: String,
    var tw1: String,
    var tw2: String,
    var tw3: String,
    var tw4: String,
    var vsi1max: String,
    var vsi1min: String,
    var vsi2max: String,
    var vsi2min: String,
    var vstmax: String,
    var vstmin: String
)

data class UpdatePss2BCommand(
    @TargetAggregateIdentifier var pss2BId: UUID? = null,
    var a: String,
    var inputSignal1Type: String,
    var inputSignal2Type: String,
    var ks1: String,
    var ks2: String,
    var ks3: String,
    var ks4: String,
    var m: String,
    var n: String,
    var t1: String,
    var t10: String,
    var t11: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var t9: String,
    var ta: String,
    var tb: String,
    var tw1: String,
    var tw2: String,
    var tw3: String,
    var tw4: String,
    var vsi1max: String,
    var vsi1min: String,
    var vsi2max: String,
    var vsi2min: String,
    var vstmax: String,
    var vstmin: String
)

data class DeletePss2BCommand(@TargetAggregateIdentifier  var pss2BId: UUID? = null)

// single association commands

// multiple association commands


// Pss2ST Commands
data class CreatePss2STCommand(
    @TargetAggregateIdentifier var pss2STId: UUID? = null,
    var inputSignal1Type: String,
    var inputSignal2Type: String,
    var k1: String,
    var k2: String,
    var lsmax: String,
    var lsmin: String,
    var t1: String,
    var t10: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var t9: String,
    var vcl: String,
    var vcu: String
)

data class UpdatePss2STCommand(
    @TargetAggregateIdentifier var pss2STId: UUID? = null,
    var inputSignal1Type: String,
    var inputSignal2Type: String,
    var k1: String,
    var k2: String,
    var lsmax: String,
    var lsmin: String,
    var t1: String,
    var t10: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var t9: String,
    var vcl: String,
    var vcu: String
)

data class DeletePss2STCommand(@TargetAggregateIdentifier  var pss2STId: UUID? = null)

// single association commands

// multiple association commands


// Pss5 Commands
data class CreatePss5Command(
    @TargetAggregateIdentifier var pss5Id: UUID? = null,
    var ctw2: String,
    var deadband: String,
    var isfreq: String,
    var kf: String,
    var kpe: String,
    var kpss: String,
    var pmm: String,
    var tl1: String,
    var tl2: String,
    var tl3: String,
    var tl4: String,
    var tpe: String,
    var tw1: String,
    var tw2: String,
    var vadat: String,
    var vsmn: String,
    var vsmx: String
)

data class UpdatePss5Command(
    @TargetAggregateIdentifier var pss5Id: UUID? = null,
    var ctw2: String,
    var deadband: String,
    var isfreq: String,
    var kf: String,
    var kpe: String,
    var kpss: String,
    var pmm: String,
    var tl1: String,
    var tl2: String,
    var tl3: String,
    var tl4: String,
    var tpe: String,
    var tw1: String,
    var tw2: String,
    var vadat: String,
    var vsmn: String,
    var vsmx: String
)

data class DeletePss5Command(@TargetAggregateIdentifier  var pss5Id: UUID? = null)

// single association commands

// multiple association commands


// PssELIN2 Commands
data class CreatePssELIN2Command(
    @TargetAggregateIdentifier var pssELIN2Id: UUID? = null,
    var apss: String,
    var ks1: String,
    var ks2: String,
    var ppss: String,
    var psslim: String,
    var ts1: String,
    var ts2: String,
    var ts3: String,
    var ts4: String,
    var ts5: String,
    var ts6: String
)

data class UpdatePssELIN2Command(
    @TargetAggregateIdentifier var pssELIN2Id: UUID? = null,
    var apss: String,
    var ks1: String,
    var ks2: String,
    var ppss: String,
    var psslim: String,
    var ts1: String,
    var ts2: String,
    var ts3: String,
    var ts4: String,
    var ts5: String,
    var ts6: String
)

data class DeletePssELIN2Command(@TargetAggregateIdentifier  var pssELIN2Id: UUID? = null)

// single association commands

// multiple association commands


// PssIEEE1A Commands
data class CreatePssIEEE1ACommand(
    @TargetAggregateIdentifier var pssIEEE1AId: UUID? = null,
    var a1: String,
    var a2: String,
    var inputSignalType: String,
    var ks: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var vrmax: String,
    var vrmin: String
)

data class UpdatePssIEEE1ACommand(
    @TargetAggregateIdentifier var pssIEEE1AId: UUID? = null,
    var a1: String,
    var a2: String,
    var inputSignalType: String,
    var ks: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var vrmax: String,
    var vrmin: String
)

data class DeletePssIEEE1ACommand(@TargetAggregateIdentifier  var pssIEEE1AId: UUID? = null)

// single association commands

// multiple association commands


// PssIEEE2B Commands
data class CreatePssIEEE2BCommand(
    @TargetAggregateIdentifier var pssIEEE2BId: UUID? = null,
    var inputSignal1Type: String,
    var inputSignal2Type: String,
    var ks1: String,
    var ks2: String,
    var ks3: String,
    var m: String,
    var n: String,
    var t1: String,
    var t10: String,
    var t11: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var t9: String,
    var tw1: String,
    var tw2: String,
    var tw3: String,
    var tw4: String,
    var vsi1max: String,
    var vsi1min: String,
    var vsi2max: String,
    var vsi2min: String,
    var vstmax: String,
    var vstmin: String
)

data class UpdatePssIEEE2BCommand(
    @TargetAggregateIdentifier var pssIEEE2BId: UUID? = null,
    var inputSignal1Type: String,
    var inputSignal2Type: String,
    var ks1: String,
    var ks2: String,
    var ks3: String,
    var m: String,
    var n: String,
    var t1: String,
    var t10: String,
    var t11: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var t9: String,
    var tw1: String,
    var tw2: String,
    var tw3: String,
    var tw4: String,
    var vsi1max: String,
    var vsi1min: String,
    var vsi2max: String,
    var vsi2min: String,
    var vstmax: String,
    var vstmin: String
)

data class DeletePssIEEE2BCommand(@TargetAggregateIdentifier  var pssIEEE2BId: UUID? = null)

// single association commands

// multiple association commands


// PssIEEE3B Commands
data class CreatePssIEEE3BCommand(
    @TargetAggregateIdentifier var pssIEEE3BId: UUID? = null,
    var a1: String,
    var a2: String,
    var a3: String,
    var a4: String,
    var a5: String,
    var a6: String,
    var a7: String,
    var a8: String,
    var inputSignal1Type: String,
    var inputSignal2Type: String,
    var ks1: String,
    var ks2: String,
    var t1: String,
    var t2: String,
    var tw1: String,
    var tw2: String,
    var tw3: String,
    var vstmax: String,
    var vstmin: String
)

data class UpdatePssIEEE3BCommand(
    @TargetAggregateIdentifier var pssIEEE3BId: UUID? = null,
    var a1: String,
    var a2: String,
    var a3: String,
    var a4: String,
    var a5: String,
    var a6: String,
    var a7: String,
    var a8: String,
    var inputSignal1Type: String,
    var inputSignal2Type: String,
    var ks1: String,
    var ks2: String,
    var t1: String,
    var t2: String,
    var tw1: String,
    var tw2: String,
    var tw3: String,
    var vstmax: String,
    var vstmin: String
)

data class DeletePssIEEE3BCommand(@TargetAggregateIdentifier  var pssIEEE3BId: UUID? = null)

// single association commands

// multiple association commands


// PssIEEE4B Commands
data class CreatePssIEEE4BCommand(
    @TargetAggregateIdentifier var pssIEEE4BId: UUID? = null,
    var bwh1: String,
    var bwh2: String,
    var bwl1: String,
    var bwl2: String,
    var kh: String,
    var kh1: String,
    var kh11: String,
    var kh17: String,
    var kh2: String,
    var ki: String,
    var ki1: String,
    var ki11: String,
    var ki17: String,
    var ki2: String,
    var kl: String,
    var kl1: String,
    var kl11: String,
    var kl17: String,
    var kl2: String,
    var omeganh1: String,
    var omeganh2: String,
    var omeganl1: String,
    var omeganl2: String,
    var th1: String,
    var th10: String,
    var th11: String,
    var th12: String,
    var th2: String,
    var th3: String,
    var th4: String,
    var th5: String,
    var th6: String,
    var th7: String,
    var th8: String,
    var th9: String,
    var ti1: String,
    var ti10: String,
    var ti11: String,
    var ti12: String,
    var ti2: String,
    var ti3: String,
    var ti4: String,
    var ti5: String,
    var ti6: String,
    var ti7: String,
    var ti8: String,
    var ti9: String,
    var tl1: String,
    var tl10: String,
    var tl11: String,
    var tl12: String,
    var tl2: String,
    var tl3: String,
    var tl4: String,
    var tl5: String,
    var tl6: String,
    var tl7: String,
    var tl8: String,
    var tl9: String,
    var vhmax: String,
    var vhmin: String,
    var vimax: String,
    var vimin: String,
    var vlmax: String,
    var vlmin: String,
    var vstmax: String,
    var vstmin: String
)

data class UpdatePssIEEE4BCommand(
    @TargetAggregateIdentifier var pssIEEE4BId: UUID? = null,
    var bwh1: String,
    var bwh2: String,
    var bwl1: String,
    var bwl2: String,
    var kh: String,
    var kh1: String,
    var kh11: String,
    var kh17: String,
    var kh2: String,
    var ki: String,
    var ki1: String,
    var ki11: String,
    var ki17: String,
    var ki2: String,
    var kl: String,
    var kl1: String,
    var kl11: String,
    var kl17: String,
    var kl2: String,
    var omeganh1: String,
    var omeganh2: String,
    var omeganl1: String,
    var omeganl2: String,
    var th1: String,
    var th10: String,
    var th11: String,
    var th12: String,
    var th2: String,
    var th3: String,
    var th4: String,
    var th5: String,
    var th6: String,
    var th7: String,
    var th8: String,
    var th9: String,
    var ti1: String,
    var ti10: String,
    var ti11: String,
    var ti12: String,
    var ti2: String,
    var ti3: String,
    var ti4: String,
    var ti5: String,
    var ti6: String,
    var ti7: String,
    var ti8: String,
    var ti9: String,
    var tl1: String,
    var tl10: String,
    var tl11: String,
    var tl12: String,
    var tl2: String,
    var tl3: String,
    var tl4: String,
    var tl5: String,
    var tl6: String,
    var tl7: String,
    var tl8: String,
    var tl9: String,
    var vhmax: String,
    var vhmin: String,
    var vimax: String,
    var vimin: String,
    var vlmax: String,
    var vlmin: String,
    var vstmax: String,
    var vstmin: String
)

data class DeletePssIEEE4BCommand(@TargetAggregateIdentifier  var pssIEEE4BId: UUID? = null)

// single association commands

// multiple association commands


// PssPTIST1 Commands
data class CreatePssPTIST1Command(
    @TargetAggregateIdentifier var pssPTIST1Id: UUID? = null,
    var dtc: String,
    var dtf: String,
    var dtp: String,
    var k: String,
    var m: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var tf: String,
    var tp: String
)

data class UpdatePssPTIST1Command(
    @TargetAggregateIdentifier var pssPTIST1Id: UUID? = null,
    var dtc: String,
    var dtf: String,
    var dtp: String,
    var k: String,
    var m: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var tf: String,
    var tp: String
)

data class DeletePssPTIST1Command(@TargetAggregateIdentifier  var pssPTIST1Id: UUID? = null)

// single association commands

// multiple association commands


// PssPTIST3 Commands
data class CreatePssPTIST3Command(
    @TargetAggregateIdentifier var pssPTIST3Id: UUID? = null,
    var a0: String,
    var a1: String,
    var a2: String,
    var a3: String,
    var a4: String,
    var a5: String,
    var al: String,
    var athres: String,
    var b0: String,
    var b1: String,
    var b2: String,
    var b3: String,
    var b4: String,
    var b5: String,
    var dl: String,
    var dtc: String,
    var dtf: String,
    var dtp: String,
    var isw: String,
    var k: String,
    var lthres: String,
    var m: String,
    var nav: String,
    var ncl: String,
    var ncr: String,
    var pmin: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var tf: String,
    var tp: String
)

data class UpdatePssPTIST3Command(
    @TargetAggregateIdentifier var pssPTIST3Id: UUID? = null,
    var a0: String,
    var a1: String,
    var a2: String,
    var a3: String,
    var a4: String,
    var a5: String,
    var al: String,
    var athres: String,
    var b0: String,
    var b1: String,
    var b2: String,
    var b3: String,
    var b4: String,
    var b5: String,
    var dl: String,
    var dtc: String,
    var dtf: String,
    var dtp: String,
    var isw: String,
    var k: String,
    var lthres: String,
    var m: String,
    var nav: String,
    var ncl: String,
    var ncr: String,
    var pmin: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var tf: String,
    var tp: String
)

data class DeletePssPTIST3Command(@TargetAggregateIdentifier  var pssPTIST3Id: UUID? = null)

// single association commands

// multiple association commands


// PssSB4 Commands
data class CreatePssSB4Command(
    @TargetAggregateIdentifier var pssSB4Id: UUID? = null,
    var kx: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var td: String,
    var te: String,
    var tt: String,
    var tx1: String,
    var tx2: String,
    var vsmax: String,
    var vsmin: String
)

data class UpdatePssSB4Command(
    @TargetAggregateIdentifier var pssSB4Id: UUID? = null,
    var kx: String,
    var ta: String,
    var tb: String,
    var tc: String,
    var td: String,
    var te: String,
    var tt: String,
    var tx1: String,
    var tx2: String,
    var vsmax: String,
    var vsmin: String
)

data class DeletePssSB4Command(@TargetAggregateIdentifier  var pssSB4Id: UUID? = null)

// single association commands

// multiple association commands


// PssSH Commands
data class CreatePssSHCommand(
    @TargetAggregateIdentifier var pssSHId: UUID? = null,
    var k: String,
    var k0: String,
    var k1: String,
    var k2: String,
    var k3: String,
    var k4: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var td: String,
    var vsmax: String,
    var vsmin: String
)

data class UpdatePssSHCommand(
    @TargetAggregateIdentifier var pssSHId: UUID? = null,
    var k: String,
    var k0: String,
    var k1: String,
    var k2: String,
    var k3: String,
    var k4: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var td: String,
    var vsmax: String,
    var vsmin: String
)

data class DeletePssSHCommand(@TargetAggregateIdentifier  var pssSHId: UUID? = null)

// single association commands

// multiple association commands


// PssSK Commands
data class CreatePssSKCommand(
    @TargetAggregateIdentifier var pssSKId: UUID? = null,
    var k1: String,
    var k2: String,
    var k3: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var vsmax: String,
    var vsmin: String
)

data class UpdatePssSKCommand(
    @TargetAggregateIdentifier var pssSKId: UUID? = null,
    var k1: String,
    var k2: String,
    var k3: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var vsmax: String,
    var vsmin: String
)

data class DeletePssSKCommand(@TargetAggregateIdentifier  var pssSKId: UUID? = null)

// single association commands

// multiple association commands


// PssWECC Commands
data class CreatePssWECCCommand(
    @TargetAggregateIdentifier var pssWECCId: UUID? = null,
    var inputSignal1Type: String,
    var inputSignal2Type: String,
    var k1: String,
    var k2: String,
    var t1: String,
    var t10: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var t9: String,
    var vcl: String,
    var vcu: String,
    var vsmax: String,
    var vsmin: String
)

data class UpdatePssWECCCommand(
    @TargetAggregateIdentifier var pssWECCId: UUID? = null,
    var inputSignal1Type: String,
    var inputSignal2Type: String,
    var k1: String,
    var k2: String,
    var t1: String,
    var t10: String,
    var t2: String,
    var t3: String,
    var t4: String,
    var t5: String,
    var t6: String,
    var t7: String,
    var t8: String,
    var t9: String,
    var vcl: String,
    var vcu: String,
    var vsmax: String,
    var vsmin: String
)

data class DeletePssWECCCommand(@TargetAggregateIdentifier  var pssWECCId: UUID? = null)

// single association commands

// multiple association commands


// Quality61850 Commands
data class CreateQuality61850Command(
    @TargetAggregateIdentifier var quality61850Id: UUID? = null,
    var badReference: String,
    var estimatorReplaced: String,
    var failure: String,
    var oldData: String,
    var operatorBlocked: String,
    var oscillatory: String,
    var outOfRange: String,
    var overFlow: String,
    var source: String,
    var suspect: String,
    var test: String,
    var validity: String
)

data class UpdateQuality61850Command(
    @TargetAggregateIdentifier var quality61850Id: UUID? = null,
    var badReference: String,
    var estimatorReplaced: String,
    var failure: String,
    var oldData: String,
    var operatorBlocked: String,
    var oscillatory: String,
    var outOfRange: String,
    var overFlow: String,
    var source: String,
    var suspect: String,
    var test: String,
    var validity: String
)

data class DeleteQuality61850Command(@TargetAggregateIdentifier  var quality61850Id: UUID? = null)

// single association commands

// multiple association commands


// RaiseLowerCommand Commands
data class CreateRaiseLowerCommandCommand(
    @TargetAggregateIdentifier  var raiseLowerCommandId: UUID? = null
)

data class UpdateRaiseLowerCommandCommand(
    @TargetAggregateIdentifier  var raiseLowerCommandId: UUID? = null
)

data class DeleteRaiseLowerCommandCommand(@TargetAggregateIdentifier  var raiseLowerCommandId: UUID? = null)

// single association commands

// multiple association commands


// RatioTapChanger Commands
data class CreateRatioTapChangerCommand(
    @TargetAggregateIdentifier var ratioTapChangerId: UUID? = null,
    var stepVoltageIncrement: String,
    var tculControlMode: String
)

data class UpdateRatioTapChangerCommand(
    @TargetAggregateIdentifier var ratioTapChangerId: UUID? = null,
    var stepVoltageIncrement: String,
    var tculControlMode: String
)

data class DeleteRatioTapChangerCommand(@TargetAggregateIdentifier  var ratioTapChangerId: UUID? = null)

// single association commands

// multiple association commands


// RatioTapChangerTable Commands
data class CreateRatioTapChangerTableCommand(
    @TargetAggregateIdentifier  var ratioTapChangerTableId: UUID? = null
)

data class UpdateRatioTapChangerTableCommand(
    @TargetAggregateIdentifier  var ratioTapChangerTableId: UUID? = null
)

data class DeleteRatioTapChangerTableCommand(@TargetAggregateIdentifier  var ratioTapChangerTableId: UUID? = null)

// single association commands

// multiple association commands


// RatioTapChangerTablePoint Commands
data class CreateRatioTapChangerTablePointCommand(
    @TargetAggregateIdentifier  var ratioTapChangerTablePointId: UUID? = null
)

data class UpdateRatioTapChangerTablePointCommand(
    @TargetAggregateIdentifier  var ratioTapChangerTablePointId: UUID? = null
)

data class DeleteRatioTapChangerTablePointCommand(@TargetAggregateIdentifier  var ratioTapChangerTablePointId: UUID? = null)

// single association commands

// multiple association commands


// Reactance Commands
data class CreateReactanceCommand(
    @TargetAggregateIdentifier var reactanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateReactanceCommand(
    @TargetAggregateIdentifier var reactanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteReactanceCommand(@TargetAggregateIdentifier  var reactanceId: UUID? = null)

// single association commands

// multiple association commands


// ReactiveCapabilityCurve Commands
data class CreateReactiveCapabilityCurveCommand(
    @TargetAggregateIdentifier  var reactiveCapabilityCurveId: UUID? = null
)

data class UpdateReactiveCapabilityCurveCommand(
    @TargetAggregateIdentifier  var reactiveCapabilityCurveId: UUID? = null
)

data class DeleteReactiveCapabilityCurveCommand(@TargetAggregateIdentifier  var reactiveCapabilityCurveId: UUID? = null)

// single association commands

// multiple association commands


// ReactivePower Commands
data class CreateReactivePowerCommand(
    @TargetAggregateIdentifier var reactivePowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateReactivePowerCommand(
    @TargetAggregateIdentifier var reactivePowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteReactivePowerCommand(@TargetAggregateIdentifier  var reactivePowerId: UUID? = null)

// single association commands

// multiple association commands


// RegularIntervalSchedule Commands
data class CreateRegularIntervalScheduleCommand(
    @TargetAggregateIdentifier var regularIntervalScheduleId: UUID? = null,
    var endTime: String,
    var timeStep: String
)

data class UpdateRegularIntervalScheduleCommand(
    @TargetAggregateIdentifier var regularIntervalScheduleId: UUID? = null,
    var endTime: String,
    var timeStep: String
)

data class DeleteRegularIntervalScheduleCommand(@TargetAggregateIdentifier  var regularIntervalScheduleId: UUID? = null)

// single association commands

// multiple association commands


// RegularTimePoint Commands
data class CreateRegularTimePointCommand(
    @TargetAggregateIdentifier var regularTimePointId: UUID? = null,
    var sequenceNumber: String,
    var value1: String,
    var value2: String
)

data class UpdateRegularTimePointCommand(
    @TargetAggregateIdentifier var regularTimePointId: UUID? = null,
    var sequenceNumber: String,
    var value1: String,
    var value2: String
)

data class DeleteRegularTimePointCommand(@TargetAggregateIdentifier  var regularTimePointId: UUID? = null)

// single association commands

// multiple association commands


// RegulatingCondEq Commands
data class CreateRegulatingCondEqCommand(
    @TargetAggregateIdentifier  var regulatingCondEqId: UUID? = null
)

data class UpdateRegulatingCondEqCommand(
    @TargetAggregateIdentifier  var regulatingCondEqId: UUID? = null
)

data class DeleteRegulatingCondEqCommand(@TargetAggregateIdentifier  var regulatingCondEqId: UUID? = null)

// single association commands

// multiple association commands


// RegulatingControl Commands
data class CreateRegulatingControlCommand(
    @TargetAggregateIdentifier var regulatingControlId: UUID? = null,
    var mode: String
)

data class UpdateRegulatingControlCommand(
    @TargetAggregateIdentifier var regulatingControlId: UUID? = null,
    var mode: String
)

data class DeleteRegulatingControlCommand(@TargetAggregateIdentifier  var regulatingControlId: UUID? = null)

// single association commands

// multiple association commands


// RegulationSchedule Commands
data class CreateRegulationScheduleCommand(
    @TargetAggregateIdentifier  var regulationScheduleId: UUID? = null
)

data class UpdateRegulationScheduleCommand(
    @TargetAggregateIdentifier  var regulationScheduleId: UUID? = null
)

data class DeleteRegulationScheduleCommand(@TargetAggregateIdentifier  var regulationScheduleId: UUID? = null)

// single association commands

// multiple association commands


// RemoteInputSignal Commands
data class CreateRemoteInputSignalCommand(
    @TargetAggregateIdentifier var remoteInputSignalId: UUID? = null,
    var remoteSignalType: String
)

data class UpdateRemoteInputSignalCommand(
    @TargetAggregateIdentifier var remoteInputSignalId: UUID? = null,
    var remoteSignalType: String
)

data class DeleteRemoteInputSignalCommand(@TargetAggregateIdentifier  var remoteInputSignalId: UUID? = null)

// single association commands

// multiple association commands


// ReportingGroup Commands
data class CreateReportingGroupCommand(
    @TargetAggregateIdentifier  var reportingGroupId: UUID? = null
)

data class UpdateReportingGroupCommand(
    @TargetAggregateIdentifier  var reportingGroupId: UUID? = null
)

data class DeleteReportingGroupCommand(@TargetAggregateIdentifier  var reportingGroupId: UUID? = null)

// single association commands

// multiple association commands


// Resistance Commands
data class CreateResistanceCommand(
    @TargetAggregateIdentifier var resistanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateResistanceCommand(
    @TargetAggregateIdentifier var resistanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteResistanceCommand(@TargetAggregateIdentifier  var resistanceId: UUID? = null)

// single association commands

// multiple association commands


// ResistancePerLength Commands
data class CreateResistancePerLengthCommand(
    @TargetAggregateIdentifier var resistancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateResistancePerLengthCommand(
    @TargetAggregateIdentifier var resistancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteResistancePerLengthCommand(@TargetAggregateIdentifier  var resistancePerLengthId: UUID? = null)

// single association commands

// multiple association commands


// RotatingMachine Commands
data class CreateRotatingMachineCommand(
    @TargetAggregateIdentifier var rotatingMachineId: UUID? = null,
    var ratedPowerFactor: String,
    var ratedS: String,
    var ratedU: String
)

data class UpdateRotatingMachineCommand(
    @TargetAggregateIdentifier var rotatingMachineId: UUID? = null,
    var ratedPowerFactor: String,
    var ratedS: String,
    var ratedU: String
)

data class DeleteRotatingMachineCommand(@TargetAggregateIdentifier  var rotatingMachineId: UUID? = null)

// single association commands

// multiple association commands


// RotatingMachineDynamics Commands
data class CreateRotatingMachineDynamicsCommand(
    @TargetAggregateIdentifier var rotatingMachineDynamicsId: UUID? = null,
    var damping: String,
    var inertia: String,
    var saturationFactor: String,
    var saturationFactor120: String,
    var statorLeakageReactance: String,
    var statorResistance: String
)

data class UpdateRotatingMachineDynamicsCommand(
    @TargetAggregateIdentifier var rotatingMachineDynamicsId: UUID? = null,
    var damping: String,
    var inertia: String,
    var saturationFactor: String,
    var saturationFactor120: String,
    var statorLeakageReactance: String,
    var statorResistance: String
)

data class DeleteRotatingMachineDynamicsCommand(@TargetAggregateIdentifier  var rotatingMachineDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// RotationSpeed Commands
data class CreateRotationSpeedCommand(
    @TargetAggregateIdentifier var rotationSpeedId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateRotationSpeedCommand(
    @TargetAggregateIdentifier var rotationSpeedId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteRotationSpeedCommand(@TargetAggregateIdentifier  var rotationSpeedId: UUID? = null)

// single association commands

// multiple association commands


// Season Commands
data class CreateSeasonCommand(
    @TargetAggregateIdentifier var seasonId: UUID? = null,
    var endDate: String,
    var startDate: String
)

data class UpdateSeasonCommand(
    @TargetAggregateIdentifier var seasonId: UUID? = null,
    var endDate: String,
    var startDate: String
)

data class DeleteSeasonCommand(@TargetAggregateIdentifier  var seasonId: UUID? = null)

// single association commands

// multiple association commands


// SeasonDayTypeSchedule Commands
data class CreateSeasonDayTypeScheduleCommand(
    @TargetAggregateIdentifier  var seasonDayTypeScheduleId: UUID? = null
)

data class UpdateSeasonDayTypeScheduleCommand(
    @TargetAggregateIdentifier  var seasonDayTypeScheduleId: UUID? = null
)

data class DeleteSeasonDayTypeScheduleCommand(@TargetAggregateIdentifier  var seasonDayTypeScheduleId: UUID? = null)

// single association commands

// multiple association commands


// Seconds Commands
data class CreateSecondsCommand(
    @TargetAggregateIdentifier var secondsId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateSecondsCommand(
    @TargetAggregateIdentifier var secondsId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteSecondsCommand(@TargetAggregateIdentifier  var secondsId: UUID? = null)

// single association commands

// multiple association commands


// SeriesCompensator Commands
data class CreateSeriesCompensatorCommand(
    @TargetAggregateIdentifier var seriesCompensatorId: UUID? = null,
    var r: String,
    var r0: String,
    var varistorPresent: String,
    var varistorRatedCurrent: String,
    var varistorVoltageThreshold: String,
    var x: String,
    var x0: String
)

data class UpdateSeriesCompensatorCommand(
    @TargetAggregateIdentifier var seriesCompensatorId: UUID? = null,
    var r: String,
    var r0: String,
    var varistorPresent: String,
    var varistorRatedCurrent: String,
    var varistorVoltageThreshold: String,
    var x: String,
    var x0: String
)

data class DeleteSeriesCompensatorCommand(@TargetAggregateIdentifier  var seriesCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// SetPoint Commands
data class CreateSetPointCommand(
    @TargetAggregateIdentifier var setPointId: UUID? = null,
    var normalValue: String,
    var value: String
)

data class UpdateSetPointCommand(
    @TargetAggregateIdentifier var setPointId: UUID? = null,
    var normalValue: String,
    var value: String
)

data class DeleteSetPointCommand(@TargetAggregateIdentifier  var setPointId: UUID? = null)

// single association commands

// multiple association commands


// ShuntCompensator Commands
data class CreateShuntCompensatorCommand(
    @TargetAggregateIdentifier var shuntCompensatorId: UUID? = null,
    var aVRDelay: String,
    var grounded: String,
    var maximumSections: String,
    var nomU: String,
    var normalSections: String,
    var switchOnCount: String,
    var switchOnDate: String,
    var voltageSensitivity: String
)

data class UpdateShuntCompensatorCommand(
    @TargetAggregateIdentifier var shuntCompensatorId: UUID? = null,
    var aVRDelay: String,
    var grounded: String,
    var maximumSections: String,
    var nomU: String,
    var normalSections: String,
    var switchOnCount: String,
    var switchOnDate: String,
    var voltageSensitivity: String
)

data class DeleteShuntCompensatorCommand(@TargetAggregateIdentifier  var shuntCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// Simple_Float Commands
data class CreateSimple_FloatCommand(
    @TargetAggregateIdentifier var simple_FloatId: UUID? = null,
    var value: String
)

data class UpdateSimple_FloatCommand(
    @TargetAggregateIdentifier var simple_FloatId: UUID? = null,
    var value: String
)

data class DeleteSimple_FloatCommand(@TargetAggregateIdentifier  var simple_FloatId: UUID? = null)

// single association commands

// multiple association commands


// SolarGeneratingUnit Commands
data class CreateSolarGeneratingUnitCommand(
    @TargetAggregateIdentifier  var solarGeneratingUnitId: UUID? = null
)

data class UpdateSolarGeneratingUnitCommand(
    @TargetAggregateIdentifier  var solarGeneratingUnitId: UUID? = null
)

data class DeleteSolarGeneratingUnitCommand(@TargetAggregateIdentifier  var solarGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// StateVariablesVersion Commands
data class CreateStateVariablesVersionCommand(
    @TargetAggregateIdentifier var stateVariablesVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class UpdateStateVariablesVersionCommand(
    @TargetAggregateIdentifier var stateVariablesVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class DeleteStateVariablesVersionCommand(@TargetAggregateIdentifier  var stateVariablesVersionId: UUID? = null)

// single association commands

// multiple association commands


// StaticVarCompensator Commands
data class CreateStaticVarCompensatorCommand(
    @TargetAggregateIdentifier var staticVarCompensatorId: UUID? = null,
    var capacitiveRating: String,
    var inductiveRating: String,
    var slope: String,
    var sVCControlMode: String,
    var voltageSetPoint: String
)

data class UpdateStaticVarCompensatorCommand(
    @TargetAggregateIdentifier var staticVarCompensatorId: UUID? = null,
    var capacitiveRating: String,
    var inductiveRating: String,
    var slope: String,
    var sVCControlMode: String,
    var voltageSetPoint: String
)

data class DeleteStaticVarCompensatorCommand(@TargetAggregateIdentifier  var staticVarCompensatorId: UUID? = null)

// single association commands

// multiple association commands


// Staticpowersystemmodel Commands
data class CreateStaticpowersystemmodelCommand(
    @TargetAggregateIdentifier  var staticpowersystemmodelId: UUID? = null
)

data class UpdateStaticpowersystemmodelCommand(
    @TargetAggregateIdentifier  var staticpowersystemmodelId: UUID? = null
)

data class DeleteStaticpowersystemmodelCommand(@TargetAggregateIdentifier  var staticpowersystemmodelId: UUID? = null)

// single association commands

// multiple association commands


// StationSupply Commands
data class CreateStationSupplyCommand(
    @TargetAggregateIdentifier  var stationSupplyId: UUID? = null
)

data class UpdateStationSupplyCommand(
    @TargetAggregateIdentifier  var stationSupplyId: UUID? = null
)

data class DeleteStationSupplyCommand(@TargetAggregateIdentifier  var stationSupplyId: UUID? = null)

// single association commands

// multiple association commands


// SteadyStateHypothesisVersion Commands
data class CreateSteadyStateHypothesisVersionCommand(
    @TargetAggregateIdentifier var steadyStateHypothesisVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class UpdateSteadyStateHypothesisVersionCommand(
    @TargetAggregateIdentifier var steadyStateHypothesisVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class DeleteSteadyStateHypothesisVersionCommand(@TargetAggregateIdentifier  var steadyStateHypothesisVersionId: UUID? = null)

// single association commands

// multiple association commands


// StringMeasurement Commands
data class CreateStringMeasurementCommand(
    @TargetAggregateIdentifier  var stringMeasurementId: UUID? = null
)

data class UpdateStringMeasurementCommand(
    @TargetAggregateIdentifier  var stringMeasurementId: UUID? = null
)

data class DeleteStringMeasurementCommand(@TargetAggregateIdentifier  var stringMeasurementId: UUID? = null)

// single association commands

// multiple association commands


// StringMeasurementValue Commands
data class CreateStringMeasurementValueCommand(
    @TargetAggregateIdentifier var stringMeasurementValueId: UUID? = null,
    var value: String
)

data class UpdateStringMeasurementValueCommand(
    @TargetAggregateIdentifier var stringMeasurementValueId: UUID? = null,
    var value: String
)

data class DeleteStringMeasurementValueCommand(@TargetAggregateIdentifier  var stringMeasurementValueId: UUID? = null)

// single association commands

// multiple association commands


// StringProxy Commands
data class CreateStringProxyCommand(
    @TargetAggregateIdentifier  var stringProxyId: UUID? = null
)

data class UpdateStringProxyCommand(
    @TargetAggregateIdentifier  var stringProxyId: UUID? = null
)

data class DeleteStringProxyCommand(@TargetAggregateIdentifier  var stringProxyId: UUID? = null)

// single association commands

// multiple association commands


// SubGeographicalRegion Commands
data class CreateSubGeographicalRegionCommand(
    @TargetAggregateIdentifier  var subGeographicalRegionId: UUID? = null
)

data class UpdateSubGeographicalRegionCommand(
    @TargetAggregateIdentifier  var subGeographicalRegionId: UUID? = null
)

data class DeleteSubGeographicalRegionCommand(@TargetAggregateIdentifier  var subGeographicalRegionId: UUID? = null)

// single association commands

// multiple association commands


// SubLoadArea Commands
data class CreateSubLoadAreaCommand(
    @TargetAggregateIdentifier  var subLoadAreaId: UUID? = null
)

data class UpdateSubLoadAreaCommand(
    @TargetAggregateIdentifier  var subLoadAreaId: UUID? = null
)

data class DeleteSubLoadAreaCommand(@TargetAggregateIdentifier  var subLoadAreaId: UUID? = null)

// single association commands

// multiple association commands


// Substation Commands
data class CreateSubstationCommand(
    @TargetAggregateIdentifier  var substationId: UUID? = null
)

data class UpdateSubstationCommand(
    @TargetAggregateIdentifier  var substationId: UUID? = null
)

data class DeleteSubstationCommand(@TargetAggregateIdentifier  var substationId: UUID? = null)

// single association commands

// multiple association commands


// Susceptance Commands
data class CreateSusceptanceCommand(
    @TargetAggregateIdentifier var susceptanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateSusceptanceCommand(
    @TargetAggregateIdentifier var susceptanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteSusceptanceCommand(@TargetAggregateIdentifier  var susceptanceId: UUID? = null)

// single association commands

// multiple association commands


// SvInjection Commands
data class CreateSvInjectionCommand(
    @TargetAggregateIdentifier var svInjectionId: UUID? = null,
    var pInjection: String,
    var qInjection: String
)

data class UpdateSvInjectionCommand(
    @TargetAggregateIdentifier var svInjectionId: UUID? = null,
    var pInjection: String,
    var qInjection: String
)

data class DeleteSvInjectionCommand(@TargetAggregateIdentifier  var svInjectionId: UUID? = null)

// single association commands

// multiple association commands


// SvPowerFlow Commands
data class CreateSvPowerFlowCommand(
    @TargetAggregateIdentifier var svPowerFlowId: UUID? = null,
    var p: String,
    var q: String
)

data class UpdateSvPowerFlowCommand(
    @TargetAggregateIdentifier var svPowerFlowId: UUID? = null,
    var p: String,
    var q: String
)

data class DeleteSvPowerFlowCommand(@TargetAggregateIdentifier  var svPowerFlowId: UUID? = null)

// single association commands

// multiple association commands


// SvShuntCompensatorSections Commands
data class CreateSvShuntCompensatorSectionsCommand(
    @TargetAggregateIdentifier var svShuntCompensatorSectionsId: UUID? = null,
    var sections: String
)

data class UpdateSvShuntCompensatorSectionsCommand(
    @TargetAggregateIdentifier var svShuntCompensatorSectionsId: UUID? = null,
    var sections: String
)

data class DeleteSvShuntCompensatorSectionsCommand(@TargetAggregateIdentifier  var svShuntCompensatorSectionsId: UUID? = null)

// single association commands

// multiple association commands


// SvStatus Commands
data class CreateSvStatusCommand(
    @TargetAggregateIdentifier var svStatusId: UUID? = null,
    var inService: String
)

data class UpdateSvStatusCommand(
    @TargetAggregateIdentifier var svStatusId: UUID? = null,
    var inService: String
)

data class DeleteSvStatusCommand(@TargetAggregateIdentifier  var svStatusId: UUID? = null)

// single association commands

// multiple association commands


// SvTapStep Commands
data class CreateSvTapStepCommand(
    @TargetAggregateIdentifier var svTapStepId: UUID? = null,
    var position: String
)

data class UpdateSvTapStepCommand(
    @TargetAggregateIdentifier var svTapStepId: UUID? = null,
    var position: String
)

data class DeleteSvTapStepCommand(@TargetAggregateIdentifier  var svTapStepId: UUID? = null)

// single association commands

// multiple association commands


// SvVoltage Commands
data class CreateSvVoltageCommand(
    @TargetAggregateIdentifier var svVoltageId: UUID? = null,
    var angle: String,
    var v: String
)

data class UpdateSvVoltageCommand(
    @TargetAggregateIdentifier var svVoltageId: UUID? = null,
    var angle: String,
    var v: String
)

data class DeleteSvVoltageCommand(@TargetAggregateIdentifier  var svVoltageId: UUID? = null)

// single association commands

// multiple association commands


// SwitchIt Commands
data class CreateSwitchItCommand(
    @TargetAggregateIdentifier var switchItId: UUID? = null,
    var open: String
)

data class UpdateSwitchItCommand(
    @TargetAggregateIdentifier var switchItId: UUID? = null,
    var open: String
)

data class DeleteSwitchItCommand(@TargetAggregateIdentifier  var switchItId: UUID? = null)

// single association commands

// multiple association commands


// SwitchProxy Commands
data class CreateSwitchProxyCommand(
    @TargetAggregateIdentifier var switchProxyId: UUID? = null,
    var normalOpen: String,
    var ratedCurrent: String,
    var retained: String
)

data class UpdateSwitchProxyCommand(
    @TargetAggregateIdentifier var switchProxyId: UUID? = null,
    var normalOpen: String,
    var ratedCurrent: String,
    var retained: String
)

data class DeleteSwitchProxyCommand(@TargetAggregateIdentifier  var switchProxyId: UUID? = null)

// single association commands

// multiple association commands


// SwitchSchedule Commands
data class CreateSwitchScheduleCommand(
    @TargetAggregateIdentifier  var switchScheduleId: UUID? = null
)

data class UpdateSwitchScheduleCommand(
    @TargetAggregateIdentifier  var switchScheduleId: UUID? = null
)

data class DeleteSwitchScheduleCommand(@TargetAggregateIdentifier  var switchScheduleId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachine Commands
data class CreateSynchronousMachineCommand(
    @TargetAggregateIdentifier var synchronousMachineId: UUID? = null,
    var earthing: String,
    var earthingStarPointR: String,
    var earthingStarPointX: String,
    var ikk: String,
    var maxQ: String,
    var minQ: String,
    var mu: String,
    var qPercent: String,
    var r: String,
    var r0: String,
    var r2: String,
    var satDirectSubtransX: String,
    var satDirectSyncX: String,
    var satDirectTransX: String,
    var shortCircuitRotorType: String,
    var type: String,
    var voltageRegulationRange: String,
    var x0: String,
    var x2: String
)

data class UpdateSynchronousMachineCommand(
    @TargetAggregateIdentifier var synchronousMachineId: UUID? = null,
    var earthing: String,
    var earthingStarPointR: String,
    var earthingStarPointX: String,
    var ikk: String,
    var maxQ: String,
    var minQ: String,
    var mu: String,
    var qPercent: String,
    var r: String,
    var r0: String,
    var r2: String,
    var satDirectSubtransX: String,
    var satDirectSyncX: String,
    var satDirectTransX: String,
    var shortCircuitRotorType: String,
    var type: String,
    var voltageRegulationRange: String,
    var x0: String,
    var x2: String
)

data class DeleteSynchronousMachineCommand(@TargetAggregateIdentifier  var synchronousMachineId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineDetailed Commands
data class CreateSynchronousMachineDetailedCommand(
    @TargetAggregateIdentifier var synchronousMachineDetailedId: UUID? = null,
    var efdBaseRatio: String,
    var ifdBaseType: String,
    var ifdBaseValue: String,
    var saturationFactor120QAxis: String,
    var saturationFactorQAxis: String
)

data class UpdateSynchronousMachineDetailedCommand(
    @TargetAggregateIdentifier var synchronousMachineDetailedId: UUID? = null,
    var efdBaseRatio: String,
    var ifdBaseType: String,
    var ifdBaseValue: String,
    var saturationFactor120QAxis: String,
    var saturationFactorQAxis: String
)

data class DeleteSynchronousMachineDetailedCommand(@TargetAggregateIdentifier  var synchronousMachineDetailedId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineDynamics Commands
data class CreateSynchronousMachineDynamicsCommand(
    @TargetAggregateIdentifier  var synchronousMachineDynamicsId: UUID? = null
)

data class UpdateSynchronousMachineDynamicsCommand(
    @TargetAggregateIdentifier  var synchronousMachineDynamicsId: UUID? = null
)

data class DeleteSynchronousMachineDynamicsCommand(@TargetAggregateIdentifier  var synchronousMachineDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineEquivalentCircuit Commands
data class CreateSynchronousMachineEquivalentCircuitCommand(
    @TargetAggregateIdentifier var synchronousMachineEquivalentCircuitId: UUID? = null,
    var r1d: String,
    var r1q: String,
    var r2q: String,
    var rfd: String,
    var x1d: String,
    var x1q: String,
    var x2q: String,
    var xad: String,
    var xaq: String,
    var xf1d: String,
    var xfd: String
)

data class UpdateSynchronousMachineEquivalentCircuitCommand(
    @TargetAggregateIdentifier var synchronousMachineEquivalentCircuitId: UUID? = null,
    var r1d: String,
    var r1q: String,
    var r2q: String,
    var rfd: String,
    var x1d: String,
    var x1q: String,
    var x2q: String,
    var xad: String,
    var xaq: String,
    var xf1d: String,
    var xfd: String
)

data class DeleteSynchronousMachineEquivalentCircuitCommand(@TargetAggregateIdentifier  var synchronousMachineEquivalentCircuitId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineSimplified Commands
data class CreateSynchronousMachineSimplifiedCommand(
    @TargetAggregateIdentifier  var synchronousMachineSimplifiedId: UUID? = null
)

data class UpdateSynchronousMachineSimplifiedCommand(
    @TargetAggregateIdentifier  var synchronousMachineSimplifiedId: UUID? = null
)

data class DeleteSynchronousMachineSimplifiedCommand(@TargetAggregateIdentifier  var synchronousMachineSimplifiedId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineTimeConstantReactance Commands
data class CreateSynchronousMachineTimeConstantReactanceCommand(
    @TargetAggregateIdentifier var synchronousMachineTimeConstantReactanceId: UUID? = null,
    var ks: String,
    var modelType: String,
    var rotorType: String,
    var tc: String,
    var tpdo: String,
    var tppdo: String,
    var tppqo: String,
    var tpqo: String,
    var xDirectSubtrans: String,
    var xDirectSync: String,
    var xDirectTrans: String,
    var xQuadSubtrans: String,
    var xQuadSync: String,
    var xQuadTrans: String
)

data class UpdateSynchronousMachineTimeConstantReactanceCommand(
    @TargetAggregateIdentifier var synchronousMachineTimeConstantReactanceId: UUID? = null,
    var ks: String,
    var modelType: String,
    var rotorType: String,
    var tc: String,
    var tpdo: String,
    var tppdo: String,
    var tppqo: String,
    var tpqo: String,
    var xDirectSubtrans: String,
    var xDirectSync: String,
    var xDirectTrans: String,
    var xQuadSubtrans: String,
    var xQuadSync: String,
    var xQuadTrans: String
)

data class DeleteSynchronousMachineTimeConstantReactanceCommand(@TargetAggregateIdentifier  var synchronousMachineTimeConstantReactanceId: UUID? = null)

// single association commands

// multiple association commands


// SynchronousMachineUserDefined Commands
data class CreateSynchronousMachineUserDefinedCommand(
    @TargetAggregateIdentifier var synchronousMachineUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateSynchronousMachineUserDefinedCommand(
    @TargetAggregateIdentifier var synchronousMachineUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteSynchronousMachineUserDefinedCommand(@TargetAggregateIdentifier  var synchronousMachineUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// TapChanger Commands
data class CreateTapChangerCommand(
    @TargetAggregateIdentifier var tapChangerId: UUID? = null,
    var highStep: String,
    var lowStep: String,
    var ltcFlag: String,
    var neutralStep: String,
    var neutralU: String,
    var normalStep: String
)

data class UpdateTapChangerCommand(
    @TargetAggregateIdentifier var tapChangerId: UUID? = null,
    var highStep: String,
    var lowStep: String,
    var ltcFlag: String,
    var neutralStep: String,
    var neutralU: String,
    var normalStep: String
)

data class DeleteTapChangerCommand(@TargetAggregateIdentifier  var tapChangerId: UUID? = null)

// single association commands

// multiple association commands


// TapChangerControl Commands
data class CreateTapChangerControlCommand(
    @TargetAggregateIdentifier  var tapChangerControlId: UUID? = null
)

data class UpdateTapChangerControlCommand(
    @TargetAggregateIdentifier  var tapChangerControlId: UUID? = null
)

data class DeleteTapChangerControlCommand(@TargetAggregateIdentifier  var tapChangerControlId: UUID? = null)

// single association commands

// multiple association commands


// TapChangerTablePoint Commands
data class CreateTapChangerTablePointCommand(
    @TargetAggregateIdentifier var tapChangerTablePointId: UUID? = null,
    var b: String,
    var g: String,
    var r: String,
    var ratio: String,
    var step: String,
    var x: String
)

data class UpdateTapChangerTablePointCommand(
    @TargetAggregateIdentifier var tapChangerTablePointId: UUID? = null,
    var b: String,
    var g: String,
    var r: String,
    var ratio: String,
    var step: String,
    var x: String
)

data class DeleteTapChangerTablePointCommand(@TargetAggregateIdentifier  var tapChangerTablePointId: UUID? = null)

// single association commands

// multiple association commands


// TapSchedule Commands
data class CreateTapScheduleCommand(
    @TargetAggregateIdentifier  var tapScheduleId: UUID? = null
)

data class UpdateTapScheduleCommand(
    @TargetAggregateIdentifier  var tapScheduleId: UUID? = null
)

data class DeleteTapScheduleCommand(@TargetAggregateIdentifier  var tapScheduleId: UUID? = null)

// single association commands

// multiple association commands


// Temperature Commands
data class CreateTemperatureCommand(
    @TargetAggregateIdentifier var temperatureId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateTemperatureCommand(
    @TargetAggregateIdentifier var temperatureId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteTemperatureCommand(@TargetAggregateIdentifier  var temperatureId: UUID? = null)

// single association commands

// multiple association commands


// Terminal Commands
data class CreateTerminalCommand(
    @TargetAggregateIdentifier  var terminalId: UUID? = null
)

data class UpdateTerminalCommand(
    @TargetAggregateIdentifier  var terminalId: UUID? = null
)

data class DeleteTerminalCommand(@TargetAggregateIdentifier  var terminalId: UUID? = null)

// single association commands

// multiple association commands


// TextDiagramObject Commands
data class CreateTextDiagramObjectCommand(
    @TargetAggregateIdentifier var textDiagramObjectId: UUID? = null,
    var text: String
)

data class UpdateTextDiagramObjectCommand(
    @TargetAggregateIdentifier var textDiagramObjectId: UUID? = null,
    var text: String
)

data class DeleteTextDiagramObjectCommand(@TargetAggregateIdentifier  var textDiagramObjectId: UUID? = null)

// single association commands

// multiple association commands


// ThermalGeneratingUnit Commands
data class CreateThermalGeneratingUnitCommand(
    @TargetAggregateIdentifier  var thermalGeneratingUnitId: UUID? = null
)

data class UpdateThermalGeneratingUnitCommand(
    @TargetAggregateIdentifier  var thermalGeneratingUnitId: UUID? = null
)

data class DeleteThermalGeneratingUnitCommand(@TargetAggregateIdentifier  var thermalGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// TieFlow Commands
data class CreateTieFlowCommand(
    @TargetAggregateIdentifier var tieFlowId: UUID? = null,
    var positiveFlowIn: String
)

data class UpdateTieFlowCommand(
    @TargetAggregateIdentifier var tieFlowId: UUID? = null,
    var positiveFlowIn: String
)

data class DeleteTieFlowCommand(@TargetAggregateIdentifier  var tieFlowId: UUID? = null)

// single association commands

// multiple association commands


// TopologicalIsland Commands
data class CreateTopologicalIslandCommand(
    @TargetAggregateIdentifier  var topologicalIslandId: UUID? = null
)

data class UpdateTopologicalIslandCommand(
    @TargetAggregateIdentifier  var topologicalIslandId: UUID? = null
)

data class DeleteTopologicalIslandCommand(@TargetAggregateIdentifier  var topologicalIslandId: UUID? = null)

// single association commands

// multiple association commands


// TopologicalNode Commands
data class CreateTopologicalNodeCommand(
    @TargetAggregateIdentifier var topologicalNodeId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class UpdateTopologicalNodeCommand(
    @TargetAggregateIdentifier var topologicalNodeId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class DeleteTopologicalNodeCommand(@TargetAggregateIdentifier  var topologicalNodeId: UUID? = null)

// single association commands

// multiple association commands


// TopologyBoundaryVersion Commands
data class CreateTopologyBoundaryVersionCommand(
    @TargetAggregateIdentifier var topologyBoundaryVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class UpdateTopologyBoundaryVersionCommand(
    @TargetAggregateIdentifier var topologyBoundaryVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class DeleteTopologyBoundaryVersionCommand(@TargetAggregateIdentifier  var topologyBoundaryVersionId: UUID? = null)

// single association commands

// multiple association commands


// TopologyVersion Commands
data class CreateTopologyVersionCommand(
    @TargetAggregateIdentifier var topologyVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class UpdateTopologyVersionCommand(
    @TargetAggregateIdentifier var topologyVersionId: UUID? = null,
    var baseUML: String,
    var baseURI: String,
    var date: String,
    var differenceModelURI: String,
    var entsoeUML: String,
    var entsoeURI: String,
    var modelDescriptionURI: String,
    var namespaceRDF: String,
    var namespaceUML: String,
    var shortName: String
)

data class DeleteTopologyVersionCommand(@TargetAggregateIdentifier  var topologyVersionId: UUID? = null)

// single association commands

// multiple association commands


// TransformerEnd Commands
data class CreateTransformerEndCommand(
    @TargetAggregateIdentifier var transformerEndId: UUID? = null,
    var endNumber: String,
    var grounded: String,
    var rground: String,
    var xground: String
)

data class UpdateTransformerEndCommand(
    @TargetAggregateIdentifier var transformerEndId: UUID? = null,
    var endNumber: String,
    var grounded: String,
    var rground: String,
    var xground: String
)

data class DeleteTransformerEndCommand(@TargetAggregateIdentifier  var transformerEndId: UUID? = null)

// single association commands

// multiple association commands


// TurbLCFB1 Commands
data class CreateTurbLCFB1Command(
    @TargetAggregateIdentifier var turbLCFB1Id: UUID? = null,
    var db: String,
    var emax: String,
    var fb: String,
    var fbf: String,
    var irmax: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var pbf: String,
    var pmwset: String,
    var speedReferenceGovernor: String,
    var tpelec: String
)

data class UpdateTurbLCFB1Command(
    @TargetAggregateIdentifier var turbLCFB1Id: UUID? = null,
    var db: String,
    var emax: String,
    var fb: String,
    var fbf: String,
    var irmax: String,
    var ki: String,
    var kp: String,
    var mwbase: String,
    var pbf: String,
    var pmwset: String,
    var speedReferenceGovernor: String,
    var tpelec: String
)

data class DeleteTurbLCFB1Command(@TargetAggregateIdentifier  var turbLCFB1Id: UUID? = null)

// single association commands

// multiple association commands


// TurbineGovernorDynamics Commands
data class CreateTurbineGovernorDynamicsCommand(
    @TargetAggregateIdentifier  var turbineGovernorDynamicsId: UUID? = null
)

data class UpdateTurbineGovernorDynamicsCommand(
    @TargetAggregateIdentifier  var turbineGovernorDynamicsId: UUID? = null
)

data class DeleteTurbineGovernorDynamicsCommand(@TargetAggregateIdentifier  var turbineGovernorDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// TurbineGovernorUserDefined Commands
data class CreateTurbineGovernorUserDefinedCommand(
    @TargetAggregateIdentifier var turbineGovernorUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateTurbineGovernorUserDefinedCommand(
    @TargetAggregateIdentifier var turbineGovernorUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteTurbineGovernorUserDefinedCommand(@TargetAggregateIdentifier  var turbineGovernorUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// TurbineLoadControllerDynamics Commands
data class CreateTurbineLoadControllerDynamicsCommand(
    @TargetAggregateIdentifier  var turbineLoadControllerDynamicsId: UUID? = null
)

data class UpdateTurbineLoadControllerDynamicsCommand(
    @TargetAggregateIdentifier  var turbineLoadControllerDynamicsId: UUID? = null
)

data class DeleteTurbineLoadControllerDynamicsCommand(@TargetAggregateIdentifier  var turbineLoadControllerDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// TurbineLoadControllerUserDefined Commands
data class CreateTurbineLoadControllerUserDefinedCommand(
    @TargetAggregateIdentifier var turbineLoadControllerUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateTurbineLoadControllerUserDefinedCommand(
    @TargetAggregateIdentifier var turbineLoadControllerUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteTurbineLoadControllerUserDefinedCommand(@TargetAggregateIdentifier  var turbineLoadControllerUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// UnderexcLim2Simplified Commands
data class CreateUnderexcLim2SimplifiedCommand(
    @TargetAggregateIdentifier var underexcLim2SimplifiedId: UUID? = null,
    var kui: String,
    var p0: String,
    var p1: String,
    var q0: String,
    var q1: String,
    var vuimax: String,
    var vuimin: String
)

data class UpdateUnderexcLim2SimplifiedCommand(
    @TargetAggregateIdentifier var underexcLim2SimplifiedId: UUID? = null,
    var kui: String,
    var p0: String,
    var p1: String,
    var q0: String,
    var q1: String,
    var vuimax: String,
    var vuimin: String
)

data class DeleteUnderexcLim2SimplifiedCommand(@TargetAggregateIdentifier  var underexcLim2SimplifiedId: UUID? = null)

// single association commands

// multiple association commands


// UnderexcLimIEEE1 Commands
data class CreateUnderexcLimIEEE1Command(
    @TargetAggregateIdentifier var underexcLimIEEE1Id: UUID? = null,
    var kuc: String,
    var kuf: String,
    var kui: String,
    var kul: String,
    var kur: String,
    var tu1: String,
    var tu2: String,
    var tu3: String,
    var tu4: String,
    var vucmax: String,
    var vuimax: String,
    var vuimin: String,
    var vulmax: String,
    var vulmin: String,
    var vurmax: String
)

data class UpdateUnderexcLimIEEE1Command(
    @TargetAggregateIdentifier var underexcLimIEEE1Id: UUID? = null,
    var kuc: String,
    var kuf: String,
    var kui: String,
    var kul: String,
    var kur: String,
    var tu1: String,
    var tu2: String,
    var tu3: String,
    var tu4: String,
    var vucmax: String,
    var vuimax: String,
    var vuimin: String,
    var vulmax: String,
    var vulmin: String,
    var vurmax: String
)

data class DeleteUnderexcLimIEEE1Command(@TargetAggregateIdentifier  var underexcLimIEEE1Id: UUID? = null)

// single association commands

// multiple association commands


// UnderexcLimIEEE2 Commands
data class CreateUnderexcLimIEEE2Command(
    @TargetAggregateIdentifier var underexcLimIEEE2Id: UUID? = null,
    var k1: String,
    var k2: String,
    var kfb: String,
    var kuf: String,
    var kui: String,
    var kul: String,
    var p0: String,
    var p1: String,
    var p10: String,
    var p2: String,
    var p3: String,
    var p4: String,
    var p5: String,
    var p6: String,
    var p7: String,
    var p8: String,
    var p9: String,
    var q0: String,
    var q1: String,
    var q10: String,
    var q2: String,
    var q3: String,
    var q4: String,
    var q5: String,
    var q6: String,
    var q7: String,
    var q8: String,
    var q9: String,
    var tu1: String,
    var tu2: String,
    var tu3: String,
    var tu4: String,
    var tul: String,
    var tup: String,
    var tuq: String,
    var tuv: String,
    var vuimax: String,
    var vuimin: String,
    var vulmax: String,
    var vulmin: String
)

data class UpdateUnderexcLimIEEE2Command(
    @TargetAggregateIdentifier var underexcLimIEEE2Id: UUID? = null,
    var k1: String,
    var k2: String,
    var kfb: String,
    var kuf: String,
    var kui: String,
    var kul: String,
    var p0: String,
    var p1: String,
    var p10: String,
    var p2: String,
    var p3: String,
    var p4: String,
    var p5: String,
    var p6: String,
    var p7: String,
    var p8: String,
    var p9: String,
    var q0: String,
    var q1: String,
    var q10: String,
    var q2: String,
    var q3: String,
    var q4: String,
    var q5: String,
    var q6: String,
    var q7: String,
    var q8: String,
    var q9: String,
    var tu1: String,
    var tu2: String,
    var tu3: String,
    var tu4: String,
    var tul: String,
    var tup: String,
    var tuq: String,
    var tuv: String,
    var vuimax: String,
    var vuimin: String,
    var vulmax: String,
    var vulmin: String
)

data class DeleteUnderexcLimIEEE2Command(@TargetAggregateIdentifier  var underexcLimIEEE2Id: UUID? = null)

// single association commands

// multiple association commands


// UnderexcLimX1 Commands
data class CreateUnderexcLimX1Command(
    @TargetAggregateIdentifier var underexcLimX1Id: UUID? = null,
    var k: String,
    var kf2: String,
    var km: String,
    var melmax: String,
    var tf2: String,
    var tm: String
)

data class UpdateUnderexcLimX1Command(
    @TargetAggregateIdentifier var underexcLimX1Id: UUID? = null,
    var k: String,
    var kf2: String,
    var km: String,
    var melmax: String,
    var tf2: String,
    var tm: String
)

data class DeleteUnderexcLimX1Command(@TargetAggregateIdentifier  var underexcLimX1Id: UUID? = null)

// single association commands

// multiple association commands


// UnderexcLimX2 Commands
data class CreateUnderexcLimX2Command(
    @TargetAggregateIdentifier var underexcLimX2Id: UUID? = null,
    var kf2: String,
    var km: String,
    var melmax: String,
    var qo: String,
    var r: String,
    var tf2: String,
    var tm: String
)

data class UpdateUnderexcLimX2Command(
    @TargetAggregateIdentifier var underexcLimX2Id: UUID? = null,
    var kf2: String,
    var km: String,
    var melmax: String,
    var qo: String,
    var r: String,
    var tf2: String,
    var tm: String
)

data class DeleteUnderexcLimX2Command(@TargetAggregateIdentifier  var underexcLimX2Id: UUID? = null)

// single association commands

// multiple association commands


// UnderexcitationLimiterDynamics Commands
data class CreateUnderexcitationLimiterDynamicsCommand(
    @TargetAggregateIdentifier  var underexcitationLimiterDynamicsId: UUID? = null
)

data class UpdateUnderexcitationLimiterDynamicsCommand(
    @TargetAggregateIdentifier  var underexcitationLimiterDynamicsId: UUID? = null
)

data class DeleteUnderexcitationLimiterDynamicsCommand(@TargetAggregateIdentifier  var underexcitationLimiterDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// UnderexcitationLimiterUserDefined Commands
data class CreateUnderexcitationLimiterUserDefinedCommand(
    @TargetAggregateIdentifier var underexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateUnderexcitationLimiterUserDefinedCommand(
    @TargetAggregateIdentifier var underexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteUnderexcitationLimiterUserDefinedCommand(@TargetAggregateIdentifier  var underexcitationLimiterUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// Unresolvedname Commands
data class CreateUnresolvednameCommand(
    @TargetAggregateIdentifier  var unresolvednameId: UUID? = null
)

data class UpdateUnresolvednameCommand(
    @TargetAggregateIdentifier  var unresolvednameId: UUID? = null
)

data class DeleteUnresolvednameCommand(@TargetAggregateIdentifier  var unresolvednameId: UUID? = null)

// single association commands

// multiple association commands


// VAdjIEEE Commands
data class CreateVAdjIEEECommand(
    @TargetAggregateIdentifier var vAdjIEEEId: UUID? = null,
    var adjslew: String,
    var taoff: String,
    var taon: String,
    var vadjf: String,
    var vadjmax: String,
    var vadjmin: String
)

data class UpdateVAdjIEEECommand(
    @TargetAggregateIdentifier var vAdjIEEEId: UUID? = null,
    var adjslew: String,
    var taoff: String,
    var taon: String,
    var vadjf: String,
    var vadjmax: String,
    var vadjmin: String
)

data class DeleteVAdjIEEECommand(@TargetAggregateIdentifier  var vAdjIEEEId: UUID? = null)

// single association commands

// multiple association commands


// VCompIEEEType1 Commands
data class CreateVCompIEEEType1Command(
    @TargetAggregateIdentifier var vCompIEEEType1Id: UUID? = null,
    var rc: String,
    var tr: String,
    var xc: String
)

data class UpdateVCompIEEEType1Command(
    @TargetAggregateIdentifier var vCompIEEEType1Id: UUID? = null,
    var rc: String,
    var tr: String,
    var xc: String
)

data class DeleteVCompIEEEType1Command(@TargetAggregateIdentifier  var vCompIEEEType1Id: UUID? = null)

// single association commands

// multiple association commands


// VCompIEEEType2 Commands
data class CreateVCompIEEEType2Command(
    @TargetAggregateIdentifier var vCompIEEEType2Id: UUID? = null,
    var tr: String
)

data class UpdateVCompIEEEType2Command(
    @TargetAggregateIdentifier var vCompIEEEType2Id: UUID? = null,
    var tr: String
)

data class DeleteVCompIEEEType2Command(@TargetAggregateIdentifier  var vCompIEEEType2Id: UUID? = null)

// single association commands

// multiple association commands


// ValueAliasSet Commands
data class CreateValueAliasSetCommand(
    @TargetAggregateIdentifier  var valueAliasSetId: UUID? = null
)

data class UpdateValueAliasSetCommand(
    @TargetAggregateIdentifier  var valueAliasSetId: UUID? = null
)

data class DeleteValueAliasSetCommand(@TargetAggregateIdentifier  var valueAliasSetId: UUID? = null)

// single association commands

// multiple association commands


// ValueToAlias Commands
data class CreateValueToAliasCommand(
    @TargetAggregateIdentifier var valueToAliasId: UUID? = null,
    var value: String
)

data class UpdateValueToAliasCommand(
    @TargetAggregateIdentifier var valueToAliasId: UUID? = null,
    var value: String
)

data class DeleteValueToAliasCommand(@TargetAggregateIdentifier  var valueToAliasId: UUID? = null)

// single association commands

// multiple association commands


// VisibilityLayer Commands
data class CreateVisibilityLayerCommand(
    @TargetAggregateIdentifier var visibilityLayerId: UUID? = null,
    var drawingOrder: String
)

data class UpdateVisibilityLayerCommand(
    @TargetAggregateIdentifier var visibilityLayerId: UUID? = null,
    var drawingOrder: String
)

data class DeleteVisibilityLayerCommand(@TargetAggregateIdentifier  var visibilityLayerId: UUID? = null)

// single association commands

// multiple association commands


// Voltage Commands
data class CreateVoltageCommand(
    @TargetAggregateIdentifier var voltageId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateVoltageCommand(
    @TargetAggregateIdentifier var voltageId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteVoltageCommand(@TargetAggregateIdentifier  var voltageId: UUID? = null)

// single association commands

// multiple association commands


// VoltageAdjusterDynamics Commands
data class CreateVoltageAdjusterDynamicsCommand(
    @TargetAggregateIdentifier  var voltageAdjusterDynamicsId: UUID? = null
)

data class UpdateVoltageAdjusterDynamicsCommand(
    @TargetAggregateIdentifier  var voltageAdjusterDynamicsId: UUID? = null
)

data class DeleteVoltageAdjusterDynamicsCommand(@TargetAggregateIdentifier  var voltageAdjusterDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// VoltageAdjusterUserDefined Commands
data class CreateVoltageAdjusterUserDefinedCommand(
    @TargetAggregateIdentifier var voltageAdjusterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateVoltageAdjusterUserDefinedCommand(
    @TargetAggregateIdentifier var voltageAdjusterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteVoltageAdjusterUserDefinedCommand(@TargetAggregateIdentifier  var voltageAdjusterUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// VoltageCompensatorDynamics Commands
data class CreateVoltageCompensatorDynamicsCommand(
    @TargetAggregateIdentifier  var voltageCompensatorDynamicsId: UUID? = null
)

data class UpdateVoltageCompensatorDynamicsCommand(
    @TargetAggregateIdentifier  var voltageCompensatorDynamicsId: UUID? = null
)

data class DeleteVoltageCompensatorDynamicsCommand(@TargetAggregateIdentifier  var voltageCompensatorDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// VoltageCompensatorUserDefined Commands
data class CreateVoltageCompensatorUserDefinedCommand(
    @TargetAggregateIdentifier var voltageCompensatorUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateVoltageCompensatorUserDefinedCommand(
    @TargetAggregateIdentifier var voltageCompensatorUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteVoltageCompensatorUserDefinedCommand(@TargetAggregateIdentifier  var voltageCompensatorUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// VoltageLevel Commands
data class CreateVoltageLevelCommand(
    @TargetAggregateIdentifier var voltageLevelId: UUID? = null,
    var highVoltageLimit: String,
    var lowVoltageLimit: String
)

data class UpdateVoltageLevelCommand(
    @TargetAggregateIdentifier var voltageLevelId: UUID? = null,
    var highVoltageLimit: String,
    var lowVoltageLimit: String
)

data class DeleteVoltageLevelCommand(@TargetAggregateIdentifier  var voltageLevelId: UUID? = null)

// single association commands

// multiple association commands


// VoltageLimit Commands
data class CreateVoltageLimitCommand(
    @TargetAggregateIdentifier var voltageLimitId: UUID? = null,
    var value: String
)

data class UpdateVoltageLimitCommand(
    @TargetAggregateIdentifier var voltageLimitId: UUID? = null,
    var value: String
)

data class DeleteVoltageLimitCommand(@TargetAggregateIdentifier  var voltageLimitId: UUID? = null)

// single association commands

// multiple association commands


// VoltagePerReactivePower Commands
data class CreateVoltagePerReactivePowerCommand(
    @TargetAggregateIdentifier var voltagePerReactivePowerId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateVoltagePerReactivePowerCommand(
    @TargetAggregateIdentifier var voltagePerReactivePowerId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteVoltagePerReactivePowerCommand(@TargetAggregateIdentifier  var voltagePerReactivePowerId: UUID? = null)

// single association commands

// multiple association commands


// VolumeFlowRate Commands
data class CreateVolumeFlowRateCommand(
    @TargetAggregateIdentifier var volumeFlowRateId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateVolumeFlowRateCommand(
    @TargetAggregateIdentifier var volumeFlowRateId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteVolumeFlowRateCommand(@TargetAggregateIdentifier  var volumeFlowRateId: UUID? = null)

// single association commands

// multiple association commands


// VsCapabilityCurve Commands
data class CreateVsCapabilityCurveCommand(
    @TargetAggregateIdentifier  var vsCapabilityCurveId: UUID? = null
)

data class UpdateVsCapabilityCurveCommand(
    @TargetAggregateIdentifier  var vsCapabilityCurveId: UUID? = null
)

data class DeleteVsCapabilityCurveCommand(@TargetAggregateIdentifier  var vsCapabilityCurveId: UUID? = null)

// single association commands

// multiple association commands


// VsConverter Commands
data class CreateVsConverterCommand(
    @TargetAggregateIdentifier var vsConverterId: UUID? = null,
    var maxModulationIndex: String,
    var maxValveCurrent: String
)

data class UpdateVsConverterCommand(
    @TargetAggregateIdentifier var vsConverterId: UUID? = null,
    var maxModulationIndex: String,
    var maxValveCurrent: String
)

data class DeleteVsConverterCommand(@TargetAggregateIdentifier  var vsConverterId: UUID? = null)

// single association commands

// multiple association commands


// WindAeroConstIEC Commands
data class CreateWindAeroConstIECCommand(
    @TargetAggregateIdentifier  var windAeroConstIECId: UUID? = null
)

data class UpdateWindAeroConstIECCommand(
    @TargetAggregateIdentifier  var windAeroConstIECId: UUID? = null
)

data class DeleteWindAeroConstIECCommand(@TargetAggregateIdentifier  var windAeroConstIECId: UUID? = null)

// single association commands

// multiple association commands


// WindAeroLinearIEC Commands
data class CreateWindAeroLinearIECCommand(
    @TargetAggregateIdentifier var windAeroLinearIECId: UUID? = null,
    var dpomega: String,
    var dptheta: String,
    var omegazero: String,
    var pavail: String,
    var thetazero: String
)

data class UpdateWindAeroLinearIECCommand(
    @TargetAggregateIdentifier var windAeroLinearIECId: UUID? = null,
    var dpomega: String,
    var dptheta: String,
    var omegazero: String,
    var pavail: String,
    var thetazero: String
)

data class DeleteWindAeroLinearIECCommand(@TargetAggregateIdentifier  var windAeroLinearIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContCurrLimIEC Commands
data class CreateWindContCurrLimIECCommand(
    @TargetAggregateIdentifier var windContCurrLimIECId: UUID? = null,
    var imax: String,
    var imaxdip: String,
    var mdfslim: String,
    var mqpri: String,
    var tufilt: String
)

data class UpdateWindContCurrLimIECCommand(
    @TargetAggregateIdentifier var windContCurrLimIECId: UUID? = null,
    var imax: String,
    var imaxdip: String,
    var mdfslim: String,
    var mqpri: String,
    var tufilt: String
)

data class DeleteWindContCurrLimIECCommand(@TargetAggregateIdentifier  var windContCurrLimIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContPType3IEC Commands
data class CreateWindContPType3IECCommand(
    @TargetAggregateIdentifier var windContPType3IECId: UUID? = null,
    var dpmax: String,
    var dtrisemaxlvrt: String,
    var kdtd: String,
    var kip: String,
    var kpp: String,
    var mplvrt: String,
    var omegaoffset: String,
    var pdtdmax: String,
    var rramp: String,
    var tdvs: String,
    var temin: String,
    var tomegafilt: String,
    var tpfilt: String,
    var tpord: String,
    var tufilt: String,
    var tuscale: String,
    var twref: String,
    var udvs: String,
    var updip: String,
    var wdtd: String,
    var zeta: String
)

data class UpdateWindContPType3IECCommand(
    @TargetAggregateIdentifier var windContPType3IECId: UUID? = null,
    var dpmax: String,
    var dtrisemaxlvrt: String,
    var kdtd: String,
    var kip: String,
    var kpp: String,
    var mplvrt: String,
    var omegaoffset: String,
    var pdtdmax: String,
    var rramp: String,
    var tdvs: String,
    var temin: String,
    var tomegafilt: String,
    var tpfilt: String,
    var tpord: String,
    var tufilt: String,
    var tuscale: String,
    var twref: String,
    var udvs: String,
    var updip: String,
    var wdtd: String,
    var zeta: String
)

data class DeleteWindContPType3IECCommand(@TargetAggregateIdentifier  var windContPType3IECId: UUID? = null)

// single association commands

// multiple association commands


// WindContPType4aIEC Commands
data class CreateWindContPType4aIECCommand(
    @TargetAggregateIdentifier var windContPType4aIECId: UUID? = null,
    var dpmax: String,
    var tpord: String,
    var tufilt: String
)

data class UpdateWindContPType4aIECCommand(
    @TargetAggregateIdentifier var windContPType4aIECId: UUID? = null,
    var dpmax: String,
    var tpord: String,
    var tufilt: String
)

data class DeleteWindContPType4aIECCommand(@TargetAggregateIdentifier  var windContPType4aIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContPType4bIEC Commands
data class CreateWindContPType4bIECCommand(
    @TargetAggregateIdentifier var windContPType4bIECId: UUID? = null,
    var dpmax: String,
    var tpaero: String,
    var tpord: String,
    var tufilt: String
)

data class UpdateWindContPType4bIECCommand(
    @TargetAggregateIdentifier var windContPType4bIECId: UUID? = null,
    var dpmax: String,
    var tpaero: String,
    var tpord: String,
    var tufilt: String
)

data class DeleteWindContPType4bIECCommand(@TargetAggregateIdentifier  var windContPType4bIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContPitchAngleIEC Commands
data class CreateWindContPitchAngleIECCommand(
    @TargetAggregateIdentifier var windContPitchAngleIECId: UUID? = null,
    var dthetamax: String,
    var dthetamin: String,
    var kic: String,
    var kiomega: String,
    var kpc: String,
    var kpomega: String,
    var kpx: String,
    var thetamax: String,
    var thetamin: String,
    var ttheta: String
)

data class UpdateWindContPitchAngleIECCommand(
    @TargetAggregateIdentifier var windContPitchAngleIECId: UUID? = null,
    var dthetamax: String,
    var dthetamin: String,
    var kic: String,
    var kiomega: String,
    var kpc: String,
    var kpomega: String,
    var kpx: String,
    var thetamax: String,
    var thetamin: String,
    var ttheta: String
)

data class DeleteWindContPitchAngleIECCommand(@TargetAggregateIdentifier  var windContPitchAngleIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContQIEC Commands
data class CreateWindContQIECCommand(
    @TargetAggregateIdentifier var windContQIECId: UUID? = null,
    var iqh1: String,
    var iqmax: String,
    var iqmin: String,
    var iqpost: String,
    var kiq: String,
    var kiu: String,
    var kpq: String,
    var kpu: String,
    var kqv: String,
    var qmax: String,
    var qmin: String,
    var rdroop: String,
    var tiq: String,
    var tpfilt: String,
    var tpost: String,
    var tqord: String,
    var tufilt: String,
    var udb1: String,
    var udb2: String,
    var umax: String,
    var umin: String,
    var uqdip: String,
    var uref0: String,
    var windLVRTQcontrolModesType: String,
    var windQcontrolModesType: String,
    var xdroop: String
)

data class UpdateWindContQIECCommand(
    @TargetAggregateIdentifier var windContQIECId: UUID? = null,
    var iqh1: String,
    var iqmax: String,
    var iqmin: String,
    var iqpost: String,
    var kiq: String,
    var kiu: String,
    var kpq: String,
    var kpu: String,
    var kqv: String,
    var qmax: String,
    var qmin: String,
    var rdroop: String,
    var tiq: String,
    var tpfilt: String,
    var tpost: String,
    var tqord: String,
    var tufilt: String,
    var udb1: String,
    var udb2: String,
    var umax: String,
    var umin: String,
    var uqdip: String,
    var uref0: String,
    var windLVRTQcontrolModesType: String,
    var windQcontrolModesType: String,
    var xdroop: String
)

data class DeleteWindContQIECCommand(@TargetAggregateIdentifier  var windContQIECId: UUID? = null)

// single association commands

// multiple association commands


// WindContRotorRIEC Commands
data class CreateWindContRotorRIECCommand(
    @TargetAggregateIdentifier var windContRotorRIECId: UUID? = null,
    var kirr: String,
    var komegafilt: String,
    var kpfilt: String,
    var kprr: String,
    var rmax: String,
    var rmin: String,
    var tomegafilt: String,
    var tpfilt: String
)

data class UpdateWindContRotorRIECCommand(
    @TargetAggregateIdentifier var windContRotorRIECId: UUID? = null,
    var kirr: String,
    var komegafilt: String,
    var kpfilt: String,
    var kprr: String,
    var rmax: String,
    var rmin: String,
    var tomegafilt: String,
    var tpfilt: String
)

data class DeleteWindContRotorRIECCommand(@TargetAggregateIdentifier  var windContRotorRIECId: UUID? = null)

// single association commands

// multiple association commands


// WindDynamicsLookupTable Commands
data class CreateWindDynamicsLookupTableCommand(
    @TargetAggregateIdentifier var windDynamicsLookupTableId: UUID? = null,
    var input: String,
    var lookupTableFunctionType: String,
    var output: String,
    var sequence: String
)

data class UpdateWindDynamicsLookupTableCommand(
    @TargetAggregateIdentifier var windDynamicsLookupTableId: UUID? = null,
    var input: String,
    var lookupTableFunctionType: String,
    var output: String,
    var sequence: String
)

data class DeleteWindDynamicsLookupTableCommand(@TargetAggregateIdentifier  var windDynamicsLookupTableId: UUID? = null)

// single association commands

// multiple association commands


// WindGenTurbineType1IEC Commands
data class CreateWindGenTurbineType1IECCommand(
    @TargetAggregateIdentifier  var windGenTurbineType1IECId: UUID? = null
)

data class UpdateWindGenTurbineType1IECCommand(
    @TargetAggregateIdentifier  var windGenTurbineType1IECId: UUID? = null
)

data class DeleteWindGenTurbineType1IECCommand(@TargetAggregateIdentifier  var windGenTurbineType1IECId: UUID? = null)

// single association commands

// multiple association commands


// WindGenTurbineType2IEC Commands
data class CreateWindGenTurbineType2IECCommand(
    @TargetAggregateIdentifier  var windGenTurbineType2IECId: UUID? = null
)

data class UpdateWindGenTurbineType2IECCommand(
    @TargetAggregateIdentifier  var windGenTurbineType2IECId: UUID? = null
)

data class DeleteWindGenTurbineType2IECCommand(@TargetAggregateIdentifier  var windGenTurbineType2IECId: UUID? = null)

// single association commands

// multiple association commands


// WindGenTurbineType3IEC Commands
data class CreateWindGenTurbineType3IECCommand(
    @TargetAggregateIdentifier var windGenTurbineType3IECId: UUID? = null,
    var dipmax: String,
    var diqmax: String
)

data class UpdateWindGenTurbineType3IECCommand(
    @TargetAggregateIdentifier var windGenTurbineType3IECId: UUID? = null,
    var dipmax: String,
    var diqmax: String
)

data class DeleteWindGenTurbineType3IECCommand(@TargetAggregateIdentifier  var windGenTurbineType3IECId: UUID? = null)

// single association commands

// multiple association commands


// WindGenTurbineType3aIEC Commands
data class CreateWindGenTurbineType3aIECCommand(
    @TargetAggregateIdentifier var windGenTurbineType3aIECId: UUID? = null,
    var kpc: String,
    var tic: String,
    var xs: String
)

data class UpdateWindGenTurbineType3aIECCommand(
    @TargetAggregateIdentifier var windGenTurbineType3aIECId: UUID? = null,
    var kpc: String,
    var tic: String,
    var xs: String
)

data class DeleteWindGenTurbineType3aIECCommand(@TargetAggregateIdentifier  var windGenTurbineType3aIECId: UUID? = null)

// single association commands

// multiple association commands


// WindGenTurbineType3bIEC Commands
data class CreateWindGenTurbineType3bIECCommand(
    @TargetAggregateIdentifier var windGenTurbineType3bIECId: UUID? = null,
    var fducw: String,
    var mwtcwp: String,
    var tg: String,
    var two: String,
    var xs: String
)

data class UpdateWindGenTurbineType3bIECCommand(
    @TargetAggregateIdentifier var windGenTurbineType3bIECId: UUID? = null,
    var fducw: String,
    var mwtcwp: String,
    var tg: String,
    var two: String,
    var xs: String
)

data class DeleteWindGenTurbineType3bIECCommand(@TargetAggregateIdentifier  var windGenTurbineType3bIECId: UUID? = null)

// single association commands

// multiple association commands


// WindGenType4IEC Commands
data class CreateWindGenType4IECCommand(
    @TargetAggregateIdentifier var windGenType4IECId: UUID? = null,
    var dipmax: String,
    var diqmax: String,
    var diqmin: String,
    var tg: String
)

data class UpdateWindGenType4IECCommand(
    @TargetAggregateIdentifier var windGenType4IECId: UUID? = null,
    var dipmax: String,
    var diqmax: String,
    var diqmin: String,
    var tg: String
)

data class DeleteWindGenType4IECCommand(@TargetAggregateIdentifier  var windGenType4IECId: UUID? = null)

// single association commands

// multiple association commands


// WindGeneratingUnit Commands
data class CreateWindGeneratingUnitCommand(
    @TargetAggregateIdentifier var windGeneratingUnitId: UUID? = null,
    var windGenUnitType: String
)

data class UpdateWindGeneratingUnitCommand(
    @TargetAggregateIdentifier var windGeneratingUnitId: UUID? = null,
    var windGenUnitType: String
)

data class DeleteWindGeneratingUnitCommand(@TargetAggregateIdentifier  var windGeneratingUnitId: UUID? = null)

// single association commands

// multiple association commands


// WindMechIEC Commands
data class CreateWindMechIECCommand(
    @TargetAggregateIdentifier var windMechIECId: UUID? = null,
    var cdrt: String,
    var hgen: String,
    var hwtr: String,
    var kdrt: String
)

data class UpdateWindMechIECCommand(
    @TargetAggregateIdentifier var windMechIECId: UUID? = null,
    var cdrt: String,
    var hgen: String,
    var hwtr: String,
    var kdrt: String
)

data class DeleteWindMechIECCommand(@TargetAggregateIdentifier  var windMechIECId: UUID? = null)

// single association commands

// multiple association commands


// WindPitchContEmulIEC Commands
data class CreateWindPitchContEmulIECCommand(
    @TargetAggregateIdentifier var windPitchContEmulIECId: UUID? = null,
    var kdroop: String,
    var kipce: String,
    var komegaaero: String,
    var kppce: String,
    var omegaref: String,
    var pimax: String,
    var pimin: String,
    var t1: String,
    var t2: String,
    var tpe: String
)

data class UpdateWindPitchContEmulIECCommand(
    @TargetAggregateIdentifier var windPitchContEmulIECId: UUID? = null,
    var kdroop: String,
    var kipce: String,
    var komegaaero: String,
    var kppce: String,
    var omegaref: String,
    var pimax: String,
    var pimin: String,
    var t1: String,
    var t2: String,
    var tpe: String
)

data class DeleteWindPitchContEmulIECCommand(@TargetAggregateIdentifier  var windPitchContEmulIECId: UUID? = null)

// single association commands

// multiple association commands


// WindPlantDynamics Commands
data class CreateWindPlantDynamicsCommand(
    @TargetAggregateIdentifier  var windPlantDynamicsId: UUID? = null
)

data class UpdateWindPlantDynamicsCommand(
    @TargetAggregateIdentifier  var windPlantDynamicsId: UUID? = null
)

data class DeleteWindPlantDynamicsCommand(@TargetAggregateIdentifier  var windPlantDynamicsId: UUID? = null)

// single association commands

// multiple association commands


// WindPlantFreqPcontrolIEC Commands
data class CreateWindPlantFreqPcontrolIECCommand(
    @TargetAggregateIdentifier var windPlantFreqPcontrolIECId: UUID? = null,
    var dprefmax: String,
    var dprefmin: String,
    var kiwpp: String,
    var kpwpp: String,
    var prefmax: String,
    var prefmin: String,
    var tpft: String,
    var tpfv: String,
    var twpffilt: String,
    var twppfilt: String
)

data class UpdateWindPlantFreqPcontrolIECCommand(
    @TargetAggregateIdentifier var windPlantFreqPcontrolIECId: UUID? = null,
    var dprefmax: String,
    var dprefmin: String,
    var kiwpp: String,
    var kpwpp: String,
    var prefmax: String,
    var prefmin: String,
    var tpft: String,
    var tpfv: String,
    var twpffilt: String,
    var twppfilt: String
)

data class DeleteWindPlantFreqPcontrolIECCommand(@TargetAggregateIdentifier  var windPlantFreqPcontrolIECId: UUID? = null)

// single association commands

// multiple association commands


// WindPlantIEC Commands
data class CreateWindPlantIECCommand(
    @TargetAggregateIdentifier  var windPlantIECId: UUID? = null
)

data class UpdateWindPlantIECCommand(
    @TargetAggregateIdentifier  var windPlantIECId: UUID? = null
)

data class DeleteWindPlantIECCommand(@TargetAggregateIdentifier  var windPlantIECId: UUID? = null)

// single association commands

// multiple association commands


// WindPlantReactiveControlIEC Commands
data class CreateWindPlantReactiveControlIECCommand(
    @TargetAggregateIdentifier var windPlantReactiveControlIECId: UUID? = null,
    var kiwpx: String,
    var kpwpx: String,
    var kwpqu: String,
    var mwppf: String,
    var mwpu: String,
    var twppfilt: String,
    var twpqfilt: String,
    var twpufilt: String,
    var txft: String,
    var txfv: String,
    var uwpqdip: String,
    var xrefmax: String,
    var xrefmin: String
)

data class UpdateWindPlantReactiveControlIECCommand(
    @TargetAggregateIdentifier var windPlantReactiveControlIECId: UUID? = null,
    var kiwpx: String,
    var kpwpx: String,
    var kwpqu: String,
    var mwppf: String,
    var mwpu: String,
    var twppfilt: String,
    var twpqfilt: String,
    var twpufilt: String,
    var txft: String,
    var txfv: String,
    var uwpqdip: String,
    var xrefmax: String,
    var xrefmin: String
)

data class DeleteWindPlantReactiveControlIECCommand(@TargetAggregateIdentifier  var windPlantReactiveControlIECId: UUID? = null)

// single association commands

// multiple association commands


// WindPlantUserDefined Commands
data class CreateWindPlantUserDefinedCommand(
    @TargetAggregateIdentifier var windPlantUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateWindPlantUserDefinedCommand(
    @TargetAggregateIdentifier var windPlantUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteWindPlantUserDefinedCommand(@TargetAggregateIdentifier  var windPlantUserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// WindProtectionIEC Commands
data class CreateWindProtectionIECCommand(
    @TargetAggregateIdentifier var windProtectionIECId: UUID? = null,
    var fover: String,
    var funder: String,
    var tfover: String,
    var tfunder: String,
    var tuover: String,
    var tuunder: String,
    var uover: String,
    var uunder: String
)

data class UpdateWindProtectionIECCommand(
    @TargetAggregateIdentifier var windProtectionIECId: UUID? = null,
    var fover: String,
    var funder: String,
    var tfover: String,
    var tfunder: String,
    var tuover: String,
    var tuunder: String,
    var uover: String,
    var uunder: String
)

data class DeleteWindProtectionIECCommand(@TargetAggregateIdentifier  var windProtectionIECId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType1or2Dynamics Commands
data class CreateWindTurbineType1or2DynamicsCommand(
    @TargetAggregateIdentifier  var windTurbineType1or2DynamicsId: UUID? = null
)

data class UpdateWindTurbineType1or2DynamicsCommand(
    @TargetAggregateIdentifier  var windTurbineType1or2DynamicsId: UUID? = null
)

data class DeleteWindTurbineType1or2DynamicsCommand(@TargetAggregateIdentifier  var windTurbineType1or2DynamicsId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType1or2IEC Commands
data class CreateWindTurbineType1or2IECCommand(
    @TargetAggregateIdentifier  var windTurbineType1or2IECId: UUID? = null
)

data class UpdateWindTurbineType1or2IECCommand(
    @TargetAggregateIdentifier  var windTurbineType1or2IECId: UUID? = null
)

data class DeleteWindTurbineType1or2IECCommand(@TargetAggregateIdentifier  var windTurbineType1or2IECId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType3or4Dynamics Commands
data class CreateWindTurbineType3or4DynamicsCommand(
    @TargetAggregateIdentifier  var windTurbineType3or4DynamicsId: UUID? = null
)

data class UpdateWindTurbineType3or4DynamicsCommand(
    @TargetAggregateIdentifier  var windTurbineType3or4DynamicsId: UUID? = null
)

data class DeleteWindTurbineType3or4DynamicsCommand(@TargetAggregateIdentifier  var windTurbineType3or4DynamicsId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType3or4IEC Commands
data class CreateWindTurbineType3or4IECCommand(
    @TargetAggregateIdentifier  var windTurbineType3or4IECId: UUID? = null
)

data class UpdateWindTurbineType3or4IECCommand(
    @TargetAggregateIdentifier  var windTurbineType3or4IECId: UUID? = null
)

data class DeleteWindTurbineType3or4IECCommand(@TargetAggregateIdentifier  var windTurbineType3or4IECId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType4aIEC Commands
data class CreateWindTurbineType4aIECCommand(
    @TargetAggregateIdentifier  var windTurbineType4aIECId: UUID? = null
)

data class UpdateWindTurbineType4aIECCommand(
    @TargetAggregateIdentifier  var windTurbineType4aIECId: UUID? = null
)

data class DeleteWindTurbineType4aIECCommand(@TargetAggregateIdentifier  var windTurbineType4aIECId: UUID? = null)

// single association commands

// multiple association commands


// WindTurbineType4bIEC Commands
data class CreateWindTurbineType4bIECCommand(
    @TargetAggregateIdentifier  var windTurbineType4bIECId: UUID? = null
)

data class UpdateWindTurbineType4bIECCommand(
    @TargetAggregateIdentifier  var windTurbineType4bIECId: UUID? = null
)

data class DeleteWindTurbineType4bIECCommand(@TargetAggregateIdentifier  var windTurbineType4bIECId: UUID? = null)

// single association commands

// multiple association commands


// WindType1or2UserDefined Commands
data class CreateWindType1or2UserDefinedCommand(
    @TargetAggregateIdentifier var windType1or2UserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateWindType1or2UserDefinedCommand(
    @TargetAggregateIdentifier var windType1or2UserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteWindType1or2UserDefinedCommand(@TargetAggregateIdentifier  var windType1or2UserDefinedId: UUID? = null)

// single association commands

// multiple association commands


// WindType3or4UserDefined Commands
data class CreateWindType3or4UserDefinedCommand(
    @TargetAggregateIdentifier var windType3or4UserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateWindType3or4UserDefinedCommand(
    @TargetAggregateIdentifier var windType3or4UserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteWindType3or4UserDefinedCommand(@TargetAggregateIdentifier  var windType3or4UserDefinedId: UUID? = null)

// single association commands

// multiple association commands



