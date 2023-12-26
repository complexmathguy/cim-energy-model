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

// --------------------------------------------
// enum declarations
// --------------------------------------------
enum class AsynchronousMachineKind {
    generator, motor
}

enum class ControlAreaTypeKind {
    AGC, Forecast, Interchange
}

enum class CsOperatingModeKind {
    inverter, rectifier
}

enum class CsPpccControlKind {
    activePower, dcVoltage, dcCurrent
}

enum class Currency {
    USD, EUR, AUD, CAD, CHF, CNY, DKK, GBP, JPY, NOK, RUR, SEK, INR, other
}

enum class CurveStyle {
    constantYValue, straightLineYValues
}

enum class DCConverterOperatingModeKind {
    bipolar, monopolarMetallicReturn, monopolarGroundReturn
}

enum class DCPolarityKind {
    positive, middle, negative
}

enum class DroopSignalFeedbackKind {
    electricalPower, none, fuelValveStroke, governorOutput
}

enum class ExcIEEEST1AUELselectorKind {
    ignoreUELsignal, inputHVgateVoltageOutput, inputHVgateErrorSignal, inputAddedToErrorSignal
}

enum class ExcREXSFeedbackSignalKind {
    fieldVoltage, fieldCurrent, outputVoltage
}

enum class ExcST6BOELselectorKind {
    noOELinput, beforeUEL, afterUEL
}

enum class ExcST7BOELselectorKind {
    noOELinput, addVref, inputLVgate, outputLVgate
}

enum class ExcST7BUELselectorKind {
    noUELinput, addVref, inputHVgate, outputHVgate
}

enum class FrancisGovernorControlKind {
    mechanicHydrolicTachoAccelerator, mechanicHydraulicTransientFeedback, electromechanicalElectrohydraulic
}

enum class FuelType {
    coal, oil, gas, lignite, hardCoal, oilShale
}

enum class GeneratorControlSource {
    unavailable, offAGC, onAGC, plantControl
}

enum class GenericNonLinearLoadModelKind {
    exponentialRecovery, loadAdaptive
}

enum class HydroEnergyConversionKind {
    generator, pumpAndGenerator
}

enum class HydroPlantStorageKind {
    runOfRiver, pumpedStorage, storage
}

enum class IfdBaseKind {
    ifag, ifnl, iffl, other
}

enum class InputSignalKind {
    rotorSpeed, rotorAngularFrequencyDeviation, busFrequency, busFrequencyDeviation, generatorElectricalPower, generatorAcceleratingPower, busVoltage, busVoltageDerivative, branchCurrent, fieldCurrent
}

enum class LimitTypeEnum {
    patl, patlt, tatl, tc, tct, highVoltage, lowVoltage
}

enum class LimitTypeKind {
    patl, patlt, tatl, tc, tct, highVoltage, lowVoltage
}

enum class OperationalLimitDirectionKind {
    high, low, absoluteValue
}

enum class OrientationKind {
    negative
}

enum class PetersenCoilModeKind {
    fixed, manual, automaticPositioning
}

enum class PhaseCode {
    ABCN, ABC, ABN, ACN, BCN, AB, AC, BC, AN, BN, CN, A, B, C, N, s1N, s2N, s12N, s1, s2, s12
}

enum class RegulatingControlModeKind {
    voltage, activePower, reactivePower, currentFlow, admittance, timeScheduled, temperature, powerFactor
}

enum class RemoteSignalKind {
    remoteBusVoltageFrequency, remoteBusVoltageFrequencyDeviation, remoteBusFrequency, remoteBusFrequencyDeviation, remoteBusVoltageAmplitude, remoteBusVoltage, remoteBranchCurrentAmplitude, remoteBusVoltageAmplitudeDerivative, remotePuBusVoltageDerivative
}

enum class RotorKind {
    roundRotor, salientPole
}

enum class SVCControlMode {
    reactivePower, voltage
}

enum class ShortCircuitRotorKind {
    salientPole1, salientPole2, turboSeries1, turboSeries2
}

enum class Source {
    PROCESS, DEFAULTED, SUBSTITUTED
}

enum class StaticLoadModelKind {
    exponential, zIP1, zIP2, constantZ
}

enum class SynchronousMachineKind {
    generator, condenser, generatorOrCondenser, motor, generatorOrMotor, motorOrCondenser, generatorOrCondenserOrMotor
}

enum class SynchronousMachineModelKind {
    subtransient, subtransientTypeF, subtransientTypeJ, subtransientSimplified, subtransientSimplifiedDirectAxis
}

enum class SynchronousMachineOperatingMode {
    generator, condenser, motor
}

enum class TransformerControlMode {
    volt, reactive
}

enum class UnitMultiplier {
    p, n, micro, m, c, d, k, M, G, T, none
}

enum class UnitSymbol {
    VA, W, VAr, VAh, Wh, VArh, V, ohm, A, F, H, degC, s, min, h, deg, rad, J, N, S, none, Hz, g, Pa, m, m2, m3
}

enum class Validity {
    GOOD, QUESTIONABLE, INVALID
}

enum class VsPpccControlKind {
    pPcc, udc, pPccAndUdcDroop, pPccAndUdcDroopWithCompensation, pPccAndUdcDroopPilot
}

enum class VsQpccControlKind {
    reactivePcc, voltagePcc, powerFactorPcc
}

enum class WindGenUnitKind {
    offshore, onshore
}

enum class WindLVRTQcontrolModesKind {
    mode1, mode2, mode3
}

enum class WindLookupTableFunctionKind {
    fpslip, fpomega, ipvdl, iqvdl, fdpf
}

enum class WindQcontrolModesKind {
    voltage, reactivePower, openLoopReactivePower, powerFactor
}

enum class WindingConnection {
    D, Y, Z, Yn, Zn, A, I
}


