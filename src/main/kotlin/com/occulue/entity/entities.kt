/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.entity;

import java.util.*

import javax.persistence.*
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery

import com.occulue.api.*;

// --------------------------------------------
// Entity Definitions
// --------------------------------------------
@Entity
data class ACDCConverter(
    @Id var aCDCConverterId: UUID? = null,
    var baseS: String? = null,
    var idleLoss: String? = null,
    var maxUdc: String? = null,
    var minUdc: String? = null,
    var numberOfValves: String? = null,
    var ratedUdc: String? = null,
    var resistiveLoss: String? = null,
    var switchingLoss: String? = null,
    var valveU0: String? = null
)

@Entity
data class ACDCConverterDCTerminal(
    @Id var aCDCConverterDCTerminalId: UUID? = null,
    var polarity: String? = null
)

@Entity
data class ACDCTerminal(
    @Id var aCDCTerminalId: UUID? = null,
    var sequenceNumber: String? = null
)

@Entity
data class ACLineSegment(
    @Id var aCLineSegmentId: UUID? = null,
    var b0ch: String? = null,
    var bch: String? = null,
    var g0ch: String? = null,
    var gch: String? = null,
    var r: String? = null,
    var r0: String? = null,
    var shortCircuitEndTemperature: String? = null,
    var x: String? = null,
    var x0: String? = null
)

@Entity
data class Accumulator(
     var accumulatorId: UUID? = null
)

@Entity
data class AccumulatorLimit(
    @Id var accumulatorLimitId: UUID? = null,
    var value: String? = null
)

@Entity
data class AccumulatorLimitSet(
     var accumulatorLimitSetId: UUID? = null
)

@Entity
data class AccumulatorReset(
     var accumulatorResetId: UUID? = null
)

@Entity
data class AccumulatorValue(
    @Id var accumulatorValueId: UUID? = null,
    var value: String? = null
)

