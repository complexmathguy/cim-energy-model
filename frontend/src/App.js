import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import HomePageComponent from './components/HomePageComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import ListACDCConverterComponent from './components/ListACDCConverterComponent';
import CreateACDCConverterComponent from './components/CreateACDCConverterComponent';
import UpdateACDCConverterComponent from './components/UpdateACDCConverterComponent';
import ViewACDCConverterComponent from './components/ViewACDCConverterComponent';
import ListACDCConverterDCTerminalComponent from './components/ListACDCConverterDCTerminalComponent';
import CreateACDCConverterDCTerminalComponent from './components/CreateACDCConverterDCTerminalComponent';
import UpdateACDCConverterDCTerminalComponent from './components/UpdateACDCConverterDCTerminalComponent';
import ViewACDCConverterDCTerminalComponent from './components/ViewACDCConverterDCTerminalComponent';
import ListACDCTerminalComponent from './components/ListACDCTerminalComponent';
import CreateACDCTerminalComponent from './components/CreateACDCTerminalComponent';
import UpdateACDCTerminalComponent from './components/UpdateACDCTerminalComponent';
import ViewACDCTerminalComponent from './components/ViewACDCTerminalComponent';
import ListACLineSegmentComponent from './components/ListACLineSegmentComponent';
import CreateACLineSegmentComponent from './components/CreateACLineSegmentComponent';
import UpdateACLineSegmentComponent from './components/UpdateACLineSegmentComponent';
import ViewACLineSegmentComponent from './components/ViewACLineSegmentComponent';
import ListAccumulatorLimitComponent from './components/ListAccumulatorLimitComponent';
import CreateAccumulatorLimitComponent from './components/CreateAccumulatorLimitComponent';
import UpdateAccumulatorLimitComponent from './components/UpdateAccumulatorLimitComponent';
import ViewAccumulatorLimitComponent from './components/ViewAccumulatorLimitComponent';
import ListAccumulatorValueComponent from './components/ListAccumulatorValueComponent';
import CreateAccumulatorValueComponent from './components/CreateAccumulatorValueComponent';
import UpdateAccumulatorValueComponent from './components/UpdateAccumulatorValueComponent';
import ViewAccumulatorValueComponent from './components/ViewAccumulatorValueComponent';
import ListActivePowerComponent from './components/ListActivePowerComponent';
import CreateActivePowerComponent from './components/CreateActivePowerComponent';
import UpdateActivePowerComponent from './components/UpdateActivePowerComponent';
import ViewActivePowerComponent from './components/ViewActivePowerComponent';
import ListActivePowerLimitComponent from './components/ListActivePowerLimitComponent';
import CreateActivePowerLimitComponent from './components/CreateActivePowerLimitComponent';
import UpdateActivePowerLimitComponent from './components/UpdateActivePowerLimitComponent';
import ViewActivePowerLimitComponent from './components/ViewActivePowerLimitComponent';
import ListActivePowerPerCurrentFlowComponent from './components/ListActivePowerPerCurrentFlowComponent';
import CreateActivePowerPerCurrentFlowComponent from './components/CreateActivePowerPerCurrentFlowComponent';
import UpdateActivePowerPerCurrentFlowComponent from './components/UpdateActivePowerPerCurrentFlowComponent';
import ViewActivePowerPerCurrentFlowComponent from './components/ViewActivePowerPerCurrentFlowComponent';
import ListActivePowerPerFrequencyComponent from './components/ListActivePowerPerFrequencyComponent';
import CreateActivePowerPerFrequencyComponent from './components/CreateActivePowerPerFrequencyComponent';
import UpdateActivePowerPerFrequencyComponent from './components/UpdateActivePowerPerFrequencyComponent';
import ViewActivePowerPerFrequencyComponent from './components/ViewActivePowerPerFrequencyComponent';
import ListAnalogComponent from './components/ListAnalogComponent';
import CreateAnalogComponent from './components/CreateAnalogComponent';
import UpdateAnalogComponent from './components/UpdateAnalogComponent';
import ViewAnalogComponent from './components/ViewAnalogComponent';
import ListAnalogControlComponent from './components/ListAnalogControlComponent';
import CreateAnalogControlComponent from './components/CreateAnalogControlComponent';
import UpdateAnalogControlComponent from './components/UpdateAnalogControlComponent';
import ViewAnalogControlComponent from './components/ViewAnalogControlComponent';
import ListAnalogLimitComponent from './components/ListAnalogLimitComponent';
import CreateAnalogLimitComponent from './components/CreateAnalogLimitComponent';
import UpdateAnalogLimitComponent from './components/UpdateAnalogLimitComponent';
import ViewAnalogLimitComponent from './components/ViewAnalogLimitComponent';
import ListAnalogValueComponent from './components/ListAnalogValueComponent';
import CreateAnalogValueComponent from './components/CreateAnalogValueComponent';
import UpdateAnalogValueComponent from './components/UpdateAnalogValueComponent';
import ViewAnalogValueComponent from './components/ViewAnalogValueComponent';
import ListAngleDegreesComponent from './components/ListAngleDegreesComponent';
import CreateAngleDegreesComponent from './components/CreateAngleDegreesComponent';
import UpdateAngleDegreesComponent from './components/UpdateAngleDegreesComponent';
import ViewAngleDegreesComponent from './components/ViewAngleDegreesComponent';
import ListAngleRadiansComponent from './components/ListAngleRadiansComponent';
import CreateAngleRadiansComponent from './components/CreateAngleRadiansComponent';
import UpdateAngleRadiansComponent from './components/UpdateAngleRadiansComponent';
import ViewAngleRadiansComponent from './components/ViewAngleRadiansComponent';
import ListApparentPowerComponent from './components/ListApparentPowerComponent';
import CreateApparentPowerComponent from './components/CreateApparentPowerComponent';
import UpdateApparentPowerComponent from './components/UpdateApparentPowerComponent';
import ViewApparentPowerComponent from './components/ViewApparentPowerComponent';
import ListApparentPowerLimitComponent from './components/ListApparentPowerLimitComponent';
import CreateApparentPowerLimitComponent from './components/CreateApparentPowerLimitComponent';
import UpdateApparentPowerLimitComponent from './components/UpdateApparentPowerLimitComponent';
import ViewApparentPowerLimitComponent from './components/ViewApparentPowerLimitComponent';
import ListAreaComponent from './components/ListAreaComponent';
import CreateAreaComponent from './components/CreateAreaComponent';
import UpdateAreaComponent from './components/UpdateAreaComponent';
import ViewAreaComponent from './components/ViewAreaComponent';
import ListAsynchronousMachineComponent from './components/ListAsynchronousMachineComponent';
import CreateAsynchronousMachineComponent from './components/CreateAsynchronousMachineComponent';
import UpdateAsynchronousMachineComponent from './components/UpdateAsynchronousMachineComponent';
import ViewAsynchronousMachineComponent from './components/ViewAsynchronousMachineComponent';
import ListAsynchronousMachineEquivalentCircuitComponent from './components/ListAsynchronousMachineEquivalentCircuitComponent';
import CreateAsynchronousMachineEquivalentCircuitComponent from './components/CreateAsynchronousMachineEquivalentCircuitComponent';
import UpdateAsynchronousMachineEquivalentCircuitComponent from './components/UpdateAsynchronousMachineEquivalentCircuitComponent';
import ViewAsynchronousMachineEquivalentCircuitComponent from './components/ViewAsynchronousMachineEquivalentCircuitComponent';
import ListAsynchronousMachineTimeConstantReactanceComponent from './components/ListAsynchronousMachineTimeConstantReactanceComponent';
import CreateAsynchronousMachineTimeConstantReactanceComponent from './components/CreateAsynchronousMachineTimeConstantReactanceComponent';
import UpdateAsynchronousMachineTimeConstantReactanceComponent from './components/UpdateAsynchronousMachineTimeConstantReactanceComponent';
import ViewAsynchronousMachineTimeConstantReactanceComponent from './components/ViewAsynchronousMachineTimeConstantReactanceComponent';
import ListAsynchronousMachineUserDefinedComponent from './components/ListAsynchronousMachineUserDefinedComponent';
import CreateAsynchronousMachineUserDefinedComponent from './components/CreateAsynchronousMachineUserDefinedComponent';
import UpdateAsynchronousMachineUserDefinedComponent from './components/UpdateAsynchronousMachineUserDefinedComponent';
import ViewAsynchronousMachineUserDefinedComponent from './components/ViewAsynchronousMachineUserDefinedComponent';
import ListBaseVoltageComponent from './components/ListBaseVoltageComponent';
import CreateBaseVoltageComponent from './components/CreateBaseVoltageComponent';
import UpdateBaseVoltageComponent from './components/UpdateBaseVoltageComponent';
import ViewBaseVoltageComponent from './components/ViewBaseVoltageComponent';
import ListBasicIntervalScheduleComponent from './components/ListBasicIntervalScheduleComponent';
import CreateBasicIntervalScheduleComponent from './components/CreateBasicIntervalScheduleComponent';
import UpdateBasicIntervalScheduleComponent from './components/UpdateBasicIntervalScheduleComponent';
import ViewBasicIntervalScheduleComponent from './components/ViewBasicIntervalScheduleComponent';
import ListBoundaryExtensionsComponent from './components/ListBoundaryExtensionsComponent';
import CreateBoundaryExtensionsComponent from './components/CreateBoundaryExtensionsComponent';
import UpdateBoundaryExtensionsComponent from './components/UpdateBoundaryExtensionsComponent';
import ViewBoundaryExtensionsComponent from './components/ViewBoundaryExtensionsComponent';
import ListBusNameMarkerComponent from './components/ListBusNameMarkerComponent';
import CreateBusNameMarkerComponent from './components/CreateBusNameMarkerComponent';
import UpdateBusNameMarkerComponent from './components/UpdateBusNameMarkerComponent';
import ViewBusNameMarkerComponent from './components/ViewBusNameMarkerComponent';
import ListBusbarSectionComponent from './components/ListBusbarSectionComponent';
import CreateBusbarSectionComponent from './components/CreateBusbarSectionComponent';
import UpdateBusbarSectionComponent from './components/UpdateBusbarSectionComponent';
import ViewBusbarSectionComponent from './components/ViewBusbarSectionComponent';
import ListCapacitanceComponent from './components/ListCapacitanceComponent';
import CreateCapacitanceComponent from './components/CreateCapacitanceComponent';
import UpdateCapacitanceComponent from './components/UpdateCapacitanceComponent';
import ViewCapacitanceComponent from './components/ViewCapacitanceComponent';
import ListCapacitancePerLengthComponent from './components/ListCapacitancePerLengthComponent';
import CreateCapacitancePerLengthComponent from './components/CreateCapacitancePerLengthComponent';
import UpdateCapacitancePerLengthComponent from './components/UpdateCapacitancePerLengthComponent';
import ViewCapacitancePerLengthComponent from './components/ViewCapacitancePerLengthComponent';
import ListCommandComponent from './components/ListCommandComponent';
import CreateCommandComponent from './components/CreateCommandComponent';
import UpdateCommandComponent from './components/UpdateCommandComponent';
import ViewCommandComponent from './components/ViewCommandComponent';
import ListConductanceComponent from './components/ListConductanceComponent';
import CreateConductanceComponent from './components/CreateConductanceComponent';
import UpdateConductanceComponent from './components/UpdateConductanceComponent';
import ViewConductanceComponent from './components/ViewConductanceComponent';
import ListConductorComponent from './components/ListConductorComponent';
import CreateConductorComponent from './components/CreateConductorComponent';
import UpdateConductorComponent from './components/UpdateConductorComponent';
import ViewConductorComponent from './components/ViewConductorComponent';
import ListConnectivityNodeComponent from './components/ListConnectivityNodeComponent';
import CreateConnectivityNodeComponent from './components/CreateConnectivityNodeComponent';
import UpdateConnectivityNodeComponent from './components/UpdateConnectivityNodeComponent';
import ViewConnectivityNodeComponent from './components/ViewConnectivityNodeComponent';
import ListControlComponent from './components/ListControlComponent';
import CreateControlComponent from './components/CreateControlComponent';
import UpdateControlComponent from './components/UpdateControlComponent';
import ViewControlComponent from './components/ViewControlComponent';
import ListControlAreaComponent from './components/ListControlAreaComponent';
import CreateControlAreaComponent from './components/CreateControlAreaComponent';
import UpdateControlAreaComponent from './components/UpdateControlAreaComponent';
import ViewControlAreaComponent from './components/ViewControlAreaComponent';
import ListCoordinateSystemComponent from './components/ListCoordinateSystemComponent';
import CreateCoordinateSystemComponent from './components/CreateCoordinateSystemComponent';
import UpdateCoordinateSystemComponent from './components/UpdateCoordinateSystemComponent';
import ViewCoordinateSystemComponent from './components/ViewCoordinateSystemComponent';
import ListCsConverterComponent from './components/ListCsConverterComponent';
import CreateCsConverterComponent from './components/CreateCsConverterComponent';
import UpdateCsConverterComponent from './components/UpdateCsConverterComponent';
import ViewCsConverterComponent from './components/ViewCsConverterComponent';
import ListCurrentFlowComponent from './components/ListCurrentFlowComponent';
import CreateCurrentFlowComponent from './components/CreateCurrentFlowComponent';
import UpdateCurrentFlowComponent from './components/UpdateCurrentFlowComponent';
import ViewCurrentFlowComponent from './components/ViewCurrentFlowComponent';
import ListCurrentLimitComponent from './components/ListCurrentLimitComponent';
import CreateCurrentLimitComponent from './components/CreateCurrentLimitComponent';
import UpdateCurrentLimitComponent from './components/UpdateCurrentLimitComponent';
import ViewCurrentLimitComponent from './components/ViewCurrentLimitComponent';
import ListCurveComponent from './components/ListCurveComponent';
import CreateCurveComponent from './components/CreateCurveComponent';
import UpdateCurveComponent from './components/UpdateCurveComponent';
import ViewCurveComponent from './components/ViewCurveComponent';
import ListCurveDataComponent from './components/ListCurveDataComponent';
import CreateCurveDataComponent from './components/CreateCurveDataComponent';
import UpdateCurveDataComponent from './components/UpdateCurveDataComponent';
import ViewCurveDataComponent from './components/ViewCurveDataComponent';
import ListDCConverterUnitComponent from './components/ListDCConverterUnitComponent';
import CreateDCConverterUnitComponent from './components/CreateDCConverterUnitComponent';
import UpdateDCConverterUnitComponent from './components/UpdateDCConverterUnitComponent';
import ViewDCConverterUnitComponent from './components/ViewDCConverterUnitComponent';
import ListDCGroundComponent from './components/ListDCGroundComponent';
import CreateDCGroundComponent from './components/CreateDCGroundComponent';
import UpdateDCGroundComponent from './components/UpdateDCGroundComponent';
import ViewDCGroundComponent from './components/ViewDCGroundComponent';
import ListDCLineSegmentComponent from './components/ListDCLineSegmentComponent';
import CreateDCLineSegmentComponent from './components/CreateDCLineSegmentComponent';
import UpdateDCLineSegmentComponent from './components/UpdateDCLineSegmentComponent';
import ViewDCLineSegmentComponent from './components/ViewDCLineSegmentComponent';
import ListDCSeriesDeviceComponent from './components/ListDCSeriesDeviceComponent';
import CreateDCSeriesDeviceComponent from './components/CreateDCSeriesDeviceComponent';
import UpdateDCSeriesDeviceComponent from './components/UpdateDCSeriesDeviceComponent';
import ViewDCSeriesDeviceComponent from './components/ViewDCSeriesDeviceComponent';
import ListDCShuntComponent from './components/ListDCShuntComponent';
import CreateDCShuntComponent from './components/CreateDCShuntComponent';
import UpdateDCShuntComponent from './components/UpdateDCShuntComponent';
import ViewDCShuntComponent from './components/ViewDCShuntComponent';
import ListDiagramComponent from './components/ListDiagramComponent';
import CreateDiagramComponent from './components/CreateDiagramComponent';
import UpdateDiagramComponent from './components/UpdateDiagramComponent';
import ViewDiagramComponent from './components/ViewDiagramComponent';
import ListDiagramLayoutVersionComponent from './components/ListDiagramLayoutVersionComponent';
import CreateDiagramLayoutVersionComponent from './components/CreateDiagramLayoutVersionComponent';
import UpdateDiagramLayoutVersionComponent from './components/UpdateDiagramLayoutVersionComponent';
import ViewDiagramLayoutVersionComponent from './components/ViewDiagramLayoutVersionComponent';
import ListDiagramObjectComponent from './components/ListDiagramObjectComponent';
import CreateDiagramObjectComponent from './components/CreateDiagramObjectComponent';
import UpdateDiagramObjectComponent from './components/UpdateDiagramObjectComponent';
import ViewDiagramObjectComponent from './components/ViewDiagramObjectComponent';
import ListDiagramObjectPointComponent from './components/ListDiagramObjectPointComponent';
import CreateDiagramObjectPointComponent from './components/CreateDiagramObjectPointComponent';
import UpdateDiagramObjectPointComponent from './components/UpdateDiagramObjectPointComponent';
import ViewDiagramObjectPointComponent from './components/ViewDiagramObjectPointComponent';
import ListDiscExcContIEEEDEC1AComponent from './components/ListDiscExcContIEEEDEC1AComponent';
import CreateDiscExcContIEEEDEC1AComponent from './components/CreateDiscExcContIEEEDEC1AComponent';
import UpdateDiscExcContIEEEDEC1AComponent from './components/UpdateDiscExcContIEEEDEC1AComponent';
import ViewDiscExcContIEEEDEC1AComponent from './components/ViewDiscExcContIEEEDEC1AComponent';
import ListDiscExcContIEEEDEC2AComponent from './components/ListDiscExcContIEEEDEC2AComponent';
import CreateDiscExcContIEEEDEC2AComponent from './components/CreateDiscExcContIEEEDEC2AComponent';
import UpdateDiscExcContIEEEDEC2AComponent from './components/UpdateDiscExcContIEEEDEC2AComponent';
import ViewDiscExcContIEEEDEC2AComponent from './components/ViewDiscExcContIEEEDEC2AComponent';
import ListDiscExcContIEEEDEC3AComponent from './components/ListDiscExcContIEEEDEC3AComponent';
import CreateDiscExcContIEEEDEC3AComponent from './components/CreateDiscExcContIEEEDEC3AComponent';
import UpdateDiscExcContIEEEDEC3AComponent from './components/UpdateDiscExcContIEEEDEC3AComponent';
import ViewDiscExcContIEEEDEC3AComponent from './components/ViewDiscExcContIEEEDEC3AComponent';
import ListDiscontinuousExcitationControlUserDefinedComponent from './components/ListDiscontinuousExcitationControlUserDefinedComponent';
import CreateDiscontinuousExcitationControlUserDefinedComponent from './components/CreateDiscontinuousExcitationControlUserDefinedComponent';
import UpdateDiscontinuousExcitationControlUserDefinedComponent from './components/UpdateDiscontinuousExcitationControlUserDefinedComponent';
import ViewDiscontinuousExcitationControlUserDefinedComponent from './components/ViewDiscontinuousExcitationControlUserDefinedComponent';
import ListDiscreteValueComponent from './components/ListDiscreteValueComponent';
import CreateDiscreteValueComponent from './components/CreateDiscreteValueComponent';
import UpdateDiscreteValueComponent from './components/UpdateDiscreteValueComponent';
import ViewDiscreteValueComponent from './components/ViewDiscreteValueComponent';
import ListDomainVersionComponent from './components/ListDomainVersionComponent';
import CreateDomainVersionComponent from './components/CreateDomainVersionComponent';
import UpdateDomainVersionComponent from './components/UpdateDomainVersionComponent';
import ViewDomainVersionComponent from './components/ViewDomainVersionComponent';
import ListDynamicsFunctionBlockComponent from './components/ListDynamicsFunctionBlockComponent';
import CreateDynamicsFunctionBlockComponent from './components/CreateDynamicsFunctionBlockComponent';
import UpdateDynamicsFunctionBlockComponent from './components/UpdateDynamicsFunctionBlockComponent';
import ViewDynamicsFunctionBlockComponent from './components/ViewDynamicsFunctionBlockComponent';
import ListDynamicsVersionComponent from './components/ListDynamicsVersionComponent';
import CreateDynamicsVersionComponent from './components/CreateDynamicsVersionComponent';
import UpdateDynamicsVersionComponent from './components/UpdateDynamicsVersionComponent';
import ViewDynamicsVersionComponent from './components/ViewDynamicsVersionComponent';
import ListENTSOEIdentifiedObjectComponent from './components/ListENTSOEIdentifiedObjectComponent';
import CreateENTSOEIdentifiedObjectComponent from './components/CreateENTSOEIdentifiedObjectComponent';
import UpdateENTSOEIdentifiedObjectComponent from './components/UpdateENTSOEIdentifiedObjectComponent';
import ViewENTSOEIdentifiedObjectComponent from './components/ViewENTSOEIdentifiedObjectComponent';
import ListENTSOEOperationalLimitTypeComponent from './components/ListENTSOEOperationalLimitTypeComponent';
import CreateENTSOEOperationalLimitTypeComponent from './components/CreateENTSOEOperationalLimitTypeComponent';
import UpdateENTSOEOperationalLimitTypeComponent from './components/UpdateENTSOEOperationalLimitTypeComponent';
import ViewENTSOEOperationalLimitTypeComponent from './components/ViewENTSOEOperationalLimitTypeComponent';
import ListEarthFaultCompensatorComponent from './components/ListEarthFaultCompensatorComponent';
import CreateEarthFaultCompensatorComponent from './components/CreateEarthFaultCompensatorComponent';
import UpdateEarthFaultCompensatorComponent from './components/UpdateEarthFaultCompensatorComponent';
import ViewEarthFaultCompensatorComponent from './components/ViewEarthFaultCompensatorComponent';
import ListEnergyConsumerComponent from './components/ListEnergyConsumerComponent';
import CreateEnergyConsumerComponent from './components/CreateEnergyConsumerComponent';
import UpdateEnergyConsumerComponent from './components/UpdateEnergyConsumerComponent';
import ViewEnergyConsumerComponent from './components/ViewEnergyConsumerComponent';
import ListEquipmentBoundaryVersionComponent from './components/ListEquipmentBoundaryVersionComponent';
import CreateEquipmentBoundaryVersionComponent from './components/CreateEquipmentBoundaryVersionComponent';
import UpdateEquipmentBoundaryVersionComponent from './components/UpdateEquipmentBoundaryVersionComponent';
import ViewEquipmentBoundaryVersionComponent from './components/ViewEquipmentBoundaryVersionComponent';
import ListEquipmentVersionComponent from './components/ListEquipmentVersionComponent';
import CreateEquipmentVersionComponent from './components/CreateEquipmentVersionComponent';
import UpdateEquipmentVersionComponent from './components/UpdateEquipmentVersionComponent';
import ViewEquipmentVersionComponent from './components/ViewEquipmentVersionComponent';
import ListEquivalentBranchComponent from './components/ListEquivalentBranchComponent';
import CreateEquivalentBranchComponent from './components/CreateEquivalentBranchComponent';
import UpdateEquivalentBranchComponent from './components/UpdateEquivalentBranchComponent';
import ViewEquivalentBranchComponent from './components/ViewEquivalentBranchComponent';
import ListEquivalentInjectionComponent from './components/ListEquivalentInjectionComponent';
import CreateEquivalentInjectionComponent from './components/CreateEquivalentInjectionComponent';
import UpdateEquivalentInjectionComponent from './components/UpdateEquivalentInjectionComponent';
import ViewEquivalentInjectionComponent from './components/ViewEquivalentInjectionComponent';
import ListEquivalentShuntComponent from './components/ListEquivalentShuntComponent';
import CreateEquivalentShuntComponent from './components/CreateEquivalentShuntComponent';
import UpdateEquivalentShuntComponent from './components/UpdateEquivalentShuntComponent';
import ViewEquivalentShuntComponent from './components/ViewEquivalentShuntComponent';
import ListExcAC1AComponent from './components/ListExcAC1AComponent';
import CreateExcAC1AComponent from './components/CreateExcAC1AComponent';
import UpdateExcAC1AComponent from './components/UpdateExcAC1AComponent';
import ViewExcAC1AComponent from './components/ViewExcAC1AComponent';
import ListExcAC2AComponent from './components/ListExcAC2AComponent';
import CreateExcAC2AComponent from './components/CreateExcAC2AComponent';
import UpdateExcAC2AComponent from './components/UpdateExcAC2AComponent';
import ViewExcAC2AComponent from './components/ViewExcAC2AComponent';
import ListExcAC3AComponent from './components/ListExcAC3AComponent';
import CreateExcAC3AComponent from './components/CreateExcAC3AComponent';
import UpdateExcAC3AComponent from './components/UpdateExcAC3AComponent';
import ViewExcAC3AComponent from './components/ViewExcAC3AComponent';
import ListExcAC4AComponent from './components/ListExcAC4AComponent';
import CreateExcAC4AComponent from './components/CreateExcAC4AComponent';
import UpdateExcAC4AComponent from './components/UpdateExcAC4AComponent';
import ViewExcAC4AComponent from './components/ViewExcAC4AComponent';
import ListExcAC5AComponent from './components/ListExcAC5AComponent';
import CreateExcAC5AComponent from './components/CreateExcAC5AComponent';
import UpdateExcAC5AComponent from './components/UpdateExcAC5AComponent';
import ViewExcAC5AComponent from './components/ViewExcAC5AComponent';
import ListExcAC6AComponent from './components/ListExcAC6AComponent';
import CreateExcAC6AComponent from './components/CreateExcAC6AComponent';
import UpdateExcAC6AComponent from './components/UpdateExcAC6AComponent';
import ViewExcAC6AComponent from './components/ViewExcAC6AComponent';
import ListExcAC8BComponent from './components/ListExcAC8BComponent';
import CreateExcAC8BComponent from './components/CreateExcAC8BComponent';
import UpdateExcAC8BComponent from './components/UpdateExcAC8BComponent';
import ViewExcAC8BComponent from './components/ViewExcAC8BComponent';
import ListExcANSComponent from './components/ListExcANSComponent';
import CreateExcANSComponent from './components/CreateExcANSComponent';
import UpdateExcANSComponent from './components/UpdateExcANSComponent';
import ViewExcANSComponent from './components/ViewExcANSComponent';
import ListExcAVR1Component from './components/ListExcAVR1Component';
import CreateExcAVR1Component from './components/CreateExcAVR1Component';
import UpdateExcAVR1Component from './components/UpdateExcAVR1Component';
import ViewExcAVR1Component from './components/ViewExcAVR1Component';
import ListExcAVR2Component from './components/ListExcAVR2Component';
import CreateExcAVR2Component from './components/CreateExcAVR2Component';
import UpdateExcAVR2Component from './components/UpdateExcAVR2Component';
import ViewExcAVR2Component from './components/ViewExcAVR2Component';
import ListExcAVR3Component from './components/ListExcAVR3Component';
import CreateExcAVR3Component from './components/CreateExcAVR3Component';
import UpdateExcAVR3Component from './components/UpdateExcAVR3Component';
import ViewExcAVR3Component from './components/ViewExcAVR3Component';
import ListExcAVR4Component from './components/ListExcAVR4Component';
import CreateExcAVR4Component from './components/CreateExcAVR4Component';
import UpdateExcAVR4Component from './components/UpdateExcAVR4Component';
import ViewExcAVR4Component from './components/ViewExcAVR4Component';
import ListExcAVR5Component from './components/ListExcAVR5Component';
import CreateExcAVR5Component from './components/CreateExcAVR5Component';
import UpdateExcAVR5Component from './components/UpdateExcAVR5Component';
import ViewExcAVR5Component from './components/ViewExcAVR5Component';
import ListExcAVR7Component from './components/ListExcAVR7Component';
import CreateExcAVR7Component from './components/CreateExcAVR7Component';
import UpdateExcAVR7Component from './components/UpdateExcAVR7Component';
import ViewExcAVR7Component from './components/ViewExcAVR7Component';
import ListExcBBCComponent from './components/ListExcBBCComponent';
import CreateExcBBCComponent from './components/CreateExcBBCComponent';
import UpdateExcBBCComponent from './components/UpdateExcBBCComponent';
import ViewExcBBCComponent from './components/ViewExcBBCComponent';
import ListExcCZComponent from './components/ListExcCZComponent';
import CreateExcCZComponent from './components/CreateExcCZComponent';
import UpdateExcCZComponent from './components/UpdateExcCZComponent';
import ViewExcCZComponent from './components/ViewExcCZComponent';
import ListExcDC1AComponent from './components/ListExcDC1AComponent';
import CreateExcDC1AComponent from './components/CreateExcDC1AComponent';
import UpdateExcDC1AComponent from './components/UpdateExcDC1AComponent';
import ViewExcDC1AComponent from './components/ViewExcDC1AComponent';
import ListExcDC2AComponent from './components/ListExcDC2AComponent';
import CreateExcDC2AComponent from './components/CreateExcDC2AComponent';
import UpdateExcDC2AComponent from './components/UpdateExcDC2AComponent';
import ViewExcDC2AComponent from './components/ViewExcDC2AComponent';
import ListExcDC3AComponent from './components/ListExcDC3AComponent';
import CreateExcDC3AComponent from './components/CreateExcDC3AComponent';
import UpdateExcDC3AComponent from './components/UpdateExcDC3AComponent';
import ViewExcDC3AComponent from './components/ViewExcDC3AComponent';
import ListExcDC3A1Component from './components/ListExcDC3A1Component';
import CreateExcDC3A1Component from './components/CreateExcDC3A1Component';
import UpdateExcDC3A1Component from './components/UpdateExcDC3A1Component';
import ViewExcDC3A1Component from './components/ViewExcDC3A1Component';
import ListExcELIN1Component from './components/ListExcELIN1Component';
import CreateExcELIN1Component from './components/CreateExcELIN1Component';
import UpdateExcELIN1Component from './components/UpdateExcELIN1Component';
import ViewExcELIN1Component from './components/ViewExcELIN1Component';
import ListExcELIN2Component from './components/ListExcELIN2Component';
import CreateExcELIN2Component from './components/CreateExcELIN2Component';
import UpdateExcELIN2Component from './components/UpdateExcELIN2Component';
import ViewExcELIN2Component from './components/ViewExcELIN2Component';
import ListExcHUComponent from './components/ListExcHUComponent';
import CreateExcHUComponent from './components/CreateExcHUComponent';
import UpdateExcHUComponent from './components/UpdateExcHUComponent';
import ViewExcHUComponent from './components/ViewExcHUComponent';
import ListExcIEEEAC1AComponent from './components/ListExcIEEEAC1AComponent';
import CreateExcIEEEAC1AComponent from './components/CreateExcIEEEAC1AComponent';
import UpdateExcIEEEAC1AComponent from './components/UpdateExcIEEEAC1AComponent';
import ViewExcIEEEAC1AComponent from './components/ViewExcIEEEAC1AComponent';
import ListExcIEEEAC2AComponent from './components/ListExcIEEEAC2AComponent';
import CreateExcIEEEAC2AComponent from './components/CreateExcIEEEAC2AComponent';
import UpdateExcIEEEAC2AComponent from './components/UpdateExcIEEEAC2AComponent';
import ViewExcIEEEAC2AComponent from './components/ViewExcIEEEAC2AComponent';
import ListExcIEEEAC3AComponent from './components/ListExcIEEEAC3AComponent';
import CreateExcIEEEAC3AComponent from './components/CreateExcIEEEAC3AComponent';
import UpdateExcIEEEAC3AComponent from './components/UpdateExcIEEEAC3AComponent';
import ViewExcIEEEAC3AComponent from './components/ViewExcIEEEAC3AComponent';
import ListExcIEEEAC4AComponent from './components/ListExcIEEEAC4AComponent';
import CreateExcIEEEAC4AComponent from './components/CreateExcIEEEAC4AComponent';
import UpdateExcIEEEAC4AComponent from './components/UpdateExcIEEEAC4AComponent';
import ViewExcIEEEAC4AComponent from './components/ViewExcIEEEAC4AComponent';
import ListExcIEEEAC5AComponent from './components/ListExcIEEEAC5AComponent';
import CreateExcIEEEAC5AComponent from './components/CreateExcIEEEAC5AComponent';
import UpdateExcIEEEAC5AComponent from './components/UpdateExcIEEEAC5AComponent';
import ViewExcIEEEAC5AComponent from './components/ViewExcIEEEAC5AComponent';
import ListExcIEEEAC6AComponent from './components/ListExcIEEEAC6AComponent';
import CreateExcIEEEAC6AComponent from './components/CreateExcIEEEAC6AComponent';
import UpdateExcIEEEAC6AComponent from './components/UpdateExcIEEEAC6AComponent';
import ViewExcIEEEAC6AComponent from './components/ViewExcIEEEAC6AComponent';
import ListExcIEEEAC7BComponent from './components/ListExcIEEEAC7BComponent';
import CreateExcIEEEAC7BComponent from './components/CreateExcIEEEAC7BComponent';
import UpdateExcIEEEAC7BComponent from './components/UpdateExcIEEEAC7BComponent';
import ViewExcIEEEAC7BComponent from './components/ViewExcIEEEAC7BComponent';
import ListExcIEEEAC8BComponent from './components/ListExcIEEEAC8BComponent';
import CreateExcIEEEAC8BComponent from './components/CreateExcIEEEAC8BComponent';
import UpdateExcIEEEAC8BComponent from './components/UpdateExcIEEEAC8BComponent';
import ViewExcIEEEAC8BComponent from './components/ViewExcIEEEAC8BComponent';
import ListExcIEEEDC1AComponent from './components/ListExcIEEEDC1AComponent';
import CreateExcIEEEDC1AComponent from './components/CreateExcIEEEDC1AComponent';
import UpdateExcIEEEDC1AComponent from './components/UpdateExcIEEEDC1AComponent';
import ViewExcIEEEDC1AComponent from './components/ViewExcIEEEDC1AComponent';
import ListExcIEEEDC2AComponent from './components/ListExcIEEEDC2AComponent';
import CreateExcIEEEDC2AComponent from './components/CreateExcIEEEDC2AComponent';
import UpdateExcIEEEDC2AComponent from './components/UpdateExcIEEEDC2AComponent';
import ViewExcIEEEDC2AComponent from './components/ViewExcIEEEDC2AComponent';
import ListExcIEEEDC3AComponent from './components/ListExcIEEEDC3AComponent';
import CreateExcIEEEDC3AComponent from './components/CreateExcIEEEDC3AComponent';
import UpdateExcIEEEDC3AComponent from './components/UpdateExcIEEEDC3AComponent';
import ViewExcIEEEDC3AComponent from './components/ViewExcIEEEDC3AComponent';
import ListExcIEEEDC4BComponent from './components/ListExcIEEEDC4BComponent';
import CreateExcIEEEDC4BComponent from './components/CreateExcIEEEDC4BComponent';
import UpdateExcIEEEDC4BComponent from './components/UpdateExcIEEEDC4BComponent';
import ViewExcIEEEDC4BComponent from './components/ViewExcIEEEDC4BComponent';
import ListExcIEEEST1AComponent from './components/ListExcIEEEST1AComponent';
import CreateExcIEEEST1AComponent from './components/CreateExcIEEEST1AComponent';
import UpdateExcIEEEST1AComponent from './components/UpdateExcIEEEST1AComponent';
import ViewExcIEEEST1AComponent from './components/ViewExcIEEEST1AComponent';
import ListExcIEEEST2AComponent from './components/ListExcIEEEST2AComponent';
import CreateExcIEEEST2AComponent from './components/CreateExcIEEEST2AComponent';
import UpdateExcIEEEST2AComponent from './components/UpdateExcIEEEST2AComponent';
import ViewExcIEEEST2AComponent from './components/ViewExcIEEEST2AComponent';
import ListExcIEEEST3AComponent from './components/ListExcIEEEST3AComponent';
import CreateExcIEEEST3AComponent from './components/CreateExcIEEEST3AComponent';
import UpdateExcIEEEST3AComponent from './components/UpdateExcIEEEST3AComponent';
import ViewExcIEEEST3AComponent from './components/ViewExcIEEEST3AComponent';
import ListExcIEEEST4BComponent from './components/ListExcIEEEST4BComponent';
import CreateExcIEEEST4BComponent from './components/CreateExcIEEEST4BComponent';
import UpdateExcIEEEST4BComponent from './components/UpdateExcIEEEST4BComponent';
import ViewExcIEEEST4BComponent from './components/ViewExcIEEEST4BComponent';
import ListExcIEEEST5BComponent from './components/ListExcIEEEST5BComponent';
import CreateExcIEEEST5BComponent from './components/CreateExcIEEEST5BComponent';
import UpdateExcIEEEST5BComponent from './components/UpdateExcIEEEST5BComponent';
import ViewExcIEEEST5BComponent from './components/ViewExcIEEEST5BComponent';
import ListExcIEEEST6BComponent from './components/ListExcIEEEST6BComponent';
import CreateExcIEEEST6BComponent from './components/CreateExcIEEEST6BComponent';
import UpdateExcIEEEST6BComponent from './components/UpdateExcIEEEST6BComponent';
import ViewExcIEEEST6BComponent from './components/ViewExcIEEEST6BComponent';
import ListExcIEEEST7BComponent from './components/ListExcIEEEST7BComponent';
import CreateExcIEEEST7BComponent from './components/CreateExcIEEEST7BComponent';
import UpdateExcIEEEST7BComponent from './components/UpdateExcIEEEST7BComponent';
import ViewExcIEEEST7BComponent from './components/ViewExcIEEEST7BComponent';
import ListExcOEX3TComponent from './components/ListExcOEX3TComponent';
import CreateExcOEX3TComponent from './components/CreateExcOEX3TComponent';
import UpdateExcOEX3TComponent from './components/UpdateExcOEX3TComponent';
import ViewExcOEX3TComponent from './components/ViewExcOEX3TComponent';
import ListExcPICComponent from './components/ListExcPICComponent';
import CreateExcPICComponent from './components/CreateExcPICComponent';
import UpdateExcPICComponent from './components/UpdateExcPICComponent';
import ViewExcPICComponent from './components/ViewExcPICComponent';
import ListExcREXSComponent from './components/ListExcREXSComponent';
import CreateExcREXSComponent from './components/CreateExcREXSComponent';
import UpdateExcREXSComponent from './components/UpdateExcREXSComponent';
import ViewExcREXSComponent from './components/ViewExcREXSComponent';
import ListExcSCRXComponent from './components/ListExcSCRXComponent';
import CreateExcSCRXComponent from './components/CreateExcSCRXComponent';
import UpdateExcSCRXComponent from './components/UpdateExcSCRXComponent';
import ViewExcSCRXComponent from './components/ViewExcSCRXComponent';
import ListExcSEXSComponent from './components/ListExcSEXSComponent';
import CreateExcSEXSComponent from './components/CreateExcSEXSComponent';
import UpdateExcSEXSComponent from './components/UpdateExcSEXSComponent';
import ViewExcSEXSComponent from './components/ViewExcSEXSComponent';
import ListExcSKComponent from './components/ListExcSKComponent';
import CreateExcSKComponent from './components/CreateExcSKComponent';
import UpdateExcSKComponent from './components/UpdateExcSKComponent';
import ViewExcSKComponent from './components/ViewExcSKComponent';
import ListExcST1AComponent from './components/ListExcST1AComponent';
import CreateExcST1AComponent from './components/CreateExcST1AComponent';
import UpdateExcST1AComponent from './components/UpdateExcST1AComponent';
import ViewExcST1AComponent from './components/ViewExcST1AComponent';
import ListExcST2AComponent from './components/ListExcST2AComponent';
import CreateExcST2AComponent from './components/CreateExcST2AComponent';
import UpdateExcST2AComponent from './components/UpdateExcST2AComponent';
import ViewExcST2AComponent from './components/ViewExcST2AComponent';
import ListExcST3AComponent from './components/ListExcST3AComponent';
import CreateExcST3AComponent from './components/CreateExcST3AComponent';
import UpdateExcST3AComponent from './components/UpdateExcST3AComponent';
import ViewExcST3AComponent from './components/ViewExcST3AComponent';
import ListExcST4BComponent from './components/ListExcST4BComponent';
import CreateExcST4BComponent from './components/CreateExcST4BComponent';
import UpdateExcST4BComponent from './components/UpdateExcST4BComponent';
import ViewExcST4BComponent from './components/ViewExcST4BComponent';
import ListExcST6BComponent from './components/ListExcST6BComponent';
import CreateExcST6BComponent from './components/CreateExcST6BComponent';
import UpdateExcST6BComponent from './components/UpdateExcST6BComponent';
import ViewExcST6BComponent from './components/ViewExcST6BComponent';
import ListExcST7BComponent from './components/ListExcST7BComponent';
import CreateExcST7BComponent from './components/CreateExcST7BComponent';
import UpdateExcST7BComponent from './components/UpdateExcST7BComponent';
import ViewExcST7BComponent from './components/ViewExcST7BComponent';
import ListExcitationSystemUserDefinedComponent from './components/ListExcitationSystemUserDefinedComponent';
import CreateExcitationSystemUserDefinedComponent from './components/CreateExcitationSystemUserDefinedComponent';
import UpdateExcitationSystemUserDefinedComponent from './components/UpdateExcitationSystemUserDefinedComponent';
import ViewExcitationSystemUserDefinedComponent from './components/ViewExcitationSystemUserDefinedComponent';
import ListExtensionVersionComponent from './components/ListExtensionVersionComponent';
import CreateExtensionVersionComponent from './components/CreateExtensionVersionComponent';
import UpdateExtensionVersionComponent from './components/UpdateExtensionVersionComponent';
import ViewExtensionVersionComponent from './components/ViewExtensionVersionComponent';
import ListExternalNetworkInjectionComponent from './components/ListExternalNetworkInjectionComponent';
import CreateExternalNetworkInjectionComponent from './components/CreateExternalNetworkInjectionComponent';
import UpdateExternalNetworkInjectionComponent from './components/UpdateExternalNetworkInjectionComponent';
import ViewExternalNetworkInjectionComponent from './components/ViewExternalNetworkInjectionComponent';
import ListFossilFuelComponent from './components/ListFossilFuelComponent';
import CreateFossilFuelComponent from './components/CreateFossilFuelComponent';
import UpdateFossilFuelComponent from './components/UpdateFossilFuelComponent';
import ViewFossilFuelComponent from './components/ViewFossilFuelComponent';
import ListFrequencyComponent from './components/ListFrequencyComponent';
import CreateFrequencyComponent from './components/CreateFrequencyComponent';
import UpdateFrequencyComponent from './components/UpdateFrequencyComponent';
import ViewFrequencyComponent from './components/ViewFrequencyComponent';
import ListGenICompensationForGenJComponent from './components/ListGenICompensationForGenJComponent';
import CreateGenICompensationForGenJComponent from './components/CreateGenICompensationForGenJComponent';
import UpdateGenICompensationForGenJComponent from './components/UpdateGenICompensationForGenJComponent';
import ViewGenICompensationForGenJComponent from './components/ViewGenICompensationForGenJComponent';
import ListGeneratingUnitComponent from './components/ListGeneratingUnitComponent';
import CreateGeneratingUnitComponent from './components/CreateGeneratingUnitComponent';
import UpdateGeneratingUnitComponent from './components/UpdateGeneratingUnitComponent';
import ViewGeneratingUnitComponent from './components/ViewGeneratingUnitComponent';
import ListGeographicalLocationVersionComponent from './components/ListGeographicalLocationVersionComponent';
import CreateGeographicalLocationVersionComponent from './components/CreateGeographicalLocationVersionComponent';
import UpdateGeographicalLocationVersionComponent from './components/UpdateGeographicalLocationVersionComponent';
import ViewGeographicalLocationVersionComponent from './components/ViewGeographicalLocationVersionComponent';
import ListGovCT1Component from './components/ListGovCT1Component';
import CreateGovCT1Component from './components/CreateGovCT1Component';
import UpdateGovCT1Component from './components/UpdateGovCT1Component';
import ViewGovCT1Component from './components/ViewGovCT1Component';
import ListGovCT2Component from './components/ListGovCT2Component';
import CreateGovCT2Component from './components/CreateGovCT2Component';
import UpdateGovCT2Component from './components/UpdateGovCT2Component';
import ViewGovCT2Component from './components/ViewGovCT2Component';
import ListGovGASTComponent from './components/ListGovGASTComponent';
import CreateGovGASTComponent from './components/CreateGovGASTComponent';
import UpdateGovGASTComponent from './components/UpdateGovGASTComponent';
import ViewGovGASTComponent from './components/ViewGovGASTComponent';
import ListGovGAST1Component from './components/ListGovGAST1Component';
import CreateGovGAST1Component from './components/CreateGovGAST1Component';
import UpdateGovGAST1Component from './components/UpdateGovGAST1Component';
import ViewGovGAST1Component from './components/ViewGovGAST1Component';
import ListGovGAST2Component from './components/ListGovGAST2Component';
import CreateGovGAST2Component from './components/CreateGovGAST2Component';
import UpdateGovGAST2Component from './components/UpdateGovGAST2Component';
import ViewGovGAST2Component from './components/ViewGovGAST2Component';
import ListGovGAST3Component from './components/ListGovGAST3Component';
import CreateGovGAST3Component from './components/CreateGovGAST3Component';
import UpdateGovGAST3Component from './components/UpdateGovGAST3Component';
import ViewGovGAST3Component from './components/ViewGovGAST3Component';
import ListGovGAST4Component from './components/ListGovGAST4Component';
import CreateGovGAST4Component from './components/CreateGovGAST4Component';
import UpdateGovGAST4Component from './components/UpdateGovGAST4Component';
import ViewGovGAST4Component from './components/ViewGovGAST4Component';
import ListGovGASTWDComponent from './components/ListGovGASTWDComponent';
import CreateGovGASTWDComponent from './components/CreateGovGASTWDComponent';
import UpdateGovGASTWDComponent from './components/UpdateGovGASTWDComponent';
import ViewGovGASTWDComponent from './components/ViewGovGASTWDComponent';
import ListGovHydro1Component from './components/ListGovHydro1Component';
import CreateGovHydro1Component from './components/CreateGovHydro1Component';
import UpdateGovHydro1Component from './components/UpdateGovHydro1Component';
import ViewGovHydro1Component from './components/ViewGovHydro1Component';
import ListGovHydro2Component from './components/ListGovHydro2Component';
import CreateGovHydro2Component from './components/CreateGovHydro2Component';
import UpdateGovHydro2Component from './components/UpdateGovHydro2Component';
import ViewGovHydro2Component from './components/ViewGovHydro2Component';
import ListGovHydro3Component from './components/ListGovHydro3Component';
import CreateGovHydro3Component from './components/CreateGovHydro3Component';
import UpdateGovHydro3Component from './components/UpdateGovHydro3Component';
import ViewGovHydro3Component from './components/ViewGovHydro3Component';
import ListGovHydro4Component from './components/ListGovHydro4Component';
import CreateGovHydro4Component from './components/CreateGovHydro4Component';
import UpdateGovHydro4Component from './components/UpdateGovHydro4Component';
import ViewGovHydro4Component from './components/ViewGovHydro4Component';
import ListGovHydroDDComponent from './components/ListGovHydroDDComponent';
import CreateGovHydroDDComponent from './components/CreateGovHydroDDComponent';
import UpdateGovHydroDDComponent from './components/UpdateGovHydroDDComponent';
import ViewGovHydroDDComponent from './components/ViewGovHydroDDComponent';
import ListGovHydroFrancisComponent from './components/ListGovHydroFrancisComponent';
import CreateGovHydroFrancisComponent from './components/CreateGovHydroFrancisComponent';
import UpdateGovHydroFrancisComponent from './components/UpdateGovHydroFrancisComponent';
import ViewGovHydroFrancisComponent from './components/ViewGovHydroFrancisComponent';
import ListGovHydroIEEE0Component from './components/ListGovHydroIEEE0Component';
import CreateGovHydroIEEE0Component from './components/CreateGovHydroIEEE0Component';
import UpdateGovHydroIEEE0Component from './components/UpdateGovHydroIEEE0Component';
import ViewGovHydroIEEE0Component from './components/ViewGovHydroIEEE0Component';
import ListGovHydroIEEE2Component from './components/ListGovHydroIEEE2Component';
import CreateGovHydroIEEE2Component from './components/CreateGovHydroIEEE2Component';
import UpdateGovHydroIEEE2Component from './components/UpdateGovHydroIEEE2Component';
import ViewGovHydroIEEE2Component from './components/ViewGovHydroIEEE2Component';
import ListGovHydroPIDComponent from './components/ListGovHydroPIDComponent';
import CreateGovHydroPIDComponent from './components/CreateGovHydroPIDComponent';
import UpdateGovHydroPIDComponent from './components/UpdateGovHydroPIDComponent';
import ViewGovHydroPIDComponent from './components/ViewGovHydroPIDComponent';
import ListGovHydroPID2Component from './components/ListGovHydroPID2Component';
import CreateGovHydroPID2Component from './components/CreateGovHydroPID2Component';
import UpdateGovHydroPID2Component from './components/UpdateGovHydroPID2Component';
import ViewGovHydroPID2Component from './components/ViewGovHydroPID2Component';
import ListGovHydroPeltonComponent from './components/ListGovHydroPeltonComponent';
import CreateGovHydroPeltonComponent from './components/CreateGovHydroPeltonComponent';
import UpdateGovHydroPeltonComponent from './components/UpdateGovHydroPeltonComponent';
import ViewGovHydroPeltonComponent from './components/ViewGovHydroPeltonComponent';
import ListGovHydroRComponent from './components/ListGovHydroRComponent';
import CreateGovHydroRComponent from './components/CreateGovHydroRComponent';
import UpdateGovHydroRComponent from './components/UpdateGovHydroRComponent';
import ViewGovHydroRComponent from './components/ViewGovHydroRComponent';
import ListGovHydroWEHComponent from './components/ListGovHydroWEHComponent';
import CreateGovHydroWEHComponent from './components/CreateGovHydroWEHComponent';
import UpdateGovHydroWEHComponent from './components/UpdateGovHydroWEHComponent';
import ViewGovHydroWEHComponent from './components/ViewGovHydroWEHComponent';
import ListGovHydroWPIDComponent from './components/ListGovHydroWPIDComponent';
import CreateGovHydroWPIDComponent from './components/CreateGovHydroWPIDComponent';
import UpdateGovHydroWPIDComponent from './components/UpdateGovHydroWPIDComponent';
import ViewGovHydroWPIDComponent from './components/ViewGovHydroWPIDComponent';
import ListGovSteam0Component from './components/ListGovSteam0Component';
import CreateGovSteam0Component from './components/CreateGovSteam0Component';
import UpdateGovSteam0Component from './components/UpdateGovSteam0Component';
import ViewGovSteam0Component from './components/ViewGovSteam0Component';
import ListGovSteam1Component from './components/ListGovSteam1Component';
import CreateGovSteam1Component from './components/CreateGovSteam1Component';
import UpdateGovSteam1Component from './components/UpdateGovSteam1Component';
import ViewGovSteam1Component from './components/ViewGovSteam1Component';
import ListGovSteam2Component from './components/ListGovSteam2Component';
import CreateGovSteam2Component from './components/CreateGovSteam2Component';
import UpdateGovSteam2Component from './components/UpdateGovSteam2Component';
import ViewGovSteam2Component from './components/ViewGovSteam2Component';
import ListGovSteamCCComponent from './components/ListGovSteamCCComponent';
import CreateGovSteamCCComponent from './components/CreateGovSteamCCComponent';
import UpdateGovSteamCCComponent from './components/UpdateGovSteamCCComponent';
import ViewGovSteamCCComponent from './components/ViewGovSteamCCComponent';
import ListGovSteamEUComponent from './components/ListGovSteamEUComponent';
import CreateGovSteamEUComponent from './components/CreateGovSteamEUComponent';
import UpdateGovSteamEUComponent from './components/UpdateGovSteamEUComponent';
import ViewGovSteamEUComponent from './components/ViewGovSteamEUComponent';
import ListGovSteamFV2Component from './components/ListGovSteamFV2Component';
import CreateGovSteamFV2Component from './components/CreateGovSteamFV2Component';
import UpdateGovSteamFV2Component from './components/UpdateGovSteamFV2Component';
import ViewGovSteamFV2Component from './components/ViewGovSteamFV2Component';
import ListGovSteamFV3Component from './components/ListGovSteamFV3Component';
import CreateGovSteamFV3Component from './components/CreateGovSteamFV3Component';
import UpdateGovSteamFV3Component from './components/UpdateGovSteamFV3Component';
import ViewGovSteamFV3Component from './components/ViewGovSteamFV3Component';
import ListGovSteamFV4Component from './components/ListGovSteamFV4Component';
import CreateGovSteamFV4Component from './components/CreateGovSteamFV4Component';
import UpdateGovSteamFV4Component from './components/UpdateGovSteamFV4Component';
import ViewGovSteamFV4Component from './components/ViewGovSteamFV4Component';
import ListGovSteamIEEE1Component from './components/ListGovSteamIEEE1Component';
import CreateGovSteamIEEE1Component from './components/CreateGovSteamIEEE1Component';
import UpdateGovSteamIEEE1Component from './components/UpdateGovSteamIEEE1Component';
import ViewGovSteamIEEE1Component from './components/ViewGovSteamIEEE1Component';
import ListGovSteamSGOComponent from './components/ListGovSteamSGOComponent';
import CreateGovSteamSGOComponent from './components/CreateGovSteamSGOComponent';
import UpdateGovSteamSGOComponent from './components/UpdateGovSteamSGOComponent';
import ViewGovSteamSGOComponent from './components/ViewGovSteamSGOComponent';
import ListGroundingImpedanceComponent from './components/ListGroundingImpedanceComponent';
import CreateGroundingImpedanceComponent from './components/CreateGroundingImpedanceComponent';
import UpdateGroundingImpedanceComponent from './components/UpdateGroundingImpedanceComponent';
import ViewGroundingImpedanceComponent from './components/ViewGroundingImpedanceComponent';
import ListHydroGeneratingUnitComponent from './components/ListHydroGeneratingUnitComponent';
import CreateHydroGeneratingUnitComponent from './components/CreateHydroGeneratingUnitComponent';
import UpdateHydroGeneratingUnitComponent from './components/UpdateHydroGeneratingUnitComponent';
import ViewHydroGeneratingUnitComponent from './components/ViewHydroGeneratingUnitComponent';
import ListHydroPowerPlantComponent from './components/ListHydroPowerPlantComponent';
import CreateHydroPowerPlantComponent from './components/CreateHydroPowerPlantComponent';
import UpdateHydroPowerPlantComponent from './components/UpdateHydroPowerPlantComponent';
import ViewHydroPowerPlantComponent from './components/ViewHydroPowerPlantComponent';
import ListIdentifiedObjectComponent from './components/ListIdentifiedObjectComponent';
import CreateIdentifiedObjectComponent from './components/CreateIdentifiedObjectComponent';
import UpdateIdentifiedObjectComponent from './components/UpdateIdentifiedObjectComponent';
import ViewIdentifiedObjectComponent from './components/ViewIdentifiedObjectComponent';
import ListInductanceComponent from './components/ListInductanceComponent';
import CreateInductanceComponent from './components/CreateInductanceComponent';
import UpdateInductanceComponent from './components/UpdateInductanceComponent';
import ViewInductanceComponent from './components/ViewInductanceComponent';
import ListInductancePerLengthComponent from './components/ListInductancePerLengthComponent';
import CreateInductancePerLengthComponent from './components/CreateInductancePerLengthComponent';
import UpdateInductancePerLengthComponent from './components/UpdateInductancePerLengthComponent';
import ViewInductancePerLengthComponent from './components/ViewInductancePerLengthComponent';
import ListLengthComponent from './components/ListLengthComponent';
import CreateLengthComponent from './components/CreateLengthComponent';
import UpdateLengthComponent from './components/UpdateLengthComponent';
import ViewLengthComponent from './components/ViewLengthComponent';
import ListLimitSetComponent from './components/ListLimitSetComponent';
import CreateLimitSetComponent from './components/CreateLimitSetComponent';
import UpdateLimitSetComponent from './components/UpdateLimitSetComponent';
import ViewLimitSetComponent from './components/ViewLimitSetComponent';
import ListLinearShuntCompensatorComponent from './components/ListLinearShuntCompensatorComponent';
import CreateLinearShuntCompensatorComponent from './components/CreateLinearShuntCompensatorComponent';
import UpdateLinearShuntCompensatorComponent from './components/UpdateLinearShuntCompensatorComponent';
import ViewLinearShuntCompensatorComponent from './components/ViewLinearShuntCompensatorComponent';
import ListLoadCompositeComponent from './components/ListLoadCompositeComponent';
import CreateLoadCompositeComponent from './components/CreateLoadCompositeComponent';
import UpdateLoadCompositeComponent from './components/UpdateLoadCompositeComponent';
import ViewLoadCompositeComponent from './components/ViewLoadCompositeComponent';
import ListLoadGenericNonLinearComponent from './components/ListLoadGenericNonLinearComponent';
import CreateLoadGenericNonLinearComponent from './components/CreateLoadGenericNonLinearComponent';
import UpdateLoadGenericNonLinearComponent from './components/UpdateLoadGenericNonLinearComponent';
import ViewLoadGenericNonLinearComponent from './components/ViewLoadGenericNonLinearComponent';
import ListLoadMotorComponent from './components/ListLoadMotorComponent';
import CreateLoadMotorComponent from './components/CreateLoadMotorComponent';
import UpdateLoadMotorComponent from './components/UpdateLoadMotorComponent';
import ViewLoadMotorComponent from './components/ViewLoadMotorComponent';
import ListLoadResponseCharacteristicComponent from './components/ListLoadResponseCharacteristicComponent';
import CreateLoadResponseCharacteristicComponent from './components/CreateLoadResponseCharacteristicComponent';
import UpdateLoadResponseCharacteristicComponent from './components/UpdateLoadResponseCharacteristicComponent';
import ViewLoadResponseCharacteristicComponent from './components/ViewLoadResponseCharacteristicComponent';
import ListLoadStaticComponent from './components/ListLoadStaticComponent';
import CreateLoadStaticComponent from './components/CreateLoadStaticComponent';
import UpdateLoadStaticComponent from './components/UpdateLoadStaticComponent';
import ViewLoadStaticComponent from './components/ViewLoadStaticComponent';
import ListLoadUserDefinedComponent from './components/ListLoadUserDefinedComponent';
import CreateLoadUserDefinedComponent from './components/CreateLoadUserDefinedComponent';
import UpdateLoadUserDefinedComponent from './components/UpdateLoadUserDefinedComponent';
import ViewLoadUserDefinedComponent from './components/ViewLoadUserDefinedComponent';
import ListMeasurementComponent from './components/ListMeasurementComponent';
import CreateMeasurementComponent from './components/CreateMeasurementComponent';
import UpdateMeasurementComponent from './components/UpdateMeasurementComponent';
import ViewMeasurementComponent from './components/ViewMeasurementComponent';
import ListMeasurementValueComponent from './components/ListMeasurementValueComponent';
import CreateMeasurementValueComponent from './components/CreateMeasurementValueComponent';
import UpdateMeasurementValueComponent from './components/UpdateMeasurementValueComponent';
import ViewMeasurementValueComponent from './components/ViewMeasurementValueComponent';
import ListMechLoad1Component from './components/ListMechLoad1Component';
import CreateMechLoad1Component from './components/CreateMechLoad1Component';
import UpdateMechLoad1Component from './components/UpdateMechLoad1Component';
import ViewMechLoad1Component from './components/ViewMechLoad1Component';
import ListMechanicalLoadUserDefinedComponent from './components/ListMechanicalLoadUserDefinedComponent';
import CreateMechanicalLoadUserDefinedComponent from './components/CreateMechanicalLoadUserDefinedComponent';
import UpdateMechanicalLoadUserDefinedComponent from './components/UpdateMechanicalLoadUserDefinedComponent';
import ViewMechanicalLoadUserDefinedComponent from './components/ViewMechanicalLoadUserDefinedComponent';
import ListMoneyComponent from './components/ListMoneyComponent';
import CreateMoneyComponent from './components/CreateMoneyComponent';
import UpdateMoneyComponent from './components/UpdateMoneyComponent';
import ViewMoneyComponent from './components/ViewMoneyComponent';
import ListMonthDayIntervalComponent from './components/ListMonthDayIntervalComponent';
import CreateMonthDayIntervalComponent from './components/CreateMonthDayIntervalComponent';
import UpdateMonthDayIntervalComponent from './components/UpdateMonthDayIntervalComponent';
import ViewMonthDayIntervalComponent from './components/ViewMonthDayIntervalComponent';
import ListMutualCouplingComponent from './components/ListMutualCouplingComponent';
import CreateMutualCouplingComponent from './components/CreateMutualCouplingComponent';
import UpdateMutualCouplingComponent from './components/UpdateMutualCouplingComponent';
import ViewMutualCouplingComponent from './components/ViewMutualCouplingComponent';
import ListNonlinearShuntCompensatorPointComponent from './components/ListNonlinearShuntCompensatorPointComponent';
import CreateNonlinearShuntCompensatorPointComponent from './components/CreateNonlinearShuntCompensatorPointComponent';
import UpdateNonlinearShuntCompensatorPointComponent from './components/UpdateNonlinearShuntCompensatorPointComponent';
import ViewNonlinearShuntCompensatorPointComponent from './components/ViewNonlinearShuntCompensatorPointComponent';
import ListOperationalLimitTypeComponent from './components/ListOperationalLimitTypeComponent';
import CreateOperationalLimitTypeComponent from './components/CreateOperationalLimitTypeComponent';
import UpdateOperationalLimitTypeComponent from './components/UpdateOperationalLimitTypeComponent';
import ViewOperationalLimitTypeComponent from './components/ViewOperationalLimitTypeComponent';
import ListOverexcLim2Component from './components/ListOverexcLim2Component';
import CreateOverexcLim2Component from './components/CreateOverexcLim2Component';
import UpdateOverexcLim2Component from './components/UpdateOverexcLim2Component';
import ViewOverexcLim2Component from './components/ViewOverexcLim2Component';
import ListOverexcLimIEEEComponent from './components/ListOverexcLimIEEEComponent';
import CreateOverexcLimIEEEComponent from './components/CreateOverexcLimIEEEComponent';
import UpdateOverexcLimIEEEComponent from './components/UpdateOverexcLimIEEEComponent';
import ViewOverexcLimIEEEComponent from './components/ViewOverexcLimIEEEComponent';
import ListOverexcLimX1Component from './components/ListOverexcLimX1Component';
import CreateOverexcLimX1Component from './components/CreateOverexcLimX1Component';
import UpdateOverexcLimX1Component from './components/UpdateOverexcLimX1Component';
import ViewOverexcLimX1Component from './components/ViewOverexcLimX1Component';
import ListOverexcLimX2Component from './components/ListOverexcLimX2Component';
import CreateOverexcLimX2Component from './components/CreateOverexcLimX2Component';
import UpdateOverexcLimX2Component from './components/UpdateOverexcLimX2Component';
import ViewOverexcLimX2Component from './components/ViewOverexcLimX2Component';
import ListOverexcitationLimiterUserDefinedComponent from './components/ListOverexcitationLimiterUserDefinedComponent';
import CreateOverexcitationLimiterUserDefinedComponent from './components/CreateOverexcitationLimiterUserDefinedComponent';
import UpdateOverexcitationLimiterUserDefinedComponent from './components/UpdateOverexcitationLimiterUserDefinedComponent';
import ViewOverexcitationLimiterUserDefinedComponent from './components/ViewOverexcitationLimiterUserDefinedComponent';
import ListPFVArControllerType1UserDefinedComponent from './components/ListPFVArControllerType1UserDefinedComponent';
import CreatePFVArControllerType1UserDefinedComponent from './components/CreatePFVArControllerType1UserDefinedComponent';
import UpdatePFVArControllerType1UserDefinedComponent from './components/UpdatePFVArControllerType1UserDefinedComponent';
import ViewPFVArControllerType1UserDefinedComponent from './components/ViewPFVArControllerType1UserDefinedComponent';
import ListPFVArControllerType2UserDefinedComponent from './components/ListPFVArControllerType2UserDefinedComponent';
import CreatePFVArControllerType2UserDefinedComponent from './components/CreatePFVArControllerType2UserDefinedComponent';
import UpdatePFVArControllerType2UserDefinedComponent from './components/UpdatePFVArControllerType2UserDefinedComponent';
import ViewPFVArControllerType2UserDefinedComponent from './components/ViewPFVArControllerType2UserDefinedComponent';
import ListPFVArType1IEEEPFControllerComponent from './components/ListPFVArType1IEEEPFControllerComponent';
import CreatePFVArType1IEEEPFControllerComponent from './components/CreatePFVArType1IEEEPFControllerComponent';
import UpdatePFVArType1IEEEPFControllerComponent from './components/UpdatePFVArType1IEEEPFControllerComponent';
import ViewPFVArType1IEEEPFControllerComponent from './components/ViewPFVArType1IEEEPFControllerComponent';
import ListPFVArType1IEEEVArControllerComponent from './components/ListPFVArType1IEEEVArControllerComponent';
import CreatePFVArType1IEEEVArControllerComponent from './components/CreatePFVArType1IEEEVArControllerComponent';
import UpdatePFVArType1IEEEVArControllerComponent from './components/UpdatePFVArType1IEEEVArControllerComponent';
import ViewPFVArType1IEEEVArControllerComponent from './components/ViewPFVArType1IEEEVArControllerComponent';
import ListPFVArType2Common1Component from './components/ListPFVArType2Common1Component';
import CreatePFVArType2Common1Component from './components/CreatePFVArType2Common1Component';
import UpdatePFVArType2Common1Component from './components/UpdatePFVArType2Common1Component';
import ViewPFVArType2Common1Component from './components/ViewPFVArType2Common1Component';
import ListPFVArType2IEEEPFControllerComponent from './components/ListPFVArType2IEEEPFControllerComponent';
import CreatePFVArType2IEEEPFControllerComponent from './components/CreatePFVArType2IEEEPFControllerComponent';
import UpdatePFVArType2IEEEPFControllerComponent from './components/UpdatePFVArType2IEEEPFControllerComponent';
import ViewPFVArType2IEEEPFControllerComponent from './components/ViewPFVArType2IEEEPFControllerComponent';
import ListPFVArType2IEEEVArControllerComponent from './components/ListPFVArType2IEEEVArControllerComponent';
import CreatePFVArType2IEEEVArControllerComponent from './components/CreatePFVArType2IEEEVArControllerComponent';
import UpdatePFVArType2IEEEVArControllerComponent from './components/UpdatePFVArType2IEEEVArControllerComponent';
import ViewPFVArType2IEEEVArControllerComponent from './components/ViewPFVArType2IEEEVArControllerComponent';
import ListPUComponent from './components/ListPUComponent';
import CreatePUComponent from './components/CreatePUComponent';
import UpdatePUComponent from './components/UpdatePUComponent';
import ViewPUComponent from './components/ViewPUComponent';
import ListPerCentComponent from './components/ListPerCentComponent';
import CreatePerCentComponent from './components/CreatePerCentComponent';
import UpdatePerCentComponent from './components/UpdatePerCentComponent';
import ViewPerCentComponent from './components/ViewPerCentComponent';
import ListPerLengthDCLineParameterComponent from './components/ListPerLengthDCLineParameterComponent';
import CreatePerLengthDCLineParameterComponent from './components/CreatePerLengthDCLineParameterComponent';
import UpdatePerLengthDCLineParameterComponent from './components/UpdatePerLengthDCLineParameterComponent';
import ViewPerLengthDCLineParameterComponent from './components/ViewPerLengthDCLineParameterComponent';
import ListPetersenCoilComponent from './components/ListPetersenCoilComponent';
import CreatePetersenCoilComponent from './components/CreatePetersenCoilComponent';
import UpdatePetersenCoilComponent from './components/UpdatePetersenCoilComponent';
import ViewPetersenCoilComponent from './components/ViewPetersenCoilComponent';
import ListPhaseTapChangerAsymmetricalComponent from './components/ListPhaseTapChangerAsymmetricalComponent';
import CreatePhaseTapChangerAsymmetricalComponent from './components/CreatePhaseTapChangerAsymmetricalComponent';
import UpdatePhaseTapChangerAsymmetricalComponent from './components/UpdatePhaseTapChangerAsymmetricalComponent';
import ViewPhaseTapChangerAsymmetricalComponent from './components/ViewPhaseTapChangerAsymmetricalComponent';
import ListPhaseTapChangerLinearComponent from './components/ListPhaseTapChangerLinearComponent';
import CreatePhaseTapChangerLinearComponent from './components/CreatePhaseTapChangerLinearComponent';
import UpdatePhaseTapChangerLinearComponent from './components/UpdatePhaseTapChangerLinearComponent';
import ViewPhaseTapChangerLinearComponent from './components/ViewPhaseTapChangerLinearComponent';
import ListPhaseTapChangerNonLinearComponent from './components/ListPhaseTapChangerNonLinearComponent';
import CreatePhaseTapChangerNonLinearComponent from './components/CreatePhaseTapChangerNonLinearComponent';
import UpdatePhaseTapChangerNonLinearComponent from './components/UpdatePhaseTapChangerNonLinearComponent';
import ViewPhaseTapChangerNonLinearComponent from './components/ViewPhaseTapChangerNonLinearComponent';
import ListPhaseTapChangerTablePointComponent from './components/ListPhaseTapChangerTablePointComponent';
import CreatePhaseTapChangerTablePointComponent from './components/CreatePhaseTapChangerTablePointComponent';
import UpdatePhaseTapChangerTablePointComponent from './components/UpdatePhaseTapChangerTablePointComponent';
import ViewPhaseTapChangerTablePointComponent from './components/ViewPhaseTapChangerTablePointComponent';
import ListPositionPointComponent from './components/ListPositionPointComponent';
import CreatePositionPointComponent from './components/CreatePositionPointComponent';
import UpdatePositionPointComponent from './components/UpdatePositionPointComponent';
import ViewPositionPointComponent from './components/ViewPositionPointComponent';
import ListPowerSystemStabilizerUserDefinedComponent from './components/ListPowerSystemStabilizerUserDefinedComponent';
import CreatePowerSystemStabilizerUserDefinedComponent from './components/CreatePowerSystemStabilizerUserDefinedComponent';
import UpdatePowerSystemStabilizerUserDefinedComponent from './components/UpdatePowerSystemStabilizerUserDefinedComponent';
import ViewPowerSystemStabilizerUserDefinedComponent from './components/ViewPowerSystemStabilizerUserDefinedComponent';
import ListPowerTransformerComponent from './components/ListPowerTransformerComponent';
import CreatePowerTransformerComponent from './components/CreatePowerTransformerComponent';
import UpdatePowerTransformerComponent from './components/UpdatePowerTransformerComponent';
import ViewPowerTransformerComponent from './components/ViewPowerTransformerComponent';
import ListPowerTransformerEndComponent from './components/ListPowerTransformerEndComponent';
import CreatePowerTransformerEndComponent from './components/CreatePowerTransformerEndComponent';
import UpdatePowerTransformerEndComponent from './components/UpdatePowerTransformerEndComponent';
import ViewPowerTransformerEndComponent from './components/ViewPowerTransformerEndComponent';
import ListProprietaryParameterDynamicsComponent from './components/ListProprietaryParameterDynamicsComponent';
import CreateProprietaryParameterDynamicsComponent from './components/CreateProprietaryParameterDynamicsComponent';
import UpdateProprietaryParameterDynamicsComponent from './components/UpdateProprietaryParameterDynamicsComponent';
import ViewProprietaryParameterDynamicsComponent from './components/ViewProprietaryParameterDynamicsComponent';
import ListPss1Component from './components/ListPss1Component';
import CreatePss1Component from './components/CreatePss1Component';
import UpdatePss1Component from './components/UpdatePss1Component';
import ViewPss1Component from './components/ViewPss1Component';
import ListPss1AComponent from './components/ListPss1AComponent';
import CreatePss1AComponent from './components/CreatePss1AComponent';
import UpdatePss1AComponent from './components/UpdatePss1AComponent';
import ViewPss1AComponent from './components/ViewPss1AComponent';
import ListPss2BComponent from './components/ListPss2BComponent';
import CreatePss2BComponent from './components/CreatePss2BComponent';
import UpdatePss2BComponent from './components/UpdatePss2BComponent';
import ViewPss2BComponent from './components/ViewPss2BComponent';
import ListPss2STComponent from './components/ListPss2STComponent';
import CreatePss2STComponent from './components/CreatePss2STComponent';
import UpdatePss2STComponent from './components/UpdatePss2STComponent';
import ViewPss2STComponent from './components/ViewPss2STComponent';
import ListPss5Component from './components/ListPss5Component';
import CreatePss5Component from './components/CreatePss5Component';
import UpdatePss5Component from './components/UpdatePss5Component';
import ViewPss5Component from './components/ViewPss5Component';
import ListPssELIN2Component from './components/ListPssELIN2Component';
import CreatePssELIN2Component from './components/CreatePssELIN2Component';
import UpdatePssELIN2Component from './components/UpdatePssELIN2Component';
import ViewPssELIN2Component from './components/ViewPssELIN2Component';
import ListPssIEEE1AComponent from './components/ListPssIEEE1AComponent';
import CreatePssIEEE1AComponent from './components/CreatePssIEEE1AComponent';
import UpdatePssIEEE1AComponent from './components/UpdatePssIEEE1AComponent';
import ViewPssIEEE1AComponent from './components/ViewPssIEEE1AComponent';
import ListPssIEEE2BComponent from './components/ListPssIEEE2BComponent';
import CreatePssIEEE2BComponent from './components/CreatePssIEEE2BComponent';
import UpdatePssIEEE2BComponent from './components/UpdatePssIEEE2BComponent';
import ViewPssIEEE2BComponent from './components/ViewPssIEEE2BComponent';
import ListPssIEEE3BComponent from './components/ListPssIEEE3BComponent';
import CreatePssIEEE3BComponent from './components/CreatePssIEEE3BComponent';
import UpdatePssIEEE3BComponent from './components/UpdatePssIEEE3BComponent';
import ViewPssIEEE3BComponent from './components/ViewPssIEEE3BComponent';
import ListPssIEEE4BComponent from './components/ListPssIEEE4BComponent';
import CreatePssIEEE4BComponent from './components/CreatePssIEEE4BComponent';
import UpdatePssIEEE4BComponent from './components/UpdatePssIEEE4BComponent';
import ViewPssIEEE4BComponent from './components/ViewPssIEEE4BComponent';
import ListPssPTIST1Component from './components/ListPssPTIST1Component';
import CreatePssPTIST1Component from './components/CreatePssPTIST1Component';
import UpdatePssPTIST1Component from './components/UpdatePssPTIST1Component';
import ViewPssPTIST1Component from './components/ViewPssPTIST1Component';
import ListPssPTIST3Component from './components/ListPssPTIST3Component';
import CreatePssPTIST3Component from './components/CreatePssPTIST3Component';
import UpdatePssPTIST3Component from './components/UpdatePssPTIST3Component';
import ViewPssPTIST3Component from './components/ViewPssPTIST3Component';
import ListPssSB4Component from './components/ListPssSB4Component';
import CreatePssSB4Component from './components/CreatePssSB4Component';
import UpdatePssSB4Component from './components/UpdatePssSB4Component';
import ViewPssSB4Component from './components/ViewPssSB4Component';
import ListPssSHComponent from './components/ListPssSHComponent';
import CreatePssSHComponent from './components/CreatePssSHComponent';
import UpdatePssSHComponent from './components/UpdatePssSHComponent';
import ViewPssSHComponent from './components/ViewPssSHComponent';
import ListPssSKComponent from './components/ListPssSKComponent';
import CreatePssSKComponent from './components/CreatePssSKComponent';
import UpdatePssSKComponent from './components/UpdatePssSKComponent';
import ViewPssSKComponent from './components/ViewPssSKComponent';
import ListPssWECCComponent from './components/ListPssWECCComponent';
import CreatePssWECCComponent from './components/CreatePssWECCComponent';
import UpdatePssWECCComponent from './components/UpdatePssWECCComponent';
import ViewPssWECCComponent from './components/ViewPssWECCComponent';
import ListQuality61850Component from './components/ListQuality61850Component';
import CreateQuality61850Component from './components/CreateQuality61850Component';
import UpdateQuality61850Component from './components/UpdateQuality61850Component';
import ViewQuality61850Component from './components/ViewQuality61850Component';
import ListRatioTapChangerComponent from './components/ListRatioTapChangerComponent';
import CreateRatioTapChangerComponent from './components/CreateRatioTapChangerComponent';
import UpdateRatioTapChangerComponent from './components/UpdateRatioTapChangerComponent';
import ViewRatioTapChangerComponent from './components/ViewRatioTapChangerComponent';
import ListReactanceComponent from './components/ListReactanceComponent';
import CreateReactanceComponent from './components/CreateReactanceComponent';
import UpdateReactanceComponent from './components/UpdateReactanceComponent';
import ViewReactanceComponent from './components/ViewReactanceComponent';
import ListReactivePowerComponent from './components/ListReactivePowerComponent';
import CreateReactivePowerComponent from './components/CreateReactivePowerComponent';
import UpdateReactivePowerComponent from './components/UpdateReactivePowerComponent';
import ViewReactivePowerComponent from './components/ViewReactivePowerComponent';
import ListRegularIntervalScheduleComponent from './components/ListRegularIntervalScheduleComponent';
import CreateRegularIntervalScheduleComponent from './components/CreateRegularIntervalScheduleComponent';
import UpdateRegularIntervalScheduleComponent from './components/UpdateRegularIntervalScheduleComponent';
import ViewRegularIntervalScheduleComponent from './components/ViewRegularIntervalScheduleComponent';
import ListRegularTimePointComponent from './components/ListRegularTimePointComponent';
import CreateRegularTimePointComponent from './components/CreateRegularTimePointComponent';
import UpdateRegularTimePointComponent from './components/UpdateRegularTimePointComponent';
import ViewRegularTimePointComponent from './components/ViewRegularTimePointComponent';
import ListRegulatingControlComponent from './components/ListRegulatingControlComponent';
import CreateRegulatingControlComponent from './components/CreateRegulatingControlComponent';
import UpdateRegulatingControlComponent from './components/UpdateRegulatingControlComponent';
import ViewRegulatingControlComponent from './components/ViewRegulatingControlComponent';
import ListRemoteInputSignalComponent from './components/ListRemoteInputSignalComponent';
import CreateRemoteInputSignalComponent from './components/CreateRemoteInputSignalComponent';
import UpdateRemoteInputSignalComponent from './components/UpdateRemoteInputSignalComponent';
import ViewRemoteInputSignalComponent from './components/ViewRemoteInputSignalComponent';
import ListResistanceComponent from './components/ListResistanceComponent';
import CreateResistanceComponent from './components/CreateResistanceComponent';
import UpdateResistanceComponent from './components/UpdateResistanceComponent';
import ViewResistanceComponent from './components/ViewResistanceComponent';
import ListResistancePerLengthComponent from './components/ListResistancePerLengthComponent';
import CreateResistancePerLengthComponent from './components/CreateResistancePerLengthComponent';
import UpdateResistancePerLengthComponent from './components/UpdateResistancePerLengthComponent';
import ViewResistancePerLengthComponent from './components/ViewResistancePerLengthComponent';
import ListRotatingMachineComponent from './components/ListRotatingMachineComponent';
import CreateRotatingMachineComponent from './components/CreateRotatingMachineComponent';
import UpdateRotatingMachineComponent from './components/UpdateRotatingMachineComponent';
import ViewRotatingMachineComponent from './components/ViewRotatingMachineComponent';
import ListRotatingMachineDynamicsComponent from './components/ListRotatingMachineDynamicsComponent';
import CreateRotatingMachineDynamicsComponent from './components/CreateRotatingMachineDynamicsComponent';
import UpdateRotatingMachineDynamicsComponent from './components/UpdateRotatingMachineDynamicsComponent';
import ViewRotatingMachineDynamicsComponent from './components/ViewRotatingMachineDynamicsComponent';
import ListRotationSpeedComponent from './components/ListRotationSpeedComponent';
import CreateRotationSpeedComponent from './components/CreateRotationSpeedComponent';
import UpdateRotationSpeedComponent from './components/UpdateRotationSpeedComponent';
import ViewRotationSpeedComponent from './components/ViewRotationSpeedComponent';
import ListSeasonComponent from './components/ListSeasonComponent';
import CreateSeasonComponent from './components/CreateSeasonComponent';
import UpdateSeasonComponent from './components/UpdateSeasonComponent';
import ViewSeasonComponent from './components/ViewSeasonComponent';
import ListSecondsComponent from './components/ListSecondsComponent';
import CreateSecondsComponent from './components/CreateSecondsComponent';
import UpdateSecondsComponent from './components/UpdateSecondsComponent';
import ViewSecondsComponent from './components/ViewSecondsComponent';
import ListSeriesCompensatorComponent from './components/ListSeriesCompensatorComponent';
import CreateSeriesCompensatorComponent from './components/CreateSeriesCompensatorComponent';
import UpdateSeriesCompensatorComponent from './components/UpdateSeriesCompensatorComponent';
import ViewSeriesCompensatorComponent from './components/ViewSeriesCompensatorComponent';
import ListSetPointComponent from './components/ListSetPointComponent';
import CreateSetPointComponent from './components/CreateSetPointComponent';
import UpdateSetPointComponent from './components/UpdateSetPointComponent';
import ViewSetPointComponent from './components/ViewSetPointComponent';
import ListShuntCompensatorComponent from './components/ListShuntCompensatorComponent';
import CreateShuntCompensatorComponent from './components/CreateShuntCompensatorComponent';
import UpdateShuntCompensatorComponent from './components/UpdateShuntCompensatorComponent';
import ViewShuntCompensatorComponent from './components/ViewShuntCompensatorComponent';
import ListSimple_FloatComponent from './components/ListSimple_FloatComponent';
import CreateSimple_FloatComponent from './components/CreateSimple_FloatComponent';
import UpdateSimple_FloatComponent from './components/UpdateSimple_FloatComponent';
import ViewSimple_FloatComponent from './components/ViewSimple_FloatComponent';
import ListStateVariablesVersionComponent from './components/ListStateVariablesVersionComponent';
import CreateStateVariablesVersionComponent from './components/CreateStateVariablesVersionComponent';
import UpdateStateVariablesVersionComponent from './components/UpdateStateVariablesVersionComponent';
import ViewStateVariablesVersionComponent from './components/ViewStateVariablesVersionComponent';
import ListStaticVarCompensatorComponent from './components/ListStaticVarCompensatorComponent';
import CreateStaticVarCompensatorComponent from './components/CreateStaticVarCompensatorComponent';
import UpdateStaticVarCompensatorComponent from './components/UpdateStaticVarCompensatorComponent';
import ViewStaticVarCompensatorComponent from './components/ViewStaticVarCompensatorComponent';
import ListSteadyStateHypothesisVersionComponent from './components/ListSteadyStateHypothesisVersionComponent';
import CreateSteadyStateHypothesisVersionComponent from './components/CreateSteadyStateHypothesisVersionComponent';
import UpdateSteadyStateHypothesisVersionComponent from './components/UpdateSteadyStateHypothesisVersionComponent';
import ViewSteadyStateHypothesisVersionComponent from './components/ViewSteadyStateHypothesisVersionComponent';
import ListStringMeasurementValueComponent from './components/ListStringMeasurementValueComponent';
import CreateStringMeasurementValueComponent from './components/CreateStringMeasurementValueComponent';
import UpdateStringMeasurementValueComponent from './components/UpdateStringMeasurementValueComponent';
import ViewStringMeasurementValueComponent from './components/ViewStringMeasurementValueComponent';
import ListSusceptanceComponent from './components/ListSusceptanceComponent';
import CreateSusceptanceComponent from './components/CreateSusceptanceComponent';
import UpdateSusceptanceComponent from './components/UpdateSusceptanceComponent';
import ViewSusceptanceComponent from './components/ViewSusceptanceComponent';
import ListSvInjectionComponent from './components/ListSvInjectionComponent';
import CreateSvInjectionComponent from './components/CreateSvInjectionComponent';
import UpdateSvInjectionComponent from './components/UpdateSvInjectionComponent';
import ViewSvInjectionComponent from './components/ViewSvInjectionComponent';
import ListSvPowerFlowComponent from './components/ListSvPowerFlowComponent';
import CreateSvPowerFlowComponent from './components/CreateSvPowerFlowComponent';
import UpdateSvPowerFlowComponent from './components/UpdateSvPowerFlowComponent';
import ViewSvPowerFlowComponent from './components/ViewSvPowerFlowComponent';
import ListSvShuntCompensatorSectionsComponent from './components/ListSvShuntCompensatorSectionsComponent';
import CreateSvShuntCompensatorSectionsComponent from './components/CreateSvShuntCompensatorSectionsComponent';
import UpdateSvShuntCompensatorSectionsComponent from './components/UpdateSvShuntCompensatorSectionsComponent';
import ViewSvShuntCompensatorSectionsComponent from './components/ViewSvShuntCompensatorSectionsComponent';
import ListSvStatusComponent from './components/ListSvStatusComponent';
import CreateSvStatusComponent from './components/CreateSvStatusComponent';
import UpdateSvStatusComponent from './components/UpdateSvStatusComponent';
import ViewSvStatusComponent from './components/ViewSvStatusComponent';
import ListSvTapStepComponent from './components/ListSvTapStepComponent';
import CreateSvTapStepComponent from './components/CreateSvTapStepComponent';
import UpdateSvTapStepComponent from './components/UpdateSvTapStepComponent';
import ViewSvTapStepComponent from './components/ViewSvTapStepComponent';
import ListSvVoltageComponent from './components/ListSvVoltageComponent';
import CreateSvVoltageComponent from './components/CreateSvVoltageComponent';
import UpdateSvVoltageComponent from './components/UpdateSvVoltageComponent';
import ViewSvVoltageComponent from './components/ViewSvVoltageComponent';
import ListSwitchItComponent from './components/ListSwitchItComponent';
import CreateSwitchItComponent from './components/CreateSwitchItComponent';
import UpdateSwitchItComponent from './components/UpdateSwitchItComponent';
import ViewSwitchItComponent from './components/ViewSwitchItComponent';
import ListSwitchProxyComponent from './components/ListSwitchProxyComponent';
import CreateSwitchProxyComponent from './components/CreateSwitchProxyComponent';
import UpdateSwitchProxyComponent from './components/UpdateSwitchProxyComponent';
import ViewSwitchProxyComponent from './components/ViewSwitchProxyComponent';
import ListSynchronousMachineComponent from './components/ListSynchronousMachineComponent';
import CreateSynchronousMachineComponent from './components/CreateSynchronousMachineComponent';
import UpdateSynchronousMachineComponent from './components/UpdateSynchronousMachineComponent';
import ViewSynchronousMachineComponent from './components/ViewSynchronousMachineComponent';
import ListSynchronousMachineDetailedComponent from './components/ListSynchronousMachineDetailedComponent';
import CreateSynchronousMachineDetailedComponent from './components/CreateSynchronousMachineDetailedComponent';
import UpdateSynchronousMachineDetailedComponent from './components/UpdateSynchronousMachineDetailedComponent';
import ViewSynchronousMachineDetailedComponent from './components/ViewSynchronousMachineDetailedComponent';
import ListSynchronousMachineEquivalentCircuitComponent from './components/ListSynchronousMachineEquivalentCircuitComponent';
import CreateSynchronousMachineEquivalentCircuitComponent from './components/CreateSynchronousMachineEquivalentCircuitComponent';
import UpdateSynchronousMachineEquivalentCircuitComponent from './components/UpdateSynchronousMachineEquivalentCircuitComponent';
import ViewSynchronousMachineEquivalentCircuitComponent from './components/ViewSynchronousMachineEquivalentCircuitComponent';
import ListSynchronousMachineTimeConstantReactanceComponent from './components/ListSynchronousMachineTimeConstantReactanceComponent';
import CreateSynchronousMachineTimeConstantReactanceComponent from './components/CreateSynchronousMachineTimeConstantReactanceComponent';
import UpdateSynchronousMachineTimeConstantReactanceComponent from './components/UpdateSynchronousMachineTimeConstantReactanceComponent';
import ViewSynchronousMachineTimeConstantReactanceComponent from './components/ViewSynchronousMachineTimeConstantReactanceComponent';
import ListSynchronousMachineUserDefinedComponent from './components/ListSynchronousMachineUserDefinedComponent';
import CreateSynchronousMachineUserDefinedComponent from './components/CreateSynchronousMachineUserDefinedComponent';
import UpdateSynchronousMachineUserDefinedComponent from './components/UpdateSynchronousMachineUserDefinedComponent';
import ViewSynchronousMachineUserDefinedComponent from './components/ViewSynchronousMachineUserDefinedComponent';
import ListTapChangerComponent from './components/ListTapChangerComponent';
import CreateTapChangerComponent from './components/CreateTapChangerComponent';
import UpdateTapChangerComponent from './components/UpdateTapChangerComponent';
import ViewTapChangerComponent from './components/ViewTapChangerComponent';
import ListTapChangerTablePointComponent from './components/ListTapChangerTablePointComponent';
import CreateTapChangerTablePointComponent from './components/CreateTapChangerTablePointComponent';
import UpdateTapChangerTablePointComponent from './components/UpdateTapChangerTablePointComponent';
import ViewTapChangerTablePointComponent from './components/ViewTapChangerTablePointComponent';
import ListTemperatureComponent from './components/ListTemperatureComponent';
import CreateTemperatureComponent from './components/CreateTemperatureComponent';
import UpdateTemperatureComponent from './components/UpdateTemperatureComponent';
import ViewTemperatureComponent from './components/ViewTemperatureComponent';
import ListTextDiagramObjectComponent from './components/ListTextDiagramObjectComponent';
import CreateTextDiagramObjectComponent from './components/CreateTextDiagramObjectComponent';
import UpdateTextDiagramObjectComponent from './components/UpdateTextDiagramObjectComponent';
import ViewTextDiagramObjectComponent from './components/ViewTextDiagramObjectComponent';
import ListTieFlowComponent from './components/ListTieFlowComponent';
import CreateTieFlowComponent from './components/CreateTieFlowComponent';
import UpdateTieFlowComponent from './components/UpdateTieFlowComponent';
import ViewTieFlowComponent from './components/ViewTieFlowComponent';
import ListTopologicalNodeComponent from './components/ListTopologicalNodeComponent';
import CreateTopologicalNodeComponent from './components/CreateTopologicalNodeComponent';
import UpdateTopologicalNodeComponent from './components/UpdateTopologicalNodeComponent';
import ViewTopologicalNodeComponent from './components/ViewTopologicalNodeComponent';
import ListTopologyBoundaryVersionComponent from './components/ListTopologyBoundaryVersionComponent';
import CreateTopologyBoundaryVersionComponent from './components/CreateTopologyBoundaryVersionComponent';
import UpdateTopologyBoundaryVersionComponent from './components/UpdateTopologyBoundaryVersionComponent';
import ViewTopologyBoundaryVersionComponent from './components/ViewTopologyBoundaryVersionComponent';
import ListTopologyVersionComponent from './components/ListTopologyVersionComponent';
import CreateTopologyVersionComponent from './components/CreateTopologyVersionComponent';
import UpdateTopologyVersionComponent from './components/UpdateTopologyVersionComponent';
import ViewTopologyVersionComponent from './components/ViewTopologyVersionComponent';
import ListTransformerEndComponent from './components/ListTransformerEndComponent';
import CreateTransformerEndComponent from './components/CreateTransformerEndComponent';
import UpdateTransformerEndComponent from './components/UpdateTransformerEndComponent';
import ViewTransformerEndComponent from './components/ViewTransformerEndComponent';
import ListTurbLCFB1Component from './components/ListTurbLCFB1Component';
import CreateTurbLCFB1Component from './components/CreateTurbLCFB1Component';
import UpdateTurbLCFB1Component from './components/UpdateTurbLCFB1Component';
import ViewTurbLCFB1Component from './components/ViewTurbLCFB1Component';
import ListTurbineGovernorUserDefinedComponent from './components/ListTurbineGovernorUserDefinedComponent';
import CreateTurbineGovernorUserDefinedComponent from './components/CreateTurbineGovernorUserDefinedComponent';
import UpdateTurbineGovernorUserDefinedComponent from './components/UpdateTurbineGovernorUserDefinedComponent';
import ViewTurbineGovernorUserDefinedComponent from './components/ViewTurbineGovernorUserDefinedComponent';
import ListTurbineLoadControllerUserDefinedComponent from './components/ListTurbineLoadControllerUserDefinedComponent';
import CreateTurbineLoadControllerUserDefinedComponent from './components/CreateTurbineLoadControllerUserDefinedComponent';
import UpdateTurbineLoadControllerUserDefinedComponent from './components/UpdateTurbineLoadControllerUserDefinedComponent';
import ViewTurbineLoadControllerUserDefinedComponent from './components/ViewTurbineLoadControllerUserDefinedComponent';
import ListUnderexcLim2SimplifiedComponent from './components/ListUnderexcLim2SimplifiedComponent';
import CreateUnderexcLim2SimplifiedComponent from './components/CreateUnderexcLim2SimplifiedComponent';
import UpdateUnderexcLim2SimplifiedComponent from './components/UpdateUnderexcLim2SimplifiedComponent';
import ViewUnderexcLim2SimplifiedComponent from './components/ViewUnderexcLim2SimplifiedComponent';
import ListUnderexcLimIEEE1Component from './components/ListUnderexcLimIEEE1Component';
import CreateUnderexcLimIEEE1Component from './components/CreateUnderexcLimIEEE1Component';
import UpdateUnderexcLimIEEE1Component from './components/UpdateUnderexcLimIEEE1Component';
import ViewUnderexcLimIEEE1Component from './components/ViewUnderexcLimIEEE1Component';
import ListUnderexcLimIEEE2Component from './components/ListUnderexcLimIEEE2Component';
import CreateUnderexcLimIEEE2Component from './components/CreateUnderexcLimIEEE2Component';
import UpdateUnderexcLimIEEE2Component from './components/UpdateUnderexcLimIEEE2Component';
import ViewUnderexcLimIEEE2Component from './components/ViewUnderexcLimIEEE2Component';
import ListUnderexcLimX1Component from './components/ListUnderexcLimX1Component';
import CreateUnderexcLimX1Component from './components/CreateUnderexcLimX1Component';
import UpdateUnderexcLimX1Component from './components/UpdateUnderexcLimX1Component';
import ViewUnderexcLimX1Component from './components/ViewUnderexcLimX1Component';
import ListUnderexcLimX2Component from './components/ListUnderexcLimX2Component';
import CreateUnderexcLimX2Component from './components/CreateUnderexcLimX2Component';
import UpdateUnderexcLimX2Component from './components/UpdateUnderexcLimX2Component';
import ViewUnderexcLimX2Component from './components/ViewUnderexcLimX2Component';
import ListUnderexcitationLimiterUserDefinedComponent from './components/ListUnderexcitationLimiterUserDefinedComponent';
import CreateUnderexcitationLimiterUserDefinedComponent from './components/CreateUnderexcitationLimiterUserDefinedComponent';
import UpdateUnderexcitationLimiterUserDefinedComponent from './components/UpdateUnderexcitationLimiterUserDefinedComponent';
import ViewUnderexcitationLimiterUserDefinedComponent from './components/ViewUnderexcitationLimiterUserDefinedComponent';
import ListVAdjIEEEComponent from './components/ListVAdjIEEEComponent';
import CreateVAdjIEEEComponent from './components/CreateVAdjIEEEComponent';
import UpdateVAdjIEEEComponent from './components/UpdateVAdjIEEEComponent';
import ViewVAdjIEEEComponent from './components/ViewVAdjIEEEComponent';
import ListVCompIEEEType1Component from './components/ListVCompIEEEType1Component';
import CreateVCompIEEEType1Component from './components/CreateVCompIEEEType1Component';
import UpdateVCompIEEEType1Component from './components/UpdateVCompIEEEType1Component';
import ViewVCompIEEEType1Component from './components/ViewVCompIEEEType1Component';
import ListVCompIEEEType2Component from './components/ListVCompIEEEType2Component';
import CreateVCompIEEEType2Component from './components/CreateVCompIEEEType2Component';
import UpdateVCompIEEEType2Component from './components/UpdateVCompIEEEType2Component';
import ViewVCompIEEEType2Component from './components/ViewVCompIEEEType2Component';
import ListValueToAliasComponent from './components/ListValueToAliasComponent';
import CreateValueToAliasComponent from './components/CreateValueToAliasComponent';
import UpdateValueToAliasComponent from './components/UpdateValueToAliasComponent';
import ViewValueToAliasComponent from './components/ViewValueToAliasComponent';
import ListVisibilityLayerComponent from './components/ListVisibilityLayerComponent';
import CreateVisibilityLayerComponent from './components/CreateVisibilityLayerComponent';
import UpdateVisibilityLayerComponent from './components/UpdateVisibilityLayerComponent';
import ViewVisibilityLayerComponent from './components/ViewVisibilityLayerComponent';
import ListVoltageComponent from './components/ListVoltageComponent';
import CreateVoltageComponent from './components/CreateVoltageComponent';
import UpdateVoltageComponent from './components/UpdateVoltageComponent';
import ViewVoltageComponent from './components/ViewVoltageComponent';
import ListVoltageAdjusterUserDefinedComponent from './components/ListVoltageAdjusterUserDefinedComponent';
import CreateVoltageAdjusterUserDefinedComponent from './components/CreateVoltageAdjusterUserDefinedComponent';
import UpdateVoltageAdjusterUserDefinedComponent from './components/UpdateVoltageAdjusterUserDefinedComponent';
import ViewVoltageAdjusterUserDefinedComponent from './components/ViewVoltageAdjusterUserDefinedComponent';
import ListVoltageCompensatorUserDefinedComponent from './components/ListVoltageCompensatorUserDefinedComponent';
import CreateVoltageCompensatorUserDefinedComponent from './components/CreateVoltageCompensatorUserDefinedComponent';
import UpdateVoltageCompensatorUserDefinedComponent from './components/UpdateVoltageCompensatorUserDefinedComponent';
import ViewVoltageCompensatorUserDefinedComponent from './components/ViewVoltageCompensatorUserDefinedComponent';
import ListVoltageLevelComponent from './components/ListVoltageLevelComponent';
import CreateVoltageLevelComponent from './components/CreateVoltageLevelComponent';
import UpdateVoltageLevelComponent from './components/UpdateVoltageLevelComponent';
import ViewVoltageLevelComponent from './components/ViewVoltageLevelComponent';
import ListVoltageLimitComponent from './components/ListVoltageLimitComponent';
import CreateVoltageLimitComponent from './components/CreateVoltageLimitComponent';
import UpdateVoltageLimitComponent from './components/UpdateVoltageLimitComponent';
import ViewVoltageLimitComponent from './components/ViewVoltageLimitComponent';
import ListVoltagePerReactivePowerComponent from './components/ListVoltagePerReactivePowerComponent';
import CreateVoltagePerReactivePowerComponent from './components/CreateVoltagePerReactivePowerComponent';
import UpdateVoltagePerReactivePowerComponent from './components/UpdateVoltagePerReactivePowerComponent';
import ViewVoltagePerReactivePowerComponent from './components/ViewVoltagePerReactivePowerComponent';
import ListVolumeFlowRateComponent from './components/ListVolumeFlowRateComponent';
import CreateVolumeFlowRateComponent from './components/CreateVolumeFlowRateComponent';
import UpdateVolumeFlowRateComponent from './components/UpdateVolumeFlowRateComponent';
import ViewVolumeFlowRateComponent from './components/ViewVolumeFlowRateComponent';
import ListVsConverterComponent from './components/ListVsConverterComponent';
import CreateVsConverterComponent from './components/CreateVsConverterComponent';
import UpdateVsConverterComponent from './components/UpdateVsConverterComponent';
import ViewVsConverterComponent from './components/ViewVsConverterComponent';
import ListWindAeroLinearIECComponent from './components/ListWindAeroLinearIECComponent';
import CreateWindAeroLinearIECComponent from './components/CreateWindAeroLinearIECComponent';
import UpdateWindAeroLinearIECComponent from './components/UpdateWindAeroLinearIECComponent';
import ViewWindAeroLinearIECComponent from './components/ViewWindAeroLinearIECComponent';
import ListWindContCurrLimIECComponent from './components/ListWindContCurrLimIECComponent';
import CreateWindContCurrLimIECComponent from './components/CreateWindContCurrLimIECComponent';
import UpdateWindContCurrLimIECComponent from './components/UpdateWindContCurrLimIECComponent';
import ViewWindContCurrLimIECComponent from './components/ViewWindContCurrLimIECComponent';
import ListWindContPType3IECComponent from './components/ListWindContPType3IECComponent';
import CreateWindContPType3IECComponent from './components/CreateWindContPType3IECComponent';
import UpdateWindContPType3IECComponent from './components/UpdateWindContPType3IECComponent';
import ViewWindContPType3IECComponent from './components/ViewWindContPType3IECComponent';
import ListWindContPType4aIECComponent from './components/ListWindContPType4aIECComponent';
import CreateWindContPType4aIECComponent from './components/CreateWindContPType4aIECComponent';
import UpdateWindContPType4aIECComponent from './components/UpdateWindContPType4aIECComponent';
import ViewWindContPType4aIECComponent from './components/ViewWindContPType4aIECComponent';
import ListWindContPType4bIECComponent from './components/ListWindContPType4bIECComponent';
import CreateWindContPType4bIECComponent from './components/CreateWindContPType4bIECComponent';
import UpdateWindContPType4bIECComponent from './components/UpdateWindContPType4bIECComponent';
import ViewWindContPType4bIECComponent from './components/ViewWindContPType4bIECComponent';
import ListWindContPitchAngleIECComponent from './components/ListWindContPitchAngleIECComponent';
import CreateWindContPitchAngleIECComponent from './components/CreateWindContPitchAngleIECComponent';
import UpdateWindContPitchAngleIECComponent from './components/UpdateWindContPitchAngleIECComponent';
import ViewWindContPitchAngleIECComponent from './components/ViewWindContPitchAngleIECComponent';
import ListWindContQIECComponent from './components/ListWindContQIECComponent';
import CreateWindContQIECComponent from './components/CreateWindContQIECComponent';
import UpdateWindContQIECComponent from './components/UpdateWindContQIECComponent';
import ViewWindContQIECComponent from './components/ViewWindContQIECComponent';
import ListWindContRotorRIECComponent from './components/ListWindContRotorRIECComponent';
import CreateWindContRotorRIECComponent from './components/CreateWindContRotorRIECComponent';
import UpdateWindContRotorRIECComponent from './components/UpdateWindContRotorRIECComponent';
import ViewWindContRotorRIECComponent from './components/ViewWindContRotorRIECComponent';
import ListWindDynamicsLookupTableComponent from './components/ListWindDynamicsLookupTableComponent';
import CreateWindDynamicsLookupTableComponent from './components/CreateWindDynamicsLookupTableComponent';
import UpdateWindDynamicsLookupTableComponent from './components/UpdateWindDynamicsLookupTableComponent';
import ViewWindDynamicsLookupTableComponent from './components/ViewWindDynamicsLookupTableComponent';
import ListWindGenTurbineType3IECComponent from './components/ListWindGenTurbineType3IECComponent';
import CreateWindGenTurbineType3IECComponent from './components/CreateWindGenTurbineType3IECComponent';
import UpdateWindGenTurbineType3IECComponent from './components/UpdateWindGenTurbineType3IECComponent';
import ViewWindGenTurbineType3IECComponent from './components/ViewWindGenTurbineType3IECComponent';
import ListWindGenTurbineType3aIECComponent from './components/ListWindGenTurbineType3aIECComponent';
import CreateWindGenTurbineType3aIECComponent from './components/CreateWindGenTurbineType3aIECComponent';
import UpdateWindGenTurbineType3aIECComponent from './components/UpdateWindGenTurbineType3aIECComponent';
import ViewWindGenTurbineType3aIECComponent from './components/ViewWindGenTurbineType3aIECComponent';
import ListWindGenTurbineType3bIECComponent from './components/ListWindGenTurbineType3bIECComponent';
import CreateWindGenTurbineType3bIECComponent from './components/CreateWindGenTurbineType3bIECComponent';
import UpdateWindGenTurbineType3bIECComponent from './components/UpdateWindGenTurbineType3bIECComponent';
import ViewWindGenTurbineType3bIECComponent from './components/ViewWindGenTurbineType3bIECComponent';
import ListWindGenType4IECComponent from './components/ListWindGenType4IECComponent';
import CreateWindGenType4IECComponent from './components/CreateWindGenType4IECComponent';
import UpdateWindGenType4IECComponent from './components/UpdateWindGenType4IECComponent';
import ViewWindGenType4IECComponent from './components/ViewWindGenType4IECComponent';
import ListWindGeneratingUnitComponent from './components/ListWindGeneratingUnitComponent';
import CreateWindGeneratingUnitComponent from './components/CreateWindGeneratingUnitComponent';
import UpdateWindGeneratingUnitComponent from './components/UpdateWindGeneratingUnitComponent';
import ViewWindGeneratingUnitComponent from './components/ViewWindGeneratingUnitComponent';
import ListWindMechIECComponent from './components/ListWindMechIECComponent';
import CreateWindMechIECComponent from './components/CreateWindMechIECComponent';
import UpdateWindMechIECComponent from './components/UpdateWindMechIECComponent';
import ViewWindMechIECComponent from './components/ViewWindMechIECComponent';
import ListWindPitchContEmulIECComponent from './components/ListWindPitchContEmulIECComponent';
import CreateWindPitchContEmulIECComponent from './components/CreateWindPitchContEmulIECComponent';
import UpdateWindPitchContEmulIECComponent from './components/UpdateWindPitchContEmulIECComponent';
import ViewWindPitchContEmulIECComponent from './components/ViewWindPitchContEmulIECComponent';
import ListWindPlantFreqPcontrolIECComponent from './components/ListWindPlantFreqPcontrolIECComponent';
import CreateWindPlantFreqPcontrolIECComponent from './components/CreateWindPlantFreqPcontrolIECComponent';
import UpdateWindPlantFreqPcontrolIECComponent from './components/UpdateWindPlantFreqPcontrolIECComponent';
import ViewWindPlantFreqPcontrolIECComponent from './components/ViewWindPlantFreqPcontrolIECComponent';
import ListWindPlantReactiveControlIECComponent from './components/ListWindPlantReactiveControlIECComponent';
import CreateWindPlantReactiveControlIECComponent from './components/CreateWindPlantReactiveControlIECComponent';
import UpdateWindPlantReactiveControlIECComponent from './components/UpdateWindPlantReactiveControlIECComponent';
import ViewWindPlantReactiveControlIECComponent from './components/ViewWindPlantReactiveControlIECComponent';
import ListWindPlantUserDefinedComponent from './components/ListWindPlantUserDefinedComponent';
import CreateWindPlantUserDefinedComponent from './components/CreateWindPlantUserDefinedComponent';
import UpdateWindPlantUserDefinedComponent from './components/UpdateWindPlantUserDefinedComponent';
import ViewWindPlantUserDefinedComponent from './components/ViewWindPlantUserDefinedComponent';
import ListWindProtectionIECComponent from './components/ListWindProtectionIECComponent';
import CreateWindProtectionIECComponent from './components/CreateWindProtectionIECComponent';
import UpdateWindProtectionIECComponent from './components/UpdateWindProtectionIECComponent';
import ViewWindProtectionIECComponent from './components/ViewWindProtectionIECComponent';
import ListWindType1or2UserDefinedComponent from './components/ListWindType1or2UserDefinedComponent';
import CreateWindType1or2UserDefinedComponent from './components/CreateWindType1or2UserDefinedComponent';
import UpdateWindType1or2UserDefinedComponent from './components/UpdateWindType1or2UserDefinedComponent';
import ViewWindType1or2UserDefinedComponent from './components/ViewWindType1or2UserDefinedComponent';
import ListWindType3or4UserDefinedComponent from './components/ListWindType3or4UserDefinedComponent';
import CreateWindType3or4UserDefinedComponent from './components/CreateWindType3or4UserDefinedComponent';
import UpdateWindType3or4UserDefinedComponent from './components/UpdateWindType3or4UserDefinedComponent';
import ViewWindType3or4UserDefinedComponent from './components/ViewWindType3or4UserDefinedComponent';
#outputExtraInclusionComponents()
function App() {
  return (
    <div>
        <Router>
                <HeaderComponent className="header"/>
                <div className="container">
                    <Switch>
                          <Route path = "/" exact component = {HomePageComponent}></Route>
                            <Route path = "/aCDCConverters" component = {ListACDCConverterComponent}></Route>
                            <Route path = "/add-aCDCConverter/:id" component = {CreateACDCConverterComponent}></Route>
                            <Route path = "/view-aCDCConverter/:id" component = {ViewACDCConverterComponent}></Route>
                          {/* <Route path = "/update-aCDCConverter/:id" component = {UpdateACDCConverterComponent}></Route> */}
                            <Route path = "/aCDCConverterDCTerminals" component = {ListACDCConverterDCTerminalComponent}></Route>
                            <Route path = "/add-aCDCConverterDCTerminal/:id" component = {CreateACDCConverterDCTerminalComponent}></Route>
                            <Route path = "/view-aCDCConverterDCTerminal/:id" component = {ViewACDCConverterDCTerminalComponent}></Route>
                          {/* <Route path = "/update-aCDCConverterDCTerminal/:id" component = {UpdateACDCConverterDCTerminalComponent}></Route> */}
                            <Route path = "/aCDCTerminals" component = {ListACDCTerminalComponent}></Route>
                            <Route path = "/add-aCDCTerminal/:id" component = {CreateACDCTerminalComponent}></Route>
                            <Route path = "/view-aCDCTerminal/:id" component = {ViewACDCTerminalComponent}></Route>
                          {/* <Route path = "/update-aCDCTerminal/:id" component = {UpdateACDCTerminalComponent}></Route> */}
                            <Route path = "/aCLineSegments" component = {ListACLineSegmentComponent}></Route>
                            <Route path = "/add-aCLineSegment/:id" component = {CreateACLineSegmentComponent}></Route>
                            <Route path = "/view-aCLineSegment/:id" component = {ViewACLineSegmentComponent}></Route>
                          {/* <Route path = "/update-aCLineSegment/:id" component = {UpdateACLineSegmentComponent}></Route> */}
                            <Route path = "/accumulatorLimits" component = {ListAccumulatorLimitComponent}></Route>
                            <Route path = "/add-accumulatorLimit/:id" component = {CreateAccumulatorLimitComponent}></Route>
                            <Route path = "/view-accumulatorLimit/:id" component = {ViewAccumulatorLimitComponent}></Route>
                          {/* <Route path = "/update-accumulatorLimit/:id" component = {UpdateAccumulatorLimitComponent}></Route> */}
                            <Route path = "/accumulatorValues" component = {ListAccumulatorValueComponent}></Route>
                            <Route path = "/add-accumulatorValue/:id" component = {CreateAccumulatorValueComponent}></Route>
                            <Route path = "/view-accumulatorValue/:id" component = {ViewAccumulatorValueComponent}></Route>
                          {/* <Route path = "/update-accumulatorValue/:id" component = {UpdateAccumulatorValueComponent}></Route> */}
                            <Route path = "/activePowers" component = {ListActivePowerComponent}></Route>
                            <Route path = "/add-activePower/:id" component = {CreateActivePowerComponent}></Route>
                            <Route path = "/view-activePower/:id" component = {ViewActivePowerComponent}></Route>
                          {/* <Route path = "/update-activePower/:id" component = {UpdateActivePowerComponent}></Route> */}
                            <Route path = "/activePowerLimits" component = {ListActivePowerLimitComponent}></Route>
                            <Route path = "/add-activePowerLimit/:id" component = {CreateActivePowerLimitComponent}></Route>
                            <Route path = "/view-activePowerLimit/:id" component = {ViewActivePowerLimitComponent}></Route>
                          {/* <Route path = "/update-activePowerLimit/:id" component = {UpdateActivePowerLimitComponent}></Route> */}
                            <Route path = "/activePowerPerCurrentFlows" component = {ListActivePowerPerCurrentFlowComponent}></Route>
                            <Route path = "/add-activePowerPerCurrentFlow/:id" component = {CreateActivePowerPerCurrentFlowComponent}></Route>
                            <Route path = "/view-activePowerPerCurrentFlow/:id" component = {ViewActivePowerPerCurrentFlowComponent}></Route>
                          {/* <Route path = "/update-activePowerPerCurrentFlow/:id" component = {UpdateActivePowerPerCurrentFlowComponent}></Route> */}
                            <Route path = "/activePowerPerFrequencys" component = {ListActivePowerPerFrequencyComponent}></Route>
                            <Route path = "/add-activePowerPerFrequency/:id" component = {CreateActivePowerPerFrequencyComponent}></Route>
                            <Route path = "/view-activePowerPerFrequency/:id" component = {ViewActivePowerPerFrequencyComponent}></Route>
                          {/* <Route path = "/update-activePowerPerFrequency/:id" component = {UpdateActivePowerPerFrequencyComponent}></Route> */}
                            <Route path = "/analogs" component = {ListAnalogComponent}></Route>
                            <Route path = "/add-analog/:id" component = {CreateAnalogComponent}></Route>
                            <Route path = "/view-analog/:id" component = {ViewAnalogComponent}></Route>
                          {/* <Route path = "/update-analog/:id" component = {UpdateAnalogComponent}></Route> */}
                            <Route path = "/analogControls" component = {ListAnalogControlComponent}></Route>
                            <Route path = "/add-analogControl/:id" component = {CreateAnalogControlComponent}></Route>
                            <Route path = "/view-analogControl/:id" component = {ViewAnalogControlComponent}></Route>
                          {/* <Route path = "/update-analogControl/:id" component = {UpdateAnalogControlComponent}></Route> */}
                            <Route path = "/analogLimits" component = {ListAnalogLimitComponent}></Route>
                            <Route path = "/add-analogLimit/:id" component = {CreateAnalogLimitComponent}></Route>
                            <Route path = "/view-analogLimit/:id" component = {ViewAnalogLimitComponent}></Route>
                          {/* <Route path = "/update-analogLimit/:id" component = {UpdateAnalogLimitComponent}></Route> */}
                            <Route path = "/analogValues" component = {ListAnalogValueComponent}></Route>
                            <Route path = "/add-analogValue/:id" component = {CreateAnalogValueComponent}></Route>
                            <Route path = "/view-analogValue/:id" component = {ViewAnalogValueComponent}></Route>
                          {/* <Route path = "/update-analogValue/:id" component = {UpdateAnalogValueComponent}></Route> */}
                            <Route path = "/angleDegreess" component = {ListAngleDegreesComponent}></Route>
                            <Route path = "/add-angleDegrees/:id" component = {CreateAngleDegreesComponent}></Route>
                            <Route path = "/view-angleDegrees/:id" component = {ViewAngleDegreesComponent}></Route>
                          {/* <Route path = "/update-angleDegrees/:id" component = {UpdateAngleDegreesComponent}></Route> */}
                            <Route path = "/angleRadianss" component = {ListAngleRadiansComponent}></Route>
                            <Route path = "/add-angleRadians/:id" component = {CreateAngleRadiansComponent}></Route>
                            <Route path = "/view-angleRadians/:id" component = {ViewAngleRadiansComponent}></Route>
                          {/* <Route path = "/update-angleRadians/:id" component = {UpdateAngleRadiansComponent}></Route> */}
                            <Route path = "/apparentPowers" component = {ListApparentPowerComponent}></Route>
                            <Route path = "/add-apparentPower/:id" component = {CreateApparentPowerComponent}></Route>
                            <Route path = "/view-apparentPower/:id" component = {ViewApparentPowerComponent}></Route>
                          {/* <Route path = "/update-apparentPower/:id" component = {UpdateApparentPowerComponent}></Route> */}
                            <Route path = "/apparentPowerLimits" component = {ListApparentPowerLimitComponent}></Route>
                            <Route path = "/add-apparentPowerLimit/:id" component = {CreateApparentPowerLimitComponent}></Route>
                            <Route path = "/view-apparentPowerLimit/:id" component = {ViewApparentPowerLimitComponent}></Route>
                          {/* <Route path = "/update-apparentPowerLimit/:id" component = {UpdateApparentPowerLimitComponent}></Route> */}
                            <Route path = "/areas" component = {ListAreaComponent}></Route>
                            <Route path = "/add-area/:id" component = {CreateAreaComponent}></Route>
                            <Route path = "/view-area/:id" component = {ViewAreaComponent}></Route>
                          {/* <Route path = "/update-area/:id" component = {UpdateAreaComponent}></Route> */}
                            <Route path = "/asynchronousMachines" component = {ListAsynchronousMachineComponent}></Route>
                            <Route path = "/add-asynchronousMachine/:id" component = {CreateAsynchronousMachineComponent}></Route>
                            <Route path = "/view-asynchronousMachine/:id" component = {ViewAsynchronousMachineComponent}></Route>
                          {/* <Route path = "/update-asynchronousMachine/:id" component = {UpdateAsynchronousMachineComponent}></Route> */}
                            <Route path = "/asynchronousMachineEquivalentCircuits" component = {ListAsynchronousMachineEquivalentCircuitComponent}></Route>
                            <Route path = "/add-asynchronousMachineEquivalentCircuit/:id" component = {CreateAsynchronousMachineEquivalentCircuitComponent}></Route>
                            <Route path = "/view-asynchronousMachineEquivalentCircuit/:id" component = {ViewAsynchronousMachineEquivalentCircuitComponent}></Route>
                          {/* <Route path = "/update-asynchronousMachineEquivalentCircuit/:id" component = {UpdateAsynchronousMachineEquivalentCircuitComponent}></Route> */}
                            <Route path = "/asynchronousMachineTimeConstantReactances" component = {ListAsynchronousMachineTimeConstantReactanceComponent}></Route>
                            <Route path = "/add-asynchronousMachineTimeConstantReactance/:id" component = {CreateAsynchronousMachineTimeConstantReactanceComponent}></Route>
                            <Route path = "/view-asynchronousMachineTimeConstantReactance/:id" component = {ViewAsynchronousMachineTimeConstantReactanceComponent}></Route>
                          {/* <Route path = "/update-asynchronousMachineTimeConstantReactance/:id" component = {UpdateAsynchronousMachineTimeConstantReactanceComponent}></Route> */}
                            <Route path = "/asynchronousMachineUserDefineds" component = {ListAsynchronousMachineUserDefinedComponent}></Route>
                            <Route path = "/add-asynchronousMachineUserDefined/:id" component = {CreateAsynchronousMachineUserDefinedComponent}></Route>
                            <Route path = "/view-asynchronousMachineUserDefined/:id" component = {ViewAsynchronousMachineUserDefinedComponent}></Route>
                          {/* <Route path = "/update-asynchronousMachineUserDefined/:id" component = {UpdateAsynchronousMachineUserDefinedComponent}></Route> */}
                            <Route path = "/baseVoltages" component = {ListBaseVoltageComponent}></Route>
                            <Route path = "/add-baseVoltage/:id" component = {CreateBaseVoltageComponent}></Route>
                            <Route path = "/view-baseVoltage/:id" component = {ViewBaseVoltageComponent}></Route>
                          {/* <Route path = "/update-baseVoltage/:id" component = {UpdateBaseVoltageComponent}></Route> */}
                            <Route path = "/basicIntervalSchedules" component = {ListBasicIntervalScheduleComponent}></Route>
                            <Route path = "/add-basicIntervalSchedule/:id" component = {CreateBasicIntervalScheduleComponent}></Route>
                            <Route path = "/view-basicIntervalSchedule/:id" component = {ViewBasicIntervalScheduleComponent}></Route>
                          {/* <Route path = "/update-basicIntervalSchedule/:id" component = {UpdateBasicIntervalScheduleComponent}></Route> */}
                            <Route path = "/boundaryExtensionss" component = {ListBoundaryExtensionsComponent}></Route>
                            <Route path = "/add-boundaryExtensions/:id" component = {CreateBoundaryExtensionsComponent}></Route>
                            <Route path = "/view-boundaryExtensions/:id" component = {ViewBoundaryExtensionsComponent}></Route>
                          {/* <Route path = "/update-boundaryExtensions/:id" component = {UpdateBoundaryExtensionsComponent}></Route> */}
                            <Route path = "/busNameMarkers" component = {ListBusNameMarkerComponent}></Route>
                            <Route path = "/add-busNameMarker/:id" component = {CreateBusNameMarkerComponent}></Route>
                            <Route path = "/view-busNameMarker/:id" component = {ViewBusNameMarkerComponent}></Route>
                          {/* <Route path = "/update-busNameMarker/:id" component = {UpdateBusNameMarkerComponent}></Route> */}
                            <Route path = "/busbarSections" component = {ListBusbarSectionComponent}></Route>
                            <Route path = "/add-busbarSection/:id" component = {CreateBusbarSectionComponent}></Route>
                            <Route path = "/view-busbarSection/:id" component = {ViewBusbarSectionComponent}></Route>
                          {/* <Route path = "/update-busbarSection/:id" component = {UpdateBusbarSectionComponent}></Route> */}
                            <Route path = "/capacitances" component = {ListCapacitanceComponent}></Route>
                            <Route path = "/add-capacitance/:id" component = {CreateCapacitanceComponent}></Route>
                            <Route path = "/view-capacitance/:id" component = {ViewCapacitanceComponent}></Route>
                          {/* <Route path = "/update-capacitance/:id" component = {UpdateCapacitanceComponent}></Route> */}
                            <Route path = "/capacitancePerLengths" component = {ListCapacitancePerLengthComponent}></Route>
                            <Route path = "/add-capacitancePerLength/:id" component = {CreateCapacitancePerLengthComponent}></Route>
                            <Route path = "/view-capacitancePerLength/:id" component = {ViewCapacitancePerLengthComponent}></Route>
                          {/* <Route path = "/update-capacitancePerLength/:id" component = {UpdateCapacitancePerLengthComponent}></Route> */}
                            <Route path = "/commands" component = {ListCommandComponent}></Route>
                            <Route path = "/add-command/:id" component = {CreateCommandComponent}></Route>
                            <Route path = "/view-command/:id" component = {ViewCommandComponent}></Route>
                          {/* <Route path = "/update-command/:id" component = {UpdateCommandComponent}></Route> */}
                            <Route path = "/conductances" component = {ListConductanceComponent}></Route>
                            <Route path = "/add-conductance/:id" component = {CreateConductanceComponent}></Route>
                            <Route path = "/view-conductance/:id" component = {ViewConductanceComponent}></Route>
                          {/* <Route path = "/update-conductance/:id" component = {UpdateConductanceComponent}></Route> */}
                            <Route path = "/conductors" component = {ListConductorComponent}></Route>
                            <Route path = "/add-conductor/:id" component = {CreateConductorComponent}></Route>
                            <Route path = "/view-conductor/:id" component = {ViewConductorComponent}></Route>
                          {/* <Route path = "/update-conductor/:id" component = {UpdateConductorComponent}></Route> */}
                            <Route path = "/connectivityNodes" component = {ListConnectivityNodeComponent}></Route>
                            <Route path = "/add-connectivityNode/:id" component = {CreateConnectivityNodeComponent}></Route>
                            <Route path = "/view-connectivityNode/:id" component = {ViewConnectivityNodeComponent}></Route>
                          {/* <Route path = "/update-connectivityNode/:id" component = {UpdateConnectivityNodeComponent}></Route> */}
                            <Route path = "/controls" component = {ListControlComponent}></Route>
                            <Route path = "/add-control/:id" component = {CreateControlComponent}></Route>
                            <Route path = "/view-control/:id" component = {ViewControlComponent}></Route>
                          {/* <Route path = "/update-control/:id" component = {UpdateControlComponent}></Route> */}
                            <Route path = "/controlAreas" component = {ListControlAreaComponent}></Route>
                            <Route path = "/add-controlArea/:id" component = {CreateControlAreaComponent}></Route>
                            <Route path = "/view-controlArea/:id" component = {ViewControlAreaComponent}></Route>
                          {/* <Route path = "/update-controlArea/:id" component = {UpdateControlAreaComponent}></Route> */}
                            <Route path = "/coordinateSystems" component = {ListCoordinateSystemComponent}></Route>
                            <Route path = "/add-coordinateSystem/:id" component = {CreateCoordinateSystemComponent}></Route>
                            <Route path = "/view-coordinateSystem/:id" component = {ViewCoordinateSystemComponent}></Route>
                          {/* <Route path = "/update-coordinateSystem/:id" component = {UpdateCoordinateSystemComponent}></Route> */}
                            <Route path = "/csConverters" component = {ListCsConverterComponent}></Route>
                            <Route path = "/add-csConverter/:id" component = {CreateCsConverterComponent}></Route>
                            <Route path = "/view-csConverter/:id" component = {ViewCsConverterComponent}></Route>
                          {/* <Route path = "/update-csConverter/:id" component = {UpdateCsConverterComponent}></Route> */}
                            <Route path = "/currentFlows" component = {ListCurrentFlowComponent}></Route>
                            <Route path = "/add-currentFlow/:id" component = {CreateCurrentFlowComponent}></Route>
                            <Route path = "/view-currentFlow/:id" component = {ViewCurrentFlowComponent}></Route>
                          {/* <Route path = "/update-currentFlow/:id" component = {UpdateCurrentFlowComponent}></Route> */}
                            <Route path = "/currentLimits" component = {ListCurrentLimitComponent}></Route>
                            <Route path = "/add-currentLimit/:id" component = {CreateCurrentLimitComponent}></Route>
                            <Route path = "/view-currentLimit/:id" component = {ViewCurrentLimitComponent}></Route>
                          {/* <Route path = "/update-currentLimit/:id" component = {UpdateCurrentLimitComponent}></Route> */}
                            <Route path = "/curves" component = {ListCurveComponent}></Route>
                            <Route path = "/add-curve/:id" component = {CreateCurveComponent}></Route>
                            <Route path = "/view-curve/:id" component = {ViewCurveComponent}></Route>
                          {/* <Route path = "/update-curve/:id" component = {UpdateCurveComponent}></Route> */}
                            <Route path = "/curveDatas" component = {ListCurveDataComponent}></Route>
                            <Route path = "/add-curveData/:id" component = {CreateCurveDataComponent}></Route>
                            <Route path = "/view-curveData/:id" component = {ViewCurveDataComponent}></Route>
                          {/* <Route path = "/update-curveData/:id" component = {UpdateCurveDataComponent}></Route> */}
                            <Route path = "/dCConverterUnits" component = {ListDCConverterUnitComponent}></Route>
                            <Route path = "/add-dCConverterUnit/:id" component = {CreateDCConverterUnitComponent}></Route>
                            <Route path = "/view-dCConverterUnit/:id" component = {ViewDCConverterUnitComponent}></Route>
                          {/* <Route path = "/update-dCConverterUnit/:id" component = {UpdateDCConverterUnitComponent}></Route> */}
                            <Route path = "/dCGrounds" component = {ListDCGroundComponent}></Route>
                            <Route path = "/add-dCGround/:id" component = {CreateDCGroundComponent}></Route>
                            <Route path = "/view-dCGround/:id" component = {ViewDCGroundComponent}></Route>
                          {/* <Route path = "/update-dCGround/:id" component = {UpdateDCGroundComponent}></Route> */}
                            <Route path = "/dCLineSegments" component = {ListDCLineSegmentComponent}></Route>
                            <Route path = "/add-dCLineSegment/:id" component = {CreateDCLineSegmentComponent}></Route>
                            <Route path = "/view-dCLineSegment/:id" component = {ViewDCLineSegmentComponent}></Route>
                          {/* <Route path = "/update-dCLineSegment/:id" component = {UpdateDCLineSegmentComponent}></Route> */}
                            <Route path = "/dCSeriesDevices" component = {ListDCSeriesDeviceComponent}></Route>
                            <Route path = "/add-dCSeriesDevice/:id" component = {CreateDCSeriesDeviceComponent}></Route>
                            <Route path = "/view-dCSeriesDevice/:id" component = {ViewDCSeriesDeviceComponent}></Route>
                          {/* <Route path = "/update-dCSeriesDevice/:id" component = {UpdateDCSeriesDeviceComponent}></Route> */}
                            <Route path = "/dCShunts" component = {ListDCShuntComponent}></Route>
                            <Route path = "/add-dCShunt/:id" component = {CreateDCShuntComponent}></Route>
                            <Route path = "/view-dCShunt/:id" component = {ViewDCShuntComponent}></Route>
                          {/* <Route path = "/update-dCShunt/:id" component = {UpdateDCShuntComponent}></Route> */}
                            <Route path = "/diagrams" component = {ListDiagramComponent}></Route>
                            <Route path = "/add-diagram/:id" component = {CreateDiagramComponent}></Route>
                            <Route path = "/view-diagram/:id" component = {ViewDiagramComponent}></Route>
                          {/* <Route path = "/update-diagram/:id" component = {UpdateDiagramComponent}></Route> */}
                            <Route path = "/diagramLayoutVersions" component = {ListDiagramLayoutVersionComponent}></Route>
                            <Route path = "/add-diagramLayoutVersion/:id" component = {CreateDiagramLayoutVersionComponent}></Route>
                            <Route path = "/view-diagramLayoutVersion/:id" component = {ViewDiagramLayoutVersionComponent}></Route>
                          {/* <Route path = "/update-diagramLayoutVersion/:id" component = {UpdateDiagramLayoutVersionComponent}></Route> */}
                            <Route path = "/diagramObjects" component = {ListDiagramObjectComponent}></Route>
                            <Route path = "/add-diagramObject/:id" component = {CreateDiagramObjectComponent}></Route>
                            <Route path = "/view-diagramObject/:id" component = {ViewDiagramObjectComponent}></Route>
                          {/* <Route path = "/update-diagramObject/:id" component = {UpdateDiagramObjectComponent}></Route> */}
                            <Route path = "/diagramObjectPoints" component = {ListDiagramObjectPointComponent}></Route>
                            <Route path = "/add-diagramObjectPoint/:id" component = {CreateDiagramObjectPointComponent}></Route>
                            <Route path = "/view-diagramObjectPoint/:id" component = {ViewDiagramObjectPointComponent}></Route>
                          {/* <Route path = "/update-diagramObjectPoint/:id" component = {UpdateDiagramObjectPointComponent}></Route> */}
                            <Route path = "/discExcContIEEEDEC1As" component = {ListDiscExcContIEEEDEC1AComponent}></Route>
                            <Route path = "/add-discExcContIEEEDEC1A/:id" component = {CreateDiscExcContIEEEDEC1AComponent}></Route>
                            <Route path = "/view-discExcContIEEEDEC1A/:id" component = {ViewDiscExcContIEEEDEC1AComponent}></Route>
                          {/* <Route path = "/update-discExcContIEEEDEC1A/:id" component = {UpdateDiscExcContIEEEDEC1AComponent}></Route> */}
                            <Route path = "/discExcContIEEEDEC2As" component = {ListDiscExcContIEEEDEC2AComponent}></Route>
                            <Route path = "/add-discExcContIEEEDEC2A/:id" component = {CreateDiscExcContIEEEDEC2AComponent}></Route>
                            <Route path = "/view-discExcContIEEEDEC2A/:id" component = {ViewDiscExcContIEEEDEC2AComponent}></Route>
                          {/* <Route path = "/update-discExcContIEEEDEC2A/:id" component = {UpdateDiscExcContIEEEDEC2AComponent}></Route> */}
                            <Route path = "/discExcContIEEEDEC3As" component = {ListDiscExcContIEEEDEC3AComponent}></Route>
                            <Route path = "/add-discExcContIEEEDEC3A/:id" component = {CreateDiscExcContIEEEDEC3AComponent}></Route>
                            <Route path = "/view-discExcContIEEEDEC3A/:id" component = {ViewDiscExcContIEEEDEC3AComponent}></Route>
                          {/* <Route path = "/update-discExcContIEEEDEC3A/:id" component = {UpdateDiscExcContIEEEDEC3AComponent}></Route> */}
                            <Route path = "/discontinuousExcitationControlUserDefineds" component = {ListDiscontinuousExcitationControlUserDefinedComponent}></Route>
                            <Route path = "/add-discontinuousExcitationControlUserDefined/:id" component = {CreateDiscontinuousExcitationControlUserDefinedComponent}></Route>
                            <Route path = "/view-discontinuousExcitationControlUserDefined/:id" component = {ViewDiscontinuousExcitationControlUserDefinedComponent}></Route>
                          {/* <Route path = "/update-discontinuousExcitationControlUserDefined/:id" component = {UpdateDiscontinuousExcitationControlUserDefinedComponent}></Route> */}
                            <Route path = "/discreteValues" component = {ListDiscreteValueComponent}></Route>
                            <Route path = "/add-discreteValue/:id" component = {CreateDiscreteValueComponent}></Route>
                            <Route path = "/view-discreteValue/:id" component = {ViewDiscreteValueComponent}></Route>
                          {/* <Route path = "/update-discreteValue/:id" component = {UpdateDiscreteValueComponent}></Route> */}
                            <Route path = "/domainVersions" component = {ListDomainVersionComponent}></Route>
                            <Route path = "/add-domainVersion/:id" component = {CreateDomainVersionComponent}></Route>
                            <Route path = "/view-domainVersion/:id" component = {ViewDomainVersionComponent}></Route>
                          {/* <Route path = "/update-domainVersion/:id" component = {UpdateDomainVersionComponent}></Route> */}
                            <Route path = "/dynamicsFunctionBlocks" component = {ListDynamicsFunctionBlockComponent}></Route>
                            <Route path = "/add-dynamicsFunctionBlock/:id" component = {CreateDynamicsFunctionBlockComponent}></Route>
                            <Route path = "/view-dynamicsFunctionBlock/:id" component = {ViewDynamicsFunctionBlockComponent}></Route>
                          {/* <Route path = "/update-dynamicsFunctionBlock/:id" component = {UpdateDynamicsFunctionBlockComponent}></Route> */}
                            <Route path = "/dynamicsVersions" component = {ListDynamicsVersionComponent}></Route>
                            <Route path = "/add-dynamicsVersion/:id" component = {CreateDynamicsVersionComponent}></Route>
                            <Route path = "/view-dynamicsVersion/:id" component = {ViewDynamicsVersionComponent}></Route>
                          {/* <Route path = "/update-dynamicsVersion/:id" component = {UpdateDynamicsVersionComponent}></Route> */}
                            <Route path = "/eNTSOEIdentifiedObjects" component = {ListENTSOEIdentifiedObjectComponent}></Route>
                            <Route path = "/add-eNTSOEIdentifiedObject/:id" component = {CreateENTSOEIdentifiedObjectComponent}></Route>
                            <Route path = "/view-eNTSOEIdentifiedObject/:id" component = {ViewENTSOEIdentifiedObjectComponent}></Route>
                          {/* <Route path = "/update-eNTSOEIdentifiedObject/:id" component = {UpdateENTSOEIdentifiedObjectComponent}></Route> */}
                            <Route path = "/eNTSOEOperationalLimitTypes" component = {ListENTSOEOperationalLimitTypeComponent}></Route>
                            <Route path = "/add-eNTSOEOperationalLimitType/:id" component = {CreateENTSOEOperationalLimitTypeComponent}></Route>
                            <Route path = "/view-eNTSOEOperationalLimitType/:id" component = {ViewENTSOEOperationalLimitTypeComponent}></Route>
                          {/* <Route path = "/update-eNTSOEOperationalLimitType/:id" component = {UpdateENTSOEOperationalLimitTypeComponent}></Route> */}
                            <Route path = "/earthFaultCompensators" component = {ListEarthFaultCompensatorComponent}></Route>
                            <Route path = "/add-earthFaultCompensator/:id" component = {CreateEarthFaultCompensatorComponent}></Route>
                            <Route path = "/view-earthFaultCompensator/:id" component = {ViewEarthFaultCompensatorComponent}></Route>
                          {/* <Route path = "/update-earthFaultCompensator/:id" component = {UpdateEarthFaultCompensatorComponent}></Route> */}
                            <Route path = "/energyConsumers" component = {ListEnergyConsumerComponent}></Route>
                            <Route path = "/add-energyConsumer/:id" component = {CreateEnergyConsumerComponent}></Route>
                            <Route path = "/view-energyConsumer/:id" component = {ViewEnergyConsumerComponent}></Route>
                          {/* <Route path = "/update-energyConsumer/:id" component = {UpdateEnergyConsumerComponent}></Route> */}
                            <Route path = "/equipmentBoundaryVersions" component = {ListEquipmentBoundaryVersionComponent}></Route>
                            <Route path = "/add-equipmentBoundaryVersion/:id" component = {CreateEquipmentBoundaryVersionComponent}></Route>
                            <Route path = "/view-equipmentBoundaryVersion/:id" component = {ViewEquipmentBoundaryVersionComponent}></Route>
                          {/* <Route path = "/update-equipmentBoundaryVersion/:id" component = {UpdateEquipmentBoundaryVersionComponent}></Route> */}
                            <Route path = "/equipmentVersions" component = {ListEquipmentVersionComponent}></Route>
                            <Route path = "/add-equipmentVersion/:id" component = {CreateEquipmentVersionComponent}></Route>
                            <Route path = "/view-equipmentVersion/:id" component = {ViewEquipmentVersionComponent}></Route>
                          {/* <Route path = "/update-equipmentVersion/:id" component = {UpdateEquipmentVersionComponent}></Route> */}
                            <Route path = "/equivalentBranchs" component = {ListEquivalentBranchComponent}></Route>
                            <Route path = "/add-equivalentBranch/:id" component = {CreateEquivalentBranchComponent}></Route>
                            <Route path = "/view-equivalentBranch/:id" component = {ViewEquivalentBranchComponent}></Route>
                          {/* <Route path = "/update-equivalentBranch/:id" component = {UpdateEquivalentBranchComponent}></Route> */}
                            <Route path = "/equivalentInjections" component = {ListEquivalentInjectionComponent}></Route>
                            <Route path = "/add-equivalentInjection/:id" component = {CreateEquivalentInjectionComponent}></Route>
                            <Route path = "/view-equivalentInjection/:id" component = {ViewEquivalentInjectionComponent}></Route>
                          {/* <Route path = "/update-equivalentInjection/:id" component = {UpdateEquivalentInjectionComponent}></Route> */}
                            <Route path = "/equivalentShunts" component = {ListEquivalentShuntComponent}></Route>
                            <Route path = "/add-equivalentShunt/:id" component = {CreateEquivalentShuntComponent}></Route>
                            <Route path = "/view-equivalentShunt/:id" component = {ViewEquivalentShuntComponent}></Route>
                          {/* <Route path = "/update-equivalentShunt/:id" component = {UpdateEquivalentShuntComponent}></Route> */}
                            <Route path = "/excAC1As" component = {ListExcAC1AComponent}></Route>
                            <Route path = "/add-excAC1A/:id" component = {CreateExcAC1AComponent}></Route>
                            <Route path = "/view-excAC1A/:id" component = {ViewExcAC1AComponent}></Route>
                          {/* <Route path = "/update-excAC1A/:id" component = {UpdateExcAC1AComponent}></Route> */}
                            <Route path = "/excAC2As" component = {ListExcAC2AComponent}></Route>
                            <Route path = "/add-excAC2A/:id" component = {CreateExcAC2AComponent}></Route>
                            <Route path = "/view-excAC2A/:id" component = {ViewExcAC2AComponent}></Route>
                          {/* <Route path = "/update-excAC2A/:id" component = {UpdateExcAC2AComponent}></Route> */}
                            <Route path = "/excAC3As" component = {ListExcAC3AComponent}></Route>
                            <Route path = "/add-excAC3A/:id" component = {CreateExcAC3AComponent}></Route>
                            <Route path = "/view-excAC3A/:id" component = {ViewExcAC3AComponent}></Route>
                          {/* <Route path = "/update-excAC3A/:id" component = {UpdateExcAC3AComponent}></Route> */}
                            <Route path = "/excAC4As" component = {ListExcAC4AComponent}></Route>
                            <Route path = "/add-excAC4A/:id" component = {CreateExcAC4AComponent}></Route>
                            <Route path = "/view-excAC4A/:id" component = {ViewExcAC4AComponent}></Route>
                          {/* <Route path = "/update-excAC4A/:id" component = {UpdateExcAC4AComponent}></Route> */}
                            <Route path = "/excAC5As" component = {ListExcAC5AComponent}></Route>
                            <Route path = "/add-excAC5A/:id" component = {CreateExcAC5AComponent}></Route>
                            <Route path = "/view-excAC5A/:id" component = {ViewExcAC5AComponent}></Route>
                          {/* <Route path = "/update-excAC5A/:id" component = {UpdateExcAC5AComponent}></Route> */}
                            <Route path = "/excAC6As" component = {ListExcAC6AComponent}></Route>
                            <Route path = "/add-excAC6A/:id" component = {CreateExcAC6AComponent}></Route>
                            <Route path = "/view-excAC6A/:id" component = {ViewExcAC6AComponent}></Route>
                          {/* <Route path = "/update-excAC6A/:id" component = {UpdateExcAC6AComponent}></Route> */}
                            <Route path = "/excAC8Bs" component = {ListExcAC8BComponent}></Route>
                            <Route path = "/add-excAC8B/:id" component = {CreateExcAC8BComponent}></Route>
                            <Route path = "/view-excAC8B/:id" component = {ViewExcAC8BComponent}></Route>
                          {/* <Route path = "/update-excAC8B/:id" component = {UpdateExcAC8BComponent}></Route> */}
                            <Route path = "/excANSs" component = {ListExcANSComponent}></Route>
                            <Route path = "/add-excANS/:id" component = {CreateExcANSComponent}></Route>
                            <Route path = "/view-excANS/:id" component = {ViewExcANSComponent}></Route>
                          {/* <Route path = "/update-excANS/:id" component = {UpdateExcANSComponent}></Route> */}
                            <Route path = "/excAVR1s" component = {ListExcAVR1Component}></Route>
                            <Route path = "/add-excAVR1/:id" component = {CreateExcAVR1Component}></Route>
                            <Route path = "/view-excAVR1/:id" component = {ViewExcAVR1Component}></Route>
                          {/* <Route path = "/update-excAVR1/:id" component = {UpdateExcAVR1Component}></Route> */}
                            <Route path = "/excAVR2s" component = {ListExcAVR2Component}></Route>
                            <Route path = "/add-excAVR2/:id" component = {CreateExcAVR2Component}></Route>
                            <Route path = "/view-excAVR2/:id" component = {ViewExcAVR2Component}></Route>
                          {/* <Route path = "/update-excAVR2/:id" component = {UpdateExcAVR2Component}></Route> */}
                            <Route path = "/excAVR3s" component = {ListExcAVR3Component}></Route>
                            <Route path = "/add-excAVR3/:id" component = {CreateExcAVR3Component}></Route>
                            <Route path = "/view-excAVR3/:id" component = {ViewExcAVR3Component}></Route>
                          {/* <Route path = "/update-excAVR3/:id" component = {UpdateExcAVR3Component}></Route> */}
                            <Route path = "/excAVR4s" component = {ListExcAVR4Component}></Route>
                            <Route path = "/add-excAVR4/:id" component = {CreateExcAVR4Component}></Route>
                            <Route path = "/view-excAVR4/:id" component = {ViewExcAVR4Component}></Route>
                          {/* <Route path = "/update-excAVR4/:id" component = {UpdateExcAVR4Component}></Route> */}
                            <Route path = "/excAVR5s" component = {ListExcAVR5Component}></Route>
                            <Route path = "/add-excAVR5/:id" component = {CreateExcAVR5Component}></Route>
                            <Route path = "/view-excAVR5/:id" component = {ViewExcAVR5Component}></Route>
                          {/* <Route path = "/update-excAVR5/:id" component = {UpdateExcAVR5Component}></Route> */}
                            <Route path = "/excAVR7s" component = {ListExcAVR7Component}></Route>
                            <Route path = "/add-excAVR7/:id" component = {CreateExcAVR7Component}></Route>
                            <Route path = "/view-excAVR7/:id" component = {ViewExcAVR7Component}></Route>
                          {/* <Route path = "/update-excAVR7/:id" component = {UpdateExcAVR7Component}></Route> */}
                            <Route path = "/excBBCs" component = {ListExcBBCComponent}></Route>
                            <Route path = "/add-excBBC/:id" component = {CreateExcBBCComponent}></Route>
                            <Route path = "/view-excBBC/:id" component = {ViewExcBBCComponent}></Route>
                          {/* <Route path = "/update-excBBC/:id" component = {UpdateExcBBCComponent}></Route> */}
                            <Route path = "/excCZs" component = {ListExcCZComponent}></Route>
                            <Route path = "/add-excCZ/:id" component = {CreateExcCZComponent}></Route>
                            <Route path = "/view-excCZ/:id" component = {ViewExcCZComponent}></Route>
                          {/* <Route path = "/update-excCZ/:id" component = {UpdateExcCZComponent}></Route> */}
                            <Route path = "/excDC1As" component = {ListExcDC1AComponent}></Route>
                            <Route path = "/add-excDC1A/:id" component = {CreateExcDC1AComponent}></Route>
                            <Route path = "/view-excDC1A/:id" component = {ViewExcDC1AComponent}></Route>
                          {/* <Route path = "/update-excDC1A/:id" component = {UpdateExcDC1AComponent}></Route> */}
                            <Route path = "/excDC2As" component = {ListExcDC2AComponent}></Route>
                            <Route path = "/add-excDC2A/:id" component = {CreateExcDC2AComponent}></Route>
                            <Route path = "/view-excDC2A/:id" component = {ViewExcDC2AComponent}></Route>
                          {/* <Route path = "/update-excDC2A/:id" component = {UpdateExcDC2AComponent}></Route> */}
                            <Route path = "/excDC3As" component = {ListExcDC3AComponent}></Route>
                            <Route path = "/add-excDC3A/:id" component = {CreateExcDC3AComponent}></Route>
                            <Route path = "/view-excDC3A/:id" component = {ViewExcDC3AComponent}></Route>
                          {/* <Route path = "/update-excDC3A/:id" component = {UpdateExcDC3AComponent}></Route> */}
                            <Route path = "/excDC3A1s" component = {ListExcDC3A1Component}></Route>
                            <Route path = "/add-excDC3A1/:id" component = {CreateExcDC3A1Component}></Route>
                            <Route path = "/view-excDC3A1/:id" component = {ViewExcDC3A1Component}></Route>
                          {/* <Route path = "/update-excDC3A1/:id" component = {UpdateExcDC3A1Component}></Route> */}
                            <Route path = "/excELIN1s" component = {ListExcELIN1Component}></Route>
                            <Route path = "/add-excELIN1/:id" component = {CreateExcELIN1Component}></Route>
                            <Route path = "/view-excELIN1/:id" component = {ViewExcELIN1Component}></Route>
                          {/* <Route path = "/update-excELIN1/:id" component = {UpdateExcELIN1Component}></Route> */}
                            <Route path = "/excELIN2s" component = {ListExcELIN2Component}></Route>
                            <Route path = "/add-excELIN2/:id" component = {CreateExcELIN2Component}></Route>
                            <Route path = "/view-excELIN2/:id" component = {ViewExcELIN2Component}></Route>
                          {/* <Route path = "/update-excELIN2/:id" component = {UpdateExcELIN2Component}></Route> */}
                            <Route path = "/excHUs" component = {ListExcHUComponent}></Route>
                            <Route path = "/add-excHU/:id" component = {CreateExcHUComponent}></Route>
                            <Route path = "/view-excHU/:id" component = {ViewExcHUComponent}></Route>
                          {/* <Route path = "/update-excHU/:id" component = {UpdateExcHUComponent}></Route> */}
                            <Route path = "/excIEEEAC1As" component = {ListExcIEEEAC1AComponent}></Route>
                            <Route path = "/add-excIEEEAC1A/:id" component = {CreateExcIEEEAC1AComponent}></Route>
                            <Route path = "/view-excIEEEAC1A/:id" component = {ViewExcIEEEAC1AComponent}></Route>
                          {/* <Route path = "/update-excIEEEAC1A/:id" component = {UpdateExcIEEEAC1AComponent}></Route> */}
                            <Route path = "/excIEEEAC2As" component = {ListExcIEEEAC2AComponent}></Route>
                            <Route path = "/add-excIEEEAC2A/:id" component = {CreateExcIEEEAC2AComponent}></Route>
                            <Route path = "/view-excIEEEAC2A/:id" component = {ViewExcIEEEAC2AComponent}></Route>
                          {/* <Route path = "/update-excIEEEAC2A/:id" component = {UpdateExcIEEEAC2AComponent}></Route> */}
                            <Route path = "/excIEEEAC3As" component = {ListExcIEEEAC3AComponent}></Route>
                            <Route path = "/add-excIEEEAC3A/:id" component = {CreateExcIEEEAC3AComponent}></Route>
                            <Route path = "/view-excIEEEAC3A/:id" component = {ViewExcIEEEAC3AComponent}></Route>
                          {/* <Route path = "/update-excIEEEAC3A/:id" component = {UpdateExcIEEEAC3AComponent}></Route> */}
                            <Route path = "/excIEEEAC4As" component = {ListExcIEEEAC4AComponent}></Route>
                            <Route path = "/add-excIEEEAC4A/:id" component = {CreateExcIEEEAC4AComponent}></Route>
                            <Route path = "/view-excIEEEAC4A/:id" component = {ViewExcIEEEAC4AComponent}></Route>
                          {/* <Route path = "/update-excIEEEAC4A/:id" component = {UpdateExcIEEEAC4AComponent}></Route> */}
                            <Route path = "/excIEEEAC5As" component = {ListExcIEEEAC5AComponent}></Route>
                            <Route path = "/add-excIEEEAC5A/:id" component = {CreateExcIEEEAC5AComponent}></Route>
                            <Route path = "/view-excIEEEAC5A/:id" component = {ViewExcIEEEAC5AComponent}></Route>
                          {/* <Route path = "/update-excIEEEAC5A/:id" component = {UpdateExcIEEEAC5AComponent}></Route> */}
                            <Route path = "/excIEEEAC6As" component = {ListExcIEEEAC6AComponent}></Route>
                            <Route path = "/add-excIEEEAC6A/:id" component = {CreateExcIEEEAC6AComponent}></Route>
                            <Route path = "/view-excIEEEAC6A/:id" component = {ViewExcIEEEAC6AComponent}></Route>
                          {/* <Route path = "/update-excIEEEAC6A/:id" component = {UpdateExcIEEEAC6AComponent}></Route> */}
                            <Route path = "/excIEEEAC7Bs" component = {ListExcIEEEAC7BComponent}></Route>
                            <Route path = "/add-excIEEEAC7B/:id" component = {CreateExcIEEEAC7BComponent}></Route>
                            <Route path = "/view-excIEEEAC7B/:id" component = {ViewExcIEEEAC7BComponent}></Route>
                          {/* <Route path = "/update-excIEEEAC7B/:id" component = {UpdateExcIEEEAC7BComponent}></Route> */}
                            <Route path = "/excIEEEAC8Bs" component = {ListExcIEEEAC8BComponent}></Route>
                            <Route path = "/add-excIEEEAC8B/:id" component = {CreateExcIEEEAC8BComponent}></Route>
                            <Route path = "/view-excIEEEAC8B/:id" component = {ViewExcIEEEAC8BComponent}></Route>
                          {/* <Route path = "/update-excIEEEAC8B/:id" component = {UpdateExcIEEEAC8BComponent}></Route> */}
                            <Route path = "/excIEEEDC1As" component = {ListExcIEEEDC1AComponent}></Route>
                            <Route path = "/add-excIEEEDC1A/:id" component = {CreateExcIEEEDC1AComponent}></Route>
                            <Route path = "/view-excIEEEDC1A/:id" component = {ViewExcIEEEDC1AComponent}></Route>
                          {/* <Route path = "/update-excIEEEDC1A/:id" component = {UpdateExcIEEEDC1AComponent}></Route> */}
                            <Route path = "/excIEEEDC2As" component = {ListExcIEEEDC2AComponent}></Route>
                            <Route path = "/add-excIEEEDC2A/:id" component = {CreateExcIEEEDC2AComponent}></Route>
                            <Route path = "/view-excIEEEDC2A/:id" component = {ViewExcIEEEDC2AComponent}></Route>
                          {/* <Route path = "/update-excIEEEDC2A/:id" component = {UpdateExcIEEEDC2AComponent}></Route> */}
                            <Route path = "/excIEEEDC3As" component = {ListExcIEEEDC3AComponent}></Route>
                            <Route path = "/add-excIEEEDC3A/:id" component = {CreateExcIEEEDC3AComponent}></Route>
                            <Route path = "/view-excIEEEDC3A/:id" component = {ViewExcIEEEDC3AComponent}></Route>
                          {/* <Route path = "/update-excIEEEDC3A/:id" component = {UpdateExcIEEEDC3AComponent}></Route> */}
                            <Route path = "/excIEEEDC4Bs" component = {ListExcIEEEDC4BComponent}></Route>
                            <Route path = "/add-excIEEEDC4B/:id" component = {CreateExcIEEEDC4BComponent}></Route>
                            <Route path = "/view-excIEEEDC4B/:id" component = {ViewExcIEEEDC4BComponent}></Route>
                          {/* <Route path = "/update-excIEEEDC4B/:id" component = {UpdateExcIEEEDC4BComponent}></Route> */}
                            <Route path = "/excIEEEST1As" component = {ListExcIEEEST1AComponent}></Route>
                            <Route path = "/add-excIEEEST1A/:id" component = {CreateExcIEEEST1AComponent}></Route>
                            <Route path = "/view-excIEEEST1A/:id" component = {ViewExcIEEEST1AComponent}></Route>
                          {/* <Route path = "/update-excIEEEST1A/:id" component = {UpdateExcIEEEST1AComponent}></Route> */}
                            <Route path = "/excIEEEST2As" component = {ListExcIEEEST2AComponent}></Route>
                            <Route path = "/add-excIEEEST2A/:id" component = {CreateExcIEEEST2AComponent}></Route>
                            <Route path = "/view-excIEEEST2A/:id" component = {ViewExcIEEEST2AComponent}></Route>
                          {/* <Route path = "/update-excIEEEST2A/:id" component = {UpdateExcIEEEST2AComponent}></Route> */}
                            <Route path = "/excIEEEST3As" component = {ListExcIEEEST3AComponent}></Route>
                            <Route path = "/add-excIEEEST3A/:id" component = {CreateExcIEEEST3AComponent}></Route>
                            <Route path = "/view-excIEEEST3A/:id" component = {ViewExcIEEEST3AComponent}></Route>
                          {/* <Route path = "/update-excIEEEST3A/:id" component = {UpdateExcIEEEST3AComponent}></Route> */}
                            <Route path = "/excIEEEST4Bs" component = {ListExcIEEEST4BComponent}></Route>
                            <Route path = "/add-excIEEEST4B/:id" component = {CreateExcIEEEST4BComponent}></Route>
                            <Route path = "/view-excIEEEST4B/:id" component = {ViewExcIEEEST4BComponent}></Route>
                          {/* <Route path = "/update-excIEEEST4B/:id" component = {UpdateExcIEEEST4BComponent}></Route> */}
                            <Route path = "/excIEEEST5Bs" component = {ListExcIEEEST5BComponent}></Route>
                            <Route path = "/add-excIEEEST5B/:id" component = {CreateExcIEEEST5BComponent}></Route>
                            <Route path = "/view-excIEEEST5B/:id" component = {ViewExcIEEEST5BComponent}></Route>
                          {/* <Route path = "/update-excIEEEST5B/:id" component = {UpdateExcIEEEST5BComponent}></Route> */}
                            <Route path = "/excIEEEST6Bs" component = {ListExcIEEEST6BComponent}></Route>
                            <Route path = "/add-excIEEEST6B/:id" component = {CreateExcIEEEST6BComponent}></Route>
                            <Route path = "/view-excIEEEST6B/:id" component = {ViewExcIEEEST6BComponent}></Route>
                          {/* <Route path = "/update-excIEEEST6B/:id" component = {UpdateExcIEEEST6BComponent}></Route> */}
                            <Route path = "/excIEEEST7Bs" component = {ListExcIEEEST7BComponent}></Route>
                            <Route path = "/add-excIEEEST7B/:id" component = {CreateExcIEEEST7BComponent}></Route>
                            <Route path = "/view-excIEEEST7B/:id" component = {ViewExcIEEEST7BComponent}></Route>
                          {/* <Route path = "/update-excIEEEST7B/:id" component = {UpdateExcIEEEST7BComponent}></Route> */}
                            <Route path = "/excOEX3Ts" component = {ListExcOEX3TComponent}></Route>
                            <Route path = "/add-excOEX3T/:id" component = {CreateExcOEX3TComponent}></Route>
                            <Route path = "/view-excOEX3T/:id" component = {ViewExcOEX3TComponent}></Route>
                          {/* <Route path = "/update-excOEX3T/:id" component = {UpdateExcOEX3TComponent}></Route> */}
                            <Route path = "/excPICs" component = {ListExcPICComponent}></Route>
                            <Route path = "/add-excPIC/:id" component = {CreateExcPICComponent}></Route>
                            <Route path = "/view-excPIC/:id" component = {ViewExcPICComponent}></Route>
                          {/* <Route path = "/update-excPIC/:id" component = {UpdateExcPICComponent}></Route> */}
                            <Route path = "/excREXSs" component = {ListExcREXSComponent}></Route>
                            <Route path = "/add-excREXS/:id" component = {CreateExcREXSComponent}></Route>
                            <Route path = "/view-excREXS/:id" component = {ViewExcREXSComponent}></Route>
                          {/* <Route path = "/update-excREXS/:id" component = {UpdateExcREXSComponent}></Route> */}
                            <Route path = "/excSCRXs" component = {ListExcSCRXComponent}></Route>
                            <Route path = "/add-excSCRX/:id" component = {CreateExcSCRXComponent}></Route>
                            <Route path = "/view-excSCRX/:id" component = {ViewExcSCRXComponent}></Route>
                          {/* <Route path = "/update-excSCRX/:id" component = {UpdateExcSCRXComponent}></Route> */}
                            <Route path = "/excSEXSs" component = {ListExcSEXSComponent}></Route>
                            <Route path = "/add-excSEXS/:id" component = {CreateExcSEXSComponent}></Route>
                            <Route path = "/view-excSEXS/:id" component = {ViewExcSEXSComponent}></Route>
                          {/* <Route path = "/update-excSEXS/:id" component = {UpdateExcSEXSComponent}></Route> */}
                            <Route path = "/excSKs" component = {ListExcSKComponent}></Route>
                            <Route path = "/add-excSK/:id" component = {CreateExcSKComponent}></Route>
                            <Route path = "/view-excSK/:id" component = {ViewExcSKComponent}></Route>
                          {/* <Route path = "/update-excSK/:id" component = {UpdateExcSKComponent}></Route> */}
                            <Route path = "/excST1As" component = {ListExcST1AComponent}></Route>
                            <Route path = "/add-excST1A/:id" component = {CreateExcST1AComponent}></Route>
                            <Route path = "/view-excST1A/:id" component = {ViewExcST1AComponent}></Route>
                          {/* <Route path = "/update-excST1A/:id" component = {UpdateExcST1AComponent}></Route> */}
                            <Route path = "/excST2As" component = {ListExcST2AComponent}></Route>
                            <Route path = "/add-excST2A/:id" component = {CreateExcST2AComponent}></Route>
                            <Route path = "/view-excST2A/:id" component = {ViewExcST2AComponent}></Route>
                          {/* <Route path = "/update-excST2A/:id" component = {UpdateExcST2AComponent}></Route> */}
                            <Route path = "/excST3As" component = {ListExcST3AComponent}></Route>
                            <Route path = "/add-excST3A/:id" component = {CreateExcST3AComponent}></Route>
                            <Route path = "/view-excST3A/:id" component = {ViewExcST3AComponent}></Route>
                          {/* <Route path = "/update-excST3A/:id" component = {UpdateExcST3AComponent}></Route> */}
                            <Route path = "/excST4Bs" component = {ListExcST4BComponent}></Route>
                            <Route path = "/add-excST4B/:id" component = {CreateExcST4BComponent}></Route>
                            <Route path = "/view-excST4B/:id" component = {ViewExcST4BComponent}></Route>
                          {/* <Route path = "/update-excST4B/:id" component = {UpdateExcST4BComponent}></Route> */}
                            <Route path = "/excST6Bs" component = {ListExcST6BComponent}></Route>
                            <Route path = "/add-excST6B/:id" component = {CreateExcST6BComponent}></Route>
                            <Route path = "/view-excST6B/:id" component = {ViewExcST6BComponent}></Route>
                          {/* <Route path = "/update-excST6B/:id" component = {UpdateExcST6BComponent}></Route> */}
                            <Route path = "/excST7Bs" component = {ListExcST7BComponent}></Route>
                            <Route path = "/add-excST7B/:id" component = {CreateExcST7BComponent}></Route>
                            <Route path = "/view-excST7B/:id" component = {ViewExcST7BComponent}></Route>
                          {/* <Route path = "/update-excST7B/:id" component = {UpdateExcST7BComponent}></Route> */}
                            <Route path = "/excitationSystemUserDefineds" component = {ListExcitationSystemUserDefinedComponent}></Route>
                            <Route path = "/add-excitationSystemUserDefined/:id" component = {CreateExcitationSystemUserDefinedComponent}></Route>
                            <Route path = "/view-excitationSystemUserDefined/:id" component = {ViewExcitationSystemUserDefinedComponent}></Route>
                          {/* <Route path = "/update-excitationSystemUserDefined/:id" component = {UpdateExcitationSystemUserDefinedComponent}></Route> */}
                            <Route path = "/extensionVersions" component = {ListExtensionVersionComponent}></Route>
                            <Route path = "/add-extensionVersion/:id" component = {CreateExtensionVersionComponent}></Route>
                            <Route path = "/view-extensionVersion/:id" component = {ViewExtensionVersionComponent}></Route>
                          {/* <Route path = "/update-extensionVersion/:id" component = {UpdateExtensionVersionComponent}></Route> */}
                            <Route path = "/externalNetworkInjections" component = {ListExternalNetworkInjectionComponent}></Route>
                            <Route path = "/add-externalNetworkInjection/:id" component = {CreateExternalNetworkInjectionComponent}></Route>
                            <Route path = "/view-externalNetworkInjection/:id" component = {ViewExternalNetworkInjectionComponent}></Route>
                          {/* <Route path = "/update-externalNetworkInjection/:id" component = {UpdateExternalNetworkInjectionComponent}></Route> */}
                            <Route path = "/fossilFuels" component = {ListFossilFuelComponent}></Route>
                            <Route path = "/add-fossilFuel/:id" component = {CreateFossilFuelComponent}></Route>
                            <Route path = "/view-fossilFuel/:id" component = {ViewFossilFuelComponent}></Route>
                          {/* <Route path = "/update-fossilFuel/:id" component = {UpdateFossilFuelComponent}></Route> */}
                            <Route path = "/frequencys" component = {ListFrequencyComponent}></Route>
                            <Route path = "/add-frequency/:id" component = {CreateFrequencyComponent}></Route>
                            <Route path = "/view-frequency/:id" component = {ViewFrequencyComponent}></Route>
                          {/* <Route path = "/update-frequency/:id" component = {UpdateFrequencyComponent}></Route> */}
                            <Route path = "/genICompensationForGenJs" component = {ListGenICompensationForGenJComponent}></Route>
                            <Route path = "/add-genICompensationForGenJ/:id" component = {CreateGenICompensationForGenJComponent}></Route>
                            <Route path = "/view-genICompensationForGenJ/:id" component = {ViewGenICompensationForGenJComponent}></Route>
                          {/* <Route path = "/update-genICompensationForGenJ/:id" component = {UpdateGenICompensationForGenJComponent}></Route> */}
                            <Route path = "/generatingUnits" component = {ListGeneratingUnitComponent}></Route>
                            <Route path = "/add-generatingUnit/:id" component = {CreateGeneratingUnitComponent}></Route>
                            <Route path = "/view-generatingUnit/:id" component = {ViewGeneratingUnitComponent}></Route>
                          {/* <Route path = "/update-generatingUnit/:id" component = {UpdateGeneratingUnitComponent}></Route> */}
                            <Route path = "/geographicalLocationVersions" component = {ListGeographicalLocationVersionComponent}></Route>
                            <Route path = "/add-geographicalLocationVersion/:id" component = {CreateGeographicalLocationVersionComponent}></Route>
                            <Route path = "/view-geographicalLocationVersion/:id" component = {ViewGeographicalLocationVersionComponent}></Route>
                          {/* <Route path = "/update-geographicalLocationVersion/:id" component = {UpdateGeographicalLocationVersionComponent}></Route> */}
                            <Route path = "/govCT1s" component = {ListGovCT1Component}></Route>
                            <Route path = "/add-govCT1/:id" component = {CreateGovCT1Component}></Route>
                            <Route path = "/view-govCT1/:id" component = {ViewGovCT1Component}></Route>
                          {/* <Route path = "/update-govCT1/:id" component = {UpdateGovCT1Component}></Route> */}
                            <Route path = "/govCT2s" component = {ListGovCT2Component}></Route>
                            <Route path = "/add-govCT2/:id" component = {CreateGovCT2Component}></Route>
                            <Route path = "/view-govCT2/:id" component = {ViewGovCT2Component}></Route>
                          {/* <Route path = "/update-govCT2/:id" component = {UpdateGovCT2Component}></Route> */}
                            <Route path = "/govGASTs" component = {ListGovGASTComponent}></Route>
                            <Route path = "/add-govGAST/:id" component = {CreateGovGASTComponent}></Route>
                            <Route path = "/view-govGAST/:id" component = {ViewGovGASTComponent}></Route>
                          {/* <Route path = "/update-govGAST/:id" component = {UpdateGovGASTComponent}></Route> */}
                            <Route path = "/govGAST1s" component = {ListGovGAST1Component}></Route>
                            <Route path = "/add-govGAST1/:id" component = {CreateGovGAST1Component}></Route>
                            <Route path = "/view-govGAST1/:id" component = {ViewGovGAST1Component}></Route>
                          {/* <Route path = "/update-govGAST1/:id" component = {UpdateGovGAST1Component}></Route> */}
                            <Route path = "/govGAST2s" component = {ListGovGAST2Component}></Route>
                            <Route path = "/add-govGAST2/:id" component = {CreateGovGAST2Component}></Route>
                            <Route path = "/view-govGAST2/:id" component = {ViewGovGAST2Component}></Route>
                          {/* <Route path = "/update-govGAST2/:id" component = {UpdateGovGAST2Component}></Route> */}
                            <Route path = "/govGAST3s" component = {ListGovGAST3Component}></Route>
                            <Route path = "/add-govGAST3/:id" component = {CreateGovGAST3Component}></Route>
                            <Route path = "/view-govGAST3/:id" component = {ViewGovGAST3Component}></Route>
                          {/* <Route path = "/update-govGAST3/:id" component = {UpdateGovGAST3Component}></Route> */}
                            <Route path = "/govGAST4s" component = {ListGovGAST4Component}></Route>
                            <Route path = "/add-govGAST4/:id" component = {CreateGovGAST4Component}></Route>
                            <Route path = "/view-govGAST4/:id" component = {ViewGovGAST4Component}></Route>
                          {/* <Route path = "/update-govGAST4/:id" component = {UpdateGovGAST4Component}></Route> */}
                            <Route path = "/govGASTWDs" component = {ListGovGASTWDComponent}></Route>
                            <Route path = "/add-govGASTWD/:id" component = {CreateGovGASTWDComponent}></Route>
                            <Route path = "/view-govGASTWD/:id" component = {ViewGovGASTWDComponent}></Route>
                          {/* <Route path = "/update-govGASTWD/:id" component = {UpdateGovGASTWDComponent}></Route> */}
                            <Route path = "/govHydro1s" component = {ListGovHydro1Component}></Route>
                            <Route path = "/add-govHydro1/:id" component = {CreateGovHydro1Component}></Route>
                            <Route path = "/view-govHydro1/:id" component = {ViewGovHydro1Component}></Route>
                          {/* <Route path = "/update-govHydro1/:id" component = {UpdateGovHydro1Component}></Route> */}
                            <Route path = "/govHydro2s" component = {ListGovHydro2Component}></Route>
                            <Route path = "/add-govHydro2/:id" component = {CreateGovHydro2Component}></Route>
                            <Route path = "/view-govHydro2/:id" component = {ViewGovHydro2Component}></Route>
                          {/* <Route path = "/update-govHydro2/:id" component = {UpdateGovHydro2Component}></Route> */}
                            <Route path = "/govHydro3s" component = {ListGovHydro3Component}></Route>
                            <Route path = "/add-govHydro3/:id" component = {CreateGovHydro3Component}></Route>
                            <Route path = "/view-govHydro3/:id" component = {ViewGovHydro3Component}></Route>
                          {/* <Route path = "/update-govHydro3/:id" component = {UpdateGovHydro3Component}></Route> */}
                            <Route path = "/govHydro4s" component = {ListGovHydro4Component}></Route>
                            <Route path = "/add-govHydro4/:id" component = {CreateGovHydro4Component}></Route>
                            <Route path = "/view-govHydro4/:id" component = {ViewGovHydro4Component}></Route>
                          {/* <Route path = "/update-govHydro4/:id" component = {UpdateGovHydro4Component}></Route> */}
                            <Route path = "/govHydroDDs" component = {ListGovHydroDDComponent}></Route>
                            <Route path = "/add-govHydroDD/:id" component = {CreateGovHydroDDComponent}></Route>
                            <Route path = "/view-govHydroDD/:id" component = {ViewGovHydroDDComponent}></Route>
                          {/* <Route path = "/update-govHydroDD/:id" component = {UpdateGovHydroDDComponent}></Route> */}
                            <Route path = "/govHydroFranciss" component = {ListGovHydroFrancisComponent}></Route>
                            <Route path = "/add-govHydroFrancis/:id" component = {CreateGovHydroFrancisComponent}></Route>
                            <Route path = "/view-govHydroFrancis/:id" component = {ViewGovHydroFrancisComponent}></Route>
                          {/* <Route path = "/update-govHydroFrancis/:id" component = {UpdateGovHydroFrancisComponent}></Route> */}
                            <Route path = "/govHydroIEEE0s" component = {ListGovHydroIEEE0Component}></Route>
                            <Route path = "/add-govHydroIEEE0/:id" component = {CreateGovHydroIEEE0Component}></Route>
                            <Route path = "/view-govHydroIEEE0/:id" component = {ViewGovHydroIEEE0Component}></Route>
                          {/* <Route path = "/update-govHydroIEEE0/:id" component = {UpdateGovHydroIEEE0Component}></Route> */}
                            <Route path = "/govHydroIEEE2s" component = {ListGovHydroIEEE2Component}></Route>
                            <Route path = "/add-govHydroIEEE2/:id" component = {CreateGovHydroIEEE2Component}></Route>
                            <Route path = "/view-govHydroIEEE2/:id" component = {ViewGovHydroIEEE2Component}></Route>
                          {/* <Route path = "/update-govHydroIEEE2/:id" component = {UpdateGovHydroIEEE2Component}></Route> */}
                            <Route path = "/govHydroPIDs" component = {ListGovHydroPIDComponent}></Route>
                            <Route path = "/add-govHydroPID/:id" component = {CreateGovHydroPIDComponent}></Route>
                            <Route path = "/view-govHydroPID/:id" component = {ViewGovHydroPIDComponent}></Route>
                          {/* <Route path = "/update-govHydroPID/:id" component = {UpdateGovHydroPIDComponent}></Route> */}
                            <Route path = "/govHydroPID2s" component = {ListGovHydroPID2Component}></Route>
                            <Route path = "/add-govHydroPID2/:id" component = {CreateGovHydroPID2Component}></Route>
                            <Route path = "/view-govHydroPID2/:id" component = {ViewGovHydroPID2Component}></Route>
                          {/* <Route path = "/update-govHydroPID2/:id" component = {UpdateGovHydroPID2Component}></Route> */}
                            <Route path = "/govHydroPeltons" component = {ListGovHydroPeltonComponent}></Route>
                            <Route path = "/add-govHydroPelton/:id" component = {CreateGovHydroPeltonComponent}></Route>
                            <Route path = "/view-govHydroPelton/:id" component = {ViewGovHydroPeltonComponent}></Route>
                          {/* <Route path = "/update-govHydroPelton/:id" component = {UpdateGovHydroPeltonComponent}></Route> */}
                            <Route path = "/govHydroRs" component = {ListGovHydroRComponent}></Route>
                            <Route path = "/add-govHydroR/:id" component = {CreateGovHydroRComponent}></Route>
                            <Route path = "/view-govHydroR/:id" component = {ViewGovHydroRComponent}></Route>
                          {/* <Route path = "/update-govHydroR/:id" component = {UpdateGovHydroRComponent}></Route> */}
                            <Route path = "/govHydroWEHs" component = {ListGovHydroWEHComponent}></Route>
                            <Route path = "/add-govHydroWEH/:id" component = {CreateGovHydroWEHComponent}></Route>
                            <Route path = "/view-govHydroWEH/:id" component = {ViewGovHydroWEHComponent}></Route>
                          {/* <Route path = "/update-govHydroWEH/:id" component = {UpdateGovHydroWEHComponent}></Route> */}
                            <Route path = "/govHydroWPIDs" component = {ListGovHydroWPIDComponent}></Route>
                            <Route path = "/add-govHydroWPID/:id" component = {CreateGovHydroWPIDComponent}></Route>
                            <Route path = "/view-govHydroWPID/:id" component = {ViewGovHydroWPIDComponent}></Route>
                          {/* <Route path = "/update-govHydroWPID/:id" component = {UpdateGovHydroWPIDComponent}></Route> */}
                            <Route path = "/govSteam0s" component = {ListGovSteam0Component}></Route>
                            <Route path = "/add-govSteam0/:id" component = {CreateGovSteam0Component}></Route>
                            <Route path = "/view-govSteam0/:id" component = {ViewGovSteam0Component}></Route>
                          {/* <Route path = "/update-govSteam0/:id" component = {UpdateGovSteam0Component}></Route> */}
                            <Route path = "/govSteam1s" component = {ListGovSteam1Component}></Route>
                            <Route path = "/add-govSteam1/:id" component = {CreateGovSteam1Component}></Route>
                            <Route path = "/view-govSteam1/:id" component = {ViewGovSteam1Component}></Route>
                          {/* <Route path = "/update-govSteam1/:id" component = {UpdateGovSteam1Component}></Route> */}
                            <Route path = "/govSteam2s" component = {ListGovSteam2Component}></Route>
                            <Route path = "/add-govSteam2/:id" component = {CreateGovSteam2Component}></Route>
                            <Route path = "/view-govSteam2/:id" component = {ViewGovSteam2Component}></Route>
                          {/* <Route path = "/update-govSteam2/:id" component = {UpdateGovSteam2Component}></Route> */}
                            <Route path = "/govSteamCCs" component = {ListGovSteamCCComponent}></Route>
                            <Route path = "/add-govSteamCC/:id" component = {CreateGovSteamCCComponent}></Route>
                            <Route path = "/view-govSteamCC/:id" component = {ViewGovSteamCCComponent}></Route>
                          {/* <Route path = "/update-govSteamCC/:id" component = {UpdateGovSteamCCComponent}></Route> */}
                            <Route path = "/govSteamEUs" component = {ListGovSteamEUComponent}></Route>
                            <Route path = "/add-govSteamEU/:id" component = {CreateGovSteamEUComponent}></Route>
                            <Route path = "/view-govSteamEU/:id" component = {ViewGovSteamEUComponent}></Route>
                          {/* <Route path = "/update-govSteamEU/:id" component = {UpdateGovSteamEUComponent}></Route> */}
                            <Route path = "/govSteamFV2s" component = {ListGovSteamFV2Component}></Route>
                            <Route path = "/add-govSteamFV2/:id" component = {CreateGovSteamFV2Component}></Route>
                            <Route path = "/view-govSteamFV2/:id" component = {ViewGovSteamFV2Component}></Route>
                          {/* <Route path = "/update-govSteamFV2/:id" component = {UpdateGovSteamFV2Component}></Route> */}
                            <Route path = "/govSteamFV3s" component = {ListGovSteamFV3Component}></Route>
                            <Route path = "/add-govSteamFV3/:id" component = {CreateGovSteamFV3Component}></Route>
                            <Route path = "/view-govSteamFV3/:id" component = {ViewGovSteamFV3Component}></Route>
                          {/* <Route path = "/update-govSteamFV3/:id" component = {UpdateGovSteamFV3Component}></Route> */}
                            <Route path = "/govSteamFV4s" component = {ListGovSteamFV4Component}></Route>
                            <Route path = "/add-govSteamFV4/:id" component = {CreateGovSteamFV4Component}></Route>
                            <Route path = "/view-govSteamFV4/:id" component = {ViewGovSteamFV4Component}></Route>
                          {/* <Route path = "/update-govSteamFV4/:id" component = {UpdateGovSteamFV4Component}></Route> */}
                            <Route path = "/govSteamIEEE1s" component = {ListGovSteamIEEE1Component}></Route>
                            <Route path = "/add-govSteamIEEE1/:id" component = {CreateGovSteamIEEE1Component}></Route>
                            <Route path = "/view-govSteamIEEE1/:id" component = {ViewGovSteamIEEE1Component}></Route>
                          {/* <Route path = "/update-govSteamIEEE1/:id" component = {UpdateGovSteamIEEE1Component}></Route> */}
                            <Route path = "/govSteamSGOs" component = {ListGovSteamSGOComponent}></Route>
                            <Route path = "/add-govSteamSGO/:id" component = {CreateGovSteamSGOComponent}></Route>
                            <Route path = "/view-govSteamSGO/:id" component = {ViewGovSteamSGOComponent}></Route>
                          {/* <Route path = "/update-govSteamSGO/:id" component = {UpdateGovSteamSGOComponent}></Route> */}
                            <Route path = "/groundingImpedances" component = {ListGroundingImpedanceComponent}></Route>
                            <Route path = "/add-groundingImpedance/:id" component = {CreateGroundingImpedanceComponent}></Route>
                            <Route path = "/view-groundingImpedance/:id" component = {ViewGroundingImpedanceComponent}></Route>
                          {/* <Route path = "/update-groundingImpedance/:id" component = {UpdateGroundingImpedanceComponent}></Route> */}
                            <Route path = "/hydroGeneratingUnits" component = {ListHydroGeneratingUnitComponent}></Route>
                            <Route path = "/add-hydroGeneratingUnit/:id" component = {CreateHydroGeneratingUnitComponent}></Route>
                            <Route path = "/view-hydroGeneratingUnit/:id" component = {ViewHydroGeneratingUnitComponent}></Route>
                          {/* <Route path = "/update-hydroGeneratingUnit/:id" component = {UpdateHydroGeneratingUnitComponent}></Route> */}
                            <Route path = "/hydroPowerPlants" component = {ListHydroPowerPlantComponent}></Route>
                            <Route path = "/add-hydroPowerPlant/:id" component = {CreateHydroPowerPlantComponent}></Route>
                            <Route path = "/view-hydroPowerPlant/:id" component = {ViewHydroPowerPlantComponent}></Route>
                          {/* <Route path = "/update-hydroPowerPlant/:id" component = {UpdateHydroPowerPlantComponent}></Route> */}
                            <Route path = "/identifiedObjects" component = {ListIdentifiedObjectComponent}></Route>
                            <Route path = "/add-identifiedObject/:id" component = {CreateIdentifiedObjectComponent}></Route>
                            <Route path = "/view-identifiedObject/:id" component = {ViewIdentifiedObjectComponent}></Route>
                          {/* <Route path = "/update-identifiedObject/:id" component = {UpdateIdentifiedObjectComponent}></Route> */}
                            <Route path = "/inductances" component = {ListInductanceComponent}></Route>
                            <Route path = "/add-inductance/:id" component = {CreateInductanceComponent}></Route>
                            <Route path = "/view-inductance/:id" component = {ViewInductanceComponent}></Route>
                          {/* <Route path = "/update-inductance/:id" component = {UpdateInductanceComponent}></Route> */}
                            <Route path = "/inductancePerLengths" component = {ListInductancePerLengthComponent}></Route>
                            <Route path = "/add-inductancePerLength/:id" component = {CreateInductancePerLengthComponent}></Route>
                            <Route path = "/view-inductancePerLength/:id" component = {ViewInductancePerLengthComponent}></Route>
                          {/* <Route path = "/update-inductancePerLength/:id" component = {UpdateInductancePerLengthComponent}></Route> */}
                            <Route path = "/lengths" component = {ListLengthComponent}></Route>
                            <Route path = "/add-length/:id" component = {CreateLengthComponent}></Route>
                            <Route path = "/view-length/:id" component = {ViewLengthComponent}></Route>
                          {/* <Route path = "/update-length/:id" component = {UpdateLengthComponent}></Route> */}
                            <Route path = "/limitSets" component = {ListLimitSetComponent}></Route>
                            <Route path = "/add-limitSet/:id" component = {CreateLimitSetComponent}></Route>
                            <Route path = "/view-limitSet/:id" component = {ViewLimitSetComponent}></Route>
                          {/* <Route path = "/update-limitSet/:id" component = {UpdateLimitSetComponent}></Route> */}
                            <Route path = "/linearShuntCompensators" component = {ListLinearShuntCompensatorComponent}></Route>
                            <Route path = "/add-linearShuntCompensator/:id" component = {CreateLinearShuntCompensatorComponent}></Route>
                            <Route path = "/view-linearShuntCompensator/:id" component = {ViewLinearShuntCompensatorComponent}></Route>
                          {/* <Route path = "/update-linearShuntCompensator/:id" component = {UpdateLinearShuntCompensatorComponent}></Route> */}
                            <Route path = "/loadComposites" component = {ListLoadCompositeComponent}></Route>
                            <Route path = "/add-loadComposite/:id" component = {CreateLoadCompositeComponent}></Route>
                            <Route path = "/view-loadComposite/:id" component = {ViewLoadCompositeComponent}></Route>
                          {/* <Route path = "/update-loadComposite/:id" component = {UpdateLoadCompositeComponent}></Route> */}
                            <Route path = "/loadGenericNonLinears" component = {ListLoadGenericNonLinearComponent}></Route>
                            <Route path = "/add-loadGenericNonLinear/:id" component = {CreateLoadGenericNonLinearComponent}></Route>
                            <Route path = "/view-loadGenericNonLinear/:id" component = {ViewLoadGenericNonLinearComponent}></Route>
                          {/* <Route path = "/update-loadGenericNonLinear/:id" component = {UpdateLoadGenericNonLinearComponent}></Route> */}
                            <Route path = "/loadMotors" component = {ListLoadMotorComponent}></Route>
                            <Route path = "/add-loadMotor/:id" component = {CreateLoadMotorComponent}></Route>
                            <Route path = "/view-loadMotor/:id" component = {ViewLoadMotorComponent}></Route>
                          {/* <Route path = "/update-loadMotor/:id" component = {UpdateLoadMotorComponent}></Route> */}
                            <Route path = "/loadResponseCharacteristics" component = {ListLoadResponseCharacteristicComponent}></Route>
                            <Route path = "/add-loadResponseCharacteristic/:id" component = {CreateLoadResponseCharacteristicComponent}></Route>
                            <Route path = "/view-loadResponseCharacteristic/:id" component = {ViewLoadResponseCharacteristicComponent}></Route>
                          {/* <Route path = "/update-loadResponseCharacteristic/:id" component = {UpdateLoadResponseCharacteristicComponent}></Route> */}
                            <Route path = "/loadStatics" component = {ListLoadStaticComponent}></Route>
                            <Route path = "/add-loadStatic/:id" component = {CreateLoadStaticComponent}></Route>
                            <Route path = "/view-loadStatic/:id" component = {ViewLoadStaticComponent}></Route>
                          {/* <Route path = "/update-loadStatic/:id" component = {UpdateLoadStaticComponent}></Route> */}
                            <Route path = "/loadUserDefineds" component = {ListLoadUserDefinedComponent}></Route>
                            <Route path = "/add-loadUserDefined/:id" component = {CreateLoadUserDefinedComponent}></Route>
                            <Route path = "/view-loadUserDefined/:id" component = {ViewLoadUserDefinedComponent}></Route>
                          {/* <Route path = "/update-loadUserDefined/:id" component = {UpdateLoadUserDefinedComponent}></Route> */}
                            <Route path = "/measurements" component = {ListMeasurementComponent}></Route>
                            <Route path = "/add-measurement/:id" component = {CreateMeasurementComponent}></Route>
                            <Route path = "/view-measurement/:id" component = {ViewMeasurementComponent}></Route>
                          {/* <Route path = "/update-measurement/:id" component = {UpdateMeasurementComponent}></Route> */}
                            <Route path = "/measurementValues" component = {ListMeasurementValueComponent}></Route>
                            <Route path = "/add-measurementValue/:id" component = {CreateMeasurementValueComponent}></Route>
                            <Route path = "/view-measurementValue/:id" component = {ViewMeasurementValueComponent}></Route>
                          {/* <Route path = "/update-measurementValue/:id" component = {UpdateMeasurementValueComponent}></Route> */}
                            <Route path = "/mechLoad1s" component = {ListMechLoad1Component}></Route>
                            <Route path = "/add-mechLoad1/:id" component = {CreateMechLoad1Component}></Route>
                            <Route path = "/view-mechLoad1/:id" component = {ViewMechLoad1Component}></Route>
                          {/* <Route path = "/update-mechLoad1/:id" component = {UpdateMechLoad1Component}></Route> */}
                            <Route path = "/mechanicalLoadUserDefineds" component = {ListMechanicalLoadUserDefinedComponent}></Route>
                            <Route path = "/add-mechanicalLoadUserDefined/:id" component = {CreateMechanicalLoadUserDefinedComponent}></Route>
                            <Route path = "/view-mechanicalLoadUserDefined/:id" component = {ViewMechanicalLoadUserDefinedComponent}></Route>
                          {/* <Route path = "/update-mechanicalLoadUserDefined/:id" component = {UpdateMechanicalLoadUserDefinedComponent}></Route> */}
                            <Route path = "/moneys" component = {ListMoneyComponent}></Route>
                            <Route path = "/add-money/:id" component = {CreateMoneyComponent}></Route>
                            <Route path = "/view-money/:id" component = {ViewMoneyComponent}></Route>
                          {/* <Route path = "/update-money/:id" component = {UpdateMoneyComponent}></Route> */}
                            <Route path = "/monthDayIntervals" component = {ListMonthDayIntervalComponent}></Route>
                            <Route path = "/add-monthDayInterval/:id" component = {CreateMonthDayIntervalComponent}></Route>
                            <Route path = "/view-monthDayInterval/:id" component = {ViewMonthDayIntervalComponent}></Route>
                          {/* <Route path = "/update-monthDayInterval/:id" component = {UpdateMonthDayIntervalComponent}></Route> */}
                            <Route path = "/mutualCouplings" component = {ListMutualCouplingComponent}></Route>
                            <Route path = "/add-mutualCoupling/:id" component = {CreateMutualCouplingComponent}></Route>
                            <Route path = "/view-mutualCoupling/:id" component = {ViewMutualCouplingComponent}></Route>
                          {/* <Route path = "/update-mutualCoupling/:id" component = {UpdateMutualCouplingComponent}></Route> */}
                            <Route path = "/nonlinearShuntCompensatorPoints" component = {ListNonlinearShuntCompensatorPointComponent}></Route>
                            <Route path = "/add-nonlinearShuntCompensatorPoint/:id" component = {CreateNonlinearShuntCompensatorPointComponent}></Route>
                            <Route path = "/view-nonlinearShuntCompensatorPoint/:id" component = {ViewNonlinearShuntCompensatorPointComponent}></Route>
                          {/* <Route path = "/update-nonlinearShuntCompensatorPoint/:id" component = {UpdateNonlinearShuntCompensatorPointComponent}></Route> */}
                            <Route path = "/operationalLimitTypes" component = {ListOperationalLimitTypeComponent}></Route>
                            <Route path = "/add-operationalLimitType/:id" component = {CreateOperationalLimitTypeComponent}></Route>
                            <Route path = "/view-operationalLimitType/:id" component = {ViewOperationalLimitTypeComponent}></Route>
                          {/* <Route path = "/update-operationalLimitType/:id" component = {UpdateOperationalLimitTypeComponent}></Route> */}
                            <Route path = "/overexcLim2s" component = {ListOverexcLim2Component}></Route>
                            <Route path = "/add-overexcLim2/:id" component = {CreateOverexcLim2Component}></Route>
                            <Route path = "/view-overexcLim2/:id" component = {ViewOverexcLim2Component}></Route>
                          {/* <Route path = "/update-overexcLim2/:id" component = {UpdateOverexcLim2Component}></Route> */}
                            <Route path = "/overexcLimIEEEs" component = {ListOverexcLimIEEEComponent}></Route>
                            <Route path = "/add-overexcLimIEEE/:id" component = {CreateOverexcLimIEEEComponent}></Route>
                            <Route path = "/view-overexcLimIEEE/:id" component = {ViewOverexcLimIEEEComponent}></Route>
                          {/* <Route path = "/update-overexcLimIEEE/:id" component = {UpdateOverexcLimIEEEComponent}></Route> */}
                            <Route path = "/overexcLimX1s" component = {ListOverexcLimX1Component}></Route>
                            <Route path = "/add-overexcLimX1/:id" component = {CreateOverexcLimX1Component}></Route>
                            <Route path = "/view-overexcLimX1/:id" component = {ViewOverexcLimX1Component}></Route>
                          {/* <Route path = "/update-overexcLimX1/:id" component = {UpdateOverexcLimX1Component}></Route> */}
                            <Route path = "/overexcLimX2s" component = {ListOverexcLimX2Component}></Route>
                            <Route path = "/add-overexcLimX2/:id" component = {CreateOverexcLimX2Component}></Route>
                            <Route path = "/view-overexcLimX2/:id" component = {ViewOverexcLimX2Component}></Route>
                          {/* <Route path = "/update-overexcLimX2/:id" component = {UpdateOverexcLimX2Component}></Route> */}
                            <Route path = "/overexcitationLimiterUserDefineds" component = {ListOverexcitationLimiterUserDefinedComponent}></Route>
                            <Route path = "/add-overexcitationLimiterUserDefined/:id" component = {CreateOverexcitationLimiterUserDefinedComponent}></Route>
                            <Route path = "/view-overexcitationLimiterUserDefined/:id" component = {ViewOverexcitationLimiterUserDefinedComponent}></Route>
                          {/* <Route path = "/update-overexcitationLimiterUserDefined/:id" component = {UpdateOverexcitationLimiterUserDefinedComponent}></Route> */}
                            <Route path = "/pFVArControllerType1UserDefineds" component = {ListPFVArControllerType1UserDefinedComponent}></Route>
                            <Route path = "/add-pFVArControllerType1UserDefined/:id" component = {CreatePFVArControllerType1UserDefinedComponent}></Route>
                            <Route path = "/view-pFVArControllerType1UserDefined/:id" component = {ViewPFVArControllerType1UserDefinedComponent}></Route>
                          {/* <Route path = "/update-pFVArControllerType1UserDefined/:id" component = {UpdatePFVArControllerType1UserDefinedComponent}></Route> */}
                            <Route path = "/pFVArControllerType2UserDefineds" component = {ListPFVArControllerType2UserDefinedComponent}></Route>
                            <Route path = "/add-pFVArControllerType2UserDefined/:id" component = {CreatePFVArControllerType2UserDefinedComponent}></Route>
                            <Route path = "/view-pFVArControllerType2UserDefined/:id" component = {ViewPFVArControllerType2UserDefinedComponent}></Route>
                          {/* <Route path = "/update-pFVArControllerType2UserDefined/:id" component = {UpdatePFVArControllerType2UserDefinedComponent}></Route> */}
                            <Route path = "/pFVArType1IEEEPFControllers" component = {ListPFVArType1IEEEPFControllerComponent}></Route>
                            <Route path = "/add-pFVArType1IEEEPFController/:id" component = {CreatePFVArType1IEEEPFControllerComponent}></Route>
                            <Route path = "/view-pFVArType1IEEEPFController/:id" component = {ViewPFVArType1IEEEPFControllerComponent}></Route>
                          {/* <Route path = "/update-pFVArType1IEEEPFController/:id" component = {UpdatePFVArType1IEEEPFControllerComponent}></Route> */}
                            <Route path = "/pFVArType1IEEEVArControllers" component = {ListPFVArType1IEEEVArControllerComponent}></Route>
                            <Route path = "/add-pFVArType1IEEEVArController/:id" component = {CreatePFVArType1IEEEVArControllerComponent}></Route>
                            <Route path = "/view-pFVArType1IEEEVArController/:id" component = {ViewPFVArType1IEEEVArControllerComponent}></Route>
                          {/* <Route path = "/update-pFVArType1IEEEVArController/:id" component = {UpdatePFVArType1IEEEVArControllerComponent}></Route> */}
                            <Route path = "/pFVArType2Common1s" component = {ListPFVArType2Common1Component}></Route>
                            <Route path = "/add-pFVArType2Common1/:id" component = {CreatePFVArType2Common1Component}></Route>
                            <Route path = "/view-pFVArType2Common1/:id" component = {ViewPFVArType2Common1Component}></Route>
                          {/* <Route path = "/update-pFVArType2Common1/:id" component = {UpdatePFVArType2Common1Component}></Route> */}
                            <Route path = "/pFVArType2IEEEPFControllers" component = {ListPFVArType2IEEEPFControllerComponent}></Route>
                            <Route path = "/add-pFVArType2IEEEPFController/:id" component = {CreatePFVArType2IEEEPFControllerComponent}></Route>
                            <Route path = "/view-pFVArType2IEEEPFController/:id" component = {ViewPFVArType2IEEEPFControllerComponent}></Route>
                          {/* <Route path = "/update-pFVArType2IEEEPFController/:id" component = {UpdatePFVArType2IEEEPFControllerComponent}></Route> */}
                            <Route path = "/pFVArType2IEEEVArControllers" component = {ListPFVArType2IEEEVArControllerComponent}></Route>
                            <Route path = "/add-pFVArType2IEEEVArController/:id" component = {CreatePFVArType2IEEEVArControllerComponent}></Route>
                            <Route path = "/view-pFVArType2IEEEVArController/:id" component = {ViewPFVArType2IEEEVArControllerComponent}></Route>
                          {/* <Route path = "/update-pFVArType2IEEEVArController/:id" component = {UpdatePFVArType2IEEEVArControllerComponent}></Route> */}
                            <Route path = "/pUs" component = {ListPUComponent}></Route>
                            <Route path = "/add-pU/:id" component = {CreatePUComponent}></Route>
                            <Route path = "/view-pU/:id" component = {ViewPUComponent}></Route>
                          {/* <Route path = "/update-pU/:id" component = {UpdatePUComponent}></Route> */}
                            <Route path = "/perCents" component = {ListPerCentComponent}></Route>
                            <Route path = "/add-perCent/:id" component = {CreatePerCentComponent}></Route>
                            <Route path = "/view-perCent/:id" component = {ViewPerCentComponent}></Route>
                          {/* <Route path = "/update-perCent/:id" component = {UpdatePerCentComponent}></Route> */}
                            <Route path = "/perLengthDCLineParameters" component = {ListPerLengthDCLineParameterComponent}></Route>
                            <Route path = "/add-perLengthDCLineParameter/:id" component = {CreatePerLengthDCLineParameterComponent}></Route>
                            <Route path = "/view-perLengthDCLineParameter/:id" component = {ViewPerLengthDCLineParameterComponent}></Route>
                          {/* <Route path = "/update-perLengthDCLineParameter/:id" component = {UpdatePerLengthDCLineParameterComponent}></Route> */}
                            <Route path = "/petersenCoils" component = {ListPetersenCoilComponent}></Route>
                            <Route path = "/add-petersenCoil/:id" component = {CreatePetersenCoilComponent}></Route>
                            <Route path = "/view-petersenCoil/:id" component = {ViewPetersenCoilComponent}></Route>
                          {/* <Route path = "/update-petersenCoil/:id" component = {UpdatePetersenCoilComponent}></Route> */}
                            <Route path = "/phaseTapChangerAsymmetricals" component = {ListPhaseTapChangerAsymmetricalComponent}></Route>
                            <Route path = "/add-phaseTapChangerAsymmetrical/:id" component = {CreatePhaseTapChangerAsymmetricalComponent}></Route>
                            <Route path = "/view-phaseTapChangerAsymmetrical/:id" component = {ViewPhaseTapChangerAsymmetricalComponent}></Route>
                          {/* <Route path = "/update-phaseTapChangerAsymmetrical/:id" component = {UpdatePhaseTapChangerAsymmetricalComponent}></Route> */}
                            <Route path = "/phaseTapChangerLinears" component = {ListPhaseTapChangerLinearComponent}></Route>
                            <Route path = "/add-phaseTapChangerLinear/:id" component = {CreatePhaseTapChangerLinearComponent}></Route>
                            <Route path = "/view-phaseTapChangerLinear/:id" component = {ViewPhaseTapChangerLinearComponent}></Route>
                          {/* <Route path = "/update-phaseTapChangerLinear/:id" component = {UpdatePhaseTapChangerLinearComponent}></Route> */}
                            <Route path = "/phaseTapChangerNonLinears" component = {ListPhaseTapChangerNonLinearComponent}></Route>
                            <Route path = "/add-phaseTapChangerNonLinear/:id" component = {CreatePhaseTapChangerNonLinearComponent}></Route>
                            <Route path = "/view-phaseTapChangerNonLinear/:id" component = {ViewPhaseTapChangerNonLinearComponent}></Route>
                          {/* <Route path = "/update-phaseTapChangerNonLinear/:id" component = {UpdatePhaseTapChangerNonLinearComponent}></Route> */}
                            <Route path = "/phaseTapChangerTablePoints" component = {ListPhaseTapChangerTablePointComponent}></Route>
                            <Route path = "/add-phaseTapChangerTablePoint/:id" component = {CreatePhaseTapChangerTablePointComponent}></Route>
                            <Route path = "/view-phaseTapChangerTablePoint/:id" component = {ViewPhaseTapChangerTablePointComponent}></Route>
                          {/* <Route path = "/update-phaseTapChangerTablePoint/:id" component = {UpdatePhaseTapChangerTablePointComponent}></Route> */}
                            <Route path = "/positionPoints" component = {ListPositionPointComponent}></Route>
                            <Route path = "/add-positionPoint/:id" component = {CreatePositionPointComponent}></Route>
                            <Route path = "/view-positionPoint/:id" component = {ViewPositionPointComponent}></Route>
                          {/* <Route path = "/update-positionPoint/:id" component = {UpdatePositionPointComponent}></Route> */}
                            <Route path = "/powerSystemStabilizerUserDefineds" component = {ListPowerSystemStabilizerUserDefinedComponent}></Route>
                            <Route path = "/add-powerSystemStabilizerUserDefined/:id" component = {CreatePowerSystemStabilizerUserDefinedComponent}></Route>
                            <Route path = "/view-powerSystemStabilizerUserDefined/:id" component = {ViewPowerSystemStabilizerUserDefinedComponent}></Route>
                          {/* <Route path = "/update-powerSystemStabilizerUserDefined/:id" component = {UpdatePowerSystemStabilizerUserDefinedComponent}></Route> */}
                            <Route path = "/powerTransformers" component = {ListPowerTransformerComponent}></Route>
                            <Route path = "/add-powerTransformer/:id" component = {CreatePowerTransformerComponent}></Route>
                            <Route path = "/view-powerTransformer/:id" component = {ViewPowerTransformerComponent}></Route>
                          {/* <Route path = "/update-powerTransformer/:id" component = {UpdatePowerTransformerComponent}></Route> */}
                            <Route path = "/powerTransformerEnds" component = {ListPowerTransformerEndComponent}></Route>
                            <Route path = "/add-powerTransformerEnd/:id" component = {CreatePowerTransformerEndComponent}></Route>
                            <Route path = "/view-powerTransformerEnd/:id" component = {ViewPowerTransformerEndComponent}></Route>
                          {/* <Route path = "/update-powerTransformerEnd/:id" component = {UpdatePowerTransformerEndComponent}></Route> */}
                            <Route path = "/proprietaryParameterDynamicss" component = {ListProprietaryParameterDynamicsComponent}></Route>
                            <Route path = "/add-proprietaryParameterDynamics/:id" component = {CreateProprietaryParameterDynamicsComponent}></Route>
                            <Route path = "/view-proprietaryParameterDynamics/:id" component = {ViewProprietaryParameterDynamicsComponent}></Route>
                          {/* <Route path = "/update-proprietaryParameterDynamics/:id" component = {UpdateProprietaryParameterDynamicsComponent}></Route> */}
                            <Route path = "/pss1s" component = {ListPss1Component}></Route>
                            <Route path = "/add-pss1/:id" component = {CreatePss1Component}></Route>
                            <Route path = "/view-pss1/:id" component = {ViewPss1Component}></Route>
                          {/* <Route path = "/update-pss1/:id" component = {UpdatePss1Component}></Route> */}
                            <Route path = "/pss1As" component = {ListPss1AComponent}></Route>
                            <Route path = "/add-pss1A/:id" component = {CreatePss1AComponent}></Route>
                            <Route path = "/view-pss1A/:id" component = {ViewPss1AComponent}></Route>
                          {/* <Route path = "/update-pss1A/:id" component = {UpdatePss1AComponent}></Route> */}
                            <Route path = "/pss2Bs" component = {ListPss2BComponent}></Route>
                            <Route path = "/add-pss2B/:id" component = {CreatePss2BComponent}></Route>
                            <Route path = "/view-pss2B/:id" component = {ViewPss2BComponent}></Route>
                          {/* <Route path = "/update-pss2B/:id" component = {UpdatePss2BComponent}></Route> */}
                            <Route path = "/pss2STs" component = {ListPss2STComponent}></Route>
                            <Route path = "/add-pss2ST/:id" component = {CreatePss2STComponent}></Route>
                            <Route path = "/view-pss2ST/:id" component = {ViewPss2STComponent}></Route>
                          {/* <Route path = "/update-pss2ST/:id" component = {UpdatePss2STComponent}></Route> */}
                            <Route path = "/pss5s" component = {ListPss5Component}></Route>
                            <Route path = "/add-pss5/:id" component = {CreatePss5Component}></Route>
                            <Route path = "/view-pss5/:id" component = {ViewPss5Component}></Route>
                          {/* <Route path = "/update-pss5/:id" component = {UpdatePss5Component}></Route> */}
                            <Route path = "/pssELIN2s" component = {ListPssELIN2Component}></Route>
                            <Route path = "/add-pssELIN2/:id" component = {CreatePssELIN2Component}></Route>
                            <Route path = "/view-pssELIN2/:id" component = {ViewPssELIN2Component}></Route>
                          {/* <Route path = "/update-pssELIN2/:id" component = {UpdatePssELIN2Component}></Route> */}
                            <Route path = "/pssIEEE1As" component = {ListPssIEEE1AComponent}></Route>
                            <Route path = "/add-pssIEEE1A/:id" component = {CreatePssIEEE1AComponent}></Route>
                            <Route path = "/view-pssIEEE1A/:id" component = {ViewPssIEEE1AComponent}></Route>
                          {/* <Route path = "/update-pssIEEE1A/:id" component = {UpdatePssIEEE1AComponent}></Route> */}
                            <Route path = "/pssIEEE2Bs" component = {ListPssIEEE2BComponent}></Route>
                            <Route path = "/add-pssIEEE2B/:id" component = {CreatePssIEEE2BComponent}></Route>
                            <Route path = "/view-pssIEEE2B/:id" component = {ViewPssIEEE2BComponent}></Route>
                          {/* <Route path = "/update-pssIEEE2B/:id" component = {UpdatePssIEEE2BComponent}></Route> */}
                            <Route path = "/pssIEEE3Bs" component = {ListPssIEEE3BComponent}></Route>
                            <Route path = "/add-pssIEEE3B/:id" component = {CreatePssIEEE3BComponent}></Route>
                            <Route path = "/view-pssIEEE3B/:id" component = {ViewPssIEEE3BComponent}></Route>
                          {/* <Route path = "/update-pssIEEE3B/:id" component = {UpdatePssIEEE3BComponent}></Route> */}
                            <Route path = "/pssIEEE4Bs" component = {ListPssIEEE4BComponent}></Route>
                            <Route path = "/add-pssIEEE4B/:id" component = {CreatePssIEEE4BComponent}></Route>
                            <Route path = "/view-pssIEEE4B/:id" component = {ViewPssIEEE4BComponent}></Route>
                          {/* <Route path = "/update-pssIEEE4B/:id" component = {UpdatePssIEEE4BComponent}></Route> */}
                            <Route path = "/pssPTIST1s" component = {ListPssPTIST1Component}></Route>
                            <Route path = "/add-pssPTIST1/:id" component = {CreatePssPTIST1Component}></Route>
                            <Route path = "/view-pssPTIST1/:id" component = {ViewPssPTIST1Component}></Route>
                          {/* <Route path = "/update-pssPTIST1/:id" component = {UpdatePssPTIST1Component}></Route> */}
                            <Route path = "/pssPTIST3s" component = {ListPssPTIST3Component}></Route>
                            <Route path = "/add-pssPTIST3/:id" component = {CreatePssPTIST3Component}></Route>
                            <Route path = "/view-pssPTIST3/:id" component = {ViewPssPTIST3Component}></Route>
                          {/* <Route path = "/update-pssPTIST3/:id" component = {UpdatePssPTIST3Component}></Route> */}
                            <Route path = "/pssSB4s" component = {ListPssSB4Component}></Route>
                            <Route path = "/add-pssSB4/:id" component = {CreatePssSB4Component}></Route>
                            <Route path = "/view-pssSB4/:id" component = {ViewPssSB4Component}></Route>
                          {/* <Route path = "/update-pssSB4/:id" component = {UpdatePssSB4Component}></Route> */}
                            <Route path = "/pssSHs" component = {ListPssSHComponent}></Route>
                            <Route path = "/add-pssSH/:id" component = {CreatePssSHComponent}></Route>
                            <Route path = "/view-pssSH/:id" component = {ViewPssSHComponent}></Route>
                          {/* <Route path = "/update-pssSH/:id" component = {UpdatePssSHComponent}></Route> */}
                            <Route path = "/pssSKs" component = {ListPssSKComponent}></Route>
                            <Route path = "/add-pssSK/:id" component = {CreatePssSKComponent}></Route>
                            <Route path = "/view-pssSK/:id" component = {ViewPssSKComponent}></Route>
                          {/* <Route path = "/update-pssSK/:id" component = {UpdatePssSKComponent}></Route> */}
                            <Route path = "/pssWECCs" component = {ListPssWECCComponent}></Route>
                            <Route path = "/add-pssWECC/:id" component = {CreatePssWECCComponent}></Route>
                            <Route path = "/view-pssWECC/:id" component = {ViewPssWECCComponent}></Route>
                          {/* <Route path = "/update-pssWECC/:id" component = {UpdatePssWECCComponent}></Route> */}
                            <Route path = "/quality61850s" component = {ListQuality61850Component}></Route>
                            <Route path = "/add-quality61850/:id" component = {CreateQuality61850Component}></Route>
                            <Route path = "/view-quality61850/:id" component = {ViewQuality61850Component}></Route>
                          {/* <Route path = "/update-quality61850/:id" component = {UpdateQuality61850Component}></Route> */}
                            <Route path = "/ratioTapChangers" component = {ListRatioTapChangerComponent}></Route>
                            <Route path = "/add-ratioTapChanger/:id" component = {CreateRatioTapChangerComponent}></Route>
                            <Route path = "/view-ratioTapChanger/:id" component = {ViewRatioTapChangerComponent}></Route>
                          {/* <Route path = "/update-ratioTapChanger/:id" component = {UpdateRatioTapChangerComponent}></Route> */}
                            <Route path = "/reactances" component = {ListReactanceComponent}></Route>
                            <Route path = "/add-reactance/:id" component = {CreateReactanceComponent}></Route>
                            <Route path = "/view-reactance/:id" component = {ViewReactanceComponent}></Route>
                          {/* <Route path = "/update-reactance/:id" component = {UpdateReactanceComponent}></Route> */}
                            <Route path = "/reactivePowers" component = {ListReactivePowerComponent}></Route>
                            <Route path = "/add-reactivePower/:id" component = {CreateReactivePowerComponent}></Route>
                            <Route path = "/view-reactivePower/:id" component = {ViewReactivePowerComponent}></Route>
                          {/* <Route path = "/update-reactivePower/:id" component = {UpdateReactivePowerComponent}></Route> */}
                            <Route path = "/regularIntervalSchedules" component = {ListRegularIntervalScheduleComponent}></Route>
                            <Route path = "/add-regularIntervalSchedule/:id" component = {CreateRegularIntervalScheduleComponent}></Route>
                            <Route path = "/view-regularIntervalSchedule/:id" component = {ViewRegularIntervalScheduleComponent}></Route>
                          {/* <Route path = "/update-regularIntervalSchedule/:id" component = {UpdateRegularIntervalScheduleComponent}></Route> */}
                            <Route path = "/regularTimePoints" component = {ListRegularTimePointComponent}></Route>
                            <Route path = "/add-regularTimePoint/:id" component = {CreateRegularTimePointComponent}></Route>
                            <Route path = "/view-regularTimePoint/:id" component = {ViewRegularTimePointComponent}></Route>
                          {/* <Route path = "/update-regularTimePoint/:id" component = {UpdateRegularTimePointComponent}></Route> */}
                            <Route path = "/regulatingControls" component = {ListRegulatingControlComponent}></Route>
                            <Route path = "/add-regulatingControl/:id" component = {CreateRegulatingControlComponent}></Route>
                            <Route path = "/view-regulatingControl/:id" component = {ViewRegulatingControlComponent}></Route>
                          {/* <Route path = "/update-regulatingControl/:id" component = {UpdateRegulatingControlComponent}></Route> */}
                            <Route path = "/remoteInputSignals" component = {ListRemoteInputSignalComponent}></Route>
                            <Route path = "/add-remoteInputSignal/:id" component = {CreateRemoteInputSignalComponent}></Route>
                            <Route path = "/view-remoteInputSignal/:id" component = {ViewRemoteInputSignalComponent}></Route>
                          {/* <Route path = "/update-remoteInputSignal/:id" component = {UpdateRemoteInputSignalComponent}></Route> */}
                            <Route path = "/resistances" component = {ListResistanceComponent}></Route>
                            <Route path = "/add-resistance/:id" component = {CreateResistanceComponent}></Route>
                            <Route path = "/view-resistance/:id" component = {ViewResistanceComponent}></Route>
                          {/* <Route path = "/update-resistance/:id" component = {UpdateResistanceComponent}></Route> */}
                            <Route path = "/resistancePerLengths" component = {ListResistancePerLengthComponent}></Route>
                            <Route path = "/add-resistancePerLength/:id" component = {CreateResistancePerLengthComponent}></Route>
                            <Route path = "/view-resistancePerLength/:id" component = {ViewResistancePerLengthComponent}></Route>
                          {/* <Route path = "/update-resistancePerLength/:id" component = {UpdateResistancePerLengthComponent}></Route> */}
                            <Route path = "/rotatingMachines" component = {ListRotatingMachineComponent}></Route>
                            <Route path = "/add-rotatingMachine/:id" component = {CreateRotatingMachineComponent}></Route>
                            <Route path = "/view-rotatingMachine/:id" component = {ViewRotatingMachineComponent}></Route>
                          {/* <Route path = "/update-rotatingMachine/:id" component = {UpdateRotatingMachineComponent}></Route> */}
                            <Route path = "/rotatingMachineDynamicss" component = {ListRotatingMachineDynamicsComponent}></Route>
                            <Route path = "/add-rotatingMachineDynamics/:id" component = {CreateRotatingMachineDynamicsComponent}></Route>
                            <Route path = "/view-rotatingMachineDynamics/:id" component = {ViewRotatingMachineDynamicsComponent}></Route>
                          {/* <Route path = "/update-rotatingMachineDynamics/:id" component = {UpdateRotatingMachineDynamicsComponent}></Route> */}
                            <Route path = "/rotationSpeeds" component = {ListRotationSpeedComponent}></Route>
                            <Route path = "/add-rotationSpeed/:id" component = {CreateRotationSpeedComponent}></Route>
                            <Route path = "/view-rotationSpeed/:id" component = {ViewRotationSpeedComponent}></Route>
                          {/* <Route path = "/update-rotationSpeed/:id" component = {UpdateRotationSpeedComponent}></Route> */}
                            <Route path = "/seasons" component = {ListSeasonComponent}></Route>
                            <Route path = "/add-season/:id" component = {CreateSeasonComponent}></Route>
                            <Route path = "/view-season/:id" component = {ViewSeasonComponent}></Route>
                          {/* <Route path = "/update-season/:id" component = {UpdateSeasonComponent}></Route> */}
                            <Route path = "/secondss" component = {ListSecondsComponent}></Route>
                            <Route path = "/add-seconds/:id" component = {CreateSecondsComponent}></Route>
                            <Route path = "/view-seconds/:id" component = {ViewSecondsComponent}></Route>
                          {/* <Route path = "/update-seconds/:id" component = {UpdateSecondsComponent}></Route> */}
                            <Route path = "/seriesCompensators" component = {ListSeriesCompensatorComponent}></Route>
                            <Route path = "/add-seriesCompensator/:id" component = {CreateSeriesCompensatorComponent}></Route>
                            <Route path = "/view-seriesCompensator/:id" component = {ViewSeriesCompensatorComponent}></Route>
                          {/* <Route path = "/update-seriesCompensator/:id" component = {UpdateSeriesCompensatorComponent}></Route> */}
                            <Route path = "/setPoints" component = {ListSetPointComponent}></Route>
                            <Route path = "/add-setPoint/:id" component = {CreateSetPointComponent}></Route>
                            <Route path = "/view-setPoint/:id" component = {ViewSetPointComponent}></Route>
                          {/* <Route path = "/update-setPoint/:id" component = {UpdateSetPointComponent}></Route> */}
                            <Route path = "/shuntCompensators" component = {ListShuntCompensatorComponent}></Route>
                            <Route path = "/add-shuntCompensator/:id" component = {CreateShuntCompensatorComponent}></Route>
                            <Route path = "/view-shuntCompensator/:id" component = {ViewShuntCompensatorComponent}></Route>
                          {/* <Route path = "/update-shuntCompensator/:id" component = {UpdateShuntCompensatorComponent}></Route> */}
                            <Route path = "/simple_Floats" component = {ListSimple_FloatComponent}></Route>
                            <Route path = "/add-simple_Float/:id" component = {CreateSimple_FloatComponent}></Route>
                            <Route path = "/view-simple_Float/:id" component = {ViewSimple_FloatComponent}></Route>
                          {/* <Route path = "/update-simple_Float/:id" component = {UpdateSimple_FloatComponent}></Route> */}
                            <Route path = "/stateVariablesVersions" component = {ListStateVariablesVersionComponent}></Route>
                            <Route path = "/add-stateVariablesVersion/:id" component = {CreateStateVariablesVersionComponent}></Route>
                            <Route path = "/view-stateVariablesVersion/:id" component = {ViewStateVariablesVersionComponent}></Route>
                          {/* <Route path = "/update-stateVariablesVersion/:id" component = {UpdateStateVariablesVersionComponent}></Route> */}
                            <Route path = "/staticVarCompensators" component = {ListStaticVarCompensatorComponent}></Route>
                            <Route path = "/add-staticVarCompensator/:id" component = {CreateStaticVarCompensatorComponent}></Route>
                            <Route path = "/view-staticVarCompensator/:id" component = {ViewStaticVarCompensatorComponent}></Route>
                          {/* <Route path = "/update-staticVarCompensator/:id" component = {UpdateStaticVarCompensatorComponent}></Route> */}
                            <Route path = "/steadyStateHypothesisVersions" component = {ListSteadyStateHypothesisVersionComponent}></Route>
                            <Route path = "/add-steadyStateHypothesisVersion/:id" component = {CreateSteadyStateHypothesisVersionComponent}></Route>
                            <Route path = "/view-steadyStateHypothesisVersion/:id" component = {ViewSteadyStateHypothesisVersionComponent}></Route>
                          {/* <Route path = "/update-steadyStateHypothesisVersion/:id" component = {UpdateSteadyStateHypothesisVersionComponent}></Route> */}
                            <Route path = "/stringMeasurementValues" component = {ListStringMeasurementValueComponent}></Route>
                            <Route path = "/add-stringMeasurementValue/:id" component = {CreateStringMeasurementValueComponent}></Route>
                            <Route path = "/view-stringMeasurementValue/:id" component = {ViewStringMeasurementValueComponent}></Route>
                          {/* <Route path = "/update-stringMeasurementValue/:id" component = {UpdateStringMeasurementValueComponent}></Route> */}
                            <Route path = "/susceptances" component = {ListSusceptanceComponent}></Route>
                            <Route path = "/add-susceptance/:id" component = {CreateSusceptanceComponent}></Route>
                            <Route path = "/view-susceptance/:id" component = {ViewSusceptanceComponent}></Route>
                          {/* <Route path = "/update-susceptance/:id" component = {UpdateSusceptanceComponent}></Route> */}
                            <Route path = "/svInjections" component = {ListSvInjectionComponent}></Route>
                            <Route path = "/add-svInjection/:id" component = {CreateSvInjectionComponent}></Route>
                            <Route path = "/view-svInjection/:id" component = {ViewSvInjectionComponent}></Route>
                          {/* <Route path = "/update-svInjection/:id" component = {UpdateSvInjectionComponent}></Route> */}
                            <Route path = "/svPowerFlows" component = {ListSvPowerFlowComponent}></Route>
                            <Route path = "/add-svPowerFlow/:id" component = {CreateSvPowerFlowComponent}></Route>
                            <Route path = "/view-svPowerFlow/:id" component = {ViewSvPowerFlowComponent}></Route>
                          {/* <Route path = "/update-svPowerFlow/:id" component = {UpdateSvPowerFlowComponent}></Route> */}
                            <Route path = "/svShuntCompensatorSectionss" component = {ListSvShuntCompensatorSectionsComponent}></Route>
                            <Route path = "/add-svShuntCompensatorSections/:id" component = {CreateSvShuntCompensatorSectionsComponent}></Route>
                            <Route path = "/view-svShuntCompensatorSections/:id" component = {ViewSvShuntCompensatorSectionsComponent}></Route>
                          {/* <Route path = "/update-svShuntCompensatorSections/:id" component = {UpdateSvShuntCompensatorSectionsComponent}></Route> */}
                            <Route path = "/svStatuss" component = {ListSvStatusComponent}></Route>
                            <Route path = "/add-svStatus/:id" component = {CreateSvStatusComponent}></Route>
                            <Route path = "/view-svStatus/:id" component = {ViewSvStatusComponent}></Route>
                          {/* <Route path = "/update-svStatus/:id" component = {UpdateSvStatusComponent}></Route> */}
                            <Route path = "/svTapSteps" component = {ListSvTapStepComponent}></Route>
                            <Route path = "/add-svTapStep/:id" component = {CreateSvTapStepComponent}></Route>
                            <Route path = "/view-svTapStep/:id" component = {ViewSvTapStepComponent}></Route>
                          {/* <Route path = "/update-svTapStep/:id" component = {UpdateSvTapStepComponent}></Route> */}
                            <Route path = "/svVoltages" component = {ListSvVoltageComponent}></Route>
                            <Route path = "/add-svVoltage/:id" component = {CreateSvVoltageComponent}></Route>
                            <Route path = "/view-svVoltage/:id" component = {ViewSvVoltageComponent}></Route>
                          {/* <Route path = "/update-svVoltage/:id" component = {UpdateSvVoltageComponent}></Route> */}
                            <Route path = "/switchIts" component = {ListSwitchItComponent}></Route>
                            <Route path = "/add-switchIt/:id" component = {CreateSwitchItComponent}></Route>
                            <Route path = "/view-switchIt/:id" component = {ViewSwitchItComponent}></Route>
                          {/* <Route path = "/update-switchIt/:id" component = {UpdateSwitchItComponent}></Route> */}
                            <Route path = "/switchProxys" component = {ListSwitchProxyComponent}></Route>
                            <Route path = "/add-switchProxy/:id" component = {CreateSwitchProxyComponent}></Route>
                            <Route path = "/view-switchProxy/:id" component = {ViewSwitchProxyComponent}></Route>
                          {/* <Route path = "/update-switchProxy/:id" component = {UpdateSwitchProxyComponent}></Route> */}
                            <Route path = "/synchronousMachines" component = {ListSynchronousMachineComponent}></Route>
                            <Route path = "/add-synchronousMachine/:id" component = {CreateSynchronousMachineComponent}></Route>
                            <Route path = "/view-synchronousMachine/:id" component = {ViewSynchronousMachineComponent}></Route>
                          {/* <Route path = "/update-synchronousMachine/:id" component = {UpdateSynchronousMachineComponent}></Route> */}
                            <Route path = "/synchronousMachineDetaileds" component = {ListSynchronousMachineDetailedComponent}></Route>
                            <Route path = "/add-synchronousMachineDetailed/:id" component = {CreateSynchronousMachineDetailedComponent}></Route>
                            <Route path = "/view-synchronousMachineDetailed/:id" component = {ViewSynchronousMachineDetailedComponent}></Route>
                          {/* <Route path = "/update-synchronousMachineDetailed/:id" component = {UpdateSynchronousMachineDetailedComponent}></Route> */}
                            <Route path = "/synchronousMachineEquivalentCircuits" component = {ListSynchronousMachineEquivalentCircuitComponent}></Route>
                            <Route path = "/add-synchronousMachineEquivalentCircuit/:id" component = {CreateSynchronousMachineEquivalentCircuitComponent}></Route>
                            <Route path = "/view-synchronousMachineEquivalentCircuit/:id" component = {ViewSynchronousMachineEquivalentCircuitComponent}></Route>
                          {/* <Route path = "/update-synchronousMachineEquivalentCircuit/:id" component = {UpdateSynchronousMachineEquivalentCircuitComponent}></Route> */}
                            <Route path = "/synchronousMachineTimeConstantReactances" component = {ListSynchronousMachineTimeConstantReactanceComponent}></Route>
                            <Route path = "/add-synchronousMachineTimeConstantReactance/:id" component = {CreateSynchronousMachineTimeConstantReactanceComponent}></Route>
                            <Route path = "/view-synchronousMachineTimeConstantReactance/:id" component = {ViewSynchronousMachineTimeConstantReactanceComponent}></Route>
                          {/* <Route path = "/update-synchronousMachineTimeConstantReactance/:id" component = {UpdateSynchronousMachineTimeConstantReactanceComponent}></Route> */}
                            <Route path = "/synchronousMachineUserDefineds" component = {ListSynchronousMachineUserDefinedComponent}></Route>
                            <Route path = "/add-synchronousMachineUserDefined/:id" component = {CreateSynchronousMachineUserDefinedComponent}></Route>
                            <Route path = "/view-synchronousMachineUserDefined/:id" component = {ViewSynchronousMachineUserDefinedComponent}></Route>
                          {/* <Route path = "/update-synchronousMachineUserDefined/:id" component = {UpdateSynchronousMachineUserDefinedComponent}></Route> */}
                            <Route path = "/tapChangers" component = {ListTapChangerComponent}></Route>
                            <Route path = "/add-tapChanger/:id" component = {CreateTapChangerComponent}></Route>
                            <Route path = "/view-tapChanger/:id" component = {ViewTapChangerComponent}></Route>
                          {/* <Route path = "/update-tapChanger/:id" component = {UpdateTapChangerComponent}></Route> */}
                            <Route path = "/tapChangerTablePoints" component = {ListTapChangerTablePointComponent}></Route>
                            <Route path = "/add-tapChangerTablePoint/:id" component = {CreateTapChangerTablePointComponent}></Route>
                            <Route path = "/view-tapChangerTablePoint/:id" component = {ViewTapChangerTablePointComponent}></Route>
                          {/* <Route path = "/update-tapChangerTablePoint/:id" component = {UpdateTapChangerTablePointComponent}></Route> */}
                            <Route path = "/temperatures" component = {ListTemperatureComponent}></Route>
                            <Route path = "/add-temperature/:id" component = {CreateTemperatureComponent}></Route>
                            <Route path = "/view-temperature/:id" component = {ViewTemperatureComponent}></Route>
                          {/* <Route path = "/update-temperature/:id" component = {UpdateTemperatureComponent}></Route> */}
                            <Route path = "/textDiagramObjects" component = {ListTextDiagramObjectComponent}></Route>
                            <Route path = "/add-textDiagramObject/:id" component = {CreateTextDiagramObjectComponent}></Route>
                            <Route path = "/view-textDiagramObject/:id" component = {ViewTextDiagramObjectComponent}></Route>
                          {/* <Route path = "/update-textDiagramObject/:id" component = {UpdateTextDiagramObjectComponent}></Route> */}
                            <Route path = "/tieFlows" component = {ListTieFlowComponent}></Route>
                            <Route path = "/add-tieFlow/:id" component = {CreateTieFlowComponent}></Route>
                            <Route path = "/view-tieFlow/:id" component = {ViewTieFlowComponent}></Route>
                          {/* <Route path = "/update-tieFlow/:id" component = {UpdateTieFlowComponent}></Route> */}
                            <Route path = "/topologicalNodes" component = {ListTopologicalNodeComponent}></Route>
                            <Route path = "/add-topologicalNode/:id" component = {CreateTopologicalNodeComponent}></Route>
                            <Route path = "/view-topologicalNode/:id" component = {ViewTopologicalNodeComponent}></Route>
                          {/* <Route path = "/update-topologicalNode/:id" component = {UpdateTopologicalNodeComponent}></Route> */}
                            <Route path = "/topologyBoundaryVersions" component = {ListTopologyBoundaryVersionComponent}></Route>
                            <Route path = "/add-topologyBoundaryVersion/:id" component = {CreateTopologyBoundaryVersionComponent}></Route>
                            <Route path = "/view-topologyBoundaryVersion/:id" component = {ViewTopologyBoundaryVersionComponent}></Route>
                          {/* <Route path = "/update-topologyBoundaryVersion/:id" component = {UpdateTopologyBoundaryVersionComponent}></Route> */}
                            <Route path = "/topologyVersions" component = {ListTopologyVersionComponent}></Route>
                            <Route path = "/add-topologyVersion/:id" component = {CreateTopologyVersionComponent}></Route>
                            <Route path = "/view-topologyVersion/:id" component = {ViewTopologyVersionComponent}></Route>
                          {/* <Route path = "/update-topologyVersion/:id" component = {UpdateTopologyVersionComponent}></Route> */}
                            <Route path = "/transformerEnds" component = {ListTransformerEndComponent}></Route>
                            <Route path = "/add-transformerEnd/:id" component = {CreateTransformerEndComponent}></Route>
                            <Route path = "/view-transformerEnd/:id" component = {ViewTransformerEndComponent}></Route>
                          {/* <Route path = "/update-transformerEnd/:id" component = {UpdateTransformerEndComponent}></Route> */}
                            <Route path = "/turbLCFB1s" component = {ListTurbLCFB1Component}></Route>
                            <Route path = "/add-turbLCFB1/:id" component = {CreateTurbLCFB1Component}></Route>
                            <Route path = "/view-turbLCFB1/:id" component = {ViewTurbLCFB1Component}></Route>
                          {/* <Route path = "/update-turbLCFB1/:id" component = {UpdateTurbLCFB1Component}></Route> */}
                            <Route path = "/turbineGovernorUserDefineds" component = {ListTurbineGovernorUserDefinedComponent}></Route>
                            <Route path = "/add-turbineGovernorUserDefined/:id" component = {CreateTurbineGovernorUserDefinedComponent}></Route>
                            <Route path = "/view-turbineGovernorUserDefined/:id" component = {ViewTurbineGovernorUserDefinedComponent}></Route>
                          {/* <Route path = "/update-turbineGovernorUserDefined/:id" component = {UpdateTurbineGovernorUserDefinedComponent}></Route> */}
                            <Route path = "/turbineLoadControllerUserDefineds" component = {ListTurbineLoadControllerUserDefinedComponent}></Route>
                            <Route path = "/add-turbineLoadControllerUserDefined/:id" component = {CreateTurbineLoadControllerUserDefinedComponent}></Route>
                            <Route path = "/view-turbineLoadControllerUserDefined/:id" component = {ViewTurbineLoadControllerUserDefinedComponent}></Route>
                          {/* <Route path = "/update-turbineLoadControllerUserDefined/:id" component = {UpdateTurbineLoadControllerUserDefinedComponent}></Route> */}
                            <Route path = "/underexcLim2Simplifieds" component = {ListUnderexcLim2SimplifiedComponent}></Route>
                            <Route path = "/add-underexcLim2Simplified/:id" component = {CreateUnderexcLim2SimplifiedComponent}></Route>
                            <Route path = "/view-underexcLim2Simplified/:id" component = {ViewUnderexcLim2SimplifiedComponent}></Route>
                          {/* <Route path = "/update-underexcLim2Simplified/:id" component = {UpdateUnderexcLim2SimplifiedComponent}></Route> */}
                            <Route path = "/underexcLimIEEE1s" component = {ListUnderexcLimIEEE1Component}></Route>
                            <Route path = "/add-underexcLimIEEE1/:id" component = {CreateUnderexcLimIEEE1Component}></Route>
                            <Route path = "/view-underexcLimIEEE1/:id" component = {ViewUnderexcLimIEEE1Component}></Route>
                          {/* <Route path = "/update-underexcLimIEEE1/:id" component = {UpdateUnderexcLimIEEE1Component}></Route> */}
                            <Route path = "/underexcLimIEEE2s" component = {ListUnderexcLimIEEE2Component}></Route>
                            <Route path = "/add-underexcLimIEEE2/:id" component = {CreateUnderexcLimIEEE2Component}></Route>
                            <Route path = "/view-underexcLimIEEE2/:id" component = {ViewUnderexcLimIEEE2Component}></Route>
                          {/* <Route path = "/update-underexcLimIEEE2/:id" component = {UpdateUnderexcLimIEEE2Component}></Route> */}
                            <Route path = "/underexcLimX1s" component = {ListUnderexcLimX1Component}></Route>
                            <Route path = "/add-underexcLimX1/:id" component = {CreateUnderexcLimX1Component}></Route>
                            <Route path = "/view-underexcLimX1/:id" component = {ViewUnderexcLimX1Component}></Route>
                          {/* <Route path = "/update-underexcLimX1/:id" component = {UpdateUnderexcLimX1Component}></Route> */}
                            <Route path = "/underexcLimX2s" component = {ListUnderexcLimX2Component}></Route>
                            <Route path = "/add-underexcLimX2/:id" component = {CreateUnderexcLimX2Component}></Route>
                            <Route path = "/view-underexcLimX2/:id" component = {ViewUnderexcLimX2Component}></Route>
                          {/* <Route path = "/update-underexcLimX2/:id" component = {UpdateUnderexcLimX2Component}></Route> */}
                            <Route path = "/underexcitationLimiterUserDefineds" component = {ListUnderexcitationLimiterUserDefinedComponent}></Route>
                            <Route path = "/add-underexcitationLimiterUserDefined/:id" component = {CreateUnderexcitationLimiterUserDefinedComponent}></Route>
                            <Route path = "/view-underexcitationLimiterUserDefined/:id" component = {ViewUnderexcitationLimiterUserDefinedComponent}></Route>
                          {/* <Route path = "/update-underexcitationLimiterUserDefined/:id" component = {UpdateUnderexcitationLimiterUserDefinedComponent}></Route> */}
                            <Route path = "/vAdjIEEEs" component = {ListVAdjIEEEComponent}></Route>
                            <Route path = "/add-vAdjIEEE/:id" component = {CreateVAdjIEEEComponent}></Route>
                            <Route path = "/view-vAdjIEEE/:id" component = {ViewVAdjIEEEComponent}></Route>
                          {/* <Route path = "/update-vAdjIEEE/:id" component = {UpdateVAdjIEEEComponent}></Route> */}
                            <Route path = "/vCompIEEEType1s" component = {ListVCompIEEEType1Component}></Route>
                            <Route path = "/add-vCompIEEEType1/:id" component = {CreateVCompIEEEType1Component}></Route>
                            <Route path = "/view-vCompIEEEType1/:id" component = {ViewVCompIEEEType1Component}></Route>
                          {/* <Route path = "/update-vCompIEEEType1/:id" component = {UpdateVCompIEEEType1Component}></Route> */}
                            <Route path = "/vCompIEEEType2s" component = {ListVCompIEEEType2Component}></Route>
                            <Route path = "/add-vCompIEEEType2/:id" component = {CreateVCompIEEEType2Component}></Route>
                            <Route path = "/view-vCompIEEEType2/:id" component = {ViewVCompIEEEType2Component}></Route>
                          {/* <Route path = "/update-vCompIEEEType2/:id" component = {UpdateVCompIEEEType2Component}></Route> */}
                            <Route path = "/valueToAliass" component = {ListValueToAliasComponent}></Route>
                            <Route path = "/add-valueToAlias/:id" component = {CreateValueToAliasComponent}></Route>
                            <Route path = "/view-valueToAlias/:id" component = {ViewValueToAliasComponent}></Route>
                          {/* <Route path = "/update-valueToAlias/:id" component = {UpdateValueToAliasComponent}></Route> */}
                            <Route path = "/visibilityLayers" component = {ListVisibilityLayerComponent}></Route>
                            <Route path = "/add-visibilityLayer/:id" component = {CreateVisibilityLayerComponent}></Route>
                            <Route path = "/view-visibilityLayer/:id" component = {ViewVisibilityLayerComponent}></Route>
                          {/* <Route path = "/update-visibilityLayer/:id" component = {UpdateVisibilityLayerComponent}></Route> */}
                            <Route path = "/voltages" component = {ListVoltageComponent}></Route>
                            <Route path = "/add-voltage/:id" component = {CreateVoltageComponent}></Route>
                            <Route path = "/view-voltage/:id" component = {ViewVoltageComponent}></Route>
                          {/* <Route path = "/update-voltage/:id" component = {UpdateVoltageComponent}></Route> */}
                            <Route path = "/voltageAdjusterUserDefineds" component = {ListVoltageAdjusterUserDefinedComponent}></Route>
                            <Route path = "/add-voltageAdjusterUserDefined/:id" component = {CreateVoltageAdjusterUserDefinedComponent}></Route>
                            <Route path = "/view-voltageAdjusterUserDefined/:id" component = {ViewVoltageAdjusterUserDefinedComponent}></Route>
                          {/* <Route path = "/update-voltageAdjusterUserDefined/:id" component = {UpdateVoltageAdjusterUserDefinedComponent}></Route> */}
                            <Route path = "/voltageCompensatorUserDefineds" component = {ListVoltageCompensatorUserDefinedComponent}></Route>
                            <Route path = "/add-voltageCompensatorUserDefined/:id" component = {CreateVoltageCompensatorUserDefinedComponent}></Route>
                            <Route path = "/view-voltageCompensatorUserDefined/:id" component = {ViewVoltageCompensatorUserDefinedComponent}></Route>
                          {/* <Route path = "/update-voltageCompensatorUserDefined/:id" component = {UpdateVoltageCompensatorUserDefinedComponent}></Route> */}
                            <Route path = "/voltageLevels" component = {ListVoltageLevelComponent}></Route>
                            <Route path = "/add-voltageLevel/:id" component = {CreateVoltageLevelComponent}></Route>
                            <Route path = "/view-voltageLevel/:id" component = {ViewVoltageLevelComponent}></Route>
                          {/* <Route path = "/update-voltageLevel/:id" component = {UpdateVoltageLevelComponent}></Route> */}
                            <Route path = "/voltageLimits" component = {ListVoltageLimitComponent}></Route>
                            <Route path = "/add-voltageLimit/:id" component = {CreateVoltageLimitComponent}></Route>
                            <Route path = "/view-voltageLimit/:id" component = {ViewVoltageLimitComponent}></Route>
                          {/* <Route path = "/update-voltageLimit/:id" component = {UpdateVoltageLimitComponent}></Route> */}
                            <Route path = "/voltagePerReactivePowers" component = {ListVoltagePerReactivePowerComponent}></Route>
                            <Route path = "/add-voltagePerReactivePower/:id" component = {CreateVoltagePerReactivePowerComponent}></Route>
                            <Route path = "/view-voltagePerReactivePower/:id" component = {ViewVoltagePerReactivePowerComponent}></Route>
                          {/* <Route path = "/update-voltagePerReactivePower/:id" component = {UpdateVoltagePerReactivePowerComponent}></Route> */}
                            <Route path = "/volumeFlowRates" component = {ListVolumeFlowRateComponent}></Route>
                            <Route path = "/add-volumeFlowRate/:id" component = {CreateVolumeFlowRateComponent}></Route>
                            <Route path = "/view-volumeFlowRate/:id" component = {ViewVolumeFlowRateComponent}></Route>
                          {/* <Route path = "/update-volumeFlowRate/:id" component = {UpdateVolumeFlowRateComponent}></Route> */}
                            <Route path = "/vsConverters" component = {ListVsConverterComponent}></Route>
                            <Route path = "/add-vsConverter/:id" component = {CreateVsConverterComponent}></Route>
                            <Route path = "/view-vsConverter/:id" component = {ViewVsConverterComponent}></Route>
                          {/* <Route path = "/update-vsConverter/:id" component = {UpdateVsConverterComponent}></Route> */}
                            <Route path = "/windAeroLinearIECs" component = {ListWindAeroLinearIECComponent}></Route>
                            <Route path = "/add-windAeroLinearIEC/:id" component = {CreateWindAeroLinearIECComponent}></Route>
                            <Route path = "/view-windAeroLinearIEC/:id" component = {ViewWindAeroLinearIECComponent}></Route>
                          {/* <Route path = "/update-windAeroLinearIEC/:id" component = {UpdateWindAeroLinearIECComponent}></Route> */}
                            <Route path = "/windContCurrLimIECs" component = {ListWindContCurrLimIECComponent}></Route>
                            <Route path = "/add-windContCurrLimIEC/:id" component = {CreateWindContCurrLimIECComponent}></Route>
                            <Route path = "/view-windContCurrLimIEC/:id" component = {ViewWindContCurrLimIECComponent}></Route>
                          {/* <Route path = "/update-windContCurrLimIEC/:id" component = {UpdateWindContCurrLimIECComponent}></Route> */}
                            <Route path = "/windContPType3IECs" component = {ListWindContPType3IECComponent}></Route>
                            <Route path = "/add-windContPType3IEC/:id" component = {CreateWindContPType3IECComponent}></Route>
                            <Route path = "/view-windContPType3IEC/:id" component = {ViewWindContPType3IECComponent}></Route>
                          {/* <Route path = "/update-windContPType3IEC/:id" component = {UpdateWindContPType3IECComponent}></Route> */}
                            <Route path = "/windContPType4aIECs" component = {ListWindContPType4aIECComponent}></Route>
                            <Route path = "/add-windContPType4aIEC/:id" component = {CreateWindContPType4aIECComponent}></Route>
                            <Route path = "/view-windContPType4aIEC/:id" component = {ViewWindContPType4aIECComponent}></Route>
                          {/* <Route path = "/update-windContPType4aIEC/:id" component = {UpdateWindContPType4aIECComponent}></Route> */}
                            <Route path = "/windContPType4bIECs" component = {ListWindContPType4bIECComponent}></Route>
                            <Route path = "/add-windContPType4bIEC/:id" component = {CreateWindContPType4bIECComponent}></Route>
                            <Route path = "/view-windContPType4bIEC/:id" component = {ViewWindContPType4bIECComponent}></Route>
                          {/* <Route path = "/update-windContPType4bIEC/:id" component = {UpdateWindContPType4bIECComponent}></Route> */}
                            <Route path = "/windContPitchAngleIECs" component = {ListWindContPitchAngleIECComponent}></Route>
                            <Route path = "/add-windContPitchAngleIEC/:id" component = {CreateWindContPitchAngleIECComponent}></Route>
                            <Route path = "/view-windContPitchAngleIEC/:id" component = {ViewWindContPitchAngleIECComponent}></Route>
                          {/* <Route path = "/update-windContPitchAngleIEC/:id" component = {UpdateWindContPitchAngleIECComponent}></Route> */}
                            <Route path = "/windContQIECs" component = {ListWindContQIECComponent}></Route>
                            <Route path = "/add-windContQIEC/:id" component = {CreateWindContQIECComponent}></Route>
                            <Route path = "/view-windContQIEC/:id" component = {ViewWindContQIECComponent}></Route>
                          {/* <Route path = "/update-windContQIEC/:id" component = {UpdateWindContQIECComponent}></Route> */}
                            <Route path = "/windContRotorRIECs" component = {ListWindContRotorRIECComponent}></Route>
                            <Route path = "/add-windContRotorRIEC/:id" component = {CreateWindContRotorRIECComponent}></Route>
                            <Route path = "/view-windContRotorRIEC/:id" component = {ViewWindContRotorRIECComponent}></Route>
                          {/* <Route path = "/update-windContRotorRIEC/:id" component = {UpdateWindContRotorRIECComponent}></Route> */}
                            <Route path = "/windDynamicsLookupTables" component = {ListWindDynamicsLookupTableComponent}></Route>
                            <Route path = "/add-windDynamicsLookupTable/:id" component = {CreateWindDynamicsLookupTableComponent}></Route>
                            <Route path = "/view-windDynamicsLookupTable/:id" component = {ViewWindDynamicsLookupTableComponent}></Route>
                          {/* <Route path = "/update-windDynamicsLookupTable/:id" component = {UpdateWindDynamicsLookupTableComponent}></Route> */}
                            <Route path = "/windGenTurbineType3IECs" component = {ListWindGenTurbineType3IECComponent}></Route>
                            <Route path = "/add-windGenTurbineType3IEC/:id" component = {CreateWindGenTurbineType3IECComponent}></Route>
                            <Route path = "/view-windGenTurbineType3IEC/:id" component = {ViewWindGenTurbineType3IECComponent}></Route>
                          {/* <Route path = "/update-windGenTurbineType3IEC/:id" component = {UpdateWindGenTurbineType3IECComponent}></Route> */}
                            <Route path = "/windGenTurbineType3aIECs" component = {ListWindGenTurbineType3aIECComponent}></Route>
                            <Route path = "/add-windGenTurbineType3aIEC/:id" component = {CreateWindGenTurbineType3aIECComponent}></Route>
                            <Route path = "/view-windGenTurbineType3aIEC/:id" component = {ViewWindGenTurbineType3aIECComponent}></Route>
                          {/* <Route path = "/update-windGenTurbineType3aIEC/:id" component = {UpdateWindGenTurbineType3aIECComponent}></Route> */}
                            <Route path = "/windGenTurbineType3bIECs" component = {ListWindGenTurbineType3bIECComponent}></Route>
                            <Route path = "/add-windGenTurbineType3bIEC/:id" component = {CreateWindGenTurbineType3bIECComponent}></Route>
                            <Route path = "/view-windGenTurbineType3bIEC/:id" component = {ViewWindGenTurbineType3bIECComponent}></Route>
                          {/* <Route path = "/update-windGenTurbineType3bIEC/:id" component = {UpdateWindGenTurbineType3bIECComponent}></Route> */}
                            <Route path = "/windGenType4IECs" component = {ListWindGenType4IECComponent}></Route>
                            <Route path = "/add-windGenType4IEC/:id" component = {CreateWindGenType4IECComponent}></Route>
                            <Route path = "/view-windGenType4IEC/:id" component = {ViewWindGenType4IECComponent}></Route>
                          {/* <Route path = "/update-windGenType4IEC/:id" component = {UpdateWindGenType4IECComponent}></Route> */}
                            <Route path = "/windGeneratingUnits" component = {ListWindGeneratingUnitComponent}></Route>
                            <Route path = "/add-windGeneratingUnit/:id" component = {CreateWindGeneratingUnitComponent}></Route>
                            <Route path = "/view-windGeneratingUnit/:id" component = {ViewWindGeneratingUnitComponent}></Route>
                          {/* <Route path = "/update-windGeneratingUnit/:id" component = {UpdateWindGeneratingUnitComponent}></Route> */}
                            <Route path = "/windMechIECs" component = {ListWindMechIECComponent}></Route>
                            <Route path = "/add-windMechIEC/:id" component = {CreateWindMechIECComponent}></Route>
                            <Route path = "/view-windMechIEC/:id" component = {ViewWindMechIECComponent}></Route>
                          {/* <Route path = "/update-windMechIEC/:id" component = {UpdateWindMechIECComponent}></Route> */}
                            <Route path = "/windPitchContEmulIECs" component = {ListWindPitchContEmulIECComponent}></Route>
                            <Route path = "/add-windPitchContEmulIEC/:id" component = {CreateWindPitchContEmulIECComponent}></Route>
                            <Route path = "/view-windPitchContEmulIEC/:id" component = {ViewWindPitchContEmulIECComponent}></Route>
                          {/* <Route path = "/update-windPitchContEmulIEC/:id" component = {UpdateWindPitchContEmulIECComponent}></Route> */}
                            <Route path = "/windPlantFreqPcontrolIECs" component = {ListWindPlantFreqPcontrolIECComponent}></Route>
                            <Route path = "/add-windPlantFreqPcontrolIEC/:id" component = {CreateWindPlantFreqPcontrolIECComponent}></Route>
                            <Route path = "/view-windPlantFreqPcontrolIEC/:id" component = {ViewWindPlantFreqPcontrolIECComponent}></Route>
                          {/* <Route path = "/update-windPlantFreqPcontrolIEC/:id" component = {UpdateWindPlantFreqPcontrolIECComponent}></Route> */}
                            <Route path = "/windPlantReactiveControlIECs" component = {ListWindPlantReactiveControlIECComponent}></Route>
                            <Route path = "/add-windPlantReactiveControlIEC/:id" component = {CreateWindPlantReactiveControlIECComponent}></Route>
                            <Route path = "/view-windPlantReactiveControlIEC/:id" component = {ViewWindPlantReactiveControlIECComponent}></Route>
                          {/* <Route path = "/update-windPlantReactiveControlIEC/:id" component = {UpdateWindPlantReactiveControlIECComponent}></Route> */}
                            <Route path = "/windPlantUserDefineds" component = {ListWindPlantUserDefinedComponent}></Route>
                            <Route path = "/add-windPlantUserDefined/:id" component = {CreateWindPlantUserDefinedComponent}></Route>
                            <Route path = "/view-windPlantUserDefined/:id" component = {ViewWindPlantUserDefinedComponent}></Route>
                          {/* <Route path = "/update-windPlantUserDefined/:id" component = {UpdateWindPlantUserDefinedComponent}></Route> */}
                            <Route path = "/windProtectionIECs" component = {ListWindProtectionIECComponent}></Route>
                            <Route path = "/add-windProtectionIEC/:id" component = {CreateWindProtectionIECComponent}></Route>
                            <Route path = "/view-windProtectionIEC/:id" component = {ViewWindProtectionIECComponent}></Route>
                          {/* <Route path = "/update-windProtectionIEC/:id" component = {UpdateWindProtectionIECComponent}></Route> */}
                            <Route path = "/windType1or2UserDefineds" component = {ListWindType1or2UserDefinedComponent}></Route>
                            <Route path = "/add-windType1or2UserDefined/:id" component = {CreateWindType1or2UserDefinedComponent}></Route>
                            <Route path = "/view-windType1or2UserDefined/:id" component = {ViewWindType1or2UserDefinedComponent}></Route>
                          {/* <Route path = "/update-windType1or2UserDefined/:id" component = {UpdateWindType1or2UserDefinedComponent}></Route> */}
                            <Route path = "/windType3or4UserDefineds" component = {ListWindType3or4UserDefinedComponent}></Route>
                            <Route path = "/add-windType3or4UserDefined/:id" component = {CreateWindType3or4UserDefinedComponent}></Route>
                            <Route path = "/view-windType3or4UserDefined/:id" component = {ViewWindType3or4UserDefinedComponent}></Route>
                          {/* <Route path = "/update-windType3or4UserDefined/:id" component = {UpdateWindType3or4UserDefinedComponent}></Route> */}
#outputExtraRoutePaths()
                    </Switch>
                </div>
              <FooterComponent />
        </Router>
    </div>
    
  );
}

export default App;
