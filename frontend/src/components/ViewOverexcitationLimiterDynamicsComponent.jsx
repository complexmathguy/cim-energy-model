import React, { Component } from 'react'
import OverexcitationLimiterDynamicsService from '../services/OverexcitationLimiterDynamicsService'

class ViewOverexcitationLimiterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            overexcitationLimiterDynamics: {}
        }
    }

    componentDidMount(){
        OverexcitationLimiterDynamicsService.getOverexcitationLimiterDynamicsById(this.state.id).then( res => {
            this.setState({overexcitationLimiterDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View OverexcitationLimiterDynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewOverexcitationLimiterDynamicsComponent
