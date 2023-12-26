import React, { Component } from 'react'
import EnergySchedulingTypeService from '../services/EnergySchedulingTypeService'

class ViewEnergySchedulingTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            energySchedulingType: {}
        }
    }

    componentDidMount(){
        EnergySchedulingTypeService.getEnergySchedulingTypeById(this.state.id).then( res => {
            this.setState({energySchedulingType: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EnergySchedulingType Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEnergySchedulingTypeComponent
