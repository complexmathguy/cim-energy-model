import React, { Component } from 'react'
import LoadResponseCharacteristicService from '../services/LoadResponseCharacteristicService'

class ViewLoadResponseCharacteristicComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadResponseCharacteristic: {}
        }
    }

    componentDidMount(){
        LoadResponseCharacteristicService.getLoadResponseCharacteristicById(this.state.id).then( res => {
            this.setState({loadResponseCharacteristic: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadResponseCharacteristic Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> exponentModel:&emsp; </label>
                            <div> { this.state.loadResponseCharacteristic.exponentModel }</div>
                        </div>
                        <div className = "row">
                            <label> pConstantCurrent:&emsp; </label>
                            <div> { this.state.loadResponseCharacteristic.pConstantCurrent }</div>
                        </div>
                        <div className = "row">
                            <label> pConstantImpedance:&emsp; </label>
                            <div> { this.state.loadResponseCharacteristic.pConstantImpedance }</div>
                        </div>
                        <div className = "row">
                            <label> pConstantPower:&emsp; </label>
                            <div> { this.state.loadResponseCharacteristic.pConstantPower }</div>
                        </div>
                        <div className = "row">
                            <label> pFrequencyExponent:&emsp; </label>
                            <div> { this.state.loadResponseCharacteristic.pFrequencyExponent }</div>
                        </div>
                        <div className = "row">
                            <label> pVoltageExponent:&emsp; </label>
                            <div> { this.state.loadResponseCharacteristic.pVoltageExponent }</div>
                        </div>
                        <div className = "row">
                            <label> qConstantCurrent:&emsp; </label>
                            <div> { this.state.loadResponseCharacteristic.qConstantCurrent }</div>
                        </div>
                        <div className = "row">
                            <label> qConstantImpedance:&emsp; </label>
                            <div> { this.state.loadResponseCharacteristic.qConstantImpedance }</div>
                        </div>
                        <div className = "row">
                            <label> qConstantPower:&emsp; </label>
                            <div> { this.state.loadResponseCharacteristic.qConstantPower }</div>
                        </div>
                        <div className = "row">
                            <label> qFrequencyExponent:&emsp; </label>
                            <div> { this.state.loadResponseCharacteristic.qFrequencyExponent }</div>
                        </div>
                        <div className = "row">
                            <label> qVoltageExponent:&emsp; </label>
                            <div> { this.state.loadResponseCharacteristic.qVoltageExponent }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadResponseCharacteristicComponent
