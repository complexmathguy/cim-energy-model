import React, { Component } from 'react'
import VoltagePerReactivePowerService from '../services/VoltagePerReactivePowerService';

class CreateVoltagePerReactivePowerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                denominatorMultiplier: '',
                denominatorUnit: '',
                multiplier: '',
                unit: '',
                value: ''
        }
        this.changedenominatorMultiplierHandler = this.changedenominatorMultiplierHandler.bind(this);
        this.changedenominatorUnitHandler = this.changedenominatorUnitHandler.bind(this);
        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateVoltagePerReactivePower = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            voltagePerReactivePower.voltagePerReactivePowerId=''
            VoltagePerReactivePowerService.createVoltagePerReactivePower(voltagePerReactivePower).then(res =>{
                this.props.history.push('/voltagePerReactivePowers');
            });
        }else{
            VoltagePerReactivePowerService.updateVoltagePerReactivePower(voltagePerReactivePower).then( res => {
                this.props.history.push('/voltagePerReactivePowers');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VoltagePerReactivePower</h3>
        }else{
            return <h3 className="text-center">Update VoltagePerReactivePower</h3>
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
                                            <label> denominatorMultiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> denominatorUnit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> multiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> unit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> value: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVoltagePerReactivePower}>Save</button>
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

export default CreateVoltagePerReactivePowerComponent
