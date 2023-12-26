import React, { Component } from 'react'
import WindPlantDynamicsService from '../services/WindPlantDynamicsService'

class ViewWindPlantDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windPlantDynamics: {}
        }
    }

    componentDidMount(){
        WindPlantDynamicsService.getWindPlantDynamicsById(this.state.id).then( res => {
            this.setState({windPlantDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindPlantDynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindPlantDynamicsComponent
