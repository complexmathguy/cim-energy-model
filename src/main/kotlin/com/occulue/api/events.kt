/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.api;

import java.time.Instant
import java.util.*

import javax.persistence.*

import com.occulue.entity.*;


//-----------------------------------------------------------
// Event definitions
//-----------------------------------------------------------

// ACDCConverter Events

data class CreateACDCConverterEvent(
    @Id var aCDCConverterId: UUID? = null,
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

data class UpdateACDCConverterEvent(
    @Id var aCDCConverterId: UUID? = null,
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

data class DeleteACDCConverterEvent(@Id var aCDCConverterId: UUID? = null)

// single association events

// multiple association events


// ACDCConverterDCTerminal Events

data class CreateACDCConverterDCTerminalEvent(
    @Id var aCDCConverterDCTerminalId: UUID? = null,
    var polarity: String
)

data class UpdateACDCConverterDCTerminalEvent(
    @Id var aCDCConverterDCTerminalId: UUID? = null,
    var polarity: String
)

data class DeleteACDCConverterDCTerminalEvent(@Id var aCDCConverterDCTerminalId: UUID? = null)

// single association events

// multiple association events


// ACDCTerminal Events

data class CreateACDCTerminalEvent(
    @Id var aCDCTerminalId: UUID? = null,
    var sequenceNumber: String
)

data class UpdateACDCTerminalEvent(
    @Id var aCDCTerminalId: UUID? = null,
    var sequenceNumber: String
)

data class DeleteACDCTerminalEvent(@Id var aCDCTerminalId: UUID? = null)

// single association events

// multiple association events


// ACLineSegment Events

data class CreateACLineSegmentEvent(
    @Id var aCLineSegmentId: UUID? = null,
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

data class UpdateACLineSegmentEvent(
    @Id var aCLineSegmentId: UUID? = null,
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

data class DeleteACLineSegmentEvent(@Id var aCLineSegmentId: UUID? = null)

// single association events

// multiple association events


// Accumulator Events

data class CreateAccumulatorEvent(
     var accumulatorId: UUID? = null
)

data class UpdateAccumulatorEvent(
     var accumulatorId: UUID? = null
)

data class DeleteAccumulatorEvent(@Id var accumulatorId: UUID? = null)

// single association events

// multiple association events


// AccumulatorLimit Events

data class CreateAccumulatorLimitEvent(
    @Id var accumulatorLimitId: UUID? = null,
    var value: String
)

data class UpdateAccumulatorLimitEvent(
    @Id var accumulatorLimitId: UUID? = null,
    var value: String
)

data class DeleteAccumulatorLimitEvent(@Id var accumulatorLimitId: UUID? = null)

// single association events

// multiple association events


// AccumulatorLimitSet Events

data class CreateAccumulatorLimitSetEvent(
     var accumulatorLimitSetId: UUID? = null
)

data class UpdateAccumulatorLimitSetEvent(
     var accumulatorLimitSetId: UUID? = null
)

data class DeleteAccumulatorLimitSetEvent(@Id var accumulatorLimitSetId: UUID? = null)

// single association events

// multiple association events


// AccumulatorReset Events

data class CreateAccumulatorResetEvent(
     var accumulatorResetId: UUID? = null
)

data class UpdateAccumulatorResetEvent(
     var accumulatorResetId: UUID? = null
)

data class DeleteAccumulatorResetEvent(@Id var accumulatorResetId: UUID? = null)

// single association events

// multiple association events


// AccumulatorValue Events

data class CreateAccumulatorValueEvent(
    @Id var accumulatorValueId: UUID? = null,
    var value: String
)

data class UpdateAccumulatorValueEvent(
    @Id var accumulatorValueId: UUID? = null,
    var value: String
)

data class DeleteAccumulatorValueEvent(@Id var accumulatorValueId: UUID? = null)

// single association events

// multiple association events


// ActivePower Events

data class CreateActivePowerEvent(
    @Id var activePowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateActivePowerEvent(
    @Id var activePowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteActivePowerEvent(@Id var activePowerId: UUID? = null)

// single association events

// multiple association events


// ActivePowerLimit Events

data class CreateActivePowerLimitEvent(
    @Id var activePowerLimitId: UUID? = null,
    var value: String
)

data class UpdateActivePowerLimitEvent(
    @Id var activePowerLimitId: UUID? = null,
    var value: String
)

data class DeleteActivePowerLimitEvent(@Id var activePowerLimitId: UUID? = null)

// single association events

// multiple association events


// ActivePowerPerCurrentFlow Events

data class CreateActivePowerPerCurrentFlowEvent(
    @Id var activePowerPerCurrentFlowId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateActivePowerPerCurrentFlowEvent(
    @Id var activePowerPerCurrentFlowId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteActivePowerPerCurrentFlowEvent(@Id var activePowerPerCurrentFlowId: UUID? = null)

// single association events

// multiple association events


// ActivePowerPerFrequency Events

data class CreateActivePowerPerFrequencyEvent(
    @Id var activePowerPerFrequencyId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateActivePowerPerFrequencyEvent(
    @Id var activePowerPerFrequencyId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteActivePowerPerFrequencyEvent(@Id var activePowerPerFrequencyId: UUID? = null)

// single association events

// multiple association events


// Analog Events

data class CreateAnalogEvent(
    @Id var analogId: UUID? = null,
    var positiveFlowIn: String
)

data class UpdateAnalogEvent(
    @Id var analogId: UUID? = null,
    var positiveFlowIn: String
)

data class DeleteAnalogEvent(@Id var analogId: UUID? = null)

// single association events

// multiple association events


// AnalogControl Events

data class CreateAnalogControlEvent(
    @Id var analogControlId: UUID? = null,
    var maxValue: String,
    var minValue: String
)

data class UpdateAnalogControlEvent(
    @Id var analogControlId: UUID? = null,
    var maxValue: String,
    var minValue: String
)

data class DeleteAnalogControlEvent(@Id var analogControlId: UUID? = null)

// single association events

// multiple association events


// AnalogLimit Events

data class CreateAnalogLimitEvent(
    @Id var analogLimitId: UUID? = null,
    var value: String
)

data class UpdateAnalogLimitEvent(
    @Id var analogLimitId: UUID? = null,
    var value: String
)

data class DeleteAnalogLimitEvent(@Id var analogLimitId: UUID? = null)

// single association events

// multiple association events


// AnalogLimitSet Events

data class CreateAnalogLimitSetEvent(
     var analogLimitSetId: UUID? = null
)

data class UpdateAnalogLimitSetEvent(
     var analogLimitSetId: UUID? = null
)

data class DeleteAnalogLimitSetEvent(@Id var analogLimitSetId: UUID? = null)

// single association events

// multiple association events


// AnalogValue Events

data class CreateAnalogValueEvent(
    @Id var analogValueId: UUID? = null,
    var value: String
)

data class UpdateAnalogValueEvent(
    @Id var analogValueId: UUID? = null,
    var value: String
)

data class DeleteAnalogValueEvent(@Id var analogValueId: UUID? = null)

// single association events

// multiple association events


// AngleDegrees Events

data class CreateAngleDegreesEvent(
    @Id var angleDegreesId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateAngleDegreesEvent(
    @Id var angleDegreesId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteAngleDegreesEvent(@Id var angleDegreesId: UUID? = null)

// single association events

// multiple association events


// AngleRadians Events

data class CreateAngleRadiansEvent(
    @Id var angleRadiansId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateAngleRadiansEvent(
    @Id var angleRadiansId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteAngleRadiansEvent(@Id var angleRadiansId: UUID? = null)

// single association events

// multiple association events


// ApparentPower Events

data class CreateApparentPowerEvent(
    @Id var apparentPowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateApparentPowerEvent(
    @Id var apparentPowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteApparentPowerEvent(@Id var apparentPowerId: UUID? = null)

// single association events

// multiple association events


// ApparentPowerLimit Events

data class CreateApparentPowerLimitEvent(
    @Id var apparentPowerLimitId: UUID? = null,
    var value: String
)

data class UpdateApparentPowerLimitEvent(
    @Id var apparentPowerLimitId: UUID? = null,
    var value: String
)

data class DeleteApparentPowerLimitEvent(@Id var apparentPowerLimitId: UUID? = null)

// single association events

// multiple association events


// Area Events

data class CreateAreaEvent(
    @Id var areaId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateAreaEvent(
    @Id var areaId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteAreaEvent(@Id var areaId: UUID? = null)

// single association events

// multiple association events


// AsynchronousMachine Events

data class CreateAsynchronousMachineEvent(
    @Id var asynchronousMachineId: UUID? = null,
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

data class UpdateAsynchronousMachineEvent(
    @Id var asynchronousMachineId: UUID? = null,
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

data class DeleteAsynchronousMachineEvent(@Id var asynchronousMachineId: UUID? = null)

// single association events

// multiple association events


// AsynchronousMachineDynamics Events

data class CreateAsynchronousMachineDynamicsEvent(
     var asynchronousMachineDynamicsId: UUID? = null
)

data class UpdateAsynchronousMachineDynamicsEvent(
     var asynchronousMachineDynamicsId: UUID? = null
)

data class DeleteAsynchronousMachineDynamicsEvent(@Id var asynchronousMachineDynamicsId: UUID? = null)

// single association events

// multiple association events


// AsynchronousMachineEquivalentCircuit Events

data class CreateAsynchronousMachineEquivalentCircuitEvent(
    @Id var asynchronousMachineEquivalentCircuitId: UUID? = null,
    var rr1: String,
    var rr2: String,
    var xlr1: String,
    var xlr2: String,
    var xm: String
)

data class UpdateAsynchronousMachineEquivalentCircuitEvent(
    @Id var asynchronousMachineEquivalentCircuitId: UUID? = null,
    var rr1: String,
    var rr2: String,
    var xlr1: String,
    var xlr2: String,
    var xm: String
)

data class DeleteAsynchronousMachineEquivalentCircuitEvent(@Id var asynchronousMachineEquivalentCircuitId: UUID? = null)

// single association events

// multiple association events


// AsynchronousMachineTimeConstantReactance Events

data class CreateAsynchronousMachineTimeConstantReactanceEvent(
    @Id var asynchronousMachineTimeConstantReactanceId: UUID? = null,
    var tpo: String,
    var tppo: String,
    var xp: String,
    var xpp: String,
    var xs: String
)

data class UpdateAsynchronousMachineTimeConstantReactanceEvent(
    @Id var asynchronousMachineTimeConstantReactanceId: UUID? = null,
    var tpo: String,
    var tppo: String,
    var xp: String,
    var xpp: String,
    var xs: String
)

data class DeleteAsynchronousMachineTimeConstantReactanceEvent(@Id var asynchronousMachineTimeConstantReactanceId: UUID? = null)

// single association events

// multiple association events


// AsynchronousMachineUserDefined Events

data class CreateAsynchronousMachineUserDefinedEvent(
    @Id var asynchronousMachineUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateAsynchronousMachineUserDefinedEvent(
    @Id var asynchronousMachineUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteAsynchronousMachineUserDefinedEvent(@Id var asynchronousMachineUserDefinedId: UUID? = null)

// single association events

// multiple association events


// BaseVoltage Events

data class CreateBaseVoltageEvent(
    @Id var baseVoltageId: UUID? = null,
    var nominalVoltage: String
)

data class UpdateBaseVoltageEvent(
    @Id var baseVoltageId: UUID? = null,
    var nominalVoltage: String
)

data class DeleteBaseVoltageEvent(@Id var baseVoltageId: UUID? = null)

// single association events

// multiple association events


// BasicIntervalSchedule Events

data class CreateBasicIntervalScheduleEvent(
    @Id var basicIntervalScheduleId: UUID? = null,
    var startTime: String,
    var value1Unit: String,
    var value2Unit: String
)

data class UpdateBasicIntervalScheduleEvent(
    @Id var basicIntervalScheduleId: UUID? = null,
    var startTime: String,
    var value1Unit: String,
    var value2Unit: String
)

data class DeleteBasicIntervalScheduleEvent(@Id var basicIntervalScheduleId: UUID? = null)

// single association events

// multiple association events


// Bay Events

data class CreateBayEvent(
     var bayId: UUID? = null
)

data class UpdateBayEvent(
     var bayId: UUID? = null
)

data class DeleteBayEvent(@Id var bayId: UUID? = null)

// single association events

// multiple association events


// BooleanProxy Events

data class CreateBooleanProxyEvent(
     var booleanProxyId: UUID? = null
)

data class UpdateBooleanProxyEvent(
     var booleanProxyId: UUID? = null
)

data class DeleteBooleanProxyEvent(@Id var booleanProxyId: UUID? = null)

// single association events

// multiple association events


// BoundaryExtensions Events

data class CreateBoundaryExtensionsEvent(
    @Id var boundaryExtensionsId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class UpdateBoundaryExtensionsEvent(
    @Id var boundaryExtensionsId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class DeleteBoundaryExtensionsEvent(@Id var boundaryExtensionsId: UUID? = null)

// single association events

// multiple association events


// Breaker Events

data class CreateBreakerEvent(
     var breakerId: UUID? = null
)

data class UpdateBreakerEvent(
     var breakerId: UUID? = null
)

data class DeleteBreakerEvent(@Id var breakerId: UUID? = null)

// single association events

// multiple association events


// BusNameMarker Events

data class CreateBusNameMarkerEvent(
    @Id var busNameMarkerId: UUID? = null,
    var priority: String
)

data class UpdateBusNameMarkerEvent(
    @Id var busNameMarkerId: UUID? = null,
    var priority: String
)

data class DeleteBusNameMarkerEvent(@Id var busNameMarkerId: UUID? = null)

// single association events

// multiple association events


// BusbarSection Events

data class CreateBusbarSectionEvent(
    @Id var busbarSectionId: UUID? = null,
    var ipMax: String
)

data class UpdateBusbarSectionEvent(
    @Id var busbarSectionId: UUID? = null,
    var ipMax: String
)

data class DeleteBusbarSectionEvent(@Id var busbarSectionId: UUID? = null)

// single association events

// multiple association events


// Capacitance Events

data class CreateCapacitanceEvent(
    @Id var capacitanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateCapacitanceEvent(
    @Id var capacitanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteCapacitanceEvent(@Id var capacitanceId: UUID? = null)

// single association events

// multiple association events


// CapacitancePerLength Events

data class CreateCapacitancePerLengthEvent(
    @Id var capacitancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateCapacitancePerLengthEvent(
    @Id var capacitancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteCapacitancePerLengthEvent(@Id var capacitancePerLengthId: UUID? = null)

// single association events

// multiple association events


// Command Events

data class CreateCommandEvent(
    @Id var commandId: UUID? = null,
    var normalValue: String,
    var value: String
)

data class UpdateCommandEvent(
    @Id var commandId: UUID? = null,
    var normalValue: String,
    var value: String
)

data class DeleteCommandEvent(@Id var commandId: UUID? = null)

// single association events

// multiple association events


// Conductance Events

data class CreateConductanceEvent(
    @Id var conductanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateConductanceEvent(
    @Id var conductanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteConductanceEvent(@Id var conductanceId: UUID? = null)

// single association events

// multiple association events


// ConductingEquipment Events

data class CreateConductingEquipmentEvent(
     var conductingEquipmentId: UUID? = null
)

data class UpdateConductingEquipmentEvent(
     var conductingEquipmentId: UUID? = null
)

data class DeleteConductingEquipmentEvent(@Id var conductingEquipmentId: UUID? = null)

// single association events

// multiple association events


// Conductor Events

data class CreateConductorEvent(
    @Id var conductorId: UUID? = null,
    var length: String
)

data class UpdateConductorEvent(
    @Id var conductorId: UUID? = null,
    var length: String
)

data class DeleteConductorEvent(@Id var conductorId: UUID? = null)

// single association events

// multiple association events


// ConformLoad Events

data class CreateConformLoadEvent(
     var conformLoadId: UUID? = null
)

data class UpdateConformLoadEvent(
     var conformLoadId: UUID? = null
)

data class DeleteConformLoadEvent(@Id var conformLoadId: UUID? = null)

// single association events

// multiple association events


// ConformLoadGroup Events

data class CreateConformLoadGroupEvent(
     var conformLoadGroupId: UUID? = null
)

data class UpdateConformLoadGroupEvent(
     var conformLoadGroupId: UUID? = null
)

data class DeleteConformLoadGroupEvent(@Id var conformLoadGroupId: UUID? = null)

// single association events

// multiple association events


// ConformLoadSchedule Events

data class CreateConformLoadScheduleEvent(
     var conformLoadScheduleId: UUID? = null
)

data class UpdateConformLoadScheduleEvent(
     var conformLoadScheduleId: UUID? = null
)

data class DeleteConformLoadScheduleEvent(@Id var conformLoadScheduleId: UUID? = null)

// single association events

// multiple association events


// ConnectivityNode Events

data class CreateConnectivityNodeEvent(
    @Id var connectivityNodeId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class UpdateConnectivityNodeEvent(
    @Id var connectivityNodeId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class DeleteConnectivityNodeEvent(@Id var connectivityNodeId: UUID? = null)

// single association events

// multiple association events


// ConnectivityNodeContainer Events

data class CreateConnectivityNodeContainerEvent(
     var connectivityNodeContainerId: UUID? = null
)

data class UpdateConnectivityNodeContainerEvent(
     var connectivityNodeContainerId: UUID? = null
)

data class DeleteConnectivityNodeContainerEvent(@Id var connectivityNodeContainerId: UUID? = null)

// single association events

// multiple association events


// Connector Events

data class CreateConnectorEvent(
     var connectorId: UUID? = null
)

data class UpdateConnectorEvent(
     var connectorId: UUID? = null
)

data class DeleteConnectorEvent(@Id var connectorId: UUID? = null)

// single association events

// multiple association events


// Control Events

data class CreateControlEvent(
    @Id var controlId: UUID? = null,
    var controlType: String,
    var operationInProgress: String,
    var timeStamp: String,
    var unitMultiplier: String,
    var unitSymbol: String
)

data class UpdateControlEvent(
    @Id var controlId: UUID? = null,
    var controlType: String,
    var operationInProgress: String,
    var timeStamp: String,
    var unitMultiplier: String,
    var unitSymbol: String
)

data class DeleteControlEvent(@Id var controlId: UUID? = null)

// single association events

// multiple association events


// ControlArea Events

data class CreateControlAreaEvent(
    @Id var controlAreaId: UUID? = null,
    var type: String
)

data class UpdateControlAreaEvent(
    @Id var controlAreaId: UUID? = null,
    var type: String
)

data class DeleteControlAreaEvent(@Id var controlAreaId: UUID? = null)

// single association events

// multiple association events


// ControlAreaGeneratingUnit Events

data class CreateControlAreaGeneratingUnitEvent(
     var controlAreaGeneratingUnitId: UUID? = null
)

data class UpdateControlAreaGeneratingUnitEvent(
     var controlAreaGeneratingUnitId: UUID? = null
)

data class DeleteControlAreaGeneratingUnitEvent(@Id var controlAreaGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// CoordinateSystem Events

data class CreateCoordinateSystemEvent(
    @Id var coordinateSystemId: UUID? = null,
    var crsUrn: String
)

data class UpdateCoordinateSystemEvent(
    @Id var coordinateSystemId: UUID? = null,
    var crsUrn: String
)

data class DeleteCoordinateSystemEvent(@Id var coordinateSystemId: UUID? = null)

// single association events

// multiple association events


// CsConverter Events

data class CreateCsConverterEvent(
    @Id var csConverterId: UUID? = null,
    var maxAlpha: String,
    var maxGamma: String,
    var maxIdc: String,
    var minAlpha: String,
    var minGamma: String,
    var minIdc: String,
    var ratedIdc: String
)

data class UpdateCsConverterEvent(
    @Id var csConverterId: UUID? = null,
    var maxAlpha: String,
    var maxGamma: String,
    var maxIdc: String,
    var minAlpha: String,
    var minGamma: String,
    var minIdc: String,
    var ratedIdc: String
)

data class DeleteCsConverterEvent(@Id var csConverterId: UUID? = null)

// single association events

// multiple association events


// CurrentFlow Events

data class CreateCurrentFlowEvent(
    @Id var currentFlowId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateCurrentFlowEvent(
    @Id var currentFlowId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteCurrentFlowEvent(@Id var currentFlowId: UUID? = null)

// single association events

// multiple association events


// CurrentLimit Events

data class CreateCurrentLimitEvent(
    @Id var currentLimitId: UUID? = null,
    var value: String
)

data class UpdateCurrentLimitEvent(
    @Id var currentLimitId: UUID? = null,
    var value: String
)

data class DeleteCurrentLimitEvent(@Id var currentLimitId: UUID? = null)

// single association events

// multiple association events


// Curve Events

data class CreateCurveEvent(
    @Id var curveId: UUID? = null,
    var curveStyle: String,
    var xUnit: String,
    var y1Unit: String,
    var y2Unit: String
)

data class UpdateCurveEvent(
    @Id var curveId: UUID? = null,
    var curveStyle: String,
    var xUnit: String,
    var y1Unit: String,
    var y2Unit: String
)

data class DeleteCurveEvent(@Id var curveId: UUID? = null)

// single association events

// multiple association events


// CurveData Events

data class CreateCurveDataEvent(
    @Id var curveDataId: UUID? = null,
    var xvalue: String,
    var y1value: String,
    var y2value: String
)

data class UpdateCurveDataEvent(
    @Id var curveDataId: UUID? = null,
    var xvalue: String,
    var y1value: String,
    var y2value: String
)

data class DeleteCurveDataEvent(@Id var curveDataId: UUID? = null)

// single association events

// multiple association events


// DCBaseTerminal Events

data class CreateDCBaseTerminalEvent(
     var dCBaseTerminalId: UUID? = null
)

data class UpdateDCBaseTerminalEvent(
     var dCBaseTerminalId: UUID? = null
)

data class DeleteDCBaseTerminalEvent(@Id var dCBaseTerminalId: UUID? = null)

// single association events

// multiple association events


// DCBreaker Events

data class CreateDCBreakerEvent(
     var dCBreakerId: UUID? = null
)

data class UpdateDCBreakerEvent(
     var dCBreakerId: UUID? = null
)

data class DeleteDCBreakerEvent(@Id var dCBreakerId: UUID? = null)

// single association events

// multiple association events


// DCBusbar Events

data class CreateDCBusbarEvent(
     var dCBusbarId: UUID? = null
)

data class UpdateDCBusbarEvent(
     var dCBusbarId: UUID? = null
)

data class DeleteDCBusbarEvent(@Id var dCBusbarId: UUID? = null)

// single association events

// multiple association events


// DCChopper Events

data class CreateDCChopperEvent(
     var dCChopperId: UUID? = null
)

data class UpdateDCChopperEvent(
     var dCChopperId: UUID? = null
)

data class DeleteDCChopperEvent(@Id var dCChopperId: UUID? = null)

// single association events

// multiple association events


// DCConductingEquipment Events

data class CreateDCConductingEquipmentEvent(
     var dCConductingEquipmentId: UUID? = null
)

data class UpdateDCConductingEquipmentEvent(
     var dCConductingEquipmentId: UUID? = null
)

data class DeleteDCConductingEquipmentEvent(@Id var dCConductingEquipmentId: UUID? = null)

// single association events

// multiple association events


// DCConverterUnit Events

data class CreateDCConverterUnitEvent(
    @Id var dCConverterUnitId: UUID? = null,
    var operationMode: String
)

data class UpdateDCConverterUnitEvent(
    @Id var dCConverterUnitId: UUID? = null,
    var operationMode: String
)

data class DeleteDCConverterUnitEvent(@Id var dCConverterUnitId: UUID? = null)

// single association events

// multiple association events


// DCDisconnector Events

data class CreateDCDisconnectorEvent(
     var dCDisconnectorId: UUID? = null
)

data class UpdateDCDisconnectorEvent(
     var dCDisconnectorId: UUID? = null
)

data class DeleteDCDisconnectorEvent(@Id var dCDisconnectorId: UUID? = null)

// single association events

// multiple association events


// DCEquipmentContainer Events

data class CreateDCEquipmentContainerEvent(
     var dCEquipmentContainerId: UUID? = null
)

data class UpdateDCEquipmentContainerEvent(
     var dCEquipmentContainerId: UUID? = null
)

data class DeleteDCEquipmentContainerEvent(@Id var dCEquipmentContainerId: UUID? = null)

// single association events

// multiple association events


// DCGround Events

data class CreateDCGroundEvent(
    @Id var dCGroundId: UUID? = null,
    var inductance: String,
    var r: String
)

data class UpdateDCGroundEvent(
    @Id var dCGroundId: UUID? = null,
    var inductance: String,
    var r: String
)

data class DeleteDCGroundEvent(@Id var dCGroundId: UUID? = null)

// single association events

// multiple association events


// DCLine Events

data class CreateDCLineEvent(
     var dCLineId: UUID? = null
)

data class UpdateDCLineEvent(
     var dCLineId: UUID? = null
)

data class DeleteDCLineEvent(@Id var dCLineId: UUID? = null)

// single association events

// multiple association events


// DCLineSegment Events

data class CreateDCLineSegmentEvent(
    @Id var dCLineSegmentId: UUID? = null,
    var capacitance: String,
    var inductance: String,
    var length: String,
    var resistance: String
)

data class UpdateDCLineSegmentEvent(
    @Id var dCLineSegmentId: UUID? = null,
    var capacitance: String,
    var inductance: String,
    var length: String,
    var resistance: String
)

data class DeleteDCLineSegmentEvent(@Id var dCLineSegmentId: UUID? = null)

// single association events

// multiple association events


// DCNode Events

data class CreateDCNodeEvent(
     var dCNodeId: UUID? = null
)

data class UpdateDCNodeEvent(
     var dCNodeId: UUID? = null
)

data class DeleteDCNodeEvent(@Id var dCNodeId: UUID? = null)

// single association events

// multiple association events


// DCSeriesDevice Events

data class CreateDCSeriesDeviceEvent(
    @Id var dCSeriesDeviceId: UUID? = null,
    var inductance: String,
    var ratedUdc: String,
    var resistance: String
)

data class UpdateDCSeriesDeviceEvent(
    @Id var dCSeriesDeviceId: UUID? = null,
    var inductance: String,
    var ratedUdc: String,
    var resistance: String
)

data class DeleteDCSeriesDeviceEvent(@Id var dCSeriesDeviceId: UUID? = null)

// single association events

// multiple association events


// DCShunt Events

data class CreateDCShuntEvent(
    @Id var dCShuntId: UUID? = null,
    var capacitance: String,
    var ratedUdc: String,
    var resistance: String
)

data class UpdateDCShuntEvent(
    @Id var dCShuntId: UUID? = null,
    var capacitance: String,
    var ratedUdc: String,
    var resistance: String
)

data class DeleteDCShuntEvent(@Id var dCShuntId: UUID? = null)

// single association events

// multiple association events


// DCSwitch Events

data class CreateDCSwitchEvent(
     var dCSwitchId: UUID? = null
)

data class UpdateDCSwitchEvent(
     var dCSwitchId: UUID? = null
)

data class DeleteDCSwitchEvent(@Id var dCSwitchId: UUID? = null)

// single association events

// multiple association events


// DCTerminal Events

data class CreateDCTerminalEvent(
     var dCTerminalId: UUID? = null
)

data class UpdateDCTerminalEvent(
     var dCTerminalId: UUID? = null
)

data class DeleteDCTerminalEvent(@Id var dCTerminalId: UUID? = null)

// single association events

// multiple association events


// DCTopologicalIsland Events

data class CreateDCTopologicalIslandEvent(
     var dCTopologicalIslandId: UUID? = null
)

data class UpdateDCTopologicalIslandEvent(
     var dCTopologicalIslandId: UUID? = null
)

data class DeleteDCTopologicalIslandEvent(@Id var dCTopologicalIslandId: UUID? = null)

// single association events

// multiple association events


// DCTopologicalNode Events

data class CreateDCTopologicalNodeEvent(
     var dCTopologicalNodeId: UUID? = null
)

data class UpdateDCTopologicalNodeEvent(
     var dCTopologicalNodeId: UUID? = null
)

data class DeleteDCTopologicalNodeEvent(@Id var dCTopologicalNodeId: UUID? = null)

// single association events

// multiple association events


// DateProxy Events

data class CreateDateProxyEvent(
     var dateProxyId: UUID? = null
)

data class UpdateDateProxyEvent(
     var dateProxyId: UUID? = null
)

data class DeleteDateProxyEvent(@Id var dateProxyId: UUID? = null)

// single association events

// multiple association events


// DateTime Events

data class CreateDateTimeEvent(
     var dateTimeId: UUID? = null
)

data class UpdateDateTimeEvent(
     var dateTimeId: UUID? = null
)

data class DeleteDateTimeEvent(@Id var dateTimeId: UUID? = null)

// single association events

// multiple association events


// DayType Events

data class CreateDayTypeEvent(
     var dayTypeId: UUID? = null
)

data class UpdateDayTypeEvent(
     var dayTypeId: UUID? = null
)

data class DeleteDayTypeEvent(@Id var dayTypeId: UUID? = null)

// single association events

// multiple association events


// DecimalProxy Events

data class CreateDecimalProxyEvent(
     var decimalProxyId: UUID? = null
)

data class UpdateDecimalProxyEvent(
     var decimalProxyId: UUID? = null
)

data class DeleteDecimalProxyEvent(@Id var decimalProxyId: UUID? = null)

// single association events

// multiple association events


// Diagram Events

data class CreateDiagramEvent(
    @Id var diagramId: UUID? = null,
    var orientation: String,
    var x1InitialView: String,
    var x2InitialView: String,
    var y1InitialView: String,
    var y2InitialView: String
)

data class UpdateDiagramEvent(
    @Id var diagramId: UUID? = null,
    var orientation: String,
    var x1InitialView: String,
    var x2InitialView: String,
    var y1InitialView: String,
    var y2InitialView: String
)

data class DeleteDiagramEvent(@Id var diagramId: UUID? = null)

// single association events

// multiple association events


// DiagramLayoutVersion Events

data class CreateDiagramLayoutVersionEvent(
    @Id var diagramLayoutVersionId: UUID? = null,
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

data class UpdateDiagramLayoutVersionEvent(
    @Id var diagramLayoutVersionId: UUID? = null,
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

data class DeleteDiagramLayoutVersionEvent(@Id var diagramLayoutVersionId: UUID? = null)

// single association events

// multiple association events


// DiagramObject Events

data class CreateDiagramObjectEvent(
    @Id var diagramObjectId: UUID? = null,
    var drawingOrder: String,
    var isPolygon: String,
    var offsetX: String,
    var offsetY: String,
    var rotation: String
)

data class UpdateDiagramObjectEvent(
    @Id var diagramObjectId: UUID? = null,
    var drawingOrder: String,
    var isPolygon: String,
    var offsetX: String,
    var offsetY: String,
    var rotation: String
)

data class DeleteDiagramObjectEvent(@Id var diagramObjectId: UUID? = null)

// single association events

// multiple association events


// DiagramObjectGluePoint Events

data class CreateDiagramObjectGluePointEvent(
     var diagramObjectGluePointId: UUID? = null
)

data class UpdateDiagramObjectGluePointEvent(
     var diagramObjectGluePointId: UUID? = null
)

data class DeleteDiagramObjectGluePointEvent(@Id var diagramObjectGluePointId: UUID? = null)

// single association events

// multiple association events


// DiagramObjectPoint Events

data class CreateDiagramObjectPointEvent(
    @Id var diagramObjectPointId: UUID? = null,
    var sequenceNumber: String,
    var xPosition: String,
    var yPosition: String,
    var zPosition: String
)

data class UpdateDiagramObjectPointEvent(
    @Id var diagramObjectPointId: UUID? = null,
    var sequenceNumber: String,
    var xPosition: String,
    var yPosition: String,
    var zPosition: String
)

data class DeleteDiagramObjectPointEvent(@Id var diagramObjectPointId: UUID? = null)

// single association events

// multiple association events


// DiagramObjectStyle Events

data class CreateDiagramObjectStyleEvent(
     var diagramObjectStyleId: UUID? = null
)

data class UpdateDiagramObjectStyleEvent(
     var diagramObjectStyleId: UUID? = null
)

data class DeleteDiagramObjectStyleEvent(@Id var diagramObjectStyleId: UUID? = null)

// single association events

// multiple association events


// DiagramStyle Events

data class CreateDiagramStyleEvent(
     var diagramStyleId: UUID? = null
)

data class UpdateDiagramStyleEvent(
     var diagramStyleId: UUID? = null
)

data class DeleteDiagramStyleEvent(@Id var diagramStyleId: UUID? = null)

// single association events

// multiple association events


// DiscExcContIEEEDEC1A Events

data class CreateDiscExcContIEEEDEC1AEvent(
    @Id var discExcContIEEEDEC1AId: UUID? = null,
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

data class UpdateDiscExcContIEEEDEC1AEvent(
    @Id var discExcContIEEEDEC1AId: UUID? = null,
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

data class DeleteDiscExcContIEEEDEC1AEvent(@Id var discExcContIEEEDEC1AId: UUID? = null)

// single association events

// multiple association events


// DiscExcContIEEEDEC2A Events

data class CreateDiscExcContIEEEDEC2AEvent(
    @Id var discExcContIEEEDEC2AId: UUID? = null,
    var td1: String,
    var td2: String,
    var vdmax: String,
    var vdmin: String,
    var vk: String
)

data class UpdateDiscExcContIEEEDEC2AEvent(
    @Id var discExcContIEEEDEC2AId: UUID? = null,
    var td1: String,
    var td2: String,
    var vdmax: String,
    var vdmin: String,
    var vk: String
)

data class DeleteDiscExcContIEEEDEC2AEvent(@Id var discExcContIEEEDEC2AId: UUID? = null)

// single association events

// multiple association events


// DiscExcContIEEEDEC3A Events

data class CreateDiscExcContIEEEDEC3AEvent(
    @Id var discExcContIEEEDEC3AId: UUID? = null,
    var tdr: String,
    var vtmin: String
)

data class UpdateDiscExcContIEEEDEC3AEvent(
    @Id var discExcContIEEEDEC3AId: UUID? = null,
    var tdr: String,
    var vtmin: String
)

data class DeleteDiscExcContIEEEDEC3AEvent(@Id var discExcContIEEEDEC3AId: UUID? = null)

// single association events

// multiple association events


// Disconnector Events

data class CreateDisconnectorEvent(
     var disconnectorId: UUID? = null
)

data class UpdateDisconnectorEvent(
     var disconnectorId: UUID? = null
)

data class DeleteDisconnectorEvent(@Id var disconnectorId: UUID? = null)

// single association events

// multiple association events


// DiscontinuousExcitationControlDynamics Events

data class CreateDiscontinuousExcitationControlDynamicsEvent(
     var discontinuousExcitationControlDynamicsId: UUID? = null
)

data class UpdateDiscontinuousExcitationControlDynamicsEvent(
     var discontinuousExcitationControlDynamicsId: UUID? = null
)

data class DeleteDiscontinuousExcitationControlDynamicsEvent(@Id var discontinuousExcitationControlDynamicsId: UUID? = null)

// single association events

// multiple association events


// DiscontinuousExcitationControlUserDefined Events

data class CreateDiscontinuousExcitationControlUserDefinedEvent(
    @Id var discontinuousExcitationControlUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateDiscontinuousExcitationControlUserDefinedEvent(
    @Id var discontinuousExcitationControlUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteDiscontinuousExcitationControlUserDefinedEvent(@Id var discontinuousExcitationControlUserDefinedId: UUID? = null)

// single association events

// multiple association events


// Discrete Events

data class CreateDiscreteEvent(
     var discreteId: UUID? = null
)

data class UpdateDiscreteEvent(
     var discreteId: UUID? = null
)

data class DeleteDiscreteEvent(@Id var discreteId: UUID? = null)

// single association events

// multiple association events


// DiscreteValue Events

data class CreateDiscreteValueEvent(
    @Id var discreteValueId: UUID? = null,
    var value: String
)

data class UpdateDiscreteValueEvent(
    @Id var discreteValueId: UUID? = null,
    var value: String
)

data class DeleteDiscreteValueEvent(@Id var discreteValueId: UUID? = null)

// single association events

// multiple association events


// DomainVersion Events

data class CreateDomainVersionEvent(
    @Id var domainVersionId: UUID? = null,
    var baseUML: String,
    var date: String,
    var entsoeUML: String,
    var version: String
)

data class UpdateDomainVersionEvent(
    @Id var domainVersionId: UUID? = null,
    var baseUML: String,
    var date: String,
    var entsoeUML: String,
    var version: String
)

data class DeleteDomainVersionEvent(@Id var domainVersionId: UUID? = null)

// single association events

// multiple association events


// DynamicsFunctionBlock Events

data class CreateDynamicsFunctionBlockEvent(
    @Id var dynamicsFunctionBlockId: UUID? = null,
    var enabled: String
)

data class UpdateDynamicsFunctionBlockEvent(
    @Id var dynamicsFunctionBlockId: UUID? = null,
    var enabled: String
)

data class DeleteDynamicsFunctionBlockEvent(@Id var dynamicsFunctionBlockId: UUID? = null)

// single association events

// multiple association events


// DynamicsVersion Events

data class CreateDynamicsVersionEvent(
    @Id var dynamicsVersionId: UUID? = null,
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

data class UpdateDynamicsVersionEvent(
    @Id var dynamicsVersionId: UUID? = null,
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

data class DeleteDynamicsVersionEvent(@Id var dynamicsVersionId: UUID? = null)

// single association events

// multiple association events


// Dynamicsmodel Events

data class CreateDynamicsmodelEvent(
     var dynamicsmodelId: UUID? = null
)

data class UpdateDynamicsmodelEvent(
     var dynamicsmodelId: UUID? = null
)

data class DeleteDynamicsmodelEvent(@Id var dynamicsmodelId: UUID? = null)

// single association events

// multiple association events


// ENTSOEConnectivityNode Events

data class CreateENTSOEConnectivityNodeEvent(
     var eNTSOEConnectivityNodeId: UUID? = null
)

data class UpdateENTSOEConnectivityNodeEvent(
     var eNTSOEConnectivityNodeId: UUID? = null
)

data class DeleteENTSOEConnectivityNodeEvent(@Id var eNTSOEConnectivityNodeId: UUID? = null)

// single association events

// multiple association events


// ENTSOEIdentifiedObject Events

data class CreateENTSOEIdentifiedObjectEvent(
    @Id var eNTSOEIdentifiedObjectId: UUID? = null,
    var energyIdentCodeEic: String,
    var shortName: String
)

data class UpdateENTSOEIdentifiedObjectEvent(
    @Id var eNTSOEIdentifiedObjectId: UUID? = null,
    var energyIdentCodeEic: String,
    var shortName: String
)

data class DeleteENTSOEIdentifiedObjectEvent(@Id var eNTSOEIdentifiedObjectId: UUID? = null)

// single association events

// multiple association events


// ENTSOEJunction Events

data class CreateENTSOEJunctionEvent(
     var eNTSOEJunctionId: UUID? = null
)

data class UpdateENTSOEJunctionEvent(
     var eNTSOEJunctionId: UUID? = null
)

data class DeleteENTSOEJunctionEvent(@Id var eNTSOEJunctionId: UUID? = null)

// single association events

// multiple association events


// ENTSOEOperationalLimitType Events

data class CreateENTSOEOperationalLimitTypeEvent(
    @Id var eNTSOEOperationalLimitTypeId: UUID? = null,
    var limitType: String
)

data class UpdateENTSOEOperationalLimitTypeEvent(
    @Id var eNTSOEOperationalLimitTypeId: UUID? = null,
    var limitType: String
)

data class DeleteENTSOEOperationalLimitTypeEvent(@Id var eNTSOEOperationalLimitTypeId: UUID? = null)

// single association events

// multiple association events


// ENTSOETopologicalNode Events

data class CreateENTSOETopologicalNodeEvent(
     var eNTSOETopologicalNodeId: UUID? = null
)

data class UpdateENTSOETopologicalNodeEvent(
     var eNTSOETopologicalNodeId: UUID? = null
)

data class DeleteENTSOETopologicalNodeEvent(@Id var eNTSOETopologicalNodeId: UUID? = null)

// single association events

// multiple association events


// EarthFaultCompensator Events

data class CreateEarthFaultCompensatorEvent(
    @Id var earthFaultCompensatorId: UUID? = null,
    var r: String
)

data class UpdateEarthFaultCompensatorEvent(
    @Id var earthFaultCompensatorId: UUID? = null,
    var r: String
)

data class DeleteEarthFaultCompensatorEvent(@Id var earthFaultCompensatorId: UUID? = null)

// single association events

// multiple association events


// EnergyArea Events

data class CreateEnergyAreaEvent(
     var energyAreaId: UUID? = null
)

data class UpdateEnergyAreaEvent(
     var energyAreaId: UUID? = null
)

data class DeleteEnergyAreaEvent(@Id var energyAreaId: UUID? = null)

// single association events

// multiple association events


// EnergyConsumer Events

data class CreateEnergyConsumerEvent(
    @Id var energyConsumerId: UUID? = null,
    var pfixed: String,
    var pfixedPct: String,
    var qfixed: String,
    var qfixedPct: String
)

data class UpdateEnergyConsumerEvent(
    @Id var energyConsumerId: UUID? = null,
    var pfixed: String,
    var pfixedPct: String,
    var qfixed: String,
    var qfixedPct: String
)

data class DeleteEnergyConsumerEvent(@Id var energyConsumerId: UUID? = null)

// single association events

// multiple association events


// EnergySchedulingType Events

data class CreateEnergySchedulingTypeEvent(
     var energySchedulingTypeId: UUID? = null
)

data class UpdateEnergySchedulingTypeEvent(
     var energySchedulingTypeId: UUID? = null
)

data class DeleteEnergySchedulingTypeEvent(@Id var energySchedulingTypeId: UUID? = null)

// single association events

// multiple association events


// EnergySource Events

data class CreateEnergySourceEvent(
     var energySourceId: UUID? = null
)

data class UpdateEnergySourceEvent(
     var energySourceId: UUID? = null
)

data class DeleteEnergySourceEvent(@Id var energySourceId: UUID? = null)

// single association events

// multiple association events


// Equipment Events

data class CreateEquipmentEvent(
     var equipmentId: UUID? = null
)

data class UpdateEquipmentEvent(
     var equipmentId: UUID? = null
)

data class DeleteEquipmentEvent(@Id var equipmentId: UUID? = null)

// single association events

// multiple association events


// EquipmentBoundaryVersion Events

data class CreateEquipmentBoundaryVersionEvent(
    @Id var equipmentBoundaryVersionId: UUID? = null,
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

data class UpdateEquipmentBoundaryVersionEvent(
    @Id var equipmentBoundaryVersionId: UUID? = null,
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

data class DeleteEquipmentBoundaryVersionEvent(@Id var equipmentBoundaryVersionId: UUID? = null)

// single association events

// multiple association events


// EquipmentContainer Events

data class CreateEquipmentContainerEvent(
     var equipmentContainerId: UUID? = null
)

data class UpdateEquipmentContainerEvent(
     var equipmentContainerId: UUID? = null
)

data class DeleteEquipmentContainerEvent(@Id var equipmentContainerId: UUID? = null)

// single association events

// multiple association events


// EquipmentVersion Events

data class CreateEquipmentVersionEvent(
    @Id var equipmentVersionId: UUID? = null,
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

data class UpdateEquipmentVersionEvent(
    @Id var equipmentVersionId: UUID? = null,
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

data class DeleteEquipmentVersionEvent(@Id var equipmentVersionId: UUID? = null)

// single association events

// multiple association events


// EquivalentBranch Events

data class CreateEquivalentBranchEvent(
    @Id var equivalentBranchId: UUID? = null,
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

data class UpdateEquivalentBranchEvent(
    @Id var equivalentBranchId: UUID? = null,
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

data class DeleteEquivalentBranchEvent(@Id var equivalentBranchId: UUID? = null)

// single association events

// multiple association events


// EquivalentEquipment Events

data class CreateEquivalentEquipmentEvent(
     var equivalentEquipmentId: UUID? = null
)

data class UpdateEquivalentEquipmentEvent(
     var equivalentEquipmentId: UUID? = null
)

data class DeleteEquivalentEquipmentEvent(@Id var equivalentEquipmentId: UUID? = null)

// single association events

// multiple association events


// EquivalentInjection Events

data class CreateEquivalentInjectionEvent(
    @Id var equivalentInjectionId: UUID? = null,
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

data class UpdateEquivalentInjectionEvent(
    @Id var equivalentInjectionId: UUID? = null,
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

data class DeleteEquivalentInjectionEvent(@Id var equivalentInjectionId: UUID? = null)

// single association events

// multiple association events


// EquivalentNetwork Events

data class CreateEquivalentNetworkEvent(
     var equivalentNetworkId: UUID? = null
)

data class UpdateEquivalentNetworkEvent(
     var equivalentNetworkId: UUID? = null
)

data class DeleteEquivalentNetworkEvent(@Id var equivalentNetworkId: UUID? = null)

// single association events

// multiple association events


// EquivalentShunt Events

data class CreateEquivalentShuntEvent(
    @Id var equivalentShuntId: UUID? = null,
    var b: String,
    var g: String
)

data class UpdateEquivalentShuntEvent(
    @Id var equivalentShuntId: UUID? = null,
    var b: String,
    var g: String
)

data class DeleteEquivalentShuntEvent(@Id var equivalentShuntId: UUID? = null)

// single association events

// multiple association events


// ExcAC1A Events

data class CreateExcAC1AEvent(
    @Id var excAC1AId: UUID? = null,
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

data class UpdateExcAC1AEvent(
    @Id var excAC1AId: UUID? = null,
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

data class DeleteExcAC1AEvent(@Id var excAC1AId: UUID? = null)

// single association events

// multiple association events


// ExcAC2A Events

data class CreateExcAC2AEvent(
    @Id var excAC2AId: UUID? = null,
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

data class UpdateExcAC2AEvent(
    @Id var excAC2AId: UUID? = null,
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

data class DeleteExcAC2AEvent(@Id var excAC2AId: UUID? = null)

// single association events

// multiple association events


// ExcAC3A Events

data class CreateExcAC3AEvent(
    @Id var excAC3AId: UUID? = null,
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

data class UpdateExcAC3AEvent(
    @Id var excAC3AId: UUID? = null,
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

data class DeleteExcAC3AEvent(@Id var excAC3AId: UUID? = null)

// single association events

// multiple association events


// ExcAC4A Events

data class CreateExcAC4AEvent(
    @Id var excAC4AId: UUID? = null,
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

data class UpdateExcAC4AEvent(
    @Id var excAC4AId: UUID? = null,
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

data class DeleteExcAC4AEvent(@Id var excAC4AId: UUID? = null)

// single association events

// multiple association events


// ExcAC5A Events

data class CreateExcAC5AEvent(
    @Id var excAC5AId: UUID? = null,
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

data class UpdateExcAC5AEvent(
    @Id var excAC5AId: UUID? = null,
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

data class DeleteExcAC5AEvent(@Id var excAC5AId: UUID? = null)

// single association events

// multiple association events


// ExcAC6A Events

data class CreateExcAC6AEvent(
    @Id var excAC6AId: UUID? = null,
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

data class UpdateExcAC6AEvent(
    @Id var excAC6AId: UUID? = null,
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

data class DeleteExcAC6AEvent(@Id var excAC6AId: UUID? = null)

// single association events

// multiple association events


// ExcAC8B Events

data class CreateExcAC8BEvent(
    @Id var excAC8BId: UUID? = null,
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

data class UpdateExcAC8BEvent(
    @Id var excAC8BId: UUID? = null,
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

data class DeleteExcAC8BEvent(@Id var excAC8BId: UUID? = null)

// single association events

// multiple association events


// ExcANS Events

data class CreateExcANSEvent(
    @Id var excANSId: UUID? = null,
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

data class UpdateExcANSEvent(
    @Id var excANSId: UUID? = null,
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

data class DeleteExcANSEvent(@Id var excANSId: UUID? = null)

// single association events

// multiple association events


// ExcAVR1 Events

data class CreateExcAVR1Event(
    @Id var excAVR1Id: UUID? = null,
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

data class UpdateExcAVR1Event(
    @Id var excAVR1Id: UUID? = null,
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

data class DeleteExcAVR1Event(@Id var excAVR1Id: UUID? = null)

// single association events

// multiple association events


// ExcAVR2 Events

data class CreateExcAVR2Event(
    @Id var excAVR2Id: UUID? = null,
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

data class UpdateExcAVR2Event(
    @Id var excAVR2Id: UUID? = null,
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

data class DeleteExcAVR2Event(@Id var excAVR2Id: UUID? = null)

// single association events

// multiple association events


// ExcAVR3 Events

data class CreateExcAVR3Event(
    @Id var excAVR3Id: UUID? = null,
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

data class UpdateExcAVR3Event(
    @Id var excAVR3Id: UUID? = null,
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

data class DeleteExcAVR3Event(@Id var excAVR3Id: UUID? = null)

// single association events

// multiple association events


// ExcAVR4 Events

data class CreateExcAVR4Event(
    @Id var excAVR4Id: UUID? = null,
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

data class UpdateExcAVR4Event(
    @Id var excAVR4Id: UUID? = null,
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

data class DeleteExcAVR4Event(@Id var excAVR4Id: UUID? = null)

// single association events

// multiple association events


// ExcAVR5 Events

data class CreateExcAVR5Event(
    @Id var excAVR5Id: UUID? = null,
    var ka: String,
    var rex: String,
    var ta: String
)

data class UpdateExcAVR5Event(
    @Id var excAVR5Id: UUID? = null,
    var ka: String,
    var rex: String,
    var ta: String
)

data class DeleteExcAVR5Event(@Id var excAVR5Id: UUID? = null)

// single association events

// multiple association events


// ExcAVR7 Events

data class CreateExcAVR7Event(
    @Id var excAVR7Id: UUID? = null,
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

data class UpdateExcAVR7Event(
    @Id var excAVR7Id: UUID? = null,
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

data class DeleteExcAVR7Event(@Id var excAVR7Id: UUID? = null)

// single association events

// multiple association events


// ExcBBC Events

data class CreateExcBBCEvent(
    @Id var excBBCId: UUID? = null,
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

data class UpdateExcBBCEvent(
    @Id var excBBCId: UUID? = null,
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

data class DeleteExcBBCEvent(@Id var excBBCId: UUID? = null)

// single association events

// multiple association events


// ExcCZ Events

data class CreateExcCZEvent(
    @Id var excCZId: UUID? = null,
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

data class UpdateExcCZEvent(
    @Id var excCZId: UUID? = null,
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

data class DeleteExcCZEvent(@Id var excCZId: UUID? = null)

// single association events

// multiple association events


// ExcDC1A Events

data class CreateExcDC1AEvent(
    @Id var excDC1AId: UUID? = null,
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

data class UpdateExcDC1AEvent(
    @Id var excDC1AId: UUID? = null,
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

data class DeleteExcDC1AEvent(@Id var excDC1AId: UUID? = null)

// single association events

// multiple association events


// ExcDC2A Events

data class CreateExcDC2AEvent(
    @Id var excDC2AId: UUID? = null,
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

data class UpdateExcDC2AEvent(
    @Id var excDC2AId: UUID? = null,
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

data class DeleteExcDC2AEvent(@Id var excDC2AId: UUID? = null)

// single association events

// multiple association events


// ExcDC3A Events

data class CreateExcDC3AEvent(
    @Id var excDC3AId: UUID? = null,
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

data class UpdateExcDC3AEvent(
    @Id var excDC3AId: UUID? = null,
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

data class DeleteExcDC3AEvent(@Id var excDC3AId: UUID? = null)

// single association events

// multiple association events


// ExcDC3A1 Events

data class CreateExcDC3A1Event(
    @Id var excDC3A1Id: UUID? = null,
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

data class UpdateExcDC3A1Event(
    @Id var excDC3A1Id: UUID? = null,
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

data class DeleteExcDC3A1Event(@Id var excDC3A1Id: UUID? = null)

// single association events

// multiple association events


// ExcELIN1 Events

data class CreateExcELIN1Event(
    @Id var excELIN1Id: UUID? = null,
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

data class UpdateExcELIN1Event(
    @Id var excELIN1Id: UUID? = null,
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

data class DeleteExcELIN1Event(@Id var excELIN1Id: UUID? = null)

// single association events

// multiple association events


// ExcELIN2 Events

data class CreateExcELIN2Event(
    @Id var excELIN2Id: UUID? = null,
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

data class UpdateExcELIN2Event(
    @Id var excELIN2Id: UUID? = null,
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

data class DeleteExcELIN2Event(@Id var excELIN2Id: UUID? = null)

// single association events

// multiple association events


// ExcHU Events

data class CreateExcHUEvent(
    @Id var excHUId: UUID? = null,
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

data class UpdateExcHUEvent(
    @Id var excHUId: UUID? = null,
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

data class DeleteExcHUEvent(@Id var excHUId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC1A Events

data class CreateExcIEEEAC1AEvent(
    @Id var excIEEEAC1AId: UUID? = null,
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

data class UpdateExcIEEEAC1AEvent(
    @Id var excIEEEAC1AId: UUID? = null,
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

data class DeleteExcIEEEAC1AEvent(@Id var excIEEEAC1AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC2A Events

data class CreateExcIEEEAC2AEvent(
    @Id var excIEEEAC2AId: UUID? = null,
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

data class UpdateExcIEEEAC2AEvent(
    @Id var excIEEEAC2AId: UUID? = null,
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

data class DeleteExcIEEEAC2AEvent(@Id var excIEEEAC2AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC3A Events

data class CreateExcIEEEAC3AEvent(
    @Id var excIEEEAC3AId: UUID? = null,
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

data class UpdateExcIEEEAC3AEvent(
    @Id var excIEEEAC3AId: UUID? = null,
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

data class DeleteExcIEEEAC3AEvent(@Id var excIEEEAC3AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC4A Events

data class CreateExcIEEEAC4AEvent(
    @Id var excIEEEAC4AId: UUID? = null,
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

data class UpdateExcIEEEAC4AEvent(
    @Id var excIEEEAC4AId: UUID? = null,
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

data class DeleteExcIEEEAC4AEvent(@Id var excIEEEAC4AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC5A Events

data class CreateExcIEEEAC5AEvent(
    @Id var excIEEEAC5AId: UUID? = null,
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

data class UpdateExcIEEEAC5AEvent(
    @Id var excIEEEAC5AId: UUID? = null,
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

data class DeleteExcIEEEAC5AEvent(@Id var excIEEEAC5AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC6A Events

data class CreateExcIEEEAC6AEvent(
    @Id var excIEEEAC6AId: UUID? = null,
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

data class UpdateExcIEEEAC6AEvent(
    @Id var excIEEEAC6AId: UUID? = null,
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

data class DeleteExcIEEEAC6AEvent(@Id var excIEEEAC6AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC7B Events

data class CreateExcIEEEAC7BEvent(
    @Id var excIEEEAC7BId: UUID? = null,
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

data class UpdateExcIEEEAC7BEvent(
    @Id var excIEEEAC7BId: UUID? = null,
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

data class DeleteExcIEEEAC7BEvent(@Id var excIEEEAC7BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC8B Events

data class CreateExcIEEEAC8BEvent(
    @Id var excIEEEAC8BId: UUID? = null,
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

data class UpdateExcIEEEAC8BEvent(
    @Id var excIEEEAC8BId: UUID? = null,
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

data class DeleteExcIEEEAC8BEvent(@Id var excIEEEAC8BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEDC1A Events

data class CreateExcIEEEDC1AEvent(
    @Id var excIEEEDC1AId: UUID? = null,
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

data class UpdateExcIEEEDC1AEvent(
    @Id var excIEEEDC1AId: UUID? = null,
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

data class DeleteExcIEEEDC1AEvent(@Id var excIEEEDC1AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEDC2A Events

data class CreateExcIEEEDC2AEvent(
    @Id var excIEEEDC2AId: UUID? = null,
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

data class UpdateExcIEEEDC2AEvent(
    @Id var excIEEEDC2AId: UUID? = null,
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

data class DeleteExcIEEEDC2AEvent(@Id var excIEEEDC2AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEDC3A Events

data class CreateExcIEEEDC3AEvent(
    @Id var excIEEEDC3AId: UUID? = null,
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

data class UpdateExcIEEEDC3AEvent(
    @Id var excIEEEDC3AId: UUID? = null,
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

data class DeleteExcIEEEDC3AEvent(@Id var excIEEEDC3AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEDC4B Events

data class CreateExcIEEEDC4BEvent(
    @Id var excIEEEDC4BId: UUID? = null,
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

data class UpdateExcIEEEDC4BEvent(
    @Id var excIEEEDC4BId: UUID? = null,
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

data class DeleteExcIEEEDC4BEvent(@Id var excIEEEDC4BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST1A Events

data class CreateExcIEEEST1AEvent(
    @Id var excIEEEST1AId: UUID? = null,
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

data class UpdateExcIEEEST1AEvent(
    @Id var excIEEEST1AId: UUID? = null,
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

data class DeleteExcIEEEST1AEvent(@Id var excIEEEST1AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST2A Events

data class CreateExcIEEEST2AEvent(
    @Id var excIEEEST2AId: UUID? = null,
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

data class UpdateExcIEEEST2AEvent(
    @Id var excIEEEST2AId: UUID? = null,
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

data class DeleteExcIEEEST2AEvent(@Id var excIEEEST2AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST3A Events

data class CreateExcIEEEST3AEvent(
    @Id var excIEEEST3AId: UUID? = null,
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

data class UpdateExcIEEEST3AEvent(
    @Id var excIEEEST3AId: UUID? = null,
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

data class DeleteExcIEEEST3AEvent(@Id var excIEEEST3AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST4B Events

data class CreateExcIEEEST4BEvent(
    @Id var excIEEEST4BId: UUID? = null,
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

data class UpdateExcIEEEST4BEvent(
    @Id var excIEEEST4BId: UUID? = null,
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

data class DeleteExcIEEEST4BEvent(@Id var excIEEEST4BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST5B Events

data class CreateExcIEEEST5BEvent(
    @Id var excIEEEST5BId: UUID? = null,
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

data class UpdateExcIEEEST5BEvent(
    @Id var excIEEEST5BId: UUID? = null,
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

data class DeleteExcIEEEST5BEvent(@Id var excIEEEST5BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST6B Events

data class CreateExcIEEEST6BEvent(
    @Id var excIEEEST6BId: UUID? = null,
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

data class UpdateExcIEEEST6BEvent(
    @Id var excIEEEST6BId: UUID? = null,
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

data class DeleteExcIEEEST6BEvent(@Id var excIEEEST6BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST7B Events

data class CreateExcIEEEST7BEvent(
    @Id var excIEEEST7BId: UUID? = null,
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

data class UpdateExcIEEEST7BEvent(
    @Id var excIEEEST7BId: UUID? = null,
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

data class DeleteExcIEEEST7BEvent(@Id var excIEEEST7BId: UUID? = null)

// single association events

// multiple association events


// ExcOEX3T Events

data class CreateExcOEX3TEvent(
    @Id var excOEX3TId: UUID? = null,
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

data class UpdateExcOEX3TEvent(
    @Id var excOEX3TId: UUID? = null,
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

data class DeleteExcOEX3TEvent(@Id var excOEX3TId: UUID? = null)

// single association events

// multiple association events


// ExcPIC Events

data class CreateExcPICEvent(
    @Id var excPICId: UUID? = null,
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

data class UpdateExcPICEvent(
    @Id var excPICId: UUID? = null,
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

data class DeleteExcPICEvent(@Id var excPICId: UUID? = null)

// single association events

// multiple association events


// ExcREXS Events

data class CreateExcREXSEvent(
    @Id var excREXSId: UUID? = null,
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

data class UpdateExcREXSEvent(
    @Id var excREXSId: UUID? = null,
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

data class DeleteExcREXSEvent(@Id var excREXSId: UUID? = null)

// single association events

// multiple association events


// ExcSCRX Events

data class CreateExcSCRXEvent(
    @Id var excSCRXId: UUID? = null,
    var cswitch: String,
    var emax: String,
    var emin: String,
    var k: String,
    var rcrfd: String,
    var tatb: String,
    var tb: String,
    var te: String
)

data class UpdateExcSCRXEvent(
    @Id var excSCRXId: UUID? = null,
    var cswitch: String,
    var emax: String,
    var emin: String,
    var k: String,
    var rcrfd: String,
    var tatb: String,
    var tb: String,
    var te: String
)

data class DeleteExcSCRXEvent(@Id var excSCRXId: UUID? = null)

// single association events

// multiple association events


// ExcSEXS Events

data class CreateExcSEXSEvent(
    @Id var excSEXSId: UUID? = null,
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

data class UpdateExcSEXSEvent(
    @Id var excSEXSId: UUID? = null,
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

data class DeleteExcSEXSEvent(@Id var excSEXSId: UUID? = null)

// single association events

// multiple association events


// ExcSK Events

data class CreateExcSKEvent(
    @Id var excSKId: UUID? = null,
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

data class UpdateExcSKEvent(
    @Id var excSKId: UUID? = null,
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

data class DeleteExcSKEvent(@Id var excSKId: UUID? = null)

// single association events

// multiple association events


// ExcST1A Events

data class CreateExcST1AEvent(
    @Id var excST1AId: UUID? = null,
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

data class UpdateExcST1AEvent(
    @Id var excST1AId: UUID? = null,
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

data class DeleteExcST1AEvent(@Id var excST1AId: UUID? = null)

// single association events

// multiple association events


// ExcST2A Events

data class CreateExcST2AEvent(
    @Id var excST2AId: UUID? = null,
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

data class UpdateExcST2AEvent(
    @Id var excST2AId: UUID? = null,
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

data class DeleteExcST2AEvent(@Id var excST2AId: UUID? = null)

// single association events

// multiple association events


// ExcST3A Events

data class CreateExcST3AEvent(
    @Id var excST3AId: UUID? = null,
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

data class UpdateExcST3AEvent(
    @Id var excST3AId: UUID? = null,
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

data class DeleteExcST3AEvent(@Id var excST3AId: UUID? = null)

// single association events

// multiple association events


// ExcST4B Events

data class CreateExcST4BEvent(
    @Id var excST4BId: UUID? = null,
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

data class UpdateExcST4BEvent(
    @Id var excST4BId: UUID? = null,
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

data class DeleteExcST4BEvent(@Id var excST4BId: UUID? = null)

// single association events

// multiple association events


// ExcST6B Events

data class CreateExcST6BEvent(
    @Id var excST6BId: UUID? = null,
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

data class UpdateExcST6BEvent(
    @Id var excST6BId: UUID? = null,
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

data class DeleteExcST6BEvent(@Id var excST6BId: UUID? = null)

// single association events

// multiple association events


// ExcST7B Events

data class CreateExcST7BEvent(
    @Id var excST7BId: UUID? = null,
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

data class UpdateExcST7BEvent(
    @Id var excST7BId: UUID? = null,
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

data class DeleteExcST7BEvent(@Id var excST7BId: UUID? = null)

// single association events

// multiple association events


// ExcitationSystemDynamics Events

data class CreateExcitationSystemDynamicsEvent(
     var excitationSystemDynamicsId: UUID? = null
)

data class UpdateExcitationSystemDynamicsEvent(
     var excitationSystemDynamicsId: UUID? = null
)

data class DeleteExcitationSystemDynamicsEvent(@Id var excitationSystemDynamicsId: UUID? = null)

// single association events

// multiple association events


// ExcitationSystemUserDefined Events

data class CreateExcitationSystemUserDefinedEvent(
    @Id var excitationSystemUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateExcitationSystemUserDefinedEvent(
    @Id var excitationSystemUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteExcitationSystemUserDefinedEvent(@Id var excitationSystemUserDefinedId: UUID? = null)

// single association events

// multiple association events


// ExtensionVersion Events

data class CreateExtensionVersionEvent(
    @Id var extensionVersionId: UUID? = null,
    var date: String,
    var namespaceURI: String
)

data class UpdateExtensionVersionEvent(
    @Id var extensionVersionId: UUID? = null,
    var date: String,
    var namespaceURI: String
)

data class DeleteExtensionVersionEvent(@Id var extensionVersionId: UUID? = null)

// single association events

// multiple association events


// ExternalNetworkInjection Events

data class CreateExternalNetworkInjectionEvent(
    @Id var externalNetworkInjectionId: UUID? = null,
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

data class UpdateExternalNetworkInjectionEvent(
    @Id var externalNetworkInjectionId: UUID? = null,
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

data class DeleteExternalNetworkInjectionEvent(@Id var externalNetworkInjectionId: UUID? = null)

// single association events

// multiple association events


// FloatProxy Events

data class CreateFloatProxyEvent(
     var floatProxyId: UUID? = null
)

data class UpdateFloatProxyEvent(
     var floatProxyId: UUID? = null
)

data class DeleteFloatProxyEvent(@Id var floatProxyId: UUID? = null)

// single association events

// multiple association events


// FossilFuel Events

data class CreateFossilFuelEvent(
    @Id var fossilFuelId: UUID? = null,
    var fossilFuelType: String
)

data class UpdateFossilFuelEvent(
    @Id var fossilFuelId: UUID? = null,
    var fossilFuelType: String
)

data class DeleteFossilFuelEvent(@Id var fossilFuelId: UUID? = null)

// single association events

// multiple association events


// Frequency Events

data class CreateFrequencyEvent(
    @Id var frequencyId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateFrequencyEvent(
    @Id var frequencyId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteFrequencyEvent(@Id var frequencyId: UUID? = null)

// single association events

// multiple association events


// GenICompensationForGenJ Events

data class CreateGenICompensationForGenJEvent(
    @Id var genICompensationForGenJId: UUID? = null,
    var rcij: String,
    var xcij: String
)

data class UpdateGenICompensationForGenJEvent(
    @Id var genICompensationForGenJId: UUID? = null,
    var rcij: String,
    var xcij: String
)

data class DeleteGenICompensationForGenJEvent(@Id var genICompensationForGenJId: UUID? = null)

// single association events

// multiple association events


// GeneratingUnit Events

data class CreateGeneratingUnitEvent(
    @Id var generatingUnitId: UUID? = null,
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

data class UpdateGeneratingUnitEvent(
    @Id var generatingUnitId: UUID? = null,
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

data class DeleteGeneratingUnitEvent(@Id var generatingUnitId: UUID? = null)

// single association events

// multiple association events


// GeographicalLocationVersion Events

data class CreateGeographicalLocationVersionEvent(
    @Id var geographicalLocationVersionId: UUID? = null,
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

data class UpdateGeographicalLocationVersionEvent(
    @Id var geographicalLocationVersionId: UUID? = null,
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

data class DeleteGeographicalLocationVersionEvent(@Id var geographicalLocationVersionId: UUID? = null)

// single association events

// multiple association events


// GeographicalRegion Events

data class CreateGeographicalRegionEvent(
     var geographicalRegionId: UUID? = null
)

data class UpdateGeographicalRegionEvent(
     var geographicalRegionId: UUID? = null
)

data class DeleteGeographicalRegionEvent(@Id var geographicalRegionId: UUID? = null)

// single association events

// multiple association events


// GovCT1 Events

data class CreateGovCT1Event(
    @Id var govCT1Id: UUID? = null,
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

data class UpdateGovCT1Event(
    @Id var govCT1Id: UUID? = null,
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

data class DeleteGovCT1Event(@Id var govCT1Id: UUID? = null)

// single association events

// multiple association events


// GovCT2 Events

data class CreateGovCT2Event(
    @Id var govCT2Id: UUID? = null,
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

data class UpdateGovCT2Event(
    @Id var govCT2Id: UUID? = null,
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

data class DeleteGovCT2Event(@Id var govCT2Id: UUID? = null)

// single association events

// multiple association events


// GovGAST Events

data class CreateGovGASTEvent(
    @Id var govGASTId: UUID? = null,
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

data class UpdateGovGASTEvent(
    @Id var govGASTId: UUID? = null,
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

data class DeleteGovGASTEvent(@Id var govGASTId: UUID? = null)

// single association events

// multiple association events


// GovGAST1 Events

data class CreateGovGAST1Event(
    @Id var govGAST1Id: UUID? = null,
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

data class UpdateGovGAST1Event(
    @Id var govGAST1Id: UUID? = null,
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

data class DeleteGovGAST1Event(@Id var govGAST1Id: UUID? = null)

// single association events

// multiple association events


// GovGAST2 Events

data class CreateGovGAST2Event(
    @Id var govGAST2Id: UUID? = null,
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

data class UpdateGovGAST2Event(
    @Id var govGAST2Id: UUID? = null,
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

data class DeleteGovGAST2Event(@Id var govGAST2Id: UUID? = null)

// single association events

// multiple association events


// GovGAST3 Events

data class CreateGovGAST3Event(
    @Id var govGAST3Id: UUID? = null,
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

data class UpdateGovGAST3Event(
    @Id var govGAST3Id: UUID? = null,
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

data class DeleteGovGAST3Event(@Id var govGAST3Id: UUID? = null)

// single association events

// multiple association events


// GovGAST4 Events

data class CreateGovGAST4Event(
    @Id var govGAST4Id: UUID? = null,
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

data class UpdateGovGAST4Event(
    @Id var govGAST4Id: UUID? = null,
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

data class DeleteGovGAST4Event(@Id var govGAST4Id: UUID? = null)

// single association events

// multiple association events


// GovGASTWD Events

data class CreateGovGASTWDEvent(
    @Id var govGASTWDId: UUID? = null,
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

data class UpdateGovGASTWDEvent(
    @Id var govGASTWDId: UUID? = null,
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

data class DeleteGovGASTWDEvent(@Id var govGASTWDId: UUID? = null)

// single association events

// multiple association events


// GovHydro1 Events

data class CreateGovHydro1Event(
    @Id var govHydro1Id: UUID? = null,
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

data class UpdateGovHydro1Event(
    @Id var govHydro1Id: UUID? = null,
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

data class DeleteGovHydro1Event(@Id var govHydro1Id: UUID? = null)

// single association events

// multiple association events


// GovHydro2 Events

data class CreateGovHydro2Event(
    @Id var govHydro2Id: UUID? = null,
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

data class UpdateGovHydro2Event(
    @Id var govHydro2Id: UUID? = null,
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

data class DeleteGovHydro2Event(@Id var govHydro2Id: UUID? = null)

// single association events

// multiple association events


// GovHydro3 Events

data class CreateGovHydro3Event(
    @Id var govHydro3Id: UUID? = null,
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

data class UpdateGovHydro3Event(
    @Id var govHydro3Id: UUID? = null,
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

data class DeleteGovHydro3Event(@Id var govHydro3Id: UUID? = null)

// single association events

// multiple association events


// GovHydro4 Events

data class CreateGovHydro4Event(
    @Id var govHydro4Id: UUID? = null,
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

data class UpdateGovHydro4Event(
    @Id var govHydro4Id: UUID? = null,
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

data class DeleteGovHydro4Event(@Id var govHydro4Id: UUID? = null)

// single association events

// multiple association events


// GovHydroDD Events

data class CreateGovHydroDDEvent(
    @Id var govHydroDDId: UUID? = null,
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

data class UpdateGovHydroDDEvent(
    @Id var govHydroDDId: UUID? = null,
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

data class DeleteGovHydroDDEvent(@Id var govHydroDDId: UUID? = null)

// single association events

// multiple association events


// GovHydroFrancis Events

data class CreateGovHydroFrancisEvent(
    @Id var govHydroFrancisId: UUID? = null,
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

data class UpdateGovHydroFrancisEvent(
    @Id var govHydroFrancisId: UUID? = null,
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

data class DeleteGovHydroFrancisEvent(@Id var govHydroFrancisId: UUID? = null)

// single association events

// multiple association events


// GovHydroIEEE0 Events

data class CreateGovHydroIEEE0Event(
    @Id var govHydroIEEE0Id: UUID? = null,
    var k: String,
    var mwbase: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String
)

data class UpdateGovHydroIEEE0Event(
    @Id var govHydroIEEE0Id: UUID? = null,
    var k: String,
    var mwbase: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var t4: String
)

data class DeleteGovHydroIEEE0Event(@Id var govHydroIEEE0Id: UUID? = null)

// single association events

// multiple association events


// GovHydroIEEE2 Events

data class CreateGovHydroIEEE2Event(
    @Id var govHydroIEEE2Id: UUID? = null,
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

data class UpdateGovHydroIEEE2Event(
    @Id var govHydroIEEE2Id: UUID? = null,
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

data class DeleteGovHydroIEEE2Event(@Id var govHydroIEEE2Id: UUID? = null)

// single association events

// multiple association events


// GovHydroPID Events

data class CreateGovHydroPIDEvent(
    @Id var govHydroPIDId: UUID? = null,
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

data class UpdateGovHydroPIDEvent(
    @Id var govHydroPIDId: UUID? = null,
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

data class DeleteGovHydroPIDEvent(@Id var govHydroPIDId: UUID? = null)

// single association events

// multiple association events


// GovHydroPID2 Events

data class CreateGovHydroPID2Event(
    @Id var govHydroPID2Id: UUID? = null,
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

data class UpdateGovHydroPID2Event(
    @Id var govHydroPID2Id: UUID? = null,
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

data class DeleteGovHydroPID2Event(@Id var govHydroPID2Id: UUID? = null)

// single association events

// multiple association events


// GovHydroPelton Events

data class CreateGovHydroPeltonEvent(
    @Id var govHydroPeltonId: UUID? = null,
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

data class UpdateGovHydroPeltonEvent(
    @Id var govHydroPeltonId: UUID? = null,
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

data class DeleteGovHydroPeltonEvent(@Id var govHydroPeltonId: UUID? = null)

// single association events

// multiple association events


// GovHydroR Events

data class CreateGovHydroREvent(
    @Id var govHydroRId: UUID? = null,
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

data class UpdateGovHydroREvent(
    @Id var govHydroRId: UUID? = null,
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

data class DeleteGovHydroREvent(@Id var govHydroRId: UUID? = null)

// single association events

// multiple association events


// GovHydroWEH Events

data class CreateGovHydroWEHEvent(
    @Id var govHydroWEHId: UUID? = null,
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

data class UpdateGovHydroWEHEvent(
    @Id var govHydroWEHId: UUID? = null,
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

data class DeleteGovHydroWEHEvent(@Id var govHydroWEHId: UUID? = null)

// single association events

// multiple association events


// GovHydroWPID Events

data class CreateGovHydroWPIDEvent(
    @Id var govHydroWPIDId: UUID? = null,
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

data class UpdateGovHydroWPIDEvent(
    @Id var govHydroWPIDId: UUID? = null,
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

data class DeleteGovHydroWPIDEvent(@Id var govHydroWPIDId: UUID? = null)

// single association events

// multiple association events


// GovSteam0 Events

data class CreateGovSteam0Event(
    @Id var govSteam0Id: UUID? = null,
    var dt: String,
    var mwbase: String,
    var r: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var vmax: String,
    var vmin: String
)

data class UpdateGovSteam0Event(
    @Id var govSteam0Id: UUID? = null,
    var dt: String,
    var mwbase: String,
    var r: String,
    var t1: String,
    var t2: String,
    var t3: String,
    var vmax: String,
    var vmin: String
)

data class DeleteGovSteam0Event(@Id var govSteam0Id: UUID? = null)

// single association events

// multiple association events


// GovSteam1 Events

data class CreateGovSteam1Event(
    @Id var govSteam1Id: UUID? = null,
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

data class UpdateGovSteam1Event(
    @Id var govSteam1Id: UUID? = null,
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

data class DeleteGovSteam1Event(@Id var govSteam1Id: UUID? = null)

// single association events

// multiple association events


// GovSteam2 Events

data class CreateGovSteam2Event(
    @Id var govSteam2Id: UUID? = null,
    var dbf: String,
    var k: String,
    var mnef: String,
    var mxef: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String
)

data class UpdateGovSteam2Event(
    @Id var govSteam2Id: UUID? = null,
    var dbf: String,
    var k: String,
    var mnef: String,
    var mxef: String,
    var pmax: String,
    var pmin: String,
    var t1: String,
    var t2: String
)

data class DeleteGovSteam2Event(@Id var govSteam2Id: UUID? = null)

// single association events

// multiple association events


// GovSteamCC Events

data class CreateGovSteamCCEvent(
    @Id var govSteamCCId: UUID? = null,
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

data class UpdateGovSteamCCEvent(
    @Id var govSteamCCId: UUID? = null,
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

data class DeleteGovSteamCCEvent(@Id var govSteamCCId: UUID? = null)

// single association events

// multiple association events


// GovSteamEU Events

data class CreateGovSteamEUEvent(
    @Id var govSteamEUId: UUID? = null,
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

data class UpdateGovSteamEUEvent(
    @Id var govSteamEUId: UUID? = null,
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

data class DeleteGovSteamEUEvent(@Id var govSteamEUId: UUID? = null)

// single association events

// multiple association events


// GovSteamFV2 Events

data class CreateGovSteamFV2Event(
    @Id var govSteamFV2Id: UUID? = null,
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

data class UpdateGovSteamFV2Event(
    @Id var govSteamFV2Id: UUID? = null,
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

data class DeleteGovSteamFV2Event(@Id var govSteamFV2Id: UUID? = null)

// single association events

// multiple association events


// GovSteamFV3 Events

data class CreateGovSteamFV3Event(
    @Id var govSteamFV3Id: UUID? = null,
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

data class UpdateGovSteamFV3Event(
    @Id var govSteamFV3Id: UUID? = null,
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

data class DeleteGovSteamFV3Event(@Id var govSteamFV3Id: UUID? = null)

// single association events

// multiple association events


// GovSteamFV4 Events

data class CreateGovSteamFV4Event(
    @Id var govSteamFV4Id: UUID? = null,
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

data class UpdateGovSteamFV4Event(
    @Id var govSteamFV4Id: UUID? = null,
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

data class DeleteGovSteamFV4Event(@Id var govSteamFV4Id: UUID? = null)

// single association events

// multiple association events


// GovSteamIEEE1 Events

data class CreateGovSteamIEEE1Event(
    @Id var govSteamIEEE1Id: UUID? = null,
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

data class UpdateGovSteamIEEE1Event(
    @Id var govSteamIEEE1Id: UUID? = null,
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

data class DeleteGovSteamIEEE1Event(@Id var govSteamIEEE1Id: UUID? = null)

// single association events

// multiple association events


// GovSteamSGO Events

data class CreateGovSteamSGOEvent(
    @Id var govSteamSGOId: UUID? = null,
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

data class UpdateGovSteamSGOEvent(
    @Id var govSteamSGOId: UUID? = null,
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

data class DeleteGovSteamSGOEvent(@Id var govSteamSGOId: UUID? = null)

// single association events

// multiple association events


// GrossToNetActivePowerCurve Events

data class CreateGrossToNetActivePowerCurveEvent(
     var grossToNetActivePowerCurveId: UUID? = null
)

data class UpdateGrossToNetActivePowerCurveEvent(
     var grossToNetActivePowerCurveId: UUID? = null
)

data class DeleteGrossToNetActivePowerCurveEvent(@Id var grossToNetActivePowerCurveId: UUID? = null)

// single association events

// multiple association events


// Ground Events

data class CreateGroundEvent(
     var groundId: UUID? = null
)

data class UpdateGroundEvent(
     var groundId: UUID? = null
)

data class DeleteGroundEvent(@Id var groundId: UUID? = null)

// single association events

// multiple association events


// GroundDisconnector Events

data class CreateGroundDisconnectorEvent(
     var groundDisconnectorId: UUID? = null
)

data class UpdateGroundDisconnectorEvent(
     var groundDisconnectorId: UUID? = null
)

data class DeleteGroundDisconnectorEvent(@Id var groundDisconnectorId: UUID? = null)

// single association events

// multiple association events


// GroundingImpedance Events

data class CreateGroundingImpedanceEvent(
    @Id var groundingImpedanceId: UUID? = null,
    var x: String
)

data class UpdateGroundingImpedanceEvent(
    @Id var groundingImpedanceId: UUID? = null,
    var x: String
)

data class DeleteGroundingImpedanceEvent(@Id var groundingImpedanceId: UUID? = null)

// single association events

// multiple association events


// HydroGeneratingUnit Events

data class CreateHydroGeneratingUnitEvent(
    @Id var hydroGeneratingUnitId: UUID? = null,
    var energyConversionCapability: String
)

data class UpdateHydroGeneratingUnitEvent(
    @Id var hydroGeneratingUnitId: UUID? = null,
    var energyConversionCapability: String
)

data class DeleteHydroGeneratingUnitEvent(@Id var hydroGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// HydroPowerPlant Events

data class CreateHydroPowerPlantEvent(
    @Id var hydroPowerPlantId: UUID? = null,
    var hydroPlantStorageType: String
)

data class UpdateHydroPowerPlantEvent(
    @Id var hydroPowerPlantId: UUID? = null,
    var hydroPlantStorageType: String
)

data class DeleteHydroPowerPlantEvent(@Id var hydroPowerPlantId: UUID? = null)

// single association events

// multiple association events


// HydroPump Events

data class CreateHydroPumpEvent(
     var hydroPumpId: UUID? = null
)

data class UpdateHydroPumpEvent(
     var hydroPumpId: UUID? = null
)

data class DeleteHydroPumpEvent(@Id var hydroPumpId: UUID? = null)

// single association events

// multiple association events


// IdentifiedObject Events

data class CreateIdentifiedObjectEvent(
    @Id var identifiedObjectId: UUID? = null,
    var description: String,
    var energyIdentCodeEic: String,
    var mRID: String,
    var name: String,
    var shortName: String
)

data class UpdateIdentifiedObjectEvent(
    @Id var identifiedObjectId: UUID? = null,
    var description: String,
    var energyIdentCodeEic: String,
    var mRID: String,
    var name: String,
    var shortName: String
)

data class DeleteIdentifiedObjectEvent(@Id var identifiedObjectId: UUID? = null)

// single association events

// multiple association events


// Inductance Events

data class CreateInductanceEvent(
    @Id var inductanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateInductanceEvent(
    @Id var inductanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteInductanceEvent(@Id var inductanceId: UUID? = null)

// single association events

// multiple association events


// InductancePerLength Events

data class CreateInductancePerLengthEvent(
    @Id var inductancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateInductancePerLengthEvent(
    @Id var inductancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteInductancePerLengthEvent(@Id var inductancePerLengthId: UUID? = null)

// single association events

// multiple association events


// IntegerProxy Events

data class CreateIntegerProxyEvent(
     var integerProxyId: UUID? = null
)

data class UpdateIntegerProxyEvent(
     var integerProxyId: UUID? = null
)

data class DeleteIntegerProxyEvent(@Id var integerProxyId: UUID? = null)

// single association events

// multiple association events


// Junction Events

data class CreateJunctionEvent(
     var junctionId: UUID? = null
)

data class UpdateJunctionEvent(
     var junctionId: UUID? = null
)

data class DeleteJunctionEvent(@Id var junctionId: UUID? = null)

// single association events

// multiple association events


// Length Events

data class CreateLengthEvent(
    @Id var lengthId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateLengthEvent(
    @Id var lengthId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteLengthEvent(@Id var lengthId: UUID? = null)

// single association events

// multiple association events


// Limit Events

data class CreateLimitEvent(
     var limitId: UUID? = null
)

data class UpdateLimitEvent(
     var limitId: UUID? = null
)

data class DeleteLimitEvent(@Id var limitId: UUID? = null)

// single association events

// multiple association events


// LimitSet Events

data class CreateLimitSetEvent(
    @Id var limitSetId: UUID? = null,
    var isPercentageLimits: String
)

data class UpdateLimitSetEvent(
    @Id var limitSetId: UUID? = null,
    var isPercentageLimits: String
)

data class DeleteLimitSetEvent(@Id var limitSetId: UUID? = null)

// single association events

// multiple association events


// Line Events

data class CreateLineEvent(
     var lineId: UUID? = null
)

data class UpdateLineEvent(
     var lineId: UUID? = null
)

data class DeleteLineEvent(@Id var lineId: UUID? = null)

// single association events

// multiple association events


// LinearShuntCompensator Events

data class CreateLinearShuntCompensatorEvent(
    @Id var linearShuntCompensatorId: UUID? = null,
    var b0PerSection: String,
    var bPerSection: String,
    var g0PerSection: String,
    var gPerSection: String
)

data class UpdateLinearShuntCompensatorEvent(
    @Id var linearShuntCompensatorId: UUID? = null,
    var b0PerSection: String,
    var bPerSection: String,
    var g0PerSection: String,
    var gPerSection: String
)

data class DeleteLinearShuntCompensatorEvent(@Id var linearShuntCompensatorId: UUID? = null)

// single association events

// multiple association events


// LoadAggregate Events

data class CreateLoadAggregateEvent(
     var loadAggregateId: UUID? = null
)

data class UpdateLoadAggregateEvent(
     var loadAggregateId: UUID? = null
)

data class DeleteLoadAggregateEvent(@Id var loadAggregateId: UUID? = null)

// single association events

// multiple association events


// LoadArea Events

data class CreateLoadAreaEvent(
     var loadAreaId: UUID? = null
)

data class UpdateLoadAreaEvent(
     var loadAreaId: UUID? = null
)

data class DeleteLoadAreaEvent(@Id var loadAreaId: UUID? = null)

// single association events

// multiple association events


// LoadBreakSwitch Events

data class CreateLoadBreakSwitchEvent(
     var loadBreakSwitchId: UUID? = null
)

data class UpdateLoadBreakSwitchEvent(
     var loadBreakSwitchId: UUID? = null
)

data class DeleteLoadBreakSwitchEvent(@Id var loadBreakSwitchId: UUID? = null)

// single association events

// multiple association events


// LoadComposite Events

data class CreateLoadCompositeEvent(
    @Id var loadCompositeId: UUID? = null,
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

data class UpdateLoadCompositeEvent(
    @Id var loadCompositeId: UUID? = null,
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

data class DeleteLoadCompositeEvent(@Id var loadCompositeId: UUID? = null)

// single association events

// multiple association events


// LoadDynamics Events

data class CreateLoadDynamicsEvent(
     var loadDynamicsId: UUID? = null
)

data class UpdateLoadDynamicsEvent(
     var loadDynamicsId: UUID? = null
)

data class DeleteLoadDynamicsEvent(@Id var loadDynamicsId: UUID? = null)

// single association events

// multiple association events


// LoadGenericNonLinear Events

data class CreateLoadGenericNonLinearEvent(
    @Id var loadGenericNonLinearId: UUID? = null,
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

data class UpdateLoadGenericNonLinearEvent(
    @Id var loadGenericNonLinearId: UUID? = null,
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

data class DeleteLoadGenericNonLinearEvent(@Id var loadGenericNonLinearId: UUID? = null)

// single association events

// multiple association events


// LoadGroup Events

data class CreateLoadGroupEvent(
     var loadGroupId: UUID? = null
)

data class UpdateLoadGroupEvent(
     var loadGroupId: UUID? = null
)

data class DeleteLoadGroupEvent(@Id var loadGroupId: UUID? = null)

// single association events

// multiple association events


// LoadMotor Events

data class CreateLoadMotorEvent(
    @Id var loadMotorId: UUID? = null,
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

data class UpdateLoadMotorEvent(
    @Id var loadMotorId: UUID? = null,
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

data class DeleteLoadMotorEvent(@Id var loadMotorId: UUID? = null)

// single association events

// multiple association events


// LoadResponseCharacteristic Events

data class CreateLoadResponseCharacteristicEvent(
    @Id var loadResponseCharacteristicId: UUID? = null,
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

data class UpdateLoadResponseCharacteristicEvent(
    @Id var loadResponseCharacteristicId: UUID? = null,
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

data class DeleteLoadResponseCharacteristicEvent(@Id var loadResponseCharacteristicId: UUID? = null)

// single association events

// multiple association events


// LoadStatic Events

data class CreateLoadStaticEvent(
    @Id var loadStaticId: UUID? = null,
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

data class UpdateLoadStaticEvent(
    @Id var loadStaticId: UUID? = null,
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

data class DeleteLoadStaticEvent(@Id var loadStaticId: UUID? = null)

// single association events

// multiple association events


// LoadUserDefined Events

data class CreateLoadUserDefinedEvent(
    @Id var loadUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateLoadUserDefinedEvent(
    @Id var loadUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteLoadUserDefinedEvent(@Id var loadUserDefinedId: UUID? = null)

// single association events

// multiple association events


// Location Events

data class CreateLocationEvent(
     var locationId: UUID? = null
)

data class UpdateLocationEvent(
     var locationId: UUID? = null
)

data class DeleteLocationEvent(@Id var locationId: UUID? = null)

// single association events

// multiple association events


// Measurement Events

data class CreateMeasurementEvent(
    @Id var measurementId: UUID? = null,
    var measurementType: String,
    var phases: String,
    var unitMultiplier: String,
    var unitSymbol: String
)

data class UpdateMeasurementEvent(
    @Id var measurementId: UUID? = null,
    var measurementType: String,
    var phases: String,
    var unitMultiplier: String,
    var unitSymbol: String
)

data class DeleteMeasurementEvent(@Id var measurementId: UUID? = null)

// single association events

// multiple association events


// MeasurementValue Events

data class CreateMeasurementValueEvent(
    @Id var measurementValueId: UUID? = null,
    var sensorAccuracy: String,
    var timeStamp: String
)

data class UpdateMeasurementValueEvent(
    @Id var measurementValueId: UUID? = null,
    var sensorAccuracy: String,
    var timeStamp: String
)

data class DeleteMeasurementValueEvent(@Id var measurementValueId: UUID? = null)

// single association events

// multiple association events


// MeasurementValueQuality Events

data class CreateMeasurementValueQualityEvent(
     var measurementValueQualityId: UUID? = null
)

data class UpdateMeasurementValueQualityEvent(
     var measurementValueQualityId: UUID? = null
)

data class DeleteMeasurementValueQualityEvent(@Id var measurementValueQualityId: UUID? = null)

// single association events

// multiple association events


// MeasurementValueSource Events

data class CreateMeasurementValueSourceEvent(
     var measurementValueSourceId: UUID? = null
)

data class UpdateMeasurementValueSourceEvent(
     var measurementValueSourceId: UUID? = null
)

data class DeleteMeasurementValueSourceEvent(@Id var measurementValueSourceId: UUID? = null)

// single association events

// multiple association events


// MechLoad1 Events

data class CreateMechLoad1Event(
    @Id var mechLoad1Id: UUID? = null,
    var a: String,
    var b: String,
    var d: String,
    var e: String
)

data class UpdateMechLoad1Event(
    @Id var mechLoad1Id: UUID? = null,
    var a: String,
    var b: String,
    var d: String,
    var e: String
)

data class DeleteMechLoad1Event(@Id var mechLoad1Id: UUID? = null)

// single association events

// multiple association events


// MechanicalLoadDynamics Events

data class CreateMechanicalLoadDynamicsEvent(
     var mechanicalLoadDynamicsId: UUID? = null
)

data class UpdateMechanicalLoadDynamicsEvent(
     var mechanicalLoadDynamicsId: UUID? = null
)

data class DeleteMechanicalLoadDynamicsEvent(@Id var mechanicalLoadDynamicsId: UUID? = null)

// single association events

// multiple association events


// MechanicalLoadUserDefined Events

data class CreateMechanicalLoadUserDefinedEvent(
    @Id var mechanicalLoadUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateMechanicalLoadUserDefinedEvent(
    @Id var mechanicalLoadUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteMechanicalLoadUserDefinedEvent(@Id var mechanicalLoadUserDefinedId: UUID? = null)

// single association events

// multiple association events


// Money Events

data class CreateMoneyEvent(
    @Id var moneyId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateMoneyEvent(
    @Id var moneyId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteMoneyEvent(@Id var moneyId: UUID? = null)

// single association events

// multiple association events


// MonthDay Events

data class CreateMonthDayEvent(
     var monthDayId: UUID? = null
)

data class UpdateMonthDayEvent(
     var monthDayId: UUID? = null
)

data class DeleteMonthDayEvent(@Id var monthDayId: UUID? = null)

// single association events

// multiple association events


// MonthDayIntervar Events

data class CreateMonthDayIntervalEvent(
    @Id var monthDayIntervalId: UUID? = null,
    var end: String,
    var start: String
)

data class UpdateMonthDayIntervalEvent(
    @Id var monthDayIntervalId: UUID? = null,
    var end: String,
    var start: String
)

data class DeleteMonthDayIntervalEvent(@Id var monthDayIntervalId: UUID? = null)

// single association events

// multiple association events


// MutualCoupling Events

data class CreateMutualCouplingEvent(
    @Id var mutualCouplingId: UUID? = null,
    var b0ch: String,
    var distance11: String,
    var distance12: String,
    var distance21: String,
    var distance22: String,
    var g0ch: String,
    var r0: String,
    var x0: String
)

data class UpdateMutualCouplingEvent(
    @Id var mutualCouplingId: UUID? = null,
    var b0ch: String,
    var distance11: String,
    var distance12: String,
    var distance21: String,
    var distance22: String,
    var g0ch: String,
    var r0: String,
    var x0: String
)

data class DeleteMutualCouplingEvent(@Id var mutualCouplingId: UUID? = null)

// single association events

// multiple association events


// NonConformLoad Events

data class CreateNonConformLoadEvent(
     var nonConformLoadId: UUID? = null
)

data class UpdateNonConformLoadEvent(
     var nonConformLoadId: UUID? = null
)

data class DeleteNonConformLoadEvent(@Id var nonConformLoadId: UUID? = null)

// single association events

// multiple association events


// NonConformLoadGroup Events

data class CreateNonConformLoadGroupEvent(
     var nonConformLoadGroupId: UUID? = null
)

data class UpdateNonConformLoadGroupEvent(
     var nonConformLoadGroupId: UUID? = null
)

data class DeleteNonConformLoadGroupEvent(@Id var nonConformLoadGroupId: UUID? = null)

// single association events

// multiple association events


// NonConformLoadSchedule Events

data class CreateNonConformLoadScheduleEvent(
     var nonConformLoadScheduleId: UUID? = null
)

data class UpdateNonConformLoadScheduleEvent(
     var nonConformLoadScheduleId: UUID? = null
)

data class DeleteNonConformLoadScheduleEvent(@Id var nonConformLoadScheduleId: UUID? = null)

// single association events

// multiple association events


// NonlinearShuntCompensator Events

data class CreateNonlinearShuntCompensatorEvent(
     var nonlinearShuntCompensatorId: UUID? = null
)

data class UpdateNonlinearShuntCompensatorEvent(
     var nonlinearShuntCompensatorId: UUID? = null
)

data class DeleteNonlinearShuntCompensatorEvent(@Id var nonlinearShuntCompensatorId: UUID? = null)

// single association events

// multiple association events


// NonlinearShuntCompensatorPoint Events

data class CreateNonlinearShuntCompensatorPointEvent(
    @Id var nonlinearShuntCompensatorPointId: UUID? = null,
    var b: String,
    var b0: String,
    var g: String,
    var g0: String,
    var sectionNumber: String
)

data class UpdateNonlinearShuntCompensatorPointEvent(
    @Id var nonlinearShuntCompensatorPointId: UUID? = null,
    var b: String,
    var b0: String,
    var g: String,
    var g0: String,
    var sectionNumber: String
)

data class DeleteNonlinearShuntCompensatorPointEvent(@Id var nonlinearShuntCompensatorPointId: UUID? = null)

// single association events

// multiple association events


// NuclearGeneratingUnit Events

data class CreateNuclearGeneratingUnitEvent(
     var nuclearGeneratingUnitId: UUID? = null
)

data class UpdateNuclearGeneratingUnitEvent(
     var nuclearGeneratingUnitId: UUID? = null
)

data class DeleteNuclearGeneratingUnitEvent(@Id var nuclearGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// OperationalLimit Events

data class CreateOperationalLimitEvent(
     var operationalLimitId: UUID? = null
)

data class UpdateOperationalLimitEvent(
     var operationalLimitId: UUID? = null
)

data class DeleteOperationalLimitEvent(@Id var operationalLimitId: UUID? = null)

// single association events

// multiple association events


// OperationalLimitSet Events

data class CreateOperationalLimitSetEvent(
     var operationalLimitSetId: UUID? = null
)

data class UpdateOperationalLimitSetEvent(
     var operationalLimitSetId: UUID? = null
)

data class DeleteOperationalLimitSetEvent(@Id var operationalLimitSetId: UUID? = null)

// single association events

// multiple association events


// OperationalLimitType Events

data class CreateOperationalLimitTypeEvent(
    @Id var operationalLimitTypeId: UUID? = null,
    var acceptableDuration: String,
    var direction: String,
    var limitType: String
)

data class UpdateOperationalLimitTypeEvent(
    @Id var operationalLimitTypeId: UUID? = null,
    var acceptableDuration: String,
    var direction: String,
    var limitType: String
)

data class DeleteOperationalLimitTypeEvent(@Id var operationalLimitTypeId: UUID? = null)

// single association events

// multiple association events


// OverexcLim2 Events

data class CreateOverexcLim2Event(
    @Id var overexcLim2Id: UUID? = null,
    var ifdlim: String,
    var koi: String,
    var voimax: String,
    var voimin: String
)

data class UpdateOverexcLim2Event(
    @Id var overexcLim2Id: UUID? = null,
    var ifdlim: String,
    var koi: String,
    var voimax: String,
    var voimin: String
)

data class DeleteOverexcLim2Event(@Id var overexcLim2Id: UUID? = null)

// single association events

// multiple association events


// OverexcLimIEEE Events

data class CreateOverexcLimIEEEEvent(
    @Id var overexcLimIEEEId: UUID? = null,
    var hyst: String,
    var ifdlim: String,
    var ifdmax: String,
    var itfpu: String,
    var kcd: String,
    var kramp: String
)

data class UpdateOverexcLimIEEEEvent(
    @Id var overexcLimIEEEId: UUID? = null,
    var hyst: String,
    var ifdlim: String,
    var ifdmax: String,
    var itfpu: String,
    var kcd: String,
    var kramp: String
)

data class DeleteOverexcLimIEEEEvent(@Id var overexcLimIEEEId: UUID? = null)

// single association events

// multiple association events


// OverexcLimX1 Events

data class CreateOverexcLimX1Event(
    @Id var overexcLimX1Id: UUID? = null,
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

data class UpdateOverexcLimX1Event(
    @Id var overexcLimX1Id: UUID? = null,
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

data class DeleteOverexcLimX1Event(@Id var overexcLimX1Id: UUID? = null)

// single association events

// multiple association events


// OverexcLimX2 Events

data class CreateOverexcLimX2Event(
    @Id var overexcLimX2Id: UUID? = null,
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

data class UpdateOverexcLimX2Event(
    @Id var overexcLimX2Id: UUID? = null,
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

data class DeleteOverexcLimX2Event(@Id var overexcLimX2Id: UUID? = null)

// single association events

// multiple association events


// OverexcitationLimiterDynamics Events

data class CreateOverexcitationLimiterDynamicsEvent(
     var overexcitationLimiterDynamicsId: UUID? = null
)

data class UpdateOverexcitationLimiterDynamicsEvent(
     var overexcitationLimiterDynamicsId: UUID? = null
)

data class DeleteOverexcitationLimiterDynamicsEvent(@Id var overexcitationLimiterDynamicsId: UUID? = null)

// single association events

// multiple association events


// OverexcitationLimiterUserDefined Events

data class CreateOverexcitationLimiterUserDefinedEvent(
    @Id var overexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateOverexcitationLimiterUserDefinedEvent(
    @Id var overexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteOverexcitationLimiterUserDefinedEvent(@Id var overexcitationLimiterUserDefinedId: UUID? = null)

// single association events

// multiple association events


// PFVArControllerType1Dynamics Events

data class CreatePFVArControllerType1DynamicsEvent(
     var pFVArControllerType1DynamicsId: UUID? = null
)

data class UpdatePFVArControllerType1DynamicsEvent(
     var pFVArControllerType1DynamicsId: UUID? = null
)

data class DeletePFVArControllerType1DynamicsEvent(@Id var pFVArControllerType1DynamicsId: UUID? = null)

// single association events

// multiple association events


// PFVArControllerType1UserDefined Events

data class CreatePFVArControllerType1UserDefinedEvent(
    @Id var pFVArControllerType1UserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdatePFVArControllerType1UserDefinedEvent(
    @Id var pFVArControllerType1UserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeletePFVArControllerType1UserDefinedEvent(@Id var pFVArControllerType1UserDefinedId: UUID? = null)

// single association events

// multiple association events


// PFVArControllerType2Dynamics Events

data class CreatePFVArControllerType2DynamicsEvent(
     var pFVArControllerType2DynamicsId: UUID? = null
)

data class UpdatePFVArControllerType2DynamicsEvent(
     var pFVArControllerType2DynamicsId: UUID? = null
)

data class DeletePFVArControllerType2DynamicsEvent(@Id var pFVArControllerType2DynamicsId: UUID? = null)

// single association events

// multiple association events


// PFVArControllerType2UserDefined Events

data class CreatePFVArControllerType2UserDefinedEvent(
    @Id var pFVArControllerType2UserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdatePFVArControllerType2UserDefinedEvent(
    @Id var pFVArControllerType2UserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeletePFVArControllerType2UserDefinedEvent(@Id var pFVArControllerType2UserDefinedId: UUID? = null)

// single association events

// multiple association events


// PFVArType1IEEEPFController Events

data class CreatePFVArType1IEEEPFControllerEvent(
    @Id var pFVArType1IEEEPFControllerId: UUID? = null,
    var ovex: String,
    var tpfc: String,
    var vitmin: String,
    var vpf: String,
    var vpfcbw: String,
    var vpfref: String,
    var vvtmax: String,
    var vvtmin: String
)

data class UpdatePFVArType1IEEEPFControllerEvent(
    @Id var pFVArType1IEEEPFControllerId: UUID? = null,
    var ovex: String,
    var tpfc: String,
    var vitmin: String,
    var vpf: String,
    var vpfcbw: String,
    var vpfref: String,
    var vvtmax: String,
    var vvtmin: String
)

data class DeletePFVArType1IEEEPFControllerEvent(@Id var pFVArType1IEEEPFControllerId: UUID? = null)

// single association events

// multiple association events


// PFVArType1IEEEVArController Events

data class CreatePFVArType1IEEEVArControllerEvent(
    @Id var pFVArType1IEEEVArControllerId: UUID? = null,
    var tvarc: String,
    var vvar: String,
    var vvarcbw: String,
    var vvarref: String,
    var vvtmax: String,
    var vvtmin: String
)

data class UpdatePFVArType1IEEEVArControllerEvent(
    @Id var pFVArType1IEEEVArControllerId: UUID? = null,
    var tvarc: String,
    var vvar: String,
    var vvarcbw: String,
    var vvarref: String,
    var vvtmax: String,
    var vvtmin: String
)

data class DeletePFVArType1IEEEVArControllerEvent(@Id var pFVArType1IEEEVArControllerId: UUID? = null)

// single association events

// multiple association events


// PFVArType2Common1 Events

data class CreatePFVArType2Common1Event(
    @Id var pFVArType2Common1Id: UUID? = null,
    var j: String,
    var ki: String,
    var kp: String,
    var max: String,
    var ref: String
)

data class UpdatePFVArType2Common1Event(
    @Id var pFVArType2Common1Id: UUID? = null,
    var j: String,
    var ki: String,
    var kp: String,
    var max: String,
    var ref: String
)

data class DeletePFVArType2Common1Event(@Id var pFVArType2Common1Id: UUID? = null)

// single association events

// multiple association events


// PFVArType2IEEEPFController Events

data class CreatePFVArType2IEEEPFControllerEvent(
    @Id var pFVArType2IEEEPFControllerId: UUID? = null,
    var exlon: String,
    var ki: String,
    var kp: String,
    var pfref: String,
    var vclmt: String,
    var vref: String,
    var vs: String
)

data class UpdatePFVArType2IEEEPFControllerEvent(
    @Id var pFVArType2IEEEPFControllerId: UUID? = null,
    var exlon: String,
    var ki: String,
    var kp: String,
    var pfref: String,
    var vclmt: String,
    var vref: String,
    var vs: String
)

data class DeletePFVArType2IEEEPFControllerEvent(@Id var pFVArType2IEEEPFControllerId: UUID? = null)

// single association events

// multiple association events


// PFVArType2IEEEVArController Events

data class CreatePFVArType2IEEEVArControllerEvent(
    @Id var pFVArType2IEEEVArControllerId: UUID? = null,
    var exlon: String,
    var ki: String,
    var kp: String,
    var qref: String,
    var vclmt: String,
    var vref: String,
    var vs: String
)

data class UpdatePFVArType2IEEEVArControllerEvent(
    @Id var pFVArType2IEEEVArControllerId: UUID? = null,
    var exlon: String,
    var ki: String,
    var kp: String,
    var qref: String,
    var vclmt: String,
    var vref: String,
    var vs: String
)

data class DeletePFVArType2IEEEVArControllerEvent(@Id var pFVArType2IEEEVArControllerId: UUID? = null)

// single association events

// multiple association events


// PU Events

data class CreatePUEvent(
    @Id var pUId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdatePUEvent(
    @Id var pUId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeletePUEvent(@Id var pUId: UUID? = null)

// single association events

// multiple association events


// PerCent Events

data class CreatePerCentEvent(
    @Id var perCentId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdatePerCentEvent(
    @Id var perCentId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeletePerCentEvent(@Id var perCentId: UUID? = null)

// single association events

// multiple association events


// PerLengthDCLineParameter Events

data class CreatePerLengthDCLineParameterEvent(
    @Id var perLengthDCLineParameterId: UUID? = null,
    var capacitance: String,
    var inductance: String,
    var resistance: String
)

data class UpdatePerLengthDCLineParameterEvent(
    @Id var perLengthDCLineParameterId: UUID? = null,
    var capacitance: String,
    var inductance: String,
    var resistance: String
)

data class DeletePerLengthDCLineParameterEvent(@Id var perLengthDCLineParameterId: UUID? = null)

// single association events

// multiple association events


// PetersenCoil Events

data class CreatePetersenCoilEvent(
    @Id var petersenCoilId: UUID? = null,
    var mode: String,
    var nominalU: String,
    var offsetCurrent: String,
    var positionCurrent: String,
    var xGroundMax: String,
    var xGroundMin: String,
    var xGroundNominal: String
)

data class UpdatePetersenCoilEvent(
    @Id var petersenCoilId: UUID? = null,
    var mode: String,
    var nominalU: String,
    var offsetCurrent: String,
    var positionCurrent: String,
    var xGroundMax: String,
    var xGroundMin: String,
    var xGroundNominal: String
)

data class DeletePetersenCoilEvent(@Id var petersenCoilId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChanger Events

data class CreatePhaseTapChangerEvent(
     var phaseTapChangerId: UUID? = null
)

data class UpdatePhaseTapChangerEvent(
     var phaseTapChangerId: UUID? = null
)

data class DeletePhaseTapChangerEvent(@Id var phaseTapChangerId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerAsymmetrical Events

data class CreatePhaseTapChangerAsymmetricalEvent(
    @Id var phaseTapChangerAsymmetricalId: UUID? = null,
    var windingConnectionAngle: String
)

data class UpdatePhaseTapChangerAsymmetricalEvent(
    @Id var phaseTapChangerAsymmetricalId: UUID? = null,
    var windingConnectionAngle: String
)

data class DeletePhaseTapChangerAsymmetricalEvent(@Id var phaseTapChangerAsymmetricalId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerLinear Events

data class CreatePhaseTapChangerLinearEvent(
    @Id var phaseTapChangerLinearId: UUID? = null,
    var stepPhaseShiftIncrement: String,
    var xMax: String,
    var xMin: String
)

data class UpdatePhaseTapChangerLinearEvent(
    @Id var phaseTapChangerLinearId: UUID? = null,
    var stepPhaseShiftIncrement: String,
    var xMax: String,
    var xMin: String
)

data class DeletePhaseTapChangerLinearEvent(@Id var phaseTapChangerLinearId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerNonLinear Events

data class CreatePhaseTapChangerNonLinearEvent(
    @Id var phaseTapChangerNonLinearId: UUID? = null,
    var voltageStepIncrement: String,
    var xMax: String,
    var xMin: String
)

data class UpdatePhaseTapChangerNonLinearEvent(
    @Id var phaseTapChangerNonLinearId: UUID? = null,
    var voltageStepIncrement: String,
    var xMax: String,
    var xMin: String
)

data class DeletePhaseTapChangerNonLinearEvent(@Id var phaseTapChangerNonLinearId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerSymmetrical Events

data class CreatePhaseTapChangerSymmetricalEvent(
     var phaseTapChangerSymmetricalId: UUID? = null
)

data class UpdatePhaseTapChangerSymmetricalEvent(
     var phaseTapChangerSymmetricalId: UUID? = null
)

data class DeletePhaseTapChangerSymmetricalEvent(@Id var phaseTapChangerSymmetricalId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerTable Events

data class CreatePhaseTapChangerTableEvent(
     var phaseTapChangerTableId: UUID? = null
)

data class UpdatePhaseTapChangerTableEvent(
     var phaseTapChangerTableId: UUID? = null
)

data class DeletePhaseTapChangerTableEvent(@Id var phaseTapChangerTableId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerTablePoint Events

data class CreatePhaseTapChangerTablePointEvent(
    @Id var phaseTapChangerTablePointId: UUID? = null,
    var angle: String
)

data class UpdatePhaseTapChangerTablePointEvent(
    @Id var phaseTapChangerTablePointId: UUID? = null,
    var angle: String
)

data class DeletePhaseTapChangerTablePointEvent(@Id var phaseTapChangerTablePointId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerTabular Events

data class CreatePhaseTapChangerTabularEvent(
     var phaseTapChangerTabularId: UUID? = null
)

data class UpdatePhaseTapChangerTabularEvent(
     var phaseTapChangerTabularId: UUID? = null
)

data class DeletePhaseTapChangerTabularEvent(@Id var phaseTapChangerTabularId: UUID? = null)

// single association events

// multiple association events


// PositionPoint Events

data class CreatePositionPointEvent(
    @Id var positionPointId: UUID? = null,
    var sequenceNumber: String,
    var xPosition: String,
    var yPosition: String,
    var zPosition: String
)

data class UpdatePositionPointEvent(
    @Id var positionPointId: UUID? = null,
    var sequenceNumber: String,
    var xPosition: String,
    var yPosition: String,
    var zPosition: String
)

data class DeletePositionPointEvent(@Id var positionPointId: UUID? = null)

// single association events

// multiple association events


// PowerSystemResource Events

data class CreatePowerSystemResourceEvent(
     var powerSystemResourceId: UUID? = null
)

data class UpdatePowerSystemResourceEvent(
     var powerSystemResourceId: UUID? = null
)

data class DeletePowerSystemResourceEvent(@Id var powerSystemResourceId: UUID? = null)

// single association events

// multiple association events


// PowerSystemStabilizerDynamics Events

data class CreatePowerSystemStabilizerDynamicsEvent(
     var powerSystemStabilizerDynamicsId: UUID? = null
)

data class UpdatePowerSystemStabilizerDynamicsEvent(
     var powerSystemStabilizerDynamicsId: UUID? = null
)

data class DeletePowerSystemStabilizerDynamicsEvent(@Id var powerSystemStabilizerDynamicsId: UUID? = null)

// single association events

// multiple association events


// PowerSystemStabilizerUserDefined Events

data class CreatePowerSystemStabilizerUserDefinedEvent(
    @Id var powerSystemStabilizerUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdatePowerSystemStabilizerUserDefinedEvent(
    @Id var powerSystemStabilizerUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeletePowerSystemStabilizerUserDefinedEvent(@Id var powerSystemStabilizerUserDefinedId: UUID? = null)

// single association events

// multiple association events


// PowerTransformer Events

data class CreatePowerTransformerEvent(
    @Id var powerTransformerId: UUID? = null,
    var beforeShCircuitHighestOperatingCurrent: String,
    var beforeShCircuitHighestOperatingVoltage: String,
    var beforeShortCircuitAnglePf: String,
    var highSideMinOperatingU: String,
    var isPartOfGeneratorUnit: String,
    var operationalValuesConsidered: String
)

data class UpdatePowerTransformerEvent(
    @Id var powerTransformerId: UUID? = null,
    var beforeShCircuitHighestOperatingCurrent: String,
    var beforeShCircuitHighestOperatingVoltage: String,
    var beforeShortCircuitAnglePf: String,
    var highSideMinOperatingU: String,
    var isPartOfGeneratorUnit: String,
    var operationalValuesConsidered: String
)

data class DeletePowerTransformerEvent(@Id var powerTransformerId: UUID? = null)

// single association events

// multiple association events


// PowerTransformerEnd Events

data class CreatePowerTransformerEndEvent(
    @Id var powerTransformerEndId: UUID? = null,
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

data class UpdatePowerTransformerEndEvent(
    @Id var powerTransformerEndId: UUID? = null,
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

data class DeletePowerTransformerEndEvent(@Id var powerTransformerEndId: UUID? = null)

// single association events

// multiple association events


// ProprietaryParameterDynamics Events

data class CreateProprietaryParameterDynamicsEvent(
    @Id var proprietaryParameterDynamicsId: UUID? = null,
    var booleanParameterValue: String,
    var floatParameterValue: String,
    var integerParameterValue: String,
    var parameterNumber: String
)

data class UpdateProprietaryParameterDynamicsEvent(
    @Id var proprietaryParameterDynamicsId: UUID? = null,
    var booleanParameterValue: String,
    var floatParameterValue: String,
    var integerParameterValue: String,
    var parameterNumber: String
)

data class DeleteProprietaryParameterDynamicsEvent(@Id var proprietaryParameterDynamicsId: UUID? = null)

// single association events

// multiple association events


// ProtectedSwitch Events

data class CreateProtectedSwitchEvent(
     var protectedSwitchId: UUID? = null
)

data class UpdateProtectedSwitchEvent(
     var protectedSwitchId: UUID? = null
)

data class DeleteProtectedSwitchEvent(@Id var protectedSwitchId: UUID? = null)

// single association events

// multiple association events


// Pss1 Events

data class CreatePss1Event(
    @Id var pss1Id: UUID? = null,
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

data class UpdatePss1Event(
    @Id var pss1Id: UUID? = null,
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

data class DeletePss1Event(@Id var pss1Id: UUID? = null)

// single association events

// multiple association events


// Pss1A Events

data class CreatePss1AEvent(
    @Id var pss1AId: UUID? = null,
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

data class UpdatePss1AEvent(
    @Id var pss1AId: UUID? = null,
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

data class DeletePss1AEvent(@Id var pss1AId: UUID? = null)

// single association events

// multiple association events


// Pss2B Events

data class CreatePss2BEvent(
    @Id var pss2BId: UUID? = null,
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

data class UpdatePss2BEvent(
    @Id var pss2BId: UUID? = null,
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

data class DeletePss2BEvent(@Id var pss2BId: UUID? = null)

// single association events

// multiple association events


// Pss2ST Events

data class CreatePss2STEvent(
    @Id var pss2STId: UUID? = null,
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

data class UpdatePss2STEvent(
    @Id var pss2STId: UUID? = null,
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

data class DeletePss2STEvent(@Id var pss2STId: UUID? = null)

// single association events

// multiple association events


// Pss5 Events

data class CreatePss5Event(
    @Id var pss5Id: UUID? = null,
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

data class UpdatePss5Event(
    @Id var pss5Id: UUID? = null,
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

data class DeletePss5Event(@Id var pss5Id: UUID? = null)

// single association events

// multiple association events


// PssELIN2 Events

data class CreatePssELIN2Event(
    @Id var pssELIN2Id: UUID? = null,
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

data class UpdatePssELIN2Event(
    @Id var pssELIN2Id: UUID? = null,
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

data class DeletePssELIN2Event(@Id var pssELIN2Id: UUID? = null)

// single association events

// multiple association events


// PssIEEE1A Events

data class CreatePssIEEE1AEvent(
    @Id var pssIEEE1AId: UUID? = null,
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

data class UpdatePssIEEE1AEvent(
    @Id var pssIEEE1AId: UUID? = null,
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

data class DeletePssIEEE1AEvent(@Id var pssIEEE1AId: UUID? = null)

// single association events

// multiple association events


// PssIEEE2B Events

data class CreatePssIEEE2BEvent(
    @Id var pssIEEE2BId: UUID? = null,
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

data class UpdatePssIEEE2BEvent(
    @Id var pssIEEE2BId: UUID? = null,
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

data class DeletePssIEEE2BEvent(@Id var pssIEEE2BId: UUID? = null)

// single association events

// multiple association events


// PssIEEE3B Events

data class CreatePssIEEE3BEvent(
    @Id var pssIEEE3BId: UUID? = null,
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

data class UpdatePssIEEE3BEvent(
    @Id var pssIEEE3BId: UUID? = null,
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

data class DeletePssIEEE3BEvent(@Id var pssIEEE3BId: UUID? = null)

// single association events

// multiple association events


// PssIEEE4B Events

data class CreatePssIEEE4BEvent(
    @Id var pssIEEE4BId: UUID? = null,
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

data class UpdatePssIEEE4BEvent(
    @Id var pssIEEE4BId: UUID? = null,
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

data class DeletePssIEEE4BEvent(@Id var pssIEEE4BId: UUID? = null)

// single association events

// multiple association events


// PssPTIST1 Events

data class CreatePssPTIST1Event(
    @Id var pssPTIST1Id: UUID? = null,
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

data class UpdatePssPTIST1Event(
    @Id var pssPTIST1Id: UUID? = null,
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

data class DeletePssPTIST1Event(@Id var pssPTIST1Id: UUID? = null)

// single association events

// multiple association events


// PssPTIST3 Events

data class CreatePssPTIST3Event(
    @Id var pssPTIST3Id: UUID? = null,
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

data class UpdatePssPTIST3Event(
    @Id var pssPTIST3Id: UUID? = null,
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

data class DeletePssPTIST3Event(@Id var pssPTIST3Id: UUID? = null)

// single association events

// multiple association events


// PssSB4 Events

data class CreatePssSB4Event(
    @Id var pssSB4Id: UUID? = null,
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

data class UpdatePssSB4Event(
    @Id var pssSB4Id: UUID? = null,
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

data class DeletePssSB4Event(@Id var pssSB4Id: UUID? = null)

// single association events

// multiple association events


// PssSH Events

data class CreatePssSHEvent(
    @Id var pssSHId: UUID? = null,
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

data class UpdatePssSHEvent(
    @Id var pssSHId: UUID? = null,
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

data class DeletePssSHEvent(@Id var pssSHId: UUID? = null)

// single association events

// multiple association events


// PssSK Events

data class CreatePssSKEvent(
    @Id var pssSKId: UUID? = null,
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

data class UpdatePssSKEvent(
    @Id var pssSKId: UUID? = null,
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

data class DeletePssSKEvent(@Id var pssSKId: UUID? = null)

// single association events

// multiple association events


// PssWECC Events

data class CreatePssWECCEvent(
    @Id var pssWECCId: UUID? = null,
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

data class UpdatePssWECCEvent(
    @Id var pssWECCId: UUID? = null,
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

data class DeletePssWECCEvent(@Id var pssWECCId: UUID? = null)

// single association events

// multiple association events


// Quality61850 Events

data class CreateQuality61850Event(
    @Id var quality61850Id: UUID? = null,
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

data class UpdateQuality61850Event(
    @Id var quality61850Id: UUID? = null,
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

data class DeleteQuality61850Event(@Id var quality61850Id: UUID? = null)

// single association events

// multiple association events


// RaiseLowerCommand Events

data class CreateRaiseLowerCommandEvent(
     var raiseLowerCommandId: UUID? = null
)

data class UpdateRaiseLowerCommandEvent(
     var raiseLowerCommandId: UUID? = null
)

data class DeleteRaiseLowerCommandEvent(@Id var raiseLowerCommandId: UUID? = null)

// single association events

// multiple association events


// RatioTapChanger Events

data class CreateRatioTapChangerEvent(
    @Id var ratioTapChangerId: UUID? = null,
    var stepVoltageIncrement: String,
    var tculControlMode: String
)

data class UpdateRatioTapChangerEvent(
    @Id var ratioTapChangerId: UUID? = null,
    var stepVoltageIncrement: String,
    var tculControlMode: String
)

data class DeleteRatioTapChangerEvent(@Id var ratioTapChangerId: UUID? = null)

// single association events

// multiple association events


// RatioTapChangerTable Events

data class CreateRatioTapChangerTableEvent(
     var ratioTapChangerTableId: UUID? = null
)

data class UpdateRatioTapChangerTableEvent(
     var ratioTapChangerTableId: UUID? = null
)

data class DeleteRatioTapChangerTableEvent(@Id var ratioTapChangerTableId: UUID? = null)

// single association events

// multiple association events


// RatioTapChangerTablePoint Events

data class CreateRatioTapChangerTablePointEvent(
     var ratioTapChangerTablePointId: UUID? = null
)

data class UpdateRatioTapChangerTablePointEvent(
     var ratioTapChangerTablePointId: UUID? = null
)

data class DeleteRatioTapChangerTablePointEvent(@Id var ratioTapChangerTablePointId: UUID? = null)

// single association events

// multiple association events


// Reactance Events

data class CreateReactanceEvent(
    @Id var reactanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateReactanceEvent(
    @Id var reactanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteReactanceEvent(@Id var reactanceId: UUID? = null)

// single association events

// multiple association events


// ReactiveCapabilityCurve Events

data class CreateReactiveCapabilityCurveEvent(
     var reactiveCapabilityCurveId: UUID? = null
)

data class UpdateReactiveCapabilityCurveEvent(
     var reactiveCapabilityCurveId: UUID? = null
)

data class DeleteReactiveCapabilityCurveEvent(@Id var reactiveCapabilityCurveId: UUID? = null)

// single association events

// multiple association events


// ReactivePower Events

data class CreateReactivePowerEvent(
    @Id var reactivePowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateReactivePowerEvent(
    @Id var reactivePowerId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteReactivePowerEvent(@Id var reactivePowerId: UUID? = null)

// single association events

// multiple association events


// RegularIntervalSchedule Events

data class CreateRegularIntervalScheduleEvent(
    @Id var regularIntervalScheduleId: UUID? = null,
    var endTime: String,
    var timeStep: String
)

data class UpdateRegularIntervalScheduleEvent(
    @Id var regularIntervalScheduleId: UUID? = null,
    var endTime: String,
    var timeStep: String
)

data class DeleteRegularIntervalScheduleEvent(@Id var regularIntervalScheduleId: UUID? = null)

// single association events

// multiple association events


// RegularTimePoint Events

data class CreateRegularTimePointEvent(
    @Id var regularTimePointId: UUID? = null,
    var sequenceNumber: String,
    var value1: String,
    var value2: String
)

data class UpdateRegularTimePointEvent(
    @Id var regularTimePointId: UUID? = null,
    var sequenceNumber: String,
    var value1: String,
    var value2: String
)

data class DeleteRegularTimePointEvent(@Id var regularTimePointId: UUID? = null)

// single association events

// multiple association events


// RegulatingCondEq Events

data class CreateRegulatingCondEqEvent(
     var regulatingCondEqId: UUID? = null
)

data class UpdateRegulatingCondEqEvent(
     var regulatingCondEqId: UUID? = null
)

data class DeleteRegulatingCondEqEvent(@Id var regulatingCondEqId: UUID? = null)

// single association events

// multiple association events


// RegulatingControl Events

data class CreateRegulatingControlEvent(
    @Id var regulatingControlId: UUID? = null,
    var mode: String
)

data class UpdateRegulatingControlEvent(
    @Id var regulatingControlId: UUID? = null,
    var mode: String
)

data class DeleteRegulatingControlEvent(@Id var regulatingControlId: UUID? = null)

// single association events

// multiple association events


// RegulationSchedule Events

data class CreateRegulationScheduleEvent(
     var regulationScheduleId: UUID? = null
)

data class UpdateRegulationScheduleEvent(
     var regulationScheduleId: UUID? = null
)

data class DeleteRegulationScheduleEvent(@Id var regulationScheduleId: UUID? = null)

// single association events

// multiple association events


// RemoteInputSignal Events

data class CreateRemoteInputSignalEvent(
    @Id var remoteInputSignalId: UUID? = null,
    var remoteSignalType: String
)

data class UpdateRemoteInputSignalEvent(
    @Id var remoteInputSignalId: UUID? = null,
    var remoteSignalType: String
)

data class DeleteRemoteInputSignalEvent(@Id var remoteInputSignalId: UUID? = null)

// single association events

// multiple association events


// ReportingGroup Events

data class CreateReportingGroupEvent(
     var reportingGroupId: UUID? = null
)

data class UpdateReportingGroupEvent(
     var reportingGroupId: UUID? = null
)

data class DeleteReportingGroupEvent(@Id var reportingGroupId: UUID? = null)

// single association events

// multiple association events


// Resistance Events

data class CreateResistanceEvent(
    @Id var resistanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateResistanceEvent(
    @Id var resistanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteResistanceEvent(@Id var resistanceId: UUID? = null)

// single association events

// multiple association events


// ResistancePerLength Events

data class CreateResistancePerLengthEvent(
    @Id var resistancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateResistancePerLengthEvent(
    @Id var resistancePerLengthId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteResistancePerLengthEvent(@Id var resistancePerLengthId: UUID? = null)

// single association events

// multiple association events


// RotatingMachine Events

data class CreateRotatingMachineEvent(
    @Id var rotatingMachineId: UUID? = null,
    var ratedPowerFactor: String,
    var ratedS: String,
    var ratedU: String
)

data class UpdateRotatingMachineEvent(
    @Id var rotatingMachineId: UUID? = null,
    var ratedPowerFactor: String,
    var ratedS: String,
    var ratedU: String
)

data class DeleteRotatingMachineEvent(@Id var rotatingMachineId: UUID? = null)

// single association events

// multiple association events


// RotatingMachineDynamics Events

data class CreateRotatingMachineDynamicsEvent(
    @Id var rotatingMachineDynamicsId: UUID? = null,
    var damping: String,
    var inertia: String,
    var saturationFactor: String,
    var saturationFactor120: String,
    var statorLeakageReactance: String,
    var statorResistance: String
)

data class UpdateRotatingMachineDynamicsEvent(
    @Id var rotatingMachineDynamicsId: UUID? = null,
    var damping: String,
    var inertia: String,
    var saturationFactor: String,
    var saturationFactor120: String,
    var statorLeakageReactance: String,
    var statorResistance: String
)

data class DeleteRotatingMachineDynamicsEvent(@Id var rotatingMachineDynamicsId: UUID? = null)

// single association events

// multiple association events


// RotationSpeed Events

data class CreateRotationSpeedEvent(
    @Id var rotationSpeedId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateRotationSpeedEvent(
    @Id var rotationSpeedId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteRotationSpeedEvent(@Id var rotationSpeedId: UUID? = null)

// single association events

// multiple association events


// Season Events

data class CreateSeasonEvent(
    @Id var seasonId: UUID? = null,
    var endDate: String,
    var startDate: String
)

data class UpdateSeasonEvent(
    @Id var seasonId: UUID? = null,
    var endDate: String,
    var startDate: String
)

data class DeleteSeasonEvent(@Id var seasonId: UUID? = null)

// single association events

// multiple association events


// SeasonDayTypeSchedule Events

data class CreateSeasonDayTypeScheduleEvent(
     var seasonDayTypeScheduleId: UUID? = null
)

data class UpdateSeasonDayTypeScheduleEvent(
     var seasonDayTypeScheduleId: UUID? = null
)

data class DeleteSeasonDayTypeScheduleEvent(@Id var seasonDayTypeScheduleId: UUID? = null)

// single association events

// multiple association events


// Seconds Events

data class CreateSecondsEvent(
    @Id var secondsId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateSecondsEvent(
    @Id var secondsId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteSecondsEvent(@Id var secondsId: UUID? = null)

// single association events

// multiple association events


// SeriesCompensator Events

data class CreateSeriesCompensatorEvent(
    @Id var seriesCompensatorId: UUID? = null,
    var r: String,
    var r0: String,
    var varistorPresent: String,
    var varistorRatedCurrent: String,
    var varistorVoltageThreshold: String,
    var x: String,
    var x0: String
)

data class UpdateSeriesCompensatorEvent(
    @Id var seriesCompensatorId: UUID? = null,
    var r: String,
    var r0: String,
    var varistorPresent: String,
    var varistorRatedCurrent: String,
    var varistorVoltageThreshold: String,
    var x: String,
    var x0: String
)

data class DeleteSeriesCompensatorEvent(@Id var seriesCompensatorId: UUID? = null)

// single association events

// multiple association events


// SetPoint Events

data class CreateSetPointEvent(
    @Id var setPointId: UUID? = null,
    var normalValue: String,
    var value: String
)

data class UpdateSetPointEvent(
    @Id var setPointId: UUID? = null,
    var normalValue: String,
    var value: String
)

data class DeleteSetPointEvent(@Id var setPointId: UUID? = null)

// single association events

// multiple association events


// ShuntCompensator Events

data class CreateShuntCompensatorEvent(
    @Id var shuntCompensatorId: UUID? = null,
    var aVRDelay: String,
    var grounded: String,
    var maximumSections: String,
    var nomU: String,
    var normalSections: String,
    var switchOnCount: String,
    var switchOnDate: String,
    var voltageSensitivity: String
)

data class UpdateShuntCompensatorEvent(
    @Id var shuntCompensatorId: UUID? = null,
    var aVRDelay: String,
    var grounded: String,
    var maximumSections: String,
    var nomU: String,
    var normalSections: String,
    var switchOnCount: String,
    var switchOnDate: String,
    var voltageSensitivity: String
)

data class DeleteShuntCompensatorEvent(@Id var shuntCompensatorId: UUID? = null)

// single association events

// multiple association events


// Simple_Float Events

data class CreateSimple_FloatEvent(
    @Id var simple_FloatId: UUID? = null,
    var value: String
)

data class UpdateSimple_FloatEvent(
    @Id var simple_FloatId: UUID? = null,
    var value: String
)

data class DeleteSimple_FloatEvent(@Id var simple_FloatId: UUID? = null)

// single association events

// multiple association events


// SolarGeneratingUnit Events

data class CreateSolarGeneratingUnitEvent(
     var solarGeneratingUnitId: UUID? = null
)

data class UpdateSolarGeneratingUnitEvent(
     var solarGeneratingUnitId: UUID? = null
)

data class DeleteSolarGeneratingUnitEvent(@Id var solarGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// StateVariablesVersion Events

data class CreateStateVariablesVersionEvent(
    @Id var stateVariablesVersionId: UUID? = null,
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

data class UpdateStateVariablesVersionEvent(
    @Id var stateVariablesVersionId: UUID? = null,
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

data class DeleteStateVariablesVersionEvent(@Id var stateVariablesVersionId: UUID? = null)

// single association events

// multiple association events


// StaticVarCompensator Events

data class CreateStaticVarCompensatorEvent(
    @Id var staticVarCompensatorId: UUID? = null,
    var capacitiveRating: String,
    var inductiveRating: String,
    var slope: String,
    var sVCControlMode: String,
    var voltageSetPoint: String
)

data class UpdateStaticVarCompensatorEvent(
    @Id var staticVarCompensatorId: UUID? = null,
    var capacitiveRating: String,
    var inductiveRating: String,
    var slope: String,
    var sVCControlMode: String,
    var voltageSetPoint: String
)

data class DeleteStaticVarCompensatorEvent(@Id var staticVarCompensatorId: UUID? = null)

// single association events

// multiple association events


// Staticpowersystemmodel Events

data class CreateStaticpowersystemmodelEvent(
     var staticpowersystemmodelId: UUID? = null
)

data class UpdateStaticpowersystemmodelEvent(
     var staticpowersystemmodelId: UUID? = null
)

data class DeleteStaticpowersystemmodelEvent(@Id var staticpowersystemmodelId: UUID? = null)

// single association events

// multiple association events


// StationSupply Events

data class CreateStationSupplyEvent(
     var stationSupplyId: UUID? = null
)

data class UpdateStationSupplyEvent(
     var stationSupplyId: UUID? = null
)

data class DeleteStationSupplyEvent(@Id var stationSupplyId: UUID? = null)

// single association events

// multiple association events


// SteadyStateHypothesisVersion Events

data class CreateSteadyStateHypothesisVersionEvent(
    @Id var steadyStateHypothesisVersionId: UUID? = null,
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

data class UpdateSteadyStateHypothesisVersionEvent(
    @Id var steadyStateHypothesisVersionId: UUID? = null,
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

data class DeleteSteadyStateHypothesisVersionEvent(@Id var steadyStateHypothesisVersionId: UUID? = null)

// single association events

// multiple association events


// StringMeasurement Events

data class CreateStringMeasurementEvent(
     var stringMeasurementId: UUID? = null
)

data class UpdateStringMeasurementEvent(
     var stringMeasurementId: UUID? = null
)

data class DeleteStringMeasurementEvent(@Id var stringMeasurementId: UUID? = null)

// single association events

// multiple association events


// StringMeasurementValue Events

data class CreateStringMeasurementValueEvent(
    @Id var stringMeasurementValueId: UUID? = null,
    var value: String
)

data class UpdateStringMeasurementValueEvent(
    @Id var stringMeasurementValueId: UUID? = null,
    var value: String
)

data class DeleteStringMeasurementValueEvent(@Id var stringMeasurementValueId: UUID? = null)

// single association events

// multiple association events


// StringProxy Events

data class CreateStringProxyEvent(
     var stringProxyId: UUID? = null
)

data class UpdateStringProxyEvent(
     var stringProxyId: UUID? = null
)

data class DeleteStringProxyEvent(@Id var stringProxyId: UUID? = null)

// single association events

// multiple association events


// SubGeographicalRegion Events

data class CreateSubGeographicalRegionEvent(
     var subGeographicalRegionId: UUID? = null
)

data class UpdateSubGeographicalRegionEvent(
     var subGeographicalRegionId: UUID? = null
)

data class DeleteSubGeographicalRegionEvent(@Id var subGeographicalRegionId: UUID? = null)

// single association events

// multiple association events


// SubLoadArea Events

data class CreateSubLoadAreaEvent(
     var subLoadAreaId: UUID? = null
)

data class UpdateSubLoadAreaEvent(
     var subLoadAreaId: UUID? = null
)

data class DeleteSubLoadAreaEvent(@Id var subLoadAreaId: UUID? = null)

// single association events

// multiple association events


// Substation Events

data class CreateSubstationEvent(
     var substationId: UUID? = null
)

data class UpdateSubstationEvent(
     var substationId: UUID? = null
)

data class DeleteSubstationEvent(@Id var substationId: UUID? = null)

// single association events

// multiple association events


// Susceptance Events

data class CreateSusceptanceEvent(
    @Id var susceptanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateSusceptanceEvent(
    @Id var susceptanceId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteSusceptanceEvent(@Id var susceptanceId: UUID? = null)

// single association events

// multiple association events


// SvInjection Events

data class CreateSvInjectionEvent(
    @Id var svInjectionId: UUID? = null,
    var pInjection: String,
    var qInjection: String
)

data class UpdateSvInjectionEvent(
    @Id var svInjectionId: UUID? = null,
    var pInjection: String,
    var qInjection: String
)

data class DeleteSvInjectionEvent(@Id var svInjectionId: UUID? = null)

// single association events

// multiple association events


// SvPowerFlow Events

data class CreateSvPowerFlowEvent(
    @Id var svPowerFlowId: UUID? = null,
    var p: String,
    var q: String
)

data class UpdateSvPowerFlowEvent(
    @Id var svPowerFlowId: UUID? = null,
    var p: String,
    var q: String
)

data class DeleteSvPowerFlowEvent(@Id var svPowerFlowId: UUID? = null)

// single association events

// multiple association events


// SvShuntCompensatorSections Events

data class CreateSvShuntCompensatorSectionsEvent(
    @Id var svShuntCompensatorSectionsId: UUID? = null,
    var sections: String
)

data class UpdateSvShuntCompensatorSectionsEvent(
    @Id var svShuntCompensatorSectionsId: UUID? = null,
    var sections: String
)

data class DeleteSvShuntCompensatorSectionsEvent(@Id var svShuntCompensatorSectionsId: UUID? = null)

// single association events

// multiple association events


// SvStatus Events

data class CreateSvStatusEvent(
    @Id var svStatusId: UUID? = null,
    var inService: String
)

data class UpdateSvStatusEvent(
    @Id var svStatusId: UUID? = null,
    var inService: String
)

data class DeleteSvStatusEvent(@Id var svStatusId: UUID? = null)

// single association events

// multiple association events


// SvTapStep Events

data class CreateSvTapStepEvent(
    @Id var svTapStepId: UUID? = null,
    var position: String
)

data class UpdateSvTapStepEvent(
    @Id var svTapStepId: UUID? = null,
    var position: String
)

data class DeleteSvTapStepEvent(@Id var svTapStepId: UUID? = null)

// single association events

// multiple association events


// SvVoltage Events

data class CreateSvVoltageEvent(
    @Id var svVoltageId: UUID? = null,
    var angle: String,
    var v: String
)

data class UpdateSvVoltageEvent(
    @Id var svVoltageId: UUID? = null,
    var angle: String,
    var v: String
)

data class DeleteSvVoltageEvent(@Id var svVoltageId: UUID? = null)

// single association events

// multiple association events


// SwitchIt Events

data class CreateSwitchItEvent(
    @Id var switchItId: UUID? = null,
    var open: String
)

data class UpdateSwitchItEvent(
    @Id var switchItId: UUID? = null,
    var open: String
)

data class DeleteSwitchItEvent(@Id var switchItId: UUID? = null)

// single association events

// multiple association events


// SwitchProxy Events

data class CreateSwitchProxyEvent(
    @Id var switchProxyId: UUID? = null,
    var normalOpen: String,
    var ratedCurrent: String,
    var retained: String
)

data class UpdateSwitchProxyEvent(
    @Id var switchProxyId: UUID? = null,
    var normalOpen: String,
    var ratedCurrent: String,
    var retained: String
)

data class DeleteSwitchProxyEvent(@Id var switchProxyId: UUID? = null)

// single association events

// multiple association events


// SwitchSchedule Events

data class CreateSwitchScheduleEvent(
     var switchScheduleId: UUID? = null
)

data class UpdateSwitchScheduleEvent(
     var switchScheduleId: UUID? = null
)

data class DeleteSwitchScheduleEvent(@Id var switchScheduleId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachine Events

data class CreateSynchronousMachineEvent(
    @Id var synchronousMachineId: UUID? = null,
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

data class UpdateSynchronousMachineEvent(
    @Id var synchronousMachineId: UUID? = null,
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

data class DeleteSynchronousMachineEvent(@Id var synchronousMachineId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineDetailed Events

data class CreateSynchronousMachineDetailedEvent(
    @Id var synchronousMachineDetailedId: UUID? = null,
    var efdBaseRatio: String,
    var ifdBaseType: String,
    var ifdBaseValue: String,
    var saturationFactor120QAxis: String,
    var saturationFactorQAxis: String
)

data class UpdateSynchronousMachineDetailedEvent(
    @Id var synchronousMachineDetailedId: UUID? = null,
    var efdBaseRatio: String,
    var ifdBaseType: String,
    var ifdBaseValue: String,
    var saturationFactor120QAxis: String,
    var saturationFactorQAxis: String
)

data class DeleteSynchronousMachineDetailedEvent(@Id var synchronousMachineDetailedId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineDynamics Events

data class CreateSynchronousMachineDynamicsEvent(
     var synchronousMachineDynamicsId: UUID? = null
)

data class UpdateSynchronousMachineDynamicsEvent(
     var synchronousMachineDynamicsId: UUID? = null
)

data class DeleteSynchronousMachineDynamicsEvent(@Id var synchronousMachineDynamicsId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineEquivalentCircuit Events

data class CreateSynchronousMachineEquivalentCircuitEvent(
    @Id var synchronousMachineEquivalentCircuitId: UUID? = null,
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

data class UpdateSynchronousMachineEquivalentCircuitEvent(
    @Id var synchronousMachineEquivalentCircuitId: UUID? = null,
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

data class DeleteSynchronousMachineEquivalentCircuitEvent(@Id var synchronousMachineEquivalentCircuitId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineSimplified Events

data class CreateSynchronousMachineSimplifiedEvent(
     var synchronousMachineSimplifiedId: UUID? = null
)

data class UpdateSynchronousMachineSimplifiedEvent(
     var synchronousMachineSimplifiedId: UUID? = null
)

data class DeleteSynchronousMachineSimplifiedEvent(@Id var synchronousMachineSimplifiedId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineTimeConstantReactance Events

data class CreateSynchronousMachineTimeConstantReactanceEvent(
    @Id var synchronousMachineTimeConstantReactanceId: UUID? = null,
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

data class UpdateSynchronousMachineTimeConstantReactanceEvent(
    @Id var synchronousMachineTimeConstantReactanceId: UUID? = null,
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

data class DeleteSynchronousMachineTimeConstantReactanceEvent(@Id var synchronousMachineTimeConstantReactanceId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineUserDefined Events

data class CreateSynchronousMachineUserDefinedEvent(
    @Id var synchronousMachineUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateSynchronousMachineUserDefinedEvent(
    @Id var synchronousMachineUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteSynchronousMachineUserDefinedEvent(@Id var synchronousMachineUserDefinedId: UUID? = null)

// single association events

// multiple association events


// TapChanger Events

data class CreateTapChangerEvent(
    @Id var tapChangerId: UUID? = null,
    var highStep: String,
    var lowStep: String,
    var ltcFlag: String,
    var neutralStep: String,
    var neutralU: String,
    var normalStep: String
)

data class UpdateTapChangerEvent(
    @Id var tapChangerId: UUID? = null,
    var highStep: String,
    var lowStep: String,
    var ltcFlag: String,
    var neutralStep: String,
    var neutralU: String,
    var normalStep: String
)

data class DeleteTapChangerEvent(@Id var tapChangerId: UUID? = null)

// single association events

// multiple association events


// TapChangerControl Events

data class CreateTapChangerControlEvent(
     var tapChangerControlId: UUID? = null
)

data class UpdateTapChangerControlEvent(
     var tapChangerControlId: UUID? = null
)

data class DeleteTapChangerControlEvent(@Id var tapChangerControlId: UUID? = null)

// single association events

// multiple association events


// TapChangerTablePoint Events

data class CreateTapChangerTablePointEvent(
    @Id var tapChangerTablePointId: UUID? = null,
    var b: String,
    var g: String,
    var r: String,
    var ratio: String,
    var step: String,
    var x: String
)

data class UpdateTapChangerTablePointEvent(
    @Id var tapChangerTablePointId: UUID? = null,
    var b: String,
    var g: String,
    var r: String,
    var ratio: String,
    var step: String,
    var x: String
)

data class DeleteTapChangerTablePointEvent(@Id var tapChangerTablePointId: UUID? = null)

// single association events

// multiple association events


// TapSchedule Events

data class CreateTapScheduleEvent(
     var tapScheduleId: UUID? = null
)

data class UpdateTapScheduleEvent(
     var tapScheduleId: UUID? = null
)

data class DeleteTapScheduleEvent(@Id var tapScheduleId: UUID? = null)

// single association events

// multiple association events


// Temperature Events

data class CreateTemperatureEvent(
    @Id var temperatureId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateTemperatureEvent(
    @Id var temperatureId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteTemperatureEvent(@Id var temperatureId: UUID? = null)

// single association events

// multiple association events


// Terminal Events

data class CreateTerminalEvent(
     var terminalId: UUID? = null
)

data class UpdateTerminalEvent(
     var terminalId: UUID? = null
)

data class DeleteTerminalEvent(@Id var terminalId: UUID? = null)

// single association events

// multiple association events


// TextDiagramObject Events

data class CreateTextDiagramObjectEvent(
    @Id var textDiagramObjectId: UUID? = null,
    var text: String
)

data class UpdateTextDiagramObjectEvent(
    @Id var textDiagramObjectId: UUID? = null,
    var text: String
)

data class DeleteTextDiagramObjectEvent(@Id var textDiagramObjectId: UUID? = null)

// single association events

// multiple association events


// ThermalGeneratingUnit Events

data class CreateThermalGeneratingUnitEvent(
     var thermalGeneratingUnitId: UUID? = null
)

data class UpdateThermalGeneratingUnitEvent(
     var thermalGeneratingUnitId: UUID? = null
)

data class DeleteThermalGeneratingUnitEvent(@Id var thermalGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// TieFlow Events

data class CreateTieFlowEvent(
    @Id var tieFlowId: UUID? = null,
    var positiveFlowIn: String
)

data class UpdateTieFlowEvent(
    @Id var tieFlowId: UUID? = null,
    var positiveFlowIn: String
)

data class DeleteTieFlowEvent(@Id var tieFlowId: UUID? = null)

// single association events

// multiple association events


// TopologicalIsland Events

data class CreateTopologicalIslandEvent(
     var topologicalIslandId: UUID? = null
)

data class UpdateTopologicalIslandEvent(
     var topologicalIslandId: UUID? = null
)

data class DeleteTopologicalIslandEvent(@Id var topologicalIslandId: UUID? = null)

// single association events

// multiple association events


// TopologicalNode Events

data class CreateTopologicalNodeEvent(
    @Id var topologicalNodeId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class UpdateTopologicalNodeEvent(
    @Id var topologicalNodeId: UUID? = null,
    var boundaryPoint: String,
    var fromEndIsoCode: String,
    var fromEndName: String,
    var fromEndNameTso: String,
    var toEndIsoCode: String,
    var toEndName: String,
    var toEndNameTso: String
)

data class DeleteTopologicalNodeEvent(@Id var topologicalNodeId: UUID? = null)

// single association events

// multiple association events


// TopologyBoundaryVersion Events

data class CreateTopologyBoundaryVersionEvent(
    @Id var topologyBoundaryVersionId: UUID? = null,
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

data class UpdateTopologyBoundaryVersionEvent(
    @Id var topologyBoundaryVersionId: UUID? = null,
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

data class DeleteTopologyBoundaryVersionEvent(@Id var topologyBoundaryVersionId: UUID? = null)

// single association events

// multiple association events


// TopologyVersion Events

data class CreateTopologyVersionEvent(
    @Id var topologyVersionId: UUID? = null,
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

data class UpdateTopologyVersionEvent(
    @Id var topologyVersionId: UUID? = null,
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

data class DeleteTopologyVersionEvent(@Id var topologyVersionId: UUID? = null)

// single association events

// multiple association events


// TransformerEnd Events

data class CreateTransformerEndEvent(
    @Id var transformerEndId: UUID? = null,
    var endNumber: String,
    var grounded: String,
    var rground: String,
    var xground: String
)

data class UpdateTransformerEndEvent(
    @Id var transformerEndId: UUID? = null,
    var endNumber: String,
    var grounded: String,
    var rground: String,
    var xground: String
)

data class DeleteTransformerEndEvent(@Id var transformerEndId: UUID? = null)

// single association events

// multiple association events


// TurbLCFB1 Events

data class CreateTurbLCFB1Event(
    @Id var turbLCFB1Id: UUID? = null,
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

data class UpdateTurbLCFB1Event(
    @Id var turbLCFB1Id: UUID? = null,
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

data class DeleteTurbLCFB1Event(@Id var turbLCFB1Id: UUID? = null)

// single association events

// multiple association events


// TurbineGovernorDynamics Events

data class CreateTurbineGovernorDynamicsEvent(
     var turbineGovernorDynamicsId: UUID? = null
)

data class UpdateTurbineGovernorDynamicsEvent(
     var turbineGovernorDynamicsId: UUID? = null
)

data class DeleteTurbineGovernorDynamicsEvent(@Id var turbineGovernorDynamicsId: UUID? = null)

// single association events

// multiple association events


// TurbineGovernorUserDefined Events

data class CreateTurbineGovernorUserDefinedEvent(
    @Id var turbineGovernorUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateTurbineGovernorUserDefinedEvent(
    @Id var turbineGovernorUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteTurbineGovernorUserDefinedEvent(@Id var turbineGovernorUserDefinedId: UUID? = null)

// single association events

// multiple association events


// TurbineLoadControllerDynamics Events

data class CreateTurbineLoadControllerDynamicsEvent(
     var turbineLoadControllerDynamicsId: UUID? = null
)

data class UpdateTurbineLoadControllerDynamicsEvent(
     var turbineLoadControllerDynamicsId: UUID? = null
)

data class DeleteTurbineLoadControllerDynamicsEvent(@Id var turbineLoadControllerDynamicsId: UUID? = null)

// single association events

// multiple association events


// TurbineLoadControllerUserDefined Events

data class CreateTurbineLoadControllerUserDefinedEvent(
    @Id var turbineLoadControllerUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateTurbineLoadControllerUserDefinedEvent(
    @Id var turbineLoadControllerUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteTurbineLoadControllerUserDefinedEvent(@Id var turbineLoadControllerUserDefinedId: UUID? = null)

// single association events

// multiple association events


// UnderexcLim2Simplified Events

data class CreateUnderexcLim2SimplifiedEvent(
    @Id var underexcLim2SimplifiedId: UUID? = null,
    var kui: String,
    var p0: String,
    var p1: String,
    var q0: String,
    var q1: String,
    var vuimax: String,
    var vuimin: String
)

data class UpdateUnderexcLim2SimplifiedEvent(
    @Id var underexcLim2SimplifiedId: UUID? = null,
    var kui: String,
    var p0: String,
    var p1: String,
    var q0: String,
    var q1: String,
    var vuimax: String,
    var vuimin: String
)

data class DeleteUnderexcLim2SimplifiedEvent(@Id var underexcLim2SimplifiedId: UUID? = null)

// single association events

// multiple association events


// UnderexcLimIEEE1 Events

data class CreateUnderexcLimIEEE1Event(
    @Id var underexcLimIEEE1Id: UUID? = null,
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

data class UpdateUnderexcLimIEEE1Event(
    @Id var underexcLimIEEE1Id: UUID? = null,
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

data class DeleteUnderexcLimIEEE1Event(@Id var underexcLimIEEE1Id: UUID? = null)

// single association events

// multiple association events


// UnderexcLimIEEE2 Events

data class CreateUnderexcLimIEEE2Event(
    @Id var underexcLimIEEE2Id: UUID? = null,
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

data class UpdateUnderexcLimIEEE2Event(
    @Id var underexcLimIEEE2Id: UUID? = null,
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

data class DeleteUnderexcLimIEEE2Event(@Id var underexcLimIEEE2Id: UUID? = null)

// single association events

// multiple association events


// UnderexcLimX1 Events

data class CreateUnderexcLimX1Event(
    @Id var underexcLimX1Id: UUID? = null,
    var k: String,
    var kf2: String,
    var km: String,
    var melmax: String,
    var tf2: String,
    var tm: String
)

data class UpdateUnderexcLimX1Event(
    @Id var underexcLimX1Id: UUID? = null,
    var k: String,
    var kf2: String,
    var km: String,
    var melmax: String,
    var tf2: String,
    var tm: String
)

data class DeleteUnderexcLimX1Event(@Id var underexcLimX1Id: UUID? = null)

// single association events

// multiple association events


// UnderexcLimX2 Events

data class CreateUnderexcLimX2Event(
    @Id var underexcLimX2Id: UUID? = null,
    var kf2: String,
    var km: String,
    var melmax: String,
    var qo: String,
    var r: String,
    var tf2: String,
    var tm: String
)

data class UpdateUnderexcLimX2Event(
    @Id var underexcLimX2Id: UUID? = null,
    var kf2: String,
    var km: String,
    var melmax: String,
    var qo: String,
    var r: String,
    var tf2: String,
    var tm: String
)

data class DeleteUnderexcLimX2Event(@Id var underexcLimX2Id: UUID? = null)

// single association events

// multiple association events


// UnderexcitationLimiterDynamics Events

data class CreateUnderexcitationLimiterDynamicsEvent(
     var underexcitationLimiterDynamicsId: UUID? = null
)

data class UpdateUnderexcitationLimiterDynamicsEvent(
     var underexcitationLimiterDynamicsId: UUID? = null
)

data class DeleteUnderexcitationLimiterDynamicsEvent(@Id var underexcitationLimiterDynamicsId: UUID? = null)

// single association events

// multiple association events


// UnderexcitationLimiterUserDefined Events

data class CreateUnderexcitationLimiterUserDefinedEvent(
    @Id var underexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateUnderexcitationLimiterUserDefinedEvent(
    @Id var underexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteUnderexcitationLimiterUserDefinedEvent(@Id var underexcitationLimiterUserDefinedId: UUID? = null)

// single association events

// multiple association events


// Unresolvedname Events

data class CreateUnresolvednameEvent(
     var unresolvednameId: UUID? = null
)

data class UpdateUnresolvednameEvent(
     var unresolvednameId: UUID? = null
)

data class DeleteUnresolvednameEvent(@Id var unresolvednameId: UUID? = null)

// single association events

// multiple association events


// VAdjIEEE Events

data class CreateVAdjIEEEEvent(
    @Id var vAdjIEEEId: UUID? = null,
    var adjslew: String,
    var taoff: String,
    var taon: String,
    var vadjf: String,
    var vadjmax: String,
    var vadjmin: String
)

data class UpdateVAdjIEEEEvent(
    @Id var vAdjIEEEId: UUID? = null,
    var adjslew: String,
    var taoff: String,
    var taon: String,
    var vadjf: String,
    var vadjmax: String,
    var vadjmin: String
)

data class DeleteVAdjIEEEEvent(@Id var vAdjIEEEId: UUID? = null)

// single association events

// multiple association events


// VCompIEEEType1 Events

data class CreateVCompIEEEType1Event(
    @Id var vCompIEEEType1Id: UUID? = null,
    var rc: String,
    var tr: String,
    var xc: String
)

data class UpdateVCompIEEEType1Event(
    @Id var vCompIEEEType1Id: UUID? = null,
    var rc: String,
    var tr: String,
    var xc: String
)

data class DeleteVCompIEEEType1Event(@Id var vCompIEEEType1Id: UUID? = null)

// single association events

// multiple association events


// VCompIEEEType2 Events

data class CreateVCompIEEEType2Event(
    @Id var vCompIEEEType2Id: UUID? = null,
    var tr: String
)

data class UpdateVCompIEEEType2Event(
    @Id var vCompIEEEType2Id: UUID? = null,
    var tr: String
)

data class DeleteVCompIEEEType2Event(@Id var vCompIEEEType2Id: UUID? = null)

// single association events

// multiple association events


// ValueAliasSet Events

data class CreateValueAliasSetEvent(
     var valueAliasSetId: UUID? = null
)

data class UpdateValueAliasSetEvent(
     var valueAliasSetId: UUID? = null
)

data class DeleteValueAliasSetEvent(@Id var valueAliasSetId: UUID? = null)

// single association events

// multiple association events


// ValueToAlias Events

data class CreateValueToAliasEvent(
    @Id var valueToAliasId: UUID? = null,
    var value: String
)

data class UpdateValueToAliasEvent(
    @Id var valueToAliasId: UUID? = null,
    var value: String
)

data class DeleteValueToAliasEvent(@Id var valueToAliasId: UUID? = null)

// single association events

// multiple association events


// VisibilityLayer Events

data class CreateVisibilityLayerEvent(
    @Id var visibilityLayerId: UUID? = null,
    var drawingOrder: String
)

data class UpdateVisibilityLayerEvent(
    @Id var visibilityLayerId: UUID? = null,
    var drawingOrder: String
)

data class DeleteVisibilityLayerEvent(@Id var visibilityLayerId: UUID? = null)

// single association events

// multiple association events


// Voltage Events

data class CreateVoltageEvent(
    @Id var voltageId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateVoltageEvent(
    @Id var voltageId: UUID? = null,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteVoltageEvent(@Id var voltageId: UUID? = null)

// single association events

// multiple association events


// VoltageAdjusterDynamics Events

data class CreateVoltageAdjusterDynamicsEvent(
     var voltageAdjusterDynamicsId: UUID? = null
)

data class UpdateVoltageAdjusterDynamicsEvent(
     var voltageAdjusterDynamicsId: UUID? = null
)

data class DeleteVoltageAdjusterDynamicsEvent(@Id var voltageAdjusterDynamicsId: UUID? = null)

// single association events

// multiple association events


// VoltageAdjusterUserDefined Events

data class CreateVoltageAdjusterUserDefinedEvent(
    @Id var voltageAdjusterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateVoltageAdjusterUserDefinedEvent(
    @Id var voltageAdjusterUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteVoltageAdjusterUserDefinedEvent(@Id var voltageAdjusterUserDefinedId: UUID? = null)

// single association events

// multiple association events


// VoltageCompensatorDynamics Events

data class CreateVoltageCompensatorDynamicsEvent(
     var voltageCompensatorDynamicsId: UUID? = null
)

data class UpdateVoltageCompensatorDynamicsEvent(
     var voltageCompensatorDynamicsId: UUID? = null
)

data class DeleteVoltageCompensatorDynamicsEvent(@Id var voltageCompensatorDynamicsId: UUID? = null)

// single association events

// multiple association events


// VoltageCompensatorUserDefined Events

data class CreateVoltageCompensatorUserDefinedEvent(
    @Id var voltageCompensatorUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateVoltageCompensatorUserDefinedEvent(
    @Id var voltageCompensatorUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteVoltageCompensatorUserDefinedEvent(@Id var voltageCompensatorUserDefinedId: UUID? = null)

// single association events

// multiple association events


// VoltageLevel Events

data class CreateVoltageLevelEvent(
    @Id var voltageLevelId: UUID? = null,
    var highVoltageLimit: String,
    var lowVoltageLimit: String
)

data class UpdateVoltageLevelEvent(
    @Id var voltageLevelId: UUID? = null,
    var highVoltageLimit: String,
    var lowVoltageLimit: String
)

data class DeleteVoltageLevelEvent(@Id var voltageLevelId: UUID? = null)

// single association events

// multiple association events


// VoltageLimit Events

data class CreateVoltageLimitEvent(
    @Id var voltageLimitId: UUID? = null,
    var value: String
)

data class UpdateVoltageLimitEvent(
    @Id var voltageLimitId: UUID? = null,
    var value: String
)

data class DeleteVoltageLimitEvent(@Id var voltageLimitId: UUID? = null)

// single association events

// multiple association events


// VoltagePerReactivePower Events

data class CreateVoltagePerReactivePowerEvent(
    @Id var voltagePerReactivePowerId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateVoltagePerReactivePowerEvent(
    @Id var voltagePerReactivePowerId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteVoltagePerReactivePowerEvent(@Id var voltagePerReactivePowerId: UUID? = null)

// single association events

// multiple association events


// VolumeFlowRate Events

data class CreateVolumeFlowRateEvent(
    @Id var volumeFlowRateId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class UpdateVolumeFlowRateEvent(
    @Id var volumeFlowRateId: UUID? = null,
    var denominatorMultiplier: String,
    var denominatorUnit: String,
    var multiplier: String,
    var unit: String,
    var value: String
)

data class DeleteVolumeFlowRateEvent(@Id var volumeFlowRateId: UUID? = null)

// single association events

// multiple association events


// VsCapabilityCurve Events

data class CreateVsCapabilityCurveEvent(
     var vsCapabilityCurveId: UUID? = null
)

data class UpdateVsCapabilityCurveEvent(
     var vsCapabilityCurveId: UUID? = null
)

data class DeleteVsCapabilityCurveEvent(@Id var vsCapabilityCurveId: UUID? = null)

// single association events

// multiple association events


// VsConverter Events

data class CreateVsConverterEvent(
    @Id var vsConverterId: UUID? = null,
    var maxModulationIndex: String,
    var maxValveCurrent: String
)

data class UpdateVsConverterEvent(
    @Id var vsConverterId: UUID? = null,
    var maxModulationIndex: String,
    var maxValveCurrent: String
)

data class DeleteVsConverterEvent(@Id var vsConverterId: UUID? = null)

// single association events

// multiple association events


// WindAeroConstIEC Events

data class CreateWindAeroConstIECEvent(
     var windAeroConstIECId: UUID? = null
)

data class UpdateWindAeroConstIECEvent(
     var windAeroConstIECId: UUID? = null
)

data class DeleteWindAeroConstIECEvent(@Id var windAeroConstIECId: UUID? = null)

// single association events

// multiple association events


// WindAeroLinearIEC Events

data class CreateWindAeroLinearIECEvent(
    @Id var windAeroLinearIECId: UUID? = null,
    var dpomega: String,
    var dptheta: String,
    var omegazero: String,
    var pavail: String,
    var thetazero: String
)

data class UpdateWindAeroLinearIECEvent(
    @Id var windAeroLinearIECId: UUID? = null,
    var dpomega: String,
    var dptheta: String,
    var omegazero: String,
    var pavail: String,
    var thetazero: String
)

data class DeleteWindAeroLinearIECEvent(@Id var windAeroLinearIECId: UUID? = null)

// single association events

// multiple association events


// WindContCurrLimIEC Events

data class CreateWindContCurrLimIECEvent(
    @Id var windContCurrLimIECId: UUID? = null,
    var imax: String,
    var imaxdip: String,
    var mdfslim: String,
    var mqpri: String,
    var tufilt: String
)

data class UpdateWindContCurrLimIECEvent(
    @Id var windContCurrLimIECId: UUID? = null,
    var imax: String,
    var imaxdip: String,
    var mdfslim: String,
    var mqpri: String,
    var tufilt: String
)

data class DeleteWindContCurrLimIECEvent(@Id var windContCurrLimIECId: UUID? = null)

// single association events

// multiple association events


// WindContPType3IEC Events

data class CreateWindContPType3IECEvent(
    @Id var windContPType3IECId: UUID? = null,
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

data class UpdateWindContPType3IECEvent(
    @Id var windContPType3IECId: UUID? = null,
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

data class DeleteWindContPType3IECEvent(@Id var windContPType3IECId: UUID? = null)

// single association events

// multiple association events


// WindContPType4aIEC Events

data class CreateWindContPType4aIECEvent(
    @Id var windContPType4aIECId: UUID? = null,
    var dpmax: String,
    var tpord: String,
    var tufilt: String
)

data class UpdateWindContPType4aIECEvent(
    @Id var windContPType4aIECId: UUID? = null,
    var dpmax: String,
    var tpord: String,
    var tufilt: String
)

data class DeleteWindContPType4aIECEvent(@Id var windContPType4aIECId: UUID? = null)

// single association events

// multiple association events


// WindContPType4bIEC Events

data class CreateWindContPType4bIECEvent(
    @Id var windContPType4bIECId: UUID? = null,
    var dpmax: String,
    var tpaero: String,
    var tpord: String,
    var tufilt: String
)

data class UpdateWindContPType4bIECEvent(
    @Id var windContPType4bIECId: UUID? = null,
    var dpmax: String,
    var tpaero: String,
    var tpord: String,
    var tufilt: String
)

data class DeleteWindContPType4bIECEvent(@Id var windContPType4bIECId: UUID? = null)

// single association events

// multiple association events


// WindContPitchAngleIEC Events

data class CreateWindContPitchAngleIECEvent(
    @Id var windContPitchAngleIECId: UUID? = null,
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

data class UpdateWindContPitchAngleIECEvent(
    @Id var windContPitchAngleIECId: UUID? = null,
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

data class DeleteWindContPitchAngleIECEvent(@Id var windContPitchAngleIECId: UUID? = null)

// single association events

// multiple association events


// WindContQIEC Events

data class CreateWindContQIECEvent(
    @Id var windContQIECId: UUID? = null,
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

data class UpdateWindContQIECEvent(
    @Id var windContQIECId: UUID? = null,
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

data class DeleteWindContQIECEvent(@Id var windContQIECId: UUID? = null)

// single association events

// multiple association events


// WindContRotorRIEC Events

data class CreateWindContRotorRIECEvent(
    @Id var windContRotorRIECId: UUID? = null,
    var kirr: String,
    var komegafilt: String,
    var kpfilt: String,
    var kprr: String,
    var rmax: String,
    var rmin: String,
    var tomegafilt: String,
    var tpfilt: String
)

data class UpdateWindContRotorRIECEvent(
    @Id var windContRotorRIECId: UUID? = null,
    var kirr: String,
    var komegafilt: String,
    var kpfilt: String,
    var kprr: String,
    var rmax: String,
    var rmin: String,
    var tomegafilt: String,
    var tpfilt: String
)

data class DeleteWindContRotorRIECEvent(@Id var windContRotorRIECId: UUID? = null)

// single association events

// multiple association events


// WindDynamicsLookupTable Events

data class CreateWindDynamicsLookupTableEvent(
    @Id var windDynamicsLookupTableId: UUID? = null,
    var input: String,
    var lookupTableFunctionType: String,
    var output: String,
    var sequence: String
)

data class UpdateWindDynamicsLookupTableEvent(
    @Id var windDynamicsLookupTableId: UUID? = null,
    var input: String,
    var lookupTableFunctionType: String,
    var output: String,
    var sequence: String
)

data class DeleteWindDynamicsLookupTableEvent(@Id var windDynamicsLookupTableId: UUID? = null)

// single association events

// multiple association events


// WindGenTurbineType1IEC Events

data class CreateWindGenTurbineType1IECEvent(
     var windGenTurbineType1IECId: UUID? = null
)

data class UpdateWindGenTurbineType1IECEvent(
     var windGenTurbineType1IECId: UUID? = null
)

data class DeleteWindGenTurbineType1IECEvent(@Id var windGenTurbineType1IECId: UUID? = null)

// single association events

// multiple association events


// WindGenTurbineType2IEC Events

data class CreateWindGenTurbineType2IECEvent(
     var windGenTurbineType2IECId: UUID? = null
)

data class UpdateWindGenTurbineType2IECEvent(
     var windGenTurbineType2IECId: UUID? = null
)

data class DeleteWindGenTurbineType2IECEvent(@Id var windGenTurbineType2IECId: UUID? = null)

// single association events

// multiple association events


// WindGenTurbineType3IEC Events

data class CreateWindGenTurbineType3IECEvent(
    @Id var windGenTurbineType3IECId: UUID? = null,
    var dipmax: String,
    var diqmax: String
)

data class UpdateWindGenTurbineType3IECEvent(
    @Id var windGenTurbineType3IECId: UUID? = null,
    var dipmax: String,
    var diqmax: String
)

data class DeleteWindGenTurbineType3IECEvent(@Id var windGenTurbineType3IECId: UUID? = null)

// single association events

// multiple association events


// WindGenTurbineType3aIEC Events

data class CreateWindGenTurbineType3aIECEvent(
    @Id var windGenTurbineType3aIECId: UUID? = null,
    var kpc: String,
    var tic: String,
    var xs: String
)

data class UpdateWindGenTurbineType3aIECEvent(
    @Id var windGenTurbineType3aIECId: UUID? = null,
    var kpc: String,
    var tic: String,
    var xs: String
)

data class DeleteWindGenTurbineType3aIECEvent(@Id var windGenTurbineType3aIECId: UUID? = null)

// single association events

// multiple association events


// WindGenTurbineType3bIEC Events

data class CreateWindGenTurbineType3bIECEvent(
    @Id var windGenTurbineType3bIECId: UUID? = null,
    var fducw: String,
    var mwtcwp: String,
    var tg: String,
    var two: String,
    var xs: String
)

data class UpdateWindGenTurbineType3bIECEvent(
    @Id var windGenTurbineType3bIECId: UUID? = null,
    var fducw: String,
    var mwtcwp: String,
    var tg: String,
    var two: String,
    var xs: String
)

data class DeleteWindGenTurbineType3bIECEvent(@Id var windGenTurbineType3bIECId: UUID? = null)

// single association events

// multiple association events


// WindGenType4IEC Events

data class CreateWindGenType4IECEvent(
    @Id var windGenType4IECId: UUID? = null,
    var dipmax: String,
    var diqmax: String,
    var diqmin: String,
    var tg: String
)

data class UpdateWindGenType4IECEvent(
    @Id var windGenType4IECId: UUID? = null,
    var dipmax: String,
    var diqmax: String,
    var diqmin: String,
    var tg: String
)

data class DeleteWindGenType4IECEvent(@Id var windGenType4IECId: UUID? = null)

// single association events

// multiple association events


// WindGeneratingUnit Events

data class CreateWindGeneratingUnitEvent(
    @Id var windGeneratingUnitId: UUID? = null,
    var windGenUnitType: String
)

data class UpdateWindGeneratingUnitEvent(
    @Id var windGeneratingUnitId: UUID? = null,
    var windGenUnitType: String
)

data class DeleteWindGeneratingUnitEvent(@Id var windGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// WindMechIEC Events

data class CreateWindMechIECEvent(
    @Id var windMechIECId: UUID? = null,
    var cdrt: String,
    var hgen: String,
    var hwtr: String,
    var kdrt: String
)

data class UpdateWindMechIECEvent(
    @Id var windMechIECId: UUID? = null,
    var cdrt: String,
    var hgen: String,
    var hwtr: String,
    var kdrt: String
)

data class DeleteWindMechIECEvent(@Id var windMechIECId: UUID? = null)

// single association events

// multiple association events


// WindPitchContEmulIEC Events

data class CreateWindPitchContEmulIECEvent(
    @Id var windPitchContEmulIECId: UUID? = null,
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

data class UpdateWindPitchContEmulIECEvent(
    @Id var windPitchContEmulIECId: UUID? = null,
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

data class DeleteWindPitchContEmulIECEvent(@Id var windPitchContEmulIECId: UUID? = null)

// single association events

// multiple association events


// WindPlantDynamics Events

data class CreateWindPlantDynamicsEvent(
     var windPlantDynamicsId: UUID? = null
)

data class UpdateWindPlantDynamicsEvent(
     var windPlantDynamicsId: UUID? = null
)

data class DeleteWindPlantDynamicsEvent(@Id var windPlantDynamicsId: UUID? = null)

// single association events

// multiple association events


// WindPlantFreqPcontrolIEC Events

data class CreateWindPlantFreqPcontrolIECEvent(
    @Id var windPlantFreqPcontrolIECId: UUID? = null,
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

data class UpdateWindPlantFreqPcontrolIECEvent(
    @Id var windPlantFreqPcontrolIECId: UUID? = null,
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

data class DeleteWindPlantFreqPcontrolIECEvent(@Id var windPlantFreqPcontrolIECId: UUID? = null)

// single association events

// multiple association events


// WindPlantIEC Events

data class CreateWindPlantIECEvent(
     var windPlantIECId: UUID? = null
)

data class UpdateWindPlantIECEvent(
     var windPlantIECId: UUID? = null
)

data class DeleteWindPlantIECEvent(@Id var windPlantIECId: UUID? = null)

// single association events

// multiple association events


// WindPlantReactiveControlIEC Events

data class CreateWindPlantReactiveControlIECEvent(
    @Id var windPlantReactiveControlIECId: UUID? = null,
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

data class UpdateWindPlantReactiveControlIECEvent(
    @Id var windPlantReactiveControlIECId: UUID? = null,
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

data class DeleteWindPlantReactiveControlIECEvent(@Id var windPlantReactiveControlIECId: UUID? = null)

// single association events

// multiple association events


// WindPlantUserDefined Events

data class CreateWindPlantUserDefinedEvent(
    @Id var windPlantUserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateWindPlantUserDefinedEvent(
    @Id var windPlantUserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteWindPlantUserDefinedEvent(@Id var windPlantUserDefinedId: UUID? = null)

// single association events

// multiple association events


// WindProtectionIEC Events

data class CreateWindProtectionIECEvent(
    @Id var windProtectionIECId: UUID? = null,
    var fover: String,
    var funder: String,
    var tfover: String,
    var tfunder: String,
    var tuover: String,
    var tuunder: String,
    var uover: String,
    var uunder: String
)

data class UpdateWindProtectionIECEvent(
    @Id var windProtectionIECId: UUID? = null,
    var fover: String,
    var funder: String,
    var tfover: String,
    var tfunder: String,
    var tuover: String,
    var tuunder: String,
    var uover: String,
    var uunder: String
)

data class DeleteWindProtectionIECEvent(@Id var windProtectionIECId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType1or2Dynamics Events

data class CreateWindTurbineType1or2DynamicsEvent(
     var windTurbineType1or2DynamicsId: UUID? = null
)

data class UpdateWindTurbineType1or2DynamicsEvent(
     var windTurbineType1or2DynamicsId: UUID? = null
)

data class DeleteWindTurbineType1or2DynamicsEvent(@Id var windTurbineType1or2DynamicsId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType1or2IEC Events

data class CreateWindTurbineType1or2IECEvent(
     var windTurbineType1or2IECId: UUID? = null
)

data class UpdateWindTurbineType1or2IECEvent(
     var windTurbineType1or2IECId: UUID? = null
)

data class DeleteWindTurbineType1or2IECEvent(@Id var windTurbineType1or2IECId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType3or4Dynamics Events

data class CreateWindTurbineType3or4DynamicsEvent(
     var windTurbineType3or4DynamicsId: UUID? = null
)

data class UpdateWindTurbineType3or4DynamicsEvent(
     var windTurbineType3or4DynamicsId: UUID? = null
)

data class DeleteWindTurbineType3or4DynamicsEvent(@Id var windTurbineType3or4DynamicsId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType3or4IEC Events

data class CreateWindTurbineType3or4IECEvent(
     var windTurbineType3or4IECId: UUID? = null
)

data class UpdateWindTurbineType3or4IECEvent(
     var windTurbineType3or4IECId: UUID? = null
)

data class DeleteWindTurbineType3or4IECEvent(@Id var windTurbineType3or4IECId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType4aIEC Events

data class CreateWindTurbineType4aIECEvent(
     var windTurbineType4aIECId: UUID? = null
)

data class UpdateWindTurbineType4aIECEvent(
     var windTurbineType4aIECId: UUID? = null
)

data class DeleteWindTurbineType4aIECEvent(@Id var windTurbineType4aIECId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType4bIEC Events

data class CreateWindTurbineType4bIECEvent(
     var windTurbineType4bIECId: UUID? = null
)

data class UpdateWindTurbineType4bIECEvent(
     var windTurbineType4bIECId: UUID? = null
)

data class DeleteWindTurbineType4bIECEvent(@Id var windTurbineType4bIECId: UUID? = null)

// single association events

// multiple association events


// WindType1or2UserDefined Events

data class CreateWindType1or2UserDefinedEvent(
    @Id var windType1or2UserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateWindType1or2UserDefinedEvent(
    @Id var windType1or2UserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteWindType1or2UserDefinedEvent(@Id var windType1or2UserDefinedId: UUID? = null)

// single association events

// multiple association events


// WindType3or4UserDefined Events

data class CreateWindType3or4UserDefinedEvent(
    @Id var windType3or4UserDefinedId: UUID? = null,
    var proprietary: String
)

data class UpdateWindType3or4UserDefinedEvent(
    @Id var windType3or4UserDefinedId: UUID? = null,
    var proprietary: String
)

data class DeleteWindType3or4UserDefinedEvent(@Id var windType3or4UserDefinedId: UUID? = null)

// single association events

// multiple association events



