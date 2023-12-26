import React, { Component } from 'react'
import VoltagePerReactivePowerService from '../services/VoltagePerReactivePowerService';

class UpdateVoltagePerReactivePowerComponent extends Component {
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
        this.updateVoltagePerReactivePower = this.updateVoltagePerReactivePower.bind(this);

        this.changedenominatorMultiplierHandler = this.changedenominatorMultiplierHandler.bind(this);
        this.changedenominatorUnitHandler = this.changedenominatorUnitHandler.bind(this);
        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        VoltagePerReactivePowerService.getVoltagePerReactivePowerById(this.state.id).then( (res) =>{
            let voltagePerReactivePower = res.data;
            this.setState({
                denominatorMultiplier: voltagePerReactivePower.denominatorMultiplier,
                denominatorUnit: voltagePerReactivePower.denominatorUnit,
                multiplier: voltagePerReactivePower.multiplier,
                unit: voltagePerReactivePower.unit,
                value: voltagePerReactivePower.value
            });
        });
    }

    updateVoltagePerReactivePower = (e) => {
        e.preventDefault();
        let voltagePerReactivePower = {
            voltagePerReactivePowerId: this.state.id,
            denominatorMultiplier: this.state.denominatorMultiplier,
            denominatorUnit: this.state.denominatorUnit,
            multiplier: this.state.multiplier,
            unit: this.state.unit,
            value: this.state.value
        };
        console.log('voltagePerReactivePower => ' + JSON.stringify(voltagePerReactivePower));
        console.log('id => ' + JSON.stringify(this.state.id));
        VoltagePerReactivePowerService.updateVoltagePerReactivePower(voltagePerReactivePower).then( res => {
            this.props.history.push('/voltagePerReactivePowers');
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
        this.props.history.push('/voltagePerReactivePowers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VoltagePerReactivePower</h3>
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
                                        <button className="btn btn-success" onClick={this.updateVoltagePerReactivePower}>Save</button>
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

export default UpdateVoltagePerReactivePowerComponent
