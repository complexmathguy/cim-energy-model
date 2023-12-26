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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.common.caching.Cache;
import org.axonframework.common.caching.WeakReferenceCache;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.interceptors.LoggingInterceptor;
import org.axonframework.queryhandling.QueryBus;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class AxonConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		          .select()                                  
		          .apis(RequestHandlerSelectors.any())              
		          .paths(PathSelectors.any())                          
		          .build(); 
	}
	
    @Bean
    public LoggingInterceptor<Message<?>> loggingInterceptor() {
        return new LoggingInterceptor<>();
    }

    @Autowired
    public void configureLoggingInterceptorFor(CommandBus commandBus,
                                               LoggingInterceptor<Message<?>> loggingInterceptor) {
        commandBus.registerDispatchInterceptor(loggingInterceptor);
        commandBus.registerHandlerInterceptor(loggingInterceptor);
    }

    @Autowired
    public void configureLoggingInterceptorFor(EventBus eventBus, LoggingInterceptor<Message<?>> loggingInterceptor) {
        eventBus.registerDispatchInterceptor(loggingInterceptor);
    }

    @Autowired
    public void configureLoggingInterceptorFor(EventProcessingConfigurer eventProcessingConfigurer,
                                               LoggingInterceptor<Message<?>> loggingInterceptor) {
        eventProcessingConfigurer.registerDefaultHandlerInterceptor((config, processorName) -> loggingInterceptor);
    }

    @Autowired
    public void configureLoggingInterceptorFor(QueryBus queryBus, LoggingInterceptor<Message<?>> loggingInterceptor) {
        queryBus.registerDispatchInterceptor(loggingInterceptor);
        queryBus.registerHandlerInterceptor(loggingInterceptor);
    }

    // ------------------------------------------------
    // create a cache for each command type
    // ------------------------------------------------
    
    @Bean
    public Cache aCDCConverterCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache aCDCConverterDCTerminalCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache aCDCTerminalCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache aCLineSegmentCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache accumulatorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache accumulatorLimitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache accumulatorLimitSetCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache accumulatorResetCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache accumulatorValueCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache activePowerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache activePowerLimitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache activePowerPerCurrentFlowCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache activePowerPerFrequencyCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache analogCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache analogControlCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache analogLimitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache analogLimitSetCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache analogValueCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache angleDegreesCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache angleRadiansCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache apparentPowerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache apparentPowerLimitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache areaCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache asynchronousMachineCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache asynchronousMachineDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache asynchronousMachineEquivalentCircuitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache asynchronousMachineTimeConstantReactanceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache asynchronousMachineUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache baseVoltageCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache basicIntervalScheduleCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache bayCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache booleanProxyCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache boundaryExtensionsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache breakerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache busNameMarkerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache busbarSectionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache capacitanceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache capacitancePerLengthCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache commandCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache conductanceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache conductingEquipmentCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache conductorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache conformLoadCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache conformLoadGroupCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache conformLoadScheduleCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache connectivityNodeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache connectivityNodeContainerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache connectorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache controlCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache controlAreaCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache controlAreaGeneratingUnitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache coordinateSystemCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache csConverterCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache currentFlowCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache currentLimitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache curveCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache curveDataCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCBaseTerminalCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCBreakerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCBusbarCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCChopperCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCConductingEquipmentCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCConverterUnitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCDisconnectorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCEquipmentContainerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCGroundCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCLineCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCLineSegmentCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCNodeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCSeriesDeviceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCShuntCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCSwitchCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCTerminalCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCTopologicalIslandCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dCTopologicalNodeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dateProxyCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dateTimeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dayTypeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache decimalProxyCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache diagramCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache diagramLayoutVersionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache diagramObjectCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache diagramObjectGluePointCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache diagramObjectPointCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache diagramObjectStyleCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache diagramStyleCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache discExcContIEEEDEC1ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache discExcContIEEEDEC2ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache discExcContIEEEDEC3ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache disconnectorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache discontinuousExcitationControlDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache discontinuousExcitationControlUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache discreteCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache discreteValueCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache domainVersionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dynamicsFunctionBlockCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dynamicsVersionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache dynamicsmodelCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache eNTSOEConnectivityNodeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache eNTSOEIdentifiedObjectCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache eNTSOEJunctionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache eNTSOEOperationalLimitTypeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache eNTSOETopologicalNodeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache earthFaultCompensatorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache energyAreaCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache energyConsumerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache energySchedulingTypeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache energySourceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache equipmentCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache equipmentBoundaryVersionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache equipmentContainerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache equipmentVersionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache equivalentBranchCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache equivalentEquipmentCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache equivalentInjectionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache equivalentNetworkCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache equivalentShuntCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAC1ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAC2ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAC3ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAC4ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAC5ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAC6ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAC8BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excANSCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAVR1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAVR2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAVR3Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAVR4Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAVR5Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excAVR7Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excBBCCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excCZCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excDC1ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excDC2ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excDC3ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excDC3A1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excELIN1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excELIN2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excHUCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEAC1ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEAC2ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEAC3ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEAC4ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEAC5ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEAC6ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEAC7BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEAC8BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEDC1ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEDC2ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEDC3ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEDC4BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEST1ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEST2ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEST3ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEST4BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEST5BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEST6BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excIEEEST7BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excOEX3TCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excPICCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excREXSCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excSCRXCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excSEXSCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excSKCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excST1ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excST2ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excST3ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excST4BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excST6BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excST7BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excitationSystemDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache excitationSystemUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache extensionVersionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache externalNetworkInjectionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache floatProxyCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache fossilFuelCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache frequencyCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache genICompensationForGenJCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache generatingUnitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache geographicalLocationVersionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache geographicalRegionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govCT1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govCT2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govGASTCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govGAST1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govGAST2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govGAST3Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govGAST4Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govGASTWDCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydro1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydro2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydro3Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydro4Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydroDDCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydroFrancisCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydroIEEE0Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydroIEEE2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydroPIDCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydroPID2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydroPeltonCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydroRCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydroWEHCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govHydroWPIDCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govSteam0Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govSteam1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govSteam2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govSteamCCCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govSteamEUCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govSteamFV2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govSteamFV3Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govSteamFV4Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govSteamIEEE1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache govSteamSGOCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache grossToNetActivePowerCurveCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache groundCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache groundDisconnectorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache groundingImpedanceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache hydroGeneratingUnitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache hydroPowerPlantCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache hydroPumpCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache identifiedObjectCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache inductanceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache inductancePerLengthCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache integerProxyCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache junctionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache lengthCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache limitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache limitSetCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache lineCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache linearShuntCompensatorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache loadAggregateCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache loadAreaCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache loadBreakSwitchCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache loadCompositeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache loadDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache loadGenericNonLinearCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache loadGroupCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache loadMotorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache loadResponseCharacteristicCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache loadStaticCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache loadUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache locationCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache measurementCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache measurementValueCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache measurementValueQualityCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache measurementValueSourceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache mechLoad1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache mechanicalLoadDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache mechanicalLoadUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache moneyCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache monthDayCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache monthDayIntervalCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache mutualCouplingCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache nonConformLoadCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache nonConformLoadGroupCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache nonConformLoadScheduleCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache nonlinearShuntCompensatorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache nonlinearShuntCompensatorPointCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache nuclearGeneratingUnitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache operationalLimitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache operationalLimitSetCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache operationalLimitTypeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache overexcLim2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache overexcLimIEEECache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache overexcLimX1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache overexcLimX2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache overexcitationLimiterDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache overexcitationLimiterUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pFVArControllerType1DynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pFVArControllerType1UserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pFVArControllerType2DynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pFVArControllerType2UserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pFVArType1IEEEPFControllerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pFVArType1IEEEVArControllerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pFVArType2Common1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pFVArType2IEEEPFControllerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pFVArType2IEEEVArControllerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pUCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache perCentCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache perLengthDCLineParameterCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache petersenCoilCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache phaseTapChangerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache phaseTapChangerAsymmetricalCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache phaseTapChangerLinearCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache phaseTapChangerNonLinearCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache phaseTapChangerSymmetricalCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache phaseTapChangerTableCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache phaseTapChangerTablePointCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache phaseTapChangerTabularCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache positionPointCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache powerSystemResourceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache powerSystemStabilizerDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache powerSystemStabilizerUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache powerTransformerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache powerTransformerEndCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache proprietaryParameterDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache protectedSwitchCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pss1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pss1ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pss2BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pss2STCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pss5Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pssELIN2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pssIEEE1ACache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pssIEEE2BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pssIEEE3BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pssIEEE4BCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pssPTIST1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pssPTIST3Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pssSB4Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pssSHCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pssSKCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache pssWECCCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache quality61850Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache raiseLowerCommandCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache ratioTapChangerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache ratioTapChangerTableCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache ratioTapChangerTablePointCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache reactanceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache reactiveCapabilityCurveCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache reactivePowerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache regularIntervalScheduleCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache regularTimePointCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache regulatingCondEqCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache regulatingControlCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache regulationScheduleCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache remoteInputSignalCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache reportingGroupCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache resistanceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache resistancePerLengthCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache rotatingMachineCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache rotatingMachineDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache rotationSpeedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache seasonCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache seasonDayTypeScheduleCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache secondsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache seriesCompensatorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache setPointCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache shuntCompensatorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache simple_FloatCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache solarGeneratingUnitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache stateVariablesVersionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache staticVarCompensatorCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache staticpowersystemmodelCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache stationSupplyCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache steadyStateHypothesisVersionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache stringMeasurementCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache stringMeasurementValueCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache stringProxyCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache subGeographicalRegionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache subLoadAreaCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache substationCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache susceptanceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache svInjectionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache svPowerFlowCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache svShuntCompensatorSectionsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache svStatusCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache svTapStepCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache svVoltageCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache switchItCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache switchProxyCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache switchScheduleCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache synchronousMachineCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache synchronousMachineDetailedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache synchronousMachineDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache synchronousMachineEquivalentCircuitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache synchronousMachineSimplifiedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache synchronousMachineTimeConstantReactanceCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache synchronousMachineUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache tapChangerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache tapChangerControlCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache tapChangerTablePointCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache tapScheduleCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache temperatureCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache terminalCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache textDiagramObjectCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache thermalGeneratingUnitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache tieFlowCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache topologicalIslandCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache topologicalNodeCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache topologyBoundaryVersionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache topologyVersionCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache transformerEndCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache turbLCFB1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache turbineGovernorDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache turbineGovernorUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache turbineLoadControllerDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache turbineLoadControllerUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache underexcLim2SimplifiedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache underexcLimIEEE1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache underexcLimIEEE2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache underexcLimX1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache underexcLimX2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache underexcitationLimiterDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache underexcitationLimiterUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache unresolvednameCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache vAdjIEEECache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache vCompIEEEType1Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache vCompIEEEType2Cache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache valueAliasSetCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache valueToAliasCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache visibilityLayerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache voltageCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache voltageAdjusterDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache voltageAdjusterUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache voltageCompensatorDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache voltageCompensatorUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache voltageLevelCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache voltageLimitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache voltagePerReactivePowerCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache volumeFlowRateCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache vsCapabilityCurveCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache vsConverterCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windAeroConstIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windAeroLinearIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windContCurrLimIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windContPType3IECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windContPType4aIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windContPType4bIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windContPitchAngleIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windContQIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windContRotorRIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windDynamicsLookupTableCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windGenTurbineType1IECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windGenTurbineType2IECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windGenTurbineType3IECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windGenTurbineType3aIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windGenTurbineType3bIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windGenType4IECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windGeneratingUnitCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windMechIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windPitchContEmulIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windPlantDynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windPlantFreqPcontrolIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windPlantIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windPlantReactiveControlIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windPlantUserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windProtectionIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windTurbineType1or2DynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windTurbineType1or2IECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windTurbineType3or4DynamicsCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windTurbineType3or4IECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windTurbineType4aIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windTurbineType4bIECCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windType1or2UserDefinedCache() {    	
        return new WeakReferenceCache();
    }

    @Bean
    public Cache windType3or4UserDefinedCache() {    	
        return new WeakReferenceCache();
    }


}
