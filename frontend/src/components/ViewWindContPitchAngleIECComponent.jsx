import React, { Component } from 'react'
import WindContPitchAngleIECService from '../services/WindContPitchAngleIECService'

class ViewWindContPitchAngleIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windContPitchAngleIEC: {}
        }
    }

    componentDidMount(){
        WindContPitchAngleIECService.getWindContPitchAngleIECById(this.state.id).then( res => {
            this.setState({windContPitchAngleIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindContPitchAngleIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dthetamax:&emsp; </label>
                            <div> { this.state.windContPitchAngleIEC.dthetamax }</div>
                        </div>
                        <div className = "row">
                            <label> dthetamin:&emsp; </label>
                            <div> { this.state.windContPitchAngleIEC.dthetamin }</div>
                        </div>
                        <div className = "row">
                            <label> kic:&emsp; </label>
                            <div> { this.state.windContPitchAngleIEC.kic }</div>
                        </div>
                        <div className = "row">
                            <label> kiomega:&emsp; </label>
                            <div> { this.state.windContPitchAngleIEC.kiomega }</div>
                        </div>
                        <div className = "row">
                            <label> kpc:&emsp; </label>
                            <div> { this.state.windContPitchAngleIEC.kpc }</div>
                        </div>
                        <div className = "row">
                            <label> kpomega:&emsp; </label>
                            <div> { this.state.windContPitchAngleIEC.kpomega }</div>
                        </div>
                        <div className = "row">
                            <label> kpx:&emsp; </label>
                            <div> { this.state.windContPitchAngleIEC.kpx }</div>
                        </div>
                        <div className = "row">
                            <label> thetamax:&emsp; </label>
                            <div> { this.state.windContPitchAngleIEC.thetamax }</div>
                        </div>
                        <div className = "row">
                            <label> thetamin:&emsp; </label>
                            <div> { this.state.windContPitchAngleIEC.thetamin }</div>
                        </div>
                        <div className = "row">
                            <label> ttheta:&emsp; </label>
                            <div> { this.state.windContPitchAngleIEC.ttheta }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindContPitchAngleIECComponent
