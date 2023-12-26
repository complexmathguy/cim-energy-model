import React, { Component } from 'react'
import WindTurbineType1or2DynamicsService from '../services/WindTurbineType1or2DynamicsService'

class ViewWindTurbineType1or2DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windTurbineType1or2Dynamics: {}
        }
    }

    componentDidMount(){
        WindTurbineType1or2DynamicsService.getWindTurbineType1or2DynamicsById(this.state.id).then( res => {
            this.setState({windTurbineType1or2Dynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindTurbineType1or2Dynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindTurbineType1or2DynamicsComponent
