import React, { Component } from 'react'
import SynchronousMachineEquivalentCircuitService from '../services/SynchronousMachineEquivalentCircuitService'

class ViewSynchronousMachineEquivalentCircuitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            synchronousMachineEquivalentCircuit: {}
        }
    }

    componentDidMount(){
        SynchronousMachineEquivalentCircuitService.getSynchronousMachineEquivalentCircuitById(this.state.id).then( res => {
            this.setState({synchronousMachineEquivalentCircuit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SynchronousMachineEquivalentCircuit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> r1d:&emsp; </label>
                            <div> { this.state.synchronousMachineEquivalentCircuit.r1d }</div>
                        </div>
                        <div className = "row">
                            <label> r1q:&emsp; </label>
                            <div> { this.state.synchronousMachineEquivalentCircuit.r1q }</div>
                        </div>
                        <div className = "row">
                            <label> r2q:&emsp; </label>
                            <div> { this.state.synchronousMachineEquivalentCircuit.r2q }</div>
                        </div>
                        <div className = "row">
                            <label> rfd:&emsp; </label>
                            <div> { this.state.synchronousMachineEquivalentCircuit.rfd }</div>
                        </div>
                        <div className = "row">
                            <label> x1d:&emsp; </label>
                            <div> { this.state.synchronousMachineEquivalentCircuit.x1d }</div>
                        </div>
                        <div className = "row">
                            <label> x1q:&emsp; </label>
                            <div> { this.state.synchronousMachineEquivalentCircuit.x1q }</div>
                        </div>
                        <div className = "row">
                            <label> x2q:&emsp; </label>
                            <div> { this.state.synchronousMachineEquivalentCircuit.x2q }</div>
                        </div>
                        <div className = "row">
                            <label> xad:&emsp; </label>
                            <div> { this.state.synchronousMachineEquivalentCircuit.xad }</div>
                        </div>
                        <div className = "row">
                            <label> xaq:&emsp; </label>
                            <div> { this.state.synchronousMachineEquivalentCircuit.xaq }</div>
                        </div>
                        <div className = "row">
                            <label> xf1d:&emsp; </label>
                            <div> { this.state.synchronousMachineEquivalentCircuit.xf1d }</div>
                        </div>
                        <div className = "row">
                            <label> xfd:&emsp; </label>
                            <div> { this.state.synchronousMachineEquivalentCircuit.xfd }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSynchronousMachineEquivalentCircuitComponent
