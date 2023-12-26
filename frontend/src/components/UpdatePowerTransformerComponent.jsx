import React, { Component } from 'react'
import PowerTransformerService from '../services/PowerTransformerService';

class UpdatePowerTransformerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                beforeShCircuitHighestOperatingCurrent: '',
                beforeShCircuitHighestOperatingVoltage: '',
                beforeShortCircuitAnglePf: '',
                highSideMinOperatingU: '',
                isPartOfGeneratorUnit: '',
                operationalValuesConsidered: ''
        }
        this.updatePowerTransformer = this.updatePowerTransformer.bind(this);

        this.changebeforeShCircuitHighestOperatingCurrentHandler = this.changebeforeShCircuitHighestOperatingCurrentHandler.bind(this);
        this.changebeforeShCircuitHighestOperatingVoltageHandler = this.changebeforeShCircuitHighestOperatingVoltageHandler.bind(this);
        this.changebeforeShortCircuitAnglePfHandler = this.changebeforeShortCircuitAnglePfHandler.bind(this);
        this.changehighSideMinOperatingUHandler = this.changehighSideMinOperatingUHandler.bind(this);
        this.changeisPartOfGeneratorUnitHandler = this.changeisPartOfGeneratorUnitHandler.bind(this);
        this.changeoperationalValuesConsideredHandler = this.changeoperationalValuesConsideredHandler.bind(this);
    }

    componentDidMount(){
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

    updatePowerTransformer = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        PowerTransformerService.updatePowerTransformer(powerTransformer).then( res => {
            this.props.history.push('/powerTransformers');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PowerTransformer</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> beforeShCircuitHighestOperatingCurrent: </label>
                                            #formFields( $attribute, 'update')
                                            <label> beforeShCircuitHighestOperatingVoltage: </label>
                                            #formFields( $attribute, 'update')
                                            <label> beforeShortCircuitAnglePf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> highSideMinOperatingU: </label>
                                            #formFields( $attribute, 'update')
                                            <label> isPartOfGeneratorUnit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> operationalValuesConsidered: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePowerTransformer}>Save</button>
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

export default UpdatePowerTransformerComponent
