import React, { Component } from 'react'
import LoadResponseCharacteristicService from '../services/LoadResponseCharacteristicService';

class UpdateLoadResponseCharacteristicComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                exponentModel: '',
                pConstantCurrent: '',
                pConstantImpedance: '',
                pConstantPower: '',
                pFrequencyExponent: '',
                pVoltageExponent: '',
                qConstantCurrent: '',
                qConstantImpedance: '',
                qConstantPower: '',
                qFrequencyExponent: '',
                qVoltageExponent: ''
        }
        this.updateLoadResponseCharacteristic = this.updateLoadResponseCharacteristic.bind(this);

        this.changeexponentModelHandler = this.changeexponentModelHandler.bind(this);
        this.changepConstantCurrentHandler = this.changepConstantCurrentHandler.bind(this);
        this.changepConstantImpedanceHandler = this.changepConstantImpedanceHandler.bind(this);
        this.changepConstantPowerHandler = this.changepConstantPowerHandler.bind(this);
        this.changepFrequencyExponentHandler = this.changepFrequencyExponentHandler.bind(this);
        this.changepVoltageExponentHandler = this.changepVoltageExponentHandler.bind(this);
        this.changeqConstantCurrentHandler = this.changeqConstantCurrentHandler.bind(this);
        this.changeqConstantImpedanceHandler = this.changeqConstantImpedanceHandler.bind(this);
        this.changeqConstantPowerHandler = this.changeqConstantPowerHandler.bind(this);
        this.changeqFrequencyExponentHandler = this.changeqFrequencyExponentHandler.bind(this);
        this.changeqVoltageExponentHandler = this.changeqVoltageExponentHandler.bind(this);
    }

    componentDidMount(){
        LoadResponseCharacteristicService.getLoadResponseCharacteristicById(this.state.id).then( (res) =>{
            let loadResponseCharacteristic = res.data;
            this.setState({
                exponentModel: loadResponseCharacteristic.exponentModel,
                pConstantCurrent: loadResponseCharacteristic.pConstantCurrent,
                pConstantImpedance: loadResponseCharacteristic.pConstantImpedance,
                pConstantPower: loadResponseCharacteristic.pConstantPower,
                pFrequencyExponent: loadResponseCharacteristic.pFrequencyExponent,
                pVoltageExponent: loadResponseCharacteristic.pVoltageExponent,
                qConstantCurrent: loadResponseCharacteristic.qConstantCurrent,
                qConstantImpedance: loadResponseCharacteristic.qConstantImpedance,
                qConstantPower: loadResponseCharacteristic.qConstantPower,
                qFrequencyExponent: loadResponseCharacteristic.qFrequencyExponent,
                qVoltageExponent: loadResponseCharacteristic.qVoltageExponent
            });
        });
    }

    updateLoadResponseCharacteristic = (e) => {
        e.preventDefault();
        let loadResponseCharacteristic = {
            loadResponseCharacteristicId: this.state.id,
            exponentModel: this.state.exponentModel,
            pConstantCurrent: this.state.pConstantCurrent,
            pConstantImpedance: this.state.pConstantImpedance,
            pConstantPower: this.state.pConstantPower,
            pFrequencyExponent: this.state.pFrequencyExponent,
            pVoltageExponent: this.state.pVoltageExponent,
            qConstantCurrent: this.state.qConstantCurrent,
            qConstantImpedance: this.state.qConstantImpedance,
            qConstantPower: this.state.qConstantPower,
            qFrequencyExponent: this.state.qFrequencyExponent,
            qVoltageExponent: this.state.qVoltageExponent
        };
        console.log('loadResponseCharacteristic => ' + JSON.stringify(loadResponseCharacteristic));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadResponseCharacteristicService.updateLoadResponseCharacteristic(loadResponseCharacteristic).then( res => {
            this.props.history.push('/loadResponseCharacteristics');
        });
    }

    changeexponentModelHandler= (event) => {
        this.setState({exponentModel: event.target.value});
    }
    changepConstantCurrentHandler= (event) => {
        this.setState({pConstantCurrent: event.target.value});
    }
    changepConstantImpedanceHandler= (event) => {
        this.setState({pConstantImpedance: event.target.value});
    }
    changepConstantPowerHandler= (event) => {
        this.setState({pConstantPower: event.target.value});
    }
    changepFrequencyExponentHandler= (event) => {
        this.setState({pFrequencyExponent: event.target.value});
    }
    changepVoltageExponentHandler= (event) => {
        this.setState({pVoltageExponent: event.target.value});
    }
    changeqConstantCurrentHandler= (event) => {
        this.setState({qConstantCurrent: event.target.value});
    }
    changeqConstantImpedanceHandler= (event) => {
        this.setState({qConstantImpedance: event.target.value});
    }
    changeqConstantPowerHandler= (event) => {
        this.setState({qConstantPower: event.target.value});
    }
    changeqFrequencyExponentHandler= (event) => {
        this.setState({qFrequencyExponent: event.target.value});
    }
    changeqVoltageExponentHandler= (event) => {
        this.setState({qVoltageExponent: event.target.value});
    }

    cancel(){
        this.props.history.push('/loadResponseCharacteristics');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadResponseCharacteristic</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> exponentModel: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pConstantCurrent: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pConstantImpedance: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pConstantPower: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pFrequencyExponent: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pVoltageExponent: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qConstantCurrent: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qConstantImpedance: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qConstantPower: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qFrequencyExponent: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qVoltageExponent: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadResponseCharacteristic}>Save</button>
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

export default UpdateLoadResponseCharacteristicComponent
