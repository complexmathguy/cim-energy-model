import React, { Component } from 'react'
import LoadResponseCharacteristicService from '../services/LoadResponseCharacteristicService';

class CreateLoadResponseCharacteristicComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
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

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateLoadResponseCharacteristic = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            loadResponseCharacteristic.loadResponseCharacteristicId=''
            LoadResponseCharacteristicService.createLoadResponseCharacteristic(loadResponseCharacteristic).then(res =>{
                this.props.history.push('/loadResponseCharacteristics');
            });
        }else{
            LoadResponseCharacteristicService.updateLoadResponseCharacteristic(loadResponseCharacteristic).then( res => {
                this.props.history.push('/loadResponseCharacteristics');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadResponseCharacteristic</h3>
        }else{
            return <h3 className="text-center">Update LoadResponseCharacteristic</h3>
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
                                            <label> exponentModel: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pConstantCurrent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pConstantImpedance: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pConstantPower: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pFrequencyExponent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pVoltageExponent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qConstantCurrent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qConstantImpedance: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qConstantPower: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qFrequencyExponent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qVoltageExponent: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadResponseCharacteristic}>Save</button>
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

export default CreateLoadResponseCharacteristicComponent
