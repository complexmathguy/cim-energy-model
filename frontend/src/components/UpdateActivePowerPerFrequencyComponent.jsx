import React, { Component } from 'react'
import ActivePowerPerFrequencyService from '../services/ActivePowerPerFrequencyService';

class UpdateActivePowerPerFrequencyComponent extends Component {
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
        this.updateActivePowerPerFrequency = this.updateActivePowerPerFrequency.bind(this);

        this.changedenominatorMultiplierHandler = this.changedenominatorMultiplierHandler.bind(this);
        this.changedenominatorUnitHandler = this.changedenominatorUnitHandler.bind(this);
        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        ActivePowerPerFrequencyService.getActivePowerPerFrequencyById(this.state.id).then( (res) =>{
            let activePowerPerFrequency = res.data;
            this.setState({
                denominatorMultiplier: activePowerPerFrequency.denominatorMultiplier,
                denominatorUnit: activePowerPerFrequency.denominatorUnit,
                multiplier: activePowerPerFrequency.multiplier,
                unit: activePowerPerFrequency.unit,
                value: activePowerPerFrequency.value
            });
        });
    }

    updateActivePowerPerFrequency = (e) => {
        e.preventDefault();
        let activePowerPerFrequency = {
            activePowerPerFrequencyId: this.state.id,
            denominatorMultiplier: this.state.denominatorMultiplier,
            denominatorUnit: this.state.denominatorUnit,
            multiplier: this.state.multiplier,
            unit: this.state.unit,
            value: this.state.value
        };
        console.log('activePowerPerFrequency => ' + JSON.stringify(activePowerPerFrequency));
        console.log('id => ' + JSON.stringify(this.state.id));
        ActivePowerPerFrequencyService.updateActivePowerPerFrequency(activePowerPerFrequency).then( res => {
            this.props.history.push('/activePowerPerFrequencys');
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
        this.props.history.push('/activePowerPerFrequencys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ActivePowerPerFrequency</h3>
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
                                        <button className="btn btn-success" onClick={this.updateActivePowerPerFrequency}>Save</button>
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

export default UpdateActivePowerPerFrequencyComponent
