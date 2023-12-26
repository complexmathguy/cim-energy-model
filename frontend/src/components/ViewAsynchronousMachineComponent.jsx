import React, { Component } from 'react'
import AsynchronousMachineService from '../services/AsynchronousMachineService'

class ViewAsynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            asynchronousMachine: {}
        }
    }

    componentDidMount(){
        AsynchronousMachineService.getAsynchronousMachineById(this.state.id).then( res => {
            this.setState({asynchronousMachine: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AsynchronousMachine Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> converterFedDrive:&emsp; </label>
                            <div> { this.state.asynchronousMachine.converterFedDrive }</div>
                        </div>
                        <div className = "row">
                            <label> efficiency:&emsp; </label>
                            <div> { this.state.asynchronousMachine.efficiency }</div>
                        </div>
                        <div className = "row">
                            <label> iaIrRatio:&emsp; </label>
                            <div> { this.state.asynchronousMachine.iaIrRatio }</div>
                        </div>
                        <div className = "row">
                            <label> nominalFrequency:&emsp; </label>
                            <div> { this.state.asynchronousMachine.nominalFrequency }</div>
                        </div>
                        <div className = "row">
                            <label> nominalSpeed:&emsp; </label>
                            <div> { this.state.asynchronousMachine.nominalSpeed }</div>
                        </div>
                        <div className = "row">
                            <label> polePairNumber:&emsp; </label>
                            <div> { this.state.asynchronousMachine.polePairNumber }</div>
                        </div>
                        <div className = "row">
                            <label> ratedMechanicalPower:&emsp; </label>
                            <div> { this.state.asynchronousMachine.ratedMechanicalPower }</div>
                        </div>
                        <div className = "row">
                            <label> reversible:&emsp; </label>
                            <div> { this.state.asynchronousMachine.reversible }</div>
                        </div>
                        <div className = "row">
                            <label> rxLockedRotorRatio:&emsp; </label>
                            <div> { this.state.asynchronousMachine.rxLockedRotorRatio }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAsynchronousMachineComponent
