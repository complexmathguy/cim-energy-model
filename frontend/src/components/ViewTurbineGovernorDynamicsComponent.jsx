import React, { Component } from 'react'
import TurbineGovernorDynamicsService from '../services/TurbineGovernorDynamicsService'

class ViewTurbineGovernorDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            turbineGovernorDynamics: {}
        }
    }

    componentDidMount(){
        TurbineGovernorDynamicsService.getTurbineGovernorDynamicsById(this.state.id).then( res => {
            this.setState({turbineGovernorDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TurbineGovernorDynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTurbineGovernorDynamicsComponent
