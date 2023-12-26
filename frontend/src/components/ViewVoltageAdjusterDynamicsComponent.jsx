import React, { Component } from 'react'
import VoltageAdjusterDynamicsService from '../services/VoltageAdjusterDynamicsService'

class ViewVoltageAdjusterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            voltageAdjusterDynamics: {}
        }
    }

    componentDidMount(){
        VoltageAdjusterDynamicsService.getVoltageAdjusterDynamicsById(this.state.id).then( res => {
            this.setState({voltageAdjusterDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VoltageAdjusterDynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVoltageAdjusterDynamicsComponent
