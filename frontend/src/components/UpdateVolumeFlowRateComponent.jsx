import React, { Component } from 'react'
import VolumeFlowRateService from '../services/VolumeFlowRateService';

class UpdateVolumeFlowRateComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                denominatorMultiplier: '',
                denominatorUnit: '',
                multiplier: '',
                unit: '',
                value: ''
        }
        this.updateVolumeFlowRate = this.updateVolumeFlowRate.bind(this);

        this.changedenominatorMultiplierHandler = this.changedenominatorMultiplierHandler.bind(this);
        this.changedenominatorUnitHandler = this.changedenominatorUnitHandler.bind(this);
        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        VolumeFlowRateService.getVolumeFlowRateById(this.state.id).then( (res) =>{
            let volumeFlowRate = res.data;
            this.setState({
                denominatorMultiplier: volumeFlowRate.denominatorMultiplier,
                denominatorUnit: volumeFlowRate.denominatorUnit,
                multiplier: volumeFlowRate.multiplier,
                unit: volumeFlowRate.unit,
                value: volumeFlowRate.value
            });
        });
    }

    updateVolumeFlowRate = (e) => {
        e.preventDefault();
        let volumeFlowRate = {
            volumeFlowRateId: this.state.id,
            denominatorMultiplier: this.state.denominatorMultiplier,
            denominatorUnit: this.state.denominatorUnit,
            multiplier: this.state.multiplier,
            unit: this.state.unit,
            value: this.state.value
        };
        console.log('volumeFlowRate => ' + JSON.stringify(volumeFlowRate));
        console.log('id => ' + JSON.stringify(this.state.id));
        VolumeFlowRateService.updateVolumeFlowRate(volumeFlowRate).then( res => {
            this.props.history.push('/volumeFlowRates');
        });
    }

    changedenominatorMultiplierHandler= (event) => {
        this.setState({denominatorMultiplier: event.target.value});
    }
    changedenominatorUnitHandler= (event) => {
        this.setState({denominatorUnit: event.target.value});
    }
    changemultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeunitHandler= (event) => {
        this.setState({unit: event.target.value});
    }
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/volumeFlowRates');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VolumeFlowRate</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> denominatorMultiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> denominatorUnit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> unit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVolumeFlowRate}>Save</button>
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

export default UpdateVolumeFlowRateComponent
