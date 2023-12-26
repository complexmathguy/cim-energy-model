import React, { Component } from 'react'
import MechanicalLoadDynamicsService from '../services/MechanicalLoadDynamicsService'

class ViewMechanicalLoadDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            mechanicalLoadDynamics: {}
        }
    }

    componentDidMount(){
        MechanicalLoadDynamicsService.getMechanicalLoadDynamicsById(this.state.id).then( res => {
            this.setState({mechanicalLoadDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View MechanicalLoadDynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMechanicalLoadDynamicsComponent
