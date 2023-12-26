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
    @Id val aCDCConverterId: UUID? = null,
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

data class UpdateACDCConverterEvent(
    @Id val aCDCConverterId: UUID? = null,
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

data class DeleteACDCConverterEvent(@Id val aCDCConverterId: UUID? = null)

// single association events

// multiple association events


// ACDCConverterDCTerminal Events

data class CreateACDCConverterDCTerminalEvent(
    @Id val aCDCConverterDCTerminalId: UUID? = null,
    val polarity: String
)

data class UpdateACDCConverterDCTerminalEvent(
    @Id val aCDCConverterDCTerminalId: UUID? = null,
    val polarity: String
)

data class DeleteACDCConverterDCTerminalEvent(@Id val aCDCConverterDCTerminalId: UUID? = null)

// single association events

// multiple association events


// ACDCTerminal Events

data class CreateACDCTerminalEvent(
    @Id val aCDCTerminalId: UUID? = null,
    val sequenceNumber: String
)

data class UpdateACDCTerminalEvent(
    @Id val aCDCTerminalId: UUID? = null,
    val sequenceNumber: String
)

data class DeleteACDCTerminalEvent(@Id val aCDCTerminalId: UUID? = null)

// single association events

// multiple association events


// ACLineSegment Events

data class CreateACLineSegmentEvent(
    @Id val aCLineSegmentId: UUID? = null,
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

data class UpdateACLineSegmentEvent(
    @Id val aCLineSegmentId: UUID? = null,
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

data class DeleteACLineSegmentEvent(@Id val aCLineSegmentId: UUID? = null)

// single association events

// multiple association events


// Accumulator Events

data class CreateAccumulatorEvent(
     val accumulatorId: UUID? = null
)

data class UpdateAccumulatorEvent(
     val accumulatorId: UUID? = null
)

data class DeleteAccumulatorEvent(@Id val accumulatorId: UUID? = null)

// single association events

// multiple association events


// AccumulatorLimit Events

data class CreateAccumulatorLimitEvent(
    @Id val accumulatorLimitId: UUID? = null,
    val value: String
)

data class UpdateAccumulatorLimitEvent(
    @Id val accumulatorLimitId: UUID? = null,
    val value: String
)

data class DeleteAccumulatorLimitEvent(@Id val accumulatorLimitId: UUID? = null)

// single association events

// multiple association events


// AccumulatorLimitSet Events

data class CreateAccumulatorLimitSetEvent(
     val accumulatorLimitSetId: UUID? = null
)

data class UpdateAccumulatorLimitSetEvent(
     val accumulatorLimitSetId: UUID? = null
)

data class DeleteAccumulatorLimitSetEvent(@Id val accumulatorLimitSetId: UUID? = null)

// single association events

// multiple association events


// AccumulatorReset Events

data class CreateAccumulatorResetEvent(
     val accumulatorResetId: UUID? = null
)

data class UpdateAccumulatorResetEvent(
     val accumulatorResetId: UUID? = null
)

data class DeleteAccumulatorResetEvent(@Id val accumulatorResetId: UUID? = null)

// single association events

// multiple association events


// AccumulatorValue Events

data class CreateAccumulatorValueEvent(
    @Id val accumulatorValueId: UUID? = null,
    val value: String
)

data class UpdateAccumulatorValueEvent(
    @Id val accumulatorValueId: UUID? = null,
    val value: String
)

data class DeleteAccumulatorValueEvent(@Id val accumulatorValueId: UUID? = null)

// single association events

// multiple association events


// ActivePower Events

data class CreateActivePowerEvent(
    @Id val activePowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateActivePowerEvent(
    @Id val activePowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteActivePowerEvent(@Id val activePowerId: UUID? = null)

// single association events

// multiple association events


// ActivePowerLimit Events

data class CreateActivePowerLimitEvent(
    @Id val activePowerLimitId: UUID? = null,
    val value: String
)

data class UpdateActivePowerLimitEvent(
    @Id val activePowerLimitId: UUID? = null,
    val value: String
)

data class DeleteActivePowerLimitEvent(@Id val activePowerLimitId: UUID? = null)

// single association events

// multiple association events


// ActivePowerPerCurrentFlow Events

data class CreateActivePowerPerCurrentFlowEvent(
    @Id val activePowerPerCurrentFlowId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateActivePowerPerCurrentFlowEvent(
    @Id val activePowerPerCurrentFlowId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteActivePowerPerCurrentFlowEvent(@Id val activePowerPerCurrentFlowId: UUID? = null)

// single association events

// multiple association events


// ActivePowerPerFrequency Events

data class CreateActivePowerPerFrequencyEvent(
    @Id val activePowerPerFrequencyId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateActivePowerPerFrequencyEvent(
    @Id val activePowerPerFrequencyId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteActivePowerPerFrequencyEvent(@Id val activePowerPerFrequencyId: UUID? = null)

// single association events

// multiple association events


// Analog Events

data class CreateAnalogEvent(
    @Id val analogId: UUID? = null,
    val positiveFlowIn: String
)

data class UpdateAnalogEvent(
    @Id val analogId: UUID? = null,
    val positiveFlowIn: String
)

data class DeleteAnalogEvent(@Id val analogId: UUID? = null)

// single association events

// multiple association events


// AnalogControl Events

data class CreateAnalogControlEvent(
    @Id val analogControlId: UUID? = null,
    val maxValue: String,
    val minValue: String
)

data class UpdateAnalogControlEvent(
    @Id val analogControlId: UUID? = null,
    val maxValue: String,
    val minValue: String
)

data class DeleteAnalogControlEvent(@Id val analogControlId: UUID? = null)

// single association events

// multiple association events


// AnalogLimit Events

data class CreateAnalogLimitEvent(
    @Id val analogLimitId: UUID? = null,
    val value: String
)

data class UpdateAnalogLimitEvent(
    @Id val analogLimitId: UUID? = null,
    val value: String
)

data class DeleteAnalogLimitEvent(@Id val analogLimitId: UUID? = null)

// single association events

// multiple association events


// AnalogLimitSet Events

data class CreateAnalogLimitSetEvent(
     val analogLimitSetId: UUID? = null
)

data class UpdateAnalogLimitSetEvent(
     val analogLimitSetId: UUID? = null
)

data class DeleteAnalogLimitSetEvent(@Id val analogLimitSetId: UUID? = null)

// single association events

// multiple association events


// AnalogValue Events

data class CreateAnalogValueEvent(
    @Id val analogValueId: UUID? = null,
    val value: String
)

data class UpdateAnalogValueEvent(
    @Id val analogValueId: UUID? = null,
    val value: String
)

data class DeleteAnalogValueEvent(@Id val analogValueId: UUID? = null)

// single association events

// multiple association events


// AngleDegrees Events

data class CreateAngleDegreesEvent(
    @Id val angleDegreesId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateAngleDegreesEvent(
    @Id val angleDegreesId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteAngleDegreesEvent(@Id val angleDegreesId: UUID? = null)

// single association events

// multiple association events


// AngleRadians Events

data class CreateAngleRadiansEvent(
    @Id val angleRadiansId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateAngleRadiansEvent(
    @Id val angleRadiansId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteAngleRadiansEvent(@Id val angleRadiansId: UUID? = null)

// single association events

// multiple association events


// ApparentPower Events

data class CreateApparentPowerEvent(
    @Id val apparentPowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateApparentPowerEvent(
    @Id val apparentPowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteApparentPowerEvent(@Id val apparentPowerId: UUID? = null)

// single association events

// multiple association events


// ApparentPowerLimit Events

data class CreateApparentPowerLimitEvent(
    @Id val apparentPowerLimitId: UUID? = null,
    val value: String
)

data class UpdateApparentPowerLimitEvent(
    @Id val apparentPowerLimitId: UUID? = null,
    val value: String
)

data class DeleteApparentPowerLimitEvent(@Id val apparentPowerLimitId: UUID? = null)

// single association events

// multiple association events


// Area Events

data class CreateAreaEvent(
    @Id val areaId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateAreaEvent(
    @Id val areaId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteAreaEvent(@Id val areaId: UUID? = null)

// single association events

// multiple association events


// AsynchronousMachine Events

data class CreateAsynchronousMachineEvent(
    @Id val asynchronousMachineId: UUID? = null,
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

data class UpdateAsynchronousMachineEvent(
    @Id val asynchronousMachineId: UUID? = null,
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

data class DeleteAsynchronousMachineEvent(@Id val asynchronousMachineId: UUID? = null)

// single association events

// multiple association events


// AsynchronousMachineDynamics Events

data class CreateAsynchronousMachineDynamicsEvent(
     val asynchronousMachineDynamicsId: UUID? = null
)

data class UpdateAsynchronousMachineDynamicsEvent(
     val asynchronousMachineDynamicsId: UUID? = null
)

data class DeleteAsynchronousMachineDynamicsEvent(@Id val asynchronousMachineDynamicsId: UUID? = null)

// single association events

// multiple association events


// AsynchronousMachineEquivalentCircuit Events

data class CreateAsynchronousMachineEquivalentCircuitEvent(
    @Id val asynchronousMachineEquivalentCircuitId: UUID? = null,
    val rr1: String,
    val rr2: String,
    val xlr1: String,
    val xlr2: String,
    val xm: String
)

data class UpdateAsynchronousMachineEquivalentCircuitEvent(
    @Id val asynchronousMachineEquivalentCircuitId: UUID? = null,
    val rr1: String,
    val rr2: String,
    val xlr1: String,
    val xlr2: String,
    val xm: String
)

data class DeleteAsynchronousMachineEquivalentCircuitEvent(@Id val asynchronousMachineEquivalentCircuitId: UUID? = null)

// single association events

// multiple association events


// AsynchronousMachineTimeConstantReactance Events

data class CreateAsynchronousMachineTimeConstantReactanceEvent(
    @Id val asynchronousMachineTimeConstantReactanceId: UUID? = null,
    val tpo: String,
    val tppo: String,
    val xp: String,
    val xpp: String,
    val xs: String
)

data class UpdateAsynchronousMachineTimeConstantReactanceEvent(
    @Id val asynchronousMachineTimeConstantReactanceId: UUID? = null,
    val tpo: String,
    val tppo: String,
    val xp: String,
    val xpp: String,
    val xs: String
)

data class DeleteAsynchronousMachineTimeConstantReactanceEvent(@Id val asynchronousMachineTimeConstantReactanceId: UUID? = null)

// single association events

// multiple association events


// AsynchronousMachineUserDefined Events

data class CreateAsynchronousMachineUserDefinedEvent(
    @Id val asynchronousMachineUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateAsynchronousMachineUserDefinedEvent(
    @Id val asynchronousMachineUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteAsynchronousMachineUserDefinedEvent(@Id val asynchronousMachineUserDefinedId: UUID? = null)

// single association events

// multiple association events


// BaseVoltage Events

data class CreateBaseVoltageEvent(
    @Id val baseVoltageId: UUID? = null,
    val nominalVoltage: String
)

data class UpdateBaseVoltageEvent(
    @Id val baseVoltageId: UUID? = null,
    val nominalVoltage: String
)

data class DeleteBaseVoltageEvent(@Id val baseVoltageId: UUID? = null)

// single association events

// multiple association events


// BasicIntervalSchedule Events

data class CreateBasicIntervalScheduleEvent(
    @Id val basicIntervalScheduleId: UUID? = null,
    val startTime: String,
    val value1Unit: String,
    val value2Unit: String
)

data class UpdateBasicIntervalScheduleEvent(
    @Id val basicIntervalScheduleId: UUID? = null,
    val startTime: String,
    val value1Unit: String,
    val value2Unit: String
)

data class DeleteBasicIntervalScheduleEvent(@Id val basicIntervalScheduleId: UUID? = null)

// single association events

// multiple association events


// Bay Events

data class CreateBayEvent(
     val bayId: UUID? = null
)

data class UpdateBayEvent(
     val bayId: UUID? = null
)

data class DeleteBayEvent(@Id val bayId: UUID? = null)

// single association events

// multiple association events


// BooleanProxy Events

data class CreateBooleanProxyEvent(
     val booleanProxyId: UUID? = null
)

data class UpdateBooleanProxyEvent(
     val booleanProxyId: UUID? = null
)

data class DeleteBooleanProxyEvent(@Id val booleanProxyId: UUID? = null)

// single association events

// multiple association events


// BoundaryExtensions Events

data class CreateBoundaryExtensionsEvent(
    @Id val boundaryExtensionsId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class UpdateBoundaryExtensionsEvent(
    @Id val boundaryExtensionsId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class DeleteBoundaryExtensionsEvent(@Id val boundaryExtensionsId: UUID? = null)

// single association events

// multiple association events


// Breaker Events

data class CreateBreakerEvent(
     val breakerId: UUID? = null
)

data class UpdateBreakerEvent(
     val breakerId: UUID? = null
)

data class DeleteBreakerEvent(@Id val breakerId: UUID? = null)

// single association events

// multiple association events


// BusNameMarker Events

data class CreateBusNameMarkerEvent(
    @Id val busNameMarkerId: UUID? = null,
    val priority: String
)

data class UpdateBusNameMarkerEvent(
    @Id val busNameMarkerId: UUID? = null,
    val priority: String
)

data class DeleteBusNameMarkerEvent(@Id val busNameMarkerId: UUID? = null)

// single association events

// multiple association events


// BusbarSection Events

data class CreateBusbarSectionEvent(
    @Id val busbarSectionId: UUID? = null,
    val ipMax: String
)

data class UpdateBusbarSectionEvent(
    @Id val busbarSectionId: UUID? = null,
    val ipMax: String
)

data class DeleteBusbarSectionEvent(@Id val busbarSectionId: UUID? = null)

// single association events

// multiple association events


// Capacitance Events

data class CreateCapacitanceEvent(
    @Id val capacitanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateCapacitanceEvent(
    @Id val capacitanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteCapacitanceEvent(@Id val capacitanceId: UUID? = null)

// single association events

// multiple association events


// CapacitancePerLength Events

data class CreateCapacitancePerLengthEvent(
    @Id val capacitancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateCapacitancePerLengthEvent(
    @Id val capacitancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteCapacitancePerLengthEvent(@Id val capacitancePerLengthId: UUID? = null)

// single association events

// multiple association events


// Command Events

data class CreateCommandEvent(
    @Id val commandId: UUID? = null,
    val normalValue: String,
    val value: String
)

data class UpdateCommandEvent(
    @Id val commandId: UUID? = null,
    val normalValue: String,
    val value: String
)

data class DeleteCommandEvent(@Id val commandId: UUID? = null)

// single association events

// multiple association events


// Conductance Events

data class CreateConductanceEvent(
    @Id val conductanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateConductanceEvent(
    @Id val conductanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteConductanceEvent(@Id val conductanceId: UUID? = null)

// single association events

// multiple association events


// ConductingEquipment Events

data class CreateConductingEquipmentEvent(
     val conductingEquipmentId: UUID? = null
)

data class UpdateConductingEquipmentEvent(
     val conductingEquipmentId: UUID? = null
)

data class DeleteConductingEquipmentEvent(@Id val conductingEquipmentId: UUID? = null)

// single association events

// multiple association events


// Conductor Events

data class CreateConductorEvent(
    @Id val conductorId: UUID? = null,
    val length: String
)

data class UpdateConductorEvent(
    @Id val conductorId: UUID? = null,
    val length: String
)

data class DeleteConductorEvent(@Id val conductorId: UUID? = null)

// single association events

// multiple association events


// ConformLoad Events

data class CreateConformLoadEvent(
     val conformLoadId: UUID? = null
)

data class UpdateConformLoadEvent(
     val conformLoadId: UUID? = null
)

data class DeleteConformLoadEvent(@Id val conformLoadId: UUID? = null)

// single association events

// multiple association events


// ConformLoadGroup Events

data class CreateConformLoadGroupEvent(
     val conformLoadGroupId: UUID? = null
)

data class UpdateConformLoadGroupEvent(
     val conformLoadGroupId: UUID? = null
)

data class DeleteConformLoadGroupEvent(@Id val conformLoadGroupId: UUID? = null)

// single association events

// multiple association events


// ConformLoadSchedule Events

data class CreateConformLoadScheduleEvent(
     val conformLoadScheduleId: UUID? = null
)

data class UpdateConformLoadScheduleEvent(
     val conformLoadScheduleId: UUID? = null
)

data class DeleteConformLoadScheduleEvent(@Id val conformLoadScheduleId: UUID? = null)

// single association events

// multiple association events


// ConnectivityNode Events

data class CreateConnectivityNodeEvent(
    @Id val connectivityNodeId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class UpdateConnectivityNodeEvent(
    @Id val connectivityNodeId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class DeleteConnectivityNodeEvent(@Id val connectivityNodeId: UUID? = null)

// single association events

// multiple association events


// ConnectivityNodeContainer Events

data class CreateConnectivityNodeContainerEvent(
     val connectivityNodeContainerId: UUID? = null
)

data class UpdateConnectivityNodeContainerEvent(
     val connectivityNodeContainerId: UUID? = null
)

data class DeleteConnectivityNodeContainerEvent(@Id val connectivityNodeContainerId: UUID? = null)

// single association events

// multiple association events


// Connector Events

data class CreateConnectorEvent(
     val connectorId: UUID? = null
)

data class UpdateConnectorEvent(
     val connectorId: UUID? = null
)

data class DeleteConnectorEvent(@Id val connectorId: UUID? = null)

// single association events

// multiple association events


// Control Events

data class CreateControlEvent(
    @Id val controlId: UUID? = null,
    val controlType: String,
    val operationInProgress: String,
    val timeStamp: String,
    val unitMultiplier: String,
    val unitSymbol: String
)

data class UpdateControlEvent(
    @Id val controlId: UUID? = null,
    val controlType: String,
    val operationInProgress: String,
    val timeStamp: String,
    val unitMultiplier: String,
    val unitSymbol: String
)

data class DeleteControlEvent(@Id val controlId: UUID? = null)

// single association events

// multiple association events


// ControlArea Events

data class CreateControlAreaEvent(
    @Id val controlAreaId: UUID? = null,
    val type: String
)

data class UpdateControlAreaEvent(
    @Id val controlAreaId: UUID? = null,
    val type: String
)

data class DeleteControlAreaEvent(@Id val controlAreaId: UUID? = null)

// single association events

// multiple association events


// ControlAreaGeneratingUnit Events

data class CreateControlAreaGeneratingUnitEvent(
     val controlAreaGeneratingUnitId: UUID? = null
)

data class UpdateControlAreaGeneratingUnitEvent(
     val controlAreaGeneratingUnitId: UUID? = null
)

data class DeleteControlAreaGeneratingUnitEvent(@Id val controlAreaGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// CoordinateSystem Events

data class CreateCoordinateSystemEvent(
    @Id val coordinateSystemId: UUID? = null,
    val crsUrn: String
)

data class UpdateCoordinateSystemEvent(
    @Id val coordinateSystemId: UUID? = null,
    val crsUrn: String
)

data class DeleteCoordinateSystemEvent(@Id val coordinateSystemId: UUID? = null)

// single association events

// multiple association events


// CsConverter Events

data class CreateCsConverterEvent(
    @Id val csConverterId: UUID? = null,
    val maxAlpha: String,
    val maxGamma: String,
    val maxIdc: String,
    val minAlpha: String,
    val minGamma: String,
    val minIdc: String,
    val ratedIdc: String
)

data class UpdateCsConverterEvent(
    @Id val csConverterId: UUID? = null,
    val maxAlpha: String,
    val maxGamma: String,
    val maxIdc: String,
    val minAlpha: String,
    val minGamma: String,
    val minIdc: String,
    val ratedIdc: String
)

data class DeleteCsConverterEvent(@Id val csConverterId: UUID? = null)

// single association events

// multiple association events


// CurrentFlow Events

data class CreateCurrentFlowEvent(
    @Id val currentFlowId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateCurrentFlowEvent(
    @Id val currentFlowId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteCurrentFlowEvent(@Id val currentFlowId: UUID? = null)

// single association events

// multiple association events


// CurrentLimit Events

data class CreateCurrentLimitEvent(
    @Id val currentLimitId: UUID? = null,
    val value: String
)

data class UpdateCurrentLimitEvent(
    @Id val currentLimitId: UUID? = null,
    val value: String
)

data class DeleteCurrentLimitEvent(@Id val currentLimitId: UUID? = null)

// single association events

// multiple association events


// Curve Events

data class CreateCurveEvent(
    @Id val curveId: UUID? = null,
    val curveStyle: String,
    val xUnit: String,
    val y1Unit: String,
    val y2Unit: String
)

data class UpdateCurveEvent(
    @Id val curveId: UUID? = null,
    val curveStyle: String,
    val xUnit: String,
    val y1Unit: String,
    val y2Unit: String
)

data class DeleteCurveEvent(@Id val curveId: UUID? = null)

// single association events

// multiple association events


// CurveData Events

data class CreateCurveDataEvent(
    @Id val curveDataId: UUID? = null,
    val xvalue: String,
    val y1value: String,
    val y2value: String
)

data class UpdateCurveDataEvent(
    @Id val curveDataId: UUID? = null,
    val xvalue: String,
    val y1value: String,
    val y2value: String
)

data class DeleteCurveDataEvent(@Id val curveDataId: UUID? = null)

// single association events

// multiple association events


// DCBaseTerminal Events

data class CreateDCBaseTerminalEvent(
     val dCBaseTerminalId: UUID? = null
)

data class UpdateDCBaseTerminalEvent(
     val dCBaseTerminalId: UUID? = null
)

data class DeleteDCBaseTerminalEvent(@Id val dCBaseTerminalId: UUID? = null)

// single association events

// multiple association events


// DCBreaker Events

data class CreateDCBreakerEvent(
     val dCBreakerId: UUID? = null
)

data class UpdateDCBreakerEvent(
     val dCBreakerId: UUID? = null
)

data class DeleteDCBreakerEvent(@Id val dCBreakerId: UUID? = null)

// single association events

// multiple association events


// DCBusbar Events

data class CreateDCBusbarEvent(
     val dCBusbarId: UUID? = null
)

data class UpdateDCBusbarEvent(
     val dCBusbarId: UUID? = null
)

data class DeleteDCBusbarEvent(@Id val dCBusbarId: UUID? = null)

// single association events

// multiple association events


// DCChopper Events

data class CreateDCChopperEvent(
     val dCChopperId: UUID? = null
)

data class UpdateDCChopperEvent(
     val dCChopperId: UUID? = null
)

data class DeleteDCChopperEvent(@Id val dCChopperId: UUID? = null)

// single association events

// multiple association events


// DCConductingEquipment Events

data class CreateDCConductingEquipmentEvent(
     val dCConductingEquipmentId: UUID? = null
)

data class UpdateDCConductingEquipmentEvent(
     val dCConductingEquipmentId: UUID? = null
)

data class DeleteDCConductingEquipmentEvent(@Id val dCConductingEquipmentId: UUID? = null)

// single association events

// multiple association events


// DCConverterUnit Events

data class CreateDCConverterUnitEvent(
    @Id val dCConverterUnitId: UUID? = null,
    val operationMode: String
)

data class UpdateDCConverterUnitEvent(
    @Id val dCConverterUnitId: UUID? = null,
    val operationMode: String
)

data class DeleteDCConverterUnitEvent(@Id val dCConverterUnitId: UUID? = null)

// single association events

// multiple association events


// DCDisconnector Events

data class CreateDCDisconnectorEvent(
     val dCDisconnectorId: UUID? = null
)

data class UpdateDCDisconnectorEvent(
     val dCDisconnectorId: UUID? = null
)

data class DeleteDCDisconnectorEvent(@Id val dCDisconnectorId: UUID? = null)

// single association events

// multiple association events


// DCEquipmentContainer Events

data class CreateDCEquipmentContainerEvent(
     val dCEquipmentContainerId: UUID? = null
)

data class UpdateDCEquipmentContainerEvent(
     val dCEquipmentContainerId: UUID? = null
)

data class DeleteDCEquipmentContainerEvent(@Id val dCEquipmentContainerId: UUID? = null)

// single association events

// multiple association events


// DCGround Events

data class CreateDCGroundEvent(
    @Id val dCGroundId: UUID? = null,
    val inductance: String,
    val r: String
)

data class UpdateDCGroundEvent(
    @Id val dCGroundId: UUID? = null,
    val inductance: String,
    val r: String
)

data class DeleteDCGroundEvent(@Id val dCGroundId: UUID? = null)

// single association events

// multiple association events


// DCLine Events

data class CreateDCLineEvent(
     val dCLineId: UUID? = null
)

data class UpdateDCLineEvent(
     val dCLineId: UUID? = null
)

data class DeleteDCLineEvent(@Id val dCLineId: UUID? = null)

// single association events

// multiple association events


// DCLineSegment Events

data class CreateDCLineSegmentEvent(
    @Id val dCLineSegmentId: UUID? = null,
    val capacitance: String,
    val inductance: String,
    val length: String,
    val resistance: String
)

data class UpdateDCLineSegmentEvent(
    @Id val dCLineSegmentId: UUID? = null,
    val capacitance: String,
    val inductance: String,
    val length: String,
    val resistance: String
)

data class DeleteDCLineSegmentEvent(@Id val dCLineSegmentId: UUID? = null)

// single association events

// multiple association events


// DCNode Events

data class CreateDCNodeEvent(
     val dCNodeId: UUID? = null
)

data class UpdateDCNodeEvent(
     val dCNodeId: UUID? = null
)

data class DeleteDCNodeEvent(@Id val dCNodeId: UUID? = null)

// single association events

// multiple association events


// DCSeriesDevice Events

data class CreateDCSeriesDeviceEvent(
    @Id val dCSeriesDeviceId: UUID? = null,
    val inductance: String,
    val ratedUdc: String,
    val resistance: String
)

data class UpdateDCSeriesDeviceEvent(
    @Id val dCSeriesDeviceId: UUID? = null,
    val inductance: String,
    val ratedUdc: String,
    val resistance: String
)

data class DeleteDCSeriesDeviceEvent(@Id val dCSeriesDeviceId: UUID? = null)

// single association events

// multiple association events


// DCShunt Events

data class CreateDCShuntEvent(
    @Id val dCShuntId: UUID? = null,
    val capacitance: String,
    val ratedUdc: String,
    val resistance: String
)

data class UpdateDCShuntEvent(
    @Id val dCShuntId: UUID? = null,
    val capacitance: String,
    val ratedUdc: String,
    val resistance: String
)

data class DeleteDCShuntEvent(@Id val dCShuntId: UUID? = null)

// single association events

// multiple association events


// DCSwitch Events

data class CreateDCSwitchEvent(
     val dCSwitchId: UUID? = null
)

data class UpdateDCSwitchEvent(
     val dCSwitchId: UUID? = null
)

data class DeleteDCSwitchEvent(@Id val dCSwitchId: UUID? = null)

// single association events

// multiple association events


// DCTerminal Events

data class CreateDCTerminalEvent(
     val dCTerminalId: UUID? = null
)

data class UpdateDCTerminalEvent(
     val dCTerminalId: UUID? = null
)

data class DeleteDCTerminalEvent(@Id val dCTerminalId: UUID? = null)

// single association events

// multiple association events


// DCTopologicalIsland Events

data class CreateDCTopologicalIslandEvent(
     val dCTopologicalIslandId: UUID? = null
)

data class UpdateDCTopologicalIslandEvent(
     val dCTopologicalIslandId: UUID? = null
)

data class DeleteDCTopologicalIslandEvent(@Id val dCTopologicalIslandId: UUID? = null)

// single association events

// multiple association events


// DCTopologicalNode Events

data class CreateDCTopologicalNodeEvent(
     val dCTopologicalNodeId: UUID? = null
)

data class UpdateDCTopologicalNodeEvent(
     val dCTopologicalNodeId: UUID? = null
)

data class DeleteDCTopologicalNodeEvent(@Id val dCTopologicalNodeId: UUID? = null)

// single association events

// multiple association events


// DateProxy Events

data class CreateDateProxyEvent(
     val dateProxyId: UUID? = null
)

data class UpdateDateProxyEvent(
     val dateProxyId: UUID? = null
)

data class DeleteDateProxyEvent(@Id val dateProxyId: UUID? = null)

// single association events

// multiple association events


// DateTime Events

data class CreateDateTimeEvent(
     val dateTimeId: UUID? = null
)

data class UpdateDateTimeEvent(
     val dateTimeId: UUID? = null
)

data class DeleteDateTimeEvent(@Id val dateTimeId: UUID? = null)

// single association events

// multiple association events


// DayType Events

data class CreateDayTypeEvent(
     val dayTypeId: UUID? = null
)

data class UpdateDayTypeEvent(
     val dayTypeId: UUID? = null
)

data class DeleteDayTypeEvent(@Id val dayTypeId: UUID? = null)

// single association events

// multiple association events


// DecimalProxy Events

data class CreateDecimalProxyEvent(
     val decimalProxyId: UUID? = null
)

data class UpdateDecimalProxyEvent(
     val decimalProxyId: UUID? = null
)

data class DeleteDecimalProxyEvent(@Id val decimalProxyId: UUID? = null)

// single association events

// multiple association events


// Diagram Events

data class CreateDiagramEvent(
    @Id val diagramId: UUID? = null,
    val orientation: String,
    val x1InitialView: String,
    val x2InitialView: String,
    val y1InitialView: String,
    val y2InitialView: String
)

data class UpdateDiagramEvent(
    @Id val diagramId: UUID? = null,
    val orientation: String,
    val x1InitialView: String,
    val x2InitialView: String,
    val y1InitialView: String,
    val y2InitialView: String
)

data class DeleteDiagramEvent(@Id val diagramId: UUID? = null)

// single association events

// multiple association events


// DiagramLayoutVersion Events

data class CreateDiagramLayoutVersionEvent(
    @Id val diagramLayoutVersionId: UUID? = null,
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

data class UpdateDiagramLayoutVersionEvent(
    @Id val diagramLayoutVersionId: UUID? = null,
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

data class DeleteDiagramLayoutVersionEvent(@Id val diagramLayoutVersionId: UUID? = null)

// single association events

// multiple association events


// DiagramObject Events

data class CreateDiagramObjectEvent(
    @Id val diagramObjectId: UUID? = null,
    val drawingOrder: String,
    val isPolygon: String,
    val offsetX: String,
    val offsetY: String,
    val rotation: String
)

data class UpdateDiagramObjectEvent(
    @Id val diagramObjectId: UUID? = null,
    val drawingOrder: String,
    val isPolygon: String,
    val offsetX: String,
    val offsetY: String,
    val rotation: String
)

data class DeleteDiagramObjectEvent(@Id val diagramObjectId: UUID? = null)

// single association events

// multiple association events


// DiagramObjectGluePoint Events

data class CreateDiagramObjectGluePointEvent(
     val diagramObjectGluePointId: UUID? = null
)

data class UpdateDiagramObjectGluePointEvent(
     val diagramObjectGluePointId: UUID? = null
)

data class DeleteDiagramObjectGluePointEvent(@Id val diagramObjectGluePointId: UUID? = null)

// single association events

// multiple association events


// DiagramObjectPoint Events

data class CreateDiagramObjectPointEvent(
    @Id val diagramObjectPointId: UUID? = null,
    val sequenceNumber: String,
    val xPosition: String,
    val yPosition: String,
    val zPosition: String
)

data class UpdateDiagramObjectPointEvent(
    @Id val diagramObjectPointId: UUID? = null,
    val sequenceNumber: String,
    val xPosition: String,
    val yPosition: String,
    val zPosition: String
)

data class DeleteDiagramObjectPointEvent(@Id val diagramObjectPointId: UUID? = null)

// single association events

// multiple association events


// DiagramObjectStyle Events

data class CreateDiagramObjectStyleEvent(
     val diagramObjectStyleId: UUID? = null
)

data class UpdateDiagramObjectStyleEvent(
     val diagramObjectStyleId: UUID? = null
)

data class DeleteDiagramObjectStyleEvent(@Id val diagramObjectStyleId: UUID? = null)

// single association events

// multiple association events


// DiagramStyle Events

data class CreateDiagramStyleEvent(
     val diagramStyleId: UUID? = null
)

data class UpdateDiagramStyleEvent(
     val diagramStyleId: UUID? = null
)

data class DeleteDiagramStyleEvent(@Id val diagramStyleId: UUID? = null)

// single association events

// multiple association events


// DiscExcContIEEEDEC1A Events

data class CreateDiscExcContIEEEDEC1AEvent(
    @Id val discExcContIEEEDEC1AId: UUID? = null,
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

data class UpdateDiscExcContIEEEDEC1AEvent(
    @Id val discExcContIEEEDEC1AId: UUID? = null,
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

data class DeleteDiscExcContIEEEDEC1AEvent(@Id val discExcContIEEEDEC1AId: UUID? = null)

// single association events

// multiple association events


// DiscExcContIEEEDEC2A Events

data class CreateDiscExcContIEEEDEC2AEvent(
    @Id val discExcContIEEEDEC2AId: UUID? = null,
    val td1: String,
    val td2: String,
    val vdmax: String,
    val vdmin: String,
    val vk: String
)

data class UpdateDiscExcContIEEEDEC2AEvent(
    @Id val discExcContIEEEDEC2AId: UUID? = null,
    val td1: String,
    val td2: String,
    val vdmax: String,
    val vdmin: String,
    val vk: String
)

data class DeleteDiscExcContIEEEDEC2AEvent(@Id val discExcContIEEEDEC2AId: UUID? = null)

// single association events

// multiple association events


// DiscExcContIEEEDEC3A Events

data class CreateDiscExcContIEEEDEC3AEvent(
    @Id val discExcContIEEEDEC3AId: UUID? = null,
    val tdr: String,
    val vtmin: String
)

data class UpdateDiscExcContIEEEDEC3AEvent(
    @Id val discExcContIEEEDEC3AId: UUID? = null,
    val tdr: String,
    val vtmin: String
)

data class DeleteDiscExcContIEEEDEC3AEvent(@Id val discExcContIEEEDEC3AId: UUID? = null)

// single association events

// multiple association events


// Disconnector Events

data class CreateDisconnectorEvent(
     val disconnectorId: UUID? = null
)

data class UpdateDisconnectorEvent(
     val disconnectorId: UUID? = null
)

data class DeleteDisconnectorEvent(@Id val disconnectorId: UUID? = null)

// single association events

// multiple association events


// DiscontinuousExcitationControlDynamics Events

data class CreateDiscontinuousExcitationControlDynamicsEvent(
     val discontinuousExcitationControlDynamicsId: UUID? = null
)

data class UpdateDiscontinuousExcitationControlDynamicsEvent(
     val discontinuousExcitationControlDynamicsId: UUID? = null
)

data class DeleteDiscontinuousExcitationControlDynamicsEvent(@Id val discontinuousExcitationControlDynamicsId: UUID? = null)

// single association events

// multiple association events


// DiscontinuousExcitationControlUserDefined Events

data class CreateDiscontinuousExcitationControlUserDefinedEvent(
    @Id val discontinuousExcitationControlUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateDiscontinuousExcitationControlUserDefinedEvent(
    @Id val discontinuousExcitationControlUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteDiscontinuousExcitationControlUserDefinedEvent(@Id val discontinuousExcitationControlUserDefinedId: UUID? = null)

// single association events

// multiple association events


// Discrete Events

data class CreateDiscreteEvent(
     val discreteId: UUID? = null
)

data class UpdateDiscreteEvent(
     val discreteId: UUID? = null
)

data class DeleteDiscreteEvent(@Id val discreteId: UUID? = null)

// single association events

// multiple association events


// DiscreteValue Events

data class CreateDiscreteValueEvent(
    @Id val discreteValueId: UUID? = null,
    val value: String
)

data class UpdateDiscreteValueEvent(
    @Id val discreteValueId: UUID? = null,
    val value: String
)

data class DeleteDiscreteValueEvent(@Id val discreteValueId: UUID? = null)

// single association events

// multiple association events


// DomainVersion Events

data class CreateDomainVersionEvent(
    @Id val domainVersionId: UUID? = null,
    val baseUML: String,
    val date: String,
    val entsoeUML: String,
    val version: String
)

data class UpdateDomainVersionEvent(
    @Id val domainVersionId: UUID? = null,
    val baseUML: String,
    val date: String,
    val entsoeUML: String,
    val version: String
)

data class DeleteDomainVersionEvent(@Id val domainVersionId: UUID? = null)

// single association events

// multiple association events


// DynamicsFunctionBlock Events

data class CreateDynamicsFunctionBlockEvent(
    @Id val dynamicsFunctionBlockId: UUID? = null,
    val enabled: String
)

data class UpdateDynamicsFunctionBlockEvent(
    @Id val dynamicsFunctionBlockId: UUID? = null,
    val enabled: String
)

data class DeleteDynamicsFunctionBlockEvent(@Id val dynamicsFunctionBlockId: UUID? = null)

// single association events

// multiple association events


// DynamicsVersion Events

data class CreateDynamicsVersionEvent(
    @Id val dynamicsVersionId: UUID? = null,
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

data class UpdateDynamicsVersionEvent(
    @Id val dynamicsVersionId: UUID? = null,
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

data class DeleteDynamicsVersionEvent(@Id val dynamicsVersionId: UUID? = null)

// single association events

// multiple association events


// Dynamicsmodel Events

data class CreateDynamicsmodelEvent(
     val dynamicsmodelId: UUID? = null
)

data class UpdateDynamicsmodelEvent(
     val dynamicsmodelId: UUID? = null
)

data class DeleteDynamicsmodelEvent(@Id val dynamicsmodelId: UUID? = null)

// single association events

// multiple association events


// ENTSOEConnectivityNode Events

data class CreateENTSOEConnectivityNodeEvent(
     val eNTSOEConnectivityNodeId: UUID? = null
)

data class UpdateENTSOEConnectivityNodeEvent(
     val eNTSOEConnectivityNodeId: UUID? = null
)

data class DeleteENTSOEConnectivityNodeEvent(@Id val eNTSOEConnectivityNodeId: UUID? = null)

// single association events

// multiple association events


// ENTSOEIdentifiedObject Events

data class CreateENTSOEIdentifiedObjectEvent(
    @Id val eNTSOEIdentifiedObjectId: UUID? = null,
    val energyIdentCodeEic: String,
    val shortName: String
)

data class UpdateENTSOEIdentifiedObjectEvent(
    @Id val eNTSOEIdentifiedObjectId: UUID? = null,
    val energyIdentCodeEic: String,
    val shortName: String
)

data class DeleteENTSOEIdentifiedObjectEvent(@Id val eNTSOEIdentifiedObjectId: UUID? = null)

// single association events

// multiple association events


// ENTSOEJunction Events

data class CreateENTSOEJunctionEvent(
     val eNTSOEJunctionId: UUID? = null
)

data class UpdateENTSOEJunctionEvent(
     val eNTSOEJunctionId: UUID? = null
)

data class DeleteENTSOEJunctionEvent(@Id val eNTSOEJunctionId: UUID? = null)

// single association events

// multiple association events


// ENTSOEOperationalLimitType Events

data class CreateENTSOEOperationalLimitTypeEvent(
    @Id val eNTSOEOperationalLimitTypeId: UUID? = null,
    val limitType: String
)

data class UpdateENTSOEOperationalLimitTypeEvent(
    @Id val eNTSOEOperationalLimitTypeId: UUID? = null,
    val limitType: String
)

data class DeleteENTSOEOperationalLimitTypeEvent(@Id val eNTSOEOperationalLimitTypeId: UUID? = null)

// single association events

// multiple association events


// ENTSOETopologicalNode Events

data class CreateENTSOETopologicalNodeEvent(
     val eNTSOETopologicalNodeId: UUID? = null
)

data class UpdateENTSOETopologicalNodeEvent(
     val eNTSOETopologicalNodeId: UUID? = null
)

data class DeleteENTSOETopologicalNodeEvent(@Id val eNTSOETopologicalNodeId: UUID? = null)

// single association events

// multiple association events


// EarthFaultCompensator Events

data class CreateEarthFaultCompensatorEvent(
    @Id val earthFaultCompensatorId: UUID? = null,
    val r: String
)

data class UpdateEarthFaultCompensatorEvent(
    @Id val earthFaultCompensatorId: UUID? = null,
    val r: String
)

data class DeleteEarthFaultCompensatorEvent(@Id val earthFaultCompensatorId: UUID? = null)

// single association events

// multiple association events


// EnergyArea Events

data class CreateEnergyAreaEvent(
     val energyAreaId: UUID? = null
)

data class UpdateEnergyAreaEvent(
     val energyAreaId: UUID? = null
)

data class DeleteEnergyAreaEvent(@Id val energyAreaId: UUID? = null)

// single association events

// multiple association events


// EnergyConsumer Events

data class CreateEnergyConsumerEvent(
    @Id val energyConsumerId: UUID? = null,
    val pfixed: String,
    val pfixedPct: String,
    val qfixed: String,
    val qfixedPct: String
)

data class UpdateEnergyConsumerEvent(
    @Id val energyConsumerId: UUID? = null,
    val pfixed: String,
    val pfixedPct: String,
    val qfixed: String,
    val qfixedPct: String
)

data class DeleteEnergyConsumerEvent(@Id val energyConsumerId: UUID? = null)

// single association events

// multiple association events


// EnergySchedulingType Events

data class CreateEnergySchedulingTypeEvent(
     val energySchedulingTypeId: UUID? = null
)

data class UpdateEnergySchedulingTypeEvent(
     val energySchedulingTypeId: UUID? = null
)

data class DeleteEnergySchedulingTypeEvent(@Id val energySchedulingTypeId: UUID? = null)

// single association events

// multiple association events


// EnergySource Events

data class CreateEnergySourceEvent(
     val energySourceId: UUID? = null
)

data class UpdateEnergySourceEvent(
     val energySourceId: UUID? = null
)

data class DeleteEnergySourceEvent(@Id val energySourceId: UUID? = null)

// single association events

// multiple association events


// Equipment Events

data class CreateEquipmentEvent(
     val equipmentId: UUID? = null
)

data class UpdateEquipmentEvent(
     val equipmentId: UUID? = null
)

data class DeleteEquipmentEvent(@Id val equipmentId: UUID? = null)

// single association events

// multiple association events


// EquipmentBoundaryVersion Events

data class CreateEquipmentBoundaryVersionEvent(
    @Id val equipmentBoundaryVersionId: UUID? = null,
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

data class UpdateEquipmentBoundaryVersionEvent(
    @Id val equipmentBoundaryVersionId: UUID? = null,
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

data class DeleteEquipmentBoundaryVersionEvent(@Id val equipmentBoundaryVersionId: UUID? = null)

// single association events

// multiple association events


// EquipmentContainer Events

data class CreateEquipmentContainerEvent(
     val equipmentContainerId: UUID? = null
)

data class UpdateEquipmentContainerEvent(
     val equipmentContainerId: UUID? = null
)

data class DeleteEquipmentContainerEvent(@Id val equipmentContainerId: UUID? = null)

// single association events

// multiple association events


// EquipmentVersion Events

data class CreateEquipmentVersionEvent(
    @Id val equipmentVersionId: UUID? = null,
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

data class UpdateEquipmentVersionEvent(
    @Id val equipmentVersionId: UUID? = null,
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

data class DeleteEquipmentVersionEvent(@Id val equipmentVersionId: UUID? = null)

// single association events

// multiple association events


// EquivalentBranch Events

data class CreateEquivalentBranchEvent(
    @Id val equivalentBranchId: UUID? = null,
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

data class UpdateEquivalentBranchEvent(
    @Id val equivalentBranchId: UUID? = null,
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

data class DeleteEquivalentBranchEvent(@Id val equivalentBranchId: UUID? = null)

// single association events

// multiple association events


// EquivalentEquipment Events

data class CreateEquivalentEquipmentEvent(
     val equivalentEquipmentId: UUID? = null
)

data class UpdateEquivalentEquipmentEvent(
     val equivalentEquipmentId: UUID? = null
)

data class DeleteEquivalentEquipmentEvent(@Id val equivalentEquipmentId: UUID? = null)

// single association events

// multiple association events


// EquivalentInjection Events

data class CreateEquivalentInjectionEvent(
    @Id val equivalentInjectionId: UUID? = null,
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

data class UpdateEquivalentInjectionEvent(
    @Id val equivalentInjectionId: UUID? = null,
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

data class DeleteEquivalentInjectionEvent(@Id val equivalentInjectionId: UUID? = null)

// single association events

// multiple association events


// EquivalentNetwork Events

data class CreateEquivalentNetworkEvent(
     val equivalentNetworkId: UUID? = null
)

data class UpdateEquivalentNetworkEvent(
     val equivalentNetworkId: UUID? = null
)

data class DeleteEquivalentNetworkEvent(@Id val equivalentNetworkId: UUID? = null)

// single association events

// multiple association events


// EquivalentShunt Events

data class CreateEquivalentShuntEvent(
    @Id val equivalentShuntId: UUID? = null,
    val b: String,
    val g: String
)

data class UpdateEquivalentShuntEvent(
    @Id val equivalentShuntId: UUID? = null,
    val b: String,
    val g: String
)

data class DeleteEquivalentShuntEvent(@Id val equivalentShuntId: UUID? = null)

// single association events

// multiple association events


// ExcAC1A Events

data class CreateExcAC1AEvent(
    @Id val excAC1AId: UUID? = null,
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

data class UpdateExcAC1AEvent(
    @Id val excAC1AId: UUID? = null,
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

data class DeleteExcAC1AEvent(@Id val excAC1AId: UUID? = null)

// single association events

// multiple association events


// ExcAC2A Events

data class CreateExcAC2AEvent(
    @Id val excAC2AId: UUID? = null,
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

data class UpdateExcAC2AEvent(
    @Id val excAC2AId: UUID? = null,
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

data class DeleteExcAC2AEvent(@Id val excAC2AId: UUID? = null)

// single association events

// multiple association events


// ExcAC3A Events

data class CreateExcAC3AEvent(
    @Id val excAC3AId: UUID? = null,
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

data class UpdateExcAC3AEvent(
    @Id val excAC3AId: UUID? = null,
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

data class DeleteExcAC3AEvent(@Id val excAC3AId: UUID? = null)

// single association events

// multiple association events


// ExcAC4A Events

data class CreateExcAC4AEvent(
    @Id val excAC4AId: UUID? = null,
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

data class UpdateExcAC4AEvent(
    @Id val excAC4AId: UUID? = null,
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

data class DeleteExcAC4AEvent(@Id val excAC4AId: UUID? = null)

// single association events

// multiple association events


// ExcAC5A Events

data class CreateExcAC5AEvent(
    @Id val excAC5AId: UUID? = null,
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

data class UpdateExcAC5AEvent(
    @Id val excAC5AId: UUID? = null,
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

data class DeleteExcAC5AEvent(@Id val excAC5AId: UUID? = null)

// single association events

// multiple association events


// ExcAC6A Events

data class CreateExcAC6AEvent(
    @Id val excAC6AId: UUID? = null,
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

data class UpdateExcAC6AEvent(
    @Id val excAC6AId: UUID? = null,
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

data class DeleteExcAC6AEvent(@Id val excAC6AId: UUID? = null)

// single association events

// multiple association events


// ExcAC8B Events

data class CreateExcAC8BEvent(
    @Id val excAC8BId: UUID? = null,
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

data class UpdateExcAC8BEvent(
    @Id val excAC8BId: UUID? = null,
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

data class DeleteExcAC8BEvent(@Id val excAC8BId: UUID? = null)

// single association events

// multiple association events


// ExcANS Events

data class CreateExcANSEvent(
    @Id val excANSId: UUID? = null,
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

data class UpdateExcANSEvent(
    @Id val excANSId: UUID? = null,
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

data class DeleteExcANSEvent(@Id val excANSId: UUID? = null)

// single association events

// multiple association events


// ExcAVR1 Events

data class CreateExcAVR1Event(
    @Id val excAVR1Id: UUID? = null,
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

data class UpdateExcAVR1Event(
    @Id val excAVR1Id: UUID? = null,
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

data class DeleteExcAVR1Event(@Id val excAVR1Id: UUID? = null)

// single association events

// multiple association events


// ExcAVR2 Events

data class CreateExcAVR2Event(
    @Id val excAVR2Id: UUID? = null,
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

data class UpdateExcAVR2Event(
    @Id val excAVR2Id: UUID? = null,
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

data class DeleteExcAVR2Event(@Id val excAVR2Id: UUID? = null)

// single association events

// multiple association events


// ExcAVR3 Events

data class CreateExcAVR3Event(
    @Id val excAVR3Id: UUID? = null,
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

data class UpdateExcAVR3Event(
    @Id val excAVR3Id: UUID? = null,
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

data class DeleteExcAVR3Event(@Id val excAVR3Id: UUID? = null)

// single association events

// multiple association events


// ExcAVR4 Events

data class CreateExcAVR4Event(
    @Id val excAVR4Id: UUID? = null,
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

data class UpdateExcAVR4Event(
    @Id val excAVR4Id: UUID? = null,
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

data class DeleteExcAVR4Event(@Id val excAVR4Id: UUID? = null)

// single association events

// multiple association events


// ExcAVR5 Events

data class CreateExcAVR5Event(
    @Id val excAVR5Id: UUID? = null,
    val ka: String,
    val rex: String,
    val ta: String
)

data class UpdateExcAVR5Event(
    @Id val excAVR5Id: UUID? = null,
    val ka: String,
    val rex: String,
    val ta: String
)

data class DeleteExcAVR5Event(@Id val excAVR5Id: UUID? = null)

// single association events

// multiple association events


// ExcAVR7 Events

data class CreateExcAVR7Event(
    @Id val excAVR7Id: UUID? = null,
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

data class UpdateExcAVR7Event(
    @Id val excAVR7Id: UUID? = null,
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

data class DeleteExcAVR7Event(@Id val excAVR7Id: UUID? = null)

// single association events

// multiple association events


// ExcBBC Events

data class CreateExcBBCEvent(
    @Id val excBBCId: UUID? = null,
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

data class UpdateExcBBCEvent(
    @Id val excBBCId: UUID? = null,
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

data class DeleteExcBBCEvent(@Id val excBBCId: UUID? = null)

// single association events

// multiple association events


// ExcCZ Events

data class CreateExcCZEvent(
    @Id val excCZId: UUID? = null,
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

data class UpdateExcCZEvent(
    @Id val excCZId: UUID? = null,
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

data class DeleteExcCZEvent(@Id val excCZId: UUID? = null)

// single association events

// multiple association events


// ExcDC1A Events

data class CreateExcDC1AEvent(
    @Id val excDC1AId: UUID? = null,
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

data class UpdateExcDC1AEvent(
    @Id val excDC1AId: UUID? = null,
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

data class DeleteExcDC1AEvent(@Id val excDC1AId: UUID? = null)

// single association events

// multiple association events


// ExcDC2A Events

data class CreateExcDC2AEvent(
    @Id val excDC2AId: UUID? = null,
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

data class UpdateExcDC2AEvent(
    @Id val excDC2AId: UUID? = null,
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

data class DeleteExcDC2AEvent(@Id val excDC2AId: UUID? = null)

// single association events

// multiple association events


// ExcDC3A Events

data class CreateExcDC3AEvent(
    @Id val excDC3AId: UUID? = null,
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

data class UpdateExcDC3AEvent(
    @Id val excDC3AId: UUID? = null,
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

data class DeleteExcDC3AEvent(@Id val excDC3AId: UUID? = null)

// single association events

// multiple association events


// ExcDC3A1 Events

data class CreateExcDC3A1Event(
    @Id val excDC3A1Id: UUID? = null,
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

data class UpdateExcDC3A1Event(
    @Id val excDC3A1Id: UUID? = null,
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

data class DeleteExcDC3A1Event(@Id val excDC3A1Id: UUID? = null)

// single association events

// multiple association events


// ExcELIN1 Events

data class CreateExcELIN1Event(
    @Id val excELIN1Id: UUID? = null,
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

data class UpdateExcELIN1Event(
    @Id val excELIN1Id: UUID? = null,
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

data class DeleteExcELIN1Event(@Id val excELIN1Id: UUID? = null)

// single association events

// multiple association events


// ExcELIN2 Events

data class CreateExcELIN2Event(
    @Id val excELIN2Id: UUID? = null,
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

data class UpdateExcELIN2Event(
    @Id val excELIN2Id: UUID? = null,
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

data class DeleteExcELIN2Event(@Id val excELIN2Id: UUID? = null)

// single association events

// multiple association events


// ExcHU Events

data class CreateExcHUEvent(
    @Id val excHUId: UUID? = null,
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

data class UpdateExcHUEvent(
    @Id val excHUId: UUID? = null,
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

data class DeleteExcHUEvent(@Id val excHUId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC1A Events

data class CreateExcIEEEAC1AEvent(
    @Id val excIEEEAC1AId: UUID? = null,
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

data class UpdateExcIEEEAC1AEvent(
    @Id val excIEEEAC1AId: UUID? = null,
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

data class DeleteExcIEEEAC1AEvent(@Id val excIEEEAC1AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC2A Events

data class CreateExcIEEEAC2AEvent(
    @Id val excIEEEAC2AId: UUID? = null,
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

data class UpdateExcIEEEAC2AEvent(
    @Id val excIEEEAC2AId: UUID? = null,
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

data class DeleteExcIEEEAC2AEvent(@Id val excIEEEAC2AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC3A Events

data class CreateExcIEEEAC3AEvent(
    @Id val excIEEEAC3AId: UUID? = null,
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

data class UpdateExcIEEEAC3AEvent(
    @Id val excIEEEAC3AId: UUID? = null,
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

data class DeleteExcIEEEAC3AEvent(@Id val excIEEEAC3AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC4A Events

data class CreateExcIEEEAC4AEvent(
    @Id val excIEEEAC4AId: UUID? = null,
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

data class UpdateExcIEEEAC4AEvent(
    @Id val excIEEEAC4AId: UUID? = null,
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

data class DeleteExcIEEEAC4AEvent(@Id val excIEEEAC4AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC5A Events

data class CreateExcIEEEAC5AEvent(
    @Id val excIEEEAC5AId: UUID? = null,
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

data class UpdateExcIEEEAC5AEvent(
    @Id val excIEEEAC5AId: UUID? = null,
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

data class DeleteExcIEEEAC5AEvent(@Id val excIEEEAC5AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC6A Events

data class CreateExcIEEEAC6AEvent(
    @Id val excIEEEAC6AId: UUID? = null,
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

data class UpdateExcIEEEAC6AEvent(
    @Id val excIEEEAC6AId: UUID? = null,
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

data class DeleteExcIEEEAC6AEvent(@Id val excIEEEAC6AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC7B Events

data class CreateExcIEEEAC7BEvent(
    @Id val excIEEEAC7BId: UUID? = null,
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

data class UpdateExcIEEEAC7BEvent(
    @Id val excIEEEAC7BId: UUID? = null,
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

data class DeleteExcIEEEAC7BEvent(@Id val excIEEEAC7BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEAC8B Events

data class CreateExcIEEEAC8BEvent(
    @Id val excIEEEAC8BId: UUID? = null,
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

data class UpdateExcIEEEAC8BEvent(
    @Id val excIEEEAC8BId: UUID? = null,
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

data class DeleteExcIEEEAC8BEvent(@Id val excIEEEAC8BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEDC1A Events

data class CreateExcIEEEDC1AEvent(
    @Id val excIEEEDC1AId: UUID? = null,
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

data class UpdateExcIEEEDC1AEvent(
    @Id val excIEEEDC1AId: UUID? = null,
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

data class DeleteExcIEEEDC1AEvent(@Id val excIEEEDC1AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEDC2A Events

data class CreateExcIEEEDC2AEvent(
    @Id val excIEEEDC2AId: UUID? = null,
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

data class UpdateExcIEEEDC2AEvent(
    @Id val excIEEEDC2AId: UUID? = null,
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

data class DeleteExcIEEEDC2AEvent(@Id val excIEEEDC2AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEDC3A Events

data class CreateExcIEEEDC3AEvent(
    @Id val excIEEEDC3AId: UUID? = null,
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

data class UpdateExcIEEEDC3AEvent(
    @Id val excIEEEDC3AId: UUID? = null,
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

data class DeleteExcIEEEDC3AEvent(@Id val excIEEEDC3AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEDC4B Events

data class CreateExcIEEEDC4BEvent(
    @Id val excIEEEDC4BId: UUID? = null,
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

data class UpdateExcIEEEDC4BEvent(
    @Id val excIEEEDC4BId: UUID? = null,
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

data class DeleteExcIEEEDC4BEvent(@Id val excIEEEDC4BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST1A Events

data class CreateExcIEEEST1AEvent(
    @Id val excIEEEST1AId: UUID? = null,
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

data class UpdateExcIEEEST1AEvent(
    @Id val excIEEEST1AId: UUID? = null,
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

data class DeleteExcIEEEST1AEvent(@Id val excIEEEST1AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST2A Events

data class CreateExcIEEEST2AEvent(
    @Id val excIEEEST2AId: UUID? = null,
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

data class UpdateExcIEEEST2AEvent(
    @Id val excIEEEST2AId: UUID? = null,
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

data class DeleteExcIEEEST2AEvent(@Id val excIEEEST2AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST3A Events

data class CreateExcIEEEST3AEvent(
    @Id val excIEEEST3AId: UUID? = null,
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

data class UpdateExcIEEEST3AEvent(
    @Id val excIEEEST3AId: UUID? = null,
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

data class DeleteExcIEEEST3AEvent(@Id val excIEEEST3AId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST4B Events

data class CreateExcIEEEST4BEvent(
    @Id val excIEEEST4BId: UUID? = null,
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

data class UpdateExcIEEEST4BEvent(
    @Id val excIEEEST4BId: UUID? = null,
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

data class DeleteExcIEEEST4BEvent(@Id val excIEEEST4BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST5B Events

data class CreateExcIEEEST5BEvent(
    @Id val excIEEEST5BId: UUID? = null,
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

data class UpdateExcIEEEST5BEvent(
    @Id val excIEEEST5BId: UUID? = null,
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

data class DeleteExcIEEEST5BEvent(@Id val excIEEEST5BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST6B Events

data class CreateExcIEEEST6BEvent(
    @Id val excIEEEST6BId: UUID? = null,
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

data class UpdateExcIEEEST6BEvent(
    @Id val excIEEEST6BId: UUID? = null,
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

data class DeleteExcIEEEST6BEvent(@Id val excIEEEST6BId: UUID? = null)

// single association events

// multiple association events


// ExcIEEEST7B Events

data class CreateExcIEEEST7BEvent(
    @Id val excIEEEST7BId: UUID? = null,
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

data class UpdateExcIEEEST7BEvent(
    @Id val excIEEEST7BId: UUID? = null,
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

data class DeleteExcIEEEST7BEvent(@Id val excIEEEST7BId: UUID? = null)

// single association events

// multiple association events


// ExcOEX3T Events

data class CreateExcOEX3TEvent(
    @Id val excOEX3TId: UUID? = null,
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

data class UpdateExcOEX3TEvent(
    @Id val excOEX3TId: UUID? = null,
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

data class DeleteExcOEX3TEvent(@Id val excOEX3TId: UUID? = null)

// single association events

// multiple association events


// ExcPIC Events

data class CreateExcPICEvent(
    @Id val excPICId: UUID? = null,
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

data class UpdateExcPICEvent(
    @Id val excPICId: UUID? = null,
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

data class DeleteExcPICEvent(@Id val excPICId: UUID? = null)

// single association events

// multiple association events


// ExcREXS Events

data class CreateExcREXSEvent(
    @Id val excREXSId: UUID? = null,
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

data class UpdateExcREXSEvent(
    @Id val excREXSId: UUID? = null,
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

data class DeleteExcREXSEvent(@Id val excREXSId: UUID? = null)

// single association events

// multiple association events


// ExcSCRX Events

data class CreateExcSCRXEvent(
    @Id val excSCRXId: UUID? = null,
    val cswitch: String,
    val emax: String,
    val emin: String,
    val k: String,
    val rcrfd: String,
    val tatb: String,
    val tb: String,
    val te: String
)

data class UpdateExcSCRXEvent(
    @Id val excSCRXId: UUID? = null,
    val cswitch: String,
    val emax: String,
    val emin: String,
    val k: String,
    val rcrfd: String,
    val tatb: String,
    val tb: String,
    val te: String
)

data class DeleteExcSCRXEvent(@Id val excSCRXId: UUID? = null)

// single association events

// multiple association events


// ExcSEXS Events

data class CreateExcSEXSEvent(
    @Id val excSEXSId: UUID? = null,
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

data class UpdateExcSEXSEvent(
    @Id val excSEXSId: UUID? = null,
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

data class DeleteExcSEXSEvent(@Id val excSEXSId: UUID? = null)

// single association events

// multiple association events


// ExcSK Events

data class CreateExcSKEvent(
    @Id val excSKId: UUID? = null,
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

data class UpdateExcSKEvent(
    @Id val excSKId: UUID? = null,
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

data class DeleteExcSKEvent(@Id val excSKId: UUID? = null)

// single association events

// multiple association events


// ExcST1A Events

data class CreateExcST1AEvent(
    @Id val excST1AId: UUID? = null,
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

data class UpdateExcST1AEvent(
    @Id val excST1AId: UUID? = null,
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

data class DeleteExcST1AEvent(@Id val excST1AId: UUID? = null)

// single association events

// multiple association events


// ExcST2A Events

data class CreateExcST2AEvent(
    @Id val excST2AId: UUID? = null,
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

data class UpdateExcST2AEvent(
    @Id val excST2AId: UUID? = null,
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

data class DeleteExcST2AEvent(@Id val excST2AId: UUID? = null)

// single association events

// multiple association events


// ExcST3A Events

data class CreateExcST3AEvent(
    @Id val excST3AId: UUID? = null,
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

data class UpdateExcST3AEvent(
    @Id val excST3AId: UUID? = null,
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

data class DeleteExcST3AEvent(@Id val excST3AId: UUID? = null)

// single association events

// multiple association events


// ExcST4B Events

data class CreateExcST4BEvent(
    @Id val excST4BId: UUID? = null,
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

data class UpdateExcST4BEvent(
    @Id val excST4BId: UUID? = null,
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

data class DeleteExcST4BEvent(@Id val excST4BId: UUID? = null)

// single association events

// multiple association events


// ExcST6B Events

data class CreateExcST6BEvent(
    @Id val excST6BId: UUID? = null,
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

data class UpdateExcST6BEvent(
    @Id val excST6BId: UUID? = null,
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

data class DeleteExcST6BEvent(@Id val excST6BId: UUID? = null)

// single association events

// multiple association events


// ExcST7B Events

data class CreateExcST7BEvent(
    @Id val excST7BId: UUID? = null,
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

data class UpdateExcST7BEvent(
    @Id val excST7BId: UUID? = null,
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

data class DeleteExcST7BEvent(@Id val excST7BId: UUID? = null)

// single association events

// multiple association events


// ExcitationSystemDynamics Events

data class CreateExcitationSystemDynamicsEvent(
     val excitationSystemDynamicsId: UUID? = null
)

data class UpdateExcitationSystemDynamicsEvent(
     val excitationSystemDynamicsId: UUID? = null
)

data class DeleteExcitationSystemDynamicsEvent(@Id val excitationSystemDynamicsId: UUID? = null)

// single association events

// multiple association events


// ExcitationSystemUserDefined Events

data class CreateExcitationSystemUserDefinedEvent(
    @Id val excitationSystemUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateExcitationSystemUserDefinedEvent(
    @Id val excitationSystemUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteExcitationSystemUserDefinedEvent(@Id val excitationSystemUserDefinedId: UUID? = null)

// single association events

// multiple association events


// ExtensionVersion Events

data class CreateExtensionVersionEvent(
    @Id val extensionVersionId: UUID? = null,
    val date: String,
    val namespaceURI: String
)

data class UpdateExtensionVersionEvent(
    @Id val extensionVersionId: UUID? = null,
    val date: String,
    val namespaceURI: String
)

data class DeleteExtensionVersionEvent(@Id val extensionVersionId: UUID? = null)

// single association events

// multiple association events


// ExternalNetworkInjection Events

data class CreateExternalNetworkInjectionEvent(
    @Id val externalNetworkInjectionId: UUID? = null,
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

data class UpdateExternalNetworkInjectionEvent(
    @Id val externalNetworkInjectionId: UUID? = null,
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

data class DeleteExternalNetworkInjectionEvent(@Id val externalNetworkInjectionId: UUID? = null)

// single association events

// multiple association events


// FloatProxy Events

data class CreateFloatProxyEvent(
     val floatProxyId: UUID? = null
)

data class UpdateFloatProxyEvent(
     val floatProxyId: UUID? = null
)

data class DeleteFloatProxyEvent(@Id val floatProxyId: UUID? = null)

// single association events

// multiple association events


// FossilFuel Events

data class CreateFossilFuelEvent(
    @Id val fossilFuelId: UUID? = null,
    val fossilFuelType: String
)

data class UpdateFossilFuelEvent(
    @Id val fossilFuelId: UUID? = null,
    val fossilFuelType: String
)

data class DeleteFossilFuelEvent(@Id val fossilFuelId: UUID? = null)

// single association events

// multiple association events


// Frequency Events

data class CreateFrequencyEvent(
    @Id val frequencyId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateFrequencyEvent(
    @Id val frequencyId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteFrequencyEvent(@Id val frequencyId: UUID? = null)

// single association events

// multiple association events


// GenICompensationForGenJ Events

data class CreateGenICompensationForGenJEvent(
    @Id val genICompensationForGenJId: UUID? = null,
    val rcij: String,
    val xcij: String
)

data class UpdateGenICompensationForGenJEvent(
    @Id val genICompensationForGenJId: UUID? = null,
    val rcij: String,
    val xcij: String
)

data class DeleteGenICompensationForGenJEvent(@Id val genICompensationForGenJId: UUID? = null)

// single association events

// multiple association events


// GeneratingUnit Events

data class CreateGeneratingUnitEvent(
    @Id val generatingUnitId: UUID? = null,
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

data class UpdateGeneratingUnitEvent(
    @Id val generatingUnitId: UUID? = null,
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

data class DeleteGeneratingUnitEvent(@Id val generatingUnitId: UUID? = null)

// single association events

// multiple association events


// GeographicalLocationVersion Events

data class CreateGeographicalLocationVersionEvent(
    @Id val geographicalLocationVersionId: UUID? = null,
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

data class UpdateGeographicalLocationVersionEvent(
    @Id val geographicalLocationVersionId: UUID? = null,
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

data class DeleteGeographicalLocationVersionEvent(@Id val geographicalLocationVersionId: UUID? = null)

// single association events

// multiple association events


// GeographicalRegion Events

data class CreateGeographicalRegionEvent(
     val geographicalRegionId: UUID? = null
)

data class UpdateGeographicalRegionEvent(
     val geographicalRegionId: UUID? = null
)

data class DeleteGeographicalRegionEvent(@Id val geographicalRegionId: UUID? = null)

// single association events

// multiple association events


// GovCT1 Events

data class CreateGovCT1Event(
    @Id val govCT1Id: UUID? = null,
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

data class UpdateGovCT1Event(
    @Id val govCT1Id: UUID? = null,
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

data class DeleteGovCT1Event(@Id val govCT1Id: UUID? = null)

// single association events

// multiple association events


// GovCT2 Events

data class CreateGovCT2Event(
    @Id val govCT2Id: UUID? = null,
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

data class UpdateGovCT2Event(
    @Id val govCT2Id: UUID? = null,
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

data class DeleteGovCT2Event(@Id val govCT2Id: UUID? = null)

// single association events

// multiple association events


// GovGAST Events

data class CreateGovGASTEvent(
    @Id val govGASTId: UUID? = null,
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

data class UpdateGovGASTEvent(
    @Id val govGASTId: UUID? = null,
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

data class DeleteGovGASTEvent(@Id val govGASTId: UUID? = null)

// single association events

// multiple association events


// GovGAST1 Events

data class CreateGovGAST1Event(
    @Id val govGAST1Id: UUID? = null,
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

data class UpdateGovGAST1Event(
    @Id val govGAST1Id: UUID? = null,
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

data class DeleteGovGAST1Event(@Id val govGAST1Id: UUID? = null)

// single association events

// multiple association events


// GovGAST2 Events

data class CreateGovGAST2Event(
    @Id val govGAST2Id: UUID? = null,
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

data class UpdateGovGAST2Event(
    @Id val govGAST2Id: UUID? = null,
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

data class DeleteGovGAST2Event(@Id val govGAST2Id: UUID? = null)

// single association events

// multiple association events


// GovGAST3 Events

data class CreateGovGAST3Event(
    @Id val govGAST3Id: UUID? = null,
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

data class UpdateGovGAST3Event(
    @Id val govGAST3Id: UUID? = null,
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

data class DeleteGovGAST3Event(@Id val govGAST3Id: UUID? = null)

// single association events

// multiple association events


// GovGAST4 Events

data class CreateGovGAST4Event(
    @Id val govGAST4Id: UUID? = null,
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

data class UpdateGovGAST4Event(
    @Id val govGAST4Id: UUID? = null,
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

data class DeleteGovGAST4Event(@Id val govGAST4Id: UUID? = null)

// single association events

// multiple association events


// GovGASTWD Events

data class CreateGovGASTWDEvent(
    @Id val govGASTWDId: UUID? = null,
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

data class UpdateGovGASTWDEvent(
    @Id val govGASTWDId: UUID? = null,
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

data class DeleteGovGASTWDEvent(@Id val govGASTWDId: UUID? = null)

// single association events

// multiple association events


// GovHydro1 Events

data class CreateGovHydro1Event(
    @Id val govHydro1Id: UUID? = null,
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

data class UpdateGovHydro1Event(
    @Id val govHydro1Id: UUID? = null,
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

data class DeleteGovHydro1Event(@Id val govHydro1Id: UUID? = null)

// single association events

// multiple association events


// GovHydro2 Events

data class CreateGovHydro2Event(
    @Id val govHydro2Id: UUID? = null,
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

data class UpdateGovHydro2Event(
    @Id val govHydro2Id: UUID? = null,
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

data class DeleteGovHydro2Event(@Id val govHydro2Id: UUID? = null)

// single association events

// multiple association events


// GovHydro3 Events

data class CreateGovHydro3Event(
    @Id val govHydro3Id: UUID? = null,
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

data class UpdateGovHydro3Event(
    @Id val govHydro3Id: UUID? = null,
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

data class DeleteGovHydro3Event(@Id val govHydro3Id: UUID? = null)

// single association events

// multiple association events


// GovHydro4 Events

data class CreateGovHydro4Event(
    @Id val govHydro4Id: UUID? = null,
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

data class UpdateGovHydro4Event(
    @Id val govHydro4Id: UUID? = null,
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

data class DeleteGovHydro4Event(@Id val govHydro4Id: UUID? = null)

// single association events

// multiple association events


// GovHydroDD Events

data class CreateGovHydroDDEvent(
    @Id val govHydroDDId: UUID? = null,
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

data class UpdateGovHydroDDEvent(
    @Id val govHydroDDId: UUID? = null,
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

data class DeleteGovHydroDDEvent(@Id val govHydroDDId: UUID? = null)

// single association events

// multiple association events


// GovHydroFrancis Events

data class CreateGovHydroFrancisEvent(
    @Id val govHydroFrancisId: UUID? = null,
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

data class UpdateGovHydroFrancisEvent(
    @Id val govHydroFrancisId: UUID? = null,
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

data class DeleteGovHydroFrancisEvent(@Id val govHydroFrancisId: UUID? = null)

// single association events

// multiple association events


// GovHydroIEEE0 Events

data class CreateGovHydroIEEE0Event(
    @Id val govHydroIEEE0Id: UUID? = null,
    val k: String,
    val mwbase: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String
)

data class UpdateGovHydroIEEE0Event(
    @Id val govHydroIEEE0Id: UUID? = null,
    val k: String,
    val mwbase: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val t4: String
)

data class DeleteGovHydroIEEE0Event(@Id val govHydroIEEE0Id: UUID? = null)

// single association events

// multiple association events


// GovHydroIEEE2 Events

data class CreateGovHydroIEEE2Event(
    @Id val govHydroIEEE2Id: UUID? = null,
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

data class UpdateGovHydroIEEE2Event(
    @Id val govHydroIEEE2Id: UUID? = null,
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

data class DeleteGovHydroIEEE2Event(@Id val govHydroIEEE2Id: UUID? = null)

// single association events

// multiple association events


// GovHydroPID Events

data class CreateGovHydroPIDEvent(
    @Id val govHydroPIDId: UUID? = null,
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

data class UpdateGovHydroPIDEvent(
    @Id val govHydroPIDId: UUID? = null,
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

data class DeleteGovHydroPIDEvent(@Id val govHydroPIDId: UUID? = null)

// single association events

// multiple association events


// GovHydroPID2 Events

data class CreateGovHydroPID2Event(
    @Id val govHydroPID2Id: UUID? = null,
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

data class UpdateGovHydroPID2Event(
    @Id val govHydroPID2Id: UUID? = null,
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

data class DeleteGovHydroPID2Event(@Id val govHydroPID2Id: UUID? = null)

// single association events

// multiple association events


// GovHydroPelton Events

data class CreateGovHydroPeltonEvent(
    @Id val govHydroPeltonId: UUID? = null,
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

data class UpdateGovHydroPeltonEvent(
    @Id val govHydroPeltonId: UUID? = null,
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

data class DeleteGovHydroPeltonEvent(@Id val govHydroPeltonId: UUID? = null)

// single association events

// multiple association events


// GovHydroR Events

data class CreateGovHydroREvent(
    @Id val govHydroRId: UUID? = null,
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

data class UpdateGovHydroREvent(
    @Id val govHydroRId: UUID? = null,
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

data class DeleteGovHydroREvent(@Id val govHydroRId: UUID? = null)

// single association events

// multiple association events


// GovHydroWEH Events

data class CreateGovHydroWEHEvent(
    @Id val govHydroWEHId: UUID? = null,
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

data class UpdateGovHydroWEHEvent(
    @Id val govHydroWEHId: UUID? = null,
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

data class DeleteGovHydroWEHEvent(@Id val govHydroWEHId: UUID? = null)

// single association events

// multiple association events


// GovHydroWPID Events

data class CreateGovHydroWPIDEvent(
    @Id val govHydroWPIDId: UUID? = null,
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

data class UpdateGovHydroWPIDEvent(
    @Id val govHydroWPIDId: UUID? = null,
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

data class DeleteGovHydroWPIDEvent(@Id val govHydroWPIDId: UUID? = null)

// single association events

// multiple association events


// GovSteam0 Events

data class CreateGovSteam0Event(
    @Id val govSteam0Id: UUID? = null,
    val dt: String,
    val mwbase: String,
    val r: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val vmax: String,
    val vmin: String
)

data class UpdateGovSteam0Event(
    @Id val govSteam0Id: UUID? = null,
    val dt: String,
    val mwbase: String,
    val r: String,
    val t1: String,
    val t2: String,
    val t3: String,
    val vmax: String,
    val vmin: String
)

data class DeleteGovSteam0Event(@Id val govSteam0Id: UUID? = null)

// single association events

// multiple association events


// GovSteam1 Events

data class CreateGovSteam1Event(
    @Id val govSteam1Id: UUID? = null,
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

data class UpdateGovSteam1Event(
    @Id val govSteam1Id: UUID? = null,
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

data class DeleteGovSteam1Event(@Id val govSteam1Id: UUID? = null)

// single association events

// multiple association events


// GovSteam2 Events

data class CreateGovSteam2Event(
    @Id val govSteam2Id: UUID? = null,
    val dbf: String,
    val k: String,
    val mnef: String,
    val mxef: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String
)

data class UpdateGovSteam2Event(
    @Id val govSteam2Id: UUID? = null,
    val dbf: String,
    val k: String,
    val mnef: String,
    val mxef: String,
    val pmax: String,
    val pmin: String,
    val t1: String,
    val t2: String
)

data class DeleteGovSteam2Event(@Id val govSteam2Id: UUID? = null)

// single association events

// multiple association events


// GovSteamCC Events

data class CreateGovSteamCCEvent(
    @Id val govSteamCCId: UUID? = null,
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

data class UpdateGovSteamCCEvent(
    @Id val govSteamCCId: UUID? = null,
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

data class DeleteGovSteamCCEvent(@Id val govSteamCCId: UUID? = null)

// single association events

// multiple association events


// GovSteamEU Events

data class CreateGovSteamEUEvent(
    @Id val govSteamEUId: UUID? = null,
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

data class UpdateGovSteamEUEvent(
    @Id val govSteamEUId: UUID? = null,
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

data class DeleteGovSteamEUEvent(@Id val govSteamEUId: UUID? = null)

// single association events

// multiple association events


// GovSteamFV2 Events

data class CreateGovSteamFV2Event(
    @Id val govSteamFV2Id: UUID? = null,
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

data class UpdateGovSteamFV2Event(
    @Id val govSteamFV2Id: UUID? = null,
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

data class DeleteGovSteamFV2Event(@Id val govSteamFV2Id: UUID? = null)

// single association events

// multiple association events


// GovSteamFV3 Events

data class CreateGovSteamFV3Event(
    @Id val govSteamFV3Id: UUID? = null,
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

data class UpdateGovSteamFV3Event(
    @Id val govSteamFV3Id: UUID? = null,
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

data class DeleteGovSteamFV3Event(@Id val govSteamFV3Id: UUID? = null)

// single association events

// multiple association events


// GovSteamFV4 Events

data class CreateGovSteamFV4Event(
    @Id val govSteamFV4Id: UUID? = null,
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

data class UpdateGovSteamFV4Event(
    @Id val govSteamFV4Id: UUID? = null,
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

data class DeleteGovSteamFV4Event(@Id val govSteamFV4Id: UUID? = null)

// single association events

// multiple association events


// GovSteamIEEE1 Events

data class CreateGovSteamIEEE1Event(
    @Id val govSteamIEEE1Id: UUID? = null,
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

data class UpdateGovSteamIEEE1Event(
    @Id val govSteamIEEE1Id: UUID? = null,
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

data class DeleteGovSteamIEEE1Event(@Id val govSteamIEEE1Id: UUID? = null)

// single association events

// multiple association events


// GovSteamSGO Events

data class CreateGovSteamSGOEvent(
    @Id val govSteamSGOId: UUID? = null,
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

data class UpdateGovSteamSGOEvent(
    @Id val govSteamSGOId: UUID? = null,
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

data class DeleteGovSteamSGOEvent(@Id val govSteamSGOId: UUID? = null)

// single association events

// multiple association events


// GrossToNetActivePowerCurve Events

data class CreateGrossToNetActivePowerCurveEvent(
     val grossToNetActivePowerCurveId: UUID? = null
)

data class UpdateGrossToNetActivePowerCurveEvent(
     val grossToNetActivePowerCurveId: UUID? = null
)

data class DeleteGrossToNetActivePowerCurveEvent(@Id val grossToNetActivePowerCurveId: UUID? = null)

// single association events

// multiple association events


// Ground Events

data class CreateGroundEvent(
     val groundId: UUID? = null
)

data class UpdateGroundEvent(
     val groundId: UUID? = null
)

data class DeleteGroundEvent(@Id val groundId: UUID? = null)

// single association events

// multiple association events


// GroundDisconnector Events

data class CreateGroundDisconnectorEvent(
     val groundDisconnectorId: UUID? = null
)

data class UpdateGroundDisconnectorEvent(
     val groundDisconnectorId: UUID? = null
)

data class DeleteGroundDisconnectorEvent(@Id val groundDisconnectorId: UUID? = null)

// single association events

// multiple association events


// GroundingImpedance Events

data class CreateGroundingImpedanceEvent(
    @Id val groundingImpedanceId: UUID? = null,
    val x: String
)

data class UpdateGroundingImpedanceEvent(
    @Id val groundingImpedanceId: UUID? = null,
    val x: String
)

data class DeleteGroundingImpedanceEvent(@Id val groundingImpedanceId: UUID? = null)

// single association events

// multiple association events


// HydroGeneratingUnit Events

data class CreateHydroGeneratingUnitEvent(
    @Id val hydroGeneratingUnitId: UUID? = null,
    val energyConversionCapability: String
)

data class UpdateHydroGeneratingUnitEvent(
    @Id val hydroGeneratingUnitId: UUID? = null,
    val energyConversionCapability: String
)

data class DeleteHydroGeneratingUnitEvent(@Id val hydroGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// HydroPowerPlant Events

data class CreateHydroPowerPlantEvent(
    @Id val hydroPowerPlantId: UUID? = null,
    val hydroPlantStorageType: String
)

data class UpdateHydroPowerPlantEvent(
    @Id val hydroPowerPlantId: UUID? = null,
    val hydroPlantStorageType: String
)

data class DeleteHydroPowerPlantEvent(@Id val hydroPowerPlantId: UUID? = null)

// single association events

// multiple association events


// HydroPump Events

data class CreateHydroPumpEvent(
     val hydroPumpId: UUID? = null
)

data class UpdateHydroPumpEvent(
     val hydroPumpId: UUID? = null
)

data class DeleteHydroPumpEvent(@Id val hydroPumpId: UUID? = null)

// single association events

// multiple association events


// IdentifiedObject Events

data class CreateIdentifiedObjectEvent(
    @Id val identifiedObjectId: UUID? = null,
    val description: String,
    val energyIdentCodeEic: String,
    val mRID: String,
    val name: String,
    val shortName: String
)

data class UpdateIdentifiedObjectEvent(
    @Id val identifiedObjectId: UUID? = null,
    val description: String,
    val energyIdentCodeEic: String,
    val mRID: String,
    val name: String,
    val shortName: String
)

data class DeleteIdentifiedObjectEvent(@Id val identifiedObjectId: UUID? = null)

// single association events

// multiple association events


// Inductance Events

data class CreateInductanceEvent(
    @Id val inductanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateInductanceEvent(
    @Id val inductanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteInductanceEvent(@Id val inductanceId: UUID? = null)

// single association events

// multiple association events


// InductancePerLength Events

data class CreateInductancePerLengthEvent(
    @Id val inductancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateInductancePerLengthEvent(
    @Id val inductancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteInductancePerLengthEvent(@Id val inductancePerLengthId: UUID? = null)

// single association events

// multiple association events


// IntegerProxy Events

data class CreateIntegerProxyEvent(
     val integerProxyId: UUID? = null
)

data class UpdateIntegerProxyEvent(
     val integerProxyId: UUID? = null
)

data class DeleteIntegerProxyEvent(@Id val integerProxyId: UUID? = null)

// single association events

// multiple association events


// Junction Events

data class CreateJunctionEvent(
     val junctionId: UUID? = null
)

data class UpdateJunctionEvent(
     val junctionId: UUID? = null
)

data class DeleteJunctionEvent(@Id val junctionId: UUID? = null)

// single association events

// multiple association events


// Length Events

data class CreateLengthEvent(
    @Id val lengthId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateLengthEvent(
    @Id val lengthId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteLengthEvent(@Id val lengthId: UUID? = null)

// single association events

// multiple association events


// Limit Events

data class CreateLimitEvent(
     val limitId: UUID? = null
)

data class UpdateLimitEvent(
     val limitId: UUID? = null
)

data class DeleteLimitEvent(@Id val limitId: UUID? = null)

// single association events

// multiple association events


// LimitSet Events

data class CreateLimitSetEvent(
    @Id val limitSetId: UUID? = null,
    val isPercentageLimits: String
)

data class UpdateLimitSetEvent(
    @Id val limitSetId: UUID? = null,
    val isPercentageLimits: String
)

data class DeleteLimitSetEvent(@Id val limitSetId: UUID? = null)

// single association events

// multiple association events


// Line Events

data class CreateLineEvent(
     val lineId: UUID? = null
)

data class UpdateLineEvent(
     val lineId: UUID? = null
)

data class DeleteLineEvent(@Id val lineId: UUID? = null)

// single association events

// multiple association events


// LinearShuntCompensator Events

data class CreateLinearShuntCompensatorEvent(
    @Id val linearShuntCompensatorId: UUID? = null,
    val b0PerSection: String,
    val bPerSection: String,
    val g0PerSection: String,
    val gPerSection: String
)

data class UpdateLinearShuntCompensatorEvent(
    @Id val linearShuntCompensatorId: UUID? = null,
    val b0PerSection: String,
    val bPerSection: String,
    val g0PerSection: String,
    val gPerSection: String
)

data class DeleteLinearShuntCompensatorEvent(@Id val linearShuntCompensatorId: UUID? = null)

// single association events

// multiple association events


// LoadAggregate Events

data class CreateLoadAggregateEvent(
     val loadAggregateId: UUID? = null
)

data class UpdateLoadAggregateEvent(
     val loadAggregateId: UUID? = null
)

data class DeleteLoadAggregateEvent(@Id val loadAggregateId: UUID? = null)

// single association events

// multiple association events


// LoadArea Events

data class CreateLoadAreaEvent(
     val loadAreaId: UUID? = null
)

data class UpdateLoadAreaEvent(
     val loadAreaId: UUID? = null
)

data class DeleteLoadAreaEvent(@Id val loadAreaId: UUID? = null)

// single association events

// multiple association events


// LoadBreakSwitch Events

data class CreateLoadBreakSwitchEvent(
     val loadBreakSwitchId: UUID? = null
)

data class UpdateLoadBreakSwitchEvent(
     val loadBreakSwitchId: UUID? = null
)

data class DeleteLoadBreakSwitchEvent(@Id val loadBreakSwitchId: UUID? = null)

// single association events

// multiple association events


// LoadComposite Events

data class CreateLoadCompositeEvent(
    @Id val loadCompositeId: UUID? = null,
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

data class UpdateLoadCompositeEvent(
    @Id val loadCompositeId: UUID? = null,
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

data class DeleteLoadCompositeEvent(@Id val loadCompositeId: UUID? = null)

// single association events

// multiple association events


// LoadDynamics Events

data class CreateLoadDynamicsEvent(
     val loadDynamicsId: UUID? = null
)

data class UpdateLoadDynamicsEvent(
     val loadDynamicsId: UUID? = null
)

data class DeleteLoadDynamicsEvent(@Id val loadDynamicsId: UUID? = null)

// single association events

// multiple association events


// LoadGenericNonLinear Events

data class CreateLoadGenericNonLinearEvent(
    @Id val loadGenericNonLinearId: UUID? = null,
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

data class UpdateLoadGenericNonLinearEvent(
    @Id val loadGenericNonLinearId: UUID? = null,
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

data class DeleteLoadGenericNonLinearEvent(@Id val loadGenericNonLinearId: UUID? = null)

// single association events

// multiple association events


// LoadGroup Events

data class CreateLoadGroupEvent(
     val loadGroupId: UUID? = null
)

data class UpdateLoadGroupEvent(
     val loadGroupId: UUID? = null
)

data class DeleteLoadGroupEvent(@Id val loadGroupId: UUID? = null)

// single association events

// multiple association events


// LoadMotor Events

data class CreateLoadMotorEvent(
    @Id val loadMotorId: UUID? = null,
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

data class UpdateLoadMotorEvent(
    @Id val loadMotorId: UUID? = null,
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

data class DeleteLoadMotorEvent(@Id val loadMotorId: UUID? = null)

// single association events

// multiple association events


// LoadResponseCharacteristic Events

data class CreateLoadResponseCharacteristicEvent(
    @Id val loadResponseCharacteristicId: UUID? = null,
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

data class UpdateLoadResponseCharacteristicEvent(
    @Id val loadResponseCharacteristicId: UUID? = null,
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

data class DeleteLoadResponseCharacteristicEvent(@Id val loadResponseCharacteristicId: UUID? = null)

// single association events

// multiple association events


// LoadStatic Events

data class CreateLoadStaticEvent(
    @Id val loadStaticId: UUID? = null,
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

data class UpdateLoadStaticEvent(
    @Id val loadStaticId: UUID? = null,
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

data class DeleteLoadStaticEvent(@Id val loadStaticId: UUID? = null)

// single association events

// multiple association events


// LoadUserDefined Events

data class CreateLoadUserDefinedEvent(
    @Id val loadUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateLoadUserDefinedEvent(
    @Id val loadUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteLoadUserDefinedEvent(@Id val loadUserDefinedId: UUID? = null)

// single association events

// multiple association events


// Location Events

data class CreateLocationEvent(
     val locationId: UUID? = null
)

data class UpdateLocationEvent(
     val locationId: UUID? = null
)

data class DeleteLocationEvent(@Id val locationId: UUID? = null)

// single association events

// multiple association events


// Measurement Events

data class CreateMeasurementEvent(
    @Id val measurementId: UUID? = null,
    val measurementType: String,
    val phases: String,
    val unitMultiplier: String,
    val unitSymbol: String
)

data class UpdateMeasurementEvent(
    @Id val measurementId: UUID? = null,
    val measurementType: String,
    val phases: String,
    val unitMultiplier: String,
    val unitSymbol: String
)

data class DeleteMeasurementEvent(@Id val measurementId: UUID? = null)

// single association events

// multiple association events


// MeasurementValue Events

data class CreateMeasurementValueEvent(
    @Id val measurementValueId: UUID? = null,
    val sensorAccuracy: String,
    val timeStamp: String
)

data class UpdateMeasurementValueEvent(
    @Id val measurementValueId: UUID? = null,
    val sensorAccuracy: String,
    val timeStamp: String
)

data class DeleteMeasurementValueEvent(@Id val measurementValueId: UUID? = null)

// single association events

// multiple association events


// MeasurementValueQuality Events

data class CreateMeasurementValueQualityEvent(
     val measurementValueQualityId: UUID? = null
)

data class UpdateMeasurementValueQualityEvent(
     val measurementValueQualityId: UUID? = null
)

data class DeleteMeasurementValueQualityEvent(@Id val measurementValueQualityId: UUID? = null)

// single association events

// multiple association events


// MeasurementValueSource Events

data class CreateMeasurementValueSourceEvent(
     val measurementValueSourceId: UUID? = null
)

data class UpdateMeasurementValueSourceEvent(
     val measurementValueSourceId: UUID? = null
)

data class DeleteMeasurementValueSourceEvent(@Id val measurementValueSourceId: UUID? = null)

// single association events

// multiple association events


// MechLoad1 Events

data class CreateMechLoad1Event(
    @Id val mechLoad1Id: UUID? = null,
    val a: String,
    val b: String,
    val d: String,
    val e: String
)

data class UpdateMechLoad1Event(
    @Id val mechLoad1Id: UUID? = null,
    val a: String,
    val b: String,
    val d: String,
    val e: String
)

data class DeleteMechLoad1Event(@Id val mechLoad1Id: UUID? = null)

// single association events

// multiple association events


// MechanicalLoadDynamics Events

data class CreateMechanicalLoadDynamicsEvent(
     val mechanicalLoadDynamicsId: UUID? = null
)

data class UpdateMechanicalLoadDynamicsEvent(
     val mechanicalLoadDynamicsId: UUID? = null
)

data class DeleteMechanicalLoadDynamicsEvent(@Id val mechanicalLoadDynamicsId: UUID? = null)

// single association events

// multiple association events


// MechanicalLoadUserDefined Events

data class CreateMechanicalLoadUserDefinedEvent(
    @Id val mechanicalLoadUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateMechanicalLoadUserDefinedEvent(
    @Id val mechanicalLoadUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteMechanicalLoadUserDefinedEvent(@Id val mechanicalLoadUserDefinedId: UUID? = null)

// single association events

// multiple association events


// Money Events

data class CreateMoneyEvent(
    @Id val moneyId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateMoneyEvent(
    @Id val moneyId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteMoneyEvent(@Id val moneyId: UUID? = null)

// single association events

// multiple association events


// MonthDay Events

data class CreateMonthDayEvent(
     val monthDayId: UUID? = null
)

data class UpdateMonthDayEvent(
     val monthDayId: UUID? = null
)

data class DeleteMonthDayEvent(@Id val monthDayId: UUID? = null)

// single association events

// multiple association events


// MonthDayInterval Events

data class CreateMonthDayIntervalEvent(
    @Id val monthDayIntervalId: UUID? = null,
    val end: String,
    val start: String
)

data class UpdateMonthDayIntervalEvent(
    @Id val monthDayIntervalId: UUID? = null,
    val end: String,
    val start: String
)

data class DeleteMonthDayIntervalEvent(@Id val monthDayIntervalId: UUID? = null)

// single association events

// multiple association events


// MutualCoupling Events

data class CreateMutualCouplingEvent(
    @Id val mutualCouplingId: UUID? = null,
    val b0ch: String,
    val distance11: String,
    val distance12: String,
    val distance21: String,
    val distance22: String,
    val g0ch: String,
    val r0: String,
    val x0: String
)

data class UpdateMutualCouplingEvent(
    @Id val mutualCouplingId: UUID? = null,
    val b0ch: String,
    val distance11: String,
    val distance12: String,
    val distance21: String,
    val distance22: String,
    val g0ch: String,
    val r0: String,
    val x0: String
)

data class DeleteMutualCouplingEvent(@Id val mutualCouplingId: UUID? = null)

// single association events

// multiple association events


// NonConformLoad Events

data class CreateNonConformLoadEvent(
     val nonConformLoadId: UUID? = null
)

data class UpdateNonConformLoadEvent(
     val nonConformLoadId: UUID? = null
)

data class DeleteNonConformLoadEvent(@Id val nonConformLoadId: UUID? = null)

// single association events

// multiple association events


// NonConformLoadGroup Events

data class CreateNonConformLoadGroupEvent(
     val nonConformLoadGroupId: UUID? = null
)

data class UpdateNonConformLoadGroupEvent(
     val nonConformLoadGroupId: UUID? = null
)

data class DeleteNonConformLoadGroupEvent(@Id val nonConformLoadGroupId: UUID? = null)

// single association events

// multiple association events


// NonConformLoadSchedule Events

data class CreateNonConformLoadScheduleEvent(
     val nonConformLoadScheduleId: UUID? = null
)

data class UpdateNonConformLoadScheduleEvent(
     val nonConformLoadScheduleId: UUID? = null
)

data class DeleteNonConformLoadScheduleEvent(@Id val nonConformLoadScheduleId: UUID? = null)

// single association events

// multiple association events


// NonlinearShuntCompensator Events

data class CreateNonlinearShuntCompensatorEvent(
     val nonlinearShuntCompensatorId: UUID? = null
)

data class UpdateNonlinearShuntCompensatorEvent(
     val nonlinearShuntCompensatorId: UUID? = null
)

data class DeleteNonlinearShuntCompensatorEvent(@Id val nonlinearShuntCompensatorId: UUID? = null)

// single association events

// multiple association events


// NonlinearShuntCompensatorPoint Events

data class CreateNonlinearShuntCompensatorPointEvent(
    @Id val nonlinearShuntCompensatorPointId: UUID? = null,
    val b: String,
    val b0: String,
    val g: String,
    val g0: String,
    val sectionNumber: String
)

data class UpdateNonlinearShuntCompensatorPointEvent(
    @Id val nonlinearShuntCompensatorPointId: UUID? = null,
    val b: String,
    val b0: String,
    val g: String,
    val g0: String,
    val sectionNumber: String
)

data class DeleteNonlinearShuntCompensatorPointEvent(@Id val nonlinearShuntCompensatorPointId: UUID? = null)

// single association events

// multiple association events


// NuclearGeneratingUnit Events

data class CreateNuclearGeneratingUnitEvent(
     val nuclearGeneratingUnitId: UUID? = null
)

data class UpdateNuclearGeneratingUnitEvent(
     val nuclearGeneratingUnitId: UUID? = null
)

data class DeleteNuclearGeneratingUnitEvent(@Id val nuclearGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// OperationalLimit Events

data class CreateOperationalLimitEvent(
     val operationalLimitId: UUID? = null
)

data class UpdateOperationalLimitEvent(
     val operationalLimitId: UUID? = null
)

data class DeleteOperationalLimitEvent(@Id val operationalLimitId: UUID? = null)

// single association events

// multiple association events


// OperationalLimitSet Events

data class CreateOperationalLimitSetEvent(
     val operationalLimitSetId: UUID? = null
)

data class UpdateOperationalLimitSetEvent(
     val operationalLimitSetId: UUID? = null
)

data class DeleteOperationalLimitSetEvent(@Id val operationalLimitSetId: UUID? = null)

// single association events

// multiple association events


// OperationalLimitType Events

data class CreateOperationalLimitTypeEvent(
    @Id val operationalLimitTypeId: UUID? = null,
    val acceptableDuration: String,
    val direction: String,
    val limitType: String
)

data class UpdateOperationalLimitTypeEvent(
    @Id val operationalLimitTypeId: UUID? = null,
    val acceptableDuration: String,
    val direction: String,
    val limitType: String
)

data class DeleteOperationalLimitTypeEvent(@Id val operationalLimitTypeId: UUID? = null)

// single association events

// multiple association events


// OverexcLim2 Events

data class CreateOverexcLim2Event(
    @Id val overexcLim2Id: UUID? = null,
    val ifdlim: String,
    val koi: String,
    val voimax: String,
    val voimin: String
)

data class UpdateOverexcLim2Event(
    @Id val overexcLim2Id: UUID? = null,
    val ifdlim: String,
    val koi: String,
    val voimax: String,
    val voimin: String
)

data class DeleteOverexcLim2Event(@Id val overexcLim2Id: UUID? = null)

// single association events

// multiple association events


// OverexcLimIEEE Events

data class CreateOverexcLimIEEEEvent(
    @Id val overexcLimIEEEId: UUID? = null,
    val hyst: String,
    val ifdlim: String,
    val ifdmax: String,
    val itfpu: String,
    val kcd: String,
    val kramp: String
)

data class UpdateOverexcLimIEEEEvent(
    @Id val overexcLimIEEEId: UUID? = null,
    val hyst: String,
    val ifdlim: String,
    val ifdmax: String,
    val itfpu: String,
    val kcd: String,
    val kramp: String
)

data class DeleteOverexcLimIEEEEvent(@Id val overexcLimIEEEId: UUID? = null)

// single association events

// multiple association events


// OverexcLimX1 Events

data class CreateOverexcLimX1Event(
    @Id val overexcLimX1Id: UUID? = null,
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

data class UpdateOverexcLimX1Event(
    @Id val overexcLimX1Id: UUID? = null,
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

data class DeleteOverexcLimX1Event(@Id val overexcLimX1Id: UUID? = null)

// single association events

// multiple association events


// OverexcLimX2 Events

data class CreateOverexcLimX2Event(
    @Id val overexcLimX2Id: UUID? = null,
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

data class UpdateOverexcLimX2Event(
    @Id val overexcLimX2Id: UUID? = null,
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

data class DeleteOverexcLimX2Event(@Id val overexcLimX2Id: UUID? = null)

// single association events

// multiple association events


// OverexcitationLimiterDynamics Events

data class CreateOverexcitationLimiterDynamicsEvent(
     val overexcitationLimiterDynamicsId: UUID? = null
)

data class UpdateOverexcitationLimiterDynamicsEvent(
     val overexcitationLimiterDynamicsId: UUID? = null
)

data class DeleteOverexcitationLimiterDynamicsEvent(@Id val overexcitationLimiterDynamicsId: UUID? = null)

// single association events

// multiple association events


// OverexcitationLimiterUserDefined Events

data class CreateOverexcitationLimiterUserDefinedEvent(
    @Id val overexcitationLimiterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateOverexcitationLimiterUserDefinedEvent(
    @Id val overexcitationLimiterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteOverexcitationLimiterUserDefinedEvent(@Id val overexcitationLimiterUserDefinedId: UUID? = null)

// single association events

// multiple association events


// PFVArControllerType1Dynamics Events

data class CreatePFVArControllerType1DynamicsEvent(
     val pFVArControllerType1DynamicsId: UUID? = null
)

data class UpdatePFVArControllerType1DynamicsEvent(
     val pFVArControllerType1DynamicsId: UUID? = null
)

data class DeletePFVArControllerType1DynamicsEvent(@Id val pFVArControllerType1DynamicsId: UUID? = null)

// single association events

// multiple association events


// PFVArControllerType1UserDefined Events

data class CreatePFVArControllerType1UserDefinedEvent(
    @Id val pFVArControllerType1UserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdatePFVArControllerType1UserDefinedEvent(
    @Id val pFVArControllerType1UserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeletePFVArControllerType1UserDefinedEvent(@Id val pFVArControllerType1UserDefinedId: UUID? = null)

// single association events

// multiple association events


// PFVArControllerType2Dynamics Events

data class CreatePFVArControllerType2DynamicsEvent(
     val pFVArControllerType2DynamicsId: UUID? = null
)

data class UpdatePFVArControllerType2DynamicsEvent(
     val pFVArControllerType2DynamicsId: UUID? = null
)

data class DeletePFVArControllerType2DynamicsEvent(@Id val pFVArControllerType2DynamicsId: UUID? = null)

// single association events

// multiple association events


// PFVArControllerType2UserDefined Events

data class CreatePFVArControllerType2UserDefinedEvent(
    @Id val pFVArControllerType2UserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdatePFVArControllerType2UserDefinedEvent(
    @Id val pFVArControllerType2UserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeletePFVArControllerType2UserDefinedEvent(@Id val pFVArControllerType2UserDefinedId: UUID? = null)

// single association events

// multiple association events


// PFVArType1IEEEPFController Events

data class CreatePFVArType1IEEEPFControllerEvent(
    @Id val pFVArType1IEEEPFControllerId: UUID? = null,
    val ovex: String,
    val tpfc: String,
    val vitmin: String,
    val vpf: String,
    val vpfcbw: String,
    val vpfref: String,
    val vvtmax: String,
    val vvtmin: String
)

data class UpdatePFVArType1IEEEPFControllerEvent(
    @Id val pFVArType1IEEEPFControllerId: UUID? = null,
    val ovex: String,
    val tpfc: String,
    val vitmin: String,
    val vpf: String,
    val vpfcbw: String,
    val vpfref: String,
    val vvtmax: String,
    val vvtmin: String
)

data class DeletePFVArType1IEEEPFControllerEvent(@Id val pFVArType1IEEEPFControllerId: UUID? = null)

// single association events

// multiple association events


// PFVArType1IEEEVArController Events

data class CreatePFVArType1IEEEVArControllerEvent(
    @Id val pFVArType1IEEEVArControllerId: UUID? = null,
    val tvarc: String,
    val vvar: String,
    val vvarcbw: String,
    val vvarref: String,
    val vvtmax: String,
    val vvtmin: String
)

data class UpdatePFVArType1IEEEVArControllerEvent(
    @Id val pFVArType1IEEEVArControllerId: UUID? = null,
    val tvarc: String,
    val vvar: String,
    val vvarcbw: String,
    val vvarref: String,
    val vvtmax: String,
    val vvtmin: String
)

data class DeletePFVArType1IEEEVArControllerEvent(@Id val pFVArType1IEEEVArControllerId: UUID? = null)

// single association events

// multiple association events


// PFVArType2Common1 Events

data class CreatePFVArType2Common1Event(
    @Id val pFVArType2Common1Id: UUID? = null,
    val j: String,
    val ki: String,
    val kp: String,
    val max: String,
    val ref: String
)

data class UpdatePFVArType2Common1Event(
    @Id val pFVArType2Common1Id: UUID? = null,
    val j: String,
    val ki: String,
    val kp: String,
    val max: String,
    val ref: String
)

data class DeletePFVArType2Common1Event(@Id val pFVArType2Common1Id: UUID? = null)

// single association events

// multiple association events


// PFVArType2IEEEPFController Events

data class CreatePFVArType2IEEEPFControllerEvent(
    @Id val pFVArType2IEEEPFControllerId: UUID? = null,
    val exlon: String,
    val ki: String,
    val kp: String,
    val pfref: String,
    val vclmt: String,
    val vref: String,
    val vs: String
)

data class UpdatePFVArType2IEEEPFControllerEvent(
    @Id val pFVArType2IEEEPFControllerId: UUID? = null,
    val exlon: String,
    val ki: String,
    val kp: String,
    val pfref: String,
    val vclmt: String,
    val vref: String,
    val vs: String
)

data class DeletePFVArType2IEEEPFControllerEvent(@Id val pFVArType2IEEEPFControllerId: UUID? = null)

// single association events

// multiple association events


// PFVArType2IEEEVArController Events

data class CreatePFVArType2IEEEVArControllerEvent(
    @Id val pFVArType2IEEEVArControllerId: UUID? = null,
    val exlon: String,
    val ki: String,
    val kp: String,
    val qref: String,
    val vclmt: String,
    val vref: String,
    val vs: String
)

data class UpdatePFVArType2IEEEVArControllerEvent(
    @Id val pFVArType2IEEEVArControllerId: UUID? = null,
    val exlon: String,
    val ki: String,
    val kp: String,
    val qref: String,
    val vclmt: String,
    val vref: String,
    val vs: String
)

data class DeletePFVArType2IEEEVArControllerEvent(@Id val pFVArType2IEEEVArControllerId: UUID? = null)

// single association events

// multiple association events


// PU Events

data class CreatePUEvent(
    @Id val pUId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdatePUEvent(
    @Id val pUId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeletePUEvent(@Id val pUId: UUID? = null)

// single association events

// multiple association events


// PerCent Events

data class CreatePerCentEvent(
    @Id val perCentId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdatePerCentEvent(
    @Id val perCentId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeletePerCentEvent(@Id val perCentId: UUID? = null)

// single association events

// multiple association events


// PerLengthDCLineParameter Events

data class CreatePerLengthDCLineParameterEvent(
    @Id val perLengthDCLineParameterId: UUID? = null,
    val capacitance: String,
    val inductance: String,
    val resistance: String
)

data class UpdatePerLengthDCLineParameterEvent(
    @Id val perLengthDCLineParameterId: UUID? = null,
    val capacitance: String,
    val inductance: String,
    val resistance: String
)

data class DeletePerLengthDCLineParameterEvent(@Id val perLengthDCLineParameterId: UUID? = null)

// single association events

// multiple association events


// PetersenCoil Events

data class CreatePetersenCoilEvent(
    @Id val petersenCoilId: UUID? = null,
    val mode: String,
    val nominalU: String,
    val offsetCurrent: String,
    val positionCurrent: String,
    val xGroundMax: String,
    val xGroundMin: String,
    val xGroundNominal: String
)

data class UpdatePetersenCoilEvent(
    @Id val petersenCoilId: UUID? = null,
    val mode: String,
    val nominalU: String,
    val offsetCurrent: String,
    val positionCurrent: String,
    val xGroundMax: String,
    val xGroundMin: String,
    val xGroundNominal: String
)

data class DeletePetersenCoilEvent(@Id val petersenCoilId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChanger Events

data class CreatePhaseTapChangerEvent(
     val phaseTapChangerId: UUID? = null
)

data class UpdatePhaseTapChangerEvent(
     val phaseTapChangerId: UUID? = null
)

data class DeletePhaseTapChangerEvent(@Id val phaseTapChangerId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerAsymmetrical Events

data class CreatePhaseTapChangerAsymmetricalEvent(
    @Id val phaseTapChangerAsymmetricalId: UUID? = null,
    val windingConnectionAngle: String
)

data class UpdatePhaseTapChangerAsymmetricalEvent(
    @Id val phaseTapChangerAsymmetricalId: UUID? = null,
    val windingConnectionAngle: String
)

data class DeletePhaseTapChangerAsymmetricalEvent(@Id val phaseTapChangerAsymmetricalId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerLinear Events

data class CreatePhaseTapChangerLinearEvent(
    @Id val phaseTapChangerLinearId: UUID? = null,
    val stepPhaseShiftIncrement: String,
    val xMax: String,
    val xMin: String
)

data class UpdatePhaseTapChangerLinearEvent(
    @Id val phaseTapChangerLinearId: UUID? = null,
    val stepPhaseShiftIncrement: String,
    val xMax: String,
    val xMin: String
)

data class DeletePhaseTapChangerLinearEvent(@Id val phaseTapChangerLinearId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerNonLinear Events

data class CreatePhaseTapChangerNonLinearEvent(
    @Id val phaseTapChangerNonLinearId: UUID? = null,
    val voltageStepIncrement: String,
    val xMax: String,
    val xMin: String
)

data class UpdatePhaseTapChangerNonLinearEvent(
    @Id val phaseTapChangerNonLinearId: UUID? = null,
    val voltageStepIncrement: String,
    val xMax: String,
    val xMin: String
)

data class DeletePhaseTapChangerNonLinearEvent(@Id val phaseTapChangerNonLinearId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerSymmetrical Events

data class CreatePhaseTapChangerSymmetricalEvent(
     val phaseTapChangerSymmetricalId: UUID? = null
)

data class UpdatePhaseTapChangerSymmetricalEvent(
     val phaseTapChangerSymmetricalId: UUID? = null
)

data class DeletePhaseTapChangerSymmetricalEvent(@Id val phaseTapChangerSymmetricalId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerTable Events

data class CreatePhaseTapChangerTableEvent(
     val phaseTapChangerTableId: UUID? = null
)

data class UpdatePhaseTapChangerTableEvent(
     val phaseTapChangerTableId: UUID? = null
)

data class DeletePhaseTapChangerTableEvent(@Id val phaseTapChangerTableId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerTablePoint Events

data class CreatePhaseTapChangerTablePointEvent(
    @Id val phaseTapChangerTablePointId: UUID? = null,
    val angle: String
)

data class UpdatePhaseTapChangerTablePointEvent(
    @Id val phaseTapChangerTablePointId: UUID? = null,
    val angle: String
)

data class DeletePhaseTapChangerTablePointEvent(@Id val phaseTapChangerTablePointId: UUID? = null)

// single association events

// multiple association events


// PhaseTapChangerTabular Events

data class CreatePhaseTapChangerTabularEvent(
     val phaseTapChangerTabularId: UUID? = null
)

data class UpdatePhaseTapChangerTabularEvent(
     val phaseTapChangerTabularId: UUID? = null
)

data class DeletePhaseTapChangerTabularEvent(@Id val phaseTapChangerTabularId: UUID? = null)

// single association events

// multiple association events


// PositionPoint Events

data class CreatePositionPointEvent(
    @Id val positionPointId: UUID? = null,
    val sequenceNumber: String,
    val xPosition: String,
    val yPosition: String,
    val zPosition: String
)

data class UpdatePositionPointEvent(
    @Id val positionPointId: UUID? = null,
    val sequenceNumber: String,
    val xPosition: String,
    val yPosition: String,
    val zPosition: String
)

data class DeletePositionPointEvent(@Id val positionPointId: UUID? = null)

// single association events

// multiple association events


// PowerSystemResource Events

data class CreatePowerSystemResourceEvent(
     val powerSystemResourceId: UUID? = null
)

data class UpdatePowerSystemResourceEvent(
     val powerSystemResourceId: UUID? = null
)

data class DeletePowerSystemResourceEvent(@Id val powerSystemResourceId: UUID? = null)

// single association events

// multiple association events


// PowerSystemStabilizerDynamics Events

data class CreatePowerSystemStabilizerDynamicsEvent(
     val powerSystemStabilizerDynamicsId: UUID? = null
)

data class UpdatePowerSystemStabilizerDynamicsEvent(
     val powerSystemStabilizerDynamicsId: UUID? = null
)

data class DeletePowerSystemStabilizerDynamicsEvent(@Id val powerSystemStabilizerDynamicsId: UUID? = null)

// single association events

// multiple association events


// PowerSystemStabilizerUserDefined Events

data class CreatePowerSystemStabilizerUserDefinedEvent(
    @Id val powerSystemStabilizerUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdatePowerSystemStabilizerUserDefinedEvent(
    @Id val powerSystemStabilizerUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeletePowerSystemStabilizerUserDefinedEvent(@Id val powerSystemStabilizerUserDefinedId: UUID? = null)

// single association events

// multiple association events


// PowerTransformer Events

data class CreatePowerTransformerEvent(
    @Id val powerTransformerId: UUID? = null,
    val beforeShCircuitHighestOperatingCurrent: String,
    val beforeShCircuitHighestOperatingVoltage: String,
    val beforeShortCircuitAnglePf: String,
    val highSideMinOperatingU: String,
    val isPartOfGeneratorUnit: String,
    val operationalValuesConsidered: String
)

data class UpdatePowerTransformerEvent(
    @Id val powerTransformerId: UUID? = null,
    val beforeShCircuitHighestOperatingCurrent: String,
    val beforeShCircuitHighestOperatingVoltage: String,
    val beforeShortCircuitAnglePf: String,
    val highSideMinOperatingU: String,
    val isPartOfGeneratorUnit: String,
    val operationalValuesConsidered: String
)

data class DeletePowerTransformerEvent(@Id val powerTransformerId: UUID? = null)

// single association events

// multiple association events


// PowerTransformerEnd Events

data class CreatePowerTransformerEndEvent(
    @Id val powerTransformerEndId: UUID? = null,
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

data class UpdatePowerTransformerEndEvent(
    @Id val powerTransformerEndId: UUID? = null,
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

data class DeletePowerTransformerEndEvent(@Id val powerTransformerEndId: UUID? = null)

// single association events

// multiple association events


// ProprietaryParameterDynamics Events

data class CreateProprietaryParameterDynamicsEvent(
    @Id val proprietaryParameterDynamicsId: UUID? = null,
    val booleanParameterValue: String,
    val floatParameterValue: String,
    val integerParameterValue: String,
    val parameterNumber: String
)

data class UpdateProprietaryParameterDynamicsEvent(
    @Id val proprietaryParameterDynamicsId: UUID? = null,
    val booleanParameterValue: String,
    val floatParameterValue: String,
    val integerParameterValue: String,
    val parameterNumber: String
)

data class DeleteProprietaryParameterDynamicsEvent(@Id val proprietaryParameterDynamicsId: UUID? = null)

// single association events

// multiple association events


// ProtectedSwitch Events

data class CreateProtectedSwitchEvent(
     val protectedSwitchId: UUID? = null
)

data class UpdateProtectedSwitchEvent(
     val protectedSwitchId: UUID? = null
)

data class DeleteProtectedSwitchEvent(@Id val protectedSwitchId: UUID? = null)

// single association events

// multiple association events


// Pss1 Events

data class CreatePss1Event(
    @Id val pss1Id: UUID? = null,
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

data class UpdatePss1Event(
    @Id val pss1Id: UUID? = null,
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

data class DeletePss1Event(@Id val pss1Id: UUID? = null)

// single association events

// multiple association events


// Pss1A Events

data class CreatePss1AEvent(
    @Id val pss1AId: UUID? = null,
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

data class UpdatePss1AEvent(
    @Id val pss1AId: UUID? = null,
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

data class DeletePss1AEvent(@Id val pss1AId: UUID? = null)

// single association events

// multiple association events


// Pss2B Events

data class CreatePss2BEvent(
    @Id val pss2BId: UUID? = null,
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

data class UpdatePss2BEvent(
    @Id val pss2BId: UUID? = null,
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

data class DeletePss2BEvent(@Id val pss2BId: UUID? = null)

// single association events

// multiple association events


// Pss2ST Events

data class CreatePss2STEvent(
    @Id val pss2STId: UUID? = null,
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

data class UpdatePss2STEvent(
    @Id val pss2STId: UUID? = null,
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

data class DeletePss2STEvent(@Id val pss2STId: UUID? = null)

// single association events

// multiple association events


// Pss5 Events

data class CreatePss5Event(
    @Id val pss5Id: UUID? = null,
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

data class UpdatePss5Event(
    @Id val pss5Id: UUID? = null,
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

data class DeletePss5Event(@Id val pss5Id: UUID? = null)

// single association events

// multiple association events


// PssELIN2 Events

data class CreatePssELIN2Event(
    @Id val pssELIN2Id: UUID? = null,
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

data class UpdatePssELIN2Event(
    @Id val pssELIN2Id: UUID? = null,
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

data class DeletePssELIN2Event(@Id val pssELIN2Id: UUID? = null)

// single association events

// multiple association events


// PssIEEE1A Events

data class CreatePssIEEE1AEvent(
    @Id val pssIEEE1AId: UUID? = null,
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

data class UpdatePssIEEE1AEvent(
    @Id val pssIEEE1AId: UUID? = null,
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

data class DeletePssIEEE1AEvent(@Id val pssIEEE1AId: UUID? = null)

// single association events

// multiple association events


// PssIEEE2B Events

data class CreatePssIEEE2BEvent(
    @Id val pssIEEE2BId: UUID? = null,
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

data class UpdatePssIEEE2BEvent(
    @Id val pssIEEE2BId: UUID? = null,
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

data class DeletePssIEEE2BEvent(@Id val pssIEEE2BId: UUID? = null)

// single association events

// multiple association events


// PssIEEE3B Events

data class CreatePssIEEE3BEvent(
    @Id val pssIEEE3BId: UUID? = null,
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

data class UpdatePssIEEE3BEvent(
    @Id val pssIEEE3BId: UUID? = null,
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

data class DeletePssIEEE3BEvent(@Id val pssIEEE3BId: UUID? = null)

// single association events

// multiple association events


// PssIEEE4B Events

data class CreatePssIEEE4BEvent(
    @Id val pssIEEE4BId: UUID? = null,
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

data class UpdatePssIEEE4BEvent(
    @Id val pssIEEE4BId: UUID? = null,
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

data class DeletePssIEEE4BEvent(@Id val pssIEEE4BId: UUID? = null)

// single association events

// multiple association events


// PssPTIST1 Events

data class CreatePssPTIST1Event(
    @Id val pssPTIST1Id: UUID? = null,
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

data class UpdatePssPTIST1Event(
    @Id val pssPTIST1Id: UUID? = null,
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

data class DeletePssPTIST1Event(@Id val pssPTIST1Id: UUID? = null)

// single association events

// multiple association events


// PssPTIST3 Events

data class CreatePssPTIST3Event(
    @Id val pssPTIST3Id: UUID? = null,
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

data class UpdatePssPTIST3Event(
    @Id val pssPTIST3Id: UUID? = null,
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

data class DeletePssPTIST3Event(@Id val pssPTIST3Id: UUID? = null)

// single association events

// multiple association events


// PssSB4 Events

data class CreatePssSB4Event(
    @Id val pssSB4Id: UUID? = null,
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

data class UpdatePssSB4Event(
    @Id val pssSB4Id: UUID? = null,
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

data class DeletePssSB4Event(@Id val pssSB4Id: UUID? = null)

// single association events

// multiple association events


// PssSH Events

data class CreatePssSHEvent(
    @Id val pssSHId: UUID? = null,
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

data class UpdatePssSHEvent(
    @Id val pssSHId: UUID? = null,
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

data class DeletePssSHEvent(@Id val pssSHId: UUID? = null)

// single association events

// multiple association events


// PssSK Events

data class CreatePssSKEvent(
    @Id val pssSKId: UUID? = null,
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

data class UpdatePssSKEvent(
    @Id val pssSKId: UUID? = null,
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

data class DeletePssSKEvent(@Id val pssSKId: UUID? = null)

// single association events

// multiple association events


// PssWECC Events

data class CreatePssWECCEvent(
    @Id val pssWECCId: UUID? = null,
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

data class UpdatePssWECCEvent(
    @Id val pssWECCId: UUID? = null,
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

data class DeletePssWECCEvent(@Id val pssWECCId: UUID? = null)

// single association events

// multiple association events


// Quality61850 Events

data class CreateQuality61850Event(
    @Id val quality61850Id: UUID? = null,
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

data class UpdateQuality61850Event(
    @Id val quality61850Id: UUID? = null,
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

data class DeleteQuality61850Event(@Id val quality61850Id: UUID? = null)

// single association events

// multiple association events


// RaiseLowerCommand Events

data class CreateRaiseLowerCommandEvent(
     val raiseLowerCommandId: UUID? = null
)

data class UpdateRaiseLowerCommandEvent(
     val raiseLowerCommandId: UUID? = null
)

data class DeleteRaiseLowerCommandEvent(@Id val raiseLowerCommandId: UUID? = null)

// single association events

// multiple association events


// RatioTapChanger Events

data class CreateRatioTapChangerEvent(
    @Id val ratioTapChangerId: UUID? = null,
    val stepVoltageIncrement: String,
    val tculControlMode: String
)

data class UpdateRatioTapChangerEvent(
    @Id val ratioTapChangerId: UUID? = null,
    val stepVoltageIncrement: String,
    val tculControlMode: String
)

data class DeleteRatioTapChangerEvent(@Id val ratioTapChangerId: UUID? = null)

// single association events

// multiple association events


// RatioTapChangerTable Events

data class CreateRatioTapChangerTableEvent(
     val ratioTapChangerTableId: UUID? = null
)

data class UpdateRatioTapChangerTableEvent(
     val ratioTapChangerTableId: UUID? = null
)

data class DeleteRatioTapChangerTableEvent(@Id val ratioTapChangerTableId: UUID? = null)

// single association events

// multiple association events


// RatioTapChangerTablePoint Events

data class CreateRatioTapChangerTablePointEvent(
     val ratioTapChangerTablePointId: UUID? = null
)

data class UpdateRatioTapChangerTablePointEvent(
     val ratioTapChangerTablePointId: UUID? = null
)

data class DeleteRatioTapChangerTablePointEvent(@Id val ratioTapChangerTablePointId: UUID? = null)

// single association events

// multiple association events


// Reactance Events

data class CreateReactanceEvent(
    @Id val reactanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateReactanceEvent(
    @Id val reactanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteReactanceEvent(@Id val reactanceId: UUID? = null)

// single association events

// multiple association events


// ReactiveCapabilityCurve Events

data class CreateReactiveCapabilityCurveEvent(
     val reactiveCapabilityCurveId: UUID? = null
)

data class UpdateReactiveCapabilityCurveEvent(
     val reactiveCapabilityCurveId: UUID? = null
)

data class DeleteReactiveCapabilityCurveEvent(@Id val reactiveCapabilityCurveId: UUID? = null)

// single association events

// multiple association events


// ReactivePower Events

data class CreateReactivePowerEvent(
    @Id val reactivePowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateReactivePowerEvent(
    @Id val reactivePowerId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteReactivePowerEvent(@Id val reactivePowerId: UUID? = null)

// single association events

// multiple association events


// RegularIntervalSchedule Events

data class CreateRegularIntervalScheduleEvent(
    @Id val regularIntervalScheduleId: UUID? = null,
    val endTime: String,
    val timeStep: String
)

data class UpdateRegularIntervalScheduleEvent(
    @Id val regularIntervalScheduleId: UUID? = null,
    val endTime: String,
    val timeStep: String
)

data class DeleteRegularIntervalScheduleEvent(@Id val regularIntervalScheduleId: UUID? = null)

// single association events

// multiple association events


// RegularTimePoint Events

data class CreateRegularTimePointEvent(
    @Id val regularTimePointId: UUID? = null,
    val sequenceNumber: String,
    val value1: String,
    val value2: String
)

data class UpdateRegularTimePointEvent(
    @Id val regularTimePointId: UUID? = null,
    val sequenceNumber: String,
    val value1: String,
    val value2: String
)

data class DeleteRegularTimePointEvent(@Id val regularTimePointId: UUID? = null)

// single association events

// multiple association events


// RegulatingCondEq Events

data class CreateRegulatingCondEqEvent(
     val regulatingCondEqId: UUID? = null
)

data class UpdateRegulatingCondEqEvent(
     val regulatingCondEqId: UUID? = null
)

data class DeleteRegulatingCondEqEvent(@Id val regulatingCondEqId: UUID? = null)

// single association events

// multiple association events


// RegulatingControl Events

data class CreateRegulatingControlEvent(
    @Id val regulatingControlId: UUID? = null,
    val mode: String
)

data class UpdateRegulatingControlEvent(
    @Id val regulatingControlId: UUID? = null,
    val mode: String
)

data class DeleteRegulatingControlEvent(@Id val regulatingControlId: UUID? = null)

// single association events

// multiple association events


// RegulationSchedule Events

data class CreateRegulationScheduleEvent(
     val regulationScheduleId: UUID? = null
)

data class UpdateRegulationScheduleEvent(
     val regulationScheduleId: UUID? = null
)

data class DeleteRegulationScheduleEvent(@Id val regulationScheduleId: UUID? = null)

// single association events

// multiple association events


// RemoteInputSignal Events

data class CreateRemoteInputSignalEvent(
    @Id val remoteInputSignalId: UUID? = null,
    val remoteSignalType: String
)

data class UpdateRemoteInputSignalEvent(
    @Id val remoteInputSignalId: UUID? = null,
    val remoteSignalType: String
)

data class DeleteRemoteInputSignalEvent(@Id val remoteInputSignalId: UUID? = null)

// single association events

// multiple association events


// ReportingGroup Events

data class CreateReportingGroupEvent(
     val reportingGroupId: UUID? = null
)

data class UpdateReportingGroupEvent(
     val reportingGroupId: UUID? = null
)

data class DeleteReportingGroupEvent(@Id val reportingGroupId: UUID? = null)

// single association events

// multiple association events


// Resistance Events

data class CreateResistanceEvent(
    @Id val resistanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateResistanceEvent(
    @Id val resistanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteResistanceEvent(@Id val resistanceId: UUID? = null)

// single association events

// multiple association events


// ResistancePerLength Events

data class CreateResistancePerLengthEvent(
    @Id val resistancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateResistancePerLengthEvent(
    @Id val resistancePerLengthId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteResistancePerLengthEvent(@Id val resistancePerLengthId: UUID? = null)

// single association events

// multiple association events


// RotatingMachine Events

data class CreateRotatingMachineEvent(
    @Id val rotatingMachineId: UUID? = null,
    val ratedPowerFactor: String,
    val ratedS: String,
    val ratedU: String
)

data class UpdateRotatingMachineEvent(
    @Id val rotatingMachineId: UUID? = null,
    val ratedPowerFactor: String,
    val ratedS: String,
    val ratedU: String
)

data class DeleteRotatingMachineEvent(@Id val rotatingMachineId: UUID? = null)

// single association events

// multiple association events


// RotatingMachineDynamics Events

data class CreateRotatingMachineDynamicsEvent(
    @Id val rotatingMachineDynamicsId: UUID? = null,
    val damping: String,
    val inertia: String,
    val saturationFactor: String,
    val saturationFactor120: String,
    val statorLeakageReactance: String,
    val statorResistance: String
)

data class UpdateRotatingMachineDynamicsEvent(
    @Id val rotatingMachineDynamicsId: UUID? = null,
    val damping: String,
    val inertia: String,
    val saturationFactor: String,
    val saturationFactor120: String,
    val statorLeakageReactance: String,
    val statorResistance: String
)

data class DeleteRotatingMachineDynamicsEvent(@Id val rotatingMachineDynamicsId: UUID? = null)

// single association events

// multiple association events


// RotationSpeed Events

data class CreateRotationSpeedEvent(
    @Id val rotationSpeedId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateRotationSpeedEvent(
    @Id val rotationSpeedId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteRotationSpeedEvent(@Id val rotationSpeedId: UUID? = null)

// single association events

// multiple association events


// Season Events

data class CreateSeasonEvent(
    @Id val seasonId: UUID? = null,
    val endDate: String,
    val startDate: String
)

data class UpdateSeasonEvent(
    @Id val seasonId: UUID? = null,
    val endDate: String,
    val startDate: String
)

data class DeleteSeasonEvent(@Id val seasonId: UUID? = null)

// single association events

// multiple association events


// SeasonDayTypeSchedule Events

data class CreateSeasonDayTypeScheduleEvent(
     val seasonDayTypeScheduleId: UUID? = null
)

data class UpdateSeasonDayTypeScheduleEvent(
     val seasonDayTypeScheduleId: UUID? = null
)

data class DeleteSeasonDayTypeScheduleEvent(@Id val seasonDayTypeScheduleId: UUID? = null)

// single association events

// multiple association events


// Seconds Events

data class CreateSecondsEvent(
    @Id val secondsId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateSecondsEvent(
    @Id val secondsId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteSecondsEvent(@Id val secondsId: UUID? = null)

// single association events

// multiple association events


// SeriesCompensator Events

data class CreateSeriesCompensatorEvent(
    @Id val seriesCompensatorId: UUID? = null,
    val r: String,
    val r0: String,
    val varistorPresent: String,
    val varistorRatedCurrent: String,
    val varistorVoltageThreshold: String,
    val x: String,
    val x0: String
)

data class UpdateSeriesCompensatorEvent(
    @Id val seriesCompensatorId: UUID? = null,
    val r: String,
    val r0: String,
    val varistorPresent: String,
    val varistorRatedCurrent: String,
    val varistorVoltageThreshold: String,
    val x: String,
    val x0: String
)

data class DeleteSeriesCompensatorEvent(@Id val seriesCompensatorId: UUID? = null)

// single association events

// multiple association events


// SetPoint Events

data class CreateSetPointEvent(
    @Id val setPointId: UUID? = null,
    val normalValue: String,
    val value: String
)

data class UpdateSetPointEvent(
    @Id val setPointId: UUID? = null,
    val normalValue: String,
    val value: String
)

data class DeleteSetPointEvent(@Id val setPointId: UUID? = null)

// single association events

// multiple association events


// ShuntCompensator Events

data class CreateShuntCompensatorEvent(
    @Id val shuntCompensatorId: UUID? = null,
    val aVRDelay: String,
    val grounded: String,
    val maximumSections: String,
    val nomU: String,
    val normalSections: String,
    val switchOnCount: String,
    val switchOnDate: String,
    val voltageSensitivity: String
)

data class UpdateShuntCompensatorEvent(
    @Id val shuntCompensatorId: UUID? = null,
    val aVRDelay: String,
    val grounded: String,
    val maximumSections: String,
    val nomU: String,
    val normalSections: String,
    val switchOnCount: String,
    val switchOnDate: String,
    val voltageSensitivity: String
)

data class DeleteShuntCompensatorEvent(@Id val shuntCompensatorId: UUID? = null)

// single association events

// multiple association events


// Simple_Float Events

data class CreateSimple_FloatEvent(
    @Id val simple_FloatId: UUID? = null,
    val value: String
)

data class UpdateSimple_FloatEvent(
    @Id val simple_FloatId: UUID? = null,
    val value: String
)

data class DeleteSimple_FloatEvent(@Id val simple_FloatId: UUID? = null)

// single association events

// multiple association events


// SolarGeneratingUnit Events

data class CreateSolarGeneratingUnitEvent(
     val solarGeneratingUnitId: UUID? = null
)

data class UpdateSolarGeneratingUnitEvent(
     val solarGeneratingUnitId: UUID? = null
)

data class DeleteSolarGeneratingUnitEvent(@Id val solarGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// StateVariablesVersion Events

data class CreateStateVariablesVersionEvent(
    @Id val stateVariablesVersionId: UUID? = null,
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

data class UpdateStateVariablesVersionEvent(
    @Id val stateVariablesVersionId: UUID? = null,
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

data class DeleteStateVariablesVersionEvent(@Id val stateVariablesVersionId: UUID? = null)

// single association events

// multiple association events


// StaticVarCompensator Events

data class CreateStaticVarCompensatorEvent(
    @Id val staticVarCompensatorId: UUID? = null,
    val capacitiveRating: String,
    val inductiveRating: String,
    val slope: String,
    val sVCControlMode: String,
    val voltageSetPoint: String
)

data class UpdateStaticVarCompensatorEvent(
    @Id val staticVarCompensatorId: UUID? = null,
    val capacitiveRating: String,
    val inductiveRating: String,
    val slope: String,
    val sVCControlMode: String,
    val voltageSetPoint: String
)

data class DeleteStaticVarCompensatorEvent(@Id val staticVarCompensatorId: UUID? = null)

// single association events

// multiple association events


// Staticpowersystemmodel Events

data class CreateStaticpowersystemmodelEvent(
     val staticpowersystemmodelId: UUID? = null
)

data class UpdateStaticpowersystemmodelEvent(
     val staticpowersystemmodelId: UUID? = null
)

data class DeleteStaticpowersystemmodelEvent(@Id val staticpowersystemmodelId: UUID? = null)

// single association events

// multiple association events


// StationSupply Events

data class CreateStationSupplyEvent(
     val stationSupplyId: UUID? = null
)

data class UpdateStationSupplyEvent(
     val stationSupplyId: UUID? = null
)

data class DeleteStationSupplyEvent(@Id val stationSupplyId: UUID? = null)

// single association events

// multiple association events


// SteadyStateHypothesisVersion Events

data class CreateSteadyStateHypothesisVersionEvent(
    @Id val steadyStateHypothesisVersionId: UUID? = null,
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

data class UpdateSteadyStateHypothesisVersionEvent(
    @Id val steadyStateHypothesisVersionId: UUID? = null,
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

data class DeleteSteadyStateHypothesisVersionEvent(@Id val steadyStateHypothesisVersionId: UUID? = null)

// single association events

// multiple association events


// StringMeasurement Events

data class CreateStringMeasurementEvent(
     val stringMeasurementId: UUID? = null
)

data class UpdateStringMeasurementEvent(
     val stringMeasurementId: UUID? = null
)

data class DeleteStringMeasurementEvent(@Id val stringMeasurementId: UUID? = null)

// single association events

// multiple association events


// StringMeasurementValue Events

data class CreateStringMeasurementValueEvent(
    @Id val stringMeasurementValueId: UUID? = null,
    val value: String
)

data class UpdateStringMeasurementValueEvent(
    @Id val stringMeasurementValueId: UUID? = null,
    val value: String
)

data class DeleteStringMeasurementValueEvent(@Id val stringMeasurementValueId: UUID? = null)

// single association events

// multiple association events


// StringProxy Events

data class CreateStringProxyEvent(
     val stringProxyId: UUID? = null
)

data class UpdateStringProxyEvent(
     val stringProxyId: UUID? = null
)

data class DeleteStringProxyEvent(@Id val stringProxyId: UUID? = null)

// single association events

// multiple association events


// SubGeographicalRegion Events

data class CreateSubGeographicalRegionEvent(
     val subGeographicalRegionId: UUID? = null
)

data class UpdateSubGeographicalRegionEvent(
     val subGeographicalRegionId: UUID? = null
)

data class DeleteSubGeographicalRegionEvent(@Id val subGeographicalRegionId: UUID? = null)

// single association events

// multiple association events


// SubLoadArea Events

data class CreateSubLoadAreaEvent(
     val subLoadAreaId: UUID? = null
)

data class UpdateSubLoadAreaEvent(
     val subLoadAreaId: UUID? = null
)

data class DeleteSubLoadAreaEvent(@Id val subLoadAreaId: UUID? = null)

// single association events

// multiple association events


// Substation Events

data class CreateSubstationEvent(
     val substationId: UUID? = null
)

data class UpdateSubstationEvent(
     val substationId: UUID? = null
)

data class DeleteSubstationEvent(@Id val substationId: UUID? = null)

// single association events

// multiple association events


// Susceptance Events

data class CreateSusceptanceEvent(
    @Id val susceptanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateSusceptanceEvent(
    @Id val susceptanceId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteSusceptanceEvent(@Id val susceptanceId: UUID? = null)

// single association events

// multiple association events


// SvInjection Events

data class CreateSvInjectionEvent(
    @Id val svInjectionId: UUID? = null,
    val pInjection: String,
    val qInjection: String
)

data class UpdateSvInjectionEvent(
    @Id val svInjectionId: UUID? = null,
    val pInjection: String,
    val qInjection: String
)

data class DeleteSvInjectionEvent(@Id val svInjectionId: UUID? = null)

// single association events

// multiple association events


// SvPowerFlow Events

data class CreateSvPowerFlowEvent(
    @Id val svPowerFlowId: UUID? = null,
    val p: String,
    val q: String
)

data class UpdateSvPowerFlowEvent(
    @Id val svPowerFlowId: UUID? = null,
    val p: String,
    val q: String
)

data class DeleteSvPowerFlowEvent(@Id val svPowerFlowId: UUID? = null)

// single association events

// multiple association events


// SvShuntCompensatorSections Events

data class CreateSvShuntCompensatorSectionsEvent(
    @Id val svShuntCompensatorSectionsId: UUID? = null,
    val sections: String
)

data class UpdateSvShuntCompensatorSectionsEvent(
    @Id val svShuntCompensatorSectionsId: UUID? = null,
    val sections: String
)

data class DeleteSvShuntCompensatorSectionsEvent(@Id val svShuntCompensatorSectionsId: UUID? = null)

// single association events

// multiple association events


// SvStatus Events

data class CreateSvStatusEvent(
    @Id val svStatusId: UUID? = null,
    val inService: String
)

data class UpdateSvStatusEvent(
    @Id val svStatusId: UUID? = null,
    val inService: String
)

data class DeleteSvStatusEvent(@Id val svStatusId: UUID? = null)

// single association events

// multiple association events


// SvTapStep Events

data class CreateSvTapStepEvent(
    @Id val svTapStepId: UUID? = null,
    val position: String
)

data class UpdateSvTapStepEvent(
    @Id val svTapStepId: UUID? = null,
    val position: String
)

data class DeleteSvTapStepEvent(@Id val svTapStepId: UUID? = null)

// single association events

// multiple association events


// SvVoltage Events

data class CreateSvVoltageEvent(
    @Id val svVoltageId: UUID? = null,
    val angle: String,
    val v: String
)

data class UpdateSvVoltageEvent(
    @Id val svVoltageId: UUID? = null,
    val angle: String,
    val v: String
)

data class DeleteSvVoltageEvent(@Id val svVoltageId: UUID? = null)

// single association events

// multiple association events


// SwitchIt Events

data class CreateSwitchItEvent(
    @Id val switchItId: UUID? = null,
    val open: String
)

data class UpdateSwitchItEvent(
    @Id val switchItId: UUID? = null,
    val open: String
)

data class DeleteSwitchItEvent(@Id val switchItId: UUID? = null)

// single association events

// multiple association events


// SwitchProxy Events

data class CreateSwitchProxyEvent(
    @Id val switchProxyId: UUID? = null,
    val normalOpen: String,
    val ratedCurrent: String,
    val retained: String
)

data class UpdateSwitchProxyEvent(
    @Id val switchProxyId: UUID? = null,
    val normalOpen: String,
    val ratedCurrent: String,
    val retained: String
)

data class DeleteSwitchProxyEvent(@Id val switchProxyId: UUID? = null)

// single association events

// multiple association events


// SwitchSchedule Events

data class CreateSwitchScheduleEvent(
     val switchScheduleId: UUID? = null
)

data class UpdateSwitchScheduleEvent(
     val switchScheduleId: UUID? = null
)

data class DeleteSwitchScheduleEvent(@Id val switchScheduleId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachine Events

data class CreateSynchronousMachineEvent(
    @Id val synchronousMachineId: UUID? = null,
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

data class UpdateSynchronousMachineEvent(
    @Id val synchronousMachineId: UUID? = null,
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

data class DeleteSynchronousMachineEvent(@Id val synchronousMachineId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineDetailed Events

data class CreateSynchronousMachineDetailedEvent(
    @Id val synchronousMachineDetailedId: UUID? = null,
    val efdBaseRatio: String,
    val ifdBaseType: String,
    val ifdBaseValue: String,
    val saturationFactor120QAxis: String,
    val saturationFactorQAxis: String
)

data class UpdateSynchronousMachineDetailedEvent(
    @Id val synchronousMachineDetailedId: UUID? = null,
    val efdBaseRatio: String,
    val ifdBaseType: String,
    val ifdBaseValue: String,
    val saturationFactor120QAxis: String,
    val saturationFactorQAxis: String
)

data class DeleteSynchronousMachineDetailedEvent(@Id val synchronousMachineDetailedId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineDynamics Events

data class CreateSynchronousMachineDynamicsEvent(
     val synchronousMachineDynamicsId: UUID? = null
)

data class UpdateSynchronousMachineDynamicsEvent(
     val synchronousMachineDynamicsId: UUID? = null
)

data class DeleteSynchronousMachineDynamicsEvent(@Id val synchronousMachineDynamicsId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineEquivalentCircuit Events

data class CreateSynchronousMachineEquivalentCircuitEvent(
    @Id val synchronousMachineEquivalentCircuitId: UUID? = null,
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

data class UpdateSynchronousMachineEquivalentCircuitEvent(
    @Id val synchronousMachineEquivalentCircuitId: UUID? = null,
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

data class DeleteSynchronousMachineEquivalentCircuitEvent(@Id val synchronousMachineEquivalentCircuitId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineSimplified Events

data class CreateSynchronousMachineSimplifiedEvent(
     val synchronousMachineSimplifiedId: UUID? = null
)

data class UpdateSynchronousMachineSimplifiedEvent(
     val synchronousMachineSimplifiedId: UUID? = null
)

data class DeleteSynchronousMachineSimplifiedEvent(@Id val synchronousMachineSimplifiedId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineTimeConstantReactance Events

data class CreateSynchronousMachineTimeConstantReactanceEvent(
    @Id val synchronousMachineTimeConstantReactanceId: UUID? = null,
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

data class UpdateSynchronousMachineTimeConstantReactanceEvent(
    @Id val synchronousMachineTimeConstantReactanceId: UUID? = null,
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

data class DeleteSynchronousMachineTimeConstantReactanceEvent(@Id val synchronousMachineTimeConstantReactanceId: UUID? = null)

// single association events

// multiple association events


// SynchronousMachineUserDefined Events

data class CreateSynchronousMachineUserDefinedEvent(
    @Id val synchronousMachineUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateSynchronousMachineUserDefinedEvent(
    @Id val synchronousMachineUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteSynchronousMachineUserDefinedEvent(@Id val synchronousMachineUserDefinedId: UUID? = null)

// single association events

// multiple association events


// TapChanger Events

data class CreateTapChangerEvent(
    @Id val tapChangerId: UUID? = null,
    val highStep: String,
    val lowStep: String,
    val ltcFlag: String,
    val neutralStep: String,
    val neutralU: String,
    val normalStep: String
)

data class UpdateTapChangerEvent(
    @Id val tapChangerId: UUID? = null,
    val highStep: String,
    val lowStep: String,
    val ltcFlag: String,
    val neutralStep: String,
    val neutralU: String,
    val normalStep: String
)

data class DeleteTapChangerEvent(@Id val tapChangerId: UUID? = null)

// single association events

// multiple association events


// TapChangerControl Events

data class CreateTapChangerControlEvent(
     val tapChangerControlId: UUID? = null
)

data class UpdateTapChangerControlEvent(
     val tapChangerControlId: UUID? = null
)

data class DeleteTapChangerControlEvent(@Id val tapChangerControlId: UUID? = null)

// single association events

// multiple association events


// TapChangerTablePoint Events

data class CreateTapChangerTablePointEvent(
    @Id val tapChangerTablePointId: UUID? = null,
    val b: String,
    val g: String,
    val r: String,
    val ratio: String,
    val step: String,
    val x: String
)

data class UpdateTapChangerTablePointEvent(
    @Id val tapChangerTablePointId: UUID? = null,
    val b: String,
    val g: String,
    val r: String,
    val ratio: String,
    val step: String,
    val x: String
)

data class DeleteTapChangerTablePointEvent(@Id val tapChangerTablePointId: UUID? = null)

// single association events

// multiple association events


// TapSchedule Events

data class CreateTapScheduleEvent(
     val tapScheduleId: UUID? = null
)

data class UpdateTapScheduleEvent(
     val tapScheduleId: UUID? = null
)

data class DeleteTapScheduleEvent(@Id val tapScheduleId: UUID? = null)

// single association events

// multiple association events


// Temperature Events

data class CreateTemperatureEvent(
    @Id val temperatureId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateTemperatureEvent(
    @Id val temperatureId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteTemperatureEvent(@Id val temperatureId: UUID? = null)

// single association events

// multiple association events


// Terminal Events

data class CreateTerminalEvent(
     val terminalId: UUID? = null
)

data class UpdateTerminalEvent(
     val terminalId: UUID? = null
)

data class DeleteTerminalEvent(@Id val terminalId: UUID? = null)

// single association events

// multiple association events


// TextDiagramObject Events

data class CreateTextDiagramObjectEvent(
    @Id val textDiagramObjectId: UUID? = null,
    val text: String
)

data class UpdateTextDiagramObjectEvent(
    @Id val textDiagramObjectId: UUID? = null,
    val text: String
)

data class DeleteTextDiagramObjectEvent(@Id val textDiagramObjectId: UUID? = null)

// single association events

// multiple association events


// ThermalGeneratingUnit Events

data class CreateThermalGeneratingUnitEvent(
     val thermalGeneratingUnitId: UUID? = null
)

data class UpdateThermalGeneratingUnitEvent(
     val thermalGeneratingUnitId: UUID? = null
)

data class DeleteThermalGeneratingUnitEvent(@Id val thermalGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// TieFlow Events

data class CreateTieFlowEvent(
    @Id val tieFlowId: UUID? = null,
    val positiveFlowIn: String
)

data class UpdateTieFlowEvent(
    @Id val tieFlowId: UUID? = null,
    val positiveFlowIn: String
)

data class DeleteTieFlowEvent(@Id val tieFlowId: UUID? = null)

// single association events

// multiple association events


// TopologicalIsland Events

data class CreateTopologicalIslandEvent(
     val topologicalIslandId: UUID? = null
)

data class UpdateTopologicalIslandEvent(
     val topologicalIslandId: UUID? = null
)

data class DeleteTopologicalIslandEvent(@Id val topologicalIslandId: UUID? = null)

// single association events

// multiple association events


// TopologicalNode Events

data class CreateTopologicalNodeEvent(
    @Id val topologicalNodeId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class UpdateTopologicalNodeEvent(
    @Id val topologicalNodeId: UUID? = null,
    val boundaryPoint: String,
    val fromEndIsoCode: String,
    val fromEndName: String,
    val fromEndNameTso: String,
    val toEndIsoCode: String,
    val toEndName: String,
    val toEndNameTso: String
)

data class DeleteTopologicalNodeEvent(@Id val topologicalNodeId: UUID? = null)

// single association events

// multiple association events


// TopologyBoundaryVersion Events

data class CreateTopologyBoundaryVersionEvent(
    @Id val topologyBoundaryVersionId: UUID? = null,
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

data class UpdateTopologyBoundaryVersionEvent(
    @Id val topologyBoundaryVersionId: UUID? = null,
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

data class DeleteTopologyBoundaryVersionEvent(@Id val topologyBoundaryVersionId: UUID? = null)

// single association events

// multiple association events


// TopologyVersion Events

data class CreateTopologyVersionEvent(
    @Id val topologyVersionId: UUID? = null,
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

data class UpdateTopologyVersionEvent(
    @Id val topologyVersionId: UUID? = null,
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

data class DeleteTopologyVersionEvent(@Id val topologyVersionId: UUID? = null)

// single association events

// multiple association events


// TransformerEnd Events

data class CreateTransformerEndEvent(
    @Id val transformerEndId: UUID? = null,
    val endNumber: String,
    val grounded: String,
    val rground: String,
    val xground: String
)

data class UpdateTransformerEndEvent(
    @Id val transformerEndId: UUID? = null,
    val endNumber: String,
    val grounded: String,
    val rground: String,
    val xground: String
)

data class DeleteTransformerEndEvent(@Id val transformerEndId: UUID? = null)

// single association events

// multiple association events


// TurbLCFB1 Events

data class CreateTurbLCFB1Event(
    @Id val turbLCFB1Id: UUID? = null,
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

data class UpdateTurbLCFB1Event(
    @Id val turbLCFB1Id: UUID? = null,
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

data class DeleteTurbLCFB1Event(@Id val turbLCFB1Id: UUID? = null)

// single association events

// multiple association events


// TurbineGovernorDynamics Events

data class CreateTurbineGovernorDynamicsEvent(
     val turbineGovernorDynamicsId: UUID? = null
)

data class UpdateTurbineGovernorDynamicsEvent(
     val turbineGovernorDynamicsId: UUID? = null
)

data class DeleteTurbineGovernorDynamicsEvent(@Id val turbineGovernorDynamicsId: UUID? = null)

// single association events

// multiple association events


// TurbineGovernorUserDefined Events

data class CreateTurbineGovernorUserDefinedEvent(
    @Id val turbineGovernorUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateTurbineGovernorUserDefinedEvent(
    @Id val turbineGovernorUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteTurbineGovernorUserDefinedEvent(@Id val turbineGovernorUserDefinedId: UUID? = null)

// single association events

// multiple association events


// TurbineLoadControllerDynamics Events

data class CreateTurbineLoadControllerDynamicsEvent(
     val turbineLoadControllerDynamicsId: UUID? = null
)

data class UpdateTurbineLoadControllerDynamicsEvent(
     val turbineLoadControllerDynamicsId: UUID? = null
)

data class DeleteTurbineLoadControllerDynamicsEvent(@Id val turbineLoadControllerDynamicsId: UUID? = null)

// single association events

// multiple association events


// TurbineLoadControllerUserDefined Events

data class CreateTurbineLoadControllerUserDefinedEvent(
    @Id val turbineLoadControllerUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateTurbineLoadControllerUserDefinedEvent(
    @Id val turbineLoadControllerUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteTurbineLoadControllerUserDefinedEvent(@Id val turbineLoadControllerUserDefinedId: UUID? = null)

// single association events

// multiple association events


// UnderexcLim2Simplified Events

data class CreateUnderexcLim2SimplifiedEvent(
    @Id val underexcLim2SimplifiedId: UUID? = null,
    val kui: String,
    val p0: String,
    val p1: String,
    val q0: String,
    val q1: String,
    val vuimax: String,
    val vuimin: String
)

data class UpdateUnderexcLim2SimplifiedEvent(
    @Id val underexcLim2SimplifiedId: UUID? = null,
    val kui: String,
    val p0: String,
    val p1: String,
    val q0: String,
    val q1: String,
    val vuimax: String,
    val vuimin: String
)

data class DeleteUnderexcLim2SimplifiedEvent(@Id val underexcLim2SimplifiedId: UUID? = null)

// single association events

// multiple association events


// UnderexcLimIEEE1 Events

data class CreateUnderexcLimIEEE1Event(
    @Id val underexcLimIEEE1Id: UUID? = null,
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

data class UpdateUnderexcLimIEEE1Event(
    @Id val underexcLimIEEE1Id: UUID? = null,
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

data class DeleteUnderexcLimIEEE1Event(@Id val underexcLimIEEE1Id: UUID? = null)

// single association events

// multiple association events


// UnderexcLimIEEE2 Events

data class CreateUnderexcLimIEEE2Event(
    @Id val underexcLimIEEE2Id: UUID? = null,
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

data class UpdateUnderexcLimIEEE2Event(
    @Id val underexcLimIEEE2Id: UUID? = null,
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

data class DeleteUnderexcLimIEEE2Event(@Id val underexcLimIEEE2Id: UUID? = null)

// single association events

// multiple association events


// UnderexcLimX1 Events

data class CreateUnderexcLimX1Event(
    @Id val underexcLimX1Id: UUID? = null,
    val k: String,
    val kf2: String,
    val km: String,
    val melmax: String,
    val tf2: String,
    val tm: String
)

data class UpdateUnderexcLimX1Event(
    @Id val underexcLimX1Id: UUID? = null,
    val k: String,
    val kf2: String,
    val km: String,
    val melmax: String,
    val tf2: String,
    val tm: String
)

data class DeleteUnderexcLimX1Event(@Id val underexcLimX1Id: UUID? = null)

// single association events

// multiple association events


// UnderexcLimX2 Events

data class CreateUnderexcLimX2Event(
    @Id val underexcLimX2Id: UUID? = null,
    val kf2: String,
    val km: String,
    val melmax: String,
    val qo: String,
    val r: String,
    val tf2: String,
    val tm: String
)

data class UpdateUnderexcLimX2Event(
    @Id val underexcLimX2Id: UUID? = null,
    val kf2: String,
    val km: String,
    val melmax: String,
    val qo: String,
    val r: String,
    val tf2: String,
    val tm: String
)

data class DeleteUnderexcLimX2Event(@Id val underexcLimX2Id: UUID? = null)

// single association events

// multiple association events


// UnderexcitationLimiterDynamics Events

data class CreateUnderexcitationLimiterDynamicsEvent(
     val underexcitationLimiterDynamicsId: UUID? = null
)

data class UpdateUnderexcitationLimiterDynamicsEvent(
     val underexcitationLimiterDynamicsId: UUID? = null
)

data class DeleteUnderexcitationLimiterDynamicsEvent(@Id val underexcitationLimiterDynamicsId: UUID? = null)

// single association events

// multiple association events


// UnderexcitationLimiterUserDefined Events

data class CreateUnderexcitationLimiterUserDefinedEvent(
    @Id val underexcitationLimiterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateUnderexcitationLimiterUserDefinedEvent(
    @Id val underexcitationLimiterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteUnderexcitationLimiterUserDefinedEvent(@Id val underexcitationLimiterUserDefinedId: UUID? = null)

// single association events

// multiple association events


// Unresolvedname Events

data class CreateUnresolvednameEvent(
     val unresolvednameId: UUID? = null
)

data class UpdateUnresolvednameEvent(
     val unresolvednameId: UUID? = null
)

data class DeleteUnresolvednameEvent(@Id val unresolvednameId: UUID? = null)

// single association events

// multiple association events


// VAdjIEEE Events

data class CreateVAdjIEEEEvent(
    @Id val vAdjIEEEId: UUID? = null,
    val adjslew: String,
    val taoff: String,
    val taon: String,
    val vadjf: String,
    val vadjmax: String,
    val vadjmin: String
)

data class UpdateVAdjIEEEEvent(
    @Id val vAdjIEEEId: UUID? = null,
    val adjslew: String,
    val taoff: String,
    val taon: String,
    val vadjf: String,
    val vadjmax: String,
    val vadjmin: String
)

data class DeleteVAdjIEEEEvent(@Id val vAdjIEEEId: UUID? = null)

// single association events

// multiple association events


// VCompIEEEType1 Events

data class CreateVCompIEEEType1Event(
    @Id val vCompIEEEType1Id: UUID? = null,
    val rc: String,
    val tr: String,
    val xc: String
)

data class UpdateVCompIEEEType1Event(
    @Id val vCompIEEEType1Id: UUID? = null,
    val rc: String,
    val tr: String,
    val xc: String
)

data class DeleteVCompIEEEType1Event(@Id val vCompIEEEType1Id: UUID? = null)

// single association events

// multiple association events


// VCompIEEEType2 Events

data class CreateVCompIEEEType2Event(
    @Id val vCompIEEEType2Id: UUID? = null,
    val tr: String
)

data class UpdateVCompIEEEType2Event(
    @Id val vCompIEEEType2Id: UUID? = null,
    val tr: String
)

data class DeleteVCompIEEEType2Event(@Id val vCompIEEEType2Id: UUID? = null)

// single association events

// multiple association events


// ValueAliasSet Events

data class CreateValueAliasSetEvent(
     val valueAliasSetId: UUID? = null
)

data class UpdateValueAliasSetEvent(
     val valueAliasSetId: UUID? = null
)

data class DeleteValueAliasSetEvent(@Id val valueAliasSetId: UUID? = null)

// single association events

// multiple association events


// ValueToAlias Events

data class CreateValueToAliasEvent(
    @Id val valueToAliasId: UUID? = null,
    val value: String
)

data class UpdateValueToAliasEvent(
    @Id val valueToAliasId: UUID? = null,
    val value: String
)

data class DeleteValueToAliasEvent(@Id val valueToAliasId: UUID? = null)

// single association events

// multiple association events


// VisibilityLayer Events

data class CreateVisibilityLayerEvent(
    @Id val visibilityLayerId: UUID? = null,
    val drawingOrder: String
)

data class UpdateVisibilityLayerEvent(
    @Id val visibilityLayerId: UUID? = null,
    val drawingOrder: String
)

data class DeleteVisibilityLayerEvent(@Id val visibilityLayerId: UUID? = null)

// single association events

// multiple association events


// Voltage Events

data class CreateVoltageEvent(
    @Id val voltageId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateVoltageEvent(
    @Id val voltageId: UUID? = null,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteVoltageEvent(@Id val voltageId: UUID? = null)

// single association events

// multiple association events


// VoltageAdjusterDynamics Events

data class CreateVoltageAdjusterDynamicsEvent(
     val voltageAdjusterDynamicsId: UUID? = null
)

data class UpdateVoltageAdjusterDynamicsEvent(
     val voltageAdjusterDynamicsId: UUID? = null
)

data class DeleteVoltageAdjusterDynamicsEvent(@Id val voltageAdjusterDynamicsId: UUID? = null)

// single association events

// multiple association events


// VoltageAdjusterUserDefined Events

data class CreateVoltageAdjusterUserDefinedEvent(
    @Id val voltageAdjusterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateVoltageAdjusterUserDefinedEvent(
    @Id val voltageAdjusterUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteVoltageAdjusterUserDefinedEvent(@Id val voltageAdjusterUserDefinedId: UUID? = null)

// single association events

// multiple association events


// VoltageCompensatorDynamics Events

data class CreateVoltageCompensatorDynamicsEvent(
     val voltageCompensatorDynamicsId: UUID? = null
)

data class UpdateVoltageCompensatorDynamicsEvent(
     val voltageCompensatorDynamicsId: UUID? = null
)

data class DeleteVoltageCompensatorDynamicsEvent(@Id val voltageCompensatorDynamicsId: UUID? = null)

// single association events

// multiple association events


// VoltageCompensatorUserDefined Events

data class CreateVoltageCompensatorUserDefinedEvent(
    @Id val voltageCompensatorUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateVoltageCompensatorUserDefinedEvent(
    @Id val voltageCompensatorUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteVoltageCompensatorUserDefinedEvent(@Id val voltageCompensatorUserDefinedId: UUID? = null)

// single association events

// multiple association events


// VoltageLevel Events

data class CreateVoltageLevelEvent(
    @Id val voltageLevelId: UUID? = null,
    val highVoltageLimit: String,
    val lowVoltageLimit: String
)

data class UpdateVoltageLevelEvent(
    @Id val voltageLevelId: UUID? = null,
    val highVoltageLimit: String,
    val lowVoltageLimit: String
)

data class DeleteVoltageLevelEvent(@Id val voltageLevelId: UUID? = null)

// single association events

// multiple association events


// VoltageLimit Events

data class CreateVoltageLimitEvent(
    @Id val voltageLimitId: UUID? = null,
    val value: String
)

data class UpdateVoltageLimitEvent(
    @Id val voltageLimitId: UUID? = null,
    val value: String
)

data class DeleteVoltageLimitEvent(@Id val voltageLimitId: UUID? = null)

// single association events

// multiple association events


// VoltagePerReactivePower Events

data class CreateVoltagePerReactivePowerEvent(
    @Id val voltagePerReactivePowerId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateVoltagePerReactivePowerEvent(
    @Id val voltagePerReactivePowerId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteVoltagePerReactivePowerEvent(@Id val voltagePerReactivePowerId: UUID? = null)

// single association events

// multiple association events


// VolumeFlowRate Events

data class CreateVolumeFlowRateEvent(
    @Id val volumeFlowRateId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class UpdateVolumeFlowRateEvent(
    @Id val volumeFlowRateId: UUID? = null,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: String
)

data class DeleteVolumeFlowRateEvent(@Id val volumeFlowRateId: UUID? = null)

// single association events

// multiple association events


// VsCapabilityCurve Events

data class CreateVsCapabilityCurveEvent(
     val vsCapabilityCurveId: UUID? = null
)

data class UpdateVsCapabilityCurveEvent(
     val vsCapabilityCurveId: UUID? = null
)

data class DeleteVsCapabilityCurveEvent(@Id val vsCapabilityCurveId: UUID? = null)

// single association events

// multiple association events


// VsConverter Events

data class CreateVsConverterEvent(
    @Id val vsConverterId: UUID? = null,
    val maxModulationIndex: String,
    val maxValveCurrent: String
)

data class UpdateVsConverterEvent(
    @Id val vsConverterId: UUID? = null,
    val maxModulationIndex: String,
    val maxValveCurrent: String
)

data class DeleteVsConverterEvent(@Id val vsConverterId: UUID? = null)

// single association events

// multiple association events


// WindAeroConstIEC Events

data class CreateWindAeroConstIECEvent(
     val windAeroConstIECId: UUID? = null
)

data class UpdateWindAeroConstIECEvent(
     val windAeroConstIECId: UUID? = null
)

data class DeleteWindAeroConstIECEvent(@Id val windAeroConstIECId: UUID? = null)

// single association events

// multiple association events


// WindAeroLinearIEC Events

data class CreateWindAeroLinearIECEvent(
    @Id val windAeroLinearIECId: UUID? = null,
    val dpomega: String,
    val dptheta: String,
    val omegazero: String,
    val pavail: String,
    val thetazero: String
)

data class UpdateWindAeroLinearIECEvent(
    @Id val windAeroLinearIECId: UUID? = null,
    val dpomega: String,
    val dptheta: String,
    val omegazero: String,
    val pavail: String,
    val thetazero: String
)

data class DeleteWindAeroLinearIECEvent(@Id val windAeroLinearIECId: UUID? = null)

// single association events

// multiple association events


// WindContCurrLimIEC Events

data class CreateWindContCurrLimIECEvent(
    @Id val windContCurrLimIECId: UUID? = null,
    val imax: String,
    val imaxdip: String,
    val mdfslim: String,
    val mqpri: String,
    val tufilt: String
)

data class UpdateWindContCurrLimIECEvent(
    @Id val windContCurrLimIECId: UUID? = null,
    val imax: String,
    val imaxdip: String,
    val mdfslim: String,
    val mqpri: String,
    val tufilt: String
)

data class DeleteWindContCurrLimIECEvent(@Id val windContCurrLimIECId: UUID? = null)

// single association events

// multiple association events


// WindContPType3IEC Events

data class CreateWindContPType3IECEvent(
    @Id val windContPType3IECId: UUID? = null,
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

data class UpdateWindContPType3IECEvent(
    @Id val windContPType3IECId: UUID? = null,
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

data class DeleteWindContPType3IECEvent(@Id val windContPType3IECId: UUID? = null)

// single association events

// multiple association events


// WindContPType4aIEC Events

data class CreateWindContPType4aIECEvent(
    @Id val windContPType4aIECId: UUID? = null,
    val dpmax: String,
    val tpord: String,
    val tufilt: String
)

data class UpdateWindContPType4aIECEvent(
    @Id val windContPType4aIECId: UUID? = null,
    val dpmax: String,
    val tpord: String,
    val tufilt: String
)

data class DeleteWindContPType4aIECEvent(@Id val windContPType4aIECId: UUID? = null)

// single association events

// multiple association events


// WindContPType4bIEC Events

data class CreateWindContPType4bIECEvent(
    @Id val windContPType4bIECId: UUID? = null,
    val dpmax: String,
    val tpaero: String,
    val tpord: String,
    val tufilt: String
)

data class UpdateWindContPType4bIECEvent(
    @Id val windContPType4bIECId: UUID? = null,
    val dpmax: String,
    val tpaero: String,
    val tpord: String,
    val tufilt: String
)

data class DeleteWindContPType4bIECEvent(@Id val windContPType4bIECId: UUID? = null)

// single association events

// multiple association events


// WindContPitchAngleIEC Events

data class CreateWindContPitchAngleIECEvent(
    @Id val windContPitchAngleIECId: UUID? = null,
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

data class UpdateWindContPitchAngleIECEvent(
    @Id val windContPitchAngleIECId: UUID? = null,
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

data class DeleteWindContPitchAngleIECEvent(@Id val windContPitchAngleIECId: UUID? = null)

// single association events

// multiple association events


// WindContQIEC Events

data class CreateWindContQIECEvent(
    @Id val windContQIECId: UUID? = null,
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

data class UpdateWindContQIECEvent(
    @Id val windContQIECId: UUID? = null,
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

data class DeleteWindContQIECEvent(@Id val windContQIECId: UUID? = null)

// single association events

// multiple association events


// WindContRotorRIEC Events

data class CreateWindContRotorRIECEvent(
    @Id val windContRotorRIECId: UUID? = null,
    val kirr: String,
    val komegafilt: String,
    val kpfilt: String,
    val kprr: String,
    val rmax: String,
    val rmin: String,
    val tomegafilt: String,
    val tpfilt: String
)

data class UpdateWindContRotorRIECEvent(
    @Id val windContRotorRIECId: UUID? = null,
    val kirr: String,
    val komegafilt: String,
    val kpfilt: String,
    val kprr: String,
    val rmax: String,
    val rmin: String,
    val tomegafilt: String,
    val tpfilt: String
)

data class DeleteWindContRotorRIECEvent(@Id val windContRotorRIECId: UUID? = null)

// single association events

// multiple association events


// WindDynamicsLookupTable Events

data class CreateWindDynamicsLookupTableEvent(
    @Id val windDynamicsLookupTableId: UUID? = null,
    val input: String,
    val lookupTableFunctionType: String,
    val output: String,
    val sequence: String
)

data class UpdateWindDynamicsLookupTableEvent(
    @Id val windDynamicsLookupTableId: UUID? = null,
    val input: String,
    val lookupTableFunctionType: String,
    val output: String,
    val sequence: String
)

data class DeleteWindDynamicsLookupTableEvent(@Id val windDynamicsLookupTableId: UUID? = null)

// single association events

// multiple association events


// WindGenTurbineType1IEC Events

data class CreateWindGenTurbineType1IECEvent(
     val windGenTurbineType1IECId: UUID? = null
)

data class UpdateWindGenTurbineType1IECEvent(
     val windGenTurbineType1IECId: UUID? = null
)

data class DeleteWindGenTurbineType1IECEvent(@Id val windGenTurbineType1IECId: UUID? = null)

// single association events

// multiple association events


// WindGenTurbineType2IEC Events

data class CreateWindGenTurbineType2IECEvent(
     val windGenTurbineType2IECId: UUID? = null
)

data class UpdateWindGenTurbineType2IECEvent(
     val windGenTurbineType2IECId: UUID? = null
)

data class DeleteWindGenTurbineType2IECEvent(@Id val windGenTurbineType2IECId: UUID? = null)

// single association events

// multiple association events


// WindGenTurbineType3IEC Events

data class CreateWindGenTurbineType3IECEvent(
    @Id val windGenTurbineType3IECId: UUID? = null,
    val dipmax: String,
    val diqmax: String
)

data class UpdateWindGenTurbineType3IECEvent(
    @Id val windGenTurbineType3IECId: UUID? = null,
    val dipmax: String,
    val diqmax: String
)

data class DeleteWindGenTurbineType3IECEvent(@Id val windGenTurbineType3IECId: UUID? = null)

// single association events

// multiple association events


// WindGenTurbineType3aIEC Events

data class CreateWindGenTurbineType3aIECEvent(
    @Id val windGenTurbineType3aIECId: UUID? = null,
    val kpc: String,
    val tic: String,
    val xs: String
)

data class UpdateWindGenTurbineType3aIECEvent(
    @Id val windGenTurbineType3aIECId: UUID? = null,
    val kpc: String,
    val tic: String,
    val xs: String
)

data class DeleteWindGenTurbineType3aIECEvent(@Id val windGenTurbineType3aIECId: UUID? = null)

// single association events

// multiple association events


// WindGenTurbineType3bIEC Events

data class CreateWindGenTurbineType3bIECEvent(
    @Id val windGenTurbineType3bIECId: UUID? = null,
    val fducw: String,
    val mwtcwp: String,
    val tg: String,
    val two: String,
    val xs: String
)

data class UpdateWindGenTurbineType3bIECEvent(
    @Id val windGenTurbineType3bIECId: UUID? = null,
    val fducw: String,
    val mwtcwp: String,
    val tg: String,
    val two: String,
    val xs: String
)

data class DeleteWindGenTurbineType3bIECEvent(@Id val windGenTurbineType3bIECId: UUID? = null)

// single association events

// multiple association events


// WindGenType4IEC Events

data class CreateWindGenType4IECEvent(
    @Id val windGenType4IECId: UUID? = null,
    val dipmax: String,
    val diqmax: String,
    val diqmin: String,
    val tg: String
)

data class UpdateWindGenType4IECEvent(
    @Id val windGenType4IECId: UUID? = null,
    val dipmax: String,
    val diqmax: String,
    val diqmin: String,
    val tg: String
)

data class DeleteWindGenType4IECEvent(@Id val windGenType4IECId: UUID? = null)

// single association events

// multiple association events


// WindGeneratingUnit Events

data class CreateWindGeneratingUnitEvent(
    @Id val windGeneratingUnitId: UUID? = null,
    val windGenUnitType: String
)

data class UpdateWindGeneratingUnitEvent(
    @Id val windGeneratingUnitId: UUID? = null,
    val windGenUnitType: String
)

data class DeleteWindGeneratingUnitEvent(@Id val windGeneratingUnitId: UUID? = null)

// single association events

// multiple association events


// WindMechIEC Events

data class CreateWindMechIECEvent(
    @Id val windMechIECId: UUID? = null,
    val cdrt: String,
    val hgen: String,
    val hwtr: String,
    val kdrt: String
)

data class UpdateWindMechIECEvent(
    @Id val windMechIECId: UUID? = null,
    val cdrt: String,
    val hgen: String,
    val hwtr: String,
    val kdrt: String
)

data class DeleteWindMechIECEvent(@Id val windMechIECId: UUID? = null)

// single association events

// multiple association events


// WindPitchContEmulIEC Events

data class CreateWindPitchContEmulIECEvent(
    @Id val windPitchContEmulIECId: UUID? = null,
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

data class UpdateWindPitchContEmulIECEvent(
    @Id val windPitchContEmulIECId: UUID? = null,
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

data class DeleteWindPitchContEmulIECEvent(@Id val windPitchContEmulIECId: UUID? = null)

// single association events

// multiple association events


// WindPlantDynamics Events

data class CreateWindPlantDynamicsEvent(
     val windPlantDynamicsId: UUID? = null
)

data class UpdateWindPlantDynamicsEvent(
     val windPlantDynamicsId: UUID? = null
)

data class DeleteWindPlantDynamicsEvent(@Id val windPlantDynamicsId: UUID? = null)

// single association events

// multiple association events


// WindPlantFreqPcontrolIEC Events

data class CreateWindPlantFreqPcontrolIECEvent(
    @Id val windPlantFreqPcontrolIECId: UUID? = null,
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

data class UpdateWindPlantFreqPcontrolIECEvent(
    @Id val windPlantFreqPcontrolIECId: UUID? = null,
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

data class DeleteWindPlantFreqPcontrolIECEvent(@Id val windPlantFreqPcontrolIECId: UUID? = null)

// single association events

// multiple association events


// WindPlantIEC Events

data class CreateWindPlantIECEvent(
     val windPlantIECId: UUID? = null
)

data class UpdateWindPlantIECEvent(
     val windPlantIECId: UUID? = null
)

data class DeleteWindPlantIECEvent(@Id val windPlantIECId: UUID? = null)

// single association events

// multiple association events


// WindPlantReactiveControlIEC Events

data class CreateWindPlantReactiveControlIECEvent(
    @Id val windPlantReactiveControlIECId: UUID? = null,
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

data class UpdateWindPlantReactiveControlIECEvent(
    @Id val windPlantReactiveControlIECId: UUID? = null,
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

data class DeleteWindPlantReactiveControlIECEvent(@Id val windPlantReactiveControlIECId: UUID? = null)

// single association events

// multiple association events


// WindPlantUserDefined Events

data class CreateWindPlantUserDefinedEvent(
    @Id val windPlantUserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateWindPlantUserDefinedEvent(
    @Id val windPlantUserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteWindPlantUserDefinedEvent(@Id val windPlantUserDefinedId: UUID? = null)

// single association events

// multiple association events


// WindProtectionIEC Events

data class CreateWindProtectionIECEvent(
    @Id val windProtectionIECId: UUID? = null,
    val fover: String,
    val funder: String,
    val tfover: String,
    val tfunder: String,
    val tuover: String,
    val tuunder: String,
    val uover: String,
    val uunder: String
)

data class UpdateWindProtectionIECEvent(
    @Id val windProtectionIECId: UUID? = null,
    val fover: String,
    val funder: String,
    val tfover: String,
    val tfunder: String,
    val tuover: String,
    val tuunder: String,
    val uover: String,
    val uunder: String
)

data class DeleteWindProtectionIECEvent(@Id val windProtectionIECId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType1or2Dynamics Events

data class CreateWindTurbineType1or2DynamicsEvent(
     val windTurbineType1or2DynamicsId: UUID? = null
)

data class UpdateWindTurbineType1or2DynamicsEvent(
     val windTurbineType1or2DynamicsId: UUID? = null
)

data class DeleteWindTurbineType1or2DynamicsEvent(@Id val windTurbineType1or2DynamicsId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType1or2IEC Events

data class CreateWindTurbineType1or2IECEvent(
     val windTurbineType1or2IECId: UUID? = null
)

data class UpdateWindTurbineType1or2IECEvent(
     val windTurbineType1or2IECId: UUID? = null
)

data class DeleteWindTurbineType1or2IECEvent(@Id val windTurbineType1or2IECId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType3or4Dynamics Events

data class CreateWindTurbineType3or4DynamicsEvent(
     val windTurbineType3or4DynamicsId: UUID? = null
)

data class UpdateWindTurbineType3or4DynamicsEvent(
     val windTurbineType3or4DynamicsId: UUID? = null
)

data class DeleteWindTurbineType3or4DynamicsEvent(@Id val windTurbineType3or4DynamicsId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType3or4IEC Events

data class CreateWindTurbineType3or4IECEvent(
     val windTurbineType3or4IECId: UUID? = null
)

data class UpdateWindTurbineType3or4IECEvent(
     val windTurbineType3or4IECId: UUID? = null
)

data class DeleteWindTurbineType3or4IECEvent(@Id val windTurbineType3or4IECId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType4aIEC Events

data class CreateWindTurbineType4aIECEvent(
     val windTurbineType4aIECId: UUID? = null
)

data class UpdateWindTurbineType4aIECEvent(
     val windTurbineType4aIECId: UUID? = null
)

data class DeleteWindTurbineType4aIECEvent(@Id val windTurbineType4aIECId: UUID? = null)

// single association events

// multiple association events


// WindTurbineType4bIEC Events

data class CreateWindTurbineType4bIECEvent(
     val windTurbineType4bIECId: UUID? = null
)

data class UpdateWindTurbineType4bIECEvent(
     val windTurbineType4bIECId: UUID? = null
)

data class DeleteWindTurbineType4bIECEvent(@Id val windTurbineType4bIECId: UUID? = null)

// single association events

// multiple association events


// WindType1or2UserDefined Events

data class CreateWindType1or2UserDefinedEvent(
    @Id val windType1or2UserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateWindType1or2UserDefinedEvent(
    @Id val windType1or2UserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteWindType1or2UserDefinedEvent(@Id val windType1or2UserDefinedId: UUID? = null)

// single association events

// multiple association events


// WindType3or4UserDefined Events

data class CreateWindType3or4UserDefinedEvent(
    @Id val windType3or4UserDefinedId: UUID? = null,
    val proprietary: String
)

data class UpdateWindType3or4UserDefinedEvent(
    @Id val windType3or4UserDefinedId: UUID? = null,
    val proprietary: String
)

data class DeleteWindType3or4UserDefinedEvent(@Id val windType3or4UserDefinedId: UUID? = null)

// single association events

// multiple association events



