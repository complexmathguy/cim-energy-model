import React, { Component } from 'react'
import PowerTransformerService from '../services/PowerTransformerService';

class CreatePowerTransformerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                beforeShCircuitHighestOperatingCurrent: '',
                beforeShCircuitHighestOperatingVoltage: '',
                beforeShortCircuitAnglePf: '',
                highSideMinOperatingU: '',
                isPartOfGeneratorUnit: '',
                operationalValuesConsidered: ''
        }
        this.changebeforeShCircuitHighestOperatingCurrentHandler = this.changebeforeShCircuitHighestOperatingCurrentHandler.bind(this);
        this.changebeforeShCircuitHighestOperatingVoltageHandler = this.changebeforeShCircuitHighestOperatingVoltageHandler.bind(this);
        this.changebeforeShortCircuitAnglePfHandler = this.changebeforeShortCircuitAnglePfHandler.bind(this);
        this.changehighSideMinOperatingUHandler = this.changehighSideMinOperatingUHandler.bind(this);
        this.changeisPartOfGeneratorUnitHandler = this.changeisPartOfGeneratorUnitHandler.bind(this);
        this.changeoperationalValuesConsideredHandler = this.changeoperationalValuesConsideredHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PowerTransformerService.getPowerTransformerById(this.state.id).then( (res) =>{
                let powerTransformer = res.data;
                this.setState({
                    beforeShCircuitHighestOperatingCurrent: powerTransformer.beforeShCircuitHighestOperatingCurrent,
                    beforeShCircuitHighestOperatingVoltage: powerTransformer.beforeShCircuitHighestOperatingVoltage,
                    beforeShortCircuitAnglePf: powerTransformer.beforeShortCircuitAnglePf,
                    highSideMinOperatingU: powerTransformer.highSideMinOperatingU,
                    isPartOfGeneratorUnit: powerTransformer.isPartOfGeneratorUnit,
                    operationalValuesConsidered: powerTransformer.operationalValuesConsidered
                });
            });
        }        
    }
    saveOrUpdatePowerTransformer = (e) => {
        e.preventDefault();
        let powerTransformer = {
                powerTransformerId: this.state.id,
                beforeShCircuitHighestOperatingCurrent: this.state.beforeShCircuitHighestOperatingCurrent,
                beforeShCircuitHighestOperatingVoltage: this.state.beforeShCircuitHighestOperatingVoltage,
                beforeShortCircuitAnglePf: this.state.beforeShortCircuitAnglePf,
                highSideMinOperatingU: this.state.highSideMinOperatingU,
                isPartOfGeneratorUnit: this.state.isPartOfGeneratorUnit,
                operationalValuesConsidered: this.state.operationalValuesConsidered
            };
        console.log('powerTransformer => ' + JSON.stringify(powerTransformer));

        // step 5
        if(this.state.id === '_add'){
            powerTransformer.powerTransformerId=''
            PowerTransformerService.createPowerTransformer(powerTransformer).then(res =>{
                this.props.history.push('/powerTransformers');
            });
        }else{
            PowerTransformerService.updatePowerTransformer(powerTransformer).then( res => {
                this.props.history.push('/powerTransformers');
            });
        }
    }
    
    changebeforeShCircuitHighestOperatingCurrentHandler= (event) => {
        this.setState({beforeShCircuitHighestOperatingCurrent: event.target.value});
    }
    changebeforeShCircuitHighestOperatingVoltageHandler= (event) => {
        this.setState({beforeShCircuitHighestOperatingVoltage: event.target.value});
    }
    changebeforeShortCircuitAnglePfHandler= (event) => {
        this.setState({beforeShortCircuitAnglePf: event.target.value});
    }
    changehighSideMinOperatingUHandler= (event) => {
        this.setState({highSideMinOperatingU: event.target.value});
    }
    changeisPartOfGeneratorUnitHandler= (event) => {
        this.setState({isPartOfGeneratorUnit: event.target.value});
    }
    changeoperationalValuesConsideredHandler= (event) => {
        this.setState({operationalValuesConsidered: event.target.value});
    }

    cancel(){
        this.props.history.push('/powerTransformers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PowerTransformer</h3>
        }else{
            return <h3 className="text-center">Update PowerTransformer</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> beforeShCircuitHighestOperatingCurrent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> beforeShCircuitHighestOperatingVoltage: </label>
                                            #formFields( $attribute, 'create')
                                            <label> beforeShortCircuitAnglePf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> highSideMinOperatingU: </label>
                                            #formFields( $attribute, 'create')
                                            <label> isPartOfGeneratorUnit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> operationalValuesConsidered: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePowerTransformer}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreatePowerTransformerComponent
