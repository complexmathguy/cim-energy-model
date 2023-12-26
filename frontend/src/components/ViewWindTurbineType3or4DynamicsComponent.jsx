import React, { Component } from 'react'
import WindTurbineType3or4DynamicsService from '../services/WindTurbineType3or4DynamicsService'

class ViewWindTurbineType3or4DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windTurbineType3or4Dynamics: {}
        }
    }

    componentDidMount(){
        WindTurbineType3or4DynamicsService.getWindTurbineType3or4DynamicsById(this.state.id).then( res => {
            this.setState({windTurbineType3or4Dynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindTurbineType3or4Dynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindTurbineType3or4DynamicsComponent
