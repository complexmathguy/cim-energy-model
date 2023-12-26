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

import java.util.*;

import javax.persistence.Entity
import javax.persistence.Id

//-----------------------------------------------------------
// Query definitions
//-----------------------------------------------------------

// -----------------------------------------
// ACDCConverter Queries 
// -----------------------------------------

data class LoadACDCConverterFilter(val aCDCConverterId :  UUID? = null )

class FindACDCConverterQuery(val filter: LoadACDCConverterFilter = LoadACDCConverterFilter()) {
    override fun toString(): String = "LoadACDCConverterQuery"
}

class FindAllACDCConverterQuery() {
    override fun toString(): String = "LoadAllACDCConverterQuery"
}

data class ACDCConverterFetchOneSummary(@Id var aCDCConverterId : UUID? = null) {
}





// -----------------------------------------
// ACDCConverterDCTerminal Queries 
// -----------------------------------------

data class LoadACDCConverterDCTerminalFilter(val aCDCConverterDCTerminalId :  UUID? = null )

class FindACDCConverterDCTerminalQuery(val filter: LoadACDCConverterDCTerminalFilter = LoadACDCConverterDCTerminalFilter()) {
    override fun toString(): String = "LoadACDCConverterDCTerminalQuery"
}

class FindAllACDCConverterDCTerminalQuery() {
    override fun toString(): String = "LoadAllACDCConverterDCTerminalQuery"
}

data class ACDCConverterDCTerminalFetchOneSummary(@Id var aCDCConverterDCTerminalId : UUID? = null) {
}





// -----------------------------------------
// ACDCTerminal Queries 
// -----------------------------------------

data class LoadACDCTerminalFilter(val aCDCTerminalId :  UUID? = null )

class FindACDCTerminalQuery(val filter: LoadACDCTerminalFilter = LoadACDCTerminalFilter()) {
    override fun toString(): String = "LoadACDCTerminalQuery"
}

class FindAllACDCTerminalQuery() {
    override fun toString(): String = "LoadAllACDCTerminalQuery"
}

data class ACDCTerminalFetchOneSummary(@Id var aCDCTerminalId : UUID? = null) {
}





// -----------------------------------------
// ACLineSegment Queries 
// -----------------------------------------

data class LoadACLineSegmentFilter(val aCLineSegmentId :  UUID? = null )

class FindACLineSegmentQuery(val filter: LoadACLineSegmentFilter = LoadACLineSegmentFilter()) {
    override fun toString(): String = "LoadACLineSegmentQuery"
}

class FindAllACLineSegmentQuery() {
    override fun toString(): String = "LoadAllACLineSegmentQuery"
}

data class ACLineSegmentFetchOneSummary(@Id var aCLineSegmentId : UUID? = null) {
}





// -----------------------------------------
// Accumulator Queries 
// -----------------------------------------

data class LoadAccumulatorFilter(val accumulatorId :  UUID? = null )

class FindAccumulatorQuery(val filter: LoadAccumulatorFilter = LoadAccumulatorFilter()) {
    override fun toString(): String = "LoadAccumulatorQuery"
}

class FindAllAccumulatorQuery() {
    override fun toString(): String = "LoadAllAccumulatorQuery"
}

data class AccumulatorFetchOneSummary(@Id var accumulatorId : UUID? = null) {
}





// -----------------------------------------
// AccumulatorLimit Queries 
// -----------------------------------------

data class LoadAccumulatorLimitFilter(val accumulatorLimitId :  UUID? = null )

class FindAccumulatorLimitQuery(val filter: LoadAccumulatorLimitFilter = LoadAccumulatorLimitFilter()) {
    override fun toString(): String = "LoadAccumulatorLimitQuery"
}

class FindAllAccumulatorLimitQuery() {
    override fun toString(): String = "LoadAllAccumulatorLimitQuery"
}

data class AccumulatorLimitFetchOneSummary(@Id var accumulatorLimitId : UUID? = null) {
}





// -----------------------------------------
// AccumulatorLimitSet Queries 
// -----------------------------------------

data class LoadAccumulatorLimitSetFilter(val accumulatorLimitSetId :  UUID? = null )

class FindAccumulatorLimitSetQuery(val filter: LoadAccumulatorLimitSetFilter = LoadAccumulatorLimitSetFilter()) {
    override fun toString(): String = "LoadAccumulatorLimitSetQuery"
}

class FindAllAccumulatorLimitSetQuery() {
    override fun toString(): String = "LoadAllAccumulatorLimitSetQuery"
}

data class AccumulatorLimitSetFetchOneSummary(@Id var accumulatorLimitSetId : UUID? = null) {
}





// -----------------------------------------
// AccumulatorReset Queries 
// -----------------------------------------

data class LoadAccumulatorResetFilter(val accumulatorResetId :  UUID? = null )

class FindAccumulatorResetQuery(val filter: LoadAccumulatorResetFilter = LoadAccumulatorResetFilter()) {
    override fun toString(): String = "LoadAccumulatorResetQuery"
}

class FindAllAccumulatorResetQuery() {
    override fun toString(): String = "LoadAllAccumulatorResetQuery"
}

data class AccumulatorResetFetchOneSummary(@Id var accumulatorResetId : UUID? = null) {
}





// -----------------------------------------
// AccumulatorValue Queries 
// -----------------------------------------

data class LoadAccumulatorValueFilter(val accumulatorValueId :  UUID? = null )

class FindAccumulatorValueQuery(val filter: LoadAccumulatorValueFilter = LoadAccumulatorValueFilter()) {
    override fun toString(): String = "LoadAccumulatorValueQuery"
}

class FindAllAccumulatorValueQuery() {
    override fun toString(): String = "LoadAllAccumulatorValueQuery"
}

data class AccumulatorValueFetchOneSummary(@Id var accumulatorValueId : UUID? = null) {
}





// -----------------------------------------
// ActivePower Queries 
// -----------------------------------------

data class LoadActivePowerFilter(val activePowerId :  UUID? = null )

class FindActivePowerQuery(val filter: LoadActivePowerFilter = LoadActivePowerFilter()) {
    override fun toString(): String = "LoadActivePowerQuery"
}

class FindAllActivePowerQuery() {
    override fun toString(): String = "LoadAllActivePowerQuery"
}

data class ActivePowerFetchOneSummary(@Id var activePowerId : UUID? = null) {
}





// -----------------------------------------
// ActivePowerLimit Queries 
// -----------------------------------------

data class LoadActivePowerLimitFilter(val activePowerLimitId :  UUID? = null )

class FindActivePowerLimitQuery(val filter: LoadActivePowerLimitFilter = LoadActivePowerLimitFilter()) {
    override fun toString(): String = "LoadActivePowerLimitQuery"
}

class FindAllActivePowerLimitQuery() {
    override fun toString(): String = "LoadAllActivePowerLimitQuery"
}

data class ActivePowerLimitFetchOneSummary(@Id var activePowerLimitId : UUID? = null) {
}





// -----------------------------------------
// ActivePowerPerCurrentFlow Queries 
// -----------------------------------------

data class LoadActivePowerPerCurrentFlowFilter(val activePowerPerCurrentFlowId :  UUID? = null )

class FindActivePowerPerCurrentFlowQuery(val filter: LoadActivePowerPerCurrentFlowFilter = LoadActivePowerPerCurrentFlowFilter()) {
    override fun toString(): String = "LoadActivePowerPerCurrentFlowQuery"
}

class FindAllActivePowerPerCurrentFlowQuery() {
    override fun toString(): String = "LoadAllActivePowerPerCurrentFlowQuery"
}

data class ActivePowerPerCurrentFlowFetchOneSummary(@Id var activePowerPerCurrentFlowId : UUID? = null) {
}





// -----------------------------------------
// ActivePowerPerFrequency Queries 
// -----------------------------------------

data class LoadActivePowerPerFrequencyFilter(val activePowerPerFrequencyId :  UUID? = null )

class FindActivePowerPerFrequencyQuery(val filter: LoadActivePowerPerFrequencyFilter = LoadActivePowerPerFrequencyFilter()) {
    override fun toString(): String = "LoadActivePowerPerFrequencyQuery"
}

class FindAllActivePowerPerFrequencyQuery() {
    override fun toString(): String = "LoadAllActivePowerPerFrequencyQuery"
}

data class ActivePowerPerFrequencyFetchOneSummary(@Id var activePowerPerFrequencyId : UUID? = null) {
}





// -----------------------------------------
// Analog Queries 
// -----------------------------------------

data class LoadAnalogFilter(val analogId :  UUID? = null )

class FindAnalogQuery(val filter: LoadAnalogFilter = LoadAnalogFilter()) {
    override fun toString(): String = "LoadAnalogQuery"
}

class FindAllAnalogQuery() {
    override fun toString(): String = "LoadAllAnalogQuery"
}

data class AnalogFetchOneSummary(@Id var analogId : UUID? = null) {
}





// -----------------------------------------
// AnalogControl Queries 
// -----------------------------------------

data class LoadAnalogControlFilter(val analogControlId :  UUID? = null )

class FindAnalogControlQuery(val filter: LoadAnalogControlFilter = LoadAnalogControlFilter()) {
    override fun toString(): String = "LoadAnalogControlQuery"
}

class FindAllAnalogControlQuery() {
    override fun toString(): String = "LoadAllAnalogControlQuery"
}

data class AnalogControlFetchOneSummary(@Id var analogControlId : UUID? = null) {
}





// -----------------------------------------
// AnalogLimit Queries 
// -----------------------------------------

data class LoadAnalogLimitFilter(val analogLimitId :  UUID? = null )

class FindAnalogLimitQuery(val filter: LoadAnalogLimitFilter = LoadAnalogLimitFilter()) {
    override fun toString(): String = "LoadAnalogLimitQuery"
}

class FindAllAnalogLimitQuery() {
    override fun toString(): String = "LoadAllAnalogLimitQuery"
}

data class AnalogLimitFetchOneSummary(@Id var analogLimitId : UUID? = null) {
}





// -----------------------------------------
// AnalogLimitSet Queries 
// -----------------------------------------

data class LoadAnalogLimitSetFilter(val analogLimitSetId :  UUID? = null )

class FindAnalogLimitSetQuery(val filter: LoadAnalogLimitSetFilter = LoadAnalogLimitSetFilter()) {
    override fun toString(): String = "LoadAnalogLimitSetQuery"
}

class FindAllAnalogLimitSetQuery() {
    override fun toString(): String = "LoadAllAnalogLimitSetQuery"
}

data class AnalogLimitSetFetchOneSummary(@Id var analogLimitSetId : UUID? = null) {
}





// -----------------------------------------
// AnalogValue Queries 
// -----------------------------------------

data class LoadAnalogValueFilter(val analogValueId :  UUID? = null )

class FindAnalogValueQuery(val filter: LoadAnalogValueFilter = LoadAnalogValueFilter()) {
    override fun toString(): String = "LoadAnalogValueQuery"
}

class FindAllAnalogValueQuery() {
    override fun toString(): String = "LoadAllAnalogValueQuery"
}

data class AnalogValueFetchOneSummary(@Id var analogValueId : UUID? = null) {
}





// -----------------------------------------
// AngleDegrees Queries 
// -----------------------------------------

data class LoadAngleDegreesFilter(val angleDegreesId :  UUID? = null )

class FindAngleDegreesQuery(val filter: LoadAngleDegreesFilter = LoadAngleDegreesFilter()) {
    override fun toString(): String = "LoadAngleDegreesQuery"
}

class FindAllAngleDegreesQuery() {
    override fun toString(): String = "LoadAllAngleDegreesQuery"
}

data class AngleDegreesFetchOneSummary(@Id var angleDegreesId : UUID? = null) {
}





// -----------------------------------------
// AngleRadians Queries 
// -----------------------------------------

data class LoadAngleRadiansFilter(val angleRadiansId :  UUID? = null )

class FindAngleRadiansQuery(val filter: LoadAngleRadiansFilter = LoadAngleRadiansFilter()) {
    override fun toString(): String = "LoadAngleRadiansQuery"
}

class FindAllAngleRadiansQuery() {
    override fun toString(): String = "LoadAllAngleRadiansQuery"
}

data class AngleRadiansFetchOneSummary(@Id var angleRadiansId : UUID? = null) {
}





// -----------------------------------------
// ApparentPower Queries 
// -----------------------------------------

data class LoadApparentPowerFilter(val apparentPowerId :  UUID? = null )

class FindApparentPowerQuery(val filter: LoadApparentPowerFilter = LoadApparentPowerFilter()) {
    override fun toString(): String = "LoadApparentPowerQuery"
}

class FindAllApparentPowerQuery() {
    override fun toString(): String = "LoadAllApparentPowerQuery"
}

data class ApparentPowerFetchOneSummary(@Id var apparentPowerId : UUID? = null) {
}





// -----------------------------------------
// ApparentPowerLimit Queries 
// -----------------------------------------

data class LoadApparentPowerLimitFilter(val apparentPowerLimitId :  UUID? = null )

class FindApparentPowerLimitQuery(val filter: LoadApparentPowerLimitFilter = LoadApparentPowerLimitFilter()) {
    override fun toString(): String = "LoadApparentPowerLimitQuery"
}

class FindAllApparentPowerLimitQuery() {
    override fun toString(): String = "LoadAllApparentPowerLimitQuery"
}

data class ApparentPowerLimitFetchOneSummary(@Id var apparentPowerLimitId : UUID? = null) {
}





// -----------------------------------------
// Area Queries 
// -----------------------------------------

data class LoadAreaFilter(val areaId :  UUID? = null )

class FindAreaQuery(val filter: LoadAreaFilter = LoadAreaFilter()) {
    override fun toString(): String = "LoadAreaQuery"
}

class FindAllAreaQuery() {
    override fun toString(): String = "LoadAllAreaQuery"
}

data class AreaFetchOneSummary(@Id var areaId : UUID? = null) {
}





// -----------------------------------------
// AsynchronousMachine Queries 
// -----------------------------------------

data class LoadAsynchronousMachineFilter(val asynchronousMachineId :  UUID? = null )

class FindAsynchronousMachineQuery(val filter: LoadAsynchronousMachineFilter = LoadAsynchronousMachineFilter()) {
    override fun toString(): String = "LoadAsynchronousMachineQuery"
}

class FindAllAsynchronousMachineQuery() {
    override fun toString(): String = "LoadAllAsynchronousMachineQuery"
}

data class AsynchronousMachineFetchOneSummary(@Id var asynchronousMachineId : UUID? = null) {
}





// -----------------------------------------
// AsynchronousMachineDynamics Queries 
// -----------------------------------------

data class LoadAsynchronousMachineDynamicsFilter(val asynchronousMachineDynamicsId :  UUID? = null )

class FindAsynchronousMachineDynamicsQuery(val filter: LoadAsynchronousMachineDynamicsFilter = LoadAsynchronousMachineDynamicsFilter()) {
    override fun toString(): String = "LoadAsynchronousMachineDynamicsQuery"
}

class FindAllAsynchronousMachineDynamicsQuery() {
    override fun toString(): String = "LoadAllAsynchronousMachineDynamicsQuery"
}

data class AsynchronousMachineDynamicsFetchOneSummary(@Id var asynchronousMachineDynamicsId : UUID? = null) {
}





// -----------------------------------------
// AsynchronousMachineEquivalentCircuit Queries 
// -----------------------------------------

data class LoadAsynchronousMachineEquivalentCircuitFilter(val asynchronousMachineEquivalentCircuitId :  UUID? = null )

class FindAsynchronousMachineEquivalentCircuitQuery(val filter: LoadAsynchronousMachineEquivalentCircuitFilter = LoadAsynchronousMachineEquivalentCircuitFilter()) {
    override fun toString(): String = "LoadAsynchronousMachineEquivalentCircuitQuery"
}

class FindAllAsynchronousMachineEquivalentCircuitQuery() {
    override fun toString(): String = "LoadAllAsynchronousMachineEquivalentCircuitQuery"
}

data class AsynchronousMachineEquivalentCircuitFetchOneSummary(@Id var asynchronousMachineEquivalentCircuitId : UUID? = null) {
}





// -----------------------------------------
// AsynchronousMachineTimeConstantReactance Queries 
// -----------------------------------------

data class LoadAsynchronousMachineTimeConstantReactanceFilter(val asynchronousMachineTimeConstantReactanceId :  UUID? = null )

class FindAsynchronousMachineTimeConstantReactanceQuery(val filter: LoadAsynchronousMachineTimeConstantReactanceFilter = LoadAsynchronousMachineTimeConstantReactanceFilter()) {
    override fun toString(): String = "LoadAsynchronousMachineTimeConstantReactanceQuery"
}

class FindAllAsynchronousMachineTimeConstantReactanceQuery() {
    override fun toString(): String = "LoadAllAsynchronousMachineTimeConstantReactanceQuery"
}

data class AsynchronousMachineTimeConstantReactanceFetchOneSummary(@Id var asynchronousMachineTimeConstantReactanceId : UUID? = null) {
}





// -----------------------------------------
// AsynchronousMachineUserDefined Queries 
// -----------------------------------------

data class LoadAsynchronousMachineUserDefinedFilter(val asynchronousMachineUserDefinedId :  UUID? = null )

class FindAsynchronousMachineUserDefinedQuery(val filter: LoadAsynchronousMachineUserDefinedFilter = LoadAsynchronousMachineUserDefinedFilter()) {
    override fun toString(): String = "LoadAsynchronousMachineUserDefinedQuery"
}

class FindAllAsynchronousMachineUserDefinedQuery() {
    override fun toString(): String = "LoadAllAsynchronousMachineUserDefinedQuery"
}

