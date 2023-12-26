import React, { Component } from 'react'
import VoltageCompensatorDynamicsService from '../services/VoltageCompensatorDynamicsService'

class ViewVoltageCompensatorDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            voltageCompensatorDynamics: {}
        }
    }

    componentDidMount(){
        VoltageCompensatorDynamicsService.getVoltageCompensatorDynamicsById(this.state.id).then( res => {
            this.setState({voltageCompensatorDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VoltageCompensatorDynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVoltageCompensatorDynamicsComponent
