import React, { Component } from 'react'
import AsynchronousMachineEquivalentCircuitService from '../services/AsynchronousMachineEquivalentCircuitService'

class ViewAsynchronousMachineEquivalentCircuitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            asynchronousMachineEquivalentCircuit: {}
        }
    }

    componentDidMount(){
        AsynchronousMachineEquivalentCircuitService.getAsynchronousMachineEquivalentCircuitById(this.state.id).then( res => {
            this.setState({asynchronousMachineEquivalentCircuit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AsynchronousMachineEquivalentCircuit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> rr1:&emsp; </label>
                            <div> { this.state.asynchronousMachineEquivalentCircuit.rr1 }</div>
                        </div>
                        <div className = "row">
                            <label> rr2:&emsp; </label>
                            <div> { this.state.asynchronousMachineEquivalentCircuit.rr2 }</div>
                        </div>
                        <div className = "row">
                            <label> xlr1:&emsp; </label>
                            <div> { this.state.asynchronousMachineEquivalentCircuit.xlr1 }</div>
                        </div>
                        <div className = "row">
                            <label> xlr2:&emsp; </label>
                            <div> { this.state.asynchronousMachineEquivalentCircuit.xlr2 }</div>
                        </div>
                        <div className = "row">
                            <label> xm:&emsp; </label>
                            <div> { this.state.asynchronousMachineEquivalentCircuit.xm }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAsynchronousMachineEquivalentCircuitComponent