data class AsynchronousMachineUserDefinedFetchOneSummary(@Id var asynchronousMachineUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// BaseVoltage Queries 
// -----------------------------------------

data class LoadBaseVoltageFilter(val baseVoltageId :  UUID? = null )

class FindBaseVoltageQuery(val filter: LoadBaseVoltageFilter = LoadBaseVoltageFilter()) {
    override fun toString(): String = "LoadBaseVoltageQuery"
}

class FindAllBaseVoltageQuery() {
    override fun toString(): String = "LoadAllBaseVoltageQuery"
}

data class BaseVoltageFetchOneSummary(@Id var baseVoltageId : UUID? = null) {
}





// -----------------------------------------
// BasicIntervalSchedule Queries 
// -----------------------------------------

data class LoadBasicIntervalScheduleFilter(val basicIntervalScheduleId :  UUID? = null )

class FindBasicIntervalScheduleQuery(val filter: LoadBasicIntervalScheduleFilter = LoadBasicIntervalScheduleFilter()) {
    override fun toString(): String = "LoadBasicIntervalScheduleQuery"
}

class FindAllBasicIntervalScheduleQuery() {
    override fun toString(): String = "LoadAllBasicIntervalScheduleQuery"
}

data class BasicIntervalScheduleFetchOneSummary(@Id var basicIntervalScheduleId : UUID? = null) {
}





// -----------------------------------------
// Bay Queries 
// -----------------------------------------

data class LoadBayFilter(val bayId :  UUID? = null )

class FindBayQuery(val filter: LoadBayFilter = LoadBayFilter()) {
    override fun toString(): String = "LoadBayQuery"
}

class FindAllBayQuery() {
    override fun toString(): String = "LoadAllBayQuery"
}

data class BayFetchOneSummary(@Id var bayId : UUID? = null) {
}





// -----------------------------------------
// BooleanProxy Queries 
// -----------------------------------------

data class LoadBooleanProxyFilter(val booleanProxyId :  UUID? = null )

class FindBooleanProxyQuery(val filter: LoadBooleanProxyFilter = LoadBooleanProxyFilter()) {
    override fun toString(): String = "LoadBooleanProxyQuery"
}

class FindAllBooleanProxyQuery() {
    override fun toString(): String = "LoadAllBooleanProxyQuery"
}

data class BooleanProxyFetchOneSummary(@Id var booleanProxyId : UUID? = null) {
}





// -----------------------------------------
// BoundaryExtensions Queries 
// -----------------------------------------

data class LoadBoundaryExtensionsFilter(val boundaryExtensionsId :  UUID? = null )

class FindBoundaryExtensionsQuery(val filter: LoadBoundaryExtensionsFilter = LoadBoundaryExtensionsFilter()) {
    override fun toString(): String = "LoadBoundaryExtensionsQuery"
}

class FindAllBoundaryExtensionsQuery() {
    override fun toString(): String = "LoadAllBoundaryExtensionsQuery"
}

data class BoundaryExtensionsFetchOneSummary(@Id var boundaryExtensionsId : UUID? = null) {
}





// -----------------------------------------
// Breaker Queries 
// -----------------------------------------

data class LoadBreakerFilter(val breakerId :  UUID? = null )

class FindBreakerQuery(val filter: LoadBreakerFilter = LoadBreakerFilter()) {
    override fun toString(): String = "LoadBreakerQuery"
}

class FindAllBreakerQuery() {
    override fun toString(): String = "LoadAllBreakerQuery"
}

data class BreakerFetchOneSummary(@Id var breakerId : UUID? = null) {
}





// -----------------------------------------
// BusNameMarker Queries 
// -----------------------------------------

data class LoadBusNameMarkerFilter(val busNameMarkerId :  UUID? = null )

class FindBusNameMarkerQuery(val filter: LoadBusNameMarkerFilter = LoadBusNameMarkerFilter()) {
    override fun toString(): String = "LoadBusNameMarkerQuery"
}

class FindAllBusNameMarkerQuery() {
    override fun toString(): String = "LoadAllBusNameMarkerQuery"
}

data class BusNameMarkerFetchOneSummary(@Id var busNameMarkerId : UUID? = null) {
}





// -----------------------------------------
// BusbarSection Queries 
// -----------------------------------------

data class LoadBusbarSectionFilter(val busbarSectionId :  UUID? = null )

class FindBusbarSectionQuery(val filter: LoadBusbarSectionFilter = LoadBusbarSectionFilter()) {
    override fun toString(): String = "LoadBusbarSectionQuery"
}

class FindAllBusbarSectionQuery() {
    override fun toString(): String = "LoadAllBusbarSectionQuery"
}

data class BusbarSectionFetchOneSummary(@Id var busbarSectionId : UUID? = null) {
}





// -----------------------------------------
// Capacitance Queries 
// -----------------------------------------

data class LoadCapacitanceFilter(val capacitanceId :  UUID? = null )

class FindCapacitanceQuery(val filter: LoadCapacitanceFilter = LoadCapacitanceFilter()) {
    override fun toString(): String = "LoadCapacitanceQuery"
}

class FindAllCapacitanceQuery() {
    override fun toString(): String = "LoadAllCapacitanceQuery"
}

data class CapacitanceFetchOneSummary(@Id var capacitanceId : UUID? = null) {
}





// -----------------------------------------
// CapacitancePerLength Queries 
// -----------------------------------------

data class LoadCapacitancePerLengthFilter(val capacitancePerLengthId :  UUID? = null )

class FindCapacitancePerLengthQuery(val filter: LoadCapacitancePerLengthFilter = LoadCapacitancePerLengthFilter()) {
    override fun toString(): String = "LoadCapacitancePerLengthQuery"
}

class FindAllCapacitancePerLengthQuery() {
    override fun toString(): String = "LoadAllCapacitancePerLengthQuery"
}

data class CapacitancePerLengthFetchOneSummary(@Id var capacitancePerLengthId : UUID? = null) {
}





// -----------------------------------------
// Command Queries 
// -----------------------------------------

data class LoadCommandFilter(val commandId :  UUID? = null )

class FindCommandQuery(val filter: LoadCommandFilter = LoadCommandFilter()) {
    override fun toString(): String = "LoadCommandQuery"
}

class FindAllCommandQuery() {
    override fun toString(): String = "LoadAllCommandQuery"
}

data class CommandFetchOneSummary(@Id var commandId : UUID? = null) {
}





// -----------------------------------------
// Conductance Queries 
// -----------------------------------------

data class LoadConductanceFilter(val conductanceId :  UUID? = null )

class FindConductanceQuery(val filter: LoadConductanceFilter = LoadConductanceFilter()) {
    override fun toString(): String = "LoadConductanceQuery"
}

class FindAllConductanceQuery() {
    override fun toString(): String = "LoadAllConductanceQuery"
}

data class ConductanceFetchOneSummary(@Id var conductanceId : UUID? = null) {
}





// -----------------------------------------
// ConductingEquipment Queries 
// -----------------------------------------

data class LoadConductingEquipmentFilter(val conductingEquipmentId :  UUID? = null )

class FindConductingEquipmentQuery(val filter: LoadConductingEquipmentFilter = LoadConductingEquipmentFilter()) {
    override fun toString(): String = "LoadConductingEquipmentQuery"
}

class FindAllConductingEquipmentQuery() {
    override fun toString(): String = "LoadAllConductingEquipmentQuery"
}

data class ConductingEquipmentFetchOneSummary(@Id var conductingEquipmentId : UUID? = null) {
}





// -----------------------------------------
// Conductor Queries 
// -----------------------------------------

data class LoadConductorFilter(val conductorId :  UUID? = null )

class FindConductorQuery(val filter: LoadConductorFilter = LoadConductorFilter()) {
    override fun toString(): String = "LoadConductorQuery"
}

class FindAllConductorQuery() {
    override fun toString(): String = "LoadAllConductorQuery"
}

data class ConductorFetchOneSummary(@Id var conductorId : UUID? = null) {
}





// -----------------------------------------
// ConformLoad Queries 
// -----------------------------------------

data class LoadConformLoadFilter(val conformLoadId :  UUID? = null )

class FindConformLoadQuery(val filter: LoadConformLoadFilter = LoadConformLoadFilter()) {
    override fun toString(): String = "LoadConformLoadQuery"
}

class FindAllConformLoadQuery() {
    override fun toString(): String = "LoadAllConformLoadQuery"
}

data class ConformLoadFetchOneSummary(@Id var conformLoadId : UUID? = null) {
}





// -----------------------------------------
// ConformLoadGroup Queries 
// -----------------------------------------

data class LoadConformLoadGroupFilter(val conformLoadGroupId :  UUID? = null )

class FindConformLoadGroupQuery(val filter: LoadConformLoadGroupFilter = LoadConformLoadGroupFilter()) {
    override fun toString(): String = "LoadConformLoadGroupQuery"
}

class FindAllConformLoadGroupQuery() {
    override fun toString(): String = "LoadAllConformLoadGroupQuery"
}

data class ConformLoadGroupFetchOneSummary(@Id var conformLoadGroupId : UUID? = null) {
}





// -----------------------------------------
// ConformLoadSchedule Queries 
// -----------------------------------------

data class LoadConformLoadScheduleFilter(val conformLoadScheduleId :  UUID? = null )

class FindConformLoadScheduleQuery(val filter: LoadConformLoadScheduleFilter = LoadConformLoadScheduleFilter()) {
    override fun toString(): String = "LoadConformLoadScheduleQuery"
}

class FindAllConformLoadScheduleQuery() {
    override fun toString(): String = "LoadAllConformLoadScheduleQuery"
}

data class ConformLoadScheduleFetchOneSummary(@Id var conformLoadScheduleId : UUID? = null) {
}





// -----------------------------------------
// ConnectivityNode Queries 
// -----------------------------------------

data class LoadConnectivityNodeFilter(val connectivityNodeId :  UUID? = null )

class FindConnectivityNodeQuery(val filter: LoadConnectivityNodeFilter = LoadConnectivityNodeFilter()) {
    override fun toString(): String = "LoadConnectivityNodeQuery"
}

class FindAllConnectivityNodeQuery() {
    override fun toString(): String = "LoadAllConnectivityNodeQuery"
}

data class ConnectivityNodeFetchOneSummary(@Id var connectivityNodeId : UUID? = null) {
}





// -----------------------------------------
// ConnectivityNodeContainer Queries 
// -----------------------------------------

data class LoadConnectivityNodeContainerFilter(val connectivityNodeContainerId :  UUID? = null )

class FindConnectivityNodeContainerQuery(val filter: LoadConnectivityNodeContainerFilter = LoadConnectivityNodeContainerFilter()) {
    override fun toString(): String = "LoadConnectivityNodeContainerQuery"
}

class FindAllConnectivityNodeContainerQuery() {
    override fun toString(): String = "LoadAllConnectivityNodeContainerQuery"
}

data class ConnectivityNodeContainerFetchOneSummary(@Id var connectivityNodeContainerId : UUID? = null) {
}





// -----------------------------------------
// Connector Queries 
// -----------------------------------------

data class LoadConnectorFilter(val connectorId :  UUID? = null )

class FindConnectorQuery(val filter: LoadConnectorFilter = LoadConnectorFilter()) {
    override fun toString(): String = "LoadConnectorQuery"
}

class FindAllConnectorQuery() {
    override fun toString(): String = "LoadAllConnectorQuery"
}

data class ConnectorFetchOneSummary(@Id var connectorId : UUID? = null) {
}





// -----------------------------------------
// Control Queries 
// -----------------------------------------

data class LoadControlFilter(val controlId :  UUID? = null )

class FindControlQuery(val filter: LoadControlFilter = LoadControlFilter()) {
    override fun toString(): String = "LoadControlQuery"
}

class FindAllControlQuery() {
    override fun toString(): String = "LoadAllControlQuery"
}

data class ControlFetchOneSummary(@Id var controlId : UUID? = null) {
}





// -----------------------------------------
// ControlArea Queries 
// -----------------------------------------

data class LoadControlAreaFilter(val controlAreaId :  UUID? = null )

class FindControlAreaQuery(val filter: LoadControlAreaFilter = LoadControlAreaFilter()) {
    override fun toString(): String = "LoadControlAreaQuery"
}

class FindAllControlAreaQuery() {
    override fun toString(): String = "LoadAllControlAreaQuery"
}

data class ControlAreaFetchOneSummary(@Id var controlAreaId : UUID? = null) {
}





// -----------------------------------------
// ControlAreaGeneratingUnit Queries 
// -----------------------------------------

data class LoadControlAreaGeneratingUnitFilter(val controlAreaGeneratingUnitId :  UUID? = null )

class FindControlAreaGeneratingUnitQuery(val filter: LoadControlAreaGeneratingUnitFilter = LoadControlAreaGeneratingUnitFilter()) {
    override fun toString(): String = "LoadControlAreaGeneratingUnitQuery"
}

class FindAllControlAreaGeneratingUnitQuery() {
    override fun toString(): String = "LoadAllControlAreaGeneratingUnitQuery"
}

data class ControlAreaGeneratingUnitFetchOneSummary(@Id var controlAreaGeneratingUnitId : UUID? = null) {
}





// -----------------------------------------
// CoordinateSystem Queries 
// -----------------------------------------

data class LoadCoordinateSystemFilter(val coordinateSystemId :  UUID? = null )

class FindCoordinateSystemQuery(val filter: LoadCoordinateSystemFilter = LoadCoordinateSystemFilter()) {
    override fun toString(): String = "LoadCoordinateSystemQuery"
}

class FindAllCoordinateSystemQuery() {
    override fun toString(): String = "LoadAllCoordinateSystemQuery"
}

data class CoordinateSystemFetchOneSummary(@Id var coordinateSystemId : UUID? = null) {
}





// -----------------------------------------
// CsConverter Queries 
// -----------------------------------------

data class LoadCsConverterFilter(val csConverterId :  UUID? = null )

class FindCsConverterQuery(val filter: LoadCsConverterFilter = LoadCsConverterFilter()) {
    override fun toString(): String = "LoadCsConverterQuery"
}

class FindAllCsConverterQuery() {
    override fun toString(): String = "LoadAllCsConverterQuery"
}

data class CsConverterFetchOneSummary(@Id var csConverterId : UUID? = null) {
}





// -----------------------------------------
// CurrentFlow Queries 
// -----------------------------------------

data class LoadCurrentFlowFilter(val currentFlowId :  UUID? = null )

class FindCurrentFlowQuery(val filter: LoadCurrentFlowFilter = LoadCurrentFlowFilter()) {
    override fun toString(): String = "LoadCurrentFlowQuery"
}

class FindAllCurrentFlowQuery() {
    override fun toString(): String = "LoadAllCurrentFlowQuery"
}

data class CurrentFlowFetchOneSummary(@Id var currentFlowId : UUID? = null) {
}





// -----------------------------------------
// CurrentLimit Queries 
// -----------------------------------------

data class LoadCurrentLimitFilter(val currentLimitId :  UUID? = null )

class FindCurrentLimitQuery(val filter: LoadCurrentLimitFilter = LoadCurrentLimitFilter()) {
    override fun toString(): String = "LoadCurrentLimitQuery"
}

class FindAllCurrentLimitQuery() {
    override fun toString(): String = "LoadAllCurrentLimitQuery"
}

data class CurrentLimitFetchOneSummary(@Id var currentLimitId : UUID? = null) {
}





// -----------------------------------------
// Curve Queries 
// -----------------------------------------

data class LoadCurveFilter(val curveId :  UUID? = null )

class FindCurveQuery(val filter: LoadCurveFilter = LoadCurveFilter()) {
    override fun toString(): String = "LoadCurveQuery"
}

class FindAllCurveQuery() {
    override fun toString(): String = "LoadAllCurveQuery"
}

data class CurveFetchOneSummary(@Id var curveId : UUID? = null) {
}





// -----------------------------------------
// CurveData Queries 
// -----------------------------------------

data class LoadCurveDataFilter(val curveDataId :  UUID? = null )

class FindCurveDataQuery(val filter: LoadCurveDataFilter = LoadCurveDataFilter()) {
    override fun toString(): String = "LoadCurveDataQuery"
}

class FindAllCurveDataQuery() {
    override fun toString(): String = "LoadAllCurveDataQuery"
}

data class CurveDataFetchOneSummary(@Id var curveDataId : UUID? = null) {
}





// -----------------------------------------
// DCBaseTerminal Queries 
// -----------------------------------------

data class LoadDCBaseTerminalFilter(val dCBaseTerminalId :  UUID? = null )

class FindDCBaseTerminalQuery(val filter: LoadDCBaseTerminalFilter = LoadDCBaseTerminalFilter()) {
    override fun toString(): String = "LoadDCBaseTerminalQuery"
}

class FindAllDCBaseTerminalQuery() {
    override fun toString(): String = "LoadAllDCBaseTerminalQuery"
}

data class DCBaseTerminalFetchOneSummary(@Id var dCBaseTerminalId : UUID? = null) {
}





// -----------------------------------------
// DCBreaker Queries 
// -----------------------------------------

data class LoadDCBreakerFilter(val dCBreakerId :  UUID? = null )

class FindDCBreakerQuery(val filter: LoadDCBreakerFilter = LoadDCBreakerFilter()) {
    override fun toString(): String = "LoadDCBreakerQuery"
}

class FindAllDCBreakerQuery() {
    override fun toString(): String = "LoadAllDCBreakerQuery"
}

data class DCBreakerFetchOneSummary(@Id var dCBreakerId : UUID? = null) {
}





// -----------------------------------------
// DCBusbar Queries 
// -----------------------------------------

data class LoadDCBusbarFilter(val dCBusbarId :  UUID? = null )

class FindDCBusbarQuery(val filter: LoadDCBusbarFilter = LoadDCBusbarFilter()) {
    override fun toString(): String = "LoadDCBusbarQuery"
}

class FindAllDCBusbarQuery() {
    override fun toString(): String = "LoadAllDCBusbarQuery"
}

data class DCBusbarFetchOneSummary(@Id var dCBusbarId : UUID? = null) {
}





// -----------------------------------------
// DCChopper Queries 
// -----------------------------------------

data class LoadDCChopperFilter(val dCChopperId :  UUID? = null )

class FindDCChopperQuery(val filter: LoadDCChopperFilter = LoadDCChopperFilter()) {
    override fun toString(): String = "LoadDCChopperQuery"
}

class FindAllDCChopperQuery() {
    override fun toString(): String = "LoadAllDCChopperQuery"
}

data class DCChopperFetchOneSummary(@Id var dCChopperId : UUID? = null) {
}





// -----------------------------------------
// DCConductingEquipment Queries 
// -----------------------------------------

data class LoadDCConductingEquipmentFilter(val dCConductingEquipmentId :  UUID? = null )

class FindDCConductingEquipmentQuery(val filter: LoadDCConductingEquipmentFilter = LoadDCConductingEquipmentFilter()) {
    override fun toString(): String = "LoadDCConductingEquipmentQuery"
}

class FindAllDCConductingEquipmentQuery() {
    override fun toString(): String = "LoadAllDCConductingEquipmentQuery"
}

data class DCConductingEquipmentFetchOneSummary(@Id var dCConductingEquipmentId : UUID? = null) {
}





// -----------------------------------------
// DCConverterUnit Queries 
// -----------------------------------------

data class LoadDCConverterUnitFilter(val dCConverterUnitId :  UUID? = null )

class FindDCConverterUnitQuery(val filter: LoadDCConverterUnitFilter = LoadDCConverterUnitFilter()) {
    override fun toString(): String = "LoadDCConverterUnitQuery"
}

class FindAllDCConverterUnitQuery() {
    override fun toString(): String = "LoadAllDCConverterUnitQuery"
}

data class DCConverterUnitFetchOneSummary(@Id var dCConverterUnitId : UUID? = null) {
}





// -----------------------------------------
// DCDisconnector Queries 
// -----------------------------------------

data class LoadDCDisconnectorFilter(val dCDisconnectorId :  UUID? = null )

class FindDCDisconnectorQuery(val filter: LoadDCDisconnectorFilter = LoadDCDisconnectorFilter()) {
    override fun toString(): String = "LoadDCDisconnectorQuery"
}

class FindAllDCDisconnectorQuery() {
    override fun toString(): String = "LoadAllDCDisconnectorQuery"
}

data class DCDisconnectorFetchOneSummary(@Id var dCDisconnectorId : UUID? = null) {
}





// -----------------------------------------
// DCEquipmentContainer Queries 
// -----------------------------------------

data class LoadDCEquipmentContainerFilter(val dCEquipmentContainerId :  UUID? = null )

class FindDCEquipmentContainerQuery(val filter: LoadDCEquipmentContainerFilter = LoadDCEquipmentContainerFilter()) {
    override fun toString(): String = "LoadDCEquipmentContainerQuery"
}

class FindAllDCEquipmentContainerQuery() {
    override fun toString(): String = "LoadAllDCEquipmentContainerQuery"
}

data class DCEquipmentContainerFetchOneSummary(@Id var dCEquipmentContainerId : UUID? = null) {
}





// -----------------------------------------
// DCGround Queries 
// -----------------------------------------

data class LoadDCGroundFilter(val dCGroundId :  UUID? = null )

class FindDCGroundQuery(val filter: LoadDCGroundFilter = LoadDCGroundFilter()) {
    override fun toString(): String = "LoadDCGroundQuery"
}

class FindAllDCGroundQuery() {
    override fun toString(): String = "LoadAllDCGroundQuery"
}

data class DCGroundFetchOneSummary(@Id var dCGroundId : UUID? = null) {
}





// -----------------------------------------
// DCLine Queries 
// -----------------------------------------

data class LoadDCLineFilter(val dCLineId :  UUID? = null )

class FindDCLineQuery(val filter: LoadDCLineFilter = LoadDCLineFilter()) {
    override fun toString(): String = "LoadDCLineQuery"
}

class FindAllDCLineQuery() {
    override fun toString(): String = "LoadAllDCLineQuery"
}

data class DCLineFetchOneSummary(@Id var dCLineId : UUID? = null) {
}





// -----------------------------------------
// DCLineSegment Queries 
// -----------------------------------------

data class LoadDCLineSegmentFilter(val dCLineSegmentId :  UUID? = null )

class FindDCLineSegmentQuery(val filter: LoadDCLineSegmentFilter = LoadDCLineSegmentFilter()) {
    override fun toString(): String = "LoadDCLineSegmentQuery"
}

class FindAllDCLineSegmentQuery() {
    override fun toString(): String = "LoadAllDCLineSegmentQuery"
}

data class DCLineSegmentFetchOneSummary(@Id var dCLineSegmentId : UUID? = null) {
}





// -----------------------------------------
// DCNode Queries 
// -----------------------------------------

data class LoadDCNodeFilter(val dCNodeId :  UUID? = null )

class FindDCNodeQuery(val filter: LoadDCNodeFilter = LoadDCNodeFilter()) {
    override fun toString(): String = "LoadDCNodeQuery"
}

class FindAllDCNodeQuery() {
    override fun toString(): String = "LoadAllDCNodeQuery"
}

data class DCNodeFetchOneSummary(@Id var dCNodeId : UUID? = null) {
}





// -----------------------------------------
// DCSeriesDevice Queries 
// -----------------------------------------

data class LoadDCSeriesDeviceFilter(val dCSeriesDeviceId :  UUID? = null )

class FindDCSeriesDeviceQuery(val filter: LoadDCSeriesDeviceFilter = LoadDCSeriesDeviceFilter()) {
    override fun toString(): String = "LoadDCSeriesDeviceQuery"
}

class FindAllDCSeriesDeviceQuery() {
    override fun toString(): String = "LoadAllDCSeriesDeviceQuery"
}

data class DCSeriesDeviceFetchOneSummary(@Id var dCSeriesDeviceId : UUID? = null) {
}





// -----------------------------------------
// DCShunt Queries 
// -----------------------------------------

data class LoadDCShuntFilter(val dCShuntId :  UUID? = null )

class FindDCShuntQuery(val filter: LoadDCShuntFilter = LoadDCShuntFilter()) {
    override fun toString(): String = "LoadDCShuntQuery"
}

class FindAllDCShuntQuery() {
    override fun toString(): String = "LoadAllDCShuntQuery"
}

data class DCShuntFetchOneSummary(@Id var dCShuntId : UUID? = null) {
}





// -----------------------------------------
// DCSwitch Queries 
// -----------------------------------------

data class LoadDCSwitchFilter(val dCSwitchId :  UUID? = null )

class FindDCSwitchQuery(val filter: LoadDCSwitchFilter = LoadDCSwitchFilter()) {
    override fun toString(): String = "LoadDCSwitchQuery"
}

class FindAllDCSwitchQuery() {
    override fun toString(): String = "LoadAllDCSwitchQuery"
}

data class DCSwitchFetchOneSummary(@Id var dCSwitchId : UUID? = null) {
}





// -----------------------------------------
// DCTerminal Queries 
// -----------------------------------------

data class LoadDCTerminalFilter(val dCTerminalId :  UUID? = null )

class FindDCTerminalQuery(val filter: LoadDCTerminalFilter = LoadDCTerminalFilter()) {
    override fun toString(): String = "LoadDCTerminalQuery"
}

class FindAllDCTerminalQuery() {
    override fun toString(): String = "LoadAllDCTerminalQuery"
}

data class DCTerminalFetchOneSummary(@Id var dCTerminalId : UUID? = null) {
}





// -----------------------------------------
// DCTopologicalIsland Queries 
// -----------------------------------------

data class LoadDCTopologicalIslandFilter(val dCTopologicalIslandId :  UUID? = null )

class FindDCTopologicalIslandQuery(val filter: LoadDCTopologicalIslandFilter = LoadDCTopologicalIslandFilter()) {
    override fun toString(): String = "LoadDCTopologicalIslandQuery"
}

class FindAllDCTopologicalIslandQuery() {
    override fun toString(): String = "LoadAllDCTopologicalIslandQuery"
}

data class DCTopologicalIslandFetchOneSummary(@Id var dCTopologicalIslandId : UUID? = null) {
}





// -----------------------------------------
// DCTopologicalNode Queries 
// -----------------------------------------

data class LoadDCTopologicalNodeFilter(val dCTopologicalNodeId :  UUID? = null )

class FindDCTopologicalNodeQuery(val filter: LoadDCTopologicalNodeFilter = LoadDCTopologicalNodeFilter()) {
    override fun toString(): String = "LoadDCTopologicalNodeQuery"
}

class FindAllDCTopologicalNodeQuery() {
    override fun toString(): String = "LoadAllDCTopologicalNodeQuery"
}

data class DCTopologicalNodeFetchOneSummary(@Id var dCTopologicalNodeId : UUID? = null) {
}





// -----------------------------------------
// DateProxy Queries 
// -----------------------------------------

data class LoadDateProxyFilter(val dateProxyId :  UUID? = null )

class FindDateProxyQuery(val filter: LoadDateProxyFilter = LoadDateProxyFilter()) {
    override fun toString(): String = "LoadDateProxyQuery"
}

class FindAllDateProxyQuery() {
    override fun toString(): String = "LoadAllDateProxyQuery"
}

data class DateProxyFetchOneSummary(@Id var dateProxyId : UUID? = null) {
}





// -----------------------------------------
// DateTime Queries 
// -----------------------------------------

data class LoadDateTimeFilter(val dateTimeId :  UUID? = null )

class FindDateTimeQuery(val filter: LoadDateTimeFilter = LoadDateTimeFilter()) {
    override fun toString(): String = "LoadDateTimeQuery"
}

class FindAllDateTimeQuery() {
    override fun toString(): String = "LoadAllDateTimeQuery"
}

data class DateTimeFetchOneSummary(@Id var dateTimeId : UUID? = null) {
}





// -----------------------------------------
// DayType Queries 
// -----------------------------------------

data class LoadDayTypeFilter(val dayTypeId :  UUID? = null )

class FindDayTypeQuery(val filter: LoadDayTypeFilter = LoadDayTypeFilter()) {
    override fun toString(): String = "LoadDayTypeQuery"
}

class FindAllDayTypeQuery() {
    override fun toString(): String = "LoadAllDayTypeQuery"
}

data class DayTypeFetchOneSummary(@Id var dayTypeId : UUID? = null) {
}





// -----------------------------------------
// DecimalProxy Queries 
// -----------------------------------------

data class LoadDecimalProxyFilter(val decimalProxyId :  UUID? = null )

class FindDecimalProxyQuery(val filter: LoadDecimalProxyFilter = LoadDecimalProxyFilter()) {
    override fun toString(): String = "LoadDecimalProxyQuery"
}

class FindAllDecimalProxyQuery() {
    override fun toString(): String = "LoadAllDecimalProxyQuery"
}

data class DecimalProxyFetchOneSummary(@Id var decimalProxyId : UUID? = null) {
}





// -----------------------------------------
// Diagram Queries 
// -----------------------------------------

data class LoadDiagramFilter(val diagramId :  UUID? = null )

class FindDiagramQuery(val filter: LoadDiagramFilter = LoadDiagramFilter()) {
    override fun toString(): String = "LoadDiagramQuery"
}

class FindAllDiagramQuery() {
    override fun toString(): String = "LoadAllDiagramQuery"
}

data class DiagramFetchOneSummary(@Id var diagramId : UUID? = null) {
}





// -----------------------------------------
// DiagramLayoutVersion Queries 
// -----------------------------------------

data class LoadDiagramLayoutVersionFilter(val diagramLayoutVersionId :  UUID? = null )

class FindDiagramLayoutVersionQuery(val filter: LoadDiagramLayoutVersionFilter = LoadDiagramLayoutVersionFilter()) {
    override fun toString(): String = "LoadDiagramLayoutVersionQuery"
}

class FindAllDiagramLayoutVersionQuery() {
    override fun toString(): String = "LoadAllDiagramLayoutVersionQuery"
}

data class DiagramLayoutVersionFetchOneSummary(@Id var diagramLayoutVersionId : UUID? = null) {
}





// -----------------------------------------
// DiagramObject Queries 
// -----------------------------------------

data class LoadDiagramObjectFilter(val diagramObjectId :  UUID? = null )

class FindDiagramObjectQuery(val filter: LoadDiagramObjectFilter = LoadDiagramObjectFilter()) {
    override fun toString(): String = "LoadDiagramObjectQuery"
}

class FindAllDiagramObjectQuery() {
    override fun toString(): String = "LoadAllDiagramObjectQuery"
}

data class DiagramObjectFetchOneSummary(@Id var diagramObjectId : UUID? = null) {
}





// -----------------------------------------
// DiagramObjectGluePoint Queries 
// -----------------------------------------

data class LoadDiagramObjectGluePointFilter(val diagramObjectGluePointId :  UUID? = null )

class FindDiagramObjectGluePointQuery(val filter: LoadDiagramObjectGluePointFilter = LoadDiagramObjectGluePointFilter()) {
    override fun toString(): String = "LoadDiagramObjectGluePointQuery"
}

class FindAllDiagramObjectGluePointQuery() {
    override fun toString(): String = "LoadAllDiagramObjectGluePointQuery"
}

data class DiagramObjectGluePointFetchOneSummary(@Id var diagramObjectGluePointId : UUID? = null) {
}





// -----------------------------------------
// DiagramObjectPoint Queries 
// -----------------------------------------

data class LoadDiagramObjectPointFilter(val diagramObjectPointId :  UUID? = null )

class FindDiagramObjectPointQuery(val filter: LoadDiagramObjectPointFilter = LoadDiagramObjectPointFilter()) {
    override fun toString(): String = "LoadDiagramObjectPointQuery"
}

class FindAllDiagramObjectPointQuery() {
    override fun toString(): String = "LoadAllDiagramObjectPointQuery"
}

data class DiagramObjectPointFetchOneSummary(@Id var diagramObjectPointId : UUID? = null) {
}





// -----------------------------------------
// DiagramObjectStyle Queries 
// -----------------------------------------

data class LoadDiagramObjectStyleFilter(val diagramObjectStyleId :  UUID? = null )

class FindDiagramObjectStyleQuery(val filter: LoadDiagramObjectStyleFilter = LoadDiagramObjectStyleFilter()) {
    override fun toString(): String = "LoadDiagramObjectStyleQuery"
}

class FindAllDiagramObjectStyleQuery() {
    override fun toString(): String = "LoadAllDiagramObjectStyleQuery"
}

data class DiagramObjectStyleFetchOneSummary(@Id var diagramObjectStyleId : UUID? = null) {
}





// -----------------------------------------
// DiagramStyle Queries 
// -----------------------------------------

data class LoadDiagramStyleFilter(val diagramStyleId :  UUID? = null )

class FindDiagramStyleQuery(val filter: LoadDiagramStyleFilter = LoadDiagramStyleFilter()) {
    override fun toString(): String = "LoadDiagramStyleQuery"
}

class FindAllDiagramStyleQuery() {
    override fun toString(): String = "LoadAllDiagramStyleQuery"
}

data class DiagramStyleFetchOneSummary(@Id var diagramStyleId : UUID? = null) {
}





// -----------------------------------------
// DiscExcContIEEEDEC1A Queries 
// -----------------------------------------

data class LoadDiscExcContIEEEDEC1AFilter(val discExcContIEEEDEC1AId :  UUID? = null )

class FindDiscExcContIEEEDEC1AQuery(val filter: LoadDiscExcContIEEEDEC1AFilter = LoadDiscExcContIEEEDEC1AFilter()) {
    override fun toString(): String = "LoadDiscExcContIEEEDEC1AQuery"
}

class FindAllDiscExcContIEEEDEC1AQuery() {
    override fun toString(): String = "LoadAllDiscExcContIEEEDEC1AQuery"
}

data class DiscExcContIEEEDEC1AFetchOneSummary(@Id var discExcContIEEEDEC1AId : UUID? = null) {
}





// -----------------------------------------
// DiscExcContIEEEDEC2A Queries 
// -----------------------------------------

data class LoadDiscExcContIEEEDEC2AFilter(val discExcContIEEEDEC2AId :  UUID? = null )

class FindDiscExcContIEEEDEC2AQuery(val filter: LoadDiscExcContIEEEDEC2AFilter = LoadDiscExcContIEEEDEC2AFilter()) {
    override fun toString(): String = "LoadDiscExcContIEEEDEC2AQuery"
}

class FindAllDiscExcContIEEEDEC2AQuery() {
    override fun toString(): String = "LoadAllDiscExcContIEEEDEC2AQuery"
}

data class DiscExcContIEEEDEC2AFetchOneSummary(@Id var discExcContIEEEDEC2AId : UUID? = null) {
}





// -----------------------------------------
// DiscExcContIEEEDEC3A Queries 
// -----------------------------------------

data class LoadDiscExcContIEEEDEC3AFilter(val discExcContIEEEDEC3AId :  UUID? = null )

class FindDiscExcContIEEEDEC3AQuery(val filter: LoadDiscExcContIEEEDEC3AFilter = LoadDiscExcContIEEEDEC3AFilter()) {
    override fun toString(): String = "LoadDiscExcContIEEEDEC3AQuery"
}

class FindAllDiscExcContIEEEDEC3AQuery() {
    override fun toString(): String = "LoadAllDiscExcContIEEEDEC3AQuery"
}

data class DiscExcContIEEEDEC3AFetchOneSummary(@Id var discExcContIEEEDEC3AId : UUID? = null) {
}





// -----------------------------------------
// Disconnector Queries 
// -----------------------------------------

data class LoadDisconnectorFilter(val disconnectorId :  UUID? = null )

class FindDisconnectorQuery(val filter: LoadDisconnectorFilter = LoadDisconnectorFilter()) {
    override fun toString(): String = "LoadDisconnectorQuery"
}

class FindAllDisconnectorQuery() {
    override fun toString(): String = "LoadAllDisconnectorQuery"
}

data class DisconnectorFetchOneSummary(@Id var disconnectorId : UUID? = null) {
}





// -----------------------------------------
// DiscontinuousExcitationControlDynamics Queries 
// -----------------------------------------

data class LoadDiscontinuousExcitationControlDynamicsFilter(val discontinuousExcitationControlDynamicsId :  UUID? = null )

class FindDiscontinuousExcitationControlDynamicsQuery(val filter: LoadDiscontinuousExcitationControlDynamicsFilter = LoadDiscontinuousExcitationControlDynamicsFilter()) {
    override fun toString(): String = "LoadDiscontinuousExcitationControlDynamicsQuery"
}

class FindAllDiscontinuousExcitationControlDynamicsQuery() {
    override fun toString(): String = "LoadAllDiscontinuousExcitationControlDynamicsQuery"
}

data class DiscontinuousExcitationControlDynamicsFetchOneSummary(@Id var discontinuousExcitationControlDynamicsId : UUID? = null) {
}





// -----------------------------------------
// DiscontinuousExcitationControlUserDefined Queries 
// -----------------------------------------

data class LoadDiscontinuousExcitationControlUserDefinedFilter(val discontinuousExcitationControlUserDefinedId :  UUID? = null )

class FindDiscontinuousExcitationControlUserDefinedQuery(val filter: LoadDiscontinuousExcitationControlUserDefinedFilter = LoadDiscontinuousExcitationControlUserDefinedFilter()) {
    override fun toString(): String = "LoadDiscontinuousExcitationControlUserDefinedQuery"
}

class FindAllDiscontinuousExcitationControlUserDefinedQuery() {
    override fun toString(): String = "LoadAllDiscontinuousExcitationControlUserDefinedQuery"
}

data class DiscontinuousExcitationControlUserDefinedFetchOneSummary(@Id var discontinuousExcitationControlUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// Discrete Queries 
// -----------------------------------------

data class LoadDiscreteFilter(val discreteId :  UUID? = null )

class FindDiscreteQuery(val filter: LoadDiscreteFilter = LoadDiscreteFilter()) {
    override fun toString(): String = "LoadDiscreteQuery"
}

class FindAllDiscreteQuery() {
    override fun toString(): String = "LoadAllDiscreteQuery"
}

data class DiscreteFetchOneSummary(@Id var discreteId : UUID? = null) {
}





// -----------------------------------------
// DiscreteValue Queries 
// -----------------------------------------

data class LoadDiscreteValueFilter(val discreteValueId :  UUID? = null )

class FindDiscreteValueQuery(val filter: LoadDiscreteValueFilter = LoadDiscreteValueFilter()) {
    override fun toString(): String = "LoadDiscreteValueQuery"
}

class FindAllDiscreteValueQuery() {
    override fun toString(): String = "LoadAllDiscreteValueQuery"
}

data class DiscreteValueFetchOneSummary(@Id var discreteValueId : UUID? = null) {
}





// -----------------------------------------
// DomainVersion Queries 
// -----------------------------------------

data class LoadDomainVersionFilter(val domainVersionId :  UUID? = null )

class FindDomainVersionQuery(val filter: LoadDomainVersionFilter = LoadDomainVersionFilter()) {
    override fun toString(): String = "LoadDomainVersionQuery"
}

class FindAllDomainVersionQuery() {
    override fun toString(): String = "LoadAllDomainVersionQuery"
}

data class DomainVersionFetchOneSummary(@Id var domainVersionId : UUID? = null) {
}





// -----------------------------------------
// DynamicsFunctionBlock Queries 
// -----------------------------------------

data class LoadDynamicsFunctionBlockFilter(val dynamicsFunctionBlockId :  UUID? = null )

class FindDynamicsFunctionBlockQuery(val filter: LoadDynamicsFunctionBlockFilter = LoadDynamicsFunctionBlockFilter()) {
    override fun toString(): String = "LoadDynamicsFunctionBlockQuery"
}

class FindAllDynamicsFunctionBlockQuery() {
    override fun toString(): String = "LoadAllDynamicsFunctionBlockQuery"
}

data class DynamicsFunctionBlockFetchOneSummary(@Id var dynamicsFunctionBlockId : UUID? = null) {
}





// -----------------------------------------
// DynamicsVersion Queries 
// -----------------------------------------

data class LoadDynamicsVersionFilter(val dynamicsVersionId :  UUID? = null )

class FindDynamicsVersionQuery(val filter: LoadDynamicsVersionFilter = LoadDynamicsVersionFilter()) {
    override fun toString(): String = "LoadDynamicsVersionQuery"
}

class FindAllDynamicsVersionQuery() {
    override fun toString(): String = "LoadAllDynamicsVersionQuery"
}

data class DynamicsVersionFetchOneSummary(@Id var dynamicsVersionId : UUID? = null) {
}





// -----------------------------------------
// Dynamicsmodel Queries 
// -----------------------------------------

data class LoadDynamicsmodelFilter(val dynamicsmodelId :  UUID? = null )

class FindDynamicsmodelQuery(val filter: LoadDynamicsmodelFilter = LoadDynamicsmodelFilter()) {
    override fun toString(): String = "LoadDynamicsmodelQuery"
}

class FindAllDynamicsmodelQuery() {
    override fun toString(): String = "LoadAllDynamicsmodelQuery"
}

data class DynamicsmodelFetchOneSummary(@Id var dynamicsmodelId : UUID? = null) {
}





// -----------------------------------------
// ENTSOEConnectivityNode Queries 
// -----------------------------------------

data class LoadENTSOEConnectivityNodeFilter(val eNTSOEConnectivityNodeId :  UUID? = null )

class FindENTSOEConnectivityNodeQuery(val filter: LoadENTSOEConnectivityNodeFilter = LoadENTSOEConnectivityNodeFilter()) {
    override fun toString(): String = "LoadENTSOEConnectivityNodeQuery"
}

class FindAllENTSOEConnectivityNodeQuery() {
    override fun toString(): String = "LoadAllENTSOEConnectivityNodeQuery"
}

data class ENTSOEConnectivityNodeFetchOneSummary(@Id var eNTSOEConnectivityNodeId : UUID? = null) {
}





// -----------------------------------------
// ENTSOEIdentifiedObject Queries 
// -----------------------------------------

data class LoadENTSOEIdentifiedObjectFilter(val eNTSOEIdentifiedObjectId :  UUID? = null )

class FindENTSOEIdentifiedObjectQuery(val filter: LoadENTSOEIdentifiedObjectFilter = LoadENTSOEIdentifiedObjectFilter()) {
    override fun toString(): String = "LoadENTSOEIdentifiedObjectQuery"
}

class FindAllENTSOEIdentifiedObjectQuery() {
    override fun toString(): String = "LoadAllENTSOEIdentifiedObjectQuery"
}

data class ENTSOEIdentifiedObjectFetchOneSummary(@Id var eNTSOEIdentifiedObjectId : UUID? = null) {
}





// -----------------------------------------
// ENTSOEJunction Queries 
// -----------------------------------------

data class LoadENTSOEJunctionFilter(val eNTSOEJunctionId :  UUID? = null )

class FindENTSOEJunctionQuery(val filter: LoadENTSOEJunctionFilter = LoadENTSOEJunctionFilter()) {
    override fun toString(): String = "LoadENTSOEJunctionQuery"
}

class FindAllENTSOEJunctionQuery() {
    override fun toString(): String = "LoadAllENTSOEJunctionQuery"
}

data class ENTSOEJunctionFetchOneSummary(@Id var eNTSOEJunctionId : UUID? = null) {
}





// -----------------------------------------
// ENTSOEOperationalLimitType Queries 
// -----------------------------------------

data class LoadENTSOEOperationalLimitTypeFilter(val eNTSOEOperationalLimitTypeId :  UUID? = null )

class FindENTSOEOperationalLimitTypeQuery(val filter: LoadENTSOEOperationalLimitTypeFilter = LoadENTSOEOperationalLimitTypeFilter()) {
    override fun toString(): String = "LoadENTSOEOperationalLimitTypeQuery"
}

class FindAllENTSOEOperationalLimitTypeQuery() {
    override fun toString(): String = "LoadAllENTSOEOperationalLimitTypeQuery"
}

data class ENTSOEOperationalLimitTypeFetchOneSummary(@Id var eNTSOEOperationalLimitTypeId : UUID? = null) {
}





// -----------------------------------------
// ENTSOETopologicalNode Queries 
// -----------------------------------------

data class LoadENTSOETopologicalNodeFilter(val eNTSOETopologicalNodeId :  UUID? = null )

class FindENTSOETopologicalNodeQuery(val filter: LoadENTSOETopologicalNodeFilter = LoadENTSOETopologicalNodeFilter()) {
    override fun toString(): String = "LoadENTSOETopologicalNodeQuery"
}

class FindAllENTSOETopologicalNodeQuery() {
    override fun toString(): String = "LoadAllENTSOETopologicalNodeQuery"
}

data class ENTSOETopologicalNodeFetchOneSummary(@Id var eNTSOETopologicalNodeId : UUID? = null) {
}





// -----------------------------------------
// EarthFaultCompensator Queries 
// -----------------------------------------

data class LoadEarthFaultCompensatorFilter(val earthFaultCompensatorId :  UUID? = null )

class FindEarthFaultCompensatorQuery(val filter: LoadEarthFaultCompensatorFilter = LoadEarthFaultCompensatorFilter()) {
    override fun toString(): String = "LoadEarthFaultCompensatorQuery"
}

class FindAllEarthFaultCompensatorQuery() {
    override fun toString(): String = "LoadAllEarthFaultCompensatorQuery"
}

data class EarthFaultCompensatorFetchOneSummary(@Id var earthFaultCompensatorId : UUID? = null) {
}





// -----------------------------------------
// EnergyArea Queries 
// -----------------------------------------

data class LoadEnergyAreaFilter(val energyAreaId :  UUID? = null )

class FindEnergyAreaQuery(val filter: LoadEnergyAreaFilter = LoadEnergyAreaFilter()) {
    override fun toString(): String = "LoadEnergyAreaQuery"
}

class FindAllEnergyAreaQuery() {
    override fun toString(): String = "LoadAllEnergyAreaQuery"
}

data class EnergyAreaFetchOneSummary(@Id var energyAreaId : UUID? = null) {
}





// -----------------------------------------
// EnergyConsumer Queries 
// -----------------------------------------

data class LoadEnergyConsumerFilter(val energyConsumerId :  UUID? = null )

class FindEnergyConsumerQuery(val filter: LoadEnergyConsumerFilter = LoadEnergyConsumerFilter()) {
    override fun toString(): String = "LoadEnergyConsumerQuery"
}

class FindAllEnergyConsumerQuery() {
    override fun toString(): String = "LoadAllEnergyConsumerQuery"
}

data class EnergyConsumerFetchOneSummary(@Id var energyConsumerId : UUID? = null) {
}





// -----------------------------------------
// EnergySchedulingType Queries 
// -----------------------------------------

data class LoadEnergySchedulingTypeFilter(val energySchedulingTypeId :  UUID? = null )

class FindEnergySchedulingTypeQuery(val filter: LoadEnergySchedulingTypeFilter = LoadEnergySchedulingTypeFilter()) {
    override fun toString(): String = "LoadEnergySchedulingTypeQuery"
}

class FindAllEnergySchedulingTypeQuery() {
    override fun toString(): String = "LoadAllEnergySchedulingTypeQuery"
}

data class EnergySchedulingTypeFetchOneSummary(@Id var energySchedulingTypeId : UUID? = null) {
}





// -----------------------------------------
// EnergySource Queries 
// -----------------------------------------

data class LoadEnergySourceFilter(val energySourceId :  UUID? = null )

class FindEnergySourceQuery(val filter: LoadEnergySourceFilter = LoadEnergySourceFilter()) {
    override fun toString(): String = "LoadEnergySourceQuery"
}

class FindAllEnergySourceQuery() {
    override fun toString(): String = "LoadAllEnergySourceQuery"
}

data class EnergySourceFetchOneSummary(@Id var energySourceId : UUID? = null) {
}





// -----------------------------------------
// Equipment Queries 
// -----------------------------------------

data class LoadEquipmentFilter(val equipmentId :  UUID? = null )

class FindEquipmentQuery(val filter: LoadEquipmentFilter = LoadEquipmentFilter()) {
    override fun toString(): String = "LoadEquipmentQuery"
}

class FindAllEquipmentQuery() {
    override fun toString(): String = "LoadAllEquipmentQuery"
}

data class EquipmentFetchOneSummary(@Id var equipmentId : UUID? = null) {
}





// -----------------------------------------
// EquipmentBoundaryVersion Queries 
// -----------------------------------------

data class LoadEquipmentBoundaryVersionFilter(val equipmentBoundaryVersionId :  UUID? = null )

class FindEquipmentBoundaryVersionQuery(val filter: LoadEquipmentBoundaryVersionFilter = LoadEquipmentBoundaryVersionFilter()) {
    override fun toString(): String = "LoadEquipmentBoundaryVersionQuery"
}

class FindAllEquipmentBoundaryVersionQuery() {
    override fun toString(): String = "LoadAllEquipmentBoundaryVersionQuery"
}

data class EquipmentBoundaryVersionFetchOneSummary(@Id var equipmentBoundaryVersionId : UUID? = null) {
}





// -----------------------------------------
// EquipmentContainer Queries 
// -----------------------------------------

data class LoadEquipmentContainerFilter(val equipmentContainerId :  UUID? = null )

class FindEquipmentContainerQuery(val filter: LoadEquipmentContainerFilter = LoadEquipmentContainerFilter()) {
    override fun toString(): String = "LoadEquipmentContainerQuery"
}

class FindAllEquipmentContainerQuery() {
    override fun toString(): String = "LoadAllEquipmentContainerQuery"
}

data class EquipmentContainerFetchOneSummary(@Id var equipmentContainerId : UUID? = null) {
}





// -----------------------------------------
// EquipmentVersion Queries 
// -----------------------------------------

data class LoadEquipmentVersionFilter(val equipmentVersionId :  UUID? = null )

class FindEquipmentVersionQuery(val filter: LoadEquipmentVersionFilter = LoadEquipmentVersionFilter()) {
    override fun toString(): String = "LoadEquipmentVersionQuery"
}

class FindAllEquipmentVersionQuery() {
    override fun toString(): String = "LoadAllEquipmentVersionQuery"
}

data class EquipmentVersionFetchOneSummary(@Id var equipmentVersionId : UUID? = null) {
}





// -----------------------------------------
// EquivalentBranch Queries 
// -----------------------------------------

data class LoadEquivalentBranchFilter(val equivalentBranchId :  UUID? = null )

class FindEquivalentBranchQuery(val filter: LoadEquivalentBranchFilter = LoadEquivalentBranchFilter()) {
    override fun toString(): String = "LoadEquivalentBranchQuery"
}

class FindAllEquivalentBranchQuery() {
    override fun toString(): String = "LoadAllEquivalentBranchQuery"
}

data class EquivalentBranchFetchOneSummary(@Id var equivalentBranchId : UUID? = null) {
}





// -----------------------------------------
// EquivalentEquipment Queries 
// -----------------------------------------

data class LoadEquivalentEquipmentFilter(val equivalentEquipmentId :  UUID? = null )

class FindEquivalentEquipmentQuery(val filter: LoadEquivalentEquipmentFilter = LoadEquivalentEquipmentFilter()) {
    override fun toString(): String = "LoadEquivalentEquipmentQuery"
}

class FindAllEquivalentEquipmentQuery() {
    override fun toString(): String = "LoadAllEquivalentEquipmentQuery"
}

data class EquivalentEquipmentFetchOneSummary(@Id var equivalentEquipmentId : UUID? = null) {
}





// -----------------------------------------
// EquivalentInjection Queries 
// -----------------------------------------

data class LoadEquivalentInjectionFilter(val equivalentInjectionId :  UUID? = null )

class FindEquivalentInjectionQuery(val filter: LoadEquivalentInjectionFilter = LoadEquivalentInjectionFilter()) {
    override fun toString(): String = "LoadEquivalentInjectionQuery"
}

class FindAllEquivalentInjectionQuery() {
    override fun toString(): String = "LoadAllEquivalentInjectionQuery"
}

data class EquivalentInjectionFetchOneSummary(@Id var equivalentInjectionId : UUID? = null) {
}





// -----------------------------------------
// EquivalentNetwork Queries 
// -----------------------------------------

data class LoadEquivalentNetworkFilter(val equivalentNetworkId :  UUID? = null )

class FindEquivalentNetworkQuery(val filter: LoadEquivalentNetworkFilter = LoadEquivalentNetworkFilter()) {
    override fun toString(): String = "LoadEquivalentNetworkQuery"
}

class FindAllEquivalentNetworkQuery() {
    override fun toString(): String = "LoadAllEquivalentNetworkQuery"
}

data class EquivalentNetworkFetchOneSummary(@Id var equivalentNetworkId : UUID? = null) {
}





// -----------------------------------------
// EquivalentShunt Queries 
// -----------------------------------------

data class LoadEquivalentShuntFilter(val equivalentShuntId :  UUID? = null )

class FindEquivalentShuntQuery(val filter: LoadEquivalentShuntFilter = LoadEquivalentShuntFilter()) {
    override fun toString(): String = "LoadEquivalentShuntQuery"
}

class FindAllEquivalentShuntQuery() {
    override fun toString(): String = "LoadAllEquivalentShuntQuery"
}

data class EquivalentShuntFetchOneSummary(@Id var equivalentShuntId : UUID? = null) {
}





// -----------------------------------------
// ExcAC1A Queries 
// -----------------------------------------

data class LoadExcAC1AFilter(val excAC1AId :  UUID? = null )

class FindExcAC1AQuery(val filter: LoadExcAC1AFilter = LoadExcAC1AFilter()) {
    override fun toString(): String = "LoadExcAC1AQuery"
}

class FindAllExcAC1AQuery() {
    override fun toString(): String = "LoadAllExcAC1AQuery"
}

data class ExcAC1AFetchOneSummary(@Id var excAC1AId : UUID? = null) {
}





// -----------------------------------------
// ExcAC2A Queries 
// -----------------------------------------

data class LoadExcAC2AFilter(val excAC2AId :  UUID? = null )

class FindExcAC2AQuery(val filter: LoadExcAC2AFilter = LoadExcAC2AFilter()) {
    override fun toString(): String = "LoadExcAC2AQuery"
}

class FindAllExcAC2AQuery() {
    override fun toString(): String = "LoadAllExcAC2AQuery"
}

data class ExcAC2AFetchOneSummary(@Id var excAC2AId : UUID? = null) {
}





// -----------------------------------------
// ExcAC3A Queries 
// -----------------------------------------

data class LoadExcAC3AFilter(val excAC3AId :  UUID? = null )

class FindExcAC3AQuery(val filter: LoadExcAC3AFilter = LoadExcAC3AFilter()) {
    override fun toString(): String = "LoadExcAC3AQuery"
}

class FindAllExcAC3AQuery() {
    override fun toString(): String = "LoadAllExcAC3AQuery"
}

data class ExcAC3AFetchOneSummary(@Id var excAC3AId : UUID? = null) {
}





// -----------------------------------------
// ExcAC4A Queries 
// -----------------------------------------

data class LoadExcAC4AFilter(val excAC4AId :  UUID? = null )

class FindExcAC4AQuery(val filter: LoadExcAC4AFilter = LoadExcAC4AFilter()) {
    override fun toString(): String = "LoadExcAC4AQuery"
}

class FindAllExcAC4AQuery() {
    override fun toString(): String = "LoadAllExcAC4AQuery"
}

data class ExcAC4AFetchOneSummary(@Id var excAC4AId : UUID? = null) {
}





// -----------------------------------------
// ExcAC5A Queries 
// -----------------------------------------

data class LoadExcAC5AFilter(val excAC5AId :  UUID? = null )

class FindExcAC5AQuery(val filter: LoadExcAC5AFilter = LoadExcAC5AFilter()) {
    override fun toString(): String = "LoadExcAC5AQuery"
}

class FindAllExcAC5AQuery() {
    override fun toString(): String = "LoadAllExcAC5AQuery"
}

data class ExcAC5AFetchOneSummary(@Id var excAC5AId : UUID? = null) {
}





// -----------------------------------------
// ExcAC6A Queries 
// -----------------------------------------

data class LoadExcAC6AFilter(val excAC6AId :  UUID? = null )

class FindExcAC6AQuery(val filter: LoadExcAC6AFilter = LoadExcAC6AFilter()) {
    override fun toString(): String = "LoadExcAC6AQuery"
}

class FindAllExcAC6AQuery() {
    override fun toString(): String = "LoadAllExcAC6AQuery"
}

data class ExcAC6AFetchOneSummary(@Id var excAC6AId : UUID? = null) {
}





// -----------------------------------------
// ExcAC8B Queries 
// -----------------------------------------

data class LoadExcAC8BFilter(val excAC8BId :  UUID? = null )

class FindExcAC8BQuery(val filter: LoadExcAC8BFilter = LoadExcAC8BFilter()) {
    override fun toString(): String = "LoadExcAC8BQuery"
}

class FindAllExcAC8BQuery() {
    override fun toString(): String = "LoadAllExcAC8BQuery"
}

data class ExcAC8BFetchOneSummary(@Id var excAC8BId : UUID? = null) {
}





// -----------------------------------------
// ExcANS Queries 
// -----------------------------------------

data class LoadExcANSFilter(val excANSId :  UUID? = null )

class FindExcANSQuery(val filter: LoadExcANSFilter = LoadExcANSFilter()) {
    override fun toString(): String = "LoadExcANSQuery"
}

class FindAllExcANSQuery() {
    override fun toString(): String = "LoadAllExcANSQuery"
}

data class ExcANSFetchOneSummary(@Id var excANSId : UUID? = null) {
}





// -----------------------------------------
// ExcAVR1 Queries 
// -----------------------------------------

data class LoadExcAVR1Filter(val excAVR1Id :  UUID? = null )

class FindExcAVR1Query(val filter: LoadExcAVR1Filter = LoadExcAVR1Filter()) {
    override fun toString(): String = "LoadExcAVR1Query"
}

class FindAllExcAVR1Query() {
    override fun toString(): String = "LoadAllExcAVR1Query"
}

data class ExcAVR1FetchOneSummary(@Id var excAVR1Id : UUID? = null) {
}





// -----------------------------------------
// ExcAVR2 Queries 
// -----------------------------------------

data class LoadExcAVR2Filter(val excAVR2Id :  UUID? = null )

class FindExcAVR2Query(val filter: LoadExcAVR2Filter = LoadExcAVR2Filter()) {
    override fun toString(): String = "LoadExcAVR2Query"
}

class FindAllExcAVR2Query() {
    override fun toString(): String = "LoadAllExcAVR2Query"
}

data class ExcAVR2FetchOneSummary(@Id var excAVR2Id : UUID? = null) {
}





// -----------------------------------------
// ExcAVR3 Queries 
// -----------------------------------------

data class LoadExcAVR3Filter(val excAVR3Id :  UUID? = null )

class FindExcAVR3Query(val filter: LoadExcAVR3Filter = LoadExcAVR3Filter()) {
    override fun toString(): String = "LoadExcAVR3Query"
}

class FindAllExcAVR3Query() {
    override fun toString(): String = "LoadAllExcAVR3Query"
}

data class ExcAVR3FetchOneSummary(@Id var excAVR3Id : UUID? = null) {
}





// -----------------------------------------
// ExcAVR4 Queries 
// -----------------------------------------

data class LoadExcAVR4Filter(val excAVR4Id :  UUID? = null )

class FindExcAVR4Query(val filter: LoadExcAVR4Filter = LoadExcAVR4Filter()) {
    override fun toString(): String = "LoadExcAVR4Query"
}

class FindAllExcAVR4Query() {
    override fun toString(): String = "LoadAllExcAVR4Query"
}

data class ExcAVR4FetchOneSummary(@Id var excAVR4Id : UUID? = null) {
}





// -----------------------------------------
// ExcAVR5 Queries 
// -----------------------------------------

data class LoadExcAVR5Filter(val excAVR5Id :  UUID? = null )

class FindExcAVR5Query(val filter: LoadExcAVR5Filter = LoadExcAVR5Filter()) {
    override fun toString(): String = "LoadExcAVR5Query"
}

class FindAllExcAVR5Query() {
    override fun toString(): String = "LoadAllExcAVR5Query"
}

data class ExcAVR5FetchOneSummary(@Id var excAVR5Id : UUID? = null) {
}





// -----------------------------------------
// ExcAVR7 Queries 
// -----------------------------------------

data class LoadExcAVR7Filter(val excAVR7Id :  UUID? = null )

class FindExcAVR7Query(val filter: LoadExcAVR7Filter = LoadExcAVR7Filter()) {
    override fun toString(): String = "LoadExcAVR7Query"
}

class FindAllExcAVR7Query() {
    override fun toString(): String = "LoadAllExcAVR7Query"
}

data class ExcAVR7FetchOneSummary(@Id var excAVR7Id : UUID? = null) {
}





// -----------------------------------------
// ExcBBC Queries 
// -----------------------------------------

data class LoadExcBBCFilter(val excBBCId :  UUID? = null )

class FindExcBBCQuery(val filter: LoadExcBBCFilter = LoadExcBBCFilter()) {
    override fun toString(): String = "LoadExcBBCQuery"
}

class FindAllExcBBCQuery() {
    override fun toString(): String = "LoadAllExcBBCQuery"
}

data class ExcBBCFetchOneSummary(@Id var excBBCId : UUID? = null) {
}





// -----------------------------------------
// ExcCZ Queries 
// -----------------------------------------

data class LoadExcCZFilter(val excCZId :  UUID? = null )

class FindExcCZQuery(val filter: LoadExcCZFilter = LoadExcCZFilter()) {
    override fun toString(): String = "LoadExcCZQuery"
}

class FindAllExcCZQuery() {
    override fun toString(): String = "LoadAllExcCZQuery"
}

data class ExcCZFetchOneSummary(@Id var excCZId : UUID? = null) {
}





// -----------------------------------------
// ExcDC1A Queries 
// -----------------------------------------

data class LoadExcDC1AFilter(val excDC1AId :  UUID? = null )

class FindExcDC1AQuery(val filter: LoadExcDC1AFilter = LoadExcDC1AFilter()) {
    override fun toString(): String = "LoadExcDC1AQuery"
}

class FindAllExcDC1AQuery() {
    override fun toString(): String = "LoadAllExcDC1AQuery"
}

data class ExcDC1AFetchOneSummary(@Id var excDC1AId : UUID? = null) {
}





// -----------------------------------------
// ExcDC2A Queries 
// -----------------------------------------

data class LoadExcDC2AFilter(val excDC2AId :  UUID? = null )

class FindExcDC2AQuery(val filter: LoadExcDC2AFilter = LoadExcDC2AFilter()) {
    override fun toString(): String = "LoadExcDC2AQuery"
}

class FindAllExcDC2AQuery() {
    override fun toString(): String = "LoadAllExcDC2AQuery"
}

data class ExcDC2AFetchOneSummary(@Id var excDC2AId : UUID? = null) {
}





// -----------------------------------------
// ExcDC3A Queries 
// -----------------------------------------

data class LoadExcDC3AFilter(val excDC3AId :  UUID? = null )

class FindExcDC3AQuery(val filter: LoadExcDC3AFilter = LoadExcDC3AFilter()) {
    override fun toString(): String = "LoadExcDC3AQuery"
}

class FindAllExcDC3AQuery() {
    override fun toString(): String = "LoadAllExcDC3AQuery"
}

data class ExcDC3AFetchOneSummary(@Id var excDC3AId : UUID? = null) {
}





// -----------------------------------------
// ExcDC3A1 Queries 
// -----------------------------------------

data class LoadExcDC3A1Filter(val excDC3A1Id :  UUID? = null )

class FindExcDC3A1Query(val filter: LoadExcDC3A1Filter = LoadExcDC3A1Filter()) {
    override fun toString(): String = "LoadExcDC3A1Query"
}

class FindAllExcDC3A1Query() {
    override fun toString(): String = "LoadAllExcDC3A1Query"
}

data class ExcDC3A1FetchOneSummary(@Id var excDC3A1Id : UUID? = null) {
}





// -----------------------------------------
// ExcELIN1 Queries 
// -----------------------------------------

data class LoadExcELIN1Filter(val excELIN1Id :  UUID? = null )

class FindExcELIN1Query(val filter: LoadExcELIN1Filter = LoadExcELIN1Filter()) {
    override fun toString(): String = "LoadExcELIN1Query"
}

class FindAllExcELIN1Query() {
    override fun toString(): String = "LoadAllExcELIN1Query"
}

data class ExcELIN1FetchOneSummary(@Id var excELIN1Id : UUID? = null) {
}





// -----------------------------------------
// ExcELIN2 Queries 
// -----------------------------------------

data class LoadExcELIN2Filter(val excELIN2Id :  UUID? = null )

class FindExcELIN2Query(val filter: LoadExcELIN2Filter = LoadExcELIN2Filter()) {
    override fun toString(): String = "LoadExcELIN2Query"
}

class FindAllExcELIN2Query() {
    override fun toString(): String = "LoadAllExcELIN2Query"
}

data class ExcELIN2FetchOneSummary(@Id var excELIN2Id : UUID? = null) {
}





// -----------------------------------------
// ExcHU Queries 
// -----------------------------------------

data class LoadExcHUFilter(val excHUId :  UUID? = null )

class FindExcHUQuery(val filter: LoadExcHUFilter = LoadExcHUFilter()) {
    override fun toString(): String = "LoadExcHUQuery"
}

class FindAllExcHUQuery() {
    override fun toString(): String = "LoadAllExcHUQuery"
}

data class ExcHUFetchOneSummary(@Id var excHUId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEAC1A Queries 
// -----------------------------------------

data class LoadExcIEEEAC1AFilter(val excIEEEAC1AId :  UUID? = null )

class FindExcIEEEAC1AQuery(val filter: LoadExcIEEEAC1AFilter = LoadExcIEEEAC1AFilter()) {
    override fun toString(): String = "LoadExcIEEEAC1AQuery"
}

class FindAllExcIEEEAC1AQuery() {
    override fun toString(): String = "LoadAllExcIEEEAC1AQuery"
}

data class ExcIEEEAC1AFetchOneSummary(@Id var excIEEEAC1AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEAC2A Queries 
// -----------------------------------------

data class LoadExcIEEEAC2AFilter(val excIEEEAC2AId :  UUID? = null )

class FindExcIEEEAC2AQuery(val filter: LoadExcIEEEAC2AFilter = LoadExcIEEEAC2AFilter()) {
    override fun toString(): String = "LoadExcIEEEAC2AQuery"
}

class FindAllExcIEEEAC2AQuery() {
    override fun toString(): String = "LoadAllExcIEEEAC2AQuery"
}

data class ExcIEEEAC2AFetchOneSummary(@Id var excIEEEAC2AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEAC3A Queries 
// -----------------------------------------

data class LoadExcIEEEAC3AFilter(val excIEEEAC3AId :  UUID? = null )

class FindExcIEEEAC3AQuery(val filter: LoadExcIEEEAC3AFilter = LoadExcIEEEAC3AFilter()) {
    override fun toString(): String = "LoadExcIEEEAC3AQuery"
}

class FindAllExcIEEEAC3AQuery() {
    override fun toString(): String = "LoadAllExcIEEEAC3AQuery"
}

data class ExcIEEEAC3AFetchOneSummary(@Id var excIEEEAC3AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEAC4A Queries 
// -----------------------------------------

data class LoadExcIEEEAC4AFilter(val excIEEEAC4AId :  UUID? = null )

class FindExcIEEEAC4AQuery(val filter: LoadExcIEEEAC4AFilter = LoadExcIEEEAC4AFilter()) {
    override fun toString(): String = "LoadExcIEEEAC4AQuery"
}

class FindAllExcIEEEAC4AQuery() {
    override fun toString(): String = "LoadAllExcIEEEAC4AQuery"
}

data class ExcIEEEAC4AFetchOneSummary(@Id var excIEEEAC4AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEAC5A Queries 
// -----------------------------------------

data class LoadExcIEEEAC5AFilter(val excIEEEAC5AId :  UUID? = null )

class FindExcIEEEAC5AQuery(val filter: LoadExcIEEEAC5AFilter = LoadExcIEEEAC5AFilter()) {
    override fun toString(): String = "LoadExcIEEEAC5AQuery"
}

class FindAllExcIEEEAC5AQuery() {
    override fun toString(): String = "LoadAllExcIEEEAC5AQuery"
}

data class ExcIEEEAC5AFetchOneSummary(@Id var excIEEEAC5AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEAC6A Queries 
// -----------------------------------------

data class LoadExcIEEEAC6AFilter(val excIEEEAC6AId :  UUID? = null )

class FindExcIEEEAC6AQuery(val filter: LoadExcIEEEAC6AFilter = LoadExcIEEEAC6AFilter()) {
    override fun toString(): String = "LoadExcIEEEAC6AQuery"
}

class FindAllExcIEEEAC6AQuery() {
    override fun toString(): String = "LoadAllExcIEEEAC6AQuery"
}

data class ExcIEEEAC6AFetchOneSummary(@Id var excIEEEAC6AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEAC7B Queries 
// -----------------------------------------

data class LoadExcIEEEAC7BFilter(val excIEEEAC7BId :  UUID? = null )

class FindExcIEEEAC7BQuery(val filter: LoadExcIEEEAC7BFilter = LoadExcIEEEAC7BFilter()) {
    override fun toString(): String = "LoadExcIEEEAC7BQuery"
}

class FindAllExcIEEEAC7BQuery() {
    override fun toString(): String = "LoadAllExcIEEEAC7BQuery"
}

data class ExcIEEEAC7BFetchOneSummary(@Id var excIEEEAC7BId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEAC8B Queries 
// -----------------------------------------

data class LoadExcIEEEAC8BFilter(val excIEEEAC8BId :  UUID? = null )

class FindExcIEEEAC8BQuery(val filter: LoadExcIEEEAC8BFilter = LoadExcIEEEAC8BFilter()) {
    override fun toString(): String = "LoadExcIEEEAC8BQuery"
}

class FindAllExcIEEEAC8BQuery() {
    override fun toString(): String = "LoadAllExcIEEEAC8BQuery"
}

data class ExcIEEEAC8BFetchOneSummary(@Id var excIEEEAC8BId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEDC1A Queries 
// -----------------------------------------

data class LoadExcIEEEDC1AFilter(val excIEEEDC1AId :  UUID? = null )

class FindExcIEEEDC1AQuery(val filter: LoadExcIEEEDC1AFilter = LoadExcIEEEDC1AFilter()) {
    override fun toString(): String = "LoadExcIEEEDC1AQuery"
}

class FindAllExcIEEEDC1AQuery() {
    override fun toString(): String = "LoadAllExcIEEEDC1AQuery"
}

data class ExcIEEEDC1AFetchOneSummary(@Id var excIEEEDC1AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEDC2A Queries 
// -----------------------------------------

data class LoadExcIEEEDC2AFilter(val excIEEEDC2AId :  UUID? = null )

class FindExcIEEEDC2AQuery(val filter: LoadExcIEEEDC2AFilter = LoadExcIEEEDC2AFilter()) {
    override fun toString(): String = "LoadExcIEEEDC2AQuery"
}

class FindAllExcIEEEDC2AQuery() {
    override fun toString(): String = "LoadAllExcIEEEDC2AQuery"
}

data class ExcIEEEDC2AFetchOneSummary(@Id var excIEEEDC2AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEDC3A Queries 
// -----------------------------------------

data class LoadExcIEEEDC3AFilter(val excIEEEDC3AId :  UUID? = null )

class FindExcIEEEDC3AQuery(val filter: LoadExcIEEEDC3AFilter = LoadExcIEEEDC3AFilter()) {
    override fun toString(): String = "LoadExcIEEEDC3AQuery"
}

class FindAllExcIEEEDC3AQuery() {
    override fun toString(): String = "LoadAllExcIEEEDC3AQuery"
}

data class ExcIEEEDC3AFetchOneSummary(@Id var excIEEEDC3AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEDC4B Queries 
// -----------------------------------------

data class LoadExcIEEEDC4BFilter(val excIEEEDC4BId :  UUID? = null )

class FindExcIEEEDC4BQuery(val filter: LoadExcIEEEDC4BFilter = LoadExcIEEEDC4BFilter()) {
    override fun toString(): String = "LoadExcIEEEDC4BQuery"
}

class FindAllExcIEEEDC4BQuery() {
    override fun toString(): String = "LoadAllExcIEEEDC4BQuery"
}

data class ExcIEEEDC4BFetchOneSummary(@Id var excIEEEDC4BId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEST1A Queries 
// -----------------------------------------

data class LoadExcIEEEST1AFilter(val excIEEEST1AId :  UUID? = null )

class FindExcIEEEST1AQuery(val filter: LoadExcIEEEST1AFilter = LoadExcIEEEST1AFilter()) {
    override fun toString(): String = "LoadExcIEEEST1AQuery"
}

class FindAllExcIEEEST1AQuery() {
    override fun toString(): String = "LoadAllExcIEEEST1AQuery"
}

data class ExcIEEEST1AFetchOneSummary(@Id var excIEEEST1AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEST2A Queries 
// -----------------------------------------

data class LoadExcIEEEST2AFilter(val excIEEEST2AId :  UUID? = null )

class FindExcIEEEST2AQuery(val filter: LoadExcIEEEST2AFilter = LoadExcIEEEST2AFilter()) {
    override fun toString(): String = "LoadExcIEEEST2AQuery"
}

class FindAllExcIEEEST2AQuery() {
    override fun toString(): String = "LoadAllExcIEEEST2AQuery"
}

data class ExcIEEEST2AFetchOneSummary(@Id var excIEEEST2AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEST3A Queries 
// -----------------------------------------

data class LoadExcIEEEST3AFilter(val excIEEEST3AId :  UUID? = null )

class FindExcIEEEST3AQuery(val filter: LoadExcIEEEST3AFilter = LoadExcIEEEST3AFilter()) {
    override fun toString(): String = "LoadExcIEEEST3AQuery"
}

class FindAllExcIEEEST3AQuery() {
    override fun toString(): String = "LoadAllExcIEEEST3AQuery"
}

data class ExcIEEEST3AFetchOneSummary(@Id var excIEEEST3AId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEST4B Queries 
// -----------------------------------------

data class LoadExcIEEEST4BFilter(val excIEEEST4BId :  UUID? = null )

class FindExcIEEEST4BQuery(val filter: LoadExcIEEEST4BFilter = LoadExcIEEEST4BFilter()) {
    override fun toString(): String = "LoadExcIEEEST4BQuery"
}

class FindAllExcIEEEST4BQuery() {
    override fun toString(): String = "LoadAllExcIEEEST4BQuery"
}

data class ExcIEEEST4BFetchOneSummary(@Id var excIEEEST4BId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEST5B Queries 
// -----------------------------------------

data class LoadExcIEEEST5BFilter(val excIEEEST5BId :  UUID? = null )

class FindExcIEEEST5BQuery(val filter: LoadExcIEEEST5BFilter = LoadExcIEEEST5BFilter()) {
    override fun toString(): String = "LoadExcIEEEST5BQuery"
}

class FindAllExcIEEEST5BQuery() {
    override fun toString(): String = "LoadAllExcIEEEST5BQuery"
}

data class ExcIEEEST5BFetchOneSummary(@Id var excIEEEST5BId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEST6B Queries 
// -----------------------------------------

data class LoadExcIEEEST6BFilter(val excIEEEST6BId :  UUID? = null )

class FindExcIEEEST6BQuery(val filter: LoadExcIEEEST6BFilter = LoadExcIEEEST6BFilter()) {
    override fun toString(): String = "LoadExcIEEEST6BQuery"
}

class FindAllExcIEEEST6BQuery() {
    override fun toString(): String = "LoadAllExcIEEEST6BQuery"
}

data class ExcIEEEST6BFetchOneSummary(@Id var excIEEEST6BId : UUID? = null) {
}





// -----------------------------------------
// ExcIEEEST7B Queries 
// -----------------------------------------

data class LoadExcIEEEST7BFilter(val excIEEEST7BId :  UUID? = null )

class FindExcIEEEST7BQuery(val filter: LoadExcIEEEST7BFilter = LoadExcIEEEST7BFilter()) {
    override fun toString(): String = "LoadExcIEEEST7BQuery"
}

class FindAllExcIEEEST7BQuery() {
    override fun toString(): String = "LoadAllExcIEEEST7BQuery"
}

data class ExcIEEEST7BFetchOneSummary(@Id var excIEEEST7BId : UUID? = null) {
}





// -----------------------------------------
// ExcOEX3T Queries 
// -----------------------------------------

data class LoadExcOEX3TFilter(val excOEX3TId :  UUID? = null )

class FindExcOEX3TQuery(val filter: LoadExcOEX3TFilter = LoadExcOEX3TFilter()) {
    override fun toString(): String = "LoadExcOEX3TQuery"
}

class FindAllExcOEX3TQuery() {
    override fun toString(): String = "LoadAllExcOEX3TQuery"
}

data class ExcOEX3TFetchOneSummary(@Id var excOEX3TId : UUID? = null) {
}





// -----------------------------------------
// ExcPIC Queries 
// -----------------------------------------

data class LoadExcPICFilter(val excPICId :  UUID? = null )

class FindExcPICQuery(val filter: LoadExcPICFilter = LoadExcPICFilter()) {
    override fun toString(): String = "LoadExcPICQuery"
}

class FindAllExcPICQuery() {
    override fun toString(): String = "LoadAllExcPICQuery"
}

data class ExcPICFetchOneSummary(@Id var excPICId : UUID? = null) {
}





// -----------------------------------------
// ExcREXS Queries 
// -----------------------------------------

data class LoadExcREXSFilter(val excREXSId :  UUID? = null )

class FindExcREXSQuery(val filter: LoadExcREXSFilter = LoadExcREXSFilter()) {
    override fun toString(): String = "LoadExcREXSQuery"
}

class FindAllExcREXSQuery() {
    override fun toString(): String = "LoadAllExcREXSQuery"
}

data class ExcREXSFetchOneSummary(@Id var excREXSId : UUID? = null) {
}





// -----------------------------------------
// ExcSCRX Queries 
// -----------------------------------------

data class LoadExcSCRXFilter(val excSCRXId :  UUID? = null )

class FindExcSCRXQuery(val filter: LoadExcSCRXFilter = LoadExcSCRXFilter()) {
    override fun toString(): String = "LoadExcSCRXQuery"
}

class FindAllExcSCRXQuery() {
    override fun toString(): String = "LoadAllExcSCRXQuery"
}

data class ExcSCRXFetchOneSummary(@Id var excSCRXId : UUID? = null) {
}





// -----------------------------------------
// ExcSEXS Queries 
// -----------------------------------------

data class LoadExcSEXSFilter(val excSEXSId :  UUID? = null )

class FindExcSEXSQuery(val filter: LoadExcSEXSFilter = LoadExcSEXSFilter()) {
    override fun toString(): String = "LoadExcSEXSQuery"
}

class FindAllExcSEXSQuery() {
    override fun toString(): String = "LoadAllExcSEXSQuery"
}

data class ExcSEXSFetchOneSummary(@Id var excSEXSId : UUID? = null) {
}





// -----------------------------------------
// ExcSK Queries 
// -----------------------------------------

data class LoadExcSKFilter(val excSKId :  UUID? = null )

class FindExcSKQuery(val filter: LoadExcSKFilter = LoadExcSKFilter()) {
    override fun toString(): String = "LoadExcSKQuery"
}

class FindAllExcSKQuery() {
    override fun toString(): String = "LoadAllExcSKQuery"
}

data class ExcSKFetchOneSummary(@Id var excSKId : UUID? = null) {
}





// -----------------------------------------
// ExcST1A Queries 
// -----------------------------------------

data class LoadExcST1AFilter(val excST1AId :  UUID? = null )

class FindExcST1AQuery(val filter: LoadExcST1AFilter = LoadExcST1AFilter()) {
    override fun toString(): String = "LoadExcST1AQuery"
}

class FindAllExcST1AQuery() {
    override fun toString(): String = "LoadAllExcST1AQuery"
}

data class ExcST1AFetchOneSummary(@Id var excST1AId : UUID? = null) {
}





// -----------------------------------------
// ExcST2A Queries 
// -----------------------------------------

data class LoadExcST2AFilter(val excST2AId :  UUID? = null )

class FindExcST2AQuery(val filter: LoadExcST2AFilter = LoadExcST2AFilter()) {
    override fun toString(): String = "LoadExcST2AQuery"
}

class FindAllExcST2AQuery() {
    override fun toString(): String = "LoadAllExcST2AQuery"
}

data class ExcST2AFetchOneSummary(@Id var excST2AId : UUID? = null) {
}





// -----------------------------------------
// ExcST3A Queries 
// -----------------------------------------

data class LoadExcST3AFilter(val excST3AId :  UUID? = null )

class FindExcST3AQuery(val filter: LoadExcST3AFilter = LoadExcST3AFilter()) {
    override fun toString(): String = "LoadExcST3AQuery"
}

class FindAllExcST3AQuery() {
    override fun toString(): String = "LoadAllExcST3AQuery"
}

data class ExcST3AFetchOneSummary(@Id var excST3AId : UUID? = null) {
}





// -----------------------------------------
// ExcST4B Queries 
// -----------------------------------------

data class LoadExcST4BFilter(val excST4BId :  UUID? = null )

class FindExcST4BQuery(val filter: LoadExcST4BFilter = LoadExcST4BFilter()) {
    override fun toString(): String = "LoadExcST4BQuery"
}

class FindAllExcST4BQuery() {
    override fun toString(): String = "LoadAllExcST4BQuery"
}

data class ExcST4BFetchOneSummary(@Id var excST4BId : UUID? = null) {
}





// -----------------------------------------
// ExcST6B Queries 
// -----------------------------------------

data class LoadExcST6BFilter(val excST6BId :  UUID? = null )

class FindExcST6BQuery(val filter: LoadExcST6BFilter = LoadExcST6BFilter()) {
    override fun toString(): String = "LoadExcST6BQuery"
}

class FindAllExcST6BQuery() {
    override fun toString(): String = "LoadAllExcST6BQuery"
}

data class ExcST6BFetchOneSummary(@Id var excST6BId : UUID? = null) {
}





// -----------------------------------------
// ExcST7B Queries 
// -----------------------------------------

data class LoadExcST7BFilter(val excST7BId :  UUID? = null )

class FindExcST7BQuery(val filter: LoadExcST7BFilter = LoadExcST7BFilter()) {
    override fun toString(): String = "LoadExcST7BQuery"
}

class FindAllExcST7BQuery() {
    override fun toString(): String = "LoadAllExcST7BQuery"
}

data class ExcST7BFetchOneSummary(@Id var excST7BId : UUID? = null) {
}





// -----------------------------------------
// ExcitationSystemDynamics Queries 
// -----------------------------------------

data class LoadExcitationSystemDynamicsFilter(val excitationSystemDynamicsId :  UUID? = null )

class FindExcitationSystemDynamicsQuery(val filter: LoadExcitationSystemDynamicsFilter = LoadExcitationSystemDynamicsFilter()) {
    override fun toString(): String = "LoadExcitationSystemDynamicsQuery"
}

class FindAllExcitationSystemDynamicsQuery() {
    override fun toString(): String = "LoadAllExcitationSystemDynamicsQuery"
}

data class ExcitationSystemDynamicsFetchOneSummary(@Id var excitationSystemDynamicsId : UUID? = null) {
}





// -----------------------------------------
// ExcitationSystemUserDefined Queries 
// -----------------------------------------

data class LoadExcitationSystemUserDefinedFilter(val excitationSystemUserDefinedId :  UUID? = null )

class FindExcitationSystemUserDefinedQuery(val filter: LoadExcitationSystemUserDefinedFilter = LoadExcitationSystemUserDefinedFilter()) {
    override fun toString(): String = "LoadExcitationSystemUserDefinedQuery"
}

class FindAllExcitationSystemUserDefinedQuery() {
    override fun toString(): String = "LoadAllExcitationSystemUserDefinedQuery"
}

data class ExcitationSystemUserDefinedFetchOneSummary(@Id var excitationSystemUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// ExtensionVersion Queries 
// -----------------------------------------

data class LoadExtensionVersionFilter(val extensionVersionId :  UUID? = null )

class FindExtensionVersionQuery(val filter: LoadExtensionVersionFilter = LoadExtensionVersionFilter()) {
    override fun toString(): String = "LoadExtensionVersionQuery"
}

class FindAllExtensionVersionQuery() {
    override fun toString(): String = "LoadAllExtensionVersionQuery"
}

data class ExtensionVersionFetchOneSummary(@Id var extensionVersionId : UUID? = null) {
}





// -----------------------------------------
// ExternalNetworkInjection Queries 
// -----------------------------------------

data class LoadExternalNetworkInjectionFilter(val externalNetworkInjectionId :  UUID? = null )

class FindExternalNetworkInjectionQuery(val filter: LoadExternalNetworkInjectionFilter = LoadExternalNetworkInjectionFilter()) {
    override fun toString(): String = "LoadExternalNetworkInjectionQuery"
}

class FindAllExternalNetworkInjectionQuery() {
    override fun toString(): String = "LoadAllExternalNetworkInjectionQuery"
}

data class ExternalNetworkInjectionFetchOneSummary(@Id var externalNetworkInjectionId : UUID? = null) {
}





// -----------------------------------------
// FloatProxy Queries 
// -----------------------------------------

data class LoadFloatProxyFilter(val floatProxyId :  UUID? = null )

class FindFloatProxyQuery(val filter: LoadFloatProxyFilter = LoadFloatProxyFilter()) {
    override fun toString(): String = "LoadFloatProxyQuery"
}

class FindAllFloatProxyQuery() {
    override fun toString(): String = "LoadAllFloatProxyQuery"
}

data class FloatProxyFetchOneSummary(@Id var floatProxyId : UUID? = null) {
}





// -----------------------------------------
// FossilFuel Queries 
// -----------------------------------------

data class LoadFossilFuelFilter(val fossilFuelId :  UUID? = null )

class FindFossilFuelQuery(val filter: LoadFossilFuelFilter = LoadFossilFuelFilter()) {
    override fun toString(): String = "LoadFossilFuelQuery"
}

class FindAllFossilFuelQuery() {
    override fun toString(): String = "LoadAllFossilFuelQuery"
}

data class FossilFuelFetchOneSummary(@Id var fossilFuelId : UUID? = null) {
}





// -----------------------------------------
// Frequency Queries 
// -----------------------------------------

data class LoadFrequencyFilter(val frequencyId :  UUID? = null )

class FindFrequencyQuery(val filter: LoadFrequencyFilter = LoadFrequencyFilter()) {
    override fun toString(): String = "LoadFrequencyQuery"
}

class FindAllFrequencyQuery() {
    override fun toString(): String = "LoadAllFrequencyQuery"
}

data class FrequencyFetchOneSummary(@Id var frequencyId : UUID? = null) {
}





// -----------------------------------------
// GenICompensationForGenJ Queries 
// -----------------------------------------

data class LoadGenICompensationForGenJFilter(val genICompensationForGenJId :  UUID? = null )

class FindGenICompensationForGenJQuery(val filter: LoadGenICompensationForGenJFilter = LoadGenICompensationForGenJFilter()) {
    override fun toString(): String = "LoadGenICompensationForGenJQuery"
}

class FindAllGenICompensationForGenJQuery() {
    override fun toString(): String = "LoadAllGenICompensationForGenJQuery"
}

data class GenICompensationForGenJFetchOneSummary(@Id var genICompensationForGenJId : UUID? = null) {
}





// -----------------------------------------
// GeneratingUnit Queries 
// -----------------------------------------

data class LoadGeneratingUnitFilter(val generatingUnitId :  UUID? = null )

class FindGeneratingUnitQuery(val filter: LoadGeneratingUnitFilter = LoadGeneratingUnitFilter()) {
    override fun toString(): String = "LoadGeneratingUnitQuery"
}

class FindAllGeneratingUnitQuery() {
    override fun toString(): String = "LoadAllGeneratingUnitQuery"
}

data class GeneratingUnitFetchOneSummary(@Id var generatingUnitId : UUID? = null) {
}





// -----------------------------------------
// GeographicalLocationVersion Queries 
// -----------------------------------------

data class LoadGeographicalLocationVersionFilter(val geographicalLocationVersionId :  UUID? = null )

class FindGeographicalLocationVersionQuery(val filter: LoadGeographicalLocationVersionFilter = LoadGeographicalLocationVersionFilter()) {
    override fun toString(): String = "LoadGeographicalLocationVersionQuery"
}

class FindAllGeographicalLocationVersionQuery() {
    override fun toString(): String = "LoadAllGeographicalLocationVersionQuery"
}

data class GeographicalLocationVersionFetchOneSummary(@Id var geographicalLocationVersionId : UUID? = null) {
}





// -----------------------------------------
// GeographicalRegion Queries 
// -----------------------------------------

data class LoadGeographicalRegionFilter(val geographicalRegionId :  UUID? = null )

class FindGeographicalRegionQuery(val filter: LoadGeographicalRegionFilter = LoadGeographicalRegionFilter()) {
    override fun toString(): String = "LoadGeographicalRegionQuery"
}

class FindAllGeographicalRegionQuery() {
    override fun toString(): String = "LoadAllGeographicalRegionQuery"
}

data class GeographicalRegionFetchOneSummary(@Id var geographicalRegionId : UUID? = null) {
}





// -----------------------------------------
// GovCT1 Queries 
// -----------------------------------------

data class LoadGovCT1Filter(val govCT1Id :  UUID? = null )

class FindGovCT1Query(val filter: LoadGovCT1Filter = LoadGovCT1Filter()) {
    override fun toString(): String = "LoadGovCT1Query"
}

class FindAllGovCT1Query() {
    override fun toString(): String = "LoadAllGovCT1Query"
}

data class GovCT1FetchOneSummary(@Id var govCT1Id : UUID? = null) {
}





// -----------------------------------------
// GovCT2 Queries 
// -----------------------------------------

data class LoadGovCT2Filter(val govCT2Id :  UUID? = null )

class FindGovCT2Query(val filter: LoadGovCT2Filter = LoadGovCT2Filter()) {
    override fun toString(): String = "LoadGovCT2Query"
}

class FindAllGovCT2Query() {
    override fun toString(): String = "LoadAllGovCT2Query"
}

data class GovCT2FetchOneSummary(@Id var govCT2Id : UUID? = null) {
}





// -----------------------------------------
// GovGAST Queries 
// -----------------------------------------

data class LoadGovGASTFilter(val govGASTId :  UUID? = null )

class FindGovGASTQuery(val filter: LoadGovGASTFilter = LoadGovGASTFilter()) {
    override fun toString(): String = "LoadGovGASTQuery"
}

class FindAllGovGASTQuery() {
    override fun toString(): String = "LoadAllGovGASTQuery"
}

data class GovGASTFetchOneSummary(@Id var govGASTId : UUID? = null) {
}





// -----------------------------------------
// GovGAST1 Queries 
// -----------------------------------------

data class LoadGovGAST1Filter(val govGAST1Id :  UUID? = null )

class FindGovGAST1Query(val filter: LoadGovGAST1Filter = LoadGovGAST1Filter()) {
    override fun toString(): String = "LoadGovGAST1Query"
}

class FindAllGovGAST1Query() {
    override fun toString(): String = "LoadAllGovGAST1Query"
}

data class GovGAST1FetchOneSummary(@Id var govGAST1Id : UUID? = null) {
}





// -----------------------------------------
// GovGAST2 Queries 
// -----------------------------------------

data class LoadGovGAST2Filter(val govGAST2Id :  UUID? = null )

class FindGovGAST2Query(val filter: LoadGovGAST2Filter = LoadGovGAST2Filter()) {
    override fun toString(): String = "LoadGovGAST2Query"
}

class FindAllGovGAST2Query() {
    override fun toString(): String = "LoadAllGovGAST2Query"
}

data class GovGAST2FetchOneSummary(@Id var govGAST2Id : UUID? = null) {
}





// -----------------------------------------
// GovGAST3 Queries 
// -----------------------------------------

data class LoadGovGAST3Filter(val govGAST3Id :  UUID? = null )

class FindGovGAST3Query(val filter: LoadGovGAST3Filter = LoadGovGAST3Filter()) {
    override fun toString(): String = "LoadGovGAST3Query"
}

class FindAllGovGAST3Query() {
    override fun toString(): String = "LoadAllGovGAST3Query"
}

data class GovGAST3FetchOneSummary(@Id var govGAST3Id : UUID? = null) {
}





// -----------------------------------------
// GovGAST4 Queries 
// -----------------------------------------

data class LoadGovGAST4Filter(val govGAST4Id :  UUID? = null )

class FindGovGAST4Query(val filter: LoadGovGAST4Filter = LoadGovGAST4Filter()) {
    override fun toString(): String = "LoadGovGAST4Query"
}

class FindAllGovGAST4Query() {
    override fun toString(): String = "LoadAllGovGAST4Query"
}

data class GovGAST4FetchOneSummary(@Id var govGAST4Id : UUID? = null) {
}





// -----------------------------------------
// GovGASTWD Queries 
// -----------------------------------------

data class LoadGovGASTWDFilter(val govGASTWDId :  UUID? = null )

class FindGovGASTWDQuery(val filter: LoadGovGASTWDFilter = LoadGovGASTWDFilter()) {
    override fun toString(): String = "LoadGovGASTWDQuery"
}

class FindAllGovGASTWDQuery() {
    override fun toString(): String = "LoadAllGovGASTWDQuery"
}

data class GovGASTWDFetchOneSummary(@Id var govGASTWDId : UUID? = null) {
}





// -----------------------------------------
// GovHydro1 Queries 
// -----------------------------------------

data class LoadGovHydro1Filter(val govHydro1Id :  UUID? = null )

class FindGovHydro1Query(val filter: LoadGovHydro1Filter = LoadGovHydro1Filter()) {
    override fun toString(): String = "LoadGovHydro1Query"
}

class FindAllGovHydro1Query() {
    override fun toString(): String = "LoadAllGovHydro1Query"
}

data class GovHydro1FetchOneSummary(@Id var govHydro1Id : UUID? = null) {
}





// -----------------------------------------
// GovHydro2 Queries 
// -----------------------------------------

data class LoadGovHydro2Filter(val govHydro2Id :  UUID? = null )

class FindGovHydro2Query(val filter: LoadGovHydro2Filter = LoadGovHydro2Filter()) {
    override fun toString(): String = "LoadGovHydro2Query"
}

class FindAllGovHydro2Query() {
    override fun toString(): String = "LoadAllGovHydro2Query"
}

data class GovHydro2FetchOneSummary(@Id var govHydro2Id : UUID? = null) {
}





// -----------------------------------------
// GovHydro3 Queries 
// -----------------------------------------

data class LoadGovHydro3Filter(val govHydro3Id :  UUID? = null )

class FindGovHydro3Query(val filter: LoadGovHydro3Filter = LoadGovHydro3Filter()) {
    override fun toString(): String = "LoadGovHydro3Query"
}

class FindAllGovHydro3Query() {
    override fun toString(): String = "LoadAllGovHydro3Query"
}

data class GovHydro3FetchOneSummary(@Id var govHydro3Id : UUID? = null) {
}





// -----------------------------------------
// GovHydro4 Queries 
// -----------------------------------------

data class LoadGovHydro4Filter(val govHydro4Id :  UUID? = null )

class FindGovHydro4Query(val filter: LoadGovHydro4Filter = LoadGovHydro4Filter()) {
    override fun toString(): String = "LoadGovHydro4Query"
}

class FindAllGovHydro4Query() {
    override fun toString(): String = "LoadAllGovHydro4Query"
}

data class GovHydro4FetchOneSummary(@Id var govHydro4Id : UUID? = null) {
}





// -----------------------------------------
// GovHydroDD Queries 
// -----------------------------------------

data class LoadGovHydroDDFilter(val govHydroDDId :  UUID? = null )

class FindGovHydroDDQuery(val filter: LoadGovHydroDDFilter = LoadGovHydroDDFilter()) {
    override fun toString(): String = "LoadGovHydroDDQuery"
}

class FindAllGovHydroDDQuery() {
    override fun toString(): String = "LoadAllGovHydroDDQuery"
}

data class GovHydroDDFetchOneSummary(@Id var govHydroDDId : UUID? = null) {
}





// -----------------------------------------
// GovHydroFrancis Queries 
// -----------------------------------------

data class LoadGovHydroFrancisFilter(val govHydroFrancisId :  UUID? = null )

class FindGovHydroFrancisQuery(val filter: LoadGovHydroFrancisFilter = LoadGovHydroFrancisFilter()) {
    override fun toString(): String = "LoadGovHydroFrancisQuery"
}

class FindAllGovHydroFrancisQuery() {
    override fun toString(): String = "LoadAllGovHydroFrancisQuery"
}

data class GovHydroFrancisFetchOneSummary(@Id var govHydroFrancisId : UUID? = null) {
}





// -----------------------------------------
// GovHydroIEEE0 Queries 
// -----------------------------------------

data class LoadGovHydroIEEE0Filter(val govHydroIEEE0Id :  UUID? = null )

class FindGovHydroIEEE0Query(val filter: LoadGovHydroIEEE0Filter = LoadGovHydroIEEE0Filter()) {
    override fun toString(): String = "LoadGovHydroIEEE0Query"
}

class FindAllGovHydroIEEE0Query() {
    override fun toString(): String = "LoadAllGovHydroIEEE0Query"
}

data class GovHydroIEEE0FetchOneSummary(@Id var govHydroIEEE0Id : UUID? = null) {
}





// -----------------------------------------
// GovHydroIEEE2 Queries 
// -----------------------------------------

data class LoadGovHydroIEEE2Filter(val govHydroIEEE2Id :  UUID? = null )

class FindGovHydroIEEE2Query(val filter: LoadGovHydroIEEE2Filter = LoadGovHydroIEEE2Filter()) {
    override fun toString(): String = "LoadGovHydroIEEE2Query"
}

class FindAllGovHydroIEEE2Query() {
    override fun toString(): String = "LoadAllGovHydroIEEE2Query"
}

data class GovHydroIEEE2FetchOneSummary(@Id var govHydroIEEE2Id : UUID? = null) {
}





// -----------------------------------------
// GovHydroPID Queries 
// -----------------------------------------

data class LoadGovHydroPIDFilter(val govHydroPIDId :  UUID? = null )

class FindGovHydroPIDQuery(val filter: LoadGovHydroPIDFilter = LoadGovHydroPIDFilter()) {
    override fun toString(): String = "LoadGovHydroPIDQuery"
}

class FindAllGovHydroPIDQuery() {
    override fun toString(): String = "LoadAllGovHydroPIDQuery"
}

data class GovHydroPIDFetchOneSummary(@Id var govHydroPIDId : UUID? = null) {
}





// -----------------------------------------
// GovHydroPID2 Queries 
// -----------------------------------------

data class LoadGovHydroPID2Filter(val govHydroPID2Id :  UUID? = null )

class FindGovHydroPID2Query(val filter: LoadGovHydroPID2Filter = LoadGovHydroPID2Filter()) {
    override fun toString(): String = "LoadGovHydroPID2Query"
}

class FindAllGovHydroPID2Query() {
    override fun toString(): String = "LoadAllGovHydroPID2Query"
}

data class GovHydroPID2FetchOneSummary(@Id var govHydroPID2Id : UUID? = null) {
}





// -----------------------------------------
// GovHydroPelton Queries 
// -----------------------------------------

data class LoadGovHydroPeltonFilter(val govHydroPeltonId :  UUID? = null )

class FindGovHydroPeltonQuery(val filter: LoadGovHydroPeltonFilter = LoadGovHydroPeltonFilter()) {
    override fun toString(): String = "LoadGovHydroPeltonQuery"
}

class FindAllGovHydroPeltonQuery() {
    override fun toString(): String = "LoadAllGovHydroPeltonQuery"
}

data class GovHydroPeltonFetchOneSummary(@Id var govHydroPeltonId : UUID? = null) {
}





// -----------------------------------------
// GovHydroR Queries 
// -----------------------------------------

data class LoadGovHydroRFilter(val govHydroRId :  UUID? = null )

class FindGovHydroRQuery(val filter: LoadGovHydroRFilter = LoadGovHydroRFilter()) {
    override fun toString(): String = "LoadGovHydroRQuery"
}

class FindAllGovHydroRQuery() {
    override fun toString(): String = "LoadAllGovHydroRQuery"
}

data class GovHydroRFetchOneSummary(@Id var govHydroRId : UUID? = null) {
}





// -----------------------------------------
// GovHydroWEH Queries 
// -----------------------------------------

data class LoadGovHydroWEHFilter(val govHydroWEHId :  UUID? = null )

class FindGovHydroWEHQuery(val filter: LoadGovHydroWEHFilter = LoadGovHydroWEHFilter()) {
    override fun toString(): String = "LoadGovHydroWEHQuery"
}

class FindAllGovHydroWEHQuery() {
    override fun toString(): String = "LoadAllGovHydroWEHQuery"
}

data class GovHydroWEHFetchOneSummary(@Id var govHydroWEHId : UUID? = null) {
}





// -----------------------------------------
// GovHydroWPID Queries 
// -----------------------------------------

data class LoadGovHydroWPIDFilter(val govHydroWPIDId :  UUID? = null )

class FindGovHydroWPIDQuery(val filter: LoadGovHydroWPIDFilter = LoadGovHydroWPIDFilter()) {
    override fun toString(): String = "LoadGovHydroWPIDQuery"
}

class FindAllGovHydroWPIDQuery() {
    override fun toString(): String = "LoadAllGovHydroWPIDQuery"
}

data class GovHydroWPIDFetchOneSummary(@Id var govHydroWPIDId : UUID? = null) {
}





// -----------------------------------------
// GovSteam0 Queries 
// -----------------------------------------

data class LoadGovSteam0Filter(val govSteam0Id :  UUID? = null )

class FindGovSteam0Query(val filter: LoadGovSteam0Filter = LoadGovSteam0Filter()) {
    override fun toString(): String = "LoadGovSteam0Query"
}

class FindAllGovSteam0Query() {
    override fun toString(): String = "LoadAllGovSteam0Query"
}

data class GovSteam0FetchOneSummary(@Id var govSteam0Id : UUID? = null) {
}





// -----------------------------------------
// GovSteam1 Queries 
// -----------------------------------------

data class LoadGovSteam1Filter(val govSteam1Id :  UUID? = null )

class FindGovSteam1Query(val filter: LoadGovSteam1Filter = LoadGovSteam1Filter()) {
    override fun toString(): String = "LoadGovSteam1Query"
}

class FindAllGovSteam1Query() {
    override fun toString(): String = "LoadAllGovSteam1Query"
}

data class GovSteam1FetchOneSummary(@Id var govSteam1Id : UUID? = null) {
}





// -----------------------------------------
// GovSteam2 Queries 
// -----------------------------------------

data class LoadGovSteam2Filter(val govSteam2Id :  UUID? = null )

class FindGovSteam2Query(val filter: LoadGovSteam2Filter = LoadGovSteam2Filter()) {
    override fun toString(): String = "LoadGovSteam2Query"
}

class FindAllGovSteam2Query() {
    override fun toString(): String = "LoadAllGovSteam2Query"
}

data class GovSteam2FetchOneSummary(@Id var govSteam2Id : UUID? = null) {
}





// -----------------------------------------
// GovSteamCC Queries 
// -----------------------------------------

data class LoadGovSteamCCFilter(val govSteamCCId :  UUID? = null )

class FindGovSteamCCQuery(val filter: LoadGovSteamCCFilter = LoadGovSteamCCFilter()) {
    override fun toString(): String = "LoadGovSteamCCQuery"
}

class FindAllGovSteamCCQuery() {
    override fun toString(): String = "LoadAllGovSteamCCQuery"
}

data class GovSteamCCFetchOneSummary(@Id var govSteamCCId : UUID? = null) {
}





// -----------------------------------------
// GovSteamEU Queries 
// -----------------------------------------

data class LoadGovSteamEUFilter(val govSteamEUId :  UUID? = null )

class FindGovSteamEUQuery(val filter: LoadGovSteamEUFilter = LoadGovSteamEUFilter()) {
    override fun toString(): String = "LoadGovSteamEUQuery"
}

class FindAllGovSteamEUQuery() {
    override fun toString(): String = "LoadAllGovSteamEUQuery"
}

data class GovSteamEUFetchOneSummary(@Id var govSteamEUId : UUID? = null) {
}





// -----------------------------------------
// GovSteamFV2 Queries 
// -----------------------------------------

data class LoadGovSteamFV2Filter(val govSteamFV2Id :  UUID? = null )

class FindGovSteamFV2Query(val filter: LoadGovSteamFV2Filter = LoadGovSteamFV2Filter()) {
    override fun toString(): String = "LoadGovSteamFV2Query"
}

class FindAllGovSteamFV2Query() {
    override fun toString(): String = "LoadAllGovSteamFV2Query"
}

data class GovSteamFV2FetchOneSummary(@Id var govSteamFV2Id : UUID? = null) {
}





// -----------------------------------------
// GovSteamFV3 Queries 
// -----------------------------------------

data class LoadGovSteamFV3Filter(val govSteamFV3Id :  UUID? = null )

class FindGovSteamFV3Query(val filter: LoadGovSteamFV3Filter = LoadGovSteamFV3Filter()) {
    override fun toString(): String = "LoadGovSteamFV3Query"
}

class FindAllGovSteamFV3Query() {
    override fun toString(): String = "LoadAllGovSteamFV3Query"
}

data class GovSteamFV3FetchOneSummary(@Id var govSteamFV3Id : UUID? = null) {
}





// -----------------------------------------
// GovSteamFV4 Queries 
// -----------------------------------------

data class LoadGovSteamFV4Filter(val govSteamFV4Id :  UUID? = null )

class FindGovSteamFV4Query(val filter: LoadGovSteamFV4Filter = LoadGovSteamFV4Filter()) {
    override fun toString(): String = "LoadGovSteamFV4Query"
}

class FindAllGovSteamFV4Query() {
    override fun toString(): String = "LoadAllGovSteamFV4Query"
}

data class GovSteamFV4FetchOneSummary(@Id var govSteamFV4Id : UUID? = null) {
}





// -----------------------------------------
// GovSteamIEEE1 Queries 
// -----------------------------------------

data class LoadGovSteamIEEE1Filter(val govSteamIEEE1Id :  UUID? = null )

class FindGovSteamIEEE1Query(val filter: LoadGovSteamIEEE1Filter = LoadGovSteamIEEE1Filter()) {
    override fun toString(): String = "LoadGovSteamIEEE1Query"
}

class FindAllGovSteamIEEE1Query() {
    override fun toString(): String = "LoadAllGovSteamIEEE1Query"
}

data class GovSteamIEEE1FetchOneSummary(@Id var govSteamIEEE1Id : UUID? = null) {
}





// -----------------------------------------
// GovSteamSGO Queries 
// -----------------------------------------

data class LoadGovSteamSGOFilter(val govSteamSGOId :  UUID? = null )

class FindGovSteamSGOQuery(val filter: LoadGovSteamSGOFilter = LoadGovSteamSGOFilter()) {
    override fun toString(): String = "LoadGovSteamSGOQuery"
}

class FindAllGovSteamSGOQuery() {
    override fun toString(): String = "LoadAllGovSteamSGOQuery"
}

data class GovSteamSGOFetchOneSummary(@Id var govSteamSGOId : UUID? = null) {
}





// -----------------------------------------
// GrossToNetActivePowerCurve Queries 
// -----------------------------------------

data class LoadGrossToNetActivePowerCurveFilter(val grossToNetActivePowerCurveId :  UUID? = null )

class FindGrossToNetActivePowerCurveQuery(val filter: LoadGrossToNetActivePowerCurveFilter = LoadGrossToNetActivePowerCurveFilter()) {
    override fun toString(): String = "LoadGrossToNetActivePowerCurveQuery"
}

class FindAllGrossToNetActivePowerCurveQuery() {
    override fun toString(): String = "LoadAllGrossToNetActivePowerCurveQuery"
}

data class GrossToNetActivePowerCurveFetchOneSummary(@Id var grossToNetActivePowerCurveId : UUID? = null) {
}





// -----------------------------------------
// Ground Queries 
// -----------------------------------------

data class LoadGroundFilter(val groundId :  UUID? = null )

class FindGroundQuery(val filter: LoadGroundFilter = LoadGroundFilter()) {
    override fun toString(): String = "LoadGroundQuery"
}

class FindAllGroundQuery() {
    override fun toString(): String = "LoadAllGroundQuery"
}

data class GroundFetchOneSummary(@Id var groundId : UUID? = null) {
}





// -----------------------------------------
// GroundDisconnector Queries 
// -----------------------------------------

data class LoadGroundDisconnectorFilter(val groundDisconnectorId :  UUID? = null )

class FindGroundDisconnectorQuery(val filter: LoadGroundDisconnectorFilter = LoadGroundDisconnectorFilter()) {
    override fun toString(): String = "LoadGroundDisconnectorQuery"
}

class FindAllGroundDisconnectorQuery() {
    override fun toString(): String = "LoadAllGroundDisconnectorQuery"
}

data class GroundDisconnectorFetchOneSummary(@Id var groundDisconnectorId : UUID? = null) {
}





// -----------------------------------------
// GroundingImpedance Queries 
// -----------------------------------------

data class LoadGroundingImpedanceFilter(val groundingImpedanceId :  UUID? = null )

class FindGroundingImpedanceQuery(val filter: LoadGroundingImpedanceFilter = LoadGroundingImpedanceFilter()) {
    override fun toString(): String = "LoadGroundingImpedanceQuery"
}

class FindAllGroundingImpedanceQuery() {
    override fun toString(): String = "LoadAllGroundingImpedanceQuery"
}

data class GroundingImpedanceFetchOneSummary(@Id var groundingImpedanceId : UUID? = null) {
}





// -----------------------------------------
// HydroGeneratingUnit Queries 
// -----------------------------------------

data class LoadHydroGeneratingUnitFilter(val hydroGeneratingUnitId :  UUID? = null )

class FindHydroGeneratingUnitQuery(val filter: LoadHydroGeneratingUnitFilter = LoadHydroGeneratingUnitFilter()) {
    override fun toString(): String = "LoadHydroGeneratingUnitQuery"
}

class FindAllHydroGeneratingUnitQuery() {
    override fun toString(): String = "LoadAllHydroGeneratingUnitQuery"
}

data class HydroGeneratingUnitFetchOneSummary(@Id var hydroGeneratingUnitId : UUID? = null) {
}





// -----------------------------------------
// HydroPowerPlant Queries 
// -----------------------------------------

data class LoadHydroPowerPlantFilter(val hydroPowerPlantId :  UUID? = null )

class FindHydroPowerPlantQuery(val filter: LoadHydroPowerPlantFilter = LoadHydroPowerPlantFilter()) {
    override fun toString(): String = "LoadHydroPowerPlantQuery"
}

class FindAllHydroPowerPlantQuery() {
    override fun toString(): String = "LoadAllHydroPowerPlantQuery"
}

data class HydroPowerPlantFetchOneSummary(@Id var hydroPowerPlantId : UUID? = null) {
}





// -----------------------------------------
// HydroPump Queries 
// -----------------------------------------

data class LoadHydroPumpFilter(val hydroPumpId :  UUID? = null )

class FindHydroPumpQuery(val filter: LoadHydroPumpFilter = LoadHydroPumpFilter()) {
    override fun toString(): String = "LoadHydroPumpQuery"
}

class FindAllHydroPumpQuery() {
    override fun toString(): String = "LoadAllHydroPumpQuery"
}

data class HydroPumpFetchOneSummary(@Id var hydroPumpId : UUID? = null) {
}





// -----------------------------------------
// IdentifiedObject Queries 
// -----------------------------------------

data class LoadIdentifiedObjectFilter(val identifiedObjectId :  UUID? = null )

class FindIdentifiedObjectQuery(val filter: LoadIdentifiedObjectFilter = LoadIdentifiedObjectFilter()) {
    override fun toString(): String = "LoadIdentifiedObjectQuery"
}

class FindAllIdentifiedObjectQuery() {
    override fun toString(): String = "LoadAllIdentifiedObjectQuery"
}

data class IdentifiedObjectFetchOneSummary(@Id var identifiedObjectId : UUID? = null) {
}





// -----------------------------------------
// Inductance Queries 
// -----------------------------------------

data class LoadInductanceFilter(val inductanceId :  UUID? = null )

class FindInductanceQuery(val filter: LoadInductanceFilter = LoadInductanceFilter()) {
    override fun toString(): String = "LoadInductanceQuery"
}

class FindAllInductanceQuery() {
    override fun toString(): String = "LoadAllInductanceQuery"
}

data class InductanceFetchOneSummary(@Id var inductanceId : UUID? = null) {
}





// -----------------------------------------
// InductancePerLength Queries 
// -----------------------------------------

data class LoadInductancePerLengthFilter(val inductancePerLengthId :  UUID? = null )

class FindInductancePerLengthQuery(val filter: LoadInductancePerLengthFilter = LoadInductancePerLengthFilter()) {
    override fun toString(): String = "LoadInductancePerLengthQuery"
}

class FindAllInductancePerLengthQuery() {
    override fun toString(): String = "LoadAllInductancePerLengthQuery"
}

data class InductancePerLengthFetchOneSummary(@Id var inductancePerLengthId : UUID? = null) {
}





// -----------------------------------------
// IntegerProxy Queries 
// -----------------------------------------

data class LoadIntegerProxyFilter(val integerProxyId :  UUID? = null )

class FindIntegerProxyQuery(val filter: LoadIntegerProxyFilter = LoadIntegerProxyFilter()) {
    override fun toString(): String = "LoadIntegerProxyQuery"
}

class FindAllIntegerProxyQuery() {
    override fun toString(): String = "LoadAllIntegerProxyQuery"
}

data class IntegerProxyFetchOneSummary(@Id var integerProxyId : UUID? = null) {
}





// -----------------------------------------
// Junction Queries 
// -----------------------------------------

data class LoadJunctionFilter(val junctionId :  UUID? = null )

class FindJunctionQuery(val filter: LoadJunctionFilter = LoadJunctionFilter()) {
    override fun toString(): String = "LoadJunctionQuery"
}

class FindAllJunctionQuery() {
    override fun toString(): String = "LoadAllJunctionQuery"
}

data class JunctionFetchOneSummary(@Id var junctionId : UUID? = null) {
}





// -----------------------------------------
// Length Queries 
// -----------------------------------------

data class LoadLengthFilter(val lengthId :  UUID? = null )

class FindLengthQuery(val filter: LoadLengthFilter = LoadLengthFilter()) {
    override fun toString(): String = "LoadLengthQuery"
}

class FindAllLengthQuery() {
    override fun toString(): String = "LoadAllLengthQuery"
}

data class LengthFetchOneSummary(@Id var lengthId : UUID? = null) {
}





// -----------------------------------------
// Limit Queries 
// -----------------------------------------

data class LoadLimitFilter(val limitId :  UUID? = null )

class FindLimitQuery(val filter: LoadLimitFilter = LoadLimitFilter()) {
    override fun toString(): String = "LoadLimitQuery"
}

class FindAllLimitQuery() {
    override fun toString(): String = "LoadAllLimitQuery"
}

data class LimitFetchOneSummary(@Id var limitId : UUID? = null) {
}





// -----------------------------------------
// LimitSet Queries 
// -----------------------------------------

data class LoadLimitSetFilter(val limitSetId :  UUID? = null )

class FindLimitSetQuery(val filter: LoadLimitSetFilter = LoadLimitSetFilter()) {
    override fun toString(): String = "LoadLimitSetQuery"
}

class FindAllLimitSetQuery() {
    override fun toString(): String = "LoadAllLimitSetQuery"
}

data class LimitSetFetchOneSummary(@Id var limitSetId : UUID? = null) {
}





// -----------------------------------------
// Line Queries 
// -----------------------------------------

data class LoadLineFilter(val lineId :  UUID? = null )

class FindLineQuery(val filter: LoadLineFilter = LoadLineFilter()) {
    override fun toString(): String = "LoadLineQuery"
}

class FindAllLineQuery() {
    override fun toString(): String = "LoadAllLineQuery"
}

data class LineFetchOneSummary(@Id var lineId : UUID? = null) {
}





// -----------------------------------------
// LinearShuntCompensator Queries 
// -----------------------------------------

data class LoadLinearShuntCompensatorFilter(val linearShuntCompensatorId :  UUID? = null )

class FindLinearShuntCompensatorQuery(val filter: LoadLinearShuntCompensatorFilter = LoadLinearShuntCompensatorFilter()) {
    override fun toString(): String = "LoadLinearShuntCompensatorQuery"
}

class FindAllLinearShuntCompensatorQuery() {
    override fun toString(): String = "LoadAllLinearShuntCompensatorQuery"
}

data class LinearShuntCompensatorFetchOneSummary(@Id var linearShuntCompensatorId : UUID? = null) {
}





// -----------------------------------------
// LoadAggregate Queries 
// -----------------------------------------

data class LoadLoadAggregateFilter(val loadAggregateId :  UUID? = null )

class FindLoadAggregateQuery(val filter: LoadLoadAggregateFilter = LoadLoadAggregateFilter()) {
    override fun toString(): String = "LoadLoadAggregateQuery"
}

class FindAllLoadAggregateQuery() {
    override fun toString(): String = "LoadAllLoadAggregateQuery"
}

data class LoadAggregateFetchOneSummary(@Id var loadAggregateId : UUID? = null) {
}





// -----------------------------------------
// LoadArea Queries 
// -----------------------------------------

data class LoadLoadAreaFilter(val loadAreaId :  UUID? = null )

class FindLoadAreaQuery(val filter: LoadLoadAreaFilter = LoadLoadAreaFilter()) {
    override fun toString(): String = "LoadLoadAreaQuery"
}

class FindAllLoadAreaQuery() {
    override fun toString(): String = "LoadAllLoadAreaQuery"
}

data class LoadAreaFetchOneSummary(@Id var loadAreaId : UUID? = null) {
}





// -----------------------------------------
// LoadBreakSwitch Queries 
// -----------------------------------------

data class LoadLoadBreakSwitchFilter(val loadBreakSwitchId :  UUID? = null )

class FindLoadBreakSwitchQuery(val filter: LoadLoadBreakSwitchFilter = LoadLoadBreakSwitchFilter()) {
    override fun toString(): String = "LoadLoadBreakSwitchQuery"
}

class FindAllLoadBreakSwitchQuery() {
    override fun toString(): String = "LoadAllLoadBreakSwitchQuery"
}

data class LoadBreakSwitchFetchOneSummary(@Id var loadBreakSwitchId : UUID? = null) {
}





// -----------------------------------------
// LoadComposite Queries 
// -----------------------------------------

data class LoadLoadCompositeFilter(val loadCompositeId :  UUID? = null )

class FindLoadCompositeQuery(val filter: LoadLoadCompositeFilter = LoadLoadCompositeFilter()) {
    override fun toString(): String = "LoadLoadCompositeQuery"
}

class FindAllLoadCompositeQuery() {
    override fun toString(): String = "LoadAllLoadCompositeQuery"
}

data class LoadCompositeFetchOneSummary(@Id var loadCompositeId : UUID? = null) {
}





// -----------------------------------------
// LoadDynamics Queries 
// -----------------------------------------

data class LoadLoadDynamicsFilter(val loadDynamicsId :  UUID? = null )

class FindLoadDynamicsQuery(val filter: LoadLoadDynamicsFilter = LoadLoadDynamicsFilter()) {
    override fun toString(): String = "LoadLoadDynamicsQuery"
}

class FindAllLoadDynamicsQuery() {
    override fun toString(): String = "LoadAllLoadDynamicsQuery"
}

data class LoadDynamicsFetchOneSummary(@Id var loadDynamicsId : UUID? = null) {
}





// -----------------------------------------
// LoadGenericNonLinear Queries 
// -----------------------------------------

data class LoadLoadGenericNonLinearFilter(val loadGenericNonLinearId :  UUID? = null )

class FindLoadGenericNonLinearQuery(val filter: LoadLoadGenericNonLinearFilter = LoadLoadGenericNonLinearFilter()) {
    override fun toString(): String = "LoadLoadGenericNonLinearQuery"
}

class FindAllLoadGenericNonLinearQuery() {
    override fun toString(): String = "LoadAllLoadGenericNonLinearQuery"
}

data class LoadGenericNonLinearFetchOneSummary(@Id var loadGenericNonLinearId : UUID? = null) {
}





// -----------------------------------------
// LoadGroup Queries 
// -----------------------------------------

data class LoadLoadGroupFilter(val loadGroupId :  UUID? = null )

class FindLoadGroupQuery(val filter: LoadLoadGroupFilter = LoadLoadGroupFilter()) {
    override fun toString(): String = "LoadLoadGroupQuery"
}

class FindAllLoadGroupQuery() {
    override fun toString(): String = "LoadAllLoadGroupQuery"
}

data class LoadGroupFetchOneSummary(@Id var loadGroupId : UUID? = null) {
}





// -----------------------------------------
// LoadMotor Queries 
// -----------------------------------------

data class LoadLoadMotorFilter(val loadMotorId :  UUID? = null )

class FindLoadMotorQuery(val filter: LoadLoadMotorFilter = LoadLoadMotorFilter()) {
    override fun toString(): String = "LoadLoadMotorQuery"
}

class FindAllLoadMotorQuery() {
    override fun toString(): String = "LoadAllLoadMotorQuery"
}

data class LoadMotorFetchOneSummary(@Id var loadMotorId : UUID? = null) {
}





// -----------------------------------------
// LoadResponseCharacteristic Queries 
// -----------------------------------------

data class LoadLoadResponseCharacteristicFilter(val loadResponseCharacteristicId :  UUID? = null )

class FindLoadResponseCharacteristicQuery(val filter: LoadLoadResponseCharacteristicFilter = LoadLoadResponseCharacteristicFilter()) {
    override fun toString(): String = "LoadLoadResponseCharacteristicQuery"
}

class FindAllLoadResponseCharacteristicQuery() {
    override fun toString(): String = "LoadAllLoadResponseCharacteristicQuery"
}

data class LoadResponseCharacteristicFetchOneSummary(@Id var loadResponseCharacteristicId : UUID? = null) {
}





// -----------------------------------------
// LoadStatic Queries 
// -----------------------------------------

data class LoadLoadStaticFilter(val loadStaticId :  UUID? = null )

class FindLoadStaticQuery(val filter: LoadLoadStaticFilter = LoadLoadStaticFilter()) {
    override fun toString(): String = "LoadLoadStaticQuery"
}

class FindAllLoadStaticQuery() {
    override fun toString(): String = "LoadAllLoadStaticQuery"
}

data class LoadStaticFetchOneSummary(@Id var loadStaticId : UUID? = null) {
}





// -----------------------------------------
// LoadUserDefined Queries 
// -----------------------------------------

data class LoadLoadUserDefinedFilter(val loadUserDefinedId :  UUID? = null )

class FindLoadUserDefinedQuery(val filter: LoadLoadUserDefinedFilter = LoadLoadUserDefinedFilter()) {
    override fun toString(): String = "LoadLoadUserDefinedQuery"
}

class FindAllLoadUserDefinedQuery() {
    override fun toString(): String = "LoadAllLoadUserDefinedQuery"
}

data class LoadUserDefinedFetchOneSummary(@Id var loadUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// Location Queries 
// -----------------------------------------

data class LoadLocationFilter(val locationId :  UUID? = null )

class FindLocationQuery(val filter: LoadLocationFilter = LoadLocationFilter()) {
    override fun toString(): String = "LoadLocationQuery"
}

class FindAllLocationQuery() {
    override fun toString(): String = "LoadAllLocationQuery"
}

data class LocationFetchOneSummary(@Id var locationId : UUID? = null) {
}





// -----------------------------------------
// Measurement Queries 
// -----------------------------------------

data class LoadMeasurementFilter(val measurementId :  UUID? = null )

class FindMeasurementQuery(val filter: LoadMeasurementFilter = LoadMeasurementFilter()) {
    override fun toString(): String = "LoadMeasurementQuery"
}

class FindAllMeasurementQuery() {
    override fun toString(): String = "LoadAllMeasurementQuery"
}

data class MeasurementFetchOneSummary(@Id var measurementId : UUID? = null) {
}





// -----------------------------------------
// MeasurementValue Queries 
// -----------------------------------------

data class LoadMeasurementValueFilter(val measurementValueId :  UUID? = null )

class FindMeasurementValueQuery(val filter: LoadMeasurementValueFilter = LoadMeasurementValueFilter()) {
    override fun toString(): String = "LoadMeasurementValueQuery"
}

class FindAllMeasurementValueQuery() {
    override fun toString(): String = "LoadAllMeasurementValueQuery"
}

data class MeasurementValueFetchOneSummary(@Id var measurementValueId : UUID? = null) {
}





// -----------------------------------------
// MeasurementValueQuality Queries 
// -----------------------------------------

data class LoadMeasurementValueQualityFilter(val measurementValueQualityId :  UUID? = null )

class FindMeasurementValueQualityQuery(val filter: LoadMeasurementValueQualityFilter = LoadMeasurementValueQualityFilter()) {
    override fun toString(): String = "LoadMeasurementValueQualityQuery"
}

class FindAllMeasurementValueQualityQuery() {
    override fun toString(): String = "LoadAllMeasurementValueQualityQuery"
}

data class MeasurementValueQualityFetchOneSummary(@Id var measurementValueQualityId : UUID? = null) {
}





// -----------------------------------------
// MeasurementValueSource Queries 
// -----------------------------------------

data class LoadMeasurementValueSourceFilter(val measurementValueSourceId :  UUID? = null )

class FindMeasurementValueSourceQuery(val filter: LoadMeasurementValueSourceFilter = LoadMeasurementValueSourceFilter()) {
    override fun toString(): String = "LoadMeasurementValueSourceQuery"
}

class FindAllMeasurementValueSourceQuery() {
    override fun toString(): String = "LoadAllMeasurementValueSourceQuery"
}

data class MeasurementValueSourceFetchOneSummary(@Id var measurementValueSourceId : UUID? = null) {
}





// -----------------------------------------
// MechLoad1 Queries 
// -----------------------------------------

data class LoadMechLoad1Filter(val mechLoad1Id :  UUID? = null )

class FindMechLoad1Query(val filter: LoadMechLoad1Filter = LoadMechLoad1Filter()) {
    override fun toString(): String = "LoadMechLoad1Query"
}

class FindAllMechLoad1Query() {
    override fun toString(): String = "LoadAllMechLoad1Query"
}

data class MechLoad1FetchOneSummary(@Id var mechLoad1Id : UUID? = null) {
}





// -----------------------------------------
// MechanicalLoadDynamics Queries 
// -----------------------------------------

data class LoadMechanicalLoadDynamicsFilter(val mechanicalLoadDynamicsId :  UUID? = null )

class FindMechanicalLoadDynamicsQuery(val filter: LoadMechanicalLoadDynamicsFilter = LoadMechanicalLoadDynamicsFilter()) {
    override fun toString(): String = "LoadMechanicalLoadDynamicsQuery"
}

class FindAllMechanicalLoadDynamicsQuery() {
    override fun toString(): String = "LoadAllMechanicalLoadDynamicsQuery"
}

data class MechanicalLoadDynamicsFetchOneSummary(@Id var mechanicalLoadDynamicsId : UUID? = null) {
}





// -----------------------------------------
// MechanicalLoadUserDefined Queries 
// -----------------------------------------

data class LoadMechanicalLoadUserDefinedFilter(val mechanicalLoadUserDefinedId :  UUID? = null )

class FindMechanicalLoadUserDefinedQuery(val filter: LoadMechanicalLoadUserDefinedFilter = LoadMechanicalLoadUserDefinedFilter()) {
    override fun toString(): String = "LoadMechanicalLoadUserDefinedQuery"
}

class FindAllMechanicalLoadUserDefinedQuery() {
    override fun toString(): String = "LoadAllMechanicalLoadUserDefinedQuery"
}

data class MechanicalLoadUserDefinedFetchOneSummary(@Id var mechanicalLoadUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// Money Queries 
// -----------------------------------------

data class LoadMoneyFilter(val moneyId :  UUID? = null )

class FindMoneyQuery(val filter: LoadMoneyFilter = LoadMoneyFilter()) {
    override fun toString(): String = "LoadMoneyQuery"
}

class FindAllMoneyQuery() {
    override fun toString(): String = "LoadAllMoneyQuery"
}

data class MoneyFetchOneSummary(@Id var moneyId : UUID? = null) {
}





// -----------------------------------------
// MonthDay Queries 
// -----------------------------------------

data class LoadMonthDayFilter(val monthDayId :  UUID? = null )

class FindMonthDayQuery(val filter: LoadMonthDayFilter = LoadMonthDayFilter()) {
    override fun toString(): String = "LoadMonthDayQuery"
}

class FindAllMonthDayQuery() {
    override fun toString(): String = "LoadAllMonthDayQuery"
}

data class MonthDayFetchOneSummary(@Id var monthDayId : UUID? = null) {
}





// -----------------------------------------
// MonthDayInterval Queries 
// -----------------------------------------

data class LoadMonthDayIntervalFilter(val monthDayIntervalId :  UUID? = null )

class FindMonthDayIntervalQuery(val filter: LoadMonthDayIntervalFilter = LoadMonthDayIntervalFilter()) {
    override fun toString(): String = "LoadMonthDayIntervalQuery"
}

class FindAllMonthDayIntervalQuery() {
    override fun toString(): String = "LoadAllMonthDayIntervalQuery"
}

data class MonthDayIntervalFetchOneSummary(@Id var monthDayIntervalId : UUID? = null) {
}





// -----------------------------------------
// MutualCoupling Queries 
// -----------------------------------------

data class LoadMutualCouplingFilter(val mutualCouplingId :  UUID? = null )

class FindMutualCouplingQuery(val filter: LoadMutualCouplingFilter = LoadMutualCouplingFilter()) {
    override fun toString(): String = "LoadMutualCouplingQuery"
}

class FindAllMutualCouplingQuery() {
    override fun toString(): String = "LoadAllMutualCouplingQuery"
}

data class MutualCouplingFetchOneSummary(@Id var mutualCouplingId : UUID? = null) {
}





// -----------------------------------------
// NonConformLoad Queries 
// -----------------------------------------

data class LoadNonConformLoadFilter(val nonConformLoadId :  UUID? = null )

class FindNonConformLoadQuery(val filter: LoadNonConformLoadFilter = LoadNonConformLoadFilter()) {
    override fun toString(): String = "LoadNonConformLoadQuery"
}

class FindAllNonConformLoadQuery() {
    override fun toString(): String = "LoadAllNonConformLoadQuery"
}

data class NonConformLoadFetchOneSummary(@Id var nonConformLoadId : UUID? = null) {
}





// -----------------------------------------
// NonConformLoadGroup Queries 
// -----------------------------------------

data class LoadNonConformLoadGroupFilter(val nonConformLoadGroupId :  UUID? = null )

class FindNonConformLoadGroupQuery(val filter: LoadNonConformLoadGroupFilter = LoadNonConformLoadGroupFilter()) {
    override fun toString(): String = "LoadNonConformLoadGroupQuery"
}

class FindAllNonConformLoadGroupQuery() {
    override fun toString(): String = "LoadAllNonConformLoadGroupQuery"
}

data class NonConformLoadGroupFetchOneSummary(@Id var nonConformLoadGroupId : UUID? = null) {
}





// -----------------------------------------
// NonConformLoadSchedule Queries 
// -----------------------------------------

data class LoadNonConformLoadScheduleFilter(val nonConformLoadScheduleId :  UUID? = null )

class FindNonConformLoadScheduleQuery(val filter: LoadNonConformLoadScheduleFilter = LoadNonConformLoadScheduleFilter()) {
    override fun toString(): String = "LoadNonConformLoadScheduleQuery"
}

class FindAllNonConformLoadScheduleQuery() {
    override fun toString(): String = "LoadAllNonConformLoadScheduleQuery"
}

data class NonConformLoadScheduleFetchOneSummary(@Id var nonConformLoadScheduleId : UUID? = null) {
}





// -----------------------------------------
// NonlinearShuntCompensator Queries 
// -----------------------------------------

data class LoadNonlinearShuntCompensatorFilter(val nonlinearShuntCompensatorId :  UUID? = null )

class FindNonlinearShuntCompensatorQuery(val filter: LoadNonlinearShuntCompensatorFilter = LoadNonlinearShuntCompensatorFilter()) {
    override fun toString(): String = "LoadNonlinearShuntCompensatorQuery"
}

class FindAllNonlinearShuntCompensatorQuery() {
    override fun toString(): String = "LoadAllNonlinearShuntCompensatorQuery"
}

data class NonlinearShuntCompensatorFetchOneSummary(@Id var nonlinearShuntCompensatorId : UUID? = null) {
}





// -----------------------------------------
// NonlinearShuntCompensatorPoint Queries 
// -----------------------------------------

data class LoadNonlinearShuntCompensatorPointFilter(val nonlinearShuntCompensatorPointId :  UUID? = null )

class FindNonlinearShuntCompensatorPointQuery(val filter: LoadNonlinearShuntCompensatorPointFilter = LoadNonlinearShuntCompensatorPointFilter()) {
    override fun toString(): String = "LoadNonlinearShuntCompensatorPointQuery"
}

class FindAllNonlinearShuntCompensatorPointQuery() {
    override fun toString(): String = "LoadAllNonlinearShuntCompensatorPointQuery"
}

data class NonlinearShuntCompensatorPointFetchOneSummary(@Id var nonlinearShuntCompensatorPointId : UUID? = null) {
}





// -----------------------------------------
// NuclearGeneratingUnit Queries 
// -----------------------------------------

data class LoadNuclearGeneratingUnitFilter(val nuclearGeneratingUnitId :  UUID? = null )

class FindNuclearGeneratingUnitQuery(val filter: LoadNuclearGeneratingUnitFilter = LoadNuclearGeneratingUnitFilter()) {
    override fun toString(): String = "LoadNuclearGeneratingUnitQuery"
}

class FindAllNuclearGeneratingUnitQuery() {
    override fun toString(): String = "LoadAllNuclearGeneratingUnitQuery"
}

data class NuclearGeneratingUnitFetchOneSummary(@Id var nuclearGeneratingUnitId : UUID? = null) {
}





// -----------------------------------------
// OperationalLimit Queries 
// -----------------------------------------

data class LoadOperationalLimitFilter(val operationalLimitId :  UUID? = null )

class FindOperationalLimitQuery(val filter: LoadOperationalLimitFilter = LoadOperationalLimitFilter()) {
    override fun toString(): String = "LoadOperationalLimitQuery"
}

class FindAllOperationalLimitQuery() {
    override fun toString(): String = "LoadAllOperationalLimitQuery"
}

data class OperationalLimitFetchOneSummary(@Id var operationalLimitId : UUID? = null) {
}





// -----------------------------------------
// OperationalLimitSet Queries 
// -----------------------------------------

data class LoadOperationalLimitSetFilter(val operationalLimitSetId :  UUID? = null )

class FindOperationalLimitSetQuery(val filter: LoadOperationalLimitSetFilter = LoadOperationalLimitSetFilter()) {
    override fun toString(): String = "LoadOperationalLimitSetQuery"
}

class FindAllOperationalLimitSetQuery() {
    override fun toString(): String = "LoadAllOperationalLimitSetQuery"
}

data class OperationalLimitSetFetchOneSummary(@Id var operationalLimitSetId : UUID? = null) {
}





// -----------------------------------------
// OperationalLimitType Queries 
// -----------------------------------------

data class LoadOperationalLimitTypeFilter(val operationalLimitTypeId :  UUID? = null )

class FindOperationalLimitTypeQuery(val filter: LoadOperationalLimitTypeFilter = LoadOperationalLimitTypeFilter()) {
    override fun toString(): String = "LoadOperationalLimitTypeQuery"
}

class FindAllOperationalLimitTypeQuery() {
    override fun toString(): String = "LoadAllOperationalLimitTypeQuery"
}

data class OperationalLimitTypeFetchOneSummary(@Id var operationalLimitTypeId : UUID? = null) {
}





// -----------------------------------------
// OverexcLim2 Queries 
// -----------------------------------------

data class LoadOverexcLim2Filter(val overexcLim2Id :  UUID? = null )

class FindOverexcLim2Query(val filter: LoadOverexcLim2Filter = LoadOverexcLim2Filter()) {
    override fun toString(): String = "LoadOverexcLim2Query"
}

class FindAllOverexcLim2Query() {
    override fun toString(): String = "LoadAllOverexcLim2Query"
}

data class OverexcLim2FetchOneSummary(@Id var overexcLim2Id : UUID? = null) {
}





// -----------------------------------------
// OverexcLimIEEE Queries 
// -----------------------------------------

data class LoadOverexcLimIEEEFilter(val overexcLimIEEEId :  UUID? = null )

class FindOverexcLimIEEEQuery(val filter: LoadOverexcLimIEEEFilter = LoadOverexcLimIEEEFilter()) {
    override fun toString(): String = "LoadOverexcLimIEEEQuery"
}

class FindAllOverexcLimIEEEQuery() {
    override fun toString(): String = "LoadAllOverexcLimIEEEQuery"
}

data class OverexcLimIEEEFetchOneSummary(@Id var overexcLimIEEEId : UUID? = null) {
}





// -----------------------------------------
// OverexcLimX1 Queries 
// -----------------------------------------

data class LoadOverexcLimX1Filter(val overexcLimX1Id :  UUID? = null )

class FindOverexcLimX1Query(val filter: LoadOverexcLimX1Filter = LoadOverexcLimX1Filter()) {
    override fun toString(): String = "LoadOverexcLimX1Query"
}

class FindAllOverexcLimX1Query() {
    override fun toString(): String = "LoadAllOverexcLimX1Query"
}

data class OverexcLimX1FetchOneSummary(@Id var overexcLimX1Id : UUID? = null) {
}





// -----------------------------------------
// OverexcLimX2 Queries 
// -----------------------------------------

data class LoadOverexcLimX2Filter(val overexcLimX2Id :  UUID? = null )

class FindOverexcLimX2Query(val filter: LoadOverexcLimX2Filter = LoadOverexcLimX2Filter()) {
    override fun toString(): String = "LoadOverexcLimX2Query"
}

class FindAllOverexcLimX2Query() {
    override fun toString(): String = "LoadAllOverexcLimX2Query"
}

data class OverexcLimX2FetchOneSummary(@Id var overexcLimX2Id : UUID? = null) {
}





// -----------------------------------------
// OverexcitationLimiterDynamics Queries 
// -----------------------------------------

data class LoadOverexcitationLimiterDynamicsFilter(val overexcitationLimiterDynamicsId :  UUID? = null )

class FindOverexcitationLimiterDynamicsQuery(val filter: LoadOverexcitationLimiterDynamicsFilter = LoadOverexcitationLimiterDynamicsFilter()) {
    override fun toString(): String = "LoadOverexcitationLimiterDynamicsQuery"
}

class FindAllOverexcitationLimiterDynamicsQuery() {
    override fun toString(): String = "LoadAllOverexcitationLimiterDynamicsQuery"
}

data class OverexcitationLimiterDynamicsFetchOneSummary(@Id var overexcitationLimiterDynamicsId : UUID? = null) {
}





// -----------------------------------------
// OverexcitationLimiterUserDefined Queries 
// -----------------------------------------

data class LoadOverexcitationLimiterUserDefinedFilter(val overexcitationLimiterUserDefinedId :  UUID? = null )

class FindOverexcitationLimiterUserDefinedQuery(val filter: LoadOverexcitationLimiterUserDefinedFilter = LoadOverexcitationLimiterUserDefinedFilter()) {
    override fun toString(): String = "LoadOverexcitationLimiterUserDefinedQuery"
}

class FindAllOverexcitationLimiterUserDefinedQuery() {
    override fun toString(): String = "LoadAllOverexcitationLimiterUserDefinedQuery"
}

data class OverexcitationLimiterUserDefinedFetchOneSummary(@Id var overexcitationLimiterUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// PFVArControllerType1Dynamics Queries 
// -----------------------------------------

data class LoadPFVArControllerType1DynamicsFilter(val pFVArControllerType1DynamicsId :  UUID? = null )

class FindPFVArControllerType1DynamicsQuery(val filter: LoadPFVArControllerType1DynamicsFilter = LoadPFVArControllerType1DynamicsFilter()) {
    override fun toString(): String = "LoadPFVArControllerType1DynamicsQuery"
}

class FindAllPFVArControllerType1DynamicsQuery() {
    override fun toString(): String = "LoadAllPFVArControllerType1DynamicsQuery"
}

data class PFVArControllerType1DynamicsFetchOneSummary(@Id var pFVArControllerType1DynamicsId : UUID? = null) {
}





// -----------------------------------------
// PFVArControllerType1UserDefined Queries 
// -----------------------------------------

data class LoadPFVArControllerType1UserDefinedFilter(val pFVArControllerType1UserDefinedId :  UUID? = null )

class FindPFVArControllerType1UserDefinedQuery(val filter: LoadPFVArControllerType1UserDefinedFilter = LoadPFVArControllerType1UserDefinedFilter()) {
    override fun toString(): String = "LoadPFVArControllerType1UserDefinedQuery"
}

class FindAllPFVArControllerType1UserDefinedQuery() {
    override fun toString(): String = "LoadAllPFVArControllerType1UserDefinedQuery"
}

data class PFVArControllerType1UserDefinedFetchOneSummary(@Id var pFVArControllerType1UserDefinedId : UUID? = null) {
}





// -----------------------------------------
// PFVArControllerType2Dynamics Queries 
// -----------------------------------------

data class LoadPFVArControllerType2DynamicsFilter(val pFVArControllerType2DynamicsId :  UUID? = null )

class FindPFVArControllerType2DynamicsQuery(val filter: LoadPFVArControllerType2DynamicsFilter = LoadPFVArControllerType2DynamicsFilter()) {
    override fun toString(): String = "LoadPFVArControllerType2DynamicsQuery"
}

class FindAllPFVArControllerType2DynamicsQuery() {
    override fun toString(): String = "LoadAllPFVArControllerType2DynamicsQuery"
}

data class PFVArControllerType2DynamicsFetchOneSummary(@Id var pFVArControllerType2DynamicsId : UUID? = null) {
}





// -----------------------------------------
// PFVArControllerType2UserDefined Queries 
// -----------------------------------------

data class LoadPFVArControllerType2UserDefinedFilter(val pFVArControllerType2UserDefinedId :  UUID? = null )

class FindPFVArControllerType2UserDefinedQuery(val filter: LoadPFVArControllerType2UserDefinedFilter = LoadPFVArControllerType2UserDefinedFilter()) {
    override fun toString(): String = "LoadPFVArControllerType2UserDefinedQuery"
}

class FindAllPFVArControllerType2UserDefinedQuery() {
    override fun toString(): String = "LoadAllPFVArControllerType2UserDefinedQuery"
}

data class PFVArControllerType2UserDefinedFetchOneSummary(@Id var pFVArControllerType2UserDefinedId : UUID? = null) {
}





// -----------------------------------------
// PFVArType1IEEEPFController Queries 
// -----------------------------------------

data class LoadPFVArType1IEEEPFControllerFilter(val pFVArType1IEEEPFControllerId :  UUID? = null )

class FindPFVArType1IEEEPFControllerQuery(val filter: LoadPFVArType1IEEEPFControllerFilter = LoadPFVArType1IEEEPFControllerFilter()) {
    override fun toString(): String = "LoadPFVArType1IEEEPFControllerQuery"
}

class FindAllPFVArType1IEEEPFControllerQuery() {
    override fun toString(): String = "LoadAllPFVArType1IEEEPFControllerQuery"
}

data class PFVArType1IEEEPFControllerFetchOneSummary(@Id var pFVArType1IEEEPFControllerId : UUID? = null) {
}





// -----------------------------------------
// PFVArType1IEEEVArController Queries 
// -----------------------------------------

data class LoadPFVArType1IEEEVArControllerFilter(val pFVArType1IEEEVArControllerId :  UUID? = null )

class FindPFVArType1IEEEVArControllerQuery(val filter: LoadPFVArType1IEEEVArControllerFilter = LoadPFVArType1IEEEVArControllerFilter()) {
    override fun toString(): String = "LoadPFVArType1IEEEVArControllerQuery"
}

class FindAllPFVArType1IEEEVArControllerQuery() {
    override fun toString(): String = "LoadAllPFVArType1IEEEVArControllerQuery"
}

data class PFVArType1IEEEVArControllerFetchOneSummary(@Id var pFVArType1IEEEVArControllerId : UUID? = null) {
}





// -----------------------------------------
// PFVArType2Common1 Queries 
// -----------------------------------------

data class LoadPFVArType2Common1Filter(val pFVArType2Common1Id :  UUID? = null )

class FindPFVArType2Common1Query(val filter: LoadPFVArType2Common1Filter = LoadPFVArType2Common1Filter()) {
    override fun toString(): String = "LoadPFVArType2Common1Query"
}

class FindAllPFVArType2Common1Query() {
    override fun toString(): String = "LoadAllPFVArType2Common1Query"
}

data class PFVArType2Common1FetchOneSummary(@Id var pFVArType2Common1Id : UUID? = null) {
}





// -----------------------------------------
// PFVArType2IEEEPFController Queries 
// -----------------------------------------

data class LoadPFVArType2IEEEPFControllerFilter(val pFVArType2IEEEPFControllerId :  UUID? = null )

class FindPFVArType2IEEEPFControllerQuery(val filter: LoadPFVArType2IEEEPFControllerFilter = LoadPFVArType2IEEEPFControllerFilter()) {
    override fun toString(): String = "LoadPFVArType2IEEEPFControllerQuery"
}

class FindAllPFVArType2IEEEPFControllerQuery() {
    override fun toString(): String = "LoadAllPFVArType2IEEEPFControllerQuery"
}

data class PFVArType2IEEEPFControllerFetchOneSummary(@Id var pFVArType2IEEEPFControllerId : UUID? = null) {
}





// -----------------------------------------
// PFVArType2IEEEVArController Queries 
// -----------------------------------------

data class LoadPFVArType2IEEEVArControllerFilter(val pFVArType2IEEEVArControllerId :  UUID? = null )

class FindPFVArType2IEEEVArControllerQuery(val filter: LoadPFVArType2IEEEVArControllerFilter = LoadPFVArType2IEEEVArControllerFilter()) {
    override fun toString(): String = "LoadPFVArType2IEEEVArControllerQuery"
}

class FindAllPFVArType2IEEEVArControllerQuery() {
    override fun toString(): String = "LoadAllPFVArType2IEEEVArControllerQuery"
}

data class PFVArType2IEEEVArControllerFetchOneSummary(@Id var pFVArType2IEEEVArControllerId : UUID? = null) {
}





// -----------------------------------------
// PU Queries 
// -----------------------------------------

data class LoadPUFilter(val pUId :  UUID? = null )

class FindPUQuery(val filter: LoadPUFilter = LoadPUFilter()) {
    override fun toString(): String = "LoadPUQuery"
}

class FindAllPUQuery() {
    override fun toString(): String = "LoadAllPUQuery"
}

data class PUFetchOneSummary(@Id var pUId : UUID? = null) {
}





// -----------------------------------------
// PerCent Queries 
// -----------------------------------------

data class LoadPerCentFilter(val perCentId :  UUID? = null )

class FindPerCentQuery(val filter: LoadPerCentFilter = LoadPerCentFilter()) {
    override fun toString(): String = "LoadPerCentQuery"
}

class FindAllPerCentQuery() {
    override fun toString(): String = "LoadAllPerCentQuery"
}

data class PerCentFetchOneSummary(@Id var perCentId : UUID? = null) {
}





// -----------------------------------------
// PerLengthDCLineParameter Queries 
// -----------------------------------------

data class LoadPerLengthDCLineParameterFilter(val perLengthDCLineParameterId :  UUID? = null )

class FindPerLengthDCLineParameterQuery(val filter: LoadPerLengthDCLineParameterFilter = LoadPerLengthDCLineParameterFilter()) {
    override fun toString(): String = "LoadPerLengthDCLineParameterQuery"
}

class FindAllPerLengthDCLineParameterQuery() {
    override fun toString(): String = "LoadAllPerLengthDCLineParameterQuery"
}

data class PerLengthDCLineParameterFetchOneSummary(@Id var perLengthDCLineParameterId : UUID? = null) {
}





// -----------------------------------------
// PetersenCoil Queries 
// -----------------------------------------

data class LoadPetersenCoilFilter(val petersenCoilId :  UUID? = null )

class FindPetersenCoilQuery(val filter: LoadPetersenCoilFilter = LoadPetersenCoilFilter()) {
    override fun toString(): String = "LoadPetersenCoilQuery"
}

class FindAllPetersenCoilQuery() {
    override fun toString(): String = "LoadAllPetersenCoilQuery"
}

data class PetersenCoilFetchOneSummary(@Id var petersenCoilId : UUID? = null) {
}





// -----------------------------------------
// PhaseTapChanger Queries 
// -----------------------------------------

data class LoadPhaseTapChangerFilter(val phaseTapChangerId :  UUID? = null )

class FindPhaseTapChangerQuery(val filter: LoadPhaseTapChangerFilter = LoadPhaseTapChangerFilter()) {
    override fun toString(): String = "LoadPhaseTapChangerQuery"
}

class FindAllPhaseTapChangerQuery() {
    override fun toString(): String = "LoadAllPhaseTapChangerQuery"
}

data class PhaseTapChangerFetchOneSummary(@Id var phaseTapChangerId : UUID? = null) {
}





// -----------------------------------------
// PhaseTapChangerAsymmetrical Queries 
// -----------------------------------------

data class LoadPhaseTapChangerAsymmetricalFilter(val phaseTapChangerAsymmetricalId :  UUID? = null )

class FindPhaseTapChangerAsymmetricalQuery(val filter: LoadPhaseTapChangerAsymmetricalFilter = LoadPhaseTapChangerAsymmetricalFilter()) {
    override fun toString(): String = "LoadPhaseTapChangerAsymmetricalQuery"
}

class FindAllPhaseTapChangerAsymmetricalQuery() {
    override fun toString(): String = "LoadAllPhaseTapChangerAsymmetricalQuery"
}

data class PhaseTapChangerAsymmetricalFetchOneSummary(@Id var phaseTapChangerAsymmetricalId : UUID? = null) {
}





// -----------------------------------------
// PhaseTapChangerLinear Queries 
// -----------------------------------------

data class LoadPhaseTapChangerLinearFilter(val phaseTapChangerLinearId :  UUID? = null )

class FindPhaseTapChangerLinearQuery(val filter: LoadPhaseTapChangerLinearFilter = LoadPhaseTapChangerLinearFilter()) {
    override fun toString(): String = "LoadPhaseTapChangerLinearQuery"
}

class FindAllPhaseTapChangerLinearQuery() {
    override fun toString(): String = "LoadAllPhaseTapChangerLinearQuery"
}

data class PhaseTapChangerLinearFetchOneSummary(@Id var phaseTapChangerLinearId : UUID? = null) {
}





// -----------------------------------------
// PhaseTapChangerNonLinear Queries 
// -----------------------------------------

data class LoadPhaseTapChangerNonLinearFilter(val phaseTapChangerNonLinearId :  UUID? = null )

class FindPhaseTapChangerNonLinearQuery(val filter: LoadPhaseTapChangerNonLinearFilter = LoadPhaseTapChangerNonLinearFilter()) {
    override fun toString(): String = "LoadPhaseTapChangerNonLinearQuery"
}

class FindAllPhaseTapChangerNonLinearQuery() {
    override fun toString(): String = "LoadAllPhaseTapChangerNonLinearQuery"
}

data class PhaseTapChangerNonLinearFetchOneSummary(@Id var phaseTapChangerNonLinearId : UUID? = null) {
}





// -----------------------------------------
// PhaseTapChangerSymmetrical Queries 
// -----------------------------------------

data class LoadPhaseTapChangerSymmetricalFilter(val phaseTapChangerSymmetricalId :  UUID? = null )

class FindPhaseTapChangerSymmetricalQuery(val filter: LoadPhaseTapChangerSymmetricalFilter = LoadPhaseTapChangerSymmetricalFilter()) {
    override fun toString(): String = "LoadPhaseTapChangerSymmetricalQuery"
}

class FindAllPhaseTapChangerSymmetricalQuery() {
    override fun toString(): String = "LoadAllPhaseTapChangerSymmetricalQuery"
}

data class PhaseTapChangerSymmetricalFetchOneSummary(@Id var phaseTapChangerSymmetricalId : UUID? = null) {
}





// -----------------------------------------
// PhaseTapChangerTable Queries 
// -----------------------------------------

data class LoadPhaseTapChangerTableFilter(val phaseTapChangerTableId :  UUID? = null )

class FindPhaseTapChangerTableQuery(val filter: LoadPhaseTapChangerTableFilter = LoadPhaseTapChangerTableFilter()) {
    override fun toString(): String = "LoadPhaseTapChangerTableQuery"
}

class FindAllPhaseTapChangerTableQuery() {
    override fun toString(): String = "LoadAllPhaseTapChangerTableQuery"
}

data class PhaseTapChangerTableFetchOneSummary(@Id var phaseTapChangerTableId : UUID? = null) {
}





// -----------------------------------------
// PhaseTapChangerTablePoint Queries 
// -----------------------------------------

data class LoadPhaseTapChangerTablePointFilter(val phaseTapChangerTablePointId :  UUID? = null )

class FindPhaseTapChangerTablePointQuery(val filter: LoadPhaseTapChangerTablePointFilter = LoadPhaseTapChangerTablePointFilter()) {
    override fun toString(): String = "LoadPhaseTapChangerTablePointQuery"
}

class FindAllPhaseTapChangerTablePointQuery() {
    override fun toString(): String = "LoadAllPhaseTapChangerTablePointQuery"
}

data class PhaseTapChangerTablePointFetchOneSummary(@Id var phaseTapChangerTablePointId : UUID? = null) {
}





// -----------------------------------------
// PhaseTapChangerTabular Queries 
// -----------------------------------------

data class LoadPhaseTapChangerTabularFilter(val phaseTapChangerTabularId :  UUID? = null )

class FindPhaseTapChangerTabularQuery(val filter: LoadPhaseTapChangerTabularFilter = LoadPhaseTapChangerTabularFilter()) {
    override fun toString(): String = "LoadPhaseTapChangerTabularQuery"
}

class FindAllPhaseTapChangerTabularQuery() {
    override fun toString(): String = "LoadAllPhaseTapChangerTabularQuery"
}

data class PhaseTapChangerTabularFetchOneSummary(@Id var phaseTapChangerTabularId : UUID? = null) {
}





// -----------------------------------------
// PositionPoint Queries 
// -----------------------------------------

data class LoadPositionPointFilter(val positionPointId :  UUID? = null )

class FindPositionPointQuery(val filter: LoadPositionPointFilter = LoadPositionPointFilter()) {
    override fun toString(): String = "LoadPositionPointQuery"
}

class FindAllPositionPointQuery() {
    override fun toString(): String = "LoadAllPositionPointQuery"
}

data class PositionPointFetchOneSummary(@Id var positionPointId : UUID? = null) {
}





// -----------------------------------------
// PowerSystemResource Queries 
// -----------------------------------------

data class LoadPowerSystemResourceFilter(val powerSystemResourceId :  UUID? = null )

class FindPowerSystemResourceQuery(val filter: LoadPowerSystemResourceFilter = LoadPowerSystemResourceFilter()) {
    override fun toString(): String = "LoadPowerSystemResourceQuery"
}

class FindAllPowerSystemResourceQuery() {
    override fun toString(): String = "LoadAllPowerSystemResourceQuery"
}

data class PowerSystemResourceFetchOneSummary(@Id var powerSystemResourceId : UUID? = null) {
}





// -----------------------------------------
// PowerSystemStabilizerDynamics Queries 
// -----------------------------------------

data class LoadPowerSystemStabilizerDynamicsFilter(val powerSystemStabilizerDynamicsId :  UUID? = null )

class FindPowerSystemStabilizerDynamicsQuery(val filter: LoadPowerSystemStabilizerDynamicsFilter = LoadPowerSystemStabilizerDynamicsFilter()) {
    override fun toString(): String = "LoadPowerSystemStabilizerDynamicsQuery"
}

class FindAllPowerSystemStabilizerDynamicsQuery() {
    override fun toString(): String = "LoadAllPowerSystemStabilizerDynamicsQuery"
}

data class PowerSystemStabilizerDynamicsFetchOneSummary(@Id var powerSystemStabilizerDynamicsId : UUID? = null) {
}





// -----------------------------------------
// PowerSystemStabilizerUserDefined Queries 
// -----------------------------------------

data class LoadPowerSystemStabilizerUserDefinedFilter(val powerSystemStabilizerUserDefinedId :  UUID? = null )

class FindPowerSystemStabilizerUserDefinedQuery(val filter: LoadPowerSystemStabilizerUserDefinedFilter = LoadPowerSystemStabilizerUserDefinedFilter()) {
    override fun toString(): String = "LoadPowerSystemStabilizerUserDefinedQuery"
}

class FindAllPowerSystemStabilizerUserDefinedQuery() {
    override fun toString(): String = "LoadAllPowerSystemStabilizerUserDefinedQuery"
}

data class PowerSystemStabilizerUserDefinedFetchOneSummary(@Id var powerSystemStabilizerUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// PowerTransformer Queries 
// -----------------------------------------

data class LoadPowerTransformerFilter(val powerTransformerId :  UUID? = null )

class FindPowerTransformerQuery(val filter: LoadPowerTransformerFilter = LoadPowerTransformerFilter()) {
    override fun toString(): String = "LoadPowerTransformerQuery"
}

class FindAllPowerTransformerQuery() {
    override fun toString(): String = "LoadAllPowerTransformerQuery"
}

data class PowerTransformerFetchOneSummary(@Id var powerTransformerId : UUID? = null) {
}





// -----------------------------------------
// PowerTransformerEnd Queries 
// -----------------------------------------

data class LoadPowerTransformerEndFilter(val powerTransformerEndId :  UUID? = null )

class FindPowerTransformerEndQuery(val filter: LoadPowerTransformerEndFilter = LoadPowerTransformerEndFilter()) {
    override fun toString(): String = "LoadPowerTransformerEndQuery"
}

class FindAllPowerTransformerEndQuery() {
    override fun toString(): String = "LoadAllPowerTransformerEndQuery"
}

data class PowerTransformerEndFetchOneSummary(@Id var powerTransformerEndId : UUID? = null) {
}





// -----------------------------------------
// ProprietaryParameterDynamics Queries 
// -----------------------------------------

data class LoadProprietaryParameterDynamicsFilter(val proprietaryParameterDynamicsId :  UUID? = null )

class FindProprietaryParameterDynamicsQuery(val filter: LoadProprietaryParameterDynamicsFilter = LoadProprietaryParameterDynamicsFilter()) {
    override fun toString(): String = "LoadProprietaryParameterDynamicsQuery"
}

class FindAllProprietaryParameterDynamicsQuery() {
    override fun toString(): String = "LoadAllProprietaryParameterDynamicsQuery"
}

data class ProprietaryParameterDynamicsFetchOneSummary(@Id var proprietaryParameterDynamicsId : UUID? = null) {
}





// -----------------------------------------
// ProtectedSwitch Queries 
// -----------------------------------------

data class LoadProtectedSwitchFilter(val protectedSwitchId :  UUID? = null )

class FindProtectedSwitchQuery(val filter: LoadProtectedSwitchFilter = LoadProtectedSwitchFilter()) {
    override fun toString(): String = "LoadProtectedSwitchQuery"
}

class FindAllProtectedSwitchQuery() {
    override fun toString(): String = "LoadAllProtectedSwitchQuery"
}

data class ProtectedSwitchFetchOneSummary(@Id var protectedSwitchId : UUID? = null) {
}





// -----------------------------------------
// Pss1 Queries 
// -----------------------------------------

data class LoadPss1Filter(val pss1Id :  UUID? = null )

class FindPss1Query(val filter: LoadPss1Filter = LoadPss1Filter()) {
    override fun toString(): String = "LoadPss1Query"
}

class FindAllPss1Query() {
    override fun toString(): String = "LoadAllPss1Query"
}

data class Pss1FetchOneSummary(@Id var pss1Id : UUID? = null) {
}





// -----------------------------------------
// Pss1A Queries 
// -----------------------------------------

data class LoadPss1AFilter(val pss1AId :  UUID? = null )

class FindPss1AQuery(val filter: LoadPss1AFilter = LoadPss1AFilter()) {
    override fun toString(): String = "LoadPss1AQuery"
}

class FindAllPss1AQuery() {
    override fun toString(): String = "LoadAllPss1AQuery"
}

data class Pss1AFetchOneSummary(@Id var pss1AId : UUID? = null) {
}





// -----------------------------------------
// Pss2B Queries 
// -----------------------------------------

data class LoadPss2BFilter(val pss2BId :  UUID? = null )

class FindPss2BQuery(val filter: LoadPss2BFilter = LoadPss2BFilter()) {
    override fun toString(): String = "LoadPss2BQuery"
}

class FindAllPss2BQuery() {
    override fun toString(): String = "LoadAllPss2BQuery"
}

data class Pss2BFetchOneSummary(@Id var pss2BId : UUID? = null) {
}





// -----------------------------------------
// Pss2ST Queries 
// -----------------------------------------

data class LoadPss2STFilter(val pss2STId :  UUID? = null )

class FindPss2STQuery(val filter: LoadPss2STFilter = LoadPss2STFilter()) {
    override fun toString(): String = "LoadPss2STQuery"
}

class FindAllPss2STQuery() {
    override fun toString(): String = "LoadAllPss2STQuery"
}

data class Pss2STFetchOneSummary(@Id var pss2STId : UUID? = null) {
}





// -----------------------------------------
// Pss5 Queries 
// -----------------------------------------

data class LoadPss5Filter(val pss5Id :  UUID? = null )

class FindPss5Query(val filter: LoadPss5Filter = LoadPss5Filter()) {
    override fun toString(): String = "LoadPss5Query"
}

class FindAllPss5Query() {
    override fun toString(): String = "LoadAllPss5Query"
}

data class Pss5FetchOneSummary(@Id var pss5Id : UUID? = null) {
}





// -----------------------------------------
// PssELIN2 Queries 
// -----------------------------------------

data class LoadPssELIN2Filter(val pssELIN2Id :  UUID? = null )

class FindPssELIN2Query(val filter: LoadPssELIN2Filter = LoadPssELIN2Filter()) {
    override fun toString(): String = "LoadPssELIN2Query"
}

class FindAllPssELIN2Query() {
    override fun toString(): String = "LoadAllPssELIN2Query"
}

data class PssELIN2FetchOneSummary(@Id var pssELIN2Id : UUID? = null) {
}





// -----------------------------------------
// PssIEEE1A Queries 
// -----------------------------------------

data class LoadPssIEEE1AFilter(val pssIEEE1AId :  UUID? = null )

class FindPssIEEE1AQuery(val filter: LoadPssIEEE1AFilter = LoadPssIEEE1AFilter()) {
    override fun toString(): String = "LoadPssIEEE1AQuery"
}

class FindAllPssIEEE1AQuery() {
    override fun toString(): String = "LoadAllPssIEEE1AQuery"
}

data class PssIEEE1AFetchOneSummary(@Id var pssIEEE1AId : UUID? = null) {
}





// -----------------------------------------
// PssIEEE2B Queries 
// -----------------------------------------

data class LoadPssIEEE2BFilter(val pssIEEE2BId :  UUID? = null )

class FindPssIEEE2BQuery(val filter: LoadPssIEEE2BFilter = LoadPssIEEE2BFilter()) {
    override fun toString(): String = "LoadPssIEEE2BQuery"
}

class FindAllPssIEEE2BQuery() {
    override fun toString(): String = "LoadAllPssIEEE2BQuery"
}

data class PssIEEE2BFetchOneSummary(@Id var pssIEEE2BId : UUID? = null) {
}





// -----------------------------------------
// PssIEEE3B Queries 
// -----------------------------------------

data class LoadPssIEEE3BFilter(val pssIEEE3BId :  UUID? = null )

class FindPssIEEE3BQuery(val filter: LoadPssIEEE3BFilter = LoadPssIEEE3BFilter()) {
    override fun toString(): String = "LoadPssIEEE3BQuery"
}

class FindAllPssIEEE3BQuery() {
    override fun toString(): String = "LoadAllPssIEEE3BQuery"
}

data class PssIEEE3BFetchOneSummary(@Id var pssIEEE3BId : UUID? = null) {
}





// -----------------------------------------
// PssIEEE4B Queries 
// -----------------------------------------

data class LoadPssIEEE4BFilter(val pssIEEE4BId :  UUID? = null )

class FindPssIEEE4BQuery(val filter: LoadPssIEEE4BFilter = LoadPssIEEE4BFilter()) {
    override fun toString(): String = "LoadPssIEEE4BQuery"
}

class FindAllPssIEEE4BQuery() {
    override fun toString(): String = "LoadAllPssIEEE4BQuery"
}

data class PssIEEE4BFetchOneSummary(@Id var pssIEEE4BId : UUID? = null) {
}





// -----------------------------------------
// PssPTIST1 Queries 
// -----------------------------------------

data class LoadPssPTIST1Filter(val pssPTIST1Id :  UUID? = null )

class FindPssPTIST1Query(val filter: LoadPssPTIST1Filter = LoadPssPTIST1Filter()) {
    override fun toString(): String = "LoadPssPTIST1Query"
}

class FindAllPssPTIST1Query() {
    override fun toString(): String = "LoadAllPssPTIST1Query"
}

data class PssPTIST1FetchOneSummary(@Id var pssPTIST1Id : UUID? = null) {
}





// -----------------------------------------
// PssPTIST3 Queries 
// -----------------------------------------

data class LoadPssPTIST3Filter(val pssPTIST3Id :  UUID? = null )

class FindPssPTIST3Query(val filter: LoadPssPTIST3Filter = LoadPssPTIST3Filter()) {
    override fun toString(): String = "LoadPssPTIST3Query"
}

class FindAllPssPTIST3Query() {
    override fun toString(): String = "LoadAllPssPTIST3Query"
}

data class PssPTIST3FetchOneSummary(@Id var pssPTIST3Id : UUID? = null) {
}





// -----------------------------------------
// PssSB4 Queries 
// -----------------------------------------

data class LoadPssSB4Filter(val pssSB4Id :  UUID? = null )

class FindPssSB4Query(val filter: LoadPssSB4Filter = LoadPssSB4Filter()) {
    override fun toString(): String = "LoadPssSB4Query"
}

class FindAllPssSB4Query() {
    override fun toString(): String = "LoadAllPssSB4Query"
}

data class PssSB4FetchOneSummary(@Id var pssSB4Id : UUID? = null) {
}





// -----------------------------------------
// PssSH Queries 
// -----------------------------------------

data class LoadPssSHFilter(val pssSHId :  UUID? = null )

class FindPssSHQuery(val filter: LoadPssSHFilter = LoadPssSHFilter()) {
    override fun toString(): String = "LoadPssSHQuery"
}

class FindAllPssSHQuery() {
    override fun toString(): String = "LoadAllPssSHQuery"
}

data class PssSHFetchOneSummary(@Id var pssSHId : UUID? = null) {
}





// -----------------------------------------
// PssSK Queries 
// -----------------------------------------

data class LoadPssSKFilter(val pssSKId :  UUID? = null )

class FindPssSKQuery(val filter: LoadPssSKFilter = LoadPssSKFilter()) {
    override fun toString(): String = "LoadPssSKQuery"
}

class FindAllPssSKQuery() {
    override fun toString(): String = "LoadAllPssSKQuery"
}

data class PssSKFetchOneSummary(@Id var pssSKId : UUID? = null) {
}





// -----------------------------------------
// PssWECC Queries 
// -----------------------------------------

data class LoadPssWECCFilter(val pssWECCId :  UUID? = null )

class FindPssWECCQuery(val filter: LoadPssWECCFilter = LoadPssWECCFilter()) {
    override fun toString(): String = "LoadPssWECCQuery"
}

class FindAllPssWECCQuery() {
    override fun toString(): String = "LoadAllPssWECCQuery"
}

data class PssWECCFetchOneSummary(@Id var pssWECCId : UUID? = null) {
}





// -----------------------------------------
// Quality61850 Queries 
// -----------------------------------------

data class LoadQuality61850Filter(val quality61850Id :  UUID? = null )

class FindQuality61850Query(val filter: LoadQuality61850Filter = LoadQuality61850Filter()) {
    override fun toString(): String = "LoadQuality61850Query"
}

class FindAllQuality61850Query() {
    override fun toString(): String = "LoadAllQuality61850Query"
}

data class Quality61850FetchOneSummary(@Id var quality61850Id : UUID? = null) {
}





// -----------------------------------------
// RaiseLowerCommand Queries 
// -----------------------------------------

data class LoadRaiseLowerCommandFilter(val raiseLowerCommandId :  UUID? = null )

class FindRaiseLowerCommandQuery(val filter: LoadRaiseLowerCommandFilter = LoadRaiseLowerCommandFilter()) {
    override fun toString(): String = "LoadRaiseLowerCommandQuery"
}

class FindAllRaiseLowerCommandQuery() {
    override fun toString(): String = "LoadAllRaiseLowerCommandQuery"
}

data class RaiseLowerCommandFetchOneSummary(@Id var raiseLowerCommandId : UUID? = null) {
}





// -----------------------------------------
// RatioTapChanger Queries 
// -----------------------------------------

data class LoadRatioTapChangerFilter(val ratioTapChangerId :  UUID? = null )

class FindRatioTapChangerQuery(val filter: LoadRatioTapChangerFilter = LoadRatioTapChangerFilter()) {
    override fun toString(): String = "LoadRatioTapChangerQuery"
}

class FindAllRatioTapChangerQuery() {
    override fun toString(): String = "LoadAllRatioTapChangerQuery"
}

data class RatioTapChangerFetchOneSummary(@Id var ratioTapChangerId : UUID? = null) {
}





// -----------------------------------------
// RatioTapChangerTable Queries 
// -----------------------------------------

data class LoadRatioTapChangerTableFilter(val ratioTapChangerTableId :  UUID? = null )

class FindRatioTapChangerTableQuery(val filter: LoadRatioTapChangerTableFilter = LoadRatioTapChangerTableFilter()) {
    override fun toString(): String = "LoadRatioTapChangerTableQuery"
}

class FindAllRatioTapChangerTableQuery() {
    override fun toString(): String = "LoadAllRatioTapChangerTableQuery"
}

data class RatioTapChangerTableFetchOneSummary(@Id var ratioTapChangerTableId : UUID? = null) {
}





// -----------------------------------------
// RatioTapChangerTablePoint Queries 
// -----------------------------------------

data class LoadRatioTapChangerTablePointFilter(val ratioTapChangerTablePointId :  UUID? = null )

class FindRatioTapChangerTablePointQuery(val filter: LoadRatioTapChangerTablePointFilter = LoadRatioTapChangerTablePointFilter()) {
    override fun toString(): String = "LoadRatioTapChangerTablePointQuery"
}

class FindAllRatioTapChangerTablePointQuery() {
    override fun toString(): String = "LoadAllRatioTapChangerTablePointQuery"
}

data class RatioTapChangerTablePointFetchOneSummary(@Id var ratioTapChangerTablePointId : UUID? = null) {
}





// -----------------------------------------
// Reactance Queries 
// -----------------------------------------

data class LoadReactanceFilter(val reactanceId :  UUID? = null )

class FindReactanceQuery(val filter: LoadReactanceFilter = LoadReactanceFilter()) {
    override fun toString(): String = "LoadReactanceQuery"
}

class FindAllReactanceQuery() {
    override fun toString(): String = "LoadAllReactanceQuery"
}

data class ReactanceFetchOneSummary(@Id var reactanceId : UUID? = null) {
}





// -----------------------------------------
// ReactiveCapabilityCurve Queries 
// -----------------------------------------

data class LoadReactiveCapabilityCurveFilter(val reactiveCapabilityCurveId :  UUID? = null )

class FindReactiveCapabilityCurveQuery(val filter: LoadReactiveCapabilityCurveFilter = LoadReactiveCapabilityCurveFilter()) {
    override fun toString(): String = "LoadReactiveCapabilityCurveQuery"
}

class FindAllReactiveCapabilityCurveQuery() {
    override fun toString(): String = "LoadAllReactiveCapabilityCurveQuery"
}

data class ReactiveCapabilityCurveFetchOneSummary(@Id var reactiveCapabilityCurveId : UUID? = null) {
}





// -----------------------------------------
// ReactivePower Queries 
// -----------------------------------------

data class LoadReactivePowerFilter(val reactivePowerId :  UUID? = null )

class FindReactivePowerQuery(val filter: LoadReactivePowerFilter = LoadReactivePowerFilter()) {
    override fun toString(): String = "LoadReactivePowerQuery"
}

class FindAllReactivePowerQuery() {
    override fun toString(): String = "LoadAllReactivePowerQuery"
}

data class ReactivePowerFetchOneSummary(@Id var reactivePowerId : UUID? = null) {
}





// -----------------------------------------
// RegularIntervalSchedule Queries 
// -----------------------------------------

data class LoadRegularIntervalScheduleFilter(val regularIntervalScheduleId :  UUID? = null )

class FindRegularIntervalScheduleQuery(val filter: LoadRegularIntervalScheduleFilter = LoadRegularIntervalScheduleFilter()) {
    override fun toString(): String = "LoadRegularIntervalScheduleQuery"
}

class FindAllRegularIntervalScheduleQuery() {
    override fun toString(): String = "LoadAllRegularIntervalScheduleQuery"
}

data class RegularIntervalScheduleFetchOneSummary(@Id var regularIntervalScheduleId : UUID? = null) {
}





// -----------------------------------------
// RegularTimePoint Queries 
// -----------------------------------------

data class LoadRegularTimePointFilter(val regularTimePointId :  UUID? = null )

class FindRegularTimePointQuery(val filter: LoadRegularTimePointFilter = LoadRegularTimePointFilter()) {
    override fun toString(): String = "LoadRegularTimePointQuery"
}

class FindAllRegularTimePointQuery() {
    override fun toString(): String = "LoadAllRegularTimePointQuery"
}

data class RegularTimePointFetchOneSummary(@Id var regularTimePointId : UUID? = null) {
}





// -----------------------------------------
// RegulatingCondEq Queries 
// -----------------------------------------

data class LoadRegulatingCondEqFilter(val regulatingCondEqId :  UUID? = null )

class FindRegulatingCondEqQuery(val filter: LoadRegulatingCondEqFilter = LoadRegulatingCondEqFilter()) {
    override fun toString(): String = "LoadRegulatingCondEqQuery"
}

class FindAllRegulatingCondEqQuery() {
    override fun toString(): String = "LoadAllRegulatingCondEqQuery"
}

data class RegulatingCondEqFetchOneSummary(@Id var regulatingCondEqId : UUID? = null) {
}





// -----------------------------------------
// RegulatingControl Queries 
// -----------------------------------------

data class LoadRegulatingControlFilter(val regulatingControlId :  UUID? = null )

class FindRegulatingControlQuery(val filter: LoadRegulatingControlFilter = LoadRegulatingControlFilter()) {
    override fun toString(): String = "LoadRegulatingControlQuery"
}

class FindAllRegulatingControlQuery() {
    override fun toString(): String = "LoadAllRegulatingControlQuery"
}

data class RegulatingControlFetchOneSummary(@Id var regulatingControlId : UUID? = null) {
}





// -----------------------------------------
// RegulationSchedule Queries 
// -----------------------------------------

data class LoadRegulationScheduleFilter(val regulationScheduleId :  UUID? = null )

class FindRegulationScheduleQuery(val filter: LoadRegulationScheduleFilter = LoadRegulationScheduleFilter()) {
    override fun toString(): String = "LoadRegulationScheduleQuery"
}

class FindAllRegulationScheduleQuery() {
    override fun toString(): String = "LoadAllRegulationScheduleQuery"
}

data class RegulationScheduleFetchOneSummary(@Id var regulationScheduleId : UUID? = null) {
}





// -----------------------------------------
// RemoteInputSignal Queries 
// -----------------------------------------

data class LoadRemoteInputSignalFilter(val remoteInputSignalId :  UUID? = null )

class FindRemoteInputSignalQuery(val filter: LoadRemoteInputSignalFilter = LoadRemoteInputSignalFilter()) {
    override fun toString(): String = "LoadRemoteInputSignalQuery"
}

class FindAllRemoteInputSignalQuery() {
    override fun toString(): String = "LoadAllRemoteInputSignalQuery"
}

data class RemoteInputSignalFetchOneSummary(@Id var remoteInputSignalId : UUID? = null) {
}





// -----------------------------------------
// ReportingGroup Queries 
// -----------------------------------------

data class LoadReportingGroupFilter(val reportingGroupId :  UUID? = null )

class FindReportingGroupQuery(val filter: LoadReportingGroupFilter = LoadReportingGroupFilter()) {
    override fun toString(): String = "LoadReportingGroupQuery"
}

class FindAllReportingGroupQuery() {
    override fun toString(): String = "LoadAllReportingGroupQuery"
}

data class ReportingGroupFetchOneSummary(@Id var reportingGroupId : UUID? = null) {
}





// -----------------------------------------
// Resistance Queries 
// -----------------------------------------

data class LoadResistanceFilter(val resistanceId :  UUID? = null )

class FindResistanceQuery(val filter: LoadResistanceFilter = LoadResistanceFilter()) {
    override fun toString(): String = "LoadResistanceQuery"
}

class FindAllResistanceQuery() {
    override fun toString(): String = "LoadAllResistanceQuery"
}

data class ResistanceFetchOneSummary(@Id var resistanceId : UUID? = null) {
}





// -----------------------------------------
// ResistancePerLength Queries 
// -----------------------------------------

data class LoadResistancePerLengthFilter(val resistancePerLengthId :  UUID? = null )

class FindResistancePerLengthQuery(val filter: LoadResistancePerLengthFilter = LoadResistancePerLengthFilter()) {
    override fun toString(): String = "LoadResistancePerLengthQuery"
}

class FindAllResistancePerLengthQuery() {
    override fun toString(): String = "LoadAllResistancePerLengthQuery"
}

data class ResistancePerLengthFetchOneSummary(@Id var resistancePerLengthId : UUID? = null) {
}





// -----------------------------------------
// RotatingMachine Queries 
// -----------------------------------------

data class LoadRotatingMachineFilter(val rotatingMachineId :  UUID? = null )

class FindRotatingMachineQuery(val filter: LoadRotatingMachineFilter = LoadRotatingMachineFilter()) {
    override fun toString(): String = "LoadRotatingMachineQuery"
}

class FindAllRotatingMachineQuery() {
    override fun toString(): String = "LoadAllRotatingMachineQuery"
}

data class RotatingMachineFetchOneSummary(@Id var rotatingMachineId : UUID? = null) {
}





// -----------------------------------------
// RotatingMachineDynamics Queries 
// -----------------------------------------

data class LoadRotatingMachineDynamicsFilter(val rotatingMachineDynamicsId :  UUID? = null )

class FindRotatingMachineDynamicsQuery(val filter: LoadRotatingMachineDynamicsFilter = LoadRotatingMachineDynamicsFilter()) {
    override fun toString(): String = "LoadRotatingMachineDynamicsQuery"
}

class FindAllRotatingMachineDynamicsQuery() {
    override fun toString(): String = "LoadAllRotatingMachineDynamicsQuery"
}

data class RotatingMachineDynamicsFetchOneSummary(@Id var rotatingMachineDynamicsId : UUID? = null) {
}





// -----------------------------------------
// RotationSpeed Queries 
// -----------------------------------------

data class LoadRotationSpeedFilter(val rotationSpeedId :  UUID? = null )

class FindRotationSpeedQuery(val filter: LoadRotationSpeedFilter = LoadRotationSpeedFilter()) {
    override fun toString(): String = "LoadRotationSpeedQuery"
}

class FindAllRotationSpeedQuery() {
    override fun toString(): String = "LoadAllRotationSpeedQuery"
}

data class RotationSpeedFetchOneSummary(@Id var rotationSpeedId : UUID? = null) {
}





// -----------------------------------------
// Season Queries 
// -----------------------------------------

data class LoadSeasonFilter(val seasonId :  UUID? = null )

class FindSeasonQuery(val filter: LoadSeasonFilter = LoadSeasonFilter()) {
    override fun toString(): String = "LoadSeasonQuery"
}

class FindAllSeasonQuery() {
    override fun toString(): String = "LoadAllSeasonQuery"
}

data class SeasonFetchOneSummary(@Id var seasonId : UUID? = null) {
}





// -----------------------------------------
// SeasonDayTypeSchedule Queries 
// -----------------------------------------

data class LoadSeasonDayTypeScheduleFilter(val seasonDayTypeScheduleId :  UUID? = null )

class FindSeasonDayTypeScheduleQuery(val filter: LoadSeasonDayTypeScheduleFilter = LoadSeasonDayTypeScheduleFilter()) {
    override fun toString(): String = "LoadSeasonDayTypeScheduleQuery"
}

class FindAllSeasonDayTypeScheduleQuery() {
    override fun toString(): String = "LoadAllSeasonDayTypeScheduleQuery"
}

data class SeasonDayTypeScheduleFetchOneSummary(@Id var seasonDayTypeScheduleId : UUID? = null) {
}





// -----------------------------------------
// Seconds Queries 
// -----------------------------------------

data class LoadSecondsFilter(val secondsId :  UUID? = null )

class FindSecondsQuery(val filter: LoadSecondsFilter = LoadSecondsFilter()) {
    override fun toString(): String = "LoadSecondsQuery"
}

class FindAllSecondsQuery() {
    override fun toString(): String = "LoadAllSecondsQuery"
}

data class SecondsFetchOneSummary(@Id var secondsId : UUID? = null) {
}





// -----------------------------------------
// SeriesCompensator Queries 
// -----------------------------------------

data class LoadSeriesCompensatorFilter(val seriesCompensatorId :  UUID? = null )

class FindSeriesCompensatorQuery(val filter: LoadSeriesCompensatorFilter = LoadSeriesCompensatorFilter()) {
    override fun toString(): String = "LoadSeriesCompensatorQuery"
}

class FindAllSeriesCompensatorQuery() {
    override fun toString(): String = "LoadAllSeriesCompensatorQuery"
}

data class SeriesCompensatorFetchOneSummary(@Id var seriesCompensatorId : UUID? = null) {
}





// -----------------------------------------
// SetPoint Queries 
// -----------------------------------------

data class LoadSetPointFilter(val setPointId :  UUID? = null )

class FindSetPointQuery(val filter: LoadSetPointFilter = LoadSetPointFilter()) {
    override fun toString(): String = "LoadSetPointQuery"
}

class FindAllSetPointQuery() {
    override fun toString(): String = "LoadAllSetPointQuery"
}

data class SetPointFetchOneSummary(@Id var setPointId : UUID? = null) {
}





// -----------------------------------------
// ShuntCompensator Queries 
// -----------------------------------------

data class LoadShuntCompensatorFilter(val shuntCompensatorId :  UUID? = null )

class FindShuntCompensatorQuery(val filter: LoadShuntCompensatorFilter = LoadShuntCompensatorFilter()) {
    override fun toString(): String = "LoadShuntCompensatorQuery"
}

class FindAllShuntCompensatorQuery() {
    override fun toString(): String = "LoadAllShuntCompensatorQuery"
}

data class ShuntCompensatorFetchOneSummary(@Id var shuntCompensatorId : UUID? = null) {
}





// -----------------------------------------
// Simple_Float Queries 
// -----------------------------------------

data class LoadSimple_FloatFilter(val simple_FloatId :  UUID? = null )

class FindSimple_FloatQuery(val filter: LoadSimple_FloatFilter = LoadSimple_FloatFilter()) {
    override fun toString(): String = "LoadSimple_FloatQuery"
}

class FindAllSimple_FloatQuery() {
    override fun toString(): String = "LoadAllSimple_FloatQuery"
}

data class Simple_FloatFetchOneSummary(@Id var simple_FloatId : UUID? = null) {
}





// -----------------------------------------
// SolarGeneratingUnit Queries 
// -----------------------------------------

data class LoadSolarGeneratingUnitFilter(val solarGeneratingUnitId :  UUID? = null )

class FindSolarGeneratingUnitQuery(val filter: LoadSolarGeneratingUnitFilter = LoadSolarGeneratingUnitFilter()) {
    override fun toString(): String = "LoadSolarGeneratingUnitQuery"
}

class FindAllSolarGeneratingUnitQuery() {
    override fun toString(): String = "LoadAllSolarGeneratingUnitQuery"
}

data class SolarGeneratingUnitFetchOneSummary(@Id var solarGeneratingUnitId : UUID? = null) {
}





// -----------------------------------------
// StateVariablesVersion Queries 
// -----------------------------------------

data class LoadStateVariablesVersionFilter(val stateVariablesVersionId :  UUID? = null )

class FindStateVariablesVersionQuery(val filter: LoadStateVariablesVersionFilter = LoadStateVariablesVersionFilter()) {
    override fun toString(): String = "LoadStateVariablesVersionQuery"
}

class FindAllStateVariablesVersionQuery() {
    override fun toString(): String = "LoadAllStateVariablesVersionQuery"
}

data class StateVariablesVersionFetchOneSummary(@Id var stateVariablesVersionId : UUID? = null) {
}





// -----------------------------------------
// StaticVarCompensator Queries 
// -----------------------------------------

data class LoadStaticVarCompensatorFilter(val staticVarCompensatorId :  UUID? = null )

class FindStaticVarCompensatorQuery(val filter: LoadStaticVarCompensatorFilter = LoadStaticVarCompensatorFilter()) {
    override fun toString(): String = "LoadStaticVarCompensatorQuery"
}

class FindAllStaticVarCompensatorQuery() {
    override fun toString(): String = "LoadAllStaticVarCompensatorQuery"
}

data class StaticVarCompensatorFetchOneSummary(@Id var staticVarCompensatorId : UUID? = null) {
}





// -----------------------------------------
// Staticpowersystemmodel Queries 
// -----------------------------------------

data class LoadStaticpowersystemmodelFilter(val staticpowersystemmodelId :  UUID? = null )

class FindStaticpowersystemmodelQuery(val filter: LoadStaticpowersystemmodelFilter = LoadStaticpowersystemmodelFilter()) {
    override fun toString(): String = "LoadStaticpowersystemmodelQuery"
}

class FindAllStaticpowersystemmodelQuery() {
    override fun toString(): String = "LoadAllStaticpowersystemmodelQuery"
}

data class StaticpowersystemmodelFetchOneSummary(@Id var staticpowersystemmodelId : UUID? = null) {
}





// -----------------------------------------
// StationSupply Queries 
// -----------------------------------------

data class LoadStationSupplyFilter(val stationSupplyId :  UUID? = null )

class FindStationSupplyQuery(val filter: LoadStationSupplyFilter = LoadStationSupplyFilter()) {
    override fun toString(): String = "LoadStationSupplyQuery"
}

class FindAllStationSupplyQuery() {
    override fun toString(): String = "LoadAllStationSupplyQuery"
}

data class StationSupplyFetchOneSummary(@Id var stationSupplyId : UUID? = null) {
}





// -----------------------------------------
// SteadyStateHypothesisVersion Queries 
// -----------------------------------------

data class LoadSteadyStateHypothesisVersionFilter(val steadyStateHypothesisVersionId :  UUID? = null )

class FindSteadyStateHypothesisVersionQuery(val filter: LoadSteadyStateHypothesisVersionFilter = LoadSteadyStateHypothesisVersionFilter()) {
    override fun toString(): String = "LoadSteadyStateHypothesisVersionQuery"
}

class FindAllSteadyStateHypothesisVersionQuery() {
    override fun toString(): String = "LoadAllSteadyStateHypothesisVersionQuery"
}

data class SteadyStateHypothesisVersionFetchOneSummary(@Id var steadyStateHypothesisVersionId : UUID? = null) {
}





// -----------------------------------------
// StringMeasurement Queries 
// -----------------------------------------

data class LoadStringMeasurementFilter(val stringMeasurementId :  UUID? = null )

class FindStringMeasurementQuery(val filter: LoadStringMeasurementFilter = LoadStringMeasurementFilter()) {
    override fun toString(): String = "LoadStringMeasurementQuery"
}

class FindAllStringMeasurementQuery() {
    override fun toString(): String = "LoadAllStringMeasurementQuery"
}

data class StringMeasurementFetchOneSummary(@Id var stringMeasurementId : UUID? = null) {
}





// -----------------------------------------
// StringMeasurementValue Queries 
// -----------------------------------------

data class LoadStringMeasurementValueFilter(val stringMeasurementValueId :  UUID? = null )

class FindStringMeasurementValueQuery(val filter: LoadStringMeasurementValueFilter = LoadStringMeasurementValueFilter()) {
    override fun toString(): String = "LoadStringMeasurementValueQuery"
}

class FindAllStringMeasurementValueQuery() {
    override fun toString(): String = "LoadAllStringMeasurementValueQuery"
}

data class StringMeasurementValueFetchOneSummary(@Id var stringMeasurementValueId : UUID? = null) {
}





// -----------------------------------------
// StringProxy Queries 
// -----------------------------------------

data class LoadStringProxyFilter(val stringProxyId :  UUID? = null )

class FindStringProxyQuery(val filter: LoadStringProxyFilter = LoadStringProxyFilter()) {
    override fun toString(): String = "LoadStringProxyQuery"
}

class FindAllStringProxyQuery() {
    override fun toString(): String = "LoadAllStringProxyQuery"
}

data class StringProxyFetchOneSummary(@Id var stringProxyId : UUID? = null) {
}





// -----------------------------------------
// SubGeographicalRegion Queries 
// -----------------------------------------

data class LoadSubGeographicalRegionFilter(val subGeographicalRegionId :  UUID? = null )

class FindSubGeographicalRegionQuery(val filter: LoadSubGeographicalRegionFilter = LoadSubGeographicalRegionFilter()) {
    override fun toString(): String = "LoadSubGeographicalRegionQuery"
}

class FindAllSubGeographicalRegionQuery() {
    override fun toString(): String = "LoadAllSubGeographicalRegionQuery"
}

data class SubGeographicalRegionFetchOneSummary(@Id var subGeographicalRegionId : UUID? = null) {
}





// -----------------------------------------
// SubLoadArea Queries 
// -----------------------------------------

data class LoadSubLoadAreaFilter(val subLoadAreaId :  UUID? = null )

class FindSubLoadAreaQuery(val filter: LoadSubLoadAreaFilter = LoadSubLoadAreaFilter()) {
    override fun toString(): String = "LoadSubLoadAreaQuery"
}

class FindAllSubLoadAreaQuery() {
    override fun toString(): String = "LoadAllSubLoadAreaQuery"
}

data class SubLoadAreaFetchOneSummary(@Id var subLoadAreaId : UUID? = null) {
}





// -----------------------------------------
// Substation Queries 
// -----------------------------------------

data class LoadSubstationFilter(val substationId :  UUID? = null )

class FindSubstationQuery(val filter: LoadSubstationFilter = LoadSubstationFilter()) {
    override fun toString(): String = "LoadSubstationQuery"
}

class FindAllSubstationQuery() {
    override fun toString(): String = "LoadAllSubstationQuery"
}

data class SubstationFetchOneSummary(@Id var substationId : UUID? = null) {
}





// -----------------------------------------
// Susceptance Queries 
// -----------------------------------------

data class LoadSusceptanceFilter(val susceptanceId :  UUID? = null )

class FindSusceptanceQuery(val filter: LoadSusceptanceFilter = LoadSusceptanceFilter()) {
    override fun toString(): String = "LoadSusceptanceQuery"
}

class FindAllSusceptanceQuery() {
    override fun toString(): String = "LoadAllSusceptanceQuery"
}

data class SusceptanceFetchOneSummary(@Id var susceptanceId : UUID? = null) {
}





// -----------------------------------------
// SvInjection Queries 
// -----------------------------------------

data class LoadSvInjectionFilter(val svInjectionId :  UUID? = null )

class FindSvInjectionQuery(val filter: LoadSvInjectionFilter = LoadSvInjectionFilter()) {
    override fun toString(): String = "LoadSvInjectionQuery"
}

class FindAllSvInjectionQuery() {
    override fun toString(): String = "LoadAllSvInjectionQuery"
}

data class SvInjectionFetchOneSummary(@Id var svInjectionId : UUID? = null) {
}





// -----------------------------------------
// SvPowerFlow Queries 
// -----------------------------------------

data class LoadSvPowerFlowFilter(val svPowerFlowId :  UUID? = null )

class FindSvPowerFlowQuery(val filter: LoadSvPowerFlowFilter = LoadSvPowerFlowFilter()) {
    override fun toString(): String = "LoadSvPowerFlowQuery"
}

class FindAllSvPowerFlowQuery() {
    override fun toString(): String = "LoadAllSvPowerFlowQuery"
}

data class SvPowerFlowFetchOneSummary(@Id var svPowerFlowId : UUID? = null) {
}





// -----------------------------------------
// SvShuntCompensatorSections Queries 
// -----------------------------------------

data class LoadSvShuntCompensatorSectionsFilter(val svShuntCompensatorSectionsId :  UUID? = null )

class FindSvShuntCompensatorSectionsQuery(val filter: LoadSvShuntCompensatorSectionsFilter = LoadSvShuntCompensatorSectionsFilter()) {
    override fun toString(): String = "LoadSvShuntCompensatorSectionsQuery"
}

class FindAllSvShuntCompensatorSectionsQuery() {
    override fun toString(): String = "LoadAllSvShuntCompensatorSectionsQuery"
}

data class SvShuntCompensatorSectionsFetchOneSummary(@Id var svShuntCompensatorSectionsId : UUID? = null) {
}





// -----------------------------------------
// SvStatus Queries 
// -----------------------------------------

data class LoadSvStatusFilter(val svStatusId :  UUID? = null )

class FindSvStatusQuery(val filter: LoadSvStatusFilter = LoadSvStatusFilter()) {
    override fun toString(): String = "LoadSvStatusQuery"
}

class FindAllSvStatusQuery() {
    override fun toString(): String = "LoadAllSvStatusQuery"
}

data class SvStatusFetchOneSummary(@Id var svStatusId : UUID? = null) {
}





// -----------------------------------------
// SvTapStep Queries 
// -----------------------------------------

data class LoadSvTapStepFilter(val svTapStepId :  UUID? = null )

class FindSvTapStepQuery(val filter: LoadSvTapStepFilter = LoadSvTapStepFilter()) {
    override fun toString(): String = "LoadSvTapStepQuery"
}

class FindAllSvTapStepQuery() {
    override fun toString(): String = "LoadAllSvTapStepQuery"
}

data class SvTapStepFetchOneSummary(@Id var svTapStepId : UUID? = null) {
}





// -----------------------------------------
// SvVoltage Queries 
// -----------------------------------------

data class LoadSvVoltageFilter(val svVoltageId :  UUID? = null )

class FindSvVoltageQuery(val filter: LoadSvVoltageFilter = LoadSvVoltageFilter()) {
    override fun toString(): String = "LoadSvVoltageQuery"
}

class FindAllSvVoltageQuery() {
    override fun toString(): String = "LoadAllSvVoltageQuery"
}

data class SvVoltageFetchOneSummary(@Id var svVoltageId : UUID? = null) {
}





// -----------------------------------------
// SwitchIt Queries 
// -----------------------------------------

data class LoadSwitchItFilter(val switchItId :  UUID? = null )

class FindSwitchItQuery(val filter: LoadSwitchItFilter = LoadSwitchItFilter()) {
    override fun toString(): String = "LoadSwitchItQuery"
}

class FindAllSwitchItQuery() {
    override fun toString(): String = "LoadAllSwitchItQuery"
}

data class SwitchItFetchOneSummary(@Id var switchItId : UUID? = null) {
}





// -----------------------------------------
// SwitchProxy Queries 
// -----------------------------------------

data class LoadSwitchProxyFilter(val switchProxyId :  UUID? = null )

class FindSwitchProxyQuery(val filter: LoadSwitchProxyFilter = LoadSwitchProxyFilter()) {
    override fun toString(): String = "LoadSwitchProxyQuery"
}

class FindAllSwitchProxyQuery() {
    override fun toString(): String = "LoadAllSwitchProxyQuery"
}

data class SwitchProxyFetchOneSummary(@Id var switchProxyId : UUID? = null) {
}





// -----------------------------------------
// SwitchSchedule Queries 
// -----------------------------------------

data class LoadSwitchScheduleFilter(val switchScheduleId :  UUID? = null )

class FindSwitchScheduleQuery(val filter: LoadSwitchScheduleFilter = LoadSwitchScheduleFilter()) {
    override fun toString(): String = "LoadSwitchScheduleQuery"
}

class FindAllSwitchScheduleQuery() {
    override fun toString(): String = "LoadAllSwitchScheduleQuery"
}

data class SwitchScheduleFetchOneSummary(@Id var switchScheduleId : UUID? = null) {
}





// -----------------------------------------
// SynchronousMachine Queries 
// -----------------------------------------

data class LoadSynchronousMachineFilter(val synchronousMachineId :  UUID? = null )

class FindSynchronousMachineQuery(val filter: LoadSynchronousMachineFilter = LoadSynchronousMachineFilter()) {
    override fun toString(): String = "LoadSynchronousMachineQuery"
}

class FindAllSynchronousMachineQuery() {
    override fun toString(): String = "LoadAllSynchronousMachineQuery"
}

data class SynchronousMachineFetchOneSummary(@Id var synchronousMachineId : UUID? = null) {
}





// -----------------------------------------
// SynchronousMachineDetailed Queries 
// -----------------------------------------

data class LoadSynchronousMachineDetailedFilter(val synchronousMachineDetailedId :  UUID? = null )

class FindSynchronousMachineDetailedQuery(val filter: LoadSynchronousMachineDetailedFilter = LoadSynchronousMachineDetailedFilter()) {
    override fun toString(): String = "LoadSynchronousMachineDetailedQuery"
}

class FindAllSynchronousMachineDetailedQuery() {
    override fun toString(): String = "LoadAllSynchronousMachineDetailedQuery"
}

data class SynchronousMachineDetailedFetchOneSummary(@Id var synchronousMachineDetailedId : UUID? = null) {
}





// -----------------------------------------
// SynchronousMachineDynamics Queries 
// -----------------------------------------

data class LoadSynchronousMachineDynamicsFilter(val synchronousMachineDynamicsId :  UUID? = null )

class FindSynchronousMachineDynamicsQuery(val filter: LoadSynchronousMachineDynamicsFilter = LoadSynchronousMachineDynamicsFilter()) {
    override fun toString(): String = "LoadSynchronousMachineDynamicsQuery"
}

class FindAllSynchronousMachineDynamicsQuery() {
    override fun toString(): String = "LoadAllSynchronousMachineDynamicsQuery"
}

data class SynchronousMachineDynamicsFetchOneSummary(@Id var synchronousMachineDynamicsId : UUID? = null) {
}





// -----------------------------------------
// SynchronousMachineEquivalentCircuit Queries 
// -----------------------------------------

data class LoadSynchronousMachineEquivalentCircuitFilter(val synchronousMachineEquivalentCircuitId :  UUID? = null )

class FindSynchronousMachineEquivalentCircuitQuery(val filter: LoadSynchronousMachineEquivalentCircuitFilter = LoadSynchronousMachineEquivalentCircuitFilter()) {
    override fun toString(): String = "LoadSynchronousMachineEquivalentCircuitQuery"
}

class FindAllSynchronousMachineEquivalentCircuitQuery() {
    override fun toString(): String = "LoadAllSynchronousMachineEquivalentCircuitQuery"
}

data class SynchronousMachineEquivalentCircuitFetchOneSummary(@Id var synchronousMachineEquivalentCircuitId : UUID? = null) {
}





// -----------------------------------------
// SynchronousMachineSimplified Queries 
// -----------------------------------------

data class LoadSynchronousMachineSimplifiedFilter(val synchronousMachineSimplifiedId :  UUID? = null )

class FindSynchronousMachineSimplifiedQuery(val filter: LoadSynchronousMachineSimplifiedFilter = LoadSynchronousMachineSimplifiedFilter()) {
    override fun toString(): String = "LoadSynchronousMachineSimplifiedQuery"
}

class FindAllSynchronousMachineSimplifiedQuery() {
    override fun toString(): String = "LoadAllSynchronousMachineSimplifiedQuery"
}

data class SynchronousMachineSimplifiedFetchOneSummary(@Id var synchronousMachineSimplifiedId : UUID? = null) {
}





// -----------------------------------------
// SynchronousMachineTimeConstantReactance Queries 
// -----------------------------------------

data class LoadSynchronousMachineTimeConstantReactanceFilter(val synchronousMachineTimeConstantReactanceId :  UUID? = null )

class FindSynchronousMachineTimeConstantReactanceQuery(val filter: LoadSynchronousMachineTimeConstantReactanceFilter = LoadSynchronousMachineTimeConstantReactanceFilter()) {
    override fun toString(): String = "LoadSynchronousMachineTimeConstantReactanceQuery"
}

class FindAllSynchronousMachineTimeConstantReactanceQuery() {
    override fun toString(): String = "LoadAllSynchronousMachineTimeConstantReactanceQuery"
}

data class SynchronousMachineTimeConstantReactanceFetchOneSummary(@Id var synchronousMachineTimeConstantReactanceId : UUID? = null) {
}





// -----------------------------------------
// SynchronousMachineUserDefined Queries 
// -----------------------------------------

data class LoadSynchronousMachineUserDefinedFilter(val synchronousMachineUserDefinedId :  UUID? = null )

class FindSynchronousMachineUserDefinedQuery(val filter: LoadSynchronousMachineUserDefinedFilter = LoadSynchronousMachineUserDefinedFilter()) {
    override fun toString(): String = "LoadSynchronousMachineUserDefinedQuery"
}

class FindAllSynchronousMachineUserDefinedQuery() {
    override fun toString(): String = "LoadAllSynchronousMachineUserDefinedQuery"
}

data class SynchronousMachineUserDefinedFetchOneSummary(@Id var synchronousMachineUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// TapChanger Queries 
// -----------------------------------------

data class LoadTapChangerFilter(val tapChangerId :  UUID? = null )

class FindTapChangerQuery(val filter: LoadTapChangerFilter = LoadTapChangerFilter()) {
    override fun toString(): String = "LoadTapChangerQuery"
}

class FindAllTapChangerQuery() {
    override fun toString(): String = "LoadAllTapChangerQuery"
}

data class TapChangerFetchOneSummary(@Id var tapChangerId : UUID? = null) {
}





// -----------------------------------------
// TapChangerControl Queries 
// -----------------------------------------

data class LoadTapChangerControlFilter(val tapChangerControlId :  UUID? = null )

class FindTapChangerControlQuery(val filter: LoadTapChangerControlFilter = LoadTapChangerControlFilter()) {
    override fun toString(): String = "LoadTapChangerControlQuery"
}

class FindAllTapChangerControlQuery() {
    override fun toString(): String = "LoadAllTapChangerControlQuery"
}

data class TapChangerControlFetchOneSummary(@Id var tapChangerControlId : UUID? = null) {
}





// -----------------------------------------
// TapChangerTablePoint Queries 
// -----------------------------------------

data class LoadTapChangerTablePointFilter(val tapChangerTablePointId :  UUID? = null )

class FindTapChangerTablePointQuery(val filter: LoadTapChangerTablePointFilter = LoadTapChangerTablePointFilter()) {
    override fun toString(): String = "LoadTapChangerTablePointQuery"
}

class FindAllTapChangerTablePointQuery() {
    override fun toString(): String = "LoadAllTapChangerTablePointQuery"
}

data class TapChangerTablePointFetchOneSummary(@Id var tapChangerTablePointId : UUID? = null) {
}





// -----------------------------------------
// TapSchedule Queries 
// -----------------------------------------

data class LoadTapScheduleFilter(val tapScheduleId :  UUID? = null )

class FindTapScheduleQuery(val filter: LoadTapScheduleFilter = LoadTapScheduleFilter()) {
    override fun toString(): String = "LoadTapScheduleQuery"
}

class FindAllTapScheduleQuery() {
    override fun toString(): String = "LoadAllTapScheduleQuery"
}

data class TapScheduleFetchOneSummary(@Id var tapScheduleId : UUID? = null) {
}





// -----------------------------------------
// Temperature Queries 
// -----------------------------------------

data class LoadTemperatureFilter(val temperatureId :  UUID? = null )

class FindTemperatureQuery(val filter: LoadTemperatureFilter = LoadTemperatureFilter()) {
    override fun toString(): String = "LoadTemperatureQuery"
}

class FindAllTemperatureQuery() {
    override fun toString(): String = "LoadAllTemperatureQuery"
}

data class TemperatureFetchOneSummary(@Id var temperatureId : UUID? = null) {
}





// -----------------------------------------
// Terminal Queries 
// -----------------------------------------

data class LoadTerminalFilter(val terminalId :  UUID? = null )

class FindTerminalQuery(val filter: LoadTerminalFilter = LoadTerminalFilter()) {
    override fun toString(): String = "LoadTerminalQuery"
}

class FindAllTerminalQuery() {
    override fun toString(): String = "LoadAllTerminalQuery"
}

data class TerminalFetchOneSummary(@Id var terminalId : UUID? = null) {
}





// -----------------------------------------
// TextDiagramObject Queries 
// -----------------------------------------

data class LoadTextDiagramObjectFilter(val textDiagramObjectId :  UUID? = null )

class FindTextDiagramObjectQuery(val filter: LoadTextDiagramObjectFilter = LoadTextDiagramObjectFilter()) {
    override fun toString(): String = "LoadTextDiagramObjectQuery"
}

class FindAllTextDiagramObjectQuery() {
    override fun toString(): String = "LoadAllTextDiagramObjectQuery"
}

data class TextDiagramObjectFetchOneSummary(@Id var textDiagramObjectId : UUID? = null) {
}





// -----------------------------------------
// ThermalGeneratingUnit Queries 
// -----------------------------------------

data class LoadThermalGeneratingUnitFilter(val thermalGeneratingUnitId :  UUID? = null )

class FindThermalGeneratingUnitQuery(val filter: LoadThermalGeneratingUnitFilter = LoadThermalGeneratingUnitFilter()) {
    override fun toString(): String = "LoadThermalGeneratingUnitQuery"
}

class FindAllThermalGeneratingUnitQuery() {
    override fun toString(): String = "LoadAllThermalGeneratingUnitQuery"
}

data class ThermalGeneratingUnitFetchOneSummary(@Id var thermalGeneratingUnitId : UUID? = null) {
}





// -----------------------------------------
// TieFlow Queries 
// -----------------------------------------

data class LoadTieFlowFilter(val tieFlowId :  UUID? = null )

class FindTieFlowQuery(val filter: LoadTieFlowFilter = LoadTieFlowFilter()) {
    override fun toString(): String = "LoadTieFlowQuery"
}

class FindAllTieFlowQuery() {
    override fun toString(): String = "LoadAllTieFlowQuery"
}

data class TieFlowFetchOneSummary(@Id var tieFlowId : UUID? = null) {
}





// -----------------------------------------
// TopologicalIsland Queries 
// -----------------------------------------

data class LoadTopologicalIslandFilter(val topologicalIslandId :  UUID? = null )

class FindTopologicalIslandQuery(val filter: LoadTopologicalIslandFilter = LoadTopologicalIslandFilter()) {
    override fun toString(): String = "LoadTopologicalIslandQuery"
}

class FindAllTopologicalIslandQuery() {
    override fun toString(): String = "LoadAllTopologicalIslandQuery"
}

data class TopologicalIslandFetchOneSummary(@Id var topologicalIslandId : UUID? = null) {
}





// -----------------------------------------
// TopologicalNode Queries 
// -----------------------------------------

data class LoadTopologicalNodeFilter(val topologicalNodeId :  UUID? = null )

class FindTopologicalNodeQuery(val filter: LoadTopologicalNodeFilter = LoadTopologicalNodeFilter()) {
    override fun toString(): String = "LoadTopologicalNodeQuery"
}

class FindAllTopologicalNodeQuery() {
    override fun toString(): String = "LoadAllTopologicalNodeQuery"
}

data class TopologicalNodeFetchOneSummary(@Id var topologicalNodeId : UUID? = null) {
}





// -----------------------------------------
// TopologyBoundaryVersion Queries 
// -----------------------------------------

data class LoadTopologyBoundaryVersionFilter(val topologyBoundaryVersionId :  UUID? = null )

class FindTopologyBoundaryVersionQuery(val filter: LoadTopologyBoundaryVersionFilter = LoadTopologyBoundaryVersionFilter()) {
    override fun toString(): String = "LoadTopologyBoundaryVersionQuery"
}

class FindAllTopologyBoundaryVersionQuery() {
    override fun toString(): String = "LoadAllTopologyBoundaryVersionQuery"
}

data class TopologyBoundaryVersionFetchOneSummary(@Id var topologyBoundaryVersionId : UUID? = null) {
}





// -----------------------------------------
// TopologyVersion Queries 
// -----------------------------------------

data class LoadTopologyVersionFilter(val topologyVersionId :  UUID? = null )

class FindTopologyVersionQuery(val filter: LoadTopologyVersionFilter = LoadTopologyVersionFilter()) {
    override fun toString(): String = "LoadTopologyVersionQuery"
}

class FindAllTopologyVersionQuery() {
    override fun toString(): String = "LoadAllTopologyVersionQuery"
}

data class TopologyVersionFetchOneSummary(@Id var topologyVersionId : UUID? = null) {
}





// -----------------------------------------
// TransformerEnd Queries 
// -----------------------------------------

data class LoadTransformerEndFilter(val transformerEndId :  UUID? = null )

class FindTransformerEndQuery(val filter: LoadTransformerEndFilter = LoadTransformerEndFilter()) {
    override fun toString(): String = "LoadTransformerEndQuery"
}

class FindAllTransformerEndQuery() {
    override fun toString(): String = "LoadAllTransformerEndQuery"
}

data class TransformerEndFetchOneSummary(@Id var transformerEndId : UUID? = null) {
}





// -----------------------------------------
// TurbLCFB1 Queries 
// -----------------------------------------

data class LoadTurbLCFB1Filter(val turbLCFB1Id :  UUID? = null )

class FindTurbLCFB1Query(val filter: LoadTurbLCFB1Filter = LoadTurbLCFB1Filter()) {
    override fun toString(): String = "LoadTurbLCFB1Query"
}

class FindAllTurbLCFB1Query() {
    override fun toString(): String = "LoadAllTurbLCFB1Query"
}

data class TurbLCFB1FetchOneSummary(@Id var turbLCFB1Id : UUID? = null) {
}





// -----------------------------------------
// TurbineGovernorDynamics Queries 
// -----------------------------------------

data class LoadTurbineGovernorDynamicsFilter(val turbineGovernorDynamicsId :  UUID? = null )

class FindTurbineGovernorDynamicsQuery(val filter: LoadTurbineGovernorDynamicsFilter = LoadTurbineGovernorDynamicsFilter()) {
    override fun toString(): String = "LoadTurbineGovernorDynamicsQuery"
}

class FindAllTurbineGovernorDynamicsQuery() {
    override fun toString(): String = "LoadAllTurbineGovernorDynamicsQuery"
}

data class TurbineGovernorDynamicsFetchOneSummary(@Id var turbineGovernorDynamicsId : UUID? = null) {
}





// -----------------------------------------
// TurbineGovernorUserDefined Queries 
// -----------------------------------------

data class LoadTurbineGovernorUserDefinedFilter(val turbineGovernorUserDefinedId :  UUID? = null )

class FindTurbineGovernorUserDefinedQuery(val filter: LoadTurbineGovernorUserDefinedFilter = LoadTurbineGovernorUserDefinedFilter()) {
    override fun toString(): String = "LoadTurbineGovernorUserDefinedQuery"
}

class FindAllTurbineGovernorUserDefinedQuery() {
    override fun toString(): String = "LoadAllTurbineGovernorUserDefinedQuery"
}

data class TurbineGovernorUserDefinedFetchOneSummary(@Id var turbineGovernorUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// TurbineLoadControllerDynamics Queries 
// -----------------------------------------

data class LoadTurbineLoadControllerDynamicsFilter(val turbineLoadControllerDynamicsId :  UUID? = null )

class FindTurbineLoadControllerDynamicsQuery(val filter: LoadTurbineLoadControllerDynamicsFilter = LoadTurbineLoadControllerDynamicsFilter()) {
    override fun toString(): String = "LoadTurbineLoadControllerDynamicsQuery"
}

class FindAllTurbineLoadControllerDynamicsQuery() {
    override fun toString(): String = "LoadAllTurbineLoadControllerDynamicsQuery"
}

data class TurbineLoadControllerDynamicsFetchOneSummary(@Id var turbineLoadControllerDynamicsId : UUID? = null) {
}





// -----------------------------------------
// TurbineLoadControllerUserDefined Queries 
// -----------------------------------------

data class LoadTurbineLoadControllerUserDefinedFilter(val turbineLoadControllerUserDefinedId :  UUID? = null )

class FindTurbineLoadControllerUserDefinedQuery(val filter: LoadTurbineLoadControllerUserDefinedFilter = LoadTurbineLoadControllerUserDefinedFilter()) {
    override fun toString(): String = "LoadTurbineLoadControllerUserDefinedQuery"
}

class FindAllTurbineLoadControllerUserDefinedQuery() {
    override fun toString(): String = "LoadAllTurbineLoadControllerUserDefinedQuery"
}

data class TurbineLoadControllerUserDefinedFetchOneSummary(@Id var turbineLoadControllerUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// UnderexcLim2Simplified Queries 
// -----------------------------------------

data class LoadUnderexcLim2SimplifiedFilter(val underexcLim2SimplifiedId :  UUID? = null )

class FindUnderexcLim2SimplifiedQuery(val filter: LoadUnderexcLim2SimplifiedFilter = LoadUnderexcLim2SimplifiedFilter()) {
    override fun toString(): String = "LoadUnderexcLim2SimplifiedQuery"
}

class FindAllUnderexcLim2SimplifiedQuery() {
    override fun toString(): String = "LoadAllUnderexcLim2SimplifiedQuery"
}

data class UnderexcLim2SimplifiedFetchOneSummary(@Id var underexcLim2SimplifiedId : UUID? = null) {
}





// -----------------------------------------
// UnderexcLimIEEE1 Queries 
// -----------------------------------------

data class LoadUnderexcLimIEEE1Filter(val underexcLimIEEE1Id :  UUID? = null )

class FindUnderexcLimIEEE1Query(val filter: LoadUnderexcLimIEEE1Filter = LoadUnderexcLimIEEE1Filter()) {
    override fun toString(): String = "LoadUnderexcLimIEEE1Query"
}

class FindAllUnderexcLimIEEE1Query() {
    override fun toString(): String = "LoadAllUnderexcLimIEEE1Query"
}

data class UnderexcLimIEEE1FetchOneSummary(@Id var underexcLimIEEE1Id : UUID? = null) {
}





// -----------------------------------------
// UnderexcLimIEEE2 Queries 
// -----------------------------------------

data class LoadUnderexcLimIEEE2Filter(val underexcLimIEEE2Id :  UUID? = null )

class FindUnderexcLimIEEE2Query(val filter: LoadUnderexcLimIEEE2Filter = LoadUnderexcLimIEEE2Filter()) {
    override fun toString(): String = "LoadUnderexcLimIEEE2Query"
}

class FindAllUnderexcLimIEEE2Query() {
    override fun toString(): String = "LoadAllUnderexcLimIEEE2Query"
}

data class UnderexcLimIEEE2FetchOneSummary(@Id var underexcLimIEEE2Id : UUID? = null) {
}





// -----------------------------------------
// UnderexcLimX1 Queries 
// -----------------------------------------

data class LoadUnderexcLimX1Filter(val underexcLimX1Id :  UUID? = null )

class FindUnderexcLimX1Query(val filter: LoadUnderexcLimX1Filter = LoadUnderexcLimX1Filter()) {
    override fun toString(): String = "LoadUnderexcLimX1Query"
}

class FindAllUnderexcLimX1Query() {
    override fun toString(): String = "LoadAllUnderexcLimX1Query"
}

data class UnderexcLimX1FetchOneSummary(@Id var underexcLimX1Id : UUID? = null) {
}





// -----------------------------------------
// UnderexcLimX2 Queries 
// -----------------------------------------

data class LoadUnderexcLimX2Filter(val underexcLimX2Id :  UUID? = null )

class FindUnderexcLimX2Query(val filter: LoadUnderexcLimX2Filter = LoadUnderexcLimX2Filter()) {
    override fun toString(): String = "LoadUnderexcLimX2Query"
}

class FindAllUnderexcLimX2Query() {
    override fun toString(): String = "LoadAllUnderexcLimX2Query"
}

data class UnderexcLimX2FetchOneSummary(@Id var underexcLimX2Id : UUID? = null) {
}





// -----------------------------------------
// UnderexcitationLimiterDynamics Queries 
// -----------------------------------------

data class LoadUnderexcitationLimiterDynamicsFilter(val underexcitationLimiterDynamicsId :  UUID? = null )

class FindUnderexcitationLimiterDynamicsQuery(val filter: LoadUnderexcitationLimiterDynamicsFilter = LoadUnderexcitationLimiterDynamicsFilter()) {
    override fun toString(): String = "LoadUnderexcitationLimiterDynamicsQuery"
}

class FindAllUnderexcitationLimiterDynamicsQuery() {
    override fun toString(): String = "LoadAllUnderexcitationLimiterDynamicsQuery"
}

data class UnderexcitationLimiterDynamicsFetchOneSummary(@Id var underexcitationLimiterDynamicsId : UUID? = null) {
}





// -----------------------------------------
// UnderexcitationLimiterUserDefined Queries 
// -----------------------------------------

data class LoadUnderexcitationLimiterUserDefinedFilter(val underexcitationLimiterUserDefinedId :  UUID? = null )

class FindUnderexcitationLimiterUserDefinedQuery(val filter: LoadUnderexcitationLimiterUserDefinedFilter = LoadUnderexcitationLimiterUserDefinedFilter()) {
    override fun toString(): String = "LoadUnderexcitationLimiterUserDefinedQuery"
}

class FindAllUnderexcitationLimiterUserDefinedQuery() {
    override fun toString(): String = "LoadAllUnderexcitationLimiterUserDefinedQuery"
}

data class UnderexcitationLimiterUserDefinedFetchOneSummary(@Id var underexcitationLimiterUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// Unresolvedname Queries 
// -----------------------------------------

data class LoadUnresolvednameFilter(val unresolvednameId :  UUID? = null )

class FindUnresolvednameQuery(val filter: LoadUnresolvednameFilter = LoadUnresolvednameFilter()) {
    override fun toString(): String = "LoadUnresolvednameQuery"
}

class FindAllUnresolvednameQuery() {
    override fun toString(): String = "LoadAllUnresolvednameQuery"
}

data class UnresolvednameFetchOneSummary(@Id var unresolvednameId : UUID? = null) {
}





// -----------------------------------------
// VAdjIEEE Queries 
// -----------------------------------------

data class LoadVAdjIEEEFilter(val vAdjIEEEId :  UUID? = null )

class FindVAdjIEEEQuery(val filter: LoadVAdjIEEEFilter = LoadVAdjIEEEFilter()) {
    override fun toString(): String = "LoadVAdjIEEEQuery"
}

class FindAllVAdjIEEEQuery() {
    override fun toString(): String = "LoadAllVAdjIEEEQuery"
}

data class VAdjIEEEFetchOneSummary(@Id var vAdjIEEEId : UUID? = null) {
}





// -----------------------------------------
// VCompIEEEType1 Queries 
// -----------------------------------------

data class LoadVCompIEEEType1Filter(val vCompIEEEType1Id :  UUID? = null )

class FindVCompIEEEType1Query(val filter: LoadVCompIEEEType1Filter = LoadVCompIEEEType1Filter()) {
    override fun toString(): String = "LoadVCompIEEEType1Query"
}

class FindAllVCompIEEEType1Query() {
    override fun toString(): String = "LoadAllVCompIEEEType1Query"
}

data class VCompIEEEType1FetchOneSummary(@Id var vCompIEEEType1Id : UUID? = null) {
}





// -----------------------------------------
// VCompIEEEType2 Queries 
// -----------------------------------------

data class LoadVCompIEEEType2Filter(val vCompIEEEType2Id :  UUID? = null )

class FindVCompIEEEType2Query(val filter: LoadVCompIEEEType2Filter = LoadVCompIEEEType2Filter()) {
    override fun toString(): String = "LoadVCompIEEEType2Query"
}

class FindAllVCompIEEEType2Query() {
    override fun toString(): String = "LoadAllVCompIEEEType2Query"
}

data class VCompIEEEType2FetchOneSummary(@Id var vCompIEEEType2Id : UUID? = null) {
}





// -----------------------------------------
// ValueAliasSet Queries 
// -----------------------------------------

data class LoadValueAliasSetFilter(val valueAliasSetId :  UUID? = null )

class FindValueAliasSetQuery(val filter: LoadValueAliasSetFilter = LoadValueAliasSetFilter()) {
    override fun toString(): String = "LoadValueAliasSetQuery"
}

class FindAllValueAliasSetQuery() {
    override fun toString(): String = "LoadAllValueAliasSetQuery"
}

data class ValueAliasSetFetchOneSummary(@Id var valueAliasSetId : UUID? = null) {
}





// -----------------------------------------
// ValueToAlias Queries 
// -----------------------------------------

data class LoadValueToAliasFilter(val valueToAliasId :  UUID? = null )

class FindValueToAliasQuery(val filter: LoadValueToAliasFilter = LoadValueToAliasFilter()) {
    override fun toString(): String = "LoadValueToAliasQuery"
}

class FindAllValueToAliasQuery() {
    override fun toString(): String = "LoadAllValueToAliasQuery"
}

data class ValueToAliasFetchOneSummary(@Id var valueToAliasId : UUID? = null) {
}





// -----------------------------------------
// VisibilityLayer Queries 
// -----------------------------------------

data class LoadVisibilityLayerFilter(val visibilityLayerId :  UUID? = null )

class FindVisibilityLayerQuery(val filter: LoadVisibilityLayerFilter = LoadVisibilityLayerFilter()) {
    override fun toString(): String = "LoadVisibilityLayerQuery"
}

class FindAllVisibilityLayerQuery() {
    override fun toString(): String = "LoadAllVisibilityLayerQuery"
}

data class VisibilityLayerFetchOneSummary(@Id var visibilityLayerId : UUID? = null) {
}





// -----------------------------------------
// Voltage Queries 
// -----------------------------------------

data class LoadVoltageFilter(val voltageId :  UUID? = null )

class FindVoltageQuery(val filter: LoadVoltageFilter = LoadVoltageFilter()) {
    override fun toString(): String = "LoadVoltageQuery"
}

class FindAllVoltageQuery() {
    override fun toString(): String = "LoadAllVoltageQuery"
}

data class VoltageFetchOneSummary(@Id var voltageId : UUID? = null) {
}





// -----------------------------------------
// VoltageAdjusterDynamics Queries 
// -----------------------------------------

data class LoadVoltageAdjusterDynamicsFilter(val voltageAdjusterDynamicsId :  UUID? = null )

class FindVoltageAdjusterDynamicsQuery(val filter: LoadVoltageAdjusterDynamicsFilter = LoadVoltageAdjusterDynamicsFilter()) {
    override fun toString(): String = "LoadVoltageAdjusterDynamicsQuery"
}

class FindAllVoltageAdjusterDynamicsQuery() {
    override fun toString(): String = "LoadAllVoltageAdjusterDynamicsQuery"
}

data class VoltageAdjusterDynamicsFetchOneSummary(@Id var voltageAdjusterDynamicsId : UUID? = null) {
}





// -----------------------------------------
// VoltageAdjusterUserDefined Queries 
// -----------------------------------------

data class LoadVoltageAdjusterUserDefinedFilter(val voltageAdjusterUserDefinedId :  UUID? = null )

class FindVoltageAdjusterUserDefinedQuery(val filter: LoadVoltageAdjusterUserDefinedFilter = LoadVoltageAdjusterUserDefinedFilter()) {
    override fun toString(): String = "LoadVoltageAdjusterUserDefinedQuery"
}

class FindAllVoltageAdjusterUserDefinedQuery() {
    override fun toString(): String = "LoadAllVoltageAdjusterUserDefinedQuery"
}

data class VoltageAdjusterUserDefinedFetchOneSummary(@Id var voltageAdjusterUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// VoltageCompensatorDynamics Queries 
// -----------------------------------------

data class LoadVoltageCompensatorDynamicsFilter(val voltageCompensatorDynamicsId :  UUID? = null )

class FindVoltageCompensatorDynamicsQuery(val filter: LoadVoltageCompensatorDynamicsFilter = LoadVoltageCompensatorDynamicsFilter()) {
    override fun toString(): String = "LoadVoltageCompensatorDynamicsQuery"
}

class FindAllVoltageCompensatorDynamicsQuery() {
    override fun toString(): String = "LoadAllVoltageCompensatorDynamicsQuery"
}

data class VoltageCompensatorDynamicsFetchOneSummary(@Id var voltageCompensatorDynamicsId : UUID? = null) {
}





// -----------------------------------------
// VoltageCompensatorUserDefined Queries 
// -----------------------------------------

data class LoadVoltageCompensatorUserDefinedFilter(val voltageCompensatorUserDefinedId :  UUID? = null )

class FindVoltageCompensatorUserDefinedQuery(val filter: LoadVoltageCompensatorUserDefinedFilter = LoadVoltageCompensatorUserDefinedFilter()) {
    override fun toString(): String = "LoadVoltageCompensatorUserDefinedQuery"
}

class FindAllVoltageCompensatorUserDefinedQuery() {
    override fun toString(): String = "LoadAllVoltageCompensatorUserDefinedQuery"
}

data class VoltageCompensatorUserDefinedFetchOneSummary(@Id var voltageCompensatorUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// VoltageLevel Queries 
// -----------------------------------------

data class LoadVoltageLevelFilter(val voltageLevelId :  UUID? = null )

class FindVoltageLevelQuery(val filter: LoadVoltageLevelFilter = LoadVoltageLevelFilter()) {
    override fun toString(): String = "LoadVoltageLevelQuery"
}

class FindAllVoltageLevelQuery() {
    override fun toString(): String = "LoadAllVoltageLevelQuery"
}

data class VoltageLevelFetchOneSummary(@Id var voltageLevelId : UUID? = null) {
}





// -----------------------------------------
// VoltageLimit Queries 
// -----------------------------------------

data class LoadVoltageLimitFilter(val voltageLimitId :  UUID? = null )

class FindVoltageLimitQuery(val filter: LoadVoltageLimitFilter = LoadVoltageLimitFilter()) {
    override fun toString(): String = "LoadVoltageLimitQuery"
}

class FindAllVoltageLimitQuery() {
    override fun toString(): String = "LoadAllVoltageLimitQuery"
}

data class VoltageLimitFetchOneSummary(@Id var voltageLimitId : UUID? = null) {
}





// -----------------------------------------
// VoltagePerReactivePower Queries 
// -----------------------------------------

data class LoadVoltagePerReactivePowerFilter(val voltagePerReactivePowerId :  UUID? = null )

class FindVoltagePerReactivePowerQuery(val filter: LoadVoltagePerReactivePowerFilter = LoadVoltagePerReactivePowerFilter()) {
    override fun toString(): String = "LoadVoltagePerReactivePowerQuery"
}

class FindAllVoltagePerReactivePowerQuery() {
    override fun toString(): String = "LoadAllVoltagePerReactivePowerQuery"
}

data class VoltagePerReactivePowerFetchOneSummary(@Id var voltagePerReactivePowerId : UUID? = null) {
}





// -----------------------------------------
// VolumeFlowRate Queries 
// -----------------------------------------

data class LoadVolumeFlowRateFilter(val volumeFlowRateId :  UUID? = null )

class FindVolumeFlowRateQuery(val filter: LoadVolumeFlowRateFilter = LoadVolumeFlowRateFilter()) {
    override fun toString(): String = "LoadVolumeFlowRateQuery"
}

class FindAllVolumeFlowRateQuery() {
    override fun toString(): String = "LoadAllVolumeFlowRateQuery"
}

data class VolumeFlowRateFetchOneSummary(@Id var volumeFlowRateId : UUID? = null) {
}





// -----------------------------------------
// VsCapabilityCurve Queries 
// -----------------------------------------

data class LoadVsCapabilityCurveFilter(val vsCapabilityCurveId :  UUID? = null )

class FindVsCapabilityCurveQuery(val filter: LoadVsCapabilityCurveFilter = LoadVsCapabilityCurveFilter()) {
    override fun toString(): String = "LoadVsCapabilityCurveQuery"
}

class FindAllVsCapabilityCurveQuery() {
    override fun toString(): String = "LoadAllVsCapabilityCurveQuery"
}

data class VsCapabilityCurveFetchOneSummary(@Id var vsCapabilityCurveId : UUID? = null) {
}





// -----------------------------------------
// VsConverter Queries 
// -----------------------------------------

data class LoadVsConverterFilter(val vsConverterId :  UUID? = null )

class FindVsConverterQuery(val filter: LoadVsConverterFilter = LoadVsConverterFilter()) {
    override fun toString(): String = "LoadVsConverterQuery"
}

class FindAllVsConverterQuery() {
    override fun toString(): String = "LoadAllVsConverterQuery"
}

data class VsConverterFetchOneSummary(@Id var vsConverterId : UUID? = null) {
}





// -----------------------------------------
// WindAeroConstIEC Queries 
// -----------------------------------------

data class LoadWindAeroConstIECFilter(val windAeroConstIECId :  UUID? = null )

class FindWindAeroConstIECQuery(val filter: LoadWindAeroConstIECFilter = LoadWindAeroConstIECFilter()) {
    override fun toString(): String = "LoadWindAeroConstIECQuery"
}

class FindAllWindAeroConstIECQuery() {
    override fun toString(): String = "LoadAllWindAeroConstIECQuery"
}

data class WindAeroConstIECFetchOneSummary(@Id var windAeroConstIECId : UUID? = null) {
}





// -----------------------------------------
// WindAeroLinearIEC Queries 
// -----------------------------------------

data class LoadWindAeroLinearIECFilter(val windAeroLinearIECId :  UUID? = null )

class FindWindAeroLinearIECQuery(val filter: LoadWindAeroLinearIECFilter = LoadWindAeroLinearIECFilter()) {
    override fun toString(): String = "LoadWindAeroLinearIECQuery"
}

class FindAllWindAeroLinearIECQuery() {
    override fun toString(): String = "LoadAllWindAeroLinearIECQuery"
}

data class WindAeroLinearIECFetchOneSummary(@Id var windAeroLinearIECId : UUID? = null) {
}





// -----------------------------------------
// WindContCurrLimIEC Queries 
// -----------------------------------------

data class LoadWindContCurrLimIECFilter(val windContCurrLimIECId :  UUID? = null )

class FindWindContCurrLimIECQuery(val filter: LoadWindContCurrLimIECFilter = LoadWindContCurrLimIECFilter()) {
    override fun toString(): String = "LoadWindContCurrLimIECQuery"
}

class FindAllWindContCurrLimIECQuery() {
    override fun toString(): String = "LoadAllWindContCurrLimIECQuery"
}

data class WindContCurrLimIECFetchOneSummary(@Id var windContCurrLimIECId : UUID? = null) {
}





// -----------------------------------------
// WindContPType3IEC Queries 
// -----------------------------------------

data class LoadWindContPType3IECFilter(val windContPType3IECId :  UUID? = null )

class FindWindContPType3IECQuery(val filter: LoadWindContPType3IECFilter = LoadWindContPType3IECFilter()) {
    override fun toString(): String = "LoadWindContPType3IECQuery"
}

class FindAllWindContPType3IECQuery() {
    override fun toString(): String = "LoadAllWindContPType3IECQuery"
}

data class WindContPType3IECFetchOneSummary(@Id var windContPType3IECId : UUID? = null) {
}





// -----------------------------------------
// WindContPType4aIEC Queries 
// -----------------------------------------

data class LoadWindContPType4aIECFilter(val windContPType4aIECId :  UUID? = null )

class FindWindContPType4aIECQuery(val filter: LoadWindContPType4aIECFilter = LoadWindContPType4aIECFilter()) {
    override fun toString(): String = "LoadWindContPType4aIECQuery"
}

class FindAllWindContPType4aIECQuery() {
    override fun toString(): String = "LoadAllWindContPType4aIECQuery"
}

data class WindContPType4aIECFetchOneSummary(@Id var windContPType4aIECId : UUID? = null) {
}





// -----------------------------------------
// WindContPType4bIEC Queries 
// -----------------------------------------

data class LoadWindContPType4bIECFilter(val windContPType4bIECId :  UUID? = null )

class FindWindContPType4bIECQuery(val filter: LoadWindContPType4bIECFilter = LoadWindContPType4bIECFilter()) {
    override fun toString(): String = "LoadWindContPType4bIECQuery"
}

class FindAllWindContPType4bIECQuery() {
    override fun toString(): String = "LoadAllWindContPType4bIECQuery"
}

data class WindContPType4bIECFetchOneSummary(@Id var windContPType4bIECId : UUID? = null) {
}





// -----------------------------------------
// WindContPitchAngleIEC Queries 
// -----------------------------------------

data class LoadWindContPitchAngleIECFilter(val windContPitchAngleIECId :  UUID? = null )

class FindWindContPitchAngleIECQuery(val filter: LoadWindContPitchAngleIECFilter = LoadWindContPitchAngleIECFilter()) {
    override fun toString(): String = "LoadWindContPitchAngleIECQuery"
}

class FindAllWindContPitchAngleIECQuery() {
    override fun toString(): String = "LoadAllWindContPitchAngleIECQuery"
}

data class WindContPitchAngleIECFetchOneSummary(@Id var windContPitchAngleIECId : UUID? = null) {
}





// -----------------------------------------
// WindContQIEC Queries 
// -----------------------------------------

data class LoadWindContQIECFilter(val windContQIECId :  UUID? = null )

class FindWindContQIECQuery(val filter: LoadWindContQIECFilter = LoadWindContQIECFilter()) {
    override fun toString(): String = "LoadWindContQIECQuery"
}

class FindAllWindContQIECQuery() {
    override fun toString(): String = "LoadAllWindContQIECQuery"
}

data class WindContQIECFetchOneSummary(@Id var windContQIECId : UUID? = null) {
}





// -----------------------------------------
// WindContRotorRIEC Queries 
// -----------------------------------------

data class LoadWindContRotorRIECFilter(val windContRotorRIECId :  UUID? = null )

class FindWindContRotorRIECQuery(val filter: LoadWindContRotorRIECFilter = LoadWindContRotorRIECFilter()) {
    override fun toString(): String = "LoadWindContRotorRIECQuery"
}

class FindAllWindContRotorRIECQuery() {
    override fun toString(): String = "LoadAllWindContRotorRIECQuery"
}

data class WindContRotorRIECFetchOneSummary(@Id var windContRotorRIECId : UUID? = null) {
}





// -----------------------------------------
// WindDynamicsLookupTable Queries 
// -----------------------------------------

data class LoadWindDynamicsLookupTableFilter(val windDynamicsLookupTableId :  UUID? = null )

class FindWindDynamicsLookupTableQuery(val filter: LoadWindDynamicsLookupTableFilter = LoadWindDynamicsLookupTableFilter()) {
    override fun toString(): String = "LoadWindDynamicsLookupTableQuery"
}

class FindAllWindDynamicsLookupTableQuery() {
    override fun toString(): String = "LoadAllWindDynamicsLookupTableQuery"
}

data class WindDynamicsLookupTableFetchOneSummary(@Id var windDynamicsLookupTableId : UUID? = null) {
}





// -----------------------------------------
// WindGenTurbineType1IEC Queries 
// -----------------------------------------

data class LoadWindGenTurbineType1IECFilter(val windGenTurbineType1IECId :  UUID? = null )

class FindWindGenTurbineType1IECQuery(val filter: LoadWindGenTurbineType1IECFilter = LoadWindGenTurbineType1IECFilter()) {
    override fun toString(): String = "LoadWindGenTurbineType1IECQuery"
}

class FindAllWindGenTurbineType1IECQuery() {
    override fun toString(): String = "LoadAllWindGenTurbineType1IECQuery"
}

data class WindGenTurbineType1IECFetchOneSummary(@Id var windGenTurbineType1IECId : UUID? = null) {
}





// -----------------------------------------
// WindGenTurbineType2IEC Queries 
// -----------------------------------------

data class LoadWindGenTurbineType2IECFilter(val windGenTurbineType2IECId :  UUID? = null )

class FindWindGenTurbineType2IECQuery(val filter: LoadWindGenTurbineType2IECFilter = LoadWindGenTurbineType2IECFilter()) {
    override fun toString(): String = "LoadWindGenTurbineType2IECQuery"
}

class FindAllWindGenTurbineType2IECQuery() {
    override fun toString(): String = "LoadAllWindGenTurbineType2IECQuery"
}

data class WindGenTurbineType2IECFetchOneSummary(@Id var windGenTurbineType2IECId : UUID? = null) {
}





// -----------------------------------------
// WindGenTurbineType3IEC Queries 
// -----------------------------------------

data class LoadWindGenTurbineType3IECFilter(val windGenTurbineType3IECId :  UUID? = null )

class FindWindGenTurbineType3IECQuery(val filter: LoadWindGenTurbineType3IECFilter = LoadWindGenTurbineType3IECFilter()) {
    override fun toString(): String = "LoadWindGenTurbineType3IECQuery"
}

class FindAllWindGenTurbineType3IECQuery() {
    override fun toString(): String = "LoadAllWindGenTurbineType3IECQuery"
}

data class WindGenTurbineType3IECFetchOneSummary(@Id var windGenTurbineType3IECId : UUID? = null) {
}





// -----------------------------------------
// WindGenTurbineType3aIEC Queries 
// -----------------------------------------

data class LoadWindGenTurbineType3aIECFilter(val windGenTurbineType3aIECId :  UUID? = null )

class FindWindGenTurbineType3aIECQuery(val filter: LoadWindGenTurbineType3aIECFilter = LoadWindGenTurbineType3aIECFilter()) {
    override fun toString(): String = "LoadWindGenTurbineType3aIECQuery"
}

class FindAllWindGenTurbineType3aIECQuery() {
    override fun toString(): String = "LoadAllWindGenTurbineType3aIECQuery"
}

data class WindGenTurbineType3aIECFetchOneSummary(@Id var windGenTurbineType3aIECId : UUID? = null) {
}





// -----------------------------------------
// WindGenTurbineType3bIEC Queries 
// -----------------------------------------

data class LoadWindGenTurbineType3bIECFilter(val windGenTurbineType3bIECId :  UUID? = null )

class FindWindGenTurbineType3bIECQuery(val filter: LoadWindGenTurbineType3bIECFilter = LoadWindGenTurbineType3bIECFilter()) {
    override fun toString(): String = "LoadWindGenTurbineType3bIECQuery"
}

class FindAllWindGenTurbineType3bIECQuery() {
    override fun toString(): String = "LoadAllWindGenTurbineType3bIECQuery"
}

data class WindGenTurbineType3bIECFetchOneSummary(@Id var windGenTurbineType3bIECId : UUID? = null) {
}





// -----------------------------------------
// WindGenType4IEC Queries 
// -----------------------------------------

data class LoadWindGenType4IECFilter(val windGenType4IECId :  UUID? = null )

class FindWindGenType4IECQuery(val filter: LoadWindGenType4IECFilter = LoadWindGenType4IECFilter()) {
    override fun toString(): String = "LoadWindGenType4IECQuery"
}

class FindAllWindGenType4IECQuery() {
    override fun toString(): String = "LoadAllWindGenType4IECQuery"
}

data class WindGenType4IECFetchOneSummary(@Id var windGenType4IECId : UUID? = null) {
}





// -----------------------------------------
// WindGeneratingUnit Queries 
// -----------------------------------------

data class LoadWindGeneratingUnitFilter(val windGeneratingUnitId :  UUID? = null )

class FindWindGeneratingUnitQuery(val filter: LoadWindGeneratingUnitFilter = LoadWindGeneratingUnitFilter()) {
    override fun toString(): String = "LoadWindGeneratingUnitQuery"
}

class FindAllWindGeneratingUnitQuery() {
    override fun toString(): String = "LoadAllWindGeneratingUnitQuery"
}

data class WindGeneratingUnitFetchOneSummary(@Id var windGeneratingUnitId : UUID? = null) {
}





// -----------------------------------------
// WindMechIEC Queries 
// -----------------------------------------

data class LoadWindMechIECFilter(val windMechIECId :  UUID? = null )

class FindWindMechIECQuery(val filter: LoadWindMechIECFilter = LoadWindMechIECFilter()) {
    override fun toString(): String = "LoadWindMechIECQuery"
}

class FindAllWindMechIECQuery() {
    override fun toString(): String = "LoadAllWindMechIECQuery"
}

data class WindMechIECFetchOneSummary(@Id var windMechIECId : UUID? = null) {
}





// -----------------------------------------
// WindPitchContEmulIEC Queries 
// -----------------------------------------

data class LoadWindPitchContEmulIECFilter(val windPitchContEmulIECId :  UUID? = null )

class FindWindPitchContEmulIECQuery(val filter: LoadWindPitchContEmulIECFilter = LoadWindPitchContEmulIECFilter()) {
    override fun toString(): String = "LoadWindPitchContEmulIECQuery"
}

class FindAllWindPitchContEmulIECQuery() {
    override fun toString(): String = "LoadAllWindPitchContEmulIECQuery"
}

data class WindPitchContEmulIECFetchOneSummary(@Id var windPitchContEmulIECId : UUID? = null) {
}





// -----------------------------------------
// WindPlantDynamics Queries 
// -----------------------------------------

data class LoadWindPlantDynamicsFilter(val windPlantDynamicsId :  UUID? = null )

class FindWindPlantDynamicsQuery(val filter: LoadWindPlantDynamicsFilter = LoadWindPlantDynamicsFilter()) {
    override fun toString(): String = "LoadWindPlantDynamicsQuery"
}

class FindAllWindPlantDynamicsQuery() {
    override fun toString(): String = "LoadAllWindPlantDynamicsQuery"
}

data class WindPlantDynamicsFetchOneSummary(@Id var windPlantDynamicsId : UUID? = null) {
}





// -----------------------------------------
// WindPlantFreqPcontrolIEC Queries 
// -----------------------------------------

data class LoadWindPlantFreqPcontrolIECFilter(val windPlantFreqPcontrolIECId :  UUID? = null )

class FindWindPlantFreqPcontrolIECQuery(val filter: LoadWindPlantFreqPcontrolIECFilter = LoadWindPlantFreqPcontrolIECFilter()) {
    override fun toString(): String = "LoadWindPlantFreqPcontrolIECQuery"
}

class FindAllWindPlantFreqPcontrolIECQuery() {
    override fun toString(): String = "LoadAllWindPlantFreqPcontrolIECQuery"
}

data class WindPlantFreqPcontrolIECFetchOneSummary(@Id var windPlantFreqPcontrolIECId : UUID? = null) {
}





// -----------------------------------------
// WindPlantIEC Queries 
// -----------------------------------------

data class LoadWindPlantIECFilter(val windPlantIECId :  UUID? = null )

class FindWindPlantIECQuery(val filter: LoadWindPlantIECFilter = LoadWindPlantIECFilter()) {
    override fun toString(): String = "LoadWindPlantIECQuery"
}

class FindAllWindPlantIECQuery() {
    override fun toString(): String = "LoadAllWindPlantIECQuery"
}

data class WindPlantIECFetchOneSummary(@Id var windPlantIECId : UUID? = null) {
}





// -----------------------------------------
// WindPlantReactiveControlIEC Queries 
// -----------------------------------------

data class LoadWindPlantReactiveControlIECFilter(val windPlantReactiveControlIECId :  UUID? = null )

class FindWindPlantReactiveControlIECQuery(val filter: LoadWindPlantReactiveControlIECFilter = LoadWindPlantReactiveControlIECFilter()) {
    override fun toString(): String = "LoadWindPlantReactiveControlIECQuery"
}

class FindAllWindPlantReactiveControlIECQuery() {
    override fun toString(): String = "LoadAllWindPlantReactiveControlIECQuery"
}

data class WindPlantReactiveControlIECFetchOneSummary(@Id var windPlantReactiveControlIECId : UUID? = null) {
}





// -----------------------------------------
// WindPlantUserDefined Queries 
// -----------------------------------------

data class LoadWindPlantUserDefinedFilter(val windPlantUserDefinedId :  UUID? = null )

class FindWindPlantUserDefinedQuery(val filter: LoadWindPlantUserDefinedFilter = LoadWindPlantUserDefinedFilter()) {
    override fun toString(): String = "LoadWindPlantUserDefinedQuery"
}

class FindAllWindPlantUserDefinedQuery() {
    override fun toString(): String = "LoadAllWindPlantUserDefinedQuery"
}

data class WindPlantUserDefinedFetchOneSummary(@Id var windPlantUserDefinedId : UUID? = null) {
}





// -----------------------------------------
// WindProtectionIEC Queries 
// -----------------------------------------

data class LoadWindProtectionIECFilter(val windProtectionIECId :  UUID? = null )

class FindWindProtectionIECQuery(val filter: LoadWindProtectionIECFilter = LoadWindProtectionIECFilter()) {
    override fun toString(): String = "LoadWindProtectionIECQuery"
}

class FindAllWindProtectionIECQuery() {
    override fun toString(): String = "LoadAllWindProtectionIECQuery"
}

data class WindProtectionIECFetchOneSummary(@Id var windProtectionIECId : UUID? = null) {
}





// -----------------------------------------
// WindTurbineType1or2Dynamics Queries 
// -----------------------------------------

data class LoadWindTurbineType1or2DynamicsFilter(val windTurbineType1or2DynamicsId :  UUID? = null )

class FindWindTurbineType1or2DynamicsQuery(val filter: LoadWindTurbineType1or2DynamicsFilter = LoadWindTurbineType1or2DynamicsFilter()) {
    override fun toString(): String = "LoadWindTurbineType1or2DynamicsQuery"
}

class FindAllWindTurbineType1or2DynamicsQuery() {
    override fun toString(): String = "LoadAllWindTurbineType1or2DynamicsQuery"
}

data class WindTurbineType1or2DynamicsFetchOneSummary(@Id var windTurbineType1or2DynamicsId : UUID? = null) {
}





// -----------------------------------------
// WindTurbineType1or2IEC Queries 
// -----------------------------------------

data class LoadWindTurbineType1or2IECFilter(val windTurbineType1or2IECId :  UUID? = null )

class FindWindTurbineType1or2IECQuery(val filter: LoadWindTurbineType1or2IECFilter = LoadWindTurbineType1or2IECFilter()) {
    override fun toString(): String = "LoadWindTurbineType1or2IECQuery"
}

class FindAllWindTurbineType1or2IECQuery() {
    override fun toString(): String = "LoadAllWindTurbineType1or2IECQuery"
}

data class WindTurbineType1or2IECFetchOneSummary(@Id var windTurbineType1or2IECId : UUID? = null) {
}





// -----------------------------------------
// WindTurbineType3or4Dynamics Queries 
// -----------------------------------------

data class LoadWindTurbineType3or4DynamicsFilter(val windTurbineType3or4DynamicsId :  UUID? = null )

class FindWindTurbineType3or4DynamicsQuery(val filter: LoadWindTurbineType3or4DynamicsFilter = LoadWindTurbineType3or4DynamicsFilter()) {
    override fun toString(): String = "LoadWindTurbineType3or4DynamicsQuery"
}

class FindAllWindTurbineType3or4DynamicsQuery() {
    override fun toString(): String = "LoadAllWindTurbineType3or4DynamicsQuery"
}

data class WindTurbineType3or4DynamicsFetchOneSummary(@Id var windTurbineType3or4DynamicsId : UUID? = null) {
}





// -----------------------------------------
// WindTurbineType3or4IEC Queries 
// -----------------------------------------

data class LoadWindTurbineType3or4IECFilter(val windTurbineType3or4IECId :  UUID? = null )

class FindWindTurbineType3or4IECQuery(val filter: LoadWindTurbineType3or4IECFilter = LoadWindTurbineType3or4IECFilter()) {
    override fun toString(): String = "LoadWindTurbineType3or4IECQuery"
}

class FindAllWindTurbineType3or4IECQuery() {
    override fun toString(): String = "LoadAllWindTurbineType3or4IECQuery"
}

data class WindTurbineType3or4IECFetchOneSummary(@Id var windTurbineType3or4IECId : UUID? = null) {
}





// -----------------------------------------
// WindTurbineType4aIEC Queries 
// -----------------------------------------

data class LoadWindTurbineType4aIECFilter(val windTurbineType4aIECId :  UUID? = null )

class FindWindTurbineType4aIECQuery(val filter: LoadWindTurbineType4aIECFilter = LoadWindTurbineType4aIECFilter()) {
    override fun toString(): String = "LoadWindTurbineType4aIECQuery"
}

class FindAllWindTurbineType4aIECQuery() {
    override fun toString(): String = "LoadAllWindTurbineType4aIECQuery"
}

data class WindTurbineType4aIECFetchOneSummary(@Id var windTurbineType4aIECId : UUID? = null) {
}





// -----------------------------------------
// WindTurbineType4bIEC Queries 
// -----------------------------------------

data class LoadWindTurbineType4bIECFilter(val windTurbineType4bIECId :  UUID? = null )

class FindWindTurbineType4bIECQuery(val filter: LoadWindTurbineType4bIECFilter = LoadWindTurbineType4bIECFilter()) {
    override fun toString(): String = "LoadWindTurbineType4bIECQuery"
}

class FindAllWindTurbineType4bIECQuery() {
    override fun toString(): String = "LoadAllWindTurbineType4bIECQuery"
}

data class WindTurbineType4bIECFetchOneSummary(@Id var windTurbineType4bIECId : UUID? = null) {
}





// -----------------------------------------
// WindType1or2UserDefined Queries 
// -----------------------------------------

data class LoadWindType1or2UserDefinedFilter(val windType1or2UserDefinedId :  UUID? = null )

class FindWindType1or2UserDefinedQuery(val filter: LoadWindType1or2UserDefinedFilter = LoadWindType1or2UserDefinedFilter()) {
    override fun toString(): String = "LoadWindType1or2UserDefinedQuery"
}

class FindAllWindType1or2UserDefinedQuery() {
    override fun toString(): String = "LoadAllWindType1or2UserDefinedQuery"
}

data class WindType1or2UserDefinedFetchOneSummary(@Id var windType1or2UserDefinedId : UUID? = null) {
}





// -----------------------------------------
// WindType3or4UserDefined Queries 
// -----------------------------------------

data class LoadWindType3or4UserDefinedFilter(val windType3or4UserDefinedId :  UUID? = null )

class FindWindType3or4UserDefinedQuery(val filter: LoadWindType3or4UserDefinedFilter = LoadWindType3or4UserDefinedFilter()) {
    override fun toString(): String = "LoadWindType3or4UserDefinedQuery"
}

class FindAllWindType3or4UserDefinedQuery() {
    override fun toString(): String = "LoadAllWindType3or4UserDefinedQuery"
}

data class WindType3or4UserDefinedFetchOneSummary(@Id var windType3or4UserDefinedId : UUID? = null) {
}






