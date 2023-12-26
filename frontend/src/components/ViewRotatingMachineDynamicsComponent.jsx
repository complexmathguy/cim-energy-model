import React, { Component } from 'react'
import RotatingMachineDynamicsService from '../services/RotatingMachineDynamicsService'

class ViewRotatingMachineDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            rotatingMachineDynamics: {}
        }
    }

    componentDidMount(){
        RotatingMachineDynamicsService.getRotatingMachineDynamicsById(this.state.id).then( res => {
            this.setState({rotatingMachineDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RotatingMachineDynamics Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> damping:&emsp; </label>
                            <div> { this.state.rotatingMachineDynamics.damping }</div>
                        </div>
                        <div className = "row">
                            <label> inertia:&emsp; </label>
                            <div> { this.state.rotatingMachineDynamics.inertia }</div>
                        </div>
                        <div className = "row">
                            <label> saturationFactor:&emsp; </label>
                            <div> { this.state.rotatingMachineDynamics.saturationFactor }</div>
                        </div>
                        <div className = "row">
                            <label> saturationFactor120:&emsp; </label>
                            <div> { this.state.rotatingMachineDynamics.saturationFactor120 }</div>
                        </div>
                        <div className = "row">
                            <label> statorLeakageReactance:&emsp; </label>
                            <div> { this.state.rotatingMachineDynamics.statorLeakageReactance }</div>
                        </div>
                        <div className = "row">
                            <label> statorResistance:&emsp; </label>
                            <div> { this.state.rotatingMachineDynamics.statorResistance }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRotatingMachineDynamicsComponent
