import React, { Component } from 'react'
import TurbineLoadControllerDynamicsService from '../services/TurbineLoadControllerDynamicsService'

class ViewTurbineLoadControllerDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            turbineLoadControllerDynamics: {}
        }
    }

    componentDidMount(){
        TurbineLoadControllerDynamicsService.getTurbineLoadControllerDynamicsById(this.state.id).then( res => {
            this.setState({turbineLoadControllerDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TurbineLoadControllerDynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTurbineLoadControllerDynamicsComponent
