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
    @Id val aCDCConverterId: UUID? = null,
    val baseS: String? = null,
    val idleLoss: String? = null,
    val maxUdc: String? = null,
    val minUdc: String? = null,
    val numberOfValves: String? = null,
    val ratedUdc: String? = null,
    val resistiveLoss: String? = null,
    val switchingLoss: String? = null,
    val valveU0: String? = null
)

@Entity
data class ACDCConverterDCTerminal(
    @Id val aCDCConverterDCTerminalId: UUID? = null,
    val polarity: String? = null
)

@Entity
data class ACDCTerminal(
    @Id val aCDCTerminalId: UUID? = null,
    val sequenceNumber: String? = null
)

@Entity
data class ACLineSegment(
    @Id val aCLineSegmentId: UUID? = null,
    val b0ch: String? = null,
    val bch: String? = null,
    val g0ch: String? = null,
    val gch: String? = null,
    val r: String? = null,
    val r0: String? = null,
    val shortCircuitEndTemperature: String? = null,
    val x: String? = null,
    val x0: String? = null
)

@Entity
data class Accumulator(
     val accumulatorId: UUID? = null
)

@Entity
data class AccumulatorLimit(
    @Id val accumulatorLimitId: UUID? = null,
    val value: String? = null
)

@Entity
data class AccumulatorLimitSet(
     val accumulatorLimitSetId: UUID? = null
)

@Entity
data class AccumulatorReset(
     val accumulatorResetId: UUID? = null
)

@Entity
data class AccumulatorValue(
    @Id val accumulatorValueId: UUID? = null,
    val value: String? = null
)

@Entity
data class ActivePower(
    @Id val activePowerId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class ActivePowerLimit(
    @Id val activePowerLimitId: UUID? = null,
    val value: String? = null
)

@Entity
data class ActivePowerPerCurrentFlow(
    @Id val activePowerPerCurrentFlowId: UUID? = null,
    val denominatorMultiplier: String? = null,
    val denominatorUnit: String? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class ActivePowerPerFrequency(
    @Id val activePowerPerFrequencyId: UUID? = null,
    val denominatorMultiplier: String? = null,
    val denominatorUnit: String? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class Analog(
    @Id val analogId: UUID? = null,
    val positiveFlowIn: String? = null
)

@Entity
data class AnalogControl(
    @Id val analogControlId: UUID? = null,
    val maxValue: String? = null,
    val minValue: String? = null
)

@Entity
data class AnalogLimit(
    @Id val analogLimitId: UUID? = null,
    val value: String? = null
)

@Entity
data class AnalogLimitSet(
     val analogLimitSetId: UUID? = null
)

@Entity
data class AnalogValue(
    @Id val analogValueId: UUID? = null,
    val value: String? = null
)

@Entity
data class AngleDegrees(
    @Id val angleDegreesId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class AngleRadians(
    @Id val angleRadiansId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class ApparentPower(
    @Id val apparentPowerId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class ApparentPowerLimit(
    @Id val apparentPowerLimitId: UUID? = null,
    val value: String? = null
)

@Entity
data class Area(
    @Id val areaId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class AsynchronousMachine(
    @Id val asynchronousMachineId: UUID? = null,
    val converterFedDrive: String? = null,
    val efficiency: String? = null,
    val iaIrRatio: String? = null,
    val nominalFrequency: String? = null,
    val nominalSpeed: String? = null,
    val polePairNumber: String? = null,
    val ratedMechanicalPower: String? = null,
    val reversible: String? = null,
    val rxLockedRotorRatio: String? = null
)

@Entity
data class AsynchronousMachineDynamics(
     val asynchronousMachineDynamicsId: UUID? = null
)

@Entity
data class AsynchronousMachineEquivalentCircuit(
    @Id val asynchronousMachineEquivalentCircuitId: UUID? = null,
    val rr1: String? = null,
    val rr2: String? = null,
    val xlr1: String? = null,
    val xlr2: String? = null,
    val xm: String? = null
)

@Entity
data class AsynchronousMachineTimeConstantReactance(
    @Id val asynchronousMachineTimeConstantReactanceId: UUID? = null,
    val tpo: String? = null,
    val tppo: String? = null,
    val xp: String? = null,
    val xpp: String? = null,
    val xs: String? = null
)

@Entity
data class AsynchronousMachineUserDefined(
    @Id val asynchronousMachineUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class BaseVoltage(
    @Id val baseVoltageId: UUID? = null,
    val nominalVoltage: String? = null
)

@Entity
data class BasicIntervalSchedule(
    @Id val basicIntervalScheduleId: UUID? = null,
    val startTime: String? = null,
    val value1Unit: String? = null,
    val value2Unit: String? = null
)

@Entity
data class Bay(
     val bayId: UUID? = null
)

@Entity
data class BooleanProxy(
     val booleanProxyId: UUID? = null
)

@Entity
data class BoundaryExtensions(
    @Id val boundaryExtensionsId: UUID? = null,
    val boundaryPoint: String? = null,
    val fromEndIsoCode: String? = null,
    val fromEndName: String? = null,
    val fromEndNameTso: String? = null,
    val toEndIsoCode: String? = null,
    val toEndName: String? = null,
    val toEndNameTso: String? = null
)

@Entity
data class Breaker(
     val breakerId: UUID? = null
)

@Entity
data class BusNameMarker(
    @Id val busNameMarkerId: UUID? = null,
    val priority: String? = null
)

@Entity
data class BusbarSection(
    @Id val busbarSectionId: UUID? = null,
    val ipMax: String? = null
)

@Entity
data class Capacitance(
    @Id val capacitanceId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class CapacitancePerLength(
    @Id val capacitancePerLengthId: UUID? = null,
    val denominatorMultiplier: String? = null,
    val denominatorUnit: String? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class Command(
    @Id val commandId: UUID? = null,
    val normalValue: String? = null,
    val value: String? = null
)

@Entity
data class Conductance(
    @Id val conductanceId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class ConductingEquipment(
     val conductingEquipmentId: UUID? = null
)

@Entity
data class Conductor(
    @Id val conductorId: UUID? = null,
    val length: String? = null
)

@Entity
data class ConformLoad(
     val conformLoadId: UUID? = null
)

@Entity
data class ConformLoadGroup(
     val conformLoadGroupId: UUID? = null
)

@Entity
data class ConformLoadSchedule(
     val conformLoadScheduleId: UUID? = null
)

@Entity
data class ConnectivityNode(
    @Id val connectivityNodeId: UUID? = null,
    val boundaryPoint: String? = null,
    val fromEndIsoCode: String? = null,
    val fromEndName: String? = null,
    val fromEndNameTso: String? = null,
    val toEndIsoCode: String? = null,
    val toEndName: String? = null,
    val toEndNameTso: String? = null
)

@Entity
data class ConnectivityNodeContainer(
     val connectivityNodeContainerId: UUID? = null
)

@Entity
data class Connector(
     val connectorId: UUID? = null
)

@Entity
data class Control(
    @Id val controlId: UUID? = null,
    val controlType: String? = null,
    val operationInProgress: String? = null,
    val timeStamp: String? = null,
    val unitMultiplier: String? = null,
    val unitSymbol: String? = null
)

@Entity
data class ControlArea(
    @Id val controlAreaId: UUID? = null,
    val type: String? = null
)

@Entity
data class ControlAreaGeneratingUnit(
     val controlAreaGeneratingUnitId: UUID? = null
)

@Entity
data class CoordinateSystem(
    @Id val coordinateSystemId: UUID? = null,
    val crsUrn: String? = null
)

@Entity
data class CsConverter(
    @Id val csConverterId: UUID? = null,
    val maxAlpha: String? = null,
    val maxGamma: String? = null,
    val maxIdc: String? = null,
    val minAlpha: String? = null,
    val minGamma: String? = null,
    val minIdc: String? = null,
    val ratedIdc: String? = null
)

@Entity
data class CurrentFlow(
    @Id val currentFlowId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class CurrentLimit(
    @Id val currentLimitId: UUID? = null,
    val value: String? = null
)

@Entity
data class Curve(
    @Id val curveId: UUID? = null,
    val curveStyle: String? = null,
    val xUnit: String? = null,
    val y1Unit: String? = null,
    val y2Unit: String? = null
)

@Entity
data class CurveData(
    @Id val curveDataId: UUID? = null,
    val xvalue: String? = null,
    val y1value: String? = null,
    val y2value: String? = null
)

@Entity
data class DCBaseTerminal(
     val dCBaseTerminalId: UUID? = null
)

@Entity
data class DCBreaker(
     val dCBreakerId: UUID? = null
)

@Entity
data class DCBusbar(
     val dCBusbarId: UUID? = null
)

@Entity
data class DCChopper(
     val dCChopperId: UUID? = null
)

@Entity
data class DCConductingEquipment(
     val dCConductingEquipmentId: UUID? = null
)

@Entity
data class DCConverterUnit(
    @Id val dCConverterUnitId: UUID? = null,
    val operationMode: String? = null
)

@Entity
data class DCDisconnector(
     val dCDisconnectorId: UUID? = null
)

@Entity
data class DCEquipmentContainer(
     val dCEquipmentContainerId: UUID? = null
)

@Entity
data class DCGround(
    @Id val dCGroundId: UUID? = null,
    val inductance: String? = null,
    val r: String? = null
)

@Entity
data class DCLine(
     val dCLineId: UUID? = null
)

@Entity
data class DCLineSegment(
    @Id val dCLineSegmentId: UUID? = null,
    val capacitance: String? = null,
    val inductance: String? = null,
    val length: String? = null,
    val resistance: String? = null
)

@Entity
data class DCNode(
     val dCNodeId: UUID? = null
)

@Entity
data class DCSeriesDevice(
    @Id val dCSeriesDeviceId: UUID? = null,
    val inductance: String? = null,
    val ratedUdc: String? = null,
    val resistance: String? = null
)

@Entity
data class DCShunt(
    @Id val dCShuntId: UUID? = null,
    val capacitance: String? = null,
    val ratedUdc: String? = null,
    val resistance: String? = null
)

@Entity
data class DCSwitch(
     val dCSwitchId: UUID? = null
)

@Entity
data class DCTerminal(
     val dCTerminalId: UUID? = null
)

@Entity
data class DCTopologicalIsland(
     val dCTopologicalIslandId: UUID? = null
)

@Entity
data class DCTopologicalNode(
     val dCTopologicalNodeId: UUID? = null
)

@Entity
data class DateProxy(
     val dateProxyId: UUID? = null
)

@Entity
data class DateTime(
     val dateTimeId: UUID? = null
)

@Entity
data class DayType(
     val dayTypeId: UUID? = null
)

@Entity
data class DecimalProxy(
     val decimalProxyId: UUID? = null
)

@Entity
data class Diagram(
    @Id val diagramId: UUID? = null,
    val orientation: String? = null,
    val x1InitialView: String? = null,
    val x2InitialView: String? = null,
    val y1InitialView: String? = null,
    val y2InitialView: String? = null
)

@Entity
data class DiagramLayoutVersion(
    @Id val diagramLayoutVersionId: UUID? = null,
    val baseUML: String? = null,
    val baseURI: String? = null,
    val date: String? = null,
    val differenceModelURI: String? = null,
    val entsoeUML: String? = null,
    val entsoeURI: String? = null,
    val modelDescriptionURI: String? = null,
    val namespaceRDF: String? = null,
    val namespaceUML: String? = null,
    val shortName: String? = null
)

@Entity
data class DiagramObject(
    @Id val diagramObjectId: UUID? = null,
    val drawingOrder: String? = null,
    val isPolygon: String? = null,
    val offsetX: String? = null,
    val offsetY: String? = null,
    val rotation: String? = null
)

@Entity
data class DiagramObjectGluePoint(
     val diagramObjectGluePointId: UUID? = null
)

@Entity
data class DiagramObjectPoint(
    @Id val diagramObjectPointId: UUID? = null,
    val sequenceNumber: String? = null,
    val xPosition: String? = null,
    val yPosition: String? = null,
    val zPosition: String? = null
)

@Entity
data class DiagramObjectStyle(
     val diagramObjectStyleId: UUID? = null
)

@Entity
data class DiagramStyle(
     val diagramStyleId: UUID? = null
)

@Entity
data class DiscExcContIEEEDEC1A(
    @Id val discExcContIEEEDEC1AId: UUID? = null,
    val esc: String? = null,
    val kan: String? = null,
    val ketl: String? = null,
    val tan: String? = null,
    val td: String? = null,
    val tl1: String? = null,
    val tl2: String? = null,
    val tw5: String? = null,
    val value: String? = null,
    val vanmax: String? = null,
    val vomax: String? = null,
    val vomin: String? = null,
    val vsmax: String? = null,
    val vsmin: String? = null,
    val vtc: String? = null,
    val vtlmt: String? = null,
    val vtm: String? = null,
    val vtn: String? = null
)

@Entity
data class DiscExcContIEEEDEC2A(
    @Id val discExcContIEEEDEC2AId: UUID? = null,
    val td1: String? = null,
    val td2: String? = null,
    val vdmax: String? = null,
    val vdmin: String? = null,
    val vk: String? = null
)

@Entity
data class DiscExcContIEEEDEC3A(
    @Id val discExcContIEEEDEC3AId: UUID? = null,
    val tdr: String? = null,
    val vtmin: String? = null
)

@Entity
data class Disconnector(
     val disconnectorId: UUID? = null
)

@Entity
data class DiscontinuousExcitationControlDynamics(
     val discontinuousExcitationControlDynamicsId: UUID? = null
)

@Entity
data class DiscontinuousExcitationControlUserDefined(
    @Id val discontinuousExcitationControlUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class Discrete(
     val discreteId: UUID? = null
)

@Entity
data class DiscreteValue(
    @Id val discreteValueId: UUID? = null,
    val value: String? = null
)

@Entity
data class DomainVersion(
    @Id val domainVersionId: UUID? = null,
    val baseUML: String? = null,
    val date: String? = null,
    val entsoeUML: String? = null,
    val version: String? = null
)

@Entity
data class DynamicsFunctionBlock(
    @Id val dynamicsFunctionBlockId: UUID? = null,
    val enabled: String? = null
)

@Entity
data class DynamicsVersion(
    @Id val dynamicsVersionId: UUID? = null,
    val baseUML: String? = null,
    val baseURI: String? = null,
    val date: String? = null,
    val differenceModelURI: String? = null,
    val entsoeUML: String? = null,
    val entsoeURI: String? = null,
    val modelDescriptionURI: String? = null,
    val namespaceRDF: String? = null,
    val namespaceUML: String? = null,
    val shortName: String? = null
)

@Entity
data class Dynamicsmodel(
     val dynamicsmodelId: UUID? = null
)

@Entity
data class ENTSOEConnectivityNode(
     val eNTSOEConnectivityNodeId: UUID? = null
)

@Entity
data class ENTSOEIdentifiedObject(
    @Id val eNTSOEIdentifiedObjectId: UUID? = null,
    val energyIdentCodeEic: String? = null,
    val shortName: String? = null
)

@Entity
data class ENTSOEJunction(
     val eNTSOEJunctionId: UUID? = null
)

@Entity
data class ENTSOEOperationalLimitType(
    @Id val eNTSOEOperationalLimitTypeId: UUID? = null,
    val limitType: String? = null
)

@Entity
data class ENTSOETopologicalNode(
     val eNTSOETopologicalNodeId: UUID? = null
)

@Entity
data class EarthFaultCompensator(
    @Id val earthFaultCompensatorId: UUID? = null,
    val r: String? = null
)

@Entity
data class EnergyArea(
     val energyAreaId: UUID? = null
)

@Entity
data class EnergyConsumer(
    @Id val energyConsumerId: UUID? = null,
    val pfixed: String? = null,
    val pfixedPct: String? = null,
    val qfixed: String? = null,
    val qfixedPct: String? = null
)

@Entity
data class EnergySchedulingType(
     val energySchedulingTypeId: UUID? = null
)

@Entity
data class EnergySource(
     val energySourceId: UUID? = null
)

@Entity
data class Equipment(
     val equipmentId: UUID? = null
)

@Entity
data class EquipmentBoundaryVersion(
    @Id val equipmentBoundaryVersionId: UUID? = null,
    val baseUML: String? = null,
    val baseURI: String? = null,
    val date: String? = null,
    val differenceModelURI: String? = null,
    val entsoeUML: String? = null,
    val entsoeURIcore: String? = null,
    val entsoeURIoperation: String? = null,
    val modelDescriptionURI: String? = null,
    val namespaceRDF: String? = null,
    val namespaceUML: String? = null,
    val shortName: String? = null
)

@Entity
data class EquipmentContainer(
     val equipmentContainerId: UUID? = null
)

@Entity
data class EquipmentVersion(
    @Id val equipmentVersionId: UUID? = null,
    val baseUML: String? = null,
    val baseURIcore: String? = null,
    val baseURIoperation: String? = null,
    val baseURIshortCircuit: String? = null,
    val date: String? = null,
    val differenceModelURI: String? = null,
    val entsoeUML: String? = null,
    val entsoeURIcore: String? = null,
    val entsoeURIoperation: String? = null,
    val entsoeURIshortCircuit: String? = null,
    val modelDescriptionURI: String? = null,
    val namespaceRDF: String? = null,
    val namespaceUML: String? = null,
    val shortName: String? = null
)

@Entity
data class EquivalentBranch(
    @Id val equivalentBranchId: UUID? = null,
    val negativeR12: String? = null,
    val negativeR21: String? = null,
    val negativeX12: String? = null,
    val negativeX21: String? = null,
    val positiveR12: String? = null,
    val positiveR21: String? = null,
    val positiveX12: String? = null,
    val positiveX21: String? = null,
    val r: String? = null,
    val r21: String? = null,
    val x: String? = null,
    val x21: String? = null,
    val zeroR12: String? = null,
    val zeroR21: String? = null,
    val zeroX12: String? = null,
    val zeroX21: String? = null
)

@Entity
data class EquivalentEquipment(
     val equivalentEquipmentId: UUID? = null
)

@Entity
data class EquivalentInjection(
    @Id val equivalentInjectionId: UUID? = null,
    val maxP: String? = null,
    val maxQ: String? = null,
    val minP: String? = null,
    val minQ: String? = null,
    val r: String? = null,
    val r0: String? = null,
    val r2: String? = null,
    val regulationCapability: String? = null,
    val x: String? = null,
    val x0: String? = null,
    val x2: String? = null
)

@Entity
data class EquivalentNetwork(
     val equivalentNetworkId: UUID? = null
)

@Entity
data class EquivalentShunt(
    @Id val equivalentShuntId: UUID? = null,
    val b: String? = null,
    val g: String? = null
)

@Entity
data class ExcAC1A(
    @Id val excAC1AId: UUID? = null,
    val hvlvgates: String? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val kf1: String? = null,
    val kf2: String? = null,
    val ks: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcAC2A(
    @Id val excAC2AId: UUID? = null,
    val hvgate: String? = null,
    val ka: String? = null,
    val kb: String? = null,
    val kb1: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val kh: String? = null,
    val kl: String? = null,
    val kl1: String? = null,
    val ks: String? = null,
    val lvgate: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val vfemax: String? = null,
    val vlr: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcAC3A(
    @Id val excAC3AId: UUID? = null,
    val efdn: String? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val kf1: String? = null,
    val kf2: String? = null,
    val klv: String? = null,
    val kn: String? = null,
    val kr: String? = null,
    val ks: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val vemin: String? = null,
    val vfemax: String? = null,
    val vlv: String? = null
)

@Entity
data class ExcAC4A(
    @Id val excAC4AId: UUID? = null,
    val ka: String? = null,
    val kc: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val vimax: String? = null,
    val vimin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcAC5A(
    @Id val excAC5AId: UUID? = null,
    val a: String? = null,
    val efd1: String? = null,
    val efd2: String? = null,
    val ka: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val ks: String? = null,
    val seefd1: String? = null,
    val seefd2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf1: String? = null,
    val tf2: String? = null,
    val tf3: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcAC6A(
    @Id val excAC6AId: UUID? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val ke: String? = null,
    val kh: String? = null,
    val ks: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val th: String? = null,
    val tj: String? = null,
    val tk: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val vfelim: String? = null,
    val vhmax: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcAC8B(
    @Id val excAC8BId: UUID? = null,
    val inlim: String? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val kdr: String? = null,
    val ke: String? = null,
    val kir: String? = null,
    val kpr: String? = null,
    val ks: String? = null,
    val pidlim: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val ta: String? = null,
    val tdr: String? = null,
    val te: String? = null,
    val telim: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val vemin: String? = null,
    val vfemax: String? = null,
    val vimax: String? = null,
    val vimin: String? = null,
    val vpidmax: String? = null,
    val vpidmin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null,
    val vtmult: String? = null
)

@Entity
data class ExcANS(
    @Id val excANSId: UUID? = null,
    val blint: String? = null,
    val ifmn: String? = null,
    val ifmx: String? = null,
    val k2: String? = null,
    val k3: String? = null,
    val kce: String? = null,
    val krvecc: String? = null,
    val kvfif: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val tb: String? = null,
    val vrmn: String? = null,
    val vrmx: String? = null
)

@Entity
data class ExcAVR1(
    @Id val excAVR1Id: UUID? = null,
    val e1: String? = null,
    val e2: String? = null,
    val ka: String? = null,
    val kf: String? = null,
    val se1: String? = null,
    val se2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val vrmn: String? = null,
    val vrmx: String? = null
)

@Entity
data class ExcAVR2(
    @Id val excAVR2Id: UUID? = null,
    val e1: String? = null,
    val e2: String? = null,
    val ka: String? = null,
    val kf: String? = null,
    val se1: String? = null,
    val se2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val te: String? = null,
    val tf1: String? = null,
    val tf2: String? = null,
    val vrmn: String? = null,
    val vrmx: String? = null
)

@Entity
data class ExcAVR3(
    @Id val excAVR3Id: UUID? = null,
    val e1: String? = null,
    val e2: String? = null,
    val ka: String? = null,
    val se1: String? = null,
    val se2: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val te: String? = null,
    val vrmn: String? = null,
    val vrmx: String? = null
)

@Entity
data class ExcAVR4(
    @Id val excAVR4Id: UUID? = null,
    val imul: String? = null,
    val ka: String? = null,
    val ke: String? = null,
    val kif: String? = null,
    val t1: String? = null,
    val t1if: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val tif: String? = null,
    val vfmn: String? = null,
    val vfmx: String? = null,
    val vrmn: String? = null,
    val vrmx: String? = null
)

@Entity
data class ExcAVR5(
    @Id val excAVR5Id: UUID? = null,
    val ka: String? = null,
    val rex: String? = null,
    val ta: String? = null
)

@Entity
data class ExcAVR7(
    @Id val excAVR7Id: UUID? = null,
    val a1: String? = null,
    val a2: String? = null,
    val a3: String? = null,
    val a4: String? = null,
    val a5: String? = null,
    val a6: String? = null,
    val k1: String? = null,
    val k3: String? = null,
    val k5: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val vmax1: String? = null,
    val vmax3: String? = null,
    val vmax5: String? = null,
    val vmin1: String? = null,
    val vmin3: String? = null,
    val vmin5: String? = null
)

@Entity
data class ExcBBC(
    @Id val excBBCId: UUID? = null,
    val efdmax: String? = null,
    val efdmin: String? = null,
    val k: String? = null,
    val switchIt: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null,
    val xe: String? = null
)

@Entity
data class ExcCZ(
    @Id val excCZId: UUID? = null,
    val efdmax: String? = null,
    val efdmin: String? = null,
    val ka: String? = null,
    val ke: String? = null,
    val kp: String? = null,
    val ta: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcDC1A(
    @Id val excDC1AId: UUID? = null,
    val edfmax: String? = null,
    val efd1: String? = null,
    val efd2: String? = null,
    val efdmin: String? = null,
    val exclim: String? = null,
    val ka: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val ks: String? = null,
    val seefd1: String? = null,
    val seefd2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcDC2A(
    @Id val excDC2AId: UUID? = null,
    val efd1: String? = null,
    val efd2: String? = null,
    val exclim: String? = null,
    val ka: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val ks: String? = null,
    val seefd1: String? = null,
    val seefd2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val tf1: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null,
    val vtlim: String? = null
)

@Entity
data class ExcDC3A(
    @Id val excDC3AId: UUID? = null,
    val edfmax: String? = null,
    val efd1: String? = null,
    val efd2: String? = null,
    val efdlim: String? = null,
    val efdmin: String? = null,
    val exclim: String? = null,
    val ke: String? = null,
    val kr: String? = null,
    val ks: String? = null,
    val kv: String? = null,
    val seefd1: String? = null,
    val seefd2: String? = null,
    val te: String? = null,
    val trh: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcDC3A1(
    @Id val excDC3A1Id: UUID? = null,
    val exclim: String? = null,
    val ka: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val ta: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val vb1max: String? = null,
    val vblim: String? = null,
    val vbmax: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcELIN1(
    @Id val excELIN1Id: UUID? = null,
    val dpnf: String? = null,
    val efmax: String? = null,
    val efmin: String? = null,
    val ks1: String? = null,
    val ks2: String? = null,
    val smax: String? = null,
    val tfi: String? = null,
    val tnu: String? = null,
    val ts1: String? = null,
    val ts2: String? = null,
    val tsw: String? = null,
    val vpi: String? = null,
    val vpnf: String? = null,
    val vpu: String? = null,
    val xe: String? = null
)

@Entity
data class ExcELIN2(
    @Id val excELIN2Id: UUID? = null,
    val efdbas: String? = null,
    val iefmax: String? = null,
    val iefmax2: String? = null,
    val iefmin: String? = null,
    val k1: String? = null,
    val k1ec: String? = null,
    val k2: String? = null,
    val k3: String? = null,
    val k4: String? = null,
    val kd1: String? = null,
    val ke2: String? = null,
    val ketb: String? = null,
    val pid1max: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val tb1: String? = null,
    val te: String? = null,
    val te2: String? = null,
    val ti1: String? = null,
    val ti3: String? = null,
    val ti4: String? = null,
    val tr4: String? = null,
    val upmax: String? = null,
    val upmin: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val xp: String? = null
)

@Entity
data class ExcHU(
    @Id val excHUId: UUID? = null,
    val ae: String? = null,
    val ai: String? = null,
    val atr: String? = null,
    val emax: String? = null,
    val emin: String? = null,
    val imax: String? = null,
    val imin: String? = null,
    val ke: String? = null,
    val ki: String? = null,
    val te: String? = null,
    val ti: String? = null,
    val tr: String? = null
)

@Entity
data class ExcIEEEAC1A(
    @Id val excIEEEAC1AId: UUID? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEAC2A(
    @Id val excIEEEAC2AId: UUID? = null,
    val ka: String? = null,
    val kb: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val kh: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val vfemax: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEAC3A(
    @Id val excIEEEAC3AId: UUID? = null,
    val efdn: String? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val kn: String? = null,
    val kr: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val vemin: String? = null,
    val vfemax: String? = null
)

@Entity
data class ExcIEEEAC4A(
    @Id val excIEEEAC4AId: UUID? = null,
    val ka: String? = null,
    val kc: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val vimax: String? = null,
    val vimin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEAC5A(
    @Id val excIEEEAC5AId: UUID? = null,
    val efd1: String? = null,
    val efd2: String? = null,
    val ka: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val seefd1: String? = null,
    val seefd2: String? = null,
    val ta: String? = null,
    val te: String? = null,
    val tf1: String? = null,
    val tf2: String? = null,
    val tf3: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEAC6A(
    @Id val excIEEEAC6AId: UUID? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val ke: String? = null,
    val kh: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val th: String? = null,
    val tj: String? = null,
    val tk: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val vfelim: String? = null,
    val vhmax: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEAC7B(
    @Id val excIEEEAC7BId: UUID? = null,
    val kc: String? = null,
    val kd: String? = null,
    val kdr: String? = null,
    val ke: String? = null,
    val kf1: String? = null,
    val kf2: String? = null,
    val kf3: String? = null,
    val kia: String? = null,
    val kir: String? = null,
    val kl: String? = null,
    val kp: String? = null,
    val kpa: String? = null,
    val kpr: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val tdr: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val vemin: String? = null,
    val vfemax: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEAC8B(
    @Id val excIEEEAC8BId: UUID? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val kdr: String? = null,
    val ke: String? = null,
    val kir: String? = null,
    val kpr: String? = null,
    val seve1: String? = null,
    val seve2: String? = null,
    val ta: String? = null,
    val tdr: String? = null,
    val te: String? = null,
    val ve1: String? = null,
    val ve2: String? = null,
    val vemin: String? = null,
    val vfemax: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEDC1A(
    @Id val excIEEEDC1AId: UUID? = null,
    val efd1: String? = null,
    val efd2: String? = null,
    val exclim: String? = null,
    val ka: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val seefd1: String? = null,
    val seefd2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val uelin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEDC2A(
    @Id val excIEEEDC2AId: UUID? = null,
    val efd1: String? = null,
    val efd2: String? = null,
    val exclim: String? = null,
    val ka: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val seefd1: String? = null,
    val seefd2: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val uelin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEDC3A(
    @Id val excIEEEDC3AId: UUID? = null,
    val efd1: String? = null,
    val efd2: String? = null,
    val exclim: String? = null,
    val ke: String? = null,
    val kv: String? = null,
    val seefd1: String? = null,
    val seefd2: String? = null,
    val te: String? = null,
    val trh: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEDC4B(
    @Id val excIEEEDC4BId: UUID? = null,
    val efd1: String? = null,
    val efd2: String? = null,
    val ka: String? = null,
    val kd: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val oelin: String? = null,
    val seefd1: String? = null,
    val seefd2: String? = null,
    val ta: String? = null,
    val td: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val uelin: String? = null,
    val vemin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEST1A(
    @Id val excIEEEST1AId: UUID? = null,
    val ilr: String? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kf: String? = null,
    val klr: String? = null,
    val pssin: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tb1: String? = null,
    val tc: String? = null,
    val tc1: String? = null,
    val tf: String? = null,
    val uelin: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val vimax: String? = null,
    val vimin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEST2A(
    @Id val excIEEEST2AId: UUID? = null,
    val efdmax: String? = null,
    val ka: String? = null,
    val kc: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val ta: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val uelin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEST3A(
    @Id val excIEEEST3AId: UUID? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kg: String? = null,
    val ki: String? = null,
    val km: String? = null,
    val kp: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val thetap: String? = null,
    val tm: String? = null,
    val vbmax: String? = null,
    val vgmax: String? = null,
    val vimax: String? = null,
    val vimin: String? = null,
    val vmmax: String? = null,
    val vmmin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null,
    val xl: String? = null
)

@Entity
data class ExcIEEEST4B(
    @Id val excIEEEST4BId: UUID? = null,
    val kc: String? = null,
    val kg: String? = null,
    val ki: String? = null,
    val kim: String? = null,
    val kir: String? = null,
    val kp: String? = null,
    val kpm: String? = null,
    val kpr: String? = null,
    val ta: String? = null,
    val thetap: String? = null,
    val vbmax: String? = null,
    val vmmax: String? = null,
    val vmmin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null,
    val xl: String? = null
)

@Entity
data class ExcIEEEST5B(
    @Id val excIEEEST5BId: UUID? = null,
    val kc: String? = null,
    val kr: String? = null,
    val t1: String? = null,
    val tb1: String? = null,
    val tb2: String? = null,
    val tc1: String? = null,
    val tc2: String? = null,
    val tob1: String? = null,
    val tob2: String? = null,
    val toc1: String? = null,
    val toc2: String? = null,
    val tub1: String? = null,
    val tub2: String? = null,
    val tuc1: String? = null,
    val tuc2: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEST6B(
    @Id val excIEEEST6BId: UUID? = null,
    val ilr: String? = null,
    val kci: String? = null,
    val kff: String? = null,
    val kg: String? = null,
    val kia: String? = null,
    val klr: String? = null,
    val km: String? = null,
    val kpa: String? = null,
    val oelin: String? = null,
    val tg: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcIEEEST7B(
    @Id val excIEEEST7BId: UUID? = null,
    val kh: String? = null,
    val kia: String? = null,
    val kl: String? = null,
    val kpa: String? = null,
    val oelin: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val tf: String? = null,
    val tg: String? = null,
    val tia: String? = null,
    val uelin: String? = null,
    val vmax: String? = null,
    val vmin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcOEX3T(
    @Id val excOEX3TId: UUID? = null,
    val e1: String? = null,
    val e2: String? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val see1: String? = null,
    val see2: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcPIC(
    @Id val excPICId: UUID? = null,
    val e1: String? = null,
    val e2: String? = null,
    val efdmax: String? = null,
    val efdmin: String? = null,
    val ka: String? = null,
    val kc: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val se1: String? = null,
    val se2: String? = null,
    val ta1: String? = null,
    val ta2: String? = null,
    val ta3: String? = null,
    val ta4: String? = null,
    val te: String? = null,
    val tf1: String? = null,
    val tf2: String? = null,
    val vr1: String? = null,
    val vr2: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcREXS(
    @Id val excREXSId: UUID? = null,
    val e1: String? = null,
    val e2: String? = null,
    val fbf: String? = null,
    val flimf: String? = null,
    val kc: String? = null,
    val kd: String? = null,
    val ke: String? = null,
    val kefd: String? = null,
    val kf: String? = null,
    val kh: String? = null,
    val kii: String? = null,
    val kip: String? = null,
    val ks: String? = null,
    val kvi: String? = null,
    val kvp: String? = null,
    val kvphz: String? = null,
    val nvphz: String? = null,
    val se1: String? = null,
    val se2: String? = null,
    val ta: String? = null,
    val tb1: String? = null,
    val tb2: String? = null,
    val tc1: String? = null,
    val tc2: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val tf1: String? = null,
    val tf2: String? = null,
    val tp: String? = null,
    val vcmax: String? = null,
    val vfmax: String? = null,
    val vfmin: String? = null,
    val vimax: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null,
    val xc: String? = null
)

@Entity
data class ExcSCRX(
    @Id val excSCRXId: UUID? = null,
    val cswitch: String? = null,
    val emax: String? = null,
    val emin: String? = null,
    val k: String? = null,
    val rcrfd: String? = null,
    val tatb: String? = null,
    val tb: String? = null,
    val te: String? = null
)

@Entity
data class ExcSEXS(
    @Id val excSEXSId: UUID? = null,
    val efdmax: String? = null,
    val efdmin: String? = null,
    val emax: String? = null,
    val emin: String? = null,
    val k: String? = null,
    val kc: String? = null,
    val tatb: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null
)

@Entity
data class ExcSK(
    @Id val excSKId: UUID? = null,
    val efdmax: String? = null,
    val efdmin: String? = null,
    val emax: String? = null,
    val emin: String? = null,
    val k: String? = null,
    val k1: String? = null,
    val k2: String? = null,
    val kc: String? = null,
    val kce: String? = null,
    val kd: String? = null,
    val kgob: String? = null,
    val kp: String? = null,
    val kqi: String? = null,
    val kqob: String? = null,
    val kqp: String? = null,
    val nq: String? = null,
    val qconoff: String? = null,
    val qz: String? = null,
    val remote: String? = null,
    val sbase: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val ti: String? = null,
    val tp: String? = null,
    val tr: String? = null,
    val uimax: String? = null,
    val uimin: String? = null,
    val urmax: String? = null,
    val urmin: String? = null,
    val vtmax: String? = null,
    val vtmin: String? = null,
    val yp: String? = null
)

@Entity
data class ExcST1A(
    @Id val excST1AId: UUID? = null,
    val ilr: String? = null,
    val ka: String? = null,
    val kc: String? = null,
    val kf: String? = null,
    val klr: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tb1: String? = null,
    val tc: String? = null,
    val tc1: String? = null,
    val tf: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val vimax: String? = null,
    val vimin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null,
    val xe: String? = null
)

@Entity
data class ExcST2A(
    @Id val excST2AId: UUID? = null,
    val efdmax: String? = null,
    val ka: String? = null,
    val kc: String? = null,
    val ke: String? = null,
    val kf: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val te: String? = null,
    val tf: String? = null,
    val uelin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcST3A(
    @Id val excST3AId: UUID? = null,
    val efdmax: String? = null,
    val kc: String? = null,
    val kg: String? = null,
    val ki: String? = null,
    val kj: String? = null,
    val km: String? = null,
    val kp: String? = null,
    val ks: String? = null,
    val ks1: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val thetap: String? = null,
    val tm: String? = null,
    val vbmax: String? = null,
    val vgmax: String? = null,
    val vimax: String? = null,
    val vimin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null,
    val xl: String? = null
)

@Entity
data class ExcST4B(
    @Id val excST4BId: UUID? = null,
    val kc: String? = null,
    val kg: String? = null,
    val ki: String? = null,
    val kim: String? = null,
    val kir: String? = null,
    val kp: String? = null,
    val kpm: String? = null,
    val kpr: String? = null,
    val lvgate: String? = null,
    val ta: String? = null,
    val thetap: String? = null,
    val uel: String? = null,
    val vbmax: String? = null,
    val vgmax: String? = null,
    val vmmax: String? = null,
    val vmmin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null,
    val xl: String? = null
)

@Entity
data class ExcST6B(
    @Id val excST6BId: UUID? = null,
    val ilr: String? = null,
    val k1: String? = null,
    val kcl: String? = null,
    val kff: String? = null,
    val kg: String? = null,
    val kia: String? = null,
    val klr: String? = null,
    val km: String? = null,
    val kpa: String? = null,
    val kvd: String? = null,
    val oelin: String? = null,
    val tg: String? = null,
    val ts: String? = null,
    val tvd: String? = null,
    val vamax: String? = null,
    val vamin: String? = null,
    val vilim: String? = null,
    val vimax: String? = null,
    val vimin: String? = null,
    val vmult: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null,
    val xc: String? = null
)

@Entity
data class ExcST7B(
    @Id val excST7BId: UUID? = null,
    val kh: String? = null,
    val kia: String? = null,
    val kl: String? = null,
    val kpa: String? = null,
    val oelin: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val tf: String? = null,
    val tg: String? = null,
    val tia: String? = null,
    val ts: String? = null,
    val uelin: String? = null,
    val vmax: String? = null,
    val vmin: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class ExcitationSystemDynamics(
     val excitationSystemDynamicsId: UUID? = null
)

@Entity
data class ExcitationSystemUserDefined(
    @Id val excitationSystemUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class ExtensionVersion(
    @Id val extensionVersionId: UUID? = null,
    val date: String? = null,
    val namespaceURI: String? = null
)

@Entity
data class ExternalNetworkInjection(
    @Id val externalNetworkInjectionId: UUID? = null,
    val governorSCD: String? = null,
    val ikSecond: String? = null,
    val maxInitialSymShCCurrent: String? = null,
    val maxP: String? = null,
    val maxQ: String? = null,
    val maxR0ToX0Ratio: String? = null,
    val maxR1ToX1Ratio: String? = null,
    val maxZ0ToZ1Ratio: String? = null,
    val minInitialSymShCCurrent: String? = null,
    val minP: String? = null,
    val minQ: String? = null,
    val minR0ToX0Ratio: String? = null,
    val minR1ToX1Ratio: String? = null,
    val minZ0ToZ1Ratio: String? = null,
    val voltageFactor: String? = null
)

@Entity
data class FloatProxy(
     val floatProxyId: UUID? = null
)

@Entity
data class FossilFuel(
    @Id val fossilFuelId: UUID? = null,
    val fossilFuelType: String? = null
)

@Entity
data class Frequency(
    @Id val frequencyId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class GenICompensationForGenJ(
    @Id val genICompensationForGenJId: UUID? = null,
    val rcij: String? = null,
    val xcij: String? = null
)

@Entity
data class GeneratingUnit(
    @Id val generatingUnitId: UUID? = null,
    val genControlSource: String? = null,
    val governorSCD: String? = null,
    val initialP: String? = null,
    val longPF: String? = null,
    val maximumAllowableSpinningReserve: String? = null,
    val maxOperatingP: String? = null,
    val minOperatingP: String? = null,
    val nominalP: String? = null,
    val ratedGrossMaxP: String? = null,
    val ratedGrossMinP: String? = null,
    val ratedNetMaxP: String? = null,
    val shortPF: String? = null,
    val startupCost: String? = null,
    val totalEfficiency: String? = null,
    val variableCost: String? = null
)

@Entity
data class GeographicalLocationVersion(
    @Id val geographicalLocationVersionId: UUID? = null,
    val baseUML: String? = null,
    val baseURI: String? = null,
    val date: String? = null,
    val differenceModelURI: String? = null,
    val entsoeUML: String? = null,
    val entsoeURI: String? = null,
    val modelDescriptionURI: String? = null,
    val namespaceRDF: String? = null,
    val namespaceUML: String? = null,
    val shortName: String? = null
)

@Entity
data class GeographicalRegion(
     val geographicalRegionId: UUID? = null
)

@Entity
data class GovCT1(
    @Id val govCT1Id: UUID? = null,
    val aset: String? = null,
    val db: String? = null,
    val dm: String? = null,
    val ka: String? = null,
    val kdgov: String? = null,
    val kigov: String? = null,
    val kiload: String? = null,
    val kimw: String? = null,
    val kpgov: String? = null,
    val kpload: String? = null,
    val kturb: String? = null,
    val ldref: String? = null,
    val maxerr: String? = null,
    val minerr: String? = null,
    val mwbase: String? = null,
    val r: String? = null,
    val rclose: String? = null,
    val rdown: String? = null,
    val ropen: String? = null,
    val rselect: String? = null,
    val rup: String? = null,
    val ta: String? = null,
    val tact: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val tdgov: String? = null,
    val teng: String? = null,
    val tfload: String? = null,
    val tpelec: String? = null,
    val tsa: String? = null,
    val tsb: String? = null,
    val vmax: String? = null,
    val vmin: String? = null,
    val wfnl: String? = null,
    val wfspd: String? = null
)

@Entity
data class GovCT2(
    @Id val govCT2Id: UUID? = null,
    val aset: String? = null,
    val db: String? = null,
    val dm: String? = null,
    val flim1: String? = null,
    val flim10: String? = null,
    val flim2: String? = null,
    val flim3: String? = null,
    val flim4: String? = null,
    val flim5: String? = null,
    val flim6: String? = null,
    val flim7: String? = null,
    val flim8: String? = null,
    val flim9: String? = null,
    val ka: String? = null,
    val kdgov: String? = null,
    val kigov: String? = null,
    val kiload: String? = null,
    val kimw: String? = null,
    val kpgov: String? = null,
    val kpload: String? = null,
    val kturb: String? = null,
    val ldref: String? = null,
    val maxerr: String? = null,
    val minerr: String? = null,
    val mwbase: String? = null,
    val plim1: String? = null,
    val plim10: String? = null,
    val plim2: String? = null,
    val plim3: String? = null,
    val plim4: String? = null,
    val plim5: String? = null,
    val plim6: String? = null,
    val plim7: String? = null,
    val plim8: String? = null,
    val plim9: String? = null,
    val prate: String? = null,
    val r: String? = null,
    val rclose: String? = null,
    val rdown: String? = null,
    val ropen: String? = null,
    val rselect: String? = null,
    val rup: String? = null,
    val ta: String? = null,
    val tact: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val tdgov: String? = null,
    val teng: String? = null,
    val tfload: String? = null,
    val tpelec: String? = null,
    val tsa: String? = null,
    val tsb: String? = null,
    val vmax: String? = null,
    val vmin: String? = null,
    val wfnl: String? = null,
    val wfspd: String? = null
)

@Entity
data class GovGAST(
    @Id val govGASTId: UUID? = null,
    val at: String? = null,
    val dturb: String? = null,
    val kt: String? = null,
    val mwbase: String? = null,
    val r: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val vmax: String? = null,
    val vmin: String? = null
)

@Entity
data class GovGAST1(
    @Id val govGAST1Id: UUID? = null,
    val a: String? = null,
    val b: String? = null,
    val db1: String? = null,
    val db2: String? = null,
    val eps: String? = null,
    val fidle: String? = null,
    val gv1: String? = null,
    val gv2: String? = null,
    val gv3: String? = null,
    val gv4: String? = null,
    val gv5: String? = null,
    val gv6: String? = null,
    val ka: String? = null,
    val kt: String? = null,
    val lmax: String? = null,
    val loadinc: String? = null,
    val ltrate: String? = null,
    val mwbase: String? = null,
    val pgv1: String? = null,
    val pgv2: String? = null,
    val pgv3: String? = null,
    val pgv4: String? = null,
    val pgv5: String? = null,
    val pgv6: String? = null,
    val r: String? = null,
    val rmax: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val tltr: String? = null,
    val vmax: String? = null,
    val vmin: String? = null
)

@Entity
data class GovGAST2(
    @Id val govGAST2Id: UUID? = null,
    val a: String? = null,
    val af1: String? = null,
    val af2: String? = null,
    val b: String? = null,
    val bf1: String? = null,
    val bf2: String? = null,
    val c: String? = null,
    val cf2: String? = null,
    val ecr: String? = null,
    val etd: String? = null,
    val k3: String? = null,
    val k4: String? = null,
    val k5: String? = null,
    val k6: String? = null,
    val kf: String? = null,
    val mwbase: String? = null,
    val t: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val tc: String? = null,
    val tcd: String? = null,
    val tf: String? = null,
    val tmax: String? = null,
    val tmin: String? = null,
    val tr: String? = null,
    val trate: String? = null,
    val tt: String? = null,
    val w: String? = null,
    val x: String? = null,
    val y: String? = null,
    val z: String? = null
)

@Entity
data class GovGAST3(
    @Id val govGAST3Id: UUID? = null,
    val bca: String? = null,
    val bp: String? = null,
    val dtc: String? = null,
    val ka: String? = null,
    val kac: String? = null,
    val kca: String? = null,
    val ksi: String? = null,
    val ky: String? = null,
    val mnef: String? = null,
    val mxef: String? = null,
    val rcmn: String? = null,
    val rcmx: String? = null,
    val tac: String? = null,
    val tc: String? = null,
    val td: String? = null,
    val tfen: String? = null,
    val tg: String? = null,
    val tsi: String? = null,
    val tt: String? = null,
    val ttc: String? = null,
    val ty: String? = null
)

@Entity
data class GovGAST4(
    @Id val govGAST4Id: UUID? = null,
    val bp: String? = null,
    val ktm: String? = null,
    val mnef: String? = null,
    val mxef: String? = null,
    val rymn: String? = null,
    val rymx: String? = null,
    val ta: String? = null,
    val tc: String? = null,
    val tcm: String? = null,
    val tm: String? = null,
    val tv: String? = null
)

@Entity
data class GovGASTWD(
    @Id val govGASTWDId: UUID? = null,
    val a: String? = null,
    val af1: String? = null,
    val af2: String? = null,
    val b: String? = null,
    val bf1: String? = null,
    val bf2: String? = null,
    val c: String? = null,
    val cf2: String? = null,
    val ecr: String? = null,
    val etd: String? = null,
    val k3: String? = null,
    val k4: String? = null,
    val k5: String? = null,
    val k6: String? = null,
    val kd: String? = null,
    val kdroop: String? = null,
    val kf: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val mwbase: String? = null,
    val t: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val tc: String? = null,
    val tcd: String? = null,
    val td: String? = null,
    val tf: String? = null,
    val tmax: String? = null,
    val tmin: String? = null,
    val tr: String? = null,
    val trate: String? = null,
    val tt: String? = null
)

@Entity
data class GovHydro1(
    @Id val govHydro1Id: UUID? = null,
    val at: String? = null,
    val dturb: String? = null,
    val gmax: String? = null,
    val gmin: String? = null,
    val hdam: String? = null,
    val mwbase: String? = null,
    val qnl: String? = null,
    val rperm: String? = null,
    val rtemp: String? = null,
    val tf: String? = null,
    val tg: String? = null,
    val tr: String? = null,
    val tw: String? = null,
    val velm: String? = null
)

@Entity
data class GovHydro2(
    @Id val govHydro2Id: UUID? = null,
    val aturb: String? = null,
    val bturb: String? = null,
    val db1: String? = null,
    val db2: String? = null,
    val eps: String? = null,
    val gv1: String? = null,
    val gv2: String? = null,
    val gv3: String? = null,
    val gv4: String? = null,
    val gv5: String? = null,
    val gv6: String? = null,
    val kturb: String? = null,
    val mwbase: String? = null,
    val pgv1: String? = null,
    val pgv2: String? = null,
    val pgv3: String? = null,
    val pgv4: String? = null,
    val pgv5: String? = null,
    val pgv6: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val rperm: String? = null,
    val rtemp: String? = null,
    val tg: String? = null,
    val tp: String? = null,
    val tr: String? = null,
    val tw: String? = null,
    val uc: String? = null,
    val uo: String? = null
)

@Entity
data class GovHydro3(
    @Id val govHydro3Id: UUID? = null,
    val at: String? = null,
    val db1: String? = null,
    val db2: String? = null,
    val dturb: String? = null,
    val eps: String? = null,
    val governorControl: String? = null,
    val gv1: String? = null,
    val gv2: String? = null,
    val gv3: String? = null,
    val gv4: String? = null,
    val gv5: String? = null,
    val gv6: String? = null,
    val h0: String? = null,
    val k1: String? = null,
    val k2: String? = null,
    val kg: String? = null,
    val ki: String? = null,
    val mwbase: String? = null,
    val pgv1: String? = null,
    val pgv2: String? = null,
    val pgv3: String? = null,
    val pgv4: String? = null,
    val pgv5: String? = null,
    val pgv6: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val qnl: String? = null,
    val relec: String? = null,
    val rgate: String? = null,
    val td: String? = null,
    val tf: String? = null,
    val tp: String? = null,
    val tt: String? = null,
    val tw: String? = null,
    val velcl: String? = null,
    val velop: String? = null
)

@Entity
data class GovHydro4(
    @Id val govHydro4Id: UUID? = null,
    val at: String? = null,
    val bgv0: String? = null,
    val bgv1: String? = null,
    val bgv2: String? = null,
    val bgv3: String? = null,
    val bgv4: String? = null,
    val bgv5: String? = null,
    val bmax: String? = null,
    val db1: String? = null,
    val db2: String? = null,
    val dturb: String? = null,
    val eps: String? = null,
    val gmax: String? = null,
    val gmin: String? = null,
    val gv0: String? = null,
    val gv1: String? = null,
    val gv2: String? = null,
    val gv3: String? = null,
    val gv4: String? = null,
    val gv5: String? = null,
    val hdam: String? = null,
    val mwbase: String? = null,
    val pgv0: String? = null,
    val pgv1: String? = null,
    val pgv2: String? = null,
    val pgv3: String? = null,
    val pgv4: String? = null,
    val pgv5: String? = null,
    val qn1: String? = null,
    val rperm: String? = null,
    val rtemp: String? = null,
    val tblade: String? = null,
    val tg: String? = null,
    val tp: String? = null,
    val tr: String? = null,
    val tw: String? = null,
    val uc: String? = null,
    val uo: String? = null
)

@Entity
data class GovHydroDD(
    @Id val govHydroDDId: UUID? = null,
    val aturb: String? = null,
    val bturb: String? = null,
    val db1: String? = null,
    val db2: String? = null,
    val eps: String? = null,
    val gmax: String? = null,
    val gmin: String? = null,
    val gv1: String? = null,
    val gv2: String? = null,
    val gv3: String? = null,
    val gv4: String? = null,
    val gv5: String? = null,
    val gv6: String? = null,
    val inputSignal: String? = null,
    val k1: String? = null,
    val k2: String? = null,
    val kg: String? = null,
    val ki: String? = null,
    val mwbase: String? = null,
    val pgv1: String? = null,
    val pgv2: String? = null,
    val pgv3: String? = null,
    val pgv4: String? = null,
    val pgv5: String? = null,
    val pgv6: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val r: String? = null,
    val td: String? = null,
    val tf: String? = null,
    val tp: String? = null,
    val tt: String? = null,
    val tturb: String? = null,
    val velcl: String? = null,
    val velop: String? = null
)

@Entity
data class GovHydroFrancis(
    @Id val govHydroFrancisId: UUID? = null,
    val am: String? = null,
    val av0: String? = null,
    val av1: String? = null,
    val bp: String? = null,
    val db1: String? = null,
    val etamax: String? = null,
    val governorControl: String? = null,
    val h1: String? = null,
    val h2: String? = null,
    val hn: String? = null,
    val kc: String? = null,
    val kg: String? = null,
    val kt: String? = null,
    val qc0: String? = null,
    val qn: String? = null,
    val ta: String? = null,
    val td: String? = null,
    val ts: String? = null,
    val twnc: String? = null,
    val twng: String? = null,
    val tx: String? = null,
    val va: String? = null,
    val valvmax: String? = null,
    val valvmin: String? = null,
    val vc: String? = null,
    val waterTunnelSurgeChamberSimulation: String? = null,
    val zsfc: String? = null
)

@Entity
data class GovHydroIEEE0(
    @Id val govHydroIEEE0Id: UUID? = null,
    val k: String? = null,
    val mwbase: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null
)

@Entity
data class GovHydroIEEE2(
    @Id val govHydroIEEE2Id: UUID? = null,
    val aturb: String? = null,
    val bturb: String? = null,
    val gv1: String? = null,
    val gv2: String? = null,
    val gv3: String? = null,
    val gv4: String? = null,
    val gv5: String? = null,
    val gv6: String? = null,
    val kturb: String? = null,
    val mwbase: String? = null,
    val pgv1: String? = null,
    val pgv2: String? = null,
    val pgv3: String? = null,
    val pgv4: String? = null,
    val pgv5: String? = null,
    val pgv6: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val rperm: String? = null,
    val rtemp: String? = null,
    val tg: String? = null,
    val tp: String? = null,
    val tr: String? = null,
    val tw: String? = null,
    val uc: String? = null,
    val uo: String? = null
)

@Entity
data class GovHydroPID(
    @Id val govHydroPIDId: UUID? = null,
    val aturb: String? = null,
    val bturb: String? = null,
    val db1: String? = null,
    val db2: String? = null,
    val eps: String? = null,
    val gv1: String? = null,
    val gv2: String? = null,
    val gv3: String? = null,
    val gv4: String? = null,
    val gv5: String? = null,
    val gv6: String? = null,
    val inputSignal: String? = null,
    val kd: String? = null,
    val kg: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val mwbase: String? = null,
    val pgv1: String? = null,
    val pgv2: String? = null,
    val pgv3: String? = null,
    val pgv4: String? = null,
    val pgv5: String? = null,
    val pgv6: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val r: String? = null,
    val td: String? = null,
    val tf: String? = null,
    val tp: String? = null,
    val tt: String? = null,
    val tturb: String? = null,
    val velcl: String? = null,
    val velop: String? = null
)

@Entity
data class GovHydroPID2(
    @Id val govHydroPID2Id: UUID? = null,
    val atw: String? = null,
    val d: String? = null,
    val feedbackSignal: String? = null,
    val g0: String? = null,
    val g1: String? = null,
    val g2: String? = null,
    val gmax: String? = null,
    val gmin: String? = null,
    val kd: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val mwbase: String? = null,
    val p1: String? = null,
    val p2: String? = null,
    val p3: String? = null,
    val rperm: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val treg: String? = null,
    val tw: String? = null,
    val velmax: String? = null,
    val velmin: String? = null
)

@Entity
data class GovHydroPelton(
    @Id val govHydroPeltonId: UUID? = null,
    val av0: String? = null,
    val av1: String? = null,
    val bp: String? = null,
    val db1: String? = null,
    val db2: String? = null,
    val h1: String? = null,
    val h2: String? = null,
    val hn: String? = null,
    val kc: String? = null,
    val kg: String? = null,
    val qc0: String? = null,
    val qn: String? = null,
    val simplifiedPelton: String? = null,
    val staticCompensating: String? = null,
    val ta: String? = null,
    val ts: String? = null,
    val tv: String? = null,
    val twnc: String? = null,
    val twng: String? = null,
    val tx: String? = null,
    val va: String? = null,
    val valvmax: String? = null,
    val valvmin: String? = null,
    val vav: String? = null,
    val vc: String? = null,
    val vcv: String? = null,
    val waterTunnelSurgeChamberSimulation: String? = null,
    val zsfc: String? = null
)

@Entity
data class GovHydroR(
    @Id val govHydroRId: UUID? = null,
    val at: String? = null,
    val db1: String? = null,
    val db2: String? = null,
    val dturb: String? = null,
    val eps: String? = null,
    val gmax: String? = null,
    val gmin: String? = null,
    val gv1: String? = null,
    val gv2: String? = null,
    val gv3: String? = null,
    val gv4: String? = null,
    val gv5: String? = null,
    val gv6: String? = null,
    val h0: String? = null,
    val inputSignal: String? = null,
    val kg: String? = null,
    val ki: String? = null,
    val mwbase: String? = null,
    val pgv1: String? = null,
    val pgv2: String? = null,
    val pgv3: String? = null,
    val pgv4: String? = null,
    val pgv5: String? = null,
    val pgv6: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val qnl: String? = null,
    val r: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val t7: String? = null,
    val t8: String? = null,
    val td: String? = null,
    val tp: String? = null,
    val tt: String? = null,
    val tw: String? = null,
    val velcl: String? = null,
    val velop: String? = null
)

@Entity
data class GovHydroWEH(
    @Id val govHydroWEHId: UUID? = null,
    val db: String? = null,
    val dicn: String? = null,
    val dpv: String? = null,
    val dturb: String? = null,
    val feedbackSignal: String? = null,
    val fl1: String? = null,
    val fl2: String? = null,
    val fl3: String? = null,
    val fl4: String? = null,
    val fl5: String? = null,
    val fp1: String? = null,
    val fp10: String? = null,
    val fp2: String? = null,
    val fp3: String? = null,
    val fp4: String? = null,
    val fp5: String? = null,
    val fp6: String? = null,
    val fp7: String? = null,
    val fp8: String? = null,
    val fp9: String? = null,
    val gmax: String? = null,
    val gmin: String? = null,
    val gtmxcl: String? = null,
    val gtmxop: String? = null,
    val gv1: String? = null,
    val gv2: String? = null,
    val gv3: String? = null,
    val gv4: String? = null,
    val gv5: String? = null,
    val kd: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val mwbase: String? = null,
    val pmss1: String? = null,
    val pmss10: String? = null,
    val pmss2: String? = null,
    val pmss3: String? = null,
    val pmss4: String? = null,
    val pmss5: String? = null,
    val pmss6: String? = null,
    val pmss7: String? = null,
    val pmss8: String? = null,
    val pmss9: String? = null,
    val rpg: String? = null,
    val rpp: String? = null,
    val td: String? = null,
    val tdv: String? = null,
    val tg: String? = null,
    val tp: String? = null,
    val tpe: String? = null,
    val tw: String? = null
)

@Entity
data class GovHydroWPID(
    @Id val govHydroWPIDId: UUID? = null,
    val d: String? = null,
    val gatmax: String? = null,
    val gatmin: String? = null,
    val gv1: String? = null,
    val gv2: String? = null,
    val gv3: String? = null,
    val kd: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val mwbase: String? = null,
    val pgv1: String? = null,
    val pgv2: String? = null,
    val pgv3: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val reg: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val treg: String? = null,
    val tw: String? = null,
    val velmax: String? = null,
    val velmin: String? = null
)

@Entity
data class GovSteam0(
    @Id val govSteam0Id: UUID? = null,
    val dt: String? = null,
    val mwbase: String? = null,
    val r: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val vmax: String? = null,
    val vmin: String? = null
)

@Entity
data class GovSteam1(
    @Id val govSteam1Id: UUID? = null,
    val db1: String? = null,
    val db2: String? = null,
    val eps: String? = null,
    val gv1: String? = null,
    val gv2: String? = null,
    val gv3: String? = null,
    val gv4: String? = null,
    val gv5: String? = null,
    val gv6: String? = null,
    val k: String? = null,
    val k1: String? = null,
    val k2: String? = null,
    val k3: String? = null,
    val k4: String? = null,
    val k5: String? = null,
    val k6: String? = null,
    val k7: String? = null,
    val k8: String? = null,
    val mwbase: String? = null,
    val pgv1: String? = null,
    val pgv2: String? = null,
    val pgv3: String? = null,
    val pgv4: String? = null,
    val pgv5: String? = null,
    val pgv6: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val sdb1: String? = null,
    val sdb2: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val t7: String? = null,
    val uc: String? = null,
    val uo: String? = null,
    val valve: String? = null
)

@Entity
data class GovSteam2(
    @Id val govSteam2Id: UUID? = null,
    val dbf: String? = null,
    val k: String? = null,
    val mnef: String? = null,
    val mxef: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val t1: String? = null,
    val t2: String? = null
)

@Entity
data class GovSteamCC(
    @Id val govSteamCCId: UUID? = null,
    val dhp: String? = null,
    val dlp: String? = null,
    val fhp: String? = null,
    val flp: String? = null,
    val mwbase: String? = null,
    val pmaxhp: String? = null,
    val pmaxlp: String? = null,
    val rhp: String? = null,
    val rlp: String? = null,
    val t1hp: String? = null,
    val t1lp: String? = null,
    val t3hp: String? = null,
    val t3lp: String? = null,
    val t4hp: String? = null,
    val t4lp: String? = null,
    val t5hp: String? = null,
    val t5lp: String? = null
)

@Entity
data class GovSteamEU(
    @Id val govSteamEUId: UUID? = null,
    val chc: String? = null,
    val cho: String? = null,
    val cic: String? = null,
    val cio: String? = null,
    val db1: String? = null,
    val db2: String? = null,
    val hhpmax: String? = null,
    val ke: String? = null,
    val kfcor: String? = null,
    val khp: String? = null,
    val klp: String? = null,
    val kwcor: String? = null,
    val mwbase: String? = null,
    val pmax: String? = null,
    val prhmax: String? = null,
    val simx: String? = null,
    val tb: String? = null,
    val tdp: String? = null,
    val ten: String? = null,
    val tf: String? = null,
    val tfp: String? = null,
    val thp: String? = null,
    val tip: String? = null,
    val tlp: String? = null,
    val tp: String? = null,
    val trh: String? = null,
    val tvhp: String? = null,
    val tvip: String? = null,
    val tw: String? = null,
    val wfmax: String? = null,
    val wfmin: String? = null,
    val wmax1: String? = null,
    val wmax2: String? = null,
    val wwmax: String? = null,
    val wwmin: String? = null
)

@Entity
data class GovSteamFV2(
    @Id val govSteamFV2Id: UUID? = null,
    val dt: String? = null,
    val k: String? = null,
    val mwbase: String? = null,
    val r: String? = null,
    val t1: String? = null,
    val t3: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val ti: String? = null,
    val tt: String? = null,
    val vmax: String? = null,
    val vmin: String? = null
)

@Entity
data class GovSteamFV3(
    @Id val govSteamFV3Id: UUID? = null,
    val k: String? = null,
    val k1: String? = null,
    val k2: String? = null,
    val k3: String? = null,
    val mwbase: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val prmax: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val uc: String? = null,
    val uo: String? = null
)

@Entity
data class GovSteamFV4(
    @Id val govSteamFV4Id: UUID? = null,
    val cpsmn: String? = null,
    val cpsmx: String? = null,
    val crmn: String? = null,
    val crmx: String? = null,
    val kdc: String? = null,
    val kf1: String? = null,
    val kf3: String? = null,
    val khp: String? = null,
    val kic: String? = null,
    val kip: String? = null,
    val kit: String? = null,
    val kmp1: String? = null,
    val kmp2: String? = null,
    val kpc: String? = null,
    val kpp: String? = null,
    val kpt: String? = null,
    val krc: String? = null,
    val ksh: String? = null,
    val lpi: String? = null,
    val lps: String? = null,
    val mnef: String? = null,
    val mxef: String? = null,
    val pr1: String? = null,
    val pr2: String? = null,
    val psmn: String? = null,
    val rsmimn: String? = null,
    val rsmimx: String? = null,
    val rvgmn: String? = null,
    val rvgmx: String? = null,
    val srmn: String? = null,
    val srmx: String? = null,
    val srsmp: String? = null,
    val svmn: String? = null,
    val svmx: String? = null,
    val ta: String? = null,
    val tam: String? = null,
    val tc: String? = null,
    val tcm: String? = null,
    val tdc: String? = null,
    val tf1: String? = null,
    val tf2: String? = null,
    val thp: String? = null,
    val tmp: String? = null,
    val trh: String? = null,
    val tv: String? = null,
    val ty: String? = null,
    val y: String? = null,
    val yhpmn: String? = null,
    val yhpmx: String? = null,
    val ympmn: String? = null,
    val ympmx: String? = null
)

@Entity
data class GovSteamIEEE1(
    @Id val govSteamIEEE1Id: UUID? = null,
    val k: String? = null,
    val k1: String? = null,
    val k2: String? = null,
    val k3: String? = null,
    val k4: String? = null,
    val k5: String? = null,
    val k6: String? = null,
    val k7: String? = null,
    val k8: String? = null,
    val mwbase: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val t7: String? = null,
    val uc: String? = null,
    val uo: String? = null
)

@Entity
data class GovSteamSGO(
    @Id val govSteamSGOId: UUID? = null,
    val k1: String? = null,
    val k2: String? = null,
    val k3: String? = null,
    val mwbase: String? = null,
    val pmax: String? = null,
    val pmin: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null
)

@Entity
data class GrossToNetActivePowerCurve(
     val grossToNetActivePowerCurveId: UUID? = null
)

@Entity
data class Ground(
     val groundId: UUID? = null
)

@Entity
data class GroundDisconnector(
     val groundDisconnectorId: UUID? = null
)

@Entity
data class GroundingImpedance(
    @Id val groundingImpedanceId: UUID? = null,
    val x: String? = null
)

@Entity
data class HydroGeneratingUnit(
    @Id val hydroGeneratingUnitId: UUID? = null,
    val energyConversionCapability: String? = null
)

@Entity
data class HydroPowerPlant(
    @Id val hydroPowerPlantId: UUID? = null,
    val hydroPlantStorageType: String? = null
)

@Entity
data class HydroPump(
     val hydroPumpId: UUID? = null
)

@Entity
data class IdentifiedObject(
    @Id val identifiedObjectId: UUID? = null,
    val description: String? = null,
    val energyIdentCodeEic: String? = null,
    val mRID: String? = null,
    val name: String? = null,
    val shortName: String? = null
)

@Entity
data class Inductance(
    @Id val inductanceId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class InductancePerLength(
    @Id val inductancePerLengthId: UUID? = null,
    val denominatorMultiplier: String? = null,
    val denominatorUnit: String? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class IntegerProxy(
     val integerProxyId: UUID? = null
)

@Entity
data class Junction(
     val junctionId: UUID? = null
)

@Entity
data class Length(
    @Id val lengthId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class Limit(
     val limitId: UUID? = null
)

@Entity
data class LimitSet(
    @Id val limitSetId: UUID? = null,
    val isPercentageLimits: String? = null
)

@Entity
data class Line(
     val lineId: UUID? = null
)

@Entity
data class LinearShuntCompensator(
    @Id val linearShuntCompensatorId: UUID? = null,
    val b0PerSection: String? = null,
    val bPerSection: String? = null,
    val g0PerSection: String? = null,
    val gPerSection: String? = null
)

@Entity
data class LoadAggregate(
     val loadAggregateId: UUID? = null
)

@Entity
data class LoadArea(
     val loadAreaId: UUID? = null
)

@Entity
data class LoadBreakSwitch(
     val loadBreakSwitchId: UUID? = null
)

@Entity
data class LoadComposite(
    @Id val loadCompositeId: UUID? = null,
    val epfd: String? = null,
    val epfs: String? = null,
    val epvd: String? = null,
    val epvs: String? = null,
    val eqfd: String? = null,
    val eqfs: String? = null,
    val eqvd: String? = null,
    val eqvs: String? = null,
    val h: String? = null,
    val lfrac: String? = null,
    val pfrac: String? = null
)

@Entity
data class LoadDynamics(
     val loadDynamicsId: UUID? = null
)

@Entity
data class LoadGenericNonLinear(
    @Id val loadGenericNonLinearId: UUID? = null,
    val bs: String? = null,
    val bt: String? = null,
    val genericNonLinearLoadModelType: String? = null,
    val ls: String? = null,
    val lt: String? = null,
    val pt: String? = null,
    val qt: String? = null,
    val tp: String? = null,
    val tq: String? = null
)

@Entity
data class LoadGroup(
     val loadGroupId: UUID? = null
)

@Entity
data class LoadMotor(
    @Id val loadMotorId: UUID? = null,
    val d: String? = null,
    val h: String? = null,
    val lfac: String? = null,
    val lp: String? = null,
    val lpp: String? = null,
    val ls: String? = null,
    val pfrac: String? = null,
    val ra: String? = null,
    val tbkr: String? = null,
    val tpo: String? = null,
    val tppo: String? = null,
    val tv: String? = null,
    val vt: String? = null
)

@Entity
data class LoadResponseCharacteristic(
    @Id val loadResponseCharacteristicId: UUID? = null,
    val exponentModel: String? = null,
    val pConstantCurrent: String? = null,
    val pConstantImpedance: String? = null,
    val pConstantPower: String? = null,
    val pFrequencyExponent: String? = null,
    val pVoltageExponent: String? = null,
    val qConstantCurrent: String? = null,
    val qConstantImpedance: String? = null,
    val qConstantPower: String? = null,
    val qFrequencyExponent: String? = null,
    val qVoltageExponent: String? = null
)

@Entity
data class LoadStatic(
    @Id val loadStaticId: UUID? = null,
    val ep1: String? = null,
    val ep2: String? = null,
    val ep3: String? = null,
    val eq1: String? = null,
    val eq2: String? = null,
    val eq3: String? = null,
    val kp1: String? = null,
    val kp2: String? = null,
    val kp3: String? = null,
    val kp4: String? = null,
    val kpf: String? = null,
    val kq1: String? = null,
    val kq2: String? = null,
    val kq3: String? = null,
    val kq4: String? = null,
    val kqf: String? = null,
    val staticLoadModelType: String? = null
)

@Entity
data class LoadUserDefined(
    @Id val loadUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class Location(
     val locationId: UUID? = null
)

@Entity
data class Measurement(
    @Id val measurementId: UUID? = null,
    val measurementType: String? = null,
    val phases: String? = null,
    val unitMultiplier: String? = null,
    val unitSymbol: String? = null
)

@Entity
data class MeasurementValue(
    @Id val measurementValueId: UUID? = null,
    val sensorAccuracy: String? = null,
    val timeStamp: String? = null
)

@Entity
data class MeasurementValueQuality(
     val measurementValueQualityId: UUID? = null
)

@Entity
data class MeasurementValueSource(
     val measurementValueSourceId: UUID? = null
)

@Entity
data class MechLoad1(
    @Id val mechLoad1Id: UUID? = null,
    val a: String? = null,
    val b: String? = null,
    val d: String? = null,
    val e: String? = null
)

@Entity
data class MechanicalLoadDynamics(
     val mechanicalLoadDynamicsId: UUID? = null
)

@Entity
data class MechanicalLoadUserDefined(
    @Id val mechanicalLoadUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class Money(
    @Id val moneyId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class MonthDay(
     val monthDayId: UUID? = null
)

@Entity
data class MonthDayInterval(
    @Id val monthDayIntervalId: UUID? = null,
    val end: String? = null,
    val start: String? = null
)

@Entity
data class MutualCoupling(
    @Id val mutualCouplingId: UUID? = null,
    val b0ch: String? = null,
    val distance11: String? = null,
    val distance12: String? = null,
    val distance21: String? = null,
    val distance22: String? = null,
    val g0ch: String? = null,
    val r0: String? = null,
    val x0: String? = null
)

@Entity
data class NonConformLoad(
     val nonConformLoadId: UUID? = null
)

@Entity
data class NonConformLoadGroup(
     val nonConformLoadGroupId: UUID? = null
)

@Entity
data class NonConformLoadSchedule(
     val nonConformLoadScheduleId: UUID? = null
)

@Entity
data class NonlinearShuntCompensator(
     val nonlinearShuntCompensatorId: UUID? = null
)

@Entity
data class NonlinearShuntCompensatorPoint(
    @Id val nonlinearShuntCompensatorPointId: UUID? = null,
    val b: String? = null,
    val b0: String? = null,
    val g: String? = null,
    val g0: String? = null,
    val sectionNumber: String? = null
)

@Entity
data class NuclearGeneratingUnit(
     val nuclearGeneratingUnitId: UUID? = null
)

@Entity
data class OperationalLimit(
     val operationalLimitId: UUID? = null
)

@Entity
data class OperationalLimitSet(
     val operationalLimitSetId: UUID? = null
)

@Entity
data class OperationalLimitType(
    @Id val operationalLimitTypeId: UUID? = null,
    val acceptableDuration: String? = null,
    val direction: String? = null,
    val limitType: String? = null
)

@Entity
data class OverexcLim2(
    @Id val overexcLim2Id: UUID? = null,
    val ifdlim: String? = null,
    val koi: String? = null,
    val voimax: String? = null,
    val voimin: String? = null
)

@Entity
data class OverexcLimIEEE(
    @Id val overexcLimIEEEId: UUID? = null,
    val hyst: String? = null,
    val ifdlim: String? = null,
    val ifdmax: String? = null,
    val itfpu: String? = null,
    val kcd: String? = null,
    val kramp: String? = null
)

@Entity
data class OverexcLimX1(
    @Id val overexcLimX1Id: UUID? = null,
    val efd1: String? = null,
    val efd2: String? = null,
    val efd3: String? = null,
    val efddes: String? = null,
    val efdrated: String? = null,
    val kmx: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val vlow: String? = null
)

@Entity
data class OverexcLimX2(
    @Id val overexcLimX2Id: UUID? = null,
    val efd1: String? = null,
    val efd2: String? = null,
    val efd3: String? = null,
    val efddes: String? = null,
    val efdrated: String? = null,
    val kmx: String? = null,
    val m: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val vlow: String? = null
)

@Entity
data class OverexcitationLimiterDynamics(
     val overexcitationLimiterDynamicsId: UUID? = null
)

@Entity
data class OverexcitationLimiterUserDefined(
    @Id val overexcitationLimiterUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class PFVArControllerType1Dynamics(
     val pFVArControllerType1DynamicsId: UUID? = null
)

@Entity
data class PFVArControllerType1UserDefined(
    @Id val pFVArControllerType1UserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class PFVArControllerType2Dynamics(
     val pFVArControllerType2DynamicsId: UUID? = null
)

@Entity
data class PFVArControllerType2UserDefined(
    @Id val pFVArControllerType2UserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class PFVArType1IEEEPFController(
    @Id val pFVArType1IEEEPFControllerId: UUID? = null,
    val ovex: String? = null,
    val tpfc: String? = null,
    val vitmin: String? = null,
    val vpf: String? = null,
    val vpfcbw: String? = null,
    val vpfref: String? = null,
    val vvtmax: String? = null,
    val vvtmin: String? = null
)

@Entity
data class PFVArType1IEEEVArController(
    @Id val pFVArType1IEEEVArControllerId: UUID? = null,
    val tvarc: String? = null,
    val vvar: String? = null,
    val vvarcbw: String? = null,
    val vvarref: String? = null,
    val vvtmax: String? = null,
    val vvtmin: String? = null
)

@Entity
data class PFVArType2Common1(
    @Id val pFVArType2Common1Id: UUID? = null,
    val j: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val max: String? = null,
    val ref: String? = null
)

@Entity
data class PFVArType2IEEEPFController(
    @Id val pFVArType2IEEEPFControllerId: UUID? = null,
    val exlon: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val pfref: String? = null,
    val vclmt: String? = null,
    val vref: String? = null,
    val vs: String? = null
)

@Entity
data class PFVArType2IEEEVArController(
    @Id val pFVArType2IEEEVArControllerId: UUID? = null,
    val exlon: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val qref: String? = null,
    val vclmt: String? = null,
    val vref: String? = null,
    val vs: String? = null
)

@Entity
data class PU(
    @Id val pUId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class PerCent(
    @Id val perCentId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class PerLengthDCLineParameter(
    @Id val perLengthDCLineParameterId: UUID? = null,
    val capacitance: String? = null,
    val inductance: String? = null,
    val resistance: String? = null
)

@Entity
data class PetersenCoil(
    @Id val petersenCoilId: UUID? = null,
    val mode: String? = null,
    val nominalU: String? = null,
    val offsetCurrent: String? = null,
    val positionCurrent: String? = null,
    val xGroundMax: String? = null,
    val xGroundMin: String? = null,
    val xGroundNominal: String? = null
)

@Entity
data class PhaseTapChanger(
     val phaseTapChangerId: UUID? = null
)

@Entity
data class PhaseTapChangerAsymmetrical(
    @Id val phaseTapChangerAsymmetricalId: UUID? = null,
    val windingConnectionAngle: String? = null
)

@Entity
data class PhaseTapChangerLinear(
    @Id val phaseTapChangerLinearId: UUID? = null,
    val stepPhaseShiftIncrement: String? = null,
    val xMax: String? = null,
    val xMin: String? = null
)

@Entity
data class PhaseTapChangerNonLinear(
    @Id val phaseTapChangerNonLinearId: UUID? = null,
    val voltageStepIncrement: String? = null,
    val xMax: String? = null,
    val xMin: String? = null
)

@Entity
data class PhaseTapChangerSymmetrical(
     val phaseTapChangerSymmetricalId: UUID? = null
)

@Entity
data class PhaseTapChangerTable(
     val phaseTapChangerTableId: UUID? = null
)

@Entity
data class PhaseTapChangerTablePoint(
    @Id val phaseTapChangerTablePointId: UUID? = null,
    val angle: String? = null
)

@Entity
data class PhaseTapChangerTabular(
     val phaseTapChangerTabularId: UUID? = null
)

@Entity
data class PositionPoint(
    @Id val positionPointId: UUID? = null,
    val sequenceNumber: String? = null,
    val xPosition: String? = null,
    val yPosition: String? = null,
    val zPosition: String? = null
)

@Entity
data class PowerSystemResource(
     val powerSystemResourceId: UUID? = null
)

@Entity
data class PowerSystemStabilizerDynamics(
     val powerSystemStabilizerDynamicsId: UUID? = null
)

@Entity
data class PowerSystemStabilizerUserDefined(
    @Id val powerSystemStabilizerUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class PowerTransformer(
    @Id val powerTransformerId: UUID? = null,
    val beforeShCircuitHighestOperatingCurrent: String? = null,
    val beforeShCircuitHighestOperatingVoltage: String? = null,
    val beforeShortCircuitAnglePf: String? = null,
    val highSideMinOperatingU: String? = null,
    val isPartOfGeneratorUnit: String? = null,
    val operationalValuesConsidered: String? = null
)

@Entity
data class PowerTransformerEnd(
    @Id val powerTransformerEndId: UUID? = null,
    val b: String? = null,
    val b0: String? = null,
    val connectionKind: String? = null,
    val g: String? = null,
    val g0: String? = null,
    val phaseAngleClock: String? = null,
    val r: String? = null,
    val r0: String? = null,
    val ratedS: String? = null,
    val ratedU: String? = null,
    val x: String? = null,
    val x0: String? = null
)

@Entity
data class ProprietaryParameterDynamics(
    @Id val proprietaryParameterDynamicsId: UUID? = null,
    val booleanParameterValue: String? = null,
    val floatParameterValue: String? = null,
    val integerParameterValue: String? = null,
    val parameterNumber: String? = null
)

@Entity
data class ProtectedSwitch(
     val protectedSwitchId: UUID? = null
)

@Entity
data class Pss1(
    @Id val pss1Id: UUID? = null,
    val kf: String? = null,
    val kpe: String? = null,
    val ks: String? = null,
    val kw: String? = null,
    val pmin: String? = null,
    val t10: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val t7: String? = null,
    val t8: String? = null,
    val t9: String? = null,
    val tpe: String? = null,
    val vadat: String? = null,
    val vsmn: String? = null,
    val vsmx: String? = null
)

@Entity
data class Pss1A(
    @Id val pss1AId: UUID? = null,
    val a1: String? = null,
    val a2: String? = null,
    val a3: String? = null,
    val a4: String? = null,
    val a5: String? = null,
    val a6: String? = null,
    val a7: String? = null,
    val a8: String? = null,
    val inputSignalType: String? = null,
    val kd: String? = null,
    val ks: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val tdelay: String? = null,
    val vcl: String? = null,
    val vcu: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class Pss2B(
    @Id val pss2BId: UUID? = null,
    val a: String? = null,
    val inputSignal1Type: String? = null,
    val inputSignal2Type: String? = null,
    val ks1: String? = null,
    val ks2: String? = null,
    val ks3: String? = null,
    val ks4: String? = null,
    val m: String? = null,
    val n: String? = null,
    val t1: String? = null,
    val t10: String? = null,
    val t11: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t6: String? = null,
    val t7: String? = null,
    val t8: String? = null,
    val t9: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tw1: String? = null,
    val tw2: String? = null,
    val tw3: String? = null,
    val tw4: String? = null,
    val vsi1max: String? = null,
    val vsi1min: String? = null,
    val vsi2max: String? = null,
    val vsi2min: String? = null,
    val vstmax: String? = null,
    val vstmin: String? = null
)

@Entity
data class Pss2ST(
    @Id val pss2STId: UUID? = null,
    val inputSignal1Type: String? = null,
    val inputSignal2Type: String? = null,
    val k1: String? = null,
    val k2: String? = null,
    val lsmax: String? = null,
    val lsmin: String? = null,
    val t1: String? = null,
    val t10: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val t7: String? = null,
    val t8: String? = null,
    val t9: String? = null,
    val vcl: String? = null,
    val vcu: String? = null
)

@Entity
data class Pss5(
    @Id val pss5Id: UUID? = null,
    val ctw2: String? = null,
    val deadband: String? = null,
    val isfreq: String? = null,
    val kf: String? = null,
    val kpe: String? = null,
    val kpss: String? = null,
    val pmm: String? = null,
    val tl1: String? = null,
    val tl2: String? = null,
    val tl3: String? = null,
    val tl4: String? = null,
    val tpe: String? = null,
    val tw1: String? = null,
    val tw2: String? = null,
    val vadat: String? = null,
    val vsmn: String? = null,
    val vsmx: String? = null
)

@Entity
data class PssELIN2(
    @Id val pssELIN2Id: UUID? = null,
    val apss: String? = null,
    val ks1: String? = null,
    val ks2: String? = null,
    val ppss: String? = null,
    val psslim: String? = null,
    val ts1: String? = null,
    val ts2: String? = null,
    val ts3: String? = null,
    val ts4: String? = null,
    val ts5: String? = null,
    val ts6: String? = null
)

@Entity
data class PssIEEE1A(
    @Id val pssIEEE1AId: UUID? = null,
    val a1: String? = null,
    val a2: String? = null,
    val inputSignalType: String? = null,
    val ks: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val vrmax: String? = null,
    val vrmin: String? = null
)

@Entity
data class PssIEEE2B(
    @Id val pssIEEE2BId: UUID? = null,
    val inputSignal1Type: String? = null,
    val inputSignal2Type: String? = null,
    val ks1: String? = null,
    val ks2: String? = null,
    val ks3: String? = null,
    val m: String? = null,
    val n: String? = null,
    val t1: String? = null,
    val t10: String? = null,
    val t11: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t6: String? = null,
    val t7: String? = null,
    val t8: String? = null,
    val t9: String? = null,
    val tw1: String? = null,
    val tw2: String? = null,
    val tw3: String? = null,
    val tw4: String? = null,
    val vsi1max: String? = null,
    val vsi1min: String? = null,
    val vsi2max: String? = null,
    val vsi2min: String? = null,
    val vstmax: String? = null,
    val vstmin: String? = null
)

@Entity
data class PssIEEE3B(
    @Id val pssIEEE3BId: UUID? = null,
    val a1: String? = null,
    val a2: String? = null,
    val a3: String? = null,
    val a4: String? = null,
    val a5: String? = null,
    val a6: String? = null,
    val a7: String? = null,
    val a8: String? = null,
    val inputSignal1Type: String? = null,
    val inputSignal2Type: String? = null,
    val ks1: String? = null,
    val ks2: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val tw1: String? = null,
    val tw2: String? = null,
    val tw3: String? = null,
    val vstmax: String? = null,
    val vstmin: String? = null
)

@Entity
data class PssIEEE4B(
    @Id val pssIEEE4BId: UUID? = null,
    val bwh1: String? = null,
    val bwh2: String? = null,
    val bwl1: String? = null,
    val bwl2: String? = null,
    val kh: String? = null,
    val kh1: String? = null,
    val kh11: String? = null,
    val kh17: String? = null,
    val kh2: String? = null,
    val ki: String? = null,
    val ki1: String? = null,
    val ki11: String? = null,
    val ki17: String? = null,
    val ki2: String? = null,
    val kl: String? = null,
    val kl1: String? = null,
    val kl11: String? = null,
    val kl17: String? = null,
    val kl2: String? = null,
    val omeganh1: String? = null,
    val omeganh2: String? = null,
    val omeganl1: String? = null,
    val omeganl2: String? = null,
    val th1: String? = null,
    val th10: String? = null,
    val th11: String? = null,
    val th12: String? = null,
    val th2: String? = null,
    val th3: String? = null,
    val th4: String? = null,
    val th5: String? = null,
    val th6: String? = null,
    val th7: String? = null,
    val th8: String? = null,
    val th9: String? = null,
    val ti1: String? = null,
    val ti10: String? = null,
    val ti11: String? = null,
    val ti12: String? = null,
    val ti2: String? = null,
    val ti3: String? = null,
    val ti4: String? = null,
    val ti5: String? = null,
    val ti6: String? = null,
    val ti7: String? = null,
    val ti8: String? = null,
    val ti9: String? = null,
    val tl1: String? = null,
    val tl10: String? = null,
    val tl11: String? = null,
    val tl12: String? = null,
    val tl2: String? = null,
    val tl3: String? = null,
    val tl4: String? = null,
    val tl5: String? = null,
    val tl6: String? = null,
    val tl7: String? = null,
    val tl8: String? = null,
    val tl9: String? = null,
    val vhmax: String? = null,
    val vhmin: String? = null,
    val vimax: String? = null,
    val vimin: String? = null,
    val vlmax: String? = null,
    val vlmin: String? = null,
    val vstmax: String? = null,
    val vstmin: String? = null
)

@Entity
data class PssPTIST1(
    @Id val pssPTIST1Id: UUID? = null,
    val dtc: String? = null,
    val dtf: String? = null,
    val dtp: String? = null,
    val k: String? = null,
    val m: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val tf: String? = null,
    val tp: String? = null
)

@Entity
data class PssPTIST3(
    @Id val pssPTIST3Id: UUID? = null,
    val a0: String? = null,
    val a1: String? = null,
    val a2: String? = null,
    val a3: String? = null,
    val a4: String? = null,
    val a5: String? = null,
    val al: String? = null,
    val athres: String? = null,
    val b0: String? = null,
    val b1: String? = null,
    val b2: String? = null,
    val b3: String? = null,
    val b4: String? = null,
    val b5: String? = null,
    val dl: String? = null,
    val dtc: String? = null,
    val dtf: String? = null,
    val dtp: String? = null,
    val isw: String? = null,
    val k: String? = null,
    val lthres: String? = null,
    val m: String? = null,
    val nav: String? = null,
    val ncl: String? = null,
    val ncr: String? = null,
    val pmin: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val tf: String? = null,
    val tp: String? = null
)

@Entity
data class PssSB4(
    @Id val pssSB4Id: UUID? = null,
    val kx: String? = null,
    val ta: String? = null,
    val tb: String? = null,
    val tc: String? = null,
    val td: String? = null,
    val te: String? = null,
    val tt: String? = null,
    val tx1: String? = null,
    val tx2: String? = null,
    val vsmax: String? = null,
    val vsmin: String? = null
)

@Entity
data class PssSH(
    @Id val pssSHId: UUID? = null,
    val k: String? = null,
    val k0: String? = null,
    val k1: String? = null,
    val k2: String? = null,
    val k3: String? = null,
    val k4: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val td: String? = null,
    val vsmax: String? = null,
    val vsmin: String? = null
)

@Entity
data class PssSK(
    @Id val pssSKId: UUID? = null,
    val k1: String? = null,
    val k2: String? = null,
    val k3: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val vsmax: String? = null,
    val vsmin: String? = null
)

@Entity
data class PssWECC(
    @Id val pssWECCId: UUID? = null,
    val inputSignal1Type: String? = null,
    val inputSignal2Type: String? = null,
    val k1: String? = null,
    val k2: String? = null,
    val t1: String? = null,
    val t10: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val t7: String? = null,
    val t8: String? = null,
    val t9: String? = null,
    val vcl: String? = null,
    val vcu: String? = null,
    val vsmax: String? = null,
    val vsmin: String? = null
)

@Entity
data class Quality61850(
    @Id val quality61850Id: UUID? = null,
    val badReference: String? = null,
    val estimatorReplaced: String? = null,
    val failure: String? = null,
    val oldData: String? = null,
    val operatorBlocked: String? = null,
    val oscillatory: String? = null,
    val outOfRange: String? = null,
    val overFlow: String? = null,
    val source: String? = null,
    val suspect: String? = null,
    val test: String? = null,
    val validity: String? = null
)

@Entity
data class RaiseLowerCommand(
     val raiseLowerCommandId: UUID? = null
)

@Entity
data class RatioTapChanger(
    @Id val ratioTapChangerId: UUID? = null,
    val stepVoltageIncrement: String? = null,
    val tculControlMode: String? = null
)

@Entity
data class RatioTapChangerTable(
     val ratioTapChangerTableId: UUID? = null
)

@Entity
data class RatioTapChangerTablePoint(
     val ratioTapChangerTablePointId: UUID? = null
)

@Entity
data class Reactance(
    @Id val reactanceId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class ReactiveCapabilityCurve(
     val reactiveCapabilityCurveId: UUID? = null
)

@Entity
data class ReactivePower(
    @Id val reactivePowerId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class RegularIntervalSchedule(
    @Id val regularIntervalScheduleId: UUID? = null,
    val endTime: String? = null,
    val timeStep: String? = null
)

@Entity
data class RegularTimePoint(
    @Id val regularTimePointId: UUID? = null,
    val sequenceNumber: String? = null,
    val value1: String? = null,
    val value2: String? = null
)

@Entity
data class RegulatingCondEq(
     val regulatingCondEqId: UUID? = null
)

@Entity
data class RegulatingControl(
    @Id val regulatingControlId: UUID? = null,
    val mode: String? = null
)

@Entity
data class RegulationSchedule(
     val regulationScheduleId: UUID? = null
)

@Entity
data class RemoteInputSignal(
    @Id val remoteInputSignalId: UUID? = null,
    val remoteSignalType: String? = null
)

@Entity
data class ReportingGroup(
     val reportingGroupId: UUID? = null
)

@Entity
data class Resistance(
    @Id val resistanceId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class ResistancePerLength(
    @Id val resistancePerLengthId: UUID? = null,
    val denominatorMultiplier: String? = null,
    val denominatorUnit: String? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class RotatingMachine(
    @Id val rotatingMachineId: UUID? = null,
    val ratedPowerFactor: String? = null,
    val ratedS: String? = null,
    val ratedU: String? = null
)

@Entity
data class RotatingMachineDynamics(
    @Id val rotatingMachineDynamicsId: UUID? = null,
    val damping: String? = null,
    val inertia: String? = null,
    val saturationFactor: String? = null,
    val saturationFactor120: String? = null,
    val statorLeakageReactance: String? = null,
    val statorResistance: String? = null
)

@Entity
data class RotationSpeed(
    @Id val rotationSpeedId: UUID? = null,
    val denominatorMultiplier: String? = null,
    val denominatorUnit: String? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class Season(
    @Id val seasonId: UUID? = null,
    val endDate: String? = null,
    val startDate: String? = null
)

@Entity
data class SeasonDayTypeSchedule(
     val seasonDayTypeScheduleId: UUID? = null
)

@Entity
data class Seconds(
    @Id val secondsId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class SeriesCompensator(
    @Id val seriesCompensatorId: UUID? = null,
    val r: String? = null,
    val r0: String? = null,
    val varistorPresent: String? = null,
    val varistorRatedCurrent: String? = null,
    val varistorVoltageThreshold: String? = null,
    val x: String? = null,
    val x0: String? = null
)

@Entity
data class SetPoint(
    @Id val setPointId: UUID? = null,
    val normalValue: String? = null,
    val value: String? = null
)

@Entity
data class ShuntCompensator(
    @Id val shuntCompensatorId: UUID? = null,
    val aVRDelay: String? = null,
    val grounded: String? = null,
    val maximumSections: String? = null,
    val nomU: String? = null,
    val normalSections: String? = null,
    val switchOnCount: String? = null,
    val switchOnDate: String? = null,
    val voltageSensitivity: String? = null
)

@Entity
data class Simple_Float(
    @Id val simple_FloatId: UUID? = null,
    val value: String? = null
)

@Entity
data class SolarGeneratingUnit(
     val solarGeneratingUnitId: UUID? = null
)

@Entity
data class StateVariablesVersion(
    @Id val stateVariablesVersionId: UUID? = null,
    val baseUML: String? = null,
    val baseURI: String? = null,
    val date: String? = null,
    val differenceModelURI: String? = null,
    val entsoeUML: String? = null,
    val entsoeURI: String? = null,
    val modelDescriptionURI: String? = null,
    val namespaceRDF: String? = null,
    val namespaceUML: String? = null,
    val shortName: String? = null
)

@Entity
data class StaticVarCompensator(
    @Id val staticVarCompensatorId: UUID? = null,
    val capacitiveRating: String? = null,
    val inductiveRating: String? = null,
    val slope: String? = null,
    val sVCControlMode: String? = null,
    val voltageSetPoint: String? = null
)

@Entity
data class Staticpowersystemmodel(
     val staticpowersystemmodelId: UUID? = null
)

@Entity
data class StationSupply(
     val stationSupplyId: UUID? = null
)

@Entity
data class SteadyStateHypothesisVersion(
    @Id val steadyStateHypothesisVersionId: UUID? = null,
    val baseUML: String? = null,
    val baseURI: String? = null,
    val date: String? = null,
    val differenceModelURI: String? = null,
    val entsoeUML: String? = null,
    val entsoeURI: String? = null,
    val modelDescriptionURI: String? = null,
    val namespaceRDF: String? = null,
    val namespaceUML: String? = null,
    val shortName: String? = null
)

@Entity
data class StringMeasurement(
     val stringMeasurementId: UUID? = null
)

@Entity
data class StringMeasurementValue(
    @Id val stringMeasurementValueId: UUID? = null,
    val value: String? = null
)

@Entity
data class StringProxy(
     val stringProxyId: UUID? = null
)

@Entity
data class SubGeographicalRegion(
     val subGeographicalRegionId: UUID? = null
)

@Entity
data class SubLoadArea(
     val subLoadAreaId: UUID? = null
)

@Entity
data class Substation(
     val substationId: UUID? = null
)

@Entity
data class Susceptance(
    @Id val susceptanceId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class SvInjection(
    @Id val svInjectionId: UUID? = null,
    val pInjection: String? = null,
    val qInjection: String? = null
)

@Entity
data class SvPowerFlow(
    @Id val svPowerFlowId: UUID? = null,
    val p: String? = null,
    val q: String? = null
)

@Entity
data class SvShuntCompensatorSections(
    @Id val svShuntCompensatorSectionsId: UUID? = null,
    val sections: String? = null
)

@Entity
data class SvStatus(
    @Id val svStatusId: UUID? = null,
    val inService: String? = null
)

@Entity
data class SvTapStep(
    @Id val svTapStepId: UUID? = null,
    val position: String? = null
)

@Entity
data class SvVoltage(
    @Id val svVoltageId: UUID? = null,
    val angle: String? = null,
    val v: String? = null
)

@Entity
data class SwitchIt(
    @Id val switchItId: UUID? = null,
    val open: String? = null
)

@Entity
data class SwitchProxy(
    @Id val switchProxyId: UUID? = null,
    val normalOpen: String? = null,
    val ratedCurrent: String? = null,
    val retained: String? = null
)

@Entity
data class SwitchSchedule(
     val switchScheduleId: UUID? = null
)

@Entity
data class SynchronousMachine(
    @Id val synchronousMachineId: UUID? = null,
    val earthing: String? = null,
    val earthingStarPointR: String? = null,
    val earthingStarPointX: String? = null,
    val ikk: String? = null,
    val maxQ: String? = null,
    val minQ: String? = null,
    val mu: String? = null,
    val qPercent: String? = null,
    val r: String? = null,
    val r0: String? = null,
    val r2: String? = null,
    val satDirectSubtransX: String? = null,
    val satDirectSyncX: String? = null,
    val satDirectTransX: String? = null,
    val shortCircuitRotorType: String? = null,
    val type: String? = null,
    val voltageRegulationRange: String? = null,
    val x0: String? = null,
    val x2: String? = null
)

@Entity
data class SynchronousMachineDetailed(
    @Id val synchronousMachineDetailedId: UUID? = null,
    val efdBaseRatio: String? = null,
    val ifdBaseType: String? = null,
    val ifdBaseValue: String? = null,
    val saturationFactor120QAxis: String? = null,
    val saturationFactorQAxis: String? = null
)

@Entity
data class SynchronousMachineDynamics(
     val synchronousMachineDynamicsId: UUID? = null
)

@Entity
data class SynchronousMachineEquivalentCircuit(
    @Id val synchronousMachineEquivalentCircuitId: UUID? = null,
    val r1d: String? = null,
    val r1q: String? = null,
    val r2q: String? = null,
    val rfd: String? = null,
    val x1d: String? = null,
    val x1q: String? = null,
    val x2q: String? = null,
    val xad: String? = null,
    val xaq: String? = null,
    val xf1d: String? = null,
    val xfd: String? = null
)

@Entity
data class SynchronousMachineSimplified(
     val synchronousMachineSimplifiedId: UUID? = null
)

@Entity
data class SynchronousMachineTimeConstantReactance(
    @Id val synchronousMachineTimeConstantReactanceId: UUID? = null,
    val ks: String? = null,
    val modelType: String? = null,
    val rotorType: String? = null,
    val tc: String? = null,
    val tpdo: String? = null,
    val tppdo: String? = null,
    val tppqo: String? = null,
    val tpqo: String? = null,
    val xDirectSubtrans: String? = null,
    val xDirectSync: String? = null,
    val xDirectTrans: String? = null,
    val xQuadSubtrans: String? = null,
    val xQuadSync: String? = null,
    val xQuadTrans: String? = null
)

@Entity
data class SynchronousMachineUserDefined(
    @Id val synchronousMachineUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class TapChanger(
    @Id val tapChangerId: UUID? = null,
    val highStep: String? = null,
    val lowStep: String? = null,
    val ltcFlag: String? = null,
    val neutralStep: String? = null,
    val neutralU: String? = null,
    val normalStep: String? = null
)

@Entity
data class TapChangerControl(
     val tapChangerControlId: UUID? = null
)

@Entity
data class TapChangerTablePoint(
    @Id val tapChangerTablePointId: UUID? = null,
    val b: String? = null,
    val g: String? = null,
    val r: String? = null,
    val ratio: String? = null,
    val step: String? = null,
    val x: String? = null
)

@Entity
data class TapSchedule(
     val tapScheduleId: UUID? = null
)

@Entity
data class Temperature(
    @Id val temperatureId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class Terminal(
     val terminalId: UUID? = null
)

@Entity
data class TextDiagramObject(
    @Id val textDiagramObjectId: UUID? = null,
    val text: String? = null
)

@Entity
data class ThermalGeneratingUnit(
     val thermalGeneratingUnitId: UUID? = null
)

@Entity
data class TieFlow(
    @Id val tieFlowId: UUID? = null,
    val positiveFlowIn: String? = null
)

@Entity
data class TopologicalIsland(
     val topologicalIslandId: UUID? = null
)

@Entity
data class TopologicalNode(
    @Id val topologicalNodeId: UUID? = null,
    val boundaryPoint: String? = null,
    val fromEndIsoCode: String? = null,
    val fromEndName: String? = null,
    val fromEndNameTso: String? = null,
    val toEndIsoCode: String? = null,
    val toEndName: String? = null,
    val toEndNameTso: String? = null
)

@Entity
data class TopologyBoundaryVersion(
    @Id val topologyBoundaryVersionId: UUID? = null,
    val baseUML: String? = null,
    val baseURI: String? = null,
    val date: String? = null,
    val differenceModelURI: String? = null,
    val entsoeUML: String? = null,
    val entsoeURI: String? = null,
    val modelDescriptionURI: String? = null,
    val namespaceRDF: String? = null,
    val namespaceUML: String? = null,
    val shortName: String? = null
)

@Entity
data class TopologyVersion(
    @Id val topologyVersionId: UUID? = null,
    val baseUML: String? = null,
    val baseURI: String? = null,
    val date: String? = null,
    val differenceModelURI: String? = null,
    val entsoeUML: String? = null,
    val entsoeURI: String? = null,
    val modelDescriptionURI: String? = null,
    val namespaceRDF: String? = null,
    val namespaceUML: String? = null,
    val shortName: String? = null
)

@Entity
data class TransformerEnd(
    @Id val transformerEndId: UUID? = null,
    val endNumber: String? = null,
    val grounded: String? = null,
    val rground: String? = null,
    val xground: String? = null
)

@Entity
data class TurbLCFB1(
    @Id val turbLCFB1Id: UUID? = null,
    val db: String? = null,
    val emax: String? = null,
    val fb: String? = null,
    val fbf: String? = null,
    val irmax: String? = null,
    val ki: String? = null,
    val kp: String? = null,
    val mwbase: String? = null,
    val pbf: String? = null,
    val pmwset: String? = null,
    val speedReferenceGovernor: String? = null,
    val tpelec: String? = null
)

@Entity
data class TurbineGovernorDynamics(
     val turbineGovernorDynamicsId: UUID? = null
)

@Entity
data class TurbineGovernorUserDefined(
    @Id val turbineGovernorUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class TurbineLoadControllerDynamics(
     val turbineLoadControllerDynamicsId: UUID? = null
)

@Entity
data class TurbineLoadControllerUserDefined(
    @Id val turbineLoadControllerUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class UnderexcLim2Simplified(
    @Id val underexcLim2SimplifiedId: UUID? = null,
    val kui: String? = null,
    val p0: String? = null,
    val p1: String? = null,
    val q0: String? = null,
    val q1: String? = null,
    val vuimax: String? = null,
    val vuimin: String? = null
)

@Entity
data class UnderexcLimIEEE1(
    @Id val underexcLimIEEE1Id: UUID? = null,
    val kuc: String? = null,
    val kuf: String? = null,
    val kui: String? = null,
    val kul: String? = null,
    val kur: String? = null,
    val tu1: String? = null,
    val tu2: String? = null,
    val tu3: String? = null,
    val tu4: String? = null,
    val vucmax: String? = null,
    val vuimax: String? = null,
    val vuimin: String? = null,
    val vulmax: String? = null,
    val vulmin: String? = null,
    val vurmax: String? = null
)

@Entity
data class UnderexcLimIEEE2(
    @Id val underexcLimIEEE2Id: UUID? = null,
    val k1: String? = null,
    val k2: String? = null,
    val kfb: String? = null,
    val kuf: String? = null,
    val kui: String? = null,
    val kul: String? = null,
    val p0: String? = null,
    val p1: String? = null,
    val p10: String? = null,
    val p2: String? = null,
    val p3: String? = null,
    val p4: String? = null,
    val p5: String? = null,
    val p6: String? = null,
    val p7: String? = null,
    val p8: String? = null,
    val p9: String? = null,
    val q0: String? = null,
    val q1: String? = null,
    val q10: String? = null,
    val q2: String? = null,
    val q3: String? = null,
    val q4: String? = null,
    val q5: String? = null,
    val q6: String? = null,
    val q7: String? = null,
    val q8: String? = null,
    val q9: String? = null,
    val tu1: String? = null,
    val tu2: String? = null,
    val tu3: String? = null,
    val tu4: String? = null,
    val tul: String? = null,
    val tup: String? = null,
    val tuq: String? = null,
    val tuv: String? = null,
    val vuimax: String? = null,
    val vuimin: String? = null,
    val vulmax: String? = null,
    val vulmin: String? = null
)

@Entity
data class UnderexcLimX1(
    @Id val underexcLimX1Id: UUID? = null,
    val k: String? = null,
    val kf2: String? = null,
    val km: String? = null,
    val melmax: String? = null,
    val tf2: String? = null,
    val tm: String? = null
)

@Entity
data class UnderexcLimX2(
    @Id val underexcLimX2Id: UUID? = null,
    val kf2: String? = null,
    val km: String? = null,
    val melmax: String? = null,
    val qo: String? = null,
    val r: String? = null,
    val tf2: String? = null,
    val tm: String? = null
)

@Entity
data class UnderexcitationLimiterDynamics(
     val underexcitationLimiterDynamicsId: UUID? = null
)

@Entity
data class UnderexcitationLimiterUserDefined(
    @Id val underexcitationLimiterUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class Unresolvedname(
     val unresolvednameId: UUID? = null
)

@Entity
data class VAdjIEEE(
    @Id val vAdjIEEEId: UUID? = null,
    val adjslew: String? = null,
    val taoff: String? = null,
    val taon: String? = null,
    val vadjf: String? = null,
    val vadjmax: String? = null,
    val vadjmin: String? = null
)

@Entity
data class VCompIEEEType1(
    @Id val vCompIEEEType1Id: UUID? = null,
    val rc: String? = null,
    val tr: String? = null,
    val xc: String? = null
)

@Entity
data class VCompIEEEType2(
    @Id val vCompIEEEType2Id: UUID? = null,
    val tr: String? = null
)

@Entity
data class ValueAliasSet(
     val valueAliasSetId: UUID? = null
)

@Entity
data class ValueToAlias(
    @Id val valueToAliasId: UUID? = null,
    val value: String? = null
)

@Entity
data class VisibilityLayer(
    @Id val visibilityLayerId: UUID? = null,
    val drawingOrder: String? = null
)

@Entity
data class Voltage(
    @Id val voltageId: UUID? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class VoltageAdjusterDynamics(
     val voltageAdjusterDynamicsId: UUID? = null
)

@Entity
data class VoltageAdjusterUserDefined(
    @Id val voltageAdjusterUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class VoltageCompensatorDynamics(
     val voltageCompensatorDynamicsId: UUID? = null
)

@Entity
data class VoltageCompensatorUserDefined(
    @Id val voltageCompensatorUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class VoltageLevel(
    @Id val voltageLevelId: UUID? = null,
    val highVoltageLimit: String? = null,
    val lowVoltageLimit: String? = null
)

@Entity
data class VoltageLimit(
    @Id val voltageLimitId: UUID? = null,
    val value: String? = null
)

@Entity
data class VoltagePerReactivePower(
    @Id val voltagePerReactivePowerId: UUID? = null,
    val denominatorMultiplier: String? = null,
    val denominatorUnit: String? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class VolumeFlowRate(
    @Id val volumeFlowRateId: UUID? = null,
    val denominatorMultiplier: String? = null,
    val denominatorUnit: String? = null,
    val multiplier: String? = null,
    val unit: String? = null,
    val value: String? = null
)

@Entity
data class VsCapabilityCurve(
     val vsCapabilityCurveId: UUID? = null
)

@Entity
data class VsConverter(
    @Id val vsConverterId: UUID? = null,
    val maxModulationIndex: String? = null,
    val maxValveCurrent: String? = null
)

@Entity
data class WindAeroConstIEC(
     val windAeroConstIECId: UUID? = null
)

@Entity
data class WindAeroLinearIEC(
    @Id val windAeroLinearIECId: UUID? = null,
    val dpomega: String? = null,
    val dptheta: String? = null,
    val omegazero: String? = null,
    val pavail: String? = null,
    val thetazero: String? = null
)

@Entity
data class WindContCurrLimIEC(
    @Id val windContCurrLimIECId: UUID? = null,
    val imax: String? = null,
    val imaxdip: String? = null,
    val mdfslim: String? = null,
    val mqpri: String? = null,
    val tufilt: String? = null
)

@Entity
data class WindContPType3IEC(
    @Id val windContPType3IECId: UUID? = null,
    val dpmax: String? = null,
    val dtrisemaxlvrt: String? = null,
    val kdtd: String? = null,
    val kip: String? = null,
    val kpp: String? = null,
    val mplvrt: String? = null,
    val omegaoffset: String? = null,
    val pdtdmax: String? = null,
    val rramp: String? = null,
    val tdvs: String? = null,
    val temin: String? = null,
    val tomegafilt: String? = null,
    val tpfilt: String? = null,
    val tpord: String? = null,
    val tufilt: String? = null,
    val tuscale: String? = null,
    val twref: String? = null,
    val udvs: String? = null,
    val updip: String? = null,
    val wdtd: String? = null,
    val zeta: String? = null
)

@Entity
data class WindContPType4aIEC(
    @Id val windContPType4aIECId: UUID? = null,
    val dpmax: String? = null,
    val tpord: String? = null,
    val tufilt: String? = null
)

@Entity
data class WindContPType4bIEC(
    @Id val windContPType4bIECId: UUID? = null,
    val dpmax: String? = null,
    val tpaero: String? = null,
    val tpord: String? = null,
    val tufilt: String? = null
)

@Entity
data class WindContPitchAngleIEC(
    @Id val windContPitchAngleIECId: UUID? = null,
    val dthetamax: String? = null,
    val dthetamin: String? = null,
    val kic: String? = null,
    val kiomega: String? = null,
    val kpc: String? = null,
    val kpomega: String? = null,
    val kpx: String? = null,
    val thetamax: String? = null,
    val thetamin: String? = null,
    val ttheta: String? = null
)

@Entity
data class WindContQIEC(
    @Id val windContQIECId: UUID? = null,
    val iqh1: String? = null,
    val iqmax: String? = null,
    val iqmin: String? = null,
    val iqpost: String? = null,
    val kiq: String? = null,
    val kiu: String? = null,
    val kpq: String? = null,
    val kpu: String? = null,
    val kqv: String? = null,
    val qmax: String? = null,
    val qmin: String? = null,
    val rdroop: String? = null,
    val tiq: String? = null,
    val tpfilt: String? = null,
    val tpost: String? = null,
    val tqord: String? = null,
    val tufilt: String? = null,
    val udb1: String? = null,
    val udb2: String? = null,
    val umax: String? = null,
    val umin: String? = null,
    val uqdip: String? = null,
    val uref0: String? = null,
    val windLVRTQcontrolModesType: String? = null,
    val windQcontrolModesType: String? = null,
    val xdroop: String? = null
)

@Entity
data class WindContRotorRIEC(
    @Id val windContRotorRIECId: UUID? = null,
    val kirr: String? = null,
    val komegafilt: String? = null,
    val kpfilt: String? = null,
    val kprr: String? = null,
    val rmax: String? = null,
    val rmin: String? = null,
    val tomegafilt: String? = null,
    val tpfilt: String? = null
)

@Entity
data class WindDynamicsLookupTable(
    @Id val windDynamicsLookupTableId: UUID? = null,
    val input: String? = null,
    val lookupTableFunctionType: String? = null,
    val output: String? = null,
    val sequence: String? = null
)

@Entity
data class WindGenTurbineType1IEC(
     val windGenTurbineType1IECId: UUID? = null
)

@Entity
data class WindGenTurbineType2IEC(
     val windGenTurbineType2IECId: UUID? = null
)

@Entity
data class WindGenTurbineType3IEC(
    @Id val windGenTurbineType3IECId: UUID? = null,
    val dipmax: String? = null,
    val diqmax: String? = null
)

@Entity
data class WindGenTurbineType3aIEC(
    @Id val windGenTurbineType3aIECId: UUID? = null,
    val kpc: String? = null,
    val tic: String? = null,
    val xs: String? = null
)

@Entity
data class WindGenTurbineType3bIEC(
    @Id val windGenTurbineType3bIECId: UUID? = null,
    val fducw: String? = null,
    val mwtcwp: String? = null,
    val tg: String? = null,
    val two: String? = null,
    val xs: String? = null
)

@Entity
data class WindGenType4IEC(
    @Id val windGenType4IECId: UUID? = null,
    val dipmax: String? = null,
    val diqmax: String? = null,
    val diqmin: String? = null,
    val tg: String? = null
)

@Entity
data class WindGeneratingUnit(
    @Id val windGeneratingUnitId: UUID? = null,
    val windGenUnitType: String? = null
)

@Entity
data class WindMechIEC(
    @Id val windMechIECId: UUID? = null,
    val cdrt: String? = null,
    val hgen: String? = null,
    val hwtr: String? = null,
    val kdrt: String? = null
)

@Entity
data class WindPitchContEmulIEC(
    @Id val windPitchContEmulIECId: UUID? = null,
    val kdroop: String? = null,
    val kipce: String? = null,
    val komegaaero: String? = null,
    val kppce: String? = null,
    val omegaref: String? = null,
    val pimax: String? = null,
    val pimin: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val tpe: String? = null
)

@Entity
data class WindPlantDynamics(
     val windPlantDynamicsId: UUID? = null
)

@Entity
data class WindPlantFreqPcontrolIEC(
    @Id val windPlantFreqPcontrolIECId: UUID? = null,
    val dprefmax: String? = null,
    val dprefmin: String? = null,
    val kiwpp: String? = null,
    val kpwpp: String? = null,
    val prefmax: String? = null,
    val prefmin: String? = null,
    val tpft: String? = null,
    val tpfv: String? = null,
    val twpffilt: String? = null,
    val twppfilt: String? = null
)

@Entity
data class WindPlantIEC(
     val windPlantIECId: UUID? = null
)

@Entity
data class WindPlantReactiveControlIEC(
    @Id val windPlantReactiveControlIECId: UUID? = null,
    val kiwpx: String? = null,
    val kpwpx: String? = null,
    val kwpqu: String? = null,
    val mwppf: String? = null,
    val mwpu: String? = null,
    val twppfilt: String? = null,
    val twpqfilt: String? = null,
    val twpufilt: String? = null,
    val txft: String? = null,
    val txfv: String? = null,
    val uwpqdip: String? = null,
    val xrefmax: String? = null,
    val xrefmin: String? = null
)

@Entity
data class WindPlantUserDefined(
    @Id val windPlantUserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class WindProtectionIEC(
    @Id val windProtectionIECId: UUID? = null,
    val fover: String? = null,
    val funder: String? = null,
    val tfover: String? = null,
    val tfunder: String? = null,
    val tuover: String? = null,
    val tuunder: String? = null,
    val uover: String? = null,
    val uunder: String? = null
)

@Entity
data class WindTurbineType1or2Dynamics(
     val windTurbineType1or2DynamicsId: UUID? = null
)

@Entity
data class WindTurbineType1or2IEC(
     val windTurbineType1or2IECId: UUID? = null
)

@Entity
data class WindTurbineType3or4Dynamics(
     val windTurbineType3or4DynamicsId: UUID? = null
)

@Entity
data class WindTurbineType3or4IEC(
     val windTurbineType3or4IECId: UUID? = null
)

@Entity
data class WindTurbineType4aIEC(
     val windTurbineType4aIECId: UUID? = null
)

@Entity
data class WindTurbineType4bIEC(
     val windTurbineType4bIECId: UUID? = null
)

@Entity
data class WindType1or2UserDefined(
    @Id val windType1or2UserDefinedId: UUID? = null,
    val proprietary: String? = null
)

@Entity
data class WindType3or4UserDefined(
    @Id val windType3or4UserDefinedId: UUID? = null,
    val proprietary: String? = null
)

