import React, { Component } from 'react'
import VoltagePerReactivePowerService from '../services/VoltagePerReactivePowerService'

class ViewVoltagePerReactivePowerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            voltagePerReactivePower: {}
        }
    }

    componentDidMount(){
        VoltagePerReactivePowerService.getVoltagePerReactivePowerById(this.state.id).then( res => {
            this.setState({voltagePerReactivePower: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VoltagePerReactivePower Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> denominatorMultiplier:&emsp; </label>
                            <div> { this.state.voltagePerReactivePower.denominatorMultiplier }</div>
                        </div>
                        <div className = "row">
                            <label> denominatorUnit:&emsp; </label>
                            <div> { this.state.voltagePerReactivePower.denominatorUnit }</div>
                        </div>
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.voltagePerReactivePower.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.voltagePerReactivePower.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.voltagePerReactivePower.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVoltagePerReactivePowerComponent
