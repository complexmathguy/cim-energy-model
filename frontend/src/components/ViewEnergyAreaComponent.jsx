import React, { Component } from 'react'
import EnergyAreaService from '../services/EnergyAreaService'

class ViewEnergyAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            energyArea: {}
        }
    }

    componentDidMount(){
        EnergyAreaService.getEnergyAreaById(this.state.id).then( res => {
            this.setState({energyArea: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EnergyArea Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEnergyAreaComponent
