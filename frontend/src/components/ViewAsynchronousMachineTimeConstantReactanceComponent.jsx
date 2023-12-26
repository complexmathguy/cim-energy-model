import React, { Component } from 'react'
import AsynchronousMachineTimeConstantReactanceService from '../services/AsynchronousMachineTimeConstantReactanceService'

class ViewAsynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            asynchronousMachineTimeConstantReactance: {}
        }
    }

    componentDidMount(){
        AsynchronousMachineTimeConstantReactanceService.getAsynchronousMachineTimeConstantReactanceById(this.state.id).then( res => {
            this.setState({asynchronousMachineTimeConstantReactance: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AsynchronousMachineTimeConstantReactance Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> tpo:&emsp; </label>
                            <div> { this.state.asynchronousMachineTimeConstantReactance.tpo }</div>
                        </div>
                        <div className = "row">
                            <label> tppo:&emsp; </label>
                            <div> { this.state.asynchronousMachineTimeConstantReactance.tppo }</div>
                        </div>
                        <div className = "row">
                            <label> xp:&emsp; </label>
                            <div> { this.state.asynchronousMachineTimeConstantReactance.xp }</div>
                        </div>
                        <div className = "row">
                            <label> xpp:&emsp; </label>
                            <div> { this.state.asynchronousMachineTimeConstantReactance.xpp }</div>
                        </div>
                        <div className = "row">
                            <label> xs:&emsp; </label>
                            <div> { this.state.asynchronousMachineTimeConstantReactance.xs }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAsynchronousMachineTimeConstantReactanceComponent