@Entity
data class ActivePower(
    @Id var activePowerId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class ActivePowerLimit(
    @Id var activePowerLimitId: UUID? = null,
    var value: String? = null
)

@Entity
data class ActivePowerPerCurrentFlow(
    @Id var activePowerPerCurrentFlowId: UUID? = null,
    var denominatorMultiplier: String? = null,
    var denominatorUnit: String? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class ActivePowerPerFrequency(
    @Id var activePowerPerFrequencyId: UUID? = null,
    var denominatorMultiplier: String? = null,
    var denominatorUnit: String? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class Analog(
    @Id var analogId: UUID? = null,
    var positiveFlowIn: String? = null
)

@Entity
data class AnalogControl(
    @Id var analogControlId: UUID? = null,
    var maxValue: String? = null,
    var minValue: String? = null
)

@Entity
data class AnalogLimit(
    @Id var analogLimitId: UUID? = null,
    var value: String? = null
)

@Entity
data class AnalogLimitSet(
     var analogLimitSetId: UUID? = null
)

@Entity
data class AnalogValue(
    @Id var analogValueId: UUID? = null,
    var value: String? = null
)

@Entity
data class AngleDegrees(
    @Id var angleDegreesId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class AngleRadians(
    @Id var angleRadiansId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class ApparentPower(
    @Id var apparentPowerId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class ApparentPowerLimit(
    @Id var apparentPowerLimitId: UUID? = null,
    var value: String? = null
)

@Entity
data class Area(
    @Id var areaId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class AsynchronousMachine(
    @Id var asynchronousMachineId: UUID? = null,
    var converterFedDrive: String? = null,
    var efficiency: String? = null,
    var iaIrRatio: String? = null,
    var nominalFrequency: String? = null,
    var nominalSpeed: String? = null,
    var polePairNumber: String? = null,
    var ratedMechanicalPower: String? = null,
    var reversible: String? = null,
    var rxLockedRotorRatio: String? = null
)

@Entity
data class AsynchronousMachineDynamics(
     var asynchronousMachineDynamicsId: UUID? = null
)

@Entity
data class AsynchronousMachineEquivalentCircuit(
    @Id var asynchronousMachineEquivalentCircuitId: UUID? = null,
    var rr1: String? = null,
    var rr2: String? = null,
    var xlr1: String? = null,
    var xlr2: String? = null,
    var xm: String? = null
)

@Entity
data class AsynchronousMachineTimeConstantReactance(
    @Id var asynchronousMachineTimeConstantReactanceId: UUID? = null,
    var tpo: String? = null,
    var tppo: String? = null,
    var xp: String? = null,
    var xpp: String? = null,
    var xs: String? = null
)

@Entity
data class AsynchronousMachineUserDefined(
    @Id var asynchronousMachineUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class BaseVoltage(
    @Id var baseVoltageId: UUID? = null,
    var nominalVoltage: String? = null
)

@Entity
data class BasicIntervalSchedule(
    @Id var basicIntervalScheduleId: UUID? = null,
    var startTime: String? = null,
    var value1Unit: String? = null,
    var value2Unit: String? = null
)

@Entity
data class Bay(
     var bayId: UUID? = null
)

@Entity
data class BooleanProxy(
     var booleanProxyId: UUID? = null
)

@Entity
data class BoundaryExtensions(
    @Id var boundaryExtensionsId: UUID? = null,
    var boundaryPoint: String? = null,
    var fromEndIsoCode: String? = null,
    var fromEndName: String? = null,
    var fromEndNameTso: String? = null,
    var toEndIsoCode: String? = null,
    var toEndName: String? = null,
    var toEndNameTso: String? = null
)

@Entity
data class Breaker(
     var breakerId: UUID? = null
)

@Entity
data class BusNameMarker(
    @Id var busNameMarkerId: UUID? = null,
    var priority: String? = null
)

@Entity
data class BusbarSection(
    @Id var busbarSectionId: UUID? = null,
    var ipMax: String? = null
)

@Entity
data class Capacitance(
    @Id var capacitanceId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class CapacitancePerLength(
    @Id var capacitancePerLengthId: UUID? = null,
    var denominatorMultiplier: String? = null,
    var denominatorUnit: String? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class Command(
    @Id var commandId: UUID? = null,
    var normalValue: String? = null,
    var value: String? = null
)

@Entity
data class Conductance(
    @Id var conductanceId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class ConductingEquipment(
     var conductingEquipmentId: UUID? = null
)

@Entity
data class Conductor(
    @Id var conductorId: UUID? = null,
    var length: String? = null
)

@Entity
data class ConformLoad(
     var conformLoadId: UUID? = null
)

@Entity
data class ConformLoadGroup(
     var conformLoadGroupId: UUID? = null
)

@Entity
data class ConformLoadSchedule(
     var conformLoadScheduleId: UUID? = null
)

@Entity
data class ConnectivityNode(
    @Id var connectivityNodeId: UUID? = null,
    var boundaryPoint: String? = null,
    var fromEndIsoCode: String? = null,
    var fromEndName: String? = null,
    var fromEndNameTso: String? = null,
    var toEndIsoCode: String? = null,
    var toEndName: String? = null,
    var toEndNameTso: String? = null
)

@Entity
data class ConnectivityNodeContainer(
     var connectivityNodeContainerId: UUID? = null
)

@Entity
data class Connector(
     var connectorId: UUID? = null
)

@Entity
data class Control(
    @Id var controlId: UUID? = null,
    var controlType: String? = null,
    var operationInProgress: String? = null,
    var timeStamp: String? = null,
    var unitMultiplier: String? = null,
    var unitSymbol: String? = null
)

@Entity
data class ControlArea(
    @Id var controlAreaId: UUID? = null,
    var type: String? = null
)

@Entity
data class ControlAreaGeneratingUnit(
     var controlAreaGeneratingUnitId: UUID? = null
)

@Entity
data class CoordinateSystem(
    @Id var coordinateSystemId: UUID? = null,
    var crsUrn: String? = null
)

@Entity
data class CsConverter(
    @Id var csConverterId: UUID? = null,
    var maxAlpha: String? = null,
    var maxGamma: String? = null,
    var maxIdc: String? = null,
    var minAlpha: String? = null,
    var minGamma: String? = null,
    var minIdc: String? = null,
    var ratedIdc: String? = null
)

@Entity
data class CurrentFlow(
    @Id var currentFlowId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class CurrentLimit(
    @Id var currentLimitId: UUID? = null,
    var value: String? = null
)

@Entity
data class Curve(
    @Id var curveId: UUID? = null,
    var curveStyle: String? = null,
    var xUnit: String? = null,
    var y1Unit: String? = null,
    var y2Unit: String? = null
)

@Entity
data class CurveData(
    @Id var curveDataId: UUID? = null,
    var xvalue: String? = null,
    var y1value: String? = null,
    var y2value: String? = null
)

@Entity
data class DCBaseTerminal(
     var dCBaseTerminalId: UUID? = null
)

@Entity
data class DCBreaker(
     var dCBreakerId: UUID? = null
)

@Entity
data class DCBusbar(
     var dCBusbarId: UUID? = null
)

@Entity
data class DCChopper(
     var dCChopperId: UUID? = null
)

@Entity
data class DCConductingEquipment(
     var dCConductingEquipmentId: UUID? = null
)

@Entity
data class DCConverterUnit(
    @Id var dCConverterUnitId: UUID? = null,
    var operationMode: String? = null
)

@Entity
data class DCDisconnector(
     var dCDisconnectorId: UUID? = null
)

@Entity
data class DCEquipmentContainer(
     var dCEquipmentContainerId: UUID? = null
)

@Entity
data class DCGround(
    @Id var dCGroundId: UUID? = null,
    var inductance: String? = null,
    var r: String? = null
)

@Entity
data class DCLine(
     var dCLineId: UUID? = null
)

@Entity
data class DCLineSegment(
    @Id var dCLineSegmentId: UUID? = null,
    var capacitance: String? = null,
    var inductance: String? = null,
    var length: String? = null,
    var resistance: String? = null
)

@Entity
data class DCNode(
     var dCNodeId: UUID? = null
)

@Entity
data class DCSeriesDevice(
    @Id var dCSeriesDeviceId: UUID? = null,
    var inductance: String? = null,
    var ratedUdc: String? = null,
    var resistance: String? = null
)

@Entity
data class DCShunt(
    @Id var dCShuntId: UUID? = null,
    var capacitance: String? = null,
    var ratedUdc: String? = null,
    var resistance: String? = null
)

@Entity
data class DCSwitch(
     var dCSwitchId: UUID? = null
)

@Entity
data class DCTerminal(
     var dCTerminalId: UUID? = null
)

@Entity
data class DCTopologicalIsland(
     var dCTopologicalIslandId: UUID? = null
)

@Entity
data class DCTopologicalNode(
     var dCTopologicalNodeId: UUID? = null
)

@Entity
data class DateProxy(
     var dateProxyId: UUID? = null
)

@Entity
data class DateTime(
     var dateTimeId: UUID? = null
)

@Entity
data class DayType(
     var dayTypeId: UUID? = null
)

@Entity
data class DecimalProxy(
     var decimalProxyId: UUID? = null
)

@Entity
data class Diagram(
    @Id var diagramId: UUID? = null,
    var orientation: String? = null,
    var x1InitialView: String? = null,
    var x2InitialView: String? = null,
    var y1InitialView: String? = null,
    var y2InitialView: String? = null
)

@Entity
data class DiagramLayoutVersion(
    @Id var diagramLayoutVersionId: UUID? = null,
    var baseUML: String? = null,
    var baseURI: String? = null,
    var date: String? = null,
    var differenceModelURI: String? = null,
    var entsoeUML: String? = null,
    var entsoeURI: String? = null,
    var modelDescriptionURI: String? = null,
    var namespaceRDF: String? = null,
    var namespaceUML: String? = null,
    var shortName: String? = null
)

@Entity
data class DiagramObject(
    @Id var diagramObjectId: UUID? = null,
    var drawingOrder: String? = null,
    var isPolygon: String? = null,
    var offsetX: String? = null,
    var offsetY: String? = null,
    var rotation: String? = null
)

@Entity
data class DiagramObjectGluePoint(
     var diagramObjectGluePointId: UUID? = null
)

@Entity
data class DiagramObjectPoint(
    @Id var diagramObjectPointId: UUID? = null,
    var sequenceNumber: String? = null,
    var xPosition: String? = null,
    var yPosition: String? = null,
    var zPosition: String? = null
)

@Entity
data class DiagramObjectStyle(
     var diagramObjectStyleId: UUID? = null
)

@Entity
data class DiagramStyle(
     var diagramStyleId: UUID? = null
)

@Entity
data class DiscExcContIEEEDEC1A(
    @Id var discExcContIEEEDEC1AId: UUID? = null,
    var esc: String? = null,
    var kan: String? = null,
    var ketl: String? = null,
    var tan: String? = null,
    var td: String? = null,
    var tl1: String? = null,
    var tl2: String? = null,
    var tw5: String? = null,
    var value: String? = null,
    var vanmax: String? = null,
    var vomax: String? = null,
    var vomin: String? = null,
    var vsmax: String? = null,
    var vsmin: String? = null,
    var vtc: String? = null,
    var vtlmt: String? = null,
    var vtm: String? = null,
    var vtn: String? = null
)

@Entity
data class DiscExcContIEEEDEC2A(
    @Id var discExcContIEEEDEC2AId: UUID? = null,
    var td1: String? = null,
    var td2: String? = null,
    var vdmax: String? = null,
    var vdmin: String? = null,
    var vk: String? = null
)

@Entity
data class DiscExcContIEEEDEC3A(
    @Id var discExcContIEEEDEC3AId: UUID? = null,
    var tdr: String? = null,
    var vtmin: String? = null
)

@Entity
data class Disconnector(
     var disconnectorId: UUID? = null
)

@Entity
data class DiscontinuousExcitationControlDynamics(
     var discontinuousExcitationControlDynamicsId: UUID? = null
)

@Entity
data class DiscontinuousExcitationControlUserDefined(
    @Id var discontinuousExcitationControlUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class Discrete(
     var discreteId: UUID? = null
)

@Entity
data class DiscreteValue(
    @Id var discreteValueId: UUID? = null,
    var value: String? = null
)

@Entity
data class DomainVersion(
    @Id var domainVersionId: UUID? = null,
    var baseUML: String? = null,
    var date: String? = null,
    var entsoeUML: String? = null,
    var version: String? = null
)

@Entity
data class DynamicsFunctionBlock(
    @Id var dynamicsFunctionBlockId: UUID? = null,
    var enabled: String? = null
)

@Entity
data class DynamicsVersion(
    @Id var dynamicsVersionId: UUID? = null,
    var baseUML: String? = null,
    var baseURI: String? = null,
    var date: String? = null,
    var differenceModelURI: String? = null,
    var entsoeUML: String? = null,
    var entsoeURI: String? = null,
    var modelDescriptionURI: String? = null,
    var namespaceRDF: String? = null,
    var namespaceUML: String? = null,
    var shortName: String? = null
)

@Entity
data class Dynamicsmodel(
     var dynamicsmodelId: UUID? = null
)

@Entity
data class ENTSOEConnectivityNode(
     var eNTSOEConnectivityNodeId: UUID? = null
)

@Entity
data class ENTSOEIdentifiedObject(
    @Id var eNTSOEIdentifiedObjectId: UUID? = null,
    var energyIdentCodeEic: String? = null,
    var shortName: String? = null
)

@Entity
data class ENTSOEJunction(
     var eNTSOEJunctionId: UUID? = null
)

@Entity
data class ENTSOEOperationalLimitType(
    @Id var eNTSOEOperationalLimitTypeId: UUID? = null,
    var limitType: String? = null
)

@Entity
data class ENTSOETopologicalNode(
     var eNTSOETopologicalNodeId: UUID? = null
)

@Entity
data class EarthFaultCompensator(
    @Id var earthFaultCompensatorId: UUID? = null,
    var r: String? = null
)

@Entity
data class EnergyArea(
     var energyAreaId: UUID? = null
)

@Entity
data class EnergyConsumer(
    @Id var energyConsumerId: UUID? = null,
    var pfixed: String? = null,
    var pfixedPct: String? = null,
    var qfixed: String? = null,
    var qfixedPct: String? = null
)

@Entity
data class EnergySchedulingType(
     var energySchedulingTypeId: UUID? = null
)

@Entity
data class EnergySource(
     var energySourceId: UUID? = null
)

@Entity
data class Equipment(
     var equipmentId: UUID? = null
)

@Entity
data class EquipmentBoundaryVersion(
    @Id var equipmentBoundaryVersionId: UUID? = null,
    var baseUML: String? = null,
    var baseURI: String? = null,
    var date: String? = null,
    var differenceModelURI: String? = null,
    var entsoeUML: String? = null,
    var entsoeURIcore: String? = null,
    var entsoeURIoperation: String? = null,
    var modelDescriptionURI: String? = null,
    var namespaceRDF: String? = null,
    var namespaceUML: String? = null,
    var shortName: String? = null
)

@Entity
data class EquipmentContainer(
     var equipmentContainerId: UUID? = null
)

@Entity
data class EquipmentVersion(
    @Id var equipmentVersionId: UUID? = null,
    var baseUML: String? = null,
    var baseURIcore: String? = null,
    var baseURIoperation: String? = null,
    var baseURIshortCircuit: String? = null,
    var date: String? = null,
    var differenceModelURI: String? = null,
    var entsoeUML: String? = null,
    var entsoeURIcore: String? = null,
    var entsoeURIoperation: String? = null,
    var entsoeURIshortCircuit: String? = null,
    var modelDescriptionURI: String? = null,
    var namespaceRDF: String? = null,
    var namespaceUML: String? = null,
    var shortName: String? = null
)

@Entity
data class EquivalentBranch(
    @Id var equivalentBranchId: UUID? = null,
    var negativeR12: String? = null,
    var negativeR21: String? = null,
    var negativeX12: String? = null,
    var negativeX21: String? = null,
    var positiveR12: String? = null,
    var positiveR21: String? = null,
    var positiveX12: String? = null,
    var positiveX21: String? = null,
    var r: String? = null,
    var r21: String? = null,
    var x: String? = null,
    var x21: String? = null,
    var zeroR12: String? = null,
    var zeroR21: String? = null,
    var zeroX12: String? = null,
    var zeroX21: String? = null
)

@Entity
data class EquivalentEquipment(
     var equivalentEquipmentId: UUID? = null
)

@Entity
data class EquivalentInjection(
    @Id var equivalentInjectionId: UUID? = null,
    var maxP: String? = null,
    var maxQ: String? = null,
    var minP: String? = null,
    var minQ: String? = null,
    var r: String? = null,
    var r0: String? = null,
    var r2: String? = null,
    var regulationCapability: String? = null,
    var x: String? = null,
    var x0: String? = null,
    var x2: String? = null
)

@Entity
data class EquivalentNetwork(
     var equivalentNetworkId: UUID? = null
)

@Entity
data class EquivalentShunt(
    @Id var equivalentShuntId: UUID? = null,
    var b: String? = null,
    var g: String? = null
)

@Entity
data class ExcAC1A(
    @Id var excAC1AId: UUID? = null,
    var hvlvgates: String? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var kf1: String? = null,
    var kf2: String? = null,
    var ks: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcAC2A(
    @Id var excAC2AId: UUID? = null,
    var hvgate: String? = null,
    var ka: String? = null,
    var kb: String? = null,
    var kb1: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var kh: String? = null,
    var kl: String? = null,
    var kl1: String? = null,
    var ks: String? = null,
    var lvgate: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var vfemax: String? = null,
    var vlr: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcAC3A(
    @Id var excAC3AId: UUID? = null,
    var efdn: String? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var kf1: String? = null,
    var kf2: String? = null,
    var klv: String? = null,
    var kn: String? = null,
    var kr: String? = null,
    var ks: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var vemin: String? = null,
    var vfemax: String? = null,
    var vlv: String? = null
)

@Entity
data class ExcAC4A(
    @Id var excAC4AId: UUID? = null,
    var ka: String? = null,
    var kc: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var vimax: String? = null,
    var vimin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcAC5A(
    @Id var excAC5AId: UUID? = null,
    var a: String? = null,
    var efd1: String? = null,
    var efd2: String? = null,
    var ka: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var ks: String? = null,
    var seefd1: String? = null,
    var seefd2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf1: String? = null,
    var tf2: String? = null,
    var tf3: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcAC6A(
    @Id var excAC6AId: UUID? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var ke: String? = null,
    var kh: String? = null,
    var ks: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var th: String? = null,
    var tj: String? = null,
    var tk: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var vfelim: String? = null,
    var vhmax: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcAC8B(
    @Id var excAC8BId: UUID? = null,
    var inlim: String? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var kdr: String? = null,
    var ke: String? = null,
    var kir: String? = null,
    var kpr: String? = null,
    var ks: String? = null,
    var pidlim: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var ta: String? = null,
    var tdr: String? = null,
    var te: String? = null,
    var telim: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var vemin: String? = null,
    var vfemax: String? = null,
    var vimax: String? = null,
    var vimin: String? = null,
    var vpidmax: String? = null,
    var vpidmin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null,
    var vtmult: String? = null
)

@Entity
data class ExcANS(
    @Id var excANSId: UUID? = null,
    var blint: String? = null,
    var ifmn: String? = null,
    var ifmx: String? = null,
    var k2: String? = null,
    var k3: String? = null,
    var kce: String? = null,
    var krvecc: String? = null,
    var kvfif: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var tb: String? = null,
    var vrmn: String? = null,
    var vrmx: String? = null
)

@Entity
data class ExcAVR1(
    @Id var excAVR1Id: UUID? = null,
    var e1: String? = null,
    var e2: String? = null,
    var ka: String? = null,
    var kf: String? = null,
    var se1: String? = null,
    var se2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var vrmn: String? = null,
    var vrmx: String? = null
)

@Entity
data class ExcAVR2(
    @Id var excAVR2Id: UUID? = null,
    var e1: String? = null,
    var e2: String? = null,
    var ka: String? = null,
    var kf: String? = null,
    var se1: String? = null,
    var se2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var te: String? = null,
    var tf1: String? = null,
    var tf2: String? = null,
    var vrmn: String? = null,
    var vrmx: String? = null
)

@Entity
data class ExcAVR3(
    @Id var excAVR3Id: UUID? = null,
    var e1: String? = null,
    var e2: String? = null,
    var ka: String? = null,
    var se1: String? = null,
    var se2: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var te: String? = null,
    var vrmn: String? = null,
    var vrmx: String? = null
)

@Entity
data class ExcAVR4(
    @Id var excAVR4Id: UUID? = null,
    var imul: String? = null,
    var ka: String? = null,
    var ke: String? = null,
    var kif: String? = null,
    var t1: String? = null,
    var t1if: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var tif: String? = null,
    var vfmn: String? = null,
    var vfmx: String? = null,
    var vrmn: String? = null,
    var vrmx: String? = null
)

@Entity
data class ExcAVR5(
    @Id var excAVR5Id: UUID? = null,
    var ka: String? = null,
    var rex: String? = null,
    var ta: String? = null
)

@Entity
data class ExcAVR7(
    @Id var excAVR7Id: UUID? = null,
    var a1: String? = null,
    var a2: String? = null,
    var a3: String? = null,
    var a4: String? = null,
    var a5: String? = null,
    var a6: String? = null,
    var k1: String? = null,
    var k3: String? = null,
    var k5: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var vmax1: String? = null,
    var vmax3: String? = null,
    var vmax5: String? = null,
    var vmin1: String? = null,
    var vmin3: String? = null,
    var vmin5: String? = null
)

@Entity
data class ExcBBC(
    @Id var excBBCId: UUID? = null,
    var efdmax: String? = null,
    var efdmin: String? = null,
    var k: String? = null,
    var switchIt: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null,
    var xe: String? = null
)

@Entity
data class ExcCZ(
    @Id var excCZId: UUID? = null,
    var efdmax: String? = null,
    var efdmin: String? = null,
    var ka: String? = null,
    var ke: String? = null,
    var kp: String? = null,
    var ta: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcDC1A(
    @Id var excDC1AId: UUID? = null,
    var edfmax: String? = null,
    var efd1: String? = null,
    var efd2: String? = null,
    var efdmin: String? = null,
    var exclim: String? = null,
    var ka: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var ks: String? = null,
    var seefd1: String? = null,
    var seefd2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcDC2A(
    @Id var excDC2AId: UUID? = null,
    var efd1: String? = null,
    var efd2: String? = null,
    var exclim: String? = null,
    var ka: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var ks: String? = null,
    var seefd1: String? = null,
    var seefd2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var tf1: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null,
    var vtlim: String? = null
)

@Entity
data class ExcDC3A(
    @Id var excDC3AId: UUID? = null,
    var edfmax: String? = null,
    var efd1: String? = null,
    var efd2: String? = null,
    var efdlim: String? = null,
    var efdmin: String? = null,
    var exclim: String? = null,
    var ke: String? = null,
    var kr: String? = null,
    var ks: String? = null,
    var kv: String? = null,
    var seefd1: String? = null,
    var seefd2: String? = null,
    var te: String? = null,
    var trh: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcDC3A1(
    @Id var excDC3A1Id: UUID? = null,
    var exclim: String? = null,
    var ka: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var ta: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var vb1max: String? = null,
    var vblim: String? = null,
    var vbmax: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcELIN1(
    @Id var excELIN1Id: UUID? = null,
    var dpnf: String? = null,
    var efmax: String? = null,
    var efmin: String? = null,
    var ks1: String? = null,
    var ks2: String? = null,
    var smax: String? = null,
    var tfi: String? = null,
    var tnu: String? = null,
    var ts1: String? = null,
    var ts2: String? = null,
    var tsw: String? = null,
    var vpi: String? = null,
    var vpnf: String? = null,
    var vpu: String? = null,
    var xe: String? = null
)

@Entity
data class ExcELIN2(
    @Id var excELIN2Id: UUID? = null,
    var efdbas: String? = null,
    var iefmax: String? = null,
    var iefmax2: String? = null,
    var iefmin: String? = null,
    var k1: String? = null,
    var k1ec: String? = null,
    var k2: String? = null,
    var k3: String? = null,
    var k4: String? = null,
    var kd1: String? = null,
    var ke2: String? = null,
    var ketb: String? = null,
    var pid1max: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var tb1: String? = null,
    var te: String? = null,
    var te2: String? = null,
    var ti1: String? = null,
    var ti3: String? = null,
    var ti4: String? = null,
    var tr4: String? = null,
    var upmax: String? = null,
    var upmin: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var xp: String? = null
)

@Entity
data class ExcHU(
    @Id var excHUId: UUID? = null,
    var ae: String? = null,
    var ai: String? = null,
    var atr: String? = null,
    var emax: String? = null,
    var emin: String? = null,
    var imax: String? = null,
    var imin: String? = null,
    var ke: String? = null,
    var ki: String? = null,
    var te: String? = null,
    var ti: String? = null,
    var tr: String? = null
)

@Entity
data class ExcIEEEAC1A(
    @Id var excIEEEAC1AId: UUID? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEAC2A(
    @Id var excIEEEAC2AId: UUID? = null,
    var ka: String? = null,
    var kb: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var kh: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var vfemax: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEAC3A(
    @Id var excIEEEAC3AId: UUID? = null,
    var efdn: String? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var kn: String? = null,
    var kr: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var vemin: String? = null,
    var vfemax: String? = null
)

@Entity
data class ExcIEEEAC4A(
    @Id var excIEEEAC4AId: UUID? = null,
    var ka: String? = null,
    var kc: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var vimax: String? = null,
    var vimin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEAC5A(
    @Id var excIEEEAC5AId: UUID? = null,
    var efd1: String? = null,
    var efd2: String? = null,
    var ka: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var seefd1: String? = null,
    var seefd2: String? = null,
    var ta: String? = null,
    var te: String? = null,
    var tf1: String? = null,
    var tf2: String? = null,
    var tf3: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEAC6A(
    @Id var excIEEEAC6AId: UUID? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var ke: String? = null,
    var kh: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var th: String? = null,
    var tj: String? = null,
    var tk: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var vfelim: String? = null,
    var vhmax: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEAC7B(
    @Id var excIEEEAC7BId: UUID? = null,
    var kc: String? = null,
    var kd: String? = null,
    var kdr: String? = null,
    var ke: String? = null,
    var kf1: String? = null,
    var kf2: String? = null,
    var kf3: String? = null,
    var kia: String? = null,
    var kir: String? = null,
    var kl: String? = null,
    var kp: String? = null,
    var kpa: String? = null,
    var kpr: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var tdr: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var vemin: String? = null,
    var vfemax: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEAC8B(
    @Id var excIEEEAC8BId: UUID? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var kdr: String? = null,
    var ke: String? = null,
    var kir: String? = null,
    var kpr: String? = null,
    var seve1: String? = null,
    var seve2: String? = null,
    var ta: String? = null,
    var tdr: String? = null,
    var te: String? = null,
    var ve1: String? = null,
    var ve2: String? = null,
    var vemin: String? = null,
    var vfemax: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEDC1A(
    @Id var excIEEEDC1AId: UUID? = null,
    var efd1: String? = null,
    var efd2: String? = null,
    var exclim: String? = null,
    var ka: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var seefd1: String? = null,
    var seefd2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var uelin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEDC2A(
    @Id var excIEEEDC2AId: UUID? = null,
    var efd1: String? = null,
    var efd2: String? = null,
    var exclim: String? = null,
    var ka: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var seefd1: String? = null,
    var seefd2: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var uelin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEDC3A(
    @Id var excIEEEDC3AId: UUID? = null,
    var efd1: String? = null,
    var efd2: String? = null,
    var exclim: String? = null,
    var ke: String? = null,
    var kv: String? = null,
    var seefd1: String? = null,
    var seefd2: String? = null,
    var te: String? = null,
    var trh: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEDC4B(
    @Id var excIEEEDC4BId: UUID? = null,
    var efd1: String? = null,
    var efd2: String? = null,
    var ka: String? = null,
    var kd: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var oelin: String? = null,
    var seefd1: String? = null,
    var seefd2: String? = null,
    var ta: String? = null,
    var td: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var uelin: String? = null,
    var vemin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEST1A(
    @Id var excIEEEST1AId: UUID? = null,
    var ilr: String? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kf: String? = null,
    var klr: String? = null,
    var pssin: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tb1: String? = null,
    var tc: String? = null,
    var tc1: String? = null,
    var tf: String? = null,
    var uelin: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var vimax: String? = null,
    var vimin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEST2A(
    @Id var excIEEEST2AId: UUID? = null,
    var efdmax: String? = null,
    var ka: String? = null,
    var kc: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var ta: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var uelin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEST3A(
    @Id var excIEEEST3AId: UUID? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kg: String? = null,
    var ki: String? = null,
    var km: String? = null,
    var kp: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var thetap: String? = null,
    var tm: String? = null,
    var vbmax: String? = null,
    var vgmax: String? = null,
    var vimax: String? = null,
    var vimin: String? = null,
    var vmmax: String? = null,
    var vmmin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null,
    var xl: String? = null
)

@Entity
data class ExcIEEEST4B(
    @Id var excIEEEST4BId: UUID? = null,
    var kc: String? = null,
    var kg: String? = null,
    var ki: String? = null,
    var kim: String? = null,
    var kir: String? = null,
    var kp: String? = null,
    var kpm: String? = null,
    var kpr: String? = null,
    var ta: String? = null,
    var thetap: String? = null,
    var vbmax: String? = null,
    var vmmax: String? = null,
    var vmmin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null,
    var xl: String? = null
)

@Entity
data class ExcIEEEST5B(
    @Id var excIEEEST5BId: UUID? = null,
    var kc: String? = null,
    var kr: String? = null,
    var t1: String? = null,
    var tb1: String? = null,
    var tb2: String? = null,
    var tc1: String? = null,
    var tc2: String? = null,
    var tob1: String? = null,
    var tob2: String? = null,
    var toc1: String? = null,
    var toc2: String? = null,
    var tub1: String? = null,
    var tub2: String? = null,
    var tuc1: String? = null,
    var tuc2: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEST6B(
    @Id var excIEEEST6BId: UUID? = null,
    var ilr: String? = null,
    var kci: String? = null,
    var kff: String? = null,
    var kg: String? = null,
    var kia: String? = null,
    var klr: String? = null,
    var km: String? = null,
    var kpa: String? = null,
    var oelin: String? = null,
    var tg: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcIEEEST7B(
    @Id var excIEEEST7BId: UUID? = null,
    var kh: String? = null,
    var kia: String? = null,
    var kl: String? = null,
    var kpa: String? = null,
    var oelin: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var tf: String? = null,
    var tg: String? = null,
    var tia: String? = null,
    var uelin: String? = null,
    var vmax: String? = null,
    var vmin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcOEX3T(
    @Id var excOEX3TId: UUID? = null,
    var e1: String? = null,
    var e2: String? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var see1: String? = null,
    var see2: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcPIC(
    @Id var excPICId: UUID? = null,
    var e1: String? = null,
    var e2: String? = null,
    var efdmax: String? = null,
    var efdmin: String? = null,
    var ka: String? = null,
    var kc: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var se1: String? = null,
    var se2: String? = null,
    var ta1: String? = null,
    var ta2: String? = null,
    var ta3: String? = null,
    var ta4: String? = null,
    var te: String? = null,
    var tf1: String? = null,
    var tf2: String? = null,
    var vr1: String? = null,
    var vr2: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcREXS(
    @Id var excREXSId: UUID? = null,
    var e1: String? = null,
    var e2: String? = null,
    var fbf: String? = null,
    var flimf: String? = null,
    var kc: String? = null,
    var kd: String? = null,
    var ke: String? = null,
    var kefd: String? = null,
    var kf: String? = null,
    var kh: String? = null,
    var kii: String? = null,
    var kip: String? = null,
    var ks: String? = null,
    var kvi: String? = null,
    var kvp: String? = null,
    var kvphz: String? = null,
    var nvphz: String? = null,
    var se1: String? = null,
    var se2: String? = null,
    var ta: String? = null,
    var tb1: String? = null,
    var tb2: String? = null,
    var tc1: String? = null,
    var tc2: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var tf1: String? = null,
    var tf2: String? = null,
    var tp: String? = null,
    var vcmax: String? = null,
    var vfmax: String? = null,
    var vfmin: String? = null,
    var vimax: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null,
    var xc: String? = null
)

@Entity
data class ExcSCRX(
    @Id var excSCRXId: UUID? = null,
    var cswitch: String? = null,
    var emax: String? = null,
    var emin: String? = null,
    var k: String? = null,
    var rcrfd: String? = null,
    var tatb: String? = null,
    var tb: String? = null,
    var te: String? = null
)

@Entity
data class ExcSEXS(
    @Id var excSEXSId: UUID? = null,
    var efdmax: String? = null,
    var efdmin: String? = null,
    var emax: String? = null,
    var emin: String? = null,
    var k: String? = null,
    var kc: String? = null,
    var tatb: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null
)

@Entity
data class ExcSK(
    @Id var excSKId: UUID? = null,
    var efdmax: String? = null,
    var efdmin: String? = null,
    var emax: String? = null,
    var emin: String? = null,
    var k: String? = null,
    var k1: String? = null,
    var k2: String? = null,
    var kc: String? = null,
    var kce: String? = null,
    var kd: String? = null,
    var kgob: String? = null,
    var kp: String? = null,
    var kqi: String? = null,
    var kqob: String? = null,
    var kqp: String? = null,
    var nq: String? = null,
    var qconoff: String? = null,
    var qz: String? = null,
    var remote: String? = null,
    var sbase: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var ti: String? = null,
    var tp: String? = null,
    var tr: String? = null,
    var uimax: String? = null,
    var uimin: String? = null,
    var urmax: String? = null,
    var urmin: String? = null,
    var vtmax: String? = null,
    var vtmin: String? = null,
    var yp: String? = null
)

@Entity
data class ExcST1A(
    @Id var excST1AId: UUID? = null,
    var ilr: String? = null,
    var ka: String? = null,
    var kc: String? = null,
    var kf: String? = null,
    var klr: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tb1: String? = null,
    var tc: String? = null,
    var tc1: String? = null,
    var tf: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var vimax: String? = null,
    var vimin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null,
    var xe: String? = null
)

@Entity
data class ExcST2A(
    @Id var excST2AId: UUID? = null,
    var efdmax: String? = null,
    var ka: String? = null,
    var kc: String? = null,
    var ke: String? = null,
    var kf: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var te: String? = null,
    var tf: String? = null,
    var uelin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcST3A(
    @Id var excST3AId: UUID? = null,
    var efdmax: String? = null,
    var kc: String? = null,
    var kg: String? = null,
    var ki: String? = null,
    var kj: String? = null,
    var km: String? = null,
    var kp: String? = null,
    var ks: String? = null,
    var ks1: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var thetap: String? = null,
    var tm: String? = null,
    var vbmax: String? = null,
    var vgmax: String? = null,
    var vimax: String? = null,
    var vimin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null,
    var xl: String? = null
)

@Entity
data class ExcST4B(
    @Id var excST4BId: UUID? = null,
    var kc: String? = null,
    var kg: String? = null,
    var ki: String? = null,
    var kim: String? = null,
    var kir: String? = null,
    var kp: String? = null,
    var kpm: String? = null,
    var kpr: String? = null,
    var lvgate: String? = null,
    var ta: String? = null,
    var thetap: String? = null,
    var uel: String? = null,
    var vbmax: String? = null,
    var vgmax: String? = null,
    var vmmax: String? = null,
    var vmmin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null,
    var xl: String? = null
)

@Entity
data class ExcST6B(
    @Id var excST6BId: UUID? = null,
    var ilr: String? = null,
    var k1: String? = null,
    var kcl: String? = null,
    var kff: String? = null,
    var kg: String? = null,
    var kia: String? = null,
    var klr: String? = null,
    var km: String? = null,
    var kpa: String? = null,
    var kvd: String? = null,
    var oelin: String? = null,
    var tg: String? = null,
    var ts: String? = null,
    var tvd: String? = null,
    var vamax: String? = null,
    var vamin: String? = null,
    var vilim: String? = null,
    var vimax: String? = null,
    var vimin: String? = null,
    var vmult: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null,
    var xc: String? = null
)

@Entity
data class ExcST7B(
    @Id var excST7BId: UUID? = null,
    var kh: String? = null,
    var kia: String? = null,
    var kl: String? = null,
    var kpa: String? = null,
    var oelin: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var tf: String? = null,
    var tg: String? = null,
    var tia: String? = null,
    var ts: String? = null,
    var uelin: String? = null,
    var vmax: String? = null,
    var vmin: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class ExcitationSystemDynamics(
     var excitationSystemDynamicsId: UUID? = null
)

@Entity
data class ExcitationSystemUserDefined(
    @Id var excitationSystemUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class ExtensionVersion(
    @Id var extensionVersionId: UUID? = null,
    var date: String? = null,
    var namespaceURI: String? = null
)

@Entity
data class ExternalNetworkInjection(
    @Id var externalNetworkInjectionId: UUID? = null,
    var governorSCD: String? = null,
    var ikSecond: String? = null,
    var maxInitialSymShCCurrent: String? = null,
    var maxP: String? = null,
    var maxQ: String? = null,
    var maxR0ToX0Ratio: String? = null,
    var maxR1ToX1Ratio: String? = null,
    var maxZ0ToZ1Ratio: String? = null,
    var minInitialSymShCCurrent: String? = null,
    var minP: String? = null,
    var minQ: String? = null,
    var minR0ToX0Ratio: String? = null,
    var minR1ToX1Ratio: String? = null,
    var minZ0ToZ1Ratio: String? = null,
    var voltageFactor: String? = null
)

@Entity
data class FloatProxy(
     var floatProxyId: UUID? = null
)

@Entity
data class FossilFuel(
    @Id var fossilFuelId: UUID? = null,
    var fossilFuelType: String? = null
)

@Entity
data class Frequency(
    @Id var frequencyId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class GenICompensationForGenJ(
    @Id var genICompensationForGenJId: UUID? = null,
    var rcij: String? = null,
    var xcij: String? = null
)

@Entity
data class GeneratingUnit(
    @Id var generatingUnitId: UUID? = null,
    var genControlSource: String? = null,
    var governorSCD: String? = null,
    var initialP: String? = null,
    var longPF: String? = null,
    var maximumAllowableSpinningReserve: String? = null,
    var maxOperatingP: String? = null,
    var minOperatingP: String? = null,
    var nominalP: String? = null,
    var ratedGrossMaxP: String? = null,
    var ratedGrossMinP: String? = null,
    var ratedNetMaxP: String? = null,
    var shortPF: String? = null,
    var startupCost: String? = null,
    var totalEfficiency: String? = null,
    var variableCost: String? = null
)

@Entity
data class GeographicalLocationVersion(
    @Id var geographicalLocationVersionId: UUID? = null,
    var baseUML: String? = null,
    var baseURI: String? = null,
    var date: String? = null,
    var differenceModelURI: String? = null,
    var entsoeUML: String? = null,
    var entsoeURI: String? = null,
    var modelDescriptionURI: String? = null,
    var namespaceRDF: String? = null,
    var namespaceUML: String? = null,
    var shortName: String? = null
)

@Entity
data class GeographicalRegion(
     var geographicalRegionId: UUID? = null
)

@Entity
data class GovCT1(
    @Id var govCT1Id: UUID? = null,
    var aset: String? = null,
    var db: String? = null,
    var dm: String? = null,
    var ka: String? = null,
    var kdgov: String? = null,
    var kigov: String? = null,
    var kiload: String? = null,
    var kimw: String? = null,
    var kpgov: String? = null,
    var kpload: String? = null,
    var kturb: String? = null,
    var ldref: String? = null,
    var maxerr: String? = null,
    var minerr: String? = null,
    var mwbase: String? = null,
    var r: String? = null,
    var rclose: String? = null,
    var rdown: String? = null,
    var ropen: String? = null,
    var rselect: String? = null,
    var rup: String? = null,
    var ta: String? = null,
    var tact: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var tdgov: String? = null,
    var teng: String? = null,
    var tfload: String? = null,
    var tpelec: String? = null,
    var tsa: String? = null,
    var tsb: String? = null,
    var vmax: String? = null,
    var vmin: String? = null,
    var wfnl: String? = null,
    var wfspd: String? = null
)

@Entity
data class GovCT2(
    @Id var govCT2Id: UUID? = null,
    var aset: String? = null,
    var db: String? = null,
    var dm: String? = null,
    var flim1: String? = null,
    var flim10: String? = null,
    var flim2: String? = null,
    var flim3: String? = null,
    var flim4: String? = null,
    var flim5: String? = null,
    var flim6: String? = null,
    var flim7: String? = null,
    var flim8: String? = null,
    var flim9: String? = null,
    var ka: String? = null,
    var kdgov: String? = null,
    var kigov: String? = null,
    var kiload: String? = null,
    var kimw: String? = null,
    var kpgov: String? = null,
    var kpload: String? = null,
    var kturb: String? = null,
    var ldref: String? = null,
    var maxerr: String? = null,
    var minerr: String? = null,
    var mwbase: String? = null,
    var plim1: String? = null,
    var plim10: String? = null,
    var plim2: String? = null,
    var plim3: String? = null,
    var plim4: String? = null,
    var plim5: String? = null,
    var plim6: String? = null,
    var plim7: String? = null,
    var plim8: String? = null,
    var plim9: String? = null,
    var prate: String? = null,
    var r: String? = null,
    var rclose: String? = null,
    var rdown: String? = null,
    var ropen: String? = null,
    var rselect: String? = null,
    var rup: String? = null,
    var ta: String? = null,
    var tact: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var tdgov: String? = null,
    var teng: String? = null,
    var tfload: String? = null,
    var tpelec: String? = null,
    var tsa: String? = null,
    var tsb: String? = null,
    var vmax: String? = null,
    var vmin: String? = null,
    var wfnl: String? = null,
    var wfspd: String? = null
)

@Entity
data class GovGAST(
    @Id var govGASTId: UUID? = null,
    var at: String? = null,
    var dturb: String? = null,
    var kt: String? = null,
    var mwbase: String? = null,
    var r: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var vmax: String? = null,
    var vmin: String? = null
)

@Entity
data class GovGAST1(
    @Id var govGAST1Id: UUID? = null,
    var a: String? = null,
    var b: String? = null,
    var db1: String? = null,
    var db2: String? = null,
    var eps: String? = null,
    var fidle: String? = null,
    var gv1: String? = null,
    var gv2: String? = null,
    var gv3: String? = null,
    var gv4: String? = null,
    var gv5: String? = null,
    var gv6: String? = null,
    var ka: String? = null,
    var kt: String? = null,
    var lmax: String? = null,
    var loadinc: String? = null,
    var ltrate: String? = null,
    var mwbase: String? = null,
    var pgv1: String? = null,
    var pgv2: String? = null,
    var pgv3: String? = null,
    var pgv4: String? = null,
    var pgv5: String? = null,
    var pgv6: String? = null,
    var r: String? = null,
    var rmax: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var tltr: String? = null,
    var vmax: String? = null,
    var vmin: String? = null
)

@Entity
data class GovGAST2(
    @Id var govGAST2Id: UUID? = null,
    var a: String? = null,
    var af1: String? = null,
    var af2: String? = null,
    var b: String? = null,
    var bf1: String? = null,
    var bf2: String? = null,
    var c: String? = null,
    var cf2: String? = null,
    var ecr: String? = null,
    var etd: String? = null,
    var k3: String? = null,
    var k4: String? = null,
    var k5: String? = null,
    var k6: String? = null,
    var kf: String? = null,
    var mwbase: String? = null,
    var t: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var tc: String? = null,
    var tcd: String? = null,
    var tf: String? = null,
    var tmax: String? = null,
    var tmin: String? = null,
    var tr: String? = null,
    var trate: String? = null,
    var tt: String? = null,
    var w: String? = null,
    var x: String? = null,
    var y: String? = null,
    var z: String? = null
)

@Entity
data class GovGAST3(
    @Id var govGAST3Id: UUID? = null,
    var bca: String? = null,
    var bp: String? = null,
    var dtc: String? = null,
    var ka: String? = null,
    var kac: String? = null,
    var kca: String? = null,
    var ksi: String? = null,
    var ky: String? = null,
    var mnef: String? = null,
    var mxef: String? = null,
    var rcmn: String? = null,
    var rcmx: String? = null,
    var tac: String? = null,
    var tc: String? = null,
    var td: String? = null,
    var tfen: String? = null,
    var tg: String? = null,
    var tsi: String? = null,
    var tt: String? = null,
    var ttc: String? = null,
    var ty: String? = null
)

@Entity
data class GovGAST4(
    @Id var govGAST4Id: UUID? = null,
    var bp: String? = null,
    var ktm: String? = null,
    var mnef: String? = null,
    var mxef: String? = null,
    var rymn: String? = null,
    var rymx: String? = null,
    var ta: String? = null,
    var tc: String? = null,
    var tcm: String? = null,
    var tm: String? = null,
    var tv: String? = null
)

@Entity
data class GovGASTWD(
    @Id var govGASTWDId: UUID? = null,
    var a: String? = null,
    var af1: String? = null,
    var af2: String? = null,
    var b: String? = null,
    var bf1: String? = null,
    var bf2: String? = null,
    var c: String? = null,
    var cf2: String? = null,
    var ecr: String? = null,
    var etd: String? = null,
    var k3: String? = null,
    var k4: String? = null,
    var k5: String? = null,
    var k6: String? = null,
    var kd: String? = null,
    var kdroop: String? = null,
    var kf: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var mwbase: String? = null,
    var t: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var tc: String? = null,
    var tcd: String? = null,
    var td: String? = null,
    var tf: String? = null,
    var tmax: String? = null,
    var tmin: String? = null,
    var tr: String? = null,
    var trate: String? = null,
    var tt: String? = null
)

@Entity
data class GovHydro1(
    @Id var govHydro1Id: UUID? = null,
    var at: String? = null,
    var dturb: String? = null,
    var gmax: String? = null,
    var gmin: String? = null,
    var hdam: String? = null,
    var mwbase: String? = null,
    var qnl: String? = null,
    var rperm: String? = null,
    var rtemp: String? = null,
    var tf: String? = null,
    var tg: String? = null,
    var tr: String? = null,
    var tw: String? = null,
    var velm: String? = null
)

@Entity
data class GovHydro2(
    @Id var govHydro2Id: UUID? = null,
    var aturb: String? = null,
    var bturb: String? = null,
    var db1: String? = null,
    var db2: String? = null,
    var eps: String? = null,
    var gv1: String? = null,
    var gv2: String? = null,
    var gv3: String? = null,
    var gv4: String? = null,
    var gv5: String? = null,
    var gv6: String? = null,
    var kturb: String? = null,
    var mwbase: String? = null,
    var pgv1: String? = null,
    var pgv2: String? = null,
    var pgv3: String? = null,
    var pgv4: String? = null,
    var pgv5: String? = null,
    var pgv6: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var rperm: String? = null,
    var rtemp: String? = null,
    var tg: String? = null,
    var tp: String? = null,
    var tr: String? = null,
    var tw: String? = null,
    var uc: String? = null,
    var uo: String? = null
)

@Entity
data class GovHydro3(
    @Id var govHydro3Id: UUID? = null,
    var at: String? = null,
    var db1: String? = null,
    var db2: String? = null,
    var dturb: String? = null,
    var eps: String? = null,
    var governorControl: String? = null,
    var gv1: String? = null,
    var gv2: String? = null,
    var gv3: String? = null,
    var gv4: String? = null,
    var gv5: String? = null,
    var gv6: String? = null,
    var h0: String? = null,
    var k1: String? = null,
    var k2: String? = null,
    var kg: String? = null,
    var ki: String? = null,
    var mwbase: String? = null,
    var pgv1: String? = null,
    var pgv2: String? = null,
    var pgv3: String? = null,
    var pgv4: String? = null,
    var pgv5: String? = null,
    var pgv6: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var qnl: String? = null,
    var relec: String? = null,
    var rgate: String? = null,
    var td: String? = null,
    var tf: String? = null,
    var tp: String? = null,
    var tt: String? = null,
    var tw: String? = null,
    var velcl: String? = null,
    var velop: String? = null
)

@Entity
data class GovHydro4(
    @Id var govHydro4Id: UUID? = null,
    var at: String? = null,
    var bgv0: String? = null,
    var bgv1: String? = null,
    var bgv2: String? = null,
    var bgv3: String? = null,
    var bgv4: String? = null,
    var bgv5: String? = null,
    var bmax: String? = null,
    var db1: String? = null,
    var db2: String? = null,
    var dturb: String? = null,
    var eps: String? = null,
    var gmax: String? = null,
    var gmin: String? = null,
    var gv0: String? = null,
    var gv1: String? = null,
    var gv2: String? = null,
    var gv3: String? = null,
    var gv4: String? = null,
    var gv5: String? = null,
    var hdam: String? = null,
    var mwbase: String? = null,
    var pgv0: String? = null,
    var pgv1: String? = null,
    var pgv2: String? = null,
    var pgv3: String? = null,
    var pgv4: String? = null,
    var pgv5: String? = null,
    var qn1: String? = null,
    var rperm: String? = null,
    var rtemp: String? = null,
    var tblade: String? = null,
    var tg: String? = null,
    var tp: String? = null,
    var tr: String? = null,
    var tw: String? = null,
    var uc: String? = null,
    var uo: String? = null
)

@Entity
data class GovHydroDD(
    @Id var govHydroDDId: UUID? = null,
    var aturb: String? = null,
    var bturb: String? = null,
    var db1: String? = null,
    var db2: String? = null,
    var eps: String? = null,
    var gmax: String? = null,
    var gmin: String? = null,
    var gv1: String? = null,
    var gv2: String? = null,
    var gv3: String? = null,
    var gv4: String? = null,
    var gv5: String? = null,
    var gv6: String? = null,
    var inputSignal: String? = null,
    var k1: String? = null,
    var k2: String? = null,
    var kg: String? = null,
    var ki: String? = null,
    var mwbase: String? = null,
    var pgv1: String? = null,
    var pgv2: String? = null,
    var pgv3: String? = null,
    var pgv4: String? = null,
    var pgv5: String? = null,
    var pgv6: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var r: String? = null,
    var td: String? = null,
    var tf: String? = null,
    var tp: String? = null,
    var tt: String? = null,
    var tturb: String? = null,
    var velcl: String? = null,
    var velop: String? = null
)

@Entity
data class GovHydroFrancis(
    @Id var govHydroFrancisId: UUID? = null,
    var am: String? = null,
    var av0: String? = null,
    var av1: String? = null,
    var bp: String? = null,
    var db1: String? = null,
    var etamax: String? = null,
    var governorControl: String? = null,
    var h1: String? = null,
    var h2: String? = null,
    var hn: String? = null,
    var kc: String? = null,
    var kg: String? = null,
    var kt: String? = null,
    var qc0: String? = null,
    var qn: String? = null,
    var ta: String? = null,
    var td: String? = null,
    var ts: String? = null,
    var twnc: String? = null,
    var twng: String? = null,
    var tx: String? = null,
    var va: String? = null,
    var valvmax: String? = null,
    var valvmin: String? = null,
    var vc: String? = null,
    var waterTunnelSurgeChamberSimulation: String? = null,
    var zsfc: String? = null
)

@Entity
data class GovHydroIEEE0(
    @Id var govHydroIEEE0Id: UUID? = null,
    var k: String? = null,
    var mwbase: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null
)

@Entity
data class GovHydroIEEE2(
    @Id var govHydroIEEE2Id: UUID? = null,
    var aturb: String? = null,
    var bturb: String? = null,
    var gv1: String? = null,
    var gv2: String? = null,
    var gv3: String? = null,
    var gv4: String? = null,
    var gv5: String? = null,
    var gv6: String? = null,
    var kturb: String? = null,
    var mwbase: String? = null,
    var pgv1: String? = null,
    var pgv2: String? = null,
    var pgv3: String? = null,
    var pgv4: String? = null,
    var pgv5: String? = null,
    var pgv6: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var rperm: String? = null,
    var rtemp: String? = null,
    var tg: String? = null,
    var tp: String? = null,
    var tr: String? = null,
    var tw: String? = null,
    var uc: String? = null,
    var uo: String? = null
)

@Entity
data class GovHydroPID(
    @Id var govHydroPIDId: UUID? = null,
    var aturb: String? = null,
    var bturb: String? = null,
    var db1: String? = null,
    var db2: String? = null,
    var eps: String? = null,
    var gv1: String? = null,
    var gv2: String? = null,
    var gv3: String? = null,
    var gv4: String? = null,
    var gv5: String? = null,
    var gv6: String? = null,
    var inputSignal: String? = null,
    var kd: String? = null,
    var kg: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var mwbase: String? = null,
    var pgv1: String? = null,
    var pgv2: String? = null,
    var pgv3: String? = null,
    var pgv4: String? = null,
    var pgv5: String? = null,
    var pgv6: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var r: String? = null,
    var td: String? = null,
    var tf: String? = null,
    var tp: String? = null,
    var tt: String? = null,
    var tturb: String? = null,
    var velcl: String? = null,
    var velop: String? = null
)

@Entity
data class GovHydroPID2(
    @Id var govHydroPID2Id: UUID? = null,
    var atw: String? = null,
    var d: String? = null,
    var feedbackSignal: String? = null,
    var g0: String? = null,
    var g1: String? = null,
    var g2: String? = null,
    var gmax: String? = null,
    var gmin: String? = null,
    var kd: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var mwbase: String? = null,
    var p1: String? = null,
    var p2: String? = null,
    var p3: String? = null,
    var rperm: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var treg: String? = null,
    var tw: String? = null,
    var velmax: String? = null,
    var velmin: String? = null
)

@Entity
data class GovHydroPelton(
    @Id var govHydroPeltonId: UUID? = null,
    var av0: String? = null,
    var av1: String? = null,
    var bp: String? = null,
    var db1: String? = null,
    var db2: String? = null,
    var h1: String? = null,
    var h2: String? = null,
    var hn: String? = null,
    var kc: String? = null,
    var kg: String? = null,
    var qc0: String? = null,
    var qn: String? = null,
    var simplifiedPelton: String? = null,
    var staticCompensating: String? = null,
    var ta: String? = null,
    var ts: String? = null,
    var tv: String? = null,
    var twnc: String? = null,
    var twng: String? = null,
    var tx: String? = null,
    var va: String? = null,
    var valvmax: String? = null,
    var valvmin: String? = null,
    var vav: String? = null,
    var vc: String? = null,
    var vcv: String? = null,
    var waterTunnelSurgeChamberSimulation: String? = null,
    var zsfc: String? = null
)

@Entity
data class GovHydroR(
    @Id var govHydroRId: UUID? = null,
    var at: String? = null,
    var db1: String? = null,
    var db2: String? = null,
    var dturb: String? = null,
    var eps: String? = null,
    var gmax: String? = null,
    var gmin: String? = null,
    var gv1: String? = null,
    var gv2: String? = null,
    var gv3: String? = null,
    var gv4: String? = null,
    var gv5: String? = null,
    var gv6: String? = null,
    var h0: String? = null,
    var inputSignal: String? = null,
    var kg: String? = null,
    var ki: String? = null,
    var mwbase: String? = null,
    var pgv1: String? = null,
    var pgv2: String? = null,
    var pgv3: String? = null,
    var pgv4: String? = null,
    var pgv5: String? = null,
    var pgv6: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var qnl: String? = null,
    var r: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var t7: String? = null,
    var t8: String? = null,
    var td: String? = null,
    var tp: String? = null,
    var tt: String? = null,
    var tw: String? = null,
    var velcl: String? = null,
    var velop: String? = null
)

@Entity
data class GovHydroWEH(
    @Id var govHydroWEHId: UUID? = null,
    var db: String? = null,
    var dicn: String? = null,
    var dpv: String? = null,
    var dturb: String? = null,
    var feedbackSignal: String? = null,
    var fl1: String? = null,
    var fl2: String? = null,
    var fl3: String? = null,
    var fl4: String? = null,
    var fl5: String? = null,
    var fp1: String? = null,
    var fp10: String? = null,
    var fp2: String? = null,
    var fp3: String? = null,
    var fp4: String? = null,
    var fp5: String? = null,
    var fp6: String? = null,
    var fp7: String? = null,
    var fp8: String? = null,
    var fp9: String? = null,
    var gmax: String? = null,
    var gmin: String? = null,
    var gtmxcl: String? = null,
    var gtmxop: String? = null,
    var gv1: String? = null,
    var gv2: String? = null,
    var gv3: String? = null,
    var gv4: String? = null,
    var gv5: String? = null,
    var kd: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var mwbase: String? = null,
    var pmss1: String? = null,
    var pmss10: String? = null,
    var pmss2: String? = null,
    var pmss3: String? = null,
    var pmss4: String? = null,
    var pmss5: String? = null,
    var pmss6: String? = null,
    var pmss7: String? = null,
    var pmss8: String? = null,
    var pmss9: String? = null,
    var rpg: String? = null,
    var rpp: String? = null,
    var td: String? = null,
    var tdv: String? = null,
    var tg: String? = null,
    var tp: String? = null,
    var tpe: String? = null,
    var tw: String? = null
)

@Entity
data class GovHydroWPID(
    @Id var govHydroWPIDId: UUID? = null,
    var d: String? = null,
    var gatmax: String? = null,
    var gatmin: String? = null,
    var gv1: String? = null,
    var gv2: String? = null,
    var gv3: String? = null,
    var kd: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var mwbase: String? = null,
    var pgv1: String? = null,
    var pgv2: String? = null,
    var pgv3: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var reg: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var treg: String? = null,
    var tw: String? = null,
    var velmax: String? = null,
    var velmin: String? = null
)

@Entity
data class GovSteam0(
    @Id var govSteam0Id: UUID? = null,
    var dt: String? = null,
    var mwbase: String? = null,
    var r: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var vmax: String? = null,
    var vmin: String? = null
)

@Entity
data class GovSteam1(
    @Id var govSteam1Id: UUID? = null,
    var db1: String? = null,
    var db2: String? = null,
    var eps: String? = null,
    var gv1: String? = null,
    var gv2: String? = null,
    var gv3: String? = null,
    var gv4: String? = null,
    var gv5: String? = null,
    var gv6: String? = null,
    var k: String? = null,
    var k1: String? = null,
    var k2: String? = null,
    var k3: String? = null,
    var k4: String? = null,
    var k5: String? = null,
    var k6: String? = null,
    var k7: String? = null,
    var k8: String? = null,
    var mwbase: String? = null,
    var pgv1: String? = null,
    var pgv2: String? = null,
    var pgv3: String? = null,
    var pgv4: String? = null,
    var pgv5: String? = null,
    var pgv6: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var sdb1: String? = null,
    var sdb2: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var t7: String? = null,
    var uc: String? = null,
    var uo: String? = null,
    var valve: String? = null
)

@Entity
data class GovSteam2(
    @Id var govSteam2Id: UUID? = null,
    var dbf: String? = null,
    var k: String? = null,
    var mnef: String? = null,
    var mxef: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var t1: String? = null,
    var t2: String? = null
)

@Entity
data class GovSteamCC(
    @Id var govSteamCCId: UUID? = null,
    var dhp: String? = null,
    var dlp: String? = null,
    var fhp: String? = null,
    var flp: String? = null,
    var mwbase: String? = null,
    var pmaxhp: String? = null,
    var pmaxlp: String? = null,
    var rhp: String? = null,
    var rlp: String? = null,
    var t1hp: String? = null,
    var t1lp: String? = null,
    var t3hp: String? = null,
    var t3lp: String? = null,
    var t4hp: String? = null,
    var t4lp: String? = null,
    var t5hp: String? = null,
    var t5lp: String? = null
)

@Entity
data class GovSteamEU(
    @Id var govSteamEUId: UUID? = null,
    var chc: String? = null,
    var cho: String? = null,
    var cic: String? = null,
    var cio: String? = null,
    var db1: String? = null,
    var db2: String? = null,
    var hhpmax: String? = null,
    var ke: String? = null,
    var kfcor: String? = null,
    var khp: String? = null,
    var klp: String? = null,
    var kwcor: String? = null,
    var mwbase: String? = null,
    var pmax: String? = null,
    var prhmax: String? = null,
    var simx: String? = null,
    var tb: String? = null,
    var tdp: String? = null,
    var ten: String? = null,
    var tf: String? = null,
    var tfp: String? = null,
    var thp: String? = null,
    var tip: String? = null,
    var tlp: String? = null,
    var tp: String? = null,
    var trh: String? = null,
    var tvhp: String? = null,
    var tvip: String? = null,
    var tw: String? = null,
    var wfmax: String? = null,
    var wfmin: String? = null,
    var wmax1: String? = null,
    var wmax2: String? = null,
    var wwmax: String? = null,
    var wwmin: String? = null
)

@Entity
data class GovSteamFV2(
    @Id var govSteamFV2Id: UUID? = null,
    var dt: String? = null,
    var k: String? = null,
    var mwbase: String? = null,
    var r: String? = null,
    var t1: String? = null,
    var t3: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var ti: String? = null,
    var tt: String? = null,
    var vmax: String? = null,
    var vmin: String? = null
)

@Entity
data class GovSteamFV3(
    @Id var govSteamFV3Id: UUID? = null,
    var k: String? = null,
    var k1: String? = null,
    var k2: String? = null,
    var k3: String? = null,
    var mwbase: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var prmax: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var uc: String? = null,
    var uo: String? = null
)

@Entity
data class GovSteamFV4(
    @Id var govSteamFV4Id: UUID? = null,
    var cpsmn: String? = null,
    var cpsmx: String? = null,
    var crmn: String? = null,
    var crmx: String? = null,
    var kdc: String? = null,
    var kf1: String? = null,
    var kf3: String? = null,
    var khp: String? = null,
    var kic: String? = null,
    var kip: String? = null,
    var kit: String? = null,
    var kmp1: String? = null,
    var kmp2: String? = null,
    var kpc: String? = null,
    var kpp: String? = null,
    var kpt: String? = null,
    var krc: String? = null,
    var ksh: String? = null,
    var lpi: String? = null,
    var lps: String? = null,
    var mnef: String? = null,
    var mxef: String? = null,
    var pr1: String? = null,
    var pr2: String? = null,
    var psmn: String? = null,
    var rsmimn: String? = null,
    var rsmimx: String? = null,
    var rvgmn: String? = null,
    var rvgmx: String? = null,
    var srmn: String? = null,
    var srmx: String? = null,
    var srsmp: String? = null,
    var svmn: String? = null,
    var svmx: String? = null,
    var ta: String? = null,
    var tam: String? = null,
    var tc: String? = null,
    var tcm: String? = null,
    var tdc: String? = null,
    var tf1: String? = null,
    var tf2: String? = null,
    var thp: String? = null,
    var tmp: String? = null,
    var trh: String? = null,
    var tv: String? = null,
    var ty: String? = null,
    var y: String? = null,
    var yhpmn: String? = null,
    var yhpmx: String? = null,
    var ympmn: String? = null,
    var ympmx: String? = null
)

@Entity
data class GovSteamIEEE1(
    @Id var govSteamIEEE1Id: UUID? = null,
    var k: String? = null,
    var k1: String? = null,
    var k2: String? = null,
    var k3: String? = null,
    var k4: String? = null,
    var k5: String? = null,
    var k6: String? = null,
    var k7: String? = null,
    var k8: String? = null,
    var mwbase: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var t7: String? = null,
    var uc: String? = null,
    var uo: String? = null
)

@Entity
data class GovSteamSGO(
    @Id var govSteamSGOId: UUID? = null,
    var k1: String? = null,
    var k2: String? = null,
    var k3: String? = null,
    var mwbase: String? = null,
    var pmax: String? = null,
    var pmin: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null
)

@Entity
data class GrossToNetActivePowerCurve(
     var grossToNetActivePowerCurveId: UUID? = null
)

@Entity
data class Ground(
     var groundId: UUID? = null
)

@Entity
data class GroundDisconnector(
     var groundDisconnectorId: UUID? = null
)

@Entity
data class GroundingImpedance(
    @Id var groundingImpedanceId: UUID? = null,
    var x: String? = null
)

@Entity
data class HydroGeneratingUnit(
    @Id var hydroGeneratingUnitId: UUID? = null,
    var energyConversionCapability: String? = null
)

@Entity
data class HydroPowerPlant(
    @Id var hydroPowerPlantId: UUID? = null,
    var hydroPlantStorageType: String? = null
)

@Entity
data class HydroPump(
     var hydroPumpId: UUID? = null
)

@Entity
data class IdentifiedObject(
    @Id var identifiedObjectId: UUID? = null,
    var description: String? = null,
    var energyIdentCodeEic: String? = null,
    var mRID: String? = null,
    var name: String? = null,
    var shortName: String? = null
)

@Entity
data class Inductance(
    @Id var inductanceId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class InductancePerLength(
    @Id var inductancePerLengthId: UUID? = null,
    var denominatorMultiplier: String? = null,
    var denominatorUnit: String? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class IntegerProxy(
     var integerProxyId: UUID? = null
)

@Entity
data class Junction(
     var junctionId: UUID? = null
)

@Entity
data class Length(
    @Id var lengthId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class Limit(
     var limitId: UUID? = null
)

@Entity
data class LimitSet(
    @Id var limitSetId: UUID? = null,
    var isPercentageLimits: String? = null
)

@Entity
data class Line(
     var lineId: UUID? = null
)

@Entity
data class LinearShuntCompensator(
    @Id var linearShuntCompensatorId: UUID? = null,
    var b0PerSection: String? = null,
    var bPerSection: String? = null,
    var g0PerSection: String? = null,
    var gPerSection: String? = null
)

@Entity
data class LoadAggregate(
     var loadAggregateId: UUID? = null
)

@Entity
data class LoadArea(
     var loadAreaId: UUID? = null
)

@Entity
data class LoadBreakSwitch(
     var loadBreakSwitchId: UUID? = null
)

@Entity
data class LoadComposite(
    @Id var loadCompositeId: UUID? = null,
    var epfd: String? = null,
    var epfs: String? = null,
    var epvd: String? = null,
    var epvs: String? = null,
    var eqfd: String? = null,
    var eqfs: String? = null,
    var eqvd: String? = null,
    var eqvs: String? = null,
    var h: String? = null,
    var lfrac: String? = null,
    var pfrac: String? = null
)

@Entity
data class LoadDynamics(
     var loadDynamicsId: UUID? = null
)

@Entity
data class LoadGenericNonLinear(
    @Id var loadGenericNonLinearId: UUID? = null,
    var bs: String? = null,
    var bt: String? = null,
    var genericNonLinearLoadModelType: String? = null,
    var ls: String? = null,
    var lt: String? = null,
    var pt: String? = null,
    var qt: String? = null,
    var tp: String? = null,
    var tq: String? = null
)

@Entity
data class LoadGroup(
     var loadGroupId: UUID? = null
)

@Entity
data class LoadMotor(
    @Id var loadMotorId: UUID? = null,
    var d: String? = null,
    var h: String? = null,
    var lfac: String? = null,
    var lp: String? = null,
    var lpp: String? = null,
    var ls: String? = null,
    var pfrac: String? = null,
    var ra: String? = null,
    var tbkr: String? = null,
    var tpo: String? = null,
    var tppo: String? = null,
    var tv: String? = null,
    var vt: String? = null
)

@Entity
data class LoadResponseCharacteristic(
    @Id var loadResponseCharacteristicId: UUID? = null,
    var exponentModel: String? = null,
    var pConstantCurrent: String? = null,
    var pConstantImpedance: String? = null,
    var pConstantPower: String? = null,
    var pFrequencyExponent: String? = null,
    var pVoltageExponent: String? = null,
    var qConstantCurrent: String? = null,
    var qConstantImpedance: String? = null,
    var qConstantPower: String? = null,
    var qFrequencyExponent: String? = null,
    var qVoltageExponent: String? = null
)

@Entity
data class LoadStatic(
    @Id var loadStaticId: UUID? = null,
    var ep1: String? = null,
    var ep2: String? = null,
    var ep3: String? = null,
    var eq1: String? = null,
    var eq2: String? = null,
    var eq3: String? = null,
    var kp1: String? = null,
    var kp2: String? = null,
    var kp3: String? = null,
    var kp4: String? = null,
    var kpf: String? = null,
    var kq1: String? = null,
    var kq2: String? = null,
    var kq3: String? = null,
    var kq4: String? = null,
    var kqf: String? = null,
    var staticLoadModelType: String? = null
)

@Entity
data class LoadUserDefined(
    @Id var loadUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class Location(
     var locationId: UUID? = null
)

@Entity
data class Measurement(
    @Id var measurementId: UUID? = null,
    var measurementType: String? = null,
    var phases: String? = null,
    var unitMultiplier: String? = null,
    var unitSymbol: String? = null
)

@Entity
data class MeasurementValue(
    @Id var measurementValueId: UUID? = null,
    var sensorAccuracy: String? = null,
    var timeStamp: String? = null
)

@Entity
data class MeasurementValueQuality(
     var measurementValueQualityId: UUID? = null
)

@Entity
data class MeasurementValueSource(
     var measurementValueSourceId: UUID? = null
)

@Entity
data class MechLoad1(
    @Id var mechLoad1Id: UUID? = null,
    var a: String? = null,
    var b: String? = null,
    var d: String? = null,
    var e: String? = null
)

@Entity
data class MechanicalLoadDynamics(
     var mechanicalLoadDynamicsId: UUID? = null
)

@Entity
data class MechanicalLoadUserDefined(
    @Id var mechanicalLoadUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class Money(
    @Id var moneyId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class MonthDay(
     var monthDayId: UUID? = null
)

@Entity
data class MonthDayInterval(
    @Id var monthDayIntervalId: UUID? = null,
    var end: String? = null,
    var start: String? = null
)

@Entity
data class MutualCoupling(
    @Id var mutualCouplingId: UUID? = null,
    var b0ch: String? = null,
    var distance11: String? = null,
    var distance12: String? = null,
    var distance21: String? = null,
    var distance22: String? = null,
    var g0ch: String? = null,
    var r0: String? = null,
    var x0: String? = null
)

@Entity
data class NonConformLoad(
     var nonConformLoadId: UUID? = null
)

@Entity
data class NonConformLoadGroup(
     var nonConformLoadGroupId: UUID? = null
)

@Entity
data class NonConformLoadSchedule(
     var nonConformLoadScheduleId: UUID? = null
)

@Entity
data class NonlinearShuntCompensator(
     var nonlinearShuntCompensatorId: UUID? = null
)

@Entity
data class NonlinearShuntCompensatorPoint(
    @Id var nonlinearShuntCompensatorPointId: UUID? = null,
    var b: String? = null,
    var b0: String? = null,
    var g: String? = null,
    var g0: String? = null,
    var sectionNumber: String? = null
)

@Entity
data class NuclearGeneratingUnit(
     var nuclearGeneratingUnitId: UUID? = null
)

@Entity
data class OperationalLimit(
     var operationalLimitId: UUID? = null
)

@Entity
data class OperationalLimitSet(
     var operationalLimitSetId: UUID? = null
)

@Entity
data class OperationalLimitType(
    @Id var operationalLimitTypeId: UUID? = null,
    var acceptableDuration: String? = null,
    var direction: String? = null,
    var limitType: String? = null
)

@Entity
data class OverexcLim2(
    @Id var overexcLim2Id: UUID? = null,
    var ifdlim: String? = null,
    var koi: String? = null,
    var voimax: String? = null,
    var voimin: String? = null
)

@Entity
data class OverexcLimIEEE(
    @Id var overexcLimIEEEId: UUID? = null,
    var hyst: String? = null,
    var ifdlim: String? = null,
    var ifdmax: String? = null,
    var itfpu: String? = null,
    var kcd: String? = null,
    var kramp: String? = null
)

@Entity
data class OverexcLimX1(
    @Id var overexcLimX1Id: UUID? = null,
    var efd1: String? = null,
    var efd2: String? = null,
    var efd3: String? = null,
    var efddes: String? = null,
    var efdrated: String? = null,
    var kmx: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var vlow: String? = null
)

@Entity
data class OverexcLimX2(
    @Id var overexcLimX2Id: UUID? = null,
    var efd1: String? = null,
    var efd2: String? = null,
    var efd3: String? = null,
    var efddes: String? = null,
    var efdrated: String? = null,
    var kmx: String? = null,
    var m: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var vlow: String? = null
)

@Entity
data class OverexcitationLimiterDynamics(
     var overexcitationLimiterDynamicsId: UUID? = null
)

@Entity
data class OverexcitationLimiterUserDefined(
    @Id var overexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class PFVArControllerType1Dynamics(
     var pFVArControllerType1DynamicsId: UUID? = null
)

@Entity
data class PFVArControllerType1UserDefined(
    @Id var pFVArControllerType1UserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class PFVArControllerType2Dynamics(
     var pFVArControllerType2DynamicsId: UUID? = null
)

@Entity
data class PFVArControllerType2UserDefined(
    @Id var pFVArControllerType2UserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class PFVArType1IEEEPFController(
    @Id var pFVArType1IEEEPFControllerId: UUID? = null,
    var ovex: String? = null,
    var tpfc: String? = null,
    var vitmin: String? = null,
    var vpf: String? = null,
    var vpfcbw: String? = null,
    var vpfref: String? = null,
    var vvtmax: String? = null,
    var vvtmin: String? = null
)

@Entity
data class PFVArType1IEEEVArController(
    @Id var pFVArType1IEEEVArControllerId: UUID? = null,
    var tvarc: String? = null,
    var vvar: String? = null,
    var vvarcbw: String? = null,
    var vvarref: String? = null,
    var vvtmax: String? = null,
    var vvtmin: String? = null
)

@Entity
data class PFVArType2Common1(
    @Id var pFVArType2Common1Id: UUID? = null,
    var j: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var max: String? = null,
    var ref: String? = null
)

@Entity
data class PFVArType2IEEEPFController(
    @Id var pFVArType2IEEEPFControllerId: UUID? = null,
    var exlon: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var pfref: String? = null,
    var vclmt: String? = null,
    var vref: String? = null,
    var vs: String? = null
)

@Entity
data class PFVArType2IEEEVArController(
    @Id var pFVArType2IEEEVArControllerId: UUID? = null,
    var exlon: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var qref: String? = null,
    var vclmt: String? = null,
    var vref: String? = null,
    var vs: String? = null
)

@Entity
data class PU(
    @Id var pUId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class PerCent(
    @Id var perCentId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class PerLengthDCLineParameter(
    @Id var perLengthDCLineParameterId: UUID? = null,
    var capacitance: String? = null,
    var inductance: String? = null,
    var resistance: String? = null
)

@Entity
data class PetersenCoil(
    @Id var petersenCoilId: UUID? = null,
    var mode: String? = null,
    var nominalU: String? = null,
    var offsetCurrent: String? = null,
    var positionCurrent: String? = null,
    var xGroundMax: String? = null,
    var xGroundMin: String? = null,
    var xGroundNominal: String? = null
)

@Entity
data class PhaseTapChanger(
     var phaseTapChangerId: UUID? = null
)

@Entity
data class PhaseTapChangerAsymmetrical(
    @Id var phaseTapChangerAsymmetricalId: UUID? = null,
    var windingConnectionAngle: String? = null
)

@Entity
data class PhaseTapChangerLinear(
    @Id var phaseTapChangerLinearId: UUID? = null,
    var stepPhaseShiftIncrement: String? = null,
    var xMax: String? = null,
    var xMin: String? = null
)

@Entity
data class PhaseTapChangerNonLinear(
    @Id var phaseTapChangerNonLinearId: UUID? = null,
    var voltageStepIncrement: String? = null,
    var xMax: String? = null,
    var xMin: String? = null
)

@Entity
data class PhaseTapChangerSymmetrical(
     var phaseTapChangerSymmetricalId: UUID? = null
)

@Entity
data class PhaseTapChangerTable(
     var phaseTapChangerTableId: UUID? = null
)

@Entity
data class PhaseTapChangerTablePoint(
    @Id var phaseTapChangerTablePointId: UUID? = null,
    var angle: String? = null
)

@Entity
data class PhaseTapChangerTabular(
     var phaseTapChangerTabularId: UUID? = null
)

@Entity
data class PositionPoint(
    @Id var positionPointId: UUID? = null,
    var sequenceNumber: String? = null,
    var xPosition: String? = null,
    var yPosition: String? = null,
    var zPosition: String? = null
)

@Entity
data class PowerSystemResource(
     var powerSystemResourceId: UUID? = null
)

@Entity
data class PowerSystemStabilizerDynamics(
     var powerSystemStabilizerDynamicsId: UUID? = null
)

@Entity
data class PowerSystemStabilizerUserDefined(
    @Id var powerSystemStabilizerUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class PowerTransformer(
    @Id var powerTransformerId: UUID? = null,
    var beforeShCircuitHighestOperatingCurrent: String? = null,
    var beforeShCircuitHighestOperatingVoltage: String? = null,
    var beforeShortCircuitAnglePf: String? = null,
    var highSideMinOperatingU: String? = null,
    var isPartOfGeneratorUnit: String? = null,
    var operationalValuesConsidered: String? = null
)

@Entity
data class PowerTransformerEnd(
    @Id var powerTransformerEndId: UUID? = null,
    var b: String? = null,
    var b0: String? = null,
    var connectionKind: String? = null,
    var g: String? = null,
    var g0: String? = null,
    var phaseAngleClock: String? = null,
    var r: String? = null,
    var r0: String? = null,
    var ratedS: String? = null,
    var ratedU: String? = null,
    var x: String? = null,
    var x0: String? = null
)

@Entity
data class ProprietaryParameterDynamics(
    @Id var proprietaryParameterDynamicsId: UUID? = null,
    var booleanParameterValue: String? = null,
    var floatParameterValue: String? = null,
    var integerParameterValue: String? = null,
    var parameterNumber: String? = null
)

@Entity
data class ProtectedSwitch(
     var protectedSwitchId: UUID? = null
)

@Entity
data class Pss1(
    @Id var pss1Id: UUID? = null,
    var kf: String? = null,
    var kpe: String? = null,
    var ks: String? = null,
    var kw: String? = null,
    var pmin: String? = null,
    var t10: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var t7: String? = null,
    var t8: String? = null,
    var t9: String? = null,
    var tpe: String? = null,
    var vadat: String? = null,
    var vsmn: String? = null,
    var vsmx: String? = null
)

@Entity
data class Pss1A(
    @Id var pss1AId: UUID? = null,
    var a1: String? = null,
    var a2: String? = null,
    var a3: String? = null,
    var a4: String? = null,
    var a5: String? = null,
    var a6: String? = null,
    var a7: String? = null,
    var a8: String? = null,
    var inputSignalType: String? = null,
    var kd: String? = null,
    var ks: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var tdelay: String? = null,
    var vcl: String? = null,
    var vcu: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class Pss2B(
    @Id var pss2BId: UUID? = null,
    var a: String? = null,
    var inputSignal1Type: String? = null,
    var inputSignal2Type: String? = null,
    var ks1: String? = null,
    var ks2: String? = null,
    var ks3: String? = null,
    var ks4: String? = null,
    var m: String? = null,
    var n: String? = null,
    var t1: String? = null,
    var t10: String? = null,
    var t11: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t6: String? = null,
    var t7: String? = null,
    var t8: String? = null,
    var t9: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tw1: String? = null,
    var tw2: String? = null,
    var tw3: String? = null,
    var tw4: String? = null,
    var vsi1max: String? = null,
    var vsi1min: String? = null,
    var vsi2max: String? = null,
    var vsi2min: String? = null,
    var vstmax: String? = null,
    var vstmin: String? = null
)

@Entity
data class Pss2ST(
    @Id var pss2STId: UUID? = null,
    var inputSignal1Type: String? = null,
    var inputSignal2Type: String? = null,
    var k1: String? = null,
    var k2: String? = null,
    var lsmax: String? = null,
    var lsmin: String? = null,
    var t1: String? = null,
    var t10: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var t7: String? = null,
    var t8: String? = null,
    var t9: String? = null,
    var vcl: String? = null,
    var vcu: String? = null
)

@Entity
data class Pss5(
    @Id var pss5Id: UUID? = null,
    var ctw2: String? = null,
    var deadband: String? = null,
    var isfreq: String? = null,
    var kf: String? = null,
    var kpe: String? = null,
    var kpss: String? = null,
    var pmm: String? = null,
    var tl1: String? = null,
    var tl2: String? = null,
    var tl3: String? = null,
    var tl4: String? = null,
    var tpe: String? = null,
    var tw1: String? = null,
    var tw2: String? = null,
    var vadat: String? = null,
    var vsmn: String? = null,
    var vsmx: String? = null
)

@Entity
data class PssELIN2(
    @Id var pssELIN2Id: UUID? = null,
    var apss: String? = null,
    var ks1: String? = null,
    var ks2: String? = null,
    var ppss: String? = null,
    var psslim: String? = null,
    var ts1: String? = null,
    var ts2: String? = null,
    var ts3: String? = null,
    var ts4: String? = null,
    var ts5: String? = null,
    var ts6: String? = null
)

@Entity
data class PssIEEE1A(
    @Id var pssIEEE1AId: UUID? = null,
    var a1: String? = null,
    var a2: String? = null,
    var inputSignalType: String? = null,
    var ks: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var vrmax: String? = null,
    var vrmin: String? = null
)

@Entity
data class PssIEEE2B(
    @Id var pssIEEE2BId: UUID? = null,
    var inputSignal1Type: String? = null,
    var inputSignal2Type: String? = null,
    var ks1: String? = null,
    var ks2: String? = null,
    var ks3: String? = null,
    var m: String? = null,
    var n: String? = null,
    var t1: String? = null,
    var t10: String? = null,
    var t11: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t6: String? = null,
    var t7: String? = null,
    var t8: String? = null,
    var t9: String? = null,
    var tw1: String? = null,
    var tw2: String? = null,
    var tw3: String? = null,
    var tw4: String? = null,
    var vsi1max: String? = null,
    var vsi1min: String? = null,
    var vsi2max: String? = null,
    var vsi2min: String? = null,
    var vstmax: String? = null,
    var vstmin: String? = null
)

@Entity
data class PssIEEE3B(
    @Id var pssIEEE3BId: UUID? = null,
    var a1: String? = null,
    var a2: String? = null,
    var a3: String? = null,
    var a4: String? = null,
    var a5: String? = null,
    var a6: String? = null,
    var a7: String? = null,
    var a8: String? = null,
    var inputSignal1Type: String? = null,
    var inputSignal2Type: String? = null,
    var ks1: String? = null,
    var ks2: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var tw1: String? = null,
    var tw2: String? = null,
    var tw3: String? = null,
    var vstmax: String? = null,
    var vstmin: String? = null
)

@Entity
data class PssIEEE4B(
    @Id var pssIEEE4BId: UUID? = null,
    var bwh1: String? = null,
    var bwh2: String? = null,
    var bwl1: String? = null,
    var bwl2: String? = null,
    var kh: String? = null,
    var kh1: String? = null,
    var kh11: String? = null,
    var kh17: String? = null,
    var kh2: String? = null,
    var ki: String? = null,
    var ki1: String? = null,
    var ki11: String? = null,
    var ki17: String? = null,
    var ki2: String? = null,
    var kl: String? = null,
    var kl1: String? = null,
    var kl11: String? = null,
    var kl17: String? = null,
    var kl2: String? = null,
    var omeganh1: String? = null,
    var omeganh2: String? = null,
    var omeganl1: String? = null,
    var omeganl2: String? = null,
    var th1: String? = null,
    var th10: String? = null,
    var th11: String? = null,
    var th12: String? = null,
    var th2: String? = null,
    var th3: String? = null,
    var th4: String? = null,
    var th5: String? = null,
    var th6: String? = null,
    var th7: String? = null,
    var th8: String? = null,
    var th9: String? = null,
    var ti1: String? = null,
    var ti10: String? = null,
    var ti11: String? = null,
    var ti12: String? = null,
    var ti2: String? = null,
    var ti3: String? = null,
    var ti4: String? = null,
    var ti5: String? = null,
    var ti6: String? = null,
    var ti7: String? = null,
    var ti8: String? = null,
    var ti9: String? = null,
    var tl1: String? = null,
    var tl10: String? = null,
    var tl11: String? = null,
    var tl12: String? = null,
    var tl2: String? = null,
    var tl3: String? = null,
    var tl4: String? = null,
    var tl5: String? = null,
    var tl6: String? = null,
    var tl7: String? = null,
    var tl8: String? = null,
    var tl9: String? = null,
    var vhmax: String? = null,
    var vhmin: String? = null,
    var vimax: String? = null,
    var vimin: String? = null,
    var vlmax: String? = null,
    var vlmin: String? = null,
    var vstmax: String? = null,
    var vstmin: String? = null
)

@Entity
data class PssPTIST1(
    @Id var pssPTIST1Id: UUID? = null,
    var dtc: String? = null,
    var dtf: String? = null,
    var dtp: String? = null,
    var k: String? = null,
    var m: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var tf: String? = null,
    var tp: String? = null
)

@Entity
data class PssPTIST3(
    @Id var pssPTIST3Id: UUID? = null,
    var a0: String? = null,
    var a1: String? = null,
    var a2: String? = null,
    var a3: String? = null,
    var a4: String? = null,
    var a5: String? = null,
    var al: String? = null,
    var athres: String? = null,
    var b0: String? = null,
    var b1: String? = null,
    var b2: String? = null,
    var b3: String? = null,
    var b4: String? = null,
    var b5: String? = null,
    var dl: String? = null,
    var dtc: String? = null,
    var dtf: String? = null,
    var dtp: String? = null,
    var isw: String? = null,
    var k: String? = null,
    var lthres: String? = null,
    var m: String? = null,
    var nav: String? = null,
    var ncl: String? = null,
    var ncr: String? = null,
    var pmin: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var tf: String? = null,
    var tp: String? = null
)

@Entity
data class PssSB4(
    @Id var pssSB4Id: UUID? = null,
    var kx: String? = null,
    var ta: String? = null,
    var tb: String? = null,
    var tc: String? = null,
    var td: String? = null,
    var te: String? = null,
    var tt: String? = null,
    var tx1: String? = null,
    var tx2: String? = null,
    var vsmax: String? = null,
    var vsmin: String? = null
)

@Entity
data class PssSH(
    @Id var pssSHId: UUID? = null,
    var k: String? = null,
    var k0: String? = null,
    var k1: String? = null,
    var k2: String? = null,
    var k3: String? = null,
    var k4: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var td: String? = null,
    var vsmax: String? = null,
    var vsmin: String? = null
)

@Entity
data class PssSK(
    @Id var pssSKId: UUID? = null,
    var k1: String? = null,
    var k2: String? = null,
    var k3: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var vsmax: String? = null,
    var vsmin: String? = null
)

@Entity
data class PssWECC(
    @Id var pssWECCId: UUID? = null,
    var inputSignal1Type: String? = null,
    var inputSignal2Type: String? = null,
    var k1: String? = null,
    var k2: String? = null,
    var t1: String? = null,
    var t10: String? = null,
    var t2: String? = null,
    var t3: String? = null,
    var t4: String? = null,
    var t5: String? = null,
    var t6: String? = null,
    var t7: String? = null,
    var t8: String? = null,
    var t9: String? = null,
    var vcl: String? = null,
    var vcu: String? = null,
    var vsmax: String? = null,
    var vsmin: String? = null
)

@Entity
data class Quality61850(
    @Id var quality61850Id: UUID? = null,
    var badReference: String? = null,
    var estimatorReplaced: String? = null,
    var failure: String? = null,
    var oldData: String? = null,
    var operatorBlocked: String? = null,
    var oscillatory: String? = null,
    var outOfRange: String? = null,
    var overFlow: String? = null,
    var source: String? = null,
    var suspect: String? = null,
    var test: String? = null,
    var validity: String? = null
)

@Entity
data class RaiseLowerCommand(
     var raiseLowerCommandId: UUID? = null
)

@Entity
data class RatioTapChanger(
    @Id var ratioTapChangerId: UUID? = null,
    var stepVoltageIncrement: String? = null,
    var tculControlMode: String? = null
)

@Entity
data class RatioTapChangerTable(
     var ratioTapChangerTableId: UUID? = null
)

@Entity
data class RatioTapChangerTablePoint(
     var ratioTapChangerTablePointId: UUID? = null
)

@Entity
data class Reactance(
    @Id var reactanceId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class ReactiveCapabilityCurve(
     var reactiveCapabilityCurveId: UUID? = null
)

@Entity
data class ReactivePower(
    @Id var reactivePowerId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class RegularIntervalSchedule(
    @Id var regularIntervalScheduleId: UUID? = null,
    var endTime: String? = null,
    var timeStep: String? = null
)

@Entity
data class RegularTimePoint(
    @Id var regularTimePointId: UUID? = null,
    var sequenceNumber: String? = null,
    var value1: String? = null,
    var value2: String? = null
)

@Entity
data class RegulatingCondEq(
     var regulatingCondEqId: UUID? = null
)

@Entity
data class RegulatingControl(
    @Id var regulatingControlId: UUID? = null,
    var mode: String? = null
)

@Entity
data class RegulationSchedule(
     var regulationScheduleId: UUID? = null
)

@Entity
data class RemoteInputSignal(
    @Id var remoteInputSignalId: UUID? = null,
    var remoteSignalType: String? = null
)

@Entity
data class ReportingGroup(
     var reportingGroupId: UUID? = null
)

@Entity
data class Resistance(
    @Id var resistanceId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class ResistancePerLength(
    @Id var resistancePerLengthId: UUID? = null,
    var denominatorMultiplier: String? = null,
    var denominatorUnit: String? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class RotatingMachine(
    @Id var rotatingMachineId: UUID? = null,
    var ratedPowerFactor: String? = null,
    var ratedS: String? = null,
    var ratedU: String? = null
)

@Entity
data class RotatingMachineDynamics(
    @Id var rotatingMachineDynamicsId: UUID? = null,
    var damping: String? = null,
    var inertia: String? = null,
    var saturationFactor: String? = null,
    var saturationFactor120: String? = null,
    var statorLeakageReactance: String? = null,
    var statorResistance: String? = null
)

@Entity
data class RotationSpeed(
    @Id var rotationSpeedId: UUID? = null,
    var denominatorMultiplier: String? = null,
    var denominatorUnit: String? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class Season(
    @Id var seasonId: UUID? = null,
    var endDate: String? = null,
    var startDate: String? = null
)

@Entity
data class SeasonDayTypeSchedule(
     var seasonDayTypeScheduleId: UUID? = null
)

@Entity
data class Seconds(
    @Id var secondsId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class SeriesCompensator(
    @Id var seriesCompensatorId: UUID? = null,
    var r: String? = null,
    var r0: String? = null,
    var varistorPresent: String? = null,
    var varistorRatedCurrent: String? = null,
    var varistorVoltageThreshold: String? = null,
    var x: String? = null,
    var x0: String? = null
)

@Entity
data class SetPoint(
    @Id var setPointId: UUID? = null,
    var normalValue: String? = null,
    var value: String? = null
)

@Entity
data class ShuntCompensator(
    @Id var shuntCompensatorId: UUID? = null,
    var aVRDelay: String? = null,
    var grounded: String? = null,
    var maximumSections: String? = null,
    var nomU: String? = null,
    var normalSections: String? = null,
    var switchOnCount: String? = null,
    var switchOnDate: String? = null,
    var voltageSensitivity: String? = null
)

@Entity
data class Simple_Float(
    @Id var simple_FloatId: UUID? = null,
    var value: String? = null
)

@Entity
data class SolarGeneratingUnit(
     var solarGeneratingUnitId: UUID? = null
)

@Entity
data class StateVariablesVersion(
    @Id var stateVariablesVersionId: UUID? = null,
    var baseUML: String? = null,
    var baseURI: String? = null,
    var date: String? = null,
    var differenceModelURI: String? = null,
    var entsoeUML: String? = null,
    var entsoeURI: String? = null,
    var modelDescriptionURI: String? = null,
    var namespaceRDF: String? = null,
    var namespaceUML: String? = null,
    var shortName: String? = null
)

@Entity
data class StaticVarCompensator(
    @Id var staticVarCompensatorId: UUID? = null,
    var capacitiveRating: String? = null,
    var inductiveRating: String? = null,
    var slope: String? = null,
    var sVCControlMode: String? = null,
    var voltageSetPoint: String? = null
)

@Entity
data class Staticpowersystemmodel(
     var staticpowersystemmodelId: UUID? = null
)

@Entity
data class StationSupply(
     var stationSupplyId: UUID? = null
)

@Entity
data class SteadyStateHypothesisVersion(
    @Id var steadyStateHypothesisVersionId: UUID? = null,
    var baseUML: String? = null,
    var baseURI: String? = null,
    var date: String? = null,
    var differenceModelURI: String? = null,
    var entsoeUML: String? = null,
    var entsoeURI: String? = null,
    var modelDescriptionURI: String? = null,
    var namespaceRDF: String? = null,
    var namespaceUML: String? = null,
    var shortName: String? = null
)

@Entity
data class StringMeasurement(
     var stringMeasurementId: UUID? = null
)

@Entity
data class StringMeasurementValue(
    @Id var stringMeasurementValueId: UUID? = null,
    var value: String? = null
)

@Entity
data class StringProxy(
     var stringProxyId: UUID? = null
)

@Entity
data class SubGeographicalRegion(
     var subGeographicalRegionId: UUID? = null
)

@Entity
data class SubLoadArea(
     var subLoadAreaId: UUID? = null
)

@Entity
data class Substation(
     var substationId: UUID? = null
)

@Entity
data class Susceptance(
    @Id var susceptanceId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class SvInjection(
    @Id var svInjectionId: UUID? = null,
    var pInjection: String? = null,
    var qInjection: String? = null
)

@Entity
data class SvPowerFlow(
    @Id var svPowerFlowId: UUID? = null,
    var p: String? = null,
    var q: String? = null
)

@Entity
data class SvShuntCompensatorSections(
    @Id var svShuntCompensatorSectionsId: UUID? = null,
    var sections: String? = null
)

@Entity
data class SvStatus(
    @Id var svStatusId: UUID? = null,
    var inService: String? = null
)

@Entity
data class SvTapStep(
    @Id var svTapStepId: UUID? = null,
    var position: String? = null
)

@Entity
data class SvVoltage(
    @Id var svVoltageId: UUID? = null,
    var angle: String? = null,
    var v: String? = null
)

@Entity
data class SwitchIt(
    @Id var switchItId: UUID? = null,
    var open: String? = null
)

@Entity
data class SwitchProxy(
    @Id var switchProxyId: UUID? = null,
    var normalOpen: String? = null,
    var ratedCurrent: String? = null,
    var retained: String? = null
)

@Entity
data class SwitchSchedule(
     var switchScheduleId: UUID? = null
)

@Entity
data class SynchronousMachine(
    @Id var synchronousMachineId: UUID? = null,
    var earthing: String? = null,
    var earthingStarPointR: String? = null,
    var earthingStarPointX: String? = null,
    var ikk: String? = null,
    var maxQ: String? = null,
    var minQ: String? = null,
    var mu: String? = null,
    var qPercent: String? = null,
    var r: String? = null,
    var r0: String? = null,
    var r2: String? = null,
    var satDirectSubtransX: String? = null,
    var satDirectSyncX: String? = null,
    var satDirectTransX: String? = null,
    var shortCircuitRotorType: String? = null,
    var type: String? = null,
    var voltageRegulationRange: String? = null,
    var x0: String? = null,
    var x2: String? = null
)

@Entity
data class SynchronousMachineDetailed(
    @Id var synchronousMachineDetailedId: UUID? = null,
    var efdBaseRatio: String? = null,
    var ifdBaseType: String? = null,
    var ifdBaseValue: String? = null,
    var saturationFactor120QAxis: String? = null,
    var saturationFactorQAxis: String? = null
)

@Entity
data class SynchronousMachineDynamics(
     var synchronousMachineDynamicsId: UUID? = null
)

@Entity
data class SynchronousMachineEquivalentCircuit(
    @Id var synchronousMachineEquivalentCircuitId: UUID? = null,
    var r1d: String? = null,
    var r1q: String? = null,
    var r2q: String? = null,
    var rfd: String? = null,
    var x1d: String? = null,
    var x1q: String? = null,
    var x2q: String? = null,
    var xad: String? = null,
    var xaq: String? = null,
    var xf1d: String? = null,
    var xfd: String? = null
)

@Entity
data class SynchronousMachineSimplified(
     var synchronousMachineSimplifiedId: UUID? = null
)

@Entity
data class SynchronousMachineTimeConstantReactance(
    @Id var synchronousMachineTimeConstantReactanceId: UUID? = null,
    var ks: String? = null,
    var modelType: String? = null,
    var rotorType: String? = null,
    var tc: String? = null,
    var tpdo: String? = null,
    var tppdo: String? = null,
    var tppqo: String? = null,
    var tpqo: String? = null,
    var xDirectSubtrans: String? = null,
    var xDirectSync: String? = null,
    var xDirectTrans: String? = null,
    var xQuadSubtrans: String? = null,
    var xQuadSync: String? = null,
    var xQuadTrans: String? = null
)

@Entity
data class SynchronousMachineUserDefined(
    @Id var synchronousMachineUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class TapChanger(
    @Id var tapChangerId: UUID? = null,
    var highStep: String? = null,
    var lowStep: String? = null,
    var ltcFlag: String? = null,
    var neutralStep: String? = null,
    var neutralU: String? = null,
    var normalStep: String? = null
)

@Entity
data class TapChangerControl(
     var tapChangerControlId: UUID? = null
)

@Entity
data class TapChangerTablePoint(
    @Id var tapChangerTablePointId: UUID? = null,
    var b: String? = null,
    var g: String? = null,
    var r: String? = null,
    var ratio: String? = null,
    var step: String? = null,
    var x: String? = null
)

@Entity
data class TapSchedule(
     var tapScheduleId: UUID? = null
)

@Entity
data class Temperature(
    @Id var temperatureId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class Terminal(
     var terminalId: UUID? = null
)

@Entity
data class TextDiagramObject(
    @Id var textDiagramObjectId: UUID? = null,
    var text: String? = null
)

@Entity
data class ThermalGeneratingUnit(
     var thermalGeneratingUnitId: UUID? = null
)

@Entity
data class TieFlow(
    @Id var tieFlowId: UUID? = null,
    var positiveFlowIn: String? = null
)

@Entity
data class TopologicalIsland(
     var topologicalIslandId: UUID? = null
)

@Entity
data class TopologicalNode(
    @Id var topologicalNodeId: UUID? = null,
    var boundaryPoint: String? = null,
    var fromEndIsoCode: String? = null,
    var fromEndName: String? = null,
    var fromEndNameTso: String? = null,
    var toEndIsoCode: String? = null,
    var toEndName: String? = null,
    var toEndNameTso: String? = null
)

@Entity
data class TopologyBoundaryVersion(
    @Id var topologyBoundaryVersionId: UUID? = null,
    var baseUML: String? = null,
    var baseURI: String? = null,
    var date: String? = null,
    var differenceModelURI: String? = null,
    var entsoeUML: String? = null,
    var entsoeURI: String? = null,
    var modelDescriptionURI: String? = null,
    var namespaceRDF: String? = null,
    var namespaceUML: String? = null,
    var shortName: String? = null
)

@Entity
data class TopologyVersion(
    @Id var topologyVersionId: UUID? = null,
    var baseUML: String? = null,
    var baseURI: String? = null,
    var date: String? = null,
    var differenceModelURI: String? = null,
    var entsoeUML: String? = null,
    var entsoeURI: String? = null,
    var modelDescriptionURI: String? = null,
    var namespaceRDF: String? = null,
    var namespaceUML: String? = null,
    var shortName: String? = null
)

@Entity
data class TransformerEnd(
    @Id var transformerEndId: UUID? = null,
    var endNumber: String? = null,
    var grounded: String? = null,
    var rground: String? = null,
    var xground: String? = null
)

@Entity
data class TurbLCFB1(
    @Id var turbLCFB1Id: UUID? = null,
    var db: String? = null,
    var emax: String? = null,
    var fb: String? = null,
    var fbf: String? = null,
    var irmax: String? = null,
    var ki: String? = null,
    var kp: String? = null,
    var mwbase: String? = null,
    var pbf: String? = null,
    var pmwset: String? = null,
    var speedReferenceGovernor: String? = null,
    var tpelec: String? = null
)

@Entity
data class TurbineGovernorDynamics(
     var turbineGovernorDynamicsId: UUID? = null
)

@Entity
data class TurbineGovernorUserDefined(
    @Id var turbineGovernorUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class TurbineLoadControllerDynamics(
     var turbineLoadControllerDynamicsId: UUID? = null
)

@Entity
data class TurbineLoadControllerUserDefined(
    @Id var turbineLoadControllerUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class UnderexcLim2Simplified(
    @Id var underexcLim2SimplifiedId: UUID? = null,
    var kui: String? = null,
    var p0: String? = null,
    var p1: String? = null,
    var q0: String? = null,
    var q1: String? = null,
    var vuimax: String? = null,
    var vuimin: String? = null
)

@Entity
data class UnderexcLimIEEE1(
    @Id var underexcLimIEEE1Id: UUID? = null,
    var kuc: String? = null,
    var kuf: String? = null,
    var kui: String? = null,
    var kul: String? = null,
    var kur: String? = null,
    var tu1: String? = null,
    var tu2: String? = null,
    var tu3: String? = null,
    var tu4: String? = null,
    var vucmax: String? = null,
    var vuimax: String? = null,
    var vuimin: String? = null,
    var vulmax: String? = null,
    var vulmin: String? = null,
    var vurmax: String? = null
)

@Entity
data class UnderexcLimIEEE2(
    @Id var underexcLimIEEE2Id: UUID? = null,
    var k1: String? = null,
    var k2: String? = null,
    var kfb: String? = null,
    var kuf: String? = null,
    var kui: String? = null,
    var kul: String? = null,
    var p0: String? = null,
    var p1: String? = null,
    var p10: String? = null,
    var p2: String? = null,
    var p3: String? = null,
    var p4: String? = null,
    var p5: String? = null,
    var p6: String? = null,
    var p7: String? = null,
    var p8: String? = null,
    var p9: String? = null,
    var q0: String? = null,
    var q1: String? = null,
    var q10: String? = null,
    var q2: String? = null,
    var q3: String? = null,
    var q4: String? = null,
    var q5: String? = null,
    var q6: String? = null,
    var q7: String? = null,
    var q8: String? = null,
    var q9: String? = null,
    var tu1: String? = null,
    var tu2: String? = null,
    var tu3: String? = null,
    var tu4: String? = null,
    var tul: String? = null,
    var tup: String? = null,
    var tuq: String? = null,
    var tuv: String? = null,
    var vuimax: String? = null,
    var vuimin: String? = null,
    var vulmax: String? = null,
    var vulmin: String? = null
)

@Entity
data class UnderexcLimX1(
    @Id var underexcLimX1Id: UUID? = null,
    var k: String? = null,
    var kf2: String? = null,
    var km: String? = null,
    var melmax: String? = null,
    var tf2: String? = null,
    var tm: String? = null
)

@Entity
data class UnderexcLimX2(
    @Id var underexcLimX2Id: UUID? = null,
    var kf2: String? = null,
    var km: String? = null,
    var melmax: String? = null,
    var qo: String? = null,
    var r: String? = null,
    var tf2: String? = null,
    var tm: String? = null
)

@Entity
data class UnderexcitationLimiterDynamics(
     var underexcitationLimiterDynamicsId: UUID? = null
)

@Entity
data class UnderexcitationLimiterUserDefined(
    @Id var underexcitationLimiterUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class Unresolvedname(
     var unresolvednameId: UUID? = null
)

@Entity
data class VAdjIEEE(
    @Id var vAdjIEEEId: UUID? = null,
    var adjslew: String? = null,
    var taoff: String? = null,
    var taon: String? = null,
    var vadjf: String? = null,
    var vadjmax: String? = null,
    var vadjmin: String? = null
)

@Entity
data class VCompIEEEType1(
    @Id var vCompIEEEType1Id: UUID? = null,
    var rc: String? = null,
    var tr: String? = null,
    var xc: String? = null
)

@Entity
data class VCompIEEEType2(
    @Id var vCompIEEEType2Id: UUID? = null,
    var tr: String? = null
)

@Entity
data class ValueAliasSet(
     var valueAliasSetId: UUID? = null
)

@Entity
data class ValueToAlias(
    @Id var valueToAliasId: UUID? = null,
    var value: String? = null
)

@Entity
data class VisibilityLayer(
    @Id var visibilityLayerId: UUID? = null,
    var drawingOrder: String? = null
)

@Entity
data class Voltage(
    @Id var voltageId: UUID? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class VoltageAdjusterDynamics(
     var voltageAdjusterDynamicsId: UUID? = null
)

@Entity
data class VoltageAdjusterUserDefined(
    @Id var voltageAdjusterUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class VoltageCompensatorDynamics(
     var voltageCompensatorDynamicsId: UUID? = null
)

@Entity
data class VoltageCompensatorUserDefined(
    @Id var voltageCompensatorUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class VoltageLevel(
    @Id var voltageLevelId: UUID? = null,
    var highVoltageLimit: String? = null,
    var lowVoltageLimit: String? = null
)

@Entity
data class VoltageLimit(
    @Id var voltageLimitId: UUID? = null,
    var value: String? = null
)

@Entity
data class VoltagePerReactivePower(
    @Id var voltagePerReactivePowerId: UUID? = null,
    var denominatorMultiplier: String? = null,
    var denominatorUnit: String? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class VolumeFlowRate(
    @Id var volumeFlowRateId: UUID? = null,
    var denominatorMultiplier: String? = null,
    var denominatorUnit: String? = null,
    var multiplier: String? = null,
    var unit: String? = null,
    var value: String? = null
)

@Entity
data class VsCapabilityCurve(
     var vsCapabilityCurveId: UUID? = null
)

@Entity
data class VsConverter(
    @Id var vsConverterId: UUID? = null,
    var maxModulationIndex: String? = null,
    var maxValveCurrent: String? = null
)

@Entity
data class WindAeroConstIEC(
     var windAeroConstIECId: UUID? = null
)

@Entity
data class WindAeroLinearIEC(
    @Id var windAeroLinearIECId: UUID? = null,
    var dpomega: String? = null,
    var dptheta: String? = null,
    var omegazero: String? = null,
    var pavail: String? = null,
    var thetazero: String? = null
)

@Entity
data class WindContCurrLimIEC(
    @Id var windContCurrLimIECId: UUID? = null,
    var imax: String? = null,
    var imaxdip: String? = null,
    var mdfslim: String? = null,
    var mqpri: String? = null,
    var tufilt: String? = null
)

@Entity
data class WindContPType3IEC(
    @Id var windContPType3IECId: UUID? = null,
    var dpmax: String? = null,
    var dtrisemaxlvrt: String? = null,
    var kdtd: String? = null,
    var kip: String? = null,
    var kpp: String? = null,
    var mplvrt: String? = null,
    var omegaoffset: String? = null,
    var pdtdmax: String? = null,
    var rramp: String? = null,
    var tdvs: String? = null,
    var temin: String? = null,
    var tomegafilt: String? = null,
    var tpfilt: String? = null,
    var tpord: String? = null,
    var tufilt: String? = null,
    var tuscale: String? = null,
    var twref: String? = null,
    var udvs: String? = null,
    var updip: String? = null,
    var wdtd: String? = null,
    var zeta: String? = null
)

@Entity
data class WindContPType4aIEC(
    @Id var windContPType4aIECId: UUID? = null,
    var dpmax: String? = null,
    var tpord: String? = null,
    var tufilt: String? = null
)

@Entity
data class WindContPType4bIEC(
    @Id var windContPType4bIECId: UUID? = null,
    var dpmax: String? = null,
    var tpaero: String? = null,
    var tpord: String? = null,
    var tufilt: String? = null
)

@Entity
data class WindContPitchAngleIEC(
    @Id var windContPitchAngleIECId: UUID? = null,
    var dthetamax: String? = null,
    var dthetamin: String? = null,
    var kic: String? = null,
    var kiomega: String? = null,
    var kpc: String? = null,
    var kpomega: String? = null,
    var kpx: String? = null,
    var thetamax: String? = null,
    var thetamin: String? = null,
    var ttheta: String? = null
)

@Entity
data class WindContQIEC(
    @Id var windContQIECId: UUID? = null,
    var iqh1: String? = null,
    var iqmax: String? = null,
    var iqmin: String? = null,
    var iqpost: String? = null,
    var kiq: String? = null,
    var kiu: String? = null,
    var kpq: String? = null,
    var kpu: String? = null,
    var kqv: String? = null,
    var qmax: String? = null,
    var qmin: String? = null,
    var rdroop: String? = null,
    var tiq: String? = null,
    var tpfilt: String? = null,
    var tpost: String? = null,
    var tqord: String? = null,
    var tufilt: String? = null,
    var udb1: String? = null,
    var udb2: String? = null,
    var umax: String? = null,
    var umin: String? = null,
    var uqdip: String? = null,
    var uref0: String? = null,
    var windLVRTQcontrolModesType: String? = null,
    var windQcontrolModesType: String? = null,
    var xdroop: String? = null
)

@Entity
data class WindContRotorRIEC(
    @Id var windContRotorRIECId: UUID? = null,
    var kirr: String? = null,
    var komegafilt: String? = null,
    var kpfilt: String? = null,
    var kprr: String? = null,
    var rmax: String? = null,
    var rmin: String? = null,
    var tomegafilt: String? = null,
    var tpfilt: String? = null
)

@Entity
data class WindDynamicsLookupTable(
    @Id var windDynamicsLookupTableId: UUID? = null,
    var input: String? = null,
    var lookupTableFunctionType: String? = null,
    var output: String? = null,
    var sequence: String? = null
)

@Entity
data class WindGenTurbineType1IEC(
     var windGenTurbineType1IECId: UUID? = null
)

@Entity
data class WindGenTurbineType2IEC(
     var windGenTurbineType2IECId: UUID? = null
)

@Entity
data class WindGenTurbineType3IEC(
    @Id var windGenTurbineType3IECId: UUID? = null,
    var dipmax: String? = null,
    var diqmax: String? = null
)

@Entity
data class WindGenTurbineType3aIEC(
    @Id var windGenTurbineType3aIECId: UUID? = null,
    var kpc: String? = null,
    var tic: String? = null,
    var xs: String? = null
)

@Entity
data class WindGenTurbineType3bIEC(
    @Id var windGenTurbineType3bIECId: UUID? = null,
    var fducw: String? = null,
    var mwtcwp: String? = null,
    var tg: String? = null,
    var two: String? = null,
    var xs: String? = null
)

@Entity
data class WindGenType4IEC(
    @Id var windGenType4IECId: UUID? = null,
    var dipmax: String? = null,
    var diqmax: String? = null,
    var diqmin: String? = null,
    var tg: String? = null
)

@Entity
data class WindGeneratingUnit(
    @Id var windGeneratingUnitId: UUID? = null,
    var windGenUnitType: String? = null
)

@Entity
data class WindMechIEC(
    @Id var windMechIECId: UUID? = null,
    var cdrt: String? = null,
    var hgen: String? = null,
    var hwtr: String? = null,
    var kdrt: String? = null
)

@Entity
data class WindPitchContEmulIEC(
    @Id var windPitchContEmulIECId: UUID? = null,
    var kdroop: String? = null,
    var kipce: String? = null,
    var komegaaero: String? = null,
    var kppce: String? = null,
    var omegaref: String? = null,
    var pimax: String? = null,
    var pimin: String? = null,
    var t1: String? = null,
    var t2: String? = null,
    var tpe: String? = null
)

@Entity
data class WindPlantDynamics(
     var windPlantDynamicsId: UUID? = null
)

@Entity
data class WindPlantFreqPcontrolIEC(
    @Id var windPlantFreqPcontrolIECId: UUID? = null,
    var dprefmax: String? = null,
    var dprefmin: String? = null,
    var kiwpp: String? = null,
    var kpwpp: String? = null,
    var prefmax: String? = null,
    var prefmin: String? = null,
    var tpft: String? = null,
    var tpfv: String? = null,
    var twpffilt: String? = null,
    var twppfilt: String? = null
)

@Entity
data class WindPlantIEC(
     var windPlantIECId: UUID? = null
)

@Entity
data class WindPlantReactiveControlIEC(
    @Id var windPlantReactiveControlIECId: UUID? = null,
    var kiwpx: String? = null,
    var kpwpx: String? = null,
    var kwpqu: String? = null,
    var mwppf: String? = null,
    var mwpu: String? = null,
    var twppfilt: String? = null,
    var twpqfilt: String? = null,
    var twpufilt: String? = null,
    var txft: String? = null,
    var txfv: String? = null,
    var uwpqdip: String? = null,
    var xrefmax: String? = null,
    var xrefmin: String? = null
)

@Entity
data class WindPlantUserDefined(
    @Id var windPlantUserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class WindProtectionIEC(
    @Id var windProtectionIECId: UUID? = null,
    var fover: String? = null,
    var funder: String? = null,
    var tfover: String? = null,
    var tfunder: String? = null,
    var tuover: String? = null,
    var tuunder: String? = null,
    var uover: String? = null,
    var uunder: String? = null
)

@Entity
data class WindTurbineType1or2Dynamics(
     var windTurbineType1or2DynamicsId: UUID? = null
)

@Entity
data class WindTurbineType1or2IEC(
     var windTurbineType1or2IECId: UUID? = null
)

@Entity
data class WindTurbineType3or4Dynamics(
     var windTurbineType3or4DynamicsId: UUID? = null
)

@Entity
data class WindTurbineType3or4IEC(
     var windTurbineType3or4IECId: UUID? = null
)

@Entity
data class WindTurbineType4aIEC(
     var windTurbineType4aIECId: UUID? = null
)

@Entity
data class WindTurbineType4bIEC(
     var windTurbineType4bIECId: UUID? = null
)

@Entity
data class WindType1or2UserDefined(
    @Id var windType1or2UserDefinedId: UUID? = null,
    var proprietary: String? = null
)

@Entity
data class WindType3or4UserDefined(
    @Id var windType3or4UserDefinedId: UUID? = null,
    var proprietary: String? = null
)

