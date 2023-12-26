import React, { Component } from 'react'
import EnergySourceService from '../services/EnergySourceService'

class ViewEnergySourceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            energySource: {}
        }
    }

    componentDidMount(){
        EnergySourceService.getEnergySourceById(this.state.id).then( res => {
            this.setState({energySource: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EnergySource Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEnergySourceComponent
