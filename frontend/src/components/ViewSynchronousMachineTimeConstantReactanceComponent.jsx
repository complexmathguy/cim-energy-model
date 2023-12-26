import React, { Component } from 'react'
import SynchronousMachineTimeConstantReactanceService from '../services/SynchronousMachineTimeConstantReactanceService'

class ViewSynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            synchronousMachineTimeConstantReactance: {}
        }
    }

    componentDidMount(){
        SynchronousMachineTimeConstantReactanceService.getSynchronousMachineTimeConstantReactanceById(this.state.id).then( res => {
            this.setState({synchronousMachineTimeConstantReactance: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SynchronousMachineTimeConstantReactance Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.ks }</div>
                        </div>
                        <div className = "row">
                            <label> modelType:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.modelType }</div>
                        </div>
                        <div className = "row">
                            <label> rotorType:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.rotorType }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.tc }</div>
                        </div>
                        <div className = "row">
                            <label> tpdo:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.tpdo }</div>
                        </div>
                        <div className = "row">
                            <label> tppdo:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.tppdo }</div>
                        </div>
                        <div className = "row">
                            <label> tppqo:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.tppqo }</div>
                        </div>
                        <div className = "row">
                            <label> tpqo:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.tpqo }</div>
                        </div>
                        <div className = "row">
                            <label> xDirectSubtrans:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.xDirectSubtrans }</div>
                        </div>
                        <div className = "row">
                            <label> xDirectSync:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.xDirectSync }</div>
                        </div>
                        <div className = "row">
                            <label> xDirectTrans:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.xDirectTrans }</div>
                        </div>
                        <div className = "row">
                            <label> xQuadSubtrans:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.xQuadSubtrans }</div>
                        </div>
                        <div className = "row">
                            <label> xQuadSync:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.xQuadSync }</div>
                        </div>
                        <div className = "row">
                            <label> xQuadTrans:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.xQuadTrans }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSynchronousMachineTimeConstantReactanceComponent
